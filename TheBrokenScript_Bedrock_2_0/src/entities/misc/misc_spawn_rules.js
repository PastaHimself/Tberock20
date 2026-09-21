import * as operationDiagnostics from "../../core/operation_diagnostics.js";
import { world } from "@minecraft/server";
import * as spawnDirector from "../../systems/spawn_director.js";
import * as worldState from "../../systems/world_state.js";
import { config } from "../../core/config.js";
import { eventFrequency } from "../../systems/event_frequency.js";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as spawnHelpers from "../../systems/ai/spawn_helpers.js";
import * as modifiedChunks from "../../systems/modified_chunks.js";
import * as chunkRemoverRuntime from "../../systems/chunk_remover_runtime.js";
import { chunkCoordinate, chunkSpawnDecision } from "../../systems/chunk_remover_model.js";

const NIW_CHANCE = 0.0001;
const EERIE_CHANCE = 0.0015;
const CORRUPTION_CHANCE = 0.001;
const DEFAULT_PHANTOM_CHANCE = 0.0045;
const NAME_TAG_CHANCE = 0.0005;

function difficultyIsPeaceful() {
  try {
    return String(world.getDifficulty()).toLowerCase() === "peaceful";
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.misc.misc_spawn_rules.js.difficulty",
      "best-effort Bedrock API fallback",
      error,
    );
    return true;
  }
}

function isNight() {
  try {
    const time = world.getTimeOfDay();
    return time >= 13000 && time < 23000;
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.misc.misc_spawn_rules.js.time",
      "best-effort Bedrock API fallback",
      error,
    );
    return false;
  }
}

function overworldSourceGates({ requireDangerConfig = true } = {}) {
  if (difficultyIsPeaceful()) return false;
  if (world.gameRules?.doMobSpawning !== true) return false;
  if (!worldState.get("isNullHere")) return false;
  if (requireDangerConfig && config.get("danger.disableSpawningEntities")) return false;
  return true;
}

function pickSurfaceCandidate(player, minDist, maxDist) {
  const angle = Math.random() * Math.PI * 2;
  const radius = minDist + Math.random() * (maxDist - minDist);
  const x = Math.floor(player.location.x + Math.cos(angle) * radius);
  const z = Math.floor(player.location.z + Math.sin(angle) * radius);
  try {
    const top = player.dimension.getTopmostBlock?.({ x, z });
    const surfaceY = typeof top?.y === "number"
      ? top.y
      : (typeof top?.location?.y === "number" ? top.location.y : undefined);
    if (typeof surfaceY !== "number") return undefined;
    return { x: x + 0.5, y: surfaceY + 1, z: z + 0.5 };
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.misc.misc_spawn_rules.js.surface_candidate",
      "best-effort Bedrock API fallback",
      error,
    );
    return undefined;
  }
}

function pickCaveCandidate(player, minDist, maxDist) {
  const angle = Math.random() * Math.PI * 2;
  const radius = minDist + Math.random() * (maxDist - minDist);
  const x = Math.floor(player.location.x + Math.cos(angle) * radius);
  const z = Math.floor(player.location.z + Math.sin(angle) * radius);
  const centerY = Math.floor(player.location.y);

  for (let offset = 6; offset >= -18; offset--) {
    const y = centerY + offset;
    try {
      const below = player.dimension.getBlock({ x, y: y - 1, z });
      const at = player.dimension.getBlock({ x, y, z });
      const above = player.dimension.getBlock({ x, y: y + 1, z });
      if (!below || !at || !above) continue;
      if (below.isAir === true || below.typeId === "minecraft:air") continue;
      if (at.isAir !== true && at.typeId !== "minecraft:air") continue;
      if (above.isAir !== true && above.typeId !== "minecraft:air") continue;
      return { x: x + 0.5, y, z: z + 0.5 };
    } catch (error) {
      operationDiagnostics.warnOnce(
        "audit.BP.scripts.entities.misc.misc_spawn_rules.js.cave_candidate",
        "best-effort Bedrock API fallback",
        error,
      );
      return undefined;
    }
  }
  return undefined;
}

function pickChunkCandidateNearPlayer(player, minDist, maxDist) {
  return pickSurfaceCandidate(player, minDist, maxDist);
}

