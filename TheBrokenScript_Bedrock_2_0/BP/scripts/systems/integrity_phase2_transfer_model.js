export const PHASE2_SOURCE = Object.freeze({
  transferDelayTicks: 20,
  destinationDimensionId: "thebrokenscript:stage2",
  recoveryBandMinY: 190,
  recoveryBandMaxYExclusive: 199,
  recoveryTeleport: Object.freeze({ x: 85.5, y: 162.5, z: 87.5 }),
  lowestPlayerMinYExclusive: 103,
});

export function phase1CompletionStep({ chordsSpawned, livingChordCount }) {
  if (chordsSpawned !== true || livingChordCount > 0) return "active";
  return "complete";
}

export function phase2TransferPlan({ phase, participantIds }) {
  if (phase === "phase2_loading") return { action: "already_staging" };
  if (phase !== "phase1") return { action: "not_phase1" };
  return {
    action: "schedule_transfer",
    delayTicks: PHASE2_SOURCE.transferDelayTicks,
    destinationDimensionId: PHASE2_SOURCE.destinationDimensionId,
    participantIds: [...participantIds],
  };
}
