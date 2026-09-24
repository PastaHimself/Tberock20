# CHUNK_05F_REPORT

## Source examined
- 14 remaining non-boss entities: Xxram2dieEntity 392 (chat beats 1/500/1500/2000/2500/3000/3500, blink-teleport, Anger10→null_chase/ban), BanEntity (PlayerVariables.ban), CaveSoundEntity (ambient cave broadcast 555/45/rand), ChunkRemoverEntity (clearChunk/moveChunkUp → Bedrock chunk ops unsupported), CorruptionEntity (void column + redstone torches), NoTextureEntity 230 "follow" (blick spawn, ≤20 LOS branches incl. dimension teleport + item grant), NameTagEntity 148 (random name, despawn ≤15/LOS), MazeShadowsEntity (numeric/WormMan9 nametags), NullCodEntity (cod vs salmon, funnySetting gate), NothingWatcherEntity (blink anim only), NothingIsWatching pair (white_noise/glitch_sound_1/kick NIW_KICK, 1e-4 jitter), PhantomPlayerEntity (life7200, hetzer/circuit_stalk swap, blick), HetzerEntity (flying, observed blindness pulses, circuit end)
- Registry attrs TBSEntities.java:1398-1473 (xxram HP710), 1695-1744 (NIW HP510/chase HP10), 1885-1901 (ban 0.6×0.2 revuxor.png), PHANTOM_PLAYER common attrs
- Conditions: NIW(1e-4 excl480), EERIE(0.0015+freq !night delay3200), CHUNK(1e-4), CORRUPTION(0.001), DEFAULT(0.0045+freq)
- Sounds verified: white_noise, glitch_sound_1, kerfur_meow (unused here), ambient.cave; textures xxram2diexx/revuxor/nothing_watcher present

## Implemented
- **BP**: 14 entities — source HP/ATK/mov/follow/collision (xxram2die 710HP mov0; niw 510/13/0.1; chase 10/3/0.4; ban 0.6×0.2; null_cod cod-like stats)
- **RP**: 14 client entities — notexture geo family with xxram2diexx/revuxor/null textures; nothing_watcher uses its own geometry.nothing_watcher
- **Scripts**: misc_controller.js — xxram chat sequence w/ hex-decoded messages + fake times + ambient cave beats, invis-blink teleport-behind-view-ray + Anger10 → null_chase(70%)/ban; ban → tbs:ban dynamic property; niw watcher/chase pair incl. NIW kick hook; phantom swap logic; hetzer hover+blindness+circuit end; follow LOS branch (dim-teleport & item-grant ledgered); wanderer proximity-despawn w/ generated names. misc_spawn_rules.js — NIW/EERIE/CHUNK/CORRUPTION/DEFAULT ports incl. eerieNoiseDelay 3200 and corruption void-column/torch effect
- Sync 35 modules, validate_pack PASS (213 JSONs)

## Validation
| Check | Result |
|---|---|
| sync_scripts.ps1 | 35 files |
| validate_pack.ps1 | PASS (213 JSONs incl. 28 new misc JSONs) |
| Textures | xxram2diexx.png / revuxor.png / nothing_watcher.png verified |
| Sounds | white_noise, glitch_sound_1, ambient.cave verified |

## Parity
`medium-high` — approximations: chunk clear/move-up replaced by sound beat (Bedrock cannot manipulate unloaded chunks) — ledgered as engine approximation; follow dimension-teleport (CLAN_VOID/NULL_TORTURE pending Chunk 10) and item grant (SERIAL_DESIGNATION_N pending Chunk 09) are no-ops with effects kept; hetzer flight simplified to hover bob + timed circuit summon (goal structure partially read); xxram hex messages rendered literally (chat translation-key formatting omitted); PlayerVariables.ban stored as dynamic property until player-state extension.

## Unresolved defects
- BLOCK: dimension teleports pending Chunk 10; SERIAL_DESIGNATION_N grant pending Chunk 09; disruption block placement pending Chunk 08
- Moved to Chunk 06 scope: curved, jon, sub_anomaly_1/2, herobrine, obliteration pair (larger sources / own condition sets); murderfur → Chunk 07 (Kerfur pet)

## Next chunk prerequisites
Ready: all simple entities done (45 total BP entities). Chunk 06 = stalking completion pass + deferred medium entities (curved/jon/anomalies/herobrine/oblits).
