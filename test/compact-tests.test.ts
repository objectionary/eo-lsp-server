// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { getParserErrors } from "../src/parser";

describe("compact test markers", () => {
    test.each([
        "[] > app\n  42.eq 42 ++> works\n",
        "[] > app\n  1.div 0 --> stops\n",
        "[] > app\n  1.div 0 > [] -> stops\n",
        "[] > app\n  42.eq 42 > [] +> works\n",
        "[] > app\n  ++> works\n    42 > @\n",
        "[] > app\n  --> stops\n    1.div 0 > @\n",
        "[] > app\n  -- > empty\n"
    ])("accepts %s", source => {
        expect(getParserErrors(source)).toEqual([]);
    });
    test.each([
        "[] > app\n  42 + +> works\n",
        "[] > app\n  42 -- > stops\n",
        "[] > app\n  42 ++>\n",
        "[] > app\n  [x] ++> invalid\n"
    ])("rejects %s", source => {
        expect(getParserErrors(source)).not.toEqual([]);
    });
});
