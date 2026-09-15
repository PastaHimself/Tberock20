// Source-backed inventory for the entity-family parity work in Todo.md item 7.
// This module is deliberately dependency-free so CI can audit the shipped pack
// without loading the Bedrock runtime.

/** @typedef {"implemented" | "adapted" | "not_applicable"} CoverageStatus */
/** @typedef {{attributes: CoverageStatus, spawn: CoverageStatus, despawn: CoverageStatus, targeting: CoverageStatus, visibility: CoverageStatus, state: CoverageStatus, sideEffects: CoverageStatus, cleanup: CoverageStatus}} Coverage */

/** @type {Coverage} */
const BEHAVIOR_COVERAGE = Object.freeze({
  attributes: "implemented",
  spawn: "implemented",
  despawn: "implemented",
  targeting: "implemented",
  visibility: "implemented",
  state: "implemented",
  sideEffects: "implemented",
  cleanup: "implemented",
});

/** @type {Coverage} */
const RENDER_ONLY_COVERAGE = Object.freeze({
  attributes: "not_applicable",
  spawn: "not_applicable",
  despawn: "not_applicable",
  targeting: "not_applicable",
  visibility: "implemented",
  state: "not_applicable",
  sideEffects: "adapted",
  cleanup: "implemented",
});

/**
 * @param {{key: string, entityIds: string[], bedrockFamilies: string[], runtime: {controller: string, spawnRules: string | null, renderOnly?: boolean}, sourceRoots: string[], coverage?: Coverage, adaptations: string[], sourceMapAliases?: {[entityId: string]: string}}} input
 */
function familyContract({
  key,
  entityIds,
  bedrockFamilies,
  runtime,
  sourceRoots,
  coverage = BEHAVIOR_COVERAGE,
  adaptations,
  sourceMapAliases = {},
}) {
  return Object.freeze({
    key,
    entityIds: Object.freeze([...entityIds]),
    bedrockFamilies: Object.freeze([...bedrockFamilies]),
    runtime: Object.freeze({ ...runtime }),
    sourceRoots: Object.freeze([...sourceRoots]),
    coverage,
    adaptations: Object.freeze([...adaptations]),
    sourceMapAliases: Object.freeze({ ...sourceMapAliases }),
  });
}

