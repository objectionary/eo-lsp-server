// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { ClientCapabilities, SemanticTokensClientCapabilities } from "vscode-languageserver";
import { semanticTokenClientCapabilities } from "../src/semantic-token-capability";

describe("Semantic token capability selection", () => {
    test("returns nothing when text document capabilities are omitted", () => {
        expect(semanticTokenClientCapabilities({})).toBeUndefined();
    });

    test("returns nothing when semantic tokens are omitted", () => {
        expect(semanticTokenClientCapabilities({ textDocument: {} })).toBeUndefined();
    });

    test("returns advertised semantic token capabilities", () => {
        const semanticTokens: SemanticTokensClientCapabilities = {
            tokenTypes: ["class"],
            tokenModifiers: [],
            formats: [],
            requests: { full: true },
            multilineTokenSupport: false,
            overlappingTokenSupport: false
        };
        const capabilities: ClientCapabilities = {
            textDocument: {
                semanticTokens
            }
        };

        expect(semanticTokenClientCapabilities(capabilities)).toBe(semanticTokens);
    });
});
