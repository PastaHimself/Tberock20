/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableGeoModel
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.cache.object.GeoBone
 *  software.bernie.geckolib.constant.DataTickets
 *  software.bernie.geckolib.model.data.EntityModelData
 */
package net.thebrokenscript.client.model.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.entity.base.UwuableGeoModel;
import net.thebrokenscript.entity.NoTextureEntity;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.data.EntityModelData;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/client/model/entity/NoTextureModel;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableGeoModel;", "Lnet/thebrokenscript/entity/NoTextureEntity;", "<init>", "()V", "modelPath", "Lnet/minecraft/resources/ResourceLocation;", "getModelPath", "()Lnet/minecraft/resources/ResourceLocation;", "texturePath", "getTexturePath", "animationPath", "getAnimationPath", "uwuModelPath", "getUwuModelPath", "uwuTexturePath", "getUwuTexturePath", "setCustomAnimations", "", "animatable", "instanceId", "", "animationState", "Lsoftware/bernie/geckolib/animation/AnimationState;", "thebrokenscript-common"})
public final class NoTextureModel
extends UwuableGeoModel<NoTextureEntity> {
    @NotNull
    private final ResourceLocation modelPath = TBSConstants.id("geo/notexture.geo.json");
    @NotNull
    private final ResourceLocation texturePath = TBSConstants.id("textures/entities/notexture.png");
    @NotNull
    private final ResourceLocation animationPath = TBSConstants.id("animations/notexture.animation.json");
    @NotNull
    private final ResourceLocation uwuModelPath = TBSConstants.id("geo/notexture_uwu.geo.json");
    @NotNull
    private final ResourceLocation uwuTexturePath = TBSConstants.id("textures/entities/notexture_uwu.png");

    @NotNull
    public ResourceLocation getModelPath() {
        return this.modelPath;
    }

    @NotNull
    public ResourceLocation getTexturePath() {
        return this.texturePath;
    }

    @NotNull
    public ResourceLocation getAnimationPath() {
        return this.animationPath;
    }

    @NotNull
    public ResourceLocation getUwuModelPath() {
        return this.uwuModelPath;
    }

    @NotNull
    public ResourceLocation getUwuTexturePath() {
        return this.uwuTexturePath;
    }

    public void setCustomAnimations(@NotNull NoTextureEntity animatable, long instanceId, @NotNull AnimationState<NoTextureEntity> animationState) {
        Intrinsics.checkNotNullParameter((Object)((Object)animatable), (String)"animatable");
        Intrinsics.checkNotNullParameter(animationState, (String)"animationState");
        GeoBone head = this.getAnimationProcessor().getBone("Head");
        if (head != null) {
            Object object = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            Intrinsics.checkNotNull((Object)object);
            EntityModelData entityData = (EntityModelData)object;
            head.setRotX(entityData.headPitch() * ((float)Math.PI / 180));
            head.setRotY(entityData.netHeadYaw() * ((float)Math.PI / 180));
        }
    }
}

