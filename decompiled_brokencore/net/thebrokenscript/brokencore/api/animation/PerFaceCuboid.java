/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.mojang.blaze3d.vertex.PoseStack$Pose
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Unit
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.model.geom.ModelPart$Cube
 *  net.minecraft.core.Direction
 *  net.minecraft.util.FastColor$ARGB32
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Matrix4f
 *  org.joml.Vector2f
 *  org.joml.Vector2fc
 *  org.joml.Vector3f
 *  org.joml.Vector4f
 */
package net.thebrokenscript.brokencore.api.animation;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.Direction;
import net.minecraft.util.FastColor;
import net.thebrokenscript.brokencore.api.animation.BedrockTransform;
import net.thebrokenscript.brokencore.api.annotation.ExperimentalAnimationApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector3f;
import org.joml.Vector4f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000289BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\u0004\b\u000f\u0010\u0010J0\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\nH\u00c6\u0003J\u0015\u00100\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u00c6\u0003Je\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u00c6\u0001J\u0013\u00102\u001a\u00020\n2\b\u00103\u001a\u0004\u0018\u000104H\u00d6\u0003J\t\u00105\u001a\u00020&H\u00d6\u0001J\t\u00106\u001a\u000207H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/PerFaceCuboid;", "Lnet/minecraft/client/model/geom/ModelPart$Cube;", "originX", "", "originY", "originZ", "dimensionX", "dimensionY", "dimensionZ", "mirror", "", "visibleFaces", "", "Lnet/minecraft/core/Direction;", "Lorg/joml/Vector4f;", "<init>", "(FFFFFFZLjava/util/Map;)V", "getOriginX", "()F", "getOriginY", "getOriginZ", "getDimensionX", "getDimensionY", "getDimensionZ", "getMirror", "()Z", "getVisibleFaces", "()Ljava/util/Map;", "quadData", "", "Lnet/thebrokenscript/brokencore/api/animation/PerFaceCuboid$QuadData;", "compile", "", "pose", "Lcom/mojang/blaze3d/vertex/PoseStack$Pose;", "buffer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "packedLight", "", "packedOverlay", "color", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "", "QuadData", "Companion", "brokencore-common"})
@ExperimentalAnimationApi
public final class PerFaceCuboid
extends ModelPart.Cube {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final float originX;
    private final float originY;
    private final float originZ;
    private final float dimensionX;
    private final float dimensionY;
    private final float dimensionZ;
    private final boolean mirror;
    @NotNull
    private final Map<Direction, Vector4f> visibleFaces;
    @NotNull
    private final Map<Direction, QuadData> quadData;

    public PerFaceCuboid(float originX, float originY, float originZ, float dimensionX, float dimensionY, float dimensionZ, boolean mirror, @NotNull Map<Direction, ? extends Vector4f> visibleFaces) {
        Intrinsics.checkNotNullParameter(visibleFaces, (String)"visibleFaces");
        super(0, 0, originX, originY, originZ, originX + dimensionX, originY + dimensionY, originZ + dimensionZ, 0.0f, 0.0f, 0.0f, mirror, 1.0f, 1.0f, visibleFaces.keySet());
        this.originX = originX;
        this.originY = originY;
        this.originZ = originZ;
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.dimensionZ = dimensionZ;
        this.mirror = mirror;
        this.visibleFaces = visibleFaces;
        this.quadData = new LinkedHashMap();
        for (Map.Entry<Direction, Vector4f> entry : this.visibleFaces.entrySet()) {
            Vector2f uvMin = new Vector2f(entry.getValue().x, entry.getValue().y);
            Vector2f uvMax = new Vector2f(entry.getValue().z, entry.getValue().w);
            Direction dir = entry.getKey();
            Vector3f v1 = new Vector3f(0.0f, 0.0f, 0.0f);
            Vector3f v2 = new Vector3f(0.0f, 0.0f, 0.0f);
            Vector3f v3 = new Vector3f(0.0f, 0.0f, 0.0f);
            Vector3f v4 = new Vector3f(0.0f, 0.0f, 0.0f);
            switch (WhenMappings.$EnumSwitchMapping$0[dir.ordinal()]) {
                case 1: {
                    PerFaceCuboid._init_$get(v1, this.minX, this.maxY, this.minZ);
                    PerFaceCuboid._init_$get(v2, this.minX, this.maxY, this.maxZ);
                    PerFaceCuboid._init_$get(v3, this.maxX, this.maxY, this.maxZ);
                    Vector3f vector3f = PerFaceCuboid._init_$get(v4, this.maxX, this.maxY, this.minZ);
                    break;
                }
                case 2: {
                    PerFaceCuboid._init_$get(v1, this.maxX, this.minY, this.minZ);
                    PerFaceCuboid._init_$get(v2, this.maxX, this.minY, this.maxZ);
                    PerFaceCuboid._init_$get(v3, this.minX, this.minY, this.maxZ);
                    Vector3f vector3f = PerFaceCuboid._init_$get(v4, this.minX, this.minY, this.minZ);
                    break;
                }
                case 3: {
                    PerFaceCuboid._init_$get(v1, this.maxX, this.minY, this.minZ);
                    PerFaceCuboid._init_$get(v2, this.maxX, this.maxY, this.minZ);
                    PerFaceCuboid._init_$get(v3, this.minX, this.maxY, this.minZ);
                    Vector3f vector3f = PerFaceCuboid._init_$get(v4, this.minX, this.minY, this.minZ);
                    break;
                }
                case 4: {
                    PerFaceCuboid._init_$get(v1, this.minX, this.minY, this.maxZ);
                    PerFaceCuboid._init_$get(v2, this.minX, this.maxY, this.maxZ);
                    PerFaceCuboid._init_$get(v3, this.maxX, this.maxY, this.maxZ);
                    Vector3f vector3f = PerFaceCuboid._init_$get(v4, this.maxX, this.minY, this.maxZ);
                    break;
                }
                case 5: {
                    PerFaceCuboid._init_$get(v1, this.maxX, this.minY, this.minZ);
                    PerFaceCuboid._init_$get(v2, this.maxX, this.maxY, this.minZ);
                    PerFaceCuboid._init_$get(v3, this.maxX, this.maxY, this.maxZ);
                    Vector3f vector3f = PerFaceCuboid._init_$get(v4, this.maxX, this.minY, this.maxZ);
                    break;
                }
                case 6: {
                    PerFaceCuboid._init_$get(v1, this.minX, this.minY, this.maxZ);
                    PerFaceCuboid._init_$get(v2, this.minX, this.maxY, this.maxZ);
                    PerFaceCuboid._init_$get(v3, this.minX, this.maxY, this.minZ);
                    Vector3f vector3f = PerFaceCuboid._init_$get(v4, this.minX, this.minY, this.minZ);
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            this.quadData.put(dir, new QuadData(v1, v2, v3, v4, uvMin, uvMax));
        }
    }

    public final float getOriginX() {
        return this.originX;
    }

    public final float getOriginY() {
        return this.originY;
    }

    public final float getOriginZ() {
        return this.originZ;
    }

    public final float getDimensionX() {
        return this.dimensionX;
    }

    public final float getDimensionY() {
        return this.dimensionY;
    }

    public final float getDimensionZ() {
        return this.dimensionZ;
    }

    public final boolean getMirror() {
        return this.mirror;
    }

    @NotNull
    public final Map<Direction, Vector4f> getVisibleFaces() {
        return this.visibleFaces;
    }

    public void compile(@NotNull PoseStack.Pose pose, @NotNull VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        Intrinsics.checkNotNullParameter((Object)pose, (String)"pose");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        Matrix4f matrix4f = pose.pose();
        Vector3f vector3f = new Vector3f();
        for (Map.Entry<Direction, QuadData> entry : this.quadData.entrySet()) {
            Direction dir = entry.getKey();
            QuadData quad = entry.getValue();
            Vector3f normal = pose.transformNormal(dir.step(), vector3f);
            quad.forEach((Function2<? super Vector3f, ? super Vector2f, Unit>)((Function2)(arg_0, arg_1) -> PerFaceCuboid.compile$lambda$0(matrix4f, buffer, packedLight, packedOverlay, normal, arg_0, arg_1)));
        }
    }

    public final float component1() {
        return this.originX;
    }

    public final float component2() {
        return this.originY;
    }

    public final float component3() {
        return this.originZ;
    }

    public final float component4() {
        return this.dimensionX;
    }

    public final float component5() {
        return this.dimensionY;
    }

    public final float component6() {
        return this.dimensionZ;
    }

    public final boolean component7() {
        return this.mirror;
    }

    @NotNull
    public final Map<Direction, Vector4f> component8() {
        return this.visibleFaces;
    }

    @NotNull
    public final PerFaceCuboid copy(float originX, float originY, float originZ, float dimensionX, float dimensionY, float dimensionZ, boolean mirror, @NotNull Map<Direction, ? extends Vector4f> visibleFaces) {
        Intrinsics.checkNotNullParameter(visibleFaces, (String)"visibleFaces");
        return new PerFaceCuboid(originX, originY, originZ, dimensionX, dimensionY, dimensionZ, mirror, visibleFaces);
    }

    public static /* synthetic */ PerFaceCuboid copy$default(PerFaceCuboid perFaceCuboid, float f, float f2, float f3, float f4, float f5, float f6, boolean bl, Map map, int n, Object object) {
        if ((n & 1) != 0) {
            f = perFaceCuboid.originX;
        }
        if ((n & 2) != 0) {
            f2 = perFaceCuboid.originY;
        }
        if ((n & 4) != 0) {
            f3 = perFaceCuboid.originZ;
        }
        if ((n & 8) != 0) {
            f4 = perFaceCuboid.dimensionX;
        }
        if ((n & 0x10) != 0) {
            f5 = perFaceCuboid.dimensionY;
        }
        if ((n & 0x20) != 0) {
            f6 = perFaceCuboid.dimensionZ;
        }
        if ((n & 0x40) != 0) {
            bl = perFaceCuboid.mirror;
        }
        if ((n & 0x80) != 0) {
            map = perFaceCuboid.visibleFaces;
        }
        return perFaceCuboid.copy(f, f2, f3, f4, f5, f6, bl, map);
    }

    @NotNull
    public String toString() {
        return "PerFaceCuboid(originX=" + this.originX + ", originY=" + this.originY + ", originZ=" + this.originZ + ", dimensionX=" + this.dimensionX + ", dimensionY=" + this.dimensionY + ", dimensionZ=" + this.dimensionZ + ", mirror=" + this.mirror + ", visibleFaces=" + this.visibleFaces + ")";
    }

    public int hashCode() {
        int result = Float.hashCode(this.originX);
        result = result * 31 + Float.hashCode(this.originY);
        result = result * 31 + Float.hashCode(this.originZ);
        result = result * 31 + Float.hashCode(this.dimensionX);
        result = result * 31 + Float.hashCode(this.dimensionY);
        result = result * 31 + Float.hashCode(this.dimensionZ);
        result = result * 31 + Boolean.hashCode(this.mirror);
        result = result * 31 + ((Object)this.visibleFaces).hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PerFaceCuboid)) {
            return false;
        }
        PerFaceCuboid perFaceCuboid = (PerFaceCuboid)((Object)other);
        if (Float.compare(this.originX, perFaceCuboid.originX) != 0) {
            return false;
        }
        if (Float.compare(this.originY, perFaceCuboid.originY) != 0) {
            return false;
        }
        if (Float.compare(this.originZ, perFaceCuboid.originZ) != 0) {
            return false;
        }
        if (Float.compare(this.dimensionX, perFaceCuboid.dimensionX) != 0) {
            return false;
        }
        if (Float.compare(this.dimensionY, perFaceCuboid.dimensionY) != 0) {
            return false;
        }
        if (Float.compare(this.dimensionZ, perFaceCuboid.dimensionZ) != 0) {
            return false;
        }
        if (this.mirror != perFaceCuboid.mirror) {
            return false;
        }
        return Intrinsics.areEqual(this.visibleFaces, perFaceCuboid.visibleFaces);
    }

    private static final Vector3f _init_$get(Vector3f $this$_init__u24get, float x, float y, float z) {
        Intrinsics.checkNotNullParameter((Object)$this$_init__u24get, (String)"<this>");
        return $this$_init__u24get.set(x, y, z);
    }

    private static final Unit compile$lambda$0(Matrix4f $matrix4f, VertexConsumer $buffer, int $packedLight, int $packedOverlay, Vector3f $normal, Vector3f pos, Vector2f uv) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)uv, (String)"uv");
        Vector3f vertex = $matrix4f.transformPosition(new Vector3f(pos.x, pos.y, pos.z));
        $buffer.addVertex(vertex.x, vertex.y, vertex.z, FastColor.ARGB32.colorFromFloat((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f), uv.x, uv.y, $packedLight, $packedOverlay, $normal.x, $normal.y, $normal.z);
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/PerFaceCuboid$Companion;", "", "<init>", "()V", "parse", "Lnet/thebrokenscript/brokencore/api/animation/PerFaceCuboid;", "cuboidObject", "Lcom/google/gson/JsonObject;", "transform", "Lnet/thebrokenscript/brokencore/api/animation/BedrockTransform;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final PerFaceCuboid parse(@NotNull JsonObject cuboidObject, @NotNull BedrockTransform transform2) {
            Intrinsics.checkNotNullParameter((Object)cuboidObject, (String)"cuboidObject");
            Intrinsics.checkNotNullParameter((Object)transform2, (String)"transform");
            Map dirMap = new LinkedHashMap();
            for (Direction dir : EntriesMappings.entries$0) {
                String name = dir.getSerializedName();
                JsonElement jsonElement = cuboidObject.get("uv");
                JsonObject uvObj = jsonElement != null && (jsonElement = jsonElement.getAsJsonObject()) != null && (jsonElement = jsonElement.get(name)) != null ? jsonElement.getAsJsonObject() : null;
                if (uvObj == null) continue;
                JsonArray jsonArray = uvObj.get("uv").getAsJsonArray();
                Intrinsics.checkNotNullExpressionValue((Object)jsonArray, (String)"getAsJsonArray(...)");
                Vector2f uvMin = net.thebrokenscript.brokencore.api.animation.PerFaceCuboid$Companion.parse$toVec2f(jsonArray);
                Vector2f vector2f = new Vector2f((Vector2fc)uvMin);
                JsonArray jsonArray2 = uvObj.get("uv_size").getAsJsonArray();
                Intrinsics.checkNotNullExpressionValue((Object)jsonArray2, (String)"getAsJsonArray(...)");
                Vector2f uvMax = vector2f.add((Vector2fc)net.thebrokenscript.brokencore.api.animation.PerFaceCuboid$Companion.parse$toVec2f(jsonArray2));
                dirMap.put(dir, new Vector4f(uvMin.x, uvMin.y, uvMax.x, uvMax.y));
            }
            Vector3f p = transform2.getPosition();
            Vector3f s = transform2.getPosition();
            return new PerFaceCuboid(p.x, p.y, p.z, s.x, s.y, s.z, false, dirMap);
        }

        private static final Vector2f parse$toVec2f(JsonArray $this$parse_u24toVec2f) {
            return new Vector2f($this$parse_u24toVec2f.get(0).getAsFloat(), $this$parse_u24toVec2f.get(1).getAsFloat());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        @Metadata(mv={2, 1, 0}, k=3, xi=48)
        public static final class EntriesMappings {
            public static final /* synthetic */ EnumEntries<Direction> entries$0;

            static {
                entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Direction.values()));
            }
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\u0014\u001a\u00020\u00152\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00150\u0017J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\bH\u00c6\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020#H\u00d6\u0001J\t\u0010$\u001a\u00020%H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012\u00a8\u0006&"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/PerFaceCuboid$QuadData;", "", "v1", "Lorg/joml/Vector3f;", "v2", "v3", "v4", "uvMin", "Lorg/joml/Vector2f;", "uvMax", "<init>", "(Lorg/joml/Vector3f;Lorg/joml/Vector3f;Lorg/joml/Vector3f;Lorg/joml/Vector3f;Lorg/joml/Vector2f;Lorg/joml/Vector2f;)V", "getV1", "()Lorg/joml/Vector3f;", "getV2", "getV3", "getV4", "getUvMin", "()Lorg/joml/Vector2f;", "getUvMax", "forEach", "", "consumer", "Lkotlin/Function2;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "brokencore-common"})
    private static final class QuadData {
        @NotNull
        private final Vector3f v1;
        @NotNull
        private final Vector3f v2;
        @NotNull
        private final Vector3f v3;
        @NotNull
        private final Vector3f v4;
        @NotNull
        private final Vector2f uvMin;
        @NotNull
        private final Vector2f uvMax;

        public QuadData(@NotNull Vector3f v1, @NotNull Vector3f v2, @NotNull Vector3f v3, @NotNull Vector3f v4, @NotNull Vector2f uvMin, @NotNull Vector2f uvMax) {
            Intrinsics.checkNotNullParameter((Object)v1, (String)"v1");
            Intrinsics.checkNotNullParameter((Object)v2, (String)"v2");
            Intrinsics.checkNotNullParameter((Object)v3, (String)"v3");
            Intrinsics.checkNotNullParameter((Object)v4, (String)"v4");
            Intrinsics.checkNotNullParameter((Object)uvMin, (String)"uvMin");
            Intrinsics.checkNotNullParameter((Object)uvMax, (String)"uvMax");
            this.v1 = v1;
            this.v2 = v2;
            this.v3 = v3;
            this.v4 = v4;
            this.uvMin = uvMin;
            this.uvMax = uvMax;
        }

        @NotNull
        public final Vector3f getV1() {
            return this.v1;
        }

        @NotNull
        public final Vector3f getV2() {
            return this.v2;
        }

        @NotNull
        public final Vector3f getV3() {
            return this.v3;
        }

        @NotNull
        public final Vector3f getV4() {
            return this.v4;
        }

        @NotNull
        public final Vector2f getUvMin() {
            return this.uvMin;
        }

        @NotNull
        public final Vector2f getUvMax() {
            return this.uvMax;
        }

        public final void forEach(@NotNull Function2<? super Vector3f, ? super Vector2f, Unit> consumer) {
            Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
            consumer.invoke((Object)this.v1, (Object)this.uvMin);
            consumer.invoke((Object)this.v2, (Object)new Vector2f(this.uvMin.x, this.uvMax.y));
            consumer.invoke((Object)this.v3, (Object)this.uvMax);
            consumer.invoke((Object)this.v4, (Object)new Vector2f(this.uvMax.x, this.uvMin.y));
        }

        @NotNull
        public final Vector3f component1() {
            return this.v1;
        }

        @NotNull
        public final Vector3f component2() {
            return this.v2;
        }

        @NotNull
        public final Vector3f component3() {
            return this.v3;
        }

        @NotNull
        public final Vector3f component4() {
            return this.v4;
        }

        @NotNull
        public final Vector2f component5() {
            return this.uvMin;
        }

        @NotNull
        public final Vector2f component6() {
            return this.uvMax;
        }

        @NotNull
        public final QuadData copy(@NotNull Vector3f v1, @NotNull Vector3f v2, @NotNull Vector3f v3, @NotNull Vector3f v4, @NotNull Vector2f uvMin, @NotNull Vector2f uvMax) {
            Intrinsics.checkNotNullParameter((Object)v1, (String)"v1");
            Intrinsics.checkNotNullParameter((Object)v2, (String)"v2");
            Intrinsics.checkNotNullParameter((Object)v3, (String)"v3");
            Intrinsics.checkNotNullParameter((Object)v4, (String)"v4");
            Intrinsics.checkNotNullParameter((Object)uvMin, (String)"uvMin");
            Intrinsics.checkNotNullParameter((Object)uvMax, (String)"uvMax");
            return new QuadData(v1, v2, v3, v4, uvMin, uvMax);
        }

        public static /* synthetic */ QuadData copy$default(QuadData quadData, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, Vector2f vector2f, Vector2f vector2f2, int n, Object object) {
            if ((n & 1) != 0) {
                vector3f = quadData.v1;
            }
            if ((n & 2) != 0) {
                vector3f2 = quadData.v2;
            }
            if ((n & 4) != 0) {
                vector3f3 = quadData.v3;
            }
            if ((n & 8) != 0) {
                vector3f4 = quadData.v4;
            }
            if ((n & 0x10) != 0) {
                vector2f = quadData.uvMin;
            }
            if ((n & 0x20) != 0) {
                vector2f2 = quadData.uvMax;
            }
            return quadData.copy(vector3f, vector3f2, vector3f3, vector3f4, vector2f, vector2f2);
        }

        @NotNull
        public String toString() {
            return "QuadData(v1=" + this.v1 + ", v2=" + this.v2 + ", v3=" + this.v3 + ", v4=" + this.v4 + ", uvMin=" + this.uvMin + ", uvMax=" + this.uvMax + ")";
        }

        public int hashCode() {
            int result = this.v1.hashCode();
            result = result * 31 + this.v2.hashCode();
            result = result * 31 + this.v3.hashCode();
            result = result * 31 + this.v4.hashCode();
            result = result * 31 + this.uvMin.hashCode();
            result = result * 31 + this.uvMax.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QuadData)) {
                return false;
            }
            QuadData quadData = (QuadData)other;
            if (!Intrinsics.areEqual((Object)this.v1, (Object)quadData.v1)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.v2, (Object)quadData.v2)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.v3, (Object)quadData.v3)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.v4, (Object)quadData.v4)) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.uvMin, (Object)quadData.uvMin)) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.uvMax, (Object)quadData.uvMax);
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Direction.values().length];
            try {
                nArray[Direction.UP.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.DOWN.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.EAST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.WEST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

