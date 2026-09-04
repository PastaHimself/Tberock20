import { system, world } from "@minecraft/server";
import * as bossHooks from "./boss_hooks.js";
import { logger } from "../core/logging.js";
import {
  ARENA_START_SOURCE,
  arenaCenter,
  arenaParticipants,
  integrityArenaStartPlan,
  shouldRestartArenaPhase,
  sampleArenaOffset,
} from "./integrity_arena_start_model.js";
import { PHASE1_SOURCE } from "./integrity_arena_model.js";
import {
  PHASE1_TERRAIN_SOURCE,
  createTerrainCorruptionQueue,
  phase1TerrainTick,
} from "./integrity_phase1_terrain_model.js";

const ARENA_TOKEN_PROPERTY = "tbs:integrity_arena_token";
const INTRO_UNTIL_PROPERTY = "tbs:integrity_intro_until";
const CUSTOM_SKY_ENABLED_PROPERTY = "tbs:integrity_custom_sky_enabled";
const CUSTOM_SKY_COLOR_PROPERTY = "tbs:integrity_custom_sky_color";

const PHASE1_ENTITY_ID = /** @type {any} */ ("thebrokenscript:integrity_phase_1");
const CHORD_ENTITY_ID = /** @type {any} */ ("thebrokenscript:chord");

let tokenCounter = 0;
let activeArena = null;

export function startIntegrityArena(player, block) {
  if (!isPlayer(player)) return { kind: "invalid_actor" };

  const dimension = player.dimension ?? block?.dimension;
  if (!dimension?.id) return { kind: "invalid_dimension" };
  if (dimension.id !== "minecraft:overworld") return { kind: "invalid_dimension" };

  if (activeArena) {
    if (shouldRestartArenaPhase(true, trackedLivingPlayers())) {
      return restartIntegrityArenaPhase()
        ? { kind: "restarted" }
        : { kind: "restart_deferred" };
    }
  }

  const commandBlockPosition = blockPosition(block ?? player);
  const offset = {
    x: sampleArenaOffset(randomInt),
    z: sampleArenaOffset(randomInt),
  };
  const surfaceY = surfaceYAt(dimension, commandBlockPosition.x + offset.x, commandBlockPosition.z + offset.z);
  if (surfaceY === undefined) {
    logger.warn("integrity_arena: could not resolve the Phase 1 surface height");
    return { kind: "surface_unavailable" };
  }

  const center = arenaCenter(commandBlockPosition, offset, surfaceY);
  const nearbyPlayers = arenaPlayers(dimension.id, center);
  const plan = integrityArenaStartPlan({
    existingArena: Boolean(activeArena),
    livingPlayers: trackedLivingPlayers(),
    commandBlockPosition,
    offset,
    surfaceY,
    dimensionId: dimension.id,
    nearbyPlayers,
  });
  if (plan.action !== "create_and_start") return { kind: "restart_deferred" };

  resetIntegrityArena();
  activeArena = {
    token: `${system.currentTick}-${++tokenCounter}`,
    dimensionId: dimension.id,
    center: plan.center,
    participantIds: plan.participantIds,
    phase: null,
    phase1Entity: null,
    chords: [],
    chordsSpawned: false,
    terrainQueue: [],
    ticksSinceLastCorrupt: PHASE1_TERRAIN_SOURCE.initialTicksSinceLastCorrupt,
    originalTimeOfDay: readTimeOfDay(),
  };
  bossHooks.setArenaState(true, false);
  runLater(() => prepareArena(activeArena?.token), plan.schedule.preStartDelayTicks);
  return {
    kind: "started",
    center: { ...plan.center },
    participantIds: [...plan.participantIds],
  };
}

export function resetIntegrityArena() {
  const arena = activeArena;
  if (!arena) {
    bossHooks.setArenaState(false, false);
    return false;
  }

  removeEntity(arena.phase1Entity);
  for (const chord of arena.chords) removeEntity(chord);
  for (const player of playersFor(arena.participantIds)) clearCustomSky(player);
  if (Number.isFinite(arena.originalTimeOfDay)) {
    try { world.setTimeOfDay(arena.originalTimeOfDay); } catch {}
  }

  activeArena = null;
  bossHooks.setArenaState(false, false);
  return true;
}

