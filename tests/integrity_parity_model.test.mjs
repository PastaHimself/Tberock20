import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import path from "node:path";
import test from "node:test";
import {
  aabbIntersects,
  integrityParticipantIdsWithinRadius,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/integrity_arena_model.js";
import {
  fireballSegmentHitPlan,
  maceAttackIsEligible,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/phase3_attack_model.js";

const repoRoot = path.resolve(new URL("..", import.meta.url).pathname);
const phase3RuntimePath = path.join(
  repoRoot,
  "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/phase3_runtime.js",
);

test("Integrity roster selects only unique players inside the source radius", () => {
  assert.deepEqual(integrityParticipantIdsWithinRadius([
    { id: "outside", location: { x: 151, y: 0, z: 0 } },
    { id: "b", location: { x: 3, y: 0, z: 4 } },
    { id: "a", location: { x: 0, y: 0, z: 0 } },
    { id: "a", location: { x: 0, y: 0, z: 0 } },
  ], { x: 0, y: 0, z: 0 }), ["a", "b"]);
});

test("GroundArm contact excludes touching-only AABBs", () => {
  assert.equal(aabbIntersects(
    { min: { x: 0, y: 0, z: 0 }, max: { x: 1, y: 1, z: 1 } },
    { min: { x: 1, y: 0, z: 0 }, max: { x: 2, y: 1, z: 1 } },
  ), false);
});

test("fireball sweep selects the earliest non-owner roster target", () => {
  assert.deepEqual(fireballSegmentHitPlan({
    from: { x: 0, y: 1, z: 0 }, to: { x: 10, y: 1, z: 0 }, ownerId: "boss",
    targets: [
      { id: "late", aabb: { min: { x: 7, y: 0, z: -0.5 }, max: { x: 8, y: 2, z: 0.5 } } },
      { id: "boss", aabb: { min: { x: 1, y: 0, z: -0.5 }, max: { x: 2, y: 2, z: 0.5 } } },
      { id: "early", aabb: { min: { x: 4, y: 0, z: -0.5 }, max: { x: 5, y: 2, z: 0.5 } } },
    ],
  }), { id: "early", t: 0.3 });
});

test("source mace gate requires a main-hand mace and the fall threshold", () => {
  assert.equal(maceAttackIsEligible({ mainhandItemId: "minecraft:mace", fallDistance: 1.5, fallFlying: false }), true);
  assert.equal(maceAttackIsEligible({ mainhandItemId: "minecraft:sword", fallDistance: 2, fallFlying: false }), false);
  assert.equal(maceAttackIsEligible({ mainhandItemId: "minecraft:mace", fallDistance: 1.49, fallFlying: false }), false);
  assert.equal(maceAttackIsEligible({ mainhandItemId: "minecraft:mace", fallDistance: 2, fallFlying: true }), false);
});

test("Phase 3 runtime exposes one participant-roster seam", async () => {
  const runtime = await readFile(phase3RuntimePath, "utf8");
  assert.match(runtime, /export function setParticipantIds\(ids\)/);
  assert.match(runtime, /export function clearParticipantIds\(\)/);
  assert.match(runtime, /fireballSegmentHitPlan/);
  assert.match(runtime, /getAABB\(\)/);
  assert.doesNotMatch(
    runtime,
    /const targets = nearby\(fireball, FIREBALL_BEDROCK_ADAPTER\.collisionRadius\)/,
  );
});
