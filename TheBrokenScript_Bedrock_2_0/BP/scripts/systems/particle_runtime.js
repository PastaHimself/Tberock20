import * as operationDiagnostics from "../core/operation_diagnostics.js";
import { particleEventSpec } from "./particle_model.js";

// Bedrock's Dimension.spawnParticle takes one effect id and one origin. The
// emitter resources own source counts/spread, so event handlers only need this
// small guarded bridge.
export function spawnSourceParticle(target, eventName, origin = target?.location) {
  if (!target?.dimension || !origin) return false;

  let effectId;
  try {
    effectId = particleEventSpec(eventName).effectId;
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.particle_runtime.js.12", "best-effort Bedrock API fallback", error);
    return false;
  }

  try {
    target.dimension.spawnParticle(effectId, origin);
    return true;
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.particle_runtime.js.19", "best-effort Bedrock API fallback", error);
    return false;
  }
}
