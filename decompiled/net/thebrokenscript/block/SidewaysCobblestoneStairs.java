/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.item.context.BlockPlaceContext
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.HorizontalDirectionalBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.shapes.CollisionContext
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.block;

import com.mojang.serialization.MapCodec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0007H\u0014J\u001c\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0014J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0018H\u0014\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/block/SidewaysCobblestoneStairs;", "Lnet/minecraft/world/level/block/HorizontalDirectionalBlock;", "properties", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "codec", "Lcom/mojang/serialization/MapCodec;", "createBlockStateDefinition", "", "builder", "Lnet/minecraft/world/level/block/state/StateDefinition$Builder;", "Lnet/minecraft/world/level/block/Block;", "Lnet/minecraft/world/level/block/state/BlockState;", "getStateForPlacement", "context", "Lnet/minecraft/world/item/context/BlockPlaceContext;", "getShape", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "state", "level", "Lnet/minecraft/world/level/BlockGetter;", "pos", "Lnet/minecraft/core/BlockPos;", "Lnet/minecraft/world/phys/shapes/CollisionContext;", "Companion", "thebrokenscript-common"})
public final class SidewaysCobblestoneStairs
extends HorizontalDirectionalBlock {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final MapCodec<SidewaysCobblestoneStairs> CODEC;
    private static final VoxelShape NORTH;
    private static final VoxelShape SOUTH;
    private static final VoxelShape EAST;
    private static final VoxelShape WEST;

    public SidewaysCobblestoneStairs(@NotNull BlockBehaviour.Properties properties) {
        Intrinsics.checkNotNullParameter((Object)properties, (String)"properties");
        super(properties);
    }

    @NotNull
    protected MapCodec<SidewaysCobblestoneStairs> codec() {
        return CODEC;
    }

    protected void createBlockStateDefinition(@NotNull StateDefinition.Builder<Block, BlockState> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        Property[] propertyArray = new Property[]{HorizontalDirectionalBlock.FACING};
        builder.add(propertyArray);
    }

    @Nullable
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        return (BlockState)this.defaultBlockState().setValue((Property)HorizontalDirectionalBlock.FACING, (Comparable)context.getHorizontalDirection());
    }

    @NotNull
    protected VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        VoxelShape voxelShape;
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Direction direction = (Direction)state.getValue((Property)HorizontalDirectionalBlock.FACING);
        switch (direction == null ? -1 : WhenMappings.$EnumSwitchMapping$0[direction.ordinal()]) {
            case 1: {
                VoxelShape voxelShape2 = NORTH;
                voxelShape = voxelShape2;
                Intrinsics.checkNotNullExpressionValue((Object)voxelShape2, (String)"NORTH");
                break;
            }
            case 2: {
                VoxelShape voxelShape3 = SOUTH;
                voxelShape = voxelShape3;
                Intrinsics.checkNotNullExpressionValue((Object)voxelShape3, (String)"SOUTH");
                break;
            }
            case 3: {
                VoxelShape voxelShape4 = EAST;
                voxelShape = voxelShape4;
                Intrinsics.checkNotNullExpressionValue((Object)voxelShape4, (String)"EAST");
                break;
            }
            case 4: {
                VoxelShape voxelShape5 = WEST;
                voxelShape = voxelShape5;
                Intrinsics.checkNotNullExpressionValue((Object)voxelShape5, (String)"WEST");
                break;
            }
            default: {
                VoxelShape voxelShape6 = NORTH;
                voxelShape = voxelShape6;
                Intrinsics.checkNotNullExpressionValue((Object)voxelShape6, (String)"NORTH");
            }
        }
        return voxelShape;
    }

    static {
        MapCodec mapCodec = HorizontalDirectionalBlock.simpleCodec(SidewaysCobblestoneStairs::new);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"simpleCodec(...)");
        CODEC = mapCodec;
        NORTH = Shapes.or((VoxelShape)HorizontalDirectionalBlock.box((double)8.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0), (VoxelShape)HorizontalDirectionalBlock.box((double)0.0, (double)0.0, (double)8.0, (double)8.0, (double)16.0, (double)16.0));
        SOUTH = Shapes.or((VoxelShape)HorizontalDirectionalBlock.box((double)0.0, (double)0.0, (double)0.0, (double)8.0, (double)16.0, (double)16.0), (VoxelShape)HorizontalDirectionalBlock.box((double)8.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)8.0));
        EAST = Shapes.or((VoxelShape)HorizontalDirectionalBlock.box((double)0.0, (double)0.0, (double)8.0, (double)16.0, (double)16.0, (double)16.0), (VoxelShape)HorizontalDirectionalBlock.box((double)0.0, (double)0.0, (double)0.0, (double)8.0, (double)16.0, (double)8.0));
        WEST = Shapes.or((VoxelShape)HorizontalDirectionalBlock.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)8.0), (VoxelShape)HorizontalDirectionalBlock.box((double)8.0, (double)0.0, (double)8.0, (double)16.0, (double)16.0, (double)16.0));
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/block/SidewaysCobblestoneStairs$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/block/SidewaysCobblestoneStairs;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "NORTH", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "kotlin.jvm.PlatformType", "SOUTH", "EAST", "WEST", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapCodec<SidewaysCobblestoneStairs> getCODEC() {
            return CODEC;
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

