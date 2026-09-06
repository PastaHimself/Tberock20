import { world, system } from "@minecraft/server";
import * as worldState from "../../systems/world_state.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as gaze from "../../systems/ai/gaze.js";
import * as effects from "../../systems/ai/effects.js";
import * as spawnHelpers from "../../systems/ai/spawn_helpers.js";
import { logger } from "../../core/logging.js";
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
  try { dim.playSound(sound, loc, { volume: vol, pitch }); return; } catch {}
  for (const p of world.getAllPlayers()) {
    if (p.dimension.id !== dim.id) continue;
    try { p.playSound(sound, { volume: vol, pitch }); } catch {}
  }
}

function setFakeTime(dim, t) {
  try { dim.runCommandAsync(`time set ${t}`); } catch {}
}

function title(player, text, stayTicks = 10) {
  try { player.onScreenDisplay.setTitle(text, { fadeInDuration: 0, stayDuration: stayTicks, fadeOutDuration: 0 }); } catch {}
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
  } catch { return true; }
}

function inFovCone(player, entity, fovDeg = 70) {
  try {
    const view = player.getViewDirection();
    const to = { x: entity.location.x - player.location.x, y: (entity.location.y + 1.2) - (player.location.y + 1.62), z: entity.location.z - player.location.z };
    const len = Math.hypot(to.x, to.y, to.z) || 1;
    const n = { x: to.x / len, y: to.y / len, z: to.z / len };
    return (view.x * n.x + view.y * n.y + view.z * n.z) >= Math.cos(fovDeg * Math.PI / 360);
  } catch { return false; }
}

// vanishing branch shared by siluet/he/stare watchers:
// 50%: discard + blindness 35 amp1 + null_is_here_loop to players ≤25 + 70% midnight
// else: discard + spawn chaser
function vanishOrChase(e, chaserId, victimPlayer) {
  try { e.remove(); } catch {}
  deleteTimers(e);
  if (Math.random() < 0.5) {
    if (victimPlayer) { try { victimPlayer.addEffect("blindness", 35, { amplifier: 1, showParticles: false }); } catch {} }
    for (const p of world.getAllPlayers()) {
      if (p.dimension.id !== e.dimension.id) continue;
      if (distance(p.location, e.location) > 25) continue;
      try { p.playSound("thebrokenscript:null_is_here_loop", { volume: 1, pitch: 1 }); } catch {}
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
  try { e.remove(); } catch {}
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
  } catch {}
  if (Math.random() < 0.5) {
    try { e.dimension.spawnEntity("minecraft:lightning_bolt", player.location); } catch {}
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
        const killer = ev.damageSource?.damagingEntity;
        if (!killer) return;
        if (killer.typeId === "thebrokenscript:siluet_chase" || killer.typeId === "thebrokenscript:he_chase") {
          // awardKillScore: discard + 30% tryCrash (kick approximation)
          try { killer.remove(); deleteTimers(killer); } catch {}
          if (Math.random() < 0.3) {
            system.runTimeout(() => {
              try {
                const safeName = ev.deadEntity.name.replace(/"/g, '\\"');
                ev.deadEntity.dimension.runCommandAsync(`kick "${safeName}" §cYou were caught.`).catch(() => {});
              } catch {}
            }, 10);
          }
        }
      } catch {}
    });
  } catch {}
}

function onTick() {
  if (!perf.hasPlayers(system.currentTick)) return; // perf: idle server short-circuit (Chunk 16)
  let list = [];
  try { list = world.getDimension("overworld").getEntities({ families: ["thebrokenscript_humanoid"] }); } catch { return; }
  for (const e of list) {
    try { tickEntity(e); } catch (err) { logger.error(`humanoid tick ${e.typeId} ${e.id}`, err); }
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
  if (life <= 0) { try { e.remove(); } catch {} deleteTimers(e); return; }
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 512);
  if (!player) return;
  try {
    const mobs = e.dimension.getEntities({ location: e.location, maxDistance: 512 });
    for (const mob of mobs) {
      if (mob.id === e.id) continue;
      if (!LOOKABLE_TYPES.includes(mob.typeId)) continue;
      try { mob.lookAt?.(player.location); } catch {
        try {
          const dx = player.location.x - mob.location.x;
          const dz = player.location.z - mob.location.z;
          const yaw = Math.atan2(-dx, dz) * 180 / Math.PI;
          mob.teleport(mob.location, { rotation: { x: 0, y: yaw } });
        } catch {}
      }
      try { mob.addEffect("slowness", 60, { amplifier: 55, showParticles: false }); } catch {}
    }
  } catch {}
}

