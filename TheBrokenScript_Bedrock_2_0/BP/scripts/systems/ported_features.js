import { EntityDamageCause, GameMode, system, world } from "@minecraft/server";
import { ActionFormData } from "@minecraft/server-ui";
import { logger } from "../core/logging.js";
import * as operationDiagnostics from "../core/operation_diagnostics.js";
import * as dimensions from "./dimensions.js";
import * as playerState from "./player_state.js";
import * as worldState from "./world_state.js";
import { applyDamageWithSource } from "./damage_source_runtime.js";
import {
  HAND_CANNON_RANGE,
  circuitPaintingPlacement,
  firstHandCannonTarget,
  aabbIntersectsPortal,
  canEnterPortal,
  isPortalReference,
  linkPortals,
  linkedPortal,
  portalBoundsSize,
  portalCooldownUntil,
  portalKey,
  portalTargetLocation,
  samePortalBoundsSize,
  samePortalDimension,
  unlinkPortal,
} from "./ported_feature_logic.js";

const PORTAL_ANCHOR_PROPERTY = "tbs:portal_anchor_v1";
const PORTAL_LINKS_PROPERTY = "tbs:portal_links_v1";
const PORTAL_COOLDOWN_PROPERTY = "tbs:portal_cooldown_until";
const PORTAL_COOLDOWN_TICKS = 1;
const PORTAL_CONTROLLER_ID = "thebrokenscript:portal_controller";
const PORTAL_EXTENDER_ID = "thebrokenscript:portal_extender";
const PORTAL_NEIGHBORS = [
  { x: 1, y: 0, z: 0 },
  { x: -1, y: 0, z: 0 },
  { x: 0, y: 1, z: 0 },
  { x: 0, y: -1, z: 0 },
  { x: 0, y: 0, z: 1 },
  { x: 0, y: 0, z: -1 },
];
const portalIncoming = new Map();
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
      operationDiagnostics.errorOnce(`ported_features.component.${name}`, `ported_features: item component '${name}' registration failed`, error);
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
  scheduler.every("ported_features.portals", 1, tickLinkedPortals);
  scheduler.every("ported_features.effects", 20, tickPortedEffects);
}

export function clearTransientPlayerState(player, initialSpawn = false) {
  if (!isPlayer(player) || !initialSpawn) return;
  for (const property of [PORTAL_ANCHOR_PROPERTY, PORTAL_COOLDOWN_PROPERTY, HEART_CORRUPTION_UNTIL, WHY_LEAVE_UNTIL]) {
    try { player.setDynamicProperty(property, undefined); } catch (error) {
      operationDiagnostics.warnOnce("ported_features.clear_transient", `ported_features: failed to clear '${property}'`, error);
    }
  }
}

export function fireHandCannon(player) {
  if (!isPlayer(player)) return false;
  const readyAt = cannonReadyAt.get(player.id) ?? 0;
  if (system.currentTick < readyAt) return false;
  cannonReadyAt.set(player.id, system.currentTick + HAND_CANNON_COOLDOWN_TICKS);

  try {
    player.playSound("tekkit.gun", { volume: 1.5, pitch: 1.0 });
  } catch (error) {
    operationDiagnostics.warnOnce("ported_features.cannon_sound", "ported_features: hand-cannon sound failed", error);
  }

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
    operationDiagnostics.errorOnce("ported_features.cannon_raycast", "ported_features: hand cannon raycast failed", err);
  }
  return true;
}

