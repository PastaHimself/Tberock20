/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.math.MathKt
 *  kotlin.random.Random
 *  kotlin.ranges.IntRange
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.util.Mth
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSources
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.ai.attributes.AttributeInstance
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockBehaviour$BlockStateBase
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.LevelUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.ext.DamageSourcesExt
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.boss.integrity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.boss.integrity.Arena;
import net.thebrokenscript.boss.integrity.ArenaPhase;
import net.thebrokenscript.boss.integrity.IntegBossBarHandler;
import net.thebrokenscript.boss.integrity.Phase;
import net.thebrokenscript.brokencore.api.dsl.LevelUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.ext.DamageSourcesExt;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.entity.boss.VoidTentacleEntity;
import net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity;
import net.thebrokenscript.registry.TBSDamageTypes;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020!H\u0016J\u0006\u0010$\u001a\u00020!J\b\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010)\u001a\u00020*8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u00a8\u0006."}, d2={"Lnet/thebrokenscript/boss/integrity/Phase3;", "Lnet/thebrokenscript/boss/integrity/Phase;", "arena", "Lnet/thebrokenscript/boss/integrity/Arena;", "<init>", "(Lnet/thebrokenscript/boss/integrity/Arena;)V", "integrity", "Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;", "getIntegrity", "()Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;", "setIntegrity", "(Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;)V", "event", "Lnet/thebrokenscript/boss/integrity/IntegBossBarHandler;", "getEvent", "()Lnet/thebrokenscript/boss/integrity/IntegBossBarHandler;", "integrityFlailingGasStationArms", "", "Lnet/thebrokenscript/entity/boss/VoidTentacleEntity;", "pendingKills", "", "Ljava/util/UUID;", "", "id", "Lnet/thebrokenscript/boss/integrity/ArenaPhase;", "getId", "()Lnet/thebrokenscript/boss/integrity/ArenaPhase;", "dimension", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/level/Level;", "getDimension", "()Lnet/minecraft/resources/ResourceKey;", "start", "", "tick", "end", "spawnIntegrityFlailingGasStationArms", "cleanup", "playerEnteredDimension", "player", "Lnet/minecraft/server/level/ServerPlayer;", "ended", "", "getEnded", "()Z", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPhase3.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Phase3.kt\nnet/thebrokenscript/boss/integrity/Phase3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,209:1\n774#2:210\n865#2,2:211\n1563#2:213\n1634#2,3:214\n1869#2,2:217\n295#2,2:219\n1563#2:221\n1634#2,3:222\n1634#2,3:225\n1869#2,2:228\n1869#2,2:230\n1869#2,2:232\n*S KotlinDebug\n*F\n+ 1 Phase3.kt\nnet/thebrokenscript/boss/integrity/Phase3\n*L\n85#1:210\n85#1:211,2\n86#1:213\n86#1:214,3\n88#1:217,2\n102#1:219,2\n138#1:221\n138#1:222,3\n146#1:225,3\n147#1:228,2\n168#1:230,2\n193#1:232,2\n*E\n"})
public final class Phase3
extends Phase {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private IntegrityPhase3Entity integrity;
    @NotNull
    private final IntegBossBarHandler event;
    @NotNull
    private final List<VoidTentacleEntity> integrityFlailingGasStationArms;
    @NotNull
    private final Map<UUID, Integer> pendingKills;
    @NotNull
    private final ArenaPhase id;
    @NotNull
    private final ResourceKey<Level> dimension;
    private static final int MIN_TENTACLE_RANGE = 100;
    private static final int MAX_TENTACLE_RANGE = 124;
    private static final int TENTACLE_COUNT = 250;
    private static final int KILL_DELAY_TICKS = 60;
    @NotNull
    private static final Vec3 CENTER = new Vec3(194.0, -59.0, 205.0);
    @NotNull
    private static final List<BlockPos> PRESET_TENTACLES;

    public Phase3(@NotNull Arena arena) {
        Intrinsics.checkNotNullParameter((Object)arena, (String)"arena");
        super(arena);
        this.event = new IntegBossBarHandler();
        this.integrityFlailingGasStationArms = new ArrayList();
        this.pendingKills = new LinkedHashMap();
        this.id = ArenaPhase.Phase3;
        this.dimension = TBSDimensions.STAGE3;
    }

    @Nullable
    public final IntegrityPhase3Entity getIntegrity() {
        return this.integrity;
    }

    public final void setIntegrity(@Nullable IntegrityPhase3Entity integrityPhase3Entity) {
        this.integrity = integrityPhase3Entity;
    }

    @NotNull
    public final IntegBossBarHandler getEvent() {
        return this.event;
    }

    @Override
    @NotNull
    public ArenaPhase getId() {
        return this.id;
    }

    @Override
    @NotNull
    public ResourceKey<Level> getDimension() {
        return this.dimension;
    }

    @Override
    public void start() {
        this.spawnIntegrityFlailingGasStationArms();
        for (ServerPlayer player : this.getPlayers()) {
            PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)Phase3::start$lambda$0));
            this.event.addPlayer(player);
            PlayerUtil.stopAllSounds((Player)((Player)player));
            PlayerUtil.trySendCustomPacket((Player)((Player)player), (CustomPacketPayload)((CustomPacketPayload)TBSPackets.INTEGRITY_P3_MUSIC.create()));
        }
        LevelUtil.getQueue((Level)((Level)this.getLevel())).add(20L, () -> Phase3.start$lambda$1(this));
        this.integrity = (IntegrityPhase3Entity)EntityTypeExt.trySummonTyped((EntityType)((EntityType)TBSEntities.INTEGRITY_PHASE_3.get()), (LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)CENTER);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void tick() {
        Iterator $this$mapTo$iv$iv;
        Object element$iv$iv2;
        void $this$filterTo$iv$iv;
        if (this.integrity == null) {
            return;
        }
        IntegrityPhase3Entity integrityPhase3Entity = this.integrity;
        Intrinsics.checkNotNull((Object)((Object)integrityPhase3Entity));
        float f = integrityPhase3Entity.getHealth();
        IntegrityPhase3Entity integrityPhase3Entity2 = this.integrity;
        Intrinsics.checkNotNull((Object)((Object)integrityPhase3Entity2));
        this.event.set(f / integrityPhase3Entity2.getMaxHealth(), !this.getEnded());
        Iterable $this$filter$iv = this.getPlayers();
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Iterable destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv2 : $this$filterTo$iv$iv) {
            ServerPlayer player = (ServerPlayer)element$iv$iv2;
            boolean bl = false;
            if (!(player.getY() > 90.0 && Intrinsics.areEqual((Object)player.level().dimension(), this.getDimension()))) continue;
            destination$iv$iv.add(element$iv$iv2);
        }
        List aboveBoundary = (List)destination$iv$iv;
        Iterable $this$map$iv = aboveBoundary;
        boolean $i$f$map = false;
        destination$iv$iv = $this$map$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        element$iv$iv2 = $this$mapTo$iv$iv.iterator();
        while (element$iv$iv2.hasNext()) {
            void it;
            Object item$iv$iv = element$iv$iv2.next();
            ServerPlayer bl = (ServerPlayer)item$iv$iv;
            Collection collection = destination$iv$iv2;
            boolean bl2 = false;
            collection.add(it.getUUID());
        }
        Set aboveIds = CollectionsKt.toSet((Iterable)((List)destination$iv$iv2));
        Iterable $this$forEach$iv = aboveBoundary;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerPlayer player = (ServerPlayer)element$iv;
            boolean bl = false;
            if (this.pendingKills.putIfAbsent(player.getUUID(), 60) != null) continue;
            PlayerUtil.trySendOverlay((Player)((Player)player), (ResourceLocation)TBSConstants.id("textures/screens/transition.png"), (long)0L);
        }
        this.pendingKills.keySet().retainAll(aboveIds);
        Iterator<Map.Entry<UUID, Integer>> iterator = this.pendingKills.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<UUID, Integer> entry = iterator.next();
            UUID uuid = entry.getKey();
            int ticksLeft = ((Number)entry.getValue()).intValue();
            if (ticksLeft <= 0) {
                ServerPlayer playerToKill;
                ServerPlayer serverPlayer;
                Object v3;
                block10: {
                    Iterable $this$firstOrNull$iv = this.getPlayers();
                    boolean $i$f$firstOrNull = false;
                    for (Object element$iv : $this$firstOrNull$iv) {
                        ServerPlayer it = (ServerPlayer)element$iv;
                        boolean bl = false;
                        if (!Intrinsics.areEqual((Object)it.getUUID(), (Object)uuid)) continue;
                        v3 = element$iv;
                        break block10;
                    }
                    v3 = null;
                }
                if ((serverPlayer = (playerToKill = (ServerPlayer)v3)) != null && (serverPlayer = serverPlayer.getRandom()) != null) {
                    boolean it = serverPlayer.nextBoolean();
                    boolean bl = false;
                    if (it) {
                        DamageSources damageSources = this.getLevel().damageSources();
                        Intrinsics.checkNotNullExpressionValue((Object)damageSources, (String)"damageSources(...)");
                        ResourceKey resourceKey = TBSDamageTypes.VOID_MASS.getKey();
                        IntegrityPhase3Entity integrityPhase3Entity3 = this.integrity;
                        Intrinsics.checkNotNull((Object)((Object)integrityPhase3Entity3));
                        v8 = playerToKill.hurt(DamageSourcesExt.INSTANCE.source(damageSources, resourceKey, (Entity)integrityPhase3Entity3), 1000000.0f);
                    } else {
                        v8 = playerToKill.hurt(this.getLevel().damageSources().source(TBSDamageTypes.VOID_MASS.getKey()), 1000000.0f);
                    }
                }
                iterator.remove();
                continue;
            }
            this.pendingKills.put(uuid, ticksLeft - 1);
        }
    }

    @Override
    public void end() {
        this.event.reset();
        IntegrityPhase3Entity integrityPhase3Entity = this.integrity;
        if (integrityPhase3Entity != null) {
            integrityPhase3Entity.moveTo(CENTER);
        }
        for (ServerPlayer player : this.getPlayers()) {
            PlayerUtil.trySendCustomPacket((Player)((Player)player), (CustomPacketPayload)((CustomPacketPayload)TBSPackets.INTEGRITY_END_MUSIC.create()));
            PlayerUtil.trySendCustomPacket((Player)((Player)player), (CustomPacketPayload)((CustomPacketPayload)TBSPackets.PHASE3_CUTSCENE.create()));
        }
        LevelUtil.getQueue((Level)((Level)this.getLevel())).add(298L, () -> Phase3.end$lambda$0(this));
    }

    /*
     * WARNING - void declaration
     */
    public final void spawnIntegrityFlailingGasStationArms() {
        Object element$iv;
        void destination$iv;
        void $this$mapTo$iv;
        Collection collection;
        void $this$mapTo$iv$iv;
        float change = 0.025132742f;
        Iterable $this$map$iv = (Iterable)new IntRange(0, 250);
        boolean $i$f$map22 = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        Pair pair = $this$mapTo$iv$iv.iterator();
        while (pair.hasNext()) {
            void i;
            int item$iv$iv;
            int n = item$iv$iv = ((IntIterator)pair).nextInt();
            collection = destination$iv$iv;
            boolean bl = false;
            float angle = change * (float)i;
            int range = Random.Default.nextInt(100, 124);
            collection.add(TuplesKt.to((Object)MathKt.roundToInt((float)(Mth.cos((float)angle) * (float)range + (float)200)), (Object)MathKt.roundToInt((float)(Mth.sin((float)angle) * (float)range + (float)202))));
        }
        List candidates = (List)destination$iv$iv;
        $this$map$iv = candidates;
        Collection $i$f$map22 = new LinkedHashSet();
        boolean $i$f$mapTo22 = false;
        for (Object item$iv : $this$mapTo$iv) {
            pair = (Pair)item$iv;
            collection = destination$iv;
            boolean bl = false;
            int x = ((Number)pair.component1()).intValue();
            int z = ((Number)pair.component2()).intValue();
            collection.add(TuplesKt.to((Object)(x >> 4), (Object)(z >> 4)));
        }
        Object $this$forEach$iv = (Iterable)destination$iv;
        boolean $i$f$forEach2 = false;
        Iterator $i$f$mapTo22 = $this$forEach$iv.iterator();
        while ($i$f$mapTo22.hasNext()) {
            element$iv = $i$f$mapTo22.next();
            Pair item$iv = (Pair)element$iv;
            boolean bl = false;
            int cx = ((Number)item$iv.component1()).intValue();
            int cz = ((Number)item$iv.component2()).intValue();
            this.getLevel().getChunk(cx, cz);
        }
        for (Pair $i$f$forEach2 : candidates) {
            Entity ent;
            int x = ((Number)$i$f$forEach2.component1()).intValue();
            int z = ((Number)$i$f$forEach2.component2()).intValue();
            int y = this.getLevel().getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, x, z);
            BlockPos pos = new BlockPos(x, y, z);
            if (y > -40 || !this.getLevel().isStateAtPosition(pos, BlockBehaviour.BlockStateBase::isAir) || ((EntityType)TBSEntities.VOID_TENTACLE.value()).create((Level)this.getLevel()) == null) continue;
            ent.moveTo((double)pos.getX() + 0.5, (double)pos.getY(), (double)pos.getZ() + 0.5, 0.0f, 0.0f);
            this.getLevel().addFreshEntityWithPassengers(ent);
            if (!(ent instanceof FinalizedSpawn)) continue;
            FinalizedSpawn finalizedSpawn = (FinalizedSpawn)ent;
            ServerLevelAccessor serverLevelAccessor = (ServerLevelAccessor)this.getLevel();
            DifficultyInstance difficultyInstance = this.getLevel().getCurrentDifficultyAt(pos);
            Intrinsics.checkNotNullExpressionValue((Object)difficultyInstance, (String)"getCurrentDifficultyAt(...)");
            finalizedSpawn.onFinalizeSpawn(serverLevelAccessor, difficultyInstance, MobSpawnType.NATURAL, null, new CancelProxy(Phase3::spawnIntegrityFlailingGasStationArms$lambda$3, Phase3::spawnIntegrityFlailingGasStationArms$lambda$4));
        }
        $this$forEach$iv = PRESET_TENTACLES;
        boolean $i$f$forEach3 = false;
        Iterator iterator = $this$forEach$iv.iterator();
        while (iterator.hasNext()) {
            Entity entity;
            element$iv = iterator.next();
            BlockPos pos = (BlockPos)element$iv;
            boolean bl = false;
            this.getLevel().getChunk(pos.getX() >> 4, pos.getZ() >> 4);
            if (((EntityType)TBSEntities.VOID_TENTACLE.value()).create((Level)this.getLevel()) == null) continue;
            Intrinsics.checkNotNull((Object)entity);
            Entity ent = entity;
            ent.moveTo((double)pos.getX() + 0.5, (double)pos.getY(), (double)pos.getZ() + 0.5, 0.0f, 0.0f);
            if (ent instanceof VoidTentacleEntity) {
                AttributeInstance attributeInstance = ((VoidTentacleEntity)ent).getAttribute(Attributes.SCALE);
                if (attributeInstance != null) {
                    attributeInstance.setBaseValue(2.0);
                }
            }
            this.getLevel().addFreshEntityWithPassengers(ent);
            if (!(ent instanceof FinalizedSpawn)) continue;
            FinalizedSpawn finalizedSpawn = (FinalizedSpawn)ent;
            ServerLevelAccessor serverLevelAccessor = (ServerLevelAccessor)this.getLevel();
            DifficultyInstance difficultyInstance = this.getLevel().getCurrentDifficultyAt(pos);
            Intrinsics.checkNotNullExpressionValue((Object)difficultyInstance, (String)"getCurrentDifficultyAt(...)");
            finalizedSpawn.onFinalizeSpawn(serverLevelAccessor, difficultyInstance, MobSpawnType.NATURAL, null, new CancelProxy(Phase3::spawnIntegrityFlailingGasStationArms$lambda$5$0, Phase3::spawnIntegrityFlailingGasStationArms$lambda$5$1));
        }
    }

    @Override
    public void cleanup() {
        this.event.reset();
        IntegrityPhase3Entity integrityPhase3Entity = this.integrity;
        if (integrityPhase3Entity != null) {
            integrityPhase3Entity.discard();
        }
        Iterable $this$forEach$iv = this.integrityFlailingGasStationArms;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            VoidTentacleEntity p0 = (VoidTentacleEntity)((Object)element$iv);
            boolean bl = false;
            p0.discard();
        }
        this.integrityFlailingGasStationArms.clear();
    }

    @Override
    public void playerEnteredDimension(@NotNull ServerPlayer player) {
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        super.playerEnteredDimension(player);
        PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)Phase3::playerEnteredDimension$lambda$0));
        this.event.addPlayer(player);
    }

    @Override
    public boolean getEnded() {
        IntegrityPhase3Entity integrityPhase3Entity = this.integrity;
        return integrityPhase3Entity != null ? integrityPhase3Entity.getDying() : false;
    }

    private static final Unit start$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setLoadingPhase3(true);
        return Unit.INSTANCE;
    }

    private static final Unit start$lambda$1(Phase3 this$0) {
        for (ServerPlayer player : this$0.getPlayers()) {
            PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)Phase3::start$lambda$1$0));
            PlayerUtil.sendTo((Player)((Player)player), TBSDimensions.STAGE3);
        }
        return Unit.INSTANCE;
    }

    private static final Unit start$lambda$1$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setFixPos(true);
        return Unit.INSTANCE;
    }

    private static final Unit end$lambda$0(Phase3 this$0) {
        block0: {
            IntegrityPhase3Entity integrityPhase3Entity = this$0.integrity;
            if (integrityPhase3Entity == null) break block0;
            integrityPhase3Entity.discard();
        }
        return Unit.INSTANCE;
    }

    private static final Unit spawnIntegrityFlailingGasStationArms$lambda$3(boolean it) {
        return Unit.INSTANCE;
    }

    private static final boolean spawnIntegrityFlailingGasStationArms$lambda$4() {
        return false;
    }

    private static final Unit spawnIntegrityFlailingGasStationArms$lambda$5$0(boolean it) {
        return Unit.INSTANCE;
    }

    private static final boolean spawnIntegrityFlailingGasStationArms$lambda$5$1() {
        return false;
    }

    private static final Unit playerEnteredDimension$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setLoadingPhase3(false);
        return Unit.INSTANCE;
    }

    static {
        Object[] objectArray = new BlockPos[]{new BlockPos(162, -59, 232), new BlockPos(186, -59, 181), new BlockPos(228, -59, 213)};
        PRESET_TENTACLES = CollectionsKt.listOf((Object[])objectArray);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/boss/integrity/Phase3$Companion;", "", "<init>", "()V", "MIN_TENTACLE_RANGE", "", "MAX_TENTACLE_RANGE", "TENTACLE_COUNT", "KILL_DELAY_TICKS", "CENTER", "Lnet/minecraft/world/phys/Vec3;", "getCENTER", "()Lnet/minecraft/world/phys/Vec3;", "PRESET_TENTACLES", "", "Lnet/minecraft/core/BlockPos;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Vec3 getCENTER() {
            return CENTER;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

