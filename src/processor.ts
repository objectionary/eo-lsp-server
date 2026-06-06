// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import {
    CharStreams,
    CommonTokenStream,
    CharStream
} from "antlr4";
import { IndentationLexer } from "./IndentationLexer";
import EoParser from "./parser/EoParser";

export class Processor {

    /**
     * Text to be lexed and parsed
     */
    stream: CharStream;

    /**
     * EO grammar lexer with indentation support
     */
    lexer: IndentationLexer;

    /**
     * Stream of tokens provided by lexer
     */
    tokens: CommonTokenStream;

    /**
     * EO grammar parser
     */
    parser: EoParser;

    /**
     * Generates the lexer and parser for the given text.
     * @param input - Text on which to perform lexing and parsing
     */
    constructor(input: string) {
        this.stream = CharStreams.fromString(input);
        this.lexer = new IndentationLexer(this.stream);
        this.tokens = new CommonTokenStream(this.lexer);
        this.parser = new EoParser(this.tokens);
    }
}
