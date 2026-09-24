import * as operationDiagnostics from "./operation_diagnostics.js";
import { world } from "@minecraft/server";
import { migrateCoreSchema } from "./persistence_schema.js";

const NS = "tbs";
// audit: adapter cap; Bedrock dynamic-property payloads need a bounded JSON size.
const MAX_JSON_BYTES = 30000;

function key(scope, name) {
    return `${NS}:${scope}:${name}`;
}

function isVector3(value) {
    return value !== null && typeof value === "object" &&
        Number.isFinite(value.x) && Number.isFinite(value.y) && Number.isFinite(value.z);
}

function checkValue(value) {
    const t = typeof value;
    if (t === "string" || t === "boolean") return;
    if (t === "number" && Number.isFinite(value)) return;
    if (isVector3(value)) return;
    throw new Error(`state: unsupported value type '${t}' (use JSON helpers for objects)`);
}

function setDynamic(target, propertyKey, value) {
    if (value === undefined) {
        target.setDynamicProperty(propertyKey, undefined);
        return;
    }
    checkValue(value);
    target.setDynamicProperty(propertyKey, value);
}

let initialized = false;

export function init() {
    const now = Date.now();
    const currentSchema = world.getDynamicProperty(key("meta", "schema"));
    migrateCoreSchema(
        currentSchema,
        (name, value) => world.setDynamicProperty(key("meta", name), value),
        now,
        world.getDynamicProperty(key("meta", "firstInit")) === undefined,
    );
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
    setDynamic(world, key("w", name), value);
}

export function removeWorld(name) {
    world.setDynamicProperty(key("w", name), undefined);
}

export function getWorldJSON(name, fallback = undefined) {
    const raw = world.getDynamicProperty(key("wj", name));
    if (typeof raw !== "string") return fallback;
    try {
        return JSON.parse(raw);
    } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.core.state.js.71", "best-effort Bedrock API fallback", error);
        world.setDynamicProperty(key("wj", name), undefined);
        return fallback;
    }
}

export function setWorldJSON(name, value) {
    if (value === undefined) {
        world.setDynamicProperty(key("wj", name), undefined);
        return;
    }
    const raw = JSON.stringify(value);
    if (raw === undefined) {
        throw new Error(`state: JSON payload for '${name}' is not serializable`);
    }
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
    setDynamic(player, key("p", name), value);
}

export function removePlayer(player, name) {
    player.setDynamicProperty(key("p", name), undefined);
}

export function getPlayerJSON(player, name, fallback = undefined) {
    const raw = player.getDynamicProperty(key("pj", name));
    if (typeof raw !== "string") return fallback;
    try {
        return JSON.parse(raw);
    } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.core.state.js.110", "best-effort Bedrock API fallback", error);
        player.setDynamicProperty(key("pj", name), undefined);
        return fallback;
    }
}

export function setPlayerJSON(player, name, value) {
    if (value === undefined) {
        player.setDynamicProperty(key("pj", name), undefined);
        return;
    }
    const raw = JSON.stringify(value);
    if (raw === undefined) {
        throw new Error(`state: JSON payload for '${name}' is not serializable`);
    }
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
