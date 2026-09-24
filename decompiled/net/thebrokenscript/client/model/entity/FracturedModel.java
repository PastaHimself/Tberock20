/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableGeoModel
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.cache.object.GeoBone
 */
package net.thebrokenscript.client.model.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.entity.BaseFracturedEntity;
import net.thebrokenscript.brokencore.api.entity.base.UwuableGeoModel;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/client/model/entity/FracturedModel;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableGeoModel;", "Lnet/thebrokenscript/api/entity/BaseFracturedEntity;", "<init>", "()V", "modelPath", "Lnet/minecraft/resources/ResourceLocation;", "getModelPath", "()Lnet/minecraft/resources/ResourceLocation;", "texturePath", "getTexturePath", "animationPath", "getAnimationPath", "uwuModelPath", "getUwuModelPath", "uwuTexturePath", "getUwuTexturePath", "setCustomAnimations", "", "animatable", "instanceId", "", "animationState", "Lsoftware/bernie/geckolib/animation/AnimationState;", "Companion", "thebrokenscript-common"})
public final class FracturedModel
extends UwuableGeoModel<BaseFracturedEntity> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ResourceLocation modelPath = TBSConstants.id("geo/fractured/fractured.geo.json");
    @NotNull
    private final ResourceLocation texturePath = TBSConstants.id("textures/entities/fractured.png");
    @NotNull
    private final ResourceLocation animationPath = TBSConstants.id("animations/fractured.animation.json");
    @Nullable
    private final ResourceLocation uwuModelPath;
    @Nullable
    private final ResourceLocation uwuTexturePath;
    @NotNull
    private static final List<String> TRACKED_BONES;
    @NotNull
    private static final FracturedModel INSTANCE;

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
    public ResourceLocation getUwuModelPath() {
        return this.uwuModelPath;
    }

    @Nullable
    public ResourceLocation getUwuTexturePath() {
        return this.uwuTexturePath;
    }

    public void setCustomAnimations(@NotNull BaseFracturedEntity animatable, long instanceId, @NotNull AnimationState<BaseFracturedEntity> animationState) {
        Intrinsics.checkNotNullParameter((Object)((Object)animatable), (String)"animatable");
        Intrinsics.checkNotNullParameter(animationState, (String)"animationState");
        super.setCustomAnimations((GeoAnimatable)animatable, instanceId, animationState);
        for (String name : TRACKED_BONES) {
            this.getBone(name).ifPresent(arg_0 -> FracturedModel.setCustomAnimations$lambda$1(FracturedModel::setCustomAnimations$lambda$0, arg_0));
        }
    }

    private static final Unit setCustomAnimations$lambda$0(GeoBone it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        it.getWorldSpaceMatrix();
        return Unit.INSTANCE;
    }

    private static final void setCustomAnimations$lambda$1(Function1 $tmp0, Object p0) {
        $tmp0.invoke(p0);
    }

    static {
        Object[] objectArray = new String[]{"ROCK", "right_l_claw", "left_l_claw", "right_f_tarsus"};
        TRACKED_BONES = CollectionsKt.listOf((Object[])objectArray);
        INSTANCE = new FracturedModel();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/client/model/entity/FracturedModel$Companion;", "", "<init>", "()V", "TRACKED_BONES", "", "", "INSTANCE", "Lnet/thebrokenscript/client/model/entity/FracturedModel;", "getINSTANCE", "()Lnet/thebrokenscript/client/model/entity/FracturedModel;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final FracturedModel getINSTANCE() {
            return INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

