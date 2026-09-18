import { world, system } from "@minecraft/server";
import { EntityDamageCause, EquipmentSlot } from "@minecraft/server";
import * as worldState from "../../systems/world_state.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as gaze from "../../systems/ai/gaze.js";
import * as effects from "../../systems/ai/effects.js";
import * as spawnHelpers from "../../systems/ai/spawn_helpers.js";
import * as operationDiagnostics from "../../core/operation_diagnostics.js";
import * as perf from "../../systems/perf.js";

// ── constants from decompiled sources ──────────────────────────────────────
// stare: life 500, LOOKABLE aura ≤512 + slowness 60t amp55
// siluet: life 18000, ≤15 LOS vanish/chase, ≤20 gaze lightning/text-madness
// siluet_stare layer: 620 find, ≤10 trigger, ≤45 gaze; static variant
// siluet_chase / he_chase: despawn 800, target 800, fake time 1%, block-break front 3×h+1
// hallucinations: life 600, chase 1.4 speed, poof at ≤1 with hallucination_fade + blick
// he: rare_thing_spawn + lightning + rain, life 18000, mirror branches → he_chase
// deceiver: mimic player, ≤10 → circuit_deceive + blindness5 + 70% circuit after 60t
// faraway: life 1600, seen-delay ≥25 → baby/fard/phantom vanish variants
const STARE_LIFE = 500;
const SILUET_LIFE = 18000;
const CHASE_LIFE = 800;
const HALLUCINATION_LIFE = 600;
const FARAWAY_LIFE = 1600;

const timers = new Map();

function getNum(e, key, def) {
  const m = timers.get(e.id);
  if (!m) return def;
  return m[key] ?? def;
}
function setNum(e, key, v) {
  let m = timers.get(e.id);
  if (!m) { m = {}; timers.set(e.id, m); }
  m[key] = v;
}
function deleteTimers(e) { timers.delete(e.id); }
function distance(a, b) { return Math.hypot(a.x - b.x, a.y - b.y, a.z - b.z); }

function tryPlaySoundAt(dim, loc, sound, vol = 1, pitch = 1) {
  try { dim.playSound(sound, loc, { volume: vol, pitch }); return; } catch (error) {
    operationDiagnostics.warnOnce("humanoid.sound.dimension", `humanoid: dimension sound '${sound}' unavailable; using player fallback`, error);
  }
  for (const p of world.getAllPlayers()) {
    if (p.dimension.id !== dim.id) continue;
    try { p.playSound(sound, { volume: vol, pitch }); } catch (error) {
      operationDiagnostics.warnOnce("humanoid.sound.player", `humanoid: player sound fallback '${sound}' failed`, error);
    }
  }
}

function setFakeTime(dim, t) {
  try { dim.runCommand(`time set ${t}`); } catch (error) {
    operationDiagnostics.warnOnce("humanoid.fake_time", `humanoid: fake-time command '${t}' failed`, error);
  }
}

function title(player, text, stayTicks = 10) {
  try { player.onScreenDisplay.setTitle(text, { fadeInDuration: 0, stayDuration: stayTicks, fadeOutDuration: 0 }); } catch (error) {
    operationDiagnostics.warnOnce("humanoid.title", "humanoid: title presentation failed", error);
  }
}

function hasLineOfSightApprox(player, entity) {
  try {
    const origin = { x: player.location.x, y: player.location.y + 1.62, z: player.location.z };
    const dir = { x: entity.location.x - origin.x, y: (entity.location.y + 1) - origin.y, z: entity.location.z - origin.z };
    const len = Math.hypot(dir.x, dir.y, dir.z);
    if (len === 0) return true;
    const n = { x: dir.x / len, y: dir.y / len, z: dir.z / len };
    const hit = player.dimension.getBlockFromRay(origin, n, { maxDistance: len, includeLiquidBlocks: false, includePassableBlocks: false });
    if (!hit) return true;
    const hitDist = Math.hypot(hit.block.location.x - origin.x, hit.block.location.y - origin.y, hit.block.location.z - origin.z);
    return hitDist > len - 1.2;
  } catch (error) {
    operationDiagnostics.warnOnce("humanoid.line_of_sight", "humanoid: line-of-sight probe failed; preserving visible fallback", error);
    return true;
  }
}

