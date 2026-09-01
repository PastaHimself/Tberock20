# Chunk 36 — Source particle resources and event bridge

## Result

Implemented the source particle slice for all nine declared particle resource
identifiers. Eight missing source PNGs are preserved in the resource pack, and
the existing Eyes resource now carries the source event's five-particle,
three-block spread. Null/Eyes ambient events use named Bedrock particle effects;
Curved emits the source-counted particle burst once at its 6200-tick despawn.

## TDD evidence

- Red: `node --test tests/particle_model.test.mjs` failed because the new pure
  model module did not exist.
- Green: the model catalog and emitter resources pass the focused regressions.
- Red: `node --test tests/particle_runtime.test.mjs` failed because the runtime
  adapter did not exist.
- Green: the adapter resolves event ids, accepts explicit origins, and contains
  unavailable/unloaded Bedrock API failures.

## Validation

- Focused particle regressions: **8/8 passed**.
- Particle JSON parse: **11/11 files parsed** in the local slice, including the
  existing moon-stone/contact emitters.
- `node --check` passed for `particle_model.js`.
- Bedrock world/runtime smoke testing remains unavailable locally; the GitHub
  workflow is the authoritative pack/schema validation gate.

## Files

- `BP/scripts/systems/particle_model.js`
- `BP/scripts/systems/particle_runtime.js`
- `RP/particles/*.particle.json` for all nine source identifiers
- `RP/textures/particle/**` for the eight previously missing source textures
- `tests/particle_model.test.mjs`
- `tests/particle_runtime.test.mjs`
- `BP/scripts/systems/horror_events.js`
- `BP/scripts/entities/stalk/stalk_controller.js`
- `KNOWN_LIMITATIONS.md`, `ADAPTATION_NOTES.md`, `PARITY_MATRIX.md`,
  `VALIDATION_LOG.md`, and `PORT_PROGRESS.md`

## Parity

Source identifiers, registered-provider lifetimes/sizes/materials, source event
counts/spread, and Curved despawn timing are preserved. Paper's crossed-quad
custom renderer and the two resource-only definitions remain explicit Bedrock
adapters.
