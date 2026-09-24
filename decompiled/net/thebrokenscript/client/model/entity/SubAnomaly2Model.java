/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableGeoModel
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.client.model.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.entity.base.UwuableGeoModel;
import net.thebrokenscript.entity.anomaly.sa2.SubAnomaly2Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/client/model/entity/SubAnomaly2Model;", "T", "Lnet/thebrokenscript/entity/anomaly/sa2/SubAnomaly2Entity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableGeoModel;", "<init>", "()V", "modelPath", "Lnet/minecraft/resources/ResourceLocation;", "getModelPath", "()Lnet/minecraft/resources/ResourceLocation;", "texturePath", "getTexturePath", "animationPath", "getAnimationPath", "uwuModelPath", "", "getUwuModelPath", "()Ljava/lang/Void;", "uwuTexturePath", "getUwuTexturePath", "getTextureResource", "animatable", "(Lnet/thebrokenscript/entity/anomaly/sa2/SubAnomaly2Entity;)Lnet/minecraft/resources/ResourceLocation;", "thebrokenscript-common"})
public final class SubAnomaly2Model<T extends SubAnomaly2Entity>
extends UwuableGeoModel<T> {
    @NotNull
    private final ResourceLocation modelPath = TBSConstants.id("geo/sub_anom_2.geo.json");
    @NotNull
    private final ResourceLocation texturePath = TBSConstants.id("textures/entities/sa2_black_red.png");
    @NotNull
    private final ResourceLocation animationPath = TBSConstants.id("animations/sub_anom_2.animation.json");
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

    @NotNull
    public ResourceLocation getTextureResource(@NotNull T animatable) {
        String string;
        Integer n;
        Intrinsics.checkNotNullParameter(animatable, (String)"animatable");
        Integer n2 = n = (Integer)((Entity)animatable).getEntityData().get(SubAnomaly2Entity.Companion.getVARIANT());
        int n3 = 1;
        if (n2 != null && n2 == n3) {
            string = "textures/entities/sa2_notexture_black.png";
        } else {
            Integer n4 = n;
            n3 = 2;
            if (n4 != null && n4 == n3) {
                string = "textures/entities/sa2_black_red_black.png";
            } else {
                Integer n5 = n;
                n3 = 3;
                if (n5 != null && n5 == n3) {
                    string = "textures/entities/sa2_red_black.png";
                } else {
                    Integer n6 = n;
                    n3 = 4;
                    if (n6 != null && n6 == n3) {
                        string = "textures/entities/sa2_black_red.png";
                    } else {
                        Integer n7 = n;
                        n3 = 5;
                        if (n7 != null && n7 == n3) {
                            string = "textures/entities/sa2_pinkred.png";
                        } else {
                            Integer n8 = n;
                            n3 = 6;
                            if (n8 != null && n8 == n3) {
                                string = "textures/entities/sa2_blue_red.png";
                            } else {
                                Integer n9 = n;
                                n3 = 7;
                                string = n9 != null && n9 == n3 ? "textures/entities/sa2_rainbow.png" : "textures/entities/sa2_notexture_black.png";
                            }
                        }
                    }
                }
            }
        }
        String texture = string;
        return TBSConstants.id(texture);
    }
}

