// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { ClientCapabilities, SymbolKind, SymbolTag } from "vscode-languageserver";

export class ClientCapabilitiesAnalyzer {
    public readonly hasConfigurationSupport: boolean;
    public readonly hasWorkspaceFolderSupport: boolean;
    public readonly hasDiagnosticsSupport: boolean;
    public readonly hasTokensSupport: boolean;
    public readonly hasHierarchicalDocumentSymbolSupport: boolean;
    public readonly hasSymbolKindsSupport: SymbolKind[] | undefined;
    public readonly hasSymbolTagsSupport: SymbolTag[] | undefined;

    constructor(capabilities: ClientCapabilities) {
        this.hasConfigurationSupport = !!capabilities.workspace?.configuration;
        this.hasWorkspaceFolderSupport = !!capabilities.workspace?.workspaceFolders;
        this.hasDiagnosticsSupport = !!capabilities.textDocument?.publishDiagnostics?.relatedInformation;
        this.hasTokensSupport = !!capabilities.textDocument?.semanticTokens;
        const documentSymbolCapabilities = capabilities.textDocument?.documentSymbol;
        this.hasHierarchicalDocumentSymbolSupport = !!documentSymbolCapabilities?.hierarchicalDocumentSymbolSupport;
        this.hasSymbolKindsSupport = documentSymbolCapabilities?.symbolKind?.valueSet;
        this.hasSymbolTagsSupport = documentSymbolCapabilities?.tagSupport?.valueSet;
    }
}
