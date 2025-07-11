// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

/**
 * Provides the errors detected during the parsing of an input program.
 * @module ErrorListener
 */

import {
    Token as AntlrToken,
    ANTLRErrorListener,
    Recognizer,
    RecognitionException
} from "antlr4ts";
import { ParserError } from "./parserError";

export class ErrorListener implements ANTLRErrorListener<AntlrToken> {

    /**
     * Array of errors detected during the parsing
     */
    errors: ParserError[] = [];

    syntaxError(recognizer: Recognizer<AntlrToken, any>, symbol: AntlrToken | undefined, line: number,
        position: number, msg: string, e: RecognitionException | undefined) {
        this.errors.push(new ParserError(line, position, msg));
    }
}
