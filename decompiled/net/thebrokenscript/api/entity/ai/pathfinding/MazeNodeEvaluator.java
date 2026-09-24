/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.level.pathfinder.PathfindingContext
 *  net.minecraft.world.level.pathfinder.WalkNodeEvaluator
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.ai.pathfinding;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.PathfindingContext;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/api/entity/ai/pathfinding/MazeNodeEvaluator;", "Lnet/minecraft/world/level/pathfinder/WalkNodeEvaluator;", "<init>", "()V", "getPathType", "Lnet/minecraft/world/level/pathfinder/PathType;", "level", "Lnet/minecraft/world/level/pathfinder/PathfindingContext;", "x", "", "y", "z", "thebrokenscript-common"})
public final class MazeNodeEvaluator
extends WalkNodeEvaluator {
    @NotNull
    public PathType getPathType(@NotNull PathfindingContext level, int x, int y, int z) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        BlockPos pos = new BlockPos(x, y, z);
        BlockState blockState = level.getBlockState(pos);
        FluidState fluidState = blockState.getFluidState();
        if (!fluidState.isEmpty()) {
            return PathType.WATER;
        }
        PathType pathType = super.getPathType(level, x, y, z);
        Intrinsics.checkNotNullExpressionValue((Object)pathType, (String)"getPathType(...)");
        return pathType;
    }
}

