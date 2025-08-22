// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { antlrTypeNumToString, getTokenTypes, tokenize, getParserErrors } from "../src/parser";
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
        expect(types.has("Q")).toBeFalsy();
    });

    test("parses valid code", () => {
        const errors = getParserErrors(
            "# test.\n[] > test\n  42 > @\n  xyz > t\n    'hello, world'\n  bar > foo\n"
        );
        expect(errors.length).toBe(0, `First error: ${errors[0]}`);
    });

    test("detects parsing errors", () => {
        const errors = getParserErrors("-- broken syntax --");
        expect(errors.length).toBe(1);
    });

    test("parses fibonacci program from file", () => {
        const programPath = path.join(__dirname, "../fixtures", "fibonacci.eo");
        const program = fs.readFileSync(programPath, "utf8");
        const errors = getParserErrors(program);
        expect(errors.length).toBe(0, `First error: ${errors[0]}`);
    });
});
