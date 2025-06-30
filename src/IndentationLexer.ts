// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { Token, CommonToken, Lexer, CharStream } from "antlr4ts";
import { EoLexer } from "./parser/EoLexer";

/**
 * Custom lexer that wraps EoLexer to handle indentation-based TAB/UNTAB tokens
 * Modeled after the Java EoIndentLexer implementation
 */
export class IndentationLexer extends Lexer {
    private wrapped: EoLexer;
    private tokens: Token[] = [];
    private indent: number[] = [];
    private spaces: string[] = [];
    private lastPosition = 0;

    public static readonly TAB = 31;
    public static readonly UNTAB = 32;

    constructor(input: CharStream) {
        super(input);
        this.wrapped = new EoLexer(input);
        this.indent.push(0);
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
     * Extracts spaces from EOL token text
     * @param text - EOL token text
     * @returns Spaces after newline
     */
    private static textSpaces(text: string): string {
        const afterNewline = text.slice(text.indexOf("\n") + 1);
        return afterNewline;
    }

    /**
     * Emits TAB tokens for indentation
     * @param shift - Number of indentation levels to add
     * @returns Void
     */
    private emitIndent(shift: number): void {
        for (let i = 0; i < shift; i++) {
            const tab = this.createToken(
                IndentationLexer.TAB,
                "TAB",
                this.wrapped.line,
                0
            );
            this.tokens.push(tab);
        }
    }

    /**
     * Emits UNTAB tokens for dedentation
     * @param shift - Number of indentation levels to remove
     * @returns Void
     */
    private emitDedent(shift: number): void {
        for (let i = 0; i < shift; i++) {
            const untab = this.createToken(
                IndentationLexer.UNTAB,
                "UNTAB",
                this.wrapped.line,
                0
            );
            this.tokens.push(untab);
        }
    }

    /**
     * Handles TAB/UNTAB token generation based on indentation changes
     * @param tabs - Current indentation level
     * @param next - Next token to process
     * @returns Void
     */
    private handleTabs(tabs: number, next: Token): void {
        const last = this.indent[this.indent.length - 1];
        const shift = tabs - last;
        if (shift < 0) {
            let dedentCount = 0;
            while (this.indent.length > 1 && this.indent[this.indent.length - 1] > tabs) {
                this.indent.pop();
                dedentCount++;
            }
            this.emitDedent(dedentCount);
            if (this.indent[this.indent.length - 1] < tabs) {
                this.indent.push(tabs);
                this.emitIndent(1);
            }
        } else if (shift > 0) {
            this.emitIndent(shift);
            this.indent.push(tabs);
        }
        this.tokens.push(next);
    }

    /**
     * Looks ahead to process indentation
     * @returns Void
     */
    private lookAhead(): void {
        let current: Token | null = null;
        let next = this.wrapped.nextToken();
        while (next.type !== Token.EOF) {
            if (current !== null && current.type === EoLexer.EOL && next.type !== EoLexer.EOL) {
                const spaceText = this.spaces.length > 0 ? this.spaces.pop()! : "";
                this.handleTabs(Math.floor(spaceText.length / 2), next);
                current = null;
                next = this.wrapped.nextToken();
                continue;
            }
            if (current !== null && current.type !== EoLexer.EOL) {
                this.tokens.push(current);
            }
            if (next.type === EoLexer.EOL) {
                this.spaces.push(IndentationLexer.textSpaces(next.text || ""));
                this.tokens.push(next);
            }
            current = next;
            next = this.wrapped.nextToken();
        }
        if (current !== null) {
            if (current.type === EoLexer.EOL) {
                const spaceText = this.spaces.length > 0 ? this.spaces.pop()! : "";
                this.handleTabs(Math.floor(spaceText.length / 2), next);
            } else {
                this.tokens.push(current);
            }
        }
        while (this.indent.length > 1) {
            this.indent.pop();
            this.emitDedent(1);
        }
        this.tokens.push(next);
    }

    /**
     * Overrides nextToken to provide indentation-aware tokens
     * @returns Next token
     */
    public nextToken(): Token {
        if (this.tokens.length === 0) {
            this.lookAhead();
        }
        return this.tokens.shift()!;
    }

    /**
     * Removes all error listeners from both this lexer and the wrapped lexer
     * @returns void
     */
    removeErrorListeners(): void {
        super.removeErrorListeners();
        this.wrapped.removeErrorListeners();
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
