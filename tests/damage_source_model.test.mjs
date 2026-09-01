import test from "node:test";
import assert from "node:assert/strict";
import {
  CUSTOM_DAMAGE_SOURCE_COUNT,
  CUSTOM_DAMAGE_SOURCE_KEYS,
  CUSTOM_DAMAGE_SOURCES,
  damageSourcePlan,
  getDamageSource,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/damage_source_model.js";

test("catalog contains every source-registered custom damage type", () => {
  assert.equal(CUSTOM_DAMAGE_SOURCE_COUNT, 15);
  assert.deepEqual(CUSTOM_DAMAGE_SOURCE_KEYS, [
    "bad_sun",
    "bite",
    "fever_attack",
    "circuit_attack",
    "chord_lazer",
    "integrity_ball",
    "null_maze",
    "rock",
    "jimmy_rise",
    "sa1",
    "jimmy_stomp",
    "void_mass",
    "integ_bypass",
    "hand_cannon_damage",
    "sub_anom_2",
  ]);
  assert.equal(Object.keys(CUSTOM_DAMAGE_SOURCES).length, CUSTOM_DAMAGE_SOURCE_COUNT);
});

test("source definitions preserve resource and registry semantics", () => {
  const badSun = getDamageSource("thebrokenscript:bad_sun");
  assert.equal(badSun.effects, "burning");
  assert.equal(badSun.exhaustion, 0);
  assert.equal(badSun.scaling, "never");
  assert.equal(badSun.noKnockback, true);
  assert.equal(badSun.bypasses.totem, true);

  const voidMass = getDamageSource("void_mass");
  assert.equal(voidMass.messageId, "thebrokenscript.void_mass");
  assert.equal(voidMass.deathMessage, "%1$s is no more.");
  assert.equal(voidMass.deathByPlayerMessage, "%1$s became no more while fighting %2$s");
  assert.deepEqual(voidMass.bypasses, {
    armor: true,
    effects: true,
    invulnerability: true,
    shield: true,
    totem: true,
  });

  const shieldBypass = getDamageSource("integ_bypass");
  assert.equal(shieldBypass.bypasses.invulnerability, false);
  assert.equal(shieldBypass.bypasses.shield, true);
  assert.equal(shieldBypass.deathMessage, "%1$s has been killed");
});

test("damage plan preserves source id while carrying Bedrock attribution", () => {
  const plan = damageSourcePlan("rock", {
    amount: 15,
    cause: "projectile",
    damagingEntity: "jimmy-id",
    damagingProjectile: "rock-id",
  });
  assert.deepEqual(plan, {
    sourceId: "thebrokenscript:rock",
    amount: 15,
    cause: "projectile",
    damagingEntity: "jimmy-id",
    damagingProjectile: "rock-id",
  });
});

test("damage plan uses the neutral override cause only when no native cause is supplied", () => {
  assert.equal(damageSourcePlan("sub_anom_2").cause, "override");
  assert.throws(() => damageSourcePlan("thebrokenscript:not_a_real_source"), /Unknown custom damage source/);
});
