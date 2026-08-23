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
 *  net.minecraft.world.phys.AABB
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.debug.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/brokencore/api/debug/renderer/DebugBoxOutline;", "", "box", "Lnet/minecraft/world/phys/AABB;", "lineWidth", "", "r", "", "g", "b", "<init>", "(Lnet/minecraft/world/phys/AABB;DFFF)V", "getBox", "()Lnet/minecraft/world/phys/AABB;", "getLineWidth", "()D", "setLineWidth", "(D)V", "getR", "()F", "setR", "(F)V", "getG", "setG", "getB", "setB", "render", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "drawLines", "brokencore-common"})
public final class DebugBoxOutline {
    @NotNull
    private final AABB box;
    private double lineWidth;
    private float r;
    private float g;
    private float b;

    public DebugBoxOutline(@NotNull AABB box, double lineWidth, float r, float g, float b) {
        Intrinsics.checkNotNullParameter((Object)box, (String)"box");
        this.box = box;
        this.lineWidth = lineWidth;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public /* synthetic */ DebugBoxOutline(AABB aABB, double d, float f, float f2, float f3, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            d = 1.0;
        }
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        if ((n & 8) != 0) {
            f2 = 0.0f;
        }
        if ((n & 0x10) != 0) {
            f3 = 0.0f;
        }
        this(aABB, d, f, f2, f3);
    }

    @NotNull
    public final AABB getBox() {
        return this.box;
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
        this.drawLines(poseStack, buffer);
        poseStack.popPose();
    }

    private final void drawLines(PoseStack poseStack, MultiBufferSource buffer) {
        VertexConsumer buf = buffer.getBuffer(RenderType.debugLineStrip((double)this.lineWidth));
        float mix = (float)this.box.minX;
        float miy = (float)this.box.minY;
        float miz = (float)this.box.minZ;
        float mxx = (float)this.box.maxX;
        float mxy = (float)this.box.maxY;
        float mxz = (float)this.box.maxZ;
        buf.addVertex(poseStack.last(), mix, miy, miz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mix, miy, mxz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mix, miy, miz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mxx, miy, miz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mxx, miy, mxz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mxx, miy, miz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mxx, mxy, miz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mxx, mxy, mxz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mxx, mxy, miz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mix, mxy, miz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mix, mxy, mxz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mix, mxy, miz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mix, miy, miz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mix, miy, mxz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mxx, miy, mxz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mxx, mxy, mxz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mix, mxy, mxz).setColor(this.r, this.g, this.b, 1.0f);
        buf.addVertex(poseStack.last(), mix, miy, mxz).setColor(this.r, this.g, this.b, 1.0f);
    }
}

