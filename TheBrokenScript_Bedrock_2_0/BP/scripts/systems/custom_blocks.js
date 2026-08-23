import { world, system, blockComponentRegistry } from "@minecraft/server";
import * as dimensions from "./dimensions.js";
import * as worldgenStructures from "./worldgen_structures.js";
import { logger } from "../core/logging.js";

// â”€â”€ Chunk 08: custom block components (beta blockComponentRegistry) â”€â”€â”€â”€â”€â”€â”€â”€â”€â”€
// BE equivalents: command, portal_controller, portal_extender, null_structure,
// shadow_bug, exit, all_dead (flesh), a_flower, jim_trigger_1-4
// plus physical_stacktrace / disruption behaviors from prior ledgers.

const registered = [];

function register(name, handlers) {
  try {
    blockComponentRegistry.registerCustomComponent(name, handlers);
    registered.push(name);
  } catch (err) {
    logger.error(`block component '${name}' registration failed`, err);
  }
}

export function init() {
  // physical_stacktrace â€” placed by TBE stalk; shows a glitch beat when placed/stepped near
  register("physical_stacktrace", {
    onPlace(ev) {
      const { block } = ev;
      for (const p of world.getAllPlayers()) {
        if (p.dimension.id !== block.dimension.id) continue;
        if (distance(p.location, block.location) > 24) continue;
        try {
          p.onScreenDisplay.setTitle("Â§kâ–ˆâ–ˆÂ§r at java.lang.Thread.getStackTrace", {
            fadeInDuration: 0, stayDuration: 30, fadeOutDuration: 10
          });
        } catch {}
      }
    },
    onEntityFallOn(ev) {
      try { ev.entity.applyDamage(2); } catch {}
    }
  });

  // disruption â€” random glitch pulses while placed
  register("disruption", {
    onRandomTick(ev) {
      const { block } = ev;
      try {
        block.dimension.spawnParticle("minecraft:basic_flame_particle", {
          x: block.location.x + 0.5 + (Math.random() - 0.5),
          y: block.location.y + 1.1,
          z: block.location.z + 0.5 + (Math.random() - 0.5)
        });
      } catch {}
      if (Math.random() < 0.02) {
        tryPlayNear(block.dimension, block.location, "thebrokenscript:glitch_sound_1", 3, 1);
      }
    }
  });

  // command / command_block_giver â€” interact prints corrupted command feedback
  register("be_command", {
    onPlayerInteract(ev) {
      const lines = ["/give @s minecraft:knowledge", "/tp @s into_the_void", "/ban @a[distance=..64]"];
      const line = lines[Math.floor(Math.random() * lines.length)];
      try { ev.player.onScreenDisplay.setTitle(`Â§7${line}`, { stayDuration: 20 }); } catch {}
      tryPlayNear(ev.block.dimension, ev.block.location, "thebrokenscript:glitch_sound_1", 2, 0.8);
    }
  });

  register("be_portal_controller", {
    onPlayerInteract(ev) {
      try { ev.player.onScreenDisplay.setTitle("Â§5PORTAL CONTROLLER", { stayDuration: 25 }); } catch {}
      // portal activation: send player to clan_void at the null_book coords height
      const loc = { x: ev.player.location.x, y: 201, z: ev.player.location.z };
      dimensions.teleportTo(ev.player, "clan_void", loc);
      tryPlayNear(ev.block.dimension, ev.block.location, "thebrokenscript:portal_linker", 3, 1);
    }
  });

  register("be_portal_extender", {
    onPlayerInteract(ev) {
      try { ev.player.onScreenDisplay.setTitle("Â§5EXTENDER LINKED", { stayDuration: 20 }); } catch {}
    }
  });

  register("be_null_structure", {
    onPlayerInteract(ev) {
      try { ev.player.onScreenDisplay.setTitle("Â§8NULL_STRUCTURE", { stayDuration: 20 }); } catch {}
      // Chunk 11: interact builds the bedrock Shaft nearby (structure/shaft/*.nbt approx)
      const built = worldgenStructures.buildShaft(ev.block.dimension, {
        x: ev.block.location.x + 24,
        y: ev.block.location.y,
        z: ev.block.location.z + 24
      });
      if (built) {
        try { ev.player.sendMessage("Â§8the ground splits open..."); } catch {}
      }
    }
  });

  register("be_shadow_bug", {
    onRandomTick(ev) {
      if (Math.random() > 0.05) return;
      const { block } = ev;
      try {
        block.dimension.spawnParticle("minecraft:basic_smoke_particle", {
          x: block.location.x + 0.5, y: block.location.y + 1.05, z: block.location.z + 0.5
        });
      } catch {}
    }
  });

  register("be_exit", {
    onPlayerInteract(ev) {
      try { ev.player.onScreenDisplay.setTitle("Â§aEXIT?", { stayDuration: 20 }); } catch {}
    }
  });

  register("be_a_flower", {
    onPlayerInteract(ev) {
      try { ev.player.playSound("chime.amethyst_block"); } catch {}
      try { ev.player.onScreenDisplay.setTitle("Â§d...", { stayDuration: 15 }); } catch {}
    }
  });

  for (let i = 1; i <= 4; i++) {
    register(`be_jim_trigger`, makeJimTrigger(i));
  }

  logger.info(`custom_blocks: ${registered.length} component(s) registered`);
}

function makeJimTrigger(stage) {
  return {
    onPlace(ev) {
      // Jimmy arena trigger stages â€” full choreography in Chunk 12; stage marker only
      try { ev.block.setDynamicProperty("tbs:jim_stage", stage); } catch {}
    },
    onEntityStepOn(ev) {
      try { ev.entity.setDynamicProperty("tbs:jim_stage_touch", stage); } catch {}
    }
  };
}

function distance(a, b) {
  return Math.hypot(a.x - b.x, a.y - b.y, a.z - b.z);
}
function tryPlayNear(dim, loc, sound, vol, pitch) {
  try { dim.playSound(sound, loc, { volume: vol, pitch }); } catch {}
}
