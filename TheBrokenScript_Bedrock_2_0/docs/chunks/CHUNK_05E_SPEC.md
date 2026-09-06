# CHUNK_05E_SPEC — Humanoid apparitions (siluet/he/stare/deceiver/faraway)

## Source basis
- 10 entities: `stare` (invisible 0.001³ marker, life 500, forces LOOKABLE mobs ≤512 to face nearest player + slowness 60t amp55), `siluet` "r2" (HP10 1.0×4.5 mov0.2 follow590, life 18000, ambient cave + advancement, rocket easter egg funnySetting 1%, triggers ≤15 LOS / ≤20 gaze → vanish(blindness35+null_is_here_loop+70% midnight) or chase spawn; gaze branch 50% lightning+chase / text_madness_1+cantyousee; day→discard; timer 1% chase), `siluet_stare` (same + own layer: 620 find, ≤10 trigger, ≤45 gaze, static mov0 follow316), `siluet_chase` (HP10 ATK13 0.8×4.5 mov0.4, MazeNavigator, melee 1.45, AlwaysTargetPlayer 800, despawn 800 GAIN_MINOR, kill→30% tryCrash, midnight/day fake 1%, block-break front 3×h+1 when stuck/near, stepHeight 0.6↔10.6 by Ydiff≤3), `siluet_hallucination` (HP1 0.9×1.6, life600, bound UUID, FOV-cone arms, chases 1.4, poof at ≤1: hallucination_fade+blick), `he` "Him" (HP10 0.8×4.5 mov0 follow916, rare_thing_spawn+lightning+rain+life18000, ≤10 / ≤20-gaze branches mirror siluet→HE_CHASE), `he_chase` (mirror siluet_chase, melee 1.125, 1.0×2.5), `he_hallucination` (mirror, converts to HE_CHASE), `deceiver` "Null (Deceiver)" (HP10 ATK13 mov0.3 follow1816 0.6×1.8, mimics random player: join-chat + nametag + armor copy + random iron tool; ≤10 → circuit_deceive+blindness5+70% circuit after 60t; day→discard), `faraway` (0.6×1.8 humanoid skin away.png, life1600, seen-delay ≥25 → vanish: baby/fard/phantom sound+overlay variants)
- Spawns: SILUET conditions (matrix[moonStage][moonPhase] row0 [0,.001,.001,.005,.0085×4] row1 [.001,.002,.002,.005,.0085,.009,.01,.01] row2 [.003,.003,.006,.006,.005,0,0,0], entitySpawnDelay 6400, siluet/stare exclusion 500, player skylight≥2 within 75, weights siluet25/stare25/he1+10%), FARAWAY conditions (0.0085+freq, no other faraway, no delay), ENTITY conditions for deceiver (matrix [.0,1e-4,1e-4,5e-4,.001,.008,.0085,.0085 | .001,.002,.002,.002,.0025,.009,.01,.01 | .003,.003,.006,.006,.005,0…], rareSpawnDelay 12000)
- Assets: geometry.r2 (error5v2.geo.json) + siluetoverhaul.png + animation.r2.move for siluet/he ×7; stare invisible; deceiver anomaly1new.png; faraway humanoid away.png (no humanoid geo in pack → notexture approximation)

## Files
```
BP/entities/{stare,siluet,siluet_stare,siluet_chase,siluet_hallucination,he,he_chase,he_hallucination,deceiver,faraway}.json (10)
RP/entity/*.entity.json (10)
src/entities/humanoid/humanoid_controller.js (stare aura, siluet/he watchers+chasers+hallucinations, deceiver mimic, faraway delay)
src/entities/humanoid/humanoid_spawn_rules.js (SILUET/FARAWAY/ENTITY ports)
```

## Validation
parse JSONs (165+20); imports resolved; sync N modules.
