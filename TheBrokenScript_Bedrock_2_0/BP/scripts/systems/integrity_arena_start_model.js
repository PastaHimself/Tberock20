// Pure, source-backed contract for CorruptedCommandBlockConfirmPacket and
// Arena.Companion.start. Keep this module independent of the Bedrock runtime.

export const ARENA_START_SOURCE = Object.freeze({
  participantRadius: 150,
  offsetRandomMinInclusive: -20,
  offsetRandomMaxExclusive: 20,
  offsetAcceptMinInclusive: -10,
  offsetAcceptMaxInclusive: 10,
  preStartDelayTicks: 40,
  startDelayTicks: 60,
  phase1IntroDelayTicks: 1080,
  phase1: "phase1",
  fakeTimeOfDay: "midnight",
  customSkyEnabled: true,
  customSkyColor: Object.freeze({ x: 70, y: 0, z: 0 }),
});

/**
 * Mirrors the Java loop that samples nextInt(-20, 20) until [-10, 10].
 * The attempt bound only protects deterministic callers from a bad injector;
 * normal source-compatible callers return before it is reached.
 */
export function sampleArenaOffset(nextInt) {
  if (typeof nextInt !== "function") {
    throw new TypeError("sampleArenaOffset requires a nextInt function");
  }
  for (let attempts = 0; attempts < 10_000; attempts += 1) {
    const value = nextInt(
      ARENA_START_SOURCE.offsetRandomMinInclusive,
      ARENA_START_SOURCE.offsetRandomMaxExclusive,
    );
    if (
      value >= ARENA_START_SOURCE.offsetAcceptMinInclusive
      && value <= ARENA_START_SOURCE.offsetAcceptMaxInclusive
    ) {
      return value;
    }
  }
  throw new RangeError("sampleArenaOffset exceeded its safety attempt bound");
}

export function arenaCenter(commandBlockPosition, offset, surfaceY) {
  return {
    x: Number(commandBlockPosition.x) + Number(offset.x),
    y: Number(surfaceY),
    z: Number(commandBlockPosition.z) + Number(offset.z),
  };
}

export function arenaParticipants(
  players,
  center,
  dimensionId,
  radius = ARENA_START_SOURCE.participantRadius,
) {
  const centerLocation = {
    x: center.x + 0.5,
    y: center.y + 0.5,
    z: center.z + 0.5,
  };
  const radiusSquared = radius * radius;
  return players.filter((player) => {
    if (player?.dimensionId !== dimensionId) return false;
    if (!player?.location) return false;
    const dx = player.location.x - centerLocation.x;
    const dy = player.location.y - centerLocation.y;
    const dz = player.location.z - centerLocation.z;
    return dx * dx + dy * dy + dz * dz <= radiusSquared;
  });
}

export function integrityArenaStartPlan({
  existingArena,
  livingPlayers,
  commandBlockPosition,
  offset,
  surfaceY,
  dimensionId,
  nearbyPlayers,
}) {
  if (existingArena && !sourceCheckLivingPlayers(livingPlayers)) {
    return { action: "restart_phase" };
  }

  const center = arenaCenter(commandBlockPosition, offset, surfaceY);
  return {
    action: "create_and_start",
    center,
    participantIds: nearbyPlayers.map((player) => player.id),
    phase: ARENA_START_SOURCE.phase1,
    schedule: {
      preStartDelayTicks: ARENA_START_SOURCE.preStartDelayTicks,
      startDelayTicks: ARENA_START_SOURCE.startDelayTicks,
      phase1IntroDelayTicks: ARENA_START_SOURCE.phase1IntroDelayTicks,
      fakeTimeOfDay: ARENA_START_SOURCE.fakeTimeOfDay,
      customSkyEnabled: ARENA_START_SOURCE.customSkyEnabled,
      customSkyColor: { ...ARENA_START_SOURCE.customSkyColor },
    },
  };
}

// Arena.checkLivingPlayers first drops disconnected cached players. The Java
// implementation then treats one/two remaining players as sufficient even if
// dead, while three or more require at least one living player.
function sourceCheckLivingPlayers(players) {
  const connected = players.filter((player) => player?.connected);
  if (connected.length === 0) return false;
  if (connected.length <= 2) return true;
  return connected.some((player) => player.alive);
}
