import { world } from "@minecraft/server";
import * as spawnDirector from "../../systems/spawn_director.js";
import * as worldState from "../../systems/world_state.js";
import { config } from "../../core/config.js";
import { eventFrequency } from "../../systems/event_frequency.js";
import * as bossHooks from "../../systems/boss_hooks.js";

// ── condition constants ──────────────────────────────────────────────────────
const CURVED_CHANCE = 0.00085;      // CurvedConditions, delay 32000, max 2 alive
const HEROBRINE_CHANCE = 0.0001;    // HerobrineConditions, herobrineDelay 32000
const OBLIT_CHANCE = 0.0085;        // ObliterationConditions + freq, oblitSpawnDelay 32000, excl 512
const ANOMALY_MATRIX = [0.001, 0.005, 0.02, 0.015, 0.01, 0.0, 0.0, 0.0]; // moonPhase-indexed

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

function countType(dim, typeId) {
  try { return dim.getEntities({ type: typeId }).length; } catch { return 0; }
}

export function register() {
  // curved — CurvedConditions: 8.5e-4, curvedSpawnDelay 32000, max 2, cave-matched
  spawnDirector.registerRule({
    id: "curved",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      const player = baseGates(ctx);
      if (!player) return false;
      if (worldState.get("curvedSpawnDelay") > 0) return false;
      if (Math.random() > CURVED_CHANCE) return false;
      if (countType(player.dimension, "thebrokenscript:curved") > 1) return false;
      const loc = pickCandidateNearPlayer(player, 24, 56);
      // cave-match approximation: spawn at player Y when player is underground, else surface
      summonAt(player.dimension, "thebrokenscript:curved", loc);
      worldState.set("curvedSpawnDelay", 32000);
      return true;
    }
  });

  // herobrine — HerobrineConditions: 1e-4, herobrineDelay 32000, sky visible
  spawnDirector.registerRule({
    id: "herobrine",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      const player = baseGates(ctx);
      if (!player) return false;
      if (worldState.get("herobrineDelay") > 0) return false;
      if (Math.random() > HEROBRINE_CHANCE) return false;
      const loc = pickCandidateNearPlayer(player, 32, 80);
      let existing = [];
      try { existing = player.dimension.getEntities({ type: "thebrokenscript:herobrine" }); } catch {}
      if (existing.length > 0) return false;
      if (summonAt(player.dimension, "thebrokenscript:herobrine", loc) === undefined) return false;
      worldState.set("herobrineDelay", 32000);
      return true;
    }
  });

  // obliteration pair — ObliterationConditions: 0.0085+freq, oblitSpawnDelay 32000, excl 512
  spawnDirector.registerRule({
    id: "obliteration",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      const player = baseGates(ctx);
      if (!player) return false;
      if (worldState.get("oblitSpawnDelay") > 0) return false;
      if (Math.random() > OBLIT_CHANCE + eventFrequency(ctx.gameTime ?? 0)) return false;
      const loc = pickCandidateNearPlayer(player, 64, 120);
      let near = [];
      try { near = player.dimension.getEntities({ location: loc, maxDistance: 512 }); } catch {}
      if (near.some(x => x.typeId.startsWith("thebrokenscript:the_obliteration"))) return false;
      const roll = Math.random();
      const typeId = roll < 0.5 ? "thebrokenscript:the_obliteration" : "thebrokenscript:the_obliteration_2";
      if (summonAt(player.dimension, typeId, loc) === undefined) return false;
      worldState.set("oblitSpawnDelay", 32000);
      return true;
    }
  });

  // sub_anomaly_1/2 — AnomalyConditions: moonPhase matrix
  spawnDirector.registerRule({
    id: "sub_anomaly",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      const player = baseGates(ctx);
      if (!player) return false;
      const phase = getMoonPhase();
      if (Math.random() > (ANOMALY_MATRIX[phase] ?? 0) + eventFrequency(ctx.gameTime ?? 0)) return false;
      const loc = pickCandidateNearPlayer(player, 24, 64);
      const typeId = Math.random() < 0.5 ? "thebrokenscript:sub_anomaly_1" : "thebrokenscript:sub_anomaly_2";
      return summonAt(player.dimension, typeId, loc) !== undefined;
    }
  });
}
