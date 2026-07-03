// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { TextDocument } from "vscode-languageserver-textdocument";

/**
 * Validates a single document and reports a failure without letting the
 * rejection escape as an unhandled promise rejection.
 * @param document - Document to validate
 * @param validate - Validation callback
 * @param report - Failure reporting callback
 */
export function validateDocument(
    document: TextDocument,
    validate: (_document: TextDocument) => Promise<void>,
    report: (_message: string) => void
): void {
    validate(document).catch(error => {
        report(`Validation failed for ${document.uri}: ${error}`);
    });
}

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
    documents.forEach(document => validateDocument(document, validate, report));
}
