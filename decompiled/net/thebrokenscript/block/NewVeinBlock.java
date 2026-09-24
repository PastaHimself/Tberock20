/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LevelReader
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.BonemealableBlock
 *  net.minecraft.world.level.block.SimpleWaterloggedBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.material.Fluids
 *  net.minecraft.world.phys.shapes.BooleanOp
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  net.thebrokenscript.brokencore.api.dsl.DirectionUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.block;

import com.mojang.serialization.MapCodec;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.dsl.DirectionUtil;
import net.thebrokenscript.registry.TBSBlocks;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 72\u00020\u00012\u00020\u00022\u00020\u0003:\u00017B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\tH\u0014J\u001c\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0\rH\u0014J8\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0014J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0014J \u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J \u0010!\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J \u0010#\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J(\u0010%\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J(\u0010)\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020*2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J8\u0010+\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u001aH\u0014J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u001cH\u0016J \u00100\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u0016\u00101\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u0017J \u00102\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u00103\u001a\u0002042\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010/\u001a\u000205H\u0014J\b\u00106\u001a\u00020\u001aH\u0016\u00a8\u00068"}, d2={"Lnet/thebrokenscript/block/NewVeinBlock;", "Lnet/minecraft/world/level/block/Block;", "Lnet/minecraft/world/level/block/BonemealableBlock;", "Lnet/minecraft/world/level/block/SimpleWaterloggedBlock;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "codec", "Lcom/mojang/serialization/MapCodec;", "createBlockStateDefinition", "", "builder", "Lnet/minecraft/world/level/block/state/StateDefinition$Builder;", "Lnet/minecraft/world/level/block/state/BlockState;", "updateShape", "state", "direction", "Lnet/minecraft/core/Direction;", "neighborState", "level", "Lnet/minecraft/world/level/LevelAccessor;", "pos", "Lnet/minecraft/core/BlockPos;", "neighborPos", "canBeReplaced", "", "useContext", "Lnet/minecraft/world/item/context/BlockPlaceContext;", "getFluidState", "Lnet/minecraft/world/level/material/FluidState;", "propagatesSkylightDown", "Lnet/minecraft/world/level/BlockGetter;", "getLightBlock", "", "isValidBonemealTarget", "Lnet/minecraft/world/level/LevelReader;", "isBonemealSuccess", "Lnet/minecraft/world/level/Level;", "random", "Lnet/minecraft/util/RandomSource;", "performBonemeal", "Lnet/minecraft/server/level/ServerLevel;", "neighborChanged", "neighborBlock", "movedByPiston", "getStateForPlacement", "context", "canSurvive", "getUpdatedState", "updateState", "getShape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "Lnet/minecraft/world/phys/shapes/CollisionContext;", "hasDynamicShape", "Companion", "thebrokenscript-common"})
public final class NewVeinBlock
extends Block
implements BonemealableBlock,
SimpleWaterloggedBlock {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final BooleanProperty NORTH_WALL = BooleanProperty.create((String)"north_wall");
    private static final BooleanProperty SOUTH_WALL = BooleanProperty.create((String)"south_wall");
    private static final BooleanProperty EAST_WALL = BooleanProperty.create((String)"east_wall");
    private static final BooleanProperty WEST_WALL = BooleanProperty.create((String)"west_wall");
    private static final MapCodec<NewVeinBlock> CODEC = Block.simpleCodec(NewVeinBlock::new);
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

    public NewVeinBlock(@NotNull BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
        this.registerDefaultState((BlockState)this.defaultBlockState().setValue((Property)BlockStateProperties.WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    @NotNull
    protected MapCodec<NewVeinBlock> codec() {
        MapCodec<NewVeinBlock> mapCodec = CODEC;
        Intrinsics.checkNotNullExpressionValue(mapCodec, (String)"CODEC");
        return mapCodec;
    }

    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        super.createBlockStateDefinition(builder);
        Property[] propertyArray = new Property[]{BlockStateProperties.WATERLOGGED};
        StateDefinition.Builder builder2 = builder.add(propertyArray);
        propertyArray = new Property[]{NORTH_WALL};
        StateDefinition.Builder builder3 = builder2.add(propertyArray);
        propertyArray = new Property[]{SOUTH_WALL};
        StateDefinition.Builder builder4 = builder3.add(propertyArray);
        propertyArray = new Property[]{EAST_WALL};
        StateDefinition.Builder builder5 = builder4.add(propertyArray);
        propertyArray = new Property[]{WEST_WALL};
        StateDefinition.Builder builder6 = builder5.add(propertyArray);
        propertyArray = new Property[]{BlockStateProperties.NORTH};
        StateDefinition.Builder builder7 = builder6.add(propertyArray);
        propertyArray = new Property[]{BlockStateProperties.SOUTH};
        StateDefinition.Builder builder8 = builder7.add(propertyArray);
        propertyArray = new Property[]{BlockStateProperties.EAST};
        StateDefinition.Builder builder9 = builder8.add(propertyArray);
        propertyArray = new Property[]{BlockStateProperties.WEST};
        StateDefinition.Builder builder10 = builder9.add(propertyArray);
        propertyArray = new Property[]{BlockStateProperties.UP};
        StateDefinition.Builder builder11 = builder10.add(propertyArray);
        propertyArray = new Property[]{BlockStateProperties.DOWN};
        builder11.add(propertyArray);
    }

    @NotNull
    protected BlockState updateShape(@NotNull BlockState state, @NotNull Direction direction, @NotNull BlockState neighborState, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull BlockPos neighborPos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)direction, (String)"direction");
        Intrinsics.checkNotNullParameter((Object)neighborState, (String)"neighborState");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)neighborPos, (String)"neighborPos");
        if (((Boolean)state.getValue((Property)BlockStateProperties.WATERLOGGED)).booleanValue()) {
            level.scheduleTick(pos, (Fluid)Fluids.WATER, Fluids.WATER.getTickDelay((LevelReader)level));
        }
        BlockState blockState = super.updateShape(state, direction, neighborState, level, pos, neighborPos);
        Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"updateShape(...)");
        return blockState;
    }

    protected boolean canBeReplaced(@NotNull BlockState state, @NotNull BlockPlaceContext useContext) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)useContext, (String)"useContext");
        return !useContext.getItemInHand().is(TBSBlocks.NEW_VEIN_BLOCK.getItemOrThrow()) || super.canBeReplaced(state, useContext);
    }

    @NotNull
    protected FluidState getFluidState(@NotNull BlockState state) {
        FluidState fluidState;
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        if (((Boolean)state.getValue((Property)BlockStateProperties.WATERLOGGED)).booleanValue()) {
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

    protected boolean propagatesSkylightDown(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return state.getFluidState().isEmpty();
    }

    protected int getLightBlock(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return 0;
    }

    public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return false;
    }

    public boolean isBonemealSuccess(@NotNull Level level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return true;
    }

    public void performBonemeal(@NotNull ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
    }

    protected void neighborChanged(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Block neighborBlock, @NotNull BlockPos neighborPos, boolean movedByPiston) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)neighborBlock, (String)"neighborBlock");
        Intrinsics.checkNotNullParameter((Object)neighborPos, (String)"neighborPos");
        super.neighborChanged(state, level, pos, neighborBlock, neighborPos, movedByPiston);
        this.updateState(state, level, pos);
    }

    @NotNull
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Level level = context.getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)level, (String)"getLevel(...)");
        BlockPos blockPos = context.getClickedPos();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"getClickedPos(...)");
        return this.getUpdatedState(level, blockPos);
    }

    protected boolean canSurvive(@NotNull BlockState state, @NotNull LevelReader level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        boolean u = level.getBlockState(pos.offset(Direction.UP.getNormal())).isFaceSturdy((BlockGetter)level, pos.offset(Direction.UP.getNormal()), Direction.DOWN);
        boolean d = level.getBlockState(pos.offset(Direction.DOWN.getNormal())).isFaceSturdy((BlockGetter)level, pos.offset(Direction.DOWN.getNormal()), Direction.UP);
        return u || d;
    }

    @NotNull
    public final BlockState getUpdatedState(@NotNull Level level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        BlockState state = this.defaultBlockState();
        for (Direction direction : EntriesMappings.entries$0) {
            BlockPos p = pos.offset(direction.getNormal());
            BlockState s = level.getBlockState(p);
            boolean connect = s.is((Block)TBSBlocks.NEW_VEIN_BLOCK.get());
            boolean wall = s.isFaceSturdy((BlockGetter)level, pos, direction.getOpposite());
            switch (WhenMappings.$EnumSwitchMapping$0[direction.ordinal()]) {
                case 1: {
                    state = (BlockState)state.setValue((Property)NORTH_WALL, (Comparable)Boolean.valueOf(wall));
                    break;
                }
                case 2: {
                    state = (BlockState)state.setValue((Property)SOUTH_WALL, (Comparable)Boolean.valueOf(wall));
                    break;
                }
                case 3: {
                    state = (BlockState)state.setValue((Property)EAST_WALL, (Comparable)Boolean.valueOf(wall));
                    break;
                }
                case 4: {
                    state = (BlockState)state.setValue((Property)WEST_WALL, (Comparable)Boolean.valueOf(wall));
                }
            }
            state = direction.getAxis().isHorizontal() ? (BlockState)state.setValue((Property)DirectionUtil.getBlockProp((Direction)direction), (Comparable)Boolean.valueOf(connect)) : (BlockState)state.setValue((Property)DirectionUtil.getBlockProp((Direction)direction), (Comparable)Boolean.valueOf(wall));
        }
        Iterator iterator = state;
        Intrinsics.checkNotNull((Object)iterator);
        return iterator;
    }

    private final void updateState(BlockState state, Level level, BlockPos pos) {
        level.setBlockAndUpdate(pos, this.getUpdatedState(level, pos));
    }

    @NotNull
    protected VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        VoxelShape shape = Shapes.empty();
        Boolean u = (Boolean)state.getValue((Property)BlockStateProperties.UP);
        Boolean d = (Boolean)state.getValue((Property)BlockStateProperties.DOWN);
        Boolean n = (Boolean)state.getValue((Property)NORTH_WALL);
        Boolean e = (Boolean)state.getValue((Property)EAST_WALL);
        Boolean s = (Boolean)state.getValue((Property)SOUTH_WALL);
        Boolean w = (Boolean)state.getValue((Property)WEST_WALL);
        if (u.booleanValue()) {
            shape = UP_AABB;
        }
        if (d.booleanValue()) {
            shape = Shapes.join((VoxelShape)DOWN_AABB, (VoxelShape)shape, (BooleanOp)BooleanOp.OR);
        }
        if (n.booleanValue()) {
            shape = Shapes.join((VoxelShape)NORTH_AABB, (VoxelShape)shape, (BooleanOp)BooleanOp.OR);
        }
        if (e.booleanValue()) {
            shape = Shapes.join((VoxelShape)EAST_AABB, (VoxelShape)shape, (BooleanOp)BooleanOp.OR);
        }
        if (s.booleanValue()) {
            shape = Shapes.join((VoxelShape)SOUTH_AABB, (VoxelShape)shape, (BooleanOp)BooleanOp.OR);
        }
        if (w.booleanValue()) {
            shape = Shapes.join((VoxelShape)WEST_AABB, (VoxelShape)shape, (BooleanOp)BooleanOp.OR);
        }
        VoxelShape voxelShape = shape;
        Intrinsics.checkNotNull((Object)voxelShape);
        return voxelShape;
    }

    public boolean hasDynamicShape() {
        return true;
    }

    static {
        VoxelShape voxelShape = Block.box((double)0.0, (double)15.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape, (String)"box(...)");
        UP_AABB = voxelShape;
        VoxelShape voxelShape2 = Block.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)1.0, (double)16.0);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape2, (String)"box(...)");
        DOWN_AABB = voxelShape2;
        VoxelShape voxelShape3 = Block.box((double)0.0, (double)0.0, (double)0.0, (double)1.0, (double)16.0, (double)16.0);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape3, (String)"box(...)");
        WEST_AABB = voxelShape3;
        VoxelShape voxelShape4 = Block.box((double)15.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape4, (String)"box(...)");
        EAST_AABB = voxelShape4;
        VoxelShape voxelShape5 = Block.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)1.0);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape5, (String)"box(...)");
        NORTH_AABB = voxelShape5;
        VoxelShape voxelShape6 = Block.box((double)0.0, (double)0.0, (double)15.0, (double)16.0, (double)16.0, (double)16.0);
        Intrinsics.checkNotNullExpressionValue((Object)voxelShape6, (String)"box(...)");
        SOUTH_AABB = voxelShape6;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\n\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\f0\f \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\f0\f\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0019\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/block/NewVeinBlock$Companion;", "", "<init>", "()V", "NORTH_WALL", "Lnet/minecraft/world/level/block/state/properties/BooleanProperty;", "kotlin.jvm.PlatformType", "SOUTH_WALL", "EAST_WALL", "WEST_WALL", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/block/NewVeinBlock;", "UP_AABB", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "getUP_AABB", "()Lnet/minecraft/world/phys/shapes/VoxelShape;", "DOWN_AABB", "getDOWN_AABB", "WEST_AABB", "getWEST_AABB", "EAST_AABB", "getEAST_AABB", "NORTH_AABB", "getNORTH_AABB", "SOUTH_AABB", "getSOUTH_AABB", "thebrokenscript-common"})
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

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Direction> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Direction.values()));
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Direction.values().length];
            try {
                nArray[Direction.NORTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.SOUTH.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.EAST.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.WEST.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

