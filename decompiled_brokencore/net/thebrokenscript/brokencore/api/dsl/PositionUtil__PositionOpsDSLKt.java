/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 *  org.joml.Vector3i
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.joml.Vector3i;

@Metadata(mv={2, 1, 0}, k=5, xi=48, d1={"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\bH\u0086\u0002\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\bH\u0086\u0002\u001a\r\u0010\n\u001a\u00020\u0001*\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0086\u0002\u001a\"\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\b\u001a\u0012\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0011\u001a\u0012\u0010\u0012\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0011\u001a\u0015\u0010\u0004\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0013H\u0086\u0002\u001a\u0015\u0010\u0006\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0013H\u0086\u0002\u001a\u0015\u0010\u0007\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0005\u001a\u00020\bH\u0086\u0002\u001a\u0015\u0010\t\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0005\u001a\u00020\bH\u0086\u0002\u001a\r\u0010\n\u001a\u00020\u0013*\u00020\u0013H\u0086\u0002\u001a\u0015\u0010\u0007\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0013H\u0086\u0002\u001a\n\u0010\u0015\u001a\u00020\u0016*\u00020\u0017\u001a\n\u0010\u0018\u001a\u00020\u0019*\u00020\u001a\u001a\n\u0010\u0015\u001a\u00020\u0016*\u00020\u001a\u001a\n\u0010\u001b\u001a\u00020\u001a*\u00020\u001a\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\u0000\u001a\u00020\u0013*\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0014\u00a8\u0006\u001c"}, d2={"norm", "Lnet/minecraft/world/phys/Vec3;", "getNorm", "(Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;", "plus", "other", "minus", "times", "", "div", "unaryMinus", "x", "y", "z", "above", "value", "max", "Lnet/minecraft/core/Vec3i;", "min", "Lorg/joml/Vector3f;", "(Lorg/joml/Vector3f;)Lorg/joml/Vector3f;", "sum", "", "Lorg/joml/Vector3i;", "isZero", "", "Lnet/minecraft/core/BlockPos;", "negate", "brokencore-common"}, xs="net/thebrokenscript/brokencore/api/dsl/PositionUtil")
final class PositionUtil__PositionOpsDSLKt {
    @NotNull
    public static final Vec3 getNorm(@NotNull Vec3 $this$norm) {
        Intrinsics.checkNotNullParameter((Object)$this$norm, (String)"<this>");
        Vec3 vec3 = $this$norm.normalize();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"normalize(...)");
        return vec3;
    }

    @NotNull
    public static final Vec3 plus(@NotNull Vec3 $this$plus, @NotNull Vec3 other) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Vec3 vec3 = $this$plus.add(other.x, other.y, other.z);
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
        return vec3;
    }

    @NotNull
    public static final Vec3 minus(@NotNull Vec3 $this$minus, @NotNull Vec3 other) {
        Intrinsics.checkNotNullParameter((Object)$this$minus, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Vec3 vec3 = $this$minus.subtract(other.x, other.y, other.z);
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"subtract(...)");
        return vec3;
    }

    @NotNull
    public static final Vec3 times(@NotNull Vec3 $this$times, @NotNull Number other) {
        Intrinsics.checkNotNullParameter((Object)$this$times, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Vec3 vec3 = $this$times.scale(other.doubleValue());
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"scale(...)");
        return vec3;
    }

    @NotNull
    public static final Vec3 div(@NotNull Vec3 $this$div, @NotNull Number other) {
        Intrinsics.checkNotNullParameter((Object)$this$div, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Vec3 vec3 = $this$div.scale(1.0 / other.doubleValue());
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"scale(...)");
        return vec3;
    }

    @NotNull
    public static final Vec3 unaryMinus(@NotNull Vec3 $this$unaryMinus) {
        Intrinsics.checkNotNullParameter((Object)$this$unaryMinus, (String)"<this>");
        Vec3 vec3 = $this$unaryMinus.scale(-1.0);
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"scale(...)");
        return vec3;
    }

    @NotNull
    public static final Vec3 times(@NotNull Vec3 $this$times, @NotNull Vec3 other) {
        Intrinsics.checkNotNullParameter((Object)$this$times, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Vec3 vec3 = $this$times.multiply(other);
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"multiply(...)");
        return vec3;
    }

    @NotNull
    public static final Vec3 plus(@NotNull Vec3 $this$plus, @NotNull Number x, @NotNull Number y, @NotNull Number z) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)x, (String)"x");
        Intrinsics.checkNotNullParameter((Object)y, (String)"y");
        Intrinsics.checkNotNullParameter((Object)z, (String)"z");
        Vec3 vec3 = $this$plus.add(x.doubleValue(), y.doubleValue(), z.doubleValue());
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
        return vec3;
    }

    @NotNull
    public static final Vec3 above(@NotNull Vec3 $this$above, @NotNull Number value) {
        Intrinsics.checkNotNullParameter((Object)$this$above, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Vec3 vec3 = $this$above.add($this$above.x, $this$above.y + value.doubleValue(), $this$above.z);
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
        return vec3;
    }

    public static /* synthetic */ Vec3 above$default(Vec3 vec3, Number number, int n, Object object) {
        if ((n & 1) != 0) {
            number = 1;
        }
        return PositionUtil.above(vec3, number);
    }

    @NotNull
    public static final Vec3i max(@NotNull Vec3i $this$max, @NotNull Vec3i other) {
        Intrinsics.checkNotNullParameter((Object)$this$max, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return $this$max.compareTo(other) > 0 ? $this$max : other;
    }

    @NotNull
    public static final Vec3i min(@NotNull Vec3i $this$min, @NotNull Vec3i other) {
        Intrinsics.checkNotNullParameter((Object)$this$min, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return $this$min.compareTo(other) < 0 ? $this$min : other;
    }

    @NotNull
    public static final Vector3f getNorm(@NotNull Vector3f $this$norm) {
        Intrinsics.checkNotNullParameter((Object)$this$norm, (String)"<this>");
        Vector3f vector3f = $this$norm.normalize();
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"normalize(...)");
        return vector3f;
    }

    @NotNull
    public static final Vector3f plus(@NotNull Vector3f $this$plus, @NotNull Vector3f other) {
        Intrinsics.checkNotNullParameter((Object)$this$plus, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Vector3f vector3f = $this$plus.add((Vector3fc)other, new Vector3f());
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"add(...)");
        return vector3f;
    }

    @NotNull
    public static final Vector3f minus(@NotNull Vector3f $this$minus, @NotNull Vector3f other) {
        Intrinsics.checkNotNullParameter((Object)$this$minus, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Vector3f vector3f = $this$minus.sub((Vector3fc)other, new Vector3f());
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"sub(...)");
        return vector3f;
    }

    @NotNull
    public static final Vector3f times(@NotNull Vector3f $this$times, @NotNull Number other) {
        Intrinsics.checkNotNullParameter((Object)$this$times, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Vector3f vector3f = $this$times.mul(other.floatValue(), new Vector3f());
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"mul(...)");
        return vector3f;
    }

    @NotNull
    public static final Vector3f div(@NotNull Vector3f $this$div, @NotNull Number other) {
        Intrinsics.checkNotNullParameter((Object)$this$div, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Vector3f vector3f = $this$div.mul(1.0f / other.floatValue(), new Vector3f());
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"mul(...)");
        return vector3f;
    }

    @NotNull
    public static final Vector3f unaryMinus(@NotNull Vector3f $this$unaryMinus) {
        Intrinsics.checkNotNullParameter((Object)$this$unaryMinus, (String)"<this>");
        Vector3f vector3f = $this$unaryMinus.negate(new Vector3f());
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"negate(...)");
        return vector3f;
    }

    @NotNull
    public static final Vector3f times(@NotNull Vector3f $this$times, @NotNull Vector3f other) {
        Intrinsics.checkNotNullParameter((Object)$this$times, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Vector3f vector3f = $this$times.mul((Vector3fc)other, new Vector3f());
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"mul(...)");
        return vector3f;
    }

    public static final int sum(@NotNull Vector3i $this$sum) {
        Intrinsics.checkNotNullParameter((Object)$this$sum, (String)"<this>");
        return $this$sum.x + $this$sum.y + $this$sum.z;
    }

    public static final boolean isZero(@NotNull BlockPos $this$isZero) {
        Intrinsics.checkNotNullParameter((Object)$this$isZero, (String)"<this>");
        return $this$isZero.getX() == 0 && $this$isZero.getY() == 0 && $this$isZero.getZ() == 0;
    }

    public static final int sum(@NotNull BlockPos $this$sum) {
        Intrinsics.checkNotNullParameter((Object)$this$sum, (String)"<this>");
        return $this$sum.getX() + $this$sum.getY() + $this$sum.getZ();
    }

    @NotNull
    public static final BlockPos negate(@NotNull BlockPos $this$negate) {
        Intrinsics.checkNotNullParameter((Object)$this$negate, (String)"<this>");
        return new BlockPos(-$this$negate.getX(), -$this$negate.getY(), -$this$negate.getZ());
    }
}

