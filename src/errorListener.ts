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
     * Array of errors detected during the parsing
     */
    errors: ParserError[] = [];

    syntaxError(recognizer: Recognizer<T>, symbol: T | undefined, line: number,
        position: number, msg: string, _e: RecognitionException | undefined) {
        this.errors.push(new ParserError(line, position, msg));
    }
}
