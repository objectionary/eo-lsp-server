// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { getParserErrors } from "../src/parser";

describe("terminator and identity objects", () => {
    test.each([
        "[] > app\n  T \"failure\" > @\n",
        "[] > app\n  T > @\n    \"failure\"\n",
        "[] > app\n  T.foo > @\n",
        "[] > app\n  I > @\n",
        "[] > app\n  I.foo 42 > @\n",
        "[] > app\n  f 42 I > @\n"
    ])("accepts %s", source => {
        expect(getParserErrors(source)).toEqual([]);
    });
    test.each([
        "[] > app\n  I 42 > @\n",
        "[] > app\n  I > @\n    42\n",
        "[] > app\n  A > @\n"
    ])("rejects %s", source => {
        expect(getParserErrors(source)).not.toEqual([]);
    });
});
