import { world } from "@minecraft/server";
import * as storyTime from "../shared/story_time.js";
import * as worldState from "./world_state.js";
import * as playerState from "./player_state.js";

const DAY = 24000;
const OFFSET = 1000;

export function registerAll() {
    storyTime.registerThreshold(DAY * 5 + OFFSET, "txt_story_5", onTxtHint);
    storyTime.registerThreshold(DAY * 10 + OFFSET, "txt_story_10", onTxtHint);
    storyTime.registerThreshold(DAY * 15 + OFFSET, "txt_story_15", onTxtHint);
    storyTime.registerThreshold(DAY * 20 + OFFSET, "txt_story_20", onTxtHint);
    storyTime.registerThreshold(DAY * 6 + OFFSET, "coords_hint_6", onCoordsHint);
    for (const d of [24, 32, 38, 48]) {
        storyTime.registerThreshold(DAY * d + OFFSET, `moon_corruption_${d}`, onMoonCorruption);
    }
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
