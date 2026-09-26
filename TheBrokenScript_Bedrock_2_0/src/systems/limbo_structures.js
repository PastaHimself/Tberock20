import * as operationDiagnostics from "../core/operation_diagnostics.js";

const CHUNK_SIZE = 16;
const CELL_SIZE_CHUNKS = 3;
const CELL_SIZE = CHUNK_SIZE * CELL_SIZE_CHUNKS;
const MIN_DISTANCE_SQUARED = 1024;

export const LIMBO_STRUCTURE_STAGE = "source_limbo_structures";
export const LIMBO_STRUCTURE_VERSION = 1;
export const LIMBO_STRUCTURE_LEDGER_PROPERTY = "tbs:limbo_structures_v1";

export const LIMBO_STRUCTURE_ORDER = Object.freeze([
  "limbo_caveoutpost",
  "limbo_happyfarm",
  "limbo_sanctuary",
  "limbo_thewrongdirection",
  "limbo_distastefulquandary",
  "limbo_somethingoldsomethingnew",
  "limbo_towerbaseright",
  "limbo_treehouse",
]);

export const LIMBO_STRUCTURE_SIZES = Object.freeze({
  limbo_caveoutpost: Object.freeze({ x: 48, y: 44, z: 47 }),
  limbo_happyfarm: Object.freeze({ x: 19, y: 15, z: 23 }),
  limbo_sanctuary: Object.freeze({ x: 23, y: 40, z: 17 }),
  limbo_thewrongdirection: Object.freeze({ x: 21, y: 13, z: 10 }),
  limbo_distastefulquandary: Object.freeze({ x: 18, y: 14, z: 17 }),
  limbo_somethingoldsomethingnew: Object.freeze({ x: 24, y: 23, z: 26 }),
  limbo_towerbaseright: Object.freeze({ x: 62, y: 61, z: 39 }),
  limbo_treehouse: Object.freeze({ x: 39, y: 34, z: 27 }),
});

export const LIMBO_HOUSE = Object.freeze({
  name: "limbo_house",
  structureId: "thebrokenscript:limbo_house",
  chunk: Object.freeze({ x: -1, z: -1 }),
  position: Object.freeze({ x: -5, y: 1, z: -5 }),
});

const KNOWN_STRUCTURES = new Set([LIMBO_HOUSE.name, ...LIMBO_STRUCTURE_ORDER]);

export function limboCandidateChunk(cellX, cellZ) {
  return {
    x: Math.floor(Number(cellX)) * CELL_SIZE_CHUNKS + 1,
    z: Math.floor(Number(cellZ)) * CELL_SIZE_CHUNKS + 1,
  };
}

export function limboStructureCell(location) {
  const chunkX = Math.floor(Number(location.x) / CHUNK_SIZE);
  const chunkZ = Math.floor(Number(location.z) / CHUNK_SIZE);
  const cellX = Math.floor(chunkX / CELL_SIZE_CHUNKS);
  const cellZ = Math.floor(chunkZ / CELL_SIZE_CHUNKS);
  const minX = cellX * CELL_SIZE;
  const minZ = cellZ * CELL_SIZE;
  return {
    key: `${cellX}:${cellZ}`,
    cellX,
    cellZ,
    candidateChunk: limboCandidateChunk(cellX, cellZ),
    // The 62-block tower is centered on the candidate chunk and extends
    // seven blocks beyond the three-chunk cell on the X axis. The symmetric
    // positive padding also keeps the fixed house fully loaded in cell -1:-1.
    bounds: {
      from: { x: minX - 7, y: -64, z: minZ },
      to: { x: minX + CELL_SIZE + 6, y: 255, z: minZ + CELL_SIZE + 6 },
    },
  };
}

export function emptyLimboStructureLedger() {
  return { version: LIMBO_STRUCTURE_VERSION, counts: {}, usedChunks: {} };
}

function normalizedCount(value) {
  const count = Math.floor(Number(value));
  return Number.isFinite(count) && count > 0 ? count : 0;
}

