import { EntityDamageCause, GameMode, system, world } from "@minecraft/server";
import { ActionFormData } from "@minecraft/server-ui";
import { logger } from "../core/logging.js";
import * as dimensions from "./dimensions.js";
import * as playerState from "./player_state.js";
import * as worldState from "./world_state.js";
import { applyDamageWithSource } from "./damage_source_runtime.js";
import {
  HAND_CANNON_RANGE,
  circuitPaintingPlacement,
  firstHandCannonTarget,
  linkPortals,
  linkedPortal,
  canEnterPortal,
  portalCooldownUntil,
  portalKey,
} from "./ported_feature_logic.js";

const PORTAL_ANCHOR_PROPERTY = "tbs:portal_anchor_v1";
const PORTAL_LINKS_PROPERTY = "tbs:portal_links_v1";
const PORTAL_COOLDOWN_PROPERTY = "tbs:portal_cooldown_until";
const PORTAL_COOLDOWN_TICKS = 1;
const LIBRARY_BOOK_NUMBER_PROPERTY = "thebrokenscript:library_book_num";
const HEART_CORRUPTION_UNTIL = "tbs:heart_corruption_until";
const WHY_LEAVE_UNTIL = "tbs:why_leave_until";
const HAND_CANNON_COOLDOWN_TICKS = 4;
const LIBRARY_BOOK_MAX_ID = 250;
const cannonReadyAt = new Map();
const registered = [];

export function init(itemComponentRegistry) {
  function register(name, handlers) {
    try {
      itemComponentRegistry.registerCustomComponent(name, handlers);
      registered.push(name);
    } catch (error) {
      logger.error(`ported_features: item component '${name}' registration failed`, error);
    }
  }

  register("thebrokenscript:hand_cannon_use", {
    onUse(event) {
      system.run(() => fireHandCannon(event.source));
    },
  });
  register("thebrokenscript:polaroid_use", {
    onUse(event) {
      system.run(() => {
        void showPolaroid(event.source);
      });
    },
  });
  register("thebrokenscript:portal_linker_use", {
    onUseOn(event) {
      system.run(() => usePortalLinker(event.source, event.block));
    },
  });
  register("thebrokenscript:desyncer_use", {
    onUse(event) {
      system.run(() => toggleDesync(event.source));
    },
  });
  register("thebrokenscript:circuit_cave_place", {
    onUseOn(event) {
      system.run(() => placeCircuitPainting(event.source, event.block, event.blockFace));
    },
  });
  register("thebrokenscript:revuxorfish_consume", {
    onConsume(event) {
      applyFoodEffect(event.source, "minecraft:wither", 240, 4);
    },
  });
  register("thebrokenscript:faraway_salmon_consume", {
    onConsume(event) {
      applyFoodEffect(event.source, "minecraft:instant_damage", 2, 5);
      applyFoodEffect(event.source, "minecraft:wither", 1000, 100);
    },
  });
  register("thebrokenscript:n_use", {
    onUse(event) {
      system.run(() => consumeSelectedItem(event.source, "thebrokenscript:n"));
    },
  });
  register("thebrokenscript:gore_use", {
    onUse(event) {
      system.run(() => consumeSelectedItem(event.source, "thebrokenscript:gore"));
    },
  });
  register("thebrokenscript:torn_paper_use", {
    onUse(event) {
      system.run(() => void showTornPaper(event.source));
    },
  });
  register("thebrokenscript:library_book_use", {
    onUse(event) {
      system.run(() => void showLibraryBook(event.source));
    },
  });
  logger.info(`ported_features: ${registered.length}/11 item components registered`);
}

export function begin(scheduler) {
  scheduler.every("ported_features.effects", 20, tickPortedEffects);
}

export function clearTransientPlayerState(player, initialSpawn = false) {
  if (!isPlayer(player) || !initialSpawn) return;
  for (const property of [PORTAL_ANCHOR_PROPERTY, PORTAL_COOLDOWN_PROPERTY, HEART_CORRUPTION_UNTIL, WHY_LEAVE_UNTIL]) {
    try { player.setDynamicProperty(property, undefined); } catch {}
  }
}

export function fireHandCannon(player) {
  if (!isPlayer(player)) return false;
  const readyAt = cannonReadyAt.get(player.id) ?? 0;
  if (system.currentTick < readyAt) return false;
  cannonReadyAt.set(player.id, system.currentTick + HAND_CANNON_COOLDOWN_TICKS);

  try {
    player.playSound("tekkit.gun", { volume: 1.5, pitch: 1.0 });
  } catch {}

  try {
    const hits = player.getEntitiesFromViewDirection({
      maxDistance: HAND_CANNON_RANGE,
      ignoreBlockCollision: false,
    });
    const target = firstHandCannonTarget(hits, player.id);
    if (!target) return true;
    applyDamageWithSource(target, 25, "thebrokenscript:hand_cannon_damage", {
      cause: EntityDamageCause.magic,
      damagingEntity: player,
    });
  } catch (err) {
    logger.error("ported_features: hand cannon raycast failed", err);
  }
  return true;
}

