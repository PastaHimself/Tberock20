import { world, system, EntityDamageCause } from "@minecraft/server";
import { logger } from "../../core/logging.js";
import * as events from "../../core/events.js";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as dimensions from "../../systems/dimensions.js";
import {
  ARENA_SOURCE,
  INTEGRITY_PHASE,
  PHASE1_SOURCE,
  PHASE2_SOURCE,
  PHASE3_SOURCE,
  STAGE2_FLOORS,
  arenaCheckLivingPlayers,
  phase3CutsceneState,
  phase3Ended,
  stage2SpawnFloorFromY,
} from "../../systems/integrity_arena_model.js";
import {
  INTEGRITY_RUNTIME_SOURCE,
  arenaParticipantsAlive,
  createIntegrityRuntimeState,
  dimensionSettleStep,
  phase1CompletionStep,
  phase1IntroStep,
  phase2PlayerStep,
  refreshIntegrityParticipantIds,
} from "../../systems/integrity_runtime_model.js";
import * as integrityCamera from "./integrity_camera.js";

const ARENA_TAG = "thebrokenscript.integrity_arena";
const PHASE1_CRAWL_TAG = "thebrokenscript.integrity_phase1_crawl_out";
const PHASE2_LOADING_TAG = "thebrokenscript.integrity_loading_phase2";
const PHASE3_LOADING_TAG = "thebrokenscript.integrity_loading_phase3";
const PHASE2_DIMENSION = "thebrokenscript:stage2";
const PHASE3_DIMENSION = "thebrokenscript:void_shadow";
const P1_ENTITY = "thebrokenscript:integrity_phase_1";
const P2_ENTITY = "thebrokenscript:integrity_phase_2";
const P3_ENTITY = "thebrokenscript:integrity_phase_3";
const CHORD_ENTITY = "thebrokenscript:chord";
const TETHER_ENTITY = "thebrokenscript:tether";

const TERRAIN_CORRUPT_REPLACEMENTS = Object.freeze([
  "thebrokenscript:corrupted_moon_stone_bricks",
  "thebrokenscript:deviation",
  "thebrokenscript:disruption",
  "thebrokenscript:necrosis",
  "thebrokenscript:void_grass",
  "thebrokenscript:void_root",
]);

let schedulerRef = null;
let runtimeStarted = false;
let state = null;
let generation = 0;
let transferTimeoutName = null;

function callEntityMethod(entity, name, ...args) {
  try {
    const method = entity?.[name];
    return typeof method === "function" ? method.call(entity, ...args) : undefined;
  } catch {
    return undefined;
  }
}

function isValid(entity) {
  if (!entity) return false;
  try { return entity.isValid !== false; } catch { return false; }
}

function health(entity) {
  try { return entity.getComponent("minecraft:health")?.currentValue ?? 0; } catch { return 0; }
}

function isLiving(entity) {
  return isValid(entity) && health(entity) > 0;
}

function hasTag(entity, tag) {
  return callEntityMethod(entity, "hasTag", tag) === true;
}

function addTag(entity, tag) {
  callEntityMethod(entity, "addTag", tag);
}

function removeTag(entity, tag) {
  callEntityMethod(entity, "removeTag", tag);
}

function safeDimension(id) {
  try {
    return dimensions.get(id) ?? world.getDimension(id);
  } catch {
    return undefined;
  }
}

function allArenaDimensions() {
  const result = [];
  for (const id of ["overworld", "nether", "the_end", PHASE2_DIMENSION, PHASE3_DIMENSION]) {
    const dimension = safeDimension(id);
    if (dimension) result.push(dimension);
  }
  return result;
}

function allPlayers() {
  try { return world.getAllPlayers(); } catch { return []; }
}

function resolveEntity(id) {
  if (!id) return null;
  try {
    const entity = world.getEntity(id);
    return isValid(entity) ? entity : null;
  } catch {
    return null;
  }
}

function resolvePlayer(id) {
  const player = resolveEntity(id);
  return player?.typeId === "minecraft:player" ? player : null;
}

function sameDimension(a, b) {
  try { return a?.dimension?.id === b?.dimension?.id; } catch { return false; }
}

function distance(a, b) {
  return Math.hypot(a.x - b.x, a.y - b.y, a.z - b.z);
}

