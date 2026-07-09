// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { Diagnostic, DiagnosticSeverity } from "vscode-languageserver/node.js";
import { ParserError } from "./parserError";

/**
 * Builds the diagnostics for a document, reporting parser errors up to the limit.
 * @param errors - Parser errors found in the document
 * @param limit - Maximum number of diagnostics to report
 * @param version - EO grammar version stamped onto each message
 * @returns Diagnostics capped at the limit
 */
export function diagnostics(errors: ParserError[], limit: number, version: string): Diagnostic[] {
    const reported: Diagnostic[] = [];
    errors.forEach((error, index) => {
        if (index >= limit) {
            return;
        }
        reported.push({
            severity: DiagnosticSeverity.Error,
            range: {
                start: { line: error.line - 1, character: error.column },
                end: { line: error.line - 1, character: error.column }
            },
            message: `${error.msg} (EO ${version})`,
            source: "eo"
        });
    });
    return reported;
}
