import assert from "node:assert/strict";
import test from "node:test";
import {
  CHORD_PROJECTILE_BEDROCK_ADAPTER,
  CHORD_PROJECTILE_SOURCE,
  chordProjectileBlockHitStep,
  chordProjectileDirection,
  chordProjectileShouldDiscardForTravel,
  chordProjectileTravelDistance,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/chord_projectile_model.js";

test("ChordProjectileEntity source contract is preserved", () => {
  assert.deepEqual(CHORD_PROJECTILE_SOURCE, {
    saved: false,
    noGravityInFlight: true,
    launchSpeedBlocksPerTick: 1.6,
    launchInaccuracy: 0,
    maxTravelDistance: 100,
    blockHitDiscardDelayTicks: 20,
    pickupItem: null,
    baseDamageFromMob: 2,
    discardOnChordHit: true,
    discardOnCreativePlayerHit: true,
    restoreGravityAfterEntityHit: true,
    restoreGravityAfterBlockHit: true,
  });
  assert.equal(CHORD_PROJECTILE_BEDROCK_ADAPTER.runtimeStatus, "adapted_brokencore_arrow_damage");
  assert.equal(CHORD_PROJECTILE_BEDROCK_ADAPTER.entityHitDamage, 6);
});

test("Chord projectile direction keeps Java speed separate from aim normalization", () => {
  assert.deepEqual(chordProjectileDirection({ x: 3, y: 4, z: 0 }), { x: 0.6, y: 0.8, z: 0 });
  assert.equal(chordProjectileDirection({ x: 0, y: 0, z: 0 }), null);
});

test("Chord projectile expires by 100-block travel distance, not a fabricated tick lifetime", () => {
  const initial = { x: 10, y: 20, z: 30 };
  assert.equal(chordProjectileTravelDistance({ x: 10, y: 20, z: 129.99 }, initial) < 100, true);
  assert.equal(chordProjectileShouldDiscardForTravel({ x: 10, y: 20, z: 129.99 }, initial), false);
  assert.equal(chordProjectileShouldDiscardForTravel({ x: 10, y: 20, z: 130 }, initial), true);
});

test("Chord projectile block hit queues the source 20-tick discard", () => {
  assert.deepEqual(chordProjectileBlockHitStep(null), {
    grounded: true,
    discard: false,
    discardTicksRemaining: 20,
  });
  assert.deepEqual(chordProjectileBlockHitStep(20), {
    grounded: true,
    discard: false,
    discardTicksRemaining: 19,
  });
  assert.deepEqual(chordProjectileBlockHitStep(1), {
    grounded: true,
    discard: false,
    discardTicksRemaining: 0,
  });
  assert.deepEqual(chordProjectileBlockHitStep(0), {
    grounded: true,
    discard: true,
    discardTicksRemaining: 0,
  });
});
