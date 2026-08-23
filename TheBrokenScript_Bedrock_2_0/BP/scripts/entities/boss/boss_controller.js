import { world, system } from "@minecraft/server";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import { logger } from "../../core/logging.js";

// ── constants from decompiled sources ──────────────────────────────────────
// integrity: phase chain p1(910/50) → p2(910/25) → p3(1024/50) at health thresholds,
//            fireball volleys + ground arms in p3, watching beat, integrity_dies on end
// fractured (Jimmy): slam/stomp pulses 12 dmg, rock toss ranged 6, roam variant passive
// murderfur: Kerfur pet — follows nearest player, meow pitch 0.9-1.2
// fever: flying chaser 10 dmg + blindness; fever_stalk static then summons fever
// chord: flying attacker 4 dmg; chord_projectile straight-line 6 dmg
// tether/void_tentacle: proximity hazards
const FIREBALL_SPEED = 0.8;

const timers = new Map();

function getNum(e, key, def) {
  const m = timers.get(e.id);
  if (!m) return def;
  const v = m[key];
  return v === undefined ? def : v;
}
function setNum(e, key, v) {
  let m = timers.get(e.id);
  if (!m) { m = {}; timers.set(e.id, m); }
  m[key] = v;
}
function deleteTimers(e) { timers.delete(e.id); }
function distance(a, b) { return Math.hypot(a.x - b.x, a.y - b.y, a.z - b.z); }

function getHealth(e) {
  try { return e.getComponent("minecraft:health")?.currentValue ?? 0; } catch { return 0; }
}
function maxHealth(e) {
  try { return e.getComponent("minecraft:health")?.effectiveMax ?? 0; } catch { return 0; }
}
function meleePulse(e, dmg, reach = 5, interval = 20) {
  if (system.currentTick % interval !== 0) return;
  for (const p of world.getAllPlayers()) {
    if (p.dimension.id !== e.dimension.id) continue;
    if (distance(p.location, e.location) > reach) continue;
    try { p.applyDamage(dmg, { cause: "entityAttack", damagingEntity: e }); } catch { try { p.applyDamage(dmg); } catch {} }
  }
}
function approach(e, player, speedBlocksPerTick) {
  const dx = player.location.x - e.location.x;
  const dz = player.location.z - e.location.z;
  const len = Math.hypot(dx, dz) || 1;
  try {
    e.teleport({
      x: e.location.x + (dx / len) * speedBlocksPerTick,
      y: e.location.y,
      z: e.location.z + (dz / len) * speedBlocksPerTick
    });
  } catch {}
}

export function begin(scheduler) {
  scheduler.every("tbs.boss_tick", 1, onTick);
}

function onTick() {
  const dims = [];
  try { dims.push(world.getDimension("overworld")); } catch {}
  try { dims.push(world.getDimension("nether")); } catch {}
  try { dims.push(world.getDimension("the_end")); } catch {}
  for (const dim of dims) {
    let list = [];
    try { list = dim.getEntities({ families: ["thebrokenscript_boss"] }); } catch { continue; }
    for (const e of list) {
      try { tickEntity(e); } catch (err) { logger.error(`boss tick ${e.typeId} ${e.id}`, err); }
    }
  }
}

function tickEntity(e) {
  switch (e.typeId) {
    case "thebrokenscript:integrity_phase_1":
    case "thebrokenscript:integrity_phase_2": return tickIntegrityEarly(e);
    case "thebrokenscript:integrity_phase_3": return tickIntegrityP3(e);
    case "thebrokenscript:integrity_arm": return tickArm(e);
    case "thebrokenscript:integrity_curious": return tickCuriousWatcher(e);
    case "thebrokenscript:integ_fireball": return tickFireball(e);
    case "thebrokenscript:fractured": return tickFractured(e);
    case "thebrokenscript:fractured_roam": return tickFracturedRoam(e);
    case "thebrokenscript:rock": return tickRock(e);
    case "thebrokenscript:murderfur": return tickMurderfur(e);
    case "thebrokenscript:fever": return tickFever(e);
    case "thebrokenscript:fever_stalk": return tickFeverStalk(e);
    case "thebrokenscript:chord": return tickChord(e);
    case "thebrokenscript:chord_projectile": return tickChordProjectile(e);
    case "thebrokenscript:tether":
    case "thebrokenscript:void_tentacle": return tickHazard(e);
  }
}

