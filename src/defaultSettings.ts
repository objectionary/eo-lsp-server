// SPDX-FileCopyrightText: Copyright (c) 2024-2026 Objectionary.com
// SPDX-License-Identifier: MIT

/**
 * Default setting properties for the Language Server
 * @module DefaultSettings
 */
export interface DefaultSettings {
    limit: number;
}

/**
 * The settings used when the client supplies none.
 */
export const defaultSettings: DefaultSettings = { limit: 1000 };

/**
 * Completes a raw workspace configuration into full settings, filling every
 * field the client omitted (such as limit) from the defaults.
 * @param config - The raw "eo" configuration object from the client, or anything
 * @returns - Settings with every field present
 */
export function settings(config: unknown): DefaultSettings {
    const partial = config && typeof config === "object" ? config as Partial<DefaultSettings> : {};
    return { ...defaultSettings, ...partial };
}