export function readLimboStructureLedger(raw) {
  let parsed = raw;
  if (typeof raw === "string") {
    try {
      parsed = JSON.parse(raw);
    } catch (error) {
      operationDiagnostics.warnOnce(
        "limbo_structures.invalid_ledger",
        "Limbo structure ledger is invalid; rebuilding placement state",
        error,
      );
      return emptyLimboStructureLedger();
    }
  }
  if (!parsed || typeof parsed !== "object" || parsed.version !== LIMBO_STRUCTURE_VERSION) {
    return emptyLimboStructureLedger();
  }

  const ledger = emptyLimboStructureLedger();
  for (const name of KNOWN_STRUCTURES) {
    const count = normalizedCount(parsed.counts?.[name]);
    if (count > 0) ledger.counts[name] = count;
  }
  for (const [key, name] of Object.entries(parsed.usedChunks ?? {})) {
    if (/^-?\d+:-?\d+$/.test(key) && KNOWN_STRUCTURES.has(name)) {
      ledger.usedChunks[key] = name;
    }
  }
  return ledger;
}

export function serializeLimboStructureLedger(ledger) {
  return JSON.stringify(readLimboStructureLedger(ledger));
}

function chunkKey(chunk) {
  return `${chunk.x}:${chunk.z}`;
}

function candidateIsTooClose(candidate, ledger) {
  for (const key of Object.keys(ledger.usedChunks)) {
    const [x, z] = key.split(":").map(Number);
    const dx = candidate.x - x;
    const dz = candidate.z - z;
    if (dx * dx + dz * dz < MIN_DISTANCE_SQUARED) return true;
  }
  return false;
}

function rarePlacement(name, chunk) {
  const size = LIMBO_STRUCTURE_SIZES[name];
  const centerX = chunk.x * CHUNK_SIZE + 8;
  const centerZ = chunk.z * CHUNK_SIZE + 8;
  return {
    name,
    structureId: `thebrokenscript:${name}`,
    chunk: { ...chunk },
    position: {
      x: centerX - Math.floor(size.x / 2),
      y: 1,
      z: centerZ - Math.floor(size.z / 2),
    },
  };
}

export function applyLimboStructurePlacement(ledger, placement) {
  const normalized = readLimboStructureLedger(ledger);
  if (!KNOWN_STRUCTURES.has(placement?.name)) {
    throw new TypeError(`unknown Limbo structure '${String(placement?.name)}'`);
  }
  const next = {
    version: LIMBO_STRUCTURE_VERSION,
    counts: { ...normalized.counts },
    usedChunks: { ...normalized.usedChunks },
  };
  next.counts[placement.name] = (next.counts[placement.name] ?? 0) + 1;
  next.usedChunks[chunkKey(placement.chunk)] = placement.name;
  return next;
}

export function planLimboStructureCell(cell, ledger) {
  const placements = [];
  let simulated = readLimboStructureLedger(ledger);

  // Source Limbo always places this house in chunk -1,-1. A cell initializer
  // handles it first so Bedrock generation is deterministic across players.
  if (cell.key === "-1:-1" && (simulated.counts[LIMBO_HOUSE.name] ?? 0) < 1) {
    const house = {
      name: LIMBO_HOUSE.name,
      structureId: LIMBO_HOUSE.structureId,
      chunk: { ...LIMBO_HOUSE.chunk },
      position: { ...LIMBO_HOUSE.position },
    };
    placements.push(house);
    simulated = applyLimboStructurePlacement(simulated, house);
  }

  const candidate = cell.candidateChunk;
  if (simulated.usedChunks[chunkKey(candidate)] || candidateIsTooClose(candidate, simulated)) {
    return placements;
  }

  const name = LIMBO_STRUCTURE_ORDER.find(
    (structureName) => (simulated.counts[structureName] ?? 0) < 1,
  );
  if (name) placements.push(rarePlacement(name, candidate));
  return placements;
}
