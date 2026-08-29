import { world, EntityDamageCause } from "@minecraft/server";
import { logger } from "../../core/logging.js";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as perf from "../../systems/perf.js";
import {
  GROUND_ARM_SOURCE,
  GROUND_ATTACK_SOURCE,
  PHASE3_SOURCE,
  phase3BoundaryKillStep,
  phase3TentacleCandidatePosition,
  groundArmImpactPlan,
  groundArmLifecycleStep,
  groundAttackStep,
} from "../../systems/integrity_arena_model.js";
import {
  FIREBALL_ATTACK_SOURCE,
  FIREBALL_BEDROCK_ADAPTER,
  PHASE3_ATTACK,
  fireballAttackStep,
  phase3AttackCooldown,
  phase3AttackLength,
  selectPhase3ImplementedAttack,
} from "../../systems/phase3_attack_model.js";

const RUNTIME_FAMILY = "thebrokenscript_phase3_runtime";
const states = new Map();
const armOwners = new Map();
const projectileStates = new Map();

function distance(a, b) {
  return Math.hypot(a.x - b.x, a.y - b.y, a.z - b.z);
}

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

function isStuck(entity) {
  if (callEntityMethod(entity, "hasTag", "thebrokenscript.stuck") === true) return true;
  return callEntityMethod(entity, "getProperty", "thebrokenscript:stuck") === true;
}

function setStuck(entity, stuck) {
  if (!isValid(entity)) return;
  if (stuck) {
    callEntityMethod(entity, "addTag", "thebrokenscript.stuck");
    callEntityMethod(entity, "setProperty", "thebrokenscript:stuck", true);
  } else {
    callEntityMethod(entity, "removeTag", "thebrokenscript.stuck");
    callEntityMethod(entity, "setProperty", "thebrokenscript:stuck", false);
  }
}

function dimensions() {
  const result = [];
  for (const id of ["overworld", "nether", "the_end", "thebrokenscript:stage2", "thebrokenscript:void_shadow"]) {
    const dim = perf.dim(id);
    if (dim) result.push(dim);
  }
  return result;
}

function runtimeEntities(dim) {
  try { return dim.getEntities({ families: [RUNTIME_FAMILY] }); } catch { return []; }
}

function nearestPlayer(entity, fixedId = null) {
  let players = [];
  try { players = world.getAllPlayers(); } catch { return null; }
  const candidates = players.filter((player) => {
    try {
      if (player.dimension.id !== entity.dimension.id || !isLiving(player)) return false;
      return fixedId === null || player.id === fixedId;
    } catch {
      return false;
    }
  });
  candidates.sort((a, b) => distance(entity.location, a.location) - distance(entity.location, b.location));
  return candidates[0] ?? null;
}

function spawnAt(dim, typeId, loc) {
  try { return dim.spawnEntity(typeId, loc); } catch { return undefined; }
}

function removeEntity(entity) {
  try { entity.remove(); } catch {}
  states.delete(entity.id);
  armOwners.delete(entity.id);
  projectileStates.delete(entity.id);
}

function applyEntityAttack(attacker, target, damage, cause = EntityDamageCause.entityAttack) {
  try {
    target.applyDamage(damage, { cause, damagingEntity: attacker });
    return true;
  } catch {
    try { target.applyDamage(damage); return true; } catch { return false; }
  }
}

function phase3SurfaceAirY(dim, x, z) {
  try {
    const top = dim.getTopmostBlock({ x, z });
    const topY = top?.location?.y;
    if (typeof topY !== "number") return null;
    const y = topY + 1;
    if (y > -40) return null;
    const block = dim.getBlock({ x, y, z });
    if (block && block.isAir !== true) return null;
    return y;
  } catch {
    return null;
  }
}

function setTentacleScale2(tentacle) {
  callEntityMethod(tentacle, "setProperty", "thebrokenscript:scale", 2);
  callEntityMethod(tentacle, "triggerEvent", "thebrokenscript:scale_2");
}

