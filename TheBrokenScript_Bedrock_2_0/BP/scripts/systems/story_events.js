import { world, system, ItemStack } from "@minecraft/server";
import { logger } from "../core/logging.js";
import * as storyTime from "../shared/story_time.js";
import * as worldState from "./world_state.js";
import * as playerState from "./player_state.js";
import {
    createSignedNullBook,
    distributeNullBook,
} from "./story_book_adapter.js";

const DAY = 24000;
const OFFSET = 1000;
const MAX_NULL_BOOK_RETRIES = 20;
const deliveredNullBookPlayers = new Set();
let nullBookRetryScheduled = false;

export function registerAll() {
    storyTime.registerThreshold(DAY * 5 + OFFSET, "txt_story_5", onTxtHint);
    storyTime.registerThreshold(DAY * 10 + OFFSET, "txt_story_10", onTxtHint);
    storyTime.registerThreshold(DAY * 15 + OFFSET, "txt_story_15", onTxtHint);
    storyTime.registerThreshold(DAY * 20 + OFFSET, "txt_story_20", onTxtHint);
    storyTime.registerThreshold(DAY * 6 + OFFSET, "coords_hint_6", onCoordsHint);
    for (const d of [24, 32, 38, 48]) {
        storyTime.registerThreshold(DAY * d + OFFSET, `moon_corruption_${d}`, onMoonCorruption);
    }
    // NullBookStoryEvent: days(12)+1000 — gives every online player the signed "null" book.
    storyTime.registerThreshold(DAY * 12 + OFFSET, "null_book_hint", onNullBook);
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
        const playerKey = player.id ?? player;
        if (deliveredNullBookPlayers.has(playerKey)) continue;
        if (distributeNullBook(player, item)) {
            deliveredNullBookPlayers.add(playerKey);
        } else {
            pending = true;
            logger.warn(`null_book_hint delivery pending for player ${playerKey}`);
        }
    }
    if (pending) {
        scheduleNullBookRetry(attempt);
        return;
    }
    deliveredNullBookPlayers.clear();
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
