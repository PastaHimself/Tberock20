import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import path from "node:path";
import test from "node:test";
import { fileURLToPath } from "node:url";

const ROOT = path.resolve(path.dirname(fileURLToPath(import.meta.url)), "..");
const CORE_STATE = path.join(ROOT, "TheBrokenScript_Bedrock_2_0/BP/scripts/core/state.js");
const WORLD_STATE = path.join(ROOT, "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/world_state.js");
const PLAYER_STATE = path.join(ROOT, "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/player_state.js");
const MAP_VARIABLES = path.join(ROOT, "decompiled/net/thebrokenscript/data/MapVariables.java");
const PLAYER_VARIABLES = path.join(ROOT, "decompiled/net/thebrokenscript/data/PlayerVariables.java");
const PLAYER_VARS_SYNCER = path.join(ROOT, "decompiled/net/thebrokenscript/data/PlayerVarsSyncer.java");
const TBS_DIMENSIONS = path.join(ROOT, "decompiled/net/thebrokenscript/registry/TBSDimensions.java");

let moduleNonce = 0;

function source(pathname) {
  return readFileSync(pathname, "utf8");
}

function moduleUrl(text, label) {
  moduleNonce += 1;
  const tagged = `${text}\n//# sourceURL=tbs-regression-${label}-${moduleNonce}.mjs\n`;
  return `data:text/javascript;base64,${Buffer.from(tagged).toString("base64")}`;
}

async function loadCoreState(world, label) {
  globalThis.__tbsRegressionWorld = world;
  const transformed = source(CORE_STATE).replace(
    'import { world } from "@minecraft/server";',
    "const world = globalThis.__tbsRegressionWorld;",
  );
  return import(moduleUrl(transformed, label));
}

async function loadStateModel(pathname, stateAdapter, label) {
  globalThis.__tbsRegressionState = stateAdapter;
  const transformed = source(pathname).replace(
    'import * as state from "../core/state.js";',
    "const state = globalThis.__tbsRegressionState;",
  );
  return import(moduleUrl(transformed, label));
}

function dynamicPropertyBag() {
  const properties = new Map();
  return {
    properties,
    getDynamicProperty(key) {
      return properties.get(key);
    },
    setDynamicProperty(key, value) {
      if (value === undefined) properties.delete(key);
      else properties.set(key, value);
    },
    getDynamicPropertyIds() {
      return [...properties.keys()];
    },
  };
}

function jsDefaults(pathname) {
  const text = source(pathname);
  const match = text.match(/const DEFAULTS = (\{[\s\S]*?\n\});/);
  assert.ok(match, `DEFAULTS table missing from ${pathname}`);
  return Function("INT_MAX", `"use strict"; return (${match[1]});`)(2147483647);
}

function parameterNames(signature) {
  return signature.split(",").map((parameter) => {
    const match = parameter.trim().match(/([A-Za-z_$][\w$]*)$/);
    assert.ok(match, `cannot parse constructor parameter: ${parameter}`);
    return match[1];
  });
}

function javaLiteral(expression) {
  const value = expression.trim();
  if (value === "true") return true;
  if (value === "false") return false;
  if (value === "Integer.MAX_VALUE") return 2147483647;
  if (/^CameraMode\.[A-Z0-9_]+$/.test(value)) return value.slice("CameraMode.".length);
  if (/^"(?:[^"\\]|\\.)*"$/.test(value)) return JSON.parse(value);
  if (/^-?\d+(?:\.\d+)?[Lf]?$/.test(value)) return Number(value.replace(/[Lf]$/, ""));
  return undefined;
}

function javaConstructorDefaults(pathname, className) {
  const text = source(pathname);
  const primary = text.match(new RegExp(`public ${className}\\(([\\s\\S]*?)\\) \\{`));
  assert.ok(primary, `${className} primary constructor missing`);
  const fields = parameterNames(primary[1]);

  const synthetic = text.match(
    new RegExp(`public /\\* synthetic \\*/ ${className}\\(([\\s\\S]*?)\\) \\{([\\s\\S]*?)\\n\\s*this\\(`),
  );
  assert.ok(synthetic, `${className} synthetic default constructor missing`);
  const aliases = parameterNames(synthetic[1]).slice(0, fields.length);
  assert.equal(aliases.length, fields.length);

  const aliasDefaults = new Map();
  for (const match of synthetic[2].matchAll(
    /if\s*\(\([^)]*\)\s*!=\s*0\)\s*\{\s*([A-Za-z_$][\w$]*)\s*=\s*([^;]+);\s*\}/g,
  )) {
    const normalized = javaLiteral(match[2]);
    if (normalized !== undefined) aliasDefaults.set(match[1], normalized);
  }

  return Object.fromEntries(
    fields.flatMap((field, index) =>
      aliasDefaults.has(aliases[index]) ? [[field, aliasDefaults.get(aliases[index])]] : [],
    ),
  );
}