function participantPlayers() {
  if (!state) return [];
  return state.participantIds
    .map(resolvePlayer)
    .filter((player) => player !== null);
}

function playerRecords() {
  return allPlayers().map((player) => ({
    id: player.id,
    connected: isValid(player),
    alive: isLiving(player),
  }));
}

function participantRecords() {
  return participantPlayers().map((player) => ({
    id: player.id,
    connected: true,
    alive: isLiving(player),
  }));
}

function track(entity) {
  if (!entity || !state) return null;
  addTag(entity, ARENA_TAG);
  if (entity.id && !state.trackedEntityIds.includes(entity.id)) {
    state.trackedEntityIds.push(entity.id);
  }
  return entity;
}

function spawnAt(dimension, typeId, location) {
  try { return track(dimension.spawnEntity(typeId, location)); } catch { return null; }
}

function removeEntity(entity) {
  if (!entity) return;
  try { entity.remove(); } catch {}
}

function removeEntityId(id) {
  removeEntity(resolveEntity(id));
}

function stopPlayerSounds(player) {
  try { player.runCommand("stopsound @s"); } catch {}
}

function playForParticipants(sound, volume = 1, pitch = 1) {
  for (const player of participantPlayers()) {
    try { player.playSound(sound, { volume, pitch }); } catch {}
  }
}

function preparePhaseSound(sound) {
  for (const player of participantPlayers()) stopPlayerSounds(player);
  playForParticipants(sound, 1, 1);
}

function surfaceBlockY(dimension, x, z, fallbackY) {
  try {
    const block = dimension.getTopmostBlock({ x: Math.floor(x), z: Math.floor(z) });
    return typeof block?.location?.y === "number" ? block.location.y : fallbackY;
  } catch {
    return fallbackY;
  }
}

function createTerrainQueue(center) {
  const queue = [];
  const radius = PHASE1_SOURCE.terrainCorruptionRadius;
  const radiusSquared = radius * radius;
  // TerrainCorrupter uses a circular radius, a 0.3 ratio, then shuffles.
  // The replacement tag is not exposed by the Bedrock Script API, so the
  // concrete block list above is an explicitly documented adapter.
  for (let x = -radius; x <= radius; x += 1) {
    for (let z = -radius; z <= radius; z += 1) {
      if (x * x + z * z > radiusSquared) continue;
      if (Math.random() > 0.3) continue;
      queue.push({ x: center.x + x, z: center.z + z });
    }
  }
  for (let i = queue.length - 1; i > 0; i -= 1) {
    const j = Math.floor(Math.random() * (i + 1));
    [queue[i], queue[j]] = [queue[j], queue[i]];
  }
  return queue;
}

function corruptNextTerrain() {
  if (!state || state.phase !== INTEGRITY_PHASE.PHASE_1 || state.terrainQueue.length === 0) return;
  if (state.terrainTicks < PHASE1_SOURCE.terrainCorruptionDelayTicks) {
    state.terrainTicks += 1;
    return;
  }
  state.terrainTicks = 0;
  const partial = state.terrainQueue.shift();
  const dimension = safeDimension(state.originDimensionId);
  if (!dimension || !partial) return;
  try {
    // TerrainCorrupter stores partial X/Z positions; resolve the surface
    // block before applying the explicit Bedrock replacement adapter.
    const block = dimension.getTopmostBlock({ x: partial.x, z: partial.z });
    if (!block || block.typeId === "thebrokenscript:corrupted_command_block") return;
    const replacement = TERRAIN_CORRUPT_REPLACEMENTS[
      Math.floor(Math.random() * TERRAIN_CORRUPT_REPLACEMENTS.length)
    ];
    block.setType(replacement);
  } catch {}
}

function spawnPhase1Chords() {
  if (!state || state.phase !== INTEGRITY_PHASE.PHASE_1 || state.chordsSpawned) return;
  state.chordsSpawned = true;
  const dimension = safeDimension(state.originDimensionId);
  if (!dimension) return;
  const origin = state.phase1SpawnLocation ?? state.center;
  for (let index = 0; index < PHASE1_SOURCE.chordMaxCount; index += 1) {
    const angle = Math.random() * Math.PI * 2;
    const radius = Math.random() * PHASE1_SOURCE.chordRadius;
    const chord = spawnAt(dimension, CHORD_ENTITY, {
      x: origin.x + Math.cos(angle) * radius,
      y: origin.y,
      z: origin.z + Math.sin(angle) * radius,
    });
    if (chord?.id) state.trackedChordIds.push(chord.id);
  }
}

