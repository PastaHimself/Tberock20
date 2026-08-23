import { system } from "@minecraft/server";
import { logger } from "./logging.js";

const intervals = new Map();
const timeouts = new Map();

export function every(name, tickPeriod, fn) {
    if (intervals.has(name)) {
        throw new Error(`scheduler: interval '${name}' already registered`);
    }
    const handle = system.runInterval(() => {
        try {
            fn(system.currentTick);
        } catch (err) {
            logger.error(`scheduler interval '${name}' threw`, err);
        }
    }, tickPeriod);
    intervals.set(name, handle);
    return name;
}

export function afterTicks(name, delayTicks, fn) {
    if (timeouts.has(name)) {
        throw new Error(`scheduler: timeout '${name}' already registered`);
    }
    const handle = system.runTimeout(() => {
        timeouts.delete(name);
        try {
            fn(system.currentTick);
        } catch (err) {
            logger.error(`scheduler timeout '${name}' threw`, err);
        }
    }, delayTicks);
    timeouts.set(name, handle);
    return name;
}

export function cancelInterval(name) {
    const handle = intervals.get(name);
    if (handle === undefined) return false;
    system.clearRun(handle);
    intervals.delete(name);
    return true;
}

export function cancelTimeout(name) {
    const handle = timeouts.get(name);
    if (handle === undefined) return false;
    system.clearRun(handle);
    timeouts.delete(name);
    return true;
}

export function cancelAll() {
    for (const handle of intervals.values()) system.clearRun(handle);
    for (const handle of timeouts.values()) system.clearRun(handle);
    intervals.clear();
    timeouts.clear();
}

export function stats() {
    return { intervals: [...intervals.keys()], timeouts: [...timeouts.keys()] };
}

export function begin() {
    every("tbs.heartbeat", 100, () => {
        logger.debug(`heartbeat tick=${system.currentTick} active=${JSON.stringify(stats())}`);
    });
}
