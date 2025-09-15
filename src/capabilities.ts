// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { ClientCapabilities, DocumentSymbolClientCapabilities } from "vscode-languageserver";

export class Capabilities {
    configuration: boolean;
    workspace: boolean;
    diagnostics: boolean;
    tokens: boolean;
    hierarchicalDocumentSymbolSupport: boolean;

    constructor() {
        this.configuration = false;
        this.workspace = false;
        this.diagnostics = false;
        this.tokens = true;
        this.hierarchicalDocumentSymbolSupport = true;
    }

    initialize(capabilities: ClientCapabilities) {
        this.configuration = !!(capabilities.workspace?.configuration);
        this.workspace = !!(capabilities.workspace?.workspaceFolders);
        this.diagnostics = !!(capabilities.textDocument?.publishDiagnostics?.relatedInformation);
        this.tokens = !!(capabilities.textDocument?.semanticTokens);
        this.initDocumentSymbols(capabilities.textDocument?.documentSymbol);
    }

    initDocumentSymbols(capabilities?: DocumentSymbolClientCapabilities) {
        this.hierarchicalDocumentSymbolSupport = capabilities?.hierarchicalDocumentSymbolSupport ?? true;
    }
}
