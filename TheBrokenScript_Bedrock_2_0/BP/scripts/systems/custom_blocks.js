import { BlockPermutation, system, world } from "@minecraft/server";
import * as dimensions from "./dimensions.js";
import { logger } from "../core/logging.js";
import { teleportLinkedPortal } from "./ported_features.js";
import * as worldState from "./world_state.js";

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

  // Java DisruptionBlock schedules itself to become air exactly 100 ticks after placement.
  register("thebrokenscript:disruption", {
    onPlace(ev) {
      const { block } = ev;
      system.runTimeout(() => {
        try {
          block.setType("minecraft:air");
        } catch (error) {
          logger.error("custom_blocks: disruption removal failed", error);
        }
      }, 100);
    }
  });

  // Java CorruptedCommandBlock stores its placed location and flips its `code` state
  // once the world-level codeApplied flag becomes true. The Java menu/UI remains a
  // separate, currently unsupported adapter concern; do not fabricate command text here.
  register("thebrokenscript:be_command", {
    onPlace(ev) {
      const { x, y, z } = ev.block.location;
      worldState.set("commandBlockX", x);
      worldState.set("commandBlockY", y);
      worldState.set("commandBlockZ", z);
    },
    onTick(ev) {
      if (!worldState.get("codeApplied")) return;
      const states = ev.block.permutation.getAllStates();
      if (states["thebrokenscript:code"] === true) return;
      try {
        ev.block.setPermutation(
          BlockPermutation.resolve(ev.block.typeId, {
            ...states,
            "thebrokenscript:code": true,
          }),
        );
      } catch (error) {
        logger.error("custom_blocks: command state update failed", error);
      }
    }
  });

  register("thebrokenscript:be_portal_controller", {
    onPlayerInteract(ev) {
      if (!ev.player) return;
      if (heldItemTypeId(ev.player) === "thebrokenscript:portal_linker") return;

      const player = ev.player;
      const block = ev.block;
      system.run(() => {
        void handlePortalControllerInteract(player, block);
      });
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

async function handlePortalControllerInteract(player, block) {
  try {
    if (await teleportLinkedPortal(player, block)) return;

    try {
      player.onScreenDisplay.setTitle("§5PORTAL CONTROLLER", {
        fadeInDuration: 0,
        stayDuration: 25,
        fadeOutDuration: 0
      });
    } catch {}

    const loc = { x: player.location.x, y: 201, z: player.location.z };
    const teleported = await dimensions.teleportWhenReady(player, "clan_void", loc);
    if (teleported) {
      tryPlayNear(block.dimension, block.location, "thebrokenscript:portal_linker", 3, 1);
    }
  } catch (error) {
    logger.error("custom_blocks: portal controller activation failed", error);
  }
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
