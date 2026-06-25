// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { TextDocument } from "vscode-languageserver-textdocument";
import { validateTextDocuments } from "../src/validation";

describe("Configuration-triggered document validation", () => {
    test("reports rejected document validations without stopping remaining validations", async () => {
        const bad = TextDocument.create("file:///bad.eo", "eo", 0, "[] > bad\n");
        const good = TextDocument.create("file:///good.eo", "eo", 0, "[] > good\n");
        const validate = jest.fn()
            .mockRejectedValueOnce(new Error("settings transport failed"))
            .mockResolvedValueOnce(undefined);
        const report = jest.fn();

        validateTextDocuments([bad, good], validate, report);
        await Promise.resolve();

        expect(validate).toHaveBeenCalledTimes(2);
        expect(validate).toHaveBeenNthCalledWith(1, bad);
        expect(validate).toHaveBeenNthCalledWith(2, good);
        expect(report).toHaveBeenCalledTimes(1);
        expect(report).toHaveBeenCalledWith(
            "Validation failed for file:///bad.eo: Error: settings transport failed"
        );
    });
});
