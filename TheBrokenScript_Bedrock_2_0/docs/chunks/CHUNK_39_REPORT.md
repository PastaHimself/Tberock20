# Chunk 39 — Custom status-effect adapter

## Result

The two recovered custom effects now have a source-backed Bedrock adapter.
`status_effect_model.js` catalogs the identifiers, categories, colors, timing,
visibility, particle, and Heart Corruption modifier contract. The runtime stores
finite expiry ticks, refreshes them without shortening active effects, caps
Heart Corruption current health at one below the documented effective maximum,
and emits the source Eyes particle while Why Can't You Leave is active.

## Source evidence

- `decompiled/net/thebrokenscript/effects/HeartCorruptionMobEffect.java`
- `decompiled/net/thebrokenscript/effects/WhyCantYouLeaveMobEffect.java`
- `decompiled/net/thebrokenscript/events/WhyCantYouLeaveEvent.java`
- `decompiled/net/thebrokenscript/registry/TBSEffects.java`

## Validation

- TDD RED: model and runtime tests failed before their modules existed.
- TDD GREEN: focused status tests — **6/6 passed**.
- The legacy effect regression now accepts the model-backed Eyes identifier.
- Changed `status_effect_model.js`, `status_effect_runtime.js`, and
  `ported_features.js` pass `node --check`.
- Microsoft Learn and BedrockWiki verified the health component contract:
  `effectiveMax`, `currentValue`, and `setCurrentValue(value)`.
- Bedrock world/runtime smoke testing remains unavailable locally; GitHub
  Actions is the authoritative pack/schema gate.

## Parity

Source metadata and finite timing are preserved. Heart Corruption's Java
attribute modifier is approximated by a health-component cap, and Why Can't You
Leave's source Eyes particle is bridged to the native Bedrock emitter. Native
custom effect registration, modifier identity, and custom potion icon remain
engine-limited.
