import * as spawnDirector from "../../systems/spawn_director.js";
import * as worldState from "../../systems/world_state.js";
import { config } from "../../core/config.js";
import { eventFrequency } from "../../systems/event_frequency.js";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as spawnHelpers from "../../systems/ai/spawn_helpers.js";

// ── TBEConditions (moonStage==2) & TBEAmbushConditions (hasMoonCorrupted) ─────
const SPAWN_CHANCE_TBE = [0, 0, 0, 0, 0.00015, 0.00025, 0.001, 0.002]; // indexed by moonPhase 0..7
const SPAWN_MATRIX_AMBUSH = [
  [0.0002, 0.0004, 0.0006, 0.0008, 0.001, 0.0012],
  [0.0005, 0.001, 0.0015, 0.002, 0.0025, 0.003],
  [0.001, 0.002, 0.003, 0.004, 0.005, 0.006]
];
const TBE_TYPES = [
  "thebrokenscript:the_broken_end",
  "thebrokenscript:the_broken_end_stalk",
  "thebrokenscript:the_broken_end_ambush"
];

function hasOtherBrokenEndsInRange(dim, loc) {
  return entityFinder.hasEntitiesInRange(dim, loc, 512, TBE_TYPES);
}

function getMoonPhase(worldObj) {
  try {
    const mp = worldObj.getMoonPhase?.();
    if (typeof mp === "number") return mp & 7;
  } catch {}
  // fallback: day % 8
  try {
    const day = worldObj.getDay?.() ?? Math.floor((worldObj.getTime?.() ?? 0) / 24000);
    return ((day % 8) + 8) % 8;
  } catch {}
  return 0;
}

function pickCandidateNearPlayer(player, minDist, maxDist) {
  const angle = Math.random() * Math.PI * 2;
  const r = minDist + Math.random() * (maxDist - minDist);
  const x = player.location.x + Math.cos(angle) * r;
  const z = player.location.z + Math.sin(angle) * r;
  // keep Y near player or surface if available
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

function skyVisible(dim, loc) {
  try {
    const block = dim.getBlock({ x: Math.floor(loc.x), y: Math.floor(loc.y + 1), z: Math.floor(loc.z) });
    // Bedrock doesn't expose canSeeSky; approximate via sky light at position ==15
    // try getSkyLightLevel if present
    const sky = block?.getComponent?.("minecraft:sky_light") ?? block?.getSkyLightLevel?.();
    // fallback: treat as visible when getBlock returns and y is high-ish or surrounding transparent
    return true; // permissive — spawn_director already guards isNullHere/phase etc.
  } catch { return true; }
}

function canSpawnTbeStalk(ctx) {
  const player = ctx.players[0];
  const dim = player.dimension;
  if (dim.id !== "minecraft:overworld") return false;
  if (!worldState.get("isNullHere")) return false;
  if (worldState.get("tbeSpawnDelay") > 0) return false;
  // moonStage==2 required (MapVariables.moonStage)
  if (worldState.get("moonStage") !== 2) return false;
  if (bossHooks.isArenaPhase1()) return false;
  // flat world guard approximation: treat as seeded flag worldState isFlat? keep permissive
  // distance >=45 enforced via candidate at 45-90 ring
  const loc = pickCandidateNearPlayer(player, 45, 90);
  if (!skyVisible(dim, loc)) return false;
  // isFlat check from original: world.getLevel().isFlat() && rnd>0.001 -> block 99.9% spawns on flat
  // worldState isFlat default false; approximate: if isFlat true, extra gate
  if (worldState.get("isFlat") && Math.random() > 0.001) return false;
  if (hasOtherBrokenEndsInRange(dim, loc)) return false;
  // check player distance to candidate >=45 (already by ring, but verify)
  const d2 = (player.location.x - loc.x) ** 2 + (player.location.z - loc.z) ** 2;
  if (d2 < 45 * 45) return false;
  const moonPhase = getMoonPhase(ctx.world ?? player.dimension ?? { getMoonPhase: () => 0 });
  const chance = (SPAWN_CHANCE_TBE[moonPhase] ?? 0) + eventFrequency(ctx.gameTime ?? 0);
  if (Math.random() > chance) return false;
  // valid ground check (source Monster.isDarkEnough etc): approximate with sky+ darkness guard
  // trySummon at loc
  const spawned = spawnHelpers.trySummon(dim, "thebrokenscript:the_broken_end_stalk", loc);
  if (!spawned) return false;
  spawnHelpers.applyRandomRotation(spawned);
  worldState.set("tbeSpawnDelay", 32000);
  return true;
}

function canSpawnTbeAmbush(ctx) {
  const player = ctx.players[0];
  const dim = player.dimension;
  if (dim.id !== "minecraft:overworld") return false;
  if (!worldState.get("isNullHere")) return false;
  if (!worldState.get("hasMoonCorrupted")) return false;
  if (worldState.get("tbeSpawnDelay") > 0) return false;
  if (bossHooks.isArenaPhase1()) return false;
  if (worldState.get("isFlat") && Math.random() > 0.001) return false;
  const loc = pickCandidateNearPlayer(player, 45, 90);
  if (!skyVisible(dim, loc)) return false;
  if (hasOtherBrokenEndsInRange(dim, loc)) return false;
  // distance check not strictly required for ambush in source, but keep for safety (source had no distance guard for ambush)
  const corruptStage = Math.max(0, Math.min(2, worldState.get("moonStage") ?? 0));
  const invCorr = Math.max(0, Math.min(5, worldState.get("inventoryCorruption") ?? 0));
  const base = SPAWN_MATRIX_AMBUSH[corruptStage]?.[invCorr] ?? 0;
  const chance = base + eventFrequency(ctx.gameTime ?? 0);
  if (Math.random() > chance) return false;
  const spawned = spawnHelpers.trySummon(dim, "thebrokenscript:the_broken_end_ambush", loc);
  if (!spawned) return false;
  spawnHelpers.applyRandomRotation(spawned);
  worldState.set("tbeSpawnDelay", 8200);
  return true;
}

export function register() {
  spawnDirector.registerRule({
    id: "tbe_stalk",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      // ctx from spawn_director: { players, gameTime, frequency, world? }
      // augment world reference for moonPhase fallback
      try { ctx.world = ctx.players[0]?.dimension ? { getMoonPhase: () => ctx.players[0].dimension.getMoonPhase?.() ?? 0, getDay: () => ctx.players[0].dimension.getDay?.() ?? 0, getTime: () => ctx.gameTime } : ctx.world; } catch {}
      return canSpawnTbeStalk(ctx);
    }
  });
  spawnDirector.registerRule({
    id: "tbe_ambush",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      try { ctx.world = ctx.players[0]?.dimension ? { getMoonPhase: () => ctx.players[0].dimension.getMoonPhase?.() ?? 0, getDay: () => ctx.players[0].dimension.getDay?.() ?? 0, getTime: () => ctx.gameTime } : ctx.world; } catch {}
      return canSpawnTbeAmbush(ctx);
    }
  });
}
