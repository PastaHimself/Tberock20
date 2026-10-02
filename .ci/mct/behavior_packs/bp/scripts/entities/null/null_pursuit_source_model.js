export const NULL_PURSUIT_SOURCE = Object.freeze({
  endgameRadius: 500,
  endgameLifetimeTicks: 420,
  endgameDamagePeriodTicks: 60,
  endgameDamage: 999,
  endgameDeathReputation: -50,
  invadeLifetimeTicks: 3200,
  invadeTrackingRadius: 450,
  invadeTriggerRadius: 15,
  invadeScareChance: 0.7,
  invadeTriggerReputation: -10,
  invadeTimeoutReputation: 15,
  unbeatableLifetimeTicks: 500,
  unbeatableAttackDamage: 313,
});

export function stepPursuitTimer(timer, elapsedTicks, active = true) {
  const current = Math.max(0, Math.trunc(Number(timer) || 0));
  if (!active || current <= 0) return { timer: current, expired: false };
  const elapsed = Math.max(1, Math.trunc(Number(elapsedTicks) || 1));
  const next = Math.max(0, current - elapsed);
  return { timer: next, expired: next === 0 };
}

export function invadeSeenOutcome(randomValue) {
  if (!Number.isFinite(randomValue) || randomValue < 0 || randomValue >= 1) {
    throw new RangeError("randomValue must be a finite number in [0, 1)");
  }
  return randomValue < NULL_PURSUIT_SOURCE.invadeScareChance ? "scare" : "chase";
}