// ── Siluet watcher (base layer, SiluetEntity.baseTick) ──────────────────────
function tickSiluet(e) {
  let life = getNum(e, "life", SILUET_LIFE);
  if (!timers.has(e.id)) { life = SILUET_LIFE; timers.set(e.id, { life }); }
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 512);
  if (player) {
    try { e.lookAt?.(player.location); } catch {}
    // rocket easter egg (funnySetting 1%) — config not yet registered; ledgered skip
    if (distance(e.location, player.location) < 15 && hasLineOfSightApprox(player, e)) {
      vanishOrChase(e, "thebrokenscript:siluet_chase", player);
      return;
    }
    if (distance(e.location, player.location) < 20 && gaze.isLookingAtLocation(player, e.location, 14)) {
      gazeReaction(e, "thebrokenscript:siluet_chase", player);
      return;
    }
  }
  // isDay → discard + null particle burst
  try {
    const time = world.getTime?.() ?? 0;
    if (time >= 23000 || time < 1000) {
      try { e.dimension.spawnParticle("minecraft:basic_smoke_particle", e.location); } catch {}
      try { e.remove(); } catch {} deleteTimers(e); return;
    }
  } catch {}
  life--; setNum(e, "life", life);
  if (life <= 0) {
    try { e.remove(); } catch {} deleteTimers(e);
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
  if (!e.isValid()) return;
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 620);
  if (!player) return;
  try { e.lookAt?.(player.location); } catch {}
  if (distance(e.location, player.location) < 10) {
    vanishOrChase(e, "thebrokenscript:siluet_chase", player);
    return;
  }
  if (distance(e.location, player.location) < 45 && gaze.isLookingAtLocation(player, e.location, 14)) {
    gazeReaction(e, "thebrokenscript:siluet_chase", player);
  }
}

// ── Chasers (siluet_chase / he_chase) ────────────────────────────────────────
function tickChase(e) {
  let despawn = getNum(e, "despawn", CHASE_LIFE);
  if (!timers.has(e.id)) { despawn = CHASE_LIFE; timers.set(e.id, { despawn }); }
  despawn++; setNum(e, "despawn", despawn);
  if (despawn > CHASE_LIFE) { try { e.remove(); } catch {} deleteTimers(e); return; }

  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 800);
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
    try { player.applyDamage(13, { cause: "entityAttack", damagingEntity: e }); } catch { try { player.applyDamage(13); } catch {} }
  }

  // block-break front 3×h+1 when stuck/near & yDiff ≤ 3 (rate-limited every 10 ticks)
  if ((dist < 10 || yDiff <= 3) && system.currentTick % 10 === 0 && yDiff <= 6) {
    breakBlocksInFront(e);
  }
  // step-height analogue: teleport up toward player when yDiff > 3
  if (yDiff > 3 && system.currentTick % 20 === 0) {
    try { e.teleport({ x: e.location.x, y: e.location.y + 1, z: e.location.z }); } catch {}
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
        } catch {}
      }
    }
  } catch {}
}

// ── Hallucinations (siluet_hallucination / he_hallucination) ─────────────────
function tickHallucination(e) {
  let life = getNum(e, "life", HALLUCINATION_LIFE);
  let looked = getNum(e, "looked", 0);
  if (!timers.has(e.id)) {
    life = HALLUCINATION_LIFE; looked = 0;
    // bind to closest player as the "owner" (source binds via UUID packet)
    timers.set(e.id, { life, looked, owner: undefined });
    const near = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 512);
    if (near) setNum(e, "owner", near.id);
  }
  const ownerId = getNum(e, "owner", undefined);
  let ownerEnt = null;
  if (ownerId !== undefined) {
    try { ownerEnt = world.getEntity(ownerId) ?? null; } catch {}
  }

  if (!looked && ownerEnt) {
    try { e.lookAt?.(ownerEnt.location); } catch {}
    if (inFovCone(ownerEnt, e)) { looked = 1; setNum(e, "looked", 1); }
  }

  if (looked) {
    // still armed? owner disconnected check approximated by validity
    if (ownerEnt && ownerEnt.isValid()) {
      // chase at ~1.4 speed → 0.07 blocks/tick teleport-step
      const dx = ownerEnt.location.x - e.location.x;
      const dy = ownerEnt.location.y - e.location.y;
      const dz = ownerEnt.location.z - e.location.z;
      const len = Math.hypot(dx, dy, dz) || 1;
      const step = Math.min(0.07 * 5, len); // scheduler runs at 1t but cap step for stability
      try {
        e.teleport({ x: e.location.x + (dx / len) * step, y: e.location.y + (dy / len) * step, z: e.location.z + (dz / len) * step });
      } catch {}
      // poof at ≤1 from owner
      if (len <= 1) {
        try { e.remove(); } catch {} deleteTimers(e);
        try { ownerEnt.playSound("thebrokenscript:hallucination_fade", { volume: 10, pitch: 1 }); } catch {}
        title(ownerEnt, "blick", 3);
        return;
      }
    }
  }

  life--; setNum(e, "life", life);
  if (life <= 0) { try { e.remove(); } catch {} deleteTimers(e); }
}

