// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { EoAst } from "../src/eoAst";
import { EoDocumentSymbol } from "../src/eoDocumentSymbol";
import { Processor } from "../src/processor";
import { getParserErrors } from "../src/parser";

describe("Names of document symbols", () => {
    test.each([
        ['"answer > misleading" > correct', "correct"],
        ['"answer > @" > correct', "correct"],
        ['42 > valueé', "valueé"],
        ['43 > value\u00df', "value\u00df"],
        ['42 > @', "@"],
        ['42 +> test-attribute', "test-attribute"],
        ['42 > constant!', "constant"],
        ['[] > nestedé', "nestedé"],
        ['[] > atom ?', "atom"],
        ['[] > @ ?', "@"],
        ['42 +> @', "@"],
        ['foo "value > misleading" > applied', "applied"],
        ['foo > vertical\n    "answer > misleading"', "vertical"]
    ])("extracts the binding of %s", (line, expected) => {
        const text = `# test.\n[] > testé\n  ${line}\n`;
        expect(getParserErrors(text)).toEqual([]);
        const visitor = new EoDocumentSymbol();
        new Processor(text).parser.program().accept(visitor);
        expect(visitor.symbol()[0].name).toBe("testé");
        expect(visitor.symbol()[0].children![0].name).toBe(expected);
    });
    test("names a top-level bound object from its declaration", () => {
        const text = '# test.\n"answer > misleading" > actualé\n';
        expect(getParserErrors(text)).toEqual([]);
        const visitor = new EoDocumentSymbol();
        new Processor(text).parser.program().accept(visitor);
        expect(visitor.symbol()[0].name).toBe("actualé");
    });
    test("uses anonymous when a recovered declaration has no name", () => {
        const processor = new Processor("[]");
        processor.parser.removeErrorListeners();
        const ctx = processor.parser.program();
        expect(new EoAst().program(ctx)[0].name).toBe("anonymous");
    });
});
