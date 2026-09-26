import * as operationDiagnostics from "../../core/operation_diagnostics.js";
﻿import { world, system } from "@minecraft/server";
import * as worldState from "../../systems/world_state.js";
import * as playerState from "../../systems/player_state.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as gaze from "../../systems/ai/gaze.js";
import * as effects from "../../systems/ai/effects.js";
import * as spawnHelpers from "../../systems/ai/spawn_helpers.js";
import { logger } from "../../core/logging.js";
import { showScreen } from "../../systems/screen_overlay.js";

const CIRCUIT_FAMILY = [
  "thebrokenscript:circuit",
  "thebrokenscript:circuit_stalk",
  "thebrokenscript:circuit_stare",
  "thebrokenscript:circuit_mineshaft_walk",
  "thebrokenscript:circuit_mineshaft_stare",
  "thebrokenscript:circuit_mineshaft_flee"
];

const GRACE_TICKS = 160;
const STALK_LIFETIME = 10000;
const FLEE_LIFETIME = 300;
const CIRCUIT_CHASE_LIFETIME = 800;

const entityTimers = new Map();

function getTimer(entity) {
  const t = entityTimers.get(entity.id);
  return t ?? 0;
}
function setTimer(entity, v) { entityTimers.set(entity.id, v); }

export function begin(scheduler) {
  scheduler.every("tbs.circuit_tick", 5, onCircuitTick);
}

