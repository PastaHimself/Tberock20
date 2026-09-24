/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.resources.ResourceLocation
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableGeoModel
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.entity.integrity.phase2;

import kotlin.Metadata;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.entity.base.UwuableGeoModel;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.entity.integrity.phase2.IntegrityPhase2Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/entity/integrity/phase2/IntegrityPhase2Model;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableGeoModel;", "Lnet/thebrokenscript/entity/integrity/phase2/IntegrityPhase2Entity;", "<init>", "()V", "modelPath", "Lnet/minecraft/resources/ResourceLocation;", "getModelPath", "()Lnet/minecraft/resources/ResourceLocation;", "texturePath", "getTexturePath", "animationPath", "getAnimationPath", "uwuModelPath", "", "getUwuModelPath", "()Ljava/lang/Void;", "uwuTexturePath", "getUwuTexturePath", "thebrokenscript-common"})
public final class IntegrityPhase2Model
extends UwuableGeoModel<IntegrityPhase2Entity> {
    @NotNull
    private final ResourceLocation modelPath = TBSConstants.id("geo/integrity_phase2.geo.json");
    @NotNull
    private final ResourceLocation texturePath = TBSConstants.id("textures/entities/integrity_phase2.png");
    @NotNull
    private final ResourceLocation animationPath = TBSConstants.id("animations/integrity_phase2.animation.json");
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

