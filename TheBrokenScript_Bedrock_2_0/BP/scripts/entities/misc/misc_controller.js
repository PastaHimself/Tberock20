import { world, system } from "@minecraft/server";
import { EntityDamageCause, GameMode } from "@minecraft/server";
import * as worldState from "../../systems/world_state.js";
import * as dimensions from "../../systems/dimensions.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as gaze from "../../systems/ai/gaze.js";
import { logger } from "../../core/logging.js";
import * as perf from "../../systems/perf.js";

// ── constants from decompiled sources ──────────────────────────────────────
// xxram_2die: chat beats 1/500/1500/2000/2500/3000/3500, blink-teleport ≤25 within 520,
//             Anger 10 → 70% null_chase else ban; invis player-model "xXram2dieXx"
// niw: life 5200, white_noise spawn, ≤10 blindness500+glitch+70% midnight+chase, gaze≤100
// nothingiswatchingchase: ≤5 kick NIW_KICK, 1e-4 jitter ≤500
// phantom_player: life 7200, ≤200 1e-4 swap hetzer/circuit_stalk, ≤25 blick + discard
// hetzer: life 1200, observed/near → blindness5 pulses, end → circuit summon
// follow (NoTexture): ≤20 LOS 50% darkness60+health rnd / else teleport-player-to-self
// name_tag: despawn when survival player ≤15 or LOS; maze_shadows: despawn ≤15
const XXRAM_CHAT_BEATS = { 1: "h", 500: "j", 1500: "c1", 2000: "c2", 2500: "c3", 3000: "c4", 3500: "l" };
const NIW_LIFE = 5200;
const PHANTOM_LIFE = 7200;
const HETZER_LIFE = 1200;

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

function tryPlaySoundAt(dim, loc, sound, vol = 1, pitch = 1) {
  try { dim.playSound(sound, loc, { volume: vol, pitch }); return; } catch {}
  for (const p of world.getAllPlayers()) {
    if (p.dimension.id !== dim.id) continue;
    try { p.playSound(sound, { volume: vol, pitch }); } catch {}
  }
}

