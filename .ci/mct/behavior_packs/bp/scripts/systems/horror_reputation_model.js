// Source-backed reputation values from RepTier.java and RepUtilKt.java.
// Java's gainBackHalfLostRep uses integer division, so odd loss amounts are
// truncated toward zero rather than represented as decimal Bedrock values.

export const REPUTATION_TIER_AMOUNTS = Object.freeze({
  GAIN_TEENYTINY: 1,
  GAIN_BABY: 5,
  GAIN_MINOR: 10,
  GAIN_SMALL: 15,
  GAIN_RARE: 20,
  GAIN_MEDIUM: 25,
  GAIN_WELLDONE: 30,
  GAIN_HUGE: 35,
  GAIN_ILY: 50,
  LOSS_TEENYTINY: -1,
  LOSS_BABY: -5,
  LOSS_MINOR: -10,
  LOSS_SMALL: -15,
  LOSS_RARE: -20,
  LOSS_MEDIUM: -25,
  LOSS_WELLDONE: -30,
  LOSS_HUGE: -35,
  LOSS_IHY: -50,
  REGAIN_HALF: 0,
});

export const REPUTATION_TIER_BY_DELTA = Object.freeze({
  "-1": "LOSS_TEENYTINY",
  "-5": "LOSS_BABY",
  "-10": "LOSS_MINOR",
  "-15": "LOSS_SMALL",
  "-20": "LOSS_RARE",
  "-25": "LOSS_MEDIUM",
  "-30": "LOSS_WELLDONE",
  "-35": "LOSS_HUGE",
  "-50": "LOSS_IHY",
  "1": "GAIN_TEENYTINY",
  "5": "GAIN_BABY",
  "10": "GAIN_MINOR",
  "15": "GAIN_SMALL",
  "20": "GAIN_RARE",
  "25": "GAIN_MEDIUM",
  "30": "GAIN_WELLDONE",
  "35": "GAIN_HUGE",
  "50": "GAIN_ILY",
});

export function integerHalfLostReputation(amount) {
  const numeric = Number(amount);
  if (!Number.isFinite(numeric) || numeric >= 0) return 0;
  return Math.trunc(-numeric / 2);
}

export const REGAIN_HALF_BY_TIER = Object.freeze(
  Object.fromEntries(
    Object.entries(REPUTATION_TIER_AMOUNTS)
      .filter(([tier]) => tier.startsWith("LOSS_"))
      .map(([tier, amount]) => [tier, integerHalfLostReputation(amount)]),
  ),
);
