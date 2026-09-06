/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.model.PlayerModel
 *  net.minecraft.client.model.geom.ModelLayers
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.world.entity.LivingEntity
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 */
package net.thebrokenscript.client.renderer.entity.entnull;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.LivingEntity;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.client.renderer.entity.entnull.NullRenderer;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a;\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0001\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0086\b\u00a8\u0006\n"}, d2={"createNullRenderer", "Lkotlin/Function1;", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "Lnet/thebrokenscript/client/renderer/entity/entnull/NullRenderer;", "T", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "texturePath", "", "shadowRadius", "", "thebrokenscript-common"})
public final class NullRendererKt {
    public static final /* synthetic */ <T extends BaseMonster> Function1<EntityRendererProvider.Context, NullRenderer<T>> createNullRenderer(String texturePath, float shadowRadius) {
        Intrinsics.checkNotNullParameter((Object)texturePath, (String)"texturePath");
        boolean $i$f$createNullRenderer = false;
        Intrinsics.needClassReification();
        return new Function1<EntityRendererProvider.Context, NullRenderer<T>>(shadowRadius, texturePath){
            final /* synthetic */ float $shadowRadius;
            final /* synthetic */ String $texturePath;
            {
                this.$shadowRadius = $shadowRadius;
                this.$texturePath = $texturePath;
            }

            public final NullRenderer<T> invoke(EntityRendererProvider.Context context) {
                Intrinsics.checkNotNullParameter((Object)context, (String)"context");
                ModelPart modelPart = context.bakeLayer(ModelLayers.PLAYER);
                Intrinsics.needClassReification();
                PlayerModel<T> model2 = new PlayerModel<T>(modelPart){

                    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
                        Intrinsics.checkNotNullParameter(entity, (String)"entity");
                        boolean swimming = ((LivingEntity)entity).isVisuallySwimming();
                        super.setupAnim((LivingEntity)entity, swimming ? ((float)((BaseMonster)entity).tickCount + ageInTicks) % 26.0f : limbSwing, swimming ? 1.0f : limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                    }
                };
                return new NullRenderer<T>(context, (PlayerModel)model2, this.$shadowRadius, this.$texturePath);
            }
        };
    }

    public static /* synthetic */ Function1 createNullRenderer$default(String texturePath, float shadowRadius, int n, Object object) {
        if ((n & 1) != 0) {
            texturePath = "textures/entities/null.png";
        }
        if ((n & 2) != 0) {
            shadowRadius = 0.5f;
        }
        Intrinsics.checkNotNullParameter((Object)texturePath, (String)"texturePath");
        boolean $i$f$createNullRenderer = false;
        Intrinsics.needClassReification();
        return new /* invalid duplicate definition of identical inner class */;
    }
}

