import { world, system } from "@minecraft/server";
import { EntityDamageCause } from "@minecraft/server";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import { logger } from "../../core/logging.js";
import * as perf from "../../systems/perf.js";
import {
  TETHER_SOURCE,
  VOID_TENTACLE_SOURCE,
  tetherDamageBlocked,
  tetherHeartbeatStep,
  voidTentacleAttackPlan,
  voidTentacleDamageAllowed,
  voidTentacleScaleFromRoll,
  voidTentacleSweepPlan,
} from "../../systems/integrity_arena_model.js";

// ── boss death sequence (Chunk 14 presentation) ─────────────────────────────
let deathHookInstalled = false;
function installDeathHook() {
  if (deathHookInstalled) return;
  deathHookInstalled = true;
  try {
    world.afterEvents.entityDie.subscribe((ev) => {
      const id = ev.deadEntity.typeId;
      const isBoss =
        id.startsWith("thebrokenscript:integrity") ||
        id === "thebrokenscript:fractured" ||
        id === "thebrokenscript:the_obliteration" ||
        id === "thebrokenscript:the_obliteration_2";
      if (!isBoss) return;
      try { ev.deadEntity.dimension.playSound("thebrokenscript:integrity_dies", ev.deadEntity.location, { volume: 10, pitch: 1 }); } catch {}
      if (id.startsWith("thebrokenscript:integrity")) bossHooks.setArenaState(false, false);
    });
  } catch {}
}

// ── constants from decompiled sources ──────────────────────────────────────
// Integrity phase advancement is owned by Arena/Phase source semantics, not HP
// fractions. Source-backed arena constants/predicates live in integrity_arena_model.js;
// automatic arena startup remains disabled until its Java callsite is recovered.
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
    try { p.applyDamage(dmg, { cause: EntityDamageCause.entityAttack, damagingEntity: e }); } catch { try { p.applyDamage(dmg); } catch {} }
  }
}

let damageHookInstalled = false;
function installDamageHook() {
  if (damageHookInstalled) return;
  damageHookInstalled = true;
  try {
    world.beforeEvents.entityHurt.subscribe((ev) => {
      const target = ev.hurtEntity;
      const cause = ev.damageSource?.cause;
      const damagingEntity = ev.damageSource?.damagingEntity;
      if (target.typeId === "thebrokenscript:void_tentacle" && !voidTentacleDamageAllowed(cause)) {
        ev.cancel = true;
        return;
      }
      if (target.typeId === "thebrokenscript:tether" && tetherDamageBlocked({
        sourceType: damagingEntity?.typeId,
        cause,
      })) {
        ev.cancel = true;
      }
    });
  } catch {}
}

function applyEntityAttack(attacker, target, damage) {
  try {
    target.applyDamage(damage, { cause: EntityDamageCause.entityAttack, damagingEntity: attacker });
    return true;
  } catch {
    try {
      target.applyDamage(damage);
      return true;
    } catch {
      return false;
    }
  }
}

function runLater(callback, ticks) {
  try {
    const scheduler = /** @type {any} */ (system);
    if (typeof scheduler.runTimeout === "function") {
      scheduler.runTimeout(callback, ticks);
      return;
    }
  } catch {}
  callback();
}

function callEntityMethod(entity, name, ...args) {
  try {
    const method = entity[name];
    return typeof method === "function" ? method.call(entity, ...args) : undefined;
  } catch {
    return undefined;
  }
}

function entityScale(e) {
  const propertyScale = callEntityMethod(e, "getProperty", "thebrokenscript:scale");
  if (typeof propertyScale === "number" && propertyScale > 0) return propertyScale;
  const timerScale = getNum(e, "scale", undefined);
  if (timerScale === undefined) {
    const roll = Math.floor(Math.random() * (
      VOID_TENTACLE_SOURCE.scaleMaxInclusive - VOID_TENTACLE_SOURCE.scaleMinInclusive + 1
    ));
    const sourceScale = voidTentacleScaleFromRoll(roll);
    setNum(e, "scale", sourceScale);
    return sourceScale;
  }
  return Number.isFinite(timerScale) && timerScale > 0 ? timerScale : 1;
}

function isLivingEntity(e) {
  try {
    if (e.isValid === false) return false;
    if (typeof e.isValid === "function" && e.isValid() === false) return false;
  } catch {}
  return getHealth(e) > 0;
}

