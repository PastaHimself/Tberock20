const JAVA_RANDOM_MULTIPLIER = 0x5deece66dn;
const JAVA_RANDOM_ADDEND = 0xbn;
const JAVA_RANDOM_MASK = (1n << 48n) - 1n;
const JAVA_RANDOM_INT_SIGN = 0x80000000;

export const STAGE2_CORE_VERSION = 1;
export const STAGE2_DIMENSION_ID = "thebrokenscript:stage2";
export const STAGE2_CHUNK_MIN = 0;
export const STAGE2_CHUNK_MAX = 10;
export const STAGE2_INTERIOR_CHUNK_MIN = 1;
export const STAGE2_INTERIOR_CHUNK_MAX = 9;
export const STAGE2_MIN_BUILD_Y = -64;
export const STAGE2_BORDER_MAX_Y = 270;
export const STAGE2_OUTER_BARRIER_Y = 271;
export const STAGE2_NOWHERE_Y = 100;
export const STAGE2_NOWHERE_HEIGHT = 4;
export const STAGE2_NOWHERE_RANDOM_OFFSET = 341873128712n;
export const STAGE2_NOWHERE_DIVIDER = 1n;
export const STAGE2_NOWHERE_Y_SEED_MULTIPLIER = 123456789n;
export const STAGE2_NOWHERE_EDGE_THRESHOLD = 2.895;
export const STAGE2_NOWHERE_POINT_CLEARANCE = 8;
export const STAGE2_NOWHERE_CENTER_CLEARANCE = 3;
export const STAGE2_NOWHERE_MAX_POINT_ATTEMPTS = 50;
export const STAGE2_CHUNK_SEED_X = 341873128712n;
export const STAGE2_CHUNK_SEED_Z = 132897987541n;
export const STAGE2_TEMPLATE_ROTATIONS = Object.freeze([
  "none",
  "rotate90",
  "rotate180",
  "rotate270",
]);

function integerSeed(value) {
  if (typeof value === "bigint") return value;
  if (typeof value === "string" && /^-?\d+$/.test(value.trim())) return BigInt(value.trim());
  if (typeof value === "number" && Number.isSafeInteger(value)) return BigInt(value);
  throw new TypeError("Stage 2 world seed must be an integer or decimal integer string");
}

export class JavaLegacyRandom {
  constructor(seed) {
    this.seed = (integerSeed(seed) ^ JAVA_RANDOM_MULTIPLIER) & JAVA_RANDOM_MASK;
  }

  next(bits) {
    if (!Number.isInteger(bits) || bits < 1 || bits > 32) {
      throw new RangeError("JavaLegacyRandom.next bits must be in 1..32");
    }
    this.seed = (this.seed * JAVA_RANDOM_MULTIPLIER + JAVA_RANDOM_ADDEND) & JAVA_RANDOM_MASK;
    return Number(this.seed >> BigInt(48 - bits));
  }

  nextInt(bound) {
    if (!Number.isInteger(bound) || bound <= 0 || bound > 0x7fffffff) {
      throw new RangeError("JavaLegacyRandom.nextInt bound must be in 1..2147483647");
    }

    if ((bound & (bound - 1)) === 0) {
      return Number((BigInt(bound) * BigInt(this.next(31))) >> 31n);
    }

    while (true) {
      const bits = this.next(31);
      const value = bits % bound;
      // java.util.Random rejects when bits - value + (bound - 1) overflows
      // signed int. The arithmetic is positive before overflow, so comparing
      // with 2^31 reproduces the Java condition without JS bit coercion.
      if (bits - value + (bound - 1) < JAVA_RANDOM_INT_SIGN) return value;
    }
  }

  nextIntRange(origin, bound) {
    if (!Number.isInteger(origin) || !Number.isInteger(bound) || origin >= bound) {
      throw new RangeError("JavaLegacyRandom.nextIntRange requires integer origin < bound");
    }
    return origin + this.nextInt(bound - origin);
  }

  nextBoolean() {
    return this.next(1) !== 0;
  }

  nextFloat() {
    return this.next(24) / (1 << 24);
  }
}

function stage2ChunkRandom(worldSeed, chunkX, chunkZ) {
  if (!Number.isInteger(chunkX) || !Number.isInteger(chunkZ)) {
    throw new TypeError("Stage 2 chunk coordinates must be integers");
  }
  return new JavaLegacyRandom(
    integerSeed(worldSeed)
      + BigInt(chunkX) * STAGE2_CHUNK_SEED_X
      + BigInt(chunkZ) * STAGE2_CHUNK_SEED_Z,
  );
}

