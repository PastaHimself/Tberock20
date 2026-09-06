/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.CarpetBlock
 *  net.minecraft.world.level.block.FenceBlock
 *  net.minecraft.world.level.block.PressurePlateBlock
 *  net.minecraft.world.level.block.WallBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.learner.room_poi.scanner;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.learner.room_poi.RoomPoi;
import net.thebrokenscript.brokencore.api.learner.room_poi.scanner.RoomPoiScanner;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ8\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0011j\b\u0012\u0004\u0012\u00020\u0007`\u0012H\u0016\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/room_poi/scanner/SimpleTablePoiScanner;", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/scanner/RoomPoiScanner;", "<init>", "()V", "trigger", "", "blockPos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "level", "Lnet/minecraft/world/level/Level;", "isPost", "isTableTop", "scan", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/RoomPoi;", "skipPositions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "brokencore-common"})
public final class SimpleTablePoiScanner
extends RoomPoiScanner {
    @NotNull
    public static final SimpleTablePoiScanner INSTANCE = new SimpleTablePoiScanner();

    private SimpleTablePoiScanner() {
    }

    @Override
    public boolean trigger(@NotNull BlockPos blockPos, @NotNull BlockState state, @NotNull Level level) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        if (this.isPost(state)) {
            BlockState blockState = level.getBlockState(blockPos.offset(0, 1, 0));
            Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"getBlockState(...)");
            bl = this.isTableTop(blockState);
        } else if (this.isTableTop(state)) {
            BlockState blockState = level.getBlockState(blockPos.offset(0, 1, 0));
            Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"getBlockState(...)");
            bl = this.isPost(blockState);
        } else {
            bl = false;
        }
        return bl;
    }

    public final boolean isPost(@NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return state.getBlock() instanceof FenceBlock || state.getBlock() instanceof WallBlock;
    }

    public final boolean isTableTop(@NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Block block2 = state.getBlock();
        return block2 instanceof CarpetBlock || block2 instanceof PressurePlateBlock;
    }

    @Override
    @NotNull
    public RoomPoi scan(@NotNull BlockPos blockPos, @NotNull BlockState state, @NotNull Level level, @NotNull HashSet<BlockPos> skipPositions) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(skipPositions, (String)"skipPositions");
        int minY = this.isTableTop(state) ? -1 : 0;
        int maxY = this.isPost(state) ? 2 : 0;
        AABB aabb = new AABB((double)blockPos.getX(), (double)blockPos.getY() + (double)minY, (double)blockPos.getZ(), (double)blockPos.getX() + 1.0, (double)blockPos.getY() + (double)maxY, (double)blockPos.getZ() + 1.0);
        VoxelShape shape = Shapes.create((double)blockPos.getX(), (double)((double)blockPos.getY() + (double)minY), (double)blockPos.getZ(), (double)((double)blockPos.getX() + 1.0), (double)((double)blockPos.getY() + (double)maxY), (double)((double)blockPos.getZ() + 1.0));
        skipPositions.add(new BlockPos(blockPos.getX(), blockPos.getY() + minY, blockPos.getZ()));
        skipPositions.add(new BlockPos(blockPos.getX(), blockPos.getY() + maxY, blockPos.getZ()));
        Intrinsics.checkNotNull((Object)shape);
        BlockPos blockPos2 = blockPos.offset(0, minY, 0);
        Intrinsics.checkNotNullExpressionValue((Object)blockPos2, (String)"offset(...)");
        return new RoomPoi(shape, blockPos2, "table");
    }
}

