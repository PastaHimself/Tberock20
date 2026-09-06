import test from "node:test";
import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import {
  CHORD_PROJECTILE_BEDROCK_ADAPTER,
  CHORD_PROJECTILE_SOURCE,
  chordProjectileBaseDamageFromMob,
  chordProjectileDifficultyId,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/chord_projectile_model.js";

const runtime = readFileSync(
  new URL("../TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/chord_projectile_runtime.js", import.meta.url),
  "utf8",
);

test("Chord inherits the vanilla AbstractArrow damage formula and source launch power", () => {
  assert.equal(CHORD_PROJECTILE_SOURCE.baseDamageFromMob, 2);
  assert.equal(CHORD_PROJECTILE_BEDROCK_ADAPTER.entityHitDamage, undefined);
  assert.equal(chordProjectileDifficultyId("peaceful"), 0);
  assert.equal(chordProjectileDifficultyId("easy"), 1);
  assert.equal(chordProjectileDifficultyId("normal"), 2);
  assert.equal(chordProjectileDifficultyId("hard"), 3);

  const samples = [0.9, 0.1];
  assert.ok(Math.abs(chordProjectileBaseDamageFromMob({
    power: CHORD_PROJECTILE_SOURCE.baseDamageFromMob,
    difficultyId: 2,
    randomDouble: () => samples.shift(),
  }) - 4.6794) < 1e-12);
});

test("Chord damage accepts Bedrock difficulty enum abbreviations and safe defaults", () => {
  assert.equal(chordProjectileDifficultyId("n"), 2);
  assert.equal(chordProjectileDifficultyId("h"), 3);
  assert.equal(chordProjectileDifficultyId("unknown"), 0);
  assert.equal(chordProjectileBaseDamageFromMob({
    power: 2,
    difficultyId: 0,
    randomDouble: () => 0.5,
  }), 4);
});

test("Chord runtime resolves world difficulty and delegates damage to the pure formula", () => {
  assert.match(runtime, /chordProjectileBaseDamageFromMob/);
  assert.match(runtime, /chordProjectileDifficultyId/);
  assert.match(runtime, /world\.getDifficulty\(\)/);
  assert.doesNotMatch(runtime, /CHORD_PROJECTILE_BEDROCK_ADAPTER\.entityHitDamage/);
});
