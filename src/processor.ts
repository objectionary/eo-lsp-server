// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import {
    CharStreams,
    CommonTokenStream,
    CodePointCharStream
} from "antlr4ts";
import { EoLexer } from "./parser/EoLexer";
import { EoParser } from "./parser/EoParser";

export class Processor {

    /**
     * Text to be lexed and parsed
     */
    stream: CodePointCharStream;

    /**
     * EO grammar lexer
     */
    lexer: EoLexer;

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
        this.lexer = new EoLexer(this.stream);
        this.tokens = new CommonTokenStream(this.lexer);
        this.parser = new EoParser(this.tokens);
    }
}
