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

test.each([false, true])("uses the latest configuration when the old reply arrives first=%p", async oldFirst => {
    const pending: ((value: any) => void)[] = [];
    let requested: () => void;
    let request = new Promise<void>(resolve => { requested = resolve; });
    connection.onRequest("workspace/configuration", () => new Promise(resolve => {
        pending.push(resolve);
        requested();
    }));
    await connection.sendRequest("initialize", {
        processId: process.pid, rootUri: null,
        capabilities: { workspace: { configuration: true } }
    });
    await connection.sendNotification("initialized", {});
    const uri = "file:///configuration.eo";
    const counts: number[] = [];
    let receive: () => void;
    connection.onNotification("textDocument/publishDiagnostics", params => {
        counts.push(params.diagnostics.length);
        receive();
    });
    await connection.sendNotification("textDocument/didOpen", {
        textDocument: { uri, languageId: "eo", version: 1, text: "# test.\n[] > test\n  > value\n" }
    });
    await request;
    if (oldFirst) {
        const published = new Promise<void>(resolve => { receive = resolve; });
        pending[0]([{ limit: 0 }]);
        await published;
    }
    request = new Promise<void>(resolve => { requested = resolve; });
    await connection.sendNotification("workspace/didChangeConfiguration", { settings: { eo: { limit: 1 } } });
    await request;
    const published = new Promise<void>(resolve => { receive = resolve; });
    pending[1]([{ limit: 1 }]);
    await published;
    if (!oldFirst) {
        pending[0]([{ limit: 0 }]);
        await new Promise(resolve => setImmediate(resolve));
        await connection.sendRequest("textDocument/documentSymbol", { textDocument: { uri } });
    }
    expect(counts).toEqual(oldFirst ? [0, 1] : [1]);
}, 10000);
