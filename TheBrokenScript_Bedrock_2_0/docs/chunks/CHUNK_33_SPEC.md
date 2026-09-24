# Chunk 33 — Rock block-impact particle burst

## Source contract

`RockEntity.onHitBlock` emits 400 `BlockParticleOption(ParticleTypes.BLOCK, MOON_STONE)` particles after the superclass block-hit path. Each particle is offset from the impact position by independent random values in x/z `[-15, 15]` and y `[-7.5, 7.5]`, with initial velocity `(0, 2, 0)`. The entity is queued for discard one tick later.

Source evidence: `decompiled/net/thebrokenscript/entity/fractured/RockEntity.java`.

## Bedrock port

- `FRACTURED_SOURCE.rock.blockParticleBurst` records the source count, material-backed effect id, offset ranges, and initial velocity.
- `fracturedRockBlockBurstPlan` keeps the burst contract pure and testable.
- `moon_stone_block_burst.particle.json` emits exactly 400 particles using the existing moon-stone texture and source offset ranges.
- `fractured_runtime.js` invokes the emitter once at block impact; the existing one-tick grounded cleanup remains unchanged.

The emitter's lifetime and motion integration are Bedrock particle-system behavior because Java client `TerrainParticle` internals are not exposed to add-ons.

