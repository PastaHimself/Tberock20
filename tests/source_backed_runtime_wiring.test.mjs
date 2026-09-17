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
  assert.match(main, /nullDamageRuntime\.begin\(\)/);
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
  assert.deepEqual(components["minecraft:fire_immune"], {});

  const flying = readJson("BP/entities/null_flying.json")["minecraft:entity"];
  assert.deepEqual(flying.components["minecraft:fire_immune"], {});
  assert.equal(flying.components["minecraft:flying_speed"].value, 0.3);

  const damageRuntime = read("BP/scripts/entities/null/null_damage_runtime.js");
  assert.match(damageRuntime, /world\.beforeEvents\.entityHurt/);
  assert.match(damageRuntime, /damagingProjectile === undefined/);
  assert.match(damageRuntime, /damagingEntity\?\.typeId === "minecraft:player"/);
  assert.match(damageRuntime, /EntityDamageCause\.selfDestruct/);
  assert.match(damageRuntime, /EntityDamageCause\.void/);
  assert.match(damageRuntime, /event\.cancel = true/);

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
  assert.match(controller, /world\.afterEvents\.entityLoad/);
  assert.match(controller, /world\.afterEvents\.entityDie/);
  assert.match(controller, /player\.isSneaking/);
  assert.match(controller, /flyingProximityOutcome/);
  assert.match(controller, /naturalDespawnStep/);

  // Entity.dimension/location may be invalid after Entity.remove(). Preserve
  // the source's post-discard summon by snapshotting the Bedrock values first.
  assert.match(controller, /const proximityDimension = entity\.dimension/);
  assert.match(controller, /const proximityLocation = copyLocation\(entity\.location\)/);
  assert.match(controller, /spawnNullIsHere\(proximityDimension, proximityLocation\)/);
  assert.doesNotMatch(controller, /spawnNullIsHere\(entity\)/);

  // Persistent Null entities can unload with their chunk and later return.
  // Reload must restore ownership, while invalid handles must clear Maze light
  // state instead of leaving a stale minecraft:light_block behind.
  assert.match(controller, /function onEntityLoad\(event\)[\s\S]*rememberEntity\(event\?\.entity\)/);
  assert.match(controller, /function clearTrackedEntity\(id\)[\s\S]*removeMazeLight\(mazeState, mazeState\.lightDimension\)/);

  // NullMazeEntity.die applies LOSS_IHY to a player killer; awardKillScore
  // removes the Maze after a player kill and plays NULL_KILLS_PLAYER.
  assert.match(controller, /dead\.typeId === MAZE_ID[\s\S]*changeReputation\(attacker, -50\)/);
  assert.match(controller, /dead\.typeId === "minecraft:player"[\s\S]*attacker\?\.typeId === MAZE_ID/);
  assert.match(controller, /"kills_player"/);
  assert.match(controller, /discardEntity\(attacker, mazeState\)/);

  // Delayed callbacks must validate a player handle before reading mutable
  // entity properties such as isSneaking after a disconnect/unload.
  const timeoutStart = controller.indexOf("system.runTimeout(() => {");
  const timeoutEnd = controller.indexOf("}, NULL_FLYING_SOURCE.triggerDelayTicks)", timeoutStart);
  const timeoutBody = controller.slice(timeoutStart, timeoutEnd);
  assert.ok(timeoutStart >= 0 && timeoutEnd > timeoutStart);
  assert.ok(timeoutBody.indexOf("if (!isValid(player))") >= 0);
  assert.ok(timeoutBody.indexOf("if (!isValid(player))") < timeoutBody.indexOf("currentSneaking: Boolean(player.isSneaking)"));

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
  assert.match(runtime, /HANDLED_ENTITY_RETENTION_TICKS/);
  assert.match(runtime, /system\.runTimeout\(\(\) => handledEntities\.delete\(entityId\)/);

  // Source `tbs chunk remove` is unconditional; only natural remover behavior
  // is disabled by the world.disableChunkRemoval configuration flag.
  const clearStart = runtime.indexOf("export function clearChunkAt");
  const clearEnd = runtime.indexOf("function runCloneMove", clearStart);
  const adminClear = runtime.slice(clearStart, clearEnd);
  assert.doesNotMatch(adminClear, /disableChunkRemoval/);
  const naturalStart = runtime.indexOf("export function applyChunkRemoval");
  const naturalEnd = runtime.indexOf("function rememberHandledEntity", naturalStart);
  const naturalRemoval = runtime.slice(naturalStart, naturalEnd);
  assert.match(naturalRemoval, /disableChunkRemoval/);

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
