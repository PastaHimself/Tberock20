import { world } from "@minecraft/server";
import * as state from "../core/state.js";
import { logger } from "../core/logging.js";
import { evaluateStoryClockTick } from "./story_clock_model.js";

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
    const doDayLightCycle = world.gameRules.doDayLightCycle;
    // Java StoryEvents.tick() pauses the whole story dispatcher when the
    // daylight cycle is disabled.
    if (doDayLightCycle !== true) {
        return;
    }
    const currentTime = getTime();
    const tick = evaluateStoryClockTick(
        currentTime,
        world.getAllPlayers().length,
        doDayLightCycle,
    );
    if (!tick.shouldDispatch) return;
    if (tick.nextTime !== currentTime) {
        state.setWorld(KEY, tick.nextTime);
    }
    fire(tick.nextTime);
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
