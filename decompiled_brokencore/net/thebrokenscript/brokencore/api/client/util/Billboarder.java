/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Camera
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.client.util;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Camera;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.util.math.MathUtilKt;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/client/util/Billboarder;", "", "<init>", "()V", "withCameraRotation", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "mat4", "Lorg/joml/Matrix4f;", "withRotationTo", "from", "Lorg/joml/Vector3f;", "to", "withHorizRotationTo", "getPitchToward", "", "origin", "getYawToward", "brokencore-common"})
public final class Billboarder {
    @NotNull
    public static final Billboarder INSTANCE = new Billboarder();

    private Billboarder() {
    }

    public final void withCameraRotation(@NotNull PoseStack poseStack) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Camera cam = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        if (cam != null) {
            poseStack.mulPose(Axis.YP.rotation(cam.getYRot() * ((float)Math.PI / 180)));
            poseStack.mulPose(Axis.XP.rotation(-cam.getXRot() * ((float)Math.PI / 180)));
        }
    }

    public final void withCameraRotation(@NotNull Matrix4f mat4) {
        Intrinsics.checkNotNullParameter((Object)mat4, (String)"mat4");
        Camera cam = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        if (cam != null) {
            mat4.rotate((Quaternionfc)Axis.YP.rotation(cam.getYRot() * ((float)Math.PI / 180)));
            mat4.rotate((Quaternionfc)Axis.XP.rotation(-cam.getXRot() * ((float)Math.PI / 180)));
        }
    }

    public final void withRotationTo(@NotNull PoseStack poseStack, @NotNull Vector3f from, @NotNull Vector3f to) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        Intrinsics.checkNotNullParameter((Object)to, (String)"to");
        float pitch = ((Number)((Object)MathUtilKt.clamp((Comparable)Float.valueOf(this.getPitchToward(from, to)), (Comparable)Float.valueOf(-0.5f), (Comparable)Float.valueOf(0.5f)))).floatValue();
        float yaw = this.getYawToward(from, to);
        poseStack.mulPose(Axis.YP.rotation(-yaw));
        poseStack.mulPose(Axis.XP.rotation(pitch));
    }

    public final void withHorizRotationTo(@NotNull PoseStack poseStack, @NotNull Vector3f from, @NotNull Vector3f to) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        Intrinsics.checkNotNullParameter((Object)to, (String)"to");
        Camera cam = ClientDSLKt.getMC().gameRenderer.getMainCamera();
        if (cam != null) {
            float yaw = this.getYawToward(from, to);
            poseStack.mulPose(Axis.YP.rotation(-yaw));
        }
    }

    public final float getPitchToward(@NotNull Vector3f origin, @NotNull Vector3f to) {
        Intrinsics.checkNotNullParameter((Object)origin, (String)"origin");
        Intrinsics.checkNotNullParameter((Object)to, (String)"to");
        double dx = origin.x - to.x;
        double dy = origin.y - to.y;
        double dz = origin.z - to.z;
        double horizontalDistance = Math.sqrt(dx * dx + dz * dz);
        return -((float)Math.atan2(dy, horizontalDistance));
    }

    public final float getYawToward(@NotNull Vector3f origin, @NotNull Vector3f to) {
        Intrinsics.checkNotNullParameter((Object)origin, (String)"origin");
        Intrinsics.checkNotNullParameter((Object)to, (String)"to");
        double dx = origin.x - to.x;
        double dz = origin.z - to.z;
        return (float)(Math.atan2(dz, dx) - 1.5707963267948966);
    }
}

