/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableList$Builder
 *  com.llamalad7.mixinextras.injector.ModifyReturnValue
 *  net.minecraft.client.renderer.RenderType
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 */
package net.thebrokenscript.brokencore.impl.mixin.client.features.layers;

import com.google.common.collect.ImmutableList;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import java.util.Collection;
import java.util.List;
import net.minecraft.client.renderer.RenderType;
import net.thebrokenscript.brokencore.api.client.blocks.BlockRenderLayers;
import net.thebrokenscript.brokencore.api.platform.PlatformRendering;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={RenderType.class})
public class RenderTypeMixin {
    @Unique
    private static ImmutableList<RenderType> bc$chunkLayers = null;

    @ModifyReturnValue(method={"chunkBufferLayers"}, at={@At(value="RETURN")})
    private static List<RenderType> bc$overrideLayers(List<RenderType> base) {
        Collection<RenderType> custom = BlockRenderLayers.layers.values();
        if (bc$chunkLayers == null) {
            if (custom.isEmpty()) {
                return base;
            }
            int i = base.size();
            ImmutableList.Builder builder = ImmutableList.builder().addAll(base);
            for (RenderType layer : custom) {
                PlatformRendering.Companion.setChunkLayerId(layer, i++);
                builder.add((Object)layer);
            }
            bc$chunkLayers = builder.build();
        }
        return bc$chunkLayers;
    }
}

