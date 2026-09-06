import { world, system } from "@minecraft/server";
import * as worldState from "../../systems/world_state.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as gaze from "../../systems/ai/gaze.js";
import { logger } from "../../core/logging.js";
import * as perf from "../../systems/perf.js";

// ── constants from decompiled sources ──────────────────────────────────────
// curved: approach only when NOT in FOV cone (0.55), ≤10 → transform 100t → hostile,
//         block-break when stuck, despawn 6200 + particles, chat death messages
// jon: join/left yellow chat, ≥40t + 1/5 chance chats, saidHello flips after >4 +50%
// sub_anomaly: corrupt-block placement rolls (12%/17.5%, 5% branch) — mossy surrogate
// obliteration pair: integrity_watching timer150, gaze-or-close condition, O2 stare-kick >100
// herobrine: statue life400, vanish ≤42
const CURVED_DESPAWN = 6200;

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

function inFovCone(player, entity, fovDeg = 70) {
  try {
    const view = player.getViewDirection();
    const to = { x: entity.location.x - player.location.x, y: (entity.location.y + 1.2) - (player.location.y + 1.62), z: entity.location.z - player.location.z };
    const len = Math.hypot(to.x, to.y, to.z) || 1;
    const n = { x: to.x / len, y: to.y / len, z: to.z / len };
    return (view.x * n.x + view.y * n.y + view.z * n.z) >= Math.cos(fovDeg * Math.PI / 360);
  } catch { return false; }
}

export function begin(scheduler) {
  scheduler.every("tbs.stalk_tick", 1, onTick);
}

function onTick() {
  if (!perf.hasPlayers(system.currentTick)) return; // perf: idle server short-circuit (Chunk 16)
  let list = [];
  const dims = [];
  try { dims.push(world.getDimension("overworld")); } catch {}
  for (const dim of dims) {
    try { list = dim.getEntities({ families: ["thebrokenscript_stalk"] }); } catch { continue; }
    for (const e of list) {
      try { tickEntity(e); } catch (err) { logger.error(`stalk tick ${e.typeId} ${e.id}`, err); }
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
    try { e.nameTag = "Curved"; } catch {}
    try { e.nameTagVisible = true; } catch {}
  }
  // survival player within 10 & not yet aggressive → invulnerable + begin transform
  for (const p of world.getAllPlayers()) {
    if (p.dimension.id !== e.dimension.id) continue;
    const gm = typeof p.getGameMode === "function" ? p.getGameMode() : undefined;
    const survival = gm !== "creative" && gm !== "spectator" && gm !== 1 && gm !== 3;
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
      // melee pulses while transformed
      system.runInterval(() => {
        if (!e.isValid()) return;
        const target = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 4);
        if (target) {
          try { target.applyDamage(7, { cause: "entityAttack", damagingEntity: e }); } catch { try { target.applyDamage(7); } catch {} }
        }
      }, 20);
    }
  } else {
    // untransformed: approach survival player ONLY when outside their FOV cone
    const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 192);
    if (player) {
      const gm = typeof player.getGameMode === "function" ? player.getGameMode() : undefined;
      const survival = gm !== "creative" && gm !== "spectator" && gm !== 1 && gm !== 3;
      const seen = inFovCone(player, e);
      if (survival && !seen && system.currentTick % 10 === 0) {
        const dx = player.location.x - e.location.x;
        const dz = player.location.z - e.location.z;
        const len = Math.hypot(dx, dz) || 1;
        const step = 0.55 * 10 * 0.05; // 0.55 speed over 10 ticks
        try { e.teleport({ x: e.location.x + (dx / len) * step, y: e.location.y, z: e.location.z + (dz / len) * step }); } catch {}
      }
      try { e.lookAt?.(player.location); } catch {}
    }
  }
  const life = getNum(e, "life", CURVED_DESPAWN) - 1;
  setNum(e, "life", life);
  if (life <= 0) {
    try { e.dimension.spawnParticle("minecraft:basic_smoke_particle", { x: e.location.x, y: e.location.y + 1, z: e.location.z }); } catch {}
    try { e.remove(); } catch {} deleteTimers(e);
  }
}

