/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0004\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"intersects", "", "Lnet/minecraft/world/phys/AABB;", "other", "hitPosOrNull", "Lnet/minecraft/core/BlockPos;", "Lnet/minecraft/world/phys/BlockHitResult;", "getHitPosOrNull", "(Lnet/minecraft/world/phys/BlockHitResult;)Lnet/minecraft/core/BlockPos;", "brokencore-common"})
@JvmName(name="PhysUtil")
public final class PhysUtil {
    public static final boolean intersects(@NotNull AABB $this$intersects, @NotNull AABB other) {
        Intrinsics.checkNotNullParameter((Object)$this$intersects, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return $this$intersects.intersects(other);
    }

    @Nullable
    public static final BlockPos getHitPosOrNull(@NotNull BlockHitResult $this$hitPosOrNull) {
        Intrinsics.checkNotNullParameter((Object)$this$hitPosOrNull, (String)"<this>");
        return $this$hitPosOrNull.getType() == HitResult.Type.MISS ? null : $this$hitPosOrNull.getBlockPos();
    }
}

