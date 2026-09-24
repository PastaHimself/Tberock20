/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.core.Direction
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Quaternionf
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.debug.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.thebrokenscript.brokencore.api.dsl.DirectionUtil;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0018\u0010'\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016\u00a8\u0006("}, d2={"Lnet/thebrokenscript/brokencore/api/debug/renderer/DebugArrow;", "", "position", "Lorg/joml/Vector3f;", "quaternion", "Lorg/joml/Quaternionf;", "scale", "", "lineWidth", "", "r", "g", "b", "<init>", "(Lorg/joml/Vector3f;Lorg/joml/Quaternionf;FDFFF)V", "getPosition", "()Lorg/joml/Vector3f;", "getQuaternion", "()Lorg/joml/Quaternionf;", "getScale", "()F", "setScale", "(F)V", "getLineWidth", "()D", "setLineWidth", "(D)V", "getR", "setR", "getG", "setG", "getB", "setB", "render", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "drawLines", "brokencore-common"})
public final class DebugArrow {
    @NotNull
    private final Vector3f position;
    @NotNull
    private final Quaternionf quaternion;
    private float scale;
    private double lineWidth;
    private float r;
    private float g;
    private float b;

    public DebugArrow(@NotNull Vector3f position, @NotNull Quaternionf quaternion, float scale, double lineWidth, float r, float g, float b) {
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        Intrinsics.checkNotNullParameter((Object)quaternion, (String)"quaternion");
        this.position = position;
        this.quaternion = quaternion;
        this.scale = scale;
        this.lineWidth = lineWidth;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public /* synthetic */ DebugArrow(Vector3f vector3f, Quaternionf quaternionf, float f, double d, float f2, float f3, float f4, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            quaternionf = DirectionUtil.getQuaternion(Direction.UP);
        }
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        if ((n & 8) != 0) {
            d = 1.0;
        }
        if ((n & 0x10) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x20) != 0) {
            f3 = 0.0f;
        }
        if ((n & 0x40) != 0) {
            f4 = 0.0f;
        }
        this(vector3f, quaternionf, f, d, f2, f3, f4);
    }

    @NotNull
    public final Vector3f getPosition() {
        return this.position;
    }

    @NotNull
    public final Quaternionf getQuaternion() {
        return this.quaternion;
    }

    public final float getScale() {
        return this.scale;
    }

    public final void setScale(float f) {
        this.scale = f;
    }

    public final double getLineWidth() {
        return this.lineWidth;
    }

    public final void setLineWidth(double d) {
        this.lineWidth = d;
    }

    public final float getR() {
        return this.r;
    }

    public final void setR(float f) {
        this.r = f;
    }

    public final float getG() {
        return this.g;
    }

    public final void setG(float f) {
        this.g = f;
    }

    public final float getB() {
        return this.b;
    }

    public final void setB(float f) {
        this.b = f;
    }

    public final void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        poseStack.pushPose();
        poseStack.mulPose(this.quaternion);
        poseStack.translate(this.position.x, this.position.y, this.position.z);
        this.drawLines(poseStack, buffer);
        poseStack.popPose();
    }

    private final void drawLines(PoseStack poseStack, MultiBufferSource buffer) {
        VertexConsumer buf = buffer.getBuffer(RenderType.debugLineStrip((double)this.lineWidth));
        buf.addVertex(poseStack.last(), 0.0f, -this.scale, 0.0f).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), 0.0f, this.scale, 0.0f).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), this.scale * 0.5f, this.scale * 0.33f, 0.0f).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), 0.0f, this.scale, 0.0f).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), this.scale * -0.5f, this.scale * 0.33f, 0.0f).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), 0.0f, this.scale, 0.0f).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), 0.0f, this.scale * 0.33f, this.scale * -0.5f).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), 0.0f, this.scale, 0.0f).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), 0.0f, this.scale * 0.33f, this.scale * 0.5f).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), 0.0f, this.scale, 0.0f).setColor(this.r, this.g, this.b, 1.0f);
    }
}

