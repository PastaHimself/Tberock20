import test from "node:test";
import assert from "node:assert/strict";
import { readFileSync } from "node:fs";
import { join } from "node:path";
import {
  SOURCE_PARTICLE_DEFINITIONS,
  SOURCE_PARTICLE_EVENTS,
  particleDefinition,
  particleEventSpec,
  particleLifetimeRangeSeconds,
} from "../TheBrokenScript_Bedrock_2_0/BP/scripts/systems/particle_model.js";

const PARTICLE_DIR = join(process.cwd(), "TheBrokenScript_Bedrock_2_0", "RP", "particles");

function readParticle(id) {
  return JSON.parse(readFileSync(join(PARTICLE_DIR, `${id}.particle.json`), "utf8"));
}

test("source particle catalog preserves every declared resource definition", () => {
  assert.deepEqual(Object.keys(SOURCE_PARTICLE_DEFINITIONS), [
    "eyes",
    "fardaway",
    "follows_particle",
    "null_particle",
    "null_structure_particle",
    "paper_particle",
    "particle_of_curved",
    "revuxor_particle",
    "wretched_particle",
  ]);

  assert.equal(particleDefinition("eyes").sourceTexture, "thebrokenscript:eyes");
  assert.equal(particleDefinition("fardaway").targetTexture, "textures/particle/funny/fardaway");
  assert.equal(particleDefinition("follows_particle").javaProvider, false);
  assert.equal(particleDefinition("revuxor_particle").portability, "resource_only");
});

test("Java particle providers retain source size, lifetime, and render contracts", () => {
  assert.deepEqual(particleLifetimeRangeSeconds("eyes"), { min: 0.35, max: 0.35 });
  assert.deepEqual(particleLifetimeRangeSeconds("null_structure_particle"), { min: 3, max: 3 });
  assert.deepEqual(particleLifetimeRangeSeconds("fardaway"), { min: 0.05, max: 2.8 });
  assert.deepEqual(particleLifetimeRangeSeconds("paper_particle"), { min: 5, max: 9.95 });
  assert.deepEqual(particleLifetimeRangeSeconds("particle_of_curved"), { min: 0.25, max: 1.2 });
  assert.deepEqual(particleLifetimeRangeSeconds("wretched_particle"), { min: 0.35, max: 1.3 });

  assert.equal(particleDefinition("fardaway").render.material, "particles_alpha");
  assert.equal(particleDefinition("fardaway").render.fullbright, true);
  assert.equal(particleDefinition("null_particle").render.material, "particles_opaque");
  assert.equal(particleDefinition("paper_particle").motion.adapter, "crossed_quads_flutter");
  assert.equal(particleDefinition("particle_of_curved").size, 10);
  assert.equal(particleDefinition("wretched_particle").size, 0.6);
});

test("known Java sendParticles callsites keep source counts and spread", () => {
  assert.deepEqual(SOURCE_PARTICLE_EVENTS.null_particle, {
    effectId: "thebrokenscript:null_particle",
    count: 5,
    offset: [3, 3, 3],
  });
  assert.deepEqual(SOURCE_PARTICLE_EVENTS.eyes, {
    effectId: "thebrokenscript:eyes",
    count: 5,
    offset: [3, 3, 3],
  });
  assert.deepEqual(SOURCE_PARTICLE_EVENTS.curved_despawn, {
    effectId: "thebrokenscript:particle_of_curved",
    count: 55,
    offset: [3, 3, 3],
  });
  assert.deepEqual(particleEventSpec("curved_despawn"), SOURCE_PARTICLE_EVENTS.curved_despawn);
});

test("Bedrock emitters expose the source identifiers and event cardinalities", () => {
  for (const [id, definition] of Object.entries(SOURCE_PARTICLE_DEFINITIONS)) {
    const effect = readParticle(id).particle_effect;
    assert.equal(effect.description.identifier, `thebrokenscript:${id}`);
    assert.equal(effect.description.basic_render_parameters.texture, definition.targetTexture);
  }

  assert.equal(readParticle("eyes").particle_effect.components["minecraft:emitter_rate_instant"].num_particles, 5);
  assert.equal(readParticle("null_particle").particle_effect.components["minecraft:emitter_rate_instant"].num_particles, 5);
  assert.equal(readParticle("particle_of_curved").particle_effect.components["minecraft:emitter_rate_instant"].num_particles, 55);
});

test("unknown particle identifiers fail loudly", () => {
  assert.throws(() => particleDefinition("missing_particle"), /Unknown source particle/);
  assert.throws(() => particleEventSpec("missing_event"), /Unknown source particle event/);
});
