// Numeric boundaries that belong to Bedrock-side adapters, not Java source
// constants. They are centralized so provenance and tolerance cannot drift.

// Java's child-part collision implementation has no equivalent scalar
// epsilon. This value only makes the Bedrock swept-AABB zero-delta branch
// stable across floating-point inputs.
export const FRACTURED_SEGMENT_EPSILON = 1e-9;

// Java random APIs use an exclusive [0, 1) upper bound. This clamp keeps a
// normalized Bedrock roll inside the final bucket without claiming a source
// literal of 0.999999999.
export const NORMALIZED_ROLL_UPPER_BOUND = 0.999999999;

export function clampNormalizedRoll(value) {
  const numeric = Number(value);
  if (!Number.isFinite(numeric)) return 0;
  return Math.max(0, Math.min(NORMALIZED_ROLL_UPPER_BOUND, numeric));
}
