// Source-backed dimension policy.  Bedrock custom dimensions currently use the
// supported void-generator registration path, so these values drive entry and
// return adapters and keep the Java dimension-type evidence inspectable without
// claiming that the Script API can mutate every environment setting at runtime.

function deepFreeze(value) {
  if (!value || typeof value !== "object" || Object.isFrozen(value)) return value;
  for (const nested of Object.values(value)) deepFreeze(nested);
  return Object.freeze(value);
}

const policy = (values) => deepFreeze({ ...values, entry: { ...values.entry } });

export const DIMENSION_POLICIES = Object.freeze({
  backrooms: policy({
    sourceDimensionType: "thebrokenscript:backrooms",
    sourceGenerator: "thebrokenscript:backrooms_generator",
    sourceBiome: "minecraft:the_void",
    ambientLight: 0,
    fixedTime: 24000,
    hasSkylight: false,
    natural: true,
    minY: 0,
    height: 512,
    logicalHeight: 512,
    entry: { x: 0, y: 201, z: 0 },
    returnRoute: "overworld on explicit player return; generic safe landing adapter",
  }),
  clan_void: policy({
    sourceDimensionType: "thebrokenscript:clan_void",
    sourceGenerator: "thebrokenscript:clan_void_generator",
    sourceBiome: "thebrokenscript:clan_void_biomes",
    ambientLight: 0,
    fixedTime: 6000,
    hasSkylight: true,
    natural: false,
    minY: -64,
    height: 384,
    logicalHeight: 384,
    entry: { x: 0, y: 201, z: 0 },
    entryVariants: [201, 206, 216, 253],
    returnRoute: "linked destination or source-specific lifecycle return",
  }),
  concrete: policy({
    sourceDimensionType: "thebrokenscript:concrete",
    sourceGenerator: "thebrokenscript:concrete",
    sourceBiome: "thebrokenscript:concrete",
    ambientLight: 0,
    fixedTime: 1500,
    hasSkylight: true,
    natural: true,
    minY: -64,
    height: 384,
    logicalHeight: 384,
    entry: { x: 0, y: 201, z: 0 },
    returnRoute: "overworld below source Y -85",
  }),
  library: policy({
    sourceDimensionType: "thebrokenscript:library",
    sourceGenerator: "thebrokenscript:library",
    sourceBiome: "thebrokenscript:library",
    ambientLight: 0.05,
    fixedTime: 6000,
    hasSkylight: false,
    natural: false,
    minY: -64,
    height: 320,
    logicalHeight: 64,
    entry: { x: 0, y: 201, z: 0 },
    returnRoute: "overworld on explicit player return",
  }),
  limbo: policy({
    sourceDimensionType: "thebrokenscript:limbo",
    sourceGenerator: "thebrokenscript:limbo",
    sourceBiome: "thebrokenscript:limbo",
    ambientLight: 15,
    fixedTime: undefined,
    hasSkylight: false,
    natural: false,
    minY: -64,
    height: 320,
    logicalHeight: 64,
    entry: { x: 0, y: 201, z: 0 },
    returnRoute: "overworld on explicit player return",
  }),
  lucid: policy({
    sourceDimensionType: "thebrokenscript:lucid",
    sourceGenerator: "thebrokenscript:lucid",
    sourceBiome: "thebrokenscript:lucid",
    ambientLight: 0.0945,
    fixedTime: 6000,
    hasSkylight: false,
    natural: false,
    minY: -1024,
    height: 2064,
    logicalHeight: 64,
    entry: { x: 0, y: 201, z: 0 },
    returnRoute: "overworld on explicit player return",
  }),
  nothing: policy({
    sourceDimensionType: "thebrokenscript:nothing",
    sourceGenerator: "thebrokenscript:nothing",
    sourceBiome: "thebrokenscript:nothing",
    ambientLight: 0,
    fixedTime: undefined,
    hasSkylight: false,
    natural: false,
    minY: -64,
    height: 320,
    logicalHeight: 64,
    entry: { x: 0, y: 201, z: 0 },
    returnRoute: "overworld on explicit player return",
  }),
  nowhere: policy({
    sourceDimensionType: "thebrokenscript:nowhere",
    sourceGenerator: "thebrokenscript:nowhere",
    sourceBiome: "thebrokenscript:nowhere",
    ambientLight: 0.0465,
    fixedTime: 6000,
    hasSkylight: false,
    natural: false,
    minY: -64,
    height: 320,
    logicalHeight: 64,
    entry: { x: 0, y: 201, z: 0 },
    returnRoute: "protected_void below source Y -100",
  }),
  null_torture: policy({
    sourceDimensionType: "thebrokenscript:null_torture",
    sourceGenerator: "thebrokenscript:null_torture_generator",
    sourceBiome: "minecraft:multi_noise",
    ambientLight: 0,
    fixedTime: 18000,
    hasSkylight: false,
    natural: false,
    minY: -64,
    height: 384,
    logicalHeight: 384,
    monsterSpawnLightLevel: { minInclusive: 0, maxInclusive: 7 },
    entry: { x: 0, y: 201, z: 0 },
    returnRoute: "overworld on explicit player return",
  }),
  protected_void: policy({
    sourceDimensionType: "thebrokenscript:protected_void",
    sourceGenerator: "thebrokenscript:protected_void",
    sourceBiome: "thebrokenscript:protected_void",
    ambientLight: 0.0035,
    fixedTime: 6000,
    hasSkylight: false,
    natural: false,
    minY: -64,
    height: 320,
    logicalHeight: 64,
    entry: { x: 11, y: 71, z: 6, rotationY: 180 },
    returnRoute: "overworld on explicit player return",
  }),
  stage2: policy({
    sourceDimensionType: "thebrokenscript:stage2",
    sourceGenerator: "thebrokenscript:stage2",
    sourceBiome: "thebrokenscript:stage2",
    ambientLight: 0,
    fixedTime: 6000,
    hasSkylight: true,
    natural: false,
    minY: -64,
    height: 384,
    logicalHeight: 384,
    entry: { x: 85, y: 255, z: 85 },
    entryVariance: { x: 10, z: 10 },
    returnRoute: "arena lifecycle returns participants to their saved location",
  }),
  the_moon: policy({
    sourceDimensionType: "thebrokenscript:the_moon",
    sourceGenerator: "minecraft:noise",
    sourceBiome: "thebrokenscript:moon_biomes",
    ambientLight: 0.045,
    fixedTime: 15000,
    hasSkylight: false,
    hasPrecipitation: false,
    natural: false,
    minY: -64,
    height: 320,
    logicalHeight: 0,
    entry: { x: 0, y: 201, z: 0 },
    returnRoute: "overworld below source Y -85",
  }),
  void_shadow: policy({
    sourceDimensionType: "thebrokenscript:void_shadow",
    sourceGenerator: "thebrokenscript:stage3",
    sourceBiome: "thebrokenscript:stage3",
    ambientLight: 0.025,
    fixedTime: 6000,
    hasSkylight: false,
    natural: false,
    minY: -64,
    height: 320,
    logicalHeight: 64,
    entry: { x: 0, y: 201, z: 0 },
    returnRoute: "overworld on explicit player return",
  }),
});

export const DIMENSION_POLICY_IDS = Object.freeze(Object.keys(DIMENSION_POLICIES));

function policyName(id) {
  if (typeof id !== "string") return "";
  const normalized = id.trim().toLowerCase();
  return normalized.startsWith("thebrokenscript:")
    ? normalized.slice("thebrokenscript:".length)
    : normalized;
}

export function getDimensionPolicy(id) {
  return DIMENSION_POLICIES[policyName(id)];
}

export function getDimensionEntryLocation(id, fallback = { x: 0, y: 201, z: 0 }) {
  const entry = getDimensionPolicy(id)?.entry;
  return entry
    ? { x: entry.x, y: entry.y, z: entry.z }
    : { x: fallback.x, y: fallback.y, z: fallback.z };
}

export function getDimensionEntryRotation(id) {
  const rotationY = getDimensionPolicy(id)?.entry?.rotationY;
  return Number.isFinite(rotationY) ? { x: 0, y: rotationY } : undefined;
}

export function getDimensionReturnRoute(id) {
  return getDimensionPolicy(id)?.returnRoute ?? "overworld on explicit player return";
}
