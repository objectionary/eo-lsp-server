// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { tokens } from "./tokens";

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
 * Walks an EO program once, gathering leading-whitespace errors and the tokens
 * of each claimed line. Lines inside a """ block are never flagged.
 * @param {string} text - The whole EO program
 * @returns Errors and tokens gathered from the program
 */
const walk = (text) => {
  const errors = [];
  const found = [];
  let openIndent = -1;
  text.split("\n").forEach((line, idx) => {
    const one = span(line, idx + 1);
    if (openIndent >= 0) {
      if (closesTextBlock(one, openIndent)) {
        openIndent = -1;
      }
    } else if (one.tab) {
      errors.push({ line: one.line, column: 0, msg: "tab character in leading whitespace" });
    } else if (!one.blank && one.indent % 2 === 1) {
      errors.push({ line: one.line, column: 0, msg: "unexpected odd indent" });
    } else if (opensTextBlock(one)) {
      openIndent = one.indent;
    } else if (!one.blank && one.body[0] >= "a" && one.body[0] <= "z") {
      found.push(tokens(one).readName());
    }
  });
  return { errors, tokens: found };
};

/**
 * Reads the leading-whitespace errors of an EO program.
 * @param {string} text - The whole EO program
 * @returns The errors found
 */
export const lineErrors = (text) => walk(text).errors;

/**
 * Reads the head token of each claimed line.
 * @param {string} text - The whole EO program
 * @returns The tokens found
 */
export const lineTokens = (text) => walk(text).tokens;
