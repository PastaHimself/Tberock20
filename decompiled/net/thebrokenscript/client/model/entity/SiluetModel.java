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
 */
package net.thebrokenscript.client.model.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.entity.BaseSiluetEntity;
import net.thebrokenscript.brokencore.api.entity.base.UwuableGeoModel;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016\u00a2\u0006\u0002\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\t\u00a8\u0006\u001a"}, d2={"Lnet/thebrokenscript/client/model/entity/SiluetModel;", "T", "Lnet/thebrokenscript/api/entity/BaseSiluetEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableGeoModel;", "<init>", "()V", "modelPath", "Lnet/minecraft/resources/ResourceLocation;", "getModelPath", "()Lnet/minecraft/resources/ResourceLocation;", "texturePath", "getTexturePath", "animationPath", "getAnimationPath", "uwuModelPath", "getUwuModelPath", "uwuTexturePath", "getUwuTexturePath", "setCustomAnimations", "", "animatable", "instanceId", "", "animationState", "Lsoftware/bernie/geckolib/animation/AnimationState;", "(Lnet/thebrokenscript/api/entity/BaseSiluetEntity;JLsoftware/bernie/geckolib/animation/AnimationState;)V", "thebrokenscript-common"})
public final class SiluetModel<T extends BaseSiluetEntity>
extends UwuableGeoModel<T> {
    @NotNull
    private final ResourceLocation modelPath = TBSConstants.id("geo/error5v2.geo.json");
    @NotNull
    private final ResourceLocation texturePath = TBSConstants.id("textures/entities/siluetoverhaul.png");
    @NotNull
    private final ResourceLocation animationPath = TBSConstants.id("animations/error5v2.animation.json");
    @NotNull
    private final ResourceLocation uwuModelPath = TBSConstants.id("geo/error5v2.geo.json");
    @NotNull
    private final ResourceLocation uwuTexturePath = TBSConstants.id("textures/entities/siluetoverhaul.png");

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

    public void setCustomAnimations(@NotNull T animatable, long instanceId, @NotNull AnimationState<T> animationState) {
        Intrinsics.checkNotNullParameter(animatable, (String)"animatable");
        Intrinsics.checkNotNullParameter(animationState, (String)"animationState");
        GeoBone head = this.getAnimationProcessor().getBone("bone");
        if (head != null) {
            head.setRotX(0.0f);
            head.setRotY(0.0f);
            head.setRotZ(0.0f);
        }
    }
}