function phase1ChordRecords() {
  if (!state) return [];
  return state.trackedChordIds.map((id) => ({
    id,
    alive: isLiving(resolveEntity(id)),
  }));
}

function integrityEntity(typeId, dimensionId = null) {
  if (state?.integrityId) {
    const tracked = resolveEntity(state.integrityId);
    if (tracked?.typeId === typeId && (!dimensionId || tracked.dimension.id === dimensionId)) {
      return tracked;
    }
  }
  for (const dimension of allArenaDimensions()) {
    try {
      const entity = dimension.getEntities({ type: typeId }).find((candidate) => (
        isValid(candidate)
        && (!dimensionId || candidate.dimension?.id === dimensionId)
      ));
      if (entity) return entity;
    } catch {}
  }
  return null;
}

function cancelTransferTimeout() {
  if (!transferTimeoutName || !schedulerRef) return;
  try { schedulerRef.cancelTimeout(transferTimeoutName); } catch {}
  transferTimeoutName = null;
}

function queueDimensionSettle(player, loadingTag) {
  if (!player || !state) return;
  addTag(player, loadingTag);
  const expectedGeneration = state.generation;
  try {
    system.runTimeout(() => {
      if (!state || state.generation !== expectedGeneration) return;
      if (state.participantIds.includes(player.id)) removeTag(player, loadingTag);
    }, INTEGRITY_RUNTIME_SOURCE.dimensionSettleDelayTicks);
  } catch {}
}

function transferPlayers(dimensionId, loadingTag) {
  if (!state) return false;
  const destination = safeDimension(dimensionId);
  if (!destination) {
    logger.error("integrity runtime: destination dimension unavailable: " + dimensionId);
    return false;
  }

  const players = participantPlayers();
  for (const player of players) {
    const sourceLocation = { ...player.location };
    addTag(player, loadingTag);
    try {
      player.teleport(sourceLocation, { dimension: destination });
      queueDimensionSettle(player, loadingTag);
    } catch (error) {
      removeTag(player, loadingTag);
      logger.error("integrity runtime: player dimension transfer failed", error);
    }
  }
  return true;
}

function schedulePhaseTransfer(phase, dimensionId, loadingTag) {
  cancelTransferTimeout();
  const expectedGeneration = state?.generation;
  const delay = phase === INTEGRITY_PHASE.PHASE_2
    ? PHASE2_SOURCE.transferDelayTicks
    : PHASE3_SOURCE.transferDelayTicks;
  transferTimeoutName = "tbs.integrity_transfer_" + expectedGeneration + "_" + phase;
  try {
    schedulerRef.afterTicks(transferTimeoutName, delay, () => {
      transferTimeoutName = null;
      if (!state || state.generation !== expectedGeneration || state.phase !== phase) return;
      transferPlayers(dimensionId, loadingTag);
    });
  } catch (error) {
    transferTimeoutName = null;
    logger.error("integrity runtime: failed to schedule dimension transfer", error);
  }
}

function removePhase1Entities() {
  if (!state) return;
  removeEntityId(state.integrityId);
  for (const id of state.trackedChordIds) removeEntityId(id);
  state.integrityId = null;
  state.trackedChordIds = [];
}

function removePhase2Integrity() {
  if (!state) return;
  removeEntityId(state.integrityId);
  state.integrityId = null;
}

function startPhase1() {
  if (!state) return false;
  state.phase = INTEGRITY_PHASE.PHASE_1;
  state.phaseTick = 0;
  state.introComplete = false;
  state.chordsSpawned = false;
  state.trackedChordIds = [];
  state.terrainTicks = PHASE1_SOURCE.terrainCorruptionDelayTicks;
  state.terrainQueue = createTerrainQueue(state.center);
  bossHooks.setArenaState(true, true);
  const dimension = safeDimension(state.originDimensionId);
  if (!dimension) return false;

  const y = surfaceBlockY(dimension, state.center.x, state.center.z, state.center.y);
  state.phase1SpawnLocation = { x: state.center.x + 0.5, y, z: state.center.z + 0.5 };
  const integrity = spawnAt(dimension, P1_ENTITY, state.phase1SpawnLocation);
  if (!integrity) return false;
  state.integrityId = integrity.id;
  addTag(integrity, PHASE1_CRAWL_TAG);
  callEntityMethod(integrity, "clearVelocity");
  preparePhaseSound("integrity.boss_p1");
  return true;
}

