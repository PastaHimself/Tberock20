import { system, world } from "@minecraft/server";
import * as events from "../core/events.js";
import * as playerState from "./player_state.js";
import { logger } from "../core/logging.js";

// DoorTracker records every successful right-click on a Java DoorBlock. The
// custom Bedrock door definitions are ordinary blocks, so this adapter keeps
// the source state machine in one after-event handler and supplies the missing
// open/close state for those four blocks.
const CUSTOM_DOORS = new Set([
    "thebrokenscript:ud_oak_door",
    "thebrokenscript:void_door",
    "thebrokenscript:void_log_door",
    "thebrokenscript:void_plank_door",
]);
const CUSTOM_OPEN_STATE = "thebrokenscript:open";
const NATIVE_OPEN_STATE = "open_bit";
const NATIVE_UPPER_STATE = "upper_block_bit";
// Keep the serialized history below state.js's 30 KB JSON-property limit even
// when entries use long custom-dimension identifiers and signed coordinates.
const MAX_RECORDED_DOORS = 256;
const DOOR_SOUND_RANGE = 16;

let begun = false;

function isValid(value) {
    if (!value) return false;
    try { return value.isValid !== false; } catch { return false; }
}

function state(block, name) {
    try { return block?.permutation?.getState(name); } catch { return undefined; }
}

function isCustomDoor(block) {
    return CUSTOM_DOORS.has(block?.typeId);
}

export function isDoorBlock(block) {
    const id = String(block?.typeId ?? "");
    if (CUSTOM_DOORS.has(id)) return true;
    // Do not classify trapdoors as doors. This also keeps the test independent
    // of whether a particular vanilla wood family is exposed through tags.
    return id.endsWith("_door") && !id.endsWith("_trapdoor");
}

export function isOpenDoor(block) {
    if (!isDoorBlock(block)) return false;
    const customState = state(block, CUSTOM_OPEN_STATE);
    if (typeof customState === "boolean") return customState;
    return state(block, NATIVE_OPEN_STATE) === true;
}

function setOpenState(block, open) {
    if (!isDoorBlock(block)) return false;
    const stateName = isCustomDoor(block) ? CUSTOM_OPEN_STATE : NATIVE_OPEN_STATE;
    let permutation;
    try {
        permutation = block.permutation.withState(stateName, open === true);
        block.setPermutation(permutation);
        return true;
    } catch (error) {
        // A stale block handle or an older world containing a definition that
        // predates the state is not allowed to turn into a destructive fallback.
        logger.debug(`door_runtime: cannot set ${block?.typeId ?? "unknown"} ${stateName}: ${String(error)}`);
        return false;
    }
}

function nativeHalfPartner(block) {
    const upper = state(block, NATIVE_UPPER_STATE);
    if (typeof upper !== "boolean") return undefined;
    const yOffset = upper ? -1 : 1;
    try {
        const partner = block.dimension.getBlock({
            x: block.location.x,
            y: block.location.y + yOffset,
            z: block.location.z,
        });
        if (!partner || partner.typeId !== block.typeId) return undefined;
        if (state(partner, NATIVE_UPPER_STATE) !== !upper) return undefined;
        return partner;
    } catch {
        return undefined;
    }
}

function playDoorSound(block, open) {
    if (!block?.location || !block.dimension) return;
    // DoorBlock.setOpen emits the vanilla level event. Bedrock custom blocks
    // have no equivalent block-set sound callback, so deliver the closest
    // wooden/iron cue only to players in the same source range.
    const isStoneDoor = block.typeId === "thebrokenscript:void_door" || block.typeId === "minecraft:iron_door";
    const sound = `${open ? "open" : "close"}.${isStoneDoor ? "iron" : "wooden"}_door`;
    try {
        for (const player of world.getAllPlayers()) {
            if (!isValid(player) || player.dimension?.id !== block.dimension.id) continue;
            const dx = player.location.x - block.location.x;
            const dy = player.location.y - block.location.y;
            const dz = player.location.z - block.location.z;
            if (dx * dx + dy * dy + dz * dz > DOOR_SOUND_RANGE ** 2) continue;
            try { player.playSound(sound, { volume: 1, pitch: 1 }); } catch {}
        }
    } catch (error) {
        logger.debug(`door_runtime: sound '${sound}' failed: ${String(error)}`);
    }
}

