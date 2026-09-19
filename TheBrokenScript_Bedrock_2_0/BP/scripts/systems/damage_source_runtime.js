import * as operationDiagnostics from "../core/operation_diagnostics.js";
import { system } from "@minecraft/server";
import { damageSourceApplyOptions, damageSourcePlan } from "./damage_source_model.js";
import {
  appendDamageLedgerEntry,
  getDamageLedgerEntries,
  getLatestDamageLedgerEntry,
  pruneDamageLedger,
} from "./damage_source_ledger_model.js";

// Bedrock exposes only native causes in EntityHurt events. This short-lived
// ledger keeps the Java custom source id available to same-tick adapters while
// still sending the engine a valid Entity.applyDamage attribution object.
const damageLedger = new Map();

function currentTick() {
  try { return system.currentTick; } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.damage_source_runtime.js.16", "best-effort Bedrock API fallback", error); return 0; }
}

function remember(target, plan, accepted, fallback) {
  if (!target?.id) return;
  const tick = currentTick();
  pruneDamageLedger(damageLedger, tick, 1);
  appendDamageLedgerEntry(damageLedger, target.id, {
    sourceId: plan.sourceId,
    cause: plan.cause,
    amount: plan.amount,
    damagingEntityId: plan.damagingEntity?.id ?? null,
    damagingProjectileId: plan.damagingProjectile?.id ?? null,
    accepted,
    fallback,
    tick,
  });
}

try {
  system.runInterval(() => pruneDamageLedger(damageLedger, currentTick(), 1), 1);
} catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.damage_source_runtime.js.37", "best-effort Bedrock API fallback", error);}

/**
 * Applies a custom Java damage source through the nearest Bedrock native
 * cause. The return value retains the source id for callers and tests; the
 * same-tick records are available through getPortedDamageSources().
 * @param {any} target
 * @param {number} amount
 * @param {string} sourceId
 * @param {{cause?: string; damagingEntity?: any; damagingProjectile?: any}} [options]
 */
export function applyDamageWithSource(target, amount, sourceId, {
  cause,
  damagingEntity = null,
  damagingProjectile = null,
} = {}) {
  const plan = damageSourcePlan(sourceId, {
    amount,
    cause,
    damagingEntity,
    damagingProjectile,
  });
  const options = /** @type {any} */ (damageSourceApplyOptions(plan));

  let accepted = false;
  let fallback = false;
  try {
    accepted = target.applyDamage(amount, options) === true;
  } catch {
    fallback = true;
    try { accepted = target.applyDamage(amount) === true; } catch (error) { operationDiagnostics.warnOnce("audit.BP.scripts.systems.damage_source_runtime.js.67", "best-effort Bedrock API fallback", error);}
  }
  remember(target, plan, accepted, fallback);
  return { ...plan, accepted, fallback };
}

export function getLastPortedDamageSource(target, maxAgeTicks = 1) {
  return getLatestDamageLedgerEntry(damageLedger, target?.id, currentTick(), maxAgeTicks);
}

export function getPortedDamageSources(target, maxAgeTicks = 1) {
  return getDamageLedgerEntries(damageLedger, target?.id, currentTick(), maxAgeTicks);
}

export function clearPortedDamageSource(target) {
  if (target?.id) damageLedger.delete(target.id);
}
