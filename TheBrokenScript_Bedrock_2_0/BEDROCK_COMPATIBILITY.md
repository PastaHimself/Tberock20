# BEDROCK_COMPATIBILITY.md

Target: **Minecraft Bedrock 1.26.10+** (minimum engine `1.26.10`).
All version-sensitive claims below were verified against official Microsoft Learn / Minecraft Creator documentation via the Microsoft Learn MCP on 2026-08-22 during Chunk 00. Re-verify before each chunk that consumes them.

## Verified platform facts (with sources)

| Topic | Verified fact | Source |
|---|---|---|
| Manifest format | Stable manifest `format_version: 2`. Module types: `resources`, `data`, `world_template`, `script`. Script modules require `"language": "javascript"` only. Format 3 is preview-only and must not be used. | Pack manifest reference (`.../addonsreference/packmanifest`) |
| BP→RP dependency | `dependencies[]` with `uuid` = RP header UUID + matching `version`; script module deps use `module_name`/`version`. | Pack manifest reference; Behavior Pack from Scratch |
| Script API tracks | Stable (semver, no suffix), beta (`-beta`, requires "Beta APIs" experiment, breaking changes at each major MC release), internal (unsupported). Minor-version upgrades within a major are backward compatible (NPM-`^`-like). | Scripting Versioning docs |
| v2 scripting | 2.x stable line exists (`2.0.0` … `2.9.0` as of doc snapshot; latest listed `2.9.0` for `1.26.50-beta.26`). Available stable list includes `2.6.0`, `2.7.0`, `2.8.0`, `2.9.0`. | `@minecraft/server` module page |
| Bedrock 1.26.10 stable release | `@minecraft/server` **v2.6.0**: entity heal events, `entityHurt` before event, entity item pickup/drop events, `Block.getComponents`/`hasComponent`, aim-assist suite, **camera animation & attachment APIs stable** (`playAnimation`, `attachToEntity`, `EntityAttachPoint`, CatmullRom/Linear splines, `AnimationOptions`, `CameraAttachOptions`). Also stable: biome queries (`containsBiomes` w/ `isSuperset`, `BiomeFilter`), `World.getSeed`. | 1.26.10 Creator update notes |
| Ticking areas in 1.26.10 | **RESOLVED — STABLE at v2.6.0**: `@minecraft/server` changelog lists `TickingAreaManager` and `World.tickingAreaManager` as additions in **2.6.0** (the experimental-notes entry referred to a preview-channel change). Usable by this port without experiments. | `@minecraft/server` changelog §2.6.0 |
| Custom dimensions | Experimental/beta at 1.26.10 (official custom-dimension tutorial workflow). **Version change vs prompt:** promoted to **stable in 1.26.30** via `@minecraft/server` v2.8.0 (`DimensionRegistry`, `StartupBeforeEvent.dimensionRegistry`, related error types). Decision deferred to Chunk 10: either pin min-engine ≥1.26.30 for stable dims or use Beta APIs experiment at 1.26.10. | custom-dimension-api-tutorial; 1.26.30 update notes |
| Entity JSON validation | Stricter entity/AI JSON validation at 1.26.10 — invalid AI goal data must be treated as build/load failure. | prompt baseline + 1.26.10 notes |
| Removed components | Legacy `minecraft:pushable` removed for new content; split pushability components are current. Exact replacement component names to be confirmed against the current entity-components reference in Chunk 04 before first entity file is written. | prompt baseline; entity components reference |
| Custom items | Item cooldowns render correctly from 1.26.10; `minecraft:block_placer.aligned_placement` supported (format ≥1.26.0); empty `liquid_detection` arrays fail load. | 1.26.10 update notes |
| Blocks experimental | Voxel shapes (culling) behind experimental toggle; block entity events via `onEntity` handler (beta lineage) — not required for Chunk 03; re-check when blocks chunk starts. | 1.26.10 update notes (Experimental) |
| N-1 rule | Prefer depending on the highest stable minor available within the chosen major; do not chase preview versions. | Latest Platform Version Guidance |

## Decisions locked by verification

1. **Manifest**: format 2, BP(`data`)+script module, RP(`resources`). Min engine `[1, 26, 10]`.
2. **Scripts**: `@minecraft/server` `2.6.0` dependency exactly (stable floor of target engine). No `-beta` deps except the isolated custom-dimension module if Chunk 10 selects the beta path.
3. **Custom dimensions**: two candidate paths recorded above; final selection + required world experiments documented here and in ADAPTATION_NOTES when Chunk 10 runs. Dimensions must NOT be dropped to avoid the experiment.
4. **Camera horror effects**: use stable v2.6.0 camera splines/attach APIs (confirmed out of experimental at 1.26.10).
5. **No community-doc reliance**: all schemas cross-checked against learn.microsoft.com Creator references.

## Documentation changes since the porting prompt was written

| Prompt claim | Current documented state | Impact |
|---|---|---|
| Custom dimensions are experimental requiring Beta APIs | Still true at 1.26.10, but **stable since 1.26.30** (`@minecraft/server` 2.8.0) | Chunk 10 may raise effective min-engine to 1.26.30 OR isolate beta dep; record player-facing consequence |
| `@minecraft/server` v2.6.0 is newest relevant stable | Newer stables exist: 2.7.0, 2.8.0, 2.9.0 (later game drops) | We still pin 2.6.0 for the declared 1.26.10 minimum unless a subsystem (dimensions) forces a higher floor |
