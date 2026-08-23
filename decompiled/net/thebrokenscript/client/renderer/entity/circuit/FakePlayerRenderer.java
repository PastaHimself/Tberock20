/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.math.Axis
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.model.HumanoidArmorModel
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.HumanoidModel$ArmPose
 *  net.minecraft.client.model.PlayerModel
 *  net.minecraft.client.model.geom.EntityModelSet
 *  net.minecraft.client.model.geom.ModelLayers
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.renderer.ItemInHandRenderer
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.LivingEntityRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.ArrowLayer
 *  net.minecraft.client.renderer.entity.layers.BeeStingerLayer
 *  net.minecraft.client.renderer.entity.layers.CustomHeadLayer
 *  net.minecraft.client.renderer.entity.layers.ElytraLayer
 *  net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.client.renderer.entity.layers.SpinAttackEffectLayer
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.client.resources.PlayerSkin$Model
 *  net.minecraft.network.chat.CommonComponents
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.chat.numbers.NumberFormat
 *  net.minecraft.network.chat.numbers.StyledFormat
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.HumanoidArm
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.PlayerModelPart
 *  net.minecraft.world.item.CrossbowItem
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.item.UseAnim
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.scores.DisplaySlot
 *  net.minecraft.world.scores.Objective
 *  net.minecraft.world.scores.ReadOnlyScoreInfo
 *  net.minecraft.world.scores.ScoreHolder
 *  net.minecraft.world.scores.Scoreboard
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.renderer.entity.circuit;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ArrowLayer;
import net.minecraft.client.renderer.entity.layers.BeeStingerLayer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.layers.SpinAttackEffectLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.numbers.NumberFormat;
import net.minecraft.network.chat.numbers.StyledFormat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.DisplaySlot;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.ReadOnlyScoreInfo;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Scoreboard;
import net.thebrokenscript.client.api.SkinManager;
import net.thebrokenscript.client.renderer.entity.circuit.CapeLayer;
import net.thebrokenscript.client.renderer.entity.circuit.Deadmau5EarsLayer;
import net.thebrokenscript.client.renderer.entity.circuit.ParrotOnShoulderLayer;
import net.thebrokenscript.client.renderer.entity.circuit.PlayerItemInHandLayer;
import net.thebrokenscript.entity.circuit.FakePlayerEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J8\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J \u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0014H\u0014J8\u0010)\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u0014H\u0014J&\u0010.\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0002J&\u00100\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0002J8\u00101\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00022\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\tH\u0002J8\u00104\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u00142\u0006\u00106\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0014H\u0014R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2={"Lnet/thebrokenscript/client/renderer/entity/circuit/FakePlayerRenderer;", "Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;", "Lnet/thebrokenscript/entity/circuit/FakePlayerEntity;", "Lnet/minecraft/client/model/PlayerModel;", "cx", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V", "wideLayer", "Lnet/minecraft/client/model/geom/ModelPart;", "slimLayer", "modelType", "Lnet/minecraft/client/resources/PlayerSkin$Model;", "updateModelType", "", "uuid", "", "render", "entity", "entityYaw", "", "partialTicks", "poseStack", "Lcom/mojang/blaze3d/vertex/PoseStack;", "buffer", "Lnet/minecraft/client/renderer/MultiBufferSource;", "packedLight", "", "getRenderOffset", "Lnet/minecraft/world/phys/Vec3;", "setModelProperties", "getArmPose", "Lnet/minecraft/client/model/HumanoidModel$ArmPose;", "player", "hand", "Lnet/minecraft/world/InteractionHand;", "getTextureLocation", "Lnet/minecraft/resources/ResourceLocation;", "scale", "livingEntity", "partialTickTime", "renderNameTag", "displayName", "Lnet/minecraft/network/chat/Component;", "bufferSource", "partialTick", "renderRightHand", "combinedLight", "renderLeftHand", "renderHand", "arm", "armWear", "setupRotations", "bob", "yBodyRot", "thebrokenscript-common"})
public final class FakePlayerRenderer
extends LivingEntityRenderer<FakePlayerEntity, PlayerModel<FakePlayerEntity>> {
    @NotNull
    private final ModelPart wideLayer;
    @NotNull
    private final ModelPart slimLayer;
    @NotNull
    private PlayerSkin.Model modelType;

    public FakePlayerRenderer(@NotNull EntityRendererProvider.Context cx) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        super(cx, (EntityModel)new PlayerModel(cx.bakeLayer(ModelLayers.PLAYER), false), 0.5f);
        this.modelType = PlayerSkin.Model.WIDE;
        ModelPart modelPart = cx.bakeLayer(ModelLayers.PLAYER);
        Intrinsics.checkNotNullExpressionValue((Object)modelPart, (String)"bakeLayer(...)");
        this.wideLayer = modelPart;
        ModelPart modelPart2 = cx.bakeLayer(ModelLayers.PLAYER_SLIM);
        Intrinsics.checkNotNullExpressionValue((Object)modelPart2, (String)"bakeLayer(...)");
        this.slimLayer = modelPart2;
        this.addLayer((RenderLayer)new HumanoidArmorLayer((RenderLayerParent)this, (HumanoidModel)new HumanoidArmorModel(cx.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), (HumanoidModel)new HumanoidArmorModel(cx.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), cx.getModelManager()));
        RenderLayerParent renderLayerParent = (RenderLayerParent)this;
        ItemInHandRenderer itemInHandRenderer = cx.getItemInHandRenderer();
        Intrinsics.checkNotNullExpressionValue((Object)itemInHandRenderer, (String)"getItemInHandRenderer(...)");
        this.addLayer((RenderLayer)new PlayerItemInHandLayer(renderLayerParent, itemInHandRenderer));
        this.addLayer((RenderLayer)new ArrowLayer(cx, (LivingEntityRenderer)this));
        this.addLayer(new Deadmau5EarsLayer((RenderLayerParent<FakePlayerEntity, PlayerModel<FakePlayerEntity>>)((RenderLayerParent)this)));
        this.addLayer(new CapeLayer((RenderLayerParent<FakePlayerEntity, PlayerModel<FakePlayerEntity>>)((RenderLayerParent)this)));
        this.addLayer((RenderLayer)new CustomHeadLayer((RenderLayerParent)this, cx.getModelSet(), cx.getItemInHandRenderer()));
        this.addLayer((RenderLayer)new ElytraLayer((RenderLayerParent)this, cx.getModelSet()));
        RenderLayerParent renderLayerParent2 = (RenderLayerParent)this;
        EntityModelSet entityModelSet = cx.getModelSet();
        Intrinsics.checkNotNullExpressionValue((Object)entityModelSet, (String)"getModelSet(...)");
        this.addLayer(new ParrotOnShoulderLayer(renderLayerParent2, entityModelSet));
        this.addLayer((RenderLayer)new SpinAttackEffectLayer((RenderLayerParent)this, cx.getModelSet()));
        this.addLayer((RenderLayer)new BeeStingerLayer((LivingEntityRenderer)this));
    }

    private final void updateModelType(String uuid) {
        boolean currentlySlim;
        boolean useSlim = SkinManager.INSTANCE.usesSlimArms(uuid);
        boolean bl = currentlySlim = this.modelType == PlayerSkin.Model.SLIM;
        if (currentlySlim != useSlim) {
            this.model = (EntityModel)new PlayerModel(useSlim ? this.slimLayer : this.wideLayer, useSlim);
            this.modelType = useSlim ? PlayerSkin.Model.SLIM : PlayerSkin.Model.WIDE;
        }
    }

    public void render(@NotNull FakePlayerEntity entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        SkinManager.INSTANCE.loadSkin(String.valueOf(entity.getSelectedPlayer()));
        this.updateModelType(String.valueOf(entity.getSelectedPlayer()));
        this.setModelProperties(entity);
        super.render((LivingEntity)entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @NotNull
    public Vec3 getRenderOffset(@NotNull FakePlayerEntity entity, float partialTicks) {
        Vec3 vec3;
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        if (entity.isCrouching()) {
            vec3 = new Vec3(0.0, (double)(entity.getScale() * -2.0f) / 16.0, 0.0);
        } else {
            Vec3 vec32 = super.getRenderOffset((Entity)entity, partialTicks);
            vec3 = vec32;
            Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"getRenderOffset(...)");
        }
        return vec3;
    }

    private final void setModelProperties(FakePlayerEntity entity) {
        PlayerModel model2 = (PlayerModel)this.getModel();
        if (entity.isSpectator()) {
            model2.setAllVisible(false);
            model2.head.visible = true;
            model2.hat.visible = true;
        } else {
            model2.setAllVisible(true);
            model2.hat.visible = entity.isModelPartShown(PlayerModelPart.HAT);
            model2.jacket.visible = entity.isModelPartShown(PlayerModelPart.JACKET);
            model2.leftPants.visible = entity.isModelPartShown(PlayerModelPart.LEFT_PANTS_LEG);
            model2.rightPants.visible = entity.isModelPartShown(PlayerModelPart.RIGHT_PANTS_LEG);
            model2.leftSleeve.visible = entity.isModelPartShown(PlayerModelPart.LEFT_SLEEVE);
            model2.rightSleeve.visible = entity.isModelPartShown(PlayerModelPart.RIGHT_SLEEVE);
            model2.crouching = entity.isCrouching();
            HumanoidModel.ArmPose rightArmPose = this.getArmPose(entity, InteractionHand.MAIN_HAND);
            HumanoidModel.ArmPose leftArmPose = this.getArmPose(entity, InteractionHand.OFF_HAND);
            if (rightArmPose.isTwoHanded()) {
                HumanoidModel.ArmPose armPose = leftArmPose = entity.getOffhandItem().isEmpty() ? HumanoidModel.ArmPose.EMPTY : HumanoidModel.ArmPose.ITEM;
            }
            if (entity.getMainArm() == HumanoidArm.RIGHT) {
                model2.rightArmPose = rightArmPose;
                model2.leftArmPose = leftArmPose;
            } else {
                model2.rightArmPose = leftArmPose;
                model2.leftArmPose = rightArmPose;
            }
        }
    }

    private final HumanoidModel.ArmPose getArmPose(FakePlayerEntity player, InteractionHand hand) {
        ItemStack handItem = player.getItemInHand(hand);
        if (handItem.isEmpty()) {
            return HumanoidModel.ArmPose.EMPTY;
        }
        if (player.getUsedItemHand() == hand && player.getUseItemRemainingTicks() > 0) {
            UseAnim anim = handItem.getUseAnimation();
            if (anim == UseAnim.BLOCK) {
                return HumanoidModel.ArmPose.BLOCK;
            }
            if (anim == UseAnim.BOW) {
                return HumanoidModel.ArmPose.BOW_AND_ARROW;
            }
            if (anim == UseAnim.SPEAR) {
                return HumanoidModel.ArmPose.THROW_SPEAR;
            }
            if (anim == UseAnim.CROSSBOW && hand == player.getUsedItemHand()) {
                return HumanoidModel.ArmPose.CROSSBOW_CHARGE;
            }
            if (anim == UseAnim.SPYGLASS) {
                return HumanoidModel.ArmPose.SPYGLASS;
            }
            if (anim == UseAnim.TOOT_HORN) {
                return HumanoidModel.ArmPose.TOOT_HORN;
            }
            if (anim == UseAnim.BRUSH) {
                return HumanoidModel.ArmPose.BRUSH;
            }
        } else if (!player.swinging && handItem.is(Items.CROSSBOW) && CrossbowItem.isCharged((ItemStack)handItem)) {
            return HumanoidModel.ArmPose.CROSSBOW_HOLD;
        }
        return HumanoidModel.ArmPose.ITEM;
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull FakePlayerEntity entity) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        return SkinManager.INSTANCE.getSkin(String.valueOf(entity.getSelectedPlayer()));
    }

    protected void scale(@NotNull FakePlayerEntity livingEntity, @NotNull PoseStack poseStack, float partialTickTime) {
        Intrinsics.checkNotNullParameter((Object)((Object)livingEntity), (String)"livingEntity");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        float amount = 0.9375f;
        poseStack.scale(amount, amount, amount);
    }

    protected void renderNameTag(@NotNull FakePlayerEntity entity, @NotNull Component displayName, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight, float partialTick) {
        Scoreboard scoreboard;
        Objective objective;
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)displayName, (String)"displayName");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)bufferSource, (String)"bufferSource");
        double dist = this.entityRenderDispatcher.distanceToSqr((Entity)entity);
        poseStack.pushPose();
        if (dist < 100.0 && (objective = (scoreboard = entity.getScoreboard()).getDisplayObjective(DisplaySlot.BELOW_NAME)) != null) {
            ReadOnlyScoreInfo score = scoreboard.getPlayerScoreInfo((ScoreHolder)entity, objective);
            MutableComponent component = ReadOnlyScoreInfo.safeFormatValue((ReadOnlyScoreInfo)score, (NumberFormat)objective.numberFormatOrDefault((NumberFormat)StyledFormat.NO_STYLE));
            super.renderNameTag((Entity)entity, (Component)Component.empty().append((Component)component).append(CommonComponents.SPACE).append(objective.getDisplayName()), poseStack, bufferSource, packedLight, partialTick);
            poseStack.translate(0.0f, 0.25875f, 0.0f);
        }
        super.renderNameTag((Entity)entity, displayName, poseStack, bufferSource, packedLight, partialTick);
        poseStack.popPose();
    }

    public final void renderRightHand(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int combinedLight, @NotNull FakePlayerEntity player) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        Intrinsics.checkNotNullParameter((Object)((Object)player), (String)"player");
        ModelPart modelPart = ((PlayerModel)this.model).rightArm;
        Intrinsics.checkNotNullExpressionValue((Object)modelPart, (String)"rightArm");
        ModelPart modelPart2 = ((PlayerModel)this.model).rightSleeve;
        Intrinsics.checkNotNullExpressionValue((Object)modelPart2, (String)"rightSleeve");
        this.renderHand(poseStack, buffer, combinedLight, player, modelPart, modelPart2);
    }

    public final void renderLeftHand(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int combinedLight, @NotNull FakePlayerEntity player) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        Intrinsics.checkNotNullParameter((Object)((Object)player), (String)"player");
        ModelPart modelPart = ((PlayerModel)this.model).leftArm;
        Intrinsics.checkNotNullExpressionValue((Object)modelPart, (String)"leftArm");
        ModelPart modelPart2 = ((PlayerModel)this.model).leftSleeve;
        Intrinsics.checkNotNullExpressionValue((Object)modelPart2, (String)"leftSleeve");
        this.renderHand(poseStack, buffer, combinedLight, player, modelPart, modelPart2);
    }

    private final void renderHand(PoseStack poseStack, MultiBufferSource buffer, int combinedLight, FakePlayerEntity player, ModelPart arm, ModelPart armWear) {
        PlayerModel model2 = (PlayerModel)this.getModel();
        this.setModelProperties(player);
        model2.attackTime = 0.0f;
        model2.crouching = false;
        model2.swimAmount = 0.0f;
        model2.setupAnim((LivingEntity)player, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        arm.xRot = 0.0f;
        ResourceLocation skinTex = player.getSkin().texture();
        arm.render(poseStack, buffer.getBuffer(RenderType.entitySolid((ResourceLocation)skinTex)), combinedLight, OverlayTexture.NO_OVERLAY);
        armWear.xRot = 0.0f;
        armWear.render(poseStack, buffer.getBuffer(RenderType.entityTranslucent((ResourceLocation)skinTex)), combinedLight, OverlayTexture.NO_OVERLAY);
    }

    protected void setupRotations(@NotNull FakePlayerEntity entity, @NotNull PoseStack poseStack, float bob, float yBodyRot, float partialTick, float scale) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        float swimAmount = entity.getSwimAmount(partialTick);
        float viewX = entity.getViewXRot(partialTick);
        if (entity.isFallFlying()) {
            super.setupRotations((LivingEntity)entity, poseStack, bob, yBodyRot, partialTick, scale);
            float fallFlyingTicks = (float)entity.getFallFlyingTicks() + partialTick;
            float rotation = Mth.clamp((float)(fallFlyingTicks * fallFlyingTicks / 100.0f), (float)0.0f, (float)1.0f);
            if (!entity.isAutoSpinAttack()) {
                poseStack.mulPose(Axis.XP.rotationDegrees(rotation * (-90.0f - viewX)));
            }
            Vec3 viewVector = entity.getViewVector(partialTick);
            Vec3 deltaMove = entity.getDeltaMovementLerped(partialTick);
            double deltaDist = deltaMove.horizontalDistanceSqr();
            double viewDist = viewVector.horizontalDistanceSqr();
            if (deltaDist > 0.0 && viewDist > 0.0) {
                double x1 = (deltaMove.x * viewVector.x + deltaMove.z * viewVector.z) / Math.sqrt(deltaDist * viewDist);
                double x2 = deltaMove.x * viewVector.z - deltaMove.z * viewVector.x;
                poseStack.mulPose(Axis.YP.rotation((float)(Math.signum(x2) * Math.acos(x1))));
            }
        } else if (swimAmount > 0.0f) {
            super.setupRotations((LivingEntity)entity, poseStack, bob, yBodyRot, partialTick, scale);
            float distort = entity.isInWater() ? -90.0f - viewX : -90.0f;
            float amount = Mth.lerp((float)swimAmount, (float)0.0f, (float)distort);
            poseStack.mulPose(Axis.XP.rotationDegrees(amount));
            if (entity.isVisuallySwimming()) {
                poseStack.translate(0.0f, -1.0f, 0.3f);
            }
        } else {
            super.setupRotations((LivingEntity)entity, poseStack, bob, yBodyRot, partialTick, scale);
        }
    }
}

