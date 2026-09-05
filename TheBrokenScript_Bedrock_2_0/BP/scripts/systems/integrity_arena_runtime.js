import { BlockVolume, system, world } from "@minecraft/server";
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
import {
  PHASE1_SOURCE,
  STAGE2_DIMENSION_ID,
  STAGE2_FLOORS,
  STAGE2_UTIL_SOURCE,
  phase2IntegrityFloorFromY,
  phase2IntegrityPlacementStep,
  phase2LowestPlayer,
  phase2NeedsRecoveryTeleport,
  phase2Stage2FloorStep,
  stage2FindSafeSpawnY,
  stage2IntegrityPositionAllowed,
  stage2IsSpecialSpawnBand,
  stage2IsValidFloor,
  stage2SpawnAttemptCoordinates,
  stage2SpawnCellChunksFromPlayerBlock,
  stage2GeneratorRuntimeVolumes,
  stage2TemplateLoadCommand,
} from "./integrity_arena_model.js";
import {
  PHASE1_TERRAIN_SOURCE,
  createTerrainCorruptionQueue,
  phase1TerrainTick,
} from "./integrity_phase1_terrain_model.js";
import {
  PHASE2_SOURCE,
  phase1CompletionStep,
  phase2TransferPlan,
} from "./integrity_phase2_transfer_model.js";

const ARENA_TOKEN_PROPERTY = "tbs:integrity_arena_token";
const INTRO_UNTIL_PROPERTY = "tbs:integrity_intro_until";
const CUSTOM_SKY_ENABLED_PROPERTY = "tbs:integrity_custom_sky_enabled";
const CUSTOM_SKY_COLOR_PROPERTY = "tbs:integrity_custom_sky_color";
const PHASE2_LOADING_PROPERTY = "tbs:integrity_phase2_loading";
const PHASE2_FIX_POS_PROPERTY = "tbs:integrity_phase2_fix_pos";

const PHASE1_ENTITY_ID = /** @type {any} */ ("thebrokenscript:integrity_phase_1");
const CHORD_ENTITY_ID = /** @type {any} */ ("thebrokenscript:chord");
const TETHER_ENTITY_ID = /** @type {any} */ ("thebrokenscript:tether");
const INTEGRITY_PHASE2_ENTITY_ID = /** @type {any} */ ("thebrokenscript:integrity_phase_2");

// stage2.json uses a void generator with bounds 0..384. Java's dynamic
// Stage2Generator remains unavailable; these bounds only clamp entity queries.
const STAGE2_BUILD_MIN_Y = 0;
const STAGE2_BUILD_MAX_Y_EXCLUSIVE = 384;

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
    phase2TransferScheduled: false,
    phase2LowestPlayerId: null,
    // phase2TargetFloor is the current lowest player's target; the existing
    // phase2IntegrityFloor is only advanced after a successful teleport.
    phase2TargetFloor: null,
    phase2IntegrityFloor: null,
    spawnedFloors: new Set(),
    stage2ScaffoldCells: new Set(),
    integrityEntity: null,
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
  for (const player of playersFor(arena.participantIds)) {
    clearCustomSky(player);
    setEntityProperty(player, PHASE2_LOADING_PROPERTY, undefined);
    setEntityProperty(player, PHASE2_FIX_POS_PROPERTY, undefined);
  }
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
  if (!arena) return;
  if (arena.phase === "phase2") {
    tickPhaseTwo(arena);
    return;
  }
  if (arena.phase !== ARENA_START_SOURCE.phase1) return;

  const liveChordCount = arena.chords.filter(isLivingEntity).length;
  const completion = phase1CompletionStep({
    chordsSpawned: arena.chordsSpawned,
    livingChordCount: liveChordCount,
  });
  if (completion === "complete") {
    beginPhaseTwoTransfer(arena);
    return;
  }

  const plan = phase1TerrainTick(arena, randomTerrainReplacement);
  arena.terrainQueue = plan.terrainQueue;
  arena.ticksSinceLastCorrupt = plan.ticksSinceLastCorrupt;
  if (plan.action !== "corrupt") return;
  applyTerrainCorruption(arena, plan.position, plan.replacementBlockId);
}