function phase2FloorEntities(player, floor) {
  if (!state || !player || !floor) return;
  const sourceSpawns = floor.sourceSpawns ?? [];
  if (sourceSpawns.includes("TETHER")) {
    const offset = Math.min(Number(floor.boundsMinDistance ?? 8), 16);
    spawnAt(player.dimension, TETHER_ENTITY, {
      x: player.location.x + offset,
      y: floor.spawnY,
      z: player.location.z + offset,
    });
  }
  if (sourceSpawns.includes("INTEGRITY_PHASE_2") && !integrityEntity(P2_ENTITY, PHASE2_DIMENSION)) {
    const integrity = spawnAt(player.dimension, P2_ENTITY, {
      x: player.location.x + 8,
      y: floor.spawnY,
      z: player.location.z + 8,
    });
    if (integrity) state.integrityId = integrity.id;
  }
}

function stage2FloorFor(id) {
  return STAGE2_FLOORS.find((floor) => floor.id === id) ?? null;
}

function hasTetherOnFloor(dimension, player, floor) {
  if (!floor || !floor.sourceSpawns?.includes("TETHER")) return true;
  try {
    return dimension.getEntities({ type: TETHER_ENTITY }).some((tether) => (
      isValid(tether)
      && Math.abs(tether.location.x - player.location.x) <= 80
      && Math.abs(tether.location.z - player.location.z) <= 80
      && tether.location.y >= floor.yMin
      && tether.location.y <= floor.yMax
    ));
  } catch {
    return false;
  }
}

function teleportIntegrityToFloor(integrity, player, floor) {
  if (!integrity || !player || !floor) return;
  try {
    integrity.teleport({
      x: player.location.x + 4,
      y: floor.spawnY,
      z: player.location.z + 4,
    });
  } catch {}
}

function approachEntity(entity, target, speed) {
  const dx = target.location.x - entity.location.x;
  const dz = target.location.z - entity.location.z;
  const length = Math.hypot(dx, dz);
  if (length <= 0) return;
  try {
    entity.teleport({
      x: entity.location.x + (dx / length) * speed,
      y: entity.location.y,
      z: entity.location.z + (dz / length) * speed,
    });
  } catch {}
}

function clearPhase2Path(entity) {
  const view = callEntityMethod(entity, "getViewDirection");
  if (!view) return;
  for (let y = 0; y < 4; y += 1) {
    try {
      const block = entity.dimension.getBlock({
        x: Math.floor(entity.location.x + view.x),
        y: Math.floor(entity.location.y + y),
        z: Math.floor(entity.location.z + view.z),
      });
      if (!block || block.isAir === true || block.typeId === "minecraft:barrier" || block.typeId === "minecraft:air") continue;
      block.setType("minecraft:air");
    } catch {}
  }
}

function phase2Target(integrity) {
  const candidates = participantPlayers()
    .filter((player) => sameDimension(player, integrity) && isLiving(player))
    .sort((a, b) => distance(integrity.location, a.location) - distance(integrity.location, b.location));
  return candidates[0] ?? null;
}

function tickPhase2Combat(integrity) {
  if (!state || !integrity) return;
  if (!state.phase2AttackCooldown) state.phase2AttackCooldown = 0;
  const target = phase2Target(integrity);
  if (!target) return;
  try { integrity.lookAt(target.location); } catch {}
  const range = distance(integrity.location, target.location);
  if (range > 1.2) approachEntity(integrity, target, 0.85);
  clearPhase2Path(integrity);
  if (state.phase2AttackCooldown > 0) {
    state.phase2AttackCooldown -= 1;
    return;
  }
  if (range <= 3.5) {
    try {
      target.applyDamage(25, {
        cause: EntityDamageCause.entityAttack,
        damagingEntity: integrity,
      });
    } catch {}
    callEntityMethod(integrity, "playAnimation", "animation.thebrokenscript.integrity_phase2.bitch_slap");
    state.phase2AttackCooldown = 10;
  }
}