function setFakeTime(dim, t) {
  try { dim.runCommand(`time set ${t}`); } catch {}
}
function title(player, text, stay = 10) {
  try { player.onScreenDisplay.setTitle(text, { fadeInDuration: 0, stayDuration: stay, fadeOutDuration: 0 }); } catch {}
}
function chatAll(dim, text) {
  try { dim.runCommand(`tellraw @a {"rawtext":[{"text":"${text.replace(/"/g, '\\"')}"}]}`); } catch {}
}
function kickPlayer(player, reason) {
  system.runTimeout(() => {
    try {
      const safeName = player.name.replace(/"/g, '\\"');
      player.dimension.runCommand(`kick "${safeName}" ${reason}`);
    } catch {}
  }, 10);
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

export function begin(scheduler) {
  scheduler.every("tbs.misc_tick", 1, onTick);
  try {
    world.afterEvents.entityDie.subscribe((ev) => {
      try {
        if (ev.deadEntity.typeId !== "minecraft:player") return;
        const killer = ev.damageSource?.damagingEntity;
        if (!killer || killer.typeId !== "thebrokenscript:nothingiswatchingchase") return;
        // awardKillScore: discard + NIW_KICK
        try { killer.remove(); deleteTimers(killer); } catch {}
        kickPlayer(ev.deadEntity, "§kNothingiswatching");
      } catch {}
    });
  } catch {}
}

function onTick() {
  if (!perf.hasPlayers(system.currentTick)) return; // perf: idle server short-circuit (Chunk 16)
  let list = [];
  try { list = world.getDimension("overworld").getEntities({ families: ["thebrokenscript_misc"] }); } catch { return; }
  for (const e of list) {
    try { tickEntity(e); } catch (err) { logger.error(`misc tick ${e.typeId} ${e.id}`, err); }
  }
}

function tickEntity(e) {
  switch (e.typeId) {
    case "thebrokenscript:xxram_2die": return tickXxram(e);
    case "thebrokenscript:ban": return tickBan(e);
    case "thebrokenscript:niw": return tickNiw(e);
    case "thebrokenscript:nothingiswatchingchase": return tickNiwChase(e);
    case "thebrokenscript:phantom_player": return tickPhantom(e);
    case "thebrokenscript:hetzer": return tickHetzer(e);
    case "thebrokenscript:follow": return tickFollow(e);
    case "thebrokenscript:name_tag":
    case "thebrokenscript:maze_shadows": return tickWanderDespawn(e);
    case "thebrokenscript:null_cod":
    case "thebrokenscript:nothing_watcher": break; // vanilla-like / decorative — no script behavior needed
  }
}

// ── xxram_2die ───────────────────────────────────────────────────────────────
function tickXxram(e) {
  if (!timers.has(e.id)) {
    timers.set(e.id, { t: 0, anger: 0 });
    setNum(e, "invis", 1);
    try { e.addEffect("invisibility", 1000000, { amplifier: 0, showParticles: false }); } catch {}
    try { e.nameTag = "xXram2dieXx"; } catch {}
    try { e.nameTagVisible = true; } catch {}
    if (!worldState.get("hasRam2DieJoined")) worldState.set("hasRam2DieJoined", true);
  }
  const t = getNum(e, "t", 0) + 1;
  setNum(e, "t", t);
  switch (t) {
    case 1: chatAll(e.dimension, "<xXram2dieXx> has hosted the game."); break;
    case 500:
      chatAll(e.dimension, "xXram2dieXx joined the game");
      setNum(e, "invis", 0);
      try { e.removeEffect("invisibility"); } catch {}
      setFakeTime(e.dimension, "midnight");
      tryPlaySoundAt(e.dimension, e.location, "ambient.cave", 10, 0);
      break;
    case 1500:
      chatAll(e.dimension, "<xXram2dieXx> 48656c6c6f3f");
      setFakeTime(e.dimension, "midnight");
      tryPlaySoundAt(e.dimension, e.location, "ambient.cave", 10, 0);
      break;
    case 2000:
      chatAll(e.dimension, "<xXram2dieXx> 486f772064696420796f752066696e642074686973207365727665723f");
      setFakeTime(e.dimension, "midnight");
      tryPlaySoundAt(e.dimension, e.location, "ambient.cave", 10, 0);
      break;
    case 2500:
      chatAll(e.dimension, "<xXram2dieXx> 446f20796f752077616e7420746f20626520667269656e64733f");
      setFakeTime(e.dimension, "day");
      tryPlaySoundAt(e.dimension, e.location, "ambient.cave", 10, 0);
      break;
    case 3000:
      chatAll(e.dimension, "<xXram2dieXx> 4c656176652e");
      setFakeTime(e.dimension, "night");
      tryPlaySoundAt(e.dimension, e.location, "ambient.cave", 10, 0);
      break;
    case 3500:
      chatAll(e.dimension, "xXram2dieXx left the game");
      try { e.remove(); } catch {} deleteTimers(e);
      return;
  }
  // invis timer refresh while blinking
  if (getNum(e, "blink", 0) > 0) {
    setNum(e, "blink", getNum(e, "blink", 0) - 1);
    if (getNum(e, "blink", 0) <= 0) setNum(e, "invis", 0);
  }
  if (getNum(e, "invis", 0)) return;

  // unstick: teleport up if inside block
  try {
    const b = e.dimension.getBlock({ x: Math.floor(e.location.x), y: Math.floor(e.location.y), z: Math.floor(e.location.z) });
    if (b && !b.isAir && b.typeId !== "minecraft:air") {
      try { e.teleport({ x: e.location.x, y: e.location.y + 1, z: e.location.z }); } catch {}
    }
  } catch {}

  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 520);
  if (!player) return;
  try { e.lookAt?.(player.location); } catch {}
  if (distance(e.location, player.location) < 25) {
    // blink: go invisible 10 ticks and jump to a point along the player's view ray (~8 ahead)
    setNum(e, "blink", 10);
    setNum(e, "invis", 1);
    try { e.addEffect("invisibility", 220, { amplifier: 0, showParticles: false }); } catch {}
    try {
      const look = player.getViewDirection();
      const dest = { x: player.location.x + look.x * 8, y: player.location.y, z: player.location.z + look.z * 8 };
      e.teleport(dest);
    } catch {}
    const anger = getNum(e, "anger", 0) + 1;
    setNum(e, "anger", anger);
    if (anger >= 10) {
      try { e.remove(); } catch {} deleteTimers(e);
      if (Math.random() < 0.7) {
        const s = __spawn(e.dimension, "thebrokenscript:null_chase", e.location);
        if (s) { try { s.setRotation({ x: 0, y: Math.random() * 360 }); } catch {} }
      } else {
        __spawn(e.dimension, "thebrokenscript:ban", e.location);
      }
    }
  }
}

function __spawn(dim, typeId, loc) {
  try { return dim.spawnEntity(typeId, loc); } catch { return undefined; }
}

// ── ban ──────────────────────────────────────────────────────────────────────
function tickBan(e) {
  // nearest player ≤128 gets PlayerVariables.ban=true then entity discards
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 128);
  if (player) {
    try { player.setDynamicProperty("tbs:ban", true); } catch {}
  }
  try { e.remove(); } catch {} deleteTimers(e);
}

