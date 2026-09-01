import { EntityDamageCause, system } from "@minecraft/server";
import { damageSourcePlan } from "./damage_source_model.js";

// Bedrock exposes only native causes in EntityHurt events. This short-lived
// ledger keeps the Java custom source id available to same-tick adapters while
// still sending the engine a valid Entity.applyDamage attribution object.
const lastDamageByTarget = new Map();

function currentTick() {
  try { return system.currentTick; } catch { return 0; }
}

function remember(target, plan, accepted, fallback) {
  if (!target?.id) return;
  lastDamageByTarget.set(target.id, {
    sourceId: plan.sourceId,
    cause: plan.cause,
    amount: plan.amount,
    accepted,
    fallback,
    tick: currentTick(),
  });
}

/**
 * Applies a custom Java damage source through the nearest Bedrock native
 * cause. The return value retains the source id for callers and tests; the
 * same-tick record is available through getLastPortedDamageSource().
 */
export function applyDamageWithSource(target, amount, sourceId, {
  cause = EntityDamageCause.override,
  damagingEntity = null,
  damagingProjectile = null,
} = {}) {
  const plan = damageSourcePlan(sourceId, {
    amount,
    cause,
    damagingEntity,
    damagingProjectile,
  });
  const options = /** @type {any} */ ({ cause: plan.cause });
  if (damagingEntity) options.damagingEntity = damagingEntity;
  if (damagingProjectile) options.damagingProjectile = damagingProjectile;

  let accepted = false;
  let fallback = false;
  try {
    accepted = target.applyDamage(amount, options) === true;
  } catch {
    fallback = true;
    try { accepted = target.applyDamage(amount) === true; } catch {}
  }
  remember(target, plan, accepted, fallback);
  return { ...plan, accepted, fallback };
}

export function getLastPortedDamageSource(target, maxAgeTicks = 1) {
  const record = lastDamageByTarget.get(target?.id);
  if (!record) return null;
  if (currentTick() - record.tick > maxAgeTicks) {
    lastDamageByTarget.delete(target.id);
    return null;
  }
  return { ...record };
}

export function clearPortedDamageSource(target) {
  if (target?.id) lastDamageByTarget.delete(target.id);
}
