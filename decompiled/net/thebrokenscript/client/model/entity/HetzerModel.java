/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.resources.ResourceLocation
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableGeoModel
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.model.entity;

import kotlin.Metadata;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.entity.base.UwuableGeoModel;
import net.thebrokenscript.entity.players.HetzerEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/client/model/entity/HetzerModel;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableGeoModel;", "Lnet/thebrokenscript/entity/players/HetzerEntity;", "<init>", "()V", "modelPath", "Lnet/minecraft/resources/ResourceLocation;", "getModelPath", "()Lnet/minecraft/resources/ResourceLocation;", "texturePath", "getTexturePath", "animationPath", "getAnimationPath", "uwuModelPath", "getUwuModelPath", "uwuTexturePath", "getUwuTexturePath", "thebrokenscript-common"})
public final class HetzerModel
extends UwuableGeoModel<HetzerEntity> {
    @NotNull
    private final ResourceLocation modelPath = TBSConstants.id("geo/hetzerfixed.geo.json");
    @NotNull
    private final ResourceLocation texturePath = TBSConstants.id("textures/entities/hetzerfixed.png");
    @NotNull
    private final ResourceLocation animationPath = TBSConstants.id("animations/hetzerfixed.animation.json");
    @NotNull
    private final ResourceLocation uwuModelPath = TBSConstants.id("geo/hetzerfixed_uwu.geo.json");
    @NotNull
    private final ResourceLocation uwuTexturePath = TBSConstants.id("textures/entities/hetzerfixed_uwu.png");

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
}

