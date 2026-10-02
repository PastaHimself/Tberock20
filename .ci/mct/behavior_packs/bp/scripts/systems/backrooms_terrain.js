const NORMAL_BLOCKS = Object.freeze({
  floor: "thebrokenscript:moist_carpet",
  ceiling: "thebrokenscript:ceiling_tile",
  wall: "thebrokenscript:ugly_wallpaper",
  light: "thebrokenscript:ceiling_light",
});
const RED_BLOCKS = Object.freeze({
  floor: "thebrokenscript:red_moist_carpet",
  ceiling: "thebrokenscript:red_ceiling_tile",
  wall: "thebrokenscript:red_ugly_wallpaper",
  light: "thebrokenscript:red_ceiling_light",
});

export const BACKROOMS_LEVEL_ZERO = Object.freeze({
  dimensionId: "thebrokenscript:backrooms",
  stage: "source_backrooms_level_zero",
  version: 1,
  chunkSize: 16,
  cellSizeChunks: 3,
  minY: 0,
  maxY: 511,
  bedrockY: 0,
  floorY: 1,
  ceilingY: 9,
  thresholds: Object.freeze({ redRoom: 0.3, unlitRoom: 0.15, emptyArea: 0.2 }),
  blocks: Object.freeze({
    base: "minecraft:bedrock",
    normal: NORMAL_BLOCKS,
    red: RED_BLOCKS,
  }),
});

const NOISE_SCALE = 0.1;
export const BACKROOMS_NOISE_FIELDS = Object.freeze({
  unlitRoom: Object.freeze({ salt: "unlit", octaves: Object.freeze([1, 5, 9]) }),
  emptyArea: Object.freeze({ salt: "empty", octaves: Object.freeze([2, 1, 9]) }),
  redRoom: Object.freeze({ salt: "red", octaves: Object.freeze([0, 4, 2]) }),
});

function finiteCoordinate(value, name) {
  const number = Number(value);
  if (!Number.isFinite(number)) throw new TypeError(`${name} must be finite`);
  return number;
}

function fnv1a(value) {
  let hash = 0x811c9dc5;
  for (const character of String(value)) {
    hash ^= character.codePointAt(0);
    hash = Math.imul(hash, 0x01000193);
  }
  return hash >>> 0;
}

function coordinateHash(seed, x, z) {
  let hash = seed >>> 0;
  hash ^= Math.imul(x | 0, 0x9e3779b1);
  hash = Math.imul(hash ^ (hash >>> 16), 0x85ebca6b);
  hash ^= Math.imul(z | 0, 0xc2b2ae35);
  hash = Math.imul(hash ^ (hash >>> 13), 0x27d4eb2f);
  return (hash ^ (hash >>> 15)) >>> 0;
}

function fade(value) {
  return value * value * value * (value * (value * 6 - 15) + 10);
}

function lerp(from, to, amount) {
  return from + (to - from) * amount;
}

const GRADIENTS = Object.freeze([
  Object.freeze([1, 0]),
  Object.freeze([-1, 0]),
  Object.freeze([0, 1]),
  Object.freeze([0, -1]),
  Object.freeze([Math.SQRT1_2, Math.SQRT1_2]),
  Object.freeze([-Math.SQRT1_2, Math.SQRT1_2]),
  Object.freeze([Math.SQRT1_2, -Math.SQRT1_2]),
  Object.freeze([-Math.SQRT1_2, -Math.SQRT1_2]),
]);

function gradientDot(seed, gridX, gridZ, offsetX, offsetZ) {
  const gradient = GRADIENTS[coordinateHash(seed, gridX, gridZ) % GRADIENTS.length];
  return gradient[0] * offsetX + gradient[1] * offsetZ;
}

function gradientNoise2d(seed, x, z) {
  const x0 = Math.floor(x);
  const z0 = Math.floor(z);
  const dx = x - x0;
  const dz = z - z0;
  const u = fade(dx);
  const v = fade(dz);
  const top = lerp(
    gradientDot(seed, x0, z0, dx, dz),
    gradientDot(seed, x0 + 1, z0, dx - 1, dz),
    u,
  );
  const bottom = lerp(
    gradientDot(seed, x0, z0 + 1, dx, dz - 1),
    gradientDot(seed, x0 + 1, z0 + 1, dx - 1, dz - 1),
    u,
  );
  return lerp(top, bottom, v) * Math.SQRT2;
}

