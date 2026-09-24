/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.model.GeoModel
 */
package net.thebrokenscript.brokencore.api.entity.base;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.BCApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0010J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0010R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u0004\u0018\u00010\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\t\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/base/BasicGeoModel;", "T", "Lsoftware/bernie/geckolib/animatable/GeoAnimatable;", "Lsoftware/bernie/geckolib/model/GeoModel;", "<init>", "()V", "modelPath", "Lnet/minecraft/resources/ResourceLocation;", "getModelPath", "()Lnet/minecraft/resources/ResourceLocation;", "texturePath", "getTexturePath", "animationPath", "getAnimationPath", "getModelResource", "animatable", "(Lsoftware/bernie/geckolib/animatable/GeoAnimatable;)Lnet/minecraft/resources/ResourceLocation;", "getTextureResource", "getAnimationResource", "brokencore-common"})
public abstract class BasicGeoModel<T extends GeoAnimatable>
extends GeoModel<T> {
    @NotNull
    public abstract ResourceLocation getModelPath();

    @NotNull
    public abstract ResourceLocation getTexturePath();

    @Nullable
    public abstract ResourceLocation getAnimationPath();

    @NotNull
    public ResourceLocation getModelResource(@NotNull T animatable) {
        Intrinsics.checkNotNullParameter(animatable, (String)"animatable");
        return this.getModelPath();
    }

    @NotNull
    public ResourceLocation getTextureResource(@NotNull T animatable) {
        Intrinsics.checkNotNullParameter(animatable, (String)"animatable");
        return this.getTexturePath();
    }

    @Nullable
    public ResourceLocation getAnimationResource(@NotNull T animatable) {
        Intrinsics.checkNotNullParameter(animatable, (String)"animatable");
        return this.getAnimationPath() != null ? this.getAnimationPath() : BCApi.id("animations/nothing.animation.json");
    }
}

