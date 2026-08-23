/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.math.MathKt
 *  net.minecraft.util.Mth
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.phys.Vec2
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Math
 *  org.joml.Vector3d
 *  org.joml.Vector3dc
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import org.jetbrains.annotations.NotNull;
import org.joml.Math;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=5, xi=48, d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u001e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001\u001a\u0012\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001\u001a\u001a\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b\u001a\u001a\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b\u001a\u001a\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b\u001a\u001a\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0012\u0010\f\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\n\u001a\u00020\u001b\u001a\u0012\u0010\u001c\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003\u001a\u0015\u0010\u001f\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\n\u001a\u00020\u0003H\u0086\u0002\u001a\u0015\u0010 \u001a\u00020\u001d*\u00020\u001d2\u0006\u0010\n\u001a\u00020\u0003H\u0086\u0004\u001a\u001a\u0010!\u001a\u00020\"*\u00020\"2\u0006\u0010\n\u001a\u00020\"2\u0006\u0010#\u001a\u00020\b\"\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006$"}, d2={"v3", "Lorg/joml/Vector3f;", "x", "", "y", "z", "nv3", "horizDist", "", "Lorg/joml/Vector3fc;", "other", "Lnet/minecraft/world/phys/Vec3;", "normalFacing", "center", "max", "rotatedAroundX", "centerX", "rotationDeg", "rotatedAroundY", "centerY", "rotatedAroundZ", "centerZ", "rotatedAround", "asScaleIsVisible", "", "getAsScaleIsVisible", "(Lorg/joml/Vector3f;)Z", "Lorg/joml/Vector3d;", "floorDiv", "Lnet/minecraft/world/level/ChunkPos;", "factor", "times", "overBy", "lerp", "Lnet/minecraft/world/phys/Vec2;", "delta", "brokencore-common"}, xs="net/thebrokenscript/brokencore/api/dsl/PositionUtil")
final class PositionUtil__PositionDSLKt {
    @NotNull
    public static final Vector3f v3(@NotNull Number x, @NotNull Number y, @NotNull Number z) {
        Intrinsics.checkNotNullParameter((Object)x, (String)"x");
        Intrinsics.checkNotNullParameter((Object)y, (String)"y");
        Intrinsics.checkNotNullParameter((Object)z, (String)"z");
        return new Vector3f(x.floatValue(), y.floatValue(), z.floatValue());
    }

