/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.core.Holder
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.blocks;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.blocks.BlockRenderLayerBuilder;
import net.thebrokenscript.brokencore.api.client.blocks.BlockRenderTypes;
import net.thebrokenscript.brokencore.api.client.blocks.uniforms.CustomUniformFactory;
import net.thebrokenscript.brokencore.api.platform.PlatformRendering;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\f\u001a\u00020\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\u0002\b\u0011R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/client/blocks/BlockRenderLayers;", "", "<init>", "()V", "layers", "", "Lnet/minecraft/resources/ResourceLocation;", "Lnet/minecraft/client/renderer/RenderType;", "reverseLayers", "extraUniforms", "", "Lnet/thebrokenscript/brokencore/api/client/blocks/uniforms/CustomUniformFactory;", "register", "", "cb", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/client/blocks/BlockRenderLayerBuilder;", "Lkotlin/ExtensionFunctionType;", "brokencore-common"})
public final class BlockRenderLayers {
    @NotNull
    public static final BlockRenderLayers INSTANCE = new BlockRenderLayers();
    @JvmField
    @NotNull
    public static final Map<ResourceLocation, RenderType> layers = new LinkedHashMap();
    @JvmField
    @NotNull
    public static final Map<RenderType, ResourceLocation> reverseLayers = new LinkedHashMap();
    @JvmField
    @NotNull
    public static final Map<ResourceLocation, List<CustomUniformFactory>> extraUniforms = new LinkedHashMap();

    private BlockRenderLayers() {
    }

    public final void register(@NotNull Function1<? super BlockRenderLayerBuilder, Unit> cb) {
        Intrinsics.checkNotNullParameter(cb, (String)"cb");
        Object object = new BlockRenderLayerBuilder();
        cb.invoke(object);
        BlockRenderLayerBuilder layer = ((BlockRenderLayerBuilder)object).build();
        RenderType renderType = layer.getRenderType();
        Intrinsics.checkNotNull((Object)renderType);
        PlatformRendering.Companion.registerChunkRenderType(renderType);
        object = layers;
        ResourceLocation resourceLocation = layer.getId();
        Intrinsics.checkNotNull((Object)resourceLocation);
        ResourceLocation resourceLocation2 = resourceLocation;
        RenderType renderType2 = layer.getRenderType();
        Intrinsics.checkNotNull((Object)renderType2);
        Object object2 = renderType2;
        object.put(resourceLocation2, object2);
        object = reverseLayers;
        RenderType renderType3 = layer.getRenderType();
        Intrinsics.checkNotNull((Object)renderType3);
        RenderType renderType4 = renderType3;
        ResourceLocation resourceLocation3 = layer.getId();
        Intrinsics.checkNotNull((Object)resourceLocation3);
        object2 = resourceLocation3;
        object.put((RenderType)renderType4, (ResourceLocation)object2);
        object = extraUniforms;
        ResourceLocation resourceLocation4 = layer.getId();
        Intrinsics.checkNotNull((Object)resourceLocation4);
        ResourceLocation resourceLocation5 = resourceLocation4;
        object2 = layer.getUniforms().build();
        object.put((RenderType)resourceLocation5, (ResourceLocation)object2);
        for (Holder holder : layer.getBlocks()) {
            RenderType renderType5 = layer.getRenderType();
            Intrinsics.checkNotNull((Object)renderType5);
            BlockRenderTypes.INSTANCE.register(holder, renderType5);
        }
    }
}

