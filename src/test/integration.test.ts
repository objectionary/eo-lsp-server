// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { spawn, ChildProcess } from "child_process";
import * as path from "path";
import * as fs from "fs";

/**
 * Integration tests for the EO LSP server
 */
describe("LSP Server Integration", () => {
    let server: ChildProcess;
    let messageHandlers: Map<number, (response: any) => void> = new Map();
    let notificationHandlers: ((notification: any) => void)[] = [];
    let messageId = 0;
    let buffer = Buffer.alloc(0);

    /**
     * Sends a request to the LSP server
     */
    function sendRequest(method: string, params: any): Promise<any> {
        return new Promise((resolve, reject) => {
            const id = ++messageId;
            const request = {
                jsonrpc: "2.0",
                id: id,
                method: method,
                params: params
            };
            const content = JSON.stringify(request);
            const header = `Content-Length: ${Buffer.byteLength(content)}\r\n\r\n`;
            const message = header + content;
            const timeout = setTimeout(() => {
                messageHandlers.delete(id);
                reject(new Error(`Request ${method} timed out`));
            }, 10000);
            messageHandlers.set(id, (response) => {
                clearTimeout(timeout);
                messageHandlers.delete(id);
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
     */
    function sendNotification(method: string, params: any): void {
        const notification = {
            jsonrpc: "2.0",
            method: method,
            params: params
        };
        const content = JSON.stringify(notification);
        const header = `Content-Length: ${Buffer.byteLength(content)}\r\n\r\n`;
        const message = header + content;
        server.stdin!.write(message);
    }

    /**
     * Parses LSP messages from the server output
     */
    function parseMessages(data: Buffer): void {
        buffer = Buffer.concat([buffer, data]);
        while (true) {
            const headerEnd = buffer.indexOf("\r\n\r\n");
            if (headerEnd === -1) break;
            const header = buffer.toString("utf8", 0, headerEnd);
            const contentLengthMatch = header.match(/Content-Length: (\d+)/);
            if (!contentLengthMatch) {
                buffer = buffer.slice(headerEnd + 4);
                continue;
            }
            const contentLength = parseInt(contentLengthMatch[1], 10);
            const messageStart = headerEnd + 4;

            if (buffer.length < messageStart + contentLength) break;
            const content = buffer.toString("utf8", messageStart, messageStart + contentLength);
            buffer = buffer.slice(messageStart + contentLength);

            try {
                const message = JSON.parse(content);
                if (message.id !== undefined && messageHandlers.has(message.id)) {
                    messageHandlers.get(message.id)!(message);
                } else if (message.method) {
                    notificationHandlers.forEach(handler => handler(message));
                }
            } catch (e) {
                console.error("Failed to parse message:", e);
            }
        }
    }

    beforeEach((done) => {
        messageHandlers.clear();
        notificationHandlers = [];
        buffer = Buffer.alloc(0);
        const serverPath = path.join(__dirname, "..", "..", "out", "server.js");

        if (!fs.existsSync(serverPath)) {
            throw new Error(`Server not found at ${serverPath}. Run 'make build' first`);
        }
        server = spawn("node", [serverPath, "--stdio"], {
            stdio: ["pipe", "pipe", "pipe"]
        });

        server.stdout!.on("data", parseMessages);
        server.stderr!.on("data", (data) => {
            console.error("Server error:", data.toString());
        });

        server.on("error", (error) => {
            console.error("Failed to start server:", error);
            done(error);
        });
        setTimeout(done, 500);
    }, 15000);

    afterEach((done) => {
        if (server && !server.killed) {
            server.kill();
            setTimeout(done, 100);
        } else {
            done();
        }
    });

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
                uri: uri,
                languageId: "eo",
                version: 1,
                text: content
            }
        });
        await new Promise(resolve => setTimeout(resolve, 500));

        const tokens = await sendRequest("textDocument/semanticTokens/full", {
            textDocument: { uri: uri }
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

        const diagnosticsPromise = new Promise((resolve) => {
            const handler = (message: any) => {
                if (message.method === "textDocument/publishDiagnostics" &&
                    message.params.uri === uri) {
                    notificationHandlers = notificationHandlers.filter(h => h !== handler);
                    resolve(message.params.diagnostics);
                }
            };
            notificationHandlers.push(handler);
        });
        sendNotification("textDocument/didOpen", {
            textDocument: {
                uri: uri,
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
                uri: uri,
                languageId: "eo",
                version: 1,
                text: "[] > test\n"
            }
        });
        await new Promise(resolve => setTimeout(resolve, 500));
        const diagnosticsPromise = new Promise((resolve) => {
            const handler = (message: any) => {
                if (message.method === "textDocument/publishDiagnostics" &&
                    message.params.uri === uri &&
                    message.params.diagnostics.length > 0) {
                    notificationHandlers = notificationHandlers.filter(h => h !== handler);
                    resolve(message.params.diagnostics);
                }
            };
            notificationHandlers.push(handler);
        });

        sendNotification("textDocument/didChange", {
            textDocument: {
                uri: uri,
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
});
