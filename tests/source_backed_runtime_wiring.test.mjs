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

function sourceMapRow(sourceId) {
  const map = JSON.parse(read("SOURCE_MAP.json"));
  return map.rows.find((row) => row.source_id === sourceId);
}

function assertEvidence(sourceId, ...files) {
  const row = sourceMapRow(sourceId);
  assert.ok(row, `missing SOURCE_MAP row ${sourceId}`);
  for (const file of files) assert.ok(row.bedrock_files.includes(file), `${sourceId} missing ${file}`);
}

test("source-backed runtime has one bootstrap owner for maze, flying, and chunk systems", () => {
  const main = read("BP/scripts/main.js");
  assert.match(main, /modifiedChunks\.begin\(\)/);
  assert.match(main, /doorRuntime\.begin\(\)/);
  assert.match(main, /chunkRemoverRuntime\.begin\(\)/);
  assert.match(main, /nullSourceController\.begin\(scheduler\)/);

  const legacy = read("BP/scripts/entities/null/null_pursuit_controller.js");
  assert.doesNotMatch(legacy, /tickMaze|tickFlying|LIFETIMES[\s\S]*null_maze|LIFETIMES[\s\S]*null_flying/);
});

test("maze entity and custom doors expose the source-backed state contract", () => {
  const maze = readJson("BP/entities/null_maze.json")["minecraft:entity"];
  const components = maze.components;
  assert.equal(components["minecraft:navigation.walk"].can_open_doors, true);
  assert.equal(components["minecraft:navigation.walk"].can_pass_doors, true);
  assert.equal(components["minecraft:navigation.walk"].can_float, true);
  assert.equal(components["minecraft:navigation.walk"].can_walk_over_fences, true);
  assert.equal(components["minecraft:behavior.nearest_attackable_target"].within_radius, 416);
  assert.equal(components["minecraft:behavior.nearest_attackable_target"].entity_types[0].max_dist, 416);
  assert.equal(components["minecraft:behavior.nearest_attackable_target"].must_see_forget_duration, 22.5);
  assert.equal(components["minecraft:behavior.move_towards_target"].within_radius, 2);
  assert.equal(components["minecraft:behavior.melee_box_attack"].cooldown_time, 0.5);

  const doorRuntime = read("BP/scripts/systems/door_runtime.js");
  assert.match(doorRuntime, /playerInteractWithBlock/);
  assert.match(doorRuntime, /openDoorBlock/);
  assert.match(doorRuntime, /y: block\.location\.y \+ 24/);

  for (const id of ["ud_oak_door", "void_door", "void_log_door", "void_plank_door"]) {
    const block = readJson(`BP/blocks/${id}.json`)["minecraft:block"];
    assert.deepEqual(block.description.states["thebrokenscript:open"], [false, true]);
    assert.match(JSON.stringify(block.permutations), /minecraft:collision_box/);
  }
});

test("maze and flying source decisions are wired to runtime APIs and delayed state", () => {
  const controller = read("BP/scripts/entities/null/null_source_controller.js");
  assert.match(controller, /setblock \$\{location\.x\} \$\{location\.y\} \$\{location\.z\} air destroy/);
  assert.match(controller, /doorRayDistance/);
  assert.match(controller, /system\.runTimeout/);
  assert.match(controller, /isLookingAtEntityCenter/);
  assert.match(controller, /nullFlyRepGainTimer/);
  assert.match(controller, /EntityDamageCause\.none/);
  assert.match(controller, /world\.afterEvents\.entityHurt/);
  assert.match(controller, /player\.isSneaking/);
  assert.match(controller, /flyingProximityOutcome/);
  assert.match(controller, /naturalDespawnStep/);

  const gaze = read("BP/scripts/systems/ai/gaze.js");
  assert.match(gaze, /exactFlyingGaze/);
  assert.match(gaze, /flyingFovCone/);
  assert.match(gaze, /tolerance: 0/);
});

test("chunk-removal wiring is gated, persistent, loaded-only, and uses top-down sections", () => {
  const runtime = read("BP/scripts/systems/chunk_remover_runtime.js");
  assert.match(runtime, /isChunkLoaded/);
  assert.match(runtime, /fillBlocks/);
  assert.match(runtime, /clone/);
  assert.match(runtime, /chunkVerticalMovePlan/);
  assert.match(runtime, /offsetY/);

  const spawnRules = read("BP/scripts/entities/misc/misc_spawn_rules.js");
  assert.match(spawnRules, /chunkSpawnDecision/);
  assert.match(spawnRules, /modifiedChunks\.countModifiedChunk/);
  assert.match(spawnRules, /chunkRemoverRuntime\.handleChunkRemoverEntity/);

  const tracker = read("BP/scripts/systems/modified_chunks.js");
  assert.match(tracker, /playerPlaceBlock/);
  assert.match(tracker, /playerBreakBlock/);
  assert.match(tracker, /setWorldJSON/);
  assert.match(tracker, /dimension\.id/);
});

test("source map and compatibility records include the recovered source boundaries", () => {
  assertEvidence(
    "entity.null_maze",
    "BP/scripts/entities/null/null_source_controller.js",
    "BP/scripts/systems/null_pursuit_model.js",
    "BP/scripts/systems/door_runtime.js",
  );
  assertEvidence(
    "entity.null_flying",
    "BP/scripts/entities/null/null_source_controller.js",
    "BP/scripts/systems/null_pursuit_model.js",
    "BP/scripts/systems/ai/gaze.js",
  );
  assertEvidence(
    "entity.chunk_remover",
    "BP/scripts/systems/chunk_remover_runtime.js",
    "BP/scripts/systems/chunk_remover_model.js",
    "BP/scripts/systems/modified_chunks.js",
  );
  assertEvidence("code.world/chunk", "BP/scripts/systems/chunk_remover_runtime.js");

  const adaptation = read("ADAPTATION_NOTES.md");
  const limitations = read("KNOWN_LIMITATIONS.md");
  const compatibility = read("BEDROCK_COMPATIBILITY.md");
  const persistencePolicy = read("BP/scripts/core/entity_persistence_policy.js");
  assert.match(adaptation, /A-033/);
  assert.match(adaptation, /A-034/);
  assert.match(limitations, /NullMazeEntity\.java/);
  assert.match(limitations, /NullFlyingEntity\.java/);
  assert.match(limitations, /ChunkRemoverConditions\.java/);
  assert.match(limitations, /ChunkUtil\.java/);
  for (const sourcePath of ["NullMazeEntity.java", "NullFlyingEntity.java", "ChunkRemoverConditions.java", "ChunkUtil.java"]) {
    assert.match(compatibility, new RegExp(sourcePath.replaceAll(".", "\\.")));
  }
  assert.match(compatibility, /total brightness/);
  assert.match(compatibility, /isChunkLoaded/);
  assert.match(compatibility, /fillBlocks/);
  assert.match(persistencePolicy, /tbs:despawn_timer/);
  assert.match(persistencePolicy, /NullMazeEntity\/NullFlyingEntity\.timer/);
});
