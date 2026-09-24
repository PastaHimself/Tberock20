/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.DirectionProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.block;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\tH\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J8\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0017H\u0014J(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0014\u00a8\u0006$"}, d2={"Lnet/thebrokenscript/block/VoidBudBlock;", "Lnet/minecraft/world/level/block/Block;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "createBlockStateDefinition", "", "builder", "Lnet/minecraft/world/level/block/state/StateDefinition$Builder;", "Lnet/minecraft/world/level/block/state/BlockState;", "getStateForPlacement", "ctx", "Lnet/minecraft/world/item/context/BlockPlaceContext;", "rotate", "state", "rotation", "Lnet/minecraft/world/level/block/Rotation;", "canSurvive", "", "level", "Lnet/minecraft/world/level/LevelReader;", "pos", "Lnet/minecraft/core/BlockPos;", "updateShape", "direction", "Lnet/minecraft/core/Direction;", "neighborState", "Lnet/minecraft/world/level/LevelAccessor;", "neighborPos", "getShape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "Lnet/minecraft/world/level/BlockGetter;", "context", "Lnet/minecraft/world/phys/shapes/CollisionContext;", "Companion", "thebrokenscript-common"})
public final class VoidBudBlock
extends Block {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final DirectionProperty FACING;
    @NotNull
    private static final VoxelShape BOX;

    public VoidBudBlock(@NotNull BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, (Comparable)Direction.UP));
    }

    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        Property[] propertyArray = new Property[]{FACING};
        builder.add(propertyArray);
    }

    @NotNull
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        Object object = this.defaultBlockState().setValue((Property)FACING, (Comparable)ctx.getClickedFace());
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"setValue(...)");
        return (BlockState)object;
    }

    @NotNull
    protected BlockState rotate(@NotNull BlockState state, @NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
        Object object = state.setValue((Property)FACING, (Comparable)rotation.rotate((Direction)state.getValue((Property)FACING)));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"setValue(...)");
        return (BlockState)object;
    }

    protected boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        BlockPos supportPos = pos.relative(((Direction)state.getValue((Property)FACING)).getOpposite());
        return level.getBlockState(supportPos).isFaceSturdy((BlockGetter)level, supportPos, (Direction)state.getValue((Property)FACING));
    }

    @NotNull
    protected BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        BlockState blockState;
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)direction, (String)"direction");
        Intrinsics.checkNotNullParameter((Object)neighborState, (String)"neighborState");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)neighborPos, (String)"neighborPos");
        if (!state.canSurvive((LevelReader)level, pos)) {
            BlockState blockState2 = Blocks.AIR.defaultBlockState();
            blockState = blockState2;
            Intrinsics.checkNotNullExpressionValue((Object)blockState2, (String)"defaultBlockState(...)");
        } else {
            BlockState blockState3 = super.updateShape(state, direction, neighborState, level, pos, neighborPos);
            blockState = blockState3;
            Intrinsics.checkNotNullExpressionValue((Object)blockState3, (String)"updateShape(...)");
        }
        return blockState;
    }

    @NotNull
    protected VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Vec3 newPos = state.getOffset(level, pos);
        VoxelShape voxelShape = BOX.move(newPos.x, newPos.y, newPos.z);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"move(...)");
        return voxelShape;
    }

    static {
        DirectionProperty directionProperty = BlockStateProperties.FACING;
        Intrinsics.checkNotNullExpressionValue((Object)directionProperty, (String)"FACING");
        FACING = directionProperty;
        VoxelShape voxelShape = Block.box((double)3.5, (double)0.0, (double)3.5, (double)12.5, (double)13.0, (double)12.5);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"box(...)");
        BOX = voxelShape;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/block/VoidBudBlock$Companion;", "", "<init>", "()V", "FACING", "Lnet/minecraft/world/level/block/state/properties/DirectionProperty;", "getFACING", "()Lnet/minecraft/world/level/block/state/properties/DirectionProperty;", "BOX", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "getBOX", "()Lnet/minecraft/world/phys/shapes/VoxelShape;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final DirectionProperty getFACING() {
            return FACING;
        }

        @NotNull
        public final VoxelShape getBOX() {
            return BOX;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

