import { world, system } from "@minecraft/server";
import { config } from "../../core/config.js";
import { GameMode } from "@minecraft/server";
import * as worldState from "../../systems/world_state.js";
import * as playerState from "../../systems/player_state.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as gaze from "../../systems/ai/gaze.js";
import * as effects from "../../systems/ai/effects.js";
import * as spawnHelpers from "../../systems/ai/spawn_helpers.js";
import * as progression from "../../systems/progression.js";
import { logger } from "../../core/logging.js";
import * as perf from "../../systems/perf.js";

// ── constants from decompiled sources ──────────────────────────────────────
// the_broken_end : HP1000 ATK600 0.6×25 size, speed 0.45, follow 64, grace 150, life 1000, chase range 128
// stalk          : HP500  ATK15  4.5×25, life 7200 + spawnTimer 320, invis triggers 30 / 192
// curious        : HP500  ATK15  0.6×25, life 2400, weeping-angel, noticed 45→60, tbespawn1 at 45
// ambush         : HP1000 0.6×1.8, lifetime 18000-24000, despawn 26, behind-spawn 15-30
const GRACE_TICKS = 150;
const TBE_LIFE = 1000;
const STALK_LIFE = 7200;
const STALK_SPAWN_DELAY = 320;
const CURIOUS_LIFE = 2400;
const CURIOUS_NOTICED_SOUND = 45;
const CURIOUS_NOTICED_DISCARD = 60;
const AMBUSH_DESPAWN_TICKS = 26;
const UNBREAKABLE = new Set([
  "minecraft:bedrock", "minecraft:barrier", "minecraft:border_block",
  "minecraft:command_block", "minecraft:chain_command_block", "minecraft:repeating_command_block",
  "minecraft:end_portal", "minecraft:end_portal_frame", "minecraft:nether_portal",
  "minecraft:structure_block", "minecraft:jigsaw", "minecraft:allow", "minecraft:deny",
  "minecraft:light_block"
]);

const timers = new Map();
const extraState = new Map(); // id -> { grace, life, interferences, aCounter, stuckTicks, lastSeen, hasSeen }

function getState(e) {
  let s = extraState.get(e.id);
  if (!s) {
    s = { grace: GRACE_TICKS, life: TBE_LIFE, interferences: 0, aCounter: 0, stuckTicks: 0, lastSeen: 0, hasSeen: false };
    extraState.set(e.id, s);
  }
  return s;
}
function getNum(e, key, def) {
  const m = timers.get(e.id);
  if (!m) return def;
  return m[key] ?? def;
}
function setNum(e, key, value) {
  let m = timers.get(e.id);
  if (!m) { m = {}; timers.set(e.id, m); }
  m[key] = value;
}

export function begin(scheduler) {
  scheduler.every("tbs.tbe_tick", 1, onTick);
  // listen for player deaths caused by TBE to approximate awardKillScore kick/ban
  try {
    world.afterEvents.entityDie.subscribe((ev) => {
      try {
        if (ev.deadEntity.typeId !== "minecraft:player") return;
        const cause = ev.damageSource;
        const killer = cause?.damagingEntity;
        if (!killer || killer.typeId !== "thebrokenscript:the_broken_end") return;
        onTbeKillPlayer(ev.deadEntity, killer);
      } catch {}
    });
  } catch {}
}

function onTick() {
  if (!perf.hasPlayers(system.currentTick)) return; // perf: idle server short-circuit (Chunk 16)
  // query all dims for tbe family
  const dims = [];
  const overworld = perf.dim("overworld");
  if (overworld) dims.push(overworld);
  const nether = perf.dim("nether");
  if (nether) dims.push(nether);
  const theEnd = perf.dim("the_end");
  if (theEnd) dims.push(theEnd);
  for (const dim of dims) {
    let list = [];
    try { list = dim.getEntities({ families: ["thebrokenscript_tbe"] }); } catch { continue; }
    for (const e of list) {
      try { tickEntity(e); } catch (err) { logger.error(`tbe tick ${e.typeId} ${e.id}`, err); }
    }
  }
}

