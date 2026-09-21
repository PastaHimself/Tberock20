import assert from "node:assert/strict";
import fs from "node:fs";
import path from "node:path";
import test from "node:test";

import {
  ENTITY_FAMILY_CONTRACTS,
  allEntityIds,
  familyForEntity,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/core/entity_family_registry.js";
import { isLookingAtEntity } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ai/gaze.js";
import { closestTarget } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ai/targeting_model.js";
import { hasSkyLightAt, skyLightLevelAt } from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ai/visibility.js";

const projectRoot = path.resolve(path.dirname(new URL(import.meta.url).pathname), "..");
const bpEntitiesRoot = path.join(projectRoot, "TheBrokenScript_Bedrock_2_0", "BP", "entities");

function readJson(filePath) {
  return JSON.parse(fs.readFileSync(filePath, "utf8"));
}

function shippedEntityIds() {
  return fs
    .readdirSync(bpEntitiesRoot)
    .filter((file) => file.endsWith(".json"))
    .map((file) => readJson(path.join(bpEntitiesRoot, file))["minecraft:entity"].description.identifier)
    .sort();
}

test("the family registry covers every shipped entity exactly once", () => {
  const actualIds = shippedEntityIds();
  const registeredIds = allEntityIds().sort();

  assert.deepEqual(registeredIds, actualIds);
  assert.equal(new Set(registeredIds).size, registeredIds.length);

  for (const entityId of actualIds) {
    const family = familyForEntity(entityId);
    assert.ok(family, `missing family contract for ${entityId}`);
    assert.ok(family.sourceRoots.length > 0, `${entityId} has no source evidence`);
    for (const field of [
      "attributes",
      "spawn",
      "despawn",
      "targeting",
      "visibility",
      "state",
      "sideEffects",
      "cleanup",
    ]) {
      assert.ok(
        ["implemented", "adapted", "not_applicable"].includes(family.coverage[field]),
        `${entityId} is missing a coverage status for ${field}`,
      );
    }
  }
});

test("every family contract points at shipped runtime, source, and render surfaces", () => {
  const seen = new Set();

  for (const family of ENTITY_FAMILY_CONTRACTS) {
    assert.ok(family.key, "family contract has no key");
    assert.ok(family.runtime.controller, `${family.key} has no controller surface`);
    assert.ok(family.runtime.spawnRules || family.runtime.renderOnly, `${family.key} has no spawn surface`);
    assert.ok(family.sourceRoots.length > 0, `${family.key} has no source roots`);

    for (const entityId of family.entityIds) {
      assert.equal(seen.has(entityId), false, `${entityId} is assigned to multiple families`);
      seen.add(entityId);

      const slug = entityId.split(":")[1];
      assert.equal(
        fs.existsSync(path.join(projectRoot, "TheBrokenScript_Bedrock_2_0", "RP", "entity", `${slug}.entity.json`)),
        true,
        `${entityId} is missing its render definition`,
      );
    }

    assert.equal(fs.existsSync(path.join(projectRoot, family.runtime.controller)), true, `${family.key} controller is missing`);
    if (family.runtime.spawnRules) {
      assert.equal(fs.existsSync(path.join(projectRoot, family.runtime.spawnRules)), true, `${family.key} spawn rules are missing`);
    }
  }

  assert.deepEqual([...seen].sort(), shippedEntityIds());
});

test("the registry is reconciled with source-map entity and placement rows", () => {
  const sourceMap = readJson(path.join(projectRoot, "TheBrokenScript_Bedrock_2_0", "SOURCE_MAP.json"));
  const sourceRows = new Map(
    sourceMap.rows
      .filter((row) => ["entity", "painting"].includes(row.category) && row.bedrock_identifier)
      .map((row) => [row.bedrock_identifier, row]),
  );

  for (const entityId of shippedEntityIds()) {
    const family = familyForEntity(entityId);
    const sourceId = family.sourceMapAliases[entityId] ?? entityId;
    const row = sourceRows.get(sourceId);
    assert.ok(row, `${entityId} is not represented in SOURCE_MAP.json`);
    assert.ok(row.bedrock_files.some((file) => file === `BP/entities/${sourceId.split(":")[1]}.json`), `${entityId} source-map row omits its BP definition`);
    assert.ok(row.bedrock_files.some((file) => file === `RP/entity/${sourceId.split(":")[1]}.entity.json`), `${entityId} source-map row omits its RP definition`);
  }
});

test("target acquisition rejects cross-dimension and spectator candidates", () => {
  const target = {
    dimension: { id: "minecraft:overworld" },
    location: { x: 8, y: 64, z: 0 },
    getGameMode: () => "survival",
  };
  const spectator = {
    dimension: { id: "minecraft:overworld" },
    location: { x: 1, y: 64, z: 0 },
    getGameMode: () => "Spectator",
  };
  const netherTarget = {
    dimension: { id: "minecraft:nether" },
    location: { x: 0.5, y: 64, z: 0 },
    getGameMode: () => "survival",
  };

  assert.equal(
    closestTarget([netherTarget, spectator, target], { x: 0, y: 64, z: 0 }, 16, {
      dimensionId: "minecraft:overworld",
    }),
    target,
  );
});

test("gaze checks entity hitbox samples and rejects a blocked ray", () => {
  const player = {
    dimension: {
      id: "minecraft:overworld",
      getBlockFromRay: () => undefined,
    },
    getHeadLocation: () => ({ x: 0, y: 1.62, z: 0 }),
    getViewDirection: () => ({ x: 0, y: 0, z: 1 }),
  };
  const hitbox = {
    dimension: player.dimension,
    location: { x: 2, y: 0, z: 10 },
    getAABB: () => ({
      center: { x: 1.5, y: 1, z: 10 },
      extent: { x: 2.5, y: 1, z: 0.5 },
    }),
  };

  assert.equal(isLookingAtEntity(player, hitbox, 8), true);

  const blockedPlayer = {
    ...player,
    dimension: {
      ...player.dimension,
      getBlockFromRay: () => ({
        block: { location: { x: 1, y: 1, z: 1 } },
        faceLocation: { x: 0, y: 0, z: 0 },
      }),
    },
  };
  assert.equal(isLookingAtEntity(blockedPlayer, hitbox, 8), false);
});

test("sky-light gates query the documented dimension method at the sampled block", () => {
  let sampled;
  const dimension = {
    getSkyLightLevel: (location) => {
      sampled = location;
      return 15;
    },
  };

  assert.equal(hasSkyLightAt(dimension, { x: 4.9, y: 64.9, z: -2.1 }), true);
  assert.deepEqual(sampled, { x: 4, y: 65, z: -3 });
  assert.equal(skyLightLevelAt({ getSkyLightLevel: () => 1 }, { x: 0, y: 64, z: 0 }), 1);
  assert.equal(hasSkyLightAt({}, { x: 0, y: 64, z: 0 }), false);
});

test("spawn evaluation is scoped to each player and uses supported sky-light queries", () => {
  const spawnDirector = fs.readFileSync(
    path.join(projectRoot, "TheBrokenScript_Bedrock_2_0", "BP", "scripts", "systems", "spawn_director.js"),
    "utf8",
  );
  const nullRules = fs.readFileSync(
    path.join(projectRoot, "TheBrokenScript_Bedrock_2_0", "BP", "scripts", "entities", "null", "null_spawn_rules.js"),
    "utf8",
  );
  const tbeRules = fs.readFileSync(
    path.join(projectRoot, "TheBrokenScript_Bedrock_2_0", "BP", "scripts", "entities", "tbe", "tbe_spawn_rules.js"),
    "utf8",
  );
  const circuitRules = fs.readFileSync(
    path.join(projectRoot, "TheBrokenScript_Bedrock_2_0", "BP", "scripts", "entities", "circuit", "circuit_spawn_rules.js"),
    "utf8",
  );
  const circuitSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "CircuitStalkConditions.java"),
    "utf8",
  );
  const nullSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "NullConditions.java"),
    "utf8",
  );
  const nullMazeSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "NullMazeConditions.java"),
    "utf8",
  );
  const circuitMineshaftSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "CircuitMineshaftConditions.java"),
    "utf8",
  );
  const tbeSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "TBEConditions.java"),
    "utf8",
  );
  const curvedSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "CurvedConditions.java"),
    "utf8",
  );
  const herobrineSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "HerobrineConditions.java"),
    "utf8",
  );
  const obliterationSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "ObliterationConditions.java"),
    "utf8",
  );
  const tbsEntitiesSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "registry", "TBSEntities.java"),
    "utf8",
  );
  const stalkRules = fs.readFileSync(
    path.join(projectRoot, "TheBrokenScript_Bedrock_2_0", "BP", "scripts", "entities", "stalk", "stalk_spawn_rules.js"),
    "utf8",
  );

  assert.match(spawnDirector, /for\s*\(const player of players\)/);
  assert.match(spawnDirector, /player,\s*players:[\s\S]*gameTime/);
  assert.match(nullRules, /hasSkyLightAt/);
  assert.match(tbeRules, /hasSkyLightAt/);

  const corruptionSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "CorruptionConditions.java"),
    "utf8",
  );
  const defaultSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "TBSDefaultConditions.java"),
    "utf8",
  );
  const nameTagSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "NameTagConditions.java"),
    "utf8",
  );
  const nothingWatcherSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "NothingWatcherConditions.java"),
    "utf8",
  );
  const mazeShadowSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "MazeShadowConditions.java"),
    "utf8",
  );
  const miscRules = fs.readFileSync(
    path.join(projectRoot, "TheBrokenScript_Bedrock_2_0", "BP", "scripts", "entities", "misc", "misc_spawn_rules.js"),
    "utf8",
  );

  assert.match(corruptionSource, /getDisableVoidHoles\(\)/);
  assert.match(corruptionSource, /world\.getLevel\(\)\.isNight\(\)/);
  assert.match(miscRules, /config\.get\("world\.disableVoidHoles"\)/);
  assert.match(miscRules, /if \(!isNight\(\)\) return false;/);

  assert.match(defaultSource, /getHasRam2DieJoined\(\)/);
  assert.match(defaultSource, /getHasTriggeredRam2Die\(\)/);
  assert.match(miscRules, /worldState\.get\("hasRam2DieJoined"\)/);
  assert.match(miscRules, /worldState\.get\("hasTriggeredRam2Die"\)/);
  assert.match(miscRules, /countType\(dimension, "thebrokenscript:hetzer"\) > 0/);

  assert.match(nameTagSource, /getBrightness\(LightLayer\.SKY, pos\) == 0/);
  assert.match(miscRules, /id: "name_tag"/);
  assert.match(miscRules, /if \(sky !== 0\) return false;/);

  assert.match(nothingWatcherSource, /TBSDimensions\.NOTHING/);
  assert.match(nothingWatcherSource, /random\.nextFloat\(\) > 0\.02/);
  assert.match(miscRules, /dimension\.id !== "thebrokenscript:nothing"/);
  assert.match(miscRules, /countType\(dimension, "thebrokenscript:nothing_watcher"\) > 35/);

  assert.match(mazeShadowSource, /TBSDimensions\.NULL_TORTURE/);
  assert.match(mazeShadowSource, /Blocks\.BEDROCK/);
  assert.match(miscRules, /id: "maze_shadows"/);
  assert.match(miscRules, /hasBedrockNearMazeShadow/);

  // The Java predicates own their suppression rules individually. The
  // director must not impose config/Arena gates on every condition.
  assert.doesNotMatch(spawnDirector, /config\.get\("danger\.disableSpawningEntities"\)/);
  assert.doesNotMatch(spawnDirector, /bossHooks\.isArenaPhase1\(\)/);

  // TBEConditions indexes its chance table with the world's moon phase.
  // Reading moon phase from Dimension silently collapsed the old adapter to 0.
  assert.match(tbeSource, /int moonPhase = world\.getMoonPhase\(\)/);
  assert.match(tbeRules, /Number\(world\.getMoonPhase\(\)\)/);
  assert.doesNotMatch(tbeRules, /dimension\.getMoonPhase/);
  assert.match(tbeRules, /world\.gameRules\?\.doMobSpawning !== true/);
  assert.match(tbeRules, /world\.getDifficulty\(\)/);
  assert.match(tbeRules, /hasOtherBrokenEndsInRange\(dimension, location\)/);
  assert.match(tbeRules, /nearestPlayerDistance\(ctx\.players, dimension, location\)/);

  const fracturedSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "FracturedConditions.java"),
    "utf8",
  );
  const feverSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "FeverStalkConditions.java"),
    "utf8",
  );
  const bossRules = fs.readFileSync(
    path.join(projectRoot, "TheBrokenScript_Bedrock_2_0", "BP", "scripts", "entities", "boss", "boss_spawn_rules.js"),
    "utf8",
  );

  const siluetSource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "SiluetConditions.java"),
    "utf8",
  );
  const entitySource = fs.readFileSync(
    path.join(projectRoot, "decompiled", "net", "thebrokenscript", "api", "entity", "conditions", "TBSEntityConditions.java"),
    "utf8",
  );
  const humanoidRules = fs.readFileSync(
    path.join(projectRoot, "TheBrokenScript_Bedrock_2_0", "BP", "scripts", "entities", "humanoid", "humanoid_spawn_rules.js"),
    "utf8",
  );

  assert.match(siluetSource, /TBSEntities\.HE[\s\S]*?random\.nextFloat\(\) > 0\.1/);
  assert.match(humanoidRules, /const typeId = weightedType\(SILUET_TYPES\)/);
  assert.match(humanoidRules, /typeId === "thebrokenscript:he" && Math\.random\(\) > 0\.1/);
  assert.doesNotMatch(humanoidRules, /\? "thebrokenscript:he" : "thebrokenscript:siluet"/);
  assert.match(humanoidRules, /hasPlayerWithSkyLight\(ctx\.players, dimension, location, 75, 2\)/);

  assert.match(entitySource, /TBSEntities\.HETZER/);
  assert.match(entitySource, /PhantomPlayerEntity\.class/);
  for (const id of ["fake_player", "hetzer", "follow", "deceiver"]) {
    assert.match(humanoidRules, new RegExp(`"thebrokenscript:${id}"`));
  }
  assert.match(humanoidRules, /countType\(dimension, "thebrokenscript:phantom_player"\) < 1/);
  assert.match(humanoidRules, /worldState\.set\("rareSpawnDelay", 12000\)/);

  // FracturedConditions is a Corrupted Moon natural spawn, not an Overworld
  // isNullHere spawn. Fever keeps the source altitude-weighted gate.
  assert.match(fracturedSource, /TBSDimensions\.CORRUPTED_MOON/);
  assert.match(fracturedSource, /getCanFracturedSpawn\(\)/);
  assert.match(bossRules, /FRACTURED_DIMENSION = "thebrokenscript:the_moon"/);
  assert.match(bossRules, /!worldState\.get\("canFracturedSpawn"\)/);
  assert.match(bossRules, /hasOtherJims\(dimension, location\)/);

  assert.match(feverSource, /double minY = 130\.0/);
  assert.match(feverSource, /double maxY = 320\.0/);
  assert.match(feverSource, /double maxChance = 0\.75/);
  assert.match(bossRules, /\(player\.location\.y - 130\) \/ \(320 - 130\)/);
  assert.match(bossRules, /normalized \* 0\.75/);
  assert.match(bossRules, /hasOtherFevers\(dimension, location\)/);

  // Stalk-family predicates keep progression/time/type gates from Java.
  assert.match(curvedSource, /BaseMonsterExtKt\.isInCave/);
  assert.match(stalkRules, /const playerInCave = isInCave\(player\.dimension, player\.location\)/);
  assert.match(stalkRules, /isInCave\(player\.dimension, location\) !== playerInCave/);

  assert.match(herobrineSource, /getHasBuiltHerobrineShrine\(\)/);
  assert.match(stalkRules, /!worldState\.get\("hasBuiltHerobrineShrine"\)/);

  assert.match(obliterationSource, /world\.getLevel\(\)\.isDay\(\)/);
  assert.match(stalkRules, /if \(!isDay\(\)\) return false;/);

  assert.match(tbsEntitiesSource, /SUB_ANOMALY_1[\s\S]*?spawns = \(Holder\)TBSSpawnConditions\.ANOMALY/);
  assert.doesNotMatch(tbsEntitiesSource, /SUB_ANOMALY_2[\s\S]{0,800}?spawns = \(Holder\)TBSSpawnConditions\.ANOMALY/);
  assert.match(stalkRules, /"thebrokenscript:sub_anomaly_1"/);
  assert.doesNotMatch(stalkRules, /Math\.random\(\) < 0\.5 \? "thebrokenscript:sub_anomaly_1"/);

  // NullConditions applies the natural-spawn gates at the candidate position,
  // including peaceful/doMobSpawning/flat-world and the complete exclusion set.
  assert.match(nullSource, /world\.getDifficulty\(\) == Difficulty\.PEACEFUL/);
  assert.match(nullSource, /GameRules\.RULE_DOMOBSPAWNING/);
  assert.match(nullSource, /NullInvadeBaseEntity\.class/);
  assert.match(nullRules, /world\.getDifficulty\(\)/);
  assert.match(nullRules, /world\.gameRules\?\.doMobSpawning !== true/);
  assert.match(nullRules, /worldState\.get\("isFlat"\).*Math\.random\(\) > 0\.001/);
  assert.match(nullRules, /"thebrokenscript:null_invade_base"/);
  assert.match(nullRules, /hasSkyLightAt\(dim, candidate\)/);
  assert.match(nullRules, /entityFinder\.hasEntitiesInRange\(dim, candidate, NULL_EXCLUSION_RANGE, NULL_FAMILY\)/);
  assert.match(nullRules, /hasPlayerInRange\(ctx\.players, dim, candidate, NULL_PLAYER_RANGE\)/);

  assert.match(nullMazeSource, /this\.mazeFloorChance = 0\.09/);
  assert.match(nullMazeSource, /this\.defaultChance = 0\.025/);
  assert.match(nullRules, /dimension\.id !== "thebrokenscript:clan_void"|dim\.id !== "thebrokenscript:clan_void"/);
  assert.match(nullRules, /NULL_MAZE_FLOOR_CHANCE = 0\.09/);
  assert.match(nullRules, /NULL_MAZE_DEFAULT_CHANCE = 0\.025/);
  assert.match(nullRules, /if \(y >= 226 && y <= 229\) continue/);
  assert.match(nullRules, /countNullMaze\(dim\) >= NULL_MAZE_MAX_COUNT/);

  assert.match(circuitMineshaftSource, /0\.065/);
  assert.match(circuitMineshaftSource, /StructureTags\.MINESHAFT/);
  assert.match(circuitRules, /CIRCUIT_MINESHAFT_CHANCE = 0\.065/);
  assert.match(circuitRules, /function looksLikeMineshaft/);
  assert.match(circuitRules, /id: "circuit_mineshaft"/);
  assert.match(circuitRules, /"thebrokenscript:circuit_mineshaft_walk"[\s\S]*?"thebrokenscript:circuit_mineshaft_stare"/);
  assert.match(circuitRules, /looksLikeMineshaft\(dim, player\.location\)/);

  // CircuitStalkConditions requires isNullHere=true. The old Bedrock rule
  // inverted this gate and then reported success without spawning the stalk.
  assert.match(circuitSource, /if\s*\(!LevelExt\.INSTANCE\.getVars\([\s\S]*?\.isNullHere\(\)\)\s*\{\s*return false;/);
  assert.match(circuitRules, /if\s*\(!worldState\.get\("isNullHere"\)\)\s*return false;/);
  assert.doesNotMatch(circuitRules, /if\s*\(worldState\.get\("isNullHere"\)\)\s*return false;/);
  assert.match(circuitRules, /world\.gameRules\?\.doMobSpawning !== true/);
  assert.match(circuitRules, /world\.getDifficulty\(\)/);
  assert.match(circuitRules, /spawnHelpers\.trySummon\(dim,\s*"thebrokenscript:circuit_stalk",\s*candidate\)/);
  assert.match(circuitRules, /entityFinder\.hasEntitiesInRange\(dim,\s*candidate,\s*CIRCUIT_EXCLUSION_RANGE/);

  const spawnIndex = circuitRules.indexOf("spawnHelpers.trySummon");
  assert.ok(spawnIndex >= 0, "circuit stalk rule must perform the spawn");
  assert.ok(
    circuitRules.indexOf('worldState.set("circuitSpawnDelay"', spawnIndex) > spawnIndex,
    "circuit spawn delay must only mutate after a successful summon",
  );
  assert.ok(
    circuitRules.indexOf('worldState.set("hasCircuitSpawned"', spawnIndex) > spawnIndex,
    "hasCircuitSpawned must only mutate after a successful summon",
  );
});
