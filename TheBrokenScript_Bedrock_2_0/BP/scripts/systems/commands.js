import { world, system } from "@minecraft/server";
import * as horrorEvents from "./horror_events.js";
import * as dimensions from "./dimensions.js";
import * as worldgenStructures from "./worldgen_structures.js";
import * as progression from "./progression.js";
import { logger } from "../core/logging.js";
import { applyHeartCorruption, applyWhyCantYouLeave } from "./ported_features.js";

// ── Chunk 13: command surface (scriptevent) + chat responses ────────────────
// Usage: /scriptevent tbs:help   |   /scriptevent tbs:fire <event_id>
//        /scriptevent tbs:arena start|stop   |   /scriptevent tbs:shaft
//        /scriptevent tbs:dim <dimId>   |   /scriptevent tbs:adv <advId>
//        /scriptevent tbs:effect heart_corruption|why_cant_you_leave [seconds]

const CHAT_RESPONSES = {
  null: "<null> i see you.",
  herobrine: "<null> he is not real. he never was.",
  the_broken_end: "<null> it is already broken.",
  integrity: "<k§cIntegrity§r> ...",
  circuit: "§k▓▓▓",
  hello: "<null> hello.",
  friend: "<null> we are not friends.",
  who_are_you: "<null> wrong question.",
  what_do_you_want: "<null> you.",
  i_am_scared: "<null> good.",
  void: "<null> the void is patient.",
  steve: "<steve?> ...",
  sorry: "<null> too late."
};

export function begin() {
  try {
    system.afterEvents.scriptEventReceive.subscribe((ev) => {
      try { handleCommand(ev); } catch (err) { logger.error("command failed", err); }
    });
  } catch {}
  try {
    world.beforeEvents.chatSend.subscribe((ev) => {
      const msg = ev.message.toLowerCase().trim();
      const response = CHAT_RESPONSES[msg];
      if (!response) return;
      const sender = ev.sender;
      system.run(() => {
        try { sender.sendMessage("§8" + response); } catch {}
        try { sender.playSound("thebrokenscript:null_is_here_loop", { volume: 4 }); } catch {}
      });
    });
  } catch {}
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
      if (!id || !dimensions.ALL.includes(id)) { reply(ev, "§cdimensions: " + dimensions.ALL.join(", ")); break; }
      const ok = dimensions.teleportTo(player, id, { x: 0, y: 201, z: 0 });
      reply(ev, ok ? `§5traveling to ${id}` : "§cteleport failed");
      break;
    }
    case "adv": {
      const ok = progression.award(player.id, parts[0]);
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