function tickPhaseTwo(arena) {
  const participants = playersFor(arena.participantIds);
  for (const player of participants) {
    if (!phase2NeedsRecoveryTeleport(playerBlockY(player))) continue;
    try {
      player.teleport(PHASE2_SOURCE.recoveryTeleport, {
        checkForBlocks: false,
        keepVelocity: false,
      });
    } catch (err) {
      logger.error("integrity_arena: Phase 2 recovery teleport failed", err);
    }
  }

  const lowest = phase2LowestPlayer(
    participants.map((player) => ({
      id: player.id,
      y: playerBlockY(player),
    })),
  );
  arena.phase2LowestPlayerId = lowest?.id ?? null;
  const targetFloor = lowest ? phase2IntegrityFloorFromY(lowest.y) : null;
  arena.phase2TargetFloor = targetFloor?.id ?? null;

  const floorPlan = phase2Stage2FloorStep({
    phase: "phase2",
    spawnedFloorIds: [...(arena.spawnedFloors ?? [])],
    integrityPresent: isValidEntity(arena.integrityEntity),
    players: participants.map((player) => ({
      id: player.id,
      dimensionId: player.dimension?.id,
      y: playerBlockY(player),
      loadingPhase2: isPhaseTwoLoading(player),
    })),
  });
  arena.spawnedFloors = new Set(floorPlan.nextSpawnedFloorIds);
  for (const spawn of floorPlan.floorsToSpawn) {
    const player = participants.find((candidate) => candidate.id === spawn.playerId);
    if (!player) continue;
    spawnStage2FloorEntities(arena, spawn.floor, player);
  }

  const lowestPlayer = lowest
    ? participants.find((player) => player.id === lowest.id)
    : undefined;
  if (lowestPlayer) placeIntegrityForLowestPlayer(arena, lowestPlayer);
}

/**
 * Bedrock has no direct Block.canBeReplaced or
 * BlockState.entityCanStandOnFace(UP) equivalent. The adapter is deliberately
 * conservative for clearance (air only) and rejects liquids; all other
 * non-air, non-liquid blocks are treated as standable.
 */
function stage2BlockAt(dimension, location) {
  try {
    return dimension.getBlock(location);
  } catch {
    return undefined;
  }
}

function stage2IsAir(dimension, location) {
  const block = stage2BlockAt(dimension, location);
  if (!block) return false;
  try { return block.isAir === true; } catch { return false; }
}

function stage2IsValidFloorAt(dimension, x, y, z) {
  const block = stage2BlockAt(dimension, { x, y, z });
  if (!block) return false;
  try {
    const isAir = block.isAir === true;
    const isLiquid = block.isLiquid === true;
    return stage2IsValidFloor({
      isAir,
      canBeReplaced: isAir || isLiquid,
      canStandOnUp: !isAir && !isLiquid,
      isBarrier: block.typeId === "minecraft:barrier",
      isMud: block.typeId === "minecraft:mud",
    });
  } catch {
    return false;
  }
}

// Explicit opt-in seam for validated .mcstructure assets. The Stage 2 tick does
// not call this automatically while the remaining Java templates are deferred.
// Dimension.runCommand must be invoked from normal runtime execution, not a
// restricted-execution callback; failures remain retryable for the caller.
export function runStage2TemplateLoad(dimension, plan) {
  const command = stage2TemplateLoadCommand(plan);
  if (!dimension || !command || typeof dimension.runCommand !== "function") return false;
  try {
    dimension.runCommand(command);
    return true;
  } catch {
    logger.warn("integrity_arena: Stage 2 template load deferred");
    return false;
  }
}

function ensureStage2RuntimeScaffold(arena, player) {
  if (!arena || !player) return false;
  const dimension = getDimension(STAGE2_DIMENSION_ID);
  if (!dimension) return false;

  const plan = stage2GeneratorRuntimeVolumes(blockPosition(player));
  arena.stage2ScaffoldCells ??= new Set();
  if (arena.stage2ScaffoldCells.has(plan.cellKey)) return true;

  const maxX = plan.origin.x + STAGE2_UTIL_SOURCE.cellSizeBlocks - 1;
  const maxZ = plan.origin.z + STAGE2_UTIL_SOURCE.cellSizeBlocks - 1;
  try {
    for (const volume of plan.volumes) {
      dimension.fillBlocks(
        new BlockVolume(
          { x: plan.origin.x, y: volume.y, z: plan.origin.z },
          { x: maxX, y: volume.y, z: maxZ },
        ),
        volume.blockId,
        { blockFilter: { includeTypes: ["minecraft:air"] } },
      );
    }
    arena.stage2ScaffoldCells.add(plan.cellKey);
    return true;
  } catch {
    logger.warn("integrity_arena: Stage 2 runtime scaffold fill deferred");
    return false;
  }
}

function stage2FloorById(id) {
  return STAGE2_FLOORS.find((floor) => floor.id === id) ?? null;
}