function spawnPhase3Tentacles(entity, state) {
  const rangeSpan = PHASE3_SOURCE.maxTentacleRangeExclusive - PHASE3_SOURCE.minTentacleRange;
  for (
    let index = PHASE3_SOURCE.tentacleCandidateIndexMin;
    index <= PHASE3_SOURCE.tentacleCandidateIndexMaxInclusive;
    index += 1
  ) {
    const range = PHASE3_SOURCE.minTentacleRange + Math.floor(Math.random() * rangeSpan);
    const candidate = phase3TentacleCandidatePosition(index, range);
    const y = phase3SurfaceAirY(entity.dimension, candidate.x, candidate.z);
    if (y === null) continue;
    const tentacle = spawnAt(entity.dimension, "thebrokenscript:void_tentacle", {
      x: candidate.x + 0.5,
      y,
      z: candidate.z + 0.5,
    });
    if (tentacle?.id) state.tentacleIds.push(tentacle.id);
  }
  for (const preset of PHASE3_SOURCE.presetTentacles) {
    const tentacle = spawnAt(entity.dimension, "thebrokenscript:void_tentacle", {
      x: preset.x + 0.5,
      y: preset.y,
      z: preset.z + 0.5,
    });
    if (!tentacle) continue;
    setTentacleScale2(tentacle);
    if (tentacle.id) state.tentacleIds.push(tentacle.id);
  }
}

function phase3Players(entity) {
  let players = [];
  try { players = world.getAllPlayers(); } catch { return []; }
  return players
    .filter((player) => {
      try { return player.dimension.id === entity.dimension.id; } catch { return false; }
    })
    .map((player) => ({ id: player.id, entity: player }));
}

function applyVoidMass(player, integrity) {
  try {
    player.applyDamage(1_000_000, { cause: EntityDamageCause.void, damagingEntity: integrity });
    return;
  } catch {}
  try { player.applyDamage(1_000_000); } catch {}
}

function initPhase3(entity) {
  const state = {
    phase3: true,
    phase3TentaclesSpawned: false,
    pendingKills: {},
    tentacleIds: [],
    currentAttack: PHASE3_ATTACK.NOOP,
    previousAttack: null,
    attackDelay: 0,
    attackTicks: 0,
    groundAttackTimer: 0,
    groundAttackTargetId: null,
    groundAttackTargetBlockPosition: null,
    shotFireball: false,
    stuckTimer: 0,
  };
  states.set(entity.id, state);
  bossHooks.setArenaState(true, false);
  return state;
}

function finishAttack(entity, state) {
  const finishedType = state.currentAttack;
  state.attackDelay = phase3AttackCooldown(finishedType);
  state.attackTicks = 0;
  state.groundAttackTimer = 0;
  state.groundAttackTargetId = null;
  state.groundAttackTargetBlockPosition = null;
  state.shotFireball = false;
  state.stuckTimer = 0;
  state.currentAttack = PHASE3_ATTACK.NOOP;
  setStuck(entity, false);
}

function blockPositionOf(entity) {
  return {
    x: Math.floor(entity.location.x),
    y: Math.floor(entity.location.y),
    z: Math.floor(entity.location.z),
  };
}

function setArmOwner(arm, owner) {
  if (arm?.id && isValid(owner)) armOwners.set(arm.id, owner);
}

function getArmOwner(arm) {
  const owner = armOwners.get(arm?.id);
  if (!isValid(owner)) {
    if (arm?.id) armOwners.delete(arm.id);
    return null;
  }
  return owner;
}

function spawnGroundArm(owner, targetBlock) {
  if (!targetBlock) return;
  const arm = spawnAt(owner.dimension, "thebrokenscript:integrity_arm", {
    x: targetBlock.x + 0.5,
    y: targetBlock.y,
    z: targetBlock.z + 0.5,
  });
  if (arm) {
    setArmOwner(arm, owner);
    states.set(arm.id, { groundArmTimer: 0, forwardedStuck: false });
  }
}

function tickGroundAttack(entity, state) {
  const target = nearestPlayer(entity, state.groundAttackTargetId);
  const step = groundAttackStep({
    timer: state.groundAttackTimer,
    targetBlockPosition: state.groundAttackTargetBlockPosition,
    targetBlock: target ? blockPositionOf(target) : null,
    hasTarget: target !== null,
    stuck: isStuck(entity),
  });
  state.groundAttackTimer = step.timer;
  state.groundAttackTargetBlockPosition = step.targetBlockPosition;
  if (target) {
    try { entity.lookAt?.(target.location); } catch {}
  }
  if (step.spawnArm) spawnGroundArm(entity, step.targetBlockPosition);
}

function fireballMuzzle(entity) {
  return {
    x: entity.location.x,
    y: entity.location.y + FIREBALL_BEDROCK_ADAPTER.muzzleHeightFromFeet,
    z: entity.location.z,
  };
}

