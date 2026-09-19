import * as operationDiagnostics from "../../core/operation_diagnostics.js";
import { BlockPermutation, EntityDamageCause, system, world } from "@minecraft/server";
import * as events from "../../core/events.js";
import { logger } from "../../core/logging.js";
import * as config from "../../core/config.js";
import * as dimensions from "../../systems/dimensions.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as gaze from "../../systems/ai/gaze.js";
import * as horrorChat from "../../systems/horror_chat.js";
import * as playerState from "../../systems/player_state.js";
import * as doorRuntime from "../../systems/door_runtime.js";
import {
    NULL_FLYING_SOURCE,
    NULL_MAZE_SOURCE,
    exactFlyingGaze,
    flyingDelayedOutcome,
    flyingProximityOutcome,
    flyingRepGainCooldownStep,
    mazeBreakPlan,
    mazeTargetMemoryStep,
    naturalDespawnStep,
} from "../../systems/null_pursuit_model.js";

const MAZE_ID = "thebrokenscript:null_maze";
const FLYING_ID = "thebrokenscript:null_flying";
const NULL_IS_HERE_ID = "thebrokenscript:null_is_here";
const NATURAL_DESPAWN_PROPERTY = "tbs:despawn_timer";
const LIGHT_BLOCK_ID = "minecraft:light_block";
const ACTIVE_TYPES = new Set([MAZE_ID, FLYING_ID]);

// The old pursuit controller owns other Null variants. This controller is
// deliberately entity-driven: one startup scan restores persisted entities,
// then entitySpawn adds new entities and every tick only visits this map.
const trackedEntities = new Map();
const mazeStates = new Map();
const flyingStates = new Map();
let begun = false;

function isValid(value) {
    if (!value) return false;
    try { return value.isValid !== false; } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.40", "best-effort Bedrock API fallback", error); return false; }
}

function isAlive(entity) {
    if (!isValid(entity)) return false;
    try {
        const health = entity.getComponent?.("minecraft:health");
        if (health && typeof health.currentValue === "number") return health.currentValue > 0;
    } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.48", "best-effort Bedrock API fallback", error);}
    return true;
}

function sameDimension(left, right) {
    return Boolean(left?.dimension?.id && right?.dimension?.id && left.dimension.id === right.dimension.id);
}

function distanceSquared(left, right) {
    if (!left || !right) return Number.POSITIVE_INFINITY;
    return (left.x - right.x) ** 2 + (left.y - right.y) ** 2 + (left.z - right.z) ** 2;
}

function copyLocation(location) {
    return location && { x: location.x, y: location.y, z: location.z };
}

function rememberEntity(entity) {
    if (!entity || !ACTIVE_TYPES.has(entity.typeId) || !isValid(entity)) return;
    trackedEntities.set(entity.id, entity);
}

