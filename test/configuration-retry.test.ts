// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { spawn, ChildProcess } from "child_process";
import path from "path";
import { createMessageConnection, StreamMessageReader, StreamMessageWriter, MessageConnection } from "vscode-jsonrpc/node";

let server: ChildProcess;
let connection: MessageConnection;

beforeEach(() => {
    server = spawn(process.execPath, [path.join(__dirname, "../dist/index.js"), "--stdio"]);
    connection = createMessageConnection(new StreamMessageReader(server.stdout!), new StreamMessageWriter(server.stdin!));
    connection.onRequest("client/registerCapability", () => null);
    connection.listen();
});

afterEach(() => {
    connection.dispose();
    server.kill();
});

test("retries failed configuration and keeps publishing diagnostics", async () => {
    let requests = 0;
    connection.onRequest("workspace/configuration", () => {
        requests++;
        if (requests === 1) {
            throw new Error("temporarily unavailable");
        }
        return [{ limit: 0 }];
    });
    await connection.sendRequest("initialize", {
        processId: process.pid, rootUri: null,
        capabilities: { workspace: { configuration: true } }
    });
    await connection.sendNotification("initialized", {});
    const uri = "file:///retry.eo";
    let receive: (value: any) => void;
    connection.onNotification("textDocument/publishDiagnostics", params => receive(params));
    let published = new Promise<any>(resolve => { receive = resolve; });
    await connection.sendNotification("textDocument/didOpen", {
        textDocument: { uri, languageId: "eo", version: 1, text: "# test.\n[] > test\n  > value\n" }
    });
    expect((await published).diagnostics.length).toBeGreaterThan(0);
    published = new Promise<any>(resolve => { receive = resolve; });
    await connection.sendNotification("textDocument/didChange", {
        textDocument: { uri, version: 2 }, contentChanges: [{ text: "# test.\n[] > test\n  > other\n" }]
    });
    expect((await published).diagnostics).toEqual([]);
    expect(requests).toBe(2);
    published = new Promise<any>(resolve => { receive = resolve; });
    await connection.sendNotification("textDocument/didChange", {
        textDocument: { uri, version: 3 }, contentChanges: [{ text: "# test.\n[] > test\n  > last\n" }]
    });
    expect((await published).diagnostics).toEqual([]);
    expect(requests).toBe(2);
}, 10000);
