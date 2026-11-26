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
    test.each(["^", "^ left", "left ^ right", "right ^", "^receiver value"])(
        "parses bracketed receiver in [%s]", parameters => {
            expect(getParserErrors(`[${parameters}] > app\n  42 > @\n`)).toEqual([]);
        }
    );
    test("rejects a numeric receiver handle", () => {
        expect(getParserErrors("[^1] > app\n")).not.toEqual([]);
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
    test("retries token loading after a failed read without resetting the cache", () => {
        resetTokenCache();
        const missing = path.join(__dirname, "missing", "EoLexer.tokens");
        expect(() => buildTokenSetAndMap(missing)).toThrow("EoLexer.tokens file missing");
        expect(() => buildTokenSetAndMap(missing)).toThrow("EoLexer.tokens file missing");
        expect(antlrTypeNumToString(1)).toBe("COMMENTARY");
        expect(getTokenTypes()).toContain("TEXT");
        expect(getTokenTypes().size).toBe(30);
    });
    test("reports lexical errors discarded from an otherwise valid token stream", () => {
        const errors = getParserErrors('# test.\n[] > test\n  "ok"§ > value\n');
        expect(errors).toEqual([
            expect.objectContaining({ line: 3, column: 6, msg: "token recognition error at: '§'" })
        ]);
    });
    test.each(['"ok"', '"ok§"'])("accepts valid string %s", literal => {
        expect(getParserErrors(`# test.\n[] > test\n  ${literal} > value\n`)).toEqual([]);
    });
    test("keeps native indentation precedence over lexical errors on the same line", () => {
        const errors = getParserErrors('# test.\n[] > test\n\t"ok"§ > value\n');
        expect(errors.filter(error => error.line === 3)).toEqual([
            expect.objectContaining({ msg: "tab character in leading whitespace" })
        ]);
    });
    test.each(["\n", "\r\n"])("accepts one trailing blank line with %p terminators", newline => {
        const source = ["# test.", "[] > test", "  42 > @", ""].join(newline);
        expect(getParserErrors(source)).toEqual([]);
        expect(getParserErrors(source + newline)).toEqual([]);
        expect(getParserErrors(source + newline.repeat(2)).length).toBeGreaterThan(0);
    });
    test("accepts a single trailing blank line after the fibonacci fixture", () => {
        const source = fs.readFileSync(path.join(__dirname, "../fixtures/fibonacci.eo"), "utf8");
        expect(getParserErrors(source + "\n")).toEqual([]);
    });
    test("preserves diagnostics for CRLF text blocks", () => {
        const source = '# test.\n[] > app\n  """\n   odd text\n\tliteral tab\n  """ > @\n';
        expect(getParserErrors(source)).toEqual([]);
        expect(getParserErrors(source.replace(/\n/gu, "\r\n"))).toEqual([]);
    });
    test("reports trailing whitespace through the diagnostic parser entry point", () => {
        const errors = getParserErrors("# test.\n[] > app  \n  42 > @\n");
        expect(errors.filter(error => error.line === 2)).toEqual([
            expect.objectContaining({ line: 2, column: 9, msg: "trailing whitespace at end of line" })
        ]);
    });

});
