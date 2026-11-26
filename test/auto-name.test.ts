// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { EoDocumentSymbol } from "../src/eoDocumentSymbol";
import { Processor } from "../src/processor";
import { getParserErrors } from "../src/parser";

describe("auto-named body bindings", () => {
    test("keeps a handle readable in the document outline", () => {
        const visitor = new EoDocumentSymbol();
        new Processor("[] > app\n  x >> helper!\n").parser.program().accept(visitor);
        expect(visitor.symbol()[0].children?.map(node => node.name)).toEqual(["helper"]);
    });
    test.each([
        "[] > app\n  42 >>\n",
        "[] > app\n  42 >>!\n",
        "[] > app\n  42 >> handle\n",
        "[] > app\n  42 >> handle!\n",
        "[] > app\n  f x >> value!\n",
        "[] > app\n  [] >>!\n    42 > @\n"
    ])("accepts %s", source => {
        expect(getParserErrors(source)).toEqual([]);
    });
    test.each([
        "[] > app\n  42 >>! handle\n",
        "[] > app\n  [] >> handle /number\n",
        "[] > app\n  42 >> 1\n"
    ])("rejects %s", source => {
        expect(getParserErrors(source)).not.toEqual([]);
    });
});
