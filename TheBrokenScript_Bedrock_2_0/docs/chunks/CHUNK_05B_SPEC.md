# CHUNK_05B_SPEC — Null Watchers/Scare Family

## Source basis
- 4 entities: `null_watching` (HP910 mov0 follow916, texture null.png, geo nothing_watcher 0.6×1.8, timer 8000, 10-case anger), `null_scare` (HP510 mov0.3, 40t life, jump-scare), `null_mining` (HP80 mov0.2, 1200t, picks/builds cobble), `null_is_here` (HP910 mov0 flying 313dmg, 500t, 5-tick approach)
- Shared: fireImmune, pushThrough 0, invulnerable except kill/void, NullRenderer, MOBS/MONSTER, spawn NullConditions (sky visible, isNullHere, nullSpawnDelay 7200, 0.85%+freq)
- Sounds: null_flee, kills_player, one_of_us, null_is_here_loop, cave; Particles null_particle/eyes

## Files
```
BP/entities/null_{watching,scare,mining,is_here}.json (4)
RP/entity/null_*.entity.json (4) → geo nothing_watcher/notexture, textures null/anomaly1new
src/entities/null/null_controller.js (watch 10-case, scare 40t, mining build, is_here flying approach)
src/entities/null/null_spawn_rules.js (NullConditions port, 7200 delay)
```

## Validation
parse 131 JSONs; geometry ids via GEOMETRY_ID_MAP; controller imports resolved.
