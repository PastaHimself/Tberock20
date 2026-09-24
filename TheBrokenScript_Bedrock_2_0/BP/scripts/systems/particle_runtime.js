import * as operationDiagnostics from "../core/operation_diagnostics.js";
import {
  libraryPaperOrigin,
  particleEventSpec,
  shouldSpawnLibraryPaper,
} from "./particle_model.js";

// Bedrock's Dimension.spawnParticle takes one effect id and one origin. The
// emitter resources own source counts/spread, so event handlers only need this
// small guarded bridge.
export function spawnSourceParticle(target, eventName, origin = target?.location) {
  if (!target?.dimension || !origin) return false;

  let event;
  try {
    event = particleEventSpec(eventName);
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.particle_runtime.js.12", "best-effort Bedrock API fallback", error);
    return false;
  }

  try {
    if (event.scope === "player" && typeof target.spawnParticle === "function") {
      target.spawnParticle(event.effectId, origin);
    } else {
      target.dimension.spawnParticle(event.effectId, origin);
    }
    return true;
  } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.particle_runtime.js.19", "best-effort Bedrock API fallback", error);
    return false;
  }
}

export function begin(scheduler, runtimeWorld) {
  scheduler.every("particle_runtime.library_paper", 1, () => {
    tickLibraryPaper(runtimeWorld);
  });
}

export function tickLibraryPaper(runtimeWorld, random = Math.random) {
  if (!runtimeWorld?.getAllPlayers) return 0;

  let spawned = 0;
  for (const player of runtimeWorld.getAllPlayers()) {
    if (player?.dimension?.id !== "thebrokenscript:library") continue;
    if (!shouldSpawnLibraryPaper(random)) continue;
    if (spawnSourceParticle(player, "library_paper", libraryPaperOrigin(player.location, random))) {
      spawned += 1;
    }
  }
  return spawned;
}
