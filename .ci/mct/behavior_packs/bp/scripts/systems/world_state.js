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
const FIRST_JOIN_TIMER_TICKS = 18000;
const FIRST_JOIN_COORDINATE_KEYS = Object.freeze([
    "clanVoidX", "clanVoidZ", "mazeFloorX", "mazeFloorZ", "woodenFloorX", "woodenFloorZ",
    "stoneFloorX", "stoneFloorZ", "dayAX", "dayAZ",
]);
const CODE_SYMBOLS = "$%-_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

function randomFirstJoinCoordinate() {
    const magnitude = Math.floor(Math.random() * 26) * 16;
    return Math.random() < 0.5 ? -magnitude : magnitude;
}

function randomFirstJoinCode() {
    const length = 6 + Math.floor(Math.random() * 7);
    return Array.from({ length }, () => CODE_SYMBOLS[Math.floor(Math.random() * CODE_SYMBOLS.length)]).join("");
}

export function init() {
    applySchemaDefaults(
        { ...WORLD_STATE_SCHEMA, ...WORLD_EXTRA_SCHEMA },
        (key) => state.getWorld(`mv.${key}`, undefined),
        (key, value) => state.setWorld(`mv.${key}`, value),
    );
}

export function resetOnPlayerJoin(player) {
    void player;
    if (get("isNullHere")) return;

    for (const key of ["hasCircuitSpawned", "hasSiluetSpawned", "hasNullSpawned", "hasVoidSpawned"]) {
        set(key, false);
    }

    if (get("isFirstJoin") && get("firstJoinTimer") === 0 && !get("joinTimerTicking")) {
        set("firstJoinTimer", FIRST_JOIN_TIMER_TICKS);
        set("joinTimerTicking", true);
        for (const key of FIRST_JOIN_COORDINATE_KEYS) set(key, randomFirstJoinCoordinate());
        set("code", randomFirstJoinCode());
    }
}

export function tickFirstJoin(playerCount) {
    if (playerCount <= 0 || get("firstJoinTimer") <= 0) return false;
    const next = Math.max(0, get("firstJoinTimer") - 1);
    set("firstJoinTimer", next);
    if (next !== 0 || get("scheduled")) return false;
    set("isFirstJoin", false);
    set("isNullHere", true);
    set("scheduled", true);
    return true;
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