    @NotNull
    public static final Vector3f nv3(@NotNull Number x, @NotNull Number y, @NotNull Number z) {
        Intrinsics.checkNotNullParameter((Object)x, (String)"x");
        Intrinsics.checkNotNullParameter((Object)y, (String)"y");
        Intrinsics.checkNotNullParameter((Object)z, (String)"z");
        Vector3f vector3f = new Vector3f(x.floatValue(), y.floatValue(), z.floatValue()).normalize();
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"normalize(...)");
        return vector3f;
    }

    public static final float horizDist(@NotNull Vector3fc $this$horizDist, @NotNull Vec3 other) {
        Intrinsics.checkNotNullParameter((Object)$this$horizDist, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return Mth.sqrt((float)(Mth.square((float)((float)other.x - $this$horizDist.x())) + Mth.square((float)((float)other.y + $this$horizDist.y()))));
    }

    @NotNull
    public static final Vector3f normalFacing(@NotNull Vector3f $this$normalFacing, @NotNull Vector3f other) {
        Intrinsics.checkNotNullParameter((Object)$this$normalFacing, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Vector3f vector3f = new Vector3f((Vector3fc)other).sub((Vector3fc)$this$normalFacing).normalize();
        Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"normalize(...)");
        return vector3f;
    }

    @NotNull
    public static final Vector3f center(@NotNull Vector3f $this$center, @NotNull Vector3f max) {
        Intrinsics.checkNotNullParameter((Object)$this$center, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        return new Vector3f(Mth.lerp((float)0.5f, (float)$this$center.x, (float)max.x), Mth.lerp((float)0.5f, (float)$this$center.y, (float)max.y), Mth.lerp((float)0.5f, (float)$this$center.z, (float)max.z));
    }

    @NotNull
    public static final Vector3f rotatedAroundX(@NotNull Vector3f $this$rotatedAroundX, float centerX, float rotationDeg) {
        Intrinsics.checkNotNullParameter((Object)$this$rotatedAroundX, (String)"<this>");
        float rot = (float)Math.toRadians((double)rotationDeg);
        Vector3f newVec = new Vector3f((Vector3fc)$this$rotatedAroundX);
        newVec.add(centerX, 0.0f, 0.0f);
        newVec.rotateX(rot);
        newVec.sub(centerX, 0.0f, 0.0f);
        return newVec;
    }

    @NotNull
    public static final Vector3f rotatedAroundY(@NotNull Vector3f $this$rotatedAroundY, float centerY, float rotationDeg) {
        Intrinsics.checkNotNullParameter((Object)$this$rotatedAroundY, (String)"<this>");
        float rot = (float)Math.toRadians((double)rotationDeg);
        Vector3f newVec = new Vector3f((Vector3fc)$this$rotatedAroundY);
        newVec.add(0.0f, centerY, 0.0f);
        newVec.rotateY(rot);
        newVec.sub(0.0f, centerY, 0.0f);
        return newVec;
    }

    @NotNull
    public static final Vector3f rotatedAroundZ(@NotNull Vector3f $this$rotatedAroundZ, float centerZ, float rotationDeg) {
        Intrinsics.checkNotNullParameter((Object)$this$rotatedAroundZ, (String)"<this>");
        float rot = (float)Math.toRadians((double)rotationDeg);
        Vector3f newVec = new Vector3f((Vector3fc)$this$rotatedAroundZ);
        newVec.add(0.0f, 0.0f, centerZ);
        newVec.rotateZ(rot);
        newVec.sub(0.0f, 0.0f, centerZ);
        return newVec;
    }

    @NotNull
    public static final Vector3f rotatedAround(@NotNull Vector3f $this$rotatedAround, @NotNull Vector3f center, @NotNull Vector3f rotationDeg) {
        Intrinsics.checkNotNullParameter((Object)$this$rotatedAround, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)center, (String)"center");
        Intrinsics.checkNotNullParameter((Object)rotationDeg, (String)"rotationDeg");
        return PositionUtil.rotatedAroundZ(PositionUtil.rotatedAroundY(PositionUtil.rotatedAroundX($this$rotatedAround, center.x, rotationDeg.x), center.y, rotationDeg.y), center.z, rotationDeg.z);
    }

    public static final boolean getAsScaleIsVisible(@NotNull Vector3f $this$asScaleIsVisible) {
        Intrinsics.checkNotNullParameter((Object)$this$asScaleIsVisible, (String)"<this>");
        Vector3f $this$_get_asScaleIsVisible__u24lambda_u240 = $this$asScaleIsVisible;
        boolean bl = false;
        int i = 0;
        if (!($this$_get_asScaleIsVisible__u24lambda_u240.x == 0.0f)) {
            ++i;
        }
        if (!($this$_get_asScaleIsVisible__u24lambda_u240.y == 0.0f)) {
            ++i;
        }
        if (!($this$_get_asScaleIsVisible__u24lambda_u240.z == 0.0f)) {
            ++i;
        }
        return i > 1;
    }

    @NotNull
    public static final Vector3d normalFacing(@NotNull Vector3d $this$normalFacing, @NotNull Vector3d other) {
        Intrinsics.checkNotNullParameter((Object)$this$normalFacing, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        Vector3d vector3d = new Vector3d((Vector3dc)other).sub((Vector3dc)$this$normalFacing).normalize();
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"normalize(...)");
        return vector3d;
    }

    @NotNull
    public static final ChunkPos floorDiv(@NotNull ChunkPos $this$floorDiv, @NotNull Number factor) {
        Intrinsics.checkNotNullParameter((Object)$this$floorDiv, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)factor, (String)"factor");
        int n = $this$floorDiv.x;
        int n2 = factor.intValue();
        int n3 = n / n2;
        if ((n ^ n2) >= 0 || n3 * n2 != n) {
            // empty if block
        }
        int n4 = --n3;
        n = $this$floorDiv.z;
        n2 = factor.intValue();
        n3 = n / n2;
        if ((n ^ n2) < 0 && n3 * n2 != n) {
            --n3;
        }
        return new ChunkPos(n4, n3);
    }

    @NotNull
    public static final ChunkPos times(@NotNull ChunkPos $this$times, @NotNull Number other) {
        Intrinsics.checkNotNullParameter((Object)$this$times, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return new ChunkPos(MathKt.roundToInt((float)((float)$this$times.x * other.floatValue())), MathKt.roundToInt((float)((float)$this$times.z * other.floatValue())));
    }

    @NotNull
    public static final ChunkPos overBy(@NotNull ChunkPos $this$overBy, @NotNull Number other) {
        Intrinsics.checkNotNullParameter((Object)$this$overBy, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return new ChunkPos(MathKt.roundToInt((float)((float)$this$overBy.x + other.floatValue())), MathKt.roundToInt((float)((float)$this$overBy.z + other.floatValue())));
    }

    @NotNull
    public static final Vec2 lerp(@NotNull Vec2 $this$lerp, @NotNull Vec2 other, float delta) {
        Intrinsics.checkNotNullParameter((Object)$this$lerp, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return new Vec2(Mth.lerp((float)delta, (float)$this$lerp.x, (float)other.x), Mth.lerp((float)delta, (float)$this$lerp.y, (float)other.y));
    }
}