function entityIsOnGround(e) {
  try {
    const value = e.isOnGround;
    return typeof value === "function" ? value.call(e) === true : value === true;
  } catch {
    return false;
  }
}

function isEntityStuck(e) {
  if (callEntityMethod(e, "hasTag", "thebrokenscript.stuck") === true) return true;
  return callEntityMethod(e, "getProperty", "thebrokenscript:stuck") === true;
}

function setEntityStuck(e, stuck) {
  if (stuck) {
    callEntityMethod(e, "addTag", "thebrokenscript.stuck");
    callEntityMethod(e, "setProperty", "thebrokenscript:stuck", true);
    runLater(() => setEntityStuck(e, false), VOID_TENTACLE_SOURCE.stuckDurationTicks);
    return;
  }
  callEntityMethod(e, "removeTag", "thebrokenscript.stuck");
  callEntityMethod(e, "setProperty", "thebrokenscript:stuck", false);
}

function playEntityAnimation(e, animationId) {
  callEntityMethod(e, "playAnimation", animationId);
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
  installDeathHook();
  installDamageHook();
  scheduler.every("tbs.boss_tick", 1, onTick);
}

function onTick() {
  if (!perf.hasPlayers(system.currentTick)) return; // perf: idle server short-circuit (Chunk 16)
  const dims = [];
  const overworld = perf.dim("overworld");
  if (overworld) dims.push(overworld);
  const nether = perf.dim("nether");
  if (nether) dims.push(nether);
  const theEnd = perf.dim("the_end");
  if (theEnd) dims.push(theEnd);
  // TBSDimensions.STAGE2 and STAGE3 (void_shadow) are the source locations
  // for Tethers, Integrity P3, and VoidTentacles.
  for (const id of ["thebrokenscript:stage2", "thebrokenscript:void_shadow"]) {
    const dim = perf.dim(id);
    if (dim) dims.push(dim);
  }
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
    case "thebrokenscript:tether": return tickTether(e);
    case "thebrokenscript:void_tentacle": return tickVoidTentacle(e);
  }
}

// ── Integrity phases 1/2 ─────────────────────────────────────────────────────
function tickIntegrityEarly(e) {
  if (!timers.has(e.id)) {
    timers.set(e.id, { init: 1 });
    bossHooks.setArenaState(true, e.typeId === "thebrokenscript:integrity_phase_1");
    tryPlayAt(e.dimension, e.location, "thebrokenscript:integrity_watching", 10, 2);
  }
  // hover bob for giant body
  if (system.currentTick % 20 === 0 && e.typeId === "thebrokenscript:integrity_phase_1") {
    try { e.teleport({ x: e.location.x, y: e.location.y + 0.08, z: e.location.z }); } catch {}
  }
  meleePulse(e, e.typeId === "thebrokenscript:integrity_phase_1" ? 50 : 25, 6);

  // Do not transition Integrity phases from health here. Java Arena/Phase logic
  // owns those transitions; the old 50%/40% thresholds were fabricated.
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
      try { p.applyDamage(12, { cause: EntityDamageCause.entityAttack, damagingEntity: e }); } catch { try { p.applyDamage(12); } catch {} }
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
      try { target.applyDamage(6, { cause: EntityDamageCause.entityAttack, damagingEntity: e }); } catch { try { target.applyDamage(6); } catch {} }
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
      try { p.applyDamage(6, { cause: EntityDamageCause.entityAttack, damagingEntity: e }); } catch { try { p.applyDamage(6); } catch {} }
      try { e.remove(); } catch {} deleteTimers(e);
      return;
    }
  }
  const life = getNum(e, "life", 160) - 1;
  setNum(e, "life", life);
  if (life <= 0) { try { e.remove(); } catch {} deleteTimers(e); }
}

// ── Tether / VoidTentacle ───────────────────────────────────────────────────
function tickTether(e) {
  // TetherEntity.registerGoals() adds no custom melee goal. Its source-side
  // path generation remains blocked on a Bedrock equivalent for A* and block
  // mutation; keep the heartbeat while avoiding a fabricated damage pulse.
  const heartbeat = tetherHeartbeatStep(getNum(e, "tetherHeartbeatCooldown", 0));
  setNum(e, "tetherHeartbeatCooldown", heartbeat.nextCooldown);
  if (heartbeat.play) {
    // Bedrock's vanilla sound id for SoundEvents.WARDEN_HEARTBEAT.
    tryPlayAt(e.dimension, e.location, "mob.warden.heartbeat", TETHER_SOURCE.heartbeatVolume, TETHER_SOURCE.heartbeatPitch);
  }
}

