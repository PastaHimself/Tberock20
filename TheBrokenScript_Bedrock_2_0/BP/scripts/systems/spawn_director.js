import { world } from "@minecraft/server";
import * as scheduler from "../core/scheduler.js";
import { logger } from "../core/logging.js";
import { config } from "../core/config.js";
import * as worldState from "./world_state.js";
import * as bossHooks from "./boss_hooks.js";
import { eventFrequency } from "./event_frequency.js";

const rules = new Map();
const activeDelays = new Set();
const DELAY_KEYS = [
    "entitySpawnDelay", "circuitSpawnDelay", "oblitSpawnDelay", "tbeSpawnDelay",
    "rareSpawnDelay", "nullSpawnDelay", "curvedSpawnDelay", "eerieNoiseDelay",
    "herobrineDelay", "circuitInhabitedDelay"
];

export function registerRule(rule) {
    if (rules.has(rule.id)) throw new Error(`spawn_director: duplicate rule '${rule.id}'`);
    if (typeof rule.predicate !== "function") throw new Error(`spawn_director: rule '${rule.id}' needs predicate`);
    rules.set(rule.id, rule);
}

export function getDelay(key) {
    return worldState.get(key);
}

export function resetDelay(key, ticks) {
    if (!DELAY_KEYS.includes(key)) throw new Error(`spawn_director: unknown delay key '${key}'`);
    worldState.set(key, ticks);
}

function decrementDelays() {
    for (const key of DELAY_KEYS) {
        const v = worldState.get(key);
        if (v > 0 && v < 2147483647) {
            worldState.set(key, v - 1);
        }
    }
}

function evaluateAroundPlayers() {
    if (config.get("danger.disableSpawningEntities")) return;
    if (bossHooks.isArenaPhase1()) return;
    const players = world.getAllPlayers();
    if (players.length === 0) return;
    for (const rule of rules.values()) {
        try {
            const ctx = {
                players,
                gameTime: world.getTimeOfDay(),
                frequency: eventFrequency(0),
                isNullHere: () => worldState.get("isNullHere")
            };
            if (rule.predicate(ctx) === true) break;
        } catch (err) {
            logger.error(`spawn_director rule '${rule.id}' failed`, err);
        }
    }
}

export function begin(schedulerRef) {
    schedulerRef.every("tbs.spawnDelays", 1, decrementDelays);
    schedulerRef.every("tbs.spawnDirector", 200, evaluateAroundPlayers);
}
