import * as operationDiagnostics from "../../core/operation_diagnostics.js";
const SPECTATOR_MODES = new Set(["Spectator", "spectator", "minecraft:spectator", 3]);

export function dimensionIdOf(value) {
  if (!value) return undefined;
  if (typeof value === "string") return value;
  if (typeof value.dimensionId === "string") return value.dimensionId;
  if (typeof value.id === "string" && value.id.includes(":")) return value.id;
  if (typeof value.dimension?.id === "string") return value.dimension.id;
  return undefined;
}

export function distanceSquared(a, b) {
  if (!a || !b) return Number.POSITIVE_INFINITY;
  const dx = (a.x ?? 0) - (b.x ?? 0);
  const dy = (a.y ?? 0) - (b.y ?? 0);
  const dz = (a.z ?? 0) - (b.z ?? 0);
  return dx * dx + dy * dy + dz * dz;
}

export function isTargetablePlayer(player, dimensionId) {
  if (!player || player.isValid === false || !player.location) return false;
  if (dimensionId && dimensionIdOf(player) !== dimensionId) return false;

  try {
    const gameMode = player.getGameMode?.();
    if (SPECTATOR_MODES.has(gameMode)) return false;
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.ai.targeting_model.js.27", "best-effort Bedrock API fallback", error);
    // A player can invalidate between a target query and the game-mode read.
  }

  return true;
}

/**
 * @param {Array<any>} players
 * @param {{x: number, y: number, z: number}} location
 * @param {number} maxDistance
 * @param {{dimensionId?: string, predicate?: (player: any) => boolean}} [options]
 */
export function closestTarget(players, location, maxDistance, { dimensionId, predicate } = {}) {
  const resolvedDimensionId = dimensionId ?? dimensionIdOf(location);
  const maxDistanceSquared = Math.max(0, maxDistance) ** 2;
  let closest = null;
  let closestDistanceSquared = maxDistanceSquared;

  for (const player of players ?? []) {
    if (!isTargetablePlayer(player, resolvedDimensionId)) continue;
    if (predicate && !predicate(player)) continue;

    const candidateDistanceSquared = distanceSquared(player.location, location);
    if (candidateDistanceSquared <= closestDistanceSquared) {
      closest = player;
      closestDistanceSquared = candidateDistanceSquared;
    }
  }

  return closest;
}
