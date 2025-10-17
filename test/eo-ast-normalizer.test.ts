// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import { EoASTNormalizer } from "../src/EoASTNormalizer";
import { Processor } from "../src/processor";
import {
    MasterBodyContext,
    SubMasterContext,
    ObjectContext,
    BoundContext
} from "../src/parser/EoParser";
import path from "path";
import * as fs from "fs";


describe("EoASTNormalizer", () => {
    let normalizer: EoASTNormalizer;
    const programPath = path.join(__dirname, "../fixtures", "fibonacci.eo");
    const text = fs.readFileSync(programPath, "utf8");
    const processor = new Processor(text);
    const programCtx = processor.parser.program();

    beforeEach(() => {
        normalizer = new EoASTNormalizer();
    });

    test("we expect to obtain an equal nodes", () => {
        const getSpy = jest.spyOn((normalizer as any).normalizedNodes, "get");
        const nodes = normalizer.normalizeProgram(programCtx);
        expect(nodes.length).toBeGreaterThan(0);
        const nodes2 = normalizer.normalizeProgram(programCtx);
        expect(getSpy).toHaveBeenCalledTimes(1);
        expect(nodes2).toEqual(nodes);
        getSpy.mockRestore();
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
});
