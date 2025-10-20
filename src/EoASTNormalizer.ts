// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { ParseTree } from "antlr4ts/tree/ParseTree";
import { Range } from "vscode-languageserver";
import {
    BoundContext,
    MasterBodyContext,
    ObjectContext,
    ProgramContext,
    SubMasterContext
} from "./parser/EoParser";
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
}

/**
 * Describes a normalized attribute
 */
export interface NormalizedAttribute extends NormalizedNode {
    type: "attribute";
}

/**
 * We create a normalized layer for EO Abstract Syntax Tree,
 * so it hides all of the ANTLR4's complexity inside, by
 * simplifying RuleContext into a simple structure.
 *
 * Basically, we need this to extract the `name` of the symbols.
 */
export class EoASTNormalizer {
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
        const name = EoASTNormalizer.extractObjectName(ctx);
        const range = EoASTNormalizer.createRange(ctx);
        const topLevelChildren = this.findTopLevelChildren(ctx);
        const normalized: NormalizedObject = {
            type: "object",
            name,
            range,
            children: topLevelChildren,
            text: ctx.text,
            selectionRange: range
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
    normalizeBound(ctx: BoundContext): NormalizedAttribute {
        if (this.normalizedNodes.has(ctx)) {
            return this.normalizedNodes.get(ctx) as NormalizedAttribute;
        }
        const name = EoASTNormalizer.extractBoundName(ctx);
        const range = EoASTNormalizer.createRange(ctx);
        const normalized: NormalizedAttribute = {
            type: "attribute",
            name,
            range,
            selectionRange: range,
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
    normalizeMasterBody(ctx: MasterBodyContext): NormalizedAttribute {
        if (this.normalizedNodes.has(ctx)) {
            return this.normalizedNodes.get(ctx) as NormalizedAttribute;
        }
        const name = EoASTNormalizer.extractMasterBodyName(ctx);
        const range = EoASTNormalizer.createRange(ctx);
        const normalized: NormalizedAttribute = {
            type: "attribute",
            name,
            range,
            selectionRange: range,
            children: [],
            text: ctx.text
        };
        this.normalizedNodes.set(ctx, normalized);
        return normalized;
    }

    /**
     * Finds the direct children of an ObjectContext using
     * ANTLR methods.
     * @param ctx ObjectContext
     * @returns normalized array of children
     * */
    findTopLevelChildren(ctx: ObjectContext): NormalizedNode[] {
        const children: NormalizedNode[] = [];
        const masterBody = ctx.masterBody();
        if (masterBody) {
            const topLevelAttributes = this.extractTopLevelAttributes(masterBody);
            children.push(...topLevelAttributes);
        }
        for (let i = 0; i < ctx.childCount; i++) {
            const child = ctx.getChild(i);
            if (child instanceof SubMasterContext) {
                this.processSubMaster(child, children);
            }
        }
        return children;
    }

    /**
     * Extracts top-level attributes from MasterBodyContext.
     * @param masterBody MasterBodyContext.
     * @returns normalized array of top-level attributes.
     */
    private extractTopLevelAttributes(masterBody: MasterBodyContext): NormalizedNode[] {
        const attributes: NormalizedNode[] = [];
        const traverseForTargets = (current: ParseTree, depth: number = 0) => {
            if (current instanceof BoundContext) {
                attributes.push(this.normalizeBound(current));
                return;
            }
            if (current instanceof SubMasterContext) {
                this.processSubMaster(current, attributes);
                return;
            }
            if (current instanceof RuleNode && depth < 10) {
                for (let i = 0; i < current.childCount; i++) {
                    const child = current.getChild(i);
                    if (child) {
                        traverseForTargets(child, depth + 1);
                    }
                }
            }
        };
        traverseForTargets(masterBody);
        return attributes;
    }

    /**
     * Loops through the SubMasterContext and gets only the
     * MasterBodyContext's children.
     * @param subMaster SubMasterContext.
     * @param children NormalizedNode[].
     * @returns void.
     * */
    private processSubMaster(subMaster: SubMasterContext, children: NormalizedNode[]): void {
        for (let i = 0; i < subMaster.childCount; i++) {
            const child = subMaster.getChild(i);
            if (child instanceof MasterBodyContext) {
                children.push(this.normalizeMasterBody(child));
            }
        }
    }

    /**
     * Recursively traverse through the children to find
     * all of the nested nodes.
     * @param node ObjectContext
     * @returns normalized array of nested nodes.
     * */
    findNestedChildrenRecursively(node: ObjectContext): NormalizedNode[] {
        const children: NormalizedNode[] = [];
        const traverse = (current: ParseTree) => {
            if (current instanceof MasterBodyContext) {
                children.push(this.normalizeMasterBody(current));
            } else if (current instanceof BoundContext) {
                children.push(this.normalizeBound(current));
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
        const match = text.match(/(?<!#.*)(?:\]|\[\])\s*>\s*([a-zA-Z_][a-zA-Z0-9_-]*)/u);
        if (match) {
            return match[1];
        }
        return "anonymous";
    }

    /**
     * Bound attribute name extractor
     *
     * @param ctx BoundContext
     * @returns string containing `name`
     * */
    private static extractBoundName(ctx: BoundContext): string {
        const text = ctx.text;
        if (text.includes("> @")) {
            return "@";
        }
        const boundMatch = text.match(/(?:\+)?\s*>\s*([a-zA-Z_][a-zA-Z0-9_-]*)/u);
        if (boundMatch) {
            return boundMatch[1];
        }
        return "anonymous";
    }

    /**
     * Masterbody attribute name extractor
     *
     * @param ctx MasterBodyContext
     * @returns string containing `name`
     * */
    private static extractMasterBodyName(ctx: MasterBodyContext): string {
        const text = ctx.text;
        const boundMatch = text.match(/(?:\+)?\s*>\s*([a-zA-Z_][a-zA-Z0-9_-]*)/u);
        if (boundMatch) {
            return boundMatch[1];
        }
        return "anonymous";
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
