import assert from "node:assert/strict";
import test from "node:test";

import {
  ensureDimensionReady,
  inFlightDimensionInitializationCount,
  registerDimensionInitializer,
  unregisterDimensionInitializer,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/dimension_generation.js";

function delayedWorld({ maxActiveTickingAreas = Infinity } = {}) {
  const properties = new Map();
  let release;
  const gate = new Promise((resolve) => {
    release = resolve;
  });
  let creates = 0;
  let removes = 0;
  let active = 0;

  return {
    release,
    get creates() {
      return creates;
    },
    get removes() {
      return removes;
    },
    get active() {
      return active;
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
        return active < maxActiveTickingAreas;
      },
      async createTickingArea() {
        creates += 1;
        active += 1;
        await gate;
      },
      removeTickingArea() {
        removes += 1;
        active = Math.max(0, active - 1);
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

test("simultaneous destinations within one region retain each player's coordinates", async () => {
  const world = delayedWorld();
  const dimension = voidDimension();
  const args = { world, dimension, dimensionId: "clan_void", logger: { error() {} } };
  const first = ensureDimensionReady({ ...args, location: { x: 1.5, y: 201, z: 1.5 } });
  const second = ensureDimensionReady({ ...args, location: { x: 14.5, y: 201, z: 14.5 } });

  world.release();
  const [a, b] = await Promise.all([first, second]);

  assert.deepEqual(a.location, { x: 1.5, y: 201, z: 1.5 });
  assert.deepEqual(b.location, { x: 14.5, y: 201, z: 14.5 });
  assert.equal(dimension.getBlock({ x: 14, y: 200, z: 14 }).typeId, "minecraft:bedrock");
});

test("travelers to one block share preparation but retain their own precise positions", async () => {
  const world = delayedWorld();
  const dimension = voidDimension();
  const args = { world, dimension, dimensionId: "clan_void", logger: { error() {} } };
  const first = ensureDimensionReady({ ...args, location: { x: 1.2, y: 201, z: 1.2 } });
  const second = ensureDimensionReady({ ...args, location: { x: 1.7, y: 201, z: 1.7 } });

  world.release();
  const [a, b] = await Promise.all([first, second]);

  assert.deepEqual(a.location, { x: 1.2, y: 201, z: 1.2 });
  assert.deepEqual(b.location, { x: 1.7, y: 201, z: 1.7 });
  assert.equal(world.creates, 1);
});

test("different landing sites reuse one ticking area for shared initializer bounds", async () => {
  const world = delayedWorld({ maxActiveTickingAreas: 1 });
  const dimension = voidDimension();
  let runs = 0;

  registerDimensionInitializer("nothing", () => {
    runs += 1;
  }, {
    stage: "terrain",
    version: 1,
    regionKey: () => "cell:0:0",
    bounds: () => ({
      from: { x: 0, y: -64, z: 0 },
      to: { x: 47, y: 319, z: 47 },
    }),
  });

  try {
    const args = { world, dimension, dimensionId: "nothing", logger: { error() {} } };
    const first = ensureDimensionReady({
      ...args,
      location: { x: 1.5, y: 201, z: 1.5 },
    });
    const second = ensureDimensionReady({
      ...args,
      location: { x: 14.5, y: 201, z: 14.5 },
    });

    assert.equal(world.creates, 1);
    assert.equal(world.active, 1);

    world.release();
    const [a, b] = await Promise.all([first, second]);

    assert.equal(a.ready, true);
    assert.equal(b.ready, true);
    assert.deepEqual(a.location, { x: 1.5, y: 201, z: 1.5 });
    assert.deepEqual(b.location, { x: 14.5, y: 201, z: 14.5 });
    assert.equal(runs, 1);
    assert.equal(world.creates, 1);
    assert.equal(world.removes, 1);
    assert.equal(world.active, 0);
  } finally {
    unregisterDimensionInitializer("nothing");
  }
});

test("different landing sites share one in-flight terrain stage for the same region", async () => {
  const world = delayedWorld();
  const dimension = voidDimension();
  let releaseInitializer;
  const initializerGate = new Promise((resolve) => { releaseInitializer = resolve; });
  let runs = 0;
  registerDimensionInitializer("nothing", async () => {
    runs += 1;
    await initializerGate;
  }, { stage: "terrain", version: 1, regionKey: () => "cell:0:0" });
  try {
    const args = { world, dimension, dimensionId: "nothing", logger: { error() {} } };
    const first = ensureDimensionReady({ ...args, location: { x: 1.5, y: 201, z: 1.5 } });
    const second = ensureDimensionReady({ ...args, location: { x: 14.5, y: 201, z: 14.5 } });
    world.release();
    await new Promise((resolve) => setImmediate(resolve));
    assert.equal(runs, 1);
    releaseInitializer();
    const [a, b] = await Promise.all([first, second]);
    assert.equal(a.ready, true);
    assert.equal(b.ready, true);
    assert.equal(runs, 1);
  } finally {
    unregisterDimensionInitializer("nothing");
  }
});
