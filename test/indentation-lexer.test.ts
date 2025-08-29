// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { CharStreams, Token, VocabularyImpl } from "antlr4ts";
import { IndentationLexer } from "../src/IndentationLexer";
import { EoLexer } from "../src/parser/EoLexer";

describe("IndentationLexer", () => {

    describe("handleTabs", () => {

        test("we expect to emits TAB/UNTAB tokens based on the difference between the current and previous indentation.", () => {
            const input = "  2\n      bar > foo\n    42 > @";
            const chrStream = CharStreams.fromString(input);
            const lexer = new IndentationLexer(chrStream);
            const tokens: Token[] = [];
            let token: Token = lexer.nextToken();
            while (token.type !== Token.EOF) {
                tokens.push(token);
                token = lexer.nextToken();
            }
            const tabTokens = tokens.filter(t => t.type === IndentationLexer.TAB);
            const untabTokens = tokens.filter(t => t.type === IndentationLexer.UNTAB);
            expect(tabTokens.length).toBeGreaterThan(0);
            expect(untabTokens.length).toBeGreaterThan(0);
        });

    });

    describe("getters", () => {

        test("we expect to get all the values", () => {
            const lexer = new IndentationLexer(CharStreams.fromString(""));
            expect(lexer.channelNames).toEqual(EoLexer.channelNames);
            expect(lexer.grammarFileName).toBe("Eo.g4");
            expect(lexer.modeNames).toEqual(EoLexer.modeNames);
            expect(lexer.ruleNames).toEqual(EoLexer.ruleNames);
            /* eslint-disable-next-line no-underscore-dangle */
            expect(lexer.serializedATN).toEqual(EoLexer._serializedATN);
            expect(lexer.vocabulary).toBeInstanceOf(VocabularyImpl);
            expect(lexer.vocabulary).toEqual(EoLexer.VOCABULARY);
        });

    });

    describe("lookAhead", () => {

        const testCases = [
            {
                name: "we expect to get the correct calls of textSpaces method",
                inputToChrStream: 't\n42 > @\n  bar > foo\n    "hello, world"\n  bar > foo\n',
                expectedCalls: ["", "  ", "    ", "  ", ""],
                expectedCount: 5
            },
            {
                name: "we expect to get the correct calls of textSpaces method",
                inputToChrStream: '\n\n42 > @\n  bar > foo\n    "hello, world"\n  bar > foo\n',
                expectedCalls: ["", "", "  ", "    ", "  ", ""],
                expectedCount: 6
            }
        ];
        test.each(testCases)("$name", ({ inputToChrStream, expectedCalls, expectedCount }) => {
            const chrStream = CharStreams.fromString(inputToChrStream);
            const lexer = new IndentationLexer(chrStream);
            const spacesPushSpy = jest.spyOn((lexer as any).spaces, "push");
            const tokens: Token[] = [];
            let token: Token = lexer.nextToken();
            while (token.type !== Token.EOF) {
                tokens.push(token);
                token = lexer.nextToken();
            }
            const tabTokens = tokens.filter(t => t.type === IndentationLexer.TAB);
            const untabTokens = tokens.filter(t => t.type === IndentationLexer.UNTAB);
            expect(tabTokens.length).toBeGreaterThan(0);
            expect(untabTokens.length).toBeGreaterThan(0);
            expect(tokens.length).toBeGreaterThan(0);
            expectedCalls.forEach((value, index) => {
                expect(spacesPushSpy).toHaveBeenNthCalledWith(index + 1, value);
            });
            expect(spacesPushSpy).toHaveBeenCalledTimes(expectedCount);
            spacesPushSpy.mockRestore();
        });

        test("we expect textSpaces method is called with correct EOL text", () => {
            const input = "\nbar > foo\n  42 > @\n";
            const chrStream = CharStreams.fromString(input);
            const lexer = new IndentationLexer(chrStream);
            const textSpacesSpy = jest.spyOn(IndentationLexer as any, "textSpaces");
            const handleTabsSpy = jest.spyOn(lexer as any, "handleTabs");
            const tokens: Token[] = [];
            let token: Token = lexer.nextToken();
            while (token.type !== Token.EOF) {
                tokens.push(token);
                token = lexer.nextToken();
            }
            expect(textSpacesSpy).toHaveBeenCalledWith("\n");
            expect(textSpacesSpy).toHaveBeenCalledWith("\n  ");
            expect(textSpacesSpy).toHaveBeenCalledWith("\n");
            expect(textSpacesSpy).toHaveBeenCalledTimes(3);
            expect(handleTabsSpy).toHaveBeenCalled();
            textSpacesSpy.mockRestore();
            handleTabsSpy.mockRestore();
        });
    });
});
