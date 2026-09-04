import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import {
  commandBlockDefinition,
  commandConfirmDefinition,
  commandExecutionOutcome,
  tornPaperBody,
  tornPaperDefinition,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/command_block_model.js";

test("preserves the Torn Paper and command-screen contracts", () => {
  assert.deepEqual(tornPaperDefinition(), {
    title: "Torn Paper",
    texture: "textures/screens/torn_paper.png",
    imageWidth: 942,
    imageHeight: 453,
    rotationDegrees: 15,
    closeButton: "Close",
    canCloseOnEsc: true,
  });
  assert.equal(tornPaperBody(17, -17), "X: 24   Y: 216   Z: -24");
  assert.deepEqual(commandBlockDefinition(), {
    title: "Input Code",
    inputLabel: "",
    inputPlaceholder: "",
    executeButton: "Execute",
    glitchHeaders: ["Leave", "You Still Have Time"],
    glitchChance: 0.005,
    glitchDurationTicks: 35,
    glitchSwapIntervalTicks: 10,
    canPause: false,
    canCloseOnEsc: true,
  });
  assert.deepEqual(commandConfirmDefinition(), {
    headers: [
      "Are you sure you want to do this?",
      "The world won't be yours anymore...",
    ],
    confirmButton: "Yes",
    canPause: false,
    canCloseOnEsc: true,
  });
});

test("preserves the source command execution decision order", () => {
  assert.equal(
    commandExecutionOutcome({
      input: "wrong",
      expectedCode: "correct",
      dimensionId: "minecraft:overworld",
      initiatorPresent: true,
    }).kind,
    "invalid_code",
  );
  assert.equal(
    commandExecutionOutcome({
      input: "correct",
      expectedCode: "correct",
      dimensionId: "minecraft:nether",
      initiatorPresent: true,
    }).kind,
    "invalid_dimension",
  );
  assert.equal(
    commandExecutionOutcome({
      input: "correct",
      expectedCode: "correct",
      dimensionId: "minecraft:overworld",
      initiatorPresent: false,
    }).kind,
    "invalid_position",
  );
  assert.deepEqual(
    commandExecutionOutcome({
      input: "correct",
      expectedCode: "correct",
      dimensionId: "minecraft:overworld",
      initiatorPresent: true,
    }),
    { kind: "confirm" },
  );
});

test("wires the supported item and block adapters", async () => {
  const [features, blocks, item] = await Promise.all([
    readFile(new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_features.js", import.meta.url), "utf8"),
    readFile(new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/custom_blocks.js", import.meta.url), "utf8"),
    readFile(new URL("../TheBrokenScript_Bedrock_2_0/BP/items/torn_paper.json", import.meta.url), "utf8"),
  ]);
  const tornPaper = JSON.parse(item);

  assert.match(features, /registerCustomComponent\("thebrokenscript:torn_paper_use"/);
  assert.match(features, /new ModalFormData\(\)/);
  assert.match(features, /export async function showTornPaper\(/);
  assert.match(features, /export async function showCommandBlockGui\(/);
  assert.match(features, /export async function showCommandBlockConfirm\(/);
  assert.match(blocks, /showCommandBlockGui\(player, block\)/);
  assert.match(blocks, /showCommandBlockConfirm\(player, block\)/);
  assert.match(blocks, /thebrokenscript:command_block_giver/);
  assert.match(blocks, /give @s thebrokenscript:command 1/);
  assert.deepEqual(
    tornPaper["minecraft:item"].components["thebrokenscript:torn_paper_use"],
    {},
  );
});
