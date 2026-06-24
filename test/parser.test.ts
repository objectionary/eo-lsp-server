// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { antlrTypeNumToString, getTokenTypes, getParserErrors, buildTokenSetAndMap, resetTokenCache } from "../src/parser";
import { ErrorListener } from "../src/errorListener";
import * as fs from "fs";
import * as path from "path";

describe("Parser module", () => {
    test("Gets an EO grammar token name from an ANTLR token number", () => {
        expect(antlrTypeNumToString(1)).toBe("COMMENTARY");
    });

    test("Retrieves all token type names as defined in EO grammar", () => {
        const types = getTokenTypes();
        expect(types.size).toBe(30);
        expect(types.has("COMMENTARY")).toBeTruthy();
        expect(types.has("TEXT")).toBeTruthy();
        expect(types.has("TAB")).toBeFalsy();
        expect(types.has("UNTAB")).toBeFalsy();
        expect(types.has("Q")).toBeFalsy();
    });

    test("parses valid code", () => {
        const errors = getParserErrors(
            '# test.\n[] > test\n  42 > @\n  xyz > t\n    "hello, world"\n  bar > foo\n'
        );
        if (errors.length > 0) {
            console.error("First error:", errors[0]);
        }
        expect(errors.length).toBe(0);
    });

    test("detects parsing errors", () => {
        const errors = getParserErrors("-- broken syntax --");
        expect(errors.length).toBe(1);
    });

    test("parser errors carry the offending token length so diagnostic ranges are non-empty", () => {
        const errors = getParserErrors("-- broken syntax --");
        expect(errors.length).toBeGreaterThan(0);
        errors.forEach(error => {
            expect(error.length).toBeGreaterThanOrEqual(1);
        });
    });

    test("error listener falls back to length one when ANTLR omits the offending token", () => {
        const listener = new ErrorListener();
        listener.syntaxError(undefined as never, undefined, 3, 7, "boom", undefined);
        expect(listener.errors).toHaveLength(1);
        expect(listener.errors[0].length).toBe(1);
        expect(listener.errors[0].line).toBe(3);
        expect(listener.errors[0].column).toBe(7);
    });

    test("parses fibonacci program from file", () => {
        const programPath = path.join(__dirname, "../fixtures", "fibonacci.eo");
        const program = fs.readFileSync(programPath, "utf8");
        const errors = getParserErrors(program);
        if (errors.length > 0) {
            console.error("First error:", errors[0]);
        }
        expect(errors.length).toBe(0);
    });

    test("we expect buildTokenSetAndMap to throw", () => {
        resetTokenCache();
        const location = path.join(__dirname, "none-existing-path", "pathTo.tokens");
        expect(() => buildTokenSetAndMap(location)).toThrow();
    });
});
