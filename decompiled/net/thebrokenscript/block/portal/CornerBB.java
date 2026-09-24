/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.phys.AABB
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.block.portal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003J\u0016\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/block/portal/CornerBB;", "", "a", "Lnet/minecraft/core/Vec3i;", "b", "<init>", "(Lnet/minecraft/core/Vec3i;Lnet/minecraft/core/Vec3i;)V", "Lnet/minecraft/core/BlockPos;", "getA", "()Lnet/minecraft/core/BlockPos;", "setA", "(Lnet/minecraft/core/BlockPos;)V", "getB", "setB", "aabb", "Lnet/minecraft/world/phys/AABB;", "getAabb", "()Lnet/minecraft/world/phys/AABB;", "expand", "", "to", "set", "thebrokenscript-common"})
public final class CornerBB {
    @NotNull
    private BlockPos a;
    @NotNull
    private BlockPos b;

    public CornerBB(@NotNull Vec3i a, @NotNull Vec3i b) {
        Intrinsics.checkNotNullParameter((Object)a, (String)"a");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        this.a = new BlockPos(PositionUtil.max((Vec3i)a, (Vec3i)b));
        this.b = new BlockPos(PositionUtil.min((Vec3i)a, (Vec3i)b));
    }

    @NotNull
    public final BlockPos getA() {
        return this.a;
    }

    public final void setA(@NotNull BlockPos blockPos) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"<set-?>");
        this.a = blockPos;
    }

    @NotNull
    public final BlockPos getB() {
        return this.b;
    }

    public final void setB(@NotNull BlockPos blockPos) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"<set-?>");
        this.b = blockPos;
    }

    @NotNull
    public final AABB getAabb() {
        AABB aABB = AABB.of((BoundingBox)BoundingBox.fromCorners((Vec3i)((Vec3i)this.a), (Vec3i)((Vec3i)this.b)));
        Intrinsics.checkNotNullExpressionValue((Object)aABB, (String)"of(...)");
        return aABB;
    }

    public final void expand(@NotNull Vec3i to) {
        Intrinsics.checkNotNullParameter((Object)to, (String)"to");
        this.a = new BlockPos(Math.max(this.a.getX(), to.getX()), Math.max(this.a.getY(), to.getY()), Math.max(this.a.getZ(), to.getZ()));
        this.b = new BlockPos(Math.min(this.b.getX(), to.getX()), Math.min(this.b.getY(), to.getY()), Math.min(this.b.getZ(), to.getZ()));
    }

    public final void set(@NotNull Vec3i a, @NotNull Vec3i b) {
        Intrinsics.checkNotNullParameter((Object)a, (String)"a");
        Intrinsics.checkNotNullParameter((Object)b, (String)"b");
        this.a = new BlockPos(a);
        this.b = new BlockPos(b);
    }
}

