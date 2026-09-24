import { world, system, ItemStack } from "@minecraft/server";
import * as storyTime from "../shared/story_time.js";
import {
    STORY_EVENT_THRESHOLDS,
    validateStoryEventActions,
} from "../shared/story_clock_model.js";
import * as worldState from "./world_state.js";
import * as playerState from "./player_state.js";

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

const MAX_NULL_BOOK_RETRIES = 20;
let nullBookRetryScheduled = false;

export function registerAll() {
    const actions = validateStoryEventActions(STORY_EVENT_ACTIONS);
    for (const { eventId, threshold } of STORY_EVENT_THRESHOLDS) {
        storyTime.registerThreshold(threshold, eventId, actions[eventId]);
    }
}

function scheduleNullBookRetry(attempt) {
    if (attempt >= MAX_NULL_BOOK_RETRIES || nullBookRetryScheduled) return;
    if (typeof system.runTimeout !== "function") return;
    nullBookRetryScheduled = true;
    try {
        system.runTimeout(() => {
            nullBookRetryScheduled = false;
            onNullBook(attempt + 1);
        }, 1);
    } catch {
        nullBookRetryScheduled = false;
    }
}

// NULL_BOOK_CONTENT lang line: event.$$.null_book.text
const NULL_BOOK_PAGE1 =
    "§0null.err.object.err.null.object.alone.3.not.behind.entitytype:player.receiveddata.invalid.reboot.failed.reset.playerdata:00F9219492D94210F812";

function onNullBook(attempt = 0) {
    if (worldState.get("nullBookGiven")) return;
    const players = world.getAllPlayers();
    if (players.length === 0) {
        scheduleNullBookRetry(attempt);
        return;
    }
    // clanVoid coords as binary pages (source builds from MapVariables clanVoidX/Z; INT_MAX = unset)
    const cvx = worldState.get("clanVoidX");
    const cvz = worldState.get("clanVoidZ");
    const bin = (v) => {
        if (v === undefined || v >= 2147483647) return "?";
        return v < 0 ? "-" + Math.abs(v).toString(2) : v.toString(2);
    };
    const page2 = `X: ${bin(cvx)}  Y: 201  Z: ${bin(cvz)}  CV`;
    let pending = false;
    for (const player of players) {
        if (playerState.get(player, "nullBookDelivered")) continue;
        let delivered = false;
        try {
            const inv = player.getComponent("minecraft:inventory");
            const container = inv?.container;
            if (container) {
                container.addItem(new ItemStack("minecraft:writable_book", 1));
                delivered = true;
            }
        } catch {}
        try {
            player.sendMessage("§8[null] §0" + NULL_BOOK_PAGE1);
            player.sendMessage("§8[null] §f" + page2);
            player.onScreenDisplay.setTitle("§knull§r.book", { fadeInDuration: 5, stayDuration: 30, fadeOutDuration: 10 });
            delivered = true;
        } catch {}
        if (delivered) playerState.set(player, "nullBookDelivered", true);
        else pending = true;
    }
    if (!pending) worldState.set("nullBookGiven", true);
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