export async function showPolaroid(player) {
  if (!isPlayer(player)) return false;
  const code = String(worldState.get("code") || "NO SIGNAL");
  try {
    player.playSound("item.book.page_turn", { volume: 1.0, pitch: 1.5 });
  } catch {}
  try {
    await new ActionFormData()
      .title("§8The Polaroid")
      .body(`§0World code\n\n§l${code}§r\n\n§8Click anywhere to close.`)
      .button("Close", "textures/ui/tbs/polaroid")
      .show(player);
    return true;
  } catch (err) {
    logger.error("ported_features: polaroid form failed", err);
    return false;
  }
}

export async function showTornPaper(player) {
  if (!isPlayer(player)) return false;
  try {
    player.playSound("item.book.page_turn", { volume: 1.0, pitch: 1.5 });
    await new ActionFormData()
      .title("§fTorn Paper")
      .body("§7The paper is torn and cannot be read.")
      .button("Close")
      .show(player);
    return true;
  } catch (err) {
    logger.error("ported_features: torn paper form failed", err);
    return false;
  }
}

export async function showLibraryBook(player) {
  if (!isPlayer(player)) return false;
  const selected = selectedItem(player, "thebrokenscript:book");
  if (!selected) return false;

  let bookNumber = Number(selected.item.getDynamicProperty(LIBRARY_BOOK_NUMBER_PROPERTY));
  if (!Number.isInteger(bookNumber) || bookNumber < 1 || bookNumber > LIBRARY_BOOK_MAX_ID) {
    bookNumber = 1 + Math.floor(Math.random() * LIBRARY_BOOK_MAX_ID);
    try {
      // ItemStack dynamic properties are supported only on non-stackable items;
      // book.json therefore pins this item to a one-item stack.
      selected.item.setDynamicProperty(LIBRARY_BOOK_NUMBER_PROPERTY, bookNumber);
      selected.inventory.setItem(selected.slot, selected.item);
    } catch (err) {
      logger.error("ported_features: library book state write failed", err);
    }
  }

  try {
    player.playSound("item.book.page_turn", { volume: 1.0, pitch: 1.2 });
    await new ActionFormData()
      .title("§8Library Book")
      .body(`§7Source library book #${bookNumber}\n\n§8The full Java book screen is represented by this stable Bedrock form adapter.`)
      .button("Close")
      .show(player);
    return true;
  } catch (err) {
    logger.error("ported_features: library book form failed", err);
    return false;
  }
}

export function usePortalLinker(player, block) {
  if (!isPlayer(player) || block?.typeId !== "thebrokenscript:portal_controller") return false;
  if (player.isSneaking !== true) return false;
  const selected = blockReference(block);
  const previous = readPlayerJson(player, PORTAL_ANCHOR_PROPERTY);

  if (!previous) {
    player.setDynamicProperty(PORTAL_ANCHOR_PROPERTY, JSON.stringify(selected));
    player.sendMessage("§5Portal A stored. Use the linker on another controller.");
    try { player.playSound("random.orb", { volume: 0.7, pitch: 0.8 }); } catch {}
    return true;
  }

  if (portalKey(previous) === portalKey(selected)) {
    player.setDynamicProperty(PORTAL_ANCHOR_PROPERTY, undefined);
    player.sendMessage("§7Portal link canceled.");
    return false;
  }

  const links = linkPortals(readPortalLinks(), previous, selected);
  world.setDynamicProperty(PORTAL_LINKS_PROPERTY, JSON.stringify(links));
  player.setDynamicProperty(PORTAL_ANCHOR_PROPERTY, undefined);
  player.sendMessage("§dPortal controllers linked.");
  try { player.playSound("travel", { volume: 1.0, pitch: 1.15 }); } catch {}
  return true;
}

export function portalCooldownActive(player) {
  if (!isPlayer(player)) return false;
  const currentTick = Number(system.currentTick ?? 0);
  const cooldownUntil = Number(player.getDynamicProperty(PORTAL_COOLDOWN_PROPERTY) ?? 0);
  return !canEnterPortal(currentTick, cooldownUntil);
}

export function hasLinkedPortal(block) {
  if (!block) return false;
  return Boolean(linkedPortal(readPortalLinks(), blockReference(block)));
}

