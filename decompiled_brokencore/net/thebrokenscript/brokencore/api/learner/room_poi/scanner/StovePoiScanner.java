/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BaseRailBlock
 *  net.minecraft.world.level.block.CampfireBlock
 *  net.minecraft.world.level.block.TrapDoorBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.learner.room_poi.scanner;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseRailBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.learner.room_poi.RoomPoi;
import net.thebrokenscript.brokencore.api.learner.room_poi.scanner.RoomPoiScanner;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ8\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0012j\b\u0012\u0004\u0012\u00020\u0007`\u0013H\u0016\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/room_poi/scanner/StovePoiScanner;", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/scanner/RoomPoiScanner;", "<init>", "()V", "trigger", "", "blockPos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "level", "Lnet/minecraft/world/level/Level;", "isTrapdoor", "isRail", "isCampfire", "scan", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/RoomPoi;", "skipPositions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "brokencore-common"})
public final class StovePoiScanner
extends RoomPoiScanner {
    @NotNull
    public static final StovePoiScanner INSTANCE = new StovePoiScanner();

    private StovePoiScanner() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean trigger(@NotNull BlockPos blockPos, @NotNull BlockState state, @NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        if (this.isTrapdoor(state)) {
            BlockState blockState = level.getBlockState(blockPos.offset(0, -3, 0));
            Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"getBlockState(...)");
            if (!this.isCampfire(blockState)) return false;
            BlockState blockState2 = level.getBlockState(blockPos.offset(0, -1, 0));
            Intrinsics.checkNotNullExpressionValue((Object)blockState2, (String)"getBlockState(...)");
            if (!this.isRail(blockState2)) return false;
            return true;
        }
        if (this.isCampfire(state)) {
            BlockState blockState = level.getBlockState(blockPos.offset(0, 3, 0));
            Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"getBlockState(...)");
            if (!this.isTrapdoor(blockState)) return false;
            BlockState blockState3 = level.getBlockState(blockPos.offset(0, -1, 0));
            Intrinsics.checkNotNullExpressionValue((Object)blockState3, (String)"getBlockState(...)");
            if (!this.isRail(blockState3)) return false;
            return true;
        }
        if (!this.isRail(state)) return false;
        BlockState blockState = level.getBlockState(blockPos.offset(0, 1, 0));
        Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"getBlockState(...)");
        if (!this.isTrapdoor(blockState)) return false;
        BlockState blockState4 = level.getBlockState(blockPos.offset(0, -2, 0));
        Intrinsics.checkNotNullExpressionValue((Object)blockState4, (String)"getBlockState(...)");
        if (!this.isCampfire(blockState4)) return false;
        return true;
    }

    public final boolean isTrapdoor(@NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return state.getBlock() instanceof TrapDoorBlock;
    }

    public final boolean isRail(@NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return state.getBlock() instanceof BaseRailBlock;
    }

    public final boolean isCampfire(@NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return state.getBlock() instanceof CampfireBlock;
    }

    @Override
    @NotNull
    public RoomPoi scan(@NotNull BlockPos blockPos, @NotNull BlockState state, @NotNull Level level, @NotNull HashSet<BlockPos> skipPositions) {
        int campfirePosOfs;
        int railPosOfs;
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(skipPositions, (String)"skipPositions");
        int n = this.isCampfire(state) ? 2 : (railPosOfs = this.isTrapdoor(state) ? -1 : 0);
        int n2 = this.isRail(state) ? -2 : (campfirePosOfs = this.isTrapdoor(state) ? -3 : 0);
        int trapdoorPosOfs = this.isCampfire(state) ? 3 : (this.isRail(state) ? 1 : 0);
        BlockPos railPos = blockPos.offset(0, railPosOfs, 0);
        BlockPos campfirePos = blockPos.offset(0, campfirePosOfs, 0);
        BlockPos trapdoorPos = blockPos.offset(0, trapdoorPosOfs, 0);
        Object[] objectArray = new BlockPos[]{railPos, campfirePos, trapdoorPos};
        return new RoomPoi(MiscExt.toVoxelShape(CollectionsKt.listOf((Object[])objectArray)), blockPos, "stove");
    }
}

