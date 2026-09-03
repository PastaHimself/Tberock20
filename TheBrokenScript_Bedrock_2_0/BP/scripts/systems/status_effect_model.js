const HEART_CORRUPTION = Object.freeze({
  identifier: "thebrokenscript:heart_corruption",
  category: "harmful",
  color: 0xff00ff,
  maxHealthDelta: -1,
  shouldApplyEffectTick: true,
  appliesTickDamage: false,
});

const WHY_CANT_YOU_LEAVE = Object.freeze({
  identifier: "thebrokenscript:why_cant_you_leave",
  category: "neutral",
  color: -16777216,
  durationTicks: 1000,
  amplifier: 0,
  ambient: true,
  visible: true,
  particleEffect: "thebrokenscript:eyes",
});

export const SOURCE_STATUS_EFFECTS = Object.freeze({
  heart_corruption: HEART_CORRUPTION,
  why_cant_you_leave: WHY_CANT_YOU_LEAVE,
});

export function statusEffectDefinition(id) {
  const definition = SOURCE_STATUS_EFFECTS[id];
  if (!definition) throw new Error(`Unknown source status effect: ${id}`);
  return definition;
}

export function heartCorruptionHealthCap(effectiveMax) {
  const max = Number(effectiveMax);
  if (!Number.isFinite(max) || max <= 0) return 0;
  return Math.max(1, max - 1);
}

export function refreshStatusEffectExpiry(currentExpiry, currentTick, durationTicks) {
  const expiry = Number.isFinite(Number(currentExpiry)) ? Number(currentExpiry) : 0;
  const tick = Number.isFinite(Number(currentTick)) ? Number(currentTick) : 0;
  const duration = Math.max(1, Math.floor(Number(durationTicks)) || 1);
  return Math.max(expiry, tick) + duration;
}

export function isStatusEffectActive(expiry, currentTick) {
  return Number.isFinite(Number(expiry))
    && Number(expiry) > Number(currentTick);
}