export const ENTITY_FAMILY_CONTRACTS = Object.freeze([
  familyContract({
    key: "circuit",
    entityIds: [
      "thebrokenscript:circuit",
      "thebrokenscript:circuit_mineshaft_flee",
      "thebrokenscript:circuit_mineshaft_stare",
      "thebrokenscript:circuit_mineshaft_walk",
      "thebrokenscript:circuit_stalk",
      "thebrokenscript:circuit_stare",
    ],
    bedrockFamilies: ["thebrokenscript_circuit"],
    runtime: {
      controller: "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/circuit/circuit_controller.js",
      spawnRules: "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/circuit/circuit_spawn_rules.js",
    },
    sourceRoots: ["decompiled/net/thebrokenscript/entity/circuit"],
    adaptations: [
      "player gaze uses a hitbox-aware cone and Bedrock raycast",
      "mine-shaft variants retain shared transition and cleanup handling",
    ],
  }),
  familyContract({
    key: "null",
    entityIds: [
      "thebrokenscript:null_chase",
      "thebrokenscript:null_endgame",
      "thebrokenscript:null_flying",
      "thebrokenscript:null_invade_base",
      "thebrokenscript:null_is_here",
      "thebrokenscript:null_maze",
      "thebrokenscript:null_mining",
      "thebrokenscript:null_scare",
      "thebrokenscript:null_unbeatable_bossfight",
      "thebrokenscript:null_watching",
      "thebrokenscript:nulll",
    ],
    bedrockFamilies: ["thebrokenscript_null"],
    runtime: {
      controller: "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/null/null_controller.js",
      spawnRules: "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/null/null_spawn_rules.js",
    },
    sourceRoots: ["decompiled/net/thebrokenscript/entity/nullent"],
    sourceMapAliases: { "thebrokenscript:null_chase": "thebrokenscript:nulll" },
    adaptations: [
      "pursuit targets are constrained to the entity dimension",
      "dimension changes use the safe Bedrock teleport path",
      "watching/scare visibility uses the shared gaze contract",
    ],
  }),
  familyContract({
    key: "tbe",
    entityIds: [
      "thebrokenscript:the_broken_end",
      "thebrokenscript:the_broken_end_ambush",
      "thebrokenscript:the_broken_end_curious",
      "thebrokenscript:the_broken_end_stalk",
    ],
    bedrockFamilies: ["thebrokenscript_tbe"],
    runtime: {
      controller: "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/tbe/tbe_controller.js",
      spawnRules: "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/tbe/tbe_spawn_rules.js",
    },
    sourceRoots: ["decompiled/net/thebrokenscript/entity/tbe"],
    adaptations: [
      "sky checks use Dimension.getSkyLightLevel when available",
      "player ordering is preserved while the nearest target stays dimension-safe",
    ],
  }),
  familyContract({
    key: "humanoid",
    entityIds: [
      "thebrokenscript:deceiver",
      "thebrokenscript:faraway",
      "thebrokenscript:he",
      "thebrokenscript:he_chase",
      "thebrokenscript:he_hallucination",
      "thebrokenscript:siluet",
      "thebrokenscript:siluet_chase",
      "thebrokenscript:siluet_hallucination",
      "thebrokenscript:siluet_stare",
      "thebrokenscript:stare",
    ],
    bedrockFamilies: ["thebrokenscript_humanoid"],
    runtime: {
      controller: "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/humanoid/humanoid_controller.js",
      spawnRules: "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/humanoid/humanoid_spawn_rules.js",
    },
    sourceRoots: [
      "decompiled/net/thebrokenscript/entity/siluet",
      "decompiled/net/thebrokenscript/entity/players",
    ],
    adaptations: [
      "line-of-sight checks share the same raycast boundary as gaze checks",
      "hallucination and chase variants keep their server-side timers",
    ],
  }),
  familyContract({
    key: "misc",
    entityIds: [
      "thebrokenscript:ban",
      "thebrokenscript:chunk_remover",
      "thebrokenscript:corruption",
      "thebrokenscript:eerie_noise",
      "thebrokenscript:follow",
      "thebrokenscript:hetzer",
      "thebrokenscript:maze_shadows",
      "thebrokenscript:name_tag",
      "thebrokenscript:niw",
      "thebrokenscript:nothing_watcher",
      "thebrokenscript:nothingiswatchingchase",
      "thebrokenscript:null_cod",
      "thebrokenscript:phantom_player",
      "thebrokenscript:xxram_2die",
    ],
    bedrockFamilies: ["thebrokenscript_misc"],
    runtime: {
      controller: "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/misc/misc_controller.js",
      spawnRules: "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/misc/misc_spawn_rules.js",
    },
    sourceRoots: [
      "decompiled/net/thebrokenscript/entity/misc",
      "decompiled/net/thebrokenscript/entity/maze",
      "decompiled/net/thebrokenscript/entity/niw",
    ],
    adaptations: [
      "utility entities are event-driven and clean themselves up on invalidation",
      "the null_cod helper remains in the misc runtime family by source registration",
    ],
  }),
  familyContract({
    key: "stalk",
    entityIds: [
      "thebrokenscript:curved",
      "thebrokenscript:herobrine",
      "thebrokenscript:jon",
      "thebrokenscript:sub_anomaly_1",
      "thebrokenscript:sub_anomaly_2",
      "thebrokenscript:the_obliteration",
      "thebrokenscript:the_obliteration_2",
    ],
    bedrockFamilies: ["thebrokenscript_stalk"],
    runtime: {
      controller: "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/stalk/stalk_controller.js",
      spawnRules: "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/stalk/stalk_spawn_rules.js",
    },
    sourceRoots: [
      "decompiled/net/thebrokenscript/entity/anomaly",
      "decompiled/net/thebrokenscript/entity/oblit",
      "decompiled/net/thebrokenscript/entity/players",
    ],
    adaptations: [
      "shared FOV and raycast visibility are used for stalking transitions",
      "source-only chunk operations remain documented Bedrock-safe surrogates",
    ],
  }),
  familyContract({
    key: "boss",
    entityIds: [
      "thebrokenscript:chord",
      "thebrokenscript:chord_projectile",
      "thebrokenscript:fever",
      "thebrokenscript:fever_stalk",
      "thebrokenscript:fractured",
      "thebrokenscript:fractured_roam",
      "thebrokenscript:integ_fireball",
      "thebrokenscript:integrity_arm",
      "thebrokenscript:integrity_curious",
      "thebrokenscript:integrity_phase_1",
      "thebrokenscript:integrity_phase_2",
      "thebrokenscript:integrity_phase_3",
      "thebrokenscript:murderfur",
      "thebrokenscript:rock",
      "thebrokenscript:tether",
      "thebrokenscript:void_tentacle",
    ],
    bedrockFamilies: [
      "thebrokenscript_boss",
      "thebrokenscript_chord_projectile_runtime",
      "thebrokenscript_fractured_runtime",
      "thebrokenscript_phase3_runtime",
      "thebrokenscript_fractured_rock_runtime",
    ],
    runtime: {
      controller: "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/boss_controller.js",
      spawnRules: "TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/boss_spawn_rules.js",
    },
    sourceRoots: [
      "decompiled/net/thebrokenscript/entity/boss",
      "decompiled/net/thebrokenscript/entity/fever",
      "decompiled/net/thebrokenscript/entity/fractured",
      "decompiled/net/thebrokenscript/entity/integrity",
    ],
    adaptations: [
      "phase and projectile helpers share the boss controller lifecycle",
      "server-side phase timers remain the authority for combat transitions",
    ],
  }),
  familyContract({
    key: "render_only",
    entityIds: ["thebrokenscript:circuit_cave_painting"],
    bedrockFamilies: [],
    runtime: {
      controller: "TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_features.js",
      spawnRules: null,
      renderOnly: true,
    },
    sourceRoots: ["decompiled/net/thebrokenscript/entity/circuit"],
    coverage: RENDER_ONLY_COVERAGE,
    adaptations: ["Java client painting placement is represented as a renderable Bedrock entity"],
  }),
]);

const ENTITY_FAMILY_BY_ID = new Map(
  ENTITY_FAMILY_CONTRACTS.flatMap((family) => family.entityIds.map((entityId) => [entityId, family])),
);

export function allEntityIds() {
  return [...ENTITY_FAMILY_BY_ID.keys()];
}

export function familyForEntity(entityId) {
  return ENTITY_FAMILY_BY_ID.get(entityId);
}
