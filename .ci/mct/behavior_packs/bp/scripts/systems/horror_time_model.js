// Source-backed time boundaries from brokencore/api/world/TimeOfDay.java.
// NIGHT=13000 and TICKS_PER_DAY=24000 are Java evidence. The 23000 cutoff is
// a Bedrock event-gate adapter for the final 1000 ticks before day rollover;
// it is not claimed as a Java literal or exact engine parity.

export const JAVA_TICKS_PER_DAY = 24000;
export const JAVA_NIGHT_START = 13000;
export const BEDROCK_NIGHT_END = 23000;

export function normalizeTimeOfDay(time) {
  const numeric = Number(time);
  if (!Number.isFinite(numeric)) return 0;
  const integer = Math.trunc(numeric);
  return ((integer % JAVA_TICKS_PER_DAY) + JAVA_TICKS_PER_DAY) % JAVA_TICKS_PER_DAY;
}

export function isDayTime(time) {
  return normalizeTimeOfDay(time) < JAVA_NIGHT_START;
}

export function isNightTime(time) {
  const normalized = normalizeTimeOfDay(time);
  return normalized >= JAVA_NIGHT_START && normalized < BEDROCK_NIGHT_END;
}
