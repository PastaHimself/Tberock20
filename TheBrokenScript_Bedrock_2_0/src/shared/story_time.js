import { world } from "@minecraft/server";
import * as state from "../core/state.js";
import { logger } from "../core/logging.js";

const KEY = "storyTime";

const thresholds = new Map();

export function getTime() {
    return state.getWorld(KEY, 0);
}

export function addSkippedTime(ticks) {
    if (ticks < 0) throw new Error("story_time: cannot rewind");
    state.setWorld(KEY, getTime() + ticks);
}

export function registerThreshold(threshold, eventId, action) {
    let list = thresholds.get(threshold);
    if (list === undefined) {
        list = [];
        thresholds.set(threshold, list);
    }
    if (list.some((e) => e.id === eventId)) {
        throw new Error(`story_time: duplicate threshold registration ${eventId}@${threshold}`);
    }
    list.push({ id: eventId, action });
}

export function begin(scheduler) {
    scheduler.every("tbs.storyClock", 1, onTick);
    logger.debug("story clock started");
}

function onTick() {
    if (world.getAllPlayers().length === 0) {
        return;
    }
    const next = getTime() + 1;
    state.setWorld(KEY, next);
    fire(next);
}

function fire(time) {
    const due = thresholds.get(time);
    if (due === undefined) return;
    for (const entry of due) {
        try {
            entry.action(time);
        } catch (err) {
            logger.error(`story event '${entry.id}' failed`, err);
        }
    }
}