function spawnFireball(entity, target) {
  const from = fireballMuzzle(entity);
  const fireball = spawnAt(entity.dimension, "thebrokenscript:integ_fireball", from);
  if (!fireball) return false;
  projectileStates.set(fireball.id, {
    ownerId: entity.id,
    dirX: target.location.x - from.x,
    dirY: target.location.y + FIREBALL_BEDROCK_ADAPTER.playerTargetCenterHeight - from.y,
    dirZ: target.location.z - from.z,
    life: FIREBALL_BEDROCK_ADAPTER.maxLifetimeTicks,
  });
  return true;
}

function tickFireballAttack(entity, state) {
  const target = nearestPlayer(entity);
  if (target) {
    try { entity.lookAt?.(target.location); } catch {}
  }
  const step = fireballAttackStep({
    attackTicks: state.attackTicks,
    shotFireball: state.shotFireball,
    hasTarget: target !== null,
  });
  if (step.launch && target) {
    // Java launches from the animated righttendrils5 bone at the `ballin;`
    // keyframe. Bedrock server scripts cannot read that client bone transform;
    // the adapter uses the boss collision-volume midpoint and launches once.
    if (spawnFireball(entity, target)) state.shotFireball = true;
  }
}

function maybeSelectAttack(entity, state, target) {
  if (state.currentAttack !== PHASE3_ATTACK.NOOP || !target || state.attackDelay > 0 || isStuck(entity)) return;
  const selected = selectPhase3ImplementedAttack({
    hasTarget: true,
    attackDelay: state.attackDelay,
    stuck: false,
    distance: distance(entity.location, target.location),
    previousAttack: state.previousAttack,
    randomFloat: Math.random(),
  });
  if (selected === null) return;
  state.previousAttack = selected;
  state.currentAttack = selected;
  state.attackTicks = 0;
  state.groundAttackTimer = 0;
  state.groundAttackTargetId = selected === PHASE3_ATTACK.GROUND_ATTACK ? target.id : null;
  state.groundAttackTargetBlockPosition = null;
  state.shotFireball = false;
}

function tickPhase3(entity) {
  const state = states.get(entity.id)?.phase3 ? states.get(entity.id) : initPhase3(entity);

  // IntegrityPhase3Entity starts a 100-tick stuck timer when it is stuck while
  // idle. Attacks clear stuck state when they finish.
  if (isStuck(entity) && state.currentAttack === PHASE3_ATTACK.NOOP) {
    if (state.stuckTimer <= 0) state.stuckTimer = 100;
    else {
      state.stuckTimer -= 1;
      if (state.stuckTimer <= 0) setStuck(entity, false);
    }
  } else if (!isStuck(entity)) {
    state.stuckTimer = 0;
  }

  if (!state.phase3TentaclesSpawned) {
    state.phase3TentaclesSpawned = true;
    spawnPhase3Tentacles(entity, state);
  }

  const players = phase3Players(entity);
  const boundary = phase3BoundaryKillStep({
    pendingKills: state.pendingKills,
    players: players.map((player) => ({
      id: player.id,
      y: player.entity.location.y,
      inStage3Dimension: player.entity.dimension.id === entity.dimension.id,
    })),
  });
  state.pendingKills = boundary.pendingKills;
  for (const id of boundary.killIds) {
    const target = players.find((player) => player.id === id);
    if (target) applyVoidMass(target.entity, entity);
  }

  const target = nearestPlayer(entity);
  if (state.attackDelay > 0) state.attackDelay -= 1;
  maybeSelectAttack(entity, state, target);
  if (state.currentAttack === PHASE3_ATTACK.NOOP || state.attackDelay > 0) return;

  state.attackTicks += 1;
  if (state.currentAttack === PHASE3_ATTACK.GROUND_ATTACK) tickGroundAttack(entity, state);
  if (state.currentAttack === PHASE3_ATTACK.FIREBALL) tickFireballAttack(entity, state);

  const length = phase3AttackLength(state.currentAttack, { stuck: isStuck(entity) });
  if (state.attackTicks >= length) finishAttack(entity, state);
}

function nearby(entity, maxDistance) {
  try { return entity.dimension.getEntities({ location: entity.location, maxDistance }); } catch { return []; }
}