export function sampleBackroomsNoiseField(worldSeed, field, chunkX, chunkZ) {
  // PerlinNoise.create's integer list selects active octaves; it is not an
  // amplitude vector. Sorting and equal-mean normalization make set order inert.
  const octaves = [...new Set(field.octaves)].sort((left, right) => left - right);
  let total = 0;
  for (const octave of octaves) {
    const frequency = 2 ** octave;
    const seed = fnv1a(`${worldSeed}|backrooms|${field.salt}|octave:${octave}`);
    total += gradientNoise2d(
      seed,
      chunkX * NOISE_SCALE * frequency,
      chunkZ * NOISE_SCALE * frequency,
    );
  }
  return octaves.length === 0 ? 0 : total / octaves.length;
}

function createRandom(seed) {
  let state = seed >>> 0;
  return () => {
    state = (state + 0x6d2b79f5) >>> 0;
    let value = state;
    value = Math.imul(value ^ (value >>> 15), value | 1);
    value ^= value + Math.imul(value ^ (value >>> 7), value | 61);
    return ((value ^ (value >>> 14)) >>> 0) / 0x100000000;
  };
}

function randomInt(random, minInclusive, maxExclusive) {
  return minInclusive + Math.floor(random() * (maxExclusive - minInclusive));
}

function wrappedRuns(start, end, size = BACKROOMS_LEVEL_ZERO.chunkSize) {
  if (end < size) return [{ from: start, to: end }];
  return [
    { from: start, to: size - 1 },
    { from: 0, to: end % size },
  ];
}

function wallPlan(chunkX, chunkZ, worldSeed) {
  const seed = coordinateHash(fnv1a(`${worldSeed}|backrooms|wall`), chunkX, chunkZ);
  const random = createRandom(seed);
  return {
    startX: randomInt(random, 0, 15),
    startZ: randomInt(random, 0, 15),
    length: randomInt(random, 1, 15),
    thickness: randomInt(random, 0, 6),
    alongX: random() >= 0.5,
  };
}

function wallVolumes(origin, wall, block) {
  const xEnd = wall.startX + (wall.alongX ? wall.length : wall.thickness);
  const zEnd = wall.startZ + (wall.alongX ? wall.thickness : wall.length);
  const volumes = [];
  for (const x of wrappedRuns(wall.startX, xEnd)) {
    for (const z of wrappedRuns(wall.startZ, zEnd)) {
      volumes.push({
        from: { x: origin.x + x.from, y: 2, z: origin.z + z.from },
        to: { x: origin.x + x.to, y: 8, z: origin.z + z.to },
        block,
      });
    }
  }
  return volumes;
}

export function classifyBackroomsChunk(samples) {
  return {
    red: Number(samples?.redRoom) > BACKROOMS_LEVEL_ZERO.thresholds.redRoom,
    lit: !(Number(samples?.unlitRoom) > BACKROOMS_LEVEL_ZERO.thresholds.unlitRoom),
    walls: !(Number(samples?.emptyArea) > BACKROOMS_LEVEL_ZERO.thresholds.emptyArea),
  };
}

export function backroomsCell(location) {
  const chunkX = Math.floor(finiteCoordinate(location?.x, "location.x") / BACKROOMS_LEVEL_ZERO.chunkSize);
  const chunkZ = Math.floor(finiteCoordinate(location?.z, "location.z") / BACKROOMS_LEVEL_ZERO.chunkSize);
  const cellX = Math.floor(chunkX / BACKROOMS_LEVEL_ZERO.cellSizeChunks);
  const cellZ = Math.floor(chunkZ / BACKROOMS_LEVEL_ZERO.cellSizeChunks);
  const firstChunkX = cellX * BACKROOMS_LEVEL_ZERO.cellSizeChunks;
  const firstChunkZ = cellZ * BACKROOMS_LEVEL_ZERO.cellSizeChunks;
  const minX = firstChunkX * BACKROOMS_LEVEL_ZERO.chunkSize;
  const minZ = firstChunkZ * BACKROOMS_LEVEL_ZERO.chunkSize;
  const cellSize = BACKROOMS_LEVEL_ZERO.chunkSize * BACKROOMS_LEVEL_ZERO.cellSizeChunks;
  return {
    key: `${cellX}:${cellZ}`,
    chunk: { x: firstChunkX, z: firstChunkZ },
    bounds: {
      from: { x: minX, y: BACKROOMS_LEVEL_ZERO.minY, z: minZ },
      to: { x: minX + cellSize - 1, y: BACKROOMS_LEVEL_ZERO.maxY, z: minZ + cellSize - 1 },
    },
  };
}

export function backroomsNeighborCells(location, margin = 16) {
  const current = backroomsCell(location);
  const { from, to } = current.bounds;
  const neighborXs = [];
  const neighborZs = [];
  if (location.x - from.x <= margin) neighborXs.push(from.x - 1);
  if (to.x - location.x <= margin) neighborXs.push(to.x + 1);
  if (location.z - from.z <= margin) neighborZs.push(from.z - 1);
  if (to.z - location.z <= margin) neighborZs.push(to.z + 1);
  const neighbors = [];
  for (const x of neighborXs) neighbors.push(backroomsCell({ x, z: location.z }));
  for (const z of neighborZs) neighbors.push(backroomsCell({ x: location.x, z }));
  for (const x of neighborXs) {
    for (const z of neighborZs) neighbors.push(backroomsCell({ x, z }));
  }
  return neighbors;
}