function sourceTransform(random) {
  return {
    mirror: random.nextBoolean() ? "front_back" : "none",
    rotation: STAGE2_TEMPLATE_ROTATIONS[random.nextInt(4)],
  };
}

export function stage2SurfaceTemplatePlan(worldSeed, chunkX, chunkZ) {
  if (stage2CoreChunkRegion(chunkX, chunkZ) !== "interior") return null;
  const random = stage2ChunkRandom(worldSeed, chunkX, chunkZ);
  const transform = sourceTransform(random);
  return Object.freeze({
    structureId: random.nextFloat() < 0.99 ? "fieldbase" : "fieldbase2",
    y: 252,
    ...transform,
  });
}

const FLOOR3_VARIANTS = Object.freeze([
  null,
  "woodfloor1",
  "woodfloor2",
  "woodfloor3",
  "woodfloor4",
  "woodfloor5",
  "woodfloor6",
  "woodfloor7",
]);

function floor3Template(variant, randomExtra) {
  if (variant >= 1 && variant <= 7) return FLOOR3_VARIANTS[variant];
  if (variant === 8) return randomExtra ? "woodfloor8" : "woodfloor4";
  if (variant === 9) return randomExtra ? "woodfloor9" : "woodfloor4";
  const choices = {
    10: ["tek_woodfloor1", "woodfloor1"],
    11: ["tek_woodfloor2", "woodfloor1"],
    12: ["tek_woodfloor3", "woodfloor2"],
    13: ["tek_woodfloor4", "woodfloor2"],
    14: ["tek_woodfloor6", "woodfloor3"],
    15: ["tek_woodfloor7", "woodfloor3"],
    16: ["tek_woodfloor8", "woodfloor4"],
    17: ["tek_woodfloor9", "woodfloor4"],
    18: ["tek_woodfloor10", "woodfloor1"],
    20: ["tek_woodfloor12", "woodfloor2"],
    21: ["tek_woodfloor13", "woodfloor2"],
    22: ["tek_woodfloor14", "woodfloor3"],
    23: ["tek_woodfloor15", "woodfloor3"],
    24: ["tek_woodfloor16", "woodfloor4"],
    25: ["tek_woodfloor17", "woodfloor4"],
    26: ["tek_woodfloor18", "woodfloor1"],
    27: ["tek_woodfloor20", "woodfloor2"],
    28: ["tek_woodfloor21", "woodfloor2"],
    29: ["tek_woodfloor22", "woodfloor3"],
    30: ["tek_woodfloor23", "woodfloor3"],
    31: ["tek_woodfloor24", "woodfloor4"],
    32: ["tek_woodfloor25", "woodfloor4"],
    33: ["tek_woodfloor26", "woodfloor1"],
    34: ["tek_woodfloor27", "woodfloor1"],
    35: ["tek_woodfloor28", "woodfloor2"],
  };
  if (variant === 19) return "woodfloor1";
  if (variant === 36) return "woodfloor2";
  if (variant === 37) return "woodfloor6";
  const choice = choices[variant];
  if (!choice) throw new RangeError("Stage 2 floor-3 variant must be in 1..37");
  return randomExtra ? choice[0] : choice[1];
}

export function stage2RoomTemplatePlan(worldSeed, chunkX, chunkZ) {
  if (stage2CoreChunkRegion(chunkX, chunkZ) !== "interior") return null;
  const random = stage2ChunkRandom(worldSeed, chunkX, chunkZ);
  const transform = sourceTransform(random);
  const variantF1 = random.nextIntRange(1, 8);
  const variantF2 = random.nextIntRange(1, 6);
  const variantF3 = random.nextIntRange(1, 38);
  const variantF4 = random.nextIntRange(1, 7);
  const randomExtra = random.nextFloat() >= 0.9875;
  const special = random.nextFloat() <= 0.95;

  const floor1 = "clanvoidnew" + variantF1;
  let floor2;
  if (variantF2 === 1) floor2 = "clandimensionroom1";
  else if (variantF2 === 2) floor2 = "clandimensionroom2";
  else if (variantF2 === 3 || variantF2 === 4) floor2 = "clandimensionroom3";
  else floor2 = special ? "clandimensionroom2" : "clandimensionroom5";

  let floor4 = "stone1";
  if (special && random.nextFloat() < 0.05) {
    floor4 = "stone" + (variantF4 + 1);
  }

  return Object.freeze({
    transform: Object.freeze(transform),
    randomExtra,
    special,
    variants: Object.freeze({ variantF1, variantF2, variantF3, variantF4 }),
    placements: Object.freeze([
      Object.freeze({ structureId: floor1, y: 200 }),
      Object.freeze({ structureId: floor2, y: 207 }),
      Object.freeze({ structureId: floor3Template(variantF3, randomExtra), y: 217 }),
      Object.freeze({ structureId: floor4, y: 233 }),
    ]),
  });
}

