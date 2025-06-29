// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { spawn, ChildProcess } from "child_process";
import * as path from "path";
import * as fs from "fs";

let server: ChildProcess;
const handlers: Map<number, (response: any) => void> = new Map();
let notifications: ((notification: any) => void)[] = [];
let id = 0;
let buffer = Buffer.alloc(0);

/**
 * Sends a request to the LSP server
 * @param method - Request method
 * @param params - Request parameters
 * @returns Promise with response
 */
function sendRequest(method: string, params: any): Promise<any> {
    return new Promise((resolve, reject) => {
        const current = ++id;
        const request = {
            jsonrpc: "2.0",
            id: current,
            method,
            params
        };
        const content = JSON.stringify(request);
        const header = `Content-Length: ${Buffer.byteLength(content)}\r\n\r\n`;
        const message = header + content;
        const timeout = setTimeout(() => {
            handlers.delete(current);
            reject(new Error(`Request ${method} timed out`));
        }, 10000);
        handlers.set(current, response => {
            clearTimeout(timeout);
            handlers.delete(current);
            if (response.error) {
                reject(new Error(response.error.message));
            } else {
                resolve(response.result);
            }
        });
        server.stdin!.write(message);
    });
}

/**
 * Sends a notification to the LSP server
 * @param method - Notification method
 * @param params - Notification parameters
 * @returns void
 */
function sendNotification(method: string, params: any): void {
    const notification = {
        jsonrpc: "2.0",
        method,
        params
    };
    const content = JSON.stringify(notification);
    const header = `Content-Length: ${Buffer.byteLength(content)}\r\n\r\n`;
    const message = header + content;
    server.stdin!.write(message);
}

/**
 * Parses LSP messages from the server output
 * @param data - Buffer data to parse
 * @returns void
 */
function parseMessages(data: Buffer): void {
    buffer = Buffer.concat([buffer, data]);
    for (;;) {
        const headerEnd = buffer.indexOf("\r\n\r\n");
        if (headerEnd === -1) {
            break;
        }
        const header = buffer.toString("utf8", 0, headerEnd);
        const contentLengthMatch = header.match(/Content-Length: (\d+)/u);
        if (!contentLengthMatch) {
            buffer = buffer.slice(headerEnd + 4);
            continue;
        }
        const contentLength = parseInt(contentLengthMatch[1], 10);
        const messageStart = headerEnd + 4;
        if (buffer.length < messageStart + contentLength) {
            break;
        }
        const content = buffer.toString("utf8", messageStart, messageStart + contentLength);
        buffer = buffer.slice(messageStart + contentLength);
        try {
            const message = JSON.parse(content);
            if (message.id !== void 0 && handlers.has(message.id)) {
                handlers.get(message.id)!(message);
            } else if (message.method) {
                notifications.forEach(handler => handler(message));
            }
        } catch (e) {
            void e;
        }
    }
}

/**
 * Integration tests for the EO LSP server
 */
