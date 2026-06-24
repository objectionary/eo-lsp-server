// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

/**
 * VSCode parsing error message
 * @module ParserError
 */

export class ParserError {
    line: number;
    column: number;
    length: number;
    msg: string;

    /**
     * Error class constructor
     * @param line - Line number of error
     * @param column - Column number of error
     * @param length - Length of the offending token in characters, or 1 when unknown
     * @param msg - Error message
     * @returns - ParserError object
     */
    constructor(line: number, column: number, length: number, msg: string) {
        this.line = line;
        this.column = column;
        this.length = length;
        this.msg = msg;
    }
}