function inFovCone(player, entity, fovDeg = 70) {
  try {
    const view = player.getViewDirection();
    const to = { x: entity.location.x - player.location.x, y: (entity.location.y + 1.2) - (player.location.y + 1.62), z: entity.location.z - player.location.z };
    const len = Math.hypot(to.x, to.y, to.z) || 1;
    const n = { x: to.x / len, y: to.y / len, z: to.z / len };
    return (view.x * n.x + view.y * n.y + view.z * n.z) >= Math.cos(fovDeg * Math.PI / 360);
  } catch (error) {
    operationDiagnostics.warnOnce("humanoid.fov", "humanoid: FOV probe failed; preserving not-looking fallback", error);
    return false;
  }
}

// vanishing branch shared by siluet/he/stare watchers:
// 50%: discard + blindness 35 amp1 + null_is_here_loop to players ≤25 + 70% midnight
// else: discard + spawn chaser
function vanishOrChase(e, chaserId, victimPlayer) {
  try { e.remove(); } catch (error) {
    operationDiagnostics.warnOnce("humanoid.vanish_remove", "humanoid: vanish removal failed", error);
  }
  deleteTimers(e);
  if (Math.random() < 0.5) {
    if (victimPlayer) { try { victimPlayer.addEffect("blindness", 35, { amplifier: 1, showParticles: false }); } catch (error) {
      operationDiagnostics.warnOnce("humanoid.vanish_blindness", "humanoid: vanish blindness effect failed", error);
    } }
    for (const p of world.getAllPlayers()) {
      if (p.dimension.id !== e.dimension.id) continue;
      if (distance(p.location, e.location) > 25) continue;
      try { p.playSound("thebrokenscript:null_is_here_loop", { volume: 1, pitch: 1 }); } catch (error) {
        operationDiagnostics.warnOnce("humanoid.vanish_sound", "humanoid: vanish sound failed", error);
      }
    }
    if (Math.random() < 0.7) setFakeTime(e.dimension, "midnight");
  } else {
    spawnHelpers.trySummon(e.dimension, chaserId, e.location);
  }
}

// gaze branch shared by siluet/he:
// 50%: force look + lightning at player pos (surface approx) + rotated chase spawn
// else: text_madness_1 + cantyousee overlay
function gazeReaction(e, chaserId, player) {
  try { e.remove(); } catch (error) {
    operationDiagnostics.warnOnce("humanoid.gaze_remove", "humanoid: gaze reaction removal failed", error);
  }
  deleteTimers(e);
  // force look at where entity stood
  try {
    const dx = e.location.x - player.location.x;
    const dy = (e.location.y + 1) - (player.location.y + 1.62);
    const dz = e.location.z - player.location.z;
    const yaw = Math.atan2(-dx, dz) * 180 / Math.PI;
    const dist = Math.hypot(dx, dz);
    const pitch = -Math.atan2(dy, dist) * 180 / Math.PI;
    player.teleport(player.location, { rotation: { x: pitch, y: yaw } });
  } catch (error) {
    operationDiagnostics.warnOnce("humanoid.gaze_look", "humanoid: gaze reaction rotation failed", error);
  }
  if (Math.random() < 0.5) {
    try { e.dimension.spawnEntity("minecraft:lightning_bolt", player.location); } catch (error) {
      operationDiagnostics.warnOnce("humanoid.gaze_lightning", "humanoid: gaze lightning spawn failed", error);
    }
    const spawned = spawnHelpers.trySummon(e.dimension, chaserId, e.location);
    if (spawned) spawnHelpers.applyRandomRotation(spawned);
  } else {
    tryPlaySoundAt(e.dimension, player.location, "thebrokenscript:text_madness_1", 10, 0);
    title(player, "cantyousee", 10);
  }
}