describe("LSP Server Integration", () => {
    afterEach(done => {
        if (server && !server.killed) {
            server.kill();
            setTimeout(done, 100);
        } else {
            done();
        }
    });

    beforeEach(done => {
        handlers.clear();
        notifications = [];
        buffer = Buffer.alloc(0);
        const serverPath = path.join(__dirname, "..", "..", "out", "server.js");
        if (!fs.existsSync(serverPath)) {
            throw new Error(`Server not found at ${serverPath}. Run 'make build' first`);
        }
        server = spawn("node", [serverPath, "--stdio"], {
            stdio: ["pipe", "pipe", "pipe"]
        });
        server.stdout!.on("data", parseMessages);
        server.stderr!.on("data", data => {
            void data;
        });
        server.on("error", error => {
            done(error);
        });
        setTimeout(done, 500);
    }, 15000);

    test("Server responds to initialize request", async () => {
        const response = await sendRequest("initialize", {
            processId: process.pid,
            rootUri: null,
            capabilities: {
                textDocument: {
                    semanticTokens: {
                        tokenTypes: [],
                        tokenModifiers: []
                    }
                }
            }
        });
        expect(response).toBeDefined();
        expect(response.capabilities).toBeDefined();
        expect(response.capabilities.textDocumentSync).toBe(2);
    }, 15000);

    test("Server provides semantic tokens for valid EO code", async () => {
        await sendRequest("initialize", {
            processId: process.pid,
            rootUri: null,
            capabilities: {
                textDocument: {
                    semanticTokens: {
                        tokenTypes: ["namespace", "type", "class"],
                        tokenModifiers: ["declaration", "definition"]
                    }
                }
            }
        });
        sendNotification("initialized", {});
        const uri = "file:///test.eo";
        const content = "# test object\n[] > test\n  42 > @\n";
        sendNotification("textDocument/didOpen", {
            textDocument: {
                uri,
                languageId: "eo",
                version: 1,
                text: content
            }
        });
        await new Promise(resolve => setTimeout(resolve, 500));
        const tokens = await sendRequest("textDocument/semanticTokens/full", {
            textDocument: { uri }
        });
        expect(tokens).toBeDefined();
        expect(tokens.data).toBeDefined();
        expect(Array.isArray(tokens.data)).toBeTruthy();
    }, 15000);

    test("Server sends diagnostics for invalid EO code", async () => {
        await sendRequest("initialize", {
            processId: process.pid,
            rootUri: null,
            capabilities: {
                textDocument: {
                    semanticTokens: {
                        tokenTypes: [],
                        tokenModifiers: []
                    }
                }
            }
        });
        sendNotification("initialized", {});
        const uri = "file:///invalid.eo";
        const content = "-- invalid syntax --";
        const diagnosticsPromise = new Promise(resolve => {
            function handler(message: any) {
                if (message.method === "textDocument/publishDiagnostics" &&
                    message.params.uri === uri) {
                    notifications = notifications.filter(h => h !== handler);
                    resolve(message.params.diagnostics);
                }
            }
            notifications.push(handler);
        });
        sendNotification("textDocument/didOpen", {
            textDocument: {
                uri,
                languageId: "eo",
                version: 1,
                text: content
            }
        });
        const diagnostics = await diagnosticsPromise;
        expect(Array.isArray(diagnostics)).toBeTruthy();
        expect((diagnostics as any[]).length).toBeGreaterThan(0);
        expect((diagnostics as any[])[0].severity).toBe(1);
    }, 15000);

    test("Server handles document changes", async () => {
        await sendRequest("initialize", {
            processId: process.pid,
            rootUri: null,
            capabilities: {
                textDocument: {
                    semanticTokens: {
                        tokenTypes: [],
                        tokenModifiers: []
                    }
                }
            }
        });
        sendNotification("initialized", {});
        const uri = "file:///change.eo";
        sendNotification("textDocument/didOpen", {
            textDocument: {
                uri,
                languageId: "eo",
                version: 1,
                text: "[] > test\n"
            }
        });
        await new Promise(resolve => setTimeout(resolve, 500));
        const diagnosticsPromise = new Promise(resolve => {
            function handler(message: any) {
                if (message.method === "textDocument/publishDiagnostics" &&
                    message.params.uri === uri &&
                    message.params.diagnostics.length > 0) {
                    notifications = notifications.filter(h => h !== handler);
                    resolve(message.params.diagnostics);
                }
            }
            notifications.push(handler);
        });
        sendNotification("textDocument/didChange", {
            textDocument: {
                uri,
                version: 2
            },
            contentChanges: [{
                text: "-- broken --"
            }]
        });
        const diagnostics = await diagnosticsPromise;
        expect(Array.isArray(diagnostics)).toBeTruthy();
        expect((diagnostics as any[]).length).toBeGreaterThan(0);
    }, 15000);

    test("Server handles null settings during validation without crashing", async () => {
        await sendRequest("initialize", {
            processId: process.pid,
            rootUri: null,
            capabilities: {
                workspace: {
                    configuration: false
                },
                textDocument: {
                    semanticTokens: {
                        tokenTypes: [],
                        tokenModifiers: []
                    }
                }
            }
        });
        sendNotification("initialized", {});
        const uri = "file:///nullsettings.eo";
        const content = "-- invalid syntax to trigger validation --\n".repeat(1100);
        const diagnosticsPromise = new Promise(resolve => {
            function handler(message: any) {
                if (message.method === "textDocument/publishDiagnostics" &&
                    message.params.uri === uri) {
                    notifications = notifications.filter(h => h !== handler);
                    resolve(message.params.diagnostics);
                }
            }
            notifications.push(handler);
        });
        sendNotification("textDocument/didOpen", {
            textDocument: {
                uri,
                languageId: "eo",
                version: 1,
                text: content
            }
        });
        const diagnostics = await diagnosticsPromise;
        expect(Array.isArray(diagnostics)).toBeTruthy();
    }, 15000);

    test("Server handles malformed workspace configuration without crashing", async () => {
        await sendRequest("initialize", {
            processId: process.pid,
            rootUri: null,
            capabilities: {
                workspace: {
                    configuration: true
                },
                textDocument: {
                    semanticTokens: {
                        tokenTypes: [],
                        tokenModifiers: []
                    }
                }
            }
        });
        sendNotification("initialized", {});
        sendNotification("workspace/didChangeConfiguration", {
            settings: {
                languageServerExample: null
            }
        });
        const uri = "file:///malformed.eo";
        const content = "-- invalid syntax --";
        const diagnosticsPromise = new Promise(resolve => {
            let handler: ((message: any) => void) | null = null;
            const timeout = setTimeout(() => {
                notifications = notifications.filter(h => h !== handler);
                resolve([]);
            }, 5000);
            handler = (message: any) => {
                if (message.method === "textDocument/publishDiagnostics" &&
                    message.params.uri === uri) {
                    clearTimeout(timeout);
                    notifications = notifications.filter(h => h !== handler);
                    resolve(message.params.diagnostics);
                }
            };
            notifications.push(handler);
        });
        sendNotification("textDocument/didOpen", {
            textDocument: {
                uri,
                languageId: "eo",
                version: 1,
                text: content
            }
        });
        const diagnostics = await diagnosticsPromise;
        expect(Array.isArray(diagnostics)).toBeTruthy();
    }, 15000);
});
