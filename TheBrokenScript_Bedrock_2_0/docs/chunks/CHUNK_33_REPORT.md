# Chunk 33 Report — Rock block-impact particle burst

## Result

Implemented the source-backed Rock block-impact burst in the existing Fractured runtime. The fixed particle-presentation gap is reduced to a source-counted Bedrock emitter: 400 moon-stone particles, source spatial ranges, upward initial velocity, and one-tick cleanup.

## Validation

- 13/13 focused Jimmy model/runtime regressions pass locally.
- Changed JavaScript passes `node --check`.
- Rock entity JSON and custom particle JSON parse successfully.
- GitHub Actions validation is run on the published commit; artifact uploads remain subject to the repository storage quota.
- Minecraft world/runtime smoke testing remains unavailable in this workspace.

## Remaining difference

Bedrock owns particle lifetime and motion integration for the custom emitter; exact Java client `TerrainParticle` behavior and GeckoLib bone/keyframe presentation remain documented adapters.