export async function teleportLinkedPortal(player, block) {
  if (!isPlayer(player) || !block) return false;
  const currentTick = Number(system.currentTick ?? 0);
  const cooldownUntil = Number(player.getDynamicProperty(PORTAL_COOLDOWN_PROPERTY) ?? 0);
  if (!canEnterPortal(currentTick, cooldownUntil)) return false;
  const destination = linkedPortal(readPortalLinks(), blockReference(block));
  if (!destination) return false;

  // Reserve the one-tick bounce guard before awaiting dimension preparation.
  // This makes two same-tick interactions observe the same persisted lock.
  const reservation = portalCooldownUntil(currentTick, PORTAL_COOLDOWN_TICKS);
  try {
    player.setDynamicProperty(PORTAL_COOLDOWN_PROPERTY, reservation);
  } catch (error) {
    logger.error("ported_features: linked portal cooldown reservation failed", error);
    return true;
  }

  const teleported = await dimensions.teleportWhenReady(
    player,
    destination.dimensionId,
    {
      x: destination.x + 0.5,
      y: destination.y + 1.1,
      z: destination.z + 0.5,
    },
  );
  if (!teleported) {
    clearPortalReservation(player, reservation);
    logger.error("ported_features: linked portal destination was not ready");
    // A linked controller was handled, so its failure must not fall through to
    // the unlinked clan_void destination.
    return true;
  }

  try {
    player.onScreenDisplay.setTitle("§5LINK ESTABLISHED", {
      fadeInDuration: 0,
      stayDuration: 20,
      fadeOutDuration: 10,
    });
    try { player.playSound("travel", { volume: 1.0, pitch: 1.0 }); } catch {}
    return true;
  } catch (err) {
    logger.error("ported_features: linked portal post-teleport feedback failed", err);
    return true;
  }
}

export function toggleDesync(player) {
  if (!isPlayer(player)) return false;
  const enabled = !playerState.get(player, "isDesync");
  playerState.set(player, "isDesync", enabled);
  if (enabled) {
    try { player.addEffect("nausea", 200, { amplifier: 1, showParticles: false }); } catch {}
    try { player.addEffect("darkness", 80, { amplifier: 0, showParticles: false }); } catch {}
    try { player.playSound("glitch_sound_1", { volume: 2.0, pitch: 0.75 }); } catch {}
    player.onScreenDisplay.setTitle("§kDESYNCING", {
      fadeInDuration: 0,
      stayDuration: 30,
      fadeOutDuration: 10,
    });
  } else {
    try { player.removeEffect("nausea"); } catch {}
    try { player.removeEffect("darkness"); } catch {}
    try {
      player.teleport(player.location, {
        dimension: player.dimension,
        rotation: player.getRotation(),
      });
    } catch {}
    player.onScreenDisplay.setTitle("§aRESYNCED", {
      fadeInDuration: 0,
      stayDuration: 20,
      fadeOutDuration: 10,
    });
  }
  return enabled;
}

export function applyHeartCorruption(player, durationTicks = 200) {
  if (!isPlayer(player)) return false;
  const duration = finiteDuration(durationTicks);
  const until = Math.max(
    Number(player.getDynamicProperty(HEART_CORRUPTION_UNTIL) ?? 0),
    system.currentTick + duration,
  );
  player.setDynamicProperty(HEART_CORRUPTION_UNTIL, until);
  try {
    player.applyDamage(1, {
      cause: EntityDamageCause.magic,
    });
  } catch {}
  player.onScreenDisplay.setTitle("§d❤ §5ERR.HEALTH", {
    fadeInDuration: 0,
    stayDuration: 30,
    fadeOutDuration: 10,
  });
  return true;
}

export function applyWhyCantYouLeave(player, durationTicks = 1000) {
  if (!isPlayer(player)) return false;
  const until = system.currentTick + finiteDuration(durationTicks);
  player.setDynamicProperty(WHY_LEAVE_UNTIL, until);
  player.onScreenDisplay.setTitle("§fwhy can't you leave?", {
    fadeInDuration: 0,
    stayDuration: 50,
    fadeOutDuration: 10,
  });
  return true;
}

function placeCircuitPainting(player, block, face) {
  if (!isPlayer(player) || !block) return false;
  const placement = circuitPaintingPlacement(block.location, face);
  if (!placement) {
    player.sendMessage("§cCircuit Cave must be placed on a wall.");
    return false;
  }
  const selected = selectedItem(player, "thebrokenscript:circuit_cave_painting");
  if (!selected) return false;
  let original;
  try {
    original = selected.item.clone();
  } catch (error) {
    logger.error("ported_features: circuit painting item snapshot failed", error);
    return false;
  }
  let creative = false;
  try { creative = player.getGameMode() === GameMode.Creative; } catch {}
  if (!creative && !consumeSelectedItem(player, "thebrokenscript:circuit_cave_painting")) return false;

  let painting;
  try {
    painting = block.dimension.spawnEntity(
      "thebrokenscript:circuit_cave_painting",
      placement.location,
    );
    painting.setRotation({ x: 0, y: placement.yaw });
    try { player.playSound("block.itemframe.add_item", { volume: 1.0, pitch: 1.0 }); } catch {}
    return true;
  } catch (err) {
    try { painting?.remove(); } catch {}
    try { selected.inventory.setItem(selected.slot, original); } catch (restoreError) {
      logger.error("ported_features: circuit painting item restore failed", restoreError);
    }
    logger.error("ported_features: circuit painting placement failed", err);
    return false;
  }
}