// ── Integrity phases 1/2 ─────────────────────────────────────────────────────
function tickIntegrityEarly(e) {
  if (!timers.has(e.id)) {
    timers.set(e.id, { init: 1 });
    bossHooks.setArenaState(true, true);
    tryPlayAt(e.dimension, e.location, "thebrokenscript:integrity_watching", 10, 2);
  }
  // hover bob for giant body
  if (system.currentTick % 20 === 0 && e.typeId === "thebrokenscript:integrity_phase_1") {
    try { e.teleport({ x: e.location.x, y: e.location.y + 0.08, z: e.location.z }); } catch {}
  }
  meleePulse(e, e.typeId === "thebrokenscript:integrity_phase_1" ? 50 : 25, 6);

  // phase transition by health fraction
  const frac = getHealth(e) / Math.max(1, maxHealth(e));
  const threshold = e.typeId === "thebrokenscript:integrity_phase_1" ? 0.5 : 0.4;
  if (frac < threshold && system.currentTick % 10 === 0) {
    const next = e.typeId === "thebrokenscript:integrity_phase_1" ? "thebrokenscript:integrity_phase_2" : "thebrokenscript:integrity_phase_3";
    transitionPhase(e, next);
  }
}

function transitionPhase(e, nextTypeId) {
  const loc = { ...e.location };
  const frac = getHealth(e) / Math.max(1, maxHealth(e));
  try { e.remove(); } catch {} deleteTimers(e);
  try {
    const next = e.dimension.spawnEntity(nextTypeId, loc);
    if (next) {
      try {
        const hp = next.getComponent("minecraft:health");
        const max = next.getComponent("minecraft:health")?.effectiveMax ?? 1;
        const keep = Math.max(1, Math.floor(max * Math.min(1, frac + 0.25)));
        hp.setCurrentValue(keep);
      } catch {}
      if (nextTypeId.endsWith("phase_3")) bossHooks.setArenaState(true, false);
    }
  } catch {}
}

// ── Integrity phase 3 ────────────────────────────────────────────────────────
function tickIntegrityP3(e) {
  if (!timers.has(e.id)) {
    timers.set(e.id, { volley: 100 });
    bossHooks.setArenaState(true, false);
  }
  meleePulse(e, 50, 8);

  // fireball volley every ~5s at nearest player
  const v = getNum(e, "volley", 100) - 1;
  setNum(e, "volley", v);
  if (v <= 0) {
    setNum(e, "volley", 100);
    const target = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 64);
    if (target) {
      const fb = spawnAt(e.dimension, "thebrokenscript:integ_fireball", {
        x: e.location.x, y: e.location.y + 4, z: e.location.z
      });
      if (fb) {
        setNum(fb, "dirX", (target.location.x - e.location.x));
        setNum(fb, "dirY", (target.location.y + 1 - (e.location.y + 4)));
        setNum(fb, "dirZ", (target.location.z - e.location.z));
      }
      // occasional ground arm
      if (Math.random() < 0.3) {
        spawnAt(e.dimension, "thebrokenscript:integrity_arm", {
          x: target.location.x + (Math.random() * 6 - 3),
          y: target.location.y,
          z: target.location.z + (Math.random() * 6 - 3)
        });
      }
    }
  }
}

function spawnAt(dim, typeId, loc) {
  try { return dim.spawnEntity(typeId, loc); } catch { return undefined; }
}
function tryPlayAt(dim, loc, sound, vol = 1, pitch = 1) {
  try { dim.playSound(sound, loc, { volume: vol, pitch }); return; } catch {}
  for (const p of world.getAllPlayers()) {
    if (p.dimension.id !== dim.id) continue;
    try { p.playSound(sound, { volume: vol, pitch }); } catch {}
  }
}

