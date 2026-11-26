// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { getParserErrors } from "../src/parser";

describe("fragile dispatch", () => {
    test.each([
        "[] > app\n  x?.read > @\n",
        "[] > app\n  a.b?.c > @\n",
        "[] > app\n  read?. x > @\n",
        "[] > app\n  read?. > @\n    x\n",
        "[] > app\n  x > receiver\n  ?.read > @\n"
    ])("accepts %s", source => {
        expect(getParserErrors(source)).toEqual([]);
    });
    test.each([
        "[] > app\n  x? .read > @\n",
        "[] > app\n  x?. > @\n",
        "[] > app\n  x??.read > @\n"
    ])("rejects %s", source => {
        expect(getParserErrors(source)).not.toEqual([]);
    });
});
