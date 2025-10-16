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

    beforeEach(() => {
        normalizer = new EoASTNormalizer();
    });

    test("we normalize real EO code", () => {
        const programPath = path.join(__dirname, "../fixtures", "fibonacci.eo");
        const text = fs.readFileSync(programPath, "utf8");
        const processor = new Processor(text);
        const programCtx = processor.parser.program();
        const nodes = normalizer.normalizeProgram(programCtx);
        expect(nodes.length).toBeGreaterThan(0);
        const nodes2 = normalizer.normalizeProgram(programCtx);
        expect(nodes2).toEqual(nodes);
    });
});
