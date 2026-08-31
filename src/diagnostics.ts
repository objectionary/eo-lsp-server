// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { Diagnostic, DiagnosticSeverity } from "vscode-languageserver/node.js";
import { ParserError } from "./parserError";

/**
 * Builds the diagnostics for a document, reporting parser errors up to the limit.
 *
 * The range covers one character rather than none. An empty range is allowed
 * by LSP but paints nothing: some clients draw a caret under the next
 * character and others drop the diagnostic from the highlighted list
 * altogether, so the error shows up only in a panel.
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
                end: { line: error.line - 1, character: error.column + 1 }
            },
            message: `${error.msg} (EO ${version})`,
            source: "ex"
        });
    });
    return reported;
}