export function backroomsChunkPlan(chunkX, chunkZ, worldSeed) {
  const x = Math.floor(finiteCoordinate(chunkX, "chunkX"));
  const z = Math.floor(finiteCoordinate(chunkZ, "chunkZ"));
  const samples = {
    redRoom: sampleBackroomsNoiseField(worldSeed, BACKROOMS_NOISE_FIELDS.redRoom, x, z),
    unlitRoom: sampleBackroomsNoiseField(worldSeed, BACKROOMS_NOISE_FIELDS.unlitRoom, x, z),
    emptyArea: sampleBackroomsNoiseField(worldSeed, BACKROOMS_NOISE_FIELDS.emptyArea, x, z),
  };
  const classification = classifyBackroomsChunk(samples);
  const palette = classification.red ? BACKROOMS_LEVEL_ZERO.blocks.red : BACKROOMS_LEVEL_ZERO.blocks.normal;
  const origin = {
    x: x * BACKROOMS_LEVEL_ZERO.chunkSize,
    z: z * BACKROOMS_LEVEL_ZERO.chunkSize,
  };
  const wall = wallPlan(x, z, worldSeed);
  const lights = [];
  if (classification.lit) {
    for (let lightX = 0; lightX < 15; lightX += 4) {
      for (let lightZ = 0; lightZ < 15; lightZ += 4) {
        lights.push({
          x: origin.x + lightX,
          y: BACKROOMS_LEVEL_ZERO.ceilingY,
          z: origin.z + lightZ,
          block: palette.light,
        });
      }
    }
  }
  return {
    chunk: { x, z },
    origin,
    samples,
    ...classification,
    floorBlock: palette.floor,
    ceilingBlock: palette.ceiling,
    wallBlock: palette.wall,
    lightBlock: palette.light,
    floorVolume: {
      from: { x: origin.x, y: BACKROOMS_LEVEL_ZERO.floorY, z: origin.z },
      to: {
        x: origin.x + BACKROOMS_LEVEL_ZERO.chunkSize - 1,
        y: BACKROOMS_LEVEL_ZERO.floorY,
        z: origin.z + BACKROOMS_LEVEL_ZERO.chunkSize - 1,
      },
      block: palette.floor,
    },
    ceilingVolume: {
      from: { x: origin.x, y: BACKROOMS_LEVEL_ZERO.ceilingY, z: origin.z },
      to: {
        x: origin.x + BACKROOMS_LEVEL_ZERO.chunkSize - 1,
        y: BACKROOMS_LEVEL_ZERO.ceilingY,
        z: origin.z + BACKROOMS_LEVEL_ZERO.chunkSize - 1,
      },
      block: palette.ceiling,
    },
    wall,
    wallVolumes: classification.walls ? wallVolumes(origin, wall, palette.wall) : [],
    lights,
  };
}

export function backroomsCellPlan(cell, worldSeed) {
  const chunks = [];
  for (let chunkX = cell.chunk.x; chunkX < cell.chunk.x + BACKROOMS_LEVEL_ZERO.cellSizeChunks; chunkX++) {
    for (let chunkZ = cell.chunk.z; chunkZ < cell.chunk.z + BACKROOMS_LEVEL_ZERO.cellSizeChunks; chunkZ++) {
      chunks.push(backroomsChunkPlan(chunkX, chunkZ, worldSeed));
    }
  }
  return {
    cell,
    baseVolume: {
      from: {
        x: cell.bounds.from.x,
        y: BACKROOMS_LEVEL_ZERO.bedrockY,
        z: cell.bounds.from.z,
      },
      to: {
        x: cell.bounds.to.x,
        y: BACKROOMS_LEVEL_ZERO.bedrockY,
        z: cell.bounds.to.z,
      },
      block: BACKROOMS_LEVEL_ZERO.blocks.base,
    },
    chunks,
  };
}

export function executeBackroomsCellPlan(plan, operations) {
  if (typeof operations?.fill !== "function") throw new TypeError("operations.fill must be a function");
  if (typeof operations?.set !== "function") throw new TypeError("operations.set must be a function");
  operations.fill(plan.baseVolume);
  for (const chunk of plan.chunks) {
    operations.fill(chunk.floorVolume);
    operations.fill(chunk.ceilingVolume);
    for (const light of chunk.lights) operations.set(light);
    for (const volume of chunk.wallVolumes) operations.fill(volume);
  }
}