function tickEntity(e) {
  const id = e.typeId;
  if (id === "thebrokenscript:the_broken_end") tickBrokenEnd(e);
  else if (id === "thebrokenscript:the_broken_end_stalk") tickStalk(e);
  else if (id === "thebrokenscript:the_broken_end_curious") tickCurious(e);
  else if (id === "thebrokenscript:the_broken_end_ambush") tickAmbush(e);
}

// ── helpers ─────────────────────────────────────────────────────────────────
function distance(a, b) { return Math.hypot(a.x - b.x, a.y - b.y, a.z - b.z); }

function tryPlaySoundAt(dim, loc, sound, vol = 1, pitch = 1) {
  try { dim.playSound(sound, loc, { volume: vol, pitch }); return; } catch {}
  try { world.getAllPlayers().forEach(p => { if (p.dimension.id === dim.id) { try { p.playSound(sound, { volume: vol, pitch }); } catch {} } }); } catch {}
}

function setFakeTime(dim, timeStr) {
  // source: TimeOfDay.MIDNIGHT/DAY/NOON setFake — approximation via /time set
  try { dim.runCommand(`time set ${timeStr}`); } catch {}
}

/**
 * @param {import("@minecraft/server").Player} player
 * @param {string} subtitle
 * @param {number} [stayDuration]
 */
function showSubtitle(player, subtitle, stayDuration = 10) {
  try {
    player.onScreenDisplay.setTitle(" ", {
      subtitle,
      fadeInDuration: 0,
      stayDuration,
      fadeOutDuration: 0,
    });
  } catch {}
}

function hasLineOfSightApprox(player, entity) {
  // Bedrock has no cheap LOS, approximate with raycast testing obstruction up to entity
  try {
    const origin = { x: player.location.x, y: player.location.y + 1.62, z: player.location.z };
    const dir = { x: entity.location.x - origin.x, y: (entity.location.y + 1) - origin.y, z: entity.location.z - origin.z };
    const len = Math.hypot(dir.x, dir.y, dir.z);
    if (len === 0) return true;
    const ndir = { x: dir.x / len, y: dir.y / len, z: dir.z / len };
    const hit = player.dimension.getBlockFromRay(origin, ndir, { maxDistance: len, includeLiquidBlocks: false, includePassableBlocks: false });
    if (!hit) return true;
    // if hit block is substantially before entity (distance to hit < dist to entity - 1), LOS blocked
    const hitDist = Math.hypot(hit.block.location.x - origin.x, hit.block.location.y - origin.y, hit.block.location.z - origin.z);
    return hitDist > len - 1.2;
  } catch { return true; }
}

function isWithin(entity, player, radius) {
  return distance(entity.location, player.location) < radius;
}

