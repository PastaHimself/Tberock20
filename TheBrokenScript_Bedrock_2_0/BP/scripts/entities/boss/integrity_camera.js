import { logger } from "../../core/logging.js";

// Bedrock Camera API adapter for Integrity presentation. Java packet-level camera
// behavior is not copied directly; callers supply the source-backed camera
// position/target and this module owns the supported Bedrock equivalent.
const FREE_CAMERA_PRESET = "minecraft:free";

function validVector3(value) {
  return value && [value.x, value.y, value.z].every(Number.isFinite);
}

export function setIntegrityCamera(player, location, facingLocation) {
  if (!player?.camera || !validVector3(location) || !validVector3(facingLocation)) {
    logger.errorOnce(
      "integrity-camera-invalid-input",
      "integrity camera: player camera or required position is unavailable",
    );
    return false;
  }

  try {
    player.camera.setCamera(FREE_CAMERA_PRESET, {
      location: { x: location.x, y: location.y, z: location.z },
      facingLocation: {
        x: facingLocation.x,
        y: facingLocation.y,
        z: facingLocation.z,
      },
    });
    return true;
  } catch (error) {
    logger.errorOnce(
      "integrity-camera-set-failed",
      "integrity camera: failed to set Bedrock free camera",
      error,
    );
    return false;
  }
}

export function clearIntegrityCamera(player) {
  if (!player?.camera) {
    logger.errorOnce(
      "integrity-camera-clear-unavailable",
      "integrity camera: player camera is unavailable during cleanup",
    );
    return false;
  }

  try {
    player.camera.clear();
    return true;
  } catch (error) {
    logger.errorOnce(
      "integrity-camera-clear-failed",
      "integrity camera: failed to restore the player camera",
      error,
    );
    return false;
  }
}
