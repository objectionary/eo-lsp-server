// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { SemanticTokensClientCapabilities } from "vscode-languageserver/node.js";
import { TextDocument } from "vscode-languageserver-textdocument";

jest.mock("../src/parser", () => ({
    antlrTypeNumToString: jest.fn(() => "NAME"),
    getTokenTypes: jest.fn(() => new Set(["NAME"])),
    tokenize: jest.fn(() => [{
        line: 1,
        column: 1,
        start: 1,
        stop: 3,
        type: 1
    }])
}));

import { SemanticTokensProvider } from "../src/semantics";

describe("Semantic token UTF-16 positions", () => {
    test("converts ANTLR code point offsets to LSP UTF-16 units", () => {
        const clientCapabilities: SemanticTokensClientCapabilities = {
            tokenTypes: ["variable"],
            tokenModifiers: [],
            formats: [],
            requests: { full: true },
            multilineTokenSupport: false,
            overlappingTokenSupport: false
        };
        const provider = new SemanticTokensProvider(clientCapabilities);
        const document = TextDocument.create("foo.eo", "eo", 0, "😀a😀b\n");
        expect(provider.tokenize(document)).toEqual([{
            line: 0,
            start: 2,
            length: 4,
            tokenType: 0,
            tokenModifier: 0
        }]);
    });
});
