import { world } from "@minecraft/server";

const NS = "tbs";
const MAX_JSON_BYTES = 30000;

function key(scope, name) {
    return `${NS}:${scope}:${name}`;
}

function checkPrimitive(value) {
    const t = typeof value;
    if (t !== "string" && t !== "number" && t !== "boolean") {
        throw new Error(`state: unsupported value type '${t}' (use JSON helpers for objects)`);
    }
}

let initialized = false;

export function init() {
    if (world.getDynamicProperty(key("meta", "schema")) === undefined) {
        world.setDynamicProperty(key("meta", "schema"), 1);
        world.setDynamicProperty(key("meta", "firstInit"), Date.now());
    }
    world.setDynamicProperty(key("meta", "lastLoad"), Date.now());
    initialized = true;
}

export function isInitialized() {
    return initialized;
}

export function getWorld(name, fallback = undefined) {
    const v = world.getDynamicProperty(key("w", name));
    return v === undefined ? fallback : v;
}

export function setWorld(name, value) {
    checkPrimitive(value);
    world.setDynamicProperty(key("w", name), value);
}

export function getWorldJSON(name, fallback = undefined) {
    const raw = world.getDynamicProperty(key("wj", name));
    if (typeof raw !== "string") return fallback;
    try {
        return JSON.parse(raw);
    } catch {
        world.setDynamicProperty(key("wj", name), undefined);
        return fallback;
    }
}

export function setWorldJSON(name, value) {
    const raw = JSON.stringify(value);
    if (raw.length > MAX_JSON_BYTES) {
        throw new Error(`state: JSON payload for '${name}' exceeds ${MAX_JSON_BYTES} bytes (${raw.length})`);
    }
    world.setDynamicProperty(key("wj", name), raw);
}

export function getPlayer(player, name, fallback = undefined) {
    const v = player.getDynamicProperty(key("p", name));
    return v === undefined ? fallback : v;
}

export function setPlayer(player, name, value) {
    checkPrimitive(value);
    player.setDynamicProperty(key("p", name), value);
}

export function getPlayerJSON(player, name, fallback = undefined) {
    const raw = player.getDynamicProperty(key("pj", name));
    if (typeof raw !== "string") return fallback;
    try {
        return JSON.parse(raw);
    } catch {
        player.setDynamicProperty(key("pj", name), undefined);
        return fallback;
    }
}

export function setPlayerJSON(player, name, value) {
    const raw = JSON.stringify(value);
    if (raw.length > MAX_JSON_BYTES) {
        throw new Error(`state: JSON payload for '${name}' exceeds ${MAX_JSON_BYTES} bytes (${raw.length})`);
    }
    player.setDynamicProperty(key("pj", name), raw);
}

export function ensurePlayer(player) {
    if (player.getDynamicProperty(key("p", "firstSeen")) === undefined) {
        player.setDynamicProperty(key("p", "firstSeen"), Date.now());
    }
    player.setDynamicProperty(key("p", "lastSeen"), Date.now());
}

export function listKeys(prefix = "") {
    return world
        .getDynamicPropertyIds()
        .filter((id) => id.startsWith(`${NS}:${prefix}`));
}