function targetKind(e) {
  switch (e.typeId) {
    case "minecraft:player": return "player";
    case "thebrokenscript:integrity_arm": return "integrity_p3_ground_arm";
    case "thebrokenscript:integrity_phase_3": return "integrity_phase_3";
    default: return null;
  }
}

function nearbyTentacleEntities(e, maxDistance) {
  try {
    return e.dimension.getEntities({ location: e.location, maxDistance });
  } catch {
    return [];
  }
}

function tentacleTargetRecord(tentacle, target) {
  const kind = targetKind(target);
  if (kind === null) return null;
  return {
    entity: target,
    kind,
    alive: isLivingEntity(target),
    onGround: entityIsOnGround(target),
    stuck: kind === "integrity_phase_3" && isEntityStuck(target),
    distance: distance(tentacle.location, target.location),
  };
}

function voidTentacleAttackCandidates(e, scale) {
  const records = nearbyTentacleEntities(
    e,
    VOID_TENTACLE_SOURCE.attackSearchRadiusMultiplier * scale,
  );
  return records
    .map((target) => tentacleTargetRecord(e, target))
    .filter((target) => target !== null);
}

function voidTentacleSweepCandidates(e, scale) {
  const players = [];
  const phase3Targets = [];
  const armTargets = [];
  for (const target of nearbyTentacleEntities(
    e,
    VOID_TENTACLE_SOURCE.sweepPlayerRadiusMultiplier * scale,
  )) {
    const record = tentacleTargetRecord(e, target);
    if (record === null) continue;
    if (record.kind === "player") players.push(record);
    if (record.kind === "integrity_phase_3") phase3Targets.push(record);
    if (record.kind === "integrity_p3_ground_arm") armTargets.push(record);
  }
  return { players, phase3Targets, armTargets };
}

function voidTentacleHasPlayerTarget(e) {
  let players = [];
  try { players = world.getAllPlayers(); } catch { return false; }
  return players.some((player) => (
    player.dimension.id === e.dimension.id
    && isLivingEntity(player)
    && distance(player.location, e.location) <= VOID_TENTACLE_SOURCE.targetAcquisitionRadius
  ));
}

function scheduleTentacleSweepDamage(e, playerTargets) {
  playerTargets.forEach((target, index) => {
    runLater(() => {
      applyEntityAttack(e, target.entity, VOID_TENTACLE_SOURCE.sweepDamage);
    }, index + 1);
  });
}

function executeVoidTentacleSweep(e, scale) {
  const candidates = voidTentacleSweepCandidates(e, scale);
  const plan = voidTentacleSweepPlan({ ...candidates, scale });
  scheduleTentacleSweepDamage(e, plan.playerTargets);
  if (plan.stuckTarget !== undefined && plan.stuckTarget !== null) {
    setEntityStuck(plan.stuckTarget.entity, true);
    if (plan.discardDelayTicks > 0) {
      runLater(() => {
        try { e.remove(); } catch {}
        deleteTimers(e);
      }, plan.discardDelayTicks);
    }
  }
}

function tickVoidTentacle(e) {
  const cooldown = getNum(e, "voidTentacleCooldown", 0);
  if (cooldown > 0) {
    setNum(e, "voidTentacleCooldown", cooldown - 1);
    return;
  }

  // The Java spawn hook rolls SCALE 1..5. Prefer a future exposed Bedrock
  // property, otherwise persist the same source roll in the controller timer.
  const scale = entityScale(e);
  const plan = voidTentacleAttackPlan({
    scale,
    candidates: voidTentacleAttackCandidates(e, scale),
    randomFloat: Math.random(),
    targetAcquired: voidTentacleHasPlayerTarget(e),
  });
  if (plan.candidateCount === 0) return;
  setNum(e, "voidTentacleCooldown", plan.cooldownTicks);
  if (plan.lookTarget) {
    try { e.lookAt?.(plan.lookTarget.entity.location); } catch {}
  }
  if (plan.action === "melee" && plan.meleeTarget) {
    applyEntityAttack(e, plan.meleeTarget.entity, VOID_TENTACLE_SOURCE.meleeDamage);
    return;
  }
  if (plan.action === "sweep") {
    playEntityAnimation(e, "animation.thebrokenscript.void_tentacle.360_sweep");
    executeVoidTentacleSweep(e, scale);
  }
}
