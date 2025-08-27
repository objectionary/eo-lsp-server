// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { CharStreams, Token } from "antlr4ts";
import { IndentationLexer } from "../src/IndentationLexer";

describe("IndentationLexer", () => {
    describe("handleTabs", () => {
        test("emits TAB/UNTAB tokens based on the difference between the current and previous indentation.", () => {
            const input = "  deeply indented\n    more indentation\n  medium indentation";
            const chrStream = CharStreams.fromString(input);
            const lexer = new IndentationLexer(chrStream);
            const tokens: Token[] = [];
            let token = lexer.nextToken();
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
});
