import assert from "node:assert/strict";
import test from "node:test";

import {
  ensureDimensionReady,
  inFlightDimensionInitializationCount,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/dimension_generation.js";

function delayedWorld() {
  const properties = new Map();
  let release;
  const gate = new Promise((resolve) => {
    release = resolve;
  });
  let creates = 0;
  let removes = 0;

  return {
    release,
    get creates() {
      return creates;
    },
    get removes() {
      return removes;
    },
    getDynamicProperty(key) {
      return properties.get(key);
    },
    setDynamicProperty(key, value) {
      properties.set(key, value);
    },
    tickingAreaManager: {
      hasTickingArea() {
        return false;
      },
      hasCapacity() {
        return true;
      },
      async createTickingArea() {
        creates += 1;
        await gate;
      },
      removeTickingArea() {
        removes += 1;
      },
    },
  };
}

function voidDimension() {
  const blocks = new Map();
  const key = ({ x, y, z }) => `${x}:${y}:${z}`;
  return {
    heightRange: { min: -64, max: 320 },
    getBlock(location) {
      const typeId = blocks.get(key(location)) ?? "minecraft:air";
      return { typeId, isAir: typeId === "minecraft:air" };
    },
    setBlockType(location, typeId) {
      blocks.set(key(location), typeId);
    },
  };
}

test("simultaneous multiplayer entry into one region shares one initialization flight", async () => {
  const world = delayedWorld();
  const dimension = voidDimension();
  const args = {
    world,
    dimension,
    dimensionId: "clan_void",
    location: { x: 0.5, y: 201, z: 0.5 },
    logger: { error() {} },
  };

  const playerA = ensureDimensionReady(args);
  const playerB = ensureDimensionReady(args);

  assert.equal(inFlightDimensionInitializationCount(), 1);
  assert.equal(world.creates, 1);

  world.release();
  const [a, b] = await Promise.all([playerA, playerB]);

  assert.equal(a.ready, true);
  assert.equal(b.ready, true);
  assert.deepEqual(a.location, b.location);
  assert.equal(world.creates, 1);
  assert.equal(world.removes, 1);
  assert.equal(inFlightDimensionInitializationCount(), 0);
});
