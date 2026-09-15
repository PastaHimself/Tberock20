import { world } from "@minecraft/server";
import { logger } from "../../core/logging.js";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as dimensions from "../../systems/dimensions.js";
import * as phase3Runtime from "./phase3_runtime.js";
import {
  ARENA_SOURCE,
  INTEGRITY_PHASE,
  PHASE1_SOURCE,
  PHASE2_SOURCE,
  PHASE3_CUTSCENE_SOURCE,
  PHASE3_SOURCE,
  arenaCheckLivingPlayers,
  integrityParticipantIdsWithinRadius,
  phase1Ended,
  phase2Ended,
  phase2NeedsRecoveryTeleport,
  phase3CutsceneState,
} from "../../systems/integrity_arena_model.js";
import { integrityRosterRecords } from "../../systems/integrity_encounter_model.js";
import { clearIntegrityCamera, setIntegrityCamera } from "./integrity_camera.js";

const PHASE3_CUTSCENE = "cutscene";

let arena = null;
let schedulerRegistered = false;

function isValid(entity) {
  if (!entity) return false;
  try { return entity.isValid !== false; } catch { return false; }
}

function health(entity) {
  try { return entity.getComponent("minecraft:health")?.currentValue ?? 0; } catch { return 0; }
}

function isAlive(entity) {
  return isValid(entity) && health(entity) > 0;
}

function hasDyingState(entity) {
  try {
    return entity.hasTag("thebrokenscript.dying")
      || entity.getProperty("thebrokenscript:dying") === true;
  } catch {
    return false;
  }
}

function allPlayers() {
  try { return world.getAllPlayers(); } catch { return []; }
}

function rosterRecords() {
  if (!arena) return [];
  return integrityRosterRecords(arena.participantIds, allPlayers());
}

function setArenaFlags(active, phase1) {
  try {
    world.setDynamicProperty("tbs:arenaActive", active === true);
    world.setDynamicProperty("tbs:arenaPhase1", phase1 === true);
  } catch (error) {
    logger.error("integrity arena: failed to update compatibility flags", error);
  }
  bossHooks.setArenaState(active, phase1);
}

function dimensionFor(id) {
  return dimensions.get(id);
}

function spawnAt(dimension, typeId, location) {
  try {
    const entity = dimension?.spawnEntity(typeId, location);
    if (entity?.id && arena) arena.entityIds.add(entity.id);
    return entity;
  } catch (error) {
    logger.error("integrity arena: failed to spawn " + typeId, error);
    return undefined;
  }
}

function removeTrackedEntities() {
  if (!arena) return;
  for (const id of arena.entityIds) {
    for (const dimensionId of [
      arena.originDimensionId,
      "thebrokenscript:stage2",
      "thebrokenscript:void_shadow",
      "overworld",
      "nether",
      "the_end",
    ]) {
      const dimension = dimensionFor(dimensionId);
      if (!dimension) continue;
      try {
        const entity = dimension.getEntities().find((candidate) => candidate.id === id);
        if (entity) entity.remove();
      } catch {}
    }
  }
  arena.entityIds.clear();
}

function playerSurfaceLocation(dimension, center) {
  try {
    const top = dimension.getTopmostBlock({ x: Math.floor(center.x), z: Math.floor(center.z) });
    return {
      x: center.x,
      y: (top?.location?.y ?? center.y) + 1,
      z: center.z,
    };
  } catch {
    return { ...center };
  }
}

function currentPhaseEntity(typeId) {
  if (!arena) return null;
  for (const dimensionId of [
    arena.originDimensionId,
    "thebrokenscript:stage2",
    "thebrokenscript:void_shadow",
  ]) {
    const dimension = dimensionFor(dimensionId);
    if (!dimension) continue;
    try {
      const entity = dimension.getEntities({ type: typeId }).find((candidate) => (
        arena.entityIds.has(candidate.id)
      ));
      if (entity) return entity;
    } catch {}
  }
  return null;
}

function teleportRoster(dimensionId, location) {
  for (const { player } of rosterRecords()) {
    void dimensions.teleportWhenReady(player, dimensionId, location).catch((error) => {
      logger.error("integrity arena: roster transfer to " + dimensionId + " failed", error);
    });
  }
}

function beginPhase1() {
  const dimension = dimensionFor(arena.originDimensionId);
  if (!dimension) return false;
  const entity = spawnAt(
    dimension,
    "thebrokenscript:integrity_phase_1",
    playerSurfaceLocation(dimension, arena.center),
  );
  if (!entity) return false;
  arena.phaseEntityId = entity.id;
  arena.chordIds = [];
  arena.chordsSpawned = false;
  setArenaFlags(true, true);
  return true;
}

