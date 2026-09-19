import * as operationDiagnostics from "../../core/operation_diagnostics.js";
import { world } from "@minecraft/server";
import * as spawnDirector from "../../systems/spawn_director.js";
import * as worldState from "../../systems/world_state.js";
import { config } from "../../core/config.js";
import { eventFrequency } from "../../systems/event_frequency.js";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as modifiedChunks from "../../systems/modified_chunks.js";
import * as chunkRemoverRuntime from "../../systems/chunk_remover_runtime.js";
import { chunkCoordinate, chunkSpawnDecision } from "../../systems/chunk_remover_model.js";

// ── condition constants (NIW/EERIE/CHUNK/CORRUPTION/DEFAULT/ENTITY) ──────────
const NIW_CHANCE = 0.0001;           // NIWConditions.spawnChance
const EERIE_CHANCE = 0.0015;         // EerieConditions + freq, day only, delay 3200
const CORRUPTION_CHANCE = 0.001;     // CorruptionConditions
const DEFAULT_CHANCE = 0.0045;       // TBSDefaultConditions + freq

function getMoonPhase() {
  try {
    const mp = world.getMoonPhase?.();
    if (typeof mp === "number") return ((mp % 8) + 8) % 8;
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.21", "best-effort Bedrock API fallback", error);}
  try {
    const day = world.getDay?.() ?? Math.floor(world.getTimeOfDay() / 24000);
    return ((day % 8) + 8) % 8;
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.25", "best-effort Bedrock API fallback", error);}
  return 0;
}

function isNight() {
  try {
    const t = world.getTimeOfDay();
    // audit: Bedrock time-of-day adapter for the Java daytime range.
    return t >= 13000 && t < 23000;
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.34", "best-effort Bedrock API fallback", error); return false; }
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
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.58", "best-effort Bedrock API fallback", error);}
  return { x, y, z };
}

function pickChunkCandidateNearPlayer(player, minDist, maxDist) {
  const location = pickCandidateNearPlayer(player, minDist, maxDist);
  // ChunkRemoverConditions uses Heightmap.MOTION_BLOCKING_NO_LEAVES for the
  // spawn position, which is the first air block above the surface. The
  // stable Bedrock getTopmostBlock equivalent returns the surface block.
  try {
    const top = player.dimension.getTopmostBlock?.({ x: location.x, z: location.z });
    const surfaceY = typeof top?.y === "number"
      ? top.y
      : (typeof top?.location?.y === "number" ? top.location.y : undefined);
    if (typeof surfaceY === "number") location.y = surfaceY + 1;
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.73", "best-effort Bedrock API fallback", error);}
  return location;
}

function summonAt(dim, typeId, loc) {
  try { return dim.spawnEntity(typeId, loc); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.78", "best-effort Bedrock API fallback", error); return undefined; }
}

function difficultyIsPeaceful() {
  try { return String(world.getDifficulty()).toLowerCase() === "peaceful"; } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.82", "best-effort Bedrock API fallback", error); return true; }
}

function belowBlockIsValid(dim, location) {
  try {
    const block = dim.getBlock({ x: Math.floor(location.x), y: Math.floor(location.y) - 1, z: Math.floor(location.z) });
    return Boolean(block && block.isAir !== true && block.typeId !== "minecraft:air");
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.89", "best-effort Bedrock API fallback", error); return false; }
}

function nearestPlayerDistance(players, dimension, location) {
  let nearest = Number.POSITIVE_INFINITY;
  for (const player of players) {
    if (!player || player.dimension?.id !== dimension?.id) continue;
    const dx = player.location.x - location.x;
    const dy = player.location.y - location.y;
    const dz = player.location.z - location.z;
    nearest = Math.min(nearest, Math.hypot(dx, dy, dz));
  }
  return Number.isFinite(nearest) ? nearest : null;
}

function skyVisibleFromBelowWater(dim, location) {
  try {
    return dim.getSkyLightLevel({ x: Math.floor(location.x), y: Math.floor(location.y), z: Math.floor(location.z) }) >= 15;
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.107", "best-effort Bedrock API fallback", error); return false; }
}

function totalLightAt(dim, location) {
  try {
    const value = dim.getLightLevel?.({ x: Math.floor(location.x), y: Math.floor(location.y), z: Math.floor(location.z) });
    return typeof value === "number" ? value : undefined;
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.114", "best-effort Bedrock API fallback", error); return undefined; }
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
      try { near = player.dimension.getEntities({ location: loc, maxDistance: 480 }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.128", "best-effort Bedrock API fallback", error);}
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
      try { e.remove(); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.150", "best-effort Bedrock API fallback", error);}
      return true;
    }
  });

  // chunk_remover — ChunkRemoverConditions: 1e-4
  spawnDirector.registerRule({
    id: "chunk_remover",
    predicate: (ctx) => {
      const player = baseGates(ctx);
      if (!player) return false;
      const loc = pickChunkCandidateNearPlayer(player, 48, 96);
      const flat = Boolean(worldState.get("isFlat"));
      const spawnRoll = Math.random();
      const flatRoll = flat ? Math.random() : undefined;
      const decision = chunkSpawnDecision({
        difficultyPeaceful: difficultyIsPeaceful(),
        spawnReason: "natural",
        belowBlockValid: belowBlockIsValid(player.dimension, loc),
        doMobSpawning: Boolean(world.gameRules?.doMobSpawning),
        isNullHere: Boolean(worldState.get("isNullHere")),
        disableSpawningEntities: config.get("danger.disableSpawningEntities"),
        dimensionId: player.dimension.id,
        disableChunkRemoval: config.get("world.disableChunkRemoval"),
        spawnRoll,
        nearestPlayerDistance: nearestPlayerDistance(ctx.players, player.dimension, loc),
        canSeeSkyFromBelowWater: skyVisibleFromBelowWater(player.dimension, loc),
        arenaPhase: bossHooks.isArenaPhase1() ? "phase1" : "other",
        flat,
        flatRoll,
        // Bedrock's stable getLightLevel is total brightness (sky + block),
        // not Java LightLayer.BLOCK. Passing it through is conservative: a
        // bright sky location is rejected, preventing a false-positive chunk
        // removal when the source would have seen block light zero.
        blockLight: totalLightAt(player.dimension, loc),
        modifiedChunkCount: modifiedChunks.countModifiedChunk(
          player.dimension.id,
          chunkCoordinate(loc.x),
          chunkCoordinate(loc.z),
        ),
      });
      if (!decision.allowed) return false;
      const e = summonAt(player.dimension, "thebrokenscript:chunk_remover", loc);
      if (!e) return false;
      chunkRemoverRuntime.handleChunkRemoverEntity(e);
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
      try { e.remove(); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.211", "best-effort Bedrock API fallback", error);}
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
  try { dim.playSound("ambient.cave", loc, { volume: 45, pitch: Math.random() }); return; } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.233", "best-effort Bedrock API fallback", error);}
  for (const p of world.getAllPlayers()) {
    try { p.playSound("ambient.cave", { volume: 10, pitch: Math.random() }); } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.235", "best-effort Bedrock API fallback", error);}
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
    } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.254", "best-effort Bedrock API fallback", error); break; }
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
    } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.misc.misc_spawn_rules.js.274", "best-effort Bedrock API fallback", error);}
  }
}
