// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

jest.mock("../src/parser", () => ({
    antlrTypeNumToString: jest.fn(() => ""),
    getTokenTypes: jest.fn(() => []),
    tokenize: jest.fn(() => [])
}));

import { SemanticTokensClientCapabilities } from "vscode-languageserver/node.js";
import { TextDocument } from "vscode-languageserver-textdocument";
import { SemanticTokensProvider } from "../src/semantics";

describe("Semantic token builder cache", () => {
    test("deletes the cached builder for a closed document", () => {
        const capabilities: SemanticTokensClientCapabilities = {
            tokenTypes: [],
            tokenModifiers: [],
            formats: [],
            requests: { range: false, full: true }
        };
        const provider = new SemanticTokensProvider(capabilities);
        const document = TextDocument.create("file:///closed.eo", "eo", 0, "# test.\n[] > test\n");
        provider.getTokenBuilder(document);
        provider.deleteTokenBuilder(document.uri);
        expect(provider.tokenBuilders.has(document.uri)).toBeFalsy();
    });
});
