/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.thebrokenscript.brokencore.api.dsl.BlockUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.boss.integrity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.Heightmap;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.boss.integrity.Arena;
import net.thebrokenscript.boss.integrity.ArenaPhase;
import net.thebrokenscript.boss.integrity.PartialBlockPos;
import net.thebrokenscript.boss.integrity.Phase;
import net.thebrokenscript.boss.integrity.TerrainCorrupterKt;
import net.thebrokenscript.brokencore.api.dsl.BlockUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.entity.boss.ChordEntity;
import net.thebrokenscript.entity.integrity.phase1.IntegrityPhase1Entity;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSPackets;
import net.thebrokenscript.registry.TBSTags;
import net.thebrokenscript.util.RadiusSpawnerKt;
import net.thebrokenscript.world.chunk.ChunkCarver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\u001c\u0010\u001f\u001a\u00020\u00172\b\b\u0002\u0010 \u001a\u00020\u000f2\b\b\u0002\u0010!\u001a\u00020\"H\u0002J\u0006\u0010#\u001a\u00020\u001cR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006%"}, d2={"Lnet/thebrokenscript/boss/integrity/Phase1;", "Lnet/thebrokenscript/boss/integrity/Phase;", "arena", "Lnet/thebrokenscript/boss/integrity/Arena;", "<init>", "(Lnet/thebrokenscript/boss/integrity/Arena;)V", "blockReg", "Lnet/minecraft/core/Registry;", "Lnet/minecraft/world/level/block/Block;", "terrainQueue", "", "Lnet/thebrokenscript/boss/integrity/PartialBlockPos;", "trackedChords", "Lnet/thebrokenscript/entity/boss/ChordEntity;", "ticksSinceLastCorrupt", "", "integrity", "Lnet/thebrokenscript/entity/integrity/phase1/IntegrityPhase1Entity;", "id", "Lnet/thebrokenscript/boss/integrity/ArenaPhase;", "getId", "()Lnet/thebrokenscript/boss/integrity/ArenaPhase;", "start", "", "tick", "end", "cleanup", "ended", "", "getEnded", "()Z", "spawnChords", "maxCount", "radius", "", "hasLivingChords", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPhase1.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Phase1.kt\nnet/thebrokenscript/boss/integrity/Phase1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n1869#2,2:113\n1869#2,2:115\n1761#2,3:117\n*S KotlinDebug\n*F\n+ 1 Phase1.kt\nnet/thebrokenscript/boss/integrity/Phase1\n*L\n87#1:113,2\n96#1:115,2\n110#1:117,3\n*E\n"})
public final class Phase1
extends Phase {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Registry<Block> blockReg;
    @NotNull
    private final List<PartialBlockPos> terrainQueue;
    @NotNull
    private final List<ChordEntity> trackedChords;
    private int ticksSinceLastCorrupt;
    @Nullable
    private IntegrityPhase1Entity integrity;
    @NotNull
    private final ArenaPhase id;
    private static final int TERRAIN_CORRUPTION_RADIUS = 100;
    private static final int TERRAIN_CORRUPTION_DELAY = 20;

    public Phase1(@NotNull Arena arena) {
        Intrinsics.checkNotNullParameter((Object)arena, (String)"arena");
        super(arena);
        Registry registry = this.getLevel().registryAccess().registryOrThrow(Registries.BLOCK);
        Intrinsics.checkNotNullExpressionValue((Object)registry, (String)"registryOrThrow(...)");
        this.blockReg = registry;
        this.terrainQueue = CollectionsKt.toMutableList((Collection)TerrainCorrupterKt.createTerrainCorruptionQueue$default((Level)this.getLevel(), this.getCenter(), 100, 0.0f, 4, null));
        this.trackedChords = new ArrayList();
        this.ticksSinceLastCorrupt = 20;
        this.id = ArenaPhase.Phase1;
    }

    @Override
    @NotNull
    public ArenaPhase getId() {
        return this.id;
    }

    @Override
    public void start() {
        int y = this.getLevel().getHeight(Heightmap.Types.MOTION_BLOCKING, this.getCenter().getX(), this.getCenter().getZ());
        if (y <= this.getLevel().getMinBuildHeight()) {
            y = this.getCenter().getY();
        }
        ChunkCarver.start$default(ChunkCarver.INSTANCE, this.getLevel(), this.getCenter(), null, 4, null);
        BlockPos spawnPos = PositionUtil.withY((BlockPos)this.getCenter(), (Number)(y - 0));
        IntegrityPhase1Entity integrityPhase1Entity = this.integrity = (IntegrityPhase1Entity)EntityTypeExt.trySummonTyped((EntityType)((EntityType)TBSEntities.INTEGRITY_PHASE_1.get()), (LevelAccessor)((LevelAccessor)this.getLevel()), (BlockPos)spawnPos);
        if (integrityPhase1Entity != null) {
            integrityPhase1Entity.setNoGravity(true);
        }
        IntegrityPhase1Entity integrityPhase1Entity2 = this.integrity;
        if (integrityPhase1Entity2 != null) {
            integrityPhase1Entity2.setNoAi(true);
        }
        IntegrityPhase1Entity integrityPhase1Entity3 = this.integrity;
        if (integrityPhase1Entity3 != null) {
            integrityPhase1Entity3.setCrawlOut(true);
        }
        for (ServerPlayer player : this.getPlayers()) {
            PlayerUtil.stopAllSounds((Player)((Player)player));
            PlayerUtil.trySendCustomPacket((Player)((Player)player), (CustomPacketPayload)((CustomPacketPayload)TBSPackets.INTEGRITY_P1_MUSIC.create()));
        }
        TheBrokenScript.serverWorkQueue.add(1080L, () -> Phase1.start$lambda$0(this));
    }

    @Override
    public void tick() {
        if (this.terrainQueue.isEmpty()) {
            return;
        }
        int n = this.ticksSinceLastCorrupt;
        this.ticksSinceLastCorrupt = n + 1;
        if (this.ticksSinceLastCorrupt >= 20) {
            this.ticksSinceLastCorrupt = 0;
            Optional optional = this.blockReg.getOrCreateTag(TBSTags.TERRAIN_CORRUPT_REPLACE).getRandomElement(this.getLevel().random);
            Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getRandomElement(...)");
            Holder holder2 = (Holder)OptionalsKt.getOrNull((Optional)optional);
            if (holder2 == null) {
                return;
            }
            Holder block = holder2;
            ServerLevel serverLevel = this.getLevel();
            BlockPos blockPos = this.terrainQueue.removeFirst().finish((Level)this.getLevel());
            Object object = block.value();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"value(...)");
            serverLevel.setBlock(blockPos, BlockUtil.default((Block)((Block)object)), 3);
        }
    }

    @Override
    public void end() {
        IntegrityPhase1Entity integrityPhase1Entity = this.integrity;
        if (integrityPhase1Entity != null) {
            integrityPhase1Entity.discard();
        }
        this.integrity = null;
        Iterable $this$forEach$iv = this.trackedChords;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ChordEntity p0 = (ChordEntity)((Object)element$iv);
            boolean bl = false;
            p0.discard();
        }
        this.trackedChords.clear();
        this.terrainQueue.clear();
    }

    @Override
    public void cleanup() {
        IntegrityPhase1Entity integrityPhase1Entity = this.integrity;
        if (integrityPhase1Entity != null) {
            integrityPhase1Entity.discard();
        }
        this.integrity = null;
        Iterable $this$forEach$iv = this.trackedChords;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ChordEntity p0 = (ChordEntity)((Object)element$iv);
            boolean bl = false;
            p0.discard();
        }
        this.trackedChords.clear();
        this.terrainQueue.clear();
    }

    @Override
    public boolean getEnded() {
        return !this.hasLivingChords();
    }

    private final void spawnChords(int maxCount, float radius) {
        CollectionsKt.addAll((Collection)this.trackedChords, (Iterable)CollectionsKt.filterNotNull((Iterable)RadiusSpawnerKt.spawnRadius$default((EntityType)TBSEntities.CHORD.get(), this.getLevel(), this.getCenter().getX(), this.getCenter().getZ(), radius, 0.0f, maxCount, 0.0f, false, 192, null)));
    }

    static /* synthetic */ void spawnChords$default(Phase1 phase1, int n, float f, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 10;
        }
        if ((n2 & 2) != 0) {
            f = 10.0f;
        }
        phase1.spawnChords(n, f);
    }

    public final boolean hasLivingChords() {
        boolean bl;
        block3: {
            Iterable $this$any$iv = this.trackedChords;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    ChordEntity it = (ChordEntity)((Object)element$iv);
                    boolean bl2 = false;
                    if (!it.isAlive()) continue;
                    bl = true;
                    break block3;
                }
                bl = false;
            }
        }
        return bl || this.trackedChords.isEmpty();
    }

    private static final Unit start$lambda$0(Phase1 this$0) {
        if (!this$0.getActive()) {
            return Unit.INSTANCE;
        }
        IntegrityPhase1Entity integrityPhase1Entity = this$0.integrity;
        if (integrityPhase1Entity != null) {
            integrityPhase1Entity.setNoAi(false);
        }
        Phase1.spawnChords$default(this$0, 0, 0.0f, 3, null);
        CollectionsKt.addAll((Collection)this$0.terrainQueue, (Iterable)CollectionsKt.toMutableList((Collection)TerrainCorrupterKt.createTerrainCorruptionQueue$default((Level)this$0.getLevel(), this$0.getCenter(), 100, 0.0f, 4, null)));
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/boss/integrity/Phase1$Companion;", "", "<init>", "()V", "TERRAIN_CORRUPTION_RADIUS", "", "TERRAIN_CORRUPTION_DELAY", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