export async function showPolaroid(player) {
  if (!isPlayer(player)) return false;
  const code = String(worldState.get("code") || "NO SIGNAL");
  try {
    player.playSound("item.book.page_turn", { volume: 1.0, pitch: 1.5 });
  } catch (error) {
    operationDiagnostics.warnOnce("ported_features.polaroid_sound", "ported_features: polaroid page-turn sound failed", error);
  }
  try {
    await new ActionFormData()
      .title("§8The Polaroid")
      .body(`§0World code\n\n§l${code}§r\n\n§8Click anywhere to close.`)
      .button("Close", "textures/ui/tbs/polaroid")
      .show(player);
    return true;
  } catch (err) {
    operationDiagnostics.warnOnce("ported_features.polaroid_form", "ported_features: polaroid form failed", err);
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
    operationDiagnostics.warnOnce("ported_features.torn_paper_form", "ported_features: torn paper form failed", err);
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
      operationDiagnostics.warnOnce("ported_features.library_book_state", "ported_features: library book state write failed", err);
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
    operationDiagnostics.warnOnce("ported_features.library_book_form", "ported_features: library book form failed", err);
    return false;
  }
}

export function usePortalLinker(player, block) {
  if (!isPlayer(player) || block?.typeId !== PORTAL_CONTROLLER_ID) return false;
  if (player.isSneaking !== true) return false;
  const selected = blockReference(block);
  const previous = readPlayerJson(player, PORTAL_ANCHOR_PROPERTY);

  if (!previous) {
    try {
      player.setDynamicProperty(PORTAL_ANCHOR_PROPERTY, JSON.stringify(selected));
    } catch (error) {
      operationDiagnostics.errorOnce("ported_features.portal_anchor", "ported_features: portal anchor write failed", error);
      return false;
    }
    player.sendMessage("§5Portal A stored. Use the linker on another controller.");
    try { player.playSound("random.orb", { volume: 0.7, pitch: 0.8 }); } catch (error) {
      operationDiagnostics.warnOnce("ported_features.portal_anchor_sound", "ported_features: portal-anchor sound failed", error);
    }
    return true;
  }

  if (!isPortalReference(previous)) {
    clearPortalAnchor(player);
    player.sendMessage("§cStored portal anchor was invalid. Select Portal A again.");
    return false;
  }

  if (portalKey(previous) === portalKey(selected)) {
    clearPortalAnchor(player);
    player.sendMessage("§7Portal link canceled.");
    return false;
  }

  if (!samePortalDimension(previous, selected)) {
    clearPortalAnchor(player);
    player.sendMessage("§cPortals must be linked within the same dimension.");
    return false;
  }

  const previousController = resolvePortalController(previous);
  if (previousController.status !== "valid") {
    clearPortalAnchor(player);
    player.sendMessage("§cPortal A is no longer available. Select it again.");
    return false;
  }

  const links = linkPortals(readPortalLinks(), previous, selected);
  if (!writePortalLinks(links)) return false;
  clearPortalAnchor(player);

  player.sendMessage("§dPortal controllers linked.");
  try { player.playSound("travel", { volume: 1.0, pitch: 1.15 }); } catch (error) {
    operationDiagnostics.warnOnce("ported_features.portal_link_sound", "ported_features: portal-link sound failed", error);
  }
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

  const source = blockReference(block);
  let links = readPortalLinks();
  const destination = linkedPortal(links, source);
  if (!destination) return false;

  const reverse = isPortalReference(destination)
    ? linkedPortal(links, destination)
    : undefined;
  if (
    !isPortalReference(destination)
    || !samePortalDimension(source, destination)
    || !isPortalReference(reverse)
    || portalKey(reverse) !== portalKey(source)
  ) {
    links = unlinkPortal(links, source);
    writePortalLinks(links);
    return true;
  }

  const resolved = resolvePortalController(destination);
  if (resolved.status === "missing") {
    links = unlinkPortal(links, source);
    writePortalLinks(links);
    player.sendMessage("§7The linked portal no longer exists; the stale link was cleared.");
    return true;
  }
  if (resolved.status !== "valid") {
    operationDiagnostics.warnOnce(
      "ported_features.portal_destination_unavailable",
      "ported_features: linked portal controller is currently unavailable",
    );
    return true;
  }

  const reservation = portalCooldownUntil(currentTick, PORTAL_COOLDOWN_TICKS);
  try {
    player.setDynamicProperty(PORTAL_COOLDOWN_PROPERTY, reservation);
  } catch (error) {
    operationDiagnostics.errorOnce("ported_features.portal_cooldown", "ported_features: linked portal cooldown reservation failed", error);
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
    operationDiagnostics.errorOnce("ported_features.portal_destination", "ported_features: linked portal destination was not ready");
    return true;
  }

  try {
    player.onScreenDisplay.setTitle("§5LINK ESTABLISHED", {
      fadeInDuration: 0,
      stayDuration: 20,
      fadeOutDuration: 10,
    });
    try { player.playSound("travel", { volume: 1.0, pitch: 1.0 }); } catch (error) {
      operationDiagnostics.warnOnce("ported_features.portal_arrival_sound", "ported_features: portal-arrival sound failed", error);
    }
    return true;
  } catch (err) {
    operationDiagnostics.warnOnce("ported_features.portal_feedback", "ported_features: linked portal post-teleport feedback failed", err);
    return true;
  }
}

