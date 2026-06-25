// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { tabErrors } from "../src/lines";

describe("lines", () => {
  test("flags a line whose indentation starts with a tab", () => {
    expect(tabErrors("[] > app\n\t42 > @\n")).toEqual([
      { line: 2, column: 0, msg: "tab character in leading whitespace" }
    ]);
  });
  test("flags a tab hidden after leading spaces", () => {
    expect(tabErrors("  \tfoo")).toEqual([
      { line: 1, column: 0, msg: "tab character in leading whitespace" }
    ]);
  });
  test("stays silent on a program indented only with spaces", () => {
    expect(tabErrors("# app.\n[] > app\n  42 > @\n")).toHaveLength(0);
  });
  test("allows tabs inside a text block", () => {
    expect(tabErrors('[] > app\n  """\n\tnot an error\n  """\n')).toHaveLength(0);
  });
  test("does not open a text block on an odd indent, so a later tab is flagged", () => {
    expect(tabErrors(' """\n\tx\n')).toEqual([
      { line: 2, column: 0, msg: "tab character in leading whitespace" }
    ]);
  });
  test("does not open a text block when the opener is not bare, so a later tab is flagged", () => {
    expect(tabErrors('"""x\n\ty\n')).toEqual([
      { line: 2, column: 0, msg: "tab character in leading whitespace" }
    ]);
  });
  test("ignores blank lines", () => {
    expect(tabErrors("\n  \n[] > app\n")).toHaveLength(0);
  });
});
