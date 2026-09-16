# Randomness audit

This is a deterministic static inventory of Java random draws/sources and direct Bedrock `Math.random()` calls.
It does not claim that a Bedrock engine run reproduces a Java PRNG seed.

## Inventory

- Java random draws: **492**
- Java random source expressions: **266**
- Bedrock `Math.random()` calls: **157**
- Bedrock runtime files with direct draws: **25**

| Scope | Java draws | Java sources | Bedrock draws |
| --- | ---: | ---: | ---: |
| `client` | 61 | 21 | 0 |
| `entity` | 84 | 118 | 0 |
| `horror-event-adapter` | 0 | 0 | 20 |
| `injected` | 210 | 0 | 0 |
| `local` | 44 | 126 | 0 |
| `runtime-global` | 0 | 0 | 137 |
| `world` | 93 | 1 | 0 |

## Scope rules

- `world`: `level.random`/world-owned random streams.
- `entity`: entity/player-owned random streams such as `getRandom()`.
- `injected`: a method-provided `RandomSource`/random receiver.
- `local`: Kotlin `Random.Default` or a newly created local source.
- `client`: client-only/render/particle randomness, tracked separately from server parity.
- Bedrock runtime scopes distinguish the default helper, the ambient horror adapter, and other direct calls.

A new callsite that the classifier cannot scope fails `python tools/audit_randomness.py --check` and must be reviewed before merging.

## Java file inventory

The JSON report contains every line-level record. This compact table keeps the checked-in review surface readable while showing every Java file with a recognized source or draw.

