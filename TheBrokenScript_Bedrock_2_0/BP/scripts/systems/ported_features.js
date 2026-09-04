import { EntityComponentTypes, EntityDamageCause, GameMode, system, world } from "@minecraft/server";
import { ActionFormData } from "@minecraft/server-ui";
import { logger } from "../core/logging.js";
import * as playerState from "./player_state.js";
import * as worldState from "./world_state.js";
import { pageAt, pageBack, pageForward, selectAvailableBookId } from "./library_book_model.js";
import { nullInterfaceDefinition } from "./null_interface_model.js";
import { nulledGuiBody, nulledGuiDefinition } from "./nulled_gui_model.js";
import { fakeDisconnectDefinition } from "./fake_disconnect_model.js";
import { getLibraryBook, LIBRARY_BOOK_IDS } from "./library_book_data.js";
import {
  SOURCE_STATUS_EFFECTS,
  isStatusEffectActive,
  refreshStatusEffectExpiry,
} from "./status_effect_model.js";
import { enforceHeartCorruptionHealthCap } from "./status_effect_runtime.js";
import {
  HAND_CANNON_RANGE,
  circuitPaintingPlacement,
  firstHandCannonTarget,
  linkPortals,
  linkedPortal,
  portalKey,
} from "./ported_feature_logic.js";

const PORTAL_ANCHOR_PROPERTY = "tbs:portal_anchor_v1";
const PORTAL_LINKS_PROPERTY = "tbs:portal_links_v1";
const HEART_CORRUPTION_UNTIL = "tbs:heart_corruption_until";
const WHY_LEAVE_UNTIL = "tbs:why_leave_until";
const HAND_CANNON_COOLDOWN_TICKS = 4;
const cannonReadyAt = new Map();

export function init(itemComponentRegistry) {
  itemComponentRegistry.registerCustomComponent("thebrokenscript:hand_cannon_use", {
    onUse(event) {
      system.run(() => fireHandCannon(event.source));
    },
  });
  itemComponentRegistry.registerCustomComponent("thebrokenscript:polaroid_use", {
    onUse(event) {
      system.run(() => {
        void showPolaroid(event.source);
      });
    },
  });
  itemComponentRegistry.registerCustomComponent("thebrokenscript:library_book_use", {
    onUse(event) {
      system.run(() => {
        void showLibraryBook(event.source, event["itemStack"]);
      });
    },
  });
  itemComponentRegistry.registerCustomComponent("thebrokenscript:portal_linker_use", {
    onUseOn(event) {
      system.run(() => usePortalLinker(event.source, event.block));
    },
  });
  itemComponentRegistry.registerCustomComponent("thebrokenscript:desyncer_use", {
    onUse(event) {
      system.run(() => toggleDesync(event.source));
    },
  });
  itemComponentRegistry.registerCustomComponent("thebrokenscript:circuit_cave_place", {
    onUseOn(event) {
      system.run(() => placeCircuitPainting(event.source, event.block, event.blockFace));
    },
  });
  logger.info("ported_features: 6 item components registered");
}

export function begin(scheduler) {
  scheduler.every("ported_features.effects", 20, tickPortedEffects);
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
    target.applyDamage(25, {
      cause: EntityDamageCause.magic,
      damagingEntity: player,
    });
  } catch (err) {
    logger.error("ported_features: hand cannon raycast failed", err);
  }
  return true;
}

export async function showLibraryBook(player, itemStack = undefined) {
  if (!isPlayer(player)) return false;

  let storedId;
  try { storedId = itemStack?.getDynamicProperty?.("tbs:library_book_id"); } catch {}
  const bookId = selectAvailableBookId(storedId, Math.random(), LIBRARY_BOOK_IDS);
  try { itemStack?.setDynamicProperty?.("tbs:library_book_id", bookId); } catch {}

  const book = getLibraryBook(bookId);
  const totalPages = Math.max(1, book.pages.length);
  let currentPage = 0;

  try {
    while (true) {
      const actions = [];
      const form = new ActionFormData()
        .title("Library Book " + bookId + (book.author ? " - " + book.author : ""))
        .body(pageAt(book, currentPage + 1) || " ");

      if (currentPage > 0) {
        form.button("Previous");
        actions.push("back");
      }
      if (currentPage < totalPages - 1) {
        form.button("Next");
        actions.push("forward");
      }
      form.button("Close");
      actions.push("close");

      const response = await form.show(player);
      if (response.canceled || response.selection === undefined) return true;

      const action = actions[response.selection];
      if (action === "back") {
        currentPage = pageBack(currentPage);
      } else if (action === "forward") {
        currentPage = pageForward(currentPage, totalPages);
      } else {
        return true;
      }
      try { player.playSound("item.book.page_turn", { volume: 1.0, pitch: 1.1 }); } catch {}
    }
  } catch (err) {
    logger.error("ported_features: library book form failed", err);
    return false;
  }
}


