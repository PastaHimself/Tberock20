// Source-backed particle contracts for the Java particle providers and their
// known sendParticles callsites. This module is pure so it can be regression-
// tested without a Bedrock runtime.

const TICKS_PER_SECOND = 20;

const lifetimeTicks = (min, max = min) => Object.freeze({ min, max });
const render = (material, fullbright = false) => Object.freeze({ material, fullbright });
const motion = (kind, adapter = null) => Object.freeze({ kind, adapter });

export const SOURCE_PARTICLE_DEFINITIONS = Object.freeze({
  eyes: Object.freeze({
    sourceTexture: "thebrokenscript:eyes",
    targetTexture: "textures/particle/eyes",
    javaProvider: true,
    portability: "native",
    size: 0.4,
    lifetimeTicks: lifetimeTicks(7),
    render: render("particles_alpha", true),
    motion: motion("static"),
  }),
  fardaway: Object.freeze({
    sourceTexture: "thebrokenscript:funny/fardaway",
    targetTexture: "textures/particle/funny/fardaway",
    javaProvider: true,
    portability: "native",
    size: 1,
    lifetimeTicks: lifetimeTicks(1, 56),
    render: render("particles_alpha", true),
    motion: motion("static"),
  }),
  follows_particle: Object.freeze({
    sourceTexture: "thebrokenscript:follows_particle",
    targetTexture: "textures/particle/follows_particle",
    javaProvider: false,
    portability: "resource_only",
    size: 0.5,
    lifetimeSeconds: Object.freeze({ min: 0.5, max: 0.5 }),
    render: render("particles_alpha"),
    motion: motion("unknown_source_provider"),
  }),
  null_particle: Object.freeze({
    sourceTexture: "thebrokenscript:null_particle",
    targetTexture: "textures/particle/null_particle",
    javaProvider: true,
    portability: "native",
    size: 1,
    lifetimeTicks: lifetimeTicks(1, 56),
    render: render("particles_opaque"),
    motion: motion("static"),
  }),
  null_structure_particle: Object.freeze({
    sourceTexture: "thebrokenscript:null_structure_particle",
    targetTexture: "textures/particle/null_structure_particle",
    javaProvider: true,
    portability: "native",
    size: 0.5,
    lifetimeTicks: lifetimeTicks(60),
    render: render("particles_alpha"),
    motion: motion("static"),
  }),
  paper_particle: Object.freeze({
    sourceTexture: "thebrokenscript:paper_particle",
    targetTexture: "textures/particle/paper_particle",
    javaProvider: true,
    portability: "adapter",
    size: 0.25,
    lifetimeTicks: lifetimeTicks(100, 199),
    render: render("particles_alpha"),
    motion: motion("dynamic", "crossed_quads_flutter"),
  }),
  particle_of_curved: Object.freeze({
    sourceTexture: "thebrokenscript:particle_of_curved",
    targetTexture: "textures/particle/particle_of_curved",
    javaProvider: true,
    portability: "native",
    size: 10,
    lifetimeTicks: lifetimeTicks(5, 24),
    render: render("particles_opaque"),
    motion: motion("static"),
  }),
  revuxor_particle: Object.freeze({
    sourceTexture: "thebrokenscript:revuxor_particle",
    targetTexture: "textures/particle/revuxor_particle",
    javaProvider: false,
    portability: "resource_only",
    size: 0.7,
    lifetimeSeconds: Object.freeze({ min: 0.5, max: 0.5 }),
    render: render("particles_alpha"),
    motion: motion("unknown_source_provider"),
  }),
  wretched_particle: Object.freeze({
    sourceTexture: "thebrokenscript:wretched_particle",
    targetTexture: "textures/particle/wretched_particle",
    javaProvider: true,
    portability: "native",
    size: 0.6,
    lifetimeTicks: lifetimeTicks(7, 26),
    render: render("particles_opaque"),
    motion: motion("static"),
  }),
});

// These are the three source sendParticles callsites that have a concrete
// Bedrock runtime consumer. The emitter JSON carries the count and box spread
// because Dimension.spawnParticle accepts an effect id and origin only.
export const SOURCE_PARTICLE_EVENTS = Object.freeze({
  null_particle: Object.freeze({
    effectId: "thebrokenscript:null_particle",
    count: 5,
    offset: Object.freeze([3, 3, 3]),
  }),
  eyes: Object.freeze({
    effectId: "thebrokenscript:eyes",
    count: 5,
    offset: Object.freeze([3, 3, 3]),
  }),
  curved_despawn: Object.freeze({
    effectId: "thebrokenscript:particle_of_curved",
    count: 55,
    offset: Object.freeze([3, 3, 3]),
  }),
});

export function particleDefinition(id) {
  const definition = SOURCE_PARTICLE_DEFINITIONS[id];
  if (!definition) throw new Error(`Unknown source particle: ${id}`);
  return definition;
}

export function particleEventSpec(eventName) {
  const event = SOURCE_PARTICLE_EVENTS[eventName];
  if (!event) throw new Error(`Unknown source particle event: ${eventName}`);
  return event;
}

export function particleLifetimeRangeSeconds(id) {
  const definition = particleDefinition(id);
  if (definition.lifetimeSeconds) return definition.lifetimeSeconds;
  return Object.freeze({
    min: definition.lifetimeTicks.min / TICKS_PER_SECOND,
    max: definition.lifetimeTicks.max / TICKS_PER_SECOND,
  });
}