function tickPhase2() {
  if (!state) return;
  const integrity = integrityEntity(P2_ENTITY, PHASE2_DIMENSION);
  if (integrity && !state.integrityId) {
    state.integrityId = integrity.id;
    track(integrity);
  }

  const players = participantPlayers()
    .filter((player) => player.dimension.id === PHASE2_DIMENSION && !hasTag(player, PHASE2_LOADING_TAG));
  for (const player of players) {
    const y = Math.floor(player.location.y);
    const floor = stage2FloorFromY(y);
    if (!floor) continue;
    if (!state.spawnedFloors.has(floor.id)) {
      state.spawnedFloors.add(floor.id);
      phase2FloorEntities(player, floor);
    }
    const playerStep = phase2PlayerStep({
      y,
      currentFloorId: state.currentFloorId,
    });
    if (playerStep.recoveryTeleport) {
      try { player.teleport(PHASE2_SOURCE.recoveryTeleport); } catch {}
    }
  }

  const eligiblePlayers = players
    .filter((player) => phase2PlayerStep({ y: Math.floor(player.location.y) }).eligibleForIntegrity)
    .sort((a, b) => Math.floor(a.location.y) - Math.floor(b.location.y));
  const lowest = eligiblePlayers[0];
  if (!lowest || !integrity) return;

  const targetStep = phase2PlayerStep({
    y: Math.floor(lowest.location.y),
    currentFloorId: state.currentFloorId,
  });
  if (targetStep.floorId === null || targetStep.floorId === state.currentFloorId) {
    tickPhase2Combat(integrity);
    return;
  }
  const targetFloor = stage2FloorFor(
    STAGE2_FLOORS.find((floor) => floor.id === (
      targetStep.floorId === "Floor6" ? "FLOOR_6_INTEG" : "FLOOR_" + targetStep.floorId.slice(-1)
    ))?.id ?? "",
  );
  const stageFloor = STAGE2_FLOORS.find((floor) => (
    targetStep.floorId === "Floor6"
      ? floor.id === "FLOOR_6_INTEG"
      : floor.id === "FLOOR_" + targetStep.floorId.slice(-1)
  ));
  if (stageFloor && hasTetherOnFloor(lowest.dimension, lowest, stageFloor)) {
    teleportIntegrityToFloor(integrity, lowest, stageFloor);
    state.currentFloorId = targetStep.floorId;
  }
  tickPhase2Combat(integrity);
  void targetFloor;
}

function phase3Facing(position, rotation) {
  const yaw = (rotation.y * Math.PI) / 180;
  const pitch = (rotation.x * Math.PI) / 180;
  return {
    x: position.x - Math.sin(yaw),
    y: position.y - Math.sin(pitch),
    z: position.z + Math.cos(yaw),
  };
}

function tickFinalCutscene() {
  if (!state) return;
  const cutscene = phase3CutsceneState(state.cutsceneTick);
  if (cutscene.ended) {
    cleanupEncounter();
    return;
  }
  for (const player of participantPlayers()) {
    // Java's exact camera override, overlay packets, and music packets are
    // engine-specific. Bedrock uses the supported free-camera adapter while
    // preserving the same 428-tick interpolation/blackout timing model.
    integrityCamera.setIntegrityCamera(
      player,
      cutscene.position,
      phase3Facing(cutscene.position, cutscene.rotation),
    );
    if (cutscene.blackout && !state.blackoutSent) {
      try {
        player.camera.fade({
          fadeColor: { red: 0, green: 0, blue: 0 },
          fadeInTime: 0.05,
          holdTime: 2,
          fadeOutTime: 0.05,
        });
      } catch {}
    }
  }
  if (cutscene.blackout) state.blackoutSent = true;
  state.cutsceneTick += 1;
}

function beginVictory() {
  if (!state || state.phase !== INTEGRITY_PHASE.PHASE_3) return;
  state.phase = "victory";
  state.victory = true;
  state.cutsceneTick = 0;
  state.blackoutSent = false;
  const integrity = integrityEntity(P3_ENTITY, PHASE3_DIMENSION);
  if (integrity) {
    try { integrity.teleport(PHASE3_SOURCE.center); } catch {}
  }
  playForParticipants("integrity.boss_end", 1, 1);
}

