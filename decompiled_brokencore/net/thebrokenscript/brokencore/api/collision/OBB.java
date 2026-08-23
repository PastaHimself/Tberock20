/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.MapsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Intersectiond
 *  org.joml.Quaterniond
 *  org.joml.Quaterniondc
 *  org.joml.Vector2d
 *  org.joml.Vector3d
 *  org.joml.Vector3dc
 */
package net.thebrokenscript.brokencore.api.collision;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.collision.OBBCollision;
import net.thebrokenscript.brokencore.api.collision.Plane;
import net.thebrokenscript.brokencore.api.ext.BoundingBoxExtKt;
import net.thebrokenscript.brokencore.api.ext.JomlVecExtKt;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Intersectiond;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Vector2d;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 O2\u00020\u0001:\u0003OPQBQ\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eBA\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u0010B\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\u0004\b\r\u0010\u0014J\u000e\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0000J\u000e\u00104\u001a\u0002052\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u00107\u001a\u0004\u0018\u0001082\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u00107\u001a\u0004\u0018\u0001082\u0006\u00106\u001a\u00020\u0000J\u000e\u00109\u001a\u0002052\u0006\u0010:\u001a\u00020\nJ\u0018\u0010;\u001a\u0004\u0018\u00010\n2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nJ\u0018\u0010>\u001a\u0004\u0018\u00010\n2\u0006\u0010<\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nJ>\u0010@\u001a\u00020A26\u0010B\u001a2\u0012\u0013\u0012\u00110&\u00a2\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(G\u0012\u0004\u0012\u00020A0CJ>\u0010H\u001a\u00020A26\u0010B\u001a2\u0012\u0013\u0012\u001100\u00a2\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(F\u0012\u0013\u0012\u001101\u00a2\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020A0CJ\u000e\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u000200J\u001a\u0010L\u001a\u0004\u0018\u0001012\u0006\u0010K\u001a\u000200H\u0086\u0002\u00a2\u0006\u0004\bM\u0010NJ\u0011\u0010L\u001a\u00020\n2\u0006\u0010K\u001a\u00020&H\u0086\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n  *\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n  *\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R7\u0010$\u001a\u001e\u0012\f\u0012\n  *\u0004\u0018\u00010&0&\u0012\f\u0012\n  *\u0004\u0018\u00010\n0\n0%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u001b\u0010+\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010*\u001a\u0004\b,\u0010-R7\u0010/\u001a\u001e\u0012\f\u0012\n  *\u0004\u0018\u00010000\u0012\f\u0012\n  *\u0004\u0018\u000101010%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010*\u001a\u0004\b2\u0010(\u00a8\u0006R"}, d2={"Lnet/thebrokenscript/brokencore/api/collision/OBB;", "", "minX", "", "minY", "minZ", "maxX", "maxY", "maxZ", "yNormalInternal", "Lorg/joml/Vector3d;", "xNormalInternal", "zNormalInternal", "<init>", "(DDDDDDLorg/joml/Vector3d;Lorg/joml/Vector3d;Lorg/joml/Vector3d;)V", "up", "(DDDDDDLorg/joml/Vector3d;)V", "aabb", "Lnet/minecraft/world/phys/AABB;", "(Lnet/minecraft/world/phys/AABB;Lorg/joml/Vector3d;)V", "(Lnet/minecraft/world/phys/AABB;)V", "getMinX", "()D", "getMinY", "getMinZ", "getMaxX", "getMaxY", "getMaxZ", "minPosInternal", "maxPosInternal", "sizeInternal", "halfSizeInternal", "kotlin.jvm.PlatformType", "centerInternal", "quaternion", "Lorg/joml/Quaterniond;", "corners", "Ljava/util/EnumMap;", "Lnet/thebrokenscript/brokencore/api/collision/OBB$Corner;", "getCorners", "()Ljava/util/EnumMap;", "corners$delegate", "Lkotlin/Lazy;", "bounds", "getBounds", "()Lnet/minecraft/world/phys/AABB;", "bounds$delegate", "planes", "Lnet/thebrokenscript/brokencore/api/collision/OBB$Side;", "Lnet/thebrokenscript/brokencore/api/collision/Plane;", "getPlanes", "planes$delegate", "intersects", "", "obb", "clip", "Lnet/thebrokenscript/brokencore/api/collision/OBBCollision;", "contains", "p", "raycast", "from", "facingNormal", "raycastLineSegment", "to", "forEachCorner", "", "consumer", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "corner", "pos", "forEachSide", "plane", "getSideCenter", "side", "get", "get-tUbFSoI", "(Lnet/thebrokenscript/brokencore/api/collision/OBB$Side;)Lorg/joml/Vector3d;", "Constants", "Side", "Corner", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nOBB.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OBB.kt\nnet/thebrokenscript/brokencore/api/collision/OBB\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,237:1\n216#2,2:238\n216#2,2:240\n1869#3,2:242\n*S KotlinDebug\n*F\n+ 1 OBB.kt\nnet/thebrokenscript/brokencore/api/collision/OBB\n*L\n157#1:238,2\n192#1:240,2\n84#1:242,2\n*E\n"})
public final class OBB {
    @NotNull
    private static final Constants Constants = new Constants(null);
    private final double minX;
    private final double minY;
    private final double minZ;
    private final double maxX;
    private final double maxY;
    private final double maxZ;
    @NotNull
    private final Vector3d yNormalInternal;
    @NotNull
    private final Vector3d xNormalInternal;
    @NotNull
    private final Vector3d zNormalInternal;
    @NotNull
    private final Vector3d minPosInternal;
    @NotNull
    private final Vector3d maxPosInternal;
    @NotNull
    private final Vector3d sizeInternal;
    private final Vector3d halfSizeInternal;
    private final Vector3d centerInternal;
    @NotNull
    private final Quaterniond quaternion;
    @NotNull
    private final Lazy corners$delegate;
    @NotNull
    private final Lazy bounds$delegate;
    @NotNull
    private final Lazy planes$delegate;
    @NotNull
    private static final Vec3 HALF = new Vec3(0.5, 0.5, 0.5);

    private OBB(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, Vector3d yNormalInternal, Vector3d xNormalInternal, Vector3d zNormalInternal) {
        this.minX = minX;
        this.minY = minY;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
        this.yNormalInternal = yNormalInternal;
        this.xNormalInternal = xNormalInternal;
        this.zNormalInternal = zNormalInternal;
        this.minPosInternal = new Vector3d(this.minX, this.minY, this.minZ);
        this.maxPosInternal = new Vector3d(this.maxX, this.maxY, this.maxZ);
        this.sizeInternal = new Vector3d(this.maxX - this.minX, this.maxY - this.minY, this.maxZ - this.minZ);
        this.halfSizeInternal = new Vector3d((Vector3dc)this.sizeInternal).mul(0.5);
        this.centerInternal = new Vector3d((Vector3dc)this.minPosInternal).add((Vector3dc)this.halfSizeInternal);
        this.quaternion = new Quaterniond(this.yNormalInternal.x, this.yNormalInternal.y, this.yNormalInternal.z, 1.0);
        this.corners$delegate = LazyKt.lazy(() -> OBB.corners_delegate$lambda$0(this));
        this.bounds$delegate = LazyKt.lazy(() -> OBB.bounds_delegate$lambda$0(this));
        this.planes$delegate = LazyKt.lazy(() -> OBB.planes_delegate$lambda$0(this));
    }

    public final double getMinX() {
        return this.minX;
    }

    public final double getMinY() {
        return this.minY;
    }

    public final double getMinZ() {
        return this.minZ;
    }

    public final double getMaxX() {
        return this.maxX;
    }

    public final double getMaxY() {
        return this.maxY;
    }

    public final double getMaxZ() {
        return this.maxZ;
    }

    public OBB(double minX, double minY, double minZ, double maxX, double maxY, double maxZ, @NotNull Vector3d up) {
        Intrinsics.checkNotNullParameter((Object)up, (String)"up");
        Vector3d vector3d = new Vector3d((Vector3dc)up);
        Vector3d vector3d2 = new Vector3d((Vector3dc)up).rotateX(1.5708);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"rotateX(...)");
        Vector3d vector3d3 = new Vector3d((Vector3dc)up).rotateZ(1.5708);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d3, (String)"rotateZ(...)");
        this(minX, minY, minZ, maxX, maxY, maxZ, vector3d, vector3d2, vector3d3);
    }

    public OBB(@NotNull AABB aabb, @NotNull Vector3d up) {
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
        Intrinsics.checkNotNullParameter((Object)up, (String)"up");
        this(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ, up);
    }

    public OBB(@NotNull AABB aabb) {
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
        this(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ, new Vector3d(0.0, 1.0, 0.0));
    }

    private final EnumMap<Corner, Vector3d> getCorners() {
        Lazy lazy = this.corners$delegate;
        return (EnumMap)lazy.getValue();
    }

    private final AABB getBounds() {
        Lazy lazy = this.bounds$delegate;
        return (AABB)lazy.getValue();
    }

    private final EnumMap<Side, Plane> getPlanes() {
        Lazy lazy = this.planes$delegate;
        return (EnumMap)lazy.getValue();
    }

    public final boolean intersects(@NotNull OBB obb) {
        Intrinsics.checkNotNullParameter((Object)obb, (String)"obb");
        return Intersectiond.testObOb((Vector3d)this.centerInternal, (Vector3d)this.xNormalInternal, (Vector3d)this.yNormalInternal, (Vector3d)this.zNormalInternal, (Vector3d)this.halfSizeInternal, (Vector3d)obb.centerInternal, (Vector3d)obb.xNormalInternal, (Vector3d)obb.yNormalInternal, (Vector3d)obb.zNormalInternal, (Vector3d)obb.halfSizeInternal);
    }

    public final boolean intersects(@NotNull AABB aabb) {
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
        Vec3 vec3 = aabb.getCenter();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
        Vector3d vector3d = MiscExt.toVector3d(vec3);
        Vector3d vector3d2 = new Vector3d(1.0, 0.0, 0.0);
        Vector3d vector3d3 = new Vector3d(0.0, 1.0, 0.0);
        Vector3d vector3d4 = new Vector3d(0.0, 0.0, 1.0);
        Vec3 vec32 = BoundingBoxExtKt.getSizeBox(aabb).multiply(HALF);
        Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"multiply(...)");
        return Intersectiond.testObOb((Vector3d)this.centerInternal, (Vector3d)this.xNormalInternal, (Vector3d)this.yNormalInternal, (Vector3d)this.zNormalInternal, (Vector3d)this.halfSizeInternal, (Vector3d)vector3d, (Vector3d)vector3d2, (Vector3d)vector3d3, (Vector3d)vector3d4, (Vector3d)MiscExt.toVector3d(vec32));
    }

    @Nullable
    public final OBBCollision clip(@NotNull AABB aabb) {
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
        return this.clip(new OBB(aabb));
    }

    @Nullable
    public final OBBCollision clip(@NotNull OBB obb) {
        Vector3d pos;
        Corner c;
        Intrinsics.checkNotNullParameter((Object)obb, (String)"obb");
        Corner corner = null;
        Vector3d point = null;
        double depth = 0.0;
        Vector3d cornerPos = null;
        for (Map.Entry entry : ((Map)this.getCorners()).entrySet()) {
            c = (Corner)((Object)entry.getKey());
            pos = (Vector3d)entry.getValue();
            if (cornerPos == null) {
                Intrinsics.checkNotNull((Object)pos);
                if (!obb.contains(pos)) continue;
                cornerPos = pos;
                corner = c;
                continue;
            }
            Intrinsics.checkNotNull((Object)pos);
            if (!obb.contains(pos)) continue;
            return null;
        }
        if (corner == null) {
            for (Map.Entry entry : ((Map)obb.getCorners()).entrySet()) {
                c = (Corner)((Object)entry.getKey());
                pos = (Vector3d)entry.getValue();
                if (cornerPos == null) {
                    Intrinsics.checkNotNull((Object)pos);
                    if (!this.contains(pos)) continue;
                    cornerPos = pos;
                    corner = c;
                    continue;
                }
                Intrinsics.checkNotNull((Object)pos);
                if (!this.contains(pos)) continue;
                return null;
            }
        }
        if (corner == null || cornerPos == null) {
            return null;
        }
        Vector3d vector3d = this.centerInternal;
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"centerInternal");
        Vector3d vector3d2 = obb.raycastLineSegment(vector3d, cornerPos);
        if (vector3d2 == null) {
            return null;
        }
        point = vector3d2;
        depth = point.distance((Vector3dc)cornerPos);
        Map $this$forEach$iv = this.getPlanes();
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Vector3d plane;
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator.next();
            boolean bl = false;
            Side side = (Side)((Object)entry.getKey());
            Plane plane2 = (Plane)entry.getValue();
            Vector3d vector3d3 = plane = plane2 != null ? plane2.unbox-impl() : null;
            Intrinsics.checkNotNull((Object)(vector3d3 != null ? Plane.box-impl(vector3d3) : null));
            Intrinsics.checkNotNull((Object)((Object)side));
            if (Plane.getPointSide-impl$default(plane, this.getSideCenter(side), null, 0.0, 6, null) != Plane.Side.ON) continue;
            return new OBBCollision(point, cornerPos, side, depth, corner);
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean contains(@NotNull Vector3d p) {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        Vector3d p2 = new Vector3d((Vector3dc)p).rotate((Quaterniondc)this.quaternion);
        double d = this.minPosInternal.x;
        double d2 = this.maxPosInternal.x;
        double d3 = p2.x;
        if (!(d <= d3)) return false;
        if (!(d3 <= d2)) return false;
        boolean bl = true;
        if (!bl) return false;
        d = this.minPosInternal.y;
        d2 = this.maxPosInternal.y;
        d3 = p2.y;
        if (!(d <= d3)) return false;
        if (!(d3 <= d2)) return false;
        boolean bl2 = true;
        if (!bl2) return false;
        d = this.minPosInternal.z;
        d2 = this.maxPosInternal.z;
        d3 = p2.z;
        if (!(d <= d3)) return false;
        if (!(d3 <= d2)) return false;
        return true;
    }

    @Nullable
    public final Vector3d raycast(@NotNull Vector3d from, @NotNull Vector3d facingNormal) {
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        Intrinsics.checkNotNullParameter((Object)facingNormal, (String)"facingNormal");
        Vector3d from2 = new Vector3d((Vector3dc)from).rotate((Quaterniondc)this.quaternion);
        Vector2d result = new Vector2d();
        boolean valid = Intersectiond.intersectRayAab((Vector3dc)((Vector3dc)from2), (Vector3dc)((Vector3dc)facingNormal), (Vector3dc)((Vector3dc)this.minPosInternal), (Vector3dc)((Vector3dc)this.maxPosInternal), (Vector2d)result);
        return valid ? new Vector3d((Vector3dc)facingNormal).mul(result.x).add((Vector3dc)from2.rotate((Quaterniondc)new Quaterniond((Quaterniondc)this.quaternion).conjugate())) : null;
    }

    @Nullable
    public final Vector3d raycastLineSegment(@NotNull Vector3d from, @NotNull Vector3d to) {
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        Intrinsics.checkNotNullParameter((Object)to, (String)"to");
        Vector3d from2 = new Vector3d((Vector3dc)from).rotate((Quaterniondc)this.quaternion);
        Vector3d to2 = new Vector3d((Vector3dc)to).rotate((Quaterniondc)this.quaternion);
        Vector2d result = new Vector2d();
        boolean valid = Intersectiond.intersectLineSegmentAab((Vector3dc)((Vector3dc)from2), (Vector3dc)((Vector3dc)to2), (Vector3dc)((Vector3dc)this.minPosInternal), (Vector3dc)((Vector3dc)this.maxPosInternal), (Vector2d)result) > 0;
        return valid ? new Vector3d((Vector3dc)from2).add((Vector3dc)to2.sub((Vector3dc)from2).mul(result.x)).rotate((Quaterniondc)new Quaterniond((Quaterniondc)this.quaternion).conjugate()) : null;
    }

    public final void forEachCorner(@NotNull Function2<? super Corner, ? super Vector3d, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        Map $this$forEach$iv = this.getCorners();
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator.next();
            boolean bl = false;
            Corner corner = (Corner)((Object)entry.getKey());
            Vector3d d = (Vector3d)entry.getValue();
            Intrinsics.checkNotNull((Object)((Object)corner));
            consumer.invoke((Object)corner, (Object)new Vector3d((Vector3dc)d));
        }
    }

    public final void forEachSide(@NotNull Function2<? super Side, ? super Plane, Unit> consumer) {
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        this.getPlanes().forEach((arg_0, arg_1) -> OBB.forEachSide$lambda$0(consumer, arg_0, arg_1));
    }

    @NotNull
    public final Vector3d getSideCenter(@NotNull Side side) {
        Intrinsics.checkNotNullParameter((Object)((Object)side), (String)"side");
        double x = side.getPositiveX() ? this.halfSizeInternal.x : -this.halfSizeInternal.x;
        double y = side.getPositiveY() ? this.halfSizeInternal.y : -this.halfSizeInternal.y;
        double z = side.getPositiveZ() ? this.halfSizeInternal.z : -this.halfSizeInternal.z;
        Vector3d normal = new Vector3d((Vector3dc)(switch (WhenMappings.$EnumSwitchMapping$0[side.getAxis().ordinal()]) {
            case 1 -> this.xNormalInternal;
            case 2 -> this.yNormalInternal;
            case 3 -> this.zNormalInternal;
            default -> throw new NoWhenBranchMatchedException();
        }));
        Vector3d vector3d = new Vector3d((Vector3dc)this.centerInternal).add((Vector3dc)normal.mul(x, y, z));
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"add(...)");
        return vector3d;
    }

    @Nullable
    public final Vector3d get-tUbFSoI(@NotNull Side side) {
        Intrinsics.checkNotNullParameter((Object)((Object)side), (String)"side");
        Plane plane = this.getPlanes().get((Object)side);
        return plane != null ? plane.unbox-impl() : null;
    }

    @NotNull
    public final Vector3d get(@NotNull Corner side) {
        Intrinsics.checkNotNullParameter((Object)((Object)side), (String)"side");
        return new Vector3d((Vector3dc)this.getCorners().get((Object)side));
    }

    private static final EnumMap corners_delegate$lambda$0(OBB this$0) {
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)((Object)Corner.TNW), (Object)new Vector3d(this$0.minX, this$0.maxY, this$0.minZ).rotate((Quaterniondc)this$0.quaternion)), TuplesKt.to((Object)((Object)Corner.TSW), (Object)new Vector3d(this$0.minX, this$0.maxY, this$0.maxZ).rotate((Quaterniondc)this$0.quaternion)), TuplesKt.to((Object)((Object)Corner.TNE), (Object)new Vector3d(this$0.maxX, this$0.maxY, this$0.minZ).rotate((Quaterniondc)this$0.quaternion)), TuplesKt.to((Object)((Object)Corner.TSE), (Object)new Vector3d(this$0.maxX, this$0.maxY, this$0.maxZ).rotate((Quaterniondc)this$0.quaternion)), TuplesKt.to((Object)((Object)Corner.BNW), (Object)new Vector3d(this$0.minX, this$0.minY, this$0.minZ).rotate((Quaterniondc)this$0.quaternion)), TuplesKt.to((Object)((Object)Corner.BSW), (Object)new Vector3d(this$0.minX, this$0.minY, this$0.maxZ).rotate((Quaterniondc)this$0.quaternion)), TuplesKt.to((Object)((Object)Corner.BNE), (Object)new Vector3d(this$0.maxX, this$0.minY, this$0.minZ).rotate((Quaterniondc)this$0.quaternion)), TuplesKt.to((Object)((Object)Corner.BSE), (Object)new Vector3d(this$0.maxX, this$0.minY, this$0.maxZ).rotate((Quaterniondc)this$0.quaternion))};
        return new EnumMap(MapsKt.mapOf((Pair[])pairArray));
    }

    private static final AABB bounds_delegate$lambda$0(OBB this$0) {
        Vector3d mi = new Vector3d(Double.POSITIVE_INFINITY);
        Vector3d mx = new Vector3d(Double.NEGATIVE_INFINITY);
        Collection<Vector3d> collection = this$0.getCorners().values();
        Intrinsics.checkNotNullExpressionValue(collection, (String)"<get-values>(...)");
        Iterable $this$forEach$iv = collection;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Vector3d it = (Vector3d)element$iv;
            boolean bl = false;
            mi.min((Vector3dc)it);
            mx.min((Vector3dc)it);
        }
        return new AABB(JomlVecExtKt.toVec3(mi), JomlVecExtKt.toVec3(mx));
    }

    private static final EnumMap planes_delegate$lambda$0(OBB this$0) {
        Pair[] pairArray = new Pair[6];
        pairArray[0] = TuplesKt.to((Object)((Object)Side.U), (Object)Plane.box-impl(Plane.constructor-impl(this$0.yNormalInternal)));
        Vector3d vector3d = new Vector3d((Vector3dc)this$0.yNormalInternal).negate();
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"negate(...)");
        pairArray[1] = TuplesKt.to((Object)((Object)Side.D), (Object)Plane.box-impl(Plane.constructor-impl(vector3d)));
        pairArray[2] = TuplesKt.to((Object)((Object)Side.F), (Object)Plane.box-impl(Plane.constructor-impl(this$0.zNormalInternal)));
        Vector3d vector3d2 = new Vector3d((Vector3dc)this$0.zNormalInternal).negate();
        Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"negate(...)");
        pairArray[3] = TuplesKt.to((Object)((Object)Side.B), (Object)Plane.box-impl(Plane.constructor-impl(vector3d2)));
        pairArray[4] = TuplesKt.to((Object)((Object)Side.L), (Object)Plane.box-impl(Plane.constructor-impl(this$0.xNormalInternal)));
        Vector3d vector3d3 = new Vector3d((Vector3dc)this$0.xNormalInternal).negate();
        Intrinsics.checkNotNullExpressionValue((Object)vector3d3, (String)"negate(...)");
        pairArray[5] = TuplesKt.to((Object)((Object)Side.R), (Object)Plane.box-impl(Plane.constructor-impl(vector3d3)));
        return new EnumMap(MapsKt.mapOf((Pair[])pairArray));
    }

    private static final void forEachSide$lambda$0(Function2 $tmp0, Object p0, Object p1) {
        $tmp0.invoke(p0, p1);
    }

    @NotNull
    public static final Vec3 getHALF() {
        return Constants.getHALF();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/collision/OBB$Constants;", "", "<init>", "()V", "HALF", "Lnet/minecraft/world/phys/Vec3;", "getHALF$annotations", "getHALF", "()Lnet/minecraft/world/phys/Vec3;", "brokencore-common"})
    private static final class Constants {
        private Constants() {
        }

        @NotNull
        public final Vec3 getHALF() {
            return HALF;
        }

        @JvmStatic
        public static /* synthetic */ void getHALF$annotations() {
        }

        public /* synthetic */ Constants(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/collision/OBB$Corner;", "", "<init>", "(Ljava/lang/String;I)V", "TNW", "TSW", "TNE", "TSE", "BNW", "BSW", "BNE", "BSE", "brokencore-common"})
    public static final class Corner
    extends Enum<Corner> {
        public static final /* enum */ Corner TNW = new Corner();
        public static final /* enum */ Corner TSW = new Corner();
        public static final /* enum */ Corner TNE = new Corner();
        public static final /* enum */ Corner TSE = new Corner();
        public static final /* enum */ Corner BNW = new Corner();
        public static final /* enum */ Corner BSW = new Corner();
        public static final /* enum */ Corner BNE = new Corner();
        public static final /* enum */ Corner BSE = new Corner();
        private static final /* synthetic */ Corner[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static Corner[] values() {
            return (Corner[])$VALUES.clone();
        }

        public static Corner valueOf(String value) {
            return Enum.valueOf(Corner.class, value);
        }

        @NotNull
        public static EnumEntries<Corner> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = cornerArray = new Corner[]{Corner.TNW, Corner.TSW, Corner.TNE, Corner.TSE, Corner.BNW, Corner.BSW, Corner.BNE, Corner.BSE};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/collision/OBB$Side;", "", "positiveX", "", "positiveY", "positiveZ", "axis", "Lnet/minecraft/core/Direction$Axis;", "<init>", "(Ljava/lang/String;IZZZLnet/minecraft/core/Direction$Axis;)V", "getPositiveX", "()Z", "getPositiveY", "getPositiveZ", "getAxis", "()Lnet/minecraft/core/Direction$Axis;", "U", "D", "F", "B", "L", "R", "brokencore-common"})
    public static final class Side
    extends Enum<Side> {
        private final boolean positiveX;
        private final boolean positiveY;
        private final boolean positiveZ;
        @NotNull
        private final Direction.Axis axis;
        public static final /* enum */ Side U = new Side(true, true, true, Direction.Axis.Y);
        public static final /* enum */ Side D = new Side(true, false, true, Direction.Axis.Y);
        public static final /* enum */ Side F = new Side(true, true, false, Direction.Axis.Z);
        public static final /* enum */ Side B = new Side(true, true, true, Direction.Axis.Z);
        public static final /* enum */ Side L = new Side(false, true, true, Direction.Axis.X);
        public static final /* enum */ Side R = new Side(true, true, true, Direction.Axis.X);
        private static final /* synthetic */ Side[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private Side(boolean positiveX, boolean positiveY, boolean positiveZ, Direction.Axis axis) {
            this.positiveX = positiveX;
            this.positiveY = positiveY;
            this.positiveZ = positiveZ;
            this.axis = axis;
        }

        public final boolean getPositiveX() {
            return this.positiveX;
        }

        public final boolean getPositiveY() {
            return this.positiveY;
        }

        public final boolean getPositiveZ() {
            return this.positiveZ;
        }

        @NotNull
        public final Direction.Axis getAxis() {
            return this.axis;
        }

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
            $VALUES = sideArray = new Side[]{Side.U, Side.D, Side.F, Side.B, Side.L, Side.R};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Direction.Axis.values().length];
            try {
                nArray[Direction.Axis.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.Axis.Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.Axis.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