export function begin(scheduler) {
  scheduler.every("tbs.humanoid_tick", 1, onTick);
  try {
    world.afterEvents.entityDie.subscribe((ev) => {
      try {
        if (ev.deadEntity.typeId !== "minecraft:player") return;
        const deadPlayer = /** @type {import("@minecraft/server").Player} */ (ev.deadEntity);
        const killer = ev.damageSource?.damagingEntity;
        if (!killer) return;
        if (killer.typeId === "thebrokenscript:siluet_chase" || killer.typeId === "thebrokenscript:he_chase") {
          // awardKillScore: discard + 30% tryCrash (kick approximation)
          try { killer.remove(); deleteTimers(killer); } catch (error) {
            operationDiagnostics.warnOnce("humanoid.death_cleanup", "humanoid: death cleanup failed", error);
          }
          if (Math.random() < 0.3) {
            system.runTimeout(() => {
              try {
                const safeName = deadPlayer.name.replace(/"/g, '\\"');
                deadPlayer.dimension.runCommand(`kick "${safeName}" §cYou were caught.`);
              } catch (error) {
                operationDiagnostics.warnOnce("humanoid.death_kick", "humanoid: death follow-up kick failed", error);
              }
            }, 10);
          }
        }
      } catch (error) {
        operationDiagnostics.errorOnce("humanoid.death_event", "humanoid: death follow-up failed", error);
      }
    });
  } catch (error) {
    operationDiagnostics.errorOnce("humanoid.death_subscription", "humanoid: death-event subscription failed", error);
  }
}

function onTick() {
  if (!perf.hasPlayers(system.currentTick)) return; // perf: idle server short-circuit (Chunk 16)
  let list = [];
  try { list = world.getDimension("overworld").getEntities({ families: ["thebrokenscript_humanoid"] }); } catch (error) {
    operationDiagnostics.warnOnce("humanoid.entity_query", "humanoid: entity query failed; skipping this tick", error);
    return;
  }
  for (const e of list) {
    try { tickEntity(e); } catch (err) {
      operationDiagnostics.errorOnce(`humanoid.tick.${e.typeId}`, `humanoid: controller tick failed for ${e.typeId}`, err);
    }
  }
}

function tickEntity(e) {
  switch (e.typeId) {
    case "thebrokenscript:stare": return tickStare(e);
    case "thebrokenscript:siluet": return tickSiluet(e);
    case "thebrokenscript:siluet_stare": return tickSiluetStare(e);
    case "thebrokenscript:siluet_chase":
    case "thebrokenscript:he_chase": return tickChase(e);
    case "thebrokenscript:siluet_hallucination":
    case "thebrokenscript:he_hallucination": return tickHallucination(e);
    case "thebrokenscript:he": return tickHe(e);
    case "thebrokenscript:deceiver": return tickDeceiver(e);
    case "thebrokenscript:faraway": return tickFaraway(e);
  }
}

// ── Stare: forces LOOKABLE mobs to face the nearest player ──────────────────
const LOOKABLE_TYPES = [
  "minecraft:cow", "minecraft:sheep", "minecraft:chicken", "minecraft:cat",
  "minecraft:villager", "minecraft:villager_v2", "minecraft:zombie",
  "minecraft:pig", "minecraft:rabbit", "minecraft:horse", "minecraft:donkey",
  "minecraft:wolf", "minecraft:fox", "minecraft:goat", "minecraft:frog",
  "minecraft:skeleton", "minecraft:spider", "minecraft:creeper", "minecraft:enderman"
];
function tickStare(e) {
  let life = getNum(e, "life", STARE_LIFE);
  if (!timers.has(e.id)) { life = STARE_LIFE; timers.set(e.id, { life }); }
  life--; setNum(e, "life", life);
  if (life <= 0) { try { e.remove(); } catch (error) {
    operationDiagnostics.warnOnce("humanoid.expired_remove", "humanoid: expired entity removal failed", error);
  } deleteTimers(e); return; }
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 512);
  if (!player) return;
  try {
    const mobs = e.dimension.getEntities({ location: e.location, maxDistance: 512 });
    for (const mob of mobs) {
      if (mob.id === e.id) continue;
      if (!LOOKABLE_TYPES.includes(mob.typeId)) continue;
      try { mob.lookAt?.(player.location); } catch (error) {
        operationDiagnostics.warnOnce("humanoid.look_at", "humanoid: look-at operation failed; using rotation fallback", error);
        try {
          const dx = player.location.x - mob.location.x;
          const dz = player.location.z - mob.location.z;
          const yaw = Math.atan2(-dx, dz) * 180 / Math.PI;
          mob.teleport(mob.location, { rotation: { x: 0, y: yaw } });
        } catch (rotationError) {
          operationDiagnostics.warnOnce("humanoid.look_at_rotation", "humanoid: look-at rotation fallback failed", rotationError);
        }
      }
      try { mob.addEffect("slowness", 60, { amplifier: 55, showParticles: false }); } catch (error) {
        operationDiagnostics.warnOnce("humanoid.stare_effect", "humanoid: stare slowness effect failed", error);
      }
    }
  } catch (error) {
    operationDiagnostics.warnOnce("humanoid.stare_query", "humanoid: lookable-entity query failed", error);
  }
}