function countType(dimension, typeId) {
  try {
    return dimension.getEntities({ type: typeId }).length;
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.misc.misc_spawn_rules.js.count." + typeId,
      "best-effort Bedrock API fallback",
      error,
    );
    return Number.POSITIVE_INFINITY;
  }
}

function summonAt(dimension, typeId, location) {
  return spawnHelpers.trySummon(dimension, typeId, location);
}

function belowBlockIsValid(dimension, location) {
  try {
    const block = dimension.getBlock({
      x: Math.floor(location.x),
      y: Math.floor(location.y) - 1,
      z: Math.floor(location.z),
    });
    return Boolean(block && block.isAir !== true && block.typeId !== "minecraft:air");
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.misc.misc_spawn_rules.js.below_block",
      "best-effort Bedrock API fallback",
      error,
    );
    return false;
  }
}

function nearestPlayerDistance(players, dimension, location) {
  let nearest = Number.POSITIVE_INFINITY;
  for (const player of players) {
    if (!player || player.dimension?.id !== dimension?.id) continue;
    nearest = Math.min(
      nearest,
      Math.hypot(
        player.location.x - location.x,
        player.location.y - location.y,
        player.location.z - location.z,
      ),
    );
  }
  return Number.isFinite(nearest) ? nearest : null;
}

function hasPlayerWithSkyLight(players, dimension, location, maxDistance, minimumSky) {
  for (const player of players) {
    if (!player || player.dimension?.id !== dimension.id) continue;
    if (
      Math.hypot(
        player.location.x - location.x,
        player.location.y - location.y,
        player.location.z - location.z,
      ) > maxDistance
    ) continue;
    try {
      const sky = dimension.getSkyLightLevel?.({
        x: Math.floor(player.location.x),
        y: Math.floor(player.location.y),
        z: Math.floor(player.location.z),
      });
      if (typeof sky === "number" && sky >= minimumSky) return true;
    } catch (error) {
      operationDiagnostics.warnOnce(
        "audit.BP.scripts.entities.misc.misc_spawn_rules.js.player_sky",
        "best-effort Bedrock API fallback",
        error,
      );
    }
  }
  return false;
}

function skyLightAt(dimension, location) {
  try {
    const value = dimension.getSkyLightLevel?.({
      x: Math.floor(location.x),
      y: Math.floor(location.y),
      z: Math.floor(location.z),
    });
    return typeof value === "number" ? value : undefined;
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.misc.misc_spawn_rules.js.sky_light",
      "best-effort Bedrock API fallback",
      error,
    );
    return undefined;
  }
}

function skyVisibleFromBelowWater(dimension, location) {
  const value = skyLightAt(dimension, location);
  return typeof value === "number" && value >= 15;
}

function totalLightAt(dimension, location) {
  try {
    const value = dimension.getLightLevel?.({
      x: Math.floor(location.x),
      y: Math.floor(location.y),
      z: Math.floor(location.z),
    });
    return typeof value === "number" ? value : undefined;
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.misc.misc_spawn_rules.js.total_light",
      "best-effort Bedrock API fallback",
      error,
    );
    return undefined;
  }
}

function hasBedrockNearMazeShadow(dimension, location) {
  const px = Math.floor(location.x);
  const py = Math.floor(location.y);
  const pz = Math.floor(location.z);
  try {
    // Java: new AABB(pos).inflate(5).move(-3,-3,-3).
    for (let dx = -8; dx <= 3; dx++) {
      for (let dy = -8; dy <= 3; dy++) {
        for (let dz = -8; dz <= 3; dz++) {
          if (
            dimension.getBlock({ x: px + dx, y: py + dy, z: pz + dz })?.typeId ===
            "minecraft:bedrock"
          ) return true;
        }
      }
    }
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.misc.misc_spawn_rules.js.maze_bedrock",
      "best-effort Bedrock API fallback",
      error,
    );
  }
  return false;
}

