/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.IntProgression
 *  kotlin.ranges.RangesKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.TickTask
 *  net.minecraft.server.level.DistanceManager
 *  net.minecraft.server.level.ServerChunkCache
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.server.level.TicketType
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.GameRules
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.EntityBlock
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.chunk.LevelChunk
 *  net.minecraft.world.level.chunk.LevelChunkSection
 *  net.minecraft.world.level.levelgen.Heightmap
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.AABB
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.world;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.DistanceManager;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import net.thebrokenscript.brokencore.impl.mixin.features.chunkremover.ChunkAccessAccessor;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/world/ChunkUtil;", "", "<init>", "()V", "moveChunkUp", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "blockX", "", "blockZ", "offsetY", "recalcHeightmaps", "chunk", "Lnet/minecraft/world/level/chunk/LevelChunk;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nChunkUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChunkUtil.kt\nnet/thebrokenscript/brokencore/api/world/ChunkUtil\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,203:1\n478#2:204\n424#2:205\n1252#3,4:206\n1869#3,2:212\n216#4,2:210\n*S KotlinDebug\n*F\n+ 1 ChunkUtil.kt\nnet/thebrokenscript/brokencore/api/world/ChunkUtil\n*L\n40#1:204\n40#1:205\n40#1:206,4\n145#1:212,2\n135#1:210,2\n*E\n"})
public final class ChunkUtil {
    @NotNull
    public static final ChunkUtil INSTANCE = new ChunkUtil();

    private ChunkUtil() {
    }