// ── Siluet watcher (base layer, SiluetEntity.baseTick) ──────────────────────
function tickSiluet(e) {
  let life = getNum(e, "life", SILUET_LIFE);
  if (!timers.has(e.id)) { life = SILUET_LIFE; timers.set(e.id, { life }); }
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 512);
  if (player) {
    try { e.lookAt?.(player.location); } catch (error) {
      operationDiagnostics.warnOnce("humanoid.siluet_look", "humanoid: siluet look-at failed", error);
    }
    // rocket easter egg (funnySetting 1%) — config not yet registered; ledgered skip
    if (distance(e.location, player.location) < 15 && hasLineOfSightApprox(player, e)) {
      vanishOrChase(e, "thebrokenscript:siluet_chase", player);
      return;
    }
    if (distance(e.location, player.location) < 20 && gaze.isLookingAtEntity(player, e, 14)) {
      gazeReaction(e, "thebrokenscript:siluet_chase", player);
      return;
    }
  }
  // isDay → discard + null particle burst
  try {
    const time = world.getTimeOfDay();
    // audit: Bedrock time-of-day adapter for the Java night-window predicate.
    if (time >= 23000 || time < 1000) {
      try { e.dimension.spawnParticle("minecraft:basic_smoke_particle", e.location); } catch (error) {
        operationDiagnostics.warnOnce("humanoid.day_particle", "humanoid: daylight particle failed", error);
      }
      try { e.remove(); } catch (error) {
        operationDiagnostics.warnOnce("humanoid.day_remove", "humanoid: daylight cleanup removal failed", error);
      } deleteTimers(e); return;
    }
  } catch (error) {
    operationDiagnostics.warnOnce("humanoid.time_query", "humanoid: time-of-day query failed; preserving active fallback", error);
  }
  life--; setNum(e, "life", life);
  if (life <= 0) {
    try { e.remove(); } catch (error) {
      operationDiagnostics.warnOnce("humanoid.life_remove", "humanoid: lifetime removal failed", error);
    } deleteTimers(e);
    if (Math.random() < 0.01) {
      const spawned = spawnHelpers.trySummon(e.dimension, "thebrokenscript:siluet_chase", e.location);
      if (spawned) spawnHelpers.applyRandomRotation(spawned);
    }
  }
}

