import * as operationDiagnostics from "../../core/operation_diagnostics.js";
import { world } from "@minecraft/server";
import * as spawnDirector from "../../systems/spawn_director.js";
import * as worldState from "../../systems/world_state.js";
import { config } from "../../core/config.js";
import { eventFrequency } from "../../systems/event_frequency.js";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as spawnHelpers from "../../systems/ai/spawn_helpers.js";
import { hasSkyLightAt } from "../../systems/ai/visibility.js";

const NULL_FAMILY = [
  "thebrokenscript:null_watching",
  "thebrokenscript:null_flying",
  "thebrokenscript:null_mining",
  "thebrokenscript:null_invade_base",
  "thebrokenscript:null_is_here",
];
const NULL_SPAWN_CHANCE = 0.0085;
const NULL_SPAWN_DELAY = 7200;
const NULL_EXCLUSION_RANGE = 120;
const NULL_PLAYER_RANGE = 60;
const NULL_MAZE_MAX_COUNT = 2;
const NULL_MAZE_PLAYER_RANGE = 152;
const NULL_MAZE_FLOOR_CHANCE = 0.09;
const NULL_MAZE_DEFAULT_CHANCE = 0.025;

function difficultyIsPeaceful() {
  try {
    return String(world.getDifficulty()).toLowerCase() === "peaceful";
  } catch (error) {
    operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_spawn_rules.js.difficulty", "best-effort Bedrock API fallback", error);
    return true;
  }
}

function candidateNearPlayer(player) {
  const x = Math.floor(player.location.x + (Math.random() * 40 - 20));
  const z = Math.floor(player.location.z + (Math.random() * 40 - 20));

  try {
    const top = player.dimension.getTopmostBlock?.({ x, z });
    const surfaceY = typeof top?.y === "number"
      ? top.y
      : (typeof top?.location?.y === "number" ? top.location.y : undefined);
    if (typeof surfaceY !== "number") return undefined;
    return { x: x + 0.5, y: surfaceY + 1, z: z + 0.5 };
  } catch (error) {
    operationDiagnostics.warnOnce("audit.BP.scripts.entities.null.null_spawn_rules.js.candidate", "best-effort Bedrock API fallback", error);
    return undefined;
  }
}

function hasPlayerInRange(players, dimension, location, maxDistance) {
  return players.some((player) => {
    if (!player || player.dimension?.id !== dimension.id) return false;
    return Math.hypot(
      player.location.x - location.x,
      player.location.y - location.y,
      player.location.z - location.z,
    ) <= maxDistance;
  });
}

function nullMazeLayer(y) {
  if (y >= 200 && y <= 205.9) return "clan_void";
  if (y >= 206 && y <= 214.9) return "maze_floor";
  if (y >= 215 && y <= 229.9) return "wood_floor";
  if (y >= 230 && y <= 249.9) return "stone_floor";
  return undefined;
}

function countNullMaze(dimension) {
  try {
    return dimension.getEntities({ type: "thebrokenscript:null_maze" }).length;
  } catch (error) {
    operationDiagnostics.warnOnce(
      "audit.BP.scripts.entities.null.null_spawn_rules.js.maze_count",
      "best-effort Bedrock API fallback",
      error,
    );
    return Number.POSITIVE_INFINITY;
  }
}

