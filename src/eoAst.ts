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
export interface EoAstNode {
    type: string;
    name: string;
    range: Range;
    selectionRange: Range;
    children: EoAstNode[];
    text: string;
}

/**
 * Describes a normalized object
 */
export interface EoObject extends EoAstNode {
    type: "object";
}

/**
 * Describes a normalized attribute
 */
export interface EoAttribute extends EoAstNode {
    type: "attribute";
}

/**
 * We create a normalized layer for EO Abstract Syntax Tree,
 * so it hides all of the ANTLR4's complexity inside, by
 * simplifying RuleContext into a simple structure.
 *
 * Basically, we need this to extract the `name` of the symbols.
 */
export class EoAst {
    private nodes: Map<ParseTree, EoAstNode> = new Map();

    /**
     * Normalizes ProgramContext
     *
     * @param ctx RuleContext
     * @returns EoAstNode array.
     * */
    program(ctx: ProgramContext): EoAstNode[] {
        const nodes: EoAstNode[] = [];
        if (ctx.object()) {
            const object = this.object(ctx.object());
            nodes.push(object);
        }
        return nodes;
    }

    /**
     * Normalizes ObjectContext
     *
     * @param ctx ObjectContext
     * @returns normalized object as a simple structure
     */
    object(ctx: ObjectContext): EoObject {
        if (this.nodes.has(ctx)) {
            return this.nodes.get(ctx) as EoObject;
        }
        const name = EoAst.objectName(ctx);
        const range = EoAst.createRange(ctx);
        const topChildren = this.topChildren(ctx);
        const normalized: EoObject = {
            type: "object",
            name,
            range,
            children: topChildren,
            text: ctx.text,
            selectionRange: range
        };
        this.nodes.set(ctx, normalized);
        return normalized;
    }

    /**
     * Normalizes BoundContext
     *
     * @param ctx BoundContext
     * @returns normalized bound as a simple structure
     */
    bound(ctx: BoundContext): EoAttribute {
        if (this.nodes.has(ctx)) {
            return this.nodes.get(ctx) as EoAttribute;
        }
        const name = EoAst.boundName(ctx);
        const range = EoAst.createRange(ctx);
        const normalized: EoAttribute = {
            type: "attribute",
            name,
            range,
            selectionRange: range,
            children: [],
            text: ctx.text
        };
        this.nodes.set(ctx, normalized);
        return normalized;
    }

    /**
     * Normalizes MasterBodyContext
     *
     * @param ctx MasterBodyContext
     * @returns normalized masterbody as a simple structure
     */
    masterBody(ctx: MasterBodyContext): EoAttribute {
        if (this.nodes.has(ctx)) {
            return this.nodes.get(ctx) as EoAttribute;
        }
        const name = EoAst.masterBodyName(ctx);
        const range = EoAst.createRange(ctx);
        const normalized: EoAttribute = {
            type: "attribute",
            name,
            range,
            selectionRange: range,
            children: [],
            text: ctx.text
        };
        this.nodes.set(ctx, normalized);
        return normalized;
    }

    /**
     * Finds the direct children of an ObjectContext using
     * ANTLR methods.
     * @param ctx ObjectContext
     * @returns normalized array of top-level children
     * */
    topChildren(ctx: ObjectContext): EoAstNode[] {
        const children: EoAstNode[] = [];
        const masterBody = ctx.masterBody();
        if (masterBody) {
            const topAttributes = this.topAttributes(masterBody);
            children.push(...topAttributes);
        }
        for (let i = 0; i < ctx.childCount; i++) {
            const child = ctx.getChild(i);
            if (child instanceof SubMasterContext) {
                this.lookNested(child, children);
            }
        }
        return children;
    }

    /**
     * Extracts top-level attributes from MasterBodyContext.
     * @param masterBody MasterBodyContext.
     * @returns normalized array of top-level attributes.
     */
    private topAttributes(masterBody: MasterBodyContext): EoAstNode[] {
        const attributes: EoAstNode[] = [];
        const look = (current: ParseTree, depth: number = 0): void => {
            if (current instanceof BoundContext) {
                attributes.push(this.bound(current));
                return;
            }
            if (current instanceof SubMasterContext) {
                this.lookNested(current, attributes);
                return;
            }
            if (current instanceof RuleNode && depth < 10) {
                for (let i = 0; i < current.childCount; i++) {
                    const child = current.getChild(i);
                    if (child) {
                        look(child, depth + 1);
                    }
                }
            }
        };
        look(masterBody);
        return attributes;
    }

    /**
     * Loops through the SubMasterContext and gets only the
     * MasterBodyContext's children.
     * @param subMaster SubMasterContext.
     * @param children EoAstNode[].
     * @returns void.
     * */
    private lookNested(subMaster: SubMasterContext, children: EoAstNode[]): void {
        for (let i = 0; i < subMaster.childCount; i++) {
            const child = subMaster.getChild(i);
            if (child instanceof MasterBodyContext) {
                children.push(this.masterBody(child));
            }
        }
    }

    /**
     * Recursively traverse through the children to find
     * all of the nested nodes.
     * @param node ObjectContext
     * @returns normalized array of nested nodes.
     * */
    hierarchy(node: ObjectContext): EoAstNode[] {
        const children: EoAstNode[] = [];
        const look = (current: ParseTree): void => {
            if (current instanceof MasterBodyContext) {
                children.push(this.masterBody(current));
            } else if (current instanceof BoundContext) {
                children.push(this.bound(current));
            }
            if (current instanceof RuleNode) {
                for (let i = 0; i < current.childCount; i++) {
                    const child = current.getChild(i);
                    if (child) {
                        look(child);
                    }
                }
            }
        };
        look(node);
        return children;
    }

    /**
     * Object name extractor
     *
     * @param ctx ObjectContext
     * @returns string containing `name`
     */
    private static objectName(ctx: ObjectContext): string {
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
    private static boundName(ctx: BoundContext): string {
        const text = ctx.text;
        if (text.includes("> @")) {
            return "@";
        }
        const match = text.match(/(?:\+)?\s*>\s*([a-zA-Z_][a-zA-Z0-9_-]*)/u);
        if (match) {
            return match[1];
        }
        return "anonymous";
    }

    /**
     * Masterbody attribute name extractor
     *
     * @param ctx MasterBodyContext
     * @returns string containing `name`
     * */
    private static masterBodyName(ctx: MasterBodyContext): string {
        const text = ctx.text;
        const match = text.match(/(?:\+)?\s*>\s*([a-zA-Z_][a-zA-Z0-9_-]*)/u);
        if (match) {
            return match[1];
        }
        return "anonymous";
    }

    /**
     * Create LSP range from parser context
     * @param ctx MasterBodyContext | BoundContext | ObjectContext
     * @returns Creates a new {@link Range} literal.
     */
    private static createRange(ctx: MasterBodyContext | BoundContext | ObjectContext): Range {
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