export async function showNullInterface(player, index = 0) {
  if (!isPlayer(player)) return false;

  const view = nullInterfaceDefinition(index);
  try {
    await new ActionFormData()
      .title(view.title)
      .body(view.body)
      .button("Close")
      .show(player);
    return true;
  } catch (err) {
    logger.error("ported_features: null interface form failed", err);
    return false;
  }
}


export async function showNulledGui(player) {
  if (!isPlayer(player)) return false;

  const view = nulledGuiDefinition();
  try {
    await new ActionFormData()
      .title(view.title)
      .body(nulledGuiBody())
      .button("Close")
      .show(player);
    return true;
  } catch (err) {
    logger.error("ported_features: nulled gui form failed", err);
    return false;
  }
}


export async function showFakeDisconnect(player) {
  if (!isPlayer(player)) return false;

  const view = fakeDisconnectDefinition();
  try {
    await new ActionFormData()
      .title(view.heading)
      .body(view.body)
      .button(view.button)
      .show(player);
    return true;
  } catch (err) {
    logger.error("ported_features: fake disconnect form failed", err);
    return false;
  }
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

export function usePortalLinker(player, block) {
  if (!isPlayer(player) || block?.typeId !== "thebrokenscript:portal_controller") return false;
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

export function teleportLinkedPortal(player, block) {
  if (!isPlayer(player) || !block) return false;
  const destination = linkedPortal(readPortalLinks(), blockReference(block));
  if (!destination) return false;
  try {
    const dimension = world.getDimension(destination.dimensionId);
    player.teleport(
      { x: destination.x + 0.5, y: destination.y + 1.1, z: destination.z + 0.5 },
      { dimension },
    );
    player.onScreenDisplay.setTitle("§5LINK ESTABLISHED", {
      fadeInDuration: 0,
      stayDuration: 20,
      fadeOutDuration: 10,
    });
    try { player.playSound("travel", { volume: 1.0, pitch: 1.0 }); } catch {}
    return true;
  } catch (err) {
    logger.error("ported_features: linked portal teleport failed", err);
    return false;
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
  const until = refreshStatusEffectExpiry(
    player.getDynamicProperty(HEART_CORRUPTION_UNTIL),
    system.currentTick,
    duration,
  );
  player.setDynamicProperty(HEART_CORRUPTION_UNTIL, until);
  enforceHeartCorruptionHealthCap(player, EntityComponentTypes.Health);
  player.onScreenDisplay.setTitle("§d❤ §5ERR.HEALTH", {
    fadeInDuration: 0,
    stayDuration: 30,
    fadeOutDuration: 10,
  });
  return true;
}

export function applyWhyCantYouLeave(player, durationTicks = 1000) {
  if (!isPlayer(player)) return false;
  const until = refreshStatusEffectExpiry(
    player.getDynamicProperty(WHY_LEAVE_UNTIL),
    system.currentTick,
    durationTicks,
  );
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
  try {
    const painting = block.dimension.spawnEntity(
      "thebrokenscript:circuit_cave_painting",
      placement.location,
    );
    painting.setRotation({ x: 0, y: placement.yaw });
    consumeSelectedItem(player, "thebrokenscript:circuit_cave_painting");
    try { player.playSound("block.itemframe.add_item", { volume: 1.0, pitch: 1.0 }); } catch {}
    return true;
  } catch (err) {
    logger.error("ported_features: circuit painting placement failed", err);
    return false;
  }
}

function tickPortedEffects() {
  for (const player of world.getAllPlayers()) {
    const heartUntil = Number(player.getDynamicProperty(HEART_CORRUPTION_UNTIL) ?? 0);
    if (isStatusEffectActive(heartUntil, system.currentTick)) {
      enforceHeartCorruptionHealthCap(player, EntityComponentTypes.Health);
      try { player.onScreenDisplay.setActionBar("§d❤ §5ERR.HEALTH"); } catch {}
    }

    const leaveUntil = Number(player.getDynamicProperty(WHY_LEAVE_UNTIL) ?? 0);
    if (isStatusEffectActive(leaveUntil, system.currentTick)) {
      try {
        const head = player.getHeadLocation();
        player.dimension.spawnParticle(SOURCE_STATUS_EFFECTS.why_cant_you_leave.particleEffect, {
          x: head.x + (Math.random() - 0.5) * 1.8,
          y: head.y + (Math.random() - 0.5) * 0.8,
          z: head.z + (Math.random() - 0.5) * 1.8,
        });
      } catch {}
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
  return Math.max(1, Math.min(20_000_000, ticks));
}

function consumeSelectedItem(player, expectedTypeId) {
  try {
    if (player.getGameMode() === GameMode.Creative) return;
    const inventory = player.getComponent("minecraft:inventory")?.container;
    if (!inventory) return;
    const slot = player.selectedSlotIndex;
    const item = inventory.getItem(slot);
    if (!item || item.typeId !== expectedTypeId) return;
    if (item.amount <= 1) {
      inventory.setItem(slot);
      return;
    }
    item.amount -= 1;
    inventory.setItem(slot, item);
  } catch (err) {
    logger.error("ported_features: failed to consume placed painting", err);
  }
}

function isPlayer(entity) {
  return entity?.typeId === "minecraft:player";
}
