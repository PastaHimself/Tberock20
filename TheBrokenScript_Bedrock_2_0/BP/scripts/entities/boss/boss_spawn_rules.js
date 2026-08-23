import { world } from "@minecraft/server";
import * as spawnDirector from "../../systems/spawn_director.js";
import * as worldState from "../../systems/world_state.js";
import { config } from "../../core/config.js";
import { eventFrequency } from "../../systems/event_frequency.js";
import * as bossHooks from "../../systems/boss_hooks.js";

// ── condition constants (FracturedConditions / FeverStalkConditions) ─────────
const FRACTURED_ROW = [0.01, 0.02, 0.03, 0.04, 0.05, 0.06];   // indexed by corruption stage clamp 0..5
const FEVER_STALK_ROW = [0.0005, 0.001, 0.0015, 0.002, 0.0025, 0.003];

function baseGates(ctx) {
  const player = ctx.players[0];
  if (!player) return null;
  if (player.dimension.id !== "minecraft:overworld") return null;
  if (!worldState.get("isNullHere")) return null;
  if (bossHooks.isArenaActive()) return null;
  if (worldState.get("isFlat") && Math.random() > 0.001) return null;
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

function stageIndex() {
  // source indexes by corruptMoonStage — approximate with moonStage clamp 0..5
  const stage = worldState.get("moonStage") ?? 0;
  return Math.max(0, Math.min(5, stage));
}

export function register() {
  // fractured_roam (Jimmy roam form) — FRACTURED_CONDITIONS row+freq
  spawnDirector.registerRule({
    id: "fractured_roam",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      const player = baseGates(ctx);
      if (!player) return false;
      if (Math.random() > FRACTURED_ROW[stageIndex()] + eventFrequency(ctx.gameTime ?? 0)) return false;
      let existing = [];
      try { existing = player.dimension.getEntities({ type: "thebrokenscript:fractured_roam" }); } catch {}
      if (existing.length > 0) return false;
      const loc = pickCandidateNearPlayer(player, 48, 96);
      try { return player.dimension.spawnEntity("thebrokenscript:fractured_roam", loc) !== undefined; } catch { return false; }
    }
  });

  // fever_stalk — FEVER_STALK row+freq, sky visible
  spawnDirector.registerRule({
    id: "fever_stalk",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      const player = baseGates(ctx);
      if (!player) return false;
      if (Math.random() > FEVER_STALK_ROW[stageIndex()] + eventFrequency(ctx.gameTime ?? 0)) return false;
      let existing = [];
      try { existing = player.dimension.getEntities({ type: "thebrokenscript:fever_stalk" }); } catch {}
      if (existing.length > 0) return false;
      const loc = pickCandidateNearPlayer(player, 32, 80);
      try { return player.dimension.spawnEntity("thebrokenscript:fever_stalk", loc) !== undefined; } catch { return false; }
    }
  });
}
