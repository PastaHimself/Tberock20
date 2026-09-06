import { world } from "@minecraft/server";
import { logger } from "../core/logging.js";
import { progressionCacheKey, progressionPropertyKey } from "./progression_state.js";

// ── Chunk 13: progression (advancement approximations) ──────────────────────
// Bedrock has no custom advancements (A-006): award() = title + sound + chat
// line + per-player dynamic property. Source roster: TBSAdvancements.java.

export const ADVANCEMENTS = {
  can_someone_hear_me: "Can Someone Hear Me?",
  can_you_see_me: "Can You See Me?",
  nullnullnull: "nullnullnull",
  you_ve_brought_it_upon_yourself: "You've Brought It Upon Yourself",
  polaroid_craft: "Say Cheese!"
};

const awarded = new Set();

function resolvePlayer(playerOrId) {
  if (!playerOrId) return null;
  if (typeof playerOrId !== "string") return playerOrId;
  try {
    return world.getEntity(playerOrId) ?? null;
  } catch (error) {
    logger.error(`progression: failed to resolve player '${playerOrId}'`, error);
    return null;
  }
}

export function hasForPlayer(playerOrId, id) {
  if (!ADVANCEMENTS[id]) return false;
  const player = resolvePlayer(playerOrId);
  if (!player) return false;

  const cacheKey = progressionCacheKey(player, id);
  if (cacheKey && awarded.has(cacheKey)) return true;

  try {
    const persisted = Boolean(player.getDynamicProperty(progressionPropertyKey(id)));
    if (persisted && cacheKey) awarded.add(cacheKey);
    return persisted;
  } catch (error) {
    logger.error(`progression: failed to read advancement '${id}'`, error);
    return false;
  }
}

export function award(playerOrId, id) {
  const label = ADVANCEMENTS[id];
  if (!label) return false;

  const player = resolvePlayer(playerOrId);
  if (!player) {
    logger.error(`progression: cannot award '${id}' without a valid player`);
    return false;
  }

  const cacheKey = progressionCacheKey(player, id);
  if (!cacheKey || hasForPlayer(player, id)) return false;

  try {
    player.setDynamicProperty(progressionPropertyKey(id), true);
  } catch (error) {
    logger.error(`progression: failed to persist advancement '${id}'`, error);
    return false;
  }

  awarded.add(cacheKey);
  try {
    player.playSound("random.levelup", { volume: 0.6 });
    player.onScreenDisplay.setTitle("§8Advancement Made§r §7— " + label, {
      fadeInDuration: 5, stayDuration: 50, fadeOutDuration: 10
    });
  } catch {}

  logger.info(`progression: advancement '${id}' awarded to player ${player.id ?? player.name ?? "unknown"}`);
  return true;
}

// Compatibility wrapper: progression queries must be player-scoped. The old
// one-argument has(id) contract was ambiguous and could not reflect persistence.
export function has(playerOrId, maybeId) {
  if (maybeId === undefined) return false;
  return hasForPlayer(playerOrId, maybeId);
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
            award(p, "polaroid_craft");
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
          award(src, "you_ve_brought_it_upon_yourself");
        }
      } catch {}
    });
  } catch (error) {
    logger.error("progression: failed to subscribe to entityHurt", error);
  }
}
