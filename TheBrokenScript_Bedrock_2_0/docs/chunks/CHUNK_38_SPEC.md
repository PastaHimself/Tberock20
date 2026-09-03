# Chunk 38 — Custom status-effect runtime adapter

## Goal

Port the two recovered custom mob-effect contracts into the existing Bedrock runtime without pretending that Bedrock can register Java effect IDs or attribute modifiers.

## Source contract

- Heart Corruption is harmful and magenta (0xFF00FF), adds -1.0 to MAX_HEALTH, and reports that it should apply an effect tick without implementing tick damage.
- Why Can't You Leave is neutral and black (-16777216), lasts 1,000 ticks at amplifier 0 with ambient/visible flags, and uses the source EYES particle.
- Reapplying a live script effect must not shorten its remaining duration.

## Bedrock adapter

- status_effect_model.js records the source metadata and deterministic expiry/health-cap rules.
- status_effect_runtime.js uses minecraft:health's effectiveMax, currentValue, and setCurrentValue to emulate the active one-point cap.
- ported_features.js refreshes dynamic-property expiries, enforces the cap during the effect window, and emits thebrokenscript:eyes for Why Can't You Leave.

## Non-goals

Custom mob-effect registration, Java attribute modifier installation, custom potion icons, and exact client effect-particle cadence remain engine-limited.

## Acceptance

- No unrelated magic damage is applied when Heart Corruption starts.
- Active Heart Corruption clamps current health to one below effective maximum.
- Why Can't You Leave keeps its source duration and particle identifier.
- Focused model/runtime regressions and JavaScript syntax checks pass.
