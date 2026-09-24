/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.arguments.blocks.BlockStateParser
 *  net.minecraft.commands.arguments.blocks.BlockStateParser$BlockResult
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.HolderLookup
 *  net.minecraft.core.Vec3i
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.LevelChunk
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.xcsf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.arguments.blocks.BlockStateParser;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.thebrokenscript.brokencore.api.xcsf.PackedBlock;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR9\u0010\u000f\u001a \u0012\u0004\u0012\u00020\u0010\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00070\u00050\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0013\u0010\u000e\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/brokencore/api/xcsf/XcsfStructure;", "", "size", "Lnet/minecraft/core/Vec3i;", "data", "", "", "", "Lnet/minecraft/core/BlockPos;", "<init>", "(Lnet/minecraft/core/Vec3i;Ljava/util/Map;)V", "getSize", "()Lnet/minecraft/core/Vec3i;", "getData", "()Ljava/util/Map;", "sectionCache", "Lnet/minecraft/world/level/ChunkPos;", "", "Lnet/thebrokenscript/brokencore/api/xcsf/PackedBlock;", "getSectionCache", "sectionCache$delegate", "Lkotlin/Lazy;", "place", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "pos", "brokencore-common"})
public final class XcsfStructure {
    @NotNull
    private final Vec3i size;
    @NotNull
    private final Map<String, List<BlockPos>> data;
    @NotNull
    private final Lazy sectionCache$delegate;

    public XcsfStructure(@NotNull Vec3i size, @NotNull Map<String, ? extends List<? extends BlockPos>> data2) {
        Intrinsics.checkNotNullParameter((Object)size, (String)"size");
        Intrinsics.checkNotNullParameter(data2, (String)"data");
        this.size = size;
        this.data = data2;
        this.sectionCache$delegate = LazyKt.lazy(() -> XcsfStructure.sectionCache_delegate$lambda$0(this));
    }

    @NotNull
    public final Vec3i getSize() {
        return this.size;
    }

    @NotNull
    public final Map<String, List<BlockPos>> getData() {
        return this.data;
    }

    @NotNull
    public final Map<ChunkPos, Map<Integer, List<PackedBlock>>> getSectionCache() {
        Lazy lazy = this.sectionCache$delegate;
        return (Map)lazy.getValue();
    }

    public final void place(@NotNull ServerLevel level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        HashSet<ChunkPos> chunks = new HashSet<ChunkPos>();
        for (Map.Entry<String, List<BlockPos>> entry : this.data.entrySet()) {
            String stateDef = entry.getKey();
            List<BlockPos> targets = entry.getValue();
            HolderLookup lookup = level.holderLookup(Registries.BLOCK);
            BlockStateParser.BlockResult stateResult = BlockStateParser.parseForBlock((HolderLookup)lookup, (String)stateDef, (boolean)true);
            BlockState state = stateResult.blockState();
            for (BlockPos target : targets) {
                BlockPos real = pos.offset((Vec3i)target);
                if (chunks.add(new ChunkPos(real))) {
                    level.getChunkAt(real);
                }
                level.setBlock(real, state, 4, 0);
            }
        }
        Iterator iterator = chunks.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator, (String)"iterator(...)");
        Iterator<Map.Entry<String, List<Object>>> iterator2 = iterator;
        while (iterator2.hasNext()) {
            Map.Entry<String, List<Object>> entry = iterator2.next();
            Intrinsics.checkNotNullExpressionValue(entry, (String)"next(...)");
            ChunkPos chunk = (ChunkPos)entry;
            LevelChunk real = level.getChunk(chunk.x, chunk.z);
            level.getServer().execute(() -> XcsfStructure.place$lambda$0(level, chunk, real));
        }
    }

    private static final Map sectionCache_delegate$lambda$0(XcsfStructure this$0) {
        Map map = new LinkedHashMap();
        for (Map.Entry<String, List<BlockPos>> entry : this$0.data.entrySet()) {
            String stateDef = entry.getKey();
            List<BlockPos> targets = entry.getValue();
            for (BlockPos pos : targets) {
                List sectionList;
                Map chunkMap;
                ChunkPos chunkPos = new ChunkPos(pos.getX() >> 4, pos.getZ() >> 4);
                int sectionIdx = pos.getY() >> 4;
                Intrinsics.checkNotNullExpressionValue((Object)map.computeIfAbsent(chunkPos, arg_0 -> XcsfStructure.sectionCache_delegate$lambda$0$1(XcsfStructure::sectionCache_delegate$lambda$0$0, arg_0)), (String)"computeIfAbsent(...)");
                Intrinsics.checkNotNullExpressionValue((Object)chunkMap.computeIfAbsent(sectionIdx, arg_0 -> XcsfStructure.sectionCache_delegate$lambda$0$3(XcsfStructure::sectionCache_delegate$lambda$0$2, arg_0)), (String)"computeIfAbsent(...)");
                sectionList.add(new PackedBlock(pos.getX() & 0xF, pos.getY() & 0xF, pos.getZ() & 0xF, stateDef));
            }
        }
        return map;
    }

    private static final Map sectionCache_delegate$lambda$0$0(ChunkPos it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new LinkedHashMap();
    }

    private static final Map sectionCache_delegate$lambda$0$1(Function1 $tmp0, Object p0) {
        return (Map)$tmp0.invoke(p0);
    }

    private static final List sectionCache_delegate$lambda$0$2(Integer it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new ArrayList();
    }

    private static final List sectionCache_delegate$lambda$0$3(Function1 $tmp0, Object p0) {
        return (List)$tmp0.invoke(p0);
    }

    private static final void place$lambda$0(ServerLevel $level, ChunkPos $chunk, LevelChunk $real) {
        $level.getLightEngine().propagateLightSources($chunk);
        for (ServerPlayer player : $level.getChunkSource().chunkMap.getPlayers($chunk, false)) {
            player.connection.chunkSender.markChunkPendingToSend($real);
        }
    }
}

