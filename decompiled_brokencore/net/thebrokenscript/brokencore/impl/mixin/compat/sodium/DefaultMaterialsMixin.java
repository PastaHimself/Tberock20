/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.caffeinemc.mods.sodium.client.render.chunk.terrain.material.DefaultMaterials
 *  net.caffeinemc.mods.sodium.client.render.chunk.terrain.material.Material
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.resources.ResourceLocation
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.brokencore.impl.mixin.compat.sodium;

import java.util.Map;
import net.caffeinemc.mods.sodium.client.render.chunk.terrain.material.DefaultMaterials;
import net.caffeinemc.mods.sodium.client.render.chunk.terrain.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.blocks.BlockRenderLayers;
import net.thebrokenscript.brokencore.impl.compat.sodium.BCMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={DefaultMaterials.class})
public class DefaultMaterialsMixin {
    @Inject(method={"forRenderLayer"}, at={@At(value="HEAD")}, cancellable=true)
    private static void bc$injectRenderLayer(RenderType layer, CallbackInfoReturnable<Material> cir) {
        Material mat;
        Map<ResourceLocation, Material> mats = BCMaterials.get();
        Map<RenderType, ResourceLocation> layers = BlockRenderLayers.reverseLayers;
        if (layers.containsKey(layer) && (mat = mats.get(layers.get(layer))) != null) {
            cir.setReturnValue((Object)mat);
        }
    }
}

