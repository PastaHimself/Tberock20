export const FACE_OFFSETS = Object.freeze({
  Up: [0, 1, 0], Down: [0, -1, 0],
  North: [0, 0, -1], South: [0, 0, 1],
  East: [1, 0, 0], West: [-1, 0, 0],
});

export function adjacent(location, face) {
  const offset = FACE_OFFSETS[String(face)];
  if (!offset) return undefined;
  return { x: location.x + offset[0], y: location.y + offset[1], z: location.z + offset[2] };
}

export function plushName(id) {
  return /^thebrokenscript:([a-z0-9_]+)_plush$/.exec(id)?.[1];
}

export function plushDirection(view) {
  if (Math.abs(view.x) > Math.abs(view.z)) return view.x > 0 ? "west" : "east";
  return view.z > 0 ? "north" : "south";
}

export function flowLevel(level, besideSource = false) {
  return besideSource ? 1 : level < 7 ? level + 1 : undefined;
}
