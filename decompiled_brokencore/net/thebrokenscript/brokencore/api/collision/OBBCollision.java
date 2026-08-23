/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector3d
 */
package net.thebrokenscript.brokencore.api.collision;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.collision.OBB;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\bH\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u00c6\u0003J=\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\"H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006#"}, d2={"Lnet/thebrokenscript/brokencore/api/collision/OBBCollision;", "", "intersectionCenter", "Lorg/joml/Vector3d;", "cornerPoint", "side", "Lnet/thebrokenscript/brokencore/api/collision/OBB$Side;", "depth", "", "corner", "Lnet/thebrokenscript/brokencore/api/collision/OBB$Corner;", "<init>", "(Lorg/joml/Vector3d;Lorg/joml/Vector3d;Lnet/thebrokenscript/brokencore/api/collision/OBB$Side;DLnet/thebrokenscript/brokencore/api/collision/OBB$Corner;)V", "getIntersectionCenter", "()Lorg/joml/Vector3d;", "getCornerPoint", "getSide", "()Lnet/thebrokenscript/brokencore/api/collision/OBB$Side;", "getDepth", "()D", "getCorner", "()Lnet/thebrokenscript/brokencore/api/collision/OBB$Corner;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "brokencore-common"})
public final class OBBCollision {
    @NotNull
    private final Vector3d intersectionCenter;
    @NotNull
    private final Vector3d cornerPoint;
    @NotNull
    private final OBB.Side side;
    private final double depth;
    @Nullable
    private final OBB.Corner corner;

    public OBBCollision(@NotNull Vector3d intersectionCenter, @NotNull Vector3d cornerPoint, @NotNull OBB.Side side, double depth, @Nullable OBB.Corner corner) {
        Intrinsics.checkNotNullParameter((Object)intersectionCenter, (String)"intersectionCenter");
        Intrinsics.checkNotNullParameter((Object)cornerPoint, (String)"cornerPoint");
        Intrinsics.checkNotNullParameter((Object)((Object)side), (String)"side");
        this.intersectionCenter = intersectionCenter;
        this.cornerPoint = cornerPoint;
        this.side = side;
        this.depth = depth;
        this.corner = corner;
    }

    @NotNull
    public final Vector3d getIntersectionCenter() {
        return this.intersectionCenter;
    }

    @NotNull
    public final Vector3d getCornerPoint() {
        return this.cornerPoint;
    }

    @NotNull
    public final OBB.Side getSide() {
        return this.side;
    }

    public final double getDepth() {
        return this.depth;
    }

    @Nullable
    public final OBB.Corner getCorner() {
        return this.corner;
    }

    @NotNull
    public final Vector3d component1() {
        return this.intersectionCenter;
    }

    @NotNull
    public final Vector3d component2() {
        return this.cornerPoint;
    }

    @NotNull
    public final OBB.Side component3() {
        return this.side;
    }

    public final double component4() {
        return this.depth;
    }

    @Nullable
    public final OBB.Corner component5() {
        return this.corner;
    }

    @NotNull
    public final OBBCollision copy(@NotNull Vector3d intersectionCenter, @NotNull Vector3d cornerPoint, @NotNull OBB.Side side, double depth, @Nullable OBB.Corner corner) {
        Intrinsics.checkNotNullParameter((Object)intersectionCenter, (String)"intersectionCenter");
        Intrinsics.checkNotNullParameter((Object)cornerPoint, (String)"cornerPoint");
        Intrinsics.checkNotNullParameter((Object)((Object)side), (String)"side");
        return new OBBCollision(intersectionCenter, cornerPoint, side, depth, corner);
    }

    public static /* synthetic */ OBBCollision copy$default(OBBCollision oBBCollision, Vector3d vector3d, Vector3d vector3d2, OBB.Side side, double d, OBB.Corner corner, int n, Object object) {
        if ((n & 1) != 0) {
            vector3d = oBBCollision.intersectionCenter;
        }
        if ((n & 2) != 0) {
            vector3d2 = oBBCollision.cornerPoint;
        }
        if ((n & 4) != 0) {
            side = oBBCollision.side;
        }
        if ((n & 8) != 0) {
            d = oBBCollision.depth;
        }
        if ((n & 0x10) != 0) {
            corner = oBBCollision.corner;
        }
        return oBBCollision.copy(vector3d, vector3d2, side, d, corner);
    }

    @NotNull
    public String toString() {
        return "OBBCollision(intersectionCenter=" + this.intersectionCenter + ", cornerPoint=" + this.cornerPoint + ", side=" + this.side + ", depth=" + this.depth + ", corner=" + this.corner + ")";
    }

    public int hashCode() {
        int result = this.intersectionCenter.hashCode();
        result = result * 31 + this.cornerPoint.hashCode();
        result = result * 31 + this.side.hashCode();
        result = result * 31 + Double.hashCode(this.depth);
        result = result * 31 + (this.corner == null ? 0 : this.corner.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OBBCollision)) {
            return false;
        }
        OBBCollision oBBCollision = (OBBCollision)other;
        if (!Intrinsics.areEqual((Object)this.intersectionCenter, (Object)oBBCollision.intersectionCenter)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.cornerPoint, (Object)oBBCollision.cornerPoint)) {
            return false;
        }
        if (this.side != oBBCollision.side) {
            return false;
        }
        if (Double.compare(this.depth, oBBCollision.depth) != 0) {
            return false;
        }
        return this.corner == oBBCollision.corner;
    }
}