| File | Draws | Sources | Scopes |
| --- | ---: | ---: | --- |
| `decompiled/net/thebrokenscript/api/TBSMenuBackgrounds.java` | 1 | 4 | `injected`, `local` |
| `decompiled/net/thebrokenscript/api/engine/StructureEngine.java` | 6 | 1 | `local` |
| `decompiled/net/thebrokenscript/api/entity/ai/anomaly/sa2/AvoidLightGoal.java` | 0 | 1 | `entity` |
| `decompiled/net/thebrokenscript/api/entity/ai/anomaly/sa2/RandomFlyingGoal.java` | 0 | 1 | `entity` |
| `decompiled/net/thebrokenscript/api/entity/ai/anomaly2/SubAnomaly2Ai.java` | 0 | 4 | `entity`, `local` |
| `decompiled/net/thebrokenscript/api/entity/ai/curved/CurvedGoals.java` | 0 | 2 | `entity` |
| `decompiled/net/thebrokenscript/api/entity/ai/fake_player/FakePlayerGoals.java` | 0 | 3 | `local` |
| `decompiled/net/thebrokenscript/api/entity/ai/fractured/FracturedRoamGoUnDerGroundGoal.java` | 0 | 5 | `entity` |
| `decompiled/net/thebrokenscript/api/entity/ai/integrity/phas1/Phase1Goals.java` | 0 | 1 | `entity` |
| `decompiled/net/thebrokenscript/api/entity/ai/integrity/phase3/Phase3Goals.java` | 0 | 1 | `entity` |
| `decompiled/net/thebrokenscript/api/entity/ai/tentacle/TentacleGoals.java` | 1 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/AnomalyConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/ChunkRemoverConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/CircuitMineshaftConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/CircuitStalkConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/CorruptionConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/CurvedConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/EerieConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/FarawayConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/FeverStalkConditions.java` | 3 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/FracturedConditions.java` | 1 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/HerobrineConditions.java` | 1 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/NIWConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/NameTagConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/NothingWatcherConditions.java` | 1 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/NullConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/NullMazeConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/ObliterationConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/SiluetConditions.java` | 3 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/TBEAmbushConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/TBEConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/TBSDefaultConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/entity/conditions/TBSEntityConditions.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/api/ext/StringExt.java` | 1 | 1 | `injected`, `local` |
| `decompiled/net/thebrokenscript/behaviors/CircuitDefaultStareBehavior.java` | 4 | 0 | `world` |
| `decompiled/net/thebrokenscript/behaviors/CircuitMineshaftStalkBehaviour.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/behaviors/CircuitStalkBehavior.java` | 2 | 0 | `world` |
| `decompiled/net/thebrokenscript/behaviors/NullTitleShowerBehavior.java` | 4 | 2 | `local`, `world` |
| `decompiled/net/thebrokenscript/block/AllDeadBlock.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/block/BlockIsMissingIdBlock.java` | 3 | 0 | `injected`, `world` |
| `decompiled/net/thebrokenscript/block/ExitBlock.java` | 2 | 0 | `world` |
| `decompiled/net/thebrokenscript/block/ItBlock.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/block/OldBlock.java` | 0 | 1 | `entity` |
| `decompiled/net/thebrokenscript/block/PhysicalStacktraceBlock.java` | 4 | 0 | `injected` |
| `decompiled/net/thebrokenscript/block/PlushBlock.java` | 0 | 2 | `local` |
| `decompiled/net/thebrokenscript/block/TetherBloomBlock.java` | 0 | 2 | `entity` |
| `decompiled/net/thebrokenscript/block/VoidRootBlock.java` | 0 | 2 | `local` |
| `decompiled/net/thebrokenscript/boss/integrity/Phase3.java` | 2 | 2 | `entity`, `local` |
| `decompiled/net/thebrokenscript/boss/integrity/TerrainCorrupterKt.java` | 1 | 0 | `injected` |
| `decompiled/net/thebrokenscript/client/TBSLibraryAnimations.java` | 15 | 0 | `client` |
| `decompiled/net/thebrokenscript/client/TBSOverlayLayer.java` | 1 | 0 | `client` |
| `decompiled/net/thebrokenscript/client/gui/CommandBlockGuiScreen.java` | 2 | 0 | `client` |
| `decompiled/net/thebrokenscript/client/gui/FakeExitButton.java` | 4 | 6 | `client`, `local` |
| `decompiled/net/thebrokenscript/client/gui/FakePauseScreen.java` | 10 | 0 | `client` |
| `decompiled/net/thebrokenscript/client/overlay/HeartCorruptionOverlay.java` | 4 | 1 | `client` |
| `decompiled/net/thebrokenscript/client/particle/FardawayParticle.java` | 1 | 0 | `client` |
| `decompiled/net/thebrokenscript/client/particle/NullParticle.java` | 1 | 0 | `client` |
| `decompiled/net/thebrokenscript/client/particle/PaperParticle.java` | 2 | 0 | `client` |
| `decompiled/net/thebrokenscript/client/particle/ParticleOfCurvedParticle.java` | 1 | 0 | `client` |
| `decompiled/net/thebrokenscript/client/particle/WretchedParticle.java` | 1 | 0 | `client` |
| `decompiled/net/thebrokenscript/client/renderer/world/WindowRenderer.java` | 12 | 16 | `client`, `local` |
| `decompiled/net/thebrokenscript/command/dev/CodeCommandsKt.java` | 1 | 2 | `local` |
| `decompiled/net/thebrokenscript/entity/DeceiverEntity.java` | 1 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/FarawayEntity.java` | 1 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/NoTextureEntity.java` | 6 | 2 | `entity`, `local` |
| `decompiled/net/thebrokenscript/entity/anomaly/sa1/SubAnomaly1Entity.java` | 6 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/anomaly/sa2/SubAnomaly2BaseEntity.java` | 0 | 2 | `local` |
| `decompiled/net/thebrokenscript/entity/anomaly/sa2/SubAnomaly2Entity.java` | 0 | 2 | `local` |
| `decompiled/net/thebrokenscript/entity/boss/ChordEntity.java` | 5 | 9 | `entity`, `local` |
| `decompiled/net/thebrokenscript/entity/boss/TetherEntity.java` | 7 | 0 | `injected` |
| `decompiled/net/thebrokenscript/entity/circuit/CircuitEntity.java` | 8 | 0 | `entity`, `injected` |
| `decompiled/net/thebrokenscript/entity/circuit/CircuitStalkEntity.java` | 2 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/circuit/CircuitStareEntity.java` | 2 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/circuit/FakePlayerEntity.java` | 0 | 1 | `local` |
| `decompiled/net/thebrokenscript/entity/fever/FeverEntity.java` | 2 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/fractured/FracturedRoamEntity.java` | 0 | 1 | `local` |
| `decompiled/net/thebrokenscript/entity/fractured/JimAttackSelectorGoal.java` | 0 | 1 | `entity` |
| `decompiled/net/thebrokenscript/entity/maze/MazeShadowsEntity.java` | 2 | 2 | `entity`, `local` |
| `decompiled/net/thebrokenscript/entity/misc/CaveSoundEntity.java` | 1 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/misc/ChunkRemoverEntity.java` | 2 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/misc/JonEntity.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/entity/misc/MurderfurEntity.java` | 1 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/misc/NothingWatcherEntity.java` | 1 | 0 | `injected` |
| `decompiled/net/thebrokenscript/entity/niw/NothingIsWatchingChaseEntity.java` | 4 | 0 | `injected` |
| `decompiled/net/thebrokenscript/entity/niw/NothingIsWatchingEntity.java` | 3 | 0 | `injected`, `world` |
| `decompiled/net/thebrokenscript/entity/nullent/NullChaseEntity.java` | 4 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/nullent/NullFlyingEntity.java` | 5 | 0 | `entity`, `injected` |
| `decompiled/net/thebrokenscript/entity/nullent/NullInvadeBaseEntity.java` | 4 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/nullent/NullMazeEntity.java` | 1 | 1 | `entity` |
| `decompiled/net/thebrokenscript/entity/nullent/NullScareEntity.java` | 1 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/nullent/NullWatchingEntity.java` | 5 | 4 | `entity`, `injected`, `local` |
| `decompiled/net/thebrokenscript/entity/nullent/Xxram2dieEntity.java` | 1 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/oblit/Obliteration2Entity.java` | 2 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/oblit/ObliterationEntity.java` | 2 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/players/CurvedEntity.java` | 2 | 5 | `entity`, `local` |
| `decompiled/net/thebrokenscript/entity/players/PhantomPlayerEntity.java` | 1 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/siluet/HeChaseEntity.java` | 3 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/siluet/HeEntity.java` | 4 | 0 | `entity`, `injected` |
| `decompiled/net/thebrokenscript/entity/siluet/HeHallucinationEntity.java` | 1 | 1 | `entity` |
| `decompiled/net/thebrokenscript/entity/siluet/SiluetChaseEntity.java` | 3 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/siluet/SiluetEntity.java` | 6 | 1 | `entity`, `injected`, `local` |
| `decompiled/net/thebrokenscript/entity/siluet/SiluetHallucinationEntity.java` | 1 | 1 | `entity` |
| `decompiled/net/thebrokenscript/entity/siluet/SiluetStareEntity.java` | 3 | 0 | `entity`, `injected` |
| `decompiled/net/thebrokenscript/entity/tbe/TheBrokenEndAmbushEntity.java` | 1 | 3 | `injected`, `local` |
| `decompiled/net/thebrokenscript/entity/tbe/TheBrokenEndCuriousEntity.java` | 1 | 0 | `entity` |
| `decompiled/net/thebrokenscript/entity/tbe/TheBrokenEndEntity.java` | 6 | 0 | `entity`, `injected` |
| `decompiled/net/thebrokenscript/entity/tbe/TheBrokenEndStalkEntity.java` | 3 | 0 | `entity`, `injected` |
| `decompiled/net/thebrokenscript/events/entities/CircuitVillageEvent.java` | 7 | 0 | `injected`, `world` |
| `decompiled/net/thebrokenscript/events/entities/HallucinationEvent.java` | 4 | 1 | `entity`, `world` |
| `decompiled/net/thebrokenscript/events/entities/StrikeLightningEvent.java` | 3 | 0 | `world` |
| `decompiled/net/thebrokenscript/events/entities/TbeCuriousEvent.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/events/environment/MoonGlitchEvent.java` | 2 | 0 | `world` |
| `decompiled/net/thebrokenscript/events/misc/BSODEvent.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/events/misc/CaveWhisperEvent.java` | 0 | 2 | `local` |
| `decompiled/net/thebrokenscript/events/misc/DoorEvent.java` | 0 | 1 | `local` |
| `decompiled/net/thebrokenscript/events/misc/ExperienceEvent.java` | 2 | 0 | `world` |
| `decompiled/net/thebrokenscript/events/misc/ExplodeBaseEvent.java` | 3 | 2 | `local`, `world` |
| `decompiled/net/thebrokenscript/events/misc/HungryEvent.java` | 0 | 1 | `entity` |
| `decompiled/net/thebrokenscript/events/misc/LookAndDamageEvent.java` | 0 | 4 | `entity` |
| `decompiled/net/thebrokenscript/events/misc/SetRandomTimeOfDay.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/events/misc/SetTimeEvent.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/events/misc/TextEvent.java` | 0 | 2 | `local` |
| `decompiled/net/thebrokenscript/events/misc/WindowTitleEvent.java` | 3 | 2 | `local` |
| `decompiled/net/thebrokenscript/events/nullent/NullBookEvent.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/events/nullent/NullRandomAdvancementEvent.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/events/nullent/NullScareEvent.java` | 4 | 0 | `world` |
| `decompiled/net/thebrokenscript/events/nullent/NullWhisperEvent.java` | 0 | 2 | `local` |
| `decompiled/net/thebrokenscript/events/sounds/HeartBeatEvent.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/events/sounds/ParanoiaEvent.java` | 6 | 0 | `world` |
| `decompiled/net/thebrokenscript/events/sounds/PlaySoundEvent.java` | 1 | 2 | `local`, `world` |
| `decompiled/net/thebrokenscript/events/sounds/PsstEvent.java` | 2 | 0 | `world` |
| `decompiled/net/thebrokenscript/events/sounds/RandomSongEvent.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/events/structures/ObfuscatedSignEvent.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/events/world/PlaceBedrockEvent.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/events/world/PlaceWaterEvent.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/handlers/CorruptedCommandBlockHandler.java` | 0 | 2 | `entity` |
| `decompiled/net/thebrokenscript/handlers/EntityChecker.java` | 0 | 1 | `local` |
| `decompiled/net/thebrokenscript/handlers/EntityNamer.java` | 0 | 2 | `entity` |
| `decompiled/net/thebrokenscript/handlers/MoonAnimationHandler.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/handlers/NullMiningDespawner.java` | 0 | 1 | `entity` |
| `decompiled/net/thebrokenscript/handlers/NullMiningSpawner.java` | 7 | 0 | `injected` |
| `decompiled/net/thebrokenscript/handlers/ServerTickHandler.java` | 0 | 1 | `local` |
| `decompiled/net/thebrokenscript/handlers/chat/ChatAlertHandler.java` | 0 | 1 | `entity` |
| `decompiled/net/thebrokenscript/handlers/circuit/CircuitBlockBreakHandler.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/handlers/circuit/CircuitEntitySpawnHandler.java` | 1 | 1 | `entity` |
| `decompiled/net/thebrokenscript/handlers/dimensions/ambience/ClanVoidAmbienceHandler.java` | 6 | 1 | `entity`, `injected`, `world` |
| `decompiled/net/thebrokenscript/handlers/dimensions/ambience/ConcreteAmbienceHandler.java` | 1 | 1 | `entity` |
| `decompiled/net/thebrokenscript/handlers/dimensions/ambience/LibraryAmbienceHandler.java` | 1 | 1 | `entity` |
| `decompiled/net/thebrokenscript/handlers/dimensions/ambience/LucidAmbienceHandler.java` | 1 | 1 | `entity` |
| `decompiled/net/thebrokenscript/handlers/dimensions/ambience/NowhereAmbienceHandler.java` | 1 | 1 | `entity` |
| `decompiled/net/thebrokenscript/handlers/dimensions/ambience/WoodFloorDoorHandler.java` | 3 | 0 | `injected` |
| `decompiled/net/thebrokenscript/handlers/player/CircuitEffectsShaker.java` | 0 | 14 | `entity` |
| `decompiled/net/thebrokenscript/handlers/player/PlayerDataTicker.java` | 0 | 4 | `entity` |
| `decompiled/net/thebrokenscript/handlers/player/PlayerJoinHandler.java` | 1 | 22 | `entity`, `local` |
| `decompiled/net/thebrokenscript/handlers/player/SleepHandler.java` | 1 | 0 | `world` |
| `decompiled/net/thebrokenscript/item/LibraryBookItem.java` | 3 | 1 | `local`, `world` |
| `decompiled/net/thebrokenscript/item/PlushItem.java` | 0 | 2 | `local` |
| `decompiled/net/thebrokenscript/mixins/features/font/BakedGlyphMixin.java` | 5 | 1 | `injected`, `local` |
| `decompiled/net/thebrokenscript/mixins/features/screen/BaseTBSTitleScreenMixin.java` | 5 | 1 | `client`, `local` |
| `decompiled/net/thebrokenscript/mixins/features/screen/LogoRendererMixin.java` | 2 | 1 | `client`, `local` |
| `decompiled/net/thebrokenscript/mixins/features/sleeping/WakeUpTeleportMixin.java` | 1 | 1 | `entity`, `world` |
| `decompiled/net/thebrokenscript/mixins/features/spash/SplashManagerMixin.java` | 2 | 0 | `injected` |
| `decompiled/net/thebrokenscript/mixins/features/vfx/VoidFogMixin.java` | 10 | 0 | `injected`, `world` |
| `decompiled/net/thebrokenscript/mixins/features/world/BlockMixin.java` | 6 | 0 | `injected`, `world` |
| `decompiled/net/thebrokenscript/network/CorruptedCommandBlockConfirmPacket.java` | 2 | 0 | `world` |
| `decompiled/net/thebrokenscript/network/CurvedNoticePacket.java` | 0 | 4 | `local` |
| `decompiled/net/thebrokenscript/responses/misc/ClanBaseStructureCurvedResponse.java` | 2 | 0 | `world` |
| `decompiled/net/thebrokenscript/responses/misc/ImScaredResponse.java` | 1 | 2 | `local` |
| `decompiled/net/thebrokenscript/responses/nullent/CalResponse.java` | 2 | 0 | `world` |
| `decompiled/net/thebrokenscript/responses/nullent/FuckYouResponse.java` | 2 | 0 | `world` |
| `decompiled/net/thebrokenscript/util/CustomGoals.java` | 0 | 3 | `entity` |
| `decompiled/net/thebrokenscript/util/GenerateRandomNameKt.java` | 0 | 5 | `local` |
| `decompiled/net/thebrokenscript/util/GetRandomCachedPlayerKt.java` | 0 | 2 | `local` |
| `decompiled/net/thebrokenscript/util/StructureUtil.java` | 2 | 1 | `local` |
| `decompiled/net/thebrokenscript/world/chunk/ChunkCarver.java` | 3 | 0 | `world` |
| `decompiled/net/thebrokenscript/world/dimension/backrooms/BRGenUtil.java` | 14 | 3 | `entity`, `injected` |
| `decompiled/net/thebrokenscript/world/dimension/backrooms/BackroomsLevelZero.java` | 0 | 3 | `local` |
| `decompiled/net/thebrokenscript/world/dimension/boss/stage2/Stage2Dimension.java` | 0 | 1 | `local` |
| `decompiled/net/thebrokenscript/world/dimension/boss/stage2/Stage2Generator.java` | 18 | 7 | `entity`, `injected`, `local` |
| `decompiled/net/thebrokenscript/world/dimension/boss/stage3/Stage3Dimension.java` | 0 | 1 | `local` |
| `decompiled/net/thebrokenscript/world/dimension/clan_void/ClanVoidDimension.java` | 3 | 0 | `world` |
| `decompiled/net/thebrokenscript/world/dimension/clan_void/ClanVoidGenerator.java` | 18 | 5 | `entity`, `injected`, `local` |
| `decompiled/net/thebrokenscript/world/dimension/concrete/ConcreteGenerator.java` | 0 | 1 | `entity` |
| `decompiled/net/thebrokenscript/world/dimension/library/LibraryGenerator.java` | 0 | 1 | `entity` |
| `decompiled/net/thebrokenscript/world/dimension/limbo/LimboGenerator.java` | 0 | 2 | `entity` |
| `decompiled/net/thebrokenscript/world/dimension/lucid/LucidGenerator.java` | 0 | 15 | `entity` |
| `decompiled/net/thebrokenscript/world/dimension/nowhere/NowhereGenerator.java` | 8 | 4 | `entity`, `injected`, `local` |
| `decompiled/net/thebrokenscript/world/dimension/null_torture/NullTortureGenerator.java` | 1 | 4 | `entity`, `local` |
| `decompiled/net/thebrokenscript/world/dimension/protected_void/ProtectedVoidGenerator.java` | 0 | 1 | `entity` |
| `decompiled/net/thebrokenscript/world/gen/features/DayAFeature.java` | 5 | 0 | `injected` |
| `decompiled/net/thebrokenscript/world/gen/features/MoonChunkFeature.java` | 8 | 0 | `injected` |
| `decompiled/net/thebrokenscript/world/gen/features/VoidCystFeature.java` | 28 | 0 | `injected` |
| `decompiled/net/thebrokenscript/world/gen/structure/VoidGrowthStructure.java` | 5 | 0 | `injected` |
| `decompiled_brokencore/net/thebrokenscript/brokencore/api/dsl/ArrayUtil.java` | 1 | 0 | `injected` |
| `decompiled_brokencore/net/thebrokenscript/brokencore/api/dsl/EntityUtil.java` | 1 | 0 | `injected` |
| `decompiled_brokencore/net/thebrokenscript/brokencore/api/dsl/RandomUtil.java` | 4 | 0 | `injected` |
| `decompiled_brokencore/net/thebrokenscript/brokencore/api/dsl/StructureUtil.java` | 1 | 5 | `entity`, `world` |
| `decompiled_brokencore/net/thebrokenscript/brokencore/api/engine/EventEngine.java` | 1 | 2 | `local`, `world` |
| `decompiled_brokencore/net/thebrokenscript/brokencore/api/ext/PlayerListExt.java` | 0 | 4 | `entity` |
| `decompiled_brokencore/net/thebrokenscript/brokencore/api/ext/VoxelShapeExtKt.java` | 0 | 4 | `local` |
| `decompiled_brokencore/net/thebrokenscript/brokencore/api/learner/util/PlayerBase.java` | 0 | 4 | `local` |
| `decompiled_brokencore/net/thebrokenscript/brokencore/api/math/BoundedUnitVectorGenerator.java` | 1 | 1 | `local` |
| `decompiled_brokencore/net/thebrokenscript/brokencore/api/misc/UwuManager.java` | 1 | 3 | `local` |
| `decompiled_brokencore/net/thebrokenscript/brokencore/api/sound/FancyAudio.java` | 0 | 1 | `local` |
| `decompiled_brokencore/net/thebrokenscript/brokencore/impl/event/engine/LegacyEventPicker.java` | 2 | 0 | `world` |
| `decompiled_brokencore/net/thebrokenscript/brokencore/impl/event/engine/StatisticsEventPicker.java` | 3 | 0 | `world` |
| `decompiled_brokencore/net/thebrokenscript/brokencore/neoforge/PlatformRenderingImpl.java` | 0 | 1 | `local` |

