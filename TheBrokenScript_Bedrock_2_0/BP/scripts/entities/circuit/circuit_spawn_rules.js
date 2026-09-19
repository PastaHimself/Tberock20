import * as operationDiagnostics from "../../core/operation_diagnostics.js";
import * as spawnDirector from "../../systems/spawn_director.js";
import * as worldState from "../../systems/world_state.js";
import { config } from "../../core/config.js";
import { eventFrequency } from "../../systems/event_frequency.js";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import { skyLightLevelAt } from "../../systems/ai/visibility.js";

const BIOME_BLACKLIST_SUBSTRINGS = ["the_end", "end_midlands", "end_highlands", "null_biome"];

function isBlacklistedBiome(dimension, location) {
  try {
    const biome = dimension.getBiome?.(location);
    const id = biome?.id ?? biome?.name ?? "";
    return BIOME_BLACKLIST_SUBSTRINGS.some((s) => String(id).includes(s));
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.entities.circuit.circuit_spawn_rules.js.16", "best-effort Bedrock API fallback", error); return false; }
}

function canSpawnCircuitStalk(ctx) {
  const player = ctx.players[0];
  const dim = player.dimension;
  if (dim.id !== "minecraft:overworld") return false;
  if (worldState.get("isNullHere")) return false;
  if (worldState.get("hasCircuitSpawned")) return false;
  if (worldState.get("circuitSpawnDelay") > 0) return false;
  if (bossHooks.isArenaPhase1()) return false;
  if (isBlacklistedBiome(dim, player.location)) return false;
  if (Math.random() > 0.015 + eventFrequency(ctx.gameTime)) return false;
  const sky = skyLightLevelAt(dim, player.location);
  if (sky !== 0) return false;
  if (entityFinder.hasEntitiesInRange(dim, player.location, 420, ["thebrokenscript:circuit", "thebrokenscript:circuit_stalk", "thebrokenscript:circuit_stare", "thebrokenscript:circuit_mineshaft_walk", "thebrokenscript:circuit_mineshaft_stare", "thebrokenscript:circuit_mineshaft_flee"])) return false;
  worldState.set("circuitSpawnDelay", 5200);
  worldState.set("hasCircuitSpawned", true);
  return true;
}

export function register() {
  spawnDirector.registerRule({
    id: "circuit_stalk",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      return canSpawnCircuitStalk(ctx);
    }
  });
}
