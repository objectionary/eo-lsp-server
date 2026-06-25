// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { TextDocument } from "vscode-languageserver-textdocument";

/**
 * Validates every document and reports failures without dropping rejected promises.
 * @param documents - Documents to validate
 * @param validate - Validation callback
 * @param report - Failure reporting callback
 */
export function validateTextDocuments(
    documents: TextDocument[],
    validate: (_document: TextDocument) => Promise<void>,
    report: (_message: string) => void
): void {
    documents.forEach(document => {
        validate(document).catch(error => {
            report(`Validation failed for ${document.uri}: ${error}`);
        });
    });
}
