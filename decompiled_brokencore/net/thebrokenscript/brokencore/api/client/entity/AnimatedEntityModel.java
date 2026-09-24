/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.animation.AnimationDefinition
 *  net.minecraft.client.model.HierarchicalModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.world.entity.AnimationState
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.AnimationState;
import net.thebrokenscript.brokencore.api.client.entity.AnimatedEntityModel;
import net.thebrokenscript.brokencore.api.entity.anim.AnimatedMonster;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0017\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0004\u001a\u00020\u0005H\u0016J=\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016\u00a2\u0006\u0002\u0010\u0013J0\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u001d"}, d2={"Lnet/thebrokenscript/brokencore/api/client/entity/AnimatedEntityModel;", "E", "Lnet/thebrokenscript/brokencore/api/entity/anim/AnimatedMonster;", "Lnet/minecraft/client/model/HierarchicalModel;", "root", "Lnet/minecraft/client/model/geom/ModelPart;", "<init>", "(Lnet/minecraft/client/model/geom/ModelPart;)V", "getRoot", "()Lnet/minecraft/client/model/geom/ModelPart;", "setupAnim", "", "entity", "limbSwing", "", "limbSwingAmount", "ageInTicks", "netHeadYaw", "headPitch", "(Lnet/thebrokenscript/brokencore/api/entity/anim/AnimatedMonster;FFFFF)V", "renderToBuffer", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "vertexConsumer", "Lcom/mojang/blaze3d/vertex/VertexConsumer;", "packedLight", "", "packedOverlay", "color", "brokencore-common"})
public class AnimatedEntityModel<E extends AnimatedMonster<?>>
extends HierarchicalModel<E> {
    @NotNull
    private final ModelPart root;

    public AnimatedEntityModel(@NotNull ModelPart root) {
        Intrinsics.checkNotNullParameter((Object)root, (String)"root");
        this.root = root;
    }

    @NotNull
    protected final ModelPart getRoot() {
        return this.root;
    }

    @NotNull
    public ModelPart root() {
        return this.root;
    }

    public void setupAnim(@NotNull E entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        this.root.getAllParts().forEach(arg_0 -> AnimatedEntityModel.setupAnim$lambda$0(setupAnim.1.INSTANCE, arg_0));
        Iterator iterator = ((AnimatedMonster)((Object)entity)).getInternalAnims$brokencore_common().entrySet().iterator();
        while (iterator.hasNext()) {
            Pair<AnimationState, AnimationDefinition> v = iterator.next().getValue();
            this.animate((AnimationState)v.getFirst(), (AnimationDefinition)v.getSecond(), ageInTicks);
        }
    }

    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)vertexConsumer, (String)"vertexConsumer");
        this.root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    private static final void setupAnim$lambda$0(Function1 $tmp0, Object p0) {
        $tmp0.invoke(p0);
    }
}

