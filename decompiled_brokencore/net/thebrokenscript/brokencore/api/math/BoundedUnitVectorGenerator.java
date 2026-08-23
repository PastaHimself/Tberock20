/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3d
 *  org.joml.Vector3dc
 */
package net.thebrokenscript.brokencore.api.math;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.thebrokenscript.brokencore.api.global.GlobalMathKt;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3dc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0011\u001a\u00020\u0003J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003J\u0016\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/brokencore/api/math/BoundedUnitVectorGenerator;", "", "coneDirectionVector", "Lorg/joml/Vector3d;", "coneRadiusDegrees", "", "<init>", "(Lorg/joml/Vector3d;D)V", "getConeDirectionVector", "()Lorg/joml/Vector3d;", "radiusRadians", "getRadiusRadians", "()D", "v", "getConeRadiusDegrees", "setConeRadiusDegrees", "(D)V", "generate", "pointInCone", "", "origin", "point", "pointAngleDist", "angleDist", "a", "b", "brokencore-common"})
public final class BoundedUnitVectorGenerator {
    @NotNull
    private final Vector3d coneDirectionVector;
    private double coneRadiusDegrees;

    public BoundedUnitVectorGenerator(@NotNull Vector3d coneDirectionVector, double coneRadiusDegrees) {
        Intrinsics.checkNotNullParameter((Object)coneDirectionVector, (String)"coneDirectionVector");
        this.coneDirectionVector = coneDirectionVector;
        this.coneRadiusDegrees = coneRadiusDegrees;
    }

    @NotNull
    public final Vector3d getConeDirectionVector() {
        return this.coneDirectionVector;
    }

    private final double getRadiusRadians() {
        return GlobalMathKt.getToRadians(this.coneRadiusDegrees);
    }

    public final double getConeRadiusDegrees() {
        return this.coneRadiusDegrees;
    }

    public final void setConeRadiusDegrees(double v) {
        Math.max(Math.min(360.0, v), 0.0);
    }

    @NotNull
    public final Vector3d generate() {
        Vector3d vector3d = new Vector3d((Vector3dc)this.coneDirectionVector).rotateX(BoundedUnitVectorGenerator.generate$gen(this)).rotateY(BoundedUnitVectorGenerator.generate$gen(this)).rotateZ(BoundedUnitVectorGenerator.generate$gen(this));
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"rotateZ(...)");
        return vector3d;
    }

    public final boolean pointInCone(@NotNull Vector3d origin, @NotNull Vector3d point) {
        Intrinsics.checkNotNullParameter((Object)origin, (String)"origin");
        Intrinsics.checkNotNullParameter((Object)point, (String)"point");
        return this.pointAngleDist(origin, point) <= this.getRadiusRadians() * 0.5;
    }

    public final double pointAngleDist(@NotNull Vector3d origin, @NotNull Vector3d point) {
        Intrinsics.checkNotNullParameter((Object)origin, (String)"origin");
        Intrinsics.checkNotNullParameter((Object)point, (String)"point");
        Vector3d vector3d = new Vector3d((Vector3dc)origin).sub((Vector3dc)point);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"sub(...)");
        return this.angleDist(vector3d, this.coneDirectionVector);
    }

    private final double angleDist(Vector3d a, Vector3d b) {
        double magA = Math.sqrt(a.x * a.x + a.y * a.y + a.z * a.z);
        double magB = Math.sqrt(b.x * b.x + b.y * b.y + b.z * b.z);
        double dot = a.x * b.x + a.y * b.y + a.z * b.z;
        double mag = magA * magB;
        return Math.acos(dot / mag);
    }

    private static final double generate$gen(BoundedUnitVectorGenerator this$0) {
        return Random.Default.nextDouble(this$0.coneRadiusDegrees * 0.5 / -180.0, this$0.coneRadiusDegrees * 0.5 / 180.0) * Math.PI;
    }
}