/**
 * Opens a closed DoorBlock-equivalent, including both halves of a native
 * Bedrock door. Returns false for an already-open/non-door/invalid block.
 */
export function openDoorBlock(block) {
    if (!isDoorBlock(block) || isOpenDoor(block)) return false;
    const changed = setOpenState(block, true);
    if (!changed) return false;

    // Custom doors intentionally have no upper_block_bit. The Java VoidDoor
    // special case is a second, separate door 24 blocks above, handled by the
    // player interaction path below rather than by this half-pairing helper.
    const partner = nativeHalfPartner(block);
    if (partner) setOpenState(partner, true);
    playDoorSound(block, true);
    return true;
}

function toggleCustomDoor(block) {
    if (!isCustomDoor(block)) return false;
    const nextOpen = !isOpenDoor(block);
    if (!setOpenState(block, nextOpen)) return false;

    // VoidDoorBlock.useWithoutItem mirrors the resulting state to a second
    // void_door at exactly +24 Y, and only in protected_void.
    if (block.typeId === "thebrokenscript:void_door" &&
        block.dimension?.id === "thebrokenscript:protected_void") {
        try {
            const counterpart = block.dimension.getBlock({
                x: block.location.x,
                y: block.location.y + 24,
                z: block.location.z,
            });
            if (counterpart?.typeId === block.typeId && setOpenState(counterpart, nextOpen)) {
                playDoorSound(counterpart, nextOpen);
            }
        } catch (error) {
            logger.debug(`door_runtime: protected_void counterpart unavailable: ${String(error)}`);
        }
    }
    playDoorSound(block, nextOpen);
    return true;
}

function recordPlayerDoor(player, block) {
    if (!isValid(player) || !isDoorBlock(block)) return;
    const location = block.location;
    const entry = {
        dimension: block.dimension?.id ?? player.dimension?.id ?? "minecraft:overworld",
        x: Math.floor(location.x),
        y: Math.floor(location.y),
        z: Math.floor(location.z),
    };
    try {
        const previous = playerState.getJSON(player, "doors");
        const entries = Array.isArray(previous) ? previous.filter((value) => value && typeof value === "object") : [];
        entries.push(entry);
        // The Java list is later deduplicated by DoorEvent. Bedrock JSON
        // properties have a finite payload budget, so keep the same useful
        // recent-history semantics without allowing an unbounded list to break
        // all player persistence.
        playerState.setJSON(player, "doors", entries.slice(-MAX_RECORDED_DOORS));
    } catch (error) {
        logger.error("door_runtime: failed to record player door", error);
    }
}

function onPlayerInteract(event) {
    const block = event?.block;
    const player = event?.player;
    if (!block || !isDoorBlock(block)) return;

    // The source records the right-click before the random DoorEvent can use
    // it. The after-event is already successful; defer only custom-block
    // mutation so the event's block handle is not mutated in its callback.
    recordPlayerDoor(player, block);
    if (!isCustomDoor(block)) return;
    try {
        system.run(() => {
            if (!isValid(player) || !block?.dimension || !isValid(block.dimension)) return;
            toggleCustomDoor(block);
        });
    } catch (error) {
        logger.error("door_runtime: failed to schedule custom door toggle", error);
    }
}

export function begin() {
    if (begun) return;
    begun = true;
    events.subscribeGuarded(
        world.afterEvents.playerInteractWithBlock,
        "door-runtime.interact",
        "doors",
        onPlayerInteract,
    );
}

export const sourceDoorIds = Object.freeze([...CUSTOM_DOORS]);
