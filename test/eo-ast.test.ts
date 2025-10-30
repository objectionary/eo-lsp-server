// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { EoAst, EoAstNode } from "../src/eoAst";
import { Processor } from "../src/processor";
import path from "path";
import * as fs from "fs";


describe("EoAst", () => {

    /**
     * Reads and parses the `fibonacci.eo` eo-file
     * @returns program context
     * */
    function program() {
        const programPath = path.join(__dirname, "../fixtures", "fibonacci.eo");
        const text = fs.readFileSync(programPath, "utf8");
        const processor = new Processor(text);
        const programCtx = processor.parser.program();
        return programCtx;
    }

    describe("EoAst integration tests", () => {
        test("we expect to obtain an equal nodes", () => {
            const programCtx = program();
            const eoAst = new EoAst();
            const get = jest.spyOn((eoAst as any).nodes, "get");
            const nodes = eoAst.program(programCtx);
            expect(nodes.length).toBeGreaterThan(0);
            const nodes2 = eoAst.program(programCtx);
            expect(get).toHaveBeenCalledTimes(1);
            expect(nodes2).toEqual(nodes);
            get.mockRestore();
        });

        test("we expect hierarchy to return 6 nested children", () => {
            const programCtx = program();
            const eoAst = new EoAst();
            const context = programCtx.object();
            if (!context) {
                throw new Error("No ObjectContext found in Fibonacci test file");
            }
            const nested = eoAst.hierarchy(context);
            expect(nested.length).toBe(6);
        });
    });

    describe("EoAst mock tests", () => {
        test("we expect createRange method to use ctx.start as fallback when ctx.stop is null", () => {
            const context = {
                start: {
                    line: 2,
                    charPositionInLine: 5
                },
                stop: null
            };
            const range = (EoAst as any).createRange(context);
            expect(range).toEqual({
                start: { line: 1, character: 5 },
                end: { line: 1, character: 5 }
            });
        });

        test("we expect object() to return an empty array", () => {
            const eoAst = new EoAst();
            const context = {
                object: jest.fn().mockReturnValue(null)
            };
            const nodes = eoAst.program(context as any);
            expect(nodes).toEqual([]);
        });

        test("we expect bound and masterBody to return cached value", () => {
            const eoAst = new EoAst();
            const context = {
                text: "> cachedAttribute",
                start: { line: 1, charPositionInLine: 0 },
                stop: { line: 1, charPositionInLine: 16, text: "> cachedAttribute" }
            };
            const cached = {
                type: "attribute",
                name: "cachedAttribute",
                range: { start: { line: 0, character: 0 }, end: { line: 0, character: 16 } },
                selectionRange: { start: { line: 0, character: 0 }, end: { line: 0, character: 16 } },
                children: [],
                text: "> cachedAttribute"
            };
            const nodes = (eoAst as any).nodes;
            nodes.set(context, cached);
            const get = jest.spyOn(nodes, "get");
            const bound = eoAst.bound(context as any);
            const masterBody = eoAst.masterBody(context as any);
            expect(get).toHaveBeenCalledTimes(2);
            expect(get).toHaveBeenCalledWith(context);
            expect(bound).toBe(cached);
            expect(masterBody).toBe(cached);
            get.mockRestore();
        });

        test("we expect topChildren to trigger lookNested method", () => {
            const eoAst = new EoAst();
            const children: EoAstNode[] = [];
            const subMasterCtx = {
                masterBody: jest.fn(),
                getChild: jest.fn(),
                childCount: 0,
                text: "sub-master"
            };
            const objectCtx = {
                masterBody: jest.fn().mockReturnValue(null),
                childCount: 1,
                getChild: jest.fn().mockReturnValue(subMasterCtx)
            };
            const originalSubMaster = jest.requireActual("../src/parser/EoParser").SubMasterContext;
            Object.setPrototypeOf(subMasterCtx, originalSubMaster.prototype);
            const lookNested = jest.spyOn((eoAst as any), "lookNested");
            eoAst.topChildren(objectCtx as any);
            expect(lookNested).toHaveBeenCalledWith(subMasterCtx, children);
            lookNested.mockRestore();
        });

        describe("Name extraction methods", () => {
            describe("anonymous context", () => {
                test("we expect objectName to return 'anonymous'", () => {
                    const anonymous = { text: "[]" };
                    const result = (EoAst as any).objectName(anonymous);
                    expect(result).toBe("anonymous");
                });

                test("we expect boundName to return 'anonymous'", () => {
                    const anonymous = { text: "[]" };
                    const result = (EoAst as any).boundName(anonymous);
                    expect(result).toBe("anonymous");
                });

                test("we expect masterBodyName to return 'anonymous'", () => {
                    const anonymous = { text: "[]" };
                    const result = (EoAst as any).masterBodyName(anonymous);
                    expect(result).toBe("anonymous");
                });
            });

            describe("test-attribute context", () => {
                test("we expect boundName to return 'test-attribute'", () => {
                    const testAttr = { text: "[] +> test-attribute" };
                    const result = (EoAst as any).boundName(testAttr);
                    expect(result).toBe("test-attribute");
                });

                test("we expect masterBodyName to return 'test-attribute'", () => {
                    const testAttr = { text: "[] +> test-attribute" };
                    const result = (EoAst as any).masterBodyName(testAttr);
                    expect(result).toBe("test-attribute");
                });
            });
        });
    });
});
