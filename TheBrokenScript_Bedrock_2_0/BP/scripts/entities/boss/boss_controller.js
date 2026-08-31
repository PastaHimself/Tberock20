import { world, system } from "@minecraft/server";
import { EntityDamageCause } from "@minecraft/server";
import * as bossHooks from "../../systems/boss_hooks.js";
import * as entityFinder from "../../systems/ai/entity_finder.js";
import { logger } from "../../core/logging.js";
import * as perf from "../../systems/perf.js";
import { registerChordProjectileLaunch } from "./chord_projectile_runtime.js";
import {
  GROUND_ARM_SOURCE,
  GROUND_ATTACK_SOURCE,
  PHASE3_SOURCE,
  TETHER_SOURCE,
  VOID_TENTACLE_SOURCE,
  phase3BoundaryKillStep,
  phase3TentacleCandidatePosition,
  groundArmImpactPlan,
  groundArmLifecycleStep,
  groundAttackCanUse,
  groundAttackStep,
  tetherDamageBlocked,
  tetherHeartbeatStep,
  voidTentacleAttackPlan,
  voidTentacleDamageAllowed,
  voidTentacleScaleFromRoll,
  voidTentacleSweepPlan,
} from "../../systems/integrity_arena_model.js";

// ── boss death sequence (Chunk 14 presentation) ─────────────────────────────
let deathHookInstalled = false;
function installDeathHook() {
  if (deathHookInstalled) return;
  deathHookInstalled = true;
  try {
    world.afterEvents.entityDie.subscribe((ev) => {
      const id = ev.deadEntity.typeId;
      const isBoss =
        id.startsWith("thebrokenscript:integrity") ||
        id === "thebrokenscript:fractured" ||
        id === "thebrokenscript:the_obliteration" ||
        id === "thebrokenscript:the_obliteration_2";
      if (!isBoss) return;
      try { ev.deadEntity.dimension.playSound("thebrokenscript:integrity_dies", ev.deadEntity.location, { volume: 10, pitch: 1 }); } catch {}
      if (id.startsWith("thebrokenscript:integrity")) bossHooks.setArenaState(false, false);
    });
  } catch {}
}

// ── constants from decompiled sources ──────────────────────────────────────
// Integrity phase advancement is owned by Arena/Phase source semantics, not HP
// fractions. Source-backed arena constants/predicates live in integrity_arena_model.js;
// automatic arena startup remains disabled until its Java callsite is recovered.
// Phase 3 ring spawning and boundary countdown are wired below. The Java
// participant roster/transfer and custom camera packets remain engine gaps.
// Fractured, Rock, and FracturedRoam are owned by the dedicated source-specific runtime.
// murderfur: Kerfur pet — follows nearest player, meow pitch 0.9-1.2
// fever: flying chaser 10 dmg + blindness; fever_stalk static then summons fever
// chord: flying attacker 4 dmg; chord_projectile launch is delegated to its
// source-specific runtime adapter (the 6-damage value remains isolated there).
// tether/void_tentacle: proximity hazards
const FIREBALL_SPEED = 0.8;
  setNum(e, "life", life);
  if (life <= 0) { try { e.remove(); } catch {} deleteTimers(e); }
}

// ── Fractured (Jimmy) ────────────────────────────────────────────────────────
// The dedicated fractured runtime performs the source-specific work after this
// family scan reaches the harmless compatibility dispatch below.
function tickFracturedRoam(e) {
  // The dedicated runtime owns the source timers, underground goal, despawn,
  // and JimArena handoff. Keep the generic family dispatch harmless so this
  // controller cannot apply a second, fabricated promotion or drift tick.
  return e;
}


// ── Murderfur (Kerfur pet) ───────────────────────────────────────────────────
function tickMurderfur(e) {
  const owner = entityFinder.closestPlayerInRange(world.getAllPlayers(), e.location, 400);
  if (owner) {
    const d = distance(e.location, owner.location);
    if (d > 6 && system.currentTick % 15 === 0) approach(e, owner, 0.45);
    try { e.lookAt?.(owner.location); } catch {}
  }
  if (Math.random() < 0.001) {
