# CHUNK_06_SPEC — Stalking completion pass (curved/jon/anomalies/herobrine/oblits)

## Source basis
- 7 entities: `curved` (HP125 ATK7 mov0.35 follow916 armor5, weeping-angel-inverse: approaches survival player only when OUTSIDE FOV cone @0.55, freezes when watched; ≤10 → invulnerable+aggressive+transformTimer100→transformed hostile w/ block-break 3×3×2; despawn 6200+particles; CurvedConditions 8.5e-4 delay32000 max2 cave-matched), `jon` (friendly "jon" NPC: yellow join chat, ≥40t + 1/5 chance chats hello!/let's play minecraft! via jon.hello/jon.play, saidHello flips after >4 chats +50%, kill → dying 72t → left chat + discard), `sub_anomaly_1/2` (ANOMALY matrix moonPhase [0.001,0.005,0.02,0.015,0.01,0,0,0], sa1 corrupt-block placement 12%/17.5% ±5/-2..5 + 5% branch — surrogate mossy_cobblestone), `the_obliteration` pair (HP910 ATK3 mov1 follow1000 flying 12×14, integrity_watching vol2 pitch2 timer150, gaze-or-≤20 condition, O2 triangleKickTimer>100 → kick), `herobrine` (static statue HP910 ATK13 mov0 follow1916, HerobrineConditions 1e-4 herobrineDelay 32000 sky-visible, life400, vanish player ≤42)
- Geos: geometry.curved/curved.png, geometry.tbs_jon/jon.png, geometry.sa2/anomaly.png ×2, geometry.Max revive triangle.geo (obliteration), geometry.invertedpyramid/obliteration2.png, herobrine humanoid → notexture placeholder
- Stalking-pass cross-checks: all encounter delays already flow through spawn_director DELAY_KEYS (curvedSpawnDelay/herobrineDelay/oblitSpawnDelay present); event_frequency used in every new rule

## Files
```
BP/entities/{curved,jon,sub_anomaly_1,sub_anomaly_2,the_obliteration,the_obliteration_2,herobrine}.json (7)
RP/entity/*.entity.json (7)
src/entities/stalk/stalk_controller.js · src/entities/stalk/stalk_spawn_rules.js
```

## Validation
parse JSONs (213+14); imports resolved; sync N modules.
