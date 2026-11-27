// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { spawn, ChildProcess } from "child_process";
import path from "path";
import { SemanticTokensClientCapabilities } from "vscode-languageserver/node";
import { TextDocument } from "vscode-languageserver-textdocument";
import { createMessageConnection, StreamMessageReader, StreamMessageWriter, MessageConnection } from "vscode-jsonrpc/node";
import { SemanticTokensProvider } from "../src/semantics";

const capabilities: SemanticTokensClientCapabilities = {
    dynamicRegistration: false,
    tokenTypes: ["comment", "keyword", "macro", "method", "number", "operator", "string", "variable"],
    tokenModifiers: [],
    formats: [],
    requests: { range: false, full: { delta: true } }
};

describe("Semantic token delta previousResultId handling", () => {
    afterEach(() => {
        jest.restoreAllMocks();
    });

    test("returns edits for a matching previousResultId and falls back to full tokens when repeated", () => {
        let tick = 1000;
        jest.spyOn(Date, "now").mockImplementation(() => ++tick);
        const provider = new SemanticTokensProvider(capabilities);
        const uri = "file:///delta-repeat.eo";
        const initial = TextDocument.create(uri, "eo", 1, "# test.\n[] > app\n");
        const edited = TextDocument.create(uri, "eo", 2, "# test.\n[] > app\n  42 > @\n");
        const full = provider.provideSemanticTokens(initial);
        const expected = new SemanticTokensProvider(capabilities).provideSemanticTokens(edited).data;

        const first = provider.provideDeltas(edited, full.resultId!);
        expect("edits" in first).toBe(true);
        if ("edits" in first) {
            expect(first.edits.length).toBeGreaterThan(0);
        }

        const repeated = provider.provideDeltas(edited, full.resultId!);
        expect("data" in repeated).toBe(true);
        if ("data" in repeated) {
            expect(repeated.data).toEqual(expected);
        }
    });

    test("returns full tokens for an unknown previousResultId", () => {
        let tick = 2000;
        jest.spyOn(Date, "now").mockImplementation(() => ++tick);
        const provider = new SemanticTokensProvider(capabilities);
        const uri = "file:///delta-bogus.eo";
        const initial = TextDocument.create(uri, "eo", 1, "# test.\n[] > app\n");
        const edited = TextDocument.create(uri, "eo", 2, "# test.\n[] > app\n  42 > @\n");
        provider.provideSemanticTokens(initial);
        const expected = new SemanticTokensProvider(capabilities).provideSemanticTokens(edited).data;

        const response = provider.provideDeltas(edited, "bogus-id");
        expect("data" in response).toBe(true);
        if ("data" in response) {
            expect(response.data).toEqual(expected);
        }
    });

    test("returns full tokens when delta is requested before any full request for the document", () => {
        jest.spyOn(Date, "now").mockReturnValue(3000);
        const provider = new SemanticTokensProvider(capabilities);
        const document = TextDocument.create("file:///delta-first.eo", "eo", 1, "# test.\n[] > app\n");
        const expected = new SemanticTokensProvider(capabilities).provideSemanticTokens(document).data;

        const response = provider.provideDeltas(document, "3000");
        expect("data" in response).toBe(true);
        if ("data" in response) {
            expect(response.data).toEqual(expected);
        }
    });
});

describe("LSP semanticTokens/full/delta previousResultId forwarding", () => {
    let server: ChildProcess;
    let connection: MessageConnection;

    beforeEach(() => {
        server = spawn(process.execPath, [path.join(__dirname, "../dist/index.js"), "--stdio"]);
        connection = createMessageConnection(
            new StreamMessageReader(server.stdout!),
            new StreamMessageWriter(server.stdin!)
        );
        connection.onRequest("client/registerCapability", () => null);
        connection.listen();
    });

    afterEach(() => {
        connection.dispose();
        server.kill();
    });

    test("falls back to full tokens on repeated or bogus previousResultId over LSP", async () => {
        await connection.sendRequest("initialize", {
            processId: process.pid,
            rootUri: null,
            capabilities: {
                textDocument: {
                    semanticTokens: capabilities
                }
            }
        });
        await connection.sendNotification("initialized", {});
        const uri = "file:///lsp-delta.eo";
        await connection.sendNotification("textDocument/didOpen", {
            textDocument: { uri, languageId: "eo", version: 1, text: "# test.\n[] > app\n" }
        });
        const full: any = await connection.sendRequest("textDocument/semanticTokens/full", {
            textDocument: { uri }
        });
        expect(full.resultId).toBeDefined();
        await new Promise(resolve => setTimeout(resolve, 10));
        await connection.sendNotification("textDocument/didChange", {
            textDocument: { uri, version: 2 },
            contentChanges: [{ text: "# test.\n[] > app\n  42 > @\n" }]
        });
        const first: any = await connection.sendRequest("textDocument/semanticTokens/full/delta", {
            textDocument: { uri },
            previousResultId: full.resultId
        });
        expect(Array.isArray(first.edits)).toBe(true);
        expect(first.edits.length).toBeGreaterThan(0);

        const repeated: any = await connection.sendRequest("textDocument/semanticTokens/full/delta", {
            textDocument: { uri },
            previousResultId: full.resultId
        });
        expect(Array.isArray(repeated.data)).toBe(true);
        expect(repeated.data.length).toBeGreaterThan(full.data.length);

        const bogus: any = await connection.sendRequest("textDocument/semanticTokens/full/delta", {
            textDocument: { uri },
            previousResultId: "bogus-result-id"
        });
        expect(Array.isArray(bogus.data)).toBe(true);
        expect(bogus.data).toEqual(repeated.data);
    }, 10000);
});
