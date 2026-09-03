# Chunk 41 — Fractured rendered-contact spatial resolver

## Result

The Fractured/Jimmy runtime now has a source-backed contact resolver. It
catalogues the four bones used by the recovered GeckoLib model, accepts exact
world positions through an injectable bridge seam, preserves the recovered
SingleStomp transform when no bridge is present, and makes the unavailable
claw/rock transform explicit through an entity-anchor fallback.

The runtime uses the resolver for SingleStomp, Slam, OffenseRockThrow, and
DefensiveRockRelease origins, including Moon Rock Toss and Air Lift rock
spawns.

## Source evidence

- `decompiled/net/thebrokenscript/client/model/entity/FracturedModel.java`
- `decompiled/net/thebrokenscript/entity/fractured/FracturedEntity.java`
- `decompiled/net/thebrokenscript/entity/fractured/attacks/StompAttack.java`
- `BP/scripts/systems/fractured_animation_model.js`

## Validation

- TDD RED: the focused contact test was introduced before the resolver module.
- TDD GREEN: contact regressions — **4/4 passed**; full local Node suite —
  **12/12 passed**.
- Changed resolver/runtime JavaScript syntax and Bedrock beta type-check passed.
- GitHub Actions [run 139](https://github.com/PastaHimself/tbs-2.0/actions/runs/33756631657)
  passed repository validators, JavaScript regressions, Blockception
  diagnostics, Mojang Creator Tools validation, packaging, and report upload.
- Bedrock world/runtime smoke testing remains unavailable locally.

## Parity

Source bone ownership, event routing, and the recovered stomp transform are
preserved. Exact rendered limb/rock positions are available to a future bridge;
Bedrock-only execution uses the documented deterministic fallbacks.