export function stage2TunnelTemplatePlan(primaryRandom = Math.random, alternateRandom = Math.random) {
  if (Number(primaryRandom()) < 0.9) {
    return Object.freeze({ structureId: "bedrockhallway1", y: 160, mirror: "none", rotation: "none" });
  }
  const roll = Math.max(0, Math.min(0.999999999, Number(alternateRandom())));
  return Object.freeze({
    structureId: "bedrockhallway" + (2 + Math.floor(roll * 9)),
    y: 160,
    mirror: "none",
    rotation: "none",
  });
}

export function stage2ChunkOrigin(chunkX, chunkZ) {
  if (!Number.isInteger(chunkX) || !Number.isInteger(chunkZ)) {
    throw new TypeError("Stage 2 chunk coordinates must be integers");
  }
  return { x: chunkX * 16, z: chunkZ * 16 };
}

export function stage2CoreChunkRegion(chunkX, chunkZ) {
  if (
    chunkX < STAGE2_CHUNK_MIN
    || chunkX > STAGE2_CHUNK_MAX
    || chunkZ < STAGE2_CHUNK_MIN
    || chunkZ > STAGE2_CHUNK_MAX
  ) {
    return null;
  }
  if (
    chunkX >= STAGE2_INTERIOR_CHUNK_MIN
    && chunkX <= STAGE2_INTERIOR_CHUNK_MAX
    && chunkZ >= STAGE2_INTERIOR_CHUNK_MIN
    && chunkZ <= STAGE2_INTERIOR_CHUNK_MAX
  ) {
    return "interior";
  }
  return "border";
}

export function stage2CoreChunkBounds(chunkX, chunkZ) {
  const origin = stage2ChunkOrigin(chunkX, chunkZ);
  return {
    from: { x: origin.x, y: STAGE2_MIN_BUILD_Y, z: origin.z },
    to: { x: origin.x + 15, y: STAGE2_OUTER_BARRIER_Y, z: origin.z + 15 },
  };
}

export function stage2CorePlanePlan(chunkX, chunkZ) {
  const region = stage2CoreChunkRegion(chunkX, chunkZ);
  if (region === null) return null;

  const plan = [
    { y: STAGE2_OUTER_BARRIER_Y, blockId: "minecraft:barrier" },
  ];

  if (region === "interior") {
    plan.push(
      { y: 251, blockId: "minecraft:barrier" },
      { y: 232, blockId: "minecraft:barrier" },
      { y: 216, blockId: "minecraft:barrier" },
      { y: 206, blockId: "minecraft:barrier" },
      { y: 199, blockId: "thebrokenscript:cobblestone_border_block" },
      { y: 198, blockId: "minecraft:barrier" },
      { y: 160, blockId: "minecraft:bedrock" },
      { y: 159, blockId: "minecraft:barrier" },
      { y: 102, blockId: "minecraft:barrier" },
    );
  }

  return { region, planes: plan };
}

function pointDistance(a, b) {
  return Math.hypot(a.x - b.x, a.z - b.z);
}

