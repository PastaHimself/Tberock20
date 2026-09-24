/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableGeoModel
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.client.model.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.entity.base.UwuableGeoModel;
import net.thebrokenscript.entity.integrity.IntegrityCuriousEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\f\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/client/model/entity/IntegrityCuriousModel;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableGeoModel;", "Lnet/thebrokenscript/entity/integrity/IntegrityCuriousEntity;", "<init>", "()V", "modelPath", "Lnet/minecraft/resources/ResourceLocation;", "getModelPath", "()Lnet/minecraft/resources/ResourceLocation;", "texturePath", "", "getTexturePath", "()Ljava/lang/Void;", "animationPath", "getAnimationPath", "uwuModelPath", "getUwuModelPath", "uwuTexturePath", "getUwuTexturePath", "getTextureResource", "animatable", "Companion", "thebrokenscript-common"})
public final class IntegrityCuriousModel
extends UwuableGeoModel<IntegrityCuriousEntity> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ResourceLocation modelPath = TBSConstants.id("geo/integrity_curious.geo.json");
    @Nullable
    private final Void texturePath;
    @NotNull
    private final ResourceLocation animationPath = TBSConstants.id("animations/integrity_curious.animation.json");
    @Nullable
    private final Void uwuModelPath;
    @Nullable
    private final Void uwuTexturePath;
    private static final int FRAME_COUNT = 12;

    @NotNull
    public ResourceLocation getModelPath() {
        return this.modelPath;
    }

    @Nullable
    public Void getTexturePath() {
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

    @NotNull
    public ResourceLocation getTextureResource(@NotNull IntegrityCuriousEntity animatable) {
        Intrinsics.checkNotNullParameter((Object)((Object)animatable), (String)"animatable");
        return IntegrityCuriousModel.Companion.textureFrame(IntegrityCuriousModel.Companion.frameFor(animatable.tickCount));
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/client/model/entity/IntegrityCuriousModel$Companion;", "", "<init>", "()V", "FRAME_COUNT", "", "frameFor", "tickCount", "textureFrame", "Lnet/minecraft/resources/ResourceLocation;", "frame", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        private final int frameFor(int tickCount) {
            return tickCount % 12;
        }

        private final ResourceLocation textureFrame(int frame) {
            return TBSConstants.id("textures/entities/integrityghost_redeyes" + frame + ".png");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