export function toggleDesync(player) {
  if (!isPlayer(player)) return false;
  const enabled = !playerState.get(player, "isDesync");
  playerState.set(player, "isDesync", enabled);
  if (enabled) {
    try { player.addEffect("nausea", 200, { amplifier: 1, showParticles: false }); } catch (error) {
      operationDiagnostics.warnOnce("ported_features.desync_nausea", "ported_features: desync nausea effect failed", error);
    }
    try { player.addEffect("darkness", 80, { amplifier: 0, showParticles: false }); } catch (error) {
      operationDiagnostics.warnOnce("ported_features.desync_darkness", "ported_features: desync darkness effect failed", error);
    }
    try { player.playSound("glitch_sound_1", { volume: 2.0, pitch: 0.75 }); } catch (error) {
      operationDiagnostics.warnOnce("ported_features.desync_sound", "ported_features: desync sound failed", error);
    }
    player.onScreenDisplay.setTitle("§kDESYNCING", {
      fadeInDuration: 0,
      stayDuration: 30,
      fadeOutDuration: 10,
    });
  } else {
    try { player.removeEffect("nausea"); } catch (error) {
      operationDiagnostics.warnOnce("ported_features.resync_nausea", "ported_features: resync nausea cleanup failed", error);
    }
    try { player.removeEffect("darkness"); } catch (error) {
      operationDiagnostics.warnOnce("ported_features.resync_darkness", "ported_features: resync darkness cleanup failed", error);
    }
    try {
      player.teleport(player.location, {
        dimension: player.dimension,
        rotation: player.getRotation(),
      });
    } catch (error) {
      operationDiagnostics.warnOnce("ported_features.desync_teleport", "ported_features: desync resync teleport failed", error);
    }
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
  try { player.setDynamicProperty(HEART_CORRUPTION_UNTIL, until); } catch (error) {
    operationDiagnostics.errorOnce("ported_features.heart_state", "ported_features: heart-corruption state write failed", error);
    return false;
  }
  try {
    player.applyDamage(1, {
      cause: EntityDamageCause.magic,
    });
  } catch (error) {
    operationDiagnostics.warnOnce("ported_features.heart_damage", "ported_features: heart-corruption damage failed", error);
  }
  try {
    player.onScreenDisplay.setTitle("§d❤ §5ERR.HEALTH", {
      fadeInDuration: 0,
      stayDuration: 30,
      fadeOutDuration: 10,
    });
  } catch (error) {
    operationDiagnostics.warnOnce("ported_features.heart_title", "ported_features: heart-corruption title failed", error);
  }
  return true;
}

export function applyWhyCantYouLeave(player, durationTicks = 1000) {
  if (!isPlayer(player)) return false;
  const until = system.currentTick + finiteDuration(durationTicks);
  try {
    player.setDynamicProperty(WHY_LEAVE_UNTIL, until);
  } catch (error) {
    operationDiagnostics.errorOnce("ported_features.why_leave_state", "ported_features: why-cant-you-leave state write failed", error);
    return false;
  }
  try {
    player.onScreenDisplay.setTitle("§fwhy can't you leave?", {
      fadeInDuration: 0,
      stayDuration: 50,
      fadeOutDuration: 10,
    });
  } catch (error) {
    operationDiagnostics.warnOnce("ported_features.why_leave_title", "ported_features: why-cant-you-leave title failed", error);
  }
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
    operationDiagnostics.errorOnce("ported_features.painting_snapshot", "ported_features: circuit painting item snapshot failed", error);
    return false;
  }
  let creative = false;
  try { creative = player.getGameMode() === GameMode.Creative; } catch (error) {
    operationDiagnostics.warnOnce("ported_features.painting_gamemode", "ported_features: painting game-mode query failed; preserving survival fallback", error);
  }
  if (!creative && !consumeSelectedItem(player, "thebrokenscript:circuit_cave_painting")) return false;

  let painting;
  try {
    painting = block.dimension.spawnEntity(
      "thebrokenscript:circuit_cave_painting",
      placement.location,
    );
    painting.setRotation({ x: 0, y: placement.yaw });
    try { player.playSound("block.itemframe.add_item", { volume: 1.0, pitch: 1.0 }); } catch (error) {
      operationDiagnostics.warnOnce("ported_features.painting_sound", "ported_features: circuit painting sound failed", error);
    }
    return true;
  } catch (err) {
    try { painting?.remove(); } catch (error) {
      operationDiagnostics.warnOnce("ported_features.painting_remove", "ported_features: failed to remove partial circuit painting", error);
    }
    try { selected.inventory.setItem(selected.slot, original); } catch (restoreError) {
      operationDiagnostics.errorOnce("ported_features.painting_restore", "ported_features: circuit painting item restore failed", restoreError);
    }
    operationDiagnostics.errorOnce("ported_features.painting_place", "ported_features: circuit painting placement failed", err);
    return false;
  }
}

