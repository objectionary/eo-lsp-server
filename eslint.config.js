// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Objectionary.com
// SPDX-License-Identifier: MIT

const eslint = require("@eslint/js");
const tseslint = require("@typescript-eslint/eslint-plugin");
const tsparser = require("@typescript-eslint/parser");

module.exports = [
    {
        ignores: [
            "node_modules/**",
            "out/**",
            "src/parser/**",
            "compiled/**",
            "tsc-compiled/**",
            "dist/**",
            "bin/**",
            "coverage/**"
        ]
    },
    eslint.configs.recommended,
    {
        files: ["**/*.ts", "**/*.tsx", "**/*.js", "**/*.jsx"],
        languageOptions: {
            parser: tsparser,
            parserOptions: {
                ecmaVersion: "latest",
                sourceType: "module"
            },
            globals: {
                console: "readonly",
                process: "readonly",
                Buffer: "readonly",
                __dirname: "readonly",
                __filename: "readonly",
                exports: "writable",
                module: "writable",
                require: "readonly",
                global: "readonly",
                setTimeout: "readonly",
                clearTimeout: "readonly",
                setInterval: "readonly",
                clearInterval: "readonly"
            }
        },
        plugins: {
            "@typescript-eslint": tseslint
        },
        rules: {
            "no-undef": "off",
            "no-unused-vars": ["error", { "argsIgnorePattern": "^_", "varsIgnorePattern": "^_", "caughtErrorsIgnorePattern": "^_" }],
            semi: [2, "always"],
            "consistent-return": "off",
            "no-process-exit": "off",
            "@typescript-eslint/no-unused-vars": ["error", { "argsIgnorePattern": "^_", "varsIgnorePattern": "^_", "caughtErrorsIgnorePattern": "^_" }],
            "@typescript-eslint/no-explicit-any": 0,
            "padding-line-between-statements": "off",
            "@typescript-eslint/explicit-module-boundary-types": 0,
            "@typescript-eslint/no-non-null-assertion": 0,
            "jsdoc/require-param-type": "off",
            "jsdoc/require-returns-type": "off",
            "jsdoc/require-hyphen-before-param-description": "off",
            "jsdoc/newline-after-description": "off"
        }
    },
    {
        files: ["**/*.test.ts", "**/*.test.js", "**/*.spec.ts", "**/*.spec.js", "test/**/*.ts", "test/**/*.js"],
        languageOptions: {
            globals: {
                describe: "readonly",
                test: "readonly",
                it: "readonly",
                expect: "readonly",
                beforeEach: "readonly",
                afterEach: "readonly",
                beforeAll: "readonly",
                afterAll: "readonly",
                jest: "readonly"
            }
        }
    }
];