function tickPhase3() {
  if (!state) return;
  const integrity = integrityEntity(P3_ENTITY, PHASE3_DIMENSION);
  const dying = state.phase3DeathObserved === true || (integrity && (
    hasTag(integrity, "thebrokenscript.dying")
    || callEntityMethod(integrity, "getProperty", "thebrokenscript:dying") === true
  ));
  if (phase3Ended(dying)) {
    beginVictory();
  }
}

function transitionToPhase2() {
  if (!state || state.phase !== INTEGRITY_PHASE.PHASE_1) return false;
  if (!safeDimension(PHASE2_DIMENSION)) return false;
  removePhase1Entities();
  state.phaseTick = 0;
  state.currentFloorId = null;
  state.spawnedFloors = new Set();
  state.phase = INTEGRITY_PHASE.PHASE_2;
  state.integrityId = null;
  bossHooks.setArenaState(true, false);
  preparePhaseSound("integrity.boss_p2");
  schedulePhaseTransfer(INTEGRITY_PHASE.PHASE_2, PHASE2_DIMENSION, PHASE2_LOADING_TAG);
  return true;
}

function transitionToPhase3() {
  if (!state || state.phase !== INTEGRITY_PHASE.PHASE_2) return false;
  const dimension = safeDimension(PHASE3_DIMENSION);
  if (!dimension) return false;
  removePhase2Integrity();
  state.phaseTick = 0;
  state.currentFloorId = null;
  state.phase = INTEGRITY_PHASE.PHASE_3;
  state.integrityId = null;
  state.phase3DeathObserved = false;
  bossHooks.setArenaState(true, false);
  const integrity = spawnAt(dimension, P3_ENTITY, PHASE3_SOURCE.center);
  if (!integrity) return false;
  state.integrityId = integrity.id;
  preparePhaseSound("integrity.boss_p3");
  schedulePhaseTransfer(INTEGRITY_PHASE.PHASE_3, PHASE3_DIMENSION, PHASE3_LOADING_TAG);
  return true;
}

function cleanupEncounter() {
  const oldState = state;
  if (!oldState) return;
  cancelTransferTimeout();
  for (const player of participantPlayers()) {
    removeTag(player, PHASE2_LOADING_TAG);
    removeTag(player, PHASE3_LOADING_TAG);
    try { integrityCamera.clearIntegrityCamera(player); } catch {}
    stopPlayerSounds(player);
  }
  const ids = new Set(oldState.trackedEntityIds);
  for (const dimension of allArenaDimensions()) {
    try {
      for (const entity of dimension.getEntities({ tags: [ARENA_TAG] })) ids.add(entity.id);
    } catch {}
  }
  for (const id of ids) removeEntityId(id);
  bossHooks.setArenaParticipants([]);
  bossHooks.setArenaState(false, false);
  state = null;
}

function onDimensionChange(event) {
  if (!state || !event?.player || !state.participantIds.includes(event.player.id)) return;
  const toId = event.toDimension?.id;
  if (state.phase === INTEGRITY_PHASE.PHASE_2 && toId === PHASE2_DIMENSION) {
    queueDimensionSettle(event.player, PHASE2_LOADING_TAG);
  }
  if (state.phase === INTEGRITY_PHASE.PHASE_3 && toId === PHASE3_DIMENSION) {
    queueDimensionSettle(event.player, PHASE3_LOADING_TAG);
  }
}

function onEntityDie(event) {
  if (!state || state.phase !== INTEGRITY_PHASE.PHASE_3) return;
  if (event?.deadEntity?.id === state.integrityId && event.deadEntity.typeId === P3_ENTITY) {
    state.phase3DeathObserved = true;
  }
}

function installDamageGate() {
  events.subscribeGuarded(
    world.beforeEvents.entityHurt,
    "integrity.runtime.entityHurt",
    "integrity damage gate",
    (event) => {
      const target = event.hurtEntity;
      if (!target || (target.typeId !== P1_ENTITY && target.typeId !== P2_ENTITY)) return;
      const cause = event.damageSource?.cause;
      // IntegrityPhase1Entity and IntegrityPhase2Entity only accept
      // GENERIC_KILL or FELL_OUT_OF_WORLD in Java. Bedrock's stable causes are
      // override and void; all ordinary damage is cancelled.
      if (cause !== EntityDamageCause.override && cause !== EntityDamageCause.void) {
        event.cancel = true;
      }
    },
  );
}

