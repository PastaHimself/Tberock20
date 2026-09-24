/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.caffeinemc.mods.sodium.client.render.SodiumWorldRenderer
 *  net.caffeinemc.mods.sodium.client.render.chunk.ChunkRenderMatrices
 *  net.caffeinemc.mods.sodium.client.render.chunk.RenderSectionManager
 *  net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.resources.ResourceLocation
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.compat.sodium;

import java.util.Map;
import net.caffeinemc.mods.sodium.client.render.SodiumWorldRenderer;
import net.caffeinemc.mods.sodium.client.render.chunk.ChunkRenderMatrices;
import net.caffeinemc.mods.sodium.client.render.chunk.RenderSectionManager;
import net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.blocks.BlockRenderLayers;
import net.thebrokenscript.brokencore.impl.compat.sodium.BCPasses;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={SodiumWorldRenderer.class}, priority=980)
public class SodiumWorldRendererMixin {
    @Shadow
    private RenderSectionManager renderSectionManager;

    @Inject(method={"drawChunkLayer"}, at={@At(value="HEAD")})
    public void bc$injectPasses(RenderType renderLayer, ChunkRenderMatrices matrices, double x, double y, double z, CallbackInfo ci) {
        Map<RenderType, ResourceLocation> layers = BlockRenderLayers.reverseLayers;
        Map<ResourceLocation, TerrainRenderPass> passes = BCPasses.get();
        if (layers.containsKey(renderLayer)) {
            this.renderSectionManager.renderLayer(matrices, passes.get(layers.get(renderLayer)), x, y, z);
        }
    }
}