export function register() {
  spawnDirector.registerRule({
    id: "niw",
    predicate: (ctx) => {
      const player = ctx.players[0];
      if (!player || !overworldSourceGates()) return false;
      const dimension = player.dimension;
      if (dimension.id !== "minecraft:overworld") return false;

      const location = pickSurfaceCandidate(player, 32, 72);
      if (!location || !skyVisibleFromBelowWater(dimension, location)) return false;
      if (countType(dimension, "thebrokenscript:niw") > 0) return false;
      if (
        entityFinder.hasEntitiesInRange(
          dimension,
          location,
          480,
          ["thebrokenscript:siluet", "thebrokenscript:siluet_stare"],
        )
      ) return false;
      if (bossHooks.isArenaPhase1()) return false;
      if (worldState.get("isFlat") && Math.random() > 0.001) return false;
      if (Math.random() > NIW_CHANCE) return false;
      if (worldState.get("moonStage") === 0) return false;
      if (!hasPlayerWithSkyLight(ctx.players, dimension, location, 256, 2)) return false;

      return summonAt(dimension, "thebrokenscript:niw", location) !== undefined;
    },
  });

  spawnDirector.registerRule({
    id: "eerie_noise",
    predicate: (ctx) => {
      const player = ctx.players[0];
      if (!player || !overworldSourceGates()) return false;
      const dimension = player.dimension;
      if (dimension.id !== "minecraft:overworld") return false;

      const location = pickSurfaceCandidate(player, 24, 64);
      if (!location || !skyVisibleFromBelowWater(dimension, location)) return false;
      if (bossHooks.isArenaPhase1()) return false;
      if (worldState.get("isFlat") && Math.random() > 0.001) return false;
      if (Math.random() > EERIE_CHANCE + eventFrequency(ctx.gameTime ?? 0)) return false;
      if (isNight()) return false;
      if (worldState.get("eerieNoiseDelay") > 0) return false;

      const entity = summonAt(dimension, "thebrokenscript:eerie_noise", location);
      if (!entity) return false;
      tryPlayAmbientCave(dimension, location);
      worldState.set("eerieNoiseDelay", 3200);
      try {
        entity.remove();
      } catch (error) {
        operationDiagnostics.warnOnce(
          "audit.BP.scripts.entities.misc.misc_spawn_rules.js.eerie_remove",
          "best-effort Bedrock API fallback",
          error,
        );
      }
      return true;
    },
  });

  spawnDirector.registerRule({
    id: "chunk_remover",
    predicate: (ctx) => {
      const player = ctx.players[0];
      if (!player) return false;
      const location = pickChunkCandidateNearPlayer(player, 48, 96);
      if (!location) return false;
      const flat = Boolean(worldState.get("isFlat"));
      const decision = chunkSpawnDecision({
        difficultyPeaceful: difficultyIsPeaceful(),
        spawnReason: "natural",
        belowBlockValid: belowBlockIsValid(player.dimension, location),
        doMobSpawning: Boolean(world.gameRules?.doMobSpawning),
        isNullHere: Boolean(worldState.get("isNullHere")),
        disableSpawningEntities: config.get("danger.disableSpawningEntities"),
        dimensionId: player.dimension.id,
        disableChunkRemoval: config.get("world.disableChunkRemoval"),
        spawnRoll: Math.random(),
        nearestPlayerDistance: nearestPlayerDistance(ctx.players, player.dimension, location),
        canSeeSkyFromBelowWater: skyVisibleFromBelowWater(player.dimension, location),
        arenaPhase: bossHooks.isArenaPhase1() ? "phase1" : "other",
        flat,
        flatRoll: flat ? Math.random() : undefined,
        blockLight: totalLightAt(player.dimension, location),
        modifiedChunkCount: modifiedChunks.countModifiedChunk(
          player.dimension.id,
          chunkCoordinate(location.x),
          chunkCoordinate(location.z),
        ),
      });
      if (!decision.allowed) return false;
      const entity = summonAt(player.dimension, "thebrokenscript:chunk_remover", location);
      if (!entity) return false;
      chunkRemoverRuntime.handleChunkRemoverEntity(entity);
      return true;
    },
  });

  spawnDirector.registerRule({
    id: "corruption",
    predicate: (ctx) => {
      const player = ctx.players[0];
      if (!player || !overworldSourceGates({ requireDangerConfig: false })) return false;
      const dimension = player.dimension;
      if (dimension.id !== "minecraft:overworld") return false;
      if (config.get("world.disableVoidHoles")) return false;

      const location = pickSurfaceCandidate(player, 32, 80);
      if (!location || !skyVisibleFromBelowWater(dimension, location)) return false;
      if (bossHooks.isArenaPhase1()) return false;
      if (!isNight()) return false;
      if (worldState.get("isFlat") && Math.random() > 0.001) return false;
      if (Math.random() > CORRUPTION_CHANCE) return false;

      const entity = summonAt(dimension, "thebrokenscript:corruption", location);
      if (!entity) return false;
      applyCorruption(entity);
      try {
        entity.remove();
      } catch (error) {
        operationDiagnostics.warnOnce(
          "audit.BP.scripts.entities.misc.misc_spawn_rules.js.corruption_remove",
          "best-effort Bedrock API fallback",
          error,
        );
      }
      return true;
    },
  });

  spawnDirector.registerRule({
    id: "default_misc",
    predicate: (ctx) => {
      const player = ctx.players[0];
      if (!player || !overworldSourceGates()) return false;
      const dimension = player.dimension;
      if (dimension.id !== "minecraft:overworld") return false;

      const location = pickSurfaceCandidate(player, 28, 64);
      if (!location || !skyVisibleFromBelowWater(dimension, location)) return false;
      const light = totalLightAt(dimension, location);
      if (typeof light === "number" && light > 7) return false;
      if (bossHooks.isArenaPhase1()) return false;
      if (worldState.get("isFlat") && Math.random() > 0.001) return false;

      const typeId =
        Math.random() < 0.5
          ? "thebrokenscript:xxram_2die"
          : "thebrokenscript:phantom_player";

      if (typeId === "thebrokenscript:xxram_2die") {
        if (worldState.get("hasRam2DieJoined")) return false;
        if (!worldState.get("hasTriggeredRam2Die")) return false;
      } else {
        if (Math.random() > DEFAULT_PHANTOM_CHANCE + eventFrequency(ctx.gameTime ?? 0)) return false;
        if (countType(dimension, "thebrokenscript:phantom_player") > 0) return false;
        if (countType(dimension, "thebrokenscript:hetzer") > 0) return false;
      }

      return summonAt(dimension, typeId, location) !== undefined;
    },
  });

  spawnDirector.registerRule({
    id: "name_tag",
    predicate: (ctx) => {
      const player = ctx.players[0];
      if (!player || !overworldSourceGates()) return false;
      const dimension = player.dimension;
      if (dimension.id !== "minecraft:overworld") return false;
      if (bossHooks.isArenaPhase1()) return false;
      if (worldState.get("isFlat") && Math.random() > 0.001) return false;

      const location = pickCaveCandidate(player, 24, 72);
      if (!location) return false;
      const sky = skyLightAt(dimension, location);
      if (sky !== 0) return false;
      if (skyVisibleFromBelowWater(dimension, { ...location, y: location.y + 1 })) return false;
      const light = totalLightAt(dimension, location);
      if (typeof light === "number" && light > 7) return false;
      if (nearestPlayerDistance(ctx.players, dimension, location) > 512) return false;
      if (Math.random() > NAME_TAG_CHANCE + eventFrequency(ctx.gameTime ?? 0)) return false;

      return summonAt(dimension, "thebrokenscript:name_tag", location) !== undefined;
    },
  });

  spawnDirector.registerRule({
    id: "nothing_watcher",
    predicate: (ctx) => {
      const player = ctx.players[0];
      if (!player) return false;
      const dimension = player.dimension;
      if (difficultyIsPeaceful()) return false;
      if (config.get("danger.disableSpawningEntities")) return false;
      if (world.gameRules?.doMobSpawning !== true) return false;
      if (dimension.id !== "thebrokenscript:nothing") return false;

      const location = pickSurfaceCandidate(player, 24, 64);
      if (!location || !belowBlockIsValid(dimension, location)) return false;
      if (Math.random() > 0.02) return false;
      if (bossHooks.isArenaPhase1()) return false;
      if (countType(dimension, "thebrokenscript:nothing_watcher") > 35) return false;

      return summonAt(dimension, "thebrokenscript:nothing_watcher", location) !== undefined;
    },
  });

  spawnDirector.registerRule({
    id: "maze_shadows",
    predicate: (ctx) => {
      const player = ctx.players[0];
      if (!player || player.dimension.id !== "thebrokenscript:null_torture") return false;
      const location = pickSurfaceCandidate(player, 16, 56);
      if (!location) return false;
      if (!hasBedrockNearMazeShadow(player.dimension, location)) return false;
      if (countType(player.dimension, "thebrokenscript:maze_shadows") > 50) return false;
      return summonAt(player.dimension, "thebrokenscript:maze_shadows", location) !== undefined;
    },
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
