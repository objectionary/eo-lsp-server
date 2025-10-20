// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { EoASTNormalizer, NormalizedNode } from "../src/EoASTNormalizer";
import { ProgramContext } from "../src/parser/EoParser";
import { Processor } from "../src/processor";
import path from "path";
import * as fs from "fs";


describe("EoASTNormalizer", () => {
    let normalizer: EoASTNormalizer;
    let programCtx: ProgramContext;

    beforeAll(() => {
        const programPath = path.join(__dirname, "../fixtures", "fibonacci.eo");
        const text = fs.readFileSync(programPath, "utf8");
        const processor = new Processor(text);
        programCtx = processor.parser.program();
    });

    beforeEach(() => {
        normalizer = new EoASTNormalizer();
    });

    describe("EoASTNormalizer integration tests", () => {
        test("we expect to obtain an equal nodes", () => {
            const getSpy = jest.spyOn((normalizer as any).normalizedNodes, "get");
            const nodes = normalizer.normalizeProgram(programCtx);
            expect(nodes.length).toBeGreaterThan(0);
            const nodes2 = normalizer.normalizeProgram(programCtx);
            expect(getSpy).toHaveBeenCalledTimes(1);
            expect(nodes2).toEqual(nodes);
            getSpy.mockRestore();
        });

        test("we expect findNestedChildrenRecursively to return 6 nested children", () => {
            const objectCtx = programCtx.object();
            if (!objectCtx) {
                throw new Error("No ObjectContext found in Fibonacci test file");
            }
            const result = normalizer.findNestedChildrenRecursively(objectCtx);
            expect(result.length).toBe(6);
        });
    });

    describe("EoASTNormalizer mock tests", () => {
        test("we expect createRange method to use ctx.start as fallback when ctx.stop is null", () => {
            const mockCtx = {
                start: {
                    line: 2,
                    charPositionInLine: 5
                },
                stop: null
            };
            const result = (EoASTNormalizer as any).createRange(mockCtx);
            expect(result).toEqual({
                start: { line: 1, character: 5 },
                end: { line: 1, character: 5 }
            });
        });

        test("we expect object() to return an empty array", () => {
            const mockProgramContext = {
                object: jest.fn().mockReturnValue(null)
            };
            const nodes = normalizer.normalizeProgram(mockProgramContext as any);
            expect(nodes).toEqual([]);
        });

        test("we expect normalizeBound and normalizeMasterBody to return cached value", () => {
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
            const normalizedNodes = (normalizer as any).normalizedNodes;
            normalizedNodes.set(mockCtx, cachedValue);
            const getSpy = jest.spyOn(normalizedNodes, "get");
            const boundResult = normalizer.normalizeBound(mockCtx as any);
            const masterBodyResult = normalizer.normalizeMasterBody(mockCtx as any);
            expect(getSpy).toHaveBeenCalledTimes(2);
            expect(getSpy).toHaveBeenCalledWith(mockCtx);
            expect(boundResult).toBe(cachedValue);
            expect(masterBodyResult).toBe(cachedValue);
            getSpy.mockRestore();
        });

        test("we expect findTopLevelChildren to trigger processSubMaster method", () => {
            const children: NormalizedNode[] = [];
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
            const processSubMasterSpy = jest.spyOn((normalizer as any), "processSubMaster");
            normalizer.findTopLevelChildren(mockObjectContext as any);
            expect(processSubMasterSpy).toHaveBeenCalled();
            expect(processSubMasterSpy).toHaveBeenCalledWith(mockSubMasterContext, children);
            processSubMasterSpy.mockRestore();
        });

        describe("Name extraction methods", () => {
            let extractObjectNameSpy: jest.SpyInstance;
            let extractBoundNameSpy: jest.SpyInstance;
            let extractMasterBodyNameSpy: jest.SpyInstance;

            beforeEach(() => {
                extractObjectNameSpy = jest.spyOn(EoASTNormalizer as any, "extractObjectName");
                extractBoundNameSpy = jest.spyOn(EoASTNormalizer as any, "extractBoundName");
                extractMasterBodyNameSpy = jest.spyOn(EoASTNormalizer as any, "extractMasterBodyName");
            });

            afterEach(() => {
                extractObjectNameSpy.mockRestore();
                extractBoundNameSpy.mockRestore();
                extractMasterBodyNameSpy.mockRestore();
            });

            describe("anonymous context", () => {
                const mockAnonymousContext = { text: "[]" };

                test("we expect extractObjectName to return 'anonymous'", () => {
                    const result = (EoASTNormalizer as any).extractObjectName(mockAnonymousContext);
                    expect(result).toBe("anonymous");
                });

                test("we expect extractBoundName to return 'anonymous'", () => {
                    const result = (EoASTNormalizer as any).extractBoundName(mockAnonymousContext);
                    expect(result).toBe("anonymous");
                });

                test("we expect extractMasterBodyName to return 'anonymous'", () => {
                    const result = (EoASTNormalizer as any).extractMasterBodyName(mockAnonymousContext);
                    expect(result).toBe("anonymous");
                });
            });

            describe("test-attribute context", () => {
                const mockTestAttributeContext = { text: "[] +> test-attribute" };

                test("we expect extractBoundName to return 'test-attribute'", () => {
                    const result = (EoASTNormalizer as any).extractBoundName(mockTestAttributeContext);
                    expect(result).toBe("test-attribute");
                });

                test("we expect extractMasterBodyName to return 'test-attribute'", () => {
                    const result = (EoASTNormalizer as any).extractMasterBodyName(mockTestAttributeContext);
                    expect(result).toBe("test-attribute");
                });
            });
        });
    });
});
