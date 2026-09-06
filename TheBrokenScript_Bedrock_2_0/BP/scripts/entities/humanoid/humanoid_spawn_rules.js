import { world } from "@minecraft/server";
import * as spawnDirector from "../../systems/spawn_director.js";
import * as worldState from "../../systems/world_state.js";
import { config } from "../../core/config.js";
import { eventFrequency } from "../../systems/event_frequency.js";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as spawnHelpers from "../../systems/ai/spawn_helpers.js";
import * as progression from "../../systems/progression.js";

// ── SiluetConditions matrix[moonStage 0..2][moonPhase 0..7] ──────────────────
const SILUET_MATRIX = [
  [0.0, 0.001, 0.001, 0.005, 0.0085, 0.0085, 0.0085, 0.0085],
  [0.001, 0.002, 0.002, 0.005, 0.0085, 0.009, 0.01, 0.01],
  [0.003, 0.003, 0.006, 0.006, 0.005, 0.0, 0.0, 0.0]
];
// ── TBSEntityConditions matrix (deceiver / rare spawns) ──────────────────────
const ENTITY_MATRIX = [
  [0.0, 0.0001, 0.0001, 0.0005, 0.001, 0.008, 0.0085, 0.0085],
  [0.001, 0.002, 0.002, 0.002, 0.0025, 0.009, 0.01, 0.01],
  [0.003, 0.003, 0.006, 0.006, 0.005, 0.0, 0.0, 0.0]
];

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

function playerSkyLightAtLeast(dim, loc, min) {
  try {
    const lvl = dim.getBlock({ x: Math.floor(loc.x), y: Math.floor(loc.y), z: Math.floor(loc.z) })?.getSkyLightLevel?.();
    if (typeof lvl === "number") return lvl >= min;
  } catch {}
  return true; // permissive fallback
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

// SiluetConditions port — spawns siluet (w25) / siluet_stare (w25) / he (w1 ×10% gate)
function canSpawnSiluet(ctx) {
  const player = ctx.players[0];
  const dim = player.dimension;
  if (dim.id !== "minecraft:overworld") return false;
  if (!worldState.get("isNullHere")) return false;
  if (worldState.get("entitySpawnDelay") > 0) return false;
  if (bossHooks.isArenaPhase1()) return false;
  // player sky light ≥ 2 within 75 (source checks players near pos; we check ctx player)
  if (!playerSkyLightAtLeast(dim, player.location, 2)) return false;
  const loc = pickCandidateNearPlayer(player, 24, 60);
  if (entityFinder.hasEntitiesInRange(dim, loc, 500, ["thebrokenscript:siluet", "thebrokenscript:siluet_stare"])) return false;
  const stage = Math.max(0, Math.min(2, worldState.get("moonStage") ?? 0));
  const phase = getMoonPhase();
  const base = SILUET_MATRIX[stage]?.[phase] ?? 0;
  if (Math.random() > base + eventFrequency(ctx.gameTime ?? 0)) return false;

  // weighted pick: siluet 25 : siluet_stare 25 : he 1 (he extra 10%)
  let typeId;
  const roll = Math.floor(Math.random() * 51);
  if (roll < 25) typeId = "thebrokenscript:siluet";
  else if (roll < 50) typeId = "thebrokenscript:siluet_stare";
  else typeId = Math.random() <= 0.1 ? "thebrokenscript:he" : "thebrokenscript:siluet";

  const spawned = spawnHelpers.trySummon(dim, typeId, loc);
  if (!spawned) return false;
  worldState.set("entitySpawnDelay", 6400);
  // siluet on-spawn ambience + advancement (source: 90% to closest ≤1000)
  if (typeId === "thebrokenscript:siluet") {
    try { dim.playSound("ambient.cave", loc, { volume: 10, pitch: 1 }); } catch {}
    if (Math.random() < 0.9) {
      const near = entityFinder.closestPlayerInRange(world.getAllPlayers(), loc, 1000);
      if (near) progression.award(near.id, "can_you_see_me");
    }
  } else if (typeId === "thebrokenscript:he") {
    try { dim.playSound("thebrokenscript:rare_thing_spawn", loc, { volume: 10, pitch: 0 }); } catch {}
    try { dim.spawnEntity("minecraft:lightning_bolt", loc); } catch {}
    try { dim.runCommand("weather rain 6000"); } catch {}
  }
  return true;
}

// FarawayConditions port — 0.0085+freq, no other faraway anywhere in overworld
function canSpawnFaraway(ctx) {
  const player = ctx.players[0];
  const dim = player.dimension;
  if (dim.id !== "minecraft:overworld") return false;
  if (!worldState.get("isNullHere")) return false;
  if (bossHooks.isArenaPhase1()) return false;
  if (Math.random() > 0.0085 + eventFrequency(ctx.gameTime ?? 0)) return false;
  if (worldState.get("isFlat") && Math.random() > 0.001) return false;
  // uniqueness across the dimension
  let existing = [];
  try { existing = dim.getEntities({ type: "thebrokenscript:faraway" }); } catch {}
  if (existing.length > 0) return false;
  const loc = pickCandidateNearPlayer(player, 32, 80);
  return spawnHelpers.trySummon(dim, "thebrokenscript:faraway", loc) !== undefined;
}

// TBSEntityConditions port — deceiver via rareSpawnDelay 12000
function canSpawnDeceiver(ctx) {
  const player = ctx.players[0];
  const dim = player.dimension;
  if (dim.id !== "minecraft:overworld") return false;
  if (!worldState.get("isNullHere")) return false;
  if (worldState.get("rareSpawnDelay") > 0) return false;
  if (bossHooks.isArenaPhase1()) return false;
  if (worldState.get("isFlat") && Math.random() > 0.001) return false;
  const stage = Math.max(0, Math.min(2, worldState.get("moonStage") ?? 0));
  const phase = getMoonPhase();
  const base = ENTITY_MATRIX[stage]?.[phase] ?? 0;
  if (Math.random() > base + eventFrequency(ctx.gameTime ?? 0)) return false;
  const loc = pickCandidateNearPlayer(player, 24, 64);
  const spawned = spawnHelpers.trySummon(dim, "thebrokenscript:deceiver", loc);
  if (!spawned) return false;
  worldState.set("rareSpawnDelay", 12000);
  return true;
}

export function register() {
  spawnDirector.registerRule({
    id: "siluet_family",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      return canSpawnSiluet(ctx);
    }
  });
  spawnDirector.registerRule({
    id: "faraway",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      return canSpawnFaraway(ctx);
    }
  });
  spawnDirector.registerRule({
    id: "deceiver",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      return canSpawnDeceiver(ctx);
    }
  });
}