    /*
     * WARNING - void declaration
     */
    public final void moveChunkUp(@NotNull ServerLevel level, int blockX, int blockZ, int offsetY) {
        BlockPos newPos;
        void var13_22;
        int i;
        void $this$associateByTo$iv$iv$iv;
        void $this$mapKeysTo$iv$iv;
        void $this$mapKeys$iv;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        if (BCConfigs.INSTANCE.getServer().getDisableChunkRemoval()) {
            return;
        }
        if (!(offsetY % 16 == 0)) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        int chunkX = blockX >> 4;
        int chunkZ = blockZ >> 4;
        LevelChunk levelChunk = level.getChunk(chunkX, chunkZ);
        Intrinsics.checkNotNull((Object)levelChunk, (String)"null cannot be cast to non-null type net.minecraft.world.level.chunk.LevelChunk");
        LevelChunk chunk = levelChunk;
        int sectionOffset = offsetY >> 4;
        Map map = chunk.getBlockEntities();
        Intrinsics.checkNotNullExpressionValue((Object)map, (String)"getBlockEntities(...)");
        Map map2 = map;
        boolean $i$f$mapKeys = false;
        void var12_13 = $this$mapKeys$iv;
        Map map3 = new LinkedHashMap(MapsKt.mapCapacity((int)$this$mapKeys$iv.size()));
        boolean $i$f$mapKeysTo = false;
        Iterable iterable = $this$mapKeysTo$iv$iv.entrySet();
        Map destination$iv$iv$iv = map3;
        int $i$f$associateByTo = 0;
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            void it$iv$iv;
            Object it;
            Map.Entry entry = (Map.Entry)element$iv$iv$iv;
            Map map4 = destination$iv$iv$iv;
            boolean bl = false;
            Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
            BlockPos blockPos = ((BlockPos)it.getKey()).immutable();
            Map map5 = map4;
            boolean bl2 = false;
            it = it$iv$iv.getValue();
            map5.put(blockPos, it);
        }
        Map oldBlockEntities = destination$iv$iv$iv;
        chunk.clearAllBlockEntities();
        Registry biomes = level.registryAccess().registryOrThrow(Registries.BIOME);
        LevelChunkSection[] newSections = new LevelChunkSection[chunk.getSections().length];
        int n = chunk.getSections().length;
        for (i = 0; i < n; ++i) {
            LevelChunkSection old;
            if (chunk.getSections()[i] == null) continue;
            int newIndex = i + sectionOffset;
            boolean bl = 0 <= newIndex ? newIndex < newSections.length : false;
            if (!bl) continue;
            newSections[newIndex] = old;
        }
        int n2 = newSections.length;
        for (i = 0; i < n2; ++i) {
            if (newSections[i] != null) continue;
            newSections[i] = new LevelChunkSection(biomes);
        }
        int n3 = chunk.getSections().length;
        for (int i2 = 0; i2 < n3; ++i2) {
            chunk.getSections()[i2] = newSections[i2];
        }
        LevelChunkSection[] levelChunkSectionArray = chunk.getSections();
        Intrinsics.checkNotNullExpressionValue((Object)levelChunkSectionArray, (String)"getSections(...)");
        LevelChunkSection[] i2 = levelChunkSectionArray;
        boolean bl = false;
        int old = i2.length;
        while (var13_22 < old) {
            LevelChunkSection section;
            LevelChunkSection levelChunkSection = section = i2[var13_22];
            if (levelChunkSection != null) {
                levelChunkSection.recalcBlockCounts();
            }
            ++var13_22;
        }
        for (Map.Entry entry : oldBlockEntities.entrySet()) {
            BlockEntity newBe;
            Block block2;
            BlockState state;
            BlockPos oldPos = (BlockPos)entry.getKey();
            BlockEntity oldBe = (BlockEntity)entry.getValue();
            newPos = oldPos.offset(0, offsetY, 0);
            $i$f$associateByTo = level.getMinBuildHeight();
            int n4 = level.getMaxBuildHeight();
            int element$iv$iv$iv = newPos.getY();
            boolean bl2 = $i$f$associateByTo <= element$iv$iv$iv ? element$iv$iv$iv < n4 : false;
            if (!bl2 || !(state = chunk.getBlockState(newPos)).hasBlockEntity() || !((block2 = state.getBlock()) instanceof EntityBlock) || ((EntityBlock)block2).newBlockEntity(newPos, state) == null) continue;
            CompoundTag tag = oldBe.saveWithFullMetadata((HolderLookup.Provider)level.registryAccess());
            tag.putInt("x", newPos.getX());
            tag.putInt("y", newPos.getY());
            tag.putInt("z", newPos.getZ());
            newBe.loadWithComponents(tag, (HolderLookup.Provider)level.registryAccess());
            chunk.setBlockEntity(newBe);
            level.setBlockEntity(newBe);
        }
        this.recalcHeightmaps(chunk);
        chunk.setLightCorrect(false);
        int baseX = chunk.getPos().x << 4;
        int n5 = chunk.getPos().z << 4;
        for (int x = 0; x < 16; ++x) {
            block7: for (int z = 0; z < 16; ++z) {
                newPos = RangesKt.step((IntProgression)((IntProgression)RangesKt.until((int)level.getMinBuildHeight(), (int)level.getMaxBuildHeight())), (int)16);
                int y = newPos.getFirst();
                int block2 = newPos.getLast();
                int newBe = newPos.getStep();
                if ((newBe <= 0 || y > block2) && (newBe >= 0 || block2 > y)) continue;
                while (true) {
                    level.getLightEngine().checkBlock(new BlockPos(baseX + x, y, n5 + z));
                    if (y == block2) continue block7;
                    y += newBe;
                }
            }
        }
        chunk.setUnsaved(true);
        ChunkPos chunkPosObj = chunk.getPos();
        ServerChunkCache serverChunkCache = level.getChunkSource();
        Intrinsics.checkNotNull((Object)serverChunkCache, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerChunkCache");
        ServerChunkCache chunkCache = serverChunkCache;
        DistanceManager distanceManager = chunkCache.chunkMap.getDistanceManager();
        distanceManager.removeTicket(TicketType.PLAYER, chunkPosObj, 0, (Object)chunkPosObj);
        level.getServer().tell((Runnable)new TickTask(level.getServer().getTickCount() + 2, () -> ChunkUtil.moveChunkUp$lambda$1(level, chunkPosObj, chunk)));
        int ticking = level.getGameRules().getInt(GameRules.RULE_RANDOMTICKING);
        level.tickChunk(chunk, ticking);
        AABB chunkBounds = new AABB((double)baseX, (double)level.getMinBuildHeight(), (double)n5, (double)(baseX + 16), (double)level.getMaxBuildHeight(), (double)(n5 + 16));
        List entities = level.getEntities(null, chunkBounds);
        for (Entity entity : entities) {
            double newY = entity.getY() + (double)offsetY;
            if (!(newY >= (double)level.getMinBuildHeight()) || !(newY < (double)level.getMaxBuildHeight())) continue;
            entity.teleportTo(entity.getX(), newY, entity.getZ());
        }
        for (int x = 0; x < 16; ++x) {
            for (int z = 0; z < 16; ++z) {
                int n6 = level.getMaxBuildHeight();
                for (int y = level.getMinBuildHeight(); y < n6; ++y) {
                    BlockPos pos = new BlockPos(baseX + x, y, n5 + z);
                    BlockState state = chunk.getBlockState(pos);
                    if (state.isAir()) continue;
                    state.tick(level, pos, level.random);
                    level.updateNeighborsAt(pos, state.getBlock());
                    level.updateNeighbourForOutputSignal(pos, state.getBlock());
                }
            }
        }
    }

