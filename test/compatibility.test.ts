// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

describe("Node.js version compatibility", () => {
    test("current Node.js version meets minimum requirement", () => {
        const currentVersion = process.version;
        const versionMatch = currentVersion.match(/^v(\d+)\.(\d+)\.(\d+)/u);
        if (!versionMatch) {
            throw new Error(`Invalid Node.js version format: ${currentVersion}`);
        }
        const major = parseInt(versionMatch[1], 10);
        const isCompatible = major >= 14;
        expect(isCompatible).toBe(true);
    });

    test("optional chaining operator is supported", () => {
        const obj = { a: { b: "value" } };
        const result = obj?.a?.b;
        expect(result).toBe("value");
    });

    test("nullish coalescing operator is supported", () => {
        const value = null ?? "default";
        expect(value).toBe("default");
    });
});
