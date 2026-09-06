export const HAND_CANNON_RANGE = 100;

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
  } catch {
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
