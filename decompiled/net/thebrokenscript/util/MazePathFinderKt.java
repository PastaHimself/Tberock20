/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0004"}, d2={"distanceTo", "", "Lnet/minecraft/core/BlockPos;", "other", "thebrokenscript-common"})
public final class MazePathFinderKt {
    public static final double distanceTo(@NotNull BlockPos $this$distanceTo, @NotNull BlockPos other) {
        Intrinsics.checkNotNullParameter((Object)$this$distanceTo, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        double dx = $this$distanceTo.getX() - other.getX();
        double dy = $this$distanceTo.getY() - other.getY();
        double dz = $this$distanceTo.getZ() - other.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}

