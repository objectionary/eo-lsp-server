// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { ErrorListener } from "../src/errorListener";
import { getParserErrors } from "../src/parser";

describe("ErrorListener message shortening", () => {
    test("keeps short quoted messages unchanged", () => {
        expect(ErrorListener.shorten("token recognition error at: '§'"))
            .toBe("token recognition error at: '§'");
        expect(ErrorListener.shorten("mismatched input '[' expecting <EOF>"))
            .toBe("mismatched input '[' expecting <EOF>");
    });

    test("trims long trailing quoted input to its tail and collapses newlines", () => {
        const head = "# Boolean value, parameterized by its choice `if`.\n# It doesn't stop here.\r\n";
        const tail = "+home https://github.com/objectionary/eo";
        const raw = `no viable alternative at input '${head}${tail}'`;
        const shortened = ErrorListener.shorten(raw);
        expect(shortened.startsWith("no viable alternative at input '…")).toBe(true);
        expect(shortened.endsWith(`${tail}'`)).toBe(true);
        expect(shortened).not.toMatch(/[\r\n]/u);
        expect(shortened.length).toBeLessThanOrEqual(94);
    });

    test("trims long middle quoted input in mismatched and extraneous errors", () => {
        const quoted = "a".repeat(80) + "tail-token";
        const mismatched = ErrorListener.shorten(
            `mismatched input '${quoted}' expecting <EOF>`
        );
        expect(mismatched).toBe(
            `mismatched input '…${quoted.slice(-60)}' expecting <EOF>`
        );
        const extraneous = ErrorListener.shorten(
            `extraneous input '${quoted}' expecting NAME`
        );
        expect(extraneous).toBe(
            `extraneous input '…${quoted.slice(-60)}' expecting NAME`
        );
    });

    test("collapses line breaks in messages without a recognized quoted input", () => {
        expect(ErrorListener.shorten("rule body failed\r\non line two"))
            .toBe("rule body failed on line two");
    });

    test("stores shortened messages when syntaxError is called directly", () => {
        const listener = new ErrorListener();
        const longInput = "x".repeat(100) + "end-here";
        listener.syntaxError(
            {} as never,
            undefined,
            13,
            0,
            `no viable alternative at input '${longInput}'`,
            undefined
        );
        expect(listener.errors).toHaveLength(1);
        expect(listener.errors[0].msg).toBe(
            `no viable alternative at input '…${longInput.slice(-60)}'`
        );
    });

    test("bounds parser diagnostics for a long comment block before metas", () => {
        const source = [
            "# Boolean value, parameterized by its choice `if`.",
            "# `if` is a two-argument object that doesn't stop here.",
            "# Additional documentation line one for a long comment block.",
            "# Additional documentation line two for a long comment block.",
            "# Additional documentation line three for a long comment block.",
            "+home https://github.com/objectionary/eo",
            "+package org.eolang",
            "",
            "[] > bool",
            "  42 > @",
            ""
        ].join("\n");
        const errors = getParserErrors(source);
        const noViable = errors.find(error => error.msg.startsWith("no viable alternative at input "));
        expect(noViable).toBeDefined();
        expect(noViable!.msg).toContain("…");
        expect(noViable!.msg).toContain("+home https://github.com/objectionary/eo'");
        expect(noViable!.msg).not.toMatch(/[\r\n]/u);
        expect(noViable!.msg.length).toBeLessThan(120);
    });
});
