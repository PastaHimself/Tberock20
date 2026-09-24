/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.IntRange
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.Vec3i
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.PathComputationType
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.util.MazePathFinderKt;
import net.thebrokenscript.util.PathNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rH\u0002J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rJ\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/util/MazePathfinder;", "", "level", "Lnet/minecraft/world/level/Level;", "allowDiagonal", "", "maxSearchNodes", "", "waterWalk", "<init>", "(Lnet/minecraft/world/level/Level;ZIZ)V", "isWalkable", "pos", "Lnet/minecraft/core/BlockPos;", "isLowProfileFloor", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "getNeighbors", "", "goal", "isCornerSolid", "findPath", "start", "reconstructPath", "endNode", "Lnet/thebrokenscript/util/PathNode;", "isGroundSolid", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nMazePathFinder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MazePathFinder.kt\nnet/thebrokenscript/util/MazePathfinder\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,562:1\n183#2,2:563\n382#3,7:565\n*S KotlinDebug\n*F\n+ 1 MazePathFinder.kt\nnet/thebrokenscript/util/MazePathfinder\n*L\n155#1:563,2\n222#1:565,7\n*E\n"})
public final class MazePathfinder {
    @NotNull
    private final Level level;
    private final boolean allowDiagonal;
    private final int maxSearchNodes;
    private final boolean waterWalk;

