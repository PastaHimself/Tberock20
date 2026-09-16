import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import test from "node:test";

import {
  ENTITY_FAMILY_CONTRACTS,
  allEntityIds,
  familyForEntity,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/core/entity_family_registry.js";
import {
  CORE_SCHEMA_VERSION,
  PLAYER_COMPATIBILITY_DEFAULTS,
  PLAYER_EXTRA_SCHEMA,
  PLAYER_STATE_SCHEMA,
  WORLD_EXTRA_SCHEMA,
  WORLD_STATE_SCHEMA,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/core/persistence_schema.js";
import {
  CHAT_RESPONSE_DEFINITIONS,
  SOURCE_EVENT_DEFINITIONS,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_rules.js";
import {
  STORY_EVENT_THRESHOLDS,
  STORY_TICKS_PER_DAY,
  STORY_THRESHOLD_OFFSET,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/shared/story_clock_model.js";

const projectRoot = new URL("../TheBrokenScript_Bedrock_2_0/", import.meta.url);

function categoryCounts(rows) {
  return Object.fromEntries(
    Object.entries(rows.reduce((counts, row) => {
      counts[row.category] = (counts[row.category] ?? 0) + 1;
      return counts;
    }, {})).sort(([left], [right]) => left.localeCompare(right)),
  );
}

function schemaSnapshot(schema) {
  return Object.fromEntries(
    Object.entries(schema).map(([key, descriptor]) => {
      const normalized = { ...descriptor };
      if (normalized.javaField === undefined) delete normalized.javaField;
      return [key, normalized];
    }),
  );
}

async function currentSnapshot() {
  const sourceMap = JSON.parse(await readFile(new URL("SOURCE_MAP.json", projectRoot), "utf8"));
  return {
    sourceMap: {
      rows: sourceMap.rows.length,
      categories: categoryCounts(sourceMap.rows),
    },
    horror: {
      eventDefinitions: SOURCE_EVENT_DEFINITIONS,
      chatDefinitions: CHAT_RESPONSE_DEFINITIONS,
    },
    entities: {
      families: ENTITY_FAMILY_CONTRACTS.map(({ key, entityIds }) => ({ key, entityIds })),
      allEntityIds: allEntityIds(),
    },
    persistence: {
      coreSchemaVersion: CORE_SCHEMA_VERSION,
      worldState: schemaSnapshot(WORLD_STATE_SCHEMA),
      worldExtra: schemaSnapshot(WORLD_EXTRA_SCHEMA),
      playerState: schemaSnapshot(PLAYER_STATE_SCHEMA),
      playerExtra: schemaSnapshot(PLAYER_EXTRA_SCHEMA),
      compatibilityDefaults: PLAYER_COMPATIBILITY_DEFAULTS,
    },
    timing: {
      storyTicksPerDay: STORY_TICKS_PER_DAY,
      storyThresholdOffset: STORY_THRESHOLD_OFFSET,
      storyEventThresholds: STORY_EVENT_THRESHOLDS,
    },
  };
}

test("source-backed registries, persistence descriptors, and story timing match the checked-in snapshot", async () => {
  const expected = JSON.parse(await readFile(
    new URL("./fixtures/p2_source_snapshot.json", import.meta.url),
    "utf8",
  ));
  assert.deepEqual(await currentSnapshot(), expected);
});

test("the source-map entity registry resolves every shipped entity, including documented aliases", async () => {
  const sourceMap = JSON.parse(await readFile(new URL("SOURCE_MAP.json", projectRoot), "utf8"));
  const sourceRows = new Map(
    sourceMap.rows
      .filter((row) => ["entity", "painting"].includes(row.category) && row.bedrock_identifier)
      .map((row) => [row.bedrock_identifier, row]),
  );

  for (const entityId of allEntityIds()) {
    const family = familyForEntity(entityId);
    const sourceId = family.sourceMapAliases[entityId] ?? entityId;
    assert.ok(sourceRows.has(sourceId), `${entityId} has no source-map row or alias`);
  }
});
