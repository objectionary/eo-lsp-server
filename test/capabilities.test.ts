// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { ClientCapabilities } from "vscode-languageserver";
import { ClientCapabilitiesAnalyzer } from "../src/capabilities";

describe("Client capabilities analyzer", () => {
    test("reads configuration support from the client", () => {
        const analyzer = new ClientCapabilitiesAnalyzer({
            workspace: { configuration: true }
        } as ClientCapabilities);
        expect(analyzer.hasConfigurationSupport).toBe(true);
    });
    test("reports missing configuration support as false", () => {
        const analyzer = new ClientCapabilitiesAnalyzer({} as ClientCapabilities);
        expect(analyzer.hasConfigurationSupport).toBe(false);
    });
    test("reads workspace folder support from the client", () => {
        const analyzer = new ClientCapabilitiesAnalyzer({
            workspace: { workspaceFolders: true }
        } as ClientCapabilities);
        expect(analyzer.hasWorkspaceFolderSupport).toBe(true);
    });
    test("reads semantic tokens support from the client", () => {
        const analyzer = new ClientCapabilitiesAnalyzer({
            textDocument: { semanticTokens: { dynamicRegistration: false, requests: {}, tokenTypes: [], tokenModifiers: [], formats: [] } }
        } as ClientCapabilities);
        expect(analyzer.hasTokensSupport).toBe(true);
    });
    test("exposes no fields beyond the three negotiated supports", () => {
        const analyzer = new ClientCapabilitiesAnalyzer({} as ClientCapabilities);
        expect(Object.keys(analyzer).sort()).toStrictEqual(
            ["hasConfigurationSupport", "hasTokensSupport", "hasWorkspaceFolderSupport"]
        );
    });
});