// ── Siluet stare (extends siluet: own trigger layers on top of base) ────────
function tickSiluetStare(e) {
  // base siluet layer first (mirrors super.baseTick())
  tickSiluet(e);
  if (!e.isValid) return;
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 620);
  if (!player) return;
  try { e.lookAt?.(player.location); } catch (error) {
    operationDiagnostics.warnOnce("humanoid.chase_look", "humanoid: chase look-at failed", error);
  }
  if (distance(e.location, player.location) < 10) {
    vanishOrChase(e, "thebrokenscript:siluet_chase", player);
    return;
  }
  if (distance(e.location, player.location) < 45 && gaze.isLookingAtEntity(player, e, 14)) {
    gazeReaction(e, "thebrokenscript:siluet_chase", player);
  }
}

// ── Chasers (siluet_chase / he_chase) ────────────────────────────────────────
function tickChase(e) {
  let despawn = getNum(e, "despawn", CHASE_LIFE);
  if (!timers.has(e.id)) { despawn = CHASE_LIFE; timers.set(e.id, { despawn }); }
  despawn++; setNum(e, "despawn", despawn);
  if (despawn > CHASE_LIFE) { try { e.remove(); } catch (error) {
    operationDiagnostics.warnOnce("humanoid.chase_remove", "humanoid: chase despawn removal failed", error);
  } deleteTimers(e); return; }

  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 800);
  if (!player) return;
  try { e.lookAt?.(player.location); } catch {}

  // midnight/day fake 1% each per tick
  const roll = Math.random();
  if (roll < 0.01) setFakeTime(e.dimension, "midnight");
  else if (roll < 0.02) setFakeTime(e.dimension, "day");

  const dist = distance(e.location, player.location);
  const yDiff = Math.abs(player.location.y - e.location.y);

  // melee every 20 ticks when within reach (native attack goal absent in stat-block BP)
  if (dist < 3 && system.currentTick % 20 === 0) {
    try { player.applyDamage(13, { cause: EntityDamageCause.entityAttack, damagingEntity: e }); } catch (error) {
      operationDiagnostics.warnOnce("humanoid.melee_damage", "humanoid: melee damage failed; using un-attributed fallback", error);
      try { player.applyDamage(13); } catch (fallbackError) {
        operationDiagnostics.errorOnce("humanoid.melee_damage_fallback", "humanoid: melee damage fallback failed", fallbackError);
      }
    }
  }

  // block-break front 3×h+1 when stuck/near & yDiff ≤ 3 (rate-limited every 10 ticks)
  if ((dist < 10 || yDiff <= 3) && system.currentTick % 10 === 0 && yDiff <= 6) {
    breakBlocksInFront(e);
  }
  // step-height analogue: teleport up toward player when yDiff > 3
  if (yDiff > 3 && system.currentTick % 20 === 0) {
    try { e.teleport({ x: e.location.x, y: e.location.y + 1, z: e.location.z }); } catch (error) {
      operationDiagnostics.warnOnce("humanoid.step_teleport", "humanoid: step-height teleport failed", error);
    }
  }
}