function tickGroundArm(arm) {
  const owner = getArmOwner(arm);
  const state = states.get(arm.id) ?? { groundArmTimer: 0, forwardedStuck: false };
  states.set(arm.id, state);

  if (owner && isStuck(arm) && !state.forwardedStuck) {
    state.forwardedStuck = true;
    setStuck(owner, true);
  }
  if (!isStuck(arm)) state.forwardedStuck = false;

  const hasTentacleNearby = owner !== null && nearby(arm, GROUND_ARM_SOURCE.tentacleSearchRadius)
    .some((entity) => entity.typeId === "thebrokenscript:void_tentacle");
  const step = groundArmLifecycleStep({
    timer: state.groundArmTimer,
    ownerPresent: owner !== null,
    hasTentacleNearby,
  });
  state.groundArmTimer = step.timer;

  if (step.discard) {
    removeEntity(arm);
    return;
  }
  if (!step.impact || !owner) return;

  const candidates = nearby(arm, GROUND_ARM_SOURCE.impactRadius)
    .filter((entity) => entity.typeId === "minecraft:player" && isLiving(entity))
    .map((player) => ({
      id: player.id,
      entity: player,
      dx: player.location.x - arm.location.x,
      dz: player.location.z - arm.location.z,
    }));
  const impacts = groundArmImpactPlan({ intersectingPlayers: candidates });
  for (const impact of impacts) {
    const candidate = candidates.find((entry) => entry.id === impact.id);
    if (!candidate) continue;
    applyEntityAttack(owner, candidate.entity, impact.damage);
    callEntityMethod(candidate.entity, "applyImpulse", impact.knockback);
  }
}

function explodeFireball(fireball) {
  try {
    fireball.dimension.createExplosion(
      fireball.location,
      FIREBALL_ATTACK_SOURCE.explosionPower,
      {
        breaksBlocks: FIREBALL_ATTACK_SOURCE.breaksBlocks,
        causesFire: FIREBALL_ATTACK_SOURCE.causesFire,
        source: fireball,
      },
    );
  } catch {}
  removeEntity(fireball);
}

function fireballBlockHit(fireball, next) {
  try {
    const block = fireball.dimension.getBlock({
      x: Math.floor(next.x),
      y: Math.floor(next.y),
      z: Math.floor(next.z),
    });
    return block !== undefined && block.isAir !== true;
  } catch {
    return false;
  }
}

function fireballEntityHit(fireball, projectile) {
  const targets = nearby(fireball, FIREBALL_BEDROCK_ADAPTER.collisionRadius)
    .filter((entity) => (
      entity.id !== fireball.id
      && entity.id !== projectile.ownerId
      && isLiving(entity)
    ));
  return targets[0] ?? null;
}

function tickFireball(fireball) {
  const projectile = projectileStates.get(fireball.id);
  if (!projectile) {
    // Runtime-owned fireballs are initialized at spawn. Remove orphaned legacy
    // projectiles rather than falling back to the old 0.8/12-damage behavior.
    removeEntity(fireball);
    return;
  }

  const len = Math.hypot(projectile.dirX, projectile.dirY, projectile.dirZ);
  if (len <= 0) {
    explodeFireball(fireball);
    return;
  }
  const next = {
    x: fireball.location.x + (projectile.dirX / len) * FIREBALL_ATTACK_SOURCE.projectileSpeedBlocksPerTick,
    y: fireball.location.y + (projectile.dirY / len) * FIREBALL_ATTACK_SOURCE.projectileSpeedBlocksPerTick,
    z: fireball.location.z + (projectile.dirZ / len) * FIREBALL_ATTACK_SOURCE.projectileSpeedBlocksPerTick,
  };
  if (fireballBlockHit(fireball, next)) {
    explodeFireball(fireball);
    return;
  }
  try { fireball.teleport(next); } catch { removeEntity(fireball); return; }

  const hit = fireballEntityHit(fireball, projectile);
  if (hit) {
    applyEntityAttack(fireball, hit, FIREBALL_ATTACK_SOURCE.entityHitDamage, EntityDamageCause.projectile);
    explodeFireball(fireball);
    return;
  }

  projectile.life -= 1;
  if (projectile.life <= 0) removeEntity(fireball);
}

function tickEntity(entity) {
  switch (entity.typeId) {
    case "thebrokenscript:integrity_phase_3": return tickPhase3(entity);
    case "thebrokenscript:integrity_arm": return tickGroundArm(entity);
    case "thebrokenscript:integ_fireball": return tickFireball(entity);
  }
}

function onTick() {
  let players = [];
  try { players = world.getAllPlayers(); } catch { return; }
  if (players.length === 0) return;
  for (const dim of dimensions()) {
    for (const entity of runtimeEntities(dim)) {
      try { tickEntity(entity); } catch (error) { logger.error(`phase3 runtime ${entity.typeId} ${entity.id}`, error); }
    }
  }
}

export function begin(scheduler) {
  scheduler.every("tbs.phase3_runtime_tick", 1, onTick);
}