// ── He ("Him" watcher) ────────────────────────────────────────────────────────
function tickHe(e) {
  let life = getNum(e, "life", SILUET_LIFE);
  if (!timers.has(e.id)) {
    life = SILUET_LIFE; timers.set(e.id, { life });
    // onFinalizeSpawn: rare_thing_spawn sound + lightning at self + rain
    tryPlaySoundAt(e.dimension, e.location, "thebrokenscript:rare_thing_spawn", 10, 0);
    try { e.dimension.spawnEntity("minecraft:lightning_bolt", e.location); } catch {}
    try { e.dimension.runCommandAsync("weather rain 6000"); } catch {}
  }
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 1000);
  if (player) {
    try { e.lookAt?.(player.location); } catch {}
    if (distance(e.location, player.location) < 10) {
      vanishOrChase(e, "thebrokenscript:he_chase", player);
      return;
    }
    if (distance(e.location, player.location) < 20 && gaze.isLookingAtLocation(player, e.location, 14)) {
      gazeReaction(e, "thebrokenscript:he_chase", player);
      return;
    }
  }
  try {
    const time = world.getTime?.() ?? 0;
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
      try { e.nameTag = p.name; } catch {}
      try { e.dimension.runCommandAsync(`tellraw @a {"rawtext":[{"text":"§e${p.name} joined the game"}]}`); } catch {}
      try {
        const equippable = p.getComponent("minecraft:equippable");
        const myEquip = e.getComponent("minecraft:equippable");
        if (equippable && myEquip) {
          const slots = ["Head", "Chest", "Legs", "Feet"];
          for (const s of slots) {
            try {
              const item = equippable.getEquipment(s);
              if (item) myEquip.setEquipment(s, item);
            } catch {}
          }
        }
      } catch {}
    }
  }
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 3000);
  if (player) {
    try { e.lookAt?.({ x: player.location.x, y: player.location.y + 1, z: player.location.z }); } catch {}
    if (distance(e.location, player.location) < 10) {
      tryPlaySoundAt(e.dimension, e.location, "thebrokenscript:circuit_deceive", 10, 1);
      try { player.addEffect("blindness", 5, { amplifier: 0, showParticles: false }); } catch {}
      try { e.remove(); } catch {} deleteTimers(e);
      if (Math.random() < 0.7) {
        const pos = { ...e.location };
        system.runTimeout(() => {
          try {
            const spawned = spawnHelpers.trySummon(e.dimension, "thebrokenscript:circuit", pos);
            if (spawned) spawnHelpers.applyRandomRotation(spawned);
          } catch {}
        }, 60);
      }
      return;
    }
  }
  try {
    const time = world.getTime?.() ?? 0;
    if (time >= 23000 || time < 1000) { try { e.remove(); } catch {} deleteTimers(e); }
  } catch {}
}

// ── Faraway ──────────────────────────────────────────────────────────────────
function tickFaraway(e) {
  let life = getNum(e, "life", FARAWAY_LIFE);
  let delay = getNum(e, "delay", 0);
  if (!timers.has(e.id)) { life = FARAWAY_LIFE; delay = 0; timers.set(e.id, { life, delay }); }
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 400);
  if (player) {
    const seen = (distance(e.location, player.location) < 38 && hasLineOfSightApprox(player, e) && inFovCone(player, e))
      || gaze.isLookingAtLocation(player, e.location, 14);
    if (seen) {
      delay++; setNum(e, "delay", delay);
      if (delay >= 25) {
        try { e.remove(); } catch {} deleteTimers(e);
        // variant: baby/fard easter eggs ledgered (funnySetting config pending)
        try { player.playSound("thebrokenscript:phantom", { volume: 1, pitch: 0 }); } catch {}
        title(player, "snimok_ekrana_2024-11-02_090828", 15);
        try {
          const part = Math.random() < 0.5 ? "minecraft:basic_flame_particle" : "minecraft:redstone_wire_dust_particle";
          e.dimension.spawnParticle(part, { x: e.location.x, y: e.location.y + 1, z: e.location.z });
        } catch {}
        return;
      }
    } else if (delay !== 0) {
      delay = 0; setNum(e, "delay", 0);
    }
  }
  life--; setNum(e, "life", life);
  if (life <= 0) { try { e.remove(); } catch {} deleteTimers(e); }
}
