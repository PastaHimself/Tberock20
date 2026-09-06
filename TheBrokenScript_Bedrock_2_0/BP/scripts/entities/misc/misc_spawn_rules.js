import { world } from "@minecraft/server";
import * as spawnDirector from "../../systems/spawn_director.js";
import * as worldState from "../../systems/world_state.js";
import { config } from "../../core/config.js";
import { eventFrequency } from "../../systems/event_frequency.js";
import * as bossHooks from "../../systems/boss_hooks.js";

// ── condition constants (NIW/EERIE/CHUNK/CORRUPTION/DEFAULT/ENTITY) ──────────
const NIW_CHANCE = 0.0001;           // NIWConditions.spawnChance
const EERIE_CHANCE = 0.0015;         // EerieConditions + freq, day only, delay 3200
const CHUNK_CHANCE = 0.0001;         // ChunkRemoverConditions
const CORRUPTION_CHANCE = 0.001;     // CorruptionConditions
const DEFAULT_CHANCE = 0.0045;       // TBSDefaultConditions + freq

function getMoonPhase() {
  try {
    const mp = world.getMoonPhase?.();
    if (typeof mp === "number") return ((mp % 8) + 8) % 8;
  } catch {}
  try {
    const day = world.getDay?.() ?? Math.floor(world.getTimeOfDay() / 24000);
    return ((day % 8) + 8) % 8;
  } catch {}
  return 0;
}

function isNight() {
  try {
    const t = world.getTimeOfDay();
    return t >= 13000 && t < 23000;
  } catch { return false; }
}

function baseGates(ctx) {
  const player = ctx.players[0];
  if (!player) return null;
  if (player.dimension.id !== "minecraft:overworld") return null;
  if (!worldState.get("isNullHere")) return null;
  if (bossHooks.isArenaPhase1()) return null;
  return player;
}

function pickCandidateNearPlayer(player, minDist, maxDist) {
  const angle = Math.random() * Math.PI * 2;
  const r = minDist + Math.random() * (maxDist - minDist);
  const x = player.location.x + Math.cos(angle) * r;
  const z = player.location.z + Math.sin(angle) * r;
  let y = player.location.y;
  try {
    const top = player.dimension.getTopmostBlock?.({ x, z });
    if (top) {
      if (typeof top.y === "number") y = top.y;
      else if (top.location && typeof top.location.y === "number") y = top.location.y;
    }
  } catch {}
  return { x, y, z };
}

function summonAt(dim, typeId, loc) {
  try { return dim.spawnEntity(typeId, loc); } catch { return undefined; }
}

