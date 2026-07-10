// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { lineErrors, lineTokens } from "../src/lines";

describe("lineErrors", () => {
  test("flags a line whose indentation starts with a tab", () => {
    expect(lineErrors("[] > app\n\t42 > @\n")).toEqual([
      { line: 2, column: 0, msg: "tab character in leading whitespace" }
    ]);
  });
  test("flags a tab hidden after leading spaces", () => {
    expect(lineErrors("  \tfoo")).toEqual([
      { line: 1, column: 0, msg: "tab character in leading whitespace" }
    ]);
  });
  test("flags a non-blank line whose leading-space count is odd", () => {
    expect(lineErrors("[] > app\n   42 > @\n")).toEqual([
      { line: 2, column: 0, msg: "unexpected odd indent" }
    ]);
  });
  test("stays silent on a program indented only with even spaces", () => {
    expect(lineErrors("# app.\n[] > app\n  42 > @\n")).toHaveLength(0);
  });
  test("allows tabs inside a text block", () => {
    expect(lineErrors('[] > app\n  """\n\tnot an error\n  """\n')).toHaveLength(0);
  });
  test("flags the odd indent of a would-be opener, so the block never opens", () => {
    expect(lineErrors(' """\n\tx\n')).toEqual([
      { line: 1, column: 0, msg: "unexpected odd indent" },
      { line: 2, column: 0, msg: "tab character in leading whitespace" }
    ]);
  });
  test("does not open a text block when the opener is not bare, so a later tab is flagged", () => {
    expect(lineErrors('"""x\n\ty\n')).toEqual([
      { line: 2, column: 0, msg: "tab character in leading whitespace" }
    ]);
  });
  test("ignores blank lines", () => {
    expect(lineErrors("\n  \n[] > app\n")).toHaveLength(0);
  });
});

describe("lineTokens", () => {
  test("reads the head NAME up to its terminator, offset by the line indent", () => {
    expect(lineTokens("[] > app\n  fibonacci n\n")).toEqual([
      { line: 2, start: 2, length: 9, kind: "identifier", raw: "fibonacci" }
    ]);
  });
  test("reads a NAME to the line end and claims nothing from other lines", () => {
    expect(lineTokens("foo\n# app.\n\n[] > app\n")).toEqual([
      { line: 1, start: 0, length: 3, kind: "identifier", raw: "foo" }
    ]);
  });
});
