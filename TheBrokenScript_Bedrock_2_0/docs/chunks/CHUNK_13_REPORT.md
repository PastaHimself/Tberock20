# CHUNK_13_REPORT

## Source examined
- Recipes: 40 source JSONs (`data/thebrokenscript/recipe/`) — 24 shapeless/shaped + 16 stonecutting (moonstone cutting family, chainmail ×4, notch_apple, polaroid, instabilityv2, void planks/doors/slabs/stairs family)
- Loot tables: `loot_table/blocks/*` (~140, maps ~1:1 to our block roster) + `entities/null_cod.json`
- Advancements: TBSAdvancements.java — can_someone_hear_me, can_you_see_me, nullnullnull, you_ve_brought_it_upon_yourself, polaroid_craft
- Chat responses: TBSChatResponses.java — 39 keyword-response pairs
- **Finding**: source loot tables confirm **plushies are blocks** (blocks/*_plush.json) — Chunk 09 shipped them as collectible items instead; both forms now exist (item icons retained for creative, block forms not duplicated)

## Implemented
- **BP/recipes**: **40/40 converted** via tools/build_recipes.ps1 — shapeless/shaped → `minecraft:recipe_shapeless|shaped` (crafting_table tag); 16 stonecutter recipes → shapeless with `stonecutter` tag; count-less results defaulted to 1
- **BP/loot_tables**: self-drop tables generated for all 125 custom blocks + null_cod (cod drop); `minecraft:loot` component injected into every BP/blocks/*.json (two-pass fix for cross/marker blocks)
- **Scripts**:
  - `progression.js` — advancement approximations (A-006): award() = once-per-player dynamic property + levelup sound + title; roster of 5; polaroid inventory scan every 300t → polaroid_craft; entityHurt hook on Integrity/Fractured/Obliteration bosses → you_ve_brought_it_upon_yourself
  - `commands.js` — `/scriptevent tbs:*` surface: help, fire <event>, events, arena start|stop [p3], shaft, dim <id>, adv <id>; plus chat keyword responses (14 mappings from TBSChatResponses incl. null/herobrine/the_broken_end/i_am_scared) with whisper audio
  - Wiring: horror_events nullnullnull/can_someone_hear_me handlers now call progression.award; siluet natural spawn awards can_you_see_me (90% to closest ≤1000); TBE kill awards you_ve_brought_it_upon_yourself to victim
- Sync 45 modules, validate_pack PASS (**655 JSONs**: +40 recipes, +126 loot tables)
- Manifest version left untouched per owner instruction (validator check #4 now reports user-managed version without failing)

## Validation
| Check | Result |
|---|---|
| Recipe coverage | 40/40 (24 crafting + 16 stonecutter-tagged) |
| Loot coverage | 125 blocks + null_cod; component wired into 125/125 block JSONs |
| validate_pack.ps1 | PASS (655 JSONs) |

## Parity
`medium-high` — recipes are direct conversions (same ingredients/results); loot is simplified self-drop (source tables have luck/functions variants); advancements approximate A-006 with titles/sounds; chat responses use canned lines matching response style rather than full TBSLang text extraction.

## Unresolved defects
- Plushie duality: source has plush BLOCKS; we ship items (+item icons). Block forms could be added in Chunk 14 if desired.
- Survival pickup of custom blocks relies on implicit item forms (runtime verification pending).

## Next chunk prerequisites
Ready: Chunk 14 = Presentation completion (per-dimension fog/sky, non-cube block geometries, humanoid geo for faraway/deceiver/xram2die, boss music/death sequences, animated-texture substitutes).
