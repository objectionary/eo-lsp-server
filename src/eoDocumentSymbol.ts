/* eslint-disable class-methods-use-this */
// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import {
    DocumentSymbol,
    SymbolKind
} from "vscode-languageserver";
import { ProgramContext } from "./parser/EoParser";
import { EoAst, EoAstNode } from "./eoAst";
import EoVisitor from "./parser/EoVisitor";
import { ErrorNode, ParseTree, RuleNode, TerminalNode } from "antlr4";

/**
 * Implements symbol extraction using the existing `EoParser`.
 */
export class EoDocumentSymbol implements EoVisitor<DocumentSymbol[]> {
    private eoAst = new EoAst();
    private symbols: DocumentSymbol[] = [];

    /**
     * Get all the extracted symbols
     * @returns symbols array
     */
    public symbol(): DocumentSymbol[] {
        return this.symbols;
    }

    /**
     * Entrypoint of the EoVisitor.
     * Maps the normalized nodes to symbols array.
     * @param ctx EoParser `ProgramContext`.
     * @returns symbols array.
     * */
    visitProgram(ctx: ProgramContext): DocumentSymbol[] {
        const nodes = this.eoAst.program(ctx);
        this.symbols = nodes.map(node => this.documentSymbol(node));
        return this.symbols;
    }

    /**
     * Converts the normalized node to `DocumentSymbol`.
     * @param node the normalized node.
     * @returns `DocumentSymbol` node.
     * */
    private documentSymbol(node: EoAstNode): DocumentSymbol {
        const kind = EoDocumentSymbol.kind(node.type);
        return {
            name: node.name,
            kind,
            range: node.range,
            selectionRange: node.selectionRange,
            children: node.children.map(child => this.documentSymbol(child))
        };
    }

    /**
     * Get a number of the `SymbolKind` type.
     * @param type string.
     * @returns number of `SymbolKind`.
     * */
    private static kind(type: string): SymbolKind {
        switch (type) {
            case "object": return SymbolKind.Object;
            case "attribute": return SymbolKind.Property;
            default: return SymbolKind.Property;
        }
    }

    // We omit these methods below from the EoVisitor's interface.
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