// ── Arm / curious / fireball ────────────────────────────────────────────────
function tickArm(e) {
  let life = getNum(e, "life", 200);
  life--; setNum(e, "life", life);
  meleePulse(e, 50, 4, 30);
  if (life <= 0 || getHealth(e) <= 0) { try { e.remove(); } catch {} deleteTimers(e); }
}

function tickCuriousWatcher(e) {
  let life = getNum(e, "life", 1200);
  if (!timers.has(e.id)) { life = 1200; timers.set(e.id, { life }); }
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 158);
  if (player) { try { e.lookAt?.(player.location); } catch {} }
  life--; setNum(e, "life", life);
  if (life <= 0) { try { e.remove(); } catch {} deleteTimers(e); }
}

function tickFireball(e) {
  const dx = getNum(e, "dirX", 0);
  const dy = getNum(e, "dirY", 0);
  const dz = getNum(e, "dirZ", 0);
  const len = Math.hypot(dx, dy, dz);
  if (len > 0) {
    try {
      e.teleport({
        x: e.location.x + (dx / len) * FIREBALL_SPEED,
        y: e.location.y + (dy / len) * FIREBALL_SPEED,
        z: e.location.z + (dz / len) * FIREBALL_SPEED
      });
    } catch {}
  }
  for (const p of world.getAllPlayers()) {
    if (p.dimension.id !== e.dimension.id) continue;
    if (distance(p.location, e.location) < 2.5) {
      try { p.applyDamage(12, { cause: "entityAttack", damagingEntity: e }); } catch { try { p.applyDamage(12); } catch {} }
      try { e.remove(); } catch {} deleteTimers(e);
      return;
    }
  }
  const life = getNum(e, "life", 200) - 1;
  setNum(e, "life", life);
  if (life <= 0) { try { e.remove(); } catch {} deleteTimers(e); }
}

// ── Fractured (Jimmy) ────────────────────────────────────────────────────────
function tickFractured(e) {
  const target = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 128);
  if (!target) return;
  try { e.lookAt?.(target.location); } catch {}
  if (distance(e.location, target.location) > 6 && system.currentTick % 5 === 0) {
    approach(e, target, 0.75); // mov 1.5 ≈ 0.075 b/t
  }
  meleePulse(e, 12, 7);
  // rock toss every ~10s: ranged 6 dmg + brief rock entity
  const toss = getNum(e, "toss", 200) - 1;
  setNum(e, "toss", toss);
  if (toss <= 0) {
    setNum(e, "toss", 200);
    if (distance(e.location, target.location) < 40) {
      try { target.applyDamage(6, { cause: "entityAttack", damagingEntity: e }); } catch { try { target.applyDamage(6); } catch {} }
      const rock = spawnAt(e.dimension, "thebrokenscript:rock", { x: target.location.x, y: target.location.y + 1, z: target.location.z });
      if (rock) setNum(rock, "life", 60);
    }
  }
}

function tickFracturedRoam(e) {
  // gentle wander: random drift every second
  if (system.currentTick % 20 === 0) {
    const ang = Math.random() * Math.PI * 2;
    try { e.teleport({ x: e.location.x + Math.cos(ang), y: e.location.y, z: e.location.z + Math.sin(ang) }); } catch {}
  }
  // damaged below half → become hostile Jimmy
  if (getHealth(e) < maxHealth(e) * 0.5) {
    const loc = { ...e.location };
    try { e.remove(); } catch {} deleteTimers(e);
    spawnAt(e.dimension, "thebrokenscript:fractured", loc);
  }
}

function tickRock(e) {
  const life = getNum(e, "life", 100) - 1;
  setNum(e, "life", life);
  if (life <= 0) { try { e.remove(); } catch {} deleteTimers(e); }
}

