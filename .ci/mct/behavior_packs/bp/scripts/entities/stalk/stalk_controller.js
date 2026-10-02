import * as operationDiagnostics from "../../core/operation_diagnostics.js";
﻿import { world, system } from "@minecraft/server";
import { EntityDamageCause, GameMode } from "@minecraft/server";
import * as worldState from "../../systems/world_state.js";
import * as playerState from "../../systems/player_state.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as gaze from "../../systems/ai/gaze.js";
import { logger } from "../../core/logging.js";
import * as perf from "../../systems/perf.js";
import { spawnSourceParticle } from "../../systems/particle_runtime.js";
import { showScreen } from "../../systems/screen_overlay.js";

// ── constants from decompiled sources ──────────────────────────────────────
// curved: approach only when NOT in FOV cone (0.55), ≤10 → transform 100t → hostile,
//         block-break when stuck, despawn 6200 + particles, chat death messages
// jon: join/left yellow chat, ≥40t + 1/5 chance chats, saidHello flips after >4 +50%
// sub_anomaly: corrupt-block placement rolls (12%/17.5%, 5% branch) — mossy surrogate
// obliteration pair: integrity_watching timer150, gaze-or-close condition, O2 stare-kick >100
// herobrine: statue life400, vanish ≤42
const CURVED_DESPAWN = 6200;
const SUB1_FOLLOW_RANGE = 916;
const SUB1_ATTACK_DAMAGE = 1;
const SUB1_ATTACK_RANGE = 1.5;
const SUB1_ATTACK_INTERVAL = 20;
const SUB1_MOVE_PER_TICK = 0.075 * 1.2;
const SUB2_TARGET_RANGE = 36;
const SUB2_CLOSE_DAMAGE = 2;
const SUB2_CLOSE_RANGE_SQR = 2;

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

function isAttackablePlayer(player) {
  const gm = typeof player?.getGameMode === "function" ? player.getGameMode() : undefined;
  return gm !== GameMode.Creative && gm !== GameMode.Spectator;
}

function moveHorizontallyToward(e, target, step) {
  const dx = target.location.x - e.location.x;
  const dz = target.location.z - e.location.z;
  const horizontal = Math.hypot(dx, dz);
  if (horizontal <= 0.0001) return;
  const amount = Math.min(step, horizontal);
  try {
    e.teleport({
      x: e.location.x + (dx / horizontal) * amount,
      y: e.location.y,
      z: e.location.z + (dz / horizontal) * amount,
    });
  } catch (error) {
    operationDiagnostics.warnOnce("sub_anomaly.chase", "sub anomaly chase movement failed", error);
  }
}

