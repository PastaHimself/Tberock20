export const BAN_FOLLOWUP_CHANCE = 0.5;

export function shouldSummonBan(randomValue) {
  if (!Number.isFinite(randomValue) || randomValue < 0 || randomValue >= 1) {
    throw new RangeError("randomValue must be a finite number in [0, 1)");
  }
  return randomValue < BAN_FOLLOWUP_CHANCE;
}

export function captureBanSpawnContext(dimension, location) {
  if (!dimension) throw new TypeError("dimension is required");
  if (!location) throw new TypeError("location is required");

  const { x, y, z } = location;
  if (![x, y, z].every(Number.isFinite)) {
    throw new TypeError("location coordinates must be finite numbers");
  }

  return {
    dimension,
    location: { x, y, z },
  };
}