export function stage2NowherePoints(worldSeed, chunkX, chunkZ) {
  integerSeed(worldSeed);
  if (!Number.isInteger(chunkX) || !Number.isInteger(chunkZ)) {
    throw new TypeError("Stage 2 chunk coordinates must be integers");
  }

  const points = [];
  for (let chunkOffsetX = -1; chunkOffsetX < 2; chunkOffsetX += 1) {
    for (let chunkOffsetZ = -1; chunkOffsetZ < 2; chunkOffsetZ += 1) {
      const targetChunkX = chunkX + chunkOffsetX;
      const targetChunkZ = chunkZ + chunkOffsetZ;
      const seed = integerSeed(worldSeed)
        + BigInt(targetChunkX) * STAGE2_NOWHERE_RANDOM_OFFSET
        + BigInt(targetChunkZ) * (STAGE2_NOWHERE_RANDOM_OFFSET / STAGE2_NOWHERE_DIVIDER)
        + BigInt(STAGE2_NOWHERE_Y) * STAGE2_NOWHERE_Y_SEED_MULTIPLIER;
      const random = new JavaLegacyRandom(seed);
      const numPoints = random.nextIntRange(3, 6);
      const chunkCenterX = targetChunkX * 16 + 8;
      const chunkCenterZ = targetChunkZ * 16 + 8;

      for (let index = 0; index < numPoints; index += 1) {
        let validPoint = null;
        for (let attempts = 0; attempts < STAGE2_NOWHERE_MAX_POINT_ATTEMPTS; attempts += 1) {
          const candidate = {
            x: chunkCenterX + random.nextIntRange(-16, 16),
            z: chunkCenterZ + random.nextIntRange(-16, 16),
          };
          const tooClose = points.some(
            (existing) => pointDistance(candidate, existing) < STAGE2_NOWHERE_POINT_CLEARANCE,
          );
          if (!tooClose) {
            validPoint = candidate;
            break;
          }
        }

        if (validPoint === null) {
          validPoint = {
            x: chunkCenterX + random.nextIntRange(-16, 16),
            z: chunkCenterZ + random.nextIntRange(-16, 16),
          };
        }
        points.push(validPoint);
      }
    }
  }
  return points;
}

export function stage2NowhereCells(worldSeed, chunkX, chunkZ) {
  if (stage2CoreChunkRegion(chunkX, chunkZ) !== "interior") {
    return { mud: [], barrier: [] };
  }

  const points = stage2NowherePoints(worldSeed, chunkX, chunkZ);
  const origin = stage2ChunkOrigin(chunkX, chunkZ);
  const initial = new Map();

  for (let x = origin.x; x <= origin.x + 15; x += 1) {
    for (let z = origin.z; z <= origin.z + 15; z += 1) {
      let minDistance = Number.POSITIVE_INFINITY;
      let secondMinDistance = Number.POSITIVE_INFINITY;
      for (const point of points) {
        const distance = Math.hypot(x - point.x, z - point.z);
        if (distance < minDistance) {
          secondMinDistance = minDistance;
          minDistance = distance;
        } else if (distance < secondMinDistance) {
          secondMinDistance = distance;
        }
      }
      const isSolid = (
        Math.abs(secondMinDistance - minDistance) < STAGE2_NOWHERE_EDGE_THRESHOLD
        && minDistance >= STAGE2_NOWHERE_CENTER_CLEARANCE
      );
      initial.set(x + "," + z, isSolid);
    }
  }

  const neighbors = [
    [1, 0], [-1, 0], [0, 1], [0, -1],
    [1, 1], [1, -1], [-1, 1], [-1, -1],
  ];
  const mud = [];
  const barrier = [];

  for (let x = origin.x; x <= origin.x + 15; x += 1) {
    for (let z = origin.z; z <= origin.z + 15; z += 1) {
      const key = x + "," + z;
      let isSolid = initial.get(key) === true;
      if (!isSolid) {
        let solidCount = 0;
        for (const [dx, dz] of neighbors) {
          const neighbor = initial.get((x + dx) + "," + (z + dz));
          // Source getOrDefault(..., true) makes out-of-chunk neighbors solid.
          if (neighbor === undefined || neighbor === true) solidCount += 1;
        }
        isSolid = solidCount >= 6;
      }
      (isSolid ? mud : barrier).push({ x, z });
    }
  }

  return { mud, barrier };
}

export function stage2NowhereLayerLocations(worldSeed, chunkX, chunkZ) {
  const cells = stage2NowhereCells(worldSeed, chunkX, chunkZ);
  const expand = (entries) => entries.flatMap(({ x, z }) => (
    Array.from({ length: STAGE2_NOWHERE_HEIGHT }, (_, offset) => ({
      x,
      y: STAGE2_NOWHERE_Y + offset,
      z,
    }))
  ));
  return {
    mud: expand(cells.mud),
    barrier: expand(cells.barrier),
  };
}