function inFovCone(player, entity, fovDeg = 70) {
  try {
    const view = player.getViewDirection();
    const to = { x: entity.location.x - player.location.x, y: (entity.location.y + 1.2) - (player.location.y + 1.62), z: entity.location.z - player.location.z };
    const len = Math.hypot(to.x, to.y, to.z) || 1;
    const n = { x: to.x / len, y: to.y / len, z: to.z / len };
    return (view.x * n.x + view.y * n.y + view.z * n.z) >= Math.cos(fovDeg * Math.PI / 360);
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.43", "best-effort Bedrock API fallback", error); return false; }
}

export function begin(scheduler) {
  scheduler.every("tbs.stalk_tick", 1, onTick);
}

function onTick() {
  if (!perf.hasPlayers(system.currentTick)) return; // perf: idle server short-circuit (Chunk 16)
  let list = [];
  const dimsById = new Map();
  try {
    const overworld = world.getDimension("overworld");
    dimsById.set(overworld.id, overworld);
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.54", "best-effort Bedrock API fallback", error);}
  for (const player of world.getAllPlayers()) {
    try { dimsById.set(player.dimension.id, player.dimension); } catch (error) {
      operationDiagnostics.warnOnce("stalk.player_dimension", "stalk: failed to inspect a player's active dimension", error);
    }
  }
  const dims = [...dimsById.values()];
  for (const dim of dims) {
    try { list = dim.getEntities({ families: ["thebrokenscript_stalk"] }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.56", "best-effort Bedrock API fallback", error); continue; }
    for (const e of list) {
      try { tickEntity(e); } catch (err) { logger.error(`stalk tick ${e.typeId} ${e.id}`, err); }
    }
  }
  if (system.currentTick % 200 === 0) {
    for (const id of timers.keys()) {
      try { if (!world.getEntity(id)) timers.delete(id); } catch (error) {
        operationDiagnostics.warnOnce("stalk.timer_prune", "stalk: failed to prune removed entity state", error);
      }
    }
  }
}

function tickEntity(e) {
  switch (e.typeId) {
    case "thebrokenscript:curved": return tickCurved(e);
    case "thebrokenscript:jon": return tickJon(e);
    case "thebrokenscript:sub_anomaly_1":
    case "thebrokenscript:sub_anomaly_2": return tickSubAnomaly(e);
    case "thebrokenscript:the_obliteration":
    case "thebrokenscript:the_obliteration_2": return tickObliteration(e);
    case "thebrokenscript:herobrine": return tickHerobrine(e);
  }
}

// ── Curved ───────────────────────────────────────────────────────────────────
function tickCurved(e) {
  if (!timers.has(e.id)) {
    timers.set(e.id, { life: CURVED_DESPAWN, transformed: 0, transformTimer: 100 });
    try { e.nameTag = "Curved"; } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.79", "best-effort Bedrock API fallback", error);}
    try { e.nameTagVisible = true; } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.80", "best-effort Bedrock API fallback", error);}
  }
  // survival player within 10 & not yet aggressive → invulnerable + begin transform
  for (const p of world.getAllPlayers()) {
    if (p.dimension.id !== e.dimension.id) continue;
    const gm = typeof p.getGameMode === "function" ? p.getGameMode() : undefined;
    const survival = gm !== GameMode.Creative && gm !== GameMode.Spectator;
    if (survival && distance(p.location, e.location) < 10 && getNum(e, "transformed", 0) === 0 && getNum(e, "aggressive", 0) === 0) {
      setNum(e, "aggressive", 1);
      setNum(e, "transformTimer", 100);
      break;
    }
  }
  if (getNum(e, "aggressive", 0)) {
    let tt = getNum(e, "transformTimer", 0);
    if (tt > 0) {
      tt--; setNum(e, "transformTimer", tt);
    } else if (getNum(e, "transformed", 0) === 0) {
      setNum(e, "transformed", 1);
      setNum(e, "meleePulse", 20);
    }
  } else {
    // untransformed: approach survival player ONLY when outside their FOV cone
    const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 192);
    if (player) {
      const gm = typeof player.getGameMode === "function" ? player.getGameMode() : undefined;
      const survival = gm !== GameMode.Creative && gm !== GameMode.Spectator;
      const seen = inFovCone(player, e);
      if (survival && !seen && system.currentTick % 10 === 0) {
        const dx = player.location.x - e.location.x;
        const dz = player.location.z - e.location.z;
        const len = Math.hypot(dx, dz) || 1;
        const step = 0.55 * 10 * 0.05; // 0.55 speed over 10 ticks
        try { e.teleport({ x: e.location.x + (dx / len) * step, y: e.location.y, z: e.location.z + (dz / len) * step }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.120", "best-effort Bedrock API fallback", error);}
      }
      try { e.lookAt?.(player.location); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.122", "best-effort Bedrock API fallback", error);}
    }
  }
  if (getNum(e, "transformed", 0) !== 0) {
    let meleePulse = getNum(e, "meleePulse", 20) - 1;
    if (meleePulse <= 0) {
      meleePulse = 20;
      const target = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 4);
      if (target) {
        try { target.applyDamage(7, { cause: EntityDamageCause.entityAttack, damagingEntity: e }); } catch { try { target.applyDamage(7); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.104", "best-effort Bedrock API fallback", error);} }
      }
    }
    setNum(e, "meleePulse", meleePulse);
  }
  const life = getNum(e, "life", CURVED_DESPAWN) - 1;
  setNum(e, "life", life);
  if (life <= 0) {
    spawnSourceParticle(e, "curved_despawn");
    try { e.remove(); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.129", "best-effort Bedrock API fallback", error);} deleteTimers(e);
  }
}

// ── Jon (friendly chatter NPC) ───────────────────────────────────────────────
function tickJon(e) {
  if (!timers.has(e.id)) {
    timers.set(e.id, { saidHello: 0, timesChatted: 0, lastChat: system.currentTick });
    try { e.dimension.runCommand(`tellraw @a {"rawtext":[{"text":"§ejon joined the game"}]}`); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.137", "best-effort Bedrock API fallback", error);}
  }
  const lastChat = getNum(e, "lastChat", 0);
  if (system.currentTick - lastChat >= 40 && Math.floor(Math.random() * 5) === 3) {
    const saidHello = getNum(e, "saidHello", 0);
    const msg = saidHello ? "<jon> let's play minecraft!" : "<jon> hello!";
    try { e.dimension.runCommand(`tellraw @a {"rawtext":[{"text":"${msg}"}]}`); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.143", "best-effort Bedrock API fallback", error);}
    try { e.playSound(saidHello ? "jon.play" : "jon.hello"); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.144", "best-effort Bedrock API fallback", error);}
    if (!saidHello) {
      const tc = getNum(e, "timesChatted", 0) + 1;
      setNum(e, "timesChatted", tc);
      if (tc > 4 && Math.random() < 0.5) setNum(e, "saidHello", 1);
    }
    setNum(e, "lastChat", system.currentTick);
  }
}

// ── SubAnomaly 1/2 ───────────────────────────────────────────────────────────
function tickSubAnomaly(e) {
  if (!timers.has(e.id)) timers.set(e.id, { init: 1 });

  if (e.typeId === "thebrokenscript:sub_anomaly_1") {
    tickSubAnomaly1Combat(e);
  } else if (e.typeId === "thebrokenscript:sub_anomaly_2") {
    tickSubAnomaly2CloseAttack(e);
  }

  // corrupt-block placement roll every ~40 ticks
  if (system.currentTick % 40 !== 0) return;
  const chance = getNum(e, "aggressive", 0) ? 0.175 : 0.12;
  if (Math.random() <= chance) {
    const ox = Math.floor(Math.random() * 11 - 5);
    const oy = Math.floor(Math.random() * 8 - 2);
    const oz = Math.floor(Math.random() * 11 - 5);
    try {
      const b = e.dimension.getBlock({ x: Math.floor(e.location.x) + ox, y: Math.floor(e.location.y) + oy, z: Math.floor(e.location.z) + oz });
      if (b && b.typeId === "minecraft:air") b.setType("thebrokenscript:corrupted_moon_stone_bricks");
    } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.167", "best-effort Bedrock API fallback", error);}
    if (Math.random() <= 0.05) {
      // 5% branch — extra spread block
      try {
        const b2 = e.dimension.getBlock({ x: Math.floor(e.location.x) + ox + 1, y: Math.floor(e.location.y) + oy, z: Math.floor(e.location.z) + oz });
        if (b2 && b2.typeId === "minecraft:air") b2.setType("thebrokenscript:corrupted_moon_stone_bricks");
      } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.173", "best-effort Bedrock API fallback", error);}
    }
  }
}

function tickSubAnomaly1Combat(e) {
  const target = entityFinder.closestPlayerForEntity(
    world.getAllPlayers().filter(isAttackablePlayer),
    e,
    SUB1_FOLLOW_RANGE,
  );
  if (!target) return;

  const d = distance(e.location, target.location);
  if (d > SUB1_ATTACK_RANGE) {
    moveHorizontallyToward(e, target, SUB1_MOVE_PER_TICK);
    try { e.lookAt?.(target.location); } catch (error) {
      operationDiagnostics.warnOnce("sub_anomaly_1.look", "SubAnomaly1 look-at failed", error);
    }
    return;
  }

  const readyAt = getNum(e, "sub1MeleeReadyAt", 0);
  if (system.currentTick < readyAt) return;
  try {
    target.applyDamage(SUB1_ATTACK_DAMAGE, {
      cause: EntityDamageCause.entityAttack,
      damagingEntity: e,
    });
    setNum(e, "sub1MeleeReadyAt", system.currentTick + SUB1_ATTACK_INTERVAL);
  } catch (error) {
    operationDiagnostics.warnOnce("sub_anomaly_1.melee", "SubAnomaly1 melee damage failed", error);
  }
}

function tickSubAnomaly2CloseAttack(e) {
  // SubAnomaly2 does not use a vanilla MeleeAttackGoal. Its brain acquires the
  // nearest Player within 36 blocks, and its priority-2 attack behavior applies
  // generic 2 damage while distanceToSqr(target) < 2. Preserve only that direct
  // behavior here; the separate divebomb state machine remains state-dependent.
  const target = entityFinder.closestPlayerForEntity(
    world.getAllPlayers().filter(isAttackablePlayer),
    e,
    SUB2_TARGET_RANGE,
  );
  if (!target) return;
  const dx = target.location.x - e.location.x;
  const dy = target.location.y - e.location.y;
  const dz = target.location.z - e.location.z;
  if ((dx * dx) + (dy * dy) + (dz * dz) >= SUB2_CLOSE_RANGE_SQR) return;
  try {
    target.applyDamage(SUB2_CLOSE_DAMAGE);
  } catch (error) {
    operationDiagnostics.warnOnce("sub_anomaly_2.close_attack", "SubAnomaly2 close attack failed", error);
  }
}

// ── Obliteration pair ────────────────────────────────────────────────────────
function tickObliteration(e) {
  const isTwo = e.typeId === "thebrokenscript:the_obliteration_2";
  if (!timers.has(e.id)) {
    timers.set(e.id, { watchTimer: 150, stareTicks: new Map() });
  }
  // hover drift (flying)
  if (system.currentTick % 15 === 0) {
    try { e.teleport({ x: e.location.x, y: e.location.y + 0.1, z: e.location.z }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.186", "best-effort Bedrock API fallback", error);}
  }
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 480);
  if (!player) return;
  const watching = gaze.isLookingAtEntity(player, e, 14);
  const close = distance(e.location, player.location) < 20;

  if (isTwo) {
    // The Java client animates oblit_2_effect while beneath O2's bounding box.
    // Match the horizontal footprint and lower half here in the server runtime.
    if (system.currentTick % 10 === 0) {
      for (const underneath of world.getAllPlayers()) {
        if (underneath.dimension.id !== e.dimension.id) continue;
        if (Math.abs(underneath.location.x - e.location.x) < 1.5
            && Math.abs(underneath.location.z - e.location.z) < 1.5
            && underneath.location.y < e.location.y) {
          showScreen(underneath, "oblit_2_effect", 5);
        }
      }
    }
    // triangle kick: staring at O2 accumulates ticks; >100 (5s) → kick attempt
    const key = `stare_${player.id}`;
    let s = getNum(e, key, 0);
    if (watching || close) {
      s++; setNum(e, key, s);
      if (s > 100) {
        try { e.remove(); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.200", "best-effort Bedrock API fallback", error);} deleteTimers(e);
        system.runTimeout(() => {
          try {
            const safeName = player.name.replace(/"/g, '\\"');
            player.dimension.runCommand(`kick "${safeName}" §cThe triangle has judged you.`);
          } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.205", "best-effort Bedrock API fallback", error);}
        }, 10);
        return;
      }
    } else if (s > 0) {
      setNum(e, key, 0);
      // reset player-side accumulator analogue
      try { playerState.set(player, "triangleKickTimer", 0); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.212", "best-effort Bedrock API fallback", error);}
    }
  } else {
    // O1: periodic watching sound beat every 150 ticks while observed/close
    const wt = getNum(e, "watchTimer", 150) - 1;
    if (wt <= 0) {
      setNum(e, "watchTimer", 150);
      if (watching || close) {
        tryPlayAt(e.dimension, e.location, "integrity_watching", 10, 2);
      }
    } else {
      setNum(e, "watchTimer", wt);
    }
  }
}

function tryPlayAt(dim, loc, sound, vol = 1, pitch = 1) {
  try { dim.playSound(sound, loc, { volume: vol, pitch }); return; } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.229", "best-effort Bedrock API fallback", error);}
  for (const p of world.getAllPlayers()) {
    if (p.dimension.id !== dim.id) continue;
    try { p.playSound(sound, { volume: vol, pitch }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.232", "best-effort Bedrock API fallback", error);}
  }
}

// ── Herobrine (static statue) ────────────────────────────────────────────────
function tickHerobrine(e) {
  let life = getNum(e, "life", 400);
  if (!timers.has(e.id)) { life = 400; timers.set(e.id, { life }); }
  const player = entityFinder.closestPlayerForEntity(world.getAllPlayers(), e, 158);
  if (player) {
    try { e.lookAt?.(player.location); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.242", "best-effort Bedrock API fallback", error);}
    if (distance(e.location, player.location) < 42) {
      try { e.remove(); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.244", "best-effort Bedrock API fallback", error);} deleteTimers(e);
      return;
    }
  }
  life--; setNum(e, "life", life);
  if (life <= 0) { try { e.remove(); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.stalk.stalk_controller.js.249", "best-effort Bedrock API fallback", error);} deleteTimers(e); }
}