// ── The Broken End (main) ────────────────────────────────────────────────────
function tickBrokenEnd(e) {
  const state = getState(e);
  // grace countdown (NoAI period) — at grace==30 play THE_END_IS_NEAR locally approximation
  if (state.grace > 0) {
    state.grace--;
    if (state.grace === 30) {
      tryPlaySoundAt(e.dimension, e.location, "thebrokenscript:the_end_is_near", 4, 1);
    }
    if (state.grace <= 0) {
      // re-enable AI (BP entity already has physics; nothing to toggle script-side)
    }
    // still tick life? source only ticks timer after grace; keep frozen until grace ends per source baseTick early return
    return;
  }

  // life timer 1000 -> discard (REP GAIN_MEDIUM ledgered)
  state.life--;
  if (state.life <= 0) {
    try { e.remove(); } catch {}
    timers.delete(e.id); extraState.delete(e.id);
    return;
  }

  // target handling — closest player within 128 chase range (source ChaseGoal detectionRange 128)
  const player = entityFinder.closestPlayerInRange(world.getAllPlayers().filter(p => p.dimension.id === e.dimension.id), e.location, 128);
  if (player) {
    // keep hasSeen if within LOS (1000 scan every 10 ticks — approximate each tick)
    if (hasLineOfSightApprox(player, e)) {
      state.hasSeen = true;
      state.lastSeen = system.currentTick;
    }

    // fake time + overlay "a" counter every 150 ticks
    state.aCounter++;
    if (state.aCounter > 150) {
      state.aCounter = 0;
      const r = Math.random();
      if (r < 0.7) {
        setFakeTime(e.dimension, "midnight");
        showSubtitle(player, " ");
        // frame1.png overlay approx via title image path — use title text for portability
        try { player.onScreenDisplay.setTitle("§k▓▓ §r", { fadeInDuration: 0, stayDuration: 10, fadeOutDuration: 0 }); } catch {}
        tryPlaySoundAt(e.dimension, e.location, "thebrokenscript:the_end_is_near", 4, 0.4);
      } else if (Math.random() < 0.7) {
        setFakeTime(e.dimension, "day");
        try { player.onScreenDisplay.setTitle("§k▓▓ §r", { fadeInDuration: 0, stayDuration: 10, fadeOutDuration: 0 }); } catch {}
      } else if (Math.random() < 0.7) {
        setFakeTime(e.dimension, "noon");
        try { player.onScreenDisplay.setTitle("wecanhearyou", { fadeInDuration: 0, stayDuration: 10, fadeOutDuration: 0 }); } catch {}
      }
    }

    // interferences strobe — increment each tick while chasing, flash frames 1..4 every 3 ticks
    state.interferences++;
    // source increments every tick when targeting player and shows frames at 3/6/9/12 then reset
    // approximate: at 3/6/9/12 show titles
    if (state.interferences === 3) {
      showSubtitle(player, "tbescreenframe_1");
      try { e.dimension.spawnParticle("minecraft:campfire_cosy_smoke", { x: e.location.x, y: e.location.y + 1.5, z: e.location.z }); } catch {}
    } else if (state.interferences === 6) {
      showSubtitle(player, "tbescreenframe_2");
    } else if (state.interferences === 9) {
      showSubtitle(player, "tbescreenframe_3");
    } else if (state.interferences >= 12) {
      showSubtitle(player, "tbescreenframe_4");
      state.interferences = 0;
    }

    // dig slowdown analogue: slowness + mining fatigue? use slowness
    try { player.addEffect("mining_fatigue", 10, { amplifier: 1, showParticles: false }); } catch {}
    try { player.addEffect("slowness", 10, { amplifier: 1, showParticles: false }); } catch {}

    // damage nearby golem/boat analogues (~20 blocks): break boats via kill, damage golems — ledger skip unless entity nearby
    try {
      const nearbyGolem = e.dimension.getEntities({ type: "minecraft:iron_golem", location: e.location, maxDistance: 20 });
      for (const g of nearbyGolem.slice(0, 1)) { try { g.applyDamage(30); } catch {} }
      const nearbyBoat = e.dimension.getEntities({ location: e.location, maxDistance: 20 }).filter(x => x.typeId.includes("boat"));
      for (const b of nearbyBoat.slice(0, 1)) { try { b.applyDamage(30); } catch { try { b.remove(); } catch {} } }
    } catch {}

    // force survival gamemode in production (approx: try command)
    // skip — requires operator; ledgered

    // stuck detection: if velocity near 0 for 40 ticks while having target, teleport up to target Y
    try {
      const vel = e.getVelocity();
      const speed = Math.hypot(vel.x, vel.y, vel.z);
      if (speed < 0.02 && e.isOnGround) state.stuckTicks++;
      else state.stuckTicks = 0;
      if (state.stuckTicks > 40) {
        try { e.teleport({ x: e.location.x, y: player.location.y, z: e.location.z }); } catch {}
        state.stuckTicks = 0;
      }
    } catch { state.stuckTicks = 0; }

    // block-break scan every 20 ticks (source does every tick but expensive; rate-limit)
    if (system.currentTick % 20 === 0) {
      // guard by config if exists (danger.disableBlockBreaking not yet registered — default to allowed)
      let blocked = false;
      try { blocked = config.get("danger.disableBlockBreaking") === true; } catch {}
      if (!blocked) scanAndBreakInFront(e);
    }

    // melee handled by BP components; creative-kill shortcut: if player in creative within 2.5 blocks, instant kill
    if (distance(e.location, player.location) < 2.6) {
      try {
        // Bedrock gameMode query: player.getGameMode() stable @2.6 — guard
        const gm = typeof player.getGameMode === "function" ? player.getGameMode() : undefined;
        if (gm === GameMode.Creative) {
          try { player.kill(); } catch { try { player.applyDamage(1000); } catch {} }
        }
      } catch {}
    }
  } else {
    // no target: still tick stuck logic reset
    state.stuckTicks = 0;
  }
}