export function restartIntegrityArenaPhase() {
  const arena = activeArena;
  if (!arena || arena.phase !== ARENA_START_SOURCE.phase1) return false;

  removeEntity(arena.phase1Entity);
  for (const chord of arena.chords) removeEntity(chord);
  arena.phase1Entity = null;
  arena.chords = [];
  arena.chordsSpawned = false;
  startPhaseOne(arena.token);
  return true;
}

/**
 * Phase 1 mirrors IntegrityPhase1Entity.isInvulnerable(): the source reports
 * true while its tracked Chord list is empty or contains any living Chord.
 */
export function isIntegrityPhase1Invulnerable(entity) {
  const arena = activeArena;
  if (!arena || arena.phase !== ARENA_START_SOURCE.phase1) return false;
  if (arena.phase1Entity?.id !== entity?.id) return false;

  arena.chords = arena.chords.filter(isValidEntity);
  return !arena.chordsSpawned || arena.chords.length > 0;
}

export function tickIntegrityArena() {
  const arena = activeArena;
  if (!arena || arena.phase !== ARENA_START_SOURCE.phase1) return;

  const plan = phase1TerrainTick(arena, randomTerrainReplacement);
  arena.terrainQueue = plan.terrainQueue;
  arena.ticksSinceLastCorrupt = plan.ticksSinceLastCorrupt;
  if (plan.action !== "corrupt") return;
  applyTerrainCorruption(arena, plan.position, plan.replacementBlockId);
}

function prepareArena(token) {
  const arena = currentArena(token);
  if (!arena) return;

  try { world.setTimeOfDay(0); } catch {}
  for (const player of playersFor(arena.participantIds)) applyCustomSky(player);
  runLater(() => startPhaseOne(token), ARENA_START_SOURCE.startDelayTicks);
}

function startPhaseOne(token) {
  const arena = currentArena(token);
  if (!arena) return;
  const dimension = getDimension(arena.dimensionId);
  if (!dimension) return;

  arena.phase = ARENA_START_SOURCE.phase1;
  arena.terrainQueue = createTerrainCorruptionQueue(arena.center);
  arena.ticksSinceLastCorrupt = PHASE1_TERRAIN_SOURCE.initialTicksSinceLastCorrupt;
  bossHooks.setArenaState(true, true);
  const location = {
    x: arena.center.x + 0.5,
    y: arena.center.y,
    z: arena.center.z + 0.5,
  };
  let entity;
  try {
    entity = dimension.spawnEntity(PHASE1_ENTITY_ID, location);
  } catch (err) {
    logger.error("integrity_arena: Phase 1 entity spawn failed", err);
    return;
  }
  arena.phase1Entity = entity;
  setEntityProperty(entity, ARENA_TOKEN_PROPERTY, arena.token);
  setEntityProperty(entity, INTRO_UNTIL_PROPERTY, system.currentTick + ARENA_START_SOURCE.phase1IntroDelayTicks);
  setEntityProperty(entity, "tbs:integrity_crawl_out", true);
  tryPlayAt(dimension, location, "thebrokenscript:integrity.boss_p1", 10, 1);
  runLater(() => releasePhaseOneIntro(token), ARENA_START_SOURCE.phase1IntroDelayTicks);
}

function releasePhaseOneIntro(token) {
  const arena = currentArena(token);
  if (!arena || arena.phase !== ARENA_START_SOURCE.phase1) return;
  setEntityProperty(arena.phase1Entity, INTRO_UNTIL_PROPERTY, undefined);
  setEntityProperty(arena.phase1Entity, "tbs:integrity_intro_complete", true);
  spawnPhaseOneChords(arena);
  arena.terrainQueue.push(...createTerrainCorruptionQueue(arena.center));
}

function spawnPhaseOneChords(arena) {
  if (arena.chordsSpawned) return;
  arena.chordsSpawned = true;
  const dimension = getDimension(arena.dimensionId);
  if (!dimension) return;

  for (let index = 0; index < PHASE1_SOURCE.chordMaxCount; index += 1) {
    const angle = Math.random() * Math.PI * 2;
    const radius = Math.sqrt(Math.random()) * PHASE1_SOURCE.chordRadius;
    try {
      const chord = dimension.spawnEntity(CHORD_ENTITY_ID, {
        x: arena.center.x + 0.5 + Math.cos(angle) * radius,
        y: arena.center.y,
        z: arena.center.z + 0.5 + Math.sin(angle) * radius,
      });
      setEntityProperty(chord, ARENA_TOKEN_PROPERTY, arena.token);
      arena.chords.push(chord);
    } catch (err) {
      logger.error("integrity_arena: Chord spawn failed", err);
    }
  }
}

