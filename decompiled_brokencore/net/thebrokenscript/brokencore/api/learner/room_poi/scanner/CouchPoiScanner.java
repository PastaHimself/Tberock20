/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.StairBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.Half
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.block.state.properties.StairsShape
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.learner.room_poi.scanner;

import java.util.Collection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.learner.room_poi.RoomPoi;
import net.thebrokenscript.brokencore.api.learner.room_poi.scanner.RoomPoiScanner;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J8\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000fj\b\u0012\u0004\u0012\u00020\u0007`\u0010H\u0016J\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0007\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/room_poi/scanner/CouchPoiScanner;", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/scanner/RoomPoiScanner;", "<init>", "()V", "trigger", "", "blockPos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "level", "Lnet/minecraft/world/level/Level;", "scan", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/RoomPoi;", "skipPositions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "isNotStaircase", "pos", "getStairOffsetPos", "left", "brokencore-common"})
public final class CouchPoiScanner
extends RoomPoiScanner {
    @NotNull
    public static final CouchPoiScanner INSTANCE = new CouchPoiScanner();

    private CouchPoiScanner() {
    }

    @Override
    public boolean trigger(@NotNull BlockPos blockPos, @NotNull BlockState state, @NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return state.getBlock() instanceof StairBlock && state.getValue((Property)StairBlock.HALF) == Half.BOTTOM && this.isNotStaircase(state, blockPos, level);
    }

    @Override
    @NotNull
    public RoomPoi scan(@NotNull BlockPos blockPos, @NotNull BlockState state, @NotNull Level level, @NotNull HashSet<BlockPos> skipPositions) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(skipPositions, (String)"skipPositions");
        HashSet<BlockPos> visited = new HashSet<BlockPos>();
        BlockPos pos = blockPos;
        BlockState curState = level.getBlockState(pos);
        while (!visited.contains(pos) && curState.getBlock() instanceof StairBlock) {
            visited.add(pos);
            BlockState blockState = curState;
            Intrinsics.checkNotNull((Object)blockState);
            pos = this.getStairOffsetPos(false, blockState, pos);
            curState = level.getBlockState(pos);
        }
        boolean first = true;
        while (!visited.contains(pos) && curState.getBlock() instanceof StairBlock) {
            BlockState blockState;
            if (first) {
                blockState = curState;
                Intrinsics.checkNotNull((Object)blockState);
                pos = this.getStairOffsetPos(true, blockState, pos);
                curState = level.getBlockState(pos);
                first = false;
            }
            visited.add(pos);
            blockState = curState;
            Intrinsics.checkNotNull((Object)blockState);
            pos = this.getStairOffsetPos(true, blockState, pos);
            curState = level.getBlockState(pos);
        }
        VoxelShape finalShape = Shapes.empty();
        VoxelShape voxelShape = visited.iterator();
        Intrinsics.checkNotNullExpressionValue(voxelShape, (String)"iterator(...)");
        VoxelShape voxelShape2 = voxelShape;
        while (voxelShape2.hasNext()) {
            Object e = voxelShape2.next();
            Intrinsics.checkNotNullExpressionValue(e, (String)"next(...)");
            BlockPos pos2 = (BlockPos)e;
            finalShape = Shapes.or((VoxelShape)Shapes.create((AABB)new AABB(pos2)), (VoxelShape)finalShape);
        }
        skipPositions.addAll((Collection<BlockPos>)visited);
        voxelShape2 = finalShape;
        Intrinsics.checkNotNull((Object)voxelShape2);
        return new RoomPoi(voxelShape2, pos, visited.size() == 1 ? "chair" : "couch");
    }

    public final boolean isNotStaircase(@NotNull BlockState state, @NotNull BlockPos pos, @NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Direction stateDir = (Direction)state.getValue((Property)StairBlock.FACING);
        BlockPos pos2 = pos.offset(stateDir.getNormal());
        return !level.getBlockState(pos2).isCollisionShapeFullBlock((BlockGetter)level, pos2) && !(level.getBlockState(pos2.offset(0, 1, 0)).getBlock() instanceof StairBlock);
    }

    @NotNull
    public final BlockPos getStairOffsetPos(boolean left, @NotNull BlockState state, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Direction stateDir = (Direction)state.getValue((Property)StairBlock.FACING);
        StairsShape shape = (StairsShape)state.getValue((Property)StairBlock.SHAPE);
        Direction direction = stateDir;
        Direction dir = switch (direction == null ? -1 : WhenMappings.$EnumSwitchMapping$0[direction.ordinal()]) {
            case 1 -> Direction.WEST;
            case 2 -> Direction.EAST;
            case 3 -> Direction.SOUTH;
            default -> Direction.NORTH;
        };
        StairsShape stairsShape = shape;
        BlockPos offsetPos = switch (stairsShape == null ? -1 : WhenMappings.$EnumSwitchMapping$1[stairsShape.ordinal()]) {
            case 1, 2 -> pos.offset(stateDir.getNormal());
            case 3, 4 -> pos.offset(stateDir.getOpposite().getNormal());
            case 5 -> pos;
            default -> throw new NoWhenBranchMatchedException();
        };
        Direction orthoDir = left ? dir : dir.getOpposite();
        BlockPos ofs = offsetPos.offset(orthoDir.getNormal());
        Intrinsics.checkNotNull((Object)ofs);
        return ofs;
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

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
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[StairsShape.values().length];
            try {
                nArray[StairsShape.OUTER_LEFT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[StairsShape.OUTER_RIGHT.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[StairsShape.INNER_LEFT.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[StairsShape.INNER_RIGHT.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[StairsShape.STRAIGHT.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
        }
    }
}