function findSafeStage2BlockPosition(dimension, player, floor, entityId) {
  if (!dimension || !player || !floor) return null;
  const cells = stage2SpawnCellChunksFromPlayerBlock(blockPosition(player));
  const isTether = entityId === TETHER_ENTITY_ID;
  const specialBand = stage2IsSpecialSpawnBand(floor.spawnY);

  for (let attempt = 0; attempt < STAGE2_UTIL_SOURCE.defaultMaxAttempts; attempt += 1) {
    const candidate = stage2SpawnAttemptCoordinates({
      cellChunk: cells.cellChunk,
      centerChunk: cells.centerChunk,
      spawnY: floor.spawnY,
      minBlockDistance: floor.boundsMinDistance,
      isTether,
      // Match Stage2Util's conditional RNG calls: non-Tether and special
      // bands do not consume a random X-chunk offset.
      randomChunkXOffset: specialBand || !isTether ? 0 : randomInt(0, 10),
      randomChunkZOffset: randomInt(0, 10),
      randomBlockXOffset: specialBand ? 0 : randomInt(0, 16),
      randomBlockZOffset: randomInt(0, 16),
    });
    if (!candidate) continue;

    const safeY = stage2FindSafeSpawnY({
      spawnY: floor.spawnY,
      maxScanDepth: STAGE2_UTIL_SOURCE.defaultScanDepth,
      isValidFloor: (candidateY) => stage2IsValidFloorAt(
        dimension,
        candidate.blockX,
        candidateY,
        candidate.blockZ,
      ),
      areAboveBlocksReplaceable: (candidateY, offset) => stage2IsAir(
        dimension,
        {
          x: candidate.blockX,
          y: candidateY + offset,
          z: candidate.blockZ,
        },
      ),
    });
    if (safeY !== null) {
      return { x: candidate.blockX, y: safeY, z: candidate.blockZ };
    }
  }
  return null;
}

function stage2FloorEntityLocation(blockPositionValue) {
  return {
    x: blockPositionValue.x + 0.5,
    y: blockPositionValue.y,
    z: blockPositionValue.z + 0.5,
  };
}

function stage2BlockCenter(blockPositionValue) {
  return {
    x: blockPositionValue.x + 0.5,
    y: blockPositionValue.y + 0.5,
    z: blockPositionValue.z + 0.5,
  };
}

function spawnStage2FloorEntities(arena, floor, player) {
  if (!player || player.dimension?.id !== STAGE2_DIMENSION_ID) return;
  const dimension = getDimension(STAGE2_DIMENSION_ID);
  if (!dimension) return;
  if (!ensureStage2RuntimeScaffold(arena, player)) return;

  for (const spawnType of floor.sourceSpawns) {
    const entityId = spawnType === "TETHER"
      ? TETHER_ENTITY_ID
      : spawnType === "INTEGRITY_PHASE_2"
        ? INTEGRITY_PHASE2_ENTITY_ID
        : null;
    if (!entityId) continue;

    const position = findSafeStage2BlockPosition(dimension, player, floor, entityId);
    if (!position) continue;
    try {
      const entity = dimension.spawnEntity(entityId, stage2FloorEntityLocation(position));
      setEntityProperty(entity, ARENA_TOKEN_PROPERTY, arena.token);
      setEntityProperty(entity, "tbs:integrity_phase2_floor", floor.id);
      if (entityId === INTEGRITY_PHASE2_ENTITY_ID) {
        arena.integrityEntity = entity;
      }
    } catch (err) {
      logger.error("integrity_arena: Stage 2 floor entity spawn failed", err);
    }
  }
}

function hasTetherOnFloor(dimension, player, floor) {
  if (!dimension || !player || !floor) return false;
  const { cellChunk } = stage2SpawnCellChunksFromPlayerBlock(blockPosition(player));
  const minY = Math.max(floor.yMin, STAGE2_BUILD_MIN_Y);
  const maxY = Math.min(floor.yMax + 1, STAGE2_BUILD_MAX_Y_EXCLUSIVE);
  if (maxY <= minY) return false;

  try {
    const entities = dimension.getEntities({
      type: TETHER_ENTITY_ID,
      location: {
        x: cellChunk.x * 16,
        y: minY,
        z: cellChunk.z * 16,
      },
      volume: {
        x: STAGE2_UTIL_SOURCE.cellSizeBlocks,
        y: maxY - minY,
        z: STAGE2_UTIL_SOURCE.cellSizeBlocks,
      },
    });
    return entities.some(isLivingEntity);
  } catch (err) {
    logger.warn("integrity_arena: Stage 2 Tether floor query failed");
    return false;
  }
}

function hasTetherNear(dimension, position) {
  if (!dimension || !position) return false;
  try {
    const entities = dimension.getEntities({
      type: TETHER_ENTITY_ID,
      location: stage2BlockCenter(position),
      maxDistance: STAGE2_UTIL_SOURCE.integrityTetherExclusionRadius,
    });
    return entities.some(isValidEntity);
  } catch (err) {
    logger.warn("integrity_arena: Stage 2 Tether proximity query failed");
    return false;
  }
}

