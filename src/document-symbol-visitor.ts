// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { ErrorNode } from "antlr4ts/tree/ErrorNode";
import { ParseTree } from "antlr4ts/tree/ParseTree";
import { RuleNode } from "antlr4ts/tree/RuleNode";
import { TerminalNode } from "antlr4ts/tree/TerminalNode";
import {
    DocumentSymbol,
    Range,
    SymbolKind
} from "vscode-languageserver";
import {
    MethodContext,
    ObjectContext,
    ProgramContext
} from "./parser/EoParser";
import { EoVisitor } from "./parser/EoVisitor";

/**
 * Implements symbol extraction using the existing `EoParser`.
 */
export class DocumentSymbolVisitor implements EoVisitor<DocumentSymbol[]> {
    private symbols: DocumentSymbol[] = [];
    private currentObject: DocumentSymbol | null = null;

    constructor() {
        this.symbols = [];
        this.currentObject = null;
    }

    /**
     * Get all extracted symbols
     * @returns symbols array
     */
    public getSymbols(): DocumentSymbol[] {
        return this.symbols;
    }

    /**
     * Create LSP range from parser context
     * @param ctx MethodContext | ObjectContext | VoidContext
     * @returns Creates a new {@link Range} literal.
     */
    private static createRange(ctx: ObjectContext | MethodContext | ProgramContext): Range {
        const start = ctx.start;
        const stop = ctx.stop || ctx.start;
        return Range.create(
            start.line - 1,
            start.charPositionInLine,
            stop.line - 1,
            stop.charPositionInLine + (stop.text?.length || 0)
        );
    }

    visitProgram(ctx: ProgramContext): DocumentSymbol[] {
        return this.visitChildren(ctx);
    }

    /**
     * Visit object definitions
     * @param ctx ObjectContext
     * @returns symbols array
     */
    visitObject(ctx: ObjectContext): DocumentSymbol[] {
        const name = "object";
        const range = DocumentSymbolVisitor.createRange(ctx);
        const symbol: DocumentSymbol = {
            name,
            kind: SymbolKind.Class,
            range,
            selectionRange: range,
            children: []
        };
        if (this.currentObject) {
            this.currentObject.children?.push(symbol);
        } else {
            this.symbols.push(symbol);
        }
        const previousObject = this.currentObject;
        this.currentObject = symbol;
        this.visitChildren(ctx);
        this.currentObject = previousObject;
        return this.symbols;
    }

    /**
     * Visit method definitions
     * @param ctx MethodContext
     * @returns symbols array
     */
    visitMethod(ctx: MethodContext): DocumentSymbol[] {
        if (!this.currentObject) {
            return this.symbols;
        }
        const name = "method";
        const range = DocumentSymbolVisitor.createRange(ctx);
        const methodSymbol: DocumentSymbol = {
            name,
            kind: SymbolKind.Method,
            range,
            selectionRange: range,
            children: []
        };
        this.currentObject.children?.push(methodSymbol);
        return this.symbols;
    }

    /**
     * Visit the children of a node, and return a user-defined result
     * of the operation.
     * @param node The {@link RuleNode} whose children should be visited.
     * @returns The result of visiting the children of the node.
     */
    visitChildren(node: RuleNode): DocumentSymbol[] {
        for (let i = 0; i < node.childCount; i++) {
            const child = node.getChild(i);
            if (child) {
                child.accept(this);
            }
        }
        return this.symbols;
    }

    /**
     * Visit a parse tree, and return a user-defined result of the operation.
     *
     * @param tree The {@link ParseTree} to visit.
     * @returns The result of visiting the parse tree.
     */
    visit(tree: ParseTree): DocumentSymbol[] {
        return tree.accept(this);
    }

    /**
     * Visit a terminal node, and return a user-defined result of the operation.
     *
     * @param node The {@link TerminalNode} to visit.
     * @returns The result of visiting the node.
     */
    visitTerminal(node: TerminalNode): DocumentSymbol[] {
        return this.symbols;
    }

    /**
     * Visit an error node, and return a user-defined result of the operation.
     *
     * @param node The {@link ErrorNode} to visit.
     * @returns The result of visiting the node.
     */
    visitErrorNode(node: ErrorNode): DocumentSymbol[] {
        return this.symbols;
    }
}
