import * as spawnDirector from "../../systems/spawn_director.js";
import * as worldState from "../../systems/world_state.js";
import { config } from "../../core/config.js";
import { eventFrequency } from "../../systems/event_frequency.js";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import * as spawnHelpers from "../../systems/ai/spawn_helpers.js";

function isBlacklistedBiome() { return false; }

export function register() {
  spawnDirector.registerRule({
    id: "null_watching",
    predicate: (ctx) => {
      if (config.get("danger.disableSpawningEntities")) return false;
      if (ctx.players[0].dimension.id !== "minecraft:overworld") return false;
      if (!worldState.get("isNullHere")) return false;
      if (worldState.get("nullSpawnDelay") > 0) return false;
      if (bossHooks.isArenaPhase1()) return false;
      if (Math.random() > 0.0085 + eventFrequency(ctx.gameTime)) return false;
      const dim = ctx.players[0].dimension;
      try { if (dim.getBlock(ctx.players[0].location)?.getSkyLightLevel?.() !== 15) return false; } catch {}
      if (entityFinder.hasEntitiesInRange(dim, ctx.players[0].location, 120, ["thebrokenscript:null_watching","thebrokenscript:null_flying","thebrokenscript:null_mining","thebrokenscript:null_is_here"])) return false;
      const candidate = { x: ctx.players[0].location.x + (Math.random()*40-20), y: ctx.players[0].location.y, z: ctx.players[0].location.z + (Math.random()*40-20) };
      const spawned = spawnHelpers.trySummon(dim, "thebrokenscript:null_watching", candidate);
      if (!spawned) return false;
      worldState.set("nullSpawnDelay", 7200);
      return true;
    }
  });
}
