/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.chunk.ChunkAccess;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/util/PosUtil;", "", "<init>", "()V", "hasBlockPos", "", "Lnet/minecraft/world/level/chunk/ChunkAccess;", "blockPos", "Lnet/minecraft/core/BlockPos;", "thebrokenscript-common"})
public final class PosUtil {
    @NotNull
    public static final PosUtil INSTANCE = new PosUtil();

    private PosUtil() {
    }

    @JvmStatic
    public static final boolean hasBlockPos(@NotNull ChunkAccess $this$hasBlockPos, @NotNull BlockPos blockPos) {
        Intrinsics.checkNotNullParameter((Object)$this$hasBlockPos, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        return blockPos.getX() >= $this$hasBlockPos.getPos().getMinBlockX() && blockPos.getX() >= $this$hasBlockPos.getPos().getMinBlockZ() && blockPos.getX() <= $this$hasBlockPos.getPos().getMaxBlockX() && blockPos.getZ() <= $this$hasBlockPos.getPos().getMaxBlockZ() && blockPos.getY() <= $this$hasBlockPos.getMinBuildHeight() && blockPos.getY() >= $this$hasBlockPos.getMaxBuildHeight();
    }
}

