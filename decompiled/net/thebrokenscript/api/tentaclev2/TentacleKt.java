/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.util.Mth
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.ext.RenderExtKt
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Quaternionf
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.api.tentaclev2;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.tentaclev2.Tentacle;
import net.thebrokenscript.api.tentaclev2.TentacleNode;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.ext.RenderExtKt;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0010"}, d2={"verticesCount", "", "getVerticesCount", "()I", "setVerticesCount", "(I)V", "debugDrawTentacle", "", "tentacle", "Lnet/thebrokenscript/api/tentaclev2/Tentacle;", "cam", "Lnet/minecraft/world/phys/Vec3;", "pose", "Lcom/mojang/blaze3d/vertex/PoseStack;", "bufs", "Lnet/minecraft/client/renderer/MultiBufferSource;", "thebrokenscript-common"})
public final class TentacleKt {
    private static int verticesCount;

    public static final int getVerticesCount() {
        return verticesCount;
    }

    public static final void setVerticesCount(int n) {
        verticesCount = n;
    }

    public static final void debugDrawTentacle(@NotNull Tentacle tentacle, @NotNull Vec3 cam, @NotNull PoseStack pose, @NotNull MultiBufferSource bufs) {
        Intrinsics.checkNotNullParameter((Object)tentacle, (String)"tentacle");
        Intrinsics.checkNotNullParameter((Object)cam, (String)"cam");
        Intrinsics.checkNotNullParameter((Object)pose, (String)"pose");
        Intrinsics.checkNotNullParameter((Object)bufs, (String)"bufs");
        RenderExtKt.pushPop((PoseStack)pose, () -> TentacleKt.debugDrawTentacle$lambda$0(pose, cam, tentacle, bufs));
    }

    private static final Unit debugDrawTentacle$lambda$0(PoseStack $pose, Vec3 $cam, Tentacle $tentacle, MultiBufferSource $bufs) {
        Vec3 vec3 = $cam.reverse();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"reverse(...)");
        RenderExtKt.translate((PoseStack)$pose, (Vec3)vec3);
        for (List list : CollectionsKt.windowed$default((Iterable)$tentacle.getNodes(), (int)2, (int)0, (boolean)false, (int)6, null)) {
            TentacleNode a = (TentacleNode)list.get(0);
            TentacleNode b = (TentacleNode)list.get(1);
            Vector3f vector3f = b.getPosition().sub((Vector3fc)a.getPosition(), new Vector3f());
            Intrinsics.checkNotNullExpressionValue((Object)vector3f, (String)"sub(...)");
            Vector3f dir = PositionUtil.getNorm((Vector3f)vector3f);
            Vector3f axis = new Vector3f(0.0f, 1.0f, 0.0f);
            Quaternionf rot = new Quaternionf().rotationTo((Vector3fc)axis, (Vector3fc)dir);
            RenderExtKt.pushPop((PoseStack)$pose, () -> TentacleKt.debugDrawTentacle$lambda$0$0(b, a, $pose, rot, $bufs));
        }
        return Unit.INSTANCE;
    }

    private static final Unit debugDrawTentacle$lambda$0$0(TentacleNode $b, TentacleNode $a, PoseStack $pose, Quaternionf $rot, MultiBufferSource $bufs) {
        float length = $b.getPosition().distance((Vector3fc)$a.getPosition());
        RenderExtKt.translate((PoseStack)$pose, (Vector3f)$a.getPosition());
        $pose.mulPose($rot);
        VertexConsumer buf = $bufs.getBuffer(RenderType.debugQuads());
        int res = 6;
        float part = (float)Math.PI * 2 / (float)res;
        List vertices = new ArrayList();
        for (int i = 0; i < res; ++i) {
            float rot = part * (float)i;
            float rot2 = part * (float)(i + 1);
            float ax = Mth.cos((float)rot) * $a.getThickness();
            float az = Mth.sin((float)rot) * $a.getThickness();
            float ax2 = Mth.cos((float)rot2) * $a.getThickness();
            float az2 = Mth.sin((float)rot2) * $a.getThickness();
            float bx = Mth.cos((float)rot) * $b.getThickness();
            float bz = Mth.sin((float)rot) * $b.getThickness();
            float bx2 = Mth.cos((float)rot2) * $b.getThickness();
            float bz2 = Mth.sin((float)rot2) * $b.getThickness();
            Collection collection = vertices;
            Object[] objectArray = new Vector3f[]{new Vector3f(ax, 0.0f, az), new Vector3f(ax2, 0.0f, az2), new Vector3f(bx2, length, bz2), new Vector3f(bx, length, bz)};
            CollectionsKt.addAll((Collection)collection, (Object[])objectArray);
            verticesCount += 4;
        }
        for (Vector3f vertex : vertices) {
            buf.addVertex($pose.last(), vertex).setColor(-65536);
        }
        return Unit.INSTANCE;
    }
}