const HUMANOID_UNBREAKABLE = new Set([
  "minecraft:bedrock", "minecraft:barrier", "minecraft:border_block",
  "minecraft:command_block", "minecraft:chain_command_block", "minecraft:repeating_command_block",
  "minecraft:end_portal", "minecraft:end_portal_frame", "minecraft:nether_portal",
  "minecraft:structure_block", "minecraft:jigsaw", "minecraft:allow", "minecraft:deny",
  "minecraft:light_block"
]);
function breakBlocksInFront(e) {
  try {
    const view = e.getViewDirection();
    const facing = { x: view.x, z: view.z };
    const len = Math.hypot(facing.x, facing.z) || 1;
    facing.x /= len; facing.z /= len;
    let broken = 0;
    for (let i = 1; i <= 3 && broken < 12; i++) {
      const fx = Math.floor(e.location.x + facing.x * i);
      const fz = Math.floor(e.location.z + facing.z * i);
      for (let j = 0; j <= 4 && broken < 12; j++) {
        try {
          const block = e.dimension.getBlock({ x: fx, y: Math.floor(e.location.y) + j, z: fz });
          if (!block || block.typeId === "minecraft:air") continue;
          if (HUMANOID_UNBREAKABLE.has(block.typeId)) continue;
          if (block.typeId.includes("water") || block.typeId.includes("lava")) continue;
          block.setType("minecraft:air");
          broken++;
        } catch (error) {
          operationDiagnostics.warnOnce("humanoid.block_break", "humanoid: block-break operation failed; continuing scan", error);
        }
      }
    }
  } catch (error) {
    operationDiagnostics.warnOnce("humanoid.block_break_scan", "humanoid: block-break scan failed", error);
  }
}

// ── Hallucinations (siluet_hallucination / he_hallucination) ─────────────────
function tickHallucination(e) {
  let life = getNum(e, "life", HALLUCINATION_LIFE);
  let looked = getNum(e, "looked", 0);
  if (!timers.has(e.id)) {
    life = HALLUCINATION_LIFE; looked = 0;
    // bind to closest player as the "owner" (source binds via UUID packet)
    timers.set(e.id, { life, looked, owner: undefined });
    const near = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 512);
    if (near) setNum(e, "owner", near.id);
  }
  const ownerId = getNum(e, "owner", undefined);
  let ownerEnt = null;
  if (ownerId !== undefined) {
    try { ownerEnt = world.getAllPlayers().find((player) => player.id === ownerId) ?? null; } catch (error) {
      operationDiagnostics.warnOnce("humanoid.owner_query", "humanoid: hallucination owner query failed", error);
    }
  }

  if (!looked && ownerEnt) {
    try { e.lookAt?.(ownerEnt.location); } catch (error) {
      operationDiagnostics.warnOnce("humanoid.hallucination_look", "humanoid: hallucination look-at failed", error);
    }
    if (inFovCone(ownerEnt, e)) { looked = 1; setNum(e, "looked", 1); }
  }

  if (looked) {
    // still armed? owner disconnected check approximated by validity
    if (ownerEnt && ownerEnt.isValid) {
      // chase at ~1.4 speed → 0.07 blocks/tick teleport-step
      const dx = ownerEnt.location.x - e.location.x;
      const dy = ownerEnt.location.y - e.location.y;
      const dz = ownerEnt.location.z - e.location.z;
      const len = Math.hypot(dx, dy, dz) || 1;
      const step = Math.min(0.07 * 5, len); // scheduler runs at 1t but cap step for stability
      try {
        e.teleport({ x: e.location.x + (dx / len) * step, y: e.location.y + (dy / len) * step, z: e.location.z + (dz / len) * step });
      } catch (error) {
        operationDiagnostics.warnOnce("humanoid.hallucination_teleport", "humanoid: hallucination chase teleport failed", error);
      }
      // poof at ≤1 from owner
      if (len <= 1) {
        try { e.remove(); } catch (error) {
          operationDiagnostics.warnOnce("humanoid.hallucination_remove", "humanoid: hallucination removal failed", error);
        } deleteTimers(e);
        try { ownerEnt.playSound("thebrokenscript:hallucination_fade", { volume: 10, pitch: 1 }); } catch (error) {
          operationDiagnostics.warnOnce("humanoid.hallucination_sound", "humanoid: hallucination fade sound failed", error);
        }
        title(ownerEnt, "blick", 3);
        return;
      }
    }
  }

  life--; setNum(e, "life", life);
  if (life <= 0) { try { e.remove(); } catch (error) {
    operationDiagnostics.warnOnce("humanoid.hallucination_expire", "humanoid: hallucination expiry removal failed", error);
  } deleteTimers(e); }
}

