# Chunk 67 Specification — Complete Stage 2 catalog and runtime placement

## Objective

Finish the portable Integrity Phase 2 Stage 2 structure pass: convert every source template into a validated Bedrock `.mcstructure`, keep the Java selector metadata auditable, and connect the catalog to automatic runtime placement.

## Source evidence

- `decompiled/net/thebrokenscript/world/dimension/boss/stage2/Stage2Generator.java` defines the 64-template source corpus, floor mappings, surface/tunnel branches, random rotation, and `FRONT_BACK` mirror behavior.
- `source_extracted/data/thebrokenscript/structure/*.nbt` supplies the source blobs, palettes, block entities, and structure entities.
- `STAGE2_GENERATOR_AUDIT.json` and `STAGE2_TEMPLATE_ASSET_AUDIT.json` are the source and generated-asset ledgers.

## Acceptance criteria

1. All 64 audited source templates have matching format-version 1 Bedrock assets under `BP/structures/thebrokenscript/stage2/`.
2. The converter preserves dimensions, non-air block counts, block entities, entities, supported block states, inventory NBT, and relative entity positions; Java air/structure-void cells become Bedrock `-1` no-op indices for the source `BlockIgnoreProcessor` behavior.
3. The model and asset audit agree on every template ID, source SHA, dimensions, counts, placement Y, and generation role.
4. The runtime queues source-like surface, four room layers, and tunnel placements for each entered Stage 2 cell, with bounded retries, deterministic variant selection, rotation, and Java `FRONT_BACK` → Bedrock `Z` mirroring.
5. `StructureManager.place` is the primary placement path and `/structure load` is a compatibility fallback with block/entity inclusion flags.
6. Static validation, tests, typechecking, syntax checks, packaging, and the remaining CI/device smoke gates are recorded honestly.

## Bedrock compatibility boundary

BedrockWikiMcp and Microsoft Learn support the format-version 1 structure layout, `StructureManager.place`, `StructurePlaceOptions`, `StructureRotation`, and `StructureMirrorAxis`. Bedrock JSON still cannot host the Java custom `Stage2Generator` as a true chunk generator; exact Java server-seed parity, occupancy/chunk-generation order, the unresolved R3 border material, nowhere Voronoi output, and live world smoke testing remain explicit boundaries.
