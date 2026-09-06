const TORN_PAPER_DEFINITION = Object.freeze({
  title: "Torn Paper",
  texture: "textures/screens/torn_paper.png",
  imageWidth: 942,
  imageHeight: 453,
  rotationDegrees: 15,
  closeButton: "Close",
  canCloseOnEsc: true,
});

const COMMAND_BLOCK_DEFINITION = Object.freeze({
  title: "Input Code",
  inputLabel: "",
  inputPlaceholder: "",
  executeButton: "Execute",
  glitchHeaders: Object.freeze(["Leave", "You Still Have Time"]),
  glitchChance: 0.005,
  glitchDurationTicks: 35,
  glitchSwapIntervalTicks: 10,
  canPause: false,
  canCloseOnEsc: true,
});

const COMMAND_CONFIRM_DEFINITION = Object.freeze({
  headers: Object.freeze([
    "Are you sure you want to do this?",
    "The world won't be yours anymore...",
  ]),
  confirmButton: "Yes",
  canPause: false,
  canCloseOnEsc: true,
});

export function tornPaperDefinition() {
  return { ...TORN_PAPER_DEFINITION };
}

export function tornPaperBody(woodenFloorX, woodenFloorZ) {
  const x = chunkCenter(woodenFloorX);
  const z = chunkCenter(woodenFloorZ);
  return "X: " + x + "   Y: 216   Z: " + z;
}

export function commandBlockDefinition() {
  return {
    ...COMMAND_BLOCK_DEFINITION,
    glitchHeaders: [...COMMAND_BLOCK_DEFINITION.glitchHeaders],
  };
}

export function commandConfirmDefinition() {
  return {
    ...COMMAND_CONFIRM_DEFINITION,
    headers: [...COMMAND_CONFIRM_DEFINITION.headers],
  };
}

export function commandExecutionOutcome({
  input,
  expectedCode,
  dimensionId,
  initiatorPresent,
}) {
  if (String(input ?? "") !== String(expectedCode ?? "")) {
    return { kind: "invalid_code", replacement: "err.invalid.code" };
  }
  if (dimensionId !== "minecraft:overworld") {
    return {
      kind: "invalid_dimension",
      message: "[error] invalid dimension: expected ResourceKey#<minecraft:overworld>",
    };
  }
  if (!initiatorPresent) {
    return {
      kind: "invalid_position",
      message: "[error] invalid position: initiator must be present below command block",
    };
  }
  return { kind: "confirm" };
}

function chunkCenter(value) {
  const coordinate = Number(value);
  if (!Number.isFinite(coordinate)) return 8;
  return Math.floor(coordinate / 16) * 16 + 8;
}
