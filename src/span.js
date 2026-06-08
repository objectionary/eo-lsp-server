// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

/**
 * One source line of an EO program.
 *
 * A span is the smallest unit the line-based EO parser works with: it carries
 * a single line of text together with its one-indexed number, and answers
 * questions about the line's leading whitespace, indentation and body. This is
 * the first native-JavaScript building block of the parser that will replace
 * the ANTLR-generated one.
 *
 * @param chars - Line text without the trailing terminator
 * @param number - One-indexed source line number
 * @returns - A frozen span object
 */
export function span(chars, number) {
    const indent = () => {
        let count = 0;
        while (count < chars.length && chars.charAt(count) === " ") {
            count = count + 1;
        }
        return count;
    };
    const tab = () => {
        let found = false;
        for (let idx = 0; idx < chars.length; idx = idx + 1) {
            const glyph = chars.charAt(idx);
            if (glyph === "\t") {
                found = true;
                break;
            }
            if (glyph !== " ") {
                break;
            }
        }
        return found;
    };
    return Object.freeze({
        text: () => chars,
        line: () => number,
        indent,
        tab,
        blank: () => indent() === chars.length,
        body: () => chars.substring(indent())
    });
}

/*
 * @todo #352:60 Implement a tokens reader factory in native JavaScript that
 *  consumes a span and exposes a moving cursor with read methods for
 *  identifiers, integers, star tuples and method-dispatch chains, mirroring
 *  the upstream line-based parser, so the language server can tokenize EO
 *  source without the ANTLR-generated parser. Cover it with tests.
 */
