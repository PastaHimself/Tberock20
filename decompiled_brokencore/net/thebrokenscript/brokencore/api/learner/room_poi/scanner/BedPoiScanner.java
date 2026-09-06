/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Vec3i
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BedBlock
 *  net.minecraft.world.level.block.entity.BedBlockEntity
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BedPart
 *  net.minecraft.world.level.block.state.properties.Property
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.learner.room_poi.scanner;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.Property;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.learner.room_poi.RoomPoi;
import net.thebrokenscript.brokencore.api.learner.room_poi.scanner.RoomPoiScanner;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J8\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u000fj\b\u0012\u0004\u0012\u00020\u0007`\u0010H\u0016\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/learner/room_poi/scanner/BedPoiScanner;", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/scanner/RoomPoiScanner;", "<init>", "()V", "trigger", "", "blockPos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "level", "Lnet/minecraft/world/level/Level;", "scan", "Lnet/thebrokenscript/brokencore/api/learner/room_poi/RoomPoi;", "skipPositions", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "brokencore-common"})
public final class BedPoiScanner
extends RoomPoiScanner {
    @NotNull
    public static final BedPoiScanner INSTANCE = new BedPoiScanner();

    private BedPoiScanner() {
    }

    @Override
    public boolean trigger(@NotNull BlockPos blockPos, @NotNull BlockState state, @NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return state.getBlock() instanceof BedBlock;
    }

    @Override
    @NotNull
    public RoomPoi scan(@NotNull BlockPos blockPos, @NotNull BlockState state, @NotNull Level level, @NotNull HashSet<BlockPos> skipPositions) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(skipPositions, (String)"skipPositions");
        Object[] stateDir = (Object[])state.getValue((Property)BedBlock.FACING);
        boolean opposite = state.getValue((Property)BedBlock.PART) == BedPart.HEAD;
        skipPositions.add(blockPos);
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        Intrinsics.checkNotNull((Object)blockEntity, (String)"null cannot be cast to non-null type net.minecraft.world.level.block.entity.BedBlockEntity");
        BedBlockEntity bedBlockEntity = (BedBlockEntity)blockEntity;
        Object[] objectArray = opposite ? stateDir.getOpposite() : stateDir;
        Intrinsics.checkNotNull((Object)objectArray);
        BlockPos otherPos = blockPos.offset((Vec3i)MiscExt.offset$default(blockPos, (Direction)objectArray, 0, 2, null));
        skipPositions.add(otherPos);
        objectArray = new BlockPos[]{blockPos, otherPos};
        return new RoomPoi(MiscExt.toVoxelShape(CollectionsKt.listOf((Object[])objectArray)), blockPos, bedBlockEntity.getColor().name());
    }
}