function onTick() {
  if (!state) return;
  state = refreshIntegrityParticipantIds(state, playerRecords());
  bossHooks.setArenaParticipants(state.participantIds);
  if (state.participantIds.length === 0 || !arenaCheckLivingPlayers(participantRecords())) {
    cleanupEncounter();
    return;
  }

  if (state.phase === "victory") {
    tickFinalCutscene();
    return;
  }

  state.phaseTick += 1;
  if (state.phase === INTEGRITY_PHASE.PHASE_1) {
    const intro = phase1IntroStep({
      tick: state.phaseTick,
      introComplete: state.introComplete,
    });
    state.introComplete = intro.introComplete;
    if (intro.spawnChords) {
      spawnPhase1Chords();
      state.terrainQueue.push(...createTerrainQueue(state.center));
      removeTag(integrityEntity(P1_ENTITY), PHASE1_CRAWL_TAG);
    }
    corruptNextTerrain();
    if (state.introComplete && phase1CompletionStep(phase1ChordRecords())) {
      transitionToPhase2();
    }
    return;
  }

  if (state.phase === INTEGRITY_PHASE.PHASE_2) {
    tickPhase2();
    return;
  }

  if (state.phase === INTEGRITY_PHASE.PHASE_3) {
    tickPhase3();
  }
}

export function start(sourcePlayer, requestedPhase = "p1") {
  if (!sourcePlayer || sourcePlayer.typeId !== "minecraft:player") return false;
  cleanupEncounter();
  const sourceDimensionId = sourcePlayer.dimension?.id;
  const sourceLocation = sourcePlayer.location;
  const participants = allPlayers().filter((player) => {
    try {
      return player.dimension.id === sourceDimensionId
        && distance(player.location, sourceLocation) <= ARENA_SOURCE.participantRadius;
    } catch {
      return false;
    }
  });
  if (!participants.some((player) => player.id === sourcePlayer.id)) participants.push(sourcePlayer);
  if (participants.length === 0) return false;

  state = createIntegrityRuntimeState(participants.map((player) => player.id));
  state.generation = ++generation;
  state.center = {
    x: Math.floor(sourceLocation.x),
    y: Math.floor(sourceLocation.y),
    z: Math.floor(sourceLocation.z),
  };
  state.originDimensionId = sourceDimensionId;
  state.trackedEntityIds = [];
  state.spawnedFloors = new Set();
  state.terrainQueue = [];
  bossHooks.setArenaParticipants(state.participantIds);

  const normalized = String(requestedPhase).toLowerCase();
  let started = true;
  if (normalized === "p3" || normalized === "phase3") started = transitionToPhase3();
  else if (normalized === "p2" || normalized === "phase2") started = transitionToPhase2();
  else started = startPhase1();
  if (!started) cleanupEncounter();
  return started;
}

export function stop() {
  if (!state) {
    bossHooks.setArenaParticipants([]);
    bossHooks.setArenaState(false, false);
    return false;
  }
  cleanupEncounter();
  return true;
}

export function next() {
  if (!state) return false;
  let advanced = false;
  if (state.phase === INTEGRITY_PHASE.PHASE_1) advanced = transitionToPhase2();
  else if (state.phase === INTEGRITY_PHASE.PHASE_2) advanced = transitionToPhase3();
  if (!advanced) cleanupEncounter();
  return advanced;
}

export function status() {
  if (!state) return null;
  return {
    phase: state.phase,
    generation: state.generation,
    participantIds: [...state.participantIds],
    phaseTick: state.phaseTick,
    victory: state.victory === true,
  };
}

export function begin(scheduler) {
  if (runtimeStarted) return;
  runtimeStarted = true;
  schedulerRef = scheduler;
  installDamageGate();
  events.subscribeGuarded(
    world.afterEvents.playerDimensionChange,
    "integrity.runtime.playerDimensionChange",
    "integrity transfer settle",
    onDimensionChange,
  );
  events.subscribeGuarded(
    world.afterEvents.entityDie,
    "integrity.runtime.entityDie",
    "integrity victory tracking",
    onEntityDie,
  );
  scheduler.every("tbs.integrity_runtime_tick", 1, onTick);
}
