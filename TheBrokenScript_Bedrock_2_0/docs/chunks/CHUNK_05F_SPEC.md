# CHUNK_05F_SPEC — Remaining entities (misc / niw / players)

## Source basis
- 14 entities: `xxram_2die` (HP710 ATK3 mov0 follow916 0.6×1.8 invisible player-model, chat sequence ticks 1/500/1500/2000/2500/3000/3500 w/ fake times+ambient cave, blink-teleport ≤25 within 520, Anger10 → 70% null_chase else ban, hasRam2DieJoined), `ban` (0.6×0.2 revuxor.png, nearest ≤128 → PlayerVariables.ban=true + discard), `eerie_noise` (invis marker, ambient cave broadcast range555 vol45 rand pitch, self-cancel; EERIE conditions 0.0015+freq day-only, eerieNoiseDelay 3200), `chunk_remover` (invis marker; ambient cave + 5% clearChunk else moveChunkUp rnd1-8×16 → Bedrock chunk ops unsupported, ledgered), `corruption` (invis marker; clears column to void below self + redstone torches at 4 neighbor surfaces when Δ∈(-2,4); CorruptionConditions 0.001 flat-gated), `follow`/NoTextureEntity ("No Texture", blick on spawn ≤100, ≤20 LOS: 50% darkness60+health rnd1-9+dim-teleport CLAN_VOID/NULL_TORTURE [dims Chunk 10] / else teleport-player-to-self+give item [Chunk 09], disruption block every 20t [Chunk 08], day→discard), `name_tag` (random name, wanderer, despawn if survival player ≤15 or LOS), `maze_shadows` (numeric/WormMan9 17.5% nametag, despawn player ≤15, unpersisted), `null_cod` (cod hunts salmon, funnySetting gate), `nothing_watcher` (blink-only decorative), `niw` nothingiswatching (HP510 ATK13 mov0.1 follow916 1.6×4.5, white_noise spawn, life5200, ≤10 blindness500+glitch_sound_1+70% midnight+chase, gaze≤100 → 70% chase else lightning; NIW 1e-4 exclusion 480), `nothingiswatchingchase` (HP10 ATK3 mov0.4 follow416 1.6×4.5, ≤5 kick NIW_KICK, 1e-4 jitter ≤500), `phantom_player` (common attrs 0.6×1.8 nametag, life7200, ≤200 1e-4 → hetzer/circuit_stalk swap, ≤25 blick 20t + discard), `hetzer` (flying, life1200, observed/near → blindness5 pulses, end → circuit summon)
- Spawns: NIW(1e-4), EERIE(0.0015+freq, !night, delay3200), CHUNK(1e-4), CORRUPTION(0.001), DEFAULT(0.0045+freq) for xxram_2die/phantom_player; ENTITY matrix for follow/hetzer
- Deferred from 05F scope (moved): curved (1149 ln), jon (453 ln), murderfur (Kerfur pet → Chunk 07), sub_anomaly_1/2, herobrine, obliteration pair → Chunk 06

## Files
```
BP/entities/{xxram_2die,ban,eerie_noise,chunk_remover,corruption,follow,name_tag,maze_shadows,null_cod,nothing_watcher,niw,nothingiswatchingchase,phantom_player,hetzer}.json (14)
RP/entity/*.entity.json (14)
src/entities/misc/misc_controller.js · src/entities/misc/misc_spawn_rules.js
```

## Validation
parse JSONs (185+28); imports resolved; sync N modules.