export function register() {
  // nothingiswatching — NIWConditions: 1e-4, exclusion 480 among niw/chase
  spawnDirector.registerRule({
    id: "niw",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      const player = baseGates(ctx);
      if (!player) return false;
      if (Math.random() > NIW_CHANCE) return false;
      const loc = pickCandidateNearPlayer(player, 32, 72);
      let near = [];
      try { near = player.dimension.getEntities({ location: loc, maxDistance: 480 }); } catch {}
      if (near.some(x => x.typeId === "thebrokenscript:niw" || x.typeId === "thebrokenscript:nothingiswatchingchase")) return false;
      return summonAt(player.dimension, "thebrokenscript:niw", loc) !== undefined;
    }
  });

  // eerie_noise — EerieConditions: 0.0015+freq, NOT night, eerieNoiseDelay 3200
  spawnDirector.registerRule({
    id: "eerie_noise",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      const player = baseGates(ctx);
      if (!player) return false;
      if (worldState.get("eerieNoiseDelay") > 0) return false;
      if (isNight()) return false;
      if (Math.random() > EERIE_CHANCE + eventFrequency(ctx.gameTime ?? 0)) return false;
      const loc = pickCandidateNearPlayer(player, 24, 64);
      const e = summonAt(player.dimension, "thebrokenscript:eerie_noise", loc);
      if (!e) return false;
      // onFinalizeSpawn: broadcast ambient cave range 555 vol 45 rand pitch then self-cancel
      tryPlayAmbientCave(player.dimension, loc);
      worldState.set("eerieNoiseDelay", 3200);
      try { e.remove(); } catch {}
      return true;
    }
  });

  // chunk_remover — ChunkRemoverConditions: 1e-4
  spawnDirector.registerRule({
    id: "chunk_remover",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      const player = baseGates(ctx);
      if (!player) return false;
      if (Math.random() > CHUNK_CHANCE) return false;
      const loc = pickCandidateNearPlayer(player, 48, 96);
      const e = summonAt(player.dimension, "thebrokenscript:chunk_remover", loc);
      if (!e) return false;
      // Bedrock scripts cannot clear/move chunks — sound beat only, manipulation ledgered (A-series)
      tryPlayAmbientCave(player.dimension, loc);
      try { e.remove(); } catch {}
      return true;
    }
  });

  // corruption — CorruptionConditions: 0.001
  spawnDirector.registerRule({
    id: "corruption",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      const player = baseGates(ctx);
      if (!player) return false;
      if (Math.random() > CORRUPTION_CHANCE) return false;
      const loc = pickCandidateNearPlayer(player, 32, 80);
      const e = summonAt(player.dimension, "thebrokenscript:corruption", loc);
      if (!e) return false;
      applyCorruption(e);
      try { e.remove(); } catch {}
      return true;
    }
  });

  // xxram_2die + phantom_player — DEFAULT conditions: 0.0045+freq
  spawnDirector.registerRule({
    id: "default_misc",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      const player = baseGates(ctx);
      if (!player) return false;
      if (Math.random() > DEFAULT_CHANCE + eventFrequency(ctx.gameTime ?? 0)) return false;
      const loc = pickCandidateNearPlayer(player, 28, 64);
      const roll = Math.random();
      const typeId = roll < 0.5 ? "thebrokenscript:xxram_2die" : "thebrokenscript:phantom_player";
      return summonAt(player.dimension, typeId, loc) !== undefined;
    }
  });
}

function tryPlayAmbientCave(dim, loc) {
  try { dim.playSound("ambient.cave", loc, { volume: 45, pitch: Math.random() }); return; } catch {}
  for (const p of world.getAllPlayers()) {
    try { p.playSound("ambient.cave", { volume: 10, pitch: Math.random() }); } catch {}
  }
}

// CorruptionEntity.onFinalizeSpawn port: void column below self + redstone torches at neighbors
function applyCorruption(e) {
  const dim = e.dimension;
  const bx = Math.floor(e.location.x);
  const by = Math.floor(e.location.y);
  const bz = Math.floor(e.location.z);
  // clear the column below (bounded to 48 blocks down to keep cost sane)
  let cleared = 0;
  for (let y = by; y >= Math.max(by - 48, -64) && cleared < 64; y--) {
    try {
      const b = dim.getBlock({ x: bx, y, z: bz });
      if (b && b.typeId !== "minecraft:air" && b.typeId !== "minecraft:bedrock") {
        b.setType("minecraft:air");
        cleared++;
      }
    } catch { break; }
  }
  // torches at the 4 neighbor columns' surface when height delta in (-2, 4)
  for (const [dx, dz] of [[1, 0], [-1, 0], [0, 1], [0, -1]]) {
    try {
      let sy = by + 6;
      let found = -1;
      while (sy > by - 12) {
        const b = dim.getBlock({ x: bx + dx, y: sy, z: bz + dz });
        const above = dim.getBlock({ x: bx + dx, y: sy + 1, z: bz + dz });
        if (b && b.typeId !== "minecraft:air" && above && above.typeId === "minecraft:air") { found = sy + 1; break; }
        sy--;
      }
      if (found >= 0) {
        const delta = found - by;
        if (delta < 4 && delta > -2) {
          const t = dim.getBlock({ x: bx + dx, y: found, z: bz + dz });
          if (t && t.typeId === "minecraft:air") t.setType("minecraft:redstone_torch");
        }
      }
    } catch {}
  }
}
