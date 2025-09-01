// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import * as fs from "fs";
import * as path from "path";
import { Token as AntlrToken } from "antlr4ts";
import { Processor } from "./processor";
import { ParserError } from "./parserError";
import { ErrorListener } from "./errorListener";

/**
 * Set of the token types present in the EO's grammar file
 */
let types: Set<string> | null = null;

/**
 * Maps the token numbers returned by the parser to the token type names
 * present in the EO's grammar file
 */
let mapper: Map<number, string> | null = null;

/**
 * the correct path to EoLexer.tokens file
 */
const location = path.join(__dirname, "parser", "EoLexer.tokens");

/**
 * Builds the token type set and token number to token type map using the ANTLR4
 * tokens file, if any of these has not been built yet.
 * @param locationPath expect to see the path to EoLexer.tokens file
 * @returns {void}
 */
export function buildTokenSetAndMap(locationPath: string) {
    if (!types || !mapper) {
        types = new Set<string>();
        mapper = new Map<number, string>();
        try {
            const text = fs.readFileSync(locationPath, { encoding: "utf-8" });
            text.split("\n").forEach(elem => {
                if (elem[0] !== "'") {
                    const pair = elem.split("=");

                    if (pair.length === 2) {
                        types!.add(pair[0]);
                        mapper!.set(Number(pair[1]), pair[0]);
                    }
                }
            });
        } catch (e) {
            throw new Error("EoLexer.tokens file missing");
        }
    }
}

/**
 * Resets the values of the `types` and `mapper` module variables to null.
 *
 * For testing purposes only
 * @returns Void
 */
export function resetTokenCache() {
    types = null;
    mapper = null;
}

/**
 * Converts a type number into textual token type like "META", since antlr lexer
 * returns token types as numbers
 * @param num - Number of the token type returned by the parser
 * @returns - Name of the token type defined by EO's grammar
 */
export function antlrTypeNumToString(num: number): string {
    buildTokenSetAndMap(location);
    return mapper!.get(num)!;
}

/**
 * Retrieves all token type names as defined in EO's grammar
 * @returns - Set of all the token type names define in EO's grammar
 */
export function getTokenTypes(): Set<string> {
    buildTokenSetAndMap(location);
    return types!;
}

/**
 * Tokenizes an input text using the ANTLR4 tokenizer
 * @param input - Text to be tokenized
 * @returns - Array of AntlrTokens containing the tokens in the text
 */
export function tokenize(input: string): AntlrToken[] {
    const processor = new Processor(input);
    processor.tokens.fill();
    return processor.tokens.getTokens();
}

/**
 * Parses the input text and returns the parsing errors detected
 * @param input - Text to be parsed
 * @returns - Array of parsing errors detected during the parsing
 */
export function getParserErrors(input: string): ParserError[] {
    const processor = new Processor(input);
    const listener = new ErrorListener();
    processor.lexer.removeErrorListeners();
    processor.parser.removeErrorListeners();
    processor.parser.addErrorListener(listener);
    processor.parser.program();
    return listener.errors;
}
