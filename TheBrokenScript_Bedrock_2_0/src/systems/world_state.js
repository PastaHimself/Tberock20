import * as state from "../core/state.js";

export const INT_MAX = 2147483647;

import {
    WORLD_EXTRA_SCHEMA,
    WORLD_STATE_SCHEMA,
    WORLD_DEFAULTS,
    WORLD_EXTRA_DEFAULTS,
    applySchemaDefaults,
} from "../core/persistence_schema.js";

const DEFAULTS = { ...WORLD_DEFAULTS, ...WORLD_EXTRA_DEFAULTS };

export function init() {
    applySchemaDefaults(
        { ...WORLD_STATE_SCHEMA, ...WORLD_EXTRA_SCHEMA },
        (key) => state.getWorld(`mv.${key}`, undefined),
        (key, value) => state.setWorld(`mv.${key}`, value),
    );
}

export function get(key) {
    const v = state.getWorld(`mv.${key}`, undefined);
    if (v === undefined) {
        if (!(key in DEFAULTS)) throw new Error(`world_state: unknown key '${key}'`);
        return DEFAULTS[key];
    }
    return v;
}

export function set(key, value) {
    if (!(key in DEFAULTS)) throw new Error(`world_state: unknown key '${key}'`);
    state.setWorld(`mv.${key}`, value);
}

export function update(key, fn) {
    set(key, fn(get(key)));
}
