// Deterministic source-backed rules shared by the PlayerDataTicker,
// BecomeVoid, IsolationTicker, and TrueEndGame Bedrock adapters.

export const PLAYER_LIFECYCLE_SOURCE = Object.freeze({
  isolationDurationTicks: 4200,
  overworldVoidThresholdY: -78,
  stage2ExitMaxY: 4,
  concreteExitY: -85,
  moonExitY: -85,
  nowhereExitY: -100,
  clanVoidTeleportBand: Object.freeze({ minExclusive: 98, maxExclusive: 105, targetY: 550 }),
  clanVoidFloorBands: Object.freeze([
    Object.freeze({ minExclusive: 249, maxExclusive: 251 }),
    Object.freeze({ minExclusive: 229, maxExclusive: 231 }),
  ]),
  despawnEntitySwitchClearChance: 0.001,
  skipFallDamageCheckPeriodTicks: 120,
  trueEndGameRadius: 400,
  trueEndGameFirstAlertAfterTicks: 10,
  trueEndGameTerminalTick: 16,
});

function realmName(dimensionId) {
  if (typeof dimensionId !== "string") return "";
  const normalized = dimensionId.trim().toLowerCase();
  if (normalized === "minecraft:overworld") return "overworld";
  if (normalized.startsWith("thebrokenscript:")) return normalized.slice("thebrokenscript:".length);
  return normalized;
}

export function decrementPositiveTimer(value, amount = 1) {
  const current = Number(value);
  if (!Number.isFinite(current) || current <= 0) {
    return { previous: Number.isFinite(current) ? current : 0, next: 0, expired: false };
  }
  const step = Number.isFinite(amount) && amount > 0 ? amount : 1;
  const next = Math.max(0, current - step);
  return { previous: current, next, expired: next <= 0 };
}

export function shouldClearDespawnEntitySwitch(enabled, randomValue) {
  if (!enabled) return false;
  if (!Number.isFinite(randomValue) || randomValue < 0 || randomValue >= 1) {
    throw new RangeError("randomValue must be a finite number in [0, 1)");
  }
  return randomValue < PLAYER_LIFECYCLE_SOURCE.despawnEntitySwitchClearChance;
}

export function shouldClearSkipFallDamage(skipFallDamage, gameTime, standingOnAir) {
  if (!skipFallDamage) return false;
  const tick = Number(gameTime);
  if (!Number.isFinite(tick) || tick < 0) return false;
  return tick % PLAYER_LIFECYCLE_SOURCE.skipFallDamageCheckPeriodTicks === 0 && !standingOnAir;
}

/**
 * @param {{ dimensionId?: string, y?: number, fixPos?: boolean, moonStage?: number }} [state]
 */
export function becomeVoidTransition({ dimensionId, y, fixPos = false, moonStage = 0 } = {}) {
  const realm = realmName(dimensionId);
  const py = Number(y);
  if (!Number.isFinite(py)) return null;

  if (realm === "overworld") {
    if (py < PLAYER_LIFECYCLE_SOURCE.overworldVoidThresholdY && !fixPos) {
      return { kind: "dimension", destination: Number(moonStage) > 0 ? "the_moon" : "nowhere" };
    }
    return null;
  }

  if (realm === "stage2") {
    return py <= PLAYER_LIFECYCLE_SOURCE.stage2ExitMaxY && !fixPos
      ? { kind: "stage2_to_stage3", destination: "void_shadow" }
      : null;
  }

  if (realm === "concrete") {
    return py < PLAYER_LIFECYCLE_SOURCE.concreteExitY && !fixPos
      ? { kind: "overworld_return", fellFromMoon: false, restoreBedAfterTicks: 5 }
      : null;
  }

  if (realm === "the_moon") {
    return py < PLAYER_LIFECYCLE_SOURCE.moonExitY && !fixPos
      ? { kind: "overworld_return", fellFromMoon: true, restoreBedAfterTicks: 0 }
      : null;
  }

  if (realm === "nowhere") {
    return py < PLAYER_LIFECYCLE_SOURCE.nowhereExitY && !fixPos
      ? { kind: "dimension", destination: "protected_void" }
      : null;
  }

  if (realm === "clan_void") {
    const travel = PLAYER_LIFECYCLE_SOURCE.clanVoidTeleportBand;
    if (py > travel.minExclusive && py < travel.maxExclusive) {
      return { kind: "clan_void_vertical", targetY: travel.targetY };
    }
    if (PLAYER_LIFECYCLE_SOURCE.clanVoidFloorBands.some((band) => py > band.minExclusive && py < band.maxExclusive)) {
      return { kind: "clan_void_floor_guard" };
    }
  }

  return null;
}

export function trueEndGameStep({ shutdown = 0, spawnedShutdownWindow = false, nullEndgameNearby = false } = {}) {
  const current = Math.max(0, Math.trunc(Number(shutdown) || 0));
  if (!nullEndgameNearby) {
    return {
      shutdown: current,
      spawnedShutdownWindow: Boolean(spawnedShutdownWindow),
      showInitialAlert: false,
      showTerminalAlert: false,
      forceSurvival: false,
    };
  }

  const next = current + 1;
  const showInitialAlert = next > PLAYER_LIFECYCLE_SOURCE.trueEndGameFirstAlertAfterTicks
    && !spawnedShutdownWindow;
  const showTerminalAlert = next === PLAYER_LIFECYCLE_SOURCE.trueEndGameTerminalTick;
  return {
    shutdown: next,
    spawnedShutdownWindow: Boolean(spawnedShutdownWindow) || showInitialAlert,
    showInitialAlert,
    showTerminalAlert,
    forceSurvival: showTerminalAlert,
  };
}
