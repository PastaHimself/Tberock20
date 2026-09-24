import { world } from "@minecraft/server";
import { logger } from "../core/logging.js";

// Chunk 11: script-driven worldgen builders.
// Source corpus: 305 Java .nbt structures + shaft/ (6 pieces) + xcsf phase3 arena
// (4MB custom format). NBT->mcstructure binary conversion deferred (needs offline
// tooling); signature structures are rebuilt procedurally here.

const BEDROCK = "minecraft:bedrock";
const AIR = "minecraft:air";

const built = new Set();

function setBlock(dim, x, y, z, id) {
  try {
    const b = dim.getBlock({ x: Math.floor(x), y: Math.floor(y), z: Math.floor(z) });
    if (b && b.typeId !== id) b.setType(id);
  } catch {}
}

function fillBox(dim, x0, y0, z0, x1, y1, z1, id) {
  for (let x = Math.min(x0, x1); x <= Math.max(x0, x1); x++)
    for (let y = Math.min(y0, y1); y <= Math.max(y0, y1); y++)
      for (let z = Math.min(z0, z1); z <= Math.max(z0, z1); z++)
        setBlock(dim, x, y, z, id);
}

// The Shaft (structure/shaft/*.nbt approximation):
// root pad at surface -> vertical bedrock shaft -> junction grid of halls -> rooms
export function buildShaft(dimension, origin, opts = {}) {
  const key = dimension.id + "|" + Math.floor(origin.x) + "|" + Math.floor(origin.z);
  if (built.has(key)) return false;
  built.add(key);

  const ox = Math.floor(origin.x);
  const oz = Math.floor(origin.z);
  let oy = Math.floor(origin.y);
  try {
    const top = dimension.getTopmostBlock?.({ x: ox, z: oz });
    if (top) {
      if (typeof top.y === "number") oy = top.y;
      else if (top.location && top.location.y !== undefined) oy = top.location.y;
    }
  } catch {}
  const depth = opts.depth ?? 48;
  const bottomY = Math.max(oy - depth, -60);

  // shaft_root: 7x7 bedrock pad with center opening
  fillBox(dimension, ox - 3, oy, oz - 3, ox + 3, oy, oz + 3, BEDROCK);
  fillBox(dimension, ox - 1, oy, oz - 1, ox + 1, oy + 4, oz + 1, AIR);

  // vertical shaft: hollow tube down
  for (let y = oy; y >= bottomY; y--) {
    fillBox(dimension, ox - 2, y, oz - 2, ox + 2, y, oz + 2, AIR);
    for (const [dx, dz] of [[-2,-2],[2,-2],[-2,2],[2,2],[0,-2],[0,2],[-2,0],[2,0]]) {
      setBlock(dimension, ox + dx, y, oz + dz, BEDROCK);
    }
    if ((oy - y) % 12 === 0) {
      // landing ledge every 12 blocks
      fillBox(dimension, ox - 2, y, oz - 2, ox + 2, y, oz + 2, BEDROCK);
      fillBox(dimension, ox - 1, y, oz - 1, ox + 1, y, oz + 1, AIR);
    }
  }

  // junction grid at the bottom (shaft_junction/shaft_hall/shaft_room approx)
  const hallLen = opts.hallLength ?? 16;
  for (const dir of [[hallLen, 0], [-hallLen, 0], [0, hallLen], [0, -hallLen]]) {
    carveHall(dimension, ox, bottomY, oz, dir[0], dir[1]);
    buildRoom(dimension, ox + dir[0] * 1.6, bottomY, oz + dir[1] * 1.6);
  }
  buildRoom(dimension, ox, bottomY - 5, oz);

  logger.info("worldgen: shaft built at " + ox + "," + oz + " depth=" + depth);
  return true;
}

function carveHall(dim, x, y, z, dx, dz) {
  const steps = Math.max(Math.abs(dx), Math.abs(dz));
  const sx = Math.sign(dx), sz = Math.sign(dz);
  for (let i = 0; i <= steps; i++) {
    const cx = x + sx * i, cz = z + sz * i;
    fillBox(dim, cx - 1, y, cz - 1, cx + 1, y + 2, cz + 1, AIR);
    setBlock(dim, cx, y - 1, cz, BEDROCK);
    if (i % 6 === 0) {
      setBlock(dim, cx - 1, y - 1, cz - 1, BEDROCK);
      setBlock(dim, cx + 1, y - 1, cz + 1, BEDROCK);
    }
  }
}

function buildRoom(dim, x, y, z) {
  const w = 3, h = 3;
  fillBox(dim, x - w, y, z - w, x + w, y + h, z + w, AIR);
  fillBox(dim, x - w - 1, y - 1, z - w - 1, x + w + 1, y - 1, z + w + 1, BEDROCK);
  for (let yy = y; yy <= y + h; yy++) {
    for (const p of [[-w - 1, -w - 1], [w + 1, -w - 1], [-w - 1, w + 1], [w + 1, w + 1]]) {
      setBlock(dim, x + p[0], yy, z + p[1], BEDROCK);
    }
  }
}

// Bedrock hallway segments (bedrockhallway1..10 approximation): L-shaped corridor
export function buildHallway(dimension, from, to) {
  const midX = { x: to.x, y: from.y, z: from.z };
  carveHall(dimension, Math.floor(from.x), Math.floor(from.y), Math.floor(from.z), Math.round(to.x - from.x), 0);
  carveHall(dimension, Math.floor(to.x), Math.floor(from.y), Math.floor(from.z), 0, Math.round(to.z - from.z));
  void midX;
  return true;
}
