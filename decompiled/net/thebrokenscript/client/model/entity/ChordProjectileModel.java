/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.resources.ResourceLocation
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableArrow
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableGeoModel
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.client.model.entity;

import kotlin.Metadata;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.entity.base.UwuableArrow;
import net.thebrokenscript.brokencore.api.entity.base.UwuableGeoModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/client/model/entity/ChordProjectileModel;", "G", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableArrow;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableGeoModel;", "<init>", "()V", "modelPath", "Lnet/minecraft/resources/ResourceLocation;", "getModelPath", "()Lnet/minecraft/resources/ResourceLocation;", "texturePath", "getTexturePath", "animationPath", "getAnimationPath", "uwuModelPath", "", "getUwuModelPath", "()Ljava/lang/Void;", "uwuTexturePath", "getUwuTexturePath", "thebrokenscript-common"})
public final class ChordProjectileModel<G extends UwuableArrow>
extends UwuableGeoModel<G> {
    @NotNull
    private final ResourceLocation modelPath = TBSConstants.id("geo/chord_projectile.geo.json");
    @NotNull
    private final ResourceLocation texturePath = TBSConstants.id("textures/entities/chord_projectile.png");
    @NotNull
    private final ResourceLocation animationPath = TBSConstants.id("animations/chord_projectile.animation.json");
    @Nullable
    private final Void uwuModelPath;
    @Nullable
    private final Void uwuTexturePath;

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

    @Nullable
    public Void getUwuModelPath() {
        return this.uwuModelPath;
    }

    @Nullable
    public Void getUwuTexturePath() {
        return this.uwuTexturePath;
    }
}

