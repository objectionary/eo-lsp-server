// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { ParseTree } from "antlr4ts/tree/ParseTree";
import { Range } from "vscode-languageserver";
import { BoundContext, MasterBodyContext, ObjectContext, ProgramContext } from "./parser/EoParser";
import { RuleNode } from "antlr4ts/tree/RuleNode";
import { customDebugLogger } from "./debug-logger";

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
 * Describes a normalized attribute
 */
export interface NormalizedBound extends NormalizedNode {
    type: "attribute";
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
        customDebugLogger.log("normalizeProgram STARTED \n");
        const nodes: NormalizedNode[] = [];
        if (ctx.object()) {
            customDebugLogger.log("Object detected!");
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
        customDebugLogger.log("normalizing OBJECT STARTED \n");
        const name = EoAstNormalizer.extractObjectName(ctx);
        const range = EoAstNormalizer.createRange(ctx);
        const parameters = EoAstNormalizer.extractObjectParameters(ctx);
        const allChildren = this.findChildrenRecursively(ctx);
        const normalized: NormalizedObject = {
            type: "object",
            name,
            range,
            parameters,
            children: allChildren,
            text: ctx.text,
            selectionRange: EoAstNormalizer.findNameRange(ctx) || range
        };
        this.normalizedNodes.set(ctx, normalized);
        return normalized;
    }

    /**
     * Normalizes BoundContext
     *
     * @param ctx BoundContext
     * @returns normalized bound as a simple structure
     */
    normalizeAttribute(ctx: BoundContext): NormalizedBound {
        const name = EoAstNormalizer.extractAttributeName(ctx);
        const range = EoAstNormalizer.createRange(ctx);
        const normalized: NormalizedBound = {
            type: "attribute",
            name,
            range,
            selectionRange: EoAstNormalizer.findNameRange(ctx) || range,
            children: [],
            text: ctx.text
        };
        this.normalizedNodes.set(ctx, normalized);
        return normalized;
    }

    /**
     * Normalizes MasterBodyContext
     *
     * @param ctx MasterBodyContext
     * @returns normalized masterbody as a simple structure
     */
    normalizeMasterBody(ctx: MasterBodyContext): NormalizedBound {
        const name = EoAstNormalizer.extractMasterBodyName(ctx);
        const range = EoAstNormalizer.createRange(ctx);
        const normalized: NormalizedBound = {
            type: "attribute",
            name,
            range,
            selectionRange: EoAstNormalizer.findNameRange(ctx) || range,
            children: [],
            text: ctx.text
        };
        this.normalizedNodes.set(ctx, normalized);
        return normalized;
    }

    /**
     * Recursively traverse through the children to find the
     * desired parsetree node.
     * @param node ParseTree node
     * @returns normalized array of children
     * */
    findChildrenRecursively(node: ParseTree): NormalizedNode[] {
        const children: NormalizedNode[] = [];
        const traverse = (current: ParseTree) => {
            if (current instanceof BoundContext && current !== node) {
                children.push(this.normalizeAttribute(current));
            } else if (current instanceof MasterBodyContext && current !== node) {
                children.push(this.normalizeMasterBody(current));
            } else if (current instanceof ObjectContext && current !== node) {
                children.push(this.normalizeObject(current));
            }
            if (current instanceof RuleNode) {
                for (let i = 0; i < current.childCount; i++) {
                    const child = current.getChild(i);
                    if (child) {
                        traverse(child);
                    }
                }
            }
        };
        traverse(node);
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
     * Bound attribute name extractor
     *
     * @param ctx BoundContext
     * @returns string containing `name`
     * */
    private static extractAttributeName(ctx: BoundContext): string {
        const text = ctx.text;
        if (text.includes("> @")) {
            return "@";
        }
        const boundMatch = text.match(/(?:\+)?\s*>\s*([a-zA-Z_][a-zA-Z0-9_-]*)/u);
        if (boundMatch) {
            return boundMatch[1];
        }
        const words = text.trim().split(/\s+/u);
        const lastWord = words[words.length - 1];
        if (lastWord && /^[a-zA-Z_]/u.test(lastWord)) {
            return lastWord;
        }
        return "anonymous-attribute";
    }

    /**
     * Masterbody attribute name extractor
     *
     * @param ctx MasterBodyContext
     * @returns string containing `name`
     * */
    private static extractMasterBodyName(ctx: MasterBodyContext): string {
        const text = ctx.text;
        customDebugLogger.log(`\n MASTERBODY_CONTEXT contains TEXT: \n ${text} \n`);
        const boundMatch = text.match(/(?:\+)?\s*>\s*([a-zA-Z_][a-zA-Z0-9_-]*)/u);
        if (boundMatch) {
            return boundMatch[1];
        }
        const words = text.trim().split(/\s+/u);
        const lastWord = words[words.length - 1];
        if (lastWord && /^[a-zA-Z_]/u.test(lastWord)) {
            return lastWord;
        }
        return "anonymous-masterbody";
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
