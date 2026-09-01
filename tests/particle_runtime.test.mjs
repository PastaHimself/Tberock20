import test from "node:test";
import assert from "node:assert/strict";
import { spawnSourceParticle } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/particle_runtime.js";

test("source particle runtime resolves the source event id at the entity location", () => {
  const calls = [];
  const entity = {
    location: { x: 4, y: 8, z: -2 },
    dimension: {
      spawnParticle(...args) {
        calls.push(args);
      },
    },
  };

  assert.equal(spawnSourceParticle(entity, "null_particle"), true);
  assert.deepEqual(calls, [["thebrokenscript:null_particle", entity.location]]);
});

test("source particle runtime accepts an explicit origin for despawn effects", () => {
  const calls = [];
  const entity = {
    location: { x: 1, y: 2, z: 3 },
    dimension: { spawnParticle: (...args) => calls.push(args) },
  };
  const origin = { x: 9, y: 10, z: 11 };

  assert.equal(spawnSourceParticle(entity, "curved_despawn", origin), true);
  assert.deepEqual(calls, [["thebrokenscript:particle_of_curved", origin]]);
});

test("source particle runtime contains Bedrock API failures", () => {
  const entity = {
    location: { x: 0, y: 0, z: 0 },
    dimension: {
      spawnParticle() {
        throw new Error("unloaded");
      },
    },
  };

  assert.equal(spawnSourceParticle(entity, "eyes"), false);
  assert.equal(spawnSourceParticle(null, "eyes"), false);
});
