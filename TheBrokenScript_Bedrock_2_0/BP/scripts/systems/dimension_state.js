export const DIMENSION_STATE_SCHEMA_VERSION = 1;

function requirePart(name, value) {
  const text = String(value ?? "").trim();
  if (!text) throw new TypeError(`${name} is required`);
  return text;
}

function hash32(text, seed) {
  let hash = seed >>> 0;
  for (let index = 0; index < text.length; index++) {
    hash ^= text.charCodeAt(index);
    hash = Math.imul(hash, 16777619);
  }
  return (hash >>> 0).toString(16).padStart(8, "0");
}

export function dimensionStateToken(
  dimensionId,
  stage,
  regionKey,
  version = DIMENSION_STATE_SCHEMA_VERSION,
) {
  const numericVersion = Math.max(1, Math.floor(Number(version)));
  if (!Number.isFinite(numericVersion)) throw new TypeError("version must be a finite number");
  return [
    `v${numericVersion}`,
    requirePart("dimensionId", dimensionId),
    requirePart("stage", stage),
    requirePart("regionKey", regionKey),
  ].join("|");
}

export function dimensionStatePropertyKey(
  dimensionId,
  stage,
  regionKey,
  version = DIMENSION_STATE_SCHEMA_VERSION,
) {
  const token = dimensionStateToken(dimensionId, stage, regionKey, version);
  const left = hash32(token, 0x811c9dc5);
  const right = hash32(token, 0x9e3779b9);
  return `tbs:dim_init_${left}${right}`;
}

export function readDimensionRegionState(
  worldLike,
  dimensionId,
  stage,
  regionKey,
  version = DIMENSION_STATE_SCHEMA_VERSION,
) {
  const token = dimensionStateToken(dimensionId, stage, regionKey, version);
  const key = dimensionStatePropertyKey(dimensionId, stage, regionKey, version);
  const raw = worldLike.getDynamicProperty(key);

  if (raw === token) return { initialized: true, data: undefined };
  if (typeof raw !== "string") return { initialized: false, data: undefined };

  try {
    const parsed = JSON.parse(raw);
    if (parsed?.token !== token) return { initialized: false, data: undefined };
    return { initialized: true, data: parsed.data };
  } catch {
    return { initialized: false, data: undefined };
  }
}

export function isDimensionRegionInitialized(
  worldLike,
  dimensionId,
  stage,
  regionKey,
  version = DIMENSION_STATE_SCHEMA_VERSION,
) {
  return readDimensionRegionState(
    worldLike,
    dimensionId,
    stage,
    regionKey,
    version,
  ).initialized;
}

export function markDimensionRegionInitialized(
  worldLike,
  dimensionId,
  stage,
  regionKey,
  version = DIMENSION_STATE_SCHEMA_VERSION,
  data,
) {
  const token = dimensionStateToken(dimensionId, stage, regionKey, version);
  const key = dimensionStatePropertyKey(dimensionId, stage, regionKey, version);
  worldLike.setDynamicProperty(
    key,
    data === undefined ? token : JSON.stringify({ token, data }),
  );
  return key;
}
