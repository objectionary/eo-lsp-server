// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { EoAst, EoAstNode } from "../src/eoAst";
import { ProgramContext } from "../src/parser/EoParser";
import { Processor } from "../src/processor";
import path from "path";
import * as fs from "fs";


describe("EoAst", () => {
    let eoAst: EoAst;
    let programCtx: ProgramContext;

    beforeAll(() => {
        const programPath = path.join(__dirname, "../fixtures", "fibonacci.eo");
        const text = fs.readFileSync(programPath, "utf8");
        const processor = new Processor(text);
        programCtx = processor.parser.program();
    });

    beforeEach(() => {
        eoAst = new EoAst();
    });

    describe("EoAst integration tests", () => {
        test("we expect to obtain an equal nodes", () => {
            const getSpy = jest.spyOn((eoAst as any).nodes, "get");
            const nodes = eoAst.program(programCtx);
            expect(nodes.length).toBeGreaterThan(0);
            const nodes2 = eoAst.program(programCtx);
            expect(getSpy).toHaveBeenCalledTimes(1);
            expect(nodes2).toEqual(nodes);
            getSpy.mockRestore();
        });

        test("we expect hierarchy to return 6 nested children", () => {
            const objectCtx = programCtx.object();
            if (!objectCtx) {
                throw new Error("No ObjectContext found in Fibonacci test file");
            }
            const result = eoAst.hierarchy(objectCtx);
            expect(result.length).toBe(6);
        });
    });

    describe("EoAst mock tests", () => {
        test("we expect createRange method to use ctx.start as fallback when ctx.stop is null", () => {
            const mockCtx = {
                start: {
                    line: 2,
                    charPositionInLine: 5
                },
                stop: null
            };
            const result = (EoAst as any).createRange(mockCtx);
            expect(result).toEqual({
                start: { line: 1, character: 5 },
                end: { line: 1, character: 5 }
            });
        });

        test("we expect object() to return an empty array", () => {
            const mockProgramContext = {
                object: jest.fn().mockReturnValue(null)
            };
            const nodes = eoAst.program(mockProgramContext as any);
            expect(nodes).toEqual([]);
        });

        test("we expect bound and masterBody to return cached value", () => {
            const mockCtx = {
                text: "> cachedAttribute",
                start: { line: 1, charPositionInLine: 0 },
                stop: { line: 1, charPositionInLine: 16, text: "> cachedAttribute" }
            };
            const cachedValue = {
                type: "attribute",
                name: "cachedAttribute",
                range: { start: { line: 0, character: 0 }, end: { line: 0, character: 16 } },
                selectionRange: { start: { line: 0, character: 0 }, end: { line: 0, character: 16 } },
                children: [],
                text: "> cachedAttribute"
            };
            const nodes = (eoAst as any).nodes;
            nodes.set(mockCtx, cachedValue);
            const getSpy = jest.spyOn(nodes, "get");
            const bound = eoAst.bound(mockCtx as any);
            const masterBody = eoAst.masterBody(mockCtx as any);
            expect(getSpy).toHaveBeenCalledTimes(2);
            expect(getSpy).toHaveBeenCalledWith(mockCtx);
            expect(bound).toBe(cachedValue);
            expect(masterBody).toBe(cachedValue);
            getSpy.mockRestore();
        });

        test("we expect topChildren to trigger lookNested method", () => {
            const children: EoAstNode[] = [];
            const mockSubMasterContext = {
                masterBody: jest.fn(),
                getChild: jest.fn(),
                childCount: 0,
                text: "sub-master"
            };
            const mockObjectContext = {
                masterBody: jest.fn().mockReturnValue(null),
                childCount: 1,
                getChild: jest.fn().mockReturnValue(mockSubMasterContext)
            };
            const originalSubMaster = jest.requireActual("../src/parser/EoParser").SubMasterContext;
            Object.setPrototypeOf(mockSubMasterContext, originalSubMaster.prototype);
            const lookNested = jest.spyOn((eoAst as any), "lookNested");
            eoAst.topChildren(mockObjectContext as any);
            expect(lookNested).toHaveBeenCalled();
            expect(lookNested).toHaveBeenCalledWith(mockSubMasterContext, children);
            lookNested.mockRestore();
        });

        describe("Name extraction methods", () => {
            let objectName: jest.SpyInstance;
            let boundName: jest.SpyInstance;
            let masterBodyName: jest.SpyInstance;

            beforeEach(() => {
                objectName = jest.spyOn(EoAst as any, "objectName");
                boundName = jest.spyOn(EoAst as any, "boundName");
                masterBodyName = jest.spyOn(EoAst as any, "masterBodyName");
            });

            afterEach(() => {
                objectName.mockRestore();
                boundName.mockRestore();
                masterBodyName.mockRestore();
            });

            describe("anonymous context", () => {
                const mockAnonymousContext = { text: "[]" };

                test("we expect objectName to return 'anonymous'", () => {
                    const result = (EoAst as any).objectName(mockAnonymousContext);
                    expect(result).toBe("anonymous");
                });

                test("we expect boundName to return 'anonymous'", () => {
                    const result = (EoAst as any).boundName(mockAnonymousContext);
                    expect(result).toBe("anonymous");
                });

                test("we expect masterBodyName to return 'anonymous'", () => {
                    const result = (EoAst as any).masterBodyName(mockAnonymousContext);
                    expect(result).toBe("anonymous");
                });
            });

            describe("test-attribute context", () => {
                const mockTestAttributeContext = { text: "[] +> test-attribute" };

                test("we expect boundName to return 'test-attribute'", () => {
                    const result = (EoAst as any).boundName(mockTestAttributeContext);
                    expect(result).toBe("test-attribute");
                });

                test("we expect masterBodyName to return 'test-attribute'", () => {
                    const result = (EoAst as any).masterBodyName(mockTestAttributeContext);
                    expect(result).toBe("test-attribute");
                });
            });
        });
    });
});
