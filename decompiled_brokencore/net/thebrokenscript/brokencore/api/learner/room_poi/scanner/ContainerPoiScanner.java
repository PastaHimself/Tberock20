/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BarrelBlock
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.ChestBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.ChestType
 *  net.minecraft.world.level.block.state.properties.Property
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.learner.room_poi.scanner;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.level.block.state.properties.Property;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.learner.room_poi.RoomPoi;
import net.thebrokenscript.brokencore.api.learner.room_poi.scanner.RoomPoiScanner;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J8\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000fj\b\u0012\u0004\u0012\u00020\u0007`\u0010H\u0016J*\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00140\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/room_poi/scanner/ContainerPoiScanner;", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/scanner/RoomPoiScanner;", "<init>", "()V", "trigger", "", "blockPos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "level", "Lnet/minecraft/world/level/Level;", "scan", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/RoomPoi;", "skipPositions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getContainerPositions", "Lkotlin/Pair;", "", "", "brokencore-common"})
public final class ContainerPoiScanner
extends RoomPoiScanner {
    @NotNull
    public static final ContainerPoiScanner INSTANCE = new ContainerPoiScanner();

    private ContainerPoiScanner() {
    }

    @Override
    public boolean trigger(@NotNull BlockPos blockPos, @NotNull BlockState state, @NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Block block2 = state.getBlock();
        return block2 instanceof ChestBlock || block2 instanceof BarrelBlock;
    }

    @Override
    @NotNull
    public RoomPoi scan(@NotNull BlockPos blockPos, @NotNull BlockState state, @NotNull Level level, @NotNull HashSet<BlockPos> skipPositions) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(skipPositions, (String)"skipPositions");
        Pair<String, List<BlockPos>> positions = this.getContainerPositions(blockPos, state);
        skipPositions.addAll((Collection)positions.getSecond());
        return new RoomPoi(MiscExt.toVoxelShape((Collection)positions.getSecond()), blockPos, (String)positions.getFirst());
    }

    private final Pair<String, List<BlockPos>> getContainerPositions(BlockPos blockPos, BlockState state) {
        Object[] objectArray = new BlockPos[]{blockPos};
        List positions = CollectionsKt.mutableListOf((Object[])objectArray);
        if (state.getBlock() instanceof BarrelBlock) {
            return TuplesKt.to((Object)"barrel", (Object)positions);
        }
        ChestType chestType = (ChestType)state.getValue((Property)ChestBlock.TYPE);
        if (chestType == ChestType.SINGLE) {
            return TuplesKt.to((Object)"chest", (Object)positions);
        }
        Direction direction = (Direction)state.getValue((Property)ChestBlock.FACING);
        Direction dir = switch (direction == null ? -1 : WhenMappings.$EnumSwitchMapping$0[direction.ordinal()]) {
            case 1 -> Direction.EAST;
            case 2 -> Direction.WEST;
            case 3 -> Direction.SOUTH;
            default -> Direction.NORTH;
        };
        boolean left = chestType == ChestType.LEFT;
        Direction direction2 = left ? dir : dir.getOpposite();
        Intrinsics.checkNotNull((Object)direction2);
        positions.add(MiscExt.offset$default(blockPos, direction2, 0, 2, null));
        return TuplesKt.to((Object)"double_chest", (Object)positions);
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
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

