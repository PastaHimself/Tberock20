import assert from "node:assert/strict";
import test from "node:test";

import {
  SAFE_LANDING_BLOCK,
  clampLandingLocation,
  ensureDimensionReady,
  landingAreaBounds,
  landingRegionKey,
  registerDimensionInitializer,
  unregisterDimensionInitializer,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/dimension_generation.js";
import {
  dimensionStatePropertyKey,
  dimensionStateToken,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/dimension_state.js";

function fakeWorld({ delayed = false } = {}) {
  const properties = new Map();
  let release;
  const gate = delayed
    ? new Promise((resolve) => {
        release = resolve;
      })
    : Promise.resolve();

  const calls = {
    create: 0,
    remove: 0,
    capacity: 0,
  };

  return {
    calls,
    release: () => release?.(),
    getDynamicProperty(key) {
      return properties.get(key);
    },
    setDynamicProperty(key, value) {
      if (value === undefined) properties.delete(key);
      else properties.set(key, value);
    },
    tickingAreaManager: {
      hasTickingArea() {
        return false;
      },
      hasCapacity() {
        calls.capacity += 1;
        return true;
      },
      async createTickingArea() {
        calls.create += 1;
        await gate;
      },
      removeTickingArea() {
        calls.remove += 1;
      },
    },
  };
}

function fakeDimension({ min = -64, max = 320 } = {}) {
  const blocks = new Map();
  const key = ({ x, y, z }) => `${x}:${y}:${z}`;
  return {
    id: "thebrokenscript:clan_void",
    heightRange: { min, max },
    blocks,
    getBlock(location) {
      const typeId = blocks.get(key(location)) ?? "minecraft:air";
      return { typeId, isAir: typeId === "minecraft:air" };
    },
    setBlockType(location, typeId) {
      blocks.set(key(location), typeId);
    },
  };
}

const logger = { error() {} };

test("landing location is clamped inside the actual Bedrock height range", () => {
  assert.deepEqual(
    clampLandingLocation({ x: 1.25, y: 9999, z: -2.5 }, { min: -64, max: 320 }),
    { x: 1.25, y: 318, z: -2.5 },
  );
  assert.equal(landingRegionKey({ x: -1, y: 33, z: 16 }), "-1:2:1");
  assert.deepEqual(landingAreaBounds({ x: 10.7, y: 20, z: -2.1 }), {
    from: { x: 9, y: 20, z: -4 },
    to: { x: 11, y: 20, z: -2 },
  });
});

test("dimension state keys are deterministic and collision-checked by token value", () => {
  const args = ["thebrokenscript:clan_void", "landing", "0:12:0", 1];
  assert.equal(dimensionStatePropertyKey(...args), dimensionStatePropertyKey(...args));
  assert.match(dimensionStatePropertyKey(...args), /^tbs:dim_init_[0-9a-f]{16}$/);
  assert.equal(
    dimensionStateToken(...args),
    "v1|thebrokenscript:clan_void|landing|0:12:0",
  );
});

test("first custom-dimension entry creates a persisted safe landing and cleans its ticking area", async () => {
  const world = fakeWorld();
  const dimension = fakeDimension();

  const first = await ensureDimensionReady({
    world,
    dimension,
    dimensionId: "clan_void",
    location: { x: 0.5, y: 201, z: 0.5 },
    logger,
  });

  assert.equal(first.ready, true);
  assert.equal(first.location.y, 201);
  assert.equal(world.calls.create, 1);
  assert.equal(world.calls.remove, 1);
  assert.equal(dimension.blocks.size, 9);
  assert.ok([...dimension.blocks.values()].every((typeId) => typeId === SAFE_LANDING_BLOCK));

  const second = await ensureDimensionReady({
    world,
    dimension,
    dimensionId: "thebrokenscript:clan_void",
    location: { x: 0.5, y: 201, z: 0.5 },
    logger,
  });
  assert.equal(second.ready, true);
  assert.equal(world.calls.create, 1);
  assert.equal(dimension.blocks.size, 9);
});

test("registered terrain initializer runs once before landing resolution", async () => {
  const world = fakeWorld();
  const dimension = fakeDimension();
  let runs = 0;

  registerDimensionInitializer(
    "clan_void",
    async ({ dimension: targetDimension, location }) => {
      runs += 1;
      targetDimension.setBlockType(
        { x: Math.floor(location.x), y: Math.floor(location.y) - 1, z: Math.floor(location.z) },
        "minecraft:stone",
      );
    },
    { stage: "terrain", version: 1 },
  );

  try {
    const args = {
      world,
      dimension,
      dimensionId: "clan_void",
      location: { x: 12.5, y: 201, z: 12.5 },
      logger,
    };
    const first = await ensureDimensionReady(args);
    const second = await ensureDimensionReady(args);

    assert.equal(first.ready, true);
    assert.equal(second.ready, true);
    assert.equal(runs, 1);
    assert.equal(dimension.blocks.size, 1);
  } finally {
    unregisterDimensionInitializer("clan_void");
  }
});

test("a later terrain initializer upgrades an already-persisted landing region", async () => {
  const world = fakeWorld();
  const dimension = fakeDimension();
  const args = {
    world,
    dimension,
    dimensionId: "clan_void",
    location: { x: 24.5, y: 201, z: 24.5 },
    logger,
  };

  const provisional = await ensureDimensionReady(args);
  assert.equal(provisional.ready, true);
  assert.equal(world.calls.create, 1);

  let runs = 0;
  registerDimensionInitializer(
    "clan_void",
    async ({ dimension: targetDimension, location }) => {
      runs += 1;
      targetDimension.setBlockType(
        { x: Math.floor(location.x), y: Math.floor(location.y) - 1, z: Math.floor(location.z) },
        "minecraft:stone",
      );
    },
    { stage: "terrain", version: 2 },
  );

  try {
    const upgraded = await ensureDimensionReady(args);
    const stable = await ensureDimensionReady(args);
    assert.equal(upgraded.ready, true);
    assert.equal(stable.ready, true);
    assert.equal(runs, 1);
    assert.equal(world.calls.create, 2);
  } finally {
    unregisterDimensionInitializer("clan_void");
  }
});

test("existing terrain is preferred over writing a fallback landing platform", async () => {
  const world = fakeWorld();
  const dimension = fakeDimension();
  dimension.setBlockType({ x: 4, y: 200, z: 4 }, "minecraft:stone");
  const preexistingWrites = dimension.blocks.size;

  const result = await ensureDimensionReady({
    world,
    dimension,
    dimensionId: "clan_void",
    location: { x: 4.5, y: 201, z: 4.5 },
    logger,
  });

  assert.equal(result.ready, true);
  assert.equal(result.location.y, 201);
  assert.equal(dimension.blocks.size, preexistingWrites);
});

test("persisted landing state remembers a resolved Y offset across re-entry", async () => {
  const world = fakeWorld();
  const dimension = fakeDimension();

  dimension.setBlockType({ x: 8, y: 201, z: 8 }, "minecraft:stone");
  dimension.setBlockType({ x: 8, y: 204, z: 8 }, "minecraft:stone");

  const first = await ensureDimensionReady({
    world,
    dimension,
    dimensionId: "clan_void",
    location: { x: 8.5, y: 201, z: 8.5 },
    logger,
  });
  assert.equal(first.ready, true);
  assert.equal(first.location.y, 202);

  const second = await ensureDimensionReady({
    world,
    dimension,
    dimensionId: "clan_void",
    location: { x: 8.5, y: 201, z: 8.5 },
    logger,
  });
  assert.equal(second.ready, true);
  assert.equal(second.location.y, 202);
  assert.equal(world.calls.create, 1);
});

test("vanilla destinations bypass custom initialization", async () => {
  const world = fakeWorld();
  const dimension = fakeDimension();
  const location = { x: 1, y: 70, z: 2 };

  const result = await ensureDimensionReady({
    world,
    dimension,
    dimensionId: "overworld",
    location,
    logger,
  });

  assert.deepEqual(result, { ready: true, location });
  assert.equal(world.calls.create, 0);
});