const SOURCE_SNAPSHOT = {
  map: {
    dataVersion: 3,
    isFirstJoin: true,
    daylightCycle: true,
    daylightCycleEventTimer: 0,
    moonTextureIndex: -1,
    moonCrackIndex: -1,
    bossStructX: 2147483647,
    bossStructZ: 2147483647,
    clanVoidX: 2147483647,
    clanVoidZ: 2147483647,
    dayAX: 2147483647,
    dayAZ: 2147483647,
    entitySpawnDelay: 0,
    circuitSpawnDelay: 0,
    rareSpawnDelay: 0,
    circuitInhabitedDelay: 0,
  },
  player: {
    dataVersion: 2,
    entityReputation: 50,
    moonGlitchDuration: 0,
    ticksUntilExit: 0,
    isDesync: false,
    lookedAtOblit: false,
    cameraMode: "FIRST_PERSON",
    baseRescanCooldown: 0,
    forceMetaParanoia: false,
    glitchesEnabled: false,
    dreamEnabled: false,
    voidBox: true,
  },
  dimensions: [
    "clan_void",
    "null_torture",
    "the_moon",
    "nowhere",
    "limbo",
    "lucid",
    "nothing",
    "protected_void",
    "library",
    "concrete",
    "stage2",
    "void_shadow",
  ],
};

test("source default tables stay snapshotted and Bedrock scalar defaults match Java", () => {
  const javaMap = javaConstructorDefaults(MAP_VARIABLES, "MapVariables");
  const javaPlayer = javaConstructorDefaults(PLAYER_VARIABLES, "PlayerVariables");
  const bedrockMap = jsDefaults(WORLD_STATE);
  const bedrockPlayer = jsDefaults(PLAYER_STATE);

  assert.deepEqual(
    Object.fromEntries(Object.keys(SOURCE_SNAPSHOT.map).map((key) => [key, javaMap[key]])),
    SOURCE_SNAPSHOT.map,
  );
  assert.deepEqual(
    Object.fromEntries(Object.keys(SOURCE_SNAPSHOT.player).map((key) => [key, javaPlayer[key]])),
    SOURCE_SNAPSHOT.player,
  );

  const mapIntersection = Object.keys(javaMap).filter((key) => key in bedrockMap);
  const playerIntersection = Object.keys(javaPlayer).filter((key) => key in bedrockPlayer);
  assert.ok(mapIntersection.length >= 50, "expected broad MapVariables scalar parity coverage");
  assert.ok(playerIntersection.length >= 45, "expected broad PlayerVariables scalar parity coverage");
  for (const key of mapIntersection) assert.equal(bedrockMap[key], javaMap[key], `MapVariables.${key}`);
  for (const key of playerIntersection) assert.equal(bedrockPlayer[key], javaPlayer[key], `PlayerVariables.${key}`);
});

test("Java dimension registry stays source-snapshotted at the 12 registered realms", () => {
  const java = source(TBS_DIMENSIONS);
  const dimensions = [...java.matchAll(/INSTANCE\.dim\("([a-z0-9_]+)"\)/g)].map((match) => match[1]);
  assert.deepEqual(dimensions, SOURCE_SNAPSHOT.dimensions);
  assert.equal(dimensions.length, 12);
});

test("core persistence JSON round-trips and enforces the exact 30,000-character boundary", async () => {
  const world = dynamicPropertyBag();
  const player = dynamicPropertyBag();
  const state = await loadCoreState(world, "json");

  const nested = { stage: 3, flags: [true, false], nested: { name: "null" } };
  state.setWorldJSON("nested", nested);
  assert.deepEqual(state.getWorldJSON("nested"), nested);
  state.setPlayerJSON(player, "nested", nested);
  assert.deepEqual(state.getPlayerJSON(player, "nested"), nested);

  state.setWorldJSON("limit", "x".repeat(29998));
  assert.equal(world.properties.get("tbs:wj:limit").length, 30000);
  assert.throws(() => state.setWorldJSON("too_big", "x".repeat(29999)), /exceeds 30000 bytes \(30001\)/);

  world.setDynamicProperty("tbs:wj:corrupt", "{");
  assert.deepEqual(state.getWorldJSON("corrupt", { recovered: true }), { recovered: true });
  assert.equal(world.getDynamicProperty("tbs:wj:corrupt"), undefined);
  world.setDynamicProperty("tbs:wj:not_string", 7);
  assert.equal(state.getWorldJSON("not_string", "fallback"), "fallback");

  assert.throws(() => state.setWorld("object", {}), /unsupported value type 'object'/);
  assert.throws(() => state.setPlayer(player, "null", null), /unsupported value type 'object'/);
});

