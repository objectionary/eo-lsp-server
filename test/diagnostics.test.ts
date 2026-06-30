// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { ParserError } from "../src/parserError";
import { diagnostics } from "../src/diagnostics";

describe("Capped diagnostics builder", () => {
    test("caps reported diagnostics at the given limit", () => {
        const errors = [
            new ParserError(3, 7, "first"),
            new ParserError(5, 1, "second"),
            new ParserError(9, 4, "third")
        ];
        expect(diagnostics(errors, 2, "0.57.3").length).toBe(2);
    });
    test("reports nothing when the limit is zero", () => {
        const errors = [new ParserError(2, 6, "lonely")];
        expect(diagnostics(errors, 0, "0.57.3").length).toBe(0);
    });
    test("reports every error when the limit exceeds the count", () => {
        const errors = [new ParserError(4, 2, "alpha"), new ParserError(8, 0, "beta")];
        expect(diagnostics(errors, 50, "0.57.3").length).toBe(2);
    });
    test("places a diagnostic one line above its parser error", () => {
        const errors = [new ParserError(11, 4, "shifted")];
        expect(diagnostics(errors, 1, "0.57.3")[0].range.start.line).toBe(10);
    });
    test("stamps the eo version onto the diagnostic message", () => {
        const errors = [new ParserError(6, 3, "broken token")];
        expect(diagnostics(errors, 1, "0.57.3")[0].message).toBe("broken token (EO 0.57.3)");
    });
    test("tags the diagnostic with the eo source", () => {
        const errors = [new ParserError(1, 0, "broken token")];
        expect(diagnostics(errors, 1, "0.57.3")[0].source).toBe("eo");
    });
});
