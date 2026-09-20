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
        // audit: Java Integer.MAX_VALUE equivalent for persisted delay bounds.
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
    // Java spawn predicates use ServerLevel.getGameTime(), not time-of-day.\n    const gameTime = world.getAbsoluteTime();

    // Rules historically read players[0]. Re-ordering the shared view per
    // player keeps that contract while preventing the first player from
    // deciding every spawn in a multiplayer world. A director tick still
    // admits at most one successful rule, matching the original pacing.
    for (const player of players) {
        const scopedPlayers = [player, ...players.filter((candidate) => candidate !== player)];
        let spawned = false;
        for (const rule of rules.values()) {
            try {
                const ctx = {
                    player,
                    players: scopedPlayers,
                    gameTime,
                    frequency: eventFrequency(gameTime),
                    isNullHere: () => worldState.get("isNullHere")
                };
                if (rule.predicate(ctx) === true) {
                    spawned = true;
                    break;
                }
            } catch (err) {
                logger.error(`spawn_director rule '${rule.id}' failed`, err);
            }
        }
        if (spawned) break;
    }
}

export function begin(schedulerRef) {
    schedulerRef.every("tbs.spawnDelays", 1, decrementDelays);
    schedulerRef.every("tbs.spawnDirector", 200, evaluateAroundPlayers);
}
