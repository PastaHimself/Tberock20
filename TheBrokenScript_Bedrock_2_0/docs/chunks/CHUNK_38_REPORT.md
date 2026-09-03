# Chunk 38 — Custom status-effect runtime adapter

## Implementation

- Added the source metadata and expiry rules in BP/scripts/systems/status_effect_model.js.
- Added a guarded health-component adapter in BP/scripts/systems/status_effect_runtime.js.
- Updated ported_features.js to use EntityComponentTypes.Health, refresh effect expiries from their current active boundary, enforce the Heart Corruption cap, and use the model's Why Can't You Leave particle ID.
- Updated the parity, limitation, progress, validation, and source-map ledgers.

## Source evidence

- decompiled/net/thebrokenscript/effects/HeartCorruptionMobEffect.java
- decompiled/net/thebrokenscript/effects/WhyCantYouLeaveMobEffect.java
- decompiled/net/thebrokenscript/registry/TBSEffects.java
- decompiled/net/thebrokenscript/events/misc/WhyCantYouLeaveEvent.java

## Validation

- TDD RED: the focused tests failed before the new model and runtime modules existed.
- TDD GREEN: 6/6 focused Node regressions passed.
- The exact remote branch copy of ported_features.js passes node --check.
- Microsoft Learn confirms stable EntityAttributeComponent.effectiveMax, currentValue, and setCurrentValue; the BedrockWiki/Microsoft index was also checked for the same API contract.
- Bedrock world/runtime smoke testing remains unavailable locally.
- GitHub Actions validation is pending for the new branch head.

## Parity

The source metadata and gameplay-facing health/particle behavior are now represented as a validated approximation. Bedrock still cannot install the custom effect registry entries, Java MAX_HEALTH attribute modifiers, or custom effect icons, and particle cadence is scripted rather than supplied by the Java effect renderer.
