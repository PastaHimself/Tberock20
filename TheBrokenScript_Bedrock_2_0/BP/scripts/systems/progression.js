import { world, system } from "@minecraft/server";
import { logger } from "../core/logging.js";

// ── Chunk 13: progression (advancement approximations) ──────────────────────
// Bedrock has no custom advancements (A-006): award() = title + sound + chat
// line + once-per-world dynamic property. Source roster: TBSAdvancements.java.

export const ADVANCEMENTS = {
  can_someone_hear_me: "Can Someone Hear Me?",
  can_you_see_me: "Can You See Me?",
  nullnullnull: "nullnullnull",
  you_ve_brought_it_upon_yourself: "You've Brought It Upon Yourself",
  polaroid_craft: "Say Cheese!"
};

const awarded = new Set();

export function award(playerId, id) {
  const label = ADVANCEMENTS[id];
  if (!label) return false;
  const key = `${id}`;
  if (awarded.has(key)) return false;
  // per-player once when a specific player is targeted; global otherwise
  let player = null;
  try { player = typeof playerId === "string" ? world.getEntity(playerId) : playerId; } catch {}
  if (player) {
    const propKey = `tbs:adv_${id}`;
    try { if (player.getDynamicProperty(propKey)) return false; } catch {}
    try { player.setDynamicProperty(propKey, true); } catch {}
    try {
      player.playSound("random.levelup", { volume: 0.6 });
      player.onScreenDisplay.setTitle("§8Advancement Made§r §7— " + label, {
        fadeInDuration: 5, stayDuration: 50, fadeOutDuration: 10
      });
    } catch {}
  }
  awarded.add(key);
  logger.info(`progression: advancement '${id}' awarded`);
  return true;
}

export function has(id) {
  return awarded.has(id);
}

// Polaroid craft detection: periodic inventory scan (no itemCrafted event)
let scanCount = 0;
export function begin(scheduler) {
  scheduler.every("tbs.progression_scan", 300, () => {
    scanCount++;
    for (const p of world.getAllPlayers()) {
      try {
        const inv = p.getComponent("minecraft:inventory")?.container;
        if (!inv) continue;
        for (let i = 0; i < inv.size; i++) {
          const item = inv.getItem(i);
          if (item && item.typeId === "thebrokenscript:polaroid") {
            award(p.id, "polaroid_craft");
            break;
          }
        }
      } catch {}
    }
    void scanCount;
  });

  // you_ve_brought_it_upon_yourself — damaging a boss counts (source trigger approx)
  try {
    world.afterEvents.entityHurt.subscribe((ev) => {
      try {
        const src = ev.damageSource?.damagingEntity;
        if (!src || src.typeId !== "minecraft:player") return;
        const t = ev.hurtEntity.typeId;
        if (
          t.startsWith("thebrokenscript:integrity_phase") ||
          t === "thebrokenscript:integrity_curious" ||
          t === "thebrokenscript:fractured" ||
          t === "thebrokenscript:the_obliteration" ||
          t === "thebrokenscript:the_obliteration_2"
        ) {
          award(src.id, "you_ve_brought_it_upon_yourself");
        }
      } catch {}
    });
  } catch {}
}
