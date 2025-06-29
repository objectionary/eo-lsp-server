// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { Token, CommonToken, Lexer, CharStream } from "antlr4ts";
import { EoLexer } from "./parser/EoLexer";

/**
 * Custom lexer that wraps EoLexer to handle indentation-based TAB/UNTAB tokens
 */
export class IndentationLexer extends Lexer {
    private wrapped: EoLexer;
    private pendingTokens: Token[] = [];
    private lastPosition = 0;
    private indentStack: number[] = [0];

    public static readonly TAB = 31;
    public static readonly UNTAB = 32;

    constructor(input: CharStream) {
        super(input);
        this.wrapped = new EoLexer(input);
    }

    /**
     * Checks if a token is an EOL token
     * @param token - Token to check
     * @returns true if token is EOL
     */
    private static isEOL(token: Token): boolean {
        return token.type === EoLexer.EOL;
    }

    /**
     * Creates a new token
     * @param type - Token type
     * @param text - Token text
     * @param line - Line number
     * @param column - Column position
     * @returns New CommonToken
     */
    private createToken(type: number, text: string, line: number, column: number): Token {
        const token = new CommonToken(type, text);
        token.line = line;
        token.charPositionInLine = column;
        token.startIndex = this.lastPosition;
        token.stopIndex = this.lastPosition - 1;
        return token;
    }

    /**
     * Calculates the indentation level from EOL token text
     * @param text - EOL token text
     * @returns Indentation level (number of double spaces)
     */
    private static getIndentLevel(text: string): number {
        const afterNewline = text.slice(text.indexOf("\n") + 1);
        return Math.floor(afterNewline.length / 2);
    }

    /**
     * Overrides nextToken to inject TAB/UNTAB tokens based on indentation
     * @returns Next token
     */
    public nextToken(): Token {
        if (this.pendingTokens.length > 0) {
            return this.pendingTokens.shift()!;
        }

        const token = this.wrapped.nextToken();

        if (IndentationLexer.isEOL(token) && token.type !== Token.EOF) {
            const currentIndent = IndentationLexer.getIndentLevel(token.text || "");
            const previousIndent = this.indentStack[this.indentStack.length - 1];

            this.pendingTokens.push(token);

            if (currentIndent > previousIndent) {
                this.indentStack.push(currentIndent);
                const tabToken = this.createToken(
                    IndentationLexer.TAB,
                    "TAB",
                    token.line + 1,
                    currentIndent * 2
                );
                this.pendingTokens.push(tabToken);
            } else if (currentIndent < previousIndent) {
                while (this.indentStack.length > 1 &&
                       this.indentStack[this.indentStack.length - 1] > currentIndent) {
                    this.indentStack.pop();
                    const untabToken = this.createToken(
                        IndentationLexer.UNTAB,
                        "UNTAB",
                        token.line + 1,
                        currentIndent * 2
                    );
                    this.pendingTokens.push(untabToken);
                }
            }

            this.lastPosition = token.stopIndex + 1;
            return this.pendingTokens.shift()!;
        }

        if (token.type === Token.EOF && this.indentStack.length > 1) {
            while (this.indentStack.length > 1) {
                this.indentStack.pop();
                const untabToken = this.createToken(
                    IndentationLexer.UNTAB,
                    "UNTAB",
                    token.line,
                    0
                );
                this.pendingTokens.push(untabToken);
            }
            this.pendingTokens.push(token);
            return this.pendingTokens.shift()!;
        }

        return token;
    }

    get channelNames(): string[] {
        return this.wrapped.channelNames;
    }
    get grammarFileName(): string {
        return this.wrapped.grammarFileName;
    }
    get modeNames(): string[] {
        return this.wrapped.modeNames;
    }
    get ruleNames(): string[] {
        return this.wrapped.ruleNames;
    }
    get serializedATN(): string {
        return this.wrapped.serializedATN;
    }
    get vocabulary(): any {
        return this.wrapped.vocabulary;
    }
}
