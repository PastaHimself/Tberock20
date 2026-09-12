import {
  CommandPermissionLevel,
  CustomCommandStatus,
  world,
  system
} from "@minecraft/server";
import * as horrorEvents from "./horror_events.js";
import * as dimensions from "./dimensions.js";
import * as worldgenStructures from "./worldgen_structures.js";
import * as progression from "./progression.js";
import * as playerState from "./player_state.js";
import { logger } from "../core/logging.js";
import { applyHeartCorruption, applyWhyCantYouLeave } from "./ported_features.js";

// Source-backed production command registration. Java registers `tbs` at permission
// level 4; Bedrock has no equivalent 0-4 op ladder, so Admin is the closest
// in-game operator-only permission and excludes command-block automation.
export function register(customCommandRegistry) {
  customCommandRegistry.registerCommand(
    {
      name: "tbs:reputation",
      description: "reputation",
      permissionLevel: CommandPermissionLevel.Admin,
      cheatsRequired: false
    },
    (origin) => {
      const player = origin.sourceEntity;
      if (!player || player.typeId !== "minecraft:player") {
        return {
          status: CustomCommandStatus.Failure,
          message: "This command must be executed by a player!"
        };
      }

      // Custom-command callbacks run in before-event context. Defer state access
      // and feedback to the next tick, per the Bedrock Script API contract.
      system.run(() => {
        try {
          const rep = playerState.get(player, "entityReputation");
          const text = rep <= 25 ? "BAD" : rep <= 75 ? "NORMAL" : "GOOD";
          const desc =
            rep <= 25
              ? "Null is pissed and his hatred for you is at maximum. Expect hell from null. Null will now more often attack the player."
              : rep <= 75
                ? "Null and you are neutral between each other. Null can sometimes hurt the player."
                : "Null is cool and doesn't care about you being here. Null will rarely hurt the player.";
          player.sendMessage(`Reputation value: ${rep}`);
          player.sendMessage(`Reputation: ${text}`);
          player.sendMessage(desc);
        } catch (error) {
          logger.error("commands: reputation failed", error);
        }
      });

      return { status: CustomCommandStatus.Success };
    }
  );
}

// Bedrock-only developer/regression hooks. These are not presented as Java
// command parity; they remain behind Bedrock's built-in /scriptevent command.
// Usage: /scriptevent tbs:help   |   /scriptevent tbs:fire <event_id>
//        /scriptevent tbs:arena start|stop   |   /scriptevent tbs:shaft
//        /scriptevent tbs:dim <dimension>   |   /scriptevent tbs:adv <advId>
//        /scriptevent tbs:effect heart_corruption|why_cant_you_leave [seconds]

export function begin() {
  try {
    system.afterEvents.scriptEventReceive.subscribe((ev) => {
      try { handleCommand(ev); } catch (err) { logger.error("command failed", err); }
    });
  } catch (error) {
    logger.error("commands: failed to subscribe to scriptEventReceive", error);
  }
}

function reply(ev, text) {
  try { ev.sourceEntity?.sendMessage(text); } catch {}
}

function handleCommand(ev) {
  if (!ev.id.startsWith("tbs:")) return;
  const player = ev.sourceEntity;
  if (!player || player.typeId !== "minecraft:player") return;
  const parts = ev.message.trim().split(/\s+/);
  const cmd = ev.id.slice(4);

  switch (cmd) {
    case "help":
      reply(ev, [
        "§8--- The Broken Script commands ---",
        "§7/scriptevent tbs:fire <event>",
        "§7/scriptevent tbs:arena <start|stop>",
        "§7/scriptevent tbs:shaft",
        "§7/scriptevent tbs:dim <dimension>",
        "§7/scriptevent tbs:adv <advancement>",
        "§7/scriptevent tbs:effect <effect> [seconds]"
      ].join("\n"));
      break;
    case "fire": {
      const ok = horrorEvents.fire(parts[0]);
      reply(ev, ok ? `§7fired '${parts[0]}'` : `§cunknown event '${parts[0]}'`);
      break;
    }
    case "events":
      reply(ev, `§7${horrorEvents.EVENT_COUNT} events registered`);
      break;
    case "arena": {
      const on = parts[0] === "start";
      world.setDynamicProperty("tbs:arenaActive", on);
      world.setDynamicProperty("tbs:arenaPhase1", on && parts[1] !== "p3");
      reply(ev, on ? "§5Arena started" : "§5Arena stopped");
      break;
    }
    case "shaft": {
      const built = worldgenStructures.buildShaft(player.dimension, player.location);
      reply(ev, built ? "§8the ground splits open..." : "§7already here.");
      break;
    }
    case "dim": {
      const id = parts[0];
      if (!id || !dimensions.isSupported(id)) {
        reply(ev, "§cdimensions: " + dimensions.SUPPORTED.join(", "));
        break;
      }
      reply(ev, `§5preparing ${id}...`);
      void dimensions
        .teleportWhenReady(player, id, { x: 0, y: 201, z: 0 })
        .then((ok) => {
          if (!ok) reply(ev, "§cteleport failed");
        })
        .catch((error) => {
          logger.error(`commands: dimension teleport '${id}' failed`, error);
          reply(ev, "§cteleport failed");
        });
      break;
    }
    case "adv": {
      const ok = progression.award(player, parts[0]);
      reply(ev, ok ? "§8awarded" : "§calready awarded / unknown");
      break;
    }
    case "effect": {
      const ticks = Math.max(1, Math.floor(Number(parts[1] ?? 10) * 20));
      if (parts[0] === "heart_corruption") {
        applyHeartCorruption(player, ticks);
        reply(ev, "§dERR.HEALTH");
      } else if (parts[0] === "why_cant_you_leave") {
        applyWhyCantYouLeave(player, ticks);
        reply(ev, "§8eyes in the dark");
      } else {
        reply(ev, "§ceffects: heart_corruption, why_cant_you_leave");
      }
      break;
    }
    default:
      reply(ev, "§cunknown tbs command — try /scriptevent tbs:help");
  }
}
