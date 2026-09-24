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
  } catch (error) {
    operationDiagnostics.warnOnce("audit.BP.scripts.systems.ported_feature_logic.js.28", "best-effort Bedrock API fallback", error);
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

export function isPortalReference(portal) {
  return Boolean(
    portal
      && typeof portal.dimensionId === "string"
      && portal.dimensionId.length > 0
      && Number.isInteger(portal.x)
      && Number.isInteger(portal.y)
      && Number.isInteger(portal.z),
  );
}

export function portalKey(portal) {
  return portal.dimensionId + "|" + portal.x + "," + portal.y + "," + portal.z;
}

export function samePortalDimension(first, second) {
  return isPortalReference(first)
    && isPortalReference(second)
    && first.dimensionId === second.dimensionId;
}

export function unlinkPortal(existing, portal) {
  const next = { ...(existing ?? {}) };
  if (!isPortalReference(portal)) return next;

  const key = portalKey(portal);
  const previous = next[key];
  delete next[key];

  if (isPortalReference(previous)) {
    const previousKey = portalKey(previous);
    const reverse = next[previousKey];
    if (isPortalReference(reverse) && portalKey(reverse) === key) {
      delete next[previousKey];
    }
  }

  return next;
}

export function linkPortals(existing, first, second) {
  let next = unlinkPortal(existing, first);
  next = unlinkPortal(next, second);
  next[portalKey(first)] = second;
  next[portalKey(second)] = first;
  return next;
}

export function linkedPortal(links, portal) {
  return links?.[portalKey(portal)];
}

export function portalBoundsSize(bounds) {
  return {
    x: bounds.max.x - bounds.min.x,
    y: bounds.max.y - bounds.min.y,
    z: bounds.max.z - bounds.min.z,
  };
}

export function samePortalBoundsSize(first, second) {
  const a = portalBoundsSize(first);
  const b = portalBoundsSize(second);
  return a.x === b.x && a.y === b.y && a.z === b.z;
}

export function portalTargetLocation(sourceBounds, destinationBounds, location, isPassenger = false) {
  return {
    x: destinationBounds.min.x + (location.x - sourceBounds.min.x),
    y: destinationBounds.min.y + (isPassenger ? 0 : location.y - sourceBounds.min.y),
    z: destinationBounds.min.z + (location.z - sourceBounds.min.z),
  };
}

export function aabbIntersectsPortal(aabb, bounds) {
  if (!aabb?.center || !aabb?.extent) return false;

  const min = {
    x: aabb.center.x - aabb.extent.x,
    y: aabb.center.y - aabb.extent.y,
    z: aabb.center.z - aabb.extent.z,
  };
  const max = {
    x: aabb.center.x + aabb.extent.x,
    y: aabb.center.y + aabb.extent.y,
    z: aabb.center.z + aabb.extent.z,
  };

  return max.x >= bounds.min.x
    && min.x <= bounds.max.x
    && max.y >= bounds.min.y
    && min.y <= bounds.max.y
    && max.z >= bounds.min.z
    && min.z <= bounds.max.z;
}
