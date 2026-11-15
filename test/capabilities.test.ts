// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
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
    test.each([false, true])("reads explicit dynamic registration support %p", dynamic => {
        const analyzer = new ClientCapabilitiesAnalyzer({
            workspace: { didChangeConfiguration: { dynamicRegistration: dynamic } },
            textDocument: { semanticTokens: {
                dynamicRegistration: dynamic, requests: {}, tokenTypes: [], tokenModifiers: [], formats: []
            } }
        });
        expect(analyzer.hasDynamicTokensSupport).toBe(dynamic);
        expect(analyzer.hasDynamicConfigurationSupport).toBe(dynamic);
    });
    test("exposes the negotiated supports", () => {
        const analyzer = new ClientCapabilitiesAnalyzer({} as ClientCapabilities);
        expect(Object.keys(analyzer).sort()).toStrictEqual(
            ["hasConfigurationSupport", "hasDynamicConfigurationSupport", "hasDynamicTokensSupport", "hasTokensSupport", "hasWorkspaceFolderSupport"]
        );
    });
});
