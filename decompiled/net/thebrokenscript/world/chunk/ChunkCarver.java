/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.math.MathKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.core.Vec3i
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.Mth
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.thebrokenscript.brokencore.api.dsl.BlockUtil
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.ext.BoundingBoxExt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.chunk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.brokencore.api.dsl.BlockUtil;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.ext.BoundingBoxExt;
import net.thebrokenscript.registry.TBSBlocks;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bJ&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\f2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/world/chunk/ChunkCarver;", "", "<init>", "()V", "start", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "center", "Lnet/minecraft/core/Position;", "callback", "Lkotlin/Function0;", "Lnet/minecraft/core/BlockPos;", "thebrokenscript-common"})
public final class ChunkCarver {
    @NotNull
    public static final ChunkCarver INSTANCE = new ChunkCarver();

    private ChunkCarver() {
    }

    public final void start(@NotNull ServerLevel level, @NotNull Position center, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)center, (String)"center");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        BlockPos blockPos = BlockPos.containing((Position)center);
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"containing(...)");
        this.start(level, blockPos, callback);
    }

    public static /* synthetic */ void start$default(ChunkCarver chunkCarver, ServerLevel serverLevel, Position position, Function0 function0, int n, Object object) {
        if ((n & 4) != 0) {
            function0 = ChunkCarver::start$lambda$0;
        }
        chunkCarver.start(serverLevel, position, (Function0<Unit>)function0);
    }

    public final void start(@NotNull ServerLevel level, @NotNull BlockPos center, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)center, (String)"center");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        int y = level.getHeight(Heightmap.Types.MOTION_BLOCKING, center.getX(), center.getZ());
        if (y <= level.getMinBuildHeight()) {
            y = center.getY();
        }
        int scale = 4;
        int resolution = 4;
        List removed = new ArrayList();
        List outer = new ArrayList();
        List ring = new ArrayList();
        int i = 0;
        int n = scale * resolution;
        if (i <= n) {
            while (true) {
                double angle = Math.PI / (double)(scale * resolution) * (double)i;
                int x = MathKt.roundToInt((double)((double)scale * Math.cos(angle)));
                int z = MathKt.roundToInt((double)((double)scale * Math.sin(angle)));
                int x2 = MathKt.roundToInt((double)((double)scale * Math.cos(angle + Math.PI)));
                int z2 = MathKt.roundToInt((double)((double)scale * Math.sin(angle + Math.PI)));
                BlockPos pos = center.offset(x, 0, z);
                BlockPos pos2 = center.offset(x2, 0, z2);
                ((Collection)outer).add(pos);
                ((Collection)outer).add(pos2);
                BoundingBox box = BoundingBox.fromCorners((Vec3i)((Vec3i)pos), (Vec3i)((Vec3i)pos2));
                Intrinsics.checkNotNull((Object)box);
                for (BlockPos pos3 : BoundingBoxExt.INSTANCE.getPositions(box)) {
                    ((Collection)removed).add(pos3);
                }
                int rx = MathKt.roundToInt((double)((double)(scale + 1) * Math.cos(angle)));
                int rz = MathKt.roundToInt((double)((double)(scale + 1) * Math.sin(angle)));
                int rx2 = MathKt.roundToInt((double)((double)(scale + 1) * Math.cos(angle + Math.PI)));
                int rz2 = MathKt.roundToInt((double)((double)(scale + 1) * Math.sin(angle + Math.PI)));
                ((Collection)ring).add(center.offset(rx, 0, rz));
                ((Collection)ring).add(center.offset(rx2, 0, rz2));
                if (i == n) break;
                ++i;
            }
        }
        List layers = new ArrayList();
        int n2 = y;
        for (int y2 = level.getMinBuildHeight(); y2 < n2; ++y2) {
            Map layer = new LinkedHashMap();
            for (BlockPos pos : removed) {
                if (outer.contains(pos) && (double)level.random.nextFloat() < 0.25) {
                    layer.put(PositionUtil.withY((BlockPos)pos, (Number)y2), level.random.nextBoolean() ? TBSBlocks.OBSIDIAN.getDefaultState() : TBSBlocks.R_3.getDefaultState());
                    continue;
                }
                Map x2 = layer;
                BlockPos z2 = PositionUtil.withY((BlockPos)pos, (Number)y2);
                Block block = Blocks.BARRIER;
                Intrinsics.checkNotNullExpressionValue((Object)block, (String)"BARRIER");
                BlockState blockState = BlockUtil.default((Block)block);
                x2.put(z2, blockState);
            }
            for (BlockPos pos : ring) {
                layer.put(PositionUtil.withY((BlockPos)pos, (Number)y2), level.random.nextBoolean() ? TBSBlocks.OBSIDIAN.getDefaultState() : TBSBlocks.R_3.getDefaultState());
            }
            ((Collection)layers).add(layer);
        }
        CollectionsKt.reverse((List)layers);
        double totalTime = 0.0;
        Iterator iterator = ((Iterable)layers).iterator();
        int n3 = 0;
        while (iterator.hasNext()) {
            int i2 = n3++;
            Map layer = (Map)iterator.next();
            double progress = (double)i2 + 1.0 / (double)layers.size();
            double delay = Mth.lerp((double)progress, (double)2.0, (double)1.0);
            double localTime = 0.0;
            List layer2 = CollectionsKt.shuffled((Iterable)MapsKt.toList((Map)layer));
            for (Pair pair : layer2) {
                BlockPos pos = (BlockPos)pair.component1();
                BlockState state = (BlockState)pair.component2();
                TheBrokenScript.serverWorkQueue.add(MathKt.roundToLong((double)localTime), () -> ChunkCarver.start$lambda$2(level, pos, state));
                localTime += delay;
                totalTime += delay;
            }
        }
        TheBrokenScript.serverWorkQueue.add(MathKt.roundToLong((double)totalTime), callback);
    }

    public static /* synthetic */ void start$default(ChunkCarver chunkCarver, ServerLevel serverLevel, BlockPos blockPos, Function0 function0, int n, Object object) {
        if ((n & 4) != 0) {
            function0 = ChunkCarver::start$lambda$1;
        }
        chunkCarver.start(serverLevel, blockPos, (Function0<Unit>)function0);
    }

    private static final Unit start$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final Unit start$lambda$1() {
        return Unit.INSTANCE;
    }

    private static final Unit start$lambda$2(ServerLevel $level, BlockPos $pos, BlockState $state) {
        $level.setBlock($pos, $state, 2);
        return Unit.INSTANCE;
    }
}

