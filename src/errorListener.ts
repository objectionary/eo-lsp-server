// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
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

export class ErrorListener implements ANTLRErrorListener<AntlrToken> {

    /**
     * Array of errors detected during the parsing
     */
    errors: ParserError[] = [];

    syntaxError(recognizer: Recognizer<AntlrToken>, symbol: AntlrToken | undefined, line: number,
        position: number, msg: string, _e: RecognitionException | undefined) {
        const length = symbol && symbol.stop >= symbol.start ? symbol.stop - symbol.start + 1 : 1;
        this.errors.push(new ParserError(line, position, length, msg));
    }
}
