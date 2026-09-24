export const VANILLA_DIMENSION_IDS = ["overworld", "nether", "the_end"];

// TBSDimensions.java defines these 12 logical Level keys. Keep this list
// separate from the complete source resource inventory so Java ALL semantics
// remain stable even when a dimension is resource-backed but not in ALL.
export const JAVA_REGISTERED_REALM_NAMES = [
  "clan_void",
  "null_torture",
  "the_moon",
  "nowhere",
  "limbo",
  "nothing",
  "protected_void",
  "library",
  "concrete",
  "lucid",
  "stage2",
  "void_shadow"
];

// backrooms has a real Java dimension JSON and custom generator implementation,
// but it is not present in TBSDimensions.ALL. Bedrock still needs to register it
// so the complete source dimension inventory is addressable.
export const RESOURCE_ONLY_REALM_NAMES = ["backrooms"];

export const CUSTOM_REALM_NAMES = [
  ...JAVA_REGISTERED_REALM_NAMES,
  ...RESOURCE_ONLY_REALM_NAMES
];

export const CUSTOM_DIMENSION_IDS = CUSTOM_REALM_NAMES.map((name) => `thebrokenscript:${name}`);

const VANILLA = new Set(VANILLA_DIMENSION_IDS);
const CUSTOM = new Set(CUSTOM_DIMENSION_IDS);

export function normalizeDimensionId(id) {
  if (typeof id !== "string") return "";
  const value = id.trim().toLowerCase();
  if (!value) return "";

  if (value.startsWith("minecraft:")) {
    const bare = value.slice("minecraft:".length);
    return VANILLA.has(bare) ? bare : "";
  }

  if (VANILLA.has(value)) return value;

  if (value.startsWith("thebrokenscript:")) {
    return CUSTOM.has(value) ? value : "";
  }

  const custom = `thebrokenscript:${value}`;
  return CUSTOM.has(custom) ? custom : "";
}

export function isVanillaDimensionId(id) {
  return VANILLA.has(normalizeDimensionId(id));
}

export function isCustomDimensionId(id) {
  return CUSTOM.has(normalizeDimensionId(id));
}

export function isKnownDimensionId(id) {
  return Boolean(normalizeDimensionId(id));
}

export function displayDimensionId(id) {
  const normalized = normalizeDimensionId(id);
  if (!normalized) return "";
  return normalized.startsWith("thebrokenscript:")
    ? normalized.slice("thebrokenscript:".length)
    : normalized;
}
