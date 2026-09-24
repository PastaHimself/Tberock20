# CHUNK_11_REPORT

## Source examined
- 15 biomes (`data/thebrokenscript/worldgen/biome/`): concrete, day_a, dysaphytic_wen, library, limbo, lucid, moon, nothing, nowhere, null_biome, protected_void, stage2, stage3, stereogenic_growth, void
- Structure corpus: **305 Java .nbt structures** (bedrockhallway1-10+exit, clan_void rooms ×20+, clanvoidnew1-8, brick artifacts, daya buildings, base ruins...) + shaft/ 6 pieces (root/hall/junction/room/room_hall/corner) + unused/3
- xcsf_structure: phase3_arena_final.xcsf (4.05 MB custom binary format — Integrity phase-3 arena)
- neoforge biome_modifier/spawns: 32 files (natural spawn weights already ported via spawn_director rules in Chunks 05A-07)

## Implemented
- **BP/biomes**: **15/15 biome definitions** (identifier `thebrokenscript:<name>`, temperature/downfall/climate)
- **RP**: `biomes_client.json` with per-biome fog_color + water_fog_color palette (limbo/nothing/null near-black, moon/stage3 deep violet-black, day_a daylight blue, library warm dark, etc.)
- **Scripts**: `BP/scripts/systems/worldgen_structures.js` retains the original procedural fallback builders for the Shaft/hallway interaction path.
- **Native Shaft Jigsaw templates**: all six source-backed Java NBT pieces are staged under `BP/structures/thebrokenscript/shaft/` and are used directly by Bedrock Jigsaw worldgen. Current Bedrock Jigsaw supports Java `.nbt` structure templates as well as `.mcstructure`, so a binary conversion is not required for this six-piece Jigsaw corpus.
- **Native Shaft Jigsaw data**:
  - `BP/worldgen/template_pools/shaft_root.json`
  - `BP/worldgen/template_pools/hallway.json`
  - `BP/worldgen/template_pools/shaft_room.json`
  - `BP/worldgen/structures/shaft.json`
- **Connector graph recovered from the actual NBT**:
  - `shaft_root` opens into `thebrokenscript:hallway`
  - corner/hall/junction continue `thebrokenscript:hallway`
  - `shaft_room_hall` bridges hallway → `thebrokenscript:shaft_room`
  - `shaft_room` exposes the `thebrokenscript:shaft_room` connector
- **Validation**:
  - `tools/validate_jigsaw_worldgen.py` checks Bedrock Jigsaw JSON/schema relationships.
  - `tools/validate_jigsaw_nbt_connectors.py` parses compressed Java NBT without third-party packages and checks connector `pool`, `target`, child connector names, and `start_jigsaw_name` compatibility.
  - `tests/test_jigsaw_nbt_connectors.py` covers valid, unresolved-pool, bad-target, and bad-start-name cases.
- The previous dead `shaft_room` entry was removed from the hallway pool because its source connector name is `thebrokenscript:shaft_room`; it now belongs only to the dedicated room pool.

## Validation status
| Check | Result |
|---|---|
| Biome coverage | 15/15 emitted |
| Six Shaft source templates staged | yes |
| Shaft connector pools represented | `shaft_root`, `hallway`, `shaft_room` |
| Static Jigsaw JSON validator | present |
| Static Java-NBT connector validator | present |
| Natural structure-set frequency/spacing | **pending source placement evidence** |
| In-game generation/survival test | pending Minecraft runtime |

## Parity
`in_progress` — the six-piece Shaft graph is now represented by native Jigsaw data instead of only the procedural approximation. This is a material parity improvement, but it is **not** final Shaft parity yet: the committed source ledgers do not contain authoritative natural placement frequency/spacing or source pool weights, so no guessed `structure_set` has been added. Existing neutral pool weights remain an approximation until those Java placement constants are recovered.

The remaining non-Shaft structure corpus is still not complete. Direct `.nbt` support solves the template-format problem for native Jigsaw use, but the other Java structures still need per-feature placement semantics, markers/processors, loot/encounter handling, and runtime validation. The XCSF phase-3 arena also remains a separate custom-format reconstruction task.

## Unresolved defects
- SOURCE: recover Shaft natural placement/frequency and authoritative pool weighting from the Java structure/worldgen code before adding `BP/worldgen/structure_sets/shaft.json`.
- STRUCTURES: audit and port the remaining meaningful Java structure corpus with a per-file conversion/placement ledger.
- XCSF: reconstruct `phase3_arena_final.xcsf` from its source format and boss-placement semantics.
- RUNTIME: validate native Shaft generation, terrain adaptation, connector cleanup, loot/encounters, and multiplayer behavior in Minecraft Bedrock.