function tickLinkedPortals() {
  let links = readPortalLinks();
  let dirty = false;
  const visited = new Set();

  for (const [sourceKey, destination] of Object.entries(links)) {
    if (visited.has(sourceKey)) continue;
    if (!isPortalReference(destination)) {
      delete links[sourceKey];
      dirty = true;
      continue;
    }

    const destinationKey = portalKey(destination);
    const source = links[destinationKey];
    if (!isPortalReference(source) || portalKey(source) !== sourceKey) {
      delete links[sourceKey];
      dirty = true;
      continue;
    }

    visited.add(sourceKey);
    visited.add(destinationKey);

    if (!samePortalDimension(source, destination)) {
      links = unlinkPortal(links, source);
      portalIncoming.delete(sourceKey);
      portalIncoming.delete(destinationKey);
      dirty = true;
      continue;
    }

    const sourceController = resolvePortalController(source);
    const destinationController = resolvePortalController(destination);
    if (sourceController.status === "missing" || destinationController.status === "missing") {
      links = unlinkPortal(links, source);
      portalIncoming.delete(sourceKey);
      portalIncoming.delete(destinationKey);
      dirty = true;
      continue;
    }
    if (sourceController.status !== "valid" || destinationController.status !== "valid") continue;

    const sourceBounds = collectPortalBounds(sourceController.block);
    const destinationBounds = collectPortalBounds(destinationController.block);
    if (!samePortalBoundsSize(sourceBounds, destinationBounds)) continue;

    processPortalPair(
      sourceKey,
      destinationKey,
      sourceController.block,
      destinationController.block,
      sourceBounds,
      destinationBounds,
    );
  }

  if (dirty) writePortalLinks(links);
}

