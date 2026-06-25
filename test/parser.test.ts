// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { antlrTypeNumToString, getTokenTypes, getParserErrors, buildTokenSetAndMap, resetTokenCache } from "../src/parser";
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
    test("reports a tab indentation error from the native reader", () => {
        const errors = getParserErrors("# app.\n[] > app\n\t42 > @\n");
        expect(errors).toContainEqual(
            expect.objectContaining({
                line: 3,
                column: 0,
                msg: "tab character in leading whitespace"
            })
        );
    });
    test("native reader suppresses the ANTLR error on a claimed line", () => {
        const errors = getParserErrors("# app.\n[] > app\n\t42 > @\n");
        const online = errors.filter(error => error.line === 3);
        expect(online).toHaveLength(1);
        expect(online[0].msg).toBe("tab character in leading whitespace");
    });
});
