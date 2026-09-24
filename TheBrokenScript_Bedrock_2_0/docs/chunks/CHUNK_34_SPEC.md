# Chunk 34 — Custom damage-source catalog and attribution adapter

## Objective

Port the Java custom damage-source definitions into the Bedrock add-on without inventing unsupported `damage_type` JSON. Preserve the source metadata and route recoverable callsites through the native Script API damage attribution fields.

## Source boundary

- `source_extracted/data/thebrokenscript/damage_type/*.json` — 15 definitions.
- `decompiled/net/thebrokenscript/registry/TBSDamageTypes.java` — registry builders, death text, no-knockback, and bypass flags.
- Recovered callsites in Jimmy stomp, Rock, Integrity Phase 3, Fever, and Chord behavior.

## Contract

1. `damage_source_model.js` exposes exactly 15 namespaced source definitions.
2. Each definition retains source message metadata, effects, exhaustion, scaling, no-knockback, and bypass flags.
3. `damageSourcePlan()` preserves the custom source id beside a native Bedrock cause and optional damaging entity/projectile.
4. `damage_source_runtime.js` applies the native options and records the custom id for same-tick runtime consumers.
5. Existing recovered callsites use the adapter; generic fallback damage remains unchanged.

## Explicit limitation

Bedrock's current Script API does not register arbitrary Java damage types. Native cause handling therefore remains an adapter for exact custom death messages, exhaustion/scaling, and bypass semantics.

## Acceptance checks

- TDD red phase: catalog import fails before the model exists.
- TDD green phase: 53/53 Node regressions pass.
- `node --check` passes for model, runtime adapter, and touched boss runtimes.
- Touched JSON files parse successfully.
