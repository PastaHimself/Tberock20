import { world, system, ItemStack } from "@minecraft/server";
import { logger } from "../core/logging.js";
import * as storyTime from "../shared/story_time.js";
import {
    STORY_EVENT_THRESHOLDS,
    validateStoryEventActions,
} from "../shared/story_clock_model.js";
import * as worldState from "./world_state.js";
import * as playerState from "./player_state.js";
import {
    createSignedNullBook,
    distributeNullBook,
} from "./story_book_adapter.js";

const MAX_NULL_BOOK_RETRIES = 20;
let nullBookRetryScheduled = false;

const STORY_EVENT_ACTIONS = Object.freeze({
    txt_story_5: onTxtHint,
    txt_story_10: onTxtHint,
    txt_story_15: onTxtHint,
    txt_story_20: onTxtHint,
    coords_hint_6: onCoordsHint,
    null_book_hint: onNullBook,
    moon_corruption_24: onMoonCorruption,
    moon_corruption_32: onMoonCorruption,
    moon_corruption_38: onMoonCorruption,
    moon_corruption_48: onMoonCorruption,
});

export function registerAll() {
    const actions = validateStoryEventActions(STORY_EVENT_ACTIONS);
    for (const { eventId, threshold } of STORY_EVENT_THRESHOLDS) {
        storyTime.registerThreshold(threshold, eventId, actions[eventId]);
    }
}

function scheduleNullBookRetry(attempt) {
    if (attempt >= MAX_NULL_BOOK_RETRIES || nullBookRetryScheduled) return;
    try {
        if (typeof system.runTimeout !== "function") {
            logger.error("null_book_hint cannot schedule a retry: runTimeout is unavailable");
            return;
        }
        nullBookRetryScheduled = true;
        system.runTimeout(() => {
            nullBookRetryScheduled = false;
            onNullBook(attempt + 1);
        }, 1);
    } catch (err) {
        logger.error("null_book_hint retry scheduling failed", err);
    }
}

function onNullBook(attempt = 0) {
    if (worldState.get("nullBookGiven")) return;
    let item;
    try {
        item = createSignedNullBook(
            ItemStack,
            worldState.get("clanVoidX"),
            worldState.get("clanVoidZ"),
        );
    } catch (err) {
        logger.error("null_book_hint book creation failed", err);
        scheduleNullBookRetry(attempt);
        return;
    }
    if (!item) {
        logger.error("null_book_hint book component is unavailable");
        scheduleNullBookRetry(attempt);
        return;
    }

    let players;
    try {
        players = world.getAllPlayers();
    } catch (err) {
        logger.error("null_book_hint player lookup failed", err);
        scheduleNullBookRetry(attempt);
        return;
    }
    if (players.length === 0) {
        scheduleNullBookRetry(attempt);
        return;
    }

    let pending = false;
    for (const player of players) {
        if (playerState.get(player, "nullBookDelivered")) continue;
        if (distributeNullBook(player, item)) {
            playerState.set(player, "nullBookDelivered", true);
        } else {
            pending = true;
            logger.warn(`null_book_hint delivery pending for player ${player.id ?? player.name ?? "unknown"}`);
        }
    }
    if (pending) {
        scheduleNullBookRetry(attempt);
        return;
    }
    worldState.set("nullBookGiven", true);
}

function onTxtHint() {
    for (const player of world.getAllPlayers()) {
        if (playerState.get(player, "sawTxtHint")) continue;
        const dir = String(playerState.get(player, "userDir")).replace(/\\/g, "/");
        player.onScreenDisplay.setTitle("err.file");
        player.onScreenDisplay.setActionBar(dir);
        playerState.set(player, "sawTxtHint", true);
    }
}

function onCoordsHint() {
    for (const player of world.getAllPlayers()) {
        playerState.set(player, "showCoords", true);
    }
}

function onMoonCorruption() {
    if (worldState.get("hasMoonCorrupted")) return;
    worldState.update("moonStage", (n) => n + 1);
    worldState.set("moonShouldChange", false);
}
