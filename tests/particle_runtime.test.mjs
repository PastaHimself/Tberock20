import test from "node:test";
import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import {
  spawnSourceParticle,
  tickLibraryPaper,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/particle_runtime.js";

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


test("Library paper ambience preserves source probability and spawn volume", () => {
  const calls = [];
  const player = {
    location: { x: 100, y: 50, z: -20 },
    dimension: {
      id: "thebrokenscript:library",
      spawnParticle: (...args) => calls.push(args),
    },
  };
  const values = [0.005, 0.75, 0.25, 0.5];
  const random = () => values.shift();
  const runtimeWorld = { getAllPlayers: () => [player] };

  assert.equal(tickLibraryPaper(runtimeWorld, random), 1);
  assert.deepEqual(calls, [[
    "thebrokenscript:paper_particle",
    { x: 108, y: 46, z: -20 },
  ]]);
});

test("Library paper ambience ignores other dimensions and failed 1% trials", () => {
  const calls = [];
  const library = {
    location: { x: 0, y: 0, z: 0 },
    dimension: { id: "thebrokenscript:library", spawnParticle: (...args) => calls.push(args) },
  };
  const overworld = {
    location: { x: 0, y: 0, z: 0 },
    dimension: { id: "minecraft:overworld", spawnParticle: (...args) => calls.push(args) },
  };
  assert.equal(tickLibraryPaper({ getAllPlayers: () => [library, overworld] }, () => 0.5), 0);
  assert.deepEqual(calls, []);
});

test("Follow controller uses the dedicated per-tick Wretched bridge", () => {
  const source = readFileSync(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/misc/misc_controller.js",
    "utf8",
  );
  const start = source.indexOf("function tickFollow");
  const end = source.indexOf("function tickWanderDespawn", start);
  const tickFollow = source.slice(start, end);
  assert.match(tickFollow, /spawnSourceParticle\(e, "wretched_tick"\)/);
  assert.doesNotMatch(tickFollow, /basic_smoke_particle/);
  assert.doesNotMatch(tickFollow, /currentTick % 30/);
});


test("Faraway controller retains the source funny-setting particle branch", () => {
  const source = readFileSync(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/humanoid/humanoid_controller.js",
    "utf8",
  );
  const start = source.indexOf("function tickFaraway");
  const faraway = source.slice(start);
  assert.match(faraway, /config\.get\("danger\.funnySetting"\)/);
  assert.match(faraway, /Math\.random\(\) > 0\.99/);
  assert.match(faraway, /spawnSourceParticle\(e, "faraway_fard", origin\)/);
  assert.match(faraway, /"faraway_null_burst" : "faraway_eyes_burst"/);
});


test("Null Structure marker uses its source particle bridge and creative-held gate", () => {
  const source = readFileSync(
    "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/custom_blocks.js",
    "utf8",
  );
  assert.match(source, /register\("thebrokenscript:be_null_structure",\s*\{\s*onTick/s);
  assert.match(source, /getGameMode\(\) === GameMode\.Creative/);
  assert.match(source, /isHoldingTypeId\(player, "thebrokenscript:null_structure"\)/);
  assert.match(source, /EquipmentSlot\.Offhand/);
  assert.match(source, /spawnSourceParticle\(block, "null_structure_marker", center\)/);

  const block = JSON.parse(readFileSync(
    "TheBrokenScript_Bedrock_2_0/BP/blocks/null_structure.json",
    "utf8",
  ))["minecraft:block"].components;
  assert.equal(block["minecraft:material_instances"]["*"].texture, "empty");
  assert.equal(block["minecraft:collision_box"], false);
  assert.equal(block["minecraft:selection_box"], true);
  assert.deepEqual(block["minecraft:tick"].interval_range, [1, 1]);
});
