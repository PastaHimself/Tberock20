/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.JvmInline
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Intersectiond
 *  org.joml.Vector3d
 *  org.joml.Vector3dc
 */
package net.thebrokenscript.brokencore.api.collision;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Intersectiond;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@JvmInline
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0087@\u0018\u0000 )2\u00020\u0001:\u0002()B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020!H\u00d6\u0001\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020%H\u00d6\u0001\u00a2\u0006\u0004\b&\u0010'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00a8\u0006*"}, d2={"Lnet/thebrokenscript/brokencore/api/collision/Plane;", "", "normal", "Lorg/joml/Vector3d;", "constructor-impl", "(Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "getPointSide", "Lnet/thebrokenscript/brokencore/api/collision/Plane$Side;", "p", "planePosition", "epsilon", "", "getPointSide-impl", "(Lorg/joml/Vector3d;Lorg/joml/Vector3d;Lorg/joml/Vector3d;D)Lnet/thebrokenscript/brokencore/api/collision/Plane$Side;", "getPointDistance", "getPointDistance-impl", "(Lorg/joml/Vector3d;Lorg/joml/Vector3d;Lorg/joml/Vector3d;)D", "raycast", "from", "facingNormal", "raycast-impl", "(Lorg/joml/Vector3d;Lorg/joml/Vector3d;Lorg/joml/Vector3d;Lorg/joml/Vector3d;D)Lorg/joml/Vector3d;", "to", "(Lorg/joml/Vector3d;Lorg/joml/Vector3d;Lorg/joml/Vector3d;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "closestPoint", "closestPoint-impl", "(Lorg/joml/Vector3d;Lorg/joml/Vector3d;Lorg/joml/Vector3d;)Lorg/joml/Vector3d;", "equals", "", "other", "equals-impl", "(Lorg/joml/Vector3d;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Lorg/joml/Vector3d;)I", "toString", "", "toString-impl", "(Lorg/joml/Vector3d;)Ljava/lang/String;", "Side", "Constants", "brokencore-common"})
public final class Plane {
    @NotNull
    private static final Constants Constants = new Constants(null);
    @NotNull
    private final Vector3d normal;
    @NotNull
    private static final Vector3d ZERO = new Vector3d(0.0);

    @NotNull
    public static final Side getPointSide-impl(Vector3d vector3d, @NotNull Vector3d p, @NotNull Vector3d planePosition, double epsilon) {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        Intrinsics.checkNotNullParameter((Object)planePosition, (String)"planePosition");
        double dot = new Vector3d((Vector3dc)vector3d).dot((Vector3dc)new Vector3d((Vector3dc)p).sub((Vector3dc)planePosition));
        return dot > epsilon ? Side.FRONT : (dot < -epsilon ? Side.BACK : Side.ON);
    }

    public static /* synthetic */ Side getPointSide-impl$default(Vector3d vector3d, Vector3d vector3d2, Vector3d vector3d3, double d, int n, Object object) {
        if ((n & 2) != 0) {
            vector3d3 = ZERO;
        }
        if ((n & 4) != 0) {
            d = 1.0E-5;
        }
        return Plane.getPointSide-impl(vector3d, vector3d2, vector3d3, d);
    }

    public static final double getPointDistance-impl(Vector3d vector3d, @NotNull Vector3d p, @NotNull Vector3d planePosition) {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        Intrinsics.checkNotNullParameter((Object)planePosition, (String)"planePosition");
        Vector3d p2 = new Vector3d((Vector3dc)p).sub((Vector3dc)planePosition);
        return Intersectiond.distancePointPlane((double)p2.x, (double)p2.y, (double)p2.z, (double)vector3d.x, (double)vector3d.y, (double)vector3d.z, (double)0.0);
    }

    public static /* synthetic */ double getPointDistance-impl$default(Vector3d vector3d, Vector3d vector3d2, Vector3d vector3d3, int n, Object object) {
        if ((n & 2) != 0) {
            vector3d3 = ZERO;
        }
        return Plane.getPointDistance-impl(vector3d, vector3d2, vector3d3);
    }

    @Nullable
    public static final Vector3d raycast-impl(Vector3d vector3d, @NotNull Vector3d from, @NotNull Vector3d facingNormal, @NotNull Vector3d planePosition, double epsilon) {
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        Intrinsics.checkNotNullParameter((Object)facingNormal, (String)"facingNormal");
        Intrinsics.checkNotNullParameter((Object)planePosition, (String)"planePosition");
        Vector3d from2 = new Vector3d((Vector3dc)from).sub((Vector3dc)planePosition);
        double t = Intersectiond.intersectRayPlane((double)from2.x, (double)from2.y, (double)from2.z, (double)facingNormal.x, (double)facingNormal.y, (double)facingNormal.z, (double)vector3d.x, (double)vector3d.y, (double)vector3d.z, (double)0.0, (double)epsilon);
        if (t < 0.0) {
            return null;
        }
        return new Vector3d((Vector3dc)facingNormal).mul(t).add((Vector3dc)from2);
    }

