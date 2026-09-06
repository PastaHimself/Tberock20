# Chunk 39 — Custom status-effect adapter

## Goal

Port the two registered custom effects from `TBSEffects` into an explicit
Bedrock adapter while preserving their source metadata, timing, and player
visible behavior where the Script API permits.

## Source contract

- `heart_corruption` is harmful, magenta, applies a `MAX_HEALTH` modifier
  with value `-1.0`, and declares an effect tick hook without custom tick
  damage.
- `why_cant_you_leave` is neutral, black, ambient, visible, uses the Eyes
  particle, and is applied for 1000 ticks at amplifier 0.
- Reapplying either effect must not shorten an already-active source duration.

## Bedrock adapter

- Keep the recovered definitions in the pure `status_effect_model.js` catalog.
- Store finite effect expiry ticks in player dynamic properties.
- Use the documented health component's `effectiveMax`, `currentValue`, and
  `setCurrentValue` to emulate Heart Corruption's one-point health reduction.
- Reapply the cap every 20 ticks while active and emit the native
  `thebrokenscript:eyes` particle while Why Can't You Leave is active.

## Non-goals

Native custom effect registration, Java attribute-modifier identity, and a
custom potion icon remain engine-limited. Bedrock world/runtime smoke testing
is also unavailable in the local environment.

## Acceptance

- Source metadata, effect duration, and particle contracts are covered by
  focused deterministic tests.
- Heart Corruption writes the health component only when current health is
  above the source-derived cap.
- Malformed or unavailable health components fail closed.
- Focused tests, the legacy effect regression, and changed-runtime syntax checks pass.
