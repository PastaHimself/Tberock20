# CHUNK_08_REPORT

## Source examined
- 123 blockstates (`source_extracted/assets/thebrokenscript/blockstates/`) + `TBSBlocks.java` registry + full source texture set (`textures/block/*.png`)
- Terrain_texture.json (103 entries from Chunk 03) audited against block roster; 13 missing keys identified and merged
- BE roster: TBSBlockEntities (command, all_dead, exit, shadow_bug, portal_controller, portal_extender, null_structure, a_flower)

## Implemented
- **BP/blocks**: **123 block definitions** — every source blockstate has a Bedrock counterpart:
  - ~60 full cubes (moon_stone family, protected_void family, mono family, void log/wood/planks, flesh/viscera/all_dead, deviation/semiotics, hello/oldblock/it/empty/exit, teeth/necrosis, wallpaper/carpet/ceiling sets incl. red variants, physical_stacktrace, nowhere_block, name_missing/block_is_missing_id, r_3/int (block3/block4), obsidian(redobsidian), limbo/nothing, doors as cube approximations)
  - 19 cross flora via shared `geometry.tbs_cross` + alpha_test (void bell/bloom/blossom/bud/budding/bush/cap/grass/root(s)/shroom/sprout/vine, lily_of_the_abyss + 4 potted variants, new_vein) with zero light dampening / no collision
  - 16 void_template markers (invisible, no collision), initiator, jim_trigger_1-4
  - slab/stairs/wall/fence/trapdoor/pane variants emitted as full cubes (approximation ledgered below)
- **RP**: `models/blocks/tbs_cross.geo.json` (two-plane cross geometry); terrain_texture.json +13 keys (bloom/bud/growth/vein/hi/old/nullvoid/errornotexture/block3-4/stack_trace/teeth/necrosis/void_light mappings)
- **Scripts**: `src/systems/custom_blocks.js` — beta `blockComponentRegistry` components: be_command (+command_block_giver) corrupted-command feedback, be_portal_controller/extender interaction stubs (Chunk 10 activation flow), be_null_structure, be_shadow_bug random-tick smoke, be_a_flower interact chime, be_jim_trigger stage markers (onPlace/onEntityStepOn dynamic properties for Chunk 12), plus physical_stacktrace (place-overlay "at java.lang.Thread.getStackTrace" + fall damage) and disruption (random-tick particles/glitch sound)
- **Ledger unblocks**: TBE stalk now places real `thebrokenscript:physical_stacktrace`; follow places `thebrokenscript:disruption`; sub-anomaly corrupt spread switched to `thebrokenscript:corrupted_moon_stone_bricks`
- tools/build_blocks.ps1 added (idempotent generator); sync 40 modules; validate_pack PASS (383 JSONs)

## Validation
| Check | Result |
|---|---|
| Block coverage | 123/123 blockstates → BP/blocks (diff clean) |
| validate_pack.ps1 | PASS (383 JSONs incl. 123 blocks + cross geo) |
| terrain_texture | 103 → 116 entries, all block textures resolve |
| Custom components | 12 registered (10 BE/trigger + stacktrace + disruption) |

## Parity
`medium-high` for full cubes (exact textures, correct ids); approximations: non-cube shapes (slabs/stairs/walls/fences/trapdoors/panes/doors) rendered as full cubes — true shapes need per-block custom geometries (candidate: Chunk 14 presentation pass); flora uses one shared cross geometry rather than per-species models; animated textures (necrosis/command_block/goop mcmeta) are static frames in Bedrock; corruption/all_dead share flesh-family textures where source used tinted variants.

## Unresolved defects
- Non-cube geometries deferred (Chunk 14 candidate)
- Portal controller/extender actual dimension-linking behavior lands with Chunk 10
- Jim-trigger choreography consumes markers in Chunk 12

## Next chunk prerequisites
Ready: blocks complete. Chunk 09 = Items (192) + fluids approximation (void_goop still/flow textures already present); item_texture.json (68 entries) exists from Chunk 03.
