/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.LevelUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.boss.integrity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.boss.integrity.Arena;
import net.thebrokenscript.boss.integrity.ArenaPhase;
import net.thebrokenscript.boss.integrity.Phase;
import net.thebrokenscript.boss.integrity.Phase2Floors;
import net.thebrokenscript.boss.integrity.Stage2Floor;
import net.thebrokenscript.boss.integrity.Stage2Util;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.LevelUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.entity.boss.TetherEntity;
import net.thebrokenscript.entity.integrity.phase2.IntegrityPhase2Entity;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSPackets;
import net.thebrokenscript.world.dimension.boss.stage2.Stage2Generator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u001fH\u0016J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u0010+\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*2\u0006\u0010,\u001a\u00020\nH\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J\u000e\u0010.\u001a\u0004\u0018\u00010\n*\u00020/H\u0002J$\u00100\u001a\u00020%*\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u0010,\u001a\u00020\bH\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010$\u001a\u00020%X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'\u00a8\u00065"}, d2={"Lnet/thebrokenscript/boss/integrity/Phase2;", "Lnet/thebrokenscript/boss/integrity/Phase;", "arena", "Lnet/thebrokenscript/boss/integrity/Arena;", "<init>", "(Lnet/thebrokenscript/boss/integrity/Arena;)V", "spawnedFloors", "", "Lnet/thebrokenscript/boss/integrity/Stage2Floor;", "integrityLocation", "Lnet/thebrokenscript/boss/integrity/Phase2Floors;", "getIntegrityLocation$thebrokenscript_common", "()Lnet/thebrokenscript/boss/integrity/Phase2Floors;", "setIntegrityLocation$thebrokenscript_common", "(Lnet/thebrokenscript/boss/integrity/Phase2Floors;)V", "integrity", "Lnet/thebrokenscript/entity/integrity/phase2/IntegrityPhase2Entity;", "getIntegrity", "()Lnet/thebrokenscript/entity/integrity/phase2/IntegrityPhase2Entity;", "setIntegrity", "(Lnet/thebrokenscript/entity/integrity/phase2/IntegrityPhase2Entity;)V", "id", "Lnet/thebrokenscript/boss/integrity/ArenaPhase;", "getId", "()Lnet/thebrokenscript/boss/integrity/ArenaPhase;", "dimension", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/world/level/Level;", "getDimension", "()Lnet/minecraft/resources/ResourceKey;", "start", "", "tick", "end", "cleanup", "reset", "ended", "", "getEnded", "()Z", "checkFloorSpawns", "player", "Lnet/minecraft/server/level/ServerPlayer;", "teleportIntegrityTo", "floor", "resetStage2Generator", "getFloor", "Lnet/minecraft/world/entity/player/Player;", "hasTetherOnFloor", "Lnet/minecraft/server/level/ServerLevel;", "cellChunkX", "", "cellChunkZ", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nPhase2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Phase2.kt\nnet/thebrokenscript/boss/integrity/Phase2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,150:1\n1869#2,2:151\n774#2:153\n865#2,2:154\n1869#2,2:156\n774#2:158\n865#2,2:159\n2423#2,14:161\n*S KotlinDebug\n*F\n+ 1 Phase2.kt\nnet/thebrokenscript/boss/integrity/Phase2\n*L\n56#1:151,2\n60#1:153\n60#1:154,2\n65#1:156,2\n70#1:158\n70#1:159,2\n70#1:161,14\n*E\n"})
public final class Phase2
extends Phase {
    @NotNull
    private final Set<Stage2Floor> spawnedFloors;
    @Nullable
    private Phase2Floors integrityLocation;
    @Nullable
    private IntegrityPhase2Entity integrity;
    @NotNull
    private final ArenaPhase id;
    @NotNull
    private final ResourceKey<Level> dimension;
    private final boolean ended;

    public Phase2(@NotNull Arena arena) {
        Intrinsics.checkNotNullParameter((Object)arena, (String)"arena");
        super(arena);
        this.spawnedFloors = new LinkedHashSet();
        this.id = ArenaPhase.Phase2;
        this.dimension = TBSDimensions.STAGE2;
    }

    @Nullable
    public final Phase2Floors getIntegrityLocation$thebrokenscript_common() {
        return this.integrityLocation;
    }

    public final void setIntegrityLocation$thebrokenscript_common(@Nullable Phase2Floors phase2Floors) {
        this.integrityLocation = phase2Floors;
    }

    @Nullable
    public final IntegrityPhase2Entity getIntegrity() {
        return this.integrity;
    }

    public final void setIntegrity(@Nullable IntegrityPhase2Entity integrityPhase2Entity) {
        this.integrity = integrityPhase2Entity;
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
        for (ServerPlayer player : this.getPlayers()) {
            PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)Phase2::start$lambda$0));
            PlayerUtil.stopAllSounds((Player)((Player)player));
            PlayerUtil.trySendCustomPacket((Player)((Player)player), (CustomPacketPayload)((CustomPacketPayload)TBSPackets.INTEGRITY_P2_MUSIC.create()));
        }
        LevelUtil.getQueue((Level)((Level)this.getLevel())).add(20L, () -> Phase2.start$lambda$1(this));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void tick() {
        Object v1;
        void $this$filterTo$iv$iv;
        Iterator $this$filterTo$iv$iv2;
        Object element$iv2;
        Iterable $this$forEach$iv = this.getPlayers();
        boolean $i$f$forEach = false;
        for (Object element$iv2 : $this$forEach$iv) {
            ServerPlayer player = (ServerPlayer)element$iv2;
            boolean bl = false;
            this.checkFloorSpawns(player);
        }
        Iterable $this$filter$iv = this.getPlayers();
        boolean $i$f$filter = false;
        element$iv2 = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        Iterator iterator = $this$filterTo$iv$iv2.iterator();
        while (iterator.hasNext()) {
            Object element$iv$iv = iterator.next();
            ServerPlayer it = (ServerPlayer)element$iv$iv;
            boolean bl = false;
            int n = it.getBlockY();
            boolean bl2 = 190 <= n ? n < 199 : false;
            if (!bl2) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List tpPlayers = (List)destination$iv$iv;
        if (!((Collection)tpPlayers).isEmpty()) {
            Iterable $this$forEach$iv2 = tpPlayers;
            boolean $i$f$forEach2 = false;
            for (Object element$iv3 : $this$forEach$iv2) {
                ServerPlayer player = (ServerPlayer)element$iv3;
                boolean bl = false;
                EntityUtil.teleport((Entity)((Entity)player), (Vec3)new Vec3(85.5, 162.5, 87.5));
            }
        }
        Iterable $this$filter$iv2 = this.getPlayers();
        boolean $i$f$filter2 = false;
        Iterable player = $this$filter$iv2;
        Collection destination$iv$iv2 = new ArrayList();
        boolean $i$f$filterTo2 = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            ServerPlayer it = (ServerPlayer)element$iv$iv;
            boolean bl = false;
            if (!(it.getBlockY() > 103)) continue;
            destination$iv$iv2.add(element$iv$iv);
        }
        Iterable $this$minByOrNull$iv = (List)destination$iv$iv2;
        boolean $i$f$minByOrNull = false;
        Iterator iterator$iv = $this$minByOrNull$iv.iterator();
        if (!iterator$iv.hasNext()) {
            v1 = null;
        } else {
            Object minElem$iv = iterator$iv.next();
            if (!iterator$iv.hasNext()) {
                v1 = minElem$iv;
            } else {
                ServerPlayer it = (ServerPlayer)minElem$iv;
                boolean bl = false;
                int minValue$iv = it.getBlockY();
                do {
                    Object e$iv = iterator$iv.next();
                    ServerPlayer it2 = (ServerPlayer)e$iv;
                    $i$a$-minByOrNull-Phase2$tick$lowestPlayer$2 = false;
                    int v$iv = it2.getBlockY();
                    if (minValue$iv <= v$iv) continue;
                    minElem$iv = e$iv;
                    minValue$iv = v$iv;
                } while (iterator$iv.hasNext());
                v1 = minElem$iv;
            }
        }
        ServerPlayer serverPlayer = v1;
        if (serverPlayer == null) {
            return;
        }
        ServerPlayer lowestPlayer = serverPlayer;
        Phase2Floors phase2Floors = this.getFloor((Player)lowestPlayer);
        if (phase2Floors == null) {
            return;
        }
        Phase2Floors targetFloor = phase2Floors;
        if (this.integrity == null) {
            return;
        }
        if (this.integrityLocation != targetFloor) {
            Stage2Floor stage2Floor = targetFloor.getStage2Floor();
            boolean needsTether = stage2Floor.getSpawns().contains(TBSEntities.TETHER);
            int cellChunkX = Math.floorDiv(Stage2Util.getCenterOfExistingGeneration((Player)lowestPlayer).getX() >> 4, 10) * 10;
            int cellChunkZ = Math.floorDiv(Stage2Util.getCenterOfExistingGeneration((Player)lowestPlayer).getZ() >> 4, 10) * 10;
            if (needsTether && !this.hasTetherOnFloor(this.getLevel(), cellChunkX, cellChunkZ, stage2Floor)) {
                return;
            }
            this.teleportIntegrityTo(lowestPlayer, targetFloor);
        }
    }

    @Override
    public void end() {
    }

    @Override
    public void cleanup() {
    }

    @Override
    public void reset() {
        this.resetStage2Generator();
        this.integrityLocation = null;
    }

    @Override
    public boolean getEnded() {
        return this.ended;
    }

    private final void checkFloorSpawns(ServerPlayer player) {
        if (!Intrinsics.areEqual((Object)player.serverLevel(), (Object)this.getLevel())) {
            return;
        }
        if (PlayerExt.INSTANCE.getVars((Player)player).getLoadingPhase2()) {
            return;
        }
        Stage2Floor stage2Floor = Stage2Floor.Companion.fromY(player.getBlockY());
        if (stage2Floor == null) {
            return;
        }
        Stage2Floor floor = stage2Floor;
        if (floor == Stage2Floor.FLOOR_7 && this.integrity == null) {
            return;
        }
        if (this.spawnedFloors.contains((Object)floor)) {
            return;
        }
        ((Collection)this.spawnedFloors).add(floor);
        Stage2Util.INSTANCE.spawnFloorEntities(this.getLevel(), player, floor);
    }

    private final void teleportIntegrityTo(ServerPlayer player, Phase2Floors floor) {
        IntegrityPhase2Entity integrityPhase2Entity = this.integrity;
        if (integrityPhase2Entity == null) {
            return;
        }
        IntegrityPhase2Entity entity = integrityPhase2Entity;
        BlockPos blockPos = Stage2Util.getRandomFloorPos$default(Stage2Util.INSTANCE, this.getLevel(), player, floor.getStage2Floor(), (BaseMonster)entity, 0, 8, null);
        if (blockPos == null) {
            return;
        }
        BlockPos pos = blockPos;
        this.integrityLocation = floor;
        Entity entity2 = (Entity)entity;
        Vec3 vec3 = pos.getCenter();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
        EntityUtil.teleport((Entity)entity2, (Vec3)vec3);
    }

    private final void resetStage2Generator() {
        block1: {
            ServerLevel serverLevel = this.getLevel().getServer().getLevel(TBSDimensions.STAGE2);
            if (serverLevel == null) {
                return;
            }
            ServerLevel level = serverLevel;
            ChunkGenerator chunkGenerator = level.getChunkSource().getGenerator();
            Stage2Generator stage2Generator = chunkGenerator instanceof Stage2Generator ? (Stage2Generator)chunkGenerator : null;
            if (stage2Generator == null) break block1;
            stage2Generator.resetOccupancy();
        }
    }

    private final Phase2Floors getFloor(Player $this$getFloor) {
        return Phase2Floors.Companion.fromY($this$getFloor.getBlockY());
    }

    private final boolean hasTetherOnFloor(ServerLevel $this$hasTetherOnFloor, int cellChunkX, int cellChunkZ, Stage2Floor floor) {
        double minX = cellChunkX << 4;
        double minZ = cellChunkZ << 4;
        double maxX = minX + (double)160;
        double maxZ = minZ + (double)160;
        double minY = RangesKt.coerceAtLeast((int)floor.getYLevels().getFirst(), (int)$this$hasTetherOnFloor.getMinBuildHeight());
        double maxY = RangesKt.coerceAtMost((int)(floor.getYLevels().getLast() + 1), (int)$this$hasTetherOnFloor.getMaxBuildHeight());
        AABB aabb = new AABB(minX, minY, minZ, maxX, maxY, maxZ);
        List list = $this$hasTetherOnFloor.getEntitiesOfClass(TetherEntity.class, aabb, arg_0 -> Phase2.hasTetherOnFloor$lambda$1(Phase2::hasTetherOnFloor$lambda$0, arg_0));
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getEntitiesOfClass(...)");
        return !((Collection)list).isEmpty();
    }

    private static final Unit start$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setLoadingPhase2(true);
        $this$updateVars.setEnableCustomSky(false);
        return Unit.INSTANCE;
    }

    private static final Unit start$lambda$1(Phase2 this$0) {
        for (ServerPlayer player : this$0.getPlayers()) {
            PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)Phase2::start$lambda$1$0));
            PlayerUtil.sendTo((Player)((Player)player), TBSDimensions.STAGE2);
        }
        return Unit.INSTANCE;
    }

    private static final Unit start$lambda$1$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setFixPos(true);
        return Unit.INSTANCE;
    }

    private static final boolean hasTetherOnFloor$lambda$0(TetherEntity it) {
        return it.isAlive();
    }

    private static final boolean hasTetherOnFloor$lambda$1(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }
}

