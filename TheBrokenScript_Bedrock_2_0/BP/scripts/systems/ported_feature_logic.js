import * as operationDiagnostics from "../core/operation_diagnostics.js";
export const HAND_CANNON_RANGE = 100;
export const PORTAL_COOLDOWN_TICKS = 1;

export function canEnterPortal(currentTick, cooldownUntil) {
  return Number(currentTick) >= Number(cooldownUntil ?? 0);
}

export function portalCooldownUntil(currentTick, cooldownTicks = PORTAL_COOLDOWN_TICKS) {
  return Number(currentTick) + Math.max(1, Math.floor(Number(cooldownTicks)));
}

export function firstHandCannonTarget(hits, shooterId) {
  for (const hit of hits ?? []) {
    if (!hit?.entity || hit.entity.id === shooterId) continue;
    if (isSpectatorPlayer(hit.entity)) continue;
    if (typeof hit.distance === "number" && hit.distance > HAND_CANNON_RANGE) continue;
    return hit.entity;
  }
  return undefined;
}

function isSpectatorPlayer(entity) {
  if (entity?.typeId !== "minecraft:player" || typeof entity.getGameMode !== "function") {
    return false;
  }
  try {
    return entity.getGameMode() === "Spectator";
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.ported_feature_logic.js.28", "best-effort Bedrock API fallback", error);
    return false;
  }
}

export function circuitPaintingPlacement(block, face) {
  const key = String(face).toLowerCase();
  const center = { x: block.x + 0.5, y: block.y, z: block.z + 0.5 };
  switch (key) {
    case "north":
      return { location: { ...center, z: block.z - 0.51 }, yaw: 180 };
    case "south":
      return { location: { ...center, z: block.z + 1.51 }, yaw: 0 };
    case "west":
      return { location: { ...center, x: block.x - 0.51 }, yaw: 90 };
    case "east":
      return { location: { ...center, x: block.x + 1.51 }, yaw: -90 };
    default:
      return undefined;
  }
}

export function portalKey(portal) {
  return `${portal.dimensionId}|${portal.x},${portal.y},${portal.z}`;
}

export function linkPortals(existing, first, second) {
  return {
    ...existing,
    [portalKey(first)]: second,
    [portalKey(second)]: first,
  };
}

export function linkedPortal(links, portal) {
  return links?.[portalKey(portal)];
}

export function linkedPortalDestinationExists(dimension, destination) {
  try {
    return dimension?.getBlock({
      x: destination.x, y: destination.y, z: destination.z,
    })?.typeId === "thebrokenscript:portal_controller";
  } catch (error) {
    operationDiagnostics.warnOnce("portal.destination_unavailable", "portal: destination controller could not be inspected", error);
    return false;
  }
}

export function portalReferenceFromKey(key) {
  const match = /^([^|]+)\|(-?\d+),(-?\d+),(-?\d+)$/.exec(key);
  if (!match) return undefined;
  const [, dimensionId, x, y, z] = match;
  return { dimensionId, x: Number(x), y: Number(y), z: Number(z) };
}

export function insidePortalVolume(portal, location) {
  return location.x >= portal.x && location.x < portal.x + 1
    && location.y >= portal.y + 1 && location.y < portal.y + 3
    && location.z >= portal.z && location.z < portal.z + 1;
}

export function automaticPortalTarget(source, destination, location) {
  if (!source || !destination || source.dimensionId !== destination.dimensionId
      || ![source.x, source.y, source.z, destination.x, destination.y, destination.z]
        .every(Number.isSafeInteger) || !insidePortalVolume(source, location)) return undefined;
  return {
    x: destination.x + (location.x - source.x),
    y: destination.y + (location.y - source.y),
    z: destination.z + (location.z - source.z),
  };
}
