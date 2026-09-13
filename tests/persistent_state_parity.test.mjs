import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import {
  CORE_SCHEMA_VERSION,
  JAVA_PLAYER_FIELDS,
  JAVA_WORLD_FIELDS,
  PLAYER_DEFAULTS,
  PLAYER_JSON_DEFAULTS,
  PLAYER_STATE_SCHEMA,
  applySchemaDefaults,
  WORLD_DEFAULTS,
  WORLD_STATE_SCHEMA,
  applyMissingDefaults,
  migrateCoreSchema,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/core/persistence_schema.js";
import {
  ENTITY_DYNAMIC_PROPERTY_POLICY,
  NON_PERSISTENT_ENTITY_TYPES,
  PERSISTENT_ENTITY_EVIDENCE,
  TRANSIENT_RUNTIME_STATE,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/core/entity_persistence_policy.js";

const ROOT = new URL("../", import.meta.url);
const SRC = "TheBrokenScript_Bedrock_2_0/src/systems/world_state.js";
const BP = "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/world_state.js";
const PLAYER_SRC = "TheBrokenScript_Bedrock_2_0/src/systems/player_state.js";
const PLAYER_BP = "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/player_state.js";
const STATE_SRC = "TheBrokenScript_Bedrock_2_0/src/core/state.js";
const STATE_BP = "TheBrokenScript_Bedrock_2_0/BP/scripts/core/state.js";
const MAIN_SRC = "TheBrokenScript_Bedrock_2_0/src/main.js";
const MAIN_BP = "TheBrokenScript_Bedrock_2_0/BP/scripts/main.js";
const PORTED_FEATURES = "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_features.js";
const PROGRESSION_SRC = "TheBrokenScript_Bedrock_2_0/src/systems/progression.js";
const PROGRESSION_BP = "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/progression.js";

async function text(path) {
  return (await readFile(new URL(path, ROOT), "utf8")).replace(/^\uFEFF/, "");
}

const ENCOUNTER_DELAYS = [
  "entitySpawnDelay",
  "circuitSpawnDelay",
  "oblitSpawnDelay",
  "tbeSpawnDelay",
  "rareSpawnDelay",
  "nullSpawnDelay",
  "curvedSpawnDelay",
  "eerieNoiseDelay",
  "herobrineDelay",
  "circuitInhabitedDelay",
];

test("world-state source and deploy copy stay synchronized", async () => {
  assert.equal(await text(SRC), await text(BP));
});

test("MapVariables encounter delays use the Java zero defaults", async () => {
  for (const key of ENCOUNTER_DELAYS) {
    assert.equal(WORLD_DEFAULTS[key], 0, `${key} must default to zero`);
  }
});

test("world-state initialization is additive and migration-safe", async () => {
  const source = await text(SRC);
  const init = source.match(/export function init\(\) \{([\s\S]*?)\n\}/)?.[1] ?? "";

  assert.match(init, /applySchemaDefaults/);
  assert.match(init, /WORLD_STATE_SCHEMA/);
  assert.match(init, /WORLD_EXTRA_SCHEMA/);
  assert.match(init, /state\.getWorld\(`mv\.\$\{key\}`, undefined\)/);
  assert.match(init, /state\.setWorld\(`mv\.\$\{key\}`, value\)/);
  assert.doesNotMatch(init, /mapVarsDataVersion/);
  assert.doesNotMatch(init, /getWorld\("mv\.dataVersion"/);
});

test("source and shipped persistence modules stay synchronized", async () => {
  assert.equal(await text(STATE_SRC), await text(STATE_BP));
  assert.equal(await text(PLAYER_SRC), await text(PLAYER_BP));
  assert.equal(
    await text("TheBrokenScript_Bedrock_2_0/src/core/persistence_schema.js"),
    await text("TheBrokenScript_Bedrock_2_0/BP/scripts/core/persistence_schema.js"),
  );
  assert.equal(
    await text("TheBrokenScript_Bedrock_2_0/src/core/entity_persistence_policy.js"),
    await text("TheBrokenScript_Bedrock_2_0/BP/scripts/core/entity_persistence_policy.js"),
  );
});

test("Java attachment fields have canonical Bedrock mappings and defaults", async () => {
  const mapVariables = await text("decompiled/net/thebrokenscript/data/MapVariables.java");
  const playerVariables = await text("decompiled/net/thebrokenscript/data/PlayerVariables.java");
  const javaFieldNames = (source) => [
    ...source.matchAll(/^\s*private\s+(?:final\s+)?[A-Za-z0-9_<>?, ]+\s+(\w+);/gm),
  ].map((match) => match[1]);

  assert.deepEqual(
    new Set(javaFieldNames(mapVariables)),
    new Set(Object.keys(JAVA_WORLD_FIELDS)),
  );
  assert.deepEqual(
    new Set(javaFieldNames(playerVariables)),
    new Set(Object.keys(JAVA_PLAYER_FIELDS)),
  );

  assert.equal(WORLD_STATE_SCHEMA.commandBlockX.type, "number");
  assert.equal(WORLD_STATE_SCHEMA.commandBlockZ.javaField, "commandBlockLocation");
  assert.equal(PLAYER_STATE_SCHEMA.spawnPos.type, "vector3");
  assert.equal(PLAYER_STATE_SCHEMA.customSkyColor.type, "vector3");
  assert.equal(PLAYER_STATE_SCHEMA.doors.storage, "json");
  assert.equal(PLAYER_STATE_SCHEMA.isolationAllowedUsers.storage, "json");
  assert.deepEqual(WORLD_DEFAULTS.commandBlockX, 0);
  assert.deepEqual(PLAYER_DEFAULTS.spawnPos, { x: 0, y: 0, z: 0 });
  assert.deepEqual(PLAYER_JSON_DEFAULTS.doors, []);
  assert.deepEqual(PLAYER_JSON_DEFAULTS.isolationAllowedUsers, []);
  assert.equal(PLAYER_DEFAULTS.voidBox, true);
});

test("additive migrations write only missing properties", () => {
  const values = new Map([["existing", 91]]);
  const writes = [];
  const written = applyMissingDefaults(
    { existing: 0, added: false, vector: { x: 0, y: 0, z: 0 } },
    (key) => values.get(key),
    (key, value) => {
      writes.push([key, value]);
      values.set(key, value);
    },
  );

  assert.deepEqual(written, ["added", "vector"]);
  assert.equal(values.get("existing"), 91);
  assert.deepEqual(writes, [
    ["added", false],
    ["vector", { x: 0, y: 0, z: 0 }],
  ]);
});

test("schema migrations repair invalid persisted types without resetting valid state", () => {
  const schema = {
    enabled: { type: "boolean", default: false },
    count: { type: "number", default: 0 },
    position: { type: "vector3", default: { x: 0, y: 0, z: 0 } },
    entries: { type: "json", default: [] },
  };
  const values = new Map([
    ["enabled", true],
    ["count", "corrupt"],
    ["position", { x: 1, y: 2, z: 3 }],
    ["entries", { not: "an array" }],
  ]);
  const writes = [];
  const written = applySchemaDefaults(
    schema,
    (key) => values.get(key),
    (key, value) => {
      writes.push([key, value]);
      values.set(key, value);
    },
  );

  assert.deepEqual(written, ["count", "entries"]);
  assert.deepEqual(writes, [
    ["count", 0],
    ["entries", []],
  ]);
  assert.equal(values.get("enabled"), true);
  assert.deepEqual(values.get("position"), { x: 1, y: 2, z: 3 });
});

test("core schema migration is monotonic and non-destructive", () => {
  const writes = [];
  assert.equal(migrateCoreSchema(undefined, (key, value) => writes.push([key, value]), 123), "first-init");
  assert.deepEqual(writes, [["schema", CORE_SCHEMA_VERSION], ["firstInit", 123]]);

  writes.length = 0;
  assert.equal(migrateCoreSchema(undefined, (key, value) => writes.push([key, value]), 999, false), "first-init");
  assert.deepEqual(writes, [["schema", CORE_SCHEMA_VERSION]]);

  writes.length = 0;
  assert.equal(migrateCoreSchema(1, (key, value) => writes.push([key, value]), 456), "migrated");
  assert.deepEqual(writes, [["schema", CORE_SCHEMA_VERSION]]);

  writes.length = 0;
  assert.equal(migrateCoreSchema(CORE_SCHEMA_VERSION, (key, value) => writes.push([key, value]), 789), "current");
  assert.deepEqual(writes, []);
  assert.throws(
    () => migrateCoreSchema(CORE_SCHEMA_VERSION + 1, () => {}, 0),
    /newer than supported/,
  );
});

test("runtime initializes player attachments without resetting them on respawn", async () => {
  const playerState = await text(PLAYER_SRC);
  const source = await text(MAIN_SRC);
  const deploy = await text(MAIN_BP);

  assert.match(playerState, /export function init\(player\)/);
  assert.match(playerState, /applySchemaDefaults\(\s*DYNAMIC_SCHEMA/);
  assert.match(playerState, /applySchemaDefaults\(\s*JSON_SCHEMA/);
  assert.match(playerState, /PLAYER_JSON_DEFAULTS/);
  assert.match(playerState, /export function resetLifecycleState\(player, initialSpawn\)/);
  assert.match(playerState, /set\(player, "showCoords", false\)/);
  assert.match(playerState, /set\(player, "musicCausedByTBS", false\)/);
  assert.match(playerState, /set\(player, "glitchesEnabled", false\)/);
  assert.match(playerState, /set\(player, "pixelateEnabled", false\)/);
  assert.match(source, /playerState\.init\(ev\.player\);/);
  assert.match(deploy, /playerState\.init\(ev\.player\);/);
  assert.match(source, /playerState\.resetLifecycleState\(ev\.player, ev\.initialSpawn\);/);
  assert.match(deploy, /playerState\.resetLifecycleState\(ev\.player, ev\.initialSpawn\);/);
  assert.match(source, /playerState\.init\(ev\.player\);[\s\S]*?if \(ev\.initialSpawn\)/);
  assert.match(deploy, /playerState\.init\(ev\.player\);[\s\S]*?if \(ev\.initialSpawn\)/);
  assert.match(deploy, /portedFeatures\.clearTransientPlayerState\(ev\.player, ev\.initialSpawn\);/);
});

test("one-shot progression is player-scoped and temporary effects are cleared", async () => {
  const source = await text(PROGRESSION_SRC);
  const deploy = await text(PROGRESSION_BP);
  const ported = await text(PORTED_FEATURES);
  const story = await text("TheBrokenScript_Bedrock_2_0/BP/scripts/systems/story_events.js");
  const sourceStory = await text("TheBrokenScript_Bedrock_2_0/src/systems/story_events.js");

  for (const progression of [source, deploy]) {
    assert.match(progression, /hasPersistedAdvancement/);
    assert.match(progression, /persistAdvancement/);
    assert.doesNotMatch(progression, /awarded\.has\(key\)/);
  }
  assert.match(ported, /player\.setDynamicProperty\(HEART_CORRUPTION_UNTIL, undefined\)/);
  assert.match(ported, /player\.setDynamicProperty\(WHY_LEAVE_UNTIL, undefined\)/);
  assert.match(ported, /export function clearTransientPlayerState\(player, initialSpawn = false\)/);
  for (const storyRuntime of [story, sourceStory]) {
    assert.match(storyRuntime, /playerState\.get\(player, "nullBookDelivered"\)/);
    assert.match(storyRuntime, /playerState\.set\(player, "nullBookDelivered", true\)/);
  }
  assert.doesNotMatch(story, /deliveredNullBookPlayers/);
});

test("entity policy makes persistent, transient, and non-persistent state explicit", async () => {
  const integrityArm = JSON.parse(await text("TheBrokenScript_Bedrock_2_0/BP/entities/integrity_arm.json"));
  const tbeAmbush = JSON.parse(await text("TheBrokenScript_Bedrock_2_0/BP/entities/the_broken_end_ambush.json"));
  const tbe = JSON.parse(await text("TheBrokenScript_Bedrock_2_0/BP/entities/the_broken_end.json"));
  const policy = ENTITY_DYNAMIC_PROPERTY_POLICY["tbe:variant"];

  assert.equal(policy.scope, "entity");
  assert.equal(policy.persistence, "persistent");
  assert.equal(policy.javaField, "TheBrokenEndAmbushEntity.variant");
  assert.deepEqual(PERSISTENT_ENTITY_EVIDENCE["tbe:variant"], {
    javaClass: "TheBrokenEndAmbushEntity",
    saveKey: "variant",
  });
  assert.equal(ENTITY_DYNAMIC_PROPERTY_POLICY["tbs:jim_stage_touch"].persistence, "transient");
  assert.ok(TRANSIENT_RUNTIME_STATE.some((entry) => entry.includes("timers")));
  assert.deepEqual(NON_PERSISTENT_ENTITY_TYPES, [
    "thebrokenscript:integrity_arm",
    "thebrokenscript:chord_projectile",
  ]);
  assert.equal(integrityArm["minecraft:entity"].components["minecraft:persistent"], undefined);
  assert.deepEqual(tbeAmbush["minecraft:entity"].components["minecraft:persistent"], {});
  assert.deepEqual(tbe["minecraft:entity"].components["minecraft:persistent"], {});
  const chord = JSON.parse(await text("TheBrokenScript_Bedrock_2_0/BP/entities/chord_projectile.json"));
  assert.equal(chord["minecraft:entity"].components["minecraft:persistent"], undefined);
});