function getDynamic(entity, property) {
    try { return entity.getDynamicProperty(property); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.71", "best-effort Bedrock API fallback", error); return undefined; }
}

function setDynamic(entity, property, value) {
    try {
        entity.setDynamicProperty(property, value);
        return true;
    } catch (error) {
        logger.debug(`null_source: dynamic property '${property}' unavailable: ${String(error)}`);
        return false;
    }
}

function ensureMazeState(entity) {
    let state = mazeStates.get(entity.id);
    if (!state) {
        state = {
            lastStuckPosition: { x: 0, y: 0, z: 0 },
            stuckTicks: 0,
            targetId: undefined,
            unseenTicks: 0,
            lightPosition: undefined,
            lightDimension: undefined,
            placedLight: false,
        };
        mazeStates.set(entity.id, state);
    }
    return state;
}

function ensureFlyingState(entity) {
    let state = flyingStates.get(entity.id);
    if (!state) {
        state = { triggered: false, pending: false };
        flyingStates.set(entity.id, state);
    }
    return state;
}

function ensureNaturalTimer(entity, onFirstSpawn) {
    let raw = getDynamic(entity, NATURAL_DESPAWN_PROPERTY);
    if (typeof raw !== "number" || !Number.isFinite(raw)) {
        setDynamic(entity, NATURAL_DESPAWN_PROPERTY, 3200);
        if (onFirstSpawn) onFirstSpawn();
        raw = 3200;
    }
    return Math.trunc(raw);
}

function tickNaturalTimer(entity, currentTimer) {
    const result = naturalDespawnStep(currentTimer, 3200);
    setDynamic(entity, NATURAL_DESPAWN_PROPERTY, result.timer);
    return result.discard;
}

function blockAt(dimension, location) {
    try { return dimension.getBlock(location); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.127", "best-effort Bedrock API fallback", error); return undefined; }
}

function isReplaceable(block) {
    if (!block) return false;
    try {
        if (block.isAir === true) return true;
        if (typeof block.hasTag === "function" && block.hasTag("replaceable")) return true;
    } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.135", "best-effort Bedrock API fallback", error);}
    return block.typeId === "minecraft:air";
}

function lightPermutation() {
    try {
        // Java Blocks.LIGHT.defaultBlockState() emits light level 15.
        return BlockPermutation.resolve(LIGHT_BLOCK_ID, { block_light_level: 15 });
    } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.143", "best-effort Bedrock API fallback", error);
        return undefined;
    }
}

function removeMazeLight(state, dimension) {
    if (!state?.placedLight || !state.lightPosition || !dimension) return;
    // Entity dimension changes replace entity.dimension in place. Retain the
    // previous handle so a light placed before the change is removed from the
    // old dimension rather than from the same coordinates in the new one.
    const lightDimension = state.lightDimension ?? dimension;
    const block = blockAt(lightDimension, state.lightPosition);
    try {
        if (block?.typeId === LIGHT_BLOCK_ID) block.setType("minecraft:air");
    } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.157", "best-effort Bedrock API fallback", error);}
    state.placedLight = false;
    state.lightDimension = undefined;
}

function updateMazeLight(entity, state) {
    const dimension = entity.dimension;
    const position = {
        x: Math.floor(entity.location.x),
        y: Math.floor(entity.location.y) + 1,
        z: Math.floor(entity.location.z),
    };
    if (state.lightPosition && state.lightDimension?.id === dimension?.id &&
        state.lightPosition.x === position.x && state.lightPosition.y === position.y && state.lightPosition.z === position.z) return;

    removeMazeLight(state, dimension);
    state.lightPosition = position;
    state.lightDimension = dimension;
    state.placedLight = false;
    const block = blockAt(dimension, position);
    if (!isReplaceable(block)) return;
    try {
        const permutation = lightPermutation();
        if (permutation) block.setPermutation(permutation);
        else block.setType(LIGHT_BLOCK_ID);
        state.placedLight = true;
    } catch (error) {
        logger.debug(`null_source: maze light placement failed: ${String(error)}`);
    }
}

function headLineOfSight(source, target) {
    if (!sameDimension(source, target)) return false;
    const origin = gaze.eyeLocation(source);
    const destination = gaze.eyeLocation(target);
    const delta = {
        x: destination.x - origin.x,
        y: destination.y - origin.y,
        z: destination.z - origin.z,
    };
    const distance = Math.hypot(delta.x, delta.y, delta.z);
    if (!Number.isFinite(distance)) return false;
    if (distance === 0) return true;
    const raycaster = source.dimension?.getBlockFromRay;
    if (typeof raycaster !== "function") return true;
    try {
        const length = Math.hypot(delta.x, delta.y, delta.z) || 1;
        const hit = raycaster.call(source.dimension, origin, {
            x: delta.x / length,
            y: delta.y / length,
            z: delta.z / length,
        }, {
            maxDistance: distance,
            includeLiquidBlocks: false,
            includePassableBlocks: false,
        });
        if (!hit) return true;
        if (typeof hit.distance === "number") return hit.distance >= distance;
        const block = hit.block?.location;
        if (!block) return false;
        return Math.hypot(block.x + 0.5 - origin.x, block.y + 0.5 - origin.y, block.z + 0.5 - origin.z) >= distance;
    } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.218", "best-effort Bedrock API fallback", error);
        return false;
    }
}

function playersInDimension(dimension, players) {
    return players.filter((player) => isAlive(player) && player.dimension?.id === dimension?.id);
}

function nearestPlayer(players, location, maxDistance, dimension) {
    return entityFinder.closestPlayerInRange(players, location, maxDistance, { dimension });
}

function visibleMazeTarget(entity, players) {
    const candidates = playersInDimension(entity.dimension, players)
        .filter((player) => distanceSquared(player.location, entity.location) <= NULL_MAZE_SOURCE.targetRange ** 2)
        .sort((left, right) => distanceSquared(left.location, entity.location) - distanceSquared(right.location, entity.location) || String(left.id).localeCompare(String(right.id)));
    return candidates.find((player) => headLineOfSight(entity, player));
}