function spawnPhase1Chords() {
  const dimension = dimensionFor(arena.originDimensionId);
  if (!dimension) return;
  const sourceY = currentPhaseEntity("thebrokenscript:integrity_phase_1")?.location?.y ?? arena.center.y;
  for (let index = 0; index < PHASE1_SOURCE.chordMaxCount; index += 1) {
    const angle = (Math.PI * 2 * index) / PHASE1_SOURCE.chordMaxCount;
    const entity = spawnAt(dimension, "thebrokenscript:chord", {
      x: arena.center.x + Math.cos(angle) * PHASE1_SOURCE.chordRadius,
      y: sourceY,
      z: arena.center.z + Math.sin(angle) * PHASE1_SOURCE.chordRadius,
    });
    if (entity?.id) arena.chordIds.push(entity.id);
  }
  arena.chordsSpawned = true;
}

function trackedChords() {
  if (!arena) return [];
  const result = [];
  for (const id of arena.chordIds) {
    let entityForId = null;
    for (const dimensionId of [arena.originDimensionId, "thebrokenscript:stage2"]) {
      const dimension = dimensionFor(dimensionId);
      if (!dimension) continue;
      try {
        const entity = dimension.getEntities({ type: "thebrokenscript:chord" })
          .find((candidate) => candidate.id === id);
        if (entity) {
          entityForId = entity;
          break;
        }
      } catch {}
    }
    // Keep ids for removed entities so an empty query cannot be mistaken for
    // Java's `entities.stream().allMatch(...)` over the still-tracked chords.
    result.push({ id, alive: isAlive(entityForId) });
  }
  return result;
}

function beginPhase2() {
  const dimension = dimensionFor("thebrokenscript:stage2");
  if (!dimension) return false;
  removeTrackedEntities();
  arena.phase = INTEGRITY_PHASE.PHASE_2;
  arena.phaseTicks = 0;
  arena.phaseEntityId = null;
  const entity = spawnAt(dimension, "thebrokenscript:integrity_phase_2", PHASE2_SOURCE.recoveryTeleport);
  if (!entity) return false;
  arena.phaseEntityId = entity.id;
  setArenaFlags(true, false);
  return true;
}

function tickPhase2() {
  if (arena.phaseTicks === PHASE2_SOURCE.transferDelayTicks) {
    teleportRoster("thebrokenscript:stage2", PHASE2_SOURCE.recoveryTeleport);
  }
  for (const { player } of rosterRecords()) {
    try {
      if (player.dimension.id !== "thebrokenscript:stage2") continue;
    } catch {
      continue;
    }
    const blockY = Math.floor(player.location.y);
    if (phase2NeedsRecoveryTeleport(blockY)) {
      try { player.teleport(PHASE2_SOURCE.recoveryTeleport, { dimension: dimensionFor("thebrokenscript:stage2") }); } catch {}
    }
  }
  // Phase2.ended is never set by Java. Keep the call explicit so this source
  // fact cannot silently turn into an HP threshold later.
  if (phase2Ended()) return;
}

function beginPhase3() {
  const dimension = dimensionFor("thebrokenscript:void_shadow");
  if (!dimension) return false;
  removeTrackedEntities();
  arena.phase = INTEGRITY_PHASE.PHASE_3;
  arena.phaseTicks = 0;
  arena.phaseEntityId = null;
  phase3Runtime.setParticipantIds(arena.participantIds);
  const entity = spawnAt(dimension, "thebrokenscript:integrity_phase_3", PHASE3_SOURCE.center);
  if (!entity) return false;
  arena.phaseEntityId = entity.id;
  setArenaFlags(true, false);
  return true;
}

function tickPhase3() {
  if (arena.phaseTicks === PHASE3_SOURCE.transferDelayTicks) {
    teleportRoster("thebrokenscript:void_shadow", PHASE3_SOURCE.center);
  }
  const entity = currentPhaseEntity("thebrokenscript:integrity_phase_3");
  if (entity && hasDyingState(entity) && arena.cutsceneTicks === null) {
    arena.cutsceneTicks = 0;
    arena.blackoutShown = false;
  }
  if (arena.cutsceneTicks !== null) tickCutscene();
}

function cutsceneFacingLocation(state) {
  const yaw = (state.rotation.y * Math.PI) / 180;
  return {
    x: state.position.x + Math.sin(yaw),
    y: state.position.y,
    z: state.position.z + Math.cos(yaw),
  };
}

function tickCutscene() {
  arena.cutsceneTicks += 1;
  const cutscene = phase3CutsceneState(arena.cutsceneTicks);
  const facingLocation = cutsceneFacingLocation(cutscene);
  for (const { player } of rosterRecords()) {
    setIntegrityCamera(player, cutscene.position, facingLocation);
    if (cutscene.blackout && !arena.blackoutShown) {
      try {
        player.camera.fade({
          fadeColor: { red: 0, green: 0, blue: 0 },
          fadeTime: { fadeInTime: 0, holdTime: PHASE3_CUTSCENE_SOURCE.blackoutTicks / 20, fadeOutTime: 0 },
        });
      } catch {}
    }
  }
  if (cutscene.blackout) arena.blackoutShown = true;
  if (cutscene.ended) stop("victory");
}

