/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.thebrokenscript.brokencore.api.entity.base.BasicGeoModel
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.animatable.GeoAnimatable
 */
package net.thebrokenscript.client.model.plush;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.entity.base.BasicGeoModel;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/client/model/plush/BasePlushModel;", "T", "Lsoftware/bernie/geckolib/animatable/GeoAnimatable;", "Lnet/thebrokenscript/brokencore/api/entity/base/BasicGeoModel;", "name", "", "<init>", "(Ljava/lang/String;)V", "modelPath", "Lnet/minecraft/resources/ResourceLocation;", "getModelPath", "()Lnet/minecraft/resources/ResourceLocation;", "texturePath", "getTexturePath", "animationPath", "getAnimationPath", "thebrokenscript-common"})
public class BasePlushModel<T extends GeoAnimatable>
extends BasicGeoModel<T> {
    @NotNull
    private final ResourceLocation modelPath;
    @NotNull
    private final ResourceLocation texturePath;
    @NotNull
    private final ResourceLocation animationPath;

    public BasePlushModel(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        this.modelPath = TBSConstants.id("geo/plush/" + name + ".geo.json");
        this.texturePath = TBSConstants.id("textures/plush/" + name + ".png");
        this.animationPath = TBSConstants.id("animations/plush.animation.json");
    }

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
}

