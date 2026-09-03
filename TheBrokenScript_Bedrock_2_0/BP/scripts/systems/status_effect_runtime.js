import { heartCorruptionHealthCap } from "./status_effect_model.js";

export function enforceHeartCorruptionHealthCap(player, healthComponentId = "minecraft:health") {
  if (!player || typeof player.getComponent !== "function") return false;

  try {
    const health = player.getComponent(healthComponentId);
    if (!health || typeof health.currentValue !== "number" || typeof health.effectiveMax !== "number") {
      return false;
    }
    const cap = heartCorruptionHealthCap(health.effectiveMax);
    if (health.currentValue <= cap || typeof health.setCurrentValue !== "function") return false;
    health.setCurrentValue(cap);
    return true;
  } catch {
    return false;
  }
}
