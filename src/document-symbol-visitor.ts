/* eslint-disable class-methods-use-this */
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
import { ProgramContext } from "./parser/EoParser";
import { EoVisitor } from "./parser/EoVisitor";
import { EoAstNormalizer, NormalizedNode } from "./EoASTNormalizer";

/**
 * Implements symbol extraction using the existing `EoParser`.
 */
export class DocumentSymbolVisitor implements EoVisitor<DocumentSymbol[]> {
    private normalizer = new EoAstNormalizer();
    private symbols: DocumentSymbol[] = [];

    /**
     * Get all extracted symbols
     * @returns symbols array
     */
    public getSymbols(): DocumentSymbol[] {
        return this.symbols;
    }

    visitProgram(ctx: ProgramContext): DocumentSymbol[] {
        const normalizedNodes = this.normalizer.normalizeProgram(ctx);
        this.symbols = normalizedNodes.map(node => this.normalizedToDocumentSymbol(node));
        return this.symbols;
    }

    private normalizedToDocumentSymbol(node: NormalizedNode): DocumentSymbol {
        const kind = DocumentSymbolVisitor.getSymbolKind(node.type);
        return {
            name: node.name,
            kind,
            range: node.range,
            selectionRange: node.selectionRange,
            children: node.children.map(child => this.normalizedToDocumentSymbol(child))
        };
    }

    private static getSymbolKind(type: string): SymbolKind {
        switch (type) {
            case "object": return SymbolKind.Object;
            case "attribute": return SymbolKind.Property;
            default: return SymbolKind.Object;
        }
    }

    visit(tree: ParseTree): DocumentSymbol[] {
        return [];
    }
    visitChildren(node: RuleNode): DocumentSymbol[] {
        return [];
    }
    visitTerminal(node: TerminalNode): DocumentSymbol[] {
        return [];
    }
    visitErrorNode(node: ErrorNode): DocumentSymbol[] {
        return [];
    }
}