function processPortalPair(sourceKey, destinationKey, sourceBlock, destinationBlock, sourceBounds, destinationBounds) {
  const sourceIncoming = new Set(portalIncoming.get(sourceKey) ?? []);
  const destinationIncoming = new Set(portalIncoming.get(destinationKey) ?? []);

  processPortalEntities(
    entitiesInPortal(sourceBlock.dimension, sourceBounds, true),
    sourceBounds,
    destinationBounds,
    sourceIncoming,
    destinationIncoming,
  );
  processPortalEntities(
    entitiesInPortal(destinationBlock.dimension, destinationBounds, true),
    destinationBounds,
    sourceBounds,
    destinationIncoming,
    sourceIncoming,
  );

  portalIncoming.set(
    sourceKey,
    new Set(entitiesInPortal(sourceBlock.dimension, sourceBounds, false).map((entity) => entity.id)),
  );
  portalIncoming.set(
    destinationKey,
    new Set(entitiesInPortal(destinationBlock.dimension, destinationBounds, false).map((entity) => entity.id)),
  );
}

function processPortalEntities(entities, sourceBounds, destinationBounds, sourceIncoming, destinationIncoming) {
  for (const entity of entities) {
    if (sourceIncoming.has(entity.id)) continue;
    destinationIncoming.add(entity.id);

    try {
      const isPassenger = Boolean(entity.getComponent("minecraft:riding"));
      entity.teleport(
        portalTargetLocation(sourceBounds, destinationBounds, entity.location, isPassenger),
        {
          rotation: entity.getRotation(),
          keepVelocity: true,
        },
      );
    } catch (error) {
      operationDiagnostics.warnOnce(
        "ported_features.portal_tick_teleport",
        "ported_features: source-backed portal entity teleport failed",
        error,
      );
    }
  }
}

function entitiesInPortal(dimension, bounds, livingOnly) {
  let entities;
  try {
    entities = dimension.getEntities({
      location: bounds.min,
      volume: portalBoundsSize(bounds),
    });
  } catch (error) {
    operationDiagnostics.warnOnce(
      "ported_features.portal_entity_query",
      "ported_features: portal entity query failed",
      error,
    );
    return [];
  }

  return entities.filter((entity) => {
    try {
      if (livingOnly && !entity.getComponent("minecraft:health")) return false;
      return aabbIntersectsPortal(entity.getAABB(), bounds);
    } catch (error) {
      operationDiagnostics.warnOnce(
        "ported_features.portal_entity_bounds",
        "ported_features: portal entity bounds query failed",
        error,
      );
      return false;
    }
  });
}

function collectPortalBounds(controller) {
  const origin = integerLocation(controller.location);
  const min = { ...origin };
  const max = { x: origin.x + 1, y: origin.y + 1, z: origin.z + 1 };
  const queue = [origin];
  const visited = new Set([blockLocationKey(origin)]);

  for (let cursor = 0; cursor < queue.length; cursor += 1) {
    const current = queue[cursor];
    for (const offset of PORTAL_NEIGHBORS) {
      const next = {
        x: current.x + offset.x,
        y: current.y + offset.y,
        z: current.z + offset.z,
      };
      const key = blockLocationKey(next);
      if (visited.has(key)) continue;
      visited.add(key);

      let block;
      try {
        block = controller.dimension.getBlock(next);
      } catch {
        continue;
      }
      if (!block || block.typeId !== PORTAL_EXTENDER_ID) continue;

      queue.push(next);
      min.x = Math.min(min.x, next.x);
      min.y = Math.min(min.y, next.y);
      min.z = Math.min(min.z, next.z);
      max.x = Math.max(max.x, next.x + 1);
      max.y = Math.max(max.y, next.y + 1);
      max.z = Math.max(max.z, next.z + 1);
    }
  }

  return { min, max };
}

function resolvePortalController(reference) {
  if (!isPortalReference(reference)) return { status: "missing" };

  const dimension = dimensions.get(reference.dimensionId);
  if (!dimension) return { status: "unavailable" };

  try {
    const block = dimension.getBlock(reference);
    if (!block) return { status: "unavailable" };
    if (block.typeId !== PORTAL_CONTROLLER_ID) return { status: "missing" };
    return { status: "valid", block };
  } catch {
    return { status: "unavailable" };
  }
}

