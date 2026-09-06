# Chunk 22 — VoidTentacle source SCALE adapter

## Scope

Port the source `VoidTentacleEntity` scale contract into the Bedrock entity definition and its boss controller.

## Source contract

- `VoidTentacleEntity.onFinalizeSpawn` randomizes `Attributes.SCALE` inclusively from 1 through 5 when the base scale is unchanged.
- Phase 3 creates three fixed tentacles and applies scale 2 to each one.
- The scale value is consumed by the entity's visual and attack behavior.

## Bedrock contract

- Persist the equivalent value as client-synced integer property `thebrokenscript:scale` with range 1..5.
- Map each value to a namespaced event and `minecraft:scale` component group.
- Read the persisted property before falling back to a source-equivalent roll.
- Route fixed Phase 3 presets through the same property/event bridge at value 2.

## Acceptance tests

- The entity property, range, default, and client synchronization are present.
- All five visual groups and their event transitions are present and mutually exclusive.
- The controller uses the property/event bridge and no longer relies on a controller-only visual-scale fallback.
- The existing arena regression suite remains green.
