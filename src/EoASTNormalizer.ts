// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { ParseTree } from "antlr4ts/tree/ParseTree";
import { Range } from "vscode-languageserver";
import { MethodContext, ObjectContext, ProgramContext } from "./parser/EoParser";
import { RuleNode } from "antlr4ts/tree/RuleNode";

/**
 * Describes an EO node in a common way to work with
 */
export interface NormalizedNode {
    type: string;
    name: string;
    range: Range;
    selectionRange: Range;
    children: NormalizedNode[];
    text: string;
}

/**
 * Describes a normalized object
 */
export interface NormalizedObject extends NormalizedNode {
    type: "object";
    parameters: string[];
}

/**
 * Describes a normalized method
 */
export interface NormalizedMethod extends NormalizedNode {
    type: "method";
}

/**
 * We create a normalized layer for EO Abstract Syntax Tree,
 * so it hides all of the ANTLR4's complexity inside, by
 * simplifying RuleContext into a simple structure.
 *
 * Basicly, we need this to extract the `name` of the symbols.
 */
export class EoAstNormalizer {
    private normalizedNodes: Map<ParseTree, NormalizedNode> = new Map();

    /**
     * Normalizes ProgramContext
     *
     * @param ctx RuleContext
     * @returns NormalizedNode array.
     * */
    normalizeProgram(ctx: ProgramContext): NormalizedNode[] {
        const nodes: NormalizedNode[] = [];
        if (ctx.object()) {
            const objectNode = this.normalizeObject(ctx.object());
            nodes.push(objectNode);
        }
        return nodes;
    }

    /**
     * Normalizes ObjectContext
     *
     * @param ctx ObjectContext
     * @returns normalized object as a simple structure
     */
    normalizeObject(ctx: ObjectContext): NormalizedObject {
        if (this.normalizedNodes.has(ctx)) {
            return this.normalizedNodes.get(ctx) as NormalizedObject;
        }
        const name = EoAstNormalizer.extractObjectName(ctx);
        const range = EoAstNormalizer.createRange(ctx);
        const parameters = EoAstNormalizer.extractObjectParameters(ctx);
        const normalized: NormalizedObject = {
            type: "object",
            name,
            range,
            parameters,
            children: [],
            text: ctx.text,
            selectionRange: EoAstNormalizer.findNameRange(ctx) || range
        };
        this.normalizedNodes.set(ctx, normalized);
        normalized.children = this.normalizeChildren(ctx);
        return normalized;
    }

    /**
     * Normalizes MethodContext
     *
     * @param ctx MethodContext
     * @returns normalized method as a simple structure
     */
    normalizeMethod(ctx: MethodContext): NormalizedMethod {
        if (this.normalizedNodes.has(ctx)) {
            return this.normalizedNodes.get(ctx) as NormalizedMethod;
        }
        const name = EoAstNormalizer.extractMethodName(ctx);
        const range = EoAstNormalizer.createRange(ctx);
        const normalized: NormalizedMethod = {
            type: "method",
            name,
            range,
            selectionRange: EoAstNormalizer.findNameRange(ctx) || range,
            children: [],
            text: ctx.text
        };
        this.normalizedNodes.set(ctx, normalized);
        normalized.children = this.normalizeChildren(ctx);
        return normalized;
    }

    /**
     * Normalizes all the node's children
     *
     * @param node RuleNode
     * @returns NormalizedNode array
     */
    private normalizeChildren(node: RuleNode): NormalizedNode[] {
        const children: NormalizedNode[] = [];
        for (let i = 0; i < node.childCount; i++) {
            const child = node.getChild(i);
            if (!child) {
                continue;
            }
            let normalizedChild: NormalizedNode | null = null;
            if (child instanceof ObjectContext) {
                normalizedChild = this.normalizeObject(child);
            } else if (child instanceof MethodContext) {
                normalizedChild = this.normalizeMethod(child);
            } else if (child instanceof RuleNode) {
                const childChildren = this.normalizeChildren(child);
                if (childChildren.length > 0) {
                    normalizedChild = {
                        type: "block",
                        name: `block_${i}`,
                        range: EoAstNormalizer.createRange(child),
                        selectionRange: EoAstNormalizer.createRange(child),
                        children: childChildren,
                        text: child.text
                    };
                }
            }
            if (normalizedChild) {
                children.push(normalizedChild);
            }
        }
        return children;
    }

    /**
     * Object name extractor
     *
     * @param ctx ObjectContext
     * @returns string containing `name`
     */
    private static extractObjectName(ctx: ObjectContext): string {
        const text = ctx.text;
        const gtMatch = text.match(/\]\s*>\s*([a-zA-Z_][a-zA-Z0-9_-]*)/u);
        if (gtMatch) {
            return gtMatch[1];
        }
        const simpleMatch = text.match(/^([a-zA-Z_][a-zA-Z0-9_-]*)\s*>/mu);
        if (simpleMatch) {
            return simpleMatch[1];
        }
        const boundMatch = text.match(/\[\]\s*\+\s*>\s*([a-zA-Z_][a-zA-Z0-9_-]*)/u);
        if (boundMatch) {
            return boundMatch[1];
        }
        return "anonymous";
    }

    /**
     * Method name extractor
     *
     * @param ctx MethodContext
     * @returns string containing `name`
     * */
    private static extractMethodName(ctx: MethodContext): string {
        const text = ctx.text;
        if (text.includes("> @")) {
            return "@";
        }
        const boundMatch = text.match(/\+\s*>\s*([a-zA-Z_][a-zA-Z0-9_-]*)/u);
        if (boundMatch) {
            return boundMatch[1];
        }
        const words = text.trim().split(/\s+/u);
        const lastWord = words[words.length - 1];
        if (lastWord && /^[a-zA-Z_]/u.test(lastWord)) {
            return lastWord;
        }
        return "anonymous-method";
    }

    /**
     * Object parameters extractor
     *
     * @param ctx ObjectContext
     * @returns string array containing parameters
     */
    private static extractObjectParameters(ctx: ObjectContext): string[] {
        const text = ctx.text;
        const bracketMatch = text.match(/\[([^\]]*)\]/u);
        if (bracketMatch) {
            return bracketMatch[1].split(",").map(p => p.trim()).filter(p => p);
        }
        return [];
    }

    private static findNameRange(ctx: ParseTree): Range | null {
        return EoAstNormalizer.createRange(ctx);
    }

    /**
     * Create LSP range from parser context
     * @param ctx MethodContext | ObjectContext | VoidContext
     * @returns Creates a new {@link Range} literal.
     */
    private static createRange(ctx: any): Range {
        const start = ctx.start;
        const stop = ctx.stop || ctx.start;
        return Range.create(
            start.line - 1,
            start.charPositionInLine,
            stop.line - 1,
            stop.charPositionInLine + (stop.text?.length || 0)
        );
    }
}
