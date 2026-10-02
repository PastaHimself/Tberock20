export const TBE_SOURCE = Object.freeze({
  graceTicks: 150,
  naturalDespawnTicks: 1000,
  naturalExpiryReputation: 25,
  ambientPulseTicks: 150,
  attackDamage: 600,
  attackCooldownTicks: 20,
  bodyWidth: 0.6,
  bodyHeight: 25,
  meleeInflateWidthFactor: 2.0,
  meleeInflateHeightFactor: 0.25,
});

export function tbeMeleeBoxIntersects(mobLocation, targetLocation, targetWidth = 0.6, targetHeight = 1.8) {
  const mobHalfWidth = TBE_SOURCE.bodyWidth / 2;
  const targetHalfWidth = targetWidth / 2;
  const horizontalExtent = mobHalfWidth
    + (TBE_SOURCE.bodyWidth * TBE_SOURCE.meleeInflateWidthFactor)
    + targetHalfWidth;
  if (Math.abs(targetLocation.x - mobLocation.x) >= horizontalExtent) return false;
  if (Math.abs(targetLocation.z - mobLocation.z) >= horizontalExtent) return false;

  const verticalInflate = TBE_SOURCE.bodyHeight * TBE_SOURCE.meleeInflateHeightFactor;
  const mobMinY = mobLocation.y - verticalInflate;
  const mobMaxY = mobLocation.y + TBE_SOURCE.bodyHeight + verticalInflate;
  const targetMinY = targetLocation.y;
  const targetMaxY = targetLocation.y + targetHeight;
  return targetMaxY > mobMinY && targetMinY < mobMaxY;
}

export function stepNaturalDespawn(life, hasServerPlayerTarget) {
  const current = Math.max(0, Math.trunc(Number(life) || 0));
  if (!hasServerPlayerTarget || current <= 0) {
    return { life: current, expired: false, reputationDelta: 0 };
  }
  const next = Math.max(0, current - 1);
  return {
    life: next,
    expired: next === 0,
    reputationDelta: next === 0 ? TBE_SOURCE.naturalExpiryReputation : 0,
  };
}

export function stepAmbientCounter(counter) {
  const next = (Number(counter) || 0) + 1;
  return next > TBE_SOURCE.ambientPulseTicks
    ? { counter: 0, pulse: true }
    : { counter: next, pulse: false };
}