## Bedrock file inventory

| File | Direct `Math.random()` calls | Scope |
| --- | ---: | --- |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/boss_controller.js` | 5 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/boss_spawn_rules.js` | 5 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/fractured_runtime.js` | 3 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/boss/phase3_runtime.js` | 2 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/circuit/circuit_controller.js` | 9 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/circuit/circuit_spawn_rules.js` | 1 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/humanoid/humanoid_controller.js` | 10 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/humanoid/humanoid_spawn_rules.js` | 10 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/misc/misc_controller.js` | 23 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/misc/misc_spawn_rules.js` | 10 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/null/null_controller.js` | 6 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/null/null_pursuit_controller.js` | 5 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/null/null_spawn_rules.js` | 3 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/stalk/stalk_controller.js` | 7 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/stalk/stalk_spawn_rules.js` | 8 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/tbe/tbe_controller.js` | 10 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/entities/tbe/tbe_spawn_rules.js` | 6 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ai/spawn_helpers.js` | 2 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/systems/custom_blocks.js` | 1 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/systems/dimensions.js` | 1 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/systems/fractured_roam_model.js` | 1 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_events.js` | 20 | `horror-event-adapter` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/systems/horror_rules.js` | 1 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/systems/ported_features.js` | 4 | `runtime-global` |
| `TheBrokenScript_Bedrock_2_0/BP/scripts/systems/world_state.js` | 4 | `runtime-global` |
