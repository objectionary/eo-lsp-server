import { EoVisitor } from "./parser/EoVisitor";
import {
    DocumentSymbol,
    SymbolKind,
    Range
} from "vscode-languageserver";
import {
    ObjectContext,
    MethodContext,
    VoidContext,
    FormationContext,
    AtomContext,
    MetasContext,
    OnameContext,
    TnameContext
} from "./parser/EoParser";
import { RuleNode } from "antlr4ts/tree/RuleNode";
import { ParseTree } from "antlr4ts/tree/ParseTree";
import { TerminalNode } from "antlr4ts/tree/TerminalNode";
import { ErrorNode } from "antlr4ts/tree/ErrorNode";

/**
 * Implements symbol extraction using the existing `EoParser`.
 */
export class DocumentSymbolVisitor implements EoVisitor<DocumentSymbol[]> {
    private symbols: DocumentSymbol[] = [];
    private currentObject: DocumentSymbol | null = null;

    /**
     * Get all extracted symbols
     * @returns symbols array
     */
    public getSymbols(): DocumentSymbol[] {
        return this.symbols;
    }

    /**
     * Helper to extract object name
     * @param ctx ObjectContext
     * @returns string | null
     */
    private extractObjectName(ctx: ObjectContext): string | null {
        return null;
    }

    /**
     * Helper to extract method name
     * @param ctx MethodContext
     * @returns string
     */
    private extractMethodName(ctx: MethodContext): string {
        return "method";
    }

    /**
     * Create LSP range from parser context
     * @param ctx any
     * @returns object Range
     */
    private createRange(ctx: MethodContext | ObjectContext | VoidContext): Range {
        const start = ctx.start;
        const stop = ctx.stop || ctx.start;
        return Range.create(
            start.line - 1,
            start.charPositionInLine,
            stop.line - 1,
            stop.charPositionInLine + (stop.text?.length || 0)
        );
    }

    /**
     * Visit object definitions
     * @param ctx ObjectContext
     * @returns symbols array
     */
    visitObject(ctx: ObjectContext): DocumentSymbol[] {
        const name = this.extractObjectName(ctx);
        const range = this.createRange(ctx);
        const symbol: DocumentSymbol = {
            name: name || "anonymus",
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
        const name = this.extractMethodName(ctx);
        const range = this.createRange(ctx);
        const symbol: DocumentSymbol = {
            name: name || "anonymus",
            kind: SymbolKind.Method,
            range,
            selectionRange: range,
            children: []
        };
        if (this.currentObject) {
            this.currentObject.children?.push(symbol);
        } else {
            this.symbols.push(symbol);
        }
        this.visitChildren(ctx);
        return this.symbols;
    }

    /**
     * Visit method definitions
     * @param ctx VoidContext
     * @returns symbols array
     */
    visitVoid(ctx: VoidContext): DocumentSymbol[] {
        /* eslint-disable-next-line new-cap */
        const name = ctx.NAME()?.text || ctx.PHI()?.text;
        const range = this.createRange(ctx);
        const symbol: DocumentSymbol = {
            name: name || "attribute",
            kind: SymbolKind.Property,
            range,
            selectionRange: range,
            children: []
        };
        if (this.currentObject) {
            this.currentObject.children?.push(symbol);
        }
        return this.symbols;
    }

    /**
     * Visit the children of a node, and return a user-defined result
     * of the operation.
     * @param node The {@link RuleNode} whose children should be visited.
     * @returns The result of visiting the children of the node.
     */
    visitChildren(node: RuleNode): DocumentSymbol[] {
        
    }

    /**
     * Visit a parse tree, and return a user-defined result of the operation.
     *
     * @param tree The {@link ParseTree} to visit.
     * @returns The result of visiting the parse tree.
     */
    visit(tree: ParseTree): DocumentSymbol[] {
        
    }

    /**
     * Visit a terminal node, and return a user-defined result of the operation.
     *
     * @param node The {@link TerminalNode} to visit.
     * @returns The result of visiting the node.
     */
    visitTerminal(node: TerminalNode): DocumentSymbol[] {
        
    }

    /**
     * Visit an error node, and return a user-defined result of the operation.
     *
     * @param node The {@link ErrorNode} to visit.
     * @returns The result of visiting the node.
     */
    visitErrorNode(node: ErrorNode): DocumentSymbol[] {
        
    }
}
