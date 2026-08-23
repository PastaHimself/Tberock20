# CHUNK_05E_REPORT

## Source examined
- 10 humanoid apparition entities: StareEntity 191 lines, SiluetEntity 397, SiluetStareEntity 131, SiluetChaseEntity 297 (+SiluetGoals/MazeNavigator), SiluetHallucinationEntity 459, HeEntity 238, HeChaseEntity, HeHallucinationEntity 439, DeceiverEntity 249, FarawayEntity 429 (+FarawayRenderer HumanoidMobRenderer away.png)
- Registry attrs TBSEntities.java:1474-1693/2103-2157 (HP10 family, ATK 0/13, sizes 1.0×4.5 / 0.8×4.5 / 0.9×1.6 / 1.0×2.5 / 0.6×1.8 / 0.001³ stare)
- Spawn gates: SiluetConditions.java (matrix[stage][phase], entitySpawnDelay 6400, siluet/stare exclusion 500, player skyLight≥2 within 75, weights 25/25/1 + he 10%), FarawayConditions.java (0.0085+freq, uniqueness, no delay), TBSEntityConditions.java (deceiver matrix, rareSpawnDelay 12000)
- Sounds verified in sound_definitions.json: rare_thing_spawn, phantom, text_madness_1, baby, fardaway, hallucination_fade, null_is_here_loop, siluet_chase, circuit_deceive

## Implemented
- **BP**: 10 entities (`stare`, `siluet`, `siluet_stare`, `siluet_chase`, `siluet_hallucination`, `he`, `he_chase`, `he_hallucination`, `deceiver`, `faraway`) — source HP/ATK/mov/follow/collision values, family `thebrokenscript_humanoid`
- **RP**: 10 client entities — geometry.r2 + siluetoverhaul.png for the 7 r2-model family; notexture geo for stare (invisible marker) and deceiver (anomaly1new.png billboard approx); faraway away.png on notexture (no humanoid geo in pack)
- **Scripts**: humanoid_controller.js — stare LOOKABLE aura (19 vanilla types, lookAt + slowness 60t amp55); siluet base layer (≤15 LOS vanish/chase, ≤20 gaze lightning/text-madness+cantyousee, day-discard, timer 18000 w/ 1% chase); siluet_stare extra layer (620 find, ≤10, ≤45 gaze); chasers (despawn 800→GAIN_MINOR ledgered, fake time 1%, melee 13 dmg/20t reach 3, block-break front 3×5 when near/stuck, yDiff>3 step-up); hallucinations (owner bind, FOV-cone arm, chase steps, poof ≤1 → hallucination_fade+blick, life 600); he watcher (rare_thing_spawn+lightning+rain init, mirror branches→he_chase); deceiver mimic (random-player nametag+join tellraw+armor copy via equippable, ≤10 → circuit_deceive+blindness5+70% circuit after 60t); faraway seen-delay ≥25 → phantom-sound variant vanish; kill→30% kick approximation via entityDie hook
- humanoid_spawn_rules.js — SILUET/FARAWAY/ENTITY condition ports with exact matrices/delays/exclusions
- Sync 33 modules, validate_pack PASS (185 JSONs)

## Validation
| Check | Result |
|---|---|
| sync_scripts.ps1 | 33 files |
| validate_pack.ps1 | PASS (185 JSONs incl. 20 new humanoid JSONs) |
| Geometry id | geometry.r2 verified in error5v2.geo.json |
| Sound ids | all 9 referenced events present |

## Parity
`high` — approximations: MazeNavigator/ContinuousMeleeAttackGoal/AlwaysTargetPlayerGoal replaced by controller teleport-steps + timed melee; tryCrash → /kick attempt with silent fallback; rocket easter egg + funnySetting variants (baby/fard) gated on unregistered config — default path kept, variants ledgered; can_you_see_me advancement deferred to Chunk 13; stare LOOKABLE tag approximated by 19-type list; deceiver iron-tool mainhand copy omitted (equippable covers armor only); faraway humanoid player-model unavailable in pack (notexture placeholder, Chunk 14 candidate).

## Unresolved defects
- BLOCK: advancements (can_you_see_me) pending Chunk 13 progression system
- BLOCK: FunnySetting config gate pending config registration pass (rocket/baby/fard easter eggs)
- Faraway/deceiver visual fidelity limited by missing humanoid geometry — presentation chunk ledgered

## Next chunk prerequisites
Ready: humanoid apparitions complete (10/10). Next 05F remaining entities (ban, curved, eerie_noise, chunk_remover, maze_shadows, niw pair, herobrine?, xxram_2die, null_cod, mother/jon/nothing_watcher/name_tag misc).
