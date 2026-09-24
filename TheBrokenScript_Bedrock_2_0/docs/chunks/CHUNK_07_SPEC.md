# CHUNK_07_SPEC — Bosses (Integrity / Fractured-Jimmy / Kerfur / Fever / Chord / Tether / Tentacle)

## Source basis
- 16 entities. Integrity: phase_1 (1×10 HP910 ATK50 mov0.4 kbRes50), phase_2 (0.96×2.16 ATK25 step5), phase_3 (5×32 HP1024 ATK50), arm (2×5 HP1024 ATK50 mov0), curious (1×10 HP910 ATK0 static timer), integ_fireball projectile. Phase chain by health thresholds w/ attacks/* (fireball/gravity/ground/tentacle/swipe) + Arena system
- Fractured: main Jimmy (10×30 mov1.5 HP910 ATK12 follow1000 step100 kbRes1) w/ JimAttack types (stomp/slam/airlift/moonrock), fractured_roam (ATK0 roam variant), rock (0.5×0.25 HP4); FRACTURED_CONDITIONS row [0.01..0.06]+freq
- Murderfur/Kerfur pet: 0.5×1.5 HP1000 ATK1 mov0.3 follow400, kerfur_meow pitch 0.9-1.2
- Fever pair: 1×10 flying HP910 ATK10/10 flySpeed10 kbRes50; fever_stalk spawns via FEVER_STALK row [5e-4..0.003]+freq biomeSpawn15; FeverMoveControl/Navigation flight
- Chord (2×2 flying HP32 ATK4 mov1 follow50 flySpeed0.4) + chord_projectile (0.5×1.15); tether (1×3) + void_tentacle (1×2) stationary hazards
- Geos/textures verified: Integrityphase1/2/3, tbs_ip3_ground_arm, Integrity_hallucination (curious), fractured (+BOULDER rock), tbs_fever, chord(+projectile), void_tether, tbs_void_tentacle; textures integrity_phase1-3, integrityghost_redeyes0-11 flipbook, fractured(+no_rock), fever, chord(+projectile), murderfur, tether, void_tentacle; sounds integrity_watching/integrity_dies/kerfur_meow

## Files
```
BP/entities/{integrity_phase_1,integrity_phase_2,integrity_phase_3,integrity_arm,integrity_curious,integ_fireball,fractured,fractured_roam,rock,murderfur,fever,fever_stalk,chord,chord_projectile,tether,void_tentacle}.json (16)
RP/entity/*.entity.json (16)
src/entities/boss/boss_controller.js · src/entities/boss/boss_spawn_rules.js
```

## Validation
parse JSONs (227+32); imports resolved; sync N modules.
