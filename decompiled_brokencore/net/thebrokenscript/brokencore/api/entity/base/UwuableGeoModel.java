/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.texture.MissingTextureAtlasSprite
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.model.GeoModel
 */
package net.thebrokenscript.brokencore.api.entity.base;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.BCApi;
import net.thebrokenscript.brokencore.api.entity.base.Uwuable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u0000*\f\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0015J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0015J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0015R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u0004\u0018\u00010\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\n\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/base/UwuableGeoModel;", "T", "Lnet/thebrokenscript/brokencore/api/entity/base/Uwuable;", "Lsoftware/bernie/geckolib/animatable/GeoAnimatable;", "Lsoftware/bernie/geckolib/model/GeoModel;", "<init>", "()V", "modelPath", "Lnet/minecraft/resources/ResourceLocation;", "getModelPath", "()Lnet/minecraft/resources/ResourceLocation;", "texturePath", "getTexturePath", "animationPath", "getAnimationPath", "uwuModelPath", "getUwuModelPath", "uwuTexturePath", "getUwuTexturePath", "getModelResource", "animatable", "(Lnet/thebrokenscript/brokencore/api/entity/base/Uwuable;)Lnet/minecraft/resources/ResourceLocation;", "getTextureResource", "getAnimationResource", "brokencore-common"})
public abstract class UwuableGeoModel<T extends Uwuable & GeoAnimatable>
extends GeoModel<T> {
    @NotNull
    public abstract ResourceLocation getModelPath();

    @Nullable
    public abstract ResourceLocation getTexturePath();

    @Nullable
    public abstract ResourceLocation getAnimationPath();

    @Nullable
    public abstract ResourceLocation getUwuModelPath();

    @Nullable
    public abstract ResourceLocation getUwuTexturePath();

    @Nullable
    public ResourceLocation getModelResource(@NotNull T animatable) {
        Intrinsics.checkNotNullParameter(animatable, (String)"animatable");
        return animatable.isUwu() && this.getUwuModelPath() != null ? this.getUwuModelPath() : this.getModelPath();
    }

    @Nullable
    public ResourceLocation getTextureResource(@NotNull T animatable) {
        ResourceLocation resourceLocation;
        Intrinsics.checkNotNullParameter(animatable, (String)"animatable");
        if (animatable.isUwu() && this.getUwuTexturePath() != null) {
            resourceLocation = this.getUwuTexturePath();
        } else {
            resourceLocation = this.getTexturePath();
            if (resourceLocation == null) {
                resourceLocation = MissingTextureAtlasSprite.getLocation();
            }
        }
        return resourceLocation;
    }

    @Nullable
    public ResourceLocation getAnimationResource(@NotNull T animatable) {
        Intrinsics.checkNotNullParameter(animatable, (String)"animatable");
        return this.getAnimationPath() != null ? this.getAnimationPath() : BCApi.id("animations/nothing.animation.json");
    }
}