function findNullMazeCandidate(player) {
  const layer = nullMazeLayer(player.location.y);
  if (!layer) return undefined;

  const bounds = {
    clan_void: [200, 205],
    maze_floor: [206, 214],
    wood_floor: [215, 229],
    stone_floor: [230, 249],
  }[layer];

  for (let attempt = 0; attempt < 8; attempt++) {
    const angle = Math.random() * Math.PI * 2;
    const radius = 8 + Math.random() * 52;
    const x = Math.floor(player.location.x + Math.cos(angle) * radius);
    const z = Math.floor(player.location.z + Math.sin(angle) * radius);

    for (let y = bounds[1]; y >= bounds[0]; y--) {
      // NullMazeConditions explicitly rejects candidate Y 226..229.
      if (y >= 226 && y <= 229) continue;
      try {
        const below = player.dimension.getBlock({ x, y: y - 1, z });
        const at = player.dimension.getBlock({ x, y, z });
        const above = player.dimension.getBlock({ x, y: y + 1, z });
        if (!below || !at || !above) continue;
        if (below.isAir === true || below.typeId === "minecraft:air") continue;
        if (at.isAir !== true && at.typeId !== "minecraft:air") continue;
        if (above.isAir !== true && above.typeId !== "minecraft:air") continue;
        const candidate = { x: x + 0.5, y, z: z + 0.5 };
        if (nullMazeLayer(candidate.y) === layer) return candidate;
      } catch (error) {
        operationDiagnostics.warnOnce(
          "audit.BP.scripts.entities.null.null_spawn_rules.js.maze_candidate",
          "best-effort Bedrock API fallback",
          error,
        );
        return undefined;
      }
    }
  }
  return undefined;
}

function canSpawnNullMaze(ctx) {
  const player = ctx.players[0];
  if (!player) return false;
  const dim = player.dimension;

  // Source: NullMazeConditions.predicate(). There is intentionally no arena
  // Phase1 or flat-world gate in this source condition.
  if (difficultyIsPeaceful()) return false;
  if (dim.id !== "thebrokenscript:clan_void") return false;
  if (world.gameRules?.doMobSpawning !== true) return false;
  if (!worldState.get("isNullHere")) return false;
  if (config.get("danger.disableSpawningEntities")) return false;
  if (countNullMaze(dim) >= NULL_MAZE_MAX_COUNT) return false;

  const candidate = findNullMazeCandidate(player);
  if (!candidate) return false;
  if (!hasPlayerInRange(ctx.players, dim, candidate, NULL_MAZE_PLAYER_RANGE)) return false;

  const layer = nullMazeLayer(candidate.y);
  if (!layer || layer !== nullMazeLayer(player.location.y)) return false;
  const chance = layer === "maze_floor"
    ? NULL_MAZE_FLOOR_CHANCE
    : NULL_MAZE_DEFAULT_CHANCE;
  if (Math.random() > chance + eventFrequency(ctx.gameTime)) return false;

  const spawned = spawnHelpers.trySummon(dim, "thebrokenscript:null_maze", candidate);
  if (!spawned) return false;
  spawnHelpers.applyRandomRotation(spawned);
  return true;
}

export function register() {
  spawnDirector.registerRule({
    id: "null_watching",
    predicate: (ctx) => {
      const player = ctx.players[0];
      if (!player) return false;
      const dim = player.dimension;

      // Source: NullConditions.predicate().
      if (difficultyIsPeaceful()) return false;
      if (dim.id !== "minecraft:overworld") return false;
      if (world.gameRules?.doMobSpawning !== true) return false;
      if (!worldState.get("isNullHere")) return false;
      if (config.get("danger.disableSpawningEntities")) return false;
      if (worldState.get("nullSpawnDelay") > 0) return false;

      // Java's natural-spawn engine supplies an ON_GROUND heightmap position.
      // The script director approximates that input with the first air block
      // above a nearby topmost block before applying the source predicate.
      const candidate = candidateNearPlayer(player);
      if (!candidate) return false;
      if (!hasSkyLightAt(dim, candidate)) return false;

      if (Math.random() > NULL_SPAWN_CHANCE + eventFrequency(ctx.gameTime)) return false;
      if (bossHooks.isArenaPhase1()) return false;
      if (worldState.get("isFlat") && Math.random() > 0.001) return false;
      if (entityFinder.hasEntitiesInRange(dim, candidate, NULL_EXCLUSION_RANGE, NULL_FAMILY)) return false;
      if (!hasPlayerInRange(ctx.players, dim, candidate, NULL_PLAYER_RANGE)) return false;

      const spawned = spawnHelpers.trySummon(dim, "thebrokenscript:null_watching", candidate);
      if (!spawned) return false;
      worldState.set("nullSpawnDelay", NULL_SPAWN_DELAY);
      return true;
    },
  });

  spawnDirector.registerRule({
    id: "null_maze",
    predicate: (ctx) => canSpawnNullMaze(ctx),
}