function findRandomIntegrityStage2BlockPosition(dimension, player, floor) {
  for (let attempt = 0; attempt < STAGE2_UTIL_SOURCE.defaultMaxAttempts; attempt += 1) {
    const position = findSafeStage2BlockPosition(
      dimension,
      player,
      floor,
      INTEGRITY_PHASE2_ENTITY_ID,
    );
    if (!position) continue;
    if (!stage2IntegrityPositionAllowed(hasTetherNear(dimension, position))) {
      continue;
    }
    return position;
  }
  return null;
}

function placeIntegrityForLowestPlayer(arena, player) {
  const integrity = arena.integrityEntity;
  if (!isValidEntity(integrity)) return;

  const playerY = playerBlockY(player);
  let plan = phase2IntegrityPlacementStep({
    playerY,
    integrityPresent: true,
    currentFloorId: arena.phase2IntegrityFloor,
  });
  if (plan.action === "none" || plan.action === "already_placed") return;

  const dimension = getDimension(STAGE2_DIMENSION_ID);
  if (!dimension) return;

  if (plan.action === "wait_for_tether") {
    const targetFloor = stage2FloorById(plan.stage2FloorId);
    if (!hasTetherOnFloor(dimension, player, targetFloor)) return;
    plan = phase2IntegrityPlacementStep({
      playerY,
      integrityPresent: true,
      currentFloorId: arena.phase2IntegrityFloor,
      hasTetherOnTargetFloor: true,
    });
  }
  if (plan.action !== "place") return;

  const position = findRandomIntegrityStage2BlockPosition(dimension, player, stage2FloorById(plan.stage2FloorId));
  if (!position) return;
  try {
    integrity.teleport(stage2BlockCenter(position), {
      checkForBlocks: false,
      keepVelocity: false,
    });
    arena.phase2IntegrityFloor = plan.targetFloorId;
  } catch (err) {
    logger.error("integrity_arena: Integrity Phase 2 placement failed", err);
  }
}

function beginPhaseTwoTransfer(arena) {
  const plan = phase2TransferPlan({
    phase: arena.phase,
    participantIds: arena.participantIds,
  });
  if (plan.action !== "schedule_transfer") return;

  arena.phase = "phase2_loading";
  arena.phase2TransferScheduled = true;
  removeEntity(arena.phase1Entity);
  for (const chord of arena.chords) removeEntity(chord);
  arena.phase1Entity = null;
  arena.chords = [];
  arena.chordsSpawned = false;
  arena.terrainQueue = [];
  arena.ticksSinceLastCorrupt = PHASE1_TERRAIN_SOURCE.initialTicksSinceLastCorrupt;
  arena.spawnedFloors = new Set();
  arena.stage2ScaffoldCells = new Set();
  arena.integrityEntity = null;
  arena.phase2TargetFloor = null;
  arena.phase2IntegrityFloor = null;

  const participants = playersFor(arena.participantIds);
  for (const player of participants) {
    clearCustomSky(player);
    setEntityProperty(player, PHASE2_LOADING_PROPERTY, true);
  }
  bossHooks.setArenaState(true, false);
  runLater(() => transferArenaPlayers(arena.token), plan.delayTicks);
}

function transferArenaPlayers(token) {
  const arena = currentArena(token);
  if (!arena || arena.phase !== "phase2_loading") return;

  const destination = getDimension(PHASE2_SOURCE.destinationDimensionId);
  if (!destination) {
    logger.warn("integrity_arena: Phase 2 destination dimension unavailable");
    return;
  }

  for (const player of playersFor(arena.participantIds)) {
    setEntityProperty(player, PHASE2_FIX_POS_PROPERTY, true);
    try {
      player.teleport(player.location, {
        dimension: destination,
        checkForBlocks: false,
        keepVelocity: false,
      });
      tryPlayAt(destination, player.location, "thebrokenscript:integrity.boss_p2", 10, 1);
    } catch (err) {
      logger.error("integrity_arena: Phase 2 player transfer failed", err);
    }
  }
  arena.phase = "phase2";
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

function isPhaseTwoLoading(player) {
  try {
    return player?.getDynamicProperty?.(PHASE2_LOADING_PROPERTY) === true;
  } catch {
    return false;
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

function isLivingEntity(entity) {
  if (!isValidEntity(entity)) return false;
  try {
    const health = entity.getComponent("minecraft:health");
    return health ? health.currentValue > 0 : true;
  } catch {
    return true;
  }
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

function playerBlockY(player) {
  try {
    const y = Number(player.location?.y);
    return Number.isFinite(y) ? Math.floor(y) : Number.NaN;
  } catch {
    return Number.NaN;
  }
}

function isPlayer(entity) {
  return entity?.typeId === "minecraft:player";
}
