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

function clonePortalLinks(existing) {
  return existing && typeof existing === "object" ? { ...existing } : {};
}

export function unlinkPortal(existing, portal) {
  const targetKey = portalKey(portal);
  const next = clonePortalLinks(existing);
  for (const [key, destination] of Object.entries(next)) {
    let destinationKey;
    try {
      destinationKey = portalKey(destination);
    } catch {
      destinationKey = undefined;
    }
    if (key === targetKey || destinationKey === targetKey) delete next[key];
  }
  return next;
}

export function linkPortals(existing, first, second) {
  const firstKey = portalKey(first);
  const secondKey = portalKey(second);
  if (firstKey === secondKey) return unlinkPortal(existing, first);

  let next = unlinkPortal(existing, first);
  next = unlinkPortal(next, second);
  next[firstKey] = second;
  next[secondKey] = first;
  return next;
}

export function normalizePortalLinks(existing) {
  const source = clonePortalLinks(existing);
  const normalized = {};
  for (const [key, destination] of Object.entries(source)) {
    if (!destination || typeof destination !== "object") continue;
    let destinationKey;
    try {
      destinationKey = portalKey(destination);
    } catch {
      continue;
    }
    if (destinationKey === key) continue;
    const reverse = source[destinationKey];
    if (!reverse || typeof reverse !== "object") continue;
    try {
      if (portalKey(reverse) !== key) continue;
    } catch {
      continue;
    }
    normalized[key] = destination;
  }
  return normalized;
}

export function portalLinkPairs(links) {
  const normalized = normalizePortalLinks(links);
  const pairs = [];
  const visited = new Set();
  for (const [key, destination] of Object.entries(normalized)) {
    if (visited.has(key)) continue;
    const destinationKey = portalKey(destination);
    const source = normalized[destinationKey];
    if (!source) continue;
    visited.add(key);
    visited.add(destinationKey);
    pairs.push([source, destination]);
  }
  return pairs;
}

export function linkedPortal(links, portal) {
  return normalizePortalLinks(links)?.[portalKey(portal)];
}

export function portalBounds(controller, extenders = []) {
  const locations = [controller, ...(extenders ?? [])];
  let minX = Infinity;
  let minY = Infinity;
  let minZ = Infinity;
  let maxX = -Infinity;
  let maxY = -Infinity;
  let maxZ = -Infinity;

  for (const location of locations) {
    const x = Math.floor(Number(location?.x));
    const y = Math.floor(Number(location?.y));
    const z = Math.floor(Number(location?.z));
    if (![x, y, z].every(Number.isFinite)) continue;
    minX = Math.min(minX, x);
    minY = Math.min(minY, y);
    minZ = Math.min(minZ, z);
    maxX = Math.max(maxX, x + 1);
    maxY = Math.max(maxY, y + 1);
    maxZ = Math.max(maxZ, z + 1);
  }

  if (!Number.isFinite(minX)) return undefined;
  return {
    min: { x: minX, y: minY, z: minZ },
    max: { x: maxX, y: maxY, z: maxZ },
  };
}

export function portalBoundsSize(bounds) {
  return {
    x: bounds.max.x - bounds.min.x,
    y: bounds.max.y - bounds.min.y,
    z: bounds.max.z - bounds.min.z,
  };
}

export function portalBoundsMatch(first, second) {
  if (!first || !second) return false;
  const a = portalBoundsSize(first);
  const b = portalBoundsSize(second);
  return a.x === b.x && a.y === b.y && a.z === b.z;
}

export function pointInPortalBounds(location, bounds) {
  return Boolean(
    bounds &&
    location.x >= bounds.min.x && location.x <= bounds.max.x &&
    location.y >= bounds.min.y && location.y <= bounds.max.y &&
    location.z >= bounds.min.z && location.z <= bounds.max.z
  );
}

export function portalRelativeTarget(sourceBounds, destinationBounds, location, passenger = false) {
  return {
    x: destinationBounds.min.x + (location.x - sourceBounds.min.x),
    y: destinationBounds.min.y + (passenger ? 0 : location.y - sourceBounds.min.y),
    z: destinationBounds.min.z + (location.z - sourceBounds.min.z),
  };
}

export function portalEntryFace(location, bounds, velocity = { x: 0, y: 0, z: 0 }) {
  const epsilon = 0.1;
  if (location.x <= bounds.min.x + epsilon && velocity.x > 0) return "west";
  if (location.x >= bounds.max.x - epsilon && velocity.x < 0) return "east";
  if (location.y <= bounds.min.y + epsilon && velocity.y > 0) return "down";
  if (location.y >= bounds.max.y - epsilon && velocity.y < 0) return "up";
  if (location.z <= bounds.min.z + epsilon && velocity.z > 0) return "north";
  if (location.z >= bounds.max.z - epsilon && velocity.z < 0) return "south";

  const distances = [
    ["west", location.x - bounds.min.x],
    ["east", bounds.max.x - location.x],
    ["down", location.y - bounds.min.y],
    ["up", bounds.max.y - location.y],
    ["north", location.z - bounds.min.z],
    ["south", bounds.max.z - location.z],
  ];
  distances.sort((a, b) => a[1] - b[1]);
  return distances[0]?.[0] ?? "north";
}
