// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

import { settings, defaultSettings } from "../src/defaultSettings";

describe("settings from a raw configuration", () => {
    test("fills the limit from defaults when the config omits it", () => {
        expect(settings({}).limit).toBe(defaultSettings.limit);
    });
    test("fills the limit when the config carries only unrelated keys", () => {
        expect(settings({ tabWidth: 4 }).limit).toBe(defaultSettings.limit);
    });
    test("keeps the limit the config provides", () => {
        expect(settings({ limit: 7 }).limit).toBe(7);
    });
    test("falls back to defaults when the config is not an object", () => {
        expect(settings(undefined).limit).toBe(defaultSettings.limit);
    });
    test("falls back to defaults when the config is a primitive", () => {
        expect(settings(5).limit).toBe(defaultSettings.limit);
    });
});