function scanAndBreakInFront(e) {
  try {
    const yaw = e.getRotation ? e.getRotation().y : (e.getViewDirection ? Math.atan2(e.getViewDirection().z, e.getViewDirection().x) * 180 / Math.PI : 0);
    const rad = yaw * Math.PI / 180;
    const lookX = -Math.sin(rad);
    const lookZ = Math.cos(rad);
    const scanDist = 2;
    const extraWidth = 0.65;
    const perpX = -lookZ * extraWidth;
    const perpZ = lookX * extraWidth;
    const baseY = Math.floor(e.location.y);
    const topY = Math.ceil(baseY + 2 + 1); // bbHeight approx 25 but scan limited to +1 as per source, cap to +3 to keep cheap
    const centerX = e.location.x + lookX * scanDist;
    const centerZ = e.location.z + lookZ * scanDist;
    const minX = Math.floor(Math.min(centerX + perpX, centerX - perpX));
    const maxX = Math.ceil(Math.max(centerX + perpX, centerX - perpX));
    const minZ = Math.floor(Math.min(centerZ + perpZ, centerZ - perpZ));
    const maxZ = Math.ceil(Math.max(centerZ + perpZ, centerZ - perpZ));
    // clamp heights
    const minY = baseY;
    const maxY = Math.min(topY, baseY + 4);
    let broken = 0;
    for (let x = minX; x <= maxX && broken < 24; x++) {
      for (let y = minY; y <= maxY && broken < 24; y++) {
        for (let z = minZ; z <= maxZ && broken < 24; z++) {
          try {
            const block = e.dimension.getBlock({ x, y, z });
            if (!block) continue;
            const id = block.typeId;
            if (id === "minecraft:air" || UNBREAKABLE.has(id) || id.includes("light_block")) continue;
            // hardness check via isAir/hardness not exposed — skip bedrock-like via UNBREAKABLE set
            // also skip if collision empty — Bedrock not exposed, assume breakable if not air
            // preserve fluids -> keep water/lava? source replaces with fluid legacy; skip water/lava
            if (id.includes("water") || id.includes("lava")) continue;
            block.setType("minecraft:air");
            // particle event 2001 approx
            try { e.dimension.spawnParticle("minecraft:block_destruct", { x: x + 0.5, y: y + 0.5, z: z + 0.5 }); } catch {}
            broken++;
          } catch {}
        }
      }
    }
  } catch {}
}

