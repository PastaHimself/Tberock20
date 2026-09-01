# Chunk 35 — Fractured animation timeline and presentation bridge

## Objective

Port the recovered Fractured/Jimmy animation timing and controller presentation behavior onto the existing Bedrock animation resources, while keeping the render-bone contact boundary explicit.

## Source boundary

- `source_extracted/assets/thebrokenscript/animations/fractured.animation.json` — attack instruction keyframes and clip lengths.
- `decompiled/net/thebrokenscript/client/model/entity/FracturedModel.java` — tracked render bones used by gameplay instructions.
- `decompiled/net/thebrokenscript/api/entity/BaseFracturedEntity.java` — Roam lifecycle-to-animation controller mappings.
- `decompiled/net/thebrokenscript/entity/fractured/FracturedEntity.java` — attack instruction names and server attack lengths.

## Contract

1. Preserve the four source attack clip names and their instruction seconds.
2. Convert animation instruction seconds to deterministic 20 Hz runtime ticks, retaining the explicit source stomp server tick.
3. Start the matching Bedrock entity animation through `Entity.playAnimation` for attack and defeat presentation.
4. Map FracturedRoam lifecycle states to Spawn/Idle/Walk/Flee/Underground/Loss and avoid replaying an unchanged clip every tick.
5. Add geometry locators and timeline particle events for the Java tracked-bone contact contract; identify the unavailable server world-position query as a separate adapter.

## Explicit limitation

Bedrock does not expose GeckoLib's server-side rendered-bone transforms. Locator-bound client particles provide visual contact at the animated bone, but exact server-side limb/rock world origins remain a follow-up gameplay adapter.

## Acceptance checks

- TDD red phase: the new animation model import fails before implementation.
- TDD green phase: focused animation, attack, and Fractured runtime regressions pass.
- `node --check` passes for the changed animation model and runtime.
- Runtime source assertions cover direct `playAnimation`, source event dispatch, presentation mapping, and tracked-bone preservation.