// ── niw (nothingiswatching) ──────────────────────────────────────────────────
function tickNiw(e) {
  let life = getNum(e, "life", NIW_LIFE);
  if (!timers.has(e.id)) {
    life = NIW_LIFE; timers.set(e.id, { life });
    tryPlaySoundAt(e.dimension, e.location, "thebrokenscript:white_noise", 10, 0);
  }
  const closest = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 510);
  if (closest) {
    if (distance(e.location, closest.location) < 10) {
      try { closest.addEffect("blindness", 500, { amplifier: 1, showParticles: false }); } catch {}
      tryPlaySoundAt(e.dimension, e.location, "thebrokenscript:glitch_sound_1", 10, 0);
      if (Math.random() < 0.7) setFakeTime(e.dimension, "midnight");
      __spawn(e.dimension, "thebrokenscript:nothingiswatchingchase", e.location);
      try { e.remove(); } catch {} deleteTimers(e);
      return;
    }
    if (distance(e.location, closest.location) < 100 && gaze.isLookingAtLocation(closest, e.location, 14)) {
      try { e.remove(); } catch {} deleteTimers(e);
      if (Math.random() < 0.7) {
        const s = __spawn(e.dimension, "thebrokenscript:nothingiswatchingchase", e.location);
        if (s) { try { s.setRotation({ x: 0, y: Math.random() * 360 }); } catch {} }
      } else {
        try { e.dimension.spawnEntity("minecraft:lightning_bolt", closest.location); } catch {}
      }
      return;
    }
  }
  life--; setNum(e, "life", life);
  if (life <= 0) { try { e.remove(); } catch {} deleteTimers(e); }
}

// ── nothingiswatchingchase ───────────────────────────────────────────────────
function tickNiwChase(e) {
  const target = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 500);
  if (!target) return;
  try { e.lookAt?.(target.location); } catch {}
  if (distance(e.location, target.location) < 5) {
    try { e.remove(); } catch {} deleteTimers(e);
    kickPlayer(target, "§kNothingiswatching");
    return;
  }
  if (Math.random() < 0.0001 && distance(e.location, target.location) < 500) {
    // jitter teleport near target
    try {
      e.teleport({
        x: target.location.x + (Math.random() * 20 - 10),
        y: target.location.y,
        z: target.location.z + (Math.random() * 20 - 10)
      });
    } catch {}
  }
  if (system.currentTick % 20 === 0 && distance(e.location, target.location) < 12) {
    try { target.applyDamage(3, { cause: EntityDamageCause.entityAttack, damagingEntity: e }); } catch { try { target.applyDamage(3); } catch {} }
  }
}

// ── phantom_player ───────────────────────────────────────────────────────────
function tickPhantom(e) {
  let life = getNum(e, "life", PHANTOM_LIFE);
  if (!timers.has(e.id)) {
    life = PHANTOM_LIFE; timers.set(e.id, { life });
    try { e.nameTag = "Phantom Player (notexture)"; } catch {}
    try { e.nameTagVisible = true; } catch {}
  }
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 256);
  if (player) {
    if (distance(e.location, player.location) < 200 && Math.random() < 0.0001) {
      try { e.remove(); } catch {} deleteTimers(e);
      if (Math.random() < 0.5) {
        const s = __spawn(e.dimension, "thebrokenscript:hetzer", e.location);
        if (s) { try { s.setRotation({ x: 0, y: Math.random() * 360 }); } catch {} }
      } else {
        const s = __spawn(e.dimension, "thebrokenscript:circuit_stalk", e.location);
        if (s) { try { s.setRotation({ x: 0, y: Math.random() * 360 }); } catch {} }
      }
      return;
    }
    if (distance(e.location, player.location) < 25) {
      title(player, "blick", 20);
      try { e.remove(); } catch {} deleteTimers(e);
      return;
    }
  }
  life--; setNum(e, "life", life);
  if (life <= 0) { try { e.remove(); } catch {} deleteTimers(e); }
}

