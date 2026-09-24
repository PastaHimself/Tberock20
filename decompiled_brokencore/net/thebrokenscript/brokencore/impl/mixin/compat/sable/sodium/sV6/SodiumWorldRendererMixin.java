/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.ryanhcode.sable.sublevel.ClientSubLevel
 *  dev.ryanhcode.sable.sublevel.render.dispatcher.SodiumSubLevelRenderDispatcher
 *  dev.ryanhcode.sable.sublevel.render.dispatcher.SubLevelRenderDispatcher
 *  dev.ryanhcode.sable.sublevel.render.sodium.SodiumSubLevelRenderData
 *  dev.ryanhcode.sable.sublevel.render.sodium.SubLevelRenderSectionManager
 *  it.unimi.dsi.fastutil.objects.Object2ObjectMap
 *  net.caffeinemc.mods.sodium.client.render.SodiumWorldRenderer
 *  net.caffeinemc.mods.sodium.client.render.chunk.ChunkRenderMatrices
 *  net.caffeinemc.mods.sodium.client.render.chunk.RenderSectionManager
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.resources.ResourceLocation
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.compat.sable.sodium.sV6;

import dev.ryanhcode.sable.sublevel.ClientSubLevel;
import dev.ryanhcode.sable.sublevel.render.dispatcher.SodiumSubLevelRenderDispatcher;
import dev.ryanhcode.sable.sublevel.render.dispatcher.SubLevelRenderDispatcher;
import dev.ryanhcode.sable.sublevel.render.sodium.SodiumSubLevelRenderData;
import dev.ryanhcode.sable.sublevel.render.sodium.SubLevelRenderSectionManager;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import java.util.Map;
import net.caffeinemc.mods.sodium.client.render.SodiumWorldRenderer;
import net.caffeinemc.mods.sodium.client.render.chunk.ChunkRenderMatrices;
import net.caffeinemc.mods.sodium.client.render.chunk.RenderSectionManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.blocks.BlockRenderLayers;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={SodiumWorldRenderer.class})
public class SodiumWorldRendererMixin {
    @Shadow
    @Final
    private Object2ObjectMap<ClientSubLevel, RenderSectionManager> sable$subLevelSectionManagers;

    @Inject(method={"drawChunkLayer"}, at={@At(value="TAIL")})
    public void bc$injectPassesForSublevels(RenderType renderLayer, ChunkRenderMatrices matrices, double x, double y, double z, CallbackInfo ci) {
        Map<RenderType, ResourceLocation> layers = BlockRenderLayers.reverseLayers;
        SubLevelRenderDispatcher renderDispatcher = SubLevelRenderDispatcher.get();
        if (!(renderDispatcher instanceof SodiumSubLevelRenderDispatcher)) {
            return;
        }
        if (!layers.containsKey(renderLayer)) {
            return;
        }
        for (Map.Entry entry : this.sable$subLevelSectionManagers.entrySet()) {
            ClientSubLevel subLevel = (ClientSubLevel)entry.getKey();
            RenderSectionManager manager = (RenderSectionManager)entry.getValue();
            ((SodiumSubLevelRenderData)subLevel.getRenderData()).renderAdditional();
            SubLevelRenderSectionManager subLevelManager = (SubLevelRenderSectionManager)manager;
            subLevelManager.apply(matrices, x, y, z);
            subLevelManager.render(matrices, renderLayer, x, y, z);
        }
    }
}

