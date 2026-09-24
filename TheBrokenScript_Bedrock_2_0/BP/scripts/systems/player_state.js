import * as state from "../core/state.js";
import {
    PLAYER_COMPATIBILITY_DEFAULTS,
    PLAYER_DYNAMIC_DEFAULTS,
    PLAYER_EXTRA_DEFAULTS,
    PLAYER_EXTRA_SCHEMA,
    PLAYER_JSON_DEFAULTS,
    PLAYER_STATE_SCHEMA,
    applySchemaDefaults,
} from "../core/persistence_schema.js";

const DEFAULTS = { ...PLAYER_DYNAMIC_DEFAULTS, ...PLAYER_EXTRA_DEFAULTS, ...PLAYER_COMPATIBILITY_DEFAULTS };
const DYNAMIC_SCHEMA = Object.fromEntries(
    Object.entries({ ...PLAYER_STATE_SCHEMA, ...PLAYER_EXTRA_SCHEMA })
        .filter(([, descriptor]) => descriptor.storage === "dynamic"),
);
const JSON_SCHEMA = Object.fromEntries(
    Object.entries(PLAYER_STATE_SCHEMA)
        .filter(([, descriptor]) => descriptor.storage === "json"),
);

const LEGACY_PLAYER_PROPERTIES = Object.freeze({
    ban: "tbs:ban",
    fixPos: "tbs:fixPos",
    skipFallDamage: "tbs:skipFallDamage",
    triangleKickTimer: "tbs:triangleKickTimer",
});

const LEGACY_VECTOR_FIELDS = Object.freeze({
    spawnPos: ["spawnPosX", "spawnPosY", "spawnPosZ"],
    customSkyColor: ["customSkyR", "customSkyG", "customSkyB"],
});

export const MOON_GLITCH_DURATION_SECS = 80;
export const MOON_GLITCH_DURATION_TICKS = 1600;

export function init(player) {
    migrateLegacyPlayerState(player);
    applySchemaDefaults(
        DYNAMIC_SCHEMA,
        (key) => state.getPlayer(player, `pv.${key}`, undefined),
        (key, value) => state.setPlayer(player, `pv.${key}`, value),
    );
    applySchemaDefaults(
        JSON_SCHEMA,
        (key) => state.getPlayerJSON(player, `pv.${key}`, undefined),
        (key, value) => state.setPlayerJSON(player, `pv.${key}`, value),
    );
}

const LUCID_DIMENSION_ID = "thebrokenscript:lucid";

export function resetLifecycleState(player, initialSpawn) {
    if (initialSpawn) {
        if (get(player, "showCoords")) set(player, "showCoords", false);
        if (get(player, "musicCausedByTBS")) set(player, "musicCausedByTBS", false);
        if (get(player, "glitchesEnabled")) set(player, "glitchesEnabled", false);
        return;
    }

    if (get(player, "pixelateEnabled") && player.dimension?.id !== LUCID_DIMENSION_ID) {
        set(player, "pixelateEnabled", false);
    }
}

export function migrateLegacyPlayerState(player) {
    for (const [canonicalKey, legacyKey] of Object.entries(LEGACY_PLAYER_PROPERTIES)) {
        const canonical = state.getPlayer(player, `pv.${canonicalKey}`, undefined);
        if (canonical !== undefined) continue;
        const legacy = player.getDynamicProperty(legacyKey);
        if (legacy !== undefined) state.setPlayer(player, `pv.${canonicalKey}`, legacy);
    }

    for (const [canonicalKey, legacyKeys] of Object.entries(LEGACY_VECTOR_FIELDS)) {
        const canonical = state.getPlayer(player, `pv.${canonicalKey}`, undefined);
        if (canonical !== undefined) continue;
        const values = legacyKeys.map((key) => state.getPlayer(player, `pv.${key}`, undefined));
        if (!values.some((value) => value !== undefined)) continue;
        const numbers = values.map((value) => {
            const number = Number(value);
            return Number.isFinite(number) ? number : 0;
        });
        state.setPlayer(player, `pv.${canonicalKey}`, {
            x: numbers[0],
            y: numbers[1],
            z: numbers[2],
        });
    }
}

export function get(player, key) {
    const v = state.getPlayer(player, `pv.${key}`, undefined);
    if (v === undefined) {
        if (!(key in DEFAULTS)) throw new Error(`player_state: unknown key '${key}'`);
        return DEFAULTS[key];
    }
    return v;
}

export function set(player, key, value) {
    if (!(key in DEFAULTS)) throw new Error(`player_state: unknown key '${key}'`);
    state.setPlayer(player, `pv.${key}`, value);
}

export function getJSON(player, key) {
    if (!(key in PLAYER_JSON_DEFAULTS)) throw new Error(`player_state: unknown JSON key '${key}'`);
    return state.getPlayerJSON(player, `pv.${key}`, PLAYER_JSON_DEFAULTS[key]);
}

export function setJSON(player, key, value) {
    if (!(key in PLAYER_JSON_DEFAULTS)) throw new Error(`player_state: unknown JSON key '${key}'`);
    state.setPlayerJSON(player, `pv.${key}`, value);
}

export function update(player, key, fn) {
    set(player, key, fn(get(player, key)));
}

export function isMetaParanoia(player) {
    return (
        get(player, "forceMetaParanoia") ||
        get(player, "isDesync") ||
        get(player, "lookedAtOblit")
    );
}

export function setMoonGlitch(player, enabled) {
    set(player, "moonGlitchDuration", enabled ? MOON_GLITCH_DURATION_TICKS : 0);
}
