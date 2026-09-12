import { world, system } from "@minecraft/server";
import { logger } from "../core/logging.js";

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
  } catch (error) {
    logger.error("horror_chat: failed to subscribe to chatSend", error);
  }
}
