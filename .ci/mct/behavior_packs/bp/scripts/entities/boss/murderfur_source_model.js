export const MURDERFUR_SOURCE = Object.freeze({
  maxHealth: 1000,
  baseAttackDamage: 1,
  baseMovementSpeed: 0.3,
  followRange: 400,
  phase2Health: 666,
  phase3Health: 333,
  attackIntervalTicks: 10,
  attackRange: 1.5,
  bodyWidth: 0.5,
  bodyHeight: 1.5,
  phases: Object.freeze({
    1: Object.freeze({ attackMultiplier: 1, movementMultiplier: 0.75 }),
    2: Object.freeze({ attackMultiplier: 2, movementMultiplier: 1.0 }),
    3: Object.freeze({ attackMultiplier: 5, movementMultiplier: 1.5 }),
  }),
});

export function murderfurMeleeBoxIntersects(mobLocation, targetLocation, targetWidth = 0.6, targetHeight = 1.8) {
  const mobHalfWidth = MURDERFUR_SOURCE.bodyWidth / 2;
  const targetHalfWidth = targetWidth / 2;
  const horizontalExtent = mobHalfWidth
    + (MURDERFUR_SOURCE.bodyWidth * MURDERFUR_SOURCE.attackRange)
    + targetHalfWidth;
  if (Math.abs(targetLocation.x - mobLocation.x) >= horizontalExtent) return false;
  if (Math.abs(targetLocation.z - mobLocation.z) >= horizontalExtent) return false;

  const verticalInflate = MURDERFUR_SOURCE.bodyHeight * 0.2;
  const mobMinY = mobLocation.y - verticalInflate;
  const mobMaxY = mobLocation.y + MURDERFUR_SOURCE.bodyHeight + verticalInflate;
  const targetMinY = targetLocation.y;
  const targetMaxY = targetLocation.y + targetHeight;
  return targetMaxY > mobMinY && targetMinY < mobMaxY;
}

export function murderfurPhaseStep(currentPhase, health) {
  const phase = Math.max(1, Math.min(3, Math.trunc(Number(currentPhase) || 1)));
  const hp = Number(health);
  if (phase === 1 && hp <= MURDERFUR_SOURCE.phase2Health) return 2;
  if (phase === 2 && hp <= MURDERFUR_SOURCE.phase3Health) return 3;
  return phase;
}

export function murderfurPhaseStats(phase) {
  const normalized = Math.max(1, Math.min(3, Math.trunc(Number(phase) || 1)));
  const source = MURDERFUR_SOURCE.phases[normalized];
  return {
    phase: normalized,
    attackDamage: MURDERFUR_SOURCE.baseAttackDamage * source.attackMultiplier,
    movementSpeed: MURDERFUR_SOURCE.baseMovementSpeed * source.movementMultiplier,
  };
}