// ── Jon (friendly chatter NPC) ───────────────────────────────────────────────
function tickJon(e) {
  if (!timers.has(e.id)) {
    timers.set(e.id, { saidHello: 0, timesChatted: 0, lastChat: system.currentTick });
    try { e.dimension.runCommandAsync(`tellraw @a {"rawtext":[{"text":"§ejon joined the game"}]}`); } catch {}
  }
  const lastChat = getNum(e, "lastChat", 0);
  if (system.currentTick - lastChat >= 40 && Math.floor(Math.random() * 5) === 3) {
    const saidHello = getNum(e, "saidHello", 0);
    const msg = saidHello ? "<jon> let's play minecraft!" : "<jon> hello!";
    try { e.dimension.runCommandAsync(`tellraw @a {"rawtext":[{"text":"${msg}"}]}`); } catch {}
    try { e.playSound(saidHello ? "thebrokenscript:jon.play" : "thebrokenscript:jon.hello"); } catch {}
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
  if (!timers.has(e.id)) { timers.set(e.id, { init: 1 }); return; }
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
    } catch {}
    if (Math.random() <= 0.05) {
      // 5% branch — extra spread block
      try {
        const b2 = e.dimension.getBlock({ x: Math.floor(e.location.x) + ox + 1, y: Math.floor(e.location.y) + oy, z: Math.floor(e.location.z) + oz });
        if (b2 && b2.typeId === "minecraft:air") b2.setType("thebrokenscript:corrupted_moon_stone_bricks");
      } catch {}
    }
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
    try { e.teleport({ x: e.location.x, y: e.location.y + 0.1, z: e.location.z }); } catch {}
  }
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 480);
  if (!player) return;
  const watching = gaze.isLookingAtLocation(player, e.location, 14);
  const close = distance(e.location, player.location) < 20;

  if (isTwo) {
    // triangle kick: staring at O2 accumulates ticks; >100 (5s) → kick attempt
    const key = `stare_${player.id}`;
    let s = getNum(e, key, 0);
    if (watching || close) {
      s++; setNum(e, key, s);
      if (s > 100) {
        try { e.remove(); } catch {} deleteTimers(e);
        system.runTimeout(() => {
          try {
            const safeName = player.name.replace(/"/g, '\\"');
            player.dimension.runCommandAsync(`kick "${safeName}" §cThe triangle has judged you.`).catch(() => {});
          } catch {}
        }, 10);
        return;
      }
    } else if (s > 0) {
      setNum(e, key, 0);
      // reset player-side accumulator analogue
      try { player.setDynamicProperty("tbs:triangleKickTimer", 0); } catch {}
    }
  } else {
    // O1: periodic watching sound beat every 150 ticks while observed/close
    const wt = getNum(e, "watchTimer", 150) - 1;
    if (wt <= 0) {
      setNum(e, "watchTimer", 150);
      if (watching || close) {
        tryPlayAt(e.dimension, e.location, "thebrokenscript:integrity_watching", 10, 2);
      }
    } else {
      setNum(e, "watchTimer", wt);
    }
  }
}

function tryPlayAt(dim, loc, sound, vol = 1, pitch = 1) {
  try { dim.playSound(sound, loc, { volume: vol, pitch }); return; } catch {}
  for (const p of world.getAllPlayers()) {
    if (p.dimension.id !== dim.id) continue;
    try { p.playSound(sound, { volume: vol, pitch }); } catch {}
  }
}

// ── Herobrine (static statue) ────────────────────────────────────────────────
function tickHerobrine(e) {
  let life = getNum(e, "life", 400);
  if (!timers.has(e.id)) { life = 400; timers.set(e.id, { life }); }
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 158);
  if (player) {
    try { e.lookAt?.(player.location); } catch {}
    if (distance(e.location, player.location) < 42) {
      try { e.remove(); } catch {} deleteTimers(e);
      return;
    }
  }
  life--; setNum(e, "life", life);
  if (life <= 0) { try { e.remove(); } catch {} deleteTimers(e); }
}
