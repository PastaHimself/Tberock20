// Source-backed contact points for Fractured/Jimmy attack events.
// Bedrock cannot expose GeckoLib render-bone matrices, so callers may provide
// captured world positions when a bridge exists; otherwise this module returns
// the least speculative source-preserving fallback.

import { FRACTURED_SOURCE } from "./fractured_attack_model.js";
import { FRACTURED_RENDERED_CONTACT_SOURCE } from "./fractured_animation_model.js";

const CONTACT_EVENTS = Object.freeze(Object.fromEntries(
  Object.entries(FRACTURED_RENDERED_CONTACT_SOURCE.events).map(([eventName, source]) => [
    eventName,
    Object.freeze({
      bones: Object.freeze([...source.bones]),
      fallbackMode: source.spatialAdapter === "source_stomp_offset"
        ? "source_stomp_offset"
        : "entity_anchor",
      fallbackOffsets: source.spatialAdapter === "source_stomp_offset"
        ? Object.freeze([{ ...FRACTURED_SOURCE.stomp.offset }])
        : Object.freeze([]),
    }),
  ]),
)));

export const FRACTURED_CONTACT_EVENTS = CONTACT_EVENTS;

function copyPosition(position) {
  return { x: position.x, y: position.y, z: position.z };
}

function isPosition(position) {
  return position
    && Number.isFinite(position.x)
    && Number.isFinite(position.y)
    && Number.isFinite(position.z);
}

function rotateOffset(offset, yawDegrees) {
  const yaw = (-Number(yawDegrees || 0) * Math.PI) / 180 + Math.PI;
  return {
    x: offset.x * Math.cos(yaw) - offset.z * Math.sin(yaw),
    y: offset.y,
    z: offset.x * Math.sin(yaw) + offset.z * Math.cos(yaw),
  };
}

function sourceOffsetPosition(origin, offset, yawDegrees) {
  const rotated = rotateOffset(offset, yawDegrees);
  return {
    x: origin.x + rotated.x,
    y: origin.y + rotated.y,
    z: origin.z + rotated.z,
  };
}

/**
 * Resolves the source contact bones for one attack event.
 *
 * @param {{
 *   eventName: string,
 *   origin?: { x: number, y: number, z: number },
 *   yawDegrees?: number,
 *   boneWorldPositions?: Record<string, { x: number, y: number, z: number }>,
 * }} options
 */
export function resolveFracturedContactPositions({
  eventName,
  origin = { x: 0, y: 0, z: 0 },
  yawDegrees = 0,
  boneWorldPositions = {},
} = {}) {
  const definition = CONTACT_EVENTS[eventName];
  if (!definition) throw new Error("Unknown Fractured contact event: " + eventName);
  const missingBones = definition.bones.filter((bone) => !isPosition(boneWorldPositions[bone]));
  if (missingBones.length === 0) {
    return {
      mode: "rendered_bone_world_position",
      positions: definition.bones.map((bone) => copyPosition(boneWorldPositions[bone])),
      missingBones: [],
    };
  }
  if (definition.fallbackMode === "source_stomp_offset") {
    return {
      mode: definition.fallbackMode,
      positions: definition.fallbackOffsets.map((offset) => sourceOffsetPosition(origin, offset, yawDegrees)),
      missingBones,
    };
  }
  return {
    mode: "entity_anchor_fallback",
    positions: definition.bones.map(() => copyPosition(origin)),
    missingBones,
  };
}
