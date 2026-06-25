// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { ClientCapabilities } from "vscode-languageserver";

export class ClientCapabilitiesAnalyzer {
    public readonly hasConfigurationSupport: boolean;
    public readonly hasWorkspaceFolderSupport: boolean;
    public readonly hasTokensSupport: boolean;

    constructor(capabilities: ClientCapabilities) {
        this.hasConfigurationSupport = !!capabilities.workspace?.configuration;
        this.hasWorkspaceFolderSupport = !!capabilities.workspace?.workspaceFolders;
        this.hasTokensSupport = !!capabilities.textDocument?.semanticTokens;
    }
}
