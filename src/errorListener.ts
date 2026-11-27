// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

/**
 * Provides the errors detected during the parsing of an input program.
 * @module ErrorListener
 */

import {
    Token as AntlrToken,
    ErrorListener as ANTLRErrorListener,
    Recognizer,
    RecognitionException
} from "antlr4";
import { ParserError } from "./parserError";

export class ErrorListener<T = AntlrToken> implements ANTLRErrorListener<T> {

    /**
     * Maximum number of characters kept from a quoted input fragment.
     */
    private static readonly MAX_QUOTED = 60;

    /**
     * Array of errors detected during the parsing
     */
    errors: ParserError[] = [];

    syntaxError(recognizer: Recognizer<T>, symbol: T | undefined, line: number,
        position: number, msg: string, _e: RecognitionException | undefined) {
        this.errors.push(new ParserError(line, position, ErrorListener.shorten(msg)));
    }

    /**
     * Collapses line breaks and trims long quoted input fragments so editor
     * diagnostics keep the diagnosis and the trailing context where parsing stopped.
     * @param msg - Raw syntax error message reported by ANTLR
     * @returns Compact single-line error message
     */
    static shorten(msg: string): string {
        const trailing = /^(no viable alternative at input |token recognition error at: |missing .+? at )'([\s\S]*)'$/u.exec(msg);
        if (trailing) {
            return `${trailing[1]}${ErrorListener.trim(trailing[2])}`;
        }
        const middle = /^((?:mismatched|extraneous) input )'([\s\S]*)'( expecting [\s\S]*)$/u.exec(msg);
        if (middle) {
            return `${middle[1]}${ErrorListener.trim(middle[2])}${middle[3]}`;
        }
        return msg.replace(/\r?\n|\r/gu, " ");
    }

    /**
     * Normalizes line breaks inside a quoted input snippet and keeps its tail
     * when it exceeds the display limit.
     * @param body - Text inside single quotes
     * @returns Single-quoted, bounded snippet
     */
    private static trim(body: string): string {
        const clean = body.replace(/\r?\n|\r/gu, " ");
        if (clean.length <= ErrorListener.MAX_QUOTED) {
            return `'${clean}'`;
        }
        return `'…${clean.slice(-ErrorListener.MAX_QUOTED)}'`;
    }
}
