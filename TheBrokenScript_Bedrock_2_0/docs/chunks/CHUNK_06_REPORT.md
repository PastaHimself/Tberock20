# CHUNK_06_REPORT

## Source examined
- CurvedEntity 1228 ln (HP125 ATK7 mov0.35 follow916 armor5; approach-only-unseen 0.55, ≤10 survival → invuln+aggressive+transformTimer100→transformed hostile melee+block-break 3×3×2, despawn 6200+particles, die chat + GAIN_MEDIUM rep; CurvedConditions 8.5e-4 delay32000 max2 cave-match)
- JonEntity 453 ln ("jon" NPC: yellow join/left chat, ≥40t+1/5 chats hello!/let's play minecraft!, jon.hello/jon.play sounds, saidHello flips >4+50%, dying 72t)
- SubAnomaly1/2Entity (corrupt-block rolls 12%/17.5% ±5/-2..5, 5% branch; AnomalyConditions matrix [0.001,0.005,0.02,0.015,0.01,0…] moonPhase-indexed)
- Obliteration pair (HP910 ATK3 mov1 follow1000 flying 12×14, integrity_watching vol2 pitch2 timer150, O2 triangle-kick stare>100)
- HerobrineEntity (statue HP910 ATK13 mov0 follow1916, life400, vanish ≤42; HerobrineConditions 1e-4 herobrineDelay 32000 sky-visible)
- Stalking cross-checks: curvedSpawnDelay/herobrineDelay/oblitSpawnDelay already in spawn_director DELAY_KEYS; event_frequency wired into all new rules
- Manifest switched to `@minecraft/server` **beta** channel per project decision; validator updated (numeric versions must remain stable-format)

## Implemented
- **BP**: 7 entities (`curved`, `jon`, `sub_anomaly_1/2`, `the_obliteration`, `the_obliteration_2`, `herobrine`) — source attrs, family `thebrokenscript_stalk`
- **RP**: 7 client entities — geometry.curved/curved.png, geometry.tbs_jon/jon.png, geometry.sa2/anomaly.png ×2, geometry.Max revive + null tex (O1), geometry.invertedpyramid/obliteration2.png, notexture/herobrine.png placeholder
- **Scripts**: stalk_controller.js — curved unseen-approach/transform/melee pulses/despawn particles; jon chatter with real tellraw chat beats; anomaly corrupt-block surrogate (mossy_cobblestone) rolls; obliteration hover + watching beat + O2 stare-kick accumulator; herobrine statue vanish. stalk_spawn_rules.js — CURVED/HEROBRINE/OBLIT/ANOMALY condition ports incl. delays 32000 and exclusions
- Manifest edit: `"version": "beta"` for @minecraft/server (user directive); validate_pack.ps1 check #4 updated to accept the `beta` channel while rejecting malformed numeric-beta strings
- Sync 37 modules, validate_pack PASS (227 JSONs)

## Validation
| Check | Result |
|---|---|
| sync_scripts.ps1 | 37 files |
| validate_pack.ps1 | PASS (227 JSONs incl. 14 new stalk JSONs) — `beta script dep: @minecraft/server beta` |
| Geometries | geometry.curved / geometry.tbs_jon / geometry.sa2 / geometry.Max revive / geometry.invertedpyramid verified |

## Parity
`medium` — approximations: curved navigation replaced by teleport-steps + interval melee (no native goals); vibration-listener block-break alerts omitted; jon chat via tellraw (translation keys flattened); sub-anomaly corrupt blocks use mossy_cobblestone until Chunk 08 custom blocks; obliteration rotation/glitch visual state machine simplified to hover + watch beat; herobrine humanoid model still placeholder (Chunk 14). Beta-API switch unlocks previously deferred stable-only features (custom dimensions path re-evaluated at Chunk 10).

## Unresolved defects
- BLOCK: corrupt/disruption custom blocks pending Chunk 08; dimension content pending Chunk 10
- Curved death-chat variants (weapon-specific lines) pending lang-table wiring in Chunk 13/14 pass

## Next chunk prerequisites
Ready: all non-boss entities ported (52 BP entities). Chunk 07 = bosses (Integrity phases 1-3 + arm/fireball/curious, Fractured/Jimmy family, Kerfur/Murderfur, Fever, Chord/Tether/VoidTentacle).
