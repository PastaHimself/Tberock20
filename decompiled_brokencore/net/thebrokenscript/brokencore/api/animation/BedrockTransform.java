/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.model.geom.PartPose
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.animation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.geom.PartPose;
import net.thebrokenscript.brokencore.api.animation.BedrockTransformInterpolator;
import net.thebrokenscript.brokencore.api.animation.value_animation.Easing;
import net.thebrokenscript.brokencore.api.annotation.ExperimentalAnimationApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u0000J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0000J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/brokencore/api/animation/BedrockTransform;", "", "position", "Lorg/joml/Vector3f;", "scale", "rotation", "pivot", "<init>", "(Lorg/joml/Vector3f;Lorg/joml/Vector3f;Lorg/joml/Vector3f;Lorg/joml/Vector3f;)V", "getPosition", "()Lorg/joml/Vector3f;", "getScale", "getRotation", "getPivot", "toModelTransform", "Lnet/minecraft/client/model/geom/PartPose;", "toString", "", "copy", "interpolate", "delta", "", "other", "component1", "component2", "component3", "component4", "equals", "", "hashCode", "", "Companion", "brokencore-common"})
@ExperimentalAnimationApi
public final class BedrockTransform {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Vector3f position;
    @NotNull
    private final Vector3f scale;
    @NotNull
    private final Vector3f rotation;
    @NotNull
    private final Vector3f pivot;
    @NotNull
    private static final BedrockTransformInterpolator interpolator = new BedrockTransformInterpolator(Easing.Companion.getLINEAR());

    public BedrockTransform(@NotNull Vector3f position, @NotNull Vector3f scale, @NotNull Vector3f rotation, @NotNull Vector3f pivot) {
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        Intrinsics.checkNotNullParameter((Object)scale, (String)"scale");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
        Intrinsics.checkNotNullParameter((Object)pivot, (String)"pivot");
        this.position = position;
        this.scale = scale;
        this.rotation = rotation;
        this.pivot = pivot;
    }

    @NotNull
    public final Vector3f getPosition() {
        return this.position;
    }

    @NotNull
    public final Vector3f getScale() {
        return this.scale;
    }

    @NotNull
    public final Vector3f getRotation() {
        return this.rotation;
    }

    @NotNull
    public final Vector3f getPivot() {
        return this.pivot;
    }

    @NotNull
    public final PartPose toModelTransform() {
        PartPose partPose = PartPose.offsetAndRotation((float)(this.pivot.x + this.position.x), (float)(this.pivot.y + this.position.y), (float)(this.pivot.z + this.position.z), (float)((float)Math.toRadians(this.rotation.x)), (float)((float)Math.toRadians(this.rotation.y)), (float)((float)Math.toRadians(this.rotation.z)));
        Intrinsics.checkNotNullExpressionValue((Object)partPose, (String)"offsetAndRotation(...)");
        return partPose;
    }

    @NotNull
    public String toString() {
        return "BedrockTransform{position=" + this.position + ", scale=" + this.scale + ", rotation=" + this.rotation + ", pivot=" + this.pivot + "}";
    }

    @NotNull
    public final BedrockTransform copy() {
        return new BedrockTransform(this.position, this.scale, this.rotation, this.pivot);
    }

    @NotNull
    public final BedrockTransform interpolate(float delta, @NotNull BedrockTransform other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return interpolator.interpolate(delta, this, other);
    }

    @NotNull
    public final Vector3f component1() {
        return this.position;
    }

    @NotNull
    public final Vector3f component2() {
        return this.scale;
    }

    @NotNull
    public final Vector3f component3() {
        return this.rotation;
    }

    @NotNull
    public final Vector3f component4() {
        return this.pivot;
    }

    @NotNull
    public final BedrockTransform copy(@NotNull Vector3f position, @NotNull Vector3f scale, @NotNull Vector3f rotation, @NotNull Vector3f pivot) {
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        Intrinsics.checkNotNullParameter((Object)scale, (String)"scale");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
        Intrinsics.checkNotNullParameter((Object)pivot, (String)"pivot");
        return new BedrockTransform(position, scale, rotation, pivot);
    }

    public static /* synthetic */ BedrockTransform copy$default(BedrockTransform bedrockTransform, Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3, Vector3f vector3f4, int n, Object object) {
        if ((n & 1) != 0) {
            vector3f = bedrockTransform.position;
        }
        if ((n & 2) != 0) {
            vector3f2 = bedrockTransform.scale;
        }
        if ((n & 4) != 0) {
            vector3f3 = bedrockTransform.rotation;
        }
        if ((n & 8) != 0) {
            vector3f4 = bedrockTransform.pivot;
        }
        return bedrockTransform.copy(vector3f, vector3f2, vector3f3, vector3f4);
    }

    public int hashCode() {
        int result = this.position.hashCode();
        result = result * 31 + this.scale.hashCode();
        result = result * 31 + this.rotation.hashCode();
        result = result * 31 + this.pivot.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BedrockTransform)) {
            return false;
        }
        BedrockTransform bedrockTransform = (BedrockTransform)other;
        if (!Intrinsics.areEqual((Object)this.position, (Object)bedrockTransform.position)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.scale, (Object)bedrockTransform.scale)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.rotation, (Object)bedrockTransform.rotation)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.pivot, (Object)bedrockTransform.pivot);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/brokencore/api/animation/BedrockTransform$Companion;", "", "<init>", "()V", "interpolator", "Lnet/thebrokenscript/brokencore/api/animation/BedrockTransformInterpolator;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

