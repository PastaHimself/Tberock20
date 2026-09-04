import { system, world } from "@minecraft/server";
import * as dimensions from "./dimensions.js";
import { logger } from "../core/logging.js";
import { teleportLinkedPortal } from "./ported_features.js";
import * as worldState from "./world_state.js";
import { showCommandBlockConfirm, showCommandBlockGui } from "./ported_features.js";

// Chunk 08: custom block components.
// BE equivalents: command, portal_controller, portal_extender, null_structure,
// shadow_bug, exit, all_dead (flesh), a_flower, jim_trigger_1-4
// plus physical_stacktrace / disruption behaviors from prior ledgers.

const registered = [];

/**
 * Register all custom block components during the Script API startup event.
 * @param {import("@minecraft/server").BlockComponentRegistry} blockComponentRegistry
 */
export function init(blockComponentRegistry) {
  /**
   * @param {string} name
   * @param {import("@minecraft/server").BlockCustomComponent} handlers
   */
  function register(name, handlers) {
    blockComponentRegistry.registerCustomComponent(name, handlers);
    registered.push(name);
  }

  // physical_stacktrace — placed by TBE stalk; shows a glitch beat when placed/stepped near
  register("thebrokenscript:physical_stacktrace", {
    onPlace(ev) {
      const { block } = ev;
      for (const p of world.getAllPlayers()) {
        if (p.dimension.id !== block.dimension.id) continue;
        if (distance(p.location, block.location) > 24) continue;
        try {
          p.onScreenDisplay.setTitle("§k██§r at java.lang.Thread.getStackTrace", {
            fadeInDuration: 0, stayDuration: 30, fadeOutDuration: 10
          });
        } catch {}
      }
    },
    onEntityFallOn(ev) {
      try { ev.entity.applyDamage(2); } catch {}
    }
  });

  // disruption — random glitch pulses while placed
  register("thebrokenscript:disruption", {
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

  // command / command_block_giver — route to the source screen or giver behavior
  register("thebrokenscript:be_command", {
    onPlayerInteract(ev) {
      const { block, player } = ev;
      if (block.typeId === "thebrokenscript:command_block_giver") {
        giveCorruptedCommandBlock(player, block);
        return;
      }
      if (block.typeId === "thebrokenscript:command") {
        system.run(() => {
          if (worldState.get("codeApplied")) {
            void showCommandBlockConfirm(player, block);
          } else {
            void showCommandBlockGui(player, block);
          }
        });
      }
    }
  });

  register("thebrokenscript:be_portal_controller", {
    onPlayerInteract(ev) {
      if (!ev.player) return;
      if (heldItemTypeId(ev.player) === "thebrokenscript:portal_linker") return;
      if (teleportLinkedPortal(ev.player, ev.block)) return;
      try { ev.player.onScreenDisplay.setTitle("§5PORTAL CONTROLLER", { fadeInDuration: 0, stayDuration: 25, fadeOutDuration: 0 }); } catch {}
      const loc = { x: ev.player.location.x, y: 201, z: ev.player.location.z };
      dimensions.teleportTo(ev.player, "clan_void", loc);
      tryPlayNear(ev.block.dimension, ev.block.location, "thebrokenscript:portal_linker", 3, 1);
    }
  });

  register("thebrokenscript:be_portal_extender", {
    onPlayerInteract(ev) {
      try { ev.player.onScreenDisplay.setTitle("§5EXTENDER LINKED", { fadeInDuration: 0, stayDuration: 20, fadeOutDuration: 0 }); } catch {}
    }
  });

  // Java parity: NullStructureBlock is a passive, invisible marker. Its block entity
  // stores a structureId plus once-per-player/world trigger state; event handlers query
  // nearby markers and perform the requested action. It has no use/interact behavior.
  // Keep the custom component registered because block JSONs reference it, but do not
  // synthesize a click-to-place structure action here.
  register("thebrokenscript:be_null_structure", {});

  register("thebrokenscript:be_shadow_bug", {
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

  register("thebrokenscript:be_exit", {
    onPlayerInteract(ev) {
      try { ev.player.onScreenDisplay.setTitle("§aEXIT?", { fadeInDuration: 0, stayDuration: 20, fadeOutDuration: 0 }); } catch {}
    }
  });

  register("thebrokenscript:be_a_flower", {
    onPlayerInteract(ev) {
      try { ev.player.playSound("chime.amethyst_block"); } catch {}
      try { ev.player.onScreenDisplay.setTitle("§d...", { fadeInDuration: 0, stayDuration: 15, fadeOutDuration: 0 }); } catch {}
    }
  });

  register("thebrokenscript:be_jim_trigger", makeJimTrigger());

  logger.info(`custom_blocks: ${registered.length} component(s) registered`);
}

/** @returns {import("@minecraft/server").BlockCustomComponent} */
function makeJimTrigger() {
  return {
    onStepOn(ev) {
      const stage = jimStage(ev.block);
      if (stage === 0) return;
      try { ev.entity.setDynamicProperty("tbs:jim_stage_touch", stage); } catch {}
    }
  };
}

/** @param {import("@minecraft/server").Block} block */
function jimStage(block) {
  const match = /^thebrokenscript:jim_trigger_([1-4])$/.exec(block.typeId);
  return match ? Number(match[1]) : 0;
}

function giveCorruptedCommandBlock(player, block) {
  try {
    player.runCommand("give @s thebrokenscript:command 1");
  } catch (err) {
    logger.error("custom_blocks: failed to give corrupted command block", err);
  }
  try {
    block.setType("minecraft:air");
  } catch (err) {
    logger.error("custom_blocks: failed to remove command block giver", err);
  }
}

function distance(a, b) {
  return Math.hypot(a.x - b.x, a.y - b.y, a.z - b.z);
}

function heldItemTypeId(player) {
  try {
    const inventory = player.getComponent("minecraft:inventory")?.container;
    return inventory?.getItem(player.selectedSlotIndex)?.typeId;
  } catch {
    return undefined;
  }
}

function tryPlayNear(dim, loc, sound, vol, pitch) {
  try { dim.playSound(sound, loc, { volume: vol, pitch }); } catch {}
}
