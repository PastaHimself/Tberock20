/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.Font$DisplayMode
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionfc
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.brokencore.api.debug.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.FastColor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.client.util.Billboarder;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionfc;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/debug/renderer/DebugTextDisplay;", "", "<init>", "()V", "render", "", "text", "", "position", "Lnet/minecraft/world/phys/Vec3;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "r", "", "g", "b", "brokencore-common"})
public final class DebugTextDisplay {
    @NotNull
    public static final DebugTextDisplay INSTANCE = new DebugTextDisplay();

    private DebugTextDisplay() {
    }

    public final void render(@NotNull String text, @NotNull Vec3 position, @NotNull MultiBufferSource buffer, @NotNull PoseStack poseStack, float r, float g, float b) {
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        int col = FastColor.ARGB32.colorFromFloat((float)1.0f, (float)r, (float)g, (float)b);
        int clear = FastColor.ARGB32.colorFromFloat((float)0.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        Matrix4f matrix = new Matrix4f((Matrix4fc)poseStack.last().pose());
        matrix.translate((Vector3fc)position.toVector3f());
        matrix.translate(0.5f, 0.5f, 0.5f);
        matrix.scale(0.03125f);
        matrix.rotate((Quaternionfc)Axis.ZP.rotationDegrees(180.0f));
        Billboarder.INSTANCE.withCameraRotation(matrix);
        float width = (float)ClientDSLKt.getMC().font.width(text) / -2.0f;
        ClientDSLKt.getMC().font.drawInBatch(text, width, 0.0f, col, false, matrix, buffer, Font.DisplayMode.SEE_THROUGH, clear, 0, true);
    }

    public static /* synthetic */ void render$default(DebugTextDisplay debugTextDisplay, String string, Vec3 vec3, MultiBufferSource multiBufferSource, PoseStack poseStack, float f, float f2, float f3, int n, Object object) {
        if ((n & 0x10) != 0) {
            f = 1.0f;
        }
        if ((n & 0x20) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x40) != 0) {
            f3 = 1.0f;
        }
        debugTextDisplay.render(string, vec3, multiBufferSource, poseStack, f, f2, f3);
    }
}