    private final void recalcHeightmaps(LevelChunk chunk) {
        Intrinsics.checkNotNull((Object)chunk, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.impl.mixin.features.chunkremover.ChunkAccessAccessor");
        Map<Heightmap.Types, Heightmap> heightmaps = ((ChunkAccessAccessor)chunk).brokencore_getHeightmaps();
        for (Heightmap.Types type : heightmaps.keySet()) {
            Intrinsics.checkNotNull(heightmaps);
            heightmaps.put(type, new Heightmap((ChunkAccess)chunk, type));
        }
    }

    private static final void moveChunkUp$lambda$1(ServerLevel $level, ChunkPos $chunkPosObj, LevelChunk $chunk) {
        try {
            Map records;
            Class<?> trackingClass = Class.forName("qouteall.imm_ptl.core.chunk_loading.ImmPtlChunkTracking");
            Class<?> playerChunkLoadingClass = Class.forName("qouteall.imm_ptl.core.chunk_loading.PlayerChunkLoading");
            Class<?> watchRecordClass = Class.forName("qouteall.imm_ptl.core.chunk_loading.ImmPtlChunkTracking$PlayerWatchRecord");
            Class[] classArray = new Class[]{ResourceKey.class, Integer.TYPE, Integer.TYPE};
            Method getWatchRecord = trackingClass.getMethod("getWatchRecordForChunk", classArray);
            Class[] classArray2 = new Class[]{ServerPlayer.class};
            Method getPlayerInfo = trackingClass.getMethod("getPlayerInfo", classArray2);
            Class[] classArray3 = new Class[]{watchRecordClass};
            Method markPendingLoading = playerChunkLoadingClass.getMethod("markPendingLoading", classArray3);
            Class[] classArray4 = new Class[]{ServerPlayer.class};
            Method doChunkSending = playerChunkLoadingClass.getMethod("doChunkSending", classArray4);
            Object[] objectArray = new Object[]{$level.dimension(), $chunkPosObj.x, $chunkPosObj.z};
            Object object = getWatchRecord.invoke(null, objectArray);
            Map map = records = object instanceof Map ? (Map)object : null;
            if (map != null) {
                Map $this$forEach$iv = map;
                boolean $i$f$forEach = false;
                Iterator iterator = $this$forEach$iv.entrySet().iterator();
                while (iterator.hasNext()) {
                    Field field;
                    Map.Entry element$iv;
                    Map.Entry entry = element$iv = iterator.next();
                    boolean bl = false;
                    ServerPlayer player = (ServerPlayer)entry.getKey();
                    Object record = entry.getValue();
                    Field it = field = record.getClass().getDeclaredField("isLoadedToPlayer");
                    boolean bl2 = false;
                    it.setAccessible(true);
                    it.set(record, false);
                    Object[] objectArray2 = new Object[]{player};
                    Object playerInfo = getPlayerInfo.invoke(null, objectArray2);
                    objectArray2 = new Object[]{record};
                    markPendingLoading.invoke(playerInfo, objectArray2);
                    objectArray2 = new Object[]{player};
                    doChunkSending.invoke(playerInfo, objectArray2);
                }
            }
        }
        catch (Exception playerChunkLoadingClass) {
            // empty catch block
        }
        List list = $level.players();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"players(...)");
        Iterable $this$forEach$iv = list;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerPlayer player = (ServerPlayer)element$iv;
            boolean bl = false;
            if (!player.getChunkTrackingView().isInViewDistance($chunkPosObj.x, $chunkPosObj.z)) continue;
            player.connection.send((Packet)new ClientboundLevelChunkWithLightPacket($chunk, $level.getLightEngine(), null, null));
        }
    }
}

