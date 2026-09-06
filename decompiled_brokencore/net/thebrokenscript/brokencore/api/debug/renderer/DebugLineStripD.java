/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.core.Direction
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Quaternionf
 *  org.joml.Vector3d
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.debug.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.thebrokenscript.brokencore.api.dsl.DirectionUtil;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J\u0018\u0010(\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\r\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001d\u00a8\u0006)"}, d2={"Lnet/thebrokenscript/brokencore/api/debug/renderer/DebugLineStripD;", "", "position", "Lorg/joml/Vector3d;", "positions", "", "quaternion", "Lorg/joml/Quaternionf;", "lineWidth", "", "r", "", "g", "b", "<init>", "(Lorg/joml/Vector3d;Ljava/util/List;Lorg/joml/Quaternionf;DFFF)V", "getPosition", "()Lorg/joml/Vector3d;", "getPositions", "()Ljava/util/List;", "getQuaternion", "()Lorg/joml/Quaternionf;", "getLineWidth", "()D", "setLineWidth", "(D)V", "getR", "()F", "setR", "(F)V", "getG", "setG", "getB", "setB", "render", "", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "drawLines", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nDebugLineStripD.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugLineStripD.kt\nnet/thebrokenscript/brokencore/api/debug/renderer/DebugLineStripD\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,39:1\n1869#2,2:40\n*S KotlinDebug\n*F\n+ 1 DebugLineStripD.kt\nnet/thebrokenscript/brokencore/api/debug/renderer/DebugLineStripD\n*L\n33#1:40,2\n*E\n"})
public final class DebugLineStripD {
    @NotNull
    private final Vector3d position;
    @NotNull
    private final List<Vector3d> positions;
    @NotNull
    private final Quaternionf quaternion;
    private double lineWidth;
    private float r;
    private float g;
    private float b;

    public DebugLineStripD(@NotNull Vector3d position, @NotNull List<? extends Vector3d> positions, @NotNull Quaternionf quaternion, double lineWidth, float r, float g, float b) {
        Intrinsics.checkNotNullParameter((Object)position, (String)"position");
        Intrinsics.checkNotNullParameter(positions, (String)"positions");
        Intrinsics.checkNotNullParameter((Object)quaternion, (String)"quaternion");
        this.position = position;
        this.positions = positions;
        this.quaternion = quaternion;
        this.lineWidth = lineWidth;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public /* synthetic */ DebugLineStripD(Vector3d vector3d, List list, Quaternionf quaternionf, double d, float f, float f2, float f3, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            quaternionf = DirectionUtil.getQuaternion(Direction.UP);
        }
        if ((n & 8) != 0) {
            d = 1.0;
        }
        if ((n & 0x10) != 0) {
            f = 1.0f;
        }
        if ((n & 0x20) != 0) {
            f2 = 0.0f;
        }
        if ((n & 0x40) != 0) {
            f3 = 0.0f;
        }
        this(vector3d, list, quaternionf, d, f, f2, f3);
    }

    @NotNull
    public final Vector3d getPosition() {
        return this.position;
    }

    @NotNull
    public final List<Vector3d> getPositions() {
        return this.positions;
    }

    @NotNull
    public final Quaternionf getQuaternion() {
        return this.quaternion;
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
        Iterable $this$forEach$iv = this.positions;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Vector3d it = (Vector3d)element$iv;
            boolean bl = false;
            buf.addVertex(poseStack.last(), new Vector3f((float)it.x, (float)it.y, (float)it.z)).setColor(this.r, this.g, this.b, 1.0f);
        }
    }
}