// ── hetzer ───────────────────────────────────────────────────────────────────
function tickHetzer(e) {
  let life = getNum(e, "life", HETZER_LIFE);
  if (!timers.has(e.id)) { life = HETZER_LIFE; timers.set(e.id, { life }); }
  // hover approximation (FlyingPathNavigation): gentle float bob every 10 ticks
  if (system.currentTick % 10 === 0) {
    try { e.teleport({ x: e.location.x, y: e.location.y + 0.15, z: e.location.z }); } catch {}
  }
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 64);
  if (player) {
    const observed = gaze.isLookingAtLocation(player, e.location, 14) || distance(e.location, player.location) < 10;
    if (observed && system.currentTick % 40 === 0) {
      try { player.addEffect("blindness", 5, { amplifier: 1, showParticles: false }); } catch {}
    }
  }
  life--; setNum(e, "life", life);
  if (life <= 0) {
    try { e.remove(); } catch {} deleteTimers(e);
    __spawn(e.dimension, "thebrokenscript:circuit", e.location);
  }
}

// ── follow ("No Texture") ────────────────────────────────────────────────────
function tickFollow(e) {
  // wretched particle drip
  if (system.currentTick % 30 === 0) {
    try { e.dimension.spawnParticle("minecraft:basic_smoke_particle", { x: e.location.x, y: e.location.y + 1, z: e.location.z }); } catch {}
  }
  // disruption block placement every ~20 ticks (Chunk 08 block now available)
  if (system.currentTick % 20 === 0) {
    try {
      const ox = (Math.random() < 0.5 ? 1 : -1) * Math.floor(Math.random() * 6);
      const oy = Math.floor(Math.random() * 6);
      const oz = (Math.random() < 0.5 ? 1 : -1) * Math.floor(Math.random() * 6);
      const b = e.dimension.getBlock({ x: Math.floor(e.location.x) + ox, y: Math.floor(e.location.y) + oy, z: Math.floor(e.location.z) + oz });
      if (b && b.typeId === "minecraft:air") b.setType("thebrokenscript:disruption");
    } catch {}
  }
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 40);
  if (player && distance(e.location, player.location) < 20 && hasLineOfSightApprox(player, e)) {
    try { e.remove(); } catch {} deleteTimers(e);
    if (Math.random() < 0.5) {
      tryPlaySoundAt(e.dimension, player.location, "thebrokenscript:text_madness_1", 10, 0);
      try { player.addEffect("darkness", 60, { amplifier: 1, showParticles: false }); } catch {}
      // source: random CLAN_VOID / NULL_TORTURE destination + fixPos/skipFallDamage flags
      const dest = Math.random() < 0.5 ? "clan_void" : "null_torture";
      dimensions.teleportTo(player, dest, { x: player.location.x, y: 201, z: player.location.z });
      try { player.setDynamicProperty("tbs:fixPos", true); } catch {}
      try { player.setDynamicProperty("tbs:skipFallDamage", true); } catch {}
    } else {
      try { player.teleport(e.location); } catch {}
      // give SERIAL_DESIGNATION_N item pending Chunk 09 — ledgered skip
    }
    return;
  }
  try {
    const time = world.getTimeOfDay();
    if (time >= 23000 || time < 1000) { try { e.remove(); } catch {} deleteTimers(e); }
  } catch {}
}

// ── wanderers with proximity despawn (name_tag, maze_shadows) ────────────────
function tickWanderDespawn(e) {
  if (!timers.has(e.id)) {
    timers.set(e.id, { init: 1 });
    if (e.typeId === "thebrokenscript:name_tag") {
      const chars = "abcdefghijklmnopqrstuvwxyz0123456789_";
      let n = "";
      for (let i = 0; i < 8 + Math.floor(Math.random() * 5); i++) n += chars[Math.floor(Math.random() * chars.length)];
      try { e.nameTag = n; } catch {}
    } else {
      const nick = Math.random() < 0.175 ? "WormMan9" : String(100000 + Math.floor(Math.random() * 100000));
      try { e.nameTag = nick; } catch {}
    }
    try { e.nameTagVisible = true; } catch {}
  }
  for (const p of world.getAllPlayers()) {
    if (p.dimension.id !== e.dimension.id) continue;
    const gm = typeof p.getGameMode === "function" ? p.getGameMode() : undefined;
    if (gm === GameMode.Creative || gm === GameMode.Spectator) continue;
    if (distance(p.location, e.location) < (e.typeId === "thebrokenscript:maze_shadows" ? 15 : 15) || hasLineOfSightApprox(p, e)) {
      try { e.remove(); } catch {} deleteTimers(e);
      return;
    }
  }
}