test("persistence metadata defaults are one-time while last-seen/load values advance", async () => {
  const world = dynamicPropertyBag();
  const player = dynamicPropertyBag();
  const state = await loadCoreState(world, "metadata");
  const originalNow = Date.now;
  let now = 1000;
  Date.now = () => now;
  try {
    state.init();
    assert.equal(world.getDynamicProperty("tbs:meta:schema"), 1);
    assert.equal(world.getDynamicProperty("tbs:meta:firstInit"), 1000);
    assert.equal(world.getDynamicProperty("tbs:meta:lastLoad"), 1000);

    now = 2000;
    state.init();
    assert.equal(world.getDynamicProperty("tbs:meta:firstInit"), 1000);
    assert.equal(world.getDynamicProperty("tbs:meta:lastLoad"), 2000);

    state.ensurePlayer(player);
    assert.equal(player.getDynamicProperty("tbs:p:firstSeen"), 2000);
    assert.equal(player.getDynamicProperty("tbs:p:lastSeen"), 2000);
    now = 3000;
    state.ensurePlayer(player);
    assert.equal(player.getDynamicProperty("tbs:p:firstSeen"), 2000);
    assert.equal(player.getDynamicProperty("tbs:p:lastSeen"), 3000);
  } finally {
    Date.now = originalNow;
  }
});

test("world-state migration is additive and never overwrites persisted legacy values", async () => {
  const values = new Map([
    ["mv.dataVersion", 1],
    ["mv.hasNullSpawned", true],
    ["mv.code", "legacy-code"],
  ]);
  const adapter = {
    getWorld(key, fallback) {
      return values.has(key) ? values.get(key) : fallback;
    },
    setWorld(key, value) {
      values.set(key, value);
    },
  };
  const worldState = await loadStateModel(WORLD_STATE, adapter, "world-migration");

  worldState.init();
  assert.equal(values.get("mv.dataVersion"), 1);
  assert.equal(values.get("mv.hasNullSpawned"), true);
  assert.equal(values.get("mv.code"), "legacy-code");
  assert.equal(values.get("mv.isFirstJoin"), true);
  assert.equal(values.get("mv.daylightCycle"), true);
  assert.equal(values.get("mv.bossStructX"), 2147483647);
  assert.throws(() => worldState.get("notAField"), /unknown key/);
  assert.throws(() => worldState.set("notAField", 1), /unknown key/);
});

test("player state remains owner-local and preserves source negative/threshold transitions", async () => {
  const javaVars = source(PLAYER_VARIABLES);
  const javaSyncer = source(PLAYER_VARS_SYNCER);
  assert.match(javaVars, /return this\.forceMetaParanoia \|\| this\.isDesync \|\| this\.lookedAtOblit;/);
  assert.match(javaVars, /return this\.moonGlitchDuration > 0\.0;/);
  assert.match(javaVars, /this\.moonGlitchDuration = value \? 1600\.0 : 0\.0;/);
  assert.match(javaSyncer, /setVars\(player, PlayerExt\.INSTANCE\.getVars\(orig\)\)/);

  const stores = new WeakMap();
  function store(player) {
    let values = stores.get(player);
    if (!values) {
      values = new Map();
      stores.set(player, values);
    }
    return values;
  }
  const adapter = {
    getPlayer(player, key, fallback) {
      const values = store(player);
      return values.has(key) ? values.get(key) : fallback;
    },
    setPlayer(player, key, value) {
      store(player).set(key, value);
    },
  };
  const playerState = await loadStateModel(PLAYER_STATE, adapter, "player-ownership");
  const playerA = {};
  const playerB = {};

  assert.equal(playerState.get(playerA, "entityReputation"), 50);
  assert.equal(playerState.get(playerB, "entityReputation"), 50);
  playerState.set(playerA, "entityReputation", 12);
  playerState.set(playerB, "entityReputation", 91);
  assert.equal(playerState.get(playerA, "entityReputation"), 12);
  assert.equal(playerState.get(playerB, "entityReputation"), 91);

  assert.equal(playerState.isMetaParanoia(playerA), false);
  playerState.set(playerA, "isDesync", true);
  assert.equal(playerState.isMetaParanoia(playerA), true);
  assert.equal(playerState.isMetaParanoia(playerB), false);
  playerState.set(playerA, "isDesync", false);
  playerState.set(playerA, "lookedAtOblit", true);
  assert.equal(playerState.isMetaParanoia(playerA), true);
  playerState.set(playerA, "lookedAtOblit", false);
  playerState.set(playerA, "forceMetaParanoia", true);
  assert.equal(playerState.isMetaParanoia(playerA), true);

  assert.equal(playerState.MOON_GLITCH_DURATION_SECS, 80);
  assert.equal(playerState.MOON_GLITCH_DURATION_TICKS, 1600);
  playerState.setMoonGlitch(playerA, true);
  assert.equal(playerState.get(playerA, "moonGlitchDuration"), 1600);
  assert.equal(playerState.get(playerB, "moonGlitchDuration"), 0);
  playerState.setMoonGlitch(playerA, false);
  assert.equal(playerState.get(playerA, "moonGlitchDuration"), 0);
});
