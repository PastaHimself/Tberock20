/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.model.HumanoidModel
 *  net.minecraft.client.model.geom.ModelLayers
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.HumanoidMobRenderer
 *  net.minecraft.client.renderer.entity.RenderLayerParent
 *  net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer
 *  net.minecraft.client.renderer.entity.layers.RenderLayer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Mob
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.renderer;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 \u0010*\b\b\u0000\u0010\u0001*\u00020\u00022\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003:\u0001\u0010B#\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/client/renderer/BasicTexturedRenderer;", "T", "Lnet/minecraft/world/entity/Mob;", "Lnet/minecraft/client/renderer/entity/HumanoidMobRenderer;", "Lnet/minecraft/client/model/HumanoidModel;", "context", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "location", "Lnet/minecraft/resources/ResourceLocation;", "offset", "", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;Lnet/minecraft/resources/ResourceLocation;F)V", "getTextureLocation", "entity", "(Lnet/minecraft/world/entity/Mob;)Lnet/minecraft/resources/ResourceLocation;", "Companion", "brokencore-common"})
public final class BasicTexturedRenderer<T extends Mob>
extends HumanoidMobRenderer<T, HumanoidModel<T>> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ResourceLocation location;

    private BasicTexturedRenderer(EntityRendererProvider.Context context, ResourceLocation location, float offset) {
        super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), offset);
        this.location = location;
        this.addLayer((RenderLayer)new HumanoidArmorLayer((RenderLayerParent)this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    /* synthetic */ BasicTexturedRenderer(EntityRendererProvider.Context context, ResourceLocation resourceLocation, float f, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            f = 0.5f;
        }
        this(context, resourceLocation, f);
    }

    @NotNull
    public ResourceLocation getTextureLocation(@NotNull T entity) {
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        return this.location;
    }

    public /* synthetic */ BasicTexturedRenderer(EntityRendererProvider.Context context, ResourceLocation location, float offset, DefaultConstructorMarker $constructor_marker) {
        this(context, location, offset);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0005\"\b\b\u0001\u0010\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/client/renderer/BasicTexturedRenderer$Companion;", "", "<init>", "()V", "textured", "Lkotlin/Function1;", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "Lnet/minecraft/client/renderer/entity/EntityRenderer;", "T", "Lnet/minecraft/world/entity/Mob;", "location", "Lnet/minecraft/resources/ResourceLocation;", "offset", "", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final <T extends Mob> Function1<EntityRendererProvider.Context, EntityRenderer<T>> textured(@NotNull ResourceLocation location, float offset) {
            Intrinsics.checkNotNullParameter((Object)location, (String)"location");
            return arg_0 -> Companion.textured$lambda$0(location, offset, arg_0);
        }

        public static /* synthetic */ Function1 textured$default(Companion companion, ResourceLocation resourceLocation, float f, int n, Object object) {
            if ((n & 2) != 0) {
                f = 0.5f;
            }
            return companion.textured(resourceLocation, f);
        }

        private static final BasicTexturedRenderer textured$lambda$0(ResourceLocation $location, float $offset, EntityRendererProvider.Context cx) {
            Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
            return new BasicTexturedRenderer(cx, $location, $offset, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

