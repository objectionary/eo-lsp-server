// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

import * as fs from "fs";
import * as path from "path";
import { TextDocument } from "vscode-languageserver-textdocument";
import { validateTextDocumentSafely } from "../src/document-validation";

describe("Document validation safety", () => {
    test("reports validation rejection without rethrowing", async () => {
        const document = TextDocument.create("file:///broken.eo", "eo", 1, "[] > broken\n");
        const validate = jest.fn((_document: TextDocument) => Promise.reject(new Error("settings unavailable")));
        const logger = { error: jest.fn() };

        await expect(validateTextDocumentSafely(document, validate, logger)).resolves.toBeUndefined();

        expect(validate).toHaveBeenCalledWith(document);
        expect(logger.error).toHaveBeenCalledWith(
            "Validation failed for file:///broken.eo: Error: settings unavailable"
        );
    });

    test("document content changes use safe validation", () => {
        const server = fs.readFileSync(path.join(__dirname, "..", "src", "server.ts"), "utf8");

        expect(server).toContain(
            "validateTextDocumentSafely(change.document, validateTextDocument, connection.console);"
        );
    });
});
