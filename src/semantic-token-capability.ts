// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { ClientCapabilities, SemanticTokensClientCapabilities } from "vscode-languageserver";

export function semanticTokenClientCapabilities(
    capabilities: ClientCapabilities
): SemanticTokensClientCapabilities | undefined {
    return capabilities.textDocument?.semanticTokens;
}
