/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.mojang.math.Axis
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector2i
 *  org.joml.Vector2ic
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.brokencore.api.animation;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.math.Axis;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.thebrokenscript.brokencore.api.animation.BakedCubeDefinition;
import net.thebrokenscript.brokencore.api.animation.BedrockTransform;
import net.thebrokenscript.brokencore.api.animation.PerFaceCuboid;
import net.thebrokenscript.brokencore.api.annotation.ExperimentalAnimationApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector2i;
import org.joml.Vector2ic;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u00c6\u0003J7\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000f\u00a8\u0006\u001f"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/BedrockCuboid;", "Ljava/lang/Record;", "transform", "Lnet/thebrokenscript/brokencore/api/animation/BedrockTransform;", "uv", "Lorg/joml/Vector2ic;", "perFace", "", "perFaceCuboid", "Lnet/thebrokenscript/brokencore/api/animation/PerFaceCuboid;", "<init>", "(Lnet/thebrokenscript/brokencore/api/animation/BedrockTransform;Lorg/joml/Vector2ic;ZLnet/thebrokenscript/brokencore/api/animation/PerFaceCuboid;)V", "()Lnet/thebrokenscript/brokencore/api/animation/BedrockTransform;", "()Lorg/joml/Vector2ic;", "()Z", "()Lnet/thebrokenscript/brokencore/api/animation/PerFaceCuboid;", "toBuilder", "Lnet/minecraft/client/model/geom/builders/CubeListBuilder;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "brokencore-common"})
@ExperimentalAnimationApi
public final class BedrockCuboid
extends Record {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final BedrockTransform transform;
    @Nullable
    private final Vector2ic uv;
    private final boolean perFace;
    @Nullable
    private final PerFaceCuboid perFaceCuboid;

    public BedrockCuboid(@Nullable BedrockTransform transform2, @Nullable Vector2ic uv, boolean perFace, @Nullable PerFaceCuboid perFaceCuboid) {
        this.transform = transform2;
        this.uv = uv;
        this.perFace = perFace;
        this.perFaceCuboid = perFaceCuboid;
    }

    public /* synthetic */ BedrockCuboid(BedrockTransform bedrockTransform, Vector2ic vector2ic, boolean bl, PerFaceCuboid perFaceCuboid, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 8) != 0) {
            perFaceCuboid = null;
        }
        this(bedrockTransform, vector2ic, bl, perFaceCuboid);
    }

    @Nullable
    public final BedrockTransform transform() {
        return this.transform;
    }

    @Nullable
    public final Vector2ic uv() {
        return this.uv;
    }

    public final boolean perFace() {
        return this.perFace;
    }

    @Nullable
    public final PerFaceCuboid perFaceCuboid() {
        return this.perFaceCuboid;
    }

    @NotNull
    public final CubeListBuilder toBuilder() {
        CubeListBuilder builder = new CubeListBuilder();
        if (this.perFace) {
            List list = builder.cubes;
            PerFaceCuboid perFaceCuboid = this.perFaceCuboid;
            Intrinsics.checkNotNull((Object)((Object)perFaceCuboid));
            list.add(new BakedCubeDefinition(perFaceCuboid));
            return builder;
        }
        BedrockTransform bedrockTransform = this.transform;
        Intrinsics.checkNotNull((Object)bedrockTransform);
        Vector3f pos = new Vector3f((Vector3fc)bedrockTransform.getPosition());
        new Vector3f((Vector3fc)this.transform.getPivot());
        Vector3f scale = this.transform.getScale();
        Vector3f rot = new Vector3f((Vector3fc)this.transform.getRotation());
        Matrix4f mat = new Matrix4f().identity();
        mat.translate((Vector3fc)pos);
        Quaternionf x = Axis.XP.rotationDegrees(rot.x + (float)180);
        Quaternionf y = Axis.YP.rotationDegrees(rot.y + (float)180);
        Quaternionf z = Axis.ZP.rotationDegrees(rot.z + (float)180);
        Quaternionf q = x.mul((Quaternionfc)y).mul((Quaternionfc)z);
        mat.rotateAround((Quaternionfc)q, 0.0f, 0.0f, 0.0f);
        Vector3f ofs = new Vector3f(0.0f).mulPosition((Matrix4fc)mat);
        CubeListBuilder cubeListBuilder = builder.addBox(pos.x, pos.y, pos.z, scale.x, scale.y, scale.z);
        Vector2ic vector2ic = this.uv;
        Intrinsics.checkNotNull((Object)vector2ic);
        CubeListBuilder cubeListBuilder2 = cubeListBuilder.texOffs(vector2ic.x(), this.uv.y());
        Intrinsics.checkNotNullExpressionValue((Object)cubeListBuilder2, (String)"texOffs(...)");
        return cubeListBuilder2;
    }

    @Nullable
    public final BedrockTransform component1() {
        return this.transform;
    }

    @Nullable
    public final Vector2ic component2() {
        return this.uv;
    }

    public final boolean component3() {
        return this.perFace;
    }

    @Nullable
    public final PerFaceCuboid component4() {
        return this.perFaceCuboid;
    }

    @NotNull
    public final BedrockCuboid copy(@Nullable BedrockTransform transform2, @Nullable Vector2ic uv, boolean perFace, @Nullable PerFaceCuboid perFaceCuboid) {
        return new BedrockCuboid(transform2, uv, perFace, perFaceCuboid);
    }

    public static /* synthetic */ BedrockCuboid copy$default(BedrockCuboid bedrockCuboid, BedrockTransform bedrockTransform, Vector2ic vector2ic, boolean bl, PerFaceCuboid perFaceCuboid, int n, Object object) {
        if ((n & 1) != 0) {
            bedrockTransform = bedrockCuboid.transform;
        }
        if ((n & 2) != 0) {
            vector2ic = bedrockCuboid.uv;
        }
        if ((n & 4) != 0) {
            bl = bedrockCuboid.perFace;
        }
        if ((n & 8) != 0) {
            perFaceCuboid = bedrockCuboid.perFaceCuboid;
        }
        return bedrockCuboid.copy(bedrockTransform, vector2ic, bl, perFaceCuboid);
    }

    @Override
    @NotNull
    public String toString() {
        return "BedrockCuboid(transform=" + this.transform + ", uv=" + this.uv + ", perFace=" + this.perFace + ", perFaceCuboid=" + this.perFaceCuboid + ")";
    }

    @Override
    public int hashCode() {
        int result = this.transform == null ? 0 : this.transform.hashCode();
        result = result * 31 + (this.uv == null ? 0 : this.uv.hashCode());
        result = result * 31 + Boolean.hashCode(this.perFace);
        result = result * 31 + (this.perFaceCuboid == null ? 0 : this.perFaceCuboid.hashCode());
        return result;
    }

    @Override
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BedrockCuboid)) {
            return false;
        }
        BedrockCuboid bedrockCuboid = (BedrockCuboid)other;
        if (!Intrinsics.areEqual((Object)this.transform, (Object)bedrockCuboid.transform)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.uv, (Object)bedrockCuboid.uv)) {
            return false;
        }
        if (this.perFace != bedrockCuboid.perFace) {
            return false;
        }
        return Intrinsics.areEqual((Object)((Object)this.perFaceCuboid), (Object)((Object)bedrockCuboid.perFaceCuboid));
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0002\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/BedrockCuboid$Companion;", "", "<init>", "()V", "parse", "Lnet/thebrokenscript/brokencore/api/animation/BedrockCuboid;", "cuboidObject", "Lcom/google/gson/JsonObject;", "parseTransform", "Lnet/thebrokenscript/brokencore/api/animation/BedrockTransform;", "parsePerFace", "transform", "parseBox", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final BedrockCuboid parse(@NotNull JsonObject cuboidObject) {
            Intrinsics.checkNotNullParameter((Object)cuboidObject, (String)"cuboidObject");
            BedrockTransform transform2 = this.parseTransform(cuboidObject);
            JsonElement uvJson = cuboidObject.get("uv");
            return uvJson instanceof JsonArray ? this.parseBox(cuboidObject, transform2) : this.parsePerFace(cuboidObject, transform2);
        }

        private final BedrockTransform parseTransform(JsonObject cuboidObject) {
            Vector3f pos = new Vector3f(0.0f, 0.0f, 0.0f);
            Vector3f rot = new Vector3f(0.0f, 0.0f, 0.0f);
            Vector3f size = new Vector3f(0.0f, 0.0f, 0.0f);
            Vector3f pivot = new Vector3f(0.0f, 0.0f, 0.0f);
            JsonElement originJson = cuboidObject.get("origin");
            JsonElement rotationJson = cuboidObject.get("rotation");
            JsonElement pivotJson = cuboidObject.get("pivot");
            JsonElement sizeJson = cuboidObject.get("size");
            if (originJson instanceof JsonArray) {
                pos.x = ((JsonArray)originJson).get(0).getAsFloat();
                pos.y = ((JsonArray)originJson).get(1).getAsFloat();
                pos.z = ((JsonArray)originJson).get(2).getAsFloat();
            }
            if (rotationJson instanceof JsonArray) {
                rot.x = ((JsonArray)rotationJson).get(0).getAsFloat();
                rot.y = ((JsonArray)rotationJson).get(1).getAsFloat();
                rot.z = ((JsonArray)rotationJson).get(2).getAsFloat();
            }
            if (pivotJson instanceof JsonArray) {
                pivot.x = ((JsonArray)pivotJson).get(0).getAsFloat();
                pivot.y = ((JsonArray)pivotJson).get(1).getAsFloat();
                pivot.z = ((JsonArray)pivotJson).get(2).getAsFloat();
            }
            if (sizeJson instanceof JsonArray) {
                size.x = ((JsonArray)sizeJson).get(0).getAsFloat();
                size.y = ((JsonArray)sizeJson).get(1).getAsFloat();
                size.z = ((JsonArray)sizeJson).get(2).getAsFloat();
            }
            return new BedrockTransform(pos, size, rot, pivot);
        }

        private final BedrockCuboid parsePerFace(JsonObject cuboidObject, BedrockTransform transform2) {
            return new BedrockCuboid(transform2, null, true, PerFaceCuboid.Companion.parse(cuboidObject, transform2));
        }

        private final BedrockCuboid parseBox(JsonObject cuboidObject, BedrockTransform transform2) {
            Vector2i uv = new Vector2i(0, 0);
            JsonElement uvJson = cuboidObject.get("uv");
            if (uvJson instanceof JsonArray) {
                uv.x = ((JsonArray)uvJson).get(0).getAsInt();
                uv.y = ((JsonArray)uvJson).get(1).getAsInt();
            }
            return new BedrockCuboid(transform2, (Vector2ic)uv, false, null, 8, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

