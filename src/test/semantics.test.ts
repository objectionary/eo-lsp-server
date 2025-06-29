// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { SemanticTokensProvider } from "../semantics";
import { SemanticTokensClientCapabilities } from "vscode-languageserver/node.js";
import * as fs from "fs";
import * as path from "path";
import { TextDocument } from "vscode-languageserver-textdocument";

/**
 * Return the path to the document
 * @param p - Document's name
 * @returns - Path to document
 */
function getDocPath(p: string) {
    return path.resolve(__dirname, "../../testFixture", p);
}

describe("Semantics module", () => {
    let provider: SemanticTokensProvider;
    let clientCapabilities: SemanticTokensClientCapabilities;
    beforeEach(() => {
        clientCapabilities = {
            dynamicRegistration: true,
            tokenTypes: [
                "namespace", "type",
                "class", "enum",
                "interface", "struct",
                "typeParameter", "parameter",
                "variable", "property",
                "enumMember", "event",
                "function", "method",
                "macro", "keyword",
                "modifier", "comment",
                "string", "number",
                "regexp", "operator"
            ],
            tokenModifiers: [
                "declaration",
                "definition",
                "readonly",
                "static",
                "deprecated",
                "abstract",
                "async",
                "modification",
                "documentation",
                "defaultLibrary"
            ],
            formats: [],
            requests: { range: true, full: { delta: true } },
            multilineTokenSupport: false,
            overlappingTokenSupport: false
        };
        provider = new SemanticTokensProvider(clientCapabilities);
    });

    test("Compute Legend obtains all used VSCode token types", () => {
        const semanticTokensLegend = new Set<string>(provider.computeLegend(clientCapabilities).tokenTypes);
        const expectedTokens = ["comment", "macro", "keyword", "operator", "method", "number", "string", "variable"];
        expect(semanticTokensLegend.size).toBe(8);
        expectedTokens.forEach(token => expect(semanticTokensLegend.has(token)).toBeTruthy());
    });

    test("Tokenize returns all semantic tokens", () => {
        const textDocument = TextDocument.create("foo.eo", "eo", 0, "# test.\n[] > test\n");
        const actualTokens = provider.tokenize(textDocument);
        expect(actualTokens.length).toBe(3);
    });
});
