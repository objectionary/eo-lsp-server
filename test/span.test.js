// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { span } from "../src/span";

describe("span", () => {
    test("keeps the original line text untouched", () => {
        expect(span("  42 > @", 7).text()).toBe("  42 > @");
    });
    test("reports its one-indexed line number", () => {
        expect(span("[] > app", 13).line()).toBe(13);
    });
    test("counts the leading spaces as indent", () => {
        expect(span("    stdout", 4).indent()).toBe(4);
    });
    test("does not treat an unindented line as indented", () => {
        expect(span("# comment", 1).indent()).toBe(0);
    });
    test("considers a whitespace-only line blank", () => {
        expect(span("      ", 9).blank()).toBe(true);
    });
    test("does not consider a line with content blank", () => {
        expect(span("  x > y", 2).blank()).toBe(false);
    });
    test("strips the leading whitespace from the body", () => {
        expect(span("    foo > bar", 5).body()).toBe("foo > bar");
    });
    test("spots a tab hiding in the leading whitespace", () => {
        expect(span("\tnope", 6).tab()).toBe(true);
    });
    test("finds no tab when the line starts with content", () => {
        expect(span("plus > x", 3).tab()).toBe(false);
    });
    test("finds no tab in a line of only spaces", () => {
        expect(span("   ", 8).tab()).toBe(false);
    });
});
