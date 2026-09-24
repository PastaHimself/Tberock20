/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.tags.FluidTags
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.SimpleWaterloggedBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.EnumProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.material.Fluids
 *  net.minecraft.world.level.pathfinder.PathComputationType
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.impl.block;

import com.mojang.serialization.MapCodec;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.impl.block.VerticalSlabType;
import net.thebrokenscript.brokencore.impl.registry.BCStateProperties;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u001c\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u0010H\u0014J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001aH\u0014J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\fH\u0014J(\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u001eH\u0016J2\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020&H\u0016J8\u0010'\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020 2\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u0016H\u0014J\u0018\u0010-\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010.\u001a\u00020/H\u0014\u00a8\u00061"}, d2={"Lnet/thebrokenscript/brokencore/impl/block/VerticalSlabBlock;", "Lnet/minecraft/world/level/block/Block;", "Lnet/minecraft/world/level/block/SimpleWaterloggedBlock;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "codec", "Lcom/mojang/serialization/MapCodec;", "useShapeForLightOcclusion", "", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "createBlockStateDefinition", "", "builder", "Lnet/minecraft/world/level/block/state/StateDefinition$Builder;", "getShape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "level", "Lnet/minecraft/world/level/BlockGetter;", "pos", "Lnet/minecraft/core/BlockPos;", "context", "Lnet/minecraft/world/phys/shapes/CollisionContext;", "getStateForPlacement", "Lnet/minecraft/world/item/context/BlockPlaceContext;", "canBeReplaced", "useContext", "getFluidState", "Lnet/minecraft/world/level/material/FluidState;", "placeLiquid", "Lnet/minecraft/world/level/LevelAccessor;", "fluidState", "canPlaceLiquid", "player", "Lnet/minecraft/world/entity/player/Player;", "fluid", "Lnet/minecraft/world/level/material/Fluid;", "updateShape", "facing", "Lnet/minecraft/core/Direction;", "facingState", "currentPos", "facingPos", "isPathfindable", "pathComputationType", "Lnet/minecraft/world/level/pathfinder/PathComputationType;", "Companion", "brokencore-common"})
public class VerticalSlabBlock
extends Block
implements SimpleWaterloggedBlock {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final MapCodec<VerticalSlabBlock> CODEC;
    @NotNull
    private static final EnumProperty<VerticalSlabType> TYPE;
    @NotNull
    private static final BooleanProperty WATERLOGGED;
    @NotNull
    private static final VoxelShape RIGHT_AABB;
    @NotNull
    private static final VoxelShape LEFT_AABB;

    @NotNull
    protected MapCodec<VerticalSlabBlock> codec() {
        return CODEC;
    }

    public VerticalSlabBlock(@NotNull BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.defaultBlockState().setValue((Property)TYPE, (Comparable)((Object)VerticalSlabType.RIGHT))).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    protected boolean useShapeForLightOcclusion(@NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return state.getValue((Property)TYPE) != VerticalSlabType.DOUBLE;
    }

    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        Property[] propertyArray = new Property[]{TYPE, WATERLOGGED};
        builder.add(propertyArray);
    }

    @NotNull
    protected VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        VoxelShape voxelShape;
        VerticalSlabType type;
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        VerticalSlabType verticalSlabType = type = (VerticalSlabType)((Object)state.getValue((Property)TYPE));
        switch (verticalSlabType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[verticalSlabType.ordinal()]) {
            case 1: {
                VoxelShape voxelShape2 = Shapes.block();
                voxelShape = voxelShape2;
                Intrinsics.checkNotNullExpressionValue((Object)voxelShape2, (String)"block(...)");
                break;
            }
            case 2: {
                voxelShape = LEFT_AABB;
                break;
            }
            default: {
                voxelShape = RIGHT_AABB;
            }
        }
        return voxelShape;
    }

    @Nullable
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        BlockPos pos = context.getClickedPos();
        BlockState state = context.getLevel().getBlockState(pos);
        if (state.is((Block)this)) {
            return (BlockState)((BlockState)state.setValue((Property)TYPE, (Comparable)((Object)VerticalSlabType.DOUBLE))).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(false));
        }
        FluidState fluid = context.getLevel().getFluidState(pos);
        BlockState newState = (BlockState)((BlockState)this.defaultBlockState().setValue((Property)TYPE, (Comparable)((Object)VerticalSlabType.RIGHT))).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(fluid.getType() == Fluids.WATER));
        Direction direction = context.getClickedFace();
        return direction == Direction.WEST || context.getClickLocation().x - (double)pos.getX() > 0.5 ? (BlockState)newState.setValue((Property)TYPE, (Comparable)((Object)VerticalSlabType.LEFT)) : newState;
    }

    protected boolean canBeReplaced(@NotNull BlockState state, @NotNull BlockPlaceContext useContext) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)useContext, (String)"useContext");
        ItemStack stack = useContext.getItemInHand();
        VerticalSlabType type = (VerticalSlabType)((Object)state.getValue((Property)TYPE));
        if (type != VerticalSlabType.DOUBLE && stack.is(this.asItem())) {
            if (useContext.replacingClickedOnBlock()) {
                Direction direction = useContext.getClickedFace();
                return type == VerticalSlabType.RIGHT ? direction == Direction.EAST || direction.getAxis().isVertical() : direction == Direction.WEST || direction.getAxis().isVertical();
            }
            return true;
        }
        return false;
    }

    @NotNull
    protected FluidState getFluidState(@NotNull BlockState state) {
        FluidState fluidState;
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Comparable comparable = state.getValue((Property)WATERLOGGED);
        Intrinsics.checkNotNull((Object)comparable, (String)"null cannot be cast to non-null type kotlin.Boolean");
        if (((Boolean)comparable).booleanValue()) {
            FluidState fluidState2 = Fluids.WATER.getSource(false);
            fluidState = fluidState2;
            Intrinsics.checkNotNullExpressionValue((Object)fluidState2, (String)"getSource(...)");
        } else {
            FluidState fluidState3 = super.getFluidState(state);
            fluidState = fluidState3;
            Intrinsics.checkNotNullExpressionValue((Object)fluidState3, (String)"getFluidState(...)");
        }
        return fluidState;
    }

    public boolean placeLiquid(@NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull FluidState fluidState) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)fluidState, (String)"fluidState");
        return state.getValue((Property)TYPE) != VerticalSlabType.DOUBLE ? super.placeLiquid(level, pos, state, fluidState) : false;
    }

    public boolean canPlaceLiquid(@Nullable Player player, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull Fluid fluid) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)fluid, (String)"fluid");
        return state.getValue((Property)TYPE) != VerticalSlabType.DOUBLE ? super.canPlaceLiquid(player, level, pos, state, fluid) : false;
    }

    @NotNull
    protected BlockState updateShape(@NotNull BlockState state, @NotNull Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor level, @NotNull BlockPos currentPos, @NotNull BlockPos facingPos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)facing, (String)"facing");
        Intrinsics.checkNotNullParameter((Object)facingState, (String)"facingState");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)currentPos, (String)"currentPos");
        Intrinsics.checkNotNullParameter((Object)facingPos, (String)"facingPos");
        if (((Boolean)state.getValue((Property)WATERLOGGED)).booleanValue()) {
            level.scheduleTick(currentPos, (Fluid)Fluids.WATER, Fluids.WATER.getTickDelay((LevelReader)level));
        }
        BlockState blockState = super.updateShape(state, facing, facingState, level, currentPos, facingPos);
        Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"updateShape(...)");
        return blockState;
    }

    protected boolean isPathfindable(@NotNull BlockState state, @NotNull PathComputationType pathComputationType) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)pathComputationType, (String)"pathComputationType");
        return switch (WhenMappings.$EnumSwitchMapping$1[pathComputationType.ordinal()]) {
            case 1 -> false;
            case 2 -> state.getFluidState().is(FluidTags.WATER);
            case 3 -> false;
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    static {
        MapCodec mapCodec = Block.simpleCodec(VerticalSlabBlock::new);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"simpleCodec(...)");
        CODEC = mapCodec;
        TYPE = BCStateProperties.INSTANCE.getVERTICAL_SLAB_TYPE();
        BooleanProperty booleanProperty = BlockStateProperties.WATERLOGGED;
        Intrinsics.checkNotNullExpressionValue((Object)booleanProperty, (String)"WATERLOGGED");
        WATERLOGGED = booleanProperty;
        VoxelShape voxelShape = Block.box((double)0.0, (double)0.0, (double)0.0, (double)8.0, (double)16.0, (double)16.0);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"box(...)");
        RIGHT_AABB = voxelShape;
        VoxelShape voxelShape2 = Block.box((double)8.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape2, (String)"box(...)");
        LEFT_AABB = voxelShape2;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0013X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/brokencore/impl/block/VerticalSlabBlock$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/brokencore/impl/block/VerticalSlabBlock;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "TYPE", "Lnet/minecraft/world/level/block/state/properties/EnumProperty;", "Lnet/thebrokenscript/brokencore/impl/block/VerticalSlabType;", "getTYPE", "()Lnet/minecraft/world/level/block/state/properties/EnumProperty;", "WATERLOGGED", "Lnet/minecraft/world/level/block/state/properties/BooleanProperty;", "getWATERLOGGED", "()Lnet/minecraft/world/level/block/state/properties/BooleanProperty;", "RIGHT_AABB", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "getRIGHT_AABB", "()Lnet/minecraft/world/phys/shapes/VoxelShape;", "LEFT_AABB", "getLEFT_AABB", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapCodec<VerticalSlabBlock> getCODEC() {
            return CODEC;
        }

        @NotNull
        public final EnumProperty<VerticalSlabType> getTYPE() {
            return TYPE;
        }

        @NotNull
        public final BooleanProperty getWATERLOGGED() {
            return WATERLOGGED;
        }

        @NotNull
        protected final VoxelShape getRIGHT_AABB() {
            return RIGHT_AABB;
        }

        @NotNull
        protected final VoxelShape getLEFT_AABB() {
            return LEFT_AABB;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] nArray = new int[VerticalSlabType.values().length];
            try {
                nArray[VerticalSlabType.DOUBLE.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[VerticalSlabType.LEFT.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[PathComputationType.values().length];
            try {
                nArray[PathComputationType.LAND.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PathComputationType.WATER.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[PathComputationType.AIR.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
        }
    }
}

