/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.block;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J(\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0014J8\u0010\u0014\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000eH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/block/VoidFlora;", "Lnet/minecraft/world/level/block/Block;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "shape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;Lnet/minecraft/world/phys/shapes/VoxelShape;)V", "getShape", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "level", "Lnet/minecraft/world/level/BlockGetter;", "pos", "Lnet/minecraft/core/BlockPos;", "context", "Lnet/minecraft/world/phys/shapes/CollisionContext;", "canSurvive", "", "Lnet/minecraft/world/level/LevelReader;", "updateShape", "direction", "Lnet/minecraft/core/Direction;", "neighborState", "Lnet/minecraft/world/level/LevelAccessor;", "neighborPos", "thebrokenscript-common"})
public final class VoidFlora
extends Block {
    @NotNull
    private final VoxelShape shape;

    public VoidFlora(@NotNull BlockBehaviour.Properties properties, @NotNull VoxelShape shape) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        Intrinsics.checkNotNullParameter((Object)shape, (String)"shape");
        super(properties);
        this.shape = shape;
    }

    @NotNull
    protected VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Vec3 newPos = state.getOffset(level, pos);
        VoxelShape voxelShape = this.shape.move(newPos.x, newPos.y, newPos.z);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"move(...)");
        return voxelShape;
    }

    protected boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        BlockPos belowPos = pos.below();
        return level.getBlockState(belowPos).isFaceSturdy((BlockGetter)level, belowPos, Direction.UP);
    }

    @NotNull
    protected BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)direction, (String)"direction");
        Intrinsics.checkNotNullParameter((Object)neighborState, (String)"neighborState");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)neighborPos, (String)"neighborPos");
        if (direction == Direction.DOWN && !state.canSurvive((LevelReader)level, pos)) {
            BlockState blockState = Blocks.AIR.defaultBlockState();
            Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"defaultBlockState(...)");
            return blockState;
        }
        BlockState blockState = super.updateShape(state, direction, neighborState, level, pos, neighborPos);
        Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"updateShape(...)");
        return blockState;
    }
}