function writePortalLinks(links) {
  try {
    world.setDynamicProperty(PORTAL_LINKS_PROPERTY, JSON.stringify(links));
    return true;
  } catch (error) {
    operationDiagnostics.errorOnce("ported_features.portal_link", "ported_features: portal-link state write failed", error);
    return false;
  }
}

function clearPortalAnchor(player) {
  try {
    player.setDynamicProperty(PORTAL_ANCHOR_PROPERTY, undefined);
  } catch (error) {
    operationDiagnostics.warnOnce("ported_features.portal_anchor_clear", "ported_features: portal anchor state clear failed", error);
  }
}

function integerLocation(location) {
  return {
    x: Math.floor(location.x),
    y: Math.floor(location.y),
    z: Math.floor(location.z),
  };
}

function blockLocationKey(location) {
  return location.x + "," + location.y + "," + location.z;
}

function clearPortalReservation(player, reservation) {
  try {
    const current = Number(player.getDynamicProperty(PORTAL_COOLDOWN_PROPERTY) ?? 0);
    if (current === reservation) player.setDynamicProperty(PORTAL_COOLDOWN_PROPERTY, undefined);
  } catch (error) {
    operationDiagnostics.warnOnce("ported_features.portal_reservation_clear", "ported_features: portal cooldown cleanup failed", error);
  }
}

function tickPortedEffects() {
  for (const player of world.getAllPlayers()) {
    const heartUntil = Number(player.getDynamicProperty(HEART_CORRUPTION_UNTIL) ?? 0);
    if (heartUntil > system.currentTick) {
      try { player.onScreenDisplay.setActionBar("§d❤ §5ERR.HEALTH"); } catch (error) {
        operationDiagnostics.warnOnce("ported_features.heart_actionbar", "ported_features: heart-corruption action bar failed", error);
      }
    } else if (heartUntil > 0) {
      try { player.setDynamicProperty(HEART_CORRUPTION_UNTIL, undefined); } catch (error) {
        operationDiagnostics.warnOnce("ported_features.heart_expiry", "ported_features: heart-corruption expiry cleanup failed", error);
      }
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
      } catch (error) {
        operationDiagnostics.warnOnce("ported_features.why_leave_particle", "ported_features: why-cant-you-leave particle failed", error);
      }
    } else if (leaveUntil > 0) {
      try { player.setDynamicProperty(WHY_LEAVE_UNTIL, undefined); } catch (error) {
        operationDiagnostics.warnOnce("ported_features.why_leave_expiry", "ported_features: why-cant-you-leave expiry cleanup failed", error);
      }
    }

    const cooldownUntil = Number(player.getDynamicProperty(PORTAL_COOLDOWN_PROPERTY) ?? 0);
    if (cooldownUntil > 0 && cooldownUntil <= system.currentTick) {
      try { player.setDynamicProperty(PORTAL_COOLDOWN_PROPERTY, undefined); } catch (error) {
        operationDiagnostics.warnOnce("ported_features.cooldown_expiry", "ported_features: portal cooldown expiry cleanup failed", error);
      }
    }
  }
}

function readPortalLinks() {
  const raw = world.getDynamicProperty(PORTAL_LINKS_PROPERTY);
  if (typeof raw !== "string") return {};
  try {
    const value = JSON.parse(raw);
    return value && typeof value === "object" ? value : {};
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.ported_features.js.514", "best-effort Bedrock API fallback", error);
    return {};
  }
}

function readPlayerJson(player, key) {
  const raw = player.getDynamicProperty(key);
  if (typeof raw !== "string") return undefined;
  try {
    return JSON.parse(raw);
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.ported_features.js.524", "best-effort Bedrock API fallback", error);
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
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.ported_features.js.574", "best-effort Bedrock API fallback", error);
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