// ── He ("Him" watcher) ────────────────────────────────────────────────────────
function tickHe(e) {
  let life = getNum(e, "life", SILUET_LIFE);
  if (!timers.has(e.id)) {
    life = SILUET_LIFE; timers.set(e.id, { life });
    // onFinalizeSpawn: rare_thing_spawn sound + lightning at self + rain
    tryPlaySoundAt(e.dimension, e.location, "thebrokenscript:rare_thing_spawn", 10, 0);
    try { e.dimension.spawnEntity("minecraft:lightning_bolt", e.location); } catch (error) {
      operationDiagnostics.warnOnce("humanoid.he_lightning", "humanoid: He lightning spawn failed", error);
    }
    try { e.dimension.runCommand("weather rain 6000"); } catch (error) {
      operationDiagnostics.warnOnce("humanoid.he_weather", "humanoid: He weather command failed", error);
    }
  }
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 1000);
  if (player) {
    try { e.lookAt?.(player.location); } catch (error) {
      operationDiagnostics.warnOnce("humanoid.he_look", "humanoid: He look-at failed", error);
    }
    if (distance(e.location, player.location) < 10) {
      vanishOrChase(e, "thebrokenscript:he_chase", player);
      return;
    }
    if (distance(e.location, player.location) < 20 && gaze.isLookingAtEntity(player, e, 14)) {
      gazeReaction(e, "thebrokenscript:he_chase", player);
      return;
    }
  }
  try {
    const time = world.getTimeOfDay();
    // audit: Bedrock time-of-day adapter for the Java night-window predicate.
    if (time >= 23000 || time < 1000) {
      try { e.dimension.spawnParticle("minecraft:basic_smoke_particle", e.location); } catch {}
      try { e.remove(); } catch {} deleteTimers(e); return;
    }
  } catch {}
  life--; setNum(e, "life", life);
  if (life <= 0) {
    try { e.remove(); } catch {} deleteTimers(e);
    if (Math.random() < 0.01) {
      const spawned = spawnHelpers.trySummon(e.dimension, "thebrokenscript:he_chase", e.location);
      if (spawned) spawnHelpers.applyRandomRotation(spawned);
    }
  }
}

