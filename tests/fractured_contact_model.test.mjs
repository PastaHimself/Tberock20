import test from "node:test";
import assert from "node:assert/strict";
import { resolveFracturedContactPositions } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/fractured_contact_model.js";

test("uses all supplied rendered bone positions for a multi-bone slam", () => {
  const result = resolveFracturedContactPositions({
    eventName: "Slam",
    origin: { x: 10, y: 64, z: -4 },
    yawDegrees: 90,
    boneWorldPositions: {
      right_l_claw: { x: 12.25, y: 66, z: -3.5 },
      left_l_claw: { x: 8.75, y: 66, z: -4.5 },
    },
  });
  assert.deepEqual(result, {
    mode: "rendered_bone_world_position",
    positions: [
      { x: 12.25, y: 66, z: -3.5 },
      { x: 8.75, y: 66, z: -4.5 },
    ],
    missingBones: [],
  });
});

test("preserves the source stomp offset when no render-bone bridge is available", () => {
  const result = resolveFracturedContactPositions({
    eventName: "SingleStomp",
    origin: { x: 10, y: 64, z: -4 },
    yawDegrees: 0,
  });
  assert.equal(result.mode, "source_stomp_offset");
  assert.equal(result.missingBones[0], "right_f_tarsus");
  assert.equal(result.positions[0].y, 64);
  assert.ok(Math.abs(result.positions[0].x - -16.25) < 1e-9);
  assert.ok(Math.abs(result.positions[0].z - 160.125) < 1e-9);
});

test("uses an explicit entity-anchor fallback for unavailable claw and rock bones", () => {
  const result = resolveFracturedContactPositions({
    eventName: "OffenseRockThrow",
    origin: { x: 3, y: 70, z: 8 },
  });
  assert.deepEqual(result, {
    mode: "entity_anchor_fallback",
    positions: [{ x: 3, y: 70, z: 8 }],
    missingBones: ["ROCK"],
  });
});
