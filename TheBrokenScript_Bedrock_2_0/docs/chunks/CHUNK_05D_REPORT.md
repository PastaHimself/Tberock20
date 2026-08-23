# CHUNK_05D_REPORT

## Source examined
- 4 TBE entities (TheBrokenEnd 1128 lines / Stalk 356 / Curious 369 / Ambush 356) + TBSEntities attrs (HP 1000/500, ATK 600/15, sizes 0.6×25 / 4.5×25 / 0.6×1.8, follow 64/1916/2016) + TBSSounds (TBE_INTRO, THE_END_IS_NEAR, HEARTBEAT, TBE_SPAWN1, REEL)
- Spawn gates: TBEConditions.java (moonStage==2, 0.00015-0.002+freq, ≥45 away, tbeSpawnDelay 32000, 512 exclusion) and TBEAmbushConditions.java (hasMoonCorrupted, 3×6 matrix 0.0002-0.006+freq, tbeSpawnDelay 8200); overlay/sound triggers (frame1/2, wecanhearyou, tbescreenframe_1-4, tbe_curious.png)

## Implemented
- **BP**: 4 entities (`thebrokenscript:the_broken_end*`) — source HP/ATK/mov/follow/collision/physics/persistent/breathable, family `thebrokenscript_tbe`; ATK 600 for TBE/ambush, 15 for stalk/curious; HP 1000/500 as per attrs; collision widths 0.6/4.5×25, 0.6×1.8 for ambush
- **RP**: 4 client entities → `geometry.tbs_tbe_overhaul_v4` (tbe_overhaul_ver4.png) for TBE/stalk/curious, `geometry.tbs_tbe_ambush` (tbe_ambush_1.png + variants 2/3 via controller nameTag) with entity_alphatest/single_textured
- **Scripts**: `tbe_controller.js` (grace 150 + chase 128, life 1000, interferences strobe 3/6/9/12, fake-time a>150 mid/day/noon, block-break scan 2×0.65 front, stuck 40→teleport, stalk 7200+320 invis/midnight/heartbeat/blindness, curious weeping-angel freeze + noticed 45 sound→60 blind+overlay+tbe spawn 1% within 50, ambush 18000-24000 lifetime + 26t despawn behind 15-30) and `tbe_spawn_rules.js` (ring 45-90, skyVisible permissive, 512 exclusion, moonPhase+freq rolls, delays 32000/8200, hasMoonCorrupted/moonStage gates, isFlat 0.001)
- Sync 31 modules, validate_pack PASS

## Validation
| Check | Result |
|---|---|
| sync_scripts.ps1 | 31 files |
| validate_pack.ps1 | PASS (165 JSONs parsed incl. 8 new TBE JSONs) |
| Geometry ids | geometry.tbs_tbe_overhaul_v4 / geometry.tbs_tbe_ambush verified |
| Sound ids | tbe_intro, the_end_is_near, heartbeat, tbespawn1, reel in sound_definitions.json |

## Parity
`high` — stalk invis via effect (not nbt invis), midnight/weather via gamerule/weather commands (not TimeOfDay fake), block-break limited to 24/air skip with UNBREAKABLE set (no destroySpeed/collisionShape parity), isDarkEnough/canSeeSky approximated permissively, flat-world 0.1% gate approximated via worldState isFlat, creative kill via teleport rotation (camera pitch/yaw) approximated, BAN summon ledgered (entity not yet ported), frame overlays via titles/particles not screen textures.

## Unresolved defects
- BLOCK: PhysicalStacktraceBlock placement (TBSBlocks.PHYSICAL_STACKTRACE @ stalk 70% gaze branch) pending Chunk 08 — ledgered skip
- BAN entity summon on TBE kill 50% — pending entity port (05F/07)
- Damage immunity blacklist (10 types + arrow/player/potion) approximated via high HP+knockbackResist — true immunity requires damage_sensor (Chunk 05F hardness pass may add)

## Next chunk prerequisites
Ready: TBE family complete (4/4); next 05E Humanoid apparitions (Stare, SubAnomaly, etc.) shares tbeSpawnDelay-adjacent gates but independent.
