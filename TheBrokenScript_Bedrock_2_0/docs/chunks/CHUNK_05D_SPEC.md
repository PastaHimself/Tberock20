# CHUNK_05D_SPEC — The Broken End Family

## Source basis
- 4 entities: `the_broken_end` (HP1000 ATK600 0.45 25.0h 0.6w, 1000t/50s life, grace150, chase 128 range, block-break scan, interferences), `the_broken_end_stalk` (HP500 ATK15 4.5×25, 7200t/360s +320t trigger, 30/192 gaze, invis+midnight), `the_broken_end_curious` (HP500 ATK15 0.6×25, 2400t/120s, weeping-angel freeze, noticed 45→60), `the_broken_end_ambush` (HP1000 0.6×1.8, 18000-24000t 15-20m, despawn 26t behind 15-30)
- Spawn: TBEConditions (moonStage==2, 0.00015-0.002+freq, ≥45 away, tbeSpawnDelay 32000) vs Ambush (hasMoonCorrupted, table 0.0002-0.006, tbeSpawnDelay 8200)
- Sounds: TBE_INTRO, THE_END_IS_NEAR, HEARTBEAT, TBE_SPAWN1, REEL; Overlays frame1/2, wecanhearyou, tbescreenframe_1-4, tbe_curious.png

## Files
```
BP/entities/the_broken_end*.json (4)
RP/entity/the_broken_end*.entity.json (4) → geo tbe_overhaul_v4 / tbe_ambush, textures tbe_*.png
src/entities/tbe/tbe_controller.js (grace→chase, stalk invis, curious freeze, ambush behind-spawn)
src/entities/tbe/tbe_spawn_rules.js (TBEConditions/Ambush port, delays 32000/8200)
```

## Validation
parse 165 JSONs; controller imports resolved; 31 modules synced.
