/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.geom.ModelLayers
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.render.CensorQuad
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2f
 *  org.joml.Vector2fc
 */
package net.thebrokenscript.client.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.render.CensorQuad;
import net.thebrokenscript.entity.MotherEntity;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2f;
import org.joml.Vector2fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J8\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0002H\u0014J(\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ(\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001bH\u0014\u00a8\u0006#"}, d2={"Lnet/thebrokenscript/client/entity/renderer/MotherRenderer;", "Lnet/minecraft/client/renderer/entity/MobRenderer;", "Lnet/thebrokenscript/entity/MotherEntity;", "Lnet/minecraft/client/model/EntityModel;", "context", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V", "getTextureLocation", "Lnet/minecraft/resources/ResourceLocation;", "entity", "render", "", "entityYaw", "", "partialTicks", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "packedLight", "", "getShadowRadius", "calcAlpha", "discreteness", "delta", "includeVertical", "", "getRenderType", "Lnet/minecraft/client/renderer/RenderType;", "livingEntity", "bodyVisible", "translucent", "glowing", "Companion", "thebrokenscript-common"})
public final class MotherRenderer
extends MobRenderer<MotherEntity, EntityModel<MotherEntity>> {
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final ModelPart PLACEHOLDER;

    public MotherRenderer(@NotNull EntityRendererProvider.Context context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super(context, (EntityModel)new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull MotherEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return TBSConstants.id("textures/entities/away.png");
    }

    public void render(@NotNull MotherEntity entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        RenderType type = this.getRenderType(entity, true, true, false);
        float a = this.calcAlpha(entity, 0.35f, partialTicks, false);
        PLACEHOLDER.render(poseStack, buffer.getBuffer(type), packedLight, 0, FastColor.ARGB32.colorFromFloat((float)a, (float)1.0f, (float)1.0f, (float)1.0f));
    }

    protected float getShadowRadius(@NotNull MotherEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return 0.0f;
    }

    public final float calcAlpha(@NotNull MotherEntity entity, float discreteness, float delta, boolean includeVertical) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        int width = ClientDSLKt.getMC().getWindow().getGuiScaledWidth();
        int height = ClientDSLKt.getMC().getWindow().getGuiScaledHeight();
        Vec3 vec3 = entity.getPosition(delta).add(0.0, (double)entity.getEyeHeight() * 0.5, 0.0);
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"add(...)");
        Vector2f pos = CensorQuad.INSTANCE.projectPositionToScreen(vec3, delta).div((float)width, (float)height);
        pos.x = 1.0f - pos.x;
        if (!includeVertical) {
            pos.y = 0.5f;
        }
        return Math.max(pos.distance((Vector2fc)new Vector2f(0.5f)) - discreteness, 0.0f);
    }

    public static /* synthetic */ float calcAlpha$default(MotherRenderer motherRenderer, MotherEntity motherEntity, float f, float f2, boolean bl, int n, Object object) {
        if ((n & 8) != 0) {
            bl = false;
        }
        return motherRenderer.calcAlpha(motherEntity, f, f2, bl);
    }

    @NotNull
    protected RenderType getRenderType(@NotNull MotherEntity livingEntity, boolean bodyVisible, boolean translucent, boolean glowing) {
        Intrinsics.checkNotNullParameter((Object)((Object)livingEntity), (String)"livingEntity");
        RenderType renderType = RenderType.entityTranslucentEmissive((ResourceLocation)this.getTextureLocation(livingEntity));
        Intrinsics.checkNotNullExpressionValue((Object)renderType, (String)"entityTranslucentEmissive(...)");
        return renderType;
    }

    static {
        Companion $this$PLACEHOLDER_u24lambda_u240 = Companion = new Companion(null);
        boolean bl = false;
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(-21, -14).addBox(-8.0f, -16.0f, -8.0f, 16.0f, 16.0f, 16.0f, new CubeDeformation(0.0f)), PartPose.offset((float)0.0f, (float)24.0f, (float)0.0f));
        ModelPart modelPart = LayerDefinition.create((MeshDefinition)meshdefinition, (int)16, (int)16).bakeRoot();
        Intrinsics.checkNotNullExpressionValue((Object)modelPart, (String)"bakeRoot(...)");
        PLACEHOLDER = modelPart;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/client/entity/renderer/MotherRenderer$Companion;", "", "<init>", "()V", "PLACEHOLDER", "Lnet/minecraft/client/model/geom/ModelPart;", "getPLACEHOLDER", "()Lnet/minecraft/client/model/geom/ModelPart;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ModelPart getPLACEHOLDER() {
            return PLACEHOLDER;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

