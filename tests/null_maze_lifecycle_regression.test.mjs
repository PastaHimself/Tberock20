import assert from "node:assert/strict";
import fs from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const repository = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");
const addon = path.join(repository, "TheBrokenScript_Bedrock_2_0");

function read(relativePath) {
  return fs.readFileSync(path.join(addon, relativePath), "utf8");
}

function readJson(relativePath) {
  return JSON.parse(read(relativePath));
}

test("Null Maze preserves the source 1.6-block step height", () => {
  const components = readJson("BP/entities/null_maze.json")["minecraft:entity"].components;
  assert.deepEqual(components["minecraft:variable_max_auto_step"], {
    base_value: 1.6,
    controlled_value: 1.6,
    jump_prevented_value: 1.6,
  });
});

test("Null Maze retries owned light cleanup after chunk unload", () => {
  const controller = read("BP/scripts/entities/null/null_source_controller.js");

  assert.match(controller, /const pendingMazeLightCleanup = new Map\(\)/);
  assert.match(controller, /function removeMazeLight\(state, dimension\)[\s\S]*state\?\.placedLight/);
  assert.match(controller, /if \(!clearMazeLightAt\(lightDimension, lightPosition\)\) queueMazeLightCleanup\(lightDimension, lightPosition\)/);
  assert.match(controller, /function retryPendingMazeLights\(\)[\s\S]*clearMazeLightAt\(pending\.dimension, pending\.location\)/);

  const onTickStart = controller.indexOf("function onTick() {");
  const onTickEnd = controller.indexOf("function onEntitySpawn", onTickStart);
  const onTick = controller.slice(onTickStart, onTickEnd);
  assert.ok(onTickStart >= 0 && onTickEnd > onTickStart);
  assert.ok(onTick.indexOf("retryPendingMazeLights();") >= 0);
  assert.ok(onTick.indexOf("retryPendingMazeLights();") < onTick.indexOf("world.getAllPlayers()"));
});