function onTbeKillPlayer(player, tbeEntity) {
  try { tryPlaySoundAt(tbeEntity.dimension, player.location, "thebrokenscript:the_end_is_near", 2, 0.2); } catch {}
  // source RepTier GAIN_MEDIUM analogue → advancement approximation
  try { progression.award(player.id, "you_ve_brought_it_upon_yourself"); } catch {}
  try { tbeEntity.remove(); timers.delete(tbeEntity.id); extraState.delete(tbeEntity.id); } catch {}
  // queue 15 ticks then kick — Bedrock kick command needs operator
  system.runTimeout(() => {
    try {
      const safeName = player.name.replace(/"/g, '\\"');
      try {
        player.dimension.runCommand(`kick "${safeName}" §cThe Broken End has consumed you.`);
      } catch {
        try { player.onScreenDisplay.setTitle("§4THE END IS NEAR", { subtitle: "You were removed", fadeInDuration: 10, stayDuration: 60, fadeOutDuration: 20 }); } catch {}
      }
    } catch {}
    // 50% summon BAN (entity not yet ported until 05F/07 — ledgered skip)
    // try summon ban at tbe pos if available
    // try { spawnHelpers.trySummon(tbeEntity.dimension, "thebrokenscript:ban", tbeEntity.location); } catch {}
  }, 15);
}

// ── Stalk ────────────────────────────────────────────────────────────────────
function tickStalk(e) {
  let despawn = getNum(e, "despawn", STALK_LIFE);
  let spawnTimer = getNum(e, "spawn", STALK_SPAWN_DELAY);
  let enabled = getNum(e, "enabled", 0);
  let invisible = getNum(e, "invisible", 0);

  // init on first tick (spawn handling — daylight/rain packet approx)
  if (timers.get(e.id) === undefined) {
    despawn = STALK_LIFE; spawnTimer = STALK_SPAWN_DELAY; enabled = 0; invisible = 0;
    timers.set(e.id, { despawn, spawn: spawnTimer, enabled, invisible });
    // broadcast intro to players within 256 (source packet)
    try {
      const nearby = world.getAllPlayers().filter(p => p.dimension.id === e.dimension.id && distance(p.location, e.location) < 256);
      for (const p of nearby) { try { p.playSound("thebrokenscript:tbe_intro", { volume: 1, pitch: 1 }); } catch {} }
    } catch {}
    try { e.dimension.runCommand("gamerule dodaylightcycle false"); } catch {}
    try { e.dimension.runCommand("weather rain 6000"); } catch {}
    try { e.addEffect("invisibility", 200, { amplifier: 0, showParticles: false }); } catch {}
    // track invisible flag via periodic effect; actual invis var stays 0 until trigger
  }

  // spawnTimer path: invis + enabled triggers countdown to summon TBE
  if (enabled) {
    spawnTimer--;
    setNum(e, "spawn", spawnTimer);
    if (spawnTimer <= 0) {
      try { e.remove(); } catch {}
      try {
        const spawned = spawnHelpers.trySummon(e.dimension, "thebrokenscript:the_broken_end", e.location);
        if (spawned) spawnHelpers.applyRandomRotation(spawned);
      } catch {}
      timers.delete(e.id); extraState.delete(e.id);
      return;
    }
  }
  if (invisible) {
    // keep invis effect refreshed
    if (system.currentTick % 20 === 0) { try { e.addEffect("invisibility", 40, { amplifier: 0, showParticles: false }); } catch {} }
    // don't run gaze triggers while invisible — but keep despawn ticking
  } else {
    // look-at-closest behavior
    const player = entityFinder.closestPlayerInRange(world.getAllPlayers().filter(p => p.dimension.id === e.dimension.id), e.location, 150);
    if (player) {
      try { e.lookAt?.(player.location); } catch {}
      const dist30 = isWithin(e, player, 30);
      if (dist30) {
        try { effects.blindness(player, 1); } catch { try { player.addEffect("blindness", 21, { amplifier: 1, showParticles: false }); } catch {} }
        tryPlaySoundAt(e.dimension, e.location, "thebrokenscript:heartbeat", 10, 0);
        if (Math.random() < 0.2) {
          try { e.remove(); } catch {}
          timers.delete(e.id); extraState.delete(e.id);
          if (Math.random() < 0.7) setFakeTime(e.dimension, "midnight");
          return;
        } else {
          // become invisible + start spawn timer
          setNum(e, "invisible", 1);
          setNum(e, "enabled", 1);
          try { e.addEffect("invisibility", 600, { amplifier: 0, showParticles: false }); } catch {}
        }
      }
      // 192 gaze LOS trigger (hitbox-like: fov 14)
      const inGazeRange = isWithin(e, player, 192) && gaze.isLookingAtLocation(player, e.location, 14);
      if (inGazeRange && hasLineOfSightApprox(player, e)) {
        try { player.addEffect("blindness", 21, { amplifier: 1, showParticles: false }); } catch {}
        tryPlaySoundAt(e.dimension, e.location, "thebrokenscript:heartbeat", 10, 0);
        if (Math.random() < 0.7) {
          setNum(e, "invisible", 1);
          setNum(e, "enabled", 1);
          try { e.dimension.runCommand("stopsound @a"); } catch {}
          try { e.addEffect("invisibility", 600, { amplifier: 0, showParticles: false }); } catch {}
        } else {
          // discard + place physical_stacktrace block below (Chunk 08 block now available)
          try {
            const below = e.dimension.getBlock({ x: Math.floor(e.location.x), y: Math.floor(e.location.y) - 1, z: Math.floor(e.location.z) });
            if (below && below.typeId === "minecraft:air") below.setType("thebrokenscript:physical_stacktrace");
          } catch {}
          try { e.remove(); } catch {}
          timers.delete(e.id); extraState.delete(e.id);
          return;
        }
      }
    }
  }

  // despawn countdown 7200 -> remove + restore daylight
  despawn--; setNum(e, "despawn", despawn);
  if (despawn <= 0) {
    try { e.remove(); } catch {}
    timers.delete(e.id); extraState.delete(e.id);
    try { e.dimension.runCommand("gamerule dodaylightcycle true"); } catch {}
  }
}

// ── Curious (weeping-angel) ─────────────────────────────────────────────────
function tickCurious(e) {
  let life = getNum(e, "life", CURIOUS_LIFE);
  let noticed = getNum(e, "noticed", 0);
  if (timers.get(e.id) === undefined) {
    timers.set(e.id, { life: CURIOUS_LIFE, noticed: 0 });
    life = CURIOUS_LIFE; noticed = 0;
  }
  life--; setNum(e, "life", life);
  if (life <= 0) { try { e.remove(); } catch {} timers.delete(e.id); return; }

  const player = entityFinder.closestPlayerInRange(world.getAllPlayers().filter(p => p.dimension.id === e.dimension.id), e.location, 512);
  if (!player) return;

  const inRange = isWithin(e, player, 40);
  const inFov = (() => {
    try {
      const view = player.getViewDirection();
      const to = { x: e.location.x - player.location.x, y: (e.location.y + 1.2) - (player.location.y + 1.62), z: e.location.z - player.location.z };
      const len = Math.hypot(to.x, to.y, to.z) || 1;
      const n = { x: to.x / len, y: to.y / len, z: to.z / len };
      const dot = view.x * n.x + view.y * n.y + view.z * n.z;
      const fov = 70 * Math.PI / 180;
      return dot >= Math.cos(fov / 2);
    } catch { return false; }
  })();
  const lookingAt = gaze.isLookingAtLocation(player, e.location, 14);
  const hasLOS = hasLineOfSightApprox(player, e);
  const isSeen = inRange || (hasLOS && (inFov || lookingAt));

  if (!isSeen) {
    if (system.currentTick % 60 === 0) {
      // gentle teleport toward player (weeping angel moves only when not seen)
      const dx = player.location.x - e.location.x;
      const dz = player.location.z - e.location.z;
      const len = Math.hypot(dx, dz) || 1;
      const step = 1.0;
      const dest = { x: e.location.x + (dx / len) * step, y: e.location.y, z: e.location.z + (dz / len) * step };
      try { e.teleport(dest); } catch {}
    }
  } else {
    // freeze — stop navigation (teleport hold = no movement)
  }

  if (isSeen && noticed < 45) {
    noticed++; setNum(e, "noticed", noticed);
  } else if (!isSeen) {
    if (noticed >= 1 && noticed < 45) { noticed = 0; setNum(e, "noticed", 0); }
  }
  if (noticed >= 45) {
    if (noticed === 45) {
      tryPlaySoundAt(e.dimension, e.location, "thebrokenscript:tbespawn1", 10, 1);
    }
    noticed++; setNum(e, "noticed", noticed);
  }
  if (noticed >= 60) {
    try { e.remove(); } catch {}
    timers.delete(e.id);
    try { player.addEffect("blindness", 45, { amplifier: 1, showParticles: false }); } catch {}
    try { player.onScreenDisplay.setTitle("§k▓▓▓ §r tbe_curious §k▓▓▓", { fadeInDuration: 0, stayDuration: 25, fadeOutDuration: 10 }); } catch {}
    // look-at eyes approx: force player rotation via teleport with same pos + facing entity
    try {
      const dx = e.location.x - player.location.x;
      const dy = (e.location.y + 17) - (player.location.y + 1.62);
      const dz = e.location.z - player.location.z;
      const yaw = Math.atan2(-dx, dz) * 180 / Math.PI;
      const dist = Math.hypot(dx, dz);
      const pitch = -Math.atan2(dy, dist) * 180 / Math.PI;
      player.teleport(player.location, { rotation: { x: pitch, y: yaw } });
    } catch {}
    if (isWithin(e, player, 50) && Math.random() < 0.01) {
      try {
        const spawned = spawnHelpers.trySummon(e.dimension, "thebrokenscript:the_broken_end", e.location);
        if (spawned) spawnHelpers.applyRandomRotation(spawned);
      } catch {}
    }
  }
}

// ── Ambush ───────────────────────────────────────────────────────────────────
function tickAmbush(e) {
  let aliveTicks = getNum(e, "alive", 0);
  let despawnTimer = getNum(e, "despawnTimer", 0);
  let despawning = getNum(e, "despawning", 0);
  let spawnTBE = getNum(e, "spawnTBE", 1);
  let lifetime = getNum(e, "lifetime", 0);

  if (timers.get(e.id) === undefined) {
    // random lifetime 18000-24000
    lifetime = 18000 + Math.floor(Math.random() * 6001);
    // weighted variant 1/1/2/3 -> custom name for RP nameplate
    const pool = [1, 1, 2, 3];
    const variant = pool[Math.floor(Math.random() * pool.length)];
    const nameMap = { 1: "Not_It_Cal", 2: "uImmortal_", 3: "99_thatOneteChFella_99" };
    const cname = nameMap[variant] ?? "???";
    try { e.nameTag = cname; } catch {}
    try { e.setDynamicProperty("tbe:variant", variant); } catch {}
    timers.set(e.id, { alive: 0, despawnTimer: 0, despawning: 0, spawnTBE: 1, lifetime, variant });
    aliveTicks = 0; despawnTimer = 0; despawning = 0; spawnTBE = 1;
    // ensure look-at behaviour not needed script-side — native look_at handled by behavior
  }

  if (despawning) {
    despawnTimer++; setNum(e, "despawnTimer", despawnTimer);
    if (despawnTimer >= AMBUSH_DESPAWN_TICKS) {
      if (spawnTBE) {
        const player = entityFinder.closestPlayerInRange(world.getAllPlayers().filter(p => p.dimension.id === e.dimension.id), e.location, 512);
        if (player) {
          const dist = 15 + Math.random() * 15;
          const look = player.getViewDirection();
          const targetX = player.location.x - look.x * dist;
          const targetZ = player.location.z - look.z * dist;
          // surface Y via topmost if available else player Y
          let y = player.location.y;
          try {
            const top = e.dimension.getTopmostBlock?.({ x: targetX, z: targetZ });
            if (top && top.y !== undefined) y = top.y;
            else if (top && top.location) y = top.location.y;
          } catch {}
          try {
            const pos = { x: targetX, y: y, z: targetZ };
            const spawned = spawnHelpers.trySummon(e.dimension, "thebrokenscript:the_broken_end", pos);
            if (spawned) spawnHelpers.applyRandomRotation(spawned);
          } catch {}
        }
      }
      try { e.remove(); } catch {}
      timers.delete(e.id);
    }
    return;
  }

  aliveTicks++; setNum(e, "alive", aliveTicks);
  if (aliveTicks >= lifetime) {
    setNum(e, "spawnTBE", 0);
    setNum(e, "despawning", 1);
    return;
  }

  const near = entityFinder.closestPlayerInRange(world.getAllPlayers().filter(p => p.dimension.id === e.dimension.id), e.location, 15);
  if (near) {
    setNum(e, "despawning", 1);
    tryPlaySoundAt(e.dimension, e.location, "thebrokenscript:reel", 1, 1);
  }
}
