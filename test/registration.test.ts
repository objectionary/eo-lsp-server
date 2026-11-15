// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { spawn } from "child_process";
import path from "path";
import { createMessageConnection, StreamMessageReader, StreamMessageWriter } from "vscode-jsonrpc/node";

test.each([undefined, false, true])("negotiates token registration with dynamic support %p", async dynamic => {
    const server = spawn(process.execPath, [path.join(__dirname, "../dist/index.js"), "--stdio"]);
    const connection = createMessageConnection(new StreamMessageReader(server.stdout!), new StreamMessageWriter(server.stdin!));
    const registrations: any[] = [];
    connection.onRequest("client/registerCapability", params => {
        registrations.push(...params.registrations);
        return null;
    });
    connection.listen();
    try {
        const initialized: any = await connection.sendRequest("initialize", {
            processId: process.pid, rootUri: null,
            capabilities: {
                workspace: { configuration: true, didChangeConfiguration: { dynamicRegistration: dynamic } },
                textDocument: { semanticTokens: {
                    dynamicRegistration: dynamic, requests: { full: { delta: true } },
                    tokenTypes: ["variable", "method"], tokenModifiers: [], formats: ["relative"]
                } }
            }
        });
        await connection.sendNotification("initialized", {});
        await connection.sendRequest("textDocument/documentSymbol", { textDocument: { uri: "file:///missing.eo" } });
        if (dynamic) {
            expect(initialized.capabilities.semanticTokensProvider).toBeUndefined();
            expect(registrations.map(item => item.method).sort()).toEqual([
                "textDocument/semanticTokens", "workspace/didChangeConfiguration"
            ]);
            expect(registrations.find(item => item.method === "textDocument/semanticTokens").registerOptions.full).toEqual({ delta: true });
        } else {
            expect(registrations).toEqual([]);
            expect(initialized.capabilities.semanticTokensProvider.full).toEqual({ delta: true });
            expect(initialized.capabilities.semanticTokensProvider.legend.tokenTypes).toContain("variable");
        }
    } finally {
        connection.dispose();
        server.kill();
    }
}, 10000);