function updateMazeTarget(entity, state, players) {
    const current = state.targetId
        ? players.find((player) => player.id === state.targetId && isAlive(player) && sameDimension(entity, player) &&
            distanceSquared(player.location, entity.location) <= NULL_MAZE_SOURCE.targetRange ** 2)
        : undefined;
    const candidate = current ? undefined : visibleMazeTarget(entity, players);
    const next = mazeTargetMemoryStep({
        currentTargetId: state.targetId,
        targetExists: current !== undefined,
        targetVisible: current ? headLineOfSight(entity, current) : false,
        candidateTargetId: candidate?.id,
        candidateVisible: candidate !== undefined,
        unseenTicks: state.unseenTicks,
    });
    state.targetId = next.targetId;
    state.unseenTicks = next.unseenTicks;
    return state.targetId ? players.find((player) => player.id === state.targetId && isAlive(player) && sameDimension(entity, player)) : undefined;
}

function destroyBlockWithDrops(dimension, location) {
    const command = `setblock ${location.x} ${location.y} ${location.z} air destroy`;
    try {
        dimension.runCommand(command);
        return true;
    } catch (error) {
        logger.debug(`null_source: maze block destroy failed at ${command}: ${String(error)}`);
        return false;
    }
}

function breakMazeBlocks(entity, state) {
    const facing = (() => {
        try { return entity.getViewDirection(); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.270", "best-effort Bedrock API fallback", error); return undefined; }
    })();
    const plan = mazeBreakPlan({
        blockPosition: {
            x: Math.floor(entity.location.x),
            y: Math.floor(entity.location.y),
            z: Math.floor(entity.location.z),
        },
        facing,
        stuckTicks: state.stuckTicks,
        hasTarget: state.targetId !== undefined,
        blockAt: (location) => blockAt(entity.dimension, location),
        blockBreakingDisabled: config.config.get("danger.disableBlockBreaking"),
    });
    if (!plan.resetStuck) return;
    for (const location of plan.positions) destroyBlockWithDrops(entity.dimension, location);
    // NullMazeEntity resets the counter after the non-air destroy branch even
    // when the command-backed adapter reports an individual failure.
    state.stuckTicks = 0;
}

function openMazeDoor(entity) {
    if (!entity.dimension?.getBlockFromRay) return;
    let hit;
    try {
        const direction = entity.getViewDirection();
        hit = entity.dimension.getBlockFromRay(gaze.eyeLocation(entity), direction, {
            maxDistance: NULL_MAZE_SOURCE.doorRayDistance,
            includeLiquidBlocks: false,
            includePassableBlocks: false,
        });
    } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.301", "best-effort Bedrock API fallback", error);
        return;
    }
    const block = hit?.block;
    if (!block || !doorRuntime.isDoorBlock(block) || doorRuntime.isOpenDoor(block)) return;
    doorRuntime.openDoorBlock(block);
}

function updateMazeStuck(entity, state) {
    if (state.targetId === undefined) {
        state.stuckTicks = 0;
        return;
    }
    const current = entity.location;
    if (distanceSquared(current, state.lastStuckPosition) < NULL_MAZE_SOURCE.stuckDistanceSquared) state.stuckTicks += 1;
    else state.stuckTicks = 0;
    state.lastStuckPosition = copyLocation(current);
}

