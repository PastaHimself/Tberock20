/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.DirectionProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.block;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u0015H\u0014J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0014\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/block/NameMissingBlock;", "Lnet/minecraft/world/level/block/Block;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "createBlockStateDefinition", "", "builder", "Lnet/minecraft/world/level/block/state/StateDefinition$Builder;", "Lnet/minecraft/world/level/block/state/BlockState;", "getStateForPlacement", "context", "Lnet/minecraft/world/item/context/BlockPlaceContext;", "getShape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "state", "level", "Lnet/minecraft/world/level/BlockGetter;", "pos", "Lnet/minecraft/core/BlockPos;", "Lnet/minecraft/world/phys/shapes/CollisionContext;", "rotate", "rotation", "Lnet/minecraft/world/level/block/Rotation;", "Companion", "thebrokenscript-common"})
public final class NameMissingBlock
extends Block {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final double MIN = 2.0;
    private static final double MAX = 14.0;
    @NotNull
    private static final VoxelShape UP_AABB;
    @NotNull
    private static final VoxelShape DOWN_AABB;
    @NotNull
    private static final VoxelShape WEST_AABB;
    @NotNull
    private static final VoxelShape EAST_AABB;
    @NotNull
    private static final VoxelShape NORTH_AABB;
    @NotNull
    private static final VoxelShape SOUTH_AABB;
    @NotNull
    private static final DirectionProperty FACE;

    public NameMissingBlock(@NotNull BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
        this.registerDefaultState((BlockState)this.defaultBlockState().setValue((Property)FACE, (Comparable)Direction.DOWN));
    }

    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        super.createBlockStateDefinition(builder);
        Property[] propertyArray = new Property[]{FACE};
        builder.add(propertyArray);
    }

    @NotNull
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Object object = this.defaultBlockState().setValue((Property)FACE, (Comparable)context.getClickedFace());
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"setValue(...)");
        return (BlockState)object;
    }

    @NotNull
    protected VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Direction direction = ((Direction)state.getValue((Property)FACE)).getOpposite();
        return switch (direction == null ? -1 : WhenMappings.$EnumSwitchMapping$0[direction.ordinal()]) {
            case 1 -> UP_AABB;
            case 2 -> DOWN_AABB;
            case 3 -> NORTH_AABB;
            case 4 -> SOUTH_AABB;
            case 5 -> EAST_AABB;
            case 6 -> WEST_AABB;
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    @NotNull
    protected BlockState rotate(@NotNull BlockState state, @NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
        Object object = state.setValue((Property)FACE, (Comparable)rotation.rotate((Direction)state.getValue((Property)FACE)));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"setValue(...)");
        return (BlockState)object;
    }

    static {
        VoxelShape voxelShape = Block.box((double)0.0, (double)14.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"box(...)");
        UP_AABB = voxelShape;
        VoxelShape voxelShape2 = Block.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)2.0, (double)16.0);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape2, (String)"box(...)");
        DOWN_AABB = voxelShape2;
        VoxelShape voxelShape3 = Block.box((double)0.0, (double)0.0, (double)0.0, (double)2.0, (double)16.0, (double)16.0);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape3, (String)"box(...)");
        WEST_AABB = voxelShape3;
        VoxelShape voxelShape4 = Block.box((double)14.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape4, (String)"box(...)");
        EAST_AABB = voxelShape4;
        VoxelShape voxelShape5 = Block.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)2.0);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape5, (String)"box(...)");
        NORTH_AABB = voxelShape5;
        VoxelShape voxelShape6 = Block.box((double)0.0, (double)0.0, (double)14.0, (double)16.0, (double)16.0, (double)16.0);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape6, (String)"box(...)");
        SOUTH_AABB = voxelShape6;
        DirectionProperty directionProperty = BlockStateProperties.FACING;
        Intrinsics.checkNotNullExpressionValue((Object)directionProperty, (String)"FACING");
        FACE = directionProperty;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0011\u0010\u000f\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/block/NameMissingBlock$Companion;", "", "<init>", "()V", "MIN", "", "MAX", "UP_AABB", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "getUP_AABB", "()Lnet/minecraft/world/phys/shapes/VoxelShape;", "DOWN_AABB", "getDOWN_AABB", "WEST_AABB", "getWEST_AABB", "EAST_AABB", "getEAST_AABB", "NORTH_AABB", "getNORTH_AABB", "SOUTH_AABB", "getSOUTH_AABB", "FACE", "Lnet/minecraft/world/level/block/state/properties/DirectionProperty;", "getFACE", "()Lnet/minecraft/world/level/block/state/properties/DirectionProperty;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final VoxelShape getUP_AABB() {
            return UP_AABB;
        }

        @NotNull
        public final VoxelShape getDOWN_AABB() {
            return DOWN_AABB;
        }

        @NotNull
        public final VoxelShape getWEST_AABB() {
            return WEST_AABB;
        }

        @NotNull
        public final VoxelShape getEAST_AABB() {
            return EAST_AABB;
        }

        @NotNull
        public final VoxelShape getNORTH_AABB() {
            return NORTH_AABB;
        }

        @NotNull
        public final VoxelShape getSOUTH_AABB() {
            return SOUTH_AABB;
        }

        @NotNull
        public final DirectionProperty getFACE() {
            return FACE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Direction.values().length];
            try {
                nArray[Direction.UP.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.DOWN.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.EAST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.WEST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