function clearPortalReservation(player, reservation) {
  try {
    const current = Number(player.getDynamicProperty(PORTAL_COOLDOWN_PROPERTY) ?? 0);
    if (current === reservation) player.setDynamicProperty(PORTAL_COOLDOWN_PROPERTY, undefined);
  } catch {}
}

function tickPortedEffects() {
  for (const player of world.getAllPlayers()) {
    const heartUntil = Number(player.getDynamicProperty(HEART_CORRUPTION_UNTIL) ?? 0);
    if (heartUntil > system.currentTick) {
      try { player.onScreenDisplay.setActionBar("§d❤ §5ERR.HEALTH"); } catch {}
    } else if (heartUntil > 0) {
      try { player.setDynamicProperty(HEART_CORRUPTION_UNTIL, undefined); } catch {}
    }

    const leaveUntil = Number(player.getDynamicProperty(WHY_LEAVE_UNTIL) ?? 0);
    if (leaveUntil > system.currentTick) {
      try {
        const head = player.getHeadLocation();
        player.dimension.spawnParticle("thebrokenscript:eyes", {
          x: head.x + (Math.random() - 0.5) * 1.8,
          y: head.y + (Math.random() - 0.5) * 0.8,
          z: head.z + (Math.random() - 0.5) * 1.8,
        });
      } catch {}
    } else if (leaveUntil > 0) {
      try { player.setDynamicProperty(WHY_LEAVE_UNTIL, undefined); } catch {}
    }

    const cooldownUntil = Number(player.getDynamicProperty(PORTAL_COOLDOWN_PROPERTY) ?? 0);
    if (cooldownUntil > 0 && cooldownUntil <= system.currentTick) {
      try { player.setDynamicProperty(PORTAL_COOLDOWN_PROPERTY, undefined); } catch {}
    }
  }
}

function readPortalLinks() {
  const raw = world.getDynamicProperty(PORTAL_LINKS_PROPERTY);
  if (typeof raw !== "string") return {};
  try {
    const value = JSON.parse(raw);
    return value && typeof value === "object" ? value : {};
  } catch {
    return {};
  }
}

function readPlayerJson(player, key) {
  const raw = player.getDynamicProperty(key);
  if (typeof raw !== "string") return undefined;
  try {
    return JSON.parse(raw);
  } catch {
    return undefined;
  }
}

function blockReference(block) {
  return {
    dimensionId: block.dimension.id,
    x: Math.floor(block.location.x),
    y: Math.floor(block.location.y),
    z: Math.floor(block.location.z),
  };
}

function finiteDuration(value) {
  const ticks = Math.floor(Number(value));
  if (!Number.isFinite(ticks)) return 1;
  // audit: Bedrock safety cap; no Java literal equivalent is available for this API guard.
  return Math.max(1, Math.min(20_000_000, ticks));
}

function consumeSelectedItem(player, expectedTypeId) {
  try {
    if (player.getGameMode() === GameMode.Creative) return false;
    const inventory = player.getComponent("minecraft:inventory")?.container;
    if (!inventory) return false;
    const slot = player.selectedSlotIndex;
    const item = inventory.getItem(slot);
    if (!item || item.typeId !== expectedTypeId) return false;
    if (item.amount <= 1) {
      inventory.setItem(slot);
      return true;
    }
    item.amount -= 1;
    inventory.setItem(slot, item);
    return true;
  } catch (err) {
    logger.error(`ported_features: failed to consume ${expectedTypeId}`, err);
    return false;
  }
}

function selectedItem(player, expectedTypeId) {
  try {
    const inventory = player.getComponent("minecraft:inventory")?.container;
    if (!inventory) return undefined;
    const slot = player.selectedSlotIndex;
    const item = inventory.getItem(slot);
    if (!item || item.typeId !== expectedTypeId) return undefined;
    return { inventory, item, slot };
  } catch {
    return undefined;
  }
}

function applyFoodEffect(player, effectId, duration, amplifier) {
  if (!isPlayer(player)) return false;
  try {
    player.addEffect(effectId, duration, { amplifier, showParticles: true });
    return true;
  } catch (err) {
    logger.error(`ported_features: ${effectId} food effect failed`, err);
    return false;
  }
}

function isPlayer(entity) {
  return entity?.typeId === "minecraft:player";
}