    public static /* synthetic */ Vector3d raycast-impl$default(Vector3d vector3d, Vector3d vector3d2, Vector3d vector3d3, Vector3d vector3d4, double d, int n, Object object) {
        if ((n & 4) != 0) {
            vector3d4 = ZERO;
        }
        if ((n & 8) != 0) {
            d = 1.0E-4;
        }
        return Plane.raycast-impl(vector3d, vector3d2, vector3d3, vector3d4, d);
    }

    @Nullable
    public static final Vector3d raycast-impl(Vector3d vector3d, @NotNull Vector3d from, @NotNull Vector3d to, @NotNull Vector3d planePosition) {
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        Intrinsics.checkNotNullParameter((Object)to, (String)"to");
        Intrinsics.checkNotNullParameter((Object)planePosition, (String)"planePosition");
        Vector3d from2 = new Vector3d((Vector3dc)from).sub((Vector3dc)planePosition);
        Vector3d to2 = new Vector3d((Vector3dc)to).sub((Vector3dc)planePosition);
        Vector3d result = new Vector3d();
        boolean valid = Intersectiond.intersectLineSegmentPlane((double)from2.x, (double)from2.y, (double)from2.z, (double)to2.x, (double)to2.y, (double)to2.z, (double)vector3d.x, (double)vector3d.y, (double)vector3d.z, (double)0.0, (Vector3d)result);
        return valid ? result : null;
    }

    public static /* synthetic */ Vector3d raycast-impl$default(Vector3d vector3d, Vector3d vector3d2, Vector3d vector3d3, Vector3d vector3d4, int n, Object object) {
        if ((n & 4) != 0) {
            vector3d4 = ZERO;
        }
        return Plane.raycast-impl(vector3d, vector3d2, vector3d3, vector3d4);
    }

    @NotNull
    public static final Vector3d closestPoint-impl(Vector3d vector3d, @NotNull Vector3d p, @NotNull Vector3d planePosition) {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        Intrinsics.checkNotNullParameter((Object)planePosition, (String)"planePosition");
        Vector3d vector3d2 = new Vector3d((Vector3dc)p).sub((Vector3dc)planePosition).mul((Vector3dc)vector3d);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"mul(...)");
        return vector3d2;
    }

    public static /* synthetic */ Vector3d closestPoint-impl$default(Vector3d vector3d, Vector3d vector3d2, Vector3d vector3d3, int n, Object object) {
        if ((n & 2) != 0) {
            vector3d3 = ZERO;
        }
        return Plane.closestPoint-impl(vector3d, vector3d2, vector3d3);
    }

    public static String toString-impl(Vector3d vector3d) {
        return "Plane(normal=" + vector3d + ")";
    }

    public String toString() {
        return Plane.toString-impl(this.normal);
    }

    public static int hashCode-impl(Vector3d vector3d) {
        return vector3d.hashCode();
    }

    public int hashCode() {
        return Plane.hashCode-impl(this.normal);
    }

    public static boolean equals-impl(Vector3d vector3d, Object other) {
        if (!(other instanceof Plane)) {
            return false;
        }
        return Intrinsics.areEqual((Object)vector3d, (Object)((Plane)other).unbox-impl());
    }

    public boolean equals(Object other) {
        return Plane.equals-impl(this.normal, other);
    }

    private /* synthetic */ Plane(Vector3d normal) {
        this.normal = normal;
    }

    @NotNull
    public static Vector3d constructor-impl(@NotNull Vector3d normal) {
        Intrinsics.checkNotNullParameter((Object)normal, (String)"normal");
        return normal;
    }

    public static final /* synthetic */ Plane box-impl(Vector3d v) {
        return new Plane(v);
    }

    public final /* synthetic */ Vector3d unbox-impl() {
        return this.normal;
    }

    public static final boolean equals-impl0(Vector3d p1, Vector3d p2) {
        return Intrinsics.areEqual((Object)p1, (Object)p2);
    }

    @NotNull
    public static final Vector3d getZERO() {
        return Constants.getZERO();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/collision/Plane$Constants;", "", "<init>", "()V", "ZERO", "Lorg/joml/Vector3d;", "getZERO$annotations", "getZERO", "()Lorg/joml/Vector3d;", "brokencore-common"})
    private static final class Constants {
        private Constants() {
        }

        @NotNull
        public final Vector3d getZERO() {
            return ZERO;
        }

        @JvmStatic
        public static /* synthetic */ void getZERO$annotations() {
        }

        public /* synthetic */ Constants(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/brokencore/api/collision/Plane$Side;", "", "<init>", "(Ljava/lang/String;I)V", "FRONT", "BACK", "ON", "brokencore-common"})
    public static final class Side
    extends Enum<Side> {
        public static final /* enum */ Side FRONT = new Side();
        public static final /* enum */ Side BACK = new Side();
        public static final /* enum */ Side ON = new Side();
        private static final /* synthetic */ Side[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static Side[] values() {
            return (Side[])$VALUES.clone();
        }

        public static Side valueOf(String value) {
            return Enum.valueOf(Side.class, value);
        }

        @NotNull
        public static EnumEntries<Side> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = sideArray = new Side[]{Side.FRONT, Side.BACK, Side.ON};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

