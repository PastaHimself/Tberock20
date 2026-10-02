import { system } from "@minecraft/server";

const readyAt = new Map();

export function isReady(key) {
    const t = readyAt.get(key);
    return t === undefined || system.currentTick >= t;
}

export function start(key, ticks) {
    readyAt.set(key, system.currentTick + ticks);
}

export function remaining(key) {
    const t = readyAt.get(key);
    if (t === undefined) return 0;
    return Math.max(0, t - system.currentTick);
}

export function clear(key) {
    readyAt.delete(key);
}
