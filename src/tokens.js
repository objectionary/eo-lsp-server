// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

/** Characters that terminate a NAME token. */
const TERMINATORS = new Set([
  " ", "\t", ",", ".", "|", "'", ":", ";", "!", "?", "]", "[", "}", "{", ")", "("
]);

/**
 * A stream-style token reader over one claimed line's body. Positions are
 * absolute columns, already offset by the line's indent.
 * @param {{line: number, indent: number, body: string}} one - The claimed span
 * @returns Tokens reader object
 */
export const tokens = (one) => {
  const body = one.body;
  let cursor = 0;
  /**
   * Read a NAME at the cursor; the caller guarantees a lowercase head.
   * @returns The identifier token
   */
  const readName = () => {
    const start = cursor;
    cursor += 1;
    while (cursor < body.length && !TERMINATORS.has(body[cursor])) {
      cursor += 1;
    }
    return {
      line: one.line,
      start: one.indent + start,
      length: cursor - start,
      kind: "identifier",
      raw: body.slice(start, cursor)
    };
  };
  return { readName };
};

// @todo #389:60 Grow the tokens reader: teach it the remaining value shapes
//  (STRING, INT/FLOAT, HEX, BYTES, ROOT, STAR and paren groups), then
//  method-dispatch chains and horizontal argument lists, and finally wire
//  lineTokens into semantic highlighting (src/parser.ts tokenize/getTokenTypes)
//  so ANTLR stops owning the token stream.