    public MazePathfinder(@NotNull Level level, boolean allowDiagonal, int maxSearchNodes, boolean waterWalk) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        this.level = level;
        this.allowDiagonal = allowDiagonal;
        this.maxSearchNodes = maxSearchNodes;
        this.waterWalk = waterWalk;
    }

    public /* synthetic */ MazePathfinder(Level level, boolean bl, int n, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        if ((n2 & 4) != 0) {
            n = 200;
        }
        if ((n2 & 8) != 0) {
            bl2 = false;
        }
        this(level, bl, n, bl2);
    }

    private final boolean isWalkable(BlockPos pos) {
        BlockState feetState = this.level.getBlockState(pos);
        BlockState headState = this.level.getBlockState(pos.above());
        BlockState belowState = this.level.getBlockState(pos.below());
        if (feetState.is(BlockTags.DOORS)) {
            return headState.is(BlockTags.DOORS) || headState.isPathfindable(PathComputationType.LAND);
        }
        if (!feetState.getFluidState().isEmpty()) {
            return this.waterWalk;
        }
        Intrinsics.checkNotNull((Object)feetState);
        if (this.isLowProfileFloor(feetState, pos)) {
            return headState.isPathfindable(PathComputationType.LAND);
        }
        if (!belowState.isFaceSturdy((BlockGetter)this.level, pos.below(), Direction.UP)) {
            return false;
        }
        if (!feetState.isPathfindable(PathComputationType.LAND)) {
            return false;
        }
        return headState.isPathfindable(PathComputationType.LAND);
    }

    private final boolean isLowProfileFloor(BlockState state, BlockPos pos) {
        if (state.isAir()) {
            return false;
        }
        VoxelShape shape = state.getCollisionShape((BlockGetter)this.level, pos);
        if (shape.isEmpty()) {
            return false;
        }
        double maxY = shape.max(Direction.Axis.Y);
        if (maxY > 0.5625) {
            return false;
        }
        double minX = shape.min(Direction.Axis.X);
        double maxX = shape.max(Direction.Axis.X);
        double minZ = shape.min(Direction.Axis.Z);
        double maxZ = shape.max(Direction.Axis.Z);
        return minX <= 0.001 && maxX >= 0.999 && minZ <= 0.001 && maxZ >= 0.999;
    }

    /*
     * WARNING - void declaration
     */
    private final List<BlockPos> getNeighbors(BlockPos pos, BlockPos goal) {
        List neighbors = new ArrayList();
        int maxDrop = goal.getY() < pos.getY() - 2 ? 25 : 3;
        BlockPos[] blockPosArray = new BlockPos[]{new BlockPos(1, 0, 0), new BlockPos(-1, 0, 0), new BlockPos(0, 0, 1), new BlockPos(0, 0, -1)};
        List cardinalOffsets = CollectionsKt.listOf((Object[])blockPosArray);
        block0: for (BlockPos offset : cardinalOffsets) {
            int dropDistance;
            BlockPos neighbor = pos.offset((Vec3i)offset);
            Intrinsics.checkNotNull((Object)neighbor);
            if (this.isWalkable(neighbor)) {
                neighbors.add(neighbor);
                continue;
            }
            BlockPos stepUp = neighbor.above();
            Intrinsics.checkNotNull((Object)stepUp);
            if (this.isWalkable(stepUp)) {
                neighbors.add(stepUp);
            }
            if ((dropDistance = 1) > maxDrop) continue;
            while (true) {
                BlockPos stepDown = neighbor.below(dropDistance);
                Intrinsics.checkNotNull((Object)stepDown);
                if (this.isWalkable(stepDown)) {
                    neighbors.add(stepDown);
                    continue block0;
                }
                if (!this.level.getBlockState(neighbor.below(dropDistance)).isPathfindable(PathComputationType.LAND) || dropDistance == maxDrop) continue block0;
                ++dropDistance;
            }
        }
        if (this.allowDiagonal) {
            BlockPos[] blockPosArray2 = new BlockPos[]{new BlockPos(1, 0, 1), new BlockPos(1, 0, -1), new BlockPos(-1, 0, 1), new BlockPos(-1, 0, -1)};
            List diagonalOffsets = CollectionsKt.listOf((Object[])blockPosArray2);
            for (BlockPos offset : diagonalOffsets) {
                BlockPos blockPos;
                BlockPos neighbor = pos.offset((Vec3i)offset);
                if (this.level.getBlockState(neighbor).is(BlockTags.DOORS)) continue;
                Intrinsics.checkNotNull((Object)neighbor);
                if (this.isWalkable(neighbor)) {
                    blockPos = neighbor;
                } else {
                    BlockPos blockPos2 = neighbor.above();
                    Intrinsics.checkNotNullExpressionValue((Object)blockPos2, (String)"above(...)");
                    if (this.isWalkable(blockPos2)) {
                        blockPos = neighbor.above();
                    } else {
                        Object v2;
                        block12: {
                            void $this$firstOrNull$iv;
                            Sequence sequence = SequencesKt.map((Sequence)CollectionsKt.asSequence((Iterable)((Iterable)new IntRange(1, maxDrop))), arg_0 -> MazePathfinder.getNeighbors$lambda$0(neighbor, arg_0));
                            boolean $i$f$firstOrNull = false;
                            for (Object element$iv : $this$firstOrNull$iv) {
                                BlockPos it = (BlockPos)element$iv;
                                boolean bl = false;
                                Intrinsics.checkNotNull((Object)it);
                                if (!this.isWalkable(it)) continue;
                                v2 = element$iv;
                                break block12;
                            }
                            v2 = null;
                        }
                        blockPos = v2;
                    }
                }
                if (blockPos == null) continue;
                BlockPos resolvedDiagonal = blockPos;
                BlockPos corner1 = pos.offset(offset.getX(), 0, 0);
                BlockPos corner2 = pos.offset(0, 0, offset.getZ());
                Intrinsics.checkNotNull((Object)corner1);
                boolean corner1Blocked = this.isCornerSolid(corner1);
                Intrinsics.checkNotNull((Object)corner2);
                boolean corner2Blocked = this.isCornerSolid(corner2);
                if (corner1Blocked && corner2Blocked) continue;
                neighbors.add(resolvedDiagonal);
            }
        }
        return neighbors;
    }

    private final boolean isCornerSolid(BlockPos pos) {
        BlockState feetState = this.level.getBlockState(pos);
        BlockState headState = this.level.getBlockState(pos.above());
        return !feetState.getCollisionShape((BlockGetter)this.level, pos).isEmpty() || !headState.getCollisionShape((BlockGetter)this.level, pos.above()).isEmpty();
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final List<BlockPos> findPath(@NotNull BlockPos start, @NotNull BlockPos goal) {
        Intrinsics.checkNotNullParameter((Object)start, (String)"start");
        Intrinsics.checkNotNullParameter((Object)goal, (String)"goal");
        if (!this.isWalkable(goal)) {
            return null;
        }
        PriorityQueue<PathNode> openSet = new PriorityQueue<PathNode>();
        Set closedSet = new LinkedHashSet();
        Map allNodes = new LinkedHashMap();
        PathNode startNode = new PathNode(start, 0.0, MazePathFinderKt.distanceTo(start, goal), null, 8, null);
        allNodes.put(start, startNode);
        openSet.add(startNode);
        int nodesSearched = 0;
        while (!((Collection)openSet).isEmpty() && nodesSearched < this.maxSearchNodes) {
            PathNode current = (PathNode)openSet.poll();
            ++nodesSearched;
            if (Intrinsics.areEqual((Object)current.getPos(), (Object)goal)) {
                Intrinsics.checkNotNull((Object)current);
                List<BlockPos> path = this.reconstructPath(current);
                return path;
            }
            closedSet.add(current.getPos());
            for (BlockPos neighborPos : this.getNeighbors(current.getPos(), goal)) {
                PathNode neighborNode;
                Object object;
                void $this$getOrPut$iv;
                double d;
                if (closedSet.contains(neighborPos)) continue;
                if (neighborPos.getY() < current.getPos().getY()) {
                    int dropDistance = current.getPos().getY() - neighborPos.getY();
                    d = 1.0 + (double)dropDistance * 0.75;
                } else {
                    d = neighborPos.getY() > current.getPos().getY() ? 1.434 : (this.allowDiagonal && Math.abs(neighborPos.getX() - current.getPos().getX()) == 1 && Math.abs(neighborPos.getZ() - current.getPos().getZ()) == 1 ? 1.414 : 1.0);
                }
                double moveCost = d;
                double tentativeGCost = current.getGCost() + moveCost;
                Map map = allNodes;
                BlockPos key$iv = neighborPos;
                boolean $i$f$getOrPut = false;
                Object value$iv = $this$getOrPut$iv.get(key$iv);
                if (value$iv == null) {
                    boolean bl = false;
                    PathNode answer$iv = new PathNode(neighborPos, 0.0, MazePathFinderKt.distanceTo(neighborPos, goal), null, 10, null);
                    $this$getOrPut$iv.put(key$iv, answer$iv);
                    object = answer$iv;
                } else {
                    object = value$iv;
                }
                if (!(tentativeGCost < (neighborNode = (PathNode)object).getGCost())) continue;
                neighborNode.setParent(current);
                neighborNode.setGCost(tentativeGCost);
                openSet.remove(neighborNode);
                openSet.add(neighborNode);
            }
        }
        return null;
    }

    private final List<BlockPos> reconstructPath(PathNode endNode) {
        List path = new ArrayList();
        for (PathNode current = endNode; current != null; current = current.getParent()) {
            path.add(current.getPos());
        }
        return CollectionsKt.reversed((Iterable)path);
    }

    public final boolean isGroundSolid(@NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return this.isWalkable(pos);
    }

    private static final BlockPos getNeighbors$lambda$0(BlockPos $neighbor, int it) {
        return $neighbor.below(it);
    }
}

