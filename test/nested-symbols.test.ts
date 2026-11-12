// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { EoDocumentSymbol } from "../src/eoDocumentSymbol";
import { Processor } from "../src/processor";
import { getParserErrors } from "../src/parser";

describe("Nested document symbols", () => {
    test("preserves each declaration under its immediate parent", () => {
        const text = "# test.\n[] > test\n  [] > nested\n    [] > deeper\n      42 > value\n    43 > sibling\n  44 > outer\n";
        expect(getParserErrors(text)).toEqual([]);
        const visitor = new EoDocumentSymbol();
        new Processor(text).parser.program().accept(visitor);
        const top = visitor.symbol()[0];
        expect(top.children?.map(child => child.name)).toEqual(["nested", "outer"]);
        const nested = top.children![0];
        expect(nested.children?.map(child => child.name)).toEqual(["deeper", "sibling"]);
        expect(nested.children![0].children?.map(child => child.name)).toEqual(["value"]);
        expect(nested.children![1].children).toEqual([]);
        expect(top.children![1].children).toEqual([]);
    });
});
