/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/util/PreciseBlockHitResult;", "Lnet/minecraft/world/phys/BlockHitResult;", "location", "Lnet/minecraft/world/phys/Vec3;", "hitPos", "direction", "Lnet/minecraft/core/Direction;", "blockPos", "Lnet/minecraft/core/BlockPos;", "inside", "", "<init>", "(Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/core/Direction;Lnet/minecraft/core/BlockPos;Z)V", "getHitPos", "()Lnet/minecraft/world/phys/Vec3;", "brokencore-common"})
public final class PreciseBlockHitResult
extends BlockHitResult {
    @NotNull
    private final Vec3 hitPos;

    public PreciseBlockHitResult(@NotNull Vec3 location, @NotNull Vec3 hitPos, @Nullable Direction direction, @Nullable BlockPos blockPos, boolean inside) {
        Intrinsics.checkNotNullParameter((Object)location, (String)"location");
        Intrinsics.checkNotNullParameter((Object)hitPos, (String)"hitPos");
        super(location, direction, blockPos, inside);
        this.hitPos = hitPos;
    }

    @NotNull
    public final Vec3 getHitPos() {
        return this.hitPos;
    }
}

