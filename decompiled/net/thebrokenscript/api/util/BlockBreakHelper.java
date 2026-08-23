/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.registry.TBSTags;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/api/util/BlockBreakHelper;", "", "<init>", "()V", "tryBreakCircuit", "", "level", "Lnet/minecraft/world/level/LevelAccessor;", "pos", "Lnet/minecraft/core/BlockPos;", "tryBreakNIW", "tryBreakNull", "thebrokenscript-common"})
public final class BlockBreakHelper {
    @NotNull
    public static final BlockBreakHelper INSTANCE = new BlockBreakHelper();

    private BlockBreakHelper() {
    }

    public final void tryBreakCircuit(@NotNull LevelAccessor level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        BlockState state = level.getBlockState(pos);
        if (state.is(TBSTags.CIRCUIT_BREAKABLE)) {
            Block.dropResources((BlockState)state, (LevelAccessor)level, (BlockPos)pos, null);
            level.destroyBlock(pos, false);
        }
    }

    public final void tryBreakNIW(@NotNull LevelAccessor level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        BlockState state = level.getBlockState(pos);
        if (state.is(TBSTags.NIW_BREAKABLE)) {
            Block.dropResources((BlockState)state, (LevelAccessor)level, (BlockPos)pos, null);
            level.destroyBlock(pos, false);
        }
    }

    public final void tryBreakNull(@NotNull LevelAccessor level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        BlockState state = level.getBlockState(pos);
        if (state.is(TBSTags.NULL_BREAKABLE)) {
            Block.dropResources((BlockState)state, (LevelAccessor)level, (BlockPos)pos, null);
            level.destroyBlock(pos, false);
        }
    }
}

