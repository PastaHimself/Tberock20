/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  foundry.veil.forge.impl.ForgeRenderTypeStageHandler
 *  net.minecraft.client.renderer.RenderType
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.neoforge.mixin.compat.veil;

import foundry.veil.forge.impl.ForgeRenderTypeStageHandler;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.renderer.RenderType;
import net.thebrokenscript.brokencore.api.client.blocks.BlockRenderLayers;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ForgeRenderTypeStageHandler.class})
public class ForgeRenderTypeStageHandlerMixin {
    @Shadow
    private static Set<RenderType> CUSTOM_BLOCK_LAYERS;

    @Inject(method={"setBlockLayers"}, at={@At(value="TAIL")})
    private static void bc$addRenderTypes(Set<RenderType> blockLayers, CallbackInfo ci) {
        BrokenCore.LOGGER.info("Adding BrokenCore block render layers to Veil...");
        HashSet<RenderType> all = new HashSet<RenderType>(CUSTOM_BLOCK_LAYERS);
        all.addAll(BlockRenderLayers.layers.values());
        CUSTOM_BLOCK_LAYERS = Set.copyOf(all);
    }
}

