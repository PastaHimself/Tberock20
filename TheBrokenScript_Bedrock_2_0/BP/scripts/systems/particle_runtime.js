import { particleEventSpec } from "./particle_model.js";

// Bedrock's Dimension.spawnParticle takes one effect id and one origin. The
// emitter resources own source counts/spread, so event handlers only need this
// small guarded bridge.
export function spawnSourceParticle(target, eventName, origin = target?.location) {
  if (!target?.dimension || !origin) return false;

  let effectId;
  try {
    effectId = particleEventSpec(eventName).effectId;
  } catch {
    return false;
  }

  try {
    target.dimension.spawnParticle(effectId, origin);
    return true;
  } catch {
    return false;
  }
}