function trackedLivingPlayers() {
  if (!activeArena) return [];
  const live = new Map(playersFor(activeArena.participantIds).map((player) => [player.id, player]));
  return activeArena.participantIds.map((id) => {
    const player = live.get(id);
    return { connected: Boolean(player), alive: player ? isLiving(player) : false };
  });
}

function arenaPlayers(dimensionId, center) {
  let players = [];
  try { players = world.getAllPlayers(); } catch { return []; }
  return arenaParticipants(
    players.map((player) => ({
      id: player.id,
      dimensionId: player.dimension?.id,
      location: player.location,
    })),
    center,
    dimensionId,
  );
}

function playersFor(ids) {
  let players = [];
  try { players = world.getAllPlayers(); } catch { return []; }
  const wanted = new Set(ids);
  return players.filter((player) => wanted.has(player.id));
}

function isLiving(player) {
  try {
    if (player.isValid === false) return false;
    const health = player.getComponent("minecraft:health");
    return health ? health.currentValue > 0 : true;
  } catch {
    return true;
  }
}

function applyCustomSky(player) {
  setEntityProperty(player, CUSTOM_SKY_ENABLED_PROPERTY, ARENA_START_SOURCE.customSkyEnabled);
  setEntityProperty(player, CUSTOM_SKY_COLOR_PROPERTY, JSON.stringify(ARENA_START_SOURCE.customSkyColor));
}

function clearCustomSky(player) {
  setEntityProperty(player, CUSTOM_SKY_ENABLED_PROPERTY, undefined);
  setEntityProperty(player, CUSTOM_SKY_COLOR_PROPERTY, undefined);
}

function currentArena(token) {
  return activeArena?.token === token ? activeArena : null;
}

function getDimension(id) {
  try { return world.getDimension(id); } catch { return undefined; }
}

function randomTerrainReplacement() {
  const ids = PHASE1_TERRAIN_SOURCE.replacementBlockIds;
  return ids[Math.floor(Math.random() * ids.length)];
}

function applyTerrainCorruption(arena, position, replacementBlockId) {
  const dimension = getDimension(arena.dimensionId);
  if (!dimension || !position) return;

  try {
    const top = dimension.getTopmostBlock({ x: position.x, z: position.z });
    const y = top?.location?.y;
    if (typeof y !== "number") return;
    const block = dimension.getBlock({ x: position.x, y, z: position.z });
    if (!block || block.typeId === PHASE1_TERRAIN_SOURCE.protectedBlockId) return;
    block.setType(replacementBlockId);
  } catch (err) {
    logger.error("integrity_arena: terrain corruption failed", err);
  }
}

function surfaceYAt(dimension, x, z) {
  try {
    const top = dimension.getTopmostBlock({ x, z });
    return typeof top?.location?.y === "number" ? top.location.y + 1 : undefined;
  } catch {
    return undefined;
  }
}

function blockPosition(block) {
  const location = block?.location ?? block;
  return {
    x: Math.floor(Number(location?.x ?? 0)),
    y: Math.floor(Number(location?.y ?? 0)),
    z: Math.floor(Number(location?.z ?? 0)),
  };
}

function randomInt(min, max) {
  return min + Math.floor(Math.random() * (max - min));
}

function readTimeOfDay() {
  try {
    const value = world.getTimeOfDay();
    return Number.isFinite(value) ? value : undefined;
  } catch {
    return undefined;
  }
}

function setEntityProperty(entity, key, value) {
  try { entity?.setDynamicProperty?.(key, value); } catch {}
}

function isValidEntity(entity) {
  if (!entity) return false;
  try { return entity.isValid !== false; } catch { return false; }
}

function removeEntity(entity) {
  if (!entity) return;
  try { entity.remove(); } catch {}
}

function tryPlayAt(dimension, location, sound, volume, pitch) {
  try { dimension.playSound(sound, location, { volume, pitch }); } catch {
    for (const player of playersFor(activeArena?.participantIds ?? [])) {
      try { player.playSound(sound, { volume, pitch }); } catch {}
    }
  }
}

function runLater(callback, ticks) {
  try {
    system.runTimeout(callback, ticks);
  } catch {
    callback();
  }
}

function isPlayer(entity) {
  return entity?.typeId === "minecraft:player";
}
