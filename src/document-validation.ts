// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { TextDocument } from "vscode-languageserver-textdocument";

/**
 * Validates a document without allowing validation failures to escape the LSP event handler.
 * @param document - Document to validate
 * @param validate - Validation procedure
 * @param logger - LSP console logger
 * @returns Promise that resolves after validation or failure logging
 */
export async function validateTextDocumentSafely(
    document: TextDocument,
    validate: (_document: TextDocument) => Promise<void>,
    logger: { error: (_message: string) => void }
): Promise<void> {
    try {
        await validate(document);
    } catch (error) {
        logger.error(`Validation failed for ${document.uri}: ${error}`);
    }
}