// ── Deceiver (mimics a random player) ────────────────────────────────────────
function tickDeceiver(e) {
  if (!timers.has(e.id)) {
    timers.set(e.id, { init: 1 });
    // mimic random player: join message + nametag + armor copy + random iron tool
    const players = world.getAllPlayers().filter(p => p.dimension.id === e.dimension.id);
    if (players.length > 0) {
      const p = players[Math.floor(Math.random() * players.length)];
      try { e.nameTag = p.name; } catch (error) {
        operationDiagnostics.warnOnce("humanoid.deceiver_name", "humanoid: deceiver name assignment failed", error);
      }
      try { e.dimension.runCommand(`tellraw @a {"rawtext":[{"text":"§e${p.name} joined the game"}]}`); } catch (error) {
        operationDiagnostics.warnOnce("humanoid.deceiver_join_message", "humanoid: deceiver join message failed", error);
      }
      try {
        const equippable = p.getComponent("minecraft:equippable");
        const myEquip = e.getComponent("minecraft:equippable");
        if (equippable && myEquip) {
          const slots = [EquipmentSlot.Head, EquipmentSlot.Chest, EquipmentSlot.Legs, EquipmentSlot.Feet];
          for (const s of slots) {
            try {
              const item = equippable.getEquipment(s);
              if (item) myEquip.setEquipment(s, item);
            } catch (error) {
              operationDiagnostics.warnOnce("humanoid.deceiver_equipment", "humanoid: deceiver equipment copy failed", error);
            }
          }
        }
      } catch (error) {
        operationDiagnostics.warnOnce("humanoid.deceiver_equipment_query", "humanoid: deceiver equipment query failed", error);
      }
    }
  }
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 3000);
  if (player) {
    try { e.lookAt?.({ x: player.location.x, y: player.location.y + 1, z: player.location.z }); } catch (error) {
      operationDiagnostics.warnOnce("humanoid.deceiver_look", "humanoid: deceiver look-at failed", error);
    }
    if (distance(e.location, player.location) < 10) {
      tryPlaySoundAt(e.dimension, e.location, "thebrokenscript:circuit_deceive", 10, 1);
      try { player.addEffect("blindness", 5, { amplifier: 0, showParticles: false }); } catch (error) {
        operationDiagnostics.warnOnce("humanoid.deceiver_blindness", "humanoid: deceiver blindness effect failed", error);
      }
      try { e.remove(); } catch (error) {
        operationDiagnostics.warnOnce("humanoid.deceiver_remove", "humanoid: deceiver removal failed", error);
      } deleteTimers(e);
      if (Math.random() < 0.7) {
        const pos = { ...e.location };
        system.runTimeout(() => {
          try {
            const spawned = spawnHelpers.trySummon(e.dimension, "thebrokenscript:circuit", pos);
            if (spawned) spawnHelpers.applyRandomRotation(spawned);
          } catch (error) {
            operationDiagnostics.warnOnce("humanoid.deceiver_spawn", "humanoid: delayed circuit spawn failed", error);
          }
        }, 60);
      }
      return;
    }
  }
  try {
    const time = world.getTimeOfDay();
    // audit: Bedrock time-of-day adapter for the Java night-window predicate.
    if (time >= 23000 || time < 1000) { try { e.remove(); } catch (error) {
      operationDiagnostics.warnOnce("humanoid.deceiver_day_remove", "humanoid: deceiver daylight removal failed", error);
    } deleteTimers(e); }
  } catch (error) {
    operationDiagnostics.warnOnce("humanoid.deceiver_time", "humanoid: deceiver time-of-day query failed", error);
  }
}

// ── Faraway ──────────────────────────────────────────────────────────────────
function tickFaraway(e) {
  let life = getNum(e, "life", FARAWAY_LIFE);
  let delay = getNum(e, "delay", 0);
  if (!timers.has(e.id)) { life = FARAWAY_LIFE; delay = 0; timers.set(e.id, { life, delay }); }
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 400);
  if (player) {
    const seen = (distance(e.location, player.location) < 38 && hasLineOfSightApprox(player, e) && inFovCone(player, e))
      || gaze.isLookingAtEntity(player, e, 14);
    if (seen) {
      delay++; setNum(e, "delay", delay);
      if (delay >= 25) {
        try { e.remove(); } catch (error) {
          operationDiagnostics.warnOnce("humanoid.faraway_remove", "humanoid: faraway removal failed", error);
        } deleteTimers(e);
        // variant: baby/fard easter eggs ledgered (funnySetting config pending)
        try { player.playSound("thebrokenscript:phantom", { volume: 1, pitch: 0 }); } catch (error) {
          operationDiagnostics.warnOnce("humanoid.faraway_sound", "humanoid: faraway sound failed", error);
        }
        title(player, "snimok_ekrana_2024-11-02_090828", 15);
        try {
          const part = Math.random() < 0.5 ? "minecraft:basic_flame_particle" : "minecraft:redstone_wire_dust_particle";
          e.dimension.spawnParticle(part, { x: e.location.x, y: e.location.y + 1, z: e.location.z });
        } catch (error) {
          operationDiagnostics.warnOnce("humanoid.faraway_particle", "humanoid: faraway particle failed", error);
        }
        return;
      }
    } else if (delay !== 0) {
      delay = 0; setNum(e, "delay", 0);
    }
  }
  life--; setNum(e, "life", life);
  if (life <= 0) { try { e.remove(); } catch (error) {
    operationDiagnostics.warnOnce("humanoid.faraway_expire", "humanoid: faraway expiry removal failed", error);
  } deleteTimers(e); }
}
