// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { antlrTypeNumToString, getTokenTypes, tokenize, getParserErrors } from "../parser";
import * as fs from "fs";
import * as path from "path";

describe("Parser module", () => {
    test("Gets an EO grammar token name from an ANTLR token number", () => {
        expect(antlrTypeNumToString(1)).toBe("COMMENTARY");
    });

    test("Retrieves all token type names as defined in EO grammar", () => {
        const tokenTypes = getTokenTypes();
        expect(tokenTypes.size).toBe(30);
        expect(tokenTypes.has("COMMENTARY")).toBeTruthy();
        expect(tokenTypes.has("TEXT")).toBeTruthy();
        expect(tokenTypes.has("Q")).toBeFalsy();
    });

    test("parses valid code", () => {
        const parseErrors = getParserErrors("# test.\n[] > test\n  42 > @\n");
        expect(parseErrors.length).toBe(0);
    });

    test("detects parsing errors", () => {
        const parseErrors = getParserErrors("-- broken syntax --");
        expect(parseErrors.length).toBe(1);
    });
});