function refreshArenaRoster() {
  const records = rosterRecords();
  const participants = records.map(({ player }) => ({
    connected: true,
    alive: isAlive(player),
  }));
  return {
    records,
    living: arenaCheckLivingPlayers(participants),
  };
}

function transitionToNextPhase() {
  if (!arena) return { accepted: false, reason: "no_active_arena" };
  if (arena.phase === INTEGRITY_PHASE.PHASE_1) {
    if (!beginPhase2()) {
      stop("phase_spawn_failed");
      return { accepted: false, reason: "phase_spawn_failed" };
    }
    return { accepted: true, phase: arena.phase };
  }
  if (arena.phase === INTEGRITY_PHASE.PHASE_2) {
    if (!beginPhase3()) {
      stop("phase_spawn_failed");
      return { accepted: false, reason: "phase_spawn_failed" };
    }
    return { accepted: true, phase: arena.phase };
  }
  return { accepted: false, reason: "phase_3_has_no_next_phase" };
}

function tick() {
  if (!arena) return;
  const roster = refreshArenaRoster();
  if (!roster.living) {
    stop("arena_lost");
    return;
  }
  arena.phaseTicks += 1;
  if (arena.phase === INTEGRITY_PHASE.PHASE_1) {
    if (arena.phaseTicks === PHASE1_SOURCE.introDelayTicks) spawnPhase1Chords();
    if (arena.chordsSpawned && phase1Ended(trackedChords())) transitionToNextPhase();
    return;
  }
  if (arena.phase === INTEGRITY_PHASE.PHASE_2) {
    tickPhase2();
    return;
  }
  if (arena.phase === INTEGRITY_PHASE.PHASE_3) {
    tickPhase3();
    return;
  }
  if (arena.phase === PHASE3_CUTSCENE) tickCutscene();
}

export function begin(scheduler) {
  if (schedulerRegistered) return;
  schedulerRegistered = true;
  scheduler.every("tbs.integrity_arena_tick", 1, tick);
}

/**
 * @param {import("@minecraft/server").Player} triggerPlayer
 * @param {"phase1"|"phase3"} [requestedPhase]
 */
export function start(triggerPlayer, requestedPhase = INTEGRITY_PHASE.PHASE_1) {
  if (!triggerPlayer?.id || triggerPlayer.typeId !== "minecraft:player") {
    return { accepted: false, reason: "player_required" };
  }
  if (arena) return { accepted: false, reason: "arena_already_active" };
  const players = allPlayers().filter((player) => {
    try { return player.dimension.id === triggerPlayer.dimension.id; } catch { return false; }
  });
  const center = {
    x: Math.floor(triggerPlayer.location.x) + 0.5,
    y: Math.floor(triggerPlayer.location.y) + 0.5,
    z: Math.floor(triggerPlayer.location.z) + 0.5,
  };
  const participantIds = integrityParticipantIdsWithinRadius(players, center, ARENA_SOURCE.participantRadius);
  if (participantIds.length === 0) return { accepted: false, reason: "no_participants" };

  arena = {
    center,
    originDimensionId: triggerPlayer.dimension.id,
    participantIds,
    phase: requestedPhase === INTEGRITY_PHASE.PHASE_3
      ? INTEGRITY_PHASE.PHASE_3
      : INTEGRITY_PHASE.PHASE_1,
    phaseTicks: 0,
    phaseEntityId: null,
    chordIds: [],
    chordsSpawned: false,
    entityIds: new Set(),
    cutsceneTicks: null,
    blackoutShown: false,
  };
  phase3Runtime.clearParticipantIds();
  const started = arena.phase === INTEGRITY_PHASE.PHASE_3 ? beginPhase3() : beginPhase1();
  if (!started) {
    stop("phase_spawn_failed");
    return { accepted: false, reason: "phase_spawn_failed" };
  }
  return { accepted: true, participantIds: [...participantIds] };
}

export function next() {
  if (!arena) return { accepted: false, reason: "no_active_arena" };
  return transitionToNextPhase();
}

export function stop(reason = "manual") {
  if (!arena) return;
  const players = rosterRecords().map(({ player }) => player);
  for (const player of players) clearIntegrityCamera(player);
  removeTrackedEntities();
  phase3Runtime.cleanup();
  setArenaFlags(false, false);
  arena = null;
  logger.info("integrity arena stopped: " + reason);
}

export function getState() {
  if (!arena) return null;
  return {
    phase: arena.cutsceneTicks !== null ? PHASE3_CUTSCENE : arena.phase,
    phaseTicks: arena.phaseTicks,
    participantIds: [...arena.participantIds],
  };
}

export function getParticipantIds() {
  return arena ? [...arena.participantIds] : [];
}