// ── Murderfur (Kerfur pet) ───────────────────────────────────────────────────
function tickMurderfur(e) {
  const owner = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 400);
  if (owner) {
    const d = distance(e.location, owner.location);
    if (d > 6 && system.currentTick % 15 === 0) approach(e, owner, 0.45);
    try { e.lookAt?.(owner.location); } catch {}
  }
  if (Math.random() < 0.001) {
    tryPlayAt(e.dimension, e.location, "thebrokenscript:kerfur_meow", 0, 0.9 + Math.random() * 0.3);
  }
}

// ── Fever pair ───────────────────────────────────────────────────────────────
function tickFever(e) {
  const target = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 256);
  if (!target) return;
  if (distance(e.location, target.location) > 4 && system.currentTick % 5 === 0) {
    approach(e, target, 0.2);
    try { e.teleport({ x: e.location.x, y: e.location.y + 0.05, z: e.location.z }); } catch {}
  }
  meleePulse(e, 10, 5);
  if (system.currentTick % 100 === 0) {
    try { target.addEffect("blindness", 60, { amplifier: 0, showParticles: false }); } catch {}
  }
}

function tickFeverStalk(e) {
  let life = getNum(e, "life", 7200);
  if (!timers.has(e.id)) { life = 7200; timers.set(e.id, { life }); }
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 158);
  if (player) { try { e.lookAt?.(player.location); } catch {} }
  life--; setNum(e, "life", life);
  if (life <= 0 || (player && distance(e.location, player.location) < 16)) {
    const loc = { ...e.location };
    try { e.remove(); } catch {} deleteTimers(e);
    spawnAt(e.dimension, "thebrokenscript:fever", loc);
  }
}

// ── Chord pair ───────────────────────────────────────────────────────────────
function tickChord(e) {
  const target = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 48);
  if (!target) return;
  if (distance(e.location, target.location) > 3 && system.currentTick % 3 === 0) {
    approach(e, target, 0.15);
    try { e.teleport({ x: e.location.x, y: e.location.y + 0.03, z: e.location.z }); } catch {}
  }
  meleePulse(e, 4, 3, 15);
  // fire chord projectile occasionally
  if (system.currentTick % 160 === 0) {
    const pr = spawnAt(e.dimension, "thebrokenscript:chord_projectile", { x: e.location.x, y: e.location.y + 0.5, z: e.location.z });
    if (pr) {
      setNum(pr, "dirX", target.location.x - e.location.x);
      setNum(pr, "dirY", (target.location.y + 1) - e.location.y);
      setNum(pr, "dirZ", target.location.z - e.location.z);
    }
  }
}

function tickChordProjectile(e) {
  const dx = getNum(e, "dirX", 0);
  const dy = getNum(e, "dirY", 0);
  const dz = getNum(e, "dirZ", 0);
  const len = Math.hypot(dx, dy, dz);
  if (len > 0) {
    try {
      e.teleport({
        x: e.location.x + (dx / len) * 0.9,
        y: e.location.y + (dy / len) * 0.9,
        z: e.location.z + (dz / len) * 0.9
      });
    } catch {}
  }
  for (const p of world.getAllPlayers()) {
    if (p.dimension.id !== e.dimension.id) continue;
    if (distance(p.location, e.location) < 2) {
      try { p.applyDamage(6, { cause: "entityAttack", damagingEntity: e }); } catch { try { p.applyDamage(6); } catch {} }
      try { e.remove(); } catch {} deleteTimers(e);
      return;
    }
  }
  const life = getNum(e, "life", 160) - 1;
  setNum(e, "life", life);
  if (life <= 0) { try { e.remove(); } catch {} deleteTimers(e); }
}

// ── Stationary hazards (tether / void_tentacle) ──────────────────────────────
function tickHazard(e) {
  meleePulse(e, e.typeId === "thebrokenscript:tether" ? 4 : 6, 3, 20);
  // tentacles are temporary
  if (e.typeId === "thebrokenscript:void_tentacle") {
    const life = getNum(e, "life", 600) - 1;
    setNum(e, "life", life);
    if (life <= 0) { try { e.remove(); } catch {} deleteTimers(e); }
  }
}
