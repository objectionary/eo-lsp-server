// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

/**
 * Reads one source line into its indentation facts.
 * @param {string} text - One line, without its newline terminator
 * @param {number} line - 1-based line number
 * @returns {{line: number, indent: number, tab: boolean, blank: boolean, body: string}} Its facts
 */
const span = (text, line) => {
  let indent = 0;
  while (indent < text.length && text[indent] === " ") {
    indent += 1;
  }
  let tab = false;
  for (let idx = 0; idx < text.length; idx += 1) {
    if (text[idx] === "\t") {
      tab = true;
      break;
    }
    if (text[idx] !== " ") {
      break;
    }
  }
  return { line, indent, tab, blank: indent === text.length, body: text.slice(indent) };
};

/**
 * Whether the line opens a text block: a bare """ trailed only by whitespace.
 * @param {{blank: boolean, body: string}} one - A span
 * @returns {boolean} True if it opens a text block
 */
const opensTextBlock = (one) =>
  !one.blank
  && one.body.startsWith('"""')
  && [...one.body.slice(3)].every((glyph) => glyph === " " || glyph === "\t");

/**
 * Whether the line closes the open text block: a """ at the opener's indent.
 * @param {{blank: boolean, indent: number, body: string}} one - A span
 * @param {number} openIndent - Indent the text block opened at
 * @returns {boolean} True if it closes the text block
 */
const closesTextBlock = (one, openIndent) =>
  !one.blank && one.indent === openIndent && one.body.startsWith('"""');

/**
 * Reads the tab-indentation errors of an EO program. Each error names the
 * 1-based line and column 0. A line inside a """ text block is never flagged.
 * @param {string} text - The whole EO program
 * @returns {Array<{line: number, column: number, msg: string}>} The errors found
 */
export const tabErrors = (text) => {
  const errors = [];
  let openIndent = -1;
  text.split("\n").forEach((line, idx) => {
    const one = span(line, idx + 1);
    if (openIndent >= 0) {
      if (closesTextBlock(one, openIndent)) {
        openIndent = -1;
      }
    } else if (one.tab) {
      errors.push({ line: one.line, column: 0, msg: "tab character in leading whitespace" });
    } else if (opensTextBlock(one) && one.indent % 2 === 0) {
      openIndent = one.indent;
    }
  });
  return errors;
};

// @todo #352:60 Grow this native port of upstream's Eo.process: add the
//  "unexpected odd indent" error for a non-blank line whose leading-space count
//  is odd (right after the tab check, behind the same text-block gate), then
//  begin a tokens reader that walks each claimed line into its tokens.
