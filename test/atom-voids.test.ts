// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { getParserErrors } from "../src/parser";

describe("typed atom signatures and vertical voids", () => {
    test.each([
        "[] > app\n  ? > x\n  ? > ^\n  x > @\n",
        "[] > app\n  ? > x\n",
        "[] > @ /Q.win32.return\n  ? > ^\n",
        "[] > test /number\n  ? > value /A?\n  ? > next /{Q.string B}\n",
        "[] > app /Q.pair(A,Q.bytes)\n  ? > @\n",
        "[] > app /A\n"
    ])("accepts %s", source => {
        expect(getParserErrors(source)).toEqual([]);
    });
    test.each([
        "[] > app\n  x > @\n  ? > value\n",
        "[] > app\n  ? >> handle\n",
        "[] > app\n  ? > @\n",
        "[] > app\n  ? > typed /A\n",
        "[] > app\n  ? > x!\n",
        "[] > app\n  ? > x\n    42\n",
        "[x] > test /number\n",
        "[] > test /Q\n",
        "[] > test /A?\n",
        "[] > test /Q.pair(Q.number,)\n",
        "[] > test /number\n  ? > callback /{}\n"
    ])("rejects %s", source => {
        expect(getParserErrors(source)).not.toEqual([]);
    });
});
