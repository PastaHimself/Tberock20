# Chunk 36 — Source particle resources and event bridge

## Scope

Port the remaining eight source particle resource definitions, retain the
existing `eyes` resource's Java size/lifetime contract, and replace the three
known source `sendParticles` callsites with named Bedrock emitters.

## Source evidence

- `source_extracted/assets/thebrokenscript/particles/*.json` declares nine
  texture identifiers: `eyes`, `fardaway`, `follows_particle`,
  `null_particle`, `null_structure_particle`, `paper_particle`,
  `particle_of_curved`, `revuxor_particle`, and `wretched_particle`.
- The decompiled Java providers preserve billboard sizes, source tick
  lifetimes, render-sheet material, and the Paper particle's custom flutter
  behavior.
- `NullParticleEvent` and `EyesEvent` send five particles with three-block
  offsets; `CurvedEntity` sends 55 `particle_of_curved` particles with the same
  spread when its 6200-tick despawn timer expires.
- Bedrock's particle effect format supports emitter lifetime/rate/shape,
  particle lifetime, initial speed, billboard appearance, lighting, and
  dynamic motion. `Dimension.spawnParticle` accepts a named effect and origin.

## Translation contract

| Source definition | Bedrock effect | Provider status | Source-backed values |
|---|---|---|---|
| `eyes` | `thebrokenscript:eyes` | registered provider | size `0.4`; lifetime `7t`; lit/fullbright sheet |
| `fardaway` | `thebrokenscript:fardaway` | registered provider | size `1`; lifetime `1..56t`; static/fullbright sheet |
| `follows_particle` | `thebrokenscript:follows_particle` | resource-only | texture retained; no Java provider found |
| `null_particle` | `thebrokenscript:null_particle` | registered provider | size `1`; lifetime `1..56t`; opaque sheet |
| `null_structure_particle` | `thebrokenscript:null_structure_particle` | registered provider | size `0.5`; lifetime `60t`; lit sheet |
| `paper_particle` | `thebrokenscript:paper_particle` | registered adapter | size `0.25`; lifetime `100..199t`; dynamic flutter adapter |
| `particle_of_curved` | `thebrokenscript:particle_of_curved` | registered provider | size `10`; lifetime `5..24t`; opaque sheet |
| `revuxor_particle` | `thebrokenscript:revuxor_particle` | resource-only | texture retained; no Java provider found |
| `wretched_particle` | `thebrokenscript:wretched_particle` | registered provider | size `0.6`; lifetime `7..26t`; opaque sheet |

Emitter count and spread are encoded in the three event resources because the
Bedrock Script API takes an effect id and origin rather than Java's count and
offset arguments.

## Acceptance criteria

- Every declared source particle has a Bedrock `.particle.json` and copied
  source texture under `RP/textures/particle`.
- The pure model preserves all source identifiers, provider/resource-only
  status, sizes, lifetimes, and known event counts/spread.
- Null and Eyes events invoke their named effects; Curved invokes its named
  effect once at despawn and no longer emits per-tick smoke.
- Focused and full Node regressions pass; changed JavaScript parses; all touched
  JSON parses; the GitHub Bedrock workflow remains green.

## Explicit differences

Paper's Java renderer draws crossed custom quads and applies a roll-dependent
wave. Bedrock receives a single billboard with dynamic motion/drag as the
closest supported presentation. `follows_particle` and `revuxor_particle` are
resource-only because no registered Java providers were present in the source
registry/decompiled provider list.
