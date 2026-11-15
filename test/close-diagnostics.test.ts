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

test.each([false, true])("clears diagnostics on close while configuration is pending=%p", async pending => {
    let configured: (value: any) => void;
    let requested: () => void;
    const request = new Promise<void>(resolve => { requested = resolve; });
    connection.onRequest("workspace/configuration", () => new Promise(resolve => {
        configured = resolve;
        requested();
    }));
    await connection.sendRequest("initialize", {
        processId: process.pid, rootUri: null,
        capabilities: { workspace: { configuration: pending } }
    });
    await connection.sendNotification("initialized", {});
    const uri = "file:///closed.eo";
    const publications: any[] = [];
    let receive: (value: any) => void;
    connection.onNotification("textDocument/publishDiagnostics", params => {
        publications.push(params.diagnostics);
        receive(params);
    });
    let published = new Promise<any>(resolve => { receive = resolve; });
    await connection.sendNotification("textDocument/didOpen", {
        textDocument: { uri, languageId: "eo", version: 1, text: "# test.\n[] > test\n  > value\n" }
    });
    if (pending) {
        await request;
    } else {
        expect((await published).diagnostics.length).toBeGreaterThan(0);
    }
    published = new Promise<any>(resolve => { receive = resolve; });
    await connection.sendNotification("textDocument/didClose", { textDocument: { uri } });
    expect((await published).diagnostics).toEqual([]);
    if (pending) {
        configured!([{ limit: 1000 }]);
        await new Promise(resolve => setImmediate(resolve));
        // Await a following server request after the configuration response has been handled.
        await connection.sendRequest("textDocument/documentSymbol", { textDocument: { uri } });
        expect(publications).toEqual([[]]);
    }
}, 10000);