function discardEntity(entity, state) {
    if (entity.typeId === MAZE_ID) removeMazeLight(state, entity.dimension);
    try { entity.remove(); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.322", "best-effort Bedrock API fallback", error);}
    trackedEntities.delete(entity.id);
    if (entity.typeId === MAZE_ID) mazeStates.delete(entity.id);
    else {
        const flying = flyingStates.get(entity.id);
        if (!flying?.pending) flyingStates.delete(entity.id);
    }
}

function tickMaze(entity, players) {
    const state = ensureMazeState(entity);
    const timer = ensureNaturalTimer(entity);
    if (tickNaturalTimer(entity, timer)) {
        discardEntity(entity, state);
        return;
    }
    updateMazeLight(entity, state);

    const target = updateMazeTarget(entity, state, players);
    if (target) {
        try { entity.lookAt?.(target.location); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.342", "best-effort Bedrock API fallback", error);}
    }
    updateMazeStuck(entity, state);
    if (state.targetId !== undefined) {
        breakMazeBlocks(entity, state);
        openMazeDoor(entity);
    }
}

function playRangeSound(dimension, location, sound, maxDistance, volume, pitch) {
    try {
        for (const player of world.getAllPlayers()) {
            if (!isAlive(player) || player.dimension?.id !== dimension?.id) continue;
            if (distanceSquared(player.location, location) > maxDistance ** 2) continue;
            try { player.playSound(sound, { volume, pitch }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.356", "best-effort Bedrock API fallback", error);}
        }
    } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.358", "best-effort Bedrock API fallback", error);}
}

function setupFlying(entity, players) {
    const dimension = entity.dimension;
    const location = copyLocation(entity.location);
    const sound = Math.random() < 0.5 ? "thebrokenscript:null_sad" : "thebrokenscript:null_sound_2";
    playRangeSound(dimension, location, sound, 420, 420, 0.01);

    const player = nearestPlayer(playersInDimension(dimension, players), location, 100, dimension);
    let targetY;
    if (player) {
        targetY = player.location.y + 25;
    } else {
        try {
            const top = dimension.getTopmostBlock({ x: location.x, z: location.z });
            const surfaceY = top?.location?.y ?? top?.y;
            targetY = (typeof surfaceY === "number" ? surfaceY + 1 : location.y) + 25;
        } catch {
            targetY = location.y + 25;
        }
    }
    try { entity.teleport({ x: location.x, y: targetY, z: location.z }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.380", "best-effort Bedrock API fallback", error);}
    try {
        entity.nameTag = "MobIsMissingID";
        entity.nameTagVisible = true;
    } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.384", "best-effort Bedrock API fallback", error);}
}

function spawnNullIsHere(entity) {
    try {
        const spawned = entity.dimension.spawnEntity(NULL_IS_HERE_ID, entity.location);
        try { spawned.setRotation({ x: 0, y: Math.random() * 360 }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.390", "best-effort Bedrock API fallback", error);}
    } catch (error) {
        logger.debug(`null_source: null_is_here summon failed: ${String(error)}`);
    }
}

function applyFlyingDamage(player, amount, source) {
    try {
        player.applyDamage(amount, { cause: EntityDamageCause.none });
    } catch {
        try { player.applyDamage(amount); } catch (error) { logger.debug(`null_source: flying damage failed: ${String(error)}`); }
    }
    void source;
}

function scheduleFlyingTrigger(entity, player, state) {
    state.pending = true;
    const initialSneaking = Boolean(player.isSneaking);
    const soundDimension = entity.dimension;
    const soundLocation = copyLocation(entity.location);
    try {
        system.runTimeout(() => {
            let repGainTimer = 0;
            try { repGainTimer = playerState.get(player, "nullFlyRepGainTimer"); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.413", "best-effort Bedrock API fallback", error);}
            const outcome = flyingDelayedOutcome({
                initialSneaking,
                currentSneaking: Boolean(player?.isSneaking),
                repGainTimer,
            });
            if (isValid(entity)) discardEntity(entity, undefined);
            if (!isValid(player)) {
                flyingStates.delete(entity.id);
                return;
            }
            if (outcome.reputationDelta !== 0) {
                try { horrorChat.changeReputation(player, outcome.reputationDelta); } catch (error) { logger.debug(`null_source: flying reputation update failed: ${String(error)}`); }
            }
            if (outcome.nextRepGainTimer !== repGainTimer) {
                try { playerState.set(player, "nullFlyRepGainTimer", outcome.nextRepGainTimer); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.428", "best-effort Bedrock API fallback", error);}
            }
            if (outcome.playHostileSound) playRangeSound(soundDimension, soundLocation, "thebrokenscript:you_know_nothing", 128, 0.35, 0.5);
            flyingStates.delete(entity.id);
        }, NULL_FLYING_SOURCE.triggerDelayTicks);
    } catch (error) {
        state.pending = false;
        logger.error("null_source: failed to schedule flying trigger", error);
    }
}

function tickFlying(entity, players) {
    const state = ensureFlyingState(entity);
    const timer = ensureNaturalTimer(entity, () => setupFlying(entity, players));

    const closest = nearestPlayer(playersInDimension(entity.dimension, players), entity.location, NULL_FLYING_SOURCE.targetRange, entity.dimension);
    if (closest) {
        try { entity.lookAt?.(closest.location); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.445", "best-effort Bedrock API fallback", error);}
        if (!state.triggered) {
            const candidates = playersInDimension(entity.dimension, players)
                .filter((player) => distanceSquared(player.location, entity.location) <= NULL_FLYING_SOURCE.gazeRange ** 2)
                .sort((left, right) => distanceSquared(left.location, entity.location) - distanceSquared(right.location, entity.location) || String(left.id).localeCompare(String(right.id)));
            for (const player of candidates) {
                if (!gaze.isLookingAtEntityCenter(player, entity, { maxDistance: NULL_FLYING_SOURCE.gazeRange })) continue;
                state.triggered = true;
                scheduleFlyingTrigger(entity, player, state);
                break;
            }
        }

        if (distanceSquared(closest.location, entity.location) <= NULL_FLYING_SOURCE.proximityRange ** 2) {
            const branchRoll = Math.random();
            const outcome = branchRoll < NULL_FLYING_SOURCE.proximityDamageChance
                ? flyingProximityOutcome({ branchRoll, damageRoll: Math.random() })
                : flyingProximityOutcome({ branchRoll });
            discardEntity(entity, undefined);
            if (outcome.action === "damage") applyFlyingDamage(closest, outcome.amount, entity);
            else spawnNullIsHere(entity);
            return;
        }
    }

    // NullFlyingEntity performs its target/gaze/proximity work before the
    // post-decrement natural-despawn check in baseTick().
    if (tickNaturalTimer(entity, timer)) discardEntity(entity, undefined);
}

function tickReputationCooldowns(players) {
    for (const player of players) {
        if (!isValid(player)) continue;
        try {
            const timer = playerState.get(player, "nullFlyRepGainTimer");
            const next = flyingRepGainCooldownStep(timer);
            if (next !== timer) playerState.set(player, "nullFlyRepGainTimer", next);
        } catch (error) {
            logger.debug(`null_source: cooldown tick failed: ${String(error)}`);
        }
    }
}

function tickEntities(players) {
    for (const [id, entity] of trackedEntities) {
        if (!isValid(entity) || !ACTIVE_TYPES.has(entity.typeId)) {
            trackedEntities.delete(id);
            mazeStates.delete(id);
            flyingStates.delete(id);
            continue;
        }
        try {
            if (entity.typeId === MAZE_ID) tickMaze(entity, players);
            else tickFlying(entity, players);
        } catch (error) {
            logger.error(`null_source: ${entity.typeId} tick failed`, error);
        }
    }
}

function onTick() {
    let players;
    try { players = world.getAllPlayers(); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.507", "best-effort Bedrock API fallback", error); return; }
    tickReputationCooldowns(players);
    tickEntities(players);
}

function onEntitySpawn(event) {
    rememberEntity(event?.entity);
}

function onFlyingHurt(event) {
    const entity = event?.hurtEntity;
    if (!entity || entity.typeId !== FLYING_ID) return;
    const attacker = event.damageSource?.damagingEntity;
    if (attacker?.typeId === "minecraft:player" && isValid(attacker)) {
        try { horrorChat.changeReputation(attacker, -25); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.521", "best-effort Bedrock API fallback", error);}
        let reputation = 50;
        try { reputation = Number(playerState.get(attacker, "entityReputation")); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.523", "best-effort Bedrock API fallback", error);}
        if (Math.random() < 0.3 && reputation <= 25) {
            try {
                const typeId = Math.random() < 0.5
                    ? "thebrokenscript:null_unbeatable_bossfight"
                    : NULL_IS_HERE_ID;
                const spawned = entity.dimension.spawnEntity(typeId, entity.location);
                try { spawned.setRotation({ x: 0, y: Math.random() * 360 }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.530", "best-effort Bedrock API fallback", error);}
            } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.531", "best-effort Bedrock API fallback", error);}
        }
    }
    // Java discards NullFlying for every hurt source, not only player damage.
    discardEntity(entity, undefined);
}

function scanExistingEntities() {
    for (const id of dimensions.SUPPORTED) {
        let dimension;
        try { dimension = dimensions.get(id); } catch { dimension = undefined; }
        if (!dimension) continue;
        for (const typeId of ACTIVE_TYPES) {
            try {
                for (const entity of dimension.getEntities({ type: typeId })) rememberEntity(entity);
            } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_source_controller.js.546", "best-effort Bedrock API fallback", error);}
        }
    }
}

export function begin(scheduler) {
    if (begun) return;
    begun = true;
    scanExistingEntities();
    scheduler.every("tbs.null_source_tick", 1, onTick);
    events.subscribeGuarded(world.afterEvents.entitySpawn, "null-source.entitySpawn", "null-source", onEntitySpawn);
    events.subscribeGuarded(world.afterEvents.entityHurt, "null-source.entityHurt", "null-source", onFlyingHurt);
}

// Exported for static/runtime adapters and focused tests without exposing the
// internal entity registry.
export { exactFlyingGaze };