function onCircuitTick() {
  for (const dim of [world.getDimension("overworld"), world.getDimension("nether"), world.getDimension("the_end")]) {
    let entities = [];
    try { entities = dim.getEntities({ families: ["thebrokenscript_circuit"] }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.circuit.circuit_controller.js.39", "best-effort Bedrock API fallback", error); continue; }
    for (const e of entities) {
      try { tickEntity(e); } catch (err) { logger.error(`circuit tick ${e.typeId}`, err); }
    }
  }
}

function tickEntity(entity) {
  const id = entity.typeId;
  if (id === "thebrokenscript:circuit") tickCircuit(entity);
  else if (id === "thebrokenscript:circuit_stalk") tickStalk(entity);
  else if (id === "thebrokenscript:circuit_stare") tickStare(entity);
  else if (id === "thebrokenscript:circuit_mineshaft_walk") tickMineshaftWalk(entity);
  else if (id === "thebrokenscript:circuit_mineshaft_stare") tickMineshaftStare(entity);
  else if (id === "thebrokenscript:circuit_mineshaft_flee") tickFlee(entity);
}

function tickStalk(entity) {
  let t = getTimer(entity);
  if (t === 0) { setTimer(entity, STALK_LIFETIME); t = STALK_LIFETIME; }
  t--; setTimer(entity, t);
  if (t <= 0) { worldState.set("hasCircuitSpawned", false); entity.remove(); entityTimers.delete(entity.id); return; }

  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), entity, 256);
  if (!player) return;
  if (!gaze.isLookingAtEntity(player, entity, 14)) return;

  if (Math.random() < 0.5) {
    showScreen(player, "blick", 10);
    entity.remove(); entityTimers.delete(entity.id); return;
  }
  if (Math.random() < 0.7) {
    const spawned = spawnHelpers.trySummon(entity.dimension, "thebrokenscript:circuit", entity.location);
    if (spawned) { try { spawned.setRotation({ x: 0, y: Math.random() * 360 }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.circuit.circuit_controller.js.72", "best-effort Bedrock API fallback", error);} }
  }
  effects.darkness(player, 5);
  entity.remove(); entityTimers.delete(entity.id);
}

function tickStare(entity) {
  let t = getTimer(entity);
  if (t === 0) { setTimer(entity, STALK_LIFETIME); t = STALK_LIFETIME; }
  t--; setTimer(entity, t);
  if (t <= 0) { entity.remove(); entityTimers.delete(entity.id); return; }
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), entity, 256);
  if (!player) return;
  try { entity.lookAt?.(player.location); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.circuit.circuit_controller.js.85", "best-effort Bedrock API fallback", error);}
  if (!gaze.isLookingAtEntity(player, entity, 14)) return;
  if (Math.random() < 0.5) {
    showScreen(player, "blick", 10);
    entity.remove(); entityTimers.delete(entity.id); return;
  }
  if (Math.random() < 0.7) {
    const spawned = spawnHelpers.trySummon(entity.dimension, "thebrokenscript:circuit", entity.location);
    if (spawned) { try { spawned.setRotation({ x: 0, y: Math.random() * 360 }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.circuit.circuit_controller.js.93", "best-effort Bedrock API fallback", error);} }
  }
  try { player.addEffect("darkness", 100, { amplifier: 0, showParticles: false }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.circuit.circuit_controller.js.95", "best-effort Bedrock API fallback", error);}
  entity.remove(); entityTimers.delete(entity.id);
}

function tickMineshaftWalk(entity) {
  let t = getTimer(entity);
  if (t === 0) { setTimer(entity, STALK_LIFETIME); t = STALK_LIFETIME; }
  t--; setTimer(entity, t);
  if (t <= 0) { worldState.set("hasCircuitSpawned", false); entity.remove(); entityTimers.delete(entity.id); return; }
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), entity, 256);
  if (!player) return;
  if (entityFinder.countEntitiesInRange(entity.dimension, entity.location, 20, ["thebrokenscript:circuit"]) > 0) return;
  if (!gaze.isLookingAtEntity(player, entity, 12)) return;
  const spawned = spawnHelpers.trySummon(entity.dimension, "thebrokenscript:circuit_mineshaft_flee", entity.location);
  if (spawned) { entity.remove(); entityTimers.delete(entity.id); }
}

function tickMineshaftStare(entity) {
  let t = getTimer(entity);
  if (t === 0) { setTimer(entity, STALK_LIFETIME); t = STALK_LIFETIME; }
  t--; setTimer(entity, t);
  if (t <= 0) { entity.remove(); entityTimers.delete(entity.id); return; }
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), entity, 256);
  if (!player) return;
  try { entity.lookAt?.({ x: player.location.x, y: player.location.y + 1, z: player.location.z }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.circuit.circuit_controller.js.119", "best-effort Bedrock API fallback", error);}
  if (distance(entity.location, player.location) > 8) return;
  if (Math.random() < 0.5) { effects.blindness(player, 2); } else {
    const spawned = spawnHelpers.trySummon(entity.dimension, "thebrokenscript:circuit", entity.location);
    if (spawned) { entity.remove(); entityTimers.delete(entity.id); }
  }
}

function tickFlee(entity) {
  let t = getTimer(entity);
  if (t === 0) { setTimer(entity, FLEE_LIFETIME); t = FLEE_LIFETIME; }
  const near = entityFinder.closestPlayerForEntity(world.getAllPlayers(), entity, 25);
  if (!near) { t--; setTimer(entity, t); if (t <= 0) {
    const spawned = spawnHelpers.trySummon(entity.dimension, "thebrokenscript:circuit_mineshaft_walk", entity.location);
    entity.remove(); entityTimers.delete(entity.id); if (spawned) spawnHelpers.applyRandomRotation(spawned);
  }}
}

function tickCircuit(entity) {
  let t = getTimer(entity);
  if (t === 0) { setTimer(entity, CIRCUIT_CHASE_LIFETIME); t = CIRCUIT_CHASE_LIFETIME; }
  t--; setTimer(entity, t);
  if (t <= 0) { worldState.set("hasCircuitSpawned", false); entity.remove(); entityTimers.delete(entity.id); return; }
  if (t % 46 === 0) {
    for (const p of world.getAllPlayers()) {
      if (distance(p.location, entity.location) > 128) continue;
      playerState.set(p, "noWayOutFrame", (playerState.get(p, "noWayOutFrame") + 1) % 6);
      if (Math.random() < 0.23) { p.playSound?.("thebrokenscript:circuit_jumpscare_sound"); }
    }
  }
  if (Math.random() < 0.01) {
    const p = entityFinder.closestPlayerForEntity(world.getAllPlayers(), entity, 128);
    if (p) playerState.set(p, "noWayOutFrame", (playerState.get(p, "noWayOutFrame") + 1) % 6);
  }
}

function distance(a, b) { return Math.hypot(a.x - b.x, a.y - b.y, a.z - b.z); }
