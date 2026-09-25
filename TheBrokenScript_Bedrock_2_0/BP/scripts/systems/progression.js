import * as operationDiagnostics from "../core/operation_diagnostics.js";
import { world } from "@minecraft/server";
import { logger } from "../core/logging.js";
import { hasPersistedAdvancement, persistAdvancement } from "./progression_state.js";

// ── Chunk 13: progression (advancement approximations) ──────────────────────
// Bedrock has no custom advancements (A-006): award() = title + sound + chat
// line + per-player dynamic property. Source roster: TBSAdvancements.java.

export const ADVANCEMENTS = {
  can_someone_hear_me: "Go away",
  can_you_see_me: "Here I am.",
  nullnullnull: "nullnullnull",
  you_ve_brought_it_upon_yourself: "You've brought it upon yourself.",
  polaroid_craft: "Look at the bigger picture"
};

export const ADVANCEMENT_DESCRIPTIONS = {
  can_someone_hear_me: "This place is not for you.",
  can_you_see_me: "Can you see me?",
  nullnullnull: "nullnullnull",
  you_ve_brought_it_upon_yourself: "It was your fault.",
  polaroid_craft: "A memory."
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

  try {
    return hasPersistedAdvancement(player, id, awarded);
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

  try {
    if (!persistAdvancement(player, id, awarded)) return false;
  } catch (error) {
    logger.error(`progression: failed to persist advancement '${id}'`, error);
    return false;
  }

  try {
    player.playSound("random.levelup", { volume: 0.6 });
    player.onScreenDisplay.setTitle("§8Advancement Made§r §7— " + label, {
      fadeInDuration: 5, stayDuration: 50, fadeOutDuration: 10
    });
    const description = ADVANCEMENT_DESCRIPTIONS[id];
    if (description) player.sendMessage(`§7${description}`);
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.progression.js.75", "best-effort Bedrock API fallback", error);}

  logger.info(`progression: advancement '${id}' awarded to player ${player.id ?? player.name ?? "unknown"}`);
  return true;
}

// Compatibility wrapper: progression queries must be player-scoped. The old
// one-argument has(id) contract was ambiguous and could not reflect persistence.
export function has(playerOrId, maybeId) {
  if (maybeId === undefined) return false;
  return hasForPlayer(playerOrId, maybeId);
}

export function begin(scheduler) {
  void scheduler;

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
      } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.progression.js.125", "best-effort Bedrock API fallback", error);}
    });
  } catch (error) {
    logger.error("progression: failed to subscribe to entityHurt", error);
  }
}
