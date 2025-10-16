/* eslint-disable class-methods-use-this */
// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { ErrorNode } from "antlr4ts/tree/ErrorNode";
import { ParseTree } from "antlr4ts/tree/ParseTree";
import { RuleNode } from "antlr4ts/tree/RuleNode";
import { TerminalNode } from "antlr4ts/tree/TerminalNode";
import {
    DocumentSymbol,
    SymbolKind
} from "vscode-languageserver";
import { ProgramContext } from "./parser/EoParser";
import { EoVisitor } from "./parser/EoVisitor";
import { EoASTNormalizer, NormalizedNode } from "./EoASTNormalizer";

/**
 * Implements symbol extraction using the existing `EoParser`.
 */
export class DocumentSymbolVisitor implements EoVisitor<DocumentSymbol[]> {
    private normalizer = new EoASTNormalizer();
    private symbols: DocumentSymbol[] = [];

    /**
     * Get all the extracted symbols
     * @returns symbols array
     */
    public getSymbols(): DocumentSymbol[] {
        return this.symbols;
    }

    /**
     * Entrypoint of the visitor.
     * Maps the normalized nodes to symbols array.
     * @param ctx EoParser `ProgramContext`.
     * @returns symbols array.
     * */
    visitProgram(ctx: ProgramContext): DocumentSymbol[] {
        const normalizedNodes = this.normalizer.normalizeProgram(ctx);
        this.symbols = normalizedNodes.map(node => this.normalizedToDocumentSymbol(node));
        return this.symbols;
    }

    /**
     * Converts the normalized node to `DocumentSymbol`.
     * @param node the normalized node.
     * @returns `DocumentSymbol` node.
     * */
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

    /**
     * Get a number of the `SymbolKind` type.
     * @param type string.
     * @returns number of `SymbolKind`.
     * */
    private static getSymbolKind(type: string): SymbolKind {
        switch (type) {
            case "object": return SymbolKind.Object;
            case "attribute": return SymbolKind.Property;
            default: return SymbolKind.Property;
        }
    }

    // We omit these methods from the EoVisitor's interface.
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
