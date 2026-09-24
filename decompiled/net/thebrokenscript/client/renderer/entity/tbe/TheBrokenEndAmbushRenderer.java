/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoEntityRenderer
 */
package net.thebrokenscript.client.renderer.entity.tbe;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.client.model.entity.TheBrokenEndAmbushModel;
import net.thebrokenscript.entity.tbe.TheBrokenEndAmbushEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J,\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/client/renderer/entity/tbe/TheBrokenEndAmbushRenderer;", "Lsoftware/bernie/geckolib/renderer/GeoEntityRenderer;", "Lnet/thebrokenscript/entity/tbe/TheBrokenEndAmbushEntity;", "renderManager", "Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;", "<init>", "(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V", "getRenderType", "Lnet/minecraft/client/renderer/RenderType;", "entity", "texture", "Lnet/minecraft/resources/ResourceLocation;", "bufferSource", "Lnet/minecraft/client/renderer/MultiBufferSource;", "partialTick", "", "thebrokenscript-common"})
public final class TheBrokenEndAmbushRenderer
extends GeoEntityRenderer<TheBrokenEndAmbushEntity> {
    public TheBrokenEndAmbushRenderer(@NotNull EntityRendererProvider.Context renderManager) {
        Intrinsics.checkNotNullParameter((Object)renderManager, (String)"renderManager");
        super(renderManager, (GeoModel)new TheBrokenEndAmbushModel());
    }

    @Nullable
    public RenderType getRenderType(@NotNull TheBrokenEndAmbushEntity entity, @NotNull ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        Intrinsics.checkNotNullParameter((Object)texture, (String)"texture");
        return RenderType.entityTranslucent((ResourceLocation)texture);
    }
}

