import test from "node:test";
import assert from "node:assert/strict";
import {
  FRACTURED_MULTIPART_SOURCE,
  fracturedPartHitPlan,
  fracturedRoamSwitchStep,
  multipartAabbs,
  multipartEntityMatches,
  multipartPartDefinitions,
  multipartWorldPosition,
  pointInsideAabb,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/fractured_multipart_model.js";

test("Jimmy multipart dimensions and offsets preserve BaseFracturedEntity source values", () => {
  assert.deepEqual(FRACTURED_MULTIPART_SOURCE, {
    legDistance: 45,
    rootCollisionBox: { width: 105, height: 102 },
    parts: {
      head: { name: "head", width: 14, height: 14, offset: { x: 1, y: 88, z: 10 } },
      chest: { name: "chest", width: 18, height: 18, offset: { x: 1, y: 68, z: 10 } },
    },
    subEntities: {
      frontLeft: {
        name: "frontleft",
        width: 15,
        height: 15,
        defaultOffset: { x: 40, y: 0, z: 50 },
        targetOffset: { x: 45, y: 0, z: 45 },
      },
      frontRight: {
        name: "frontright",
        width: 15,
        height: 15,
        defaultOffset: { x: -40, y: 0, z: 50 },
        targetOffset: { x: -45, y: 0, z: 45 },
      },
      backLeft: {
        name: "backleft",
        width: 15,
        height: 15,
        defaultOffset: { x: 40, y: 0, z: -49 },
        targetOffset: { x: 45, y: 0, z: -45 },
      },
      backRight: {
        name: "backright",
        width: 15,
        height: 15,
        defaultOffset: { x: -40, y: 0, z: -49 },
        targetOffset: { x: -45, y: 0, z: -45 },
      },
    },
    arrowEffects: {
      igniteSeconds: 20,
      spectralGlowTicks: 400,
    },
    roamSwitchTicks: 103,
    roamSwapState: "SWITCHING",
  });
  assert.deepEqual(multipartPartDefinitions().map((part) => part.name), [
    "head", "chest", "frontleft", "frontright", "backleft", "backright",
  ]);
});

test("multipart positions use the source body rotation and Leg.tick transform", () => {
  assert.deepEqual(multipartWorldPosition({ x: 10, y: 20, z: 30 }, { x: 1, y: 68, z: 10 }, 0), {
    x: 11, y: 88, z: 40,
  });
  assert.deepEqual(multipartWorldPosition({ x: 10, y: 20, z: 30 }, { x: 45, y: 0, z: 45 }, 90), {
    x: -35, y: 20, z: 75,
  });
  const parts = multipartPartDefinitions();
  const leg = parts.find((part) => part.name === "backright");
  const rotatedLeg = multipartWorldPosition({ x: 0, y: 0, z: 0 }, leg.targetOffset, 180);
  assert.ok(Math.abs(rotatedLeg.x - 45) < 1e-9);
  assert.equal(rotatedLeg.y, 0);
  assert.ok(Math.abs(rotatedLeg.z - 45) < 1e-9);
});

test("conceptual part AABBs preserve source dimensions while remaining a runtime adapter", () => {
  const boxes = multipartAabbs({ position: { x: 0, y: 10, z: 0 }, yawDegrees: 0 });
  const head = boxes.find((box) => box.name === "head");
  const frontLeft = boxes.find((box) => box.name === "frontleft");
  assert.deepEqual(head, {
    name: "head",
    role: "part",
    min: { x: -6, y: 98, z: 3 },
    max: { x: 8, y: 112, z: 17 },
  });
  assert.deepEqual(frontLeft, {
    name: "frontleft",
    role: "sub_entity",
    min: { x: 37.5, y: 10, z: 37.5 },
    max: { x: 52.5, y: 25, z: 52.5 },
  });
  assert.equal(pointInsideAabb({ x: 0, y: 105, z: 10 }, head), true);
  assert.equal(pointInsideAabb({ x: 0, y: 97.99, z: 10 }, head), false);
});

test("part hit routes an arrow through Jimmy and preserves source arrow side effects", () => {
  assert.deepEqual(fracturedPartHitPlan({
    parentType: "thebrokenscript:fractured",
    partHit: true,
    projectileType: "minecraft:arrow",
    projectileOnFire: true,
    invulnerable: false,
  }), {
    cancel: false,
    allowParentDamage: true,
    markHitViaPart: true,
    swap: false,
    igniteSeconds: 20,
    spectralGlowTicks: 0,
  });
  assert.deepEqual(fracturedPartHitPlan({
    parentType: "thebrokenscript:fractured",
    partHit: true,
    projectileType: "minecraft:spectral_arrow",
    projectileOnFire: false,
    invulnerable: false,
  }), {
    cancel: false,
    allowParentDamage: true,
    markHitViaPart: true,
    swap: false,
    igniteSeconds: 0,
    spectralGlowTicks: 400,
  });
});

test("missed and invulnerable part hits are rejected without parent damage", () => {
  assert.equal(fracturedPartHitPlan({ parentType: "thebrokenscript:fractured", partHit: false }).cancel, true);
  assert.equal(fracturedPartHitPlan({
    parentType: "thebrokenscript:fractured",
    partHit: true,
    projectileType: "minecraft:trident",
  }).allowParentDamage, false);
  const plan = fracturedPartHitPlan({
    parentType: "thebrokenscript:fractured",
    partHit: true,
    projectileType: "minecraft:arrow",
    projectileOnFire: true,
    invulnerable: true,
  });
  assert.equal(plan.cancel, true);
  assert.equal(plan.allowParentDamage, false);
  assert.equal(plan.markHitViaPart, false);
  assert.equal(plan.igniteSeconds, 20);
});

test("a FracturedRoam part hit requests the source SWITCHING state", () => {
  assert.deepEqual(fracturedPartHitPlan({
    parentType: "thebrokenscript:fractured_roam",
    partHit: true,
    projectileType: "minecraft:spectral_arrow",
    projectileOnFire: true,
    invulnerable: false,
  }), {
    cancel: true,
    allowParentDamage: false,
    markHitViaPart: false,
    swap: true,
    igniteSeconds: 0,
    spectralGlowTicks: 0,
  });
});

test("FracturedRoam promotion decrements before the source 103-tick switch completes", () => {
  let state = { switchTicks: FRACTURED_MULTIPART_SOURCE.roamSwitchTicks, promote: false };
  for (let tick = 0; tick < 102; tick += 1) {
    state = fracturedRoamSwitchStep(state.switchTicks);
    assert.equal(state.promote, false);
  }
  assert.equal(state.switchTicks, 1);
  state = fracturedRoamSwitchStep(state.switchTicks);
  assert.deepEqual(state, { switchTicks: 0, promote: true });
});

test("multipart entity identity treats a part and its parent as the same source entity", () => {
  assert.equal(multipartEntityMatches({ name: "head" }, "head"), true);
  assert.equal(multipartEntityMatches({ name: "head" }, "fractured"), true);
  assert.equal(multipartEntityMatches({ name: "head" }, "frontleft"), false);
});
