/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  dev.ryanhcode.sable.sublevel.render.sodium.SubLevelRenderSectionManager
 *  net.caffeinemc.mods.sodium.client.render.chunk.ChunkRenderMatrices
 *  net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.resources.ResourceLocation
 *  org.joml.Vector3d
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.compat.sable.sodium.sV6;

import com.llamalad7.mixinextras.sugar.Local;
import dev.ryanhcode.sable.sublevel.render.sodium.SubLevelRenderSectionManager;
import java.util.Map;
import net.caffeinemc.mods.sodium.client.render.chunk.ChunkRenderMatrices;
import net.caffeinemc.mods.sodium.client.render.chunk.terrain.TerrainRenderPass;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.blocks.BlockRenderLayers;
import net.thebrokenscript.brokencore.impl.compat.sodium.BCPasses;
import net.thebrokenscript.brokencore.impl.mixin.compat.sable.sodium.sV6.RenderSectionManagerInvoker;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={SubLevelRenderSectionManager.class})
public abstract class SubLevelRenderSectionManagerMixin {
    @Shadow
    @Final
    private Vector3d chunkOffset;

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Ldev/ryanhcode/sable/mixinterface/sublevel_render/sodium/DefaultChunkRendererExtension;sable$setCameraTransform(Lnet/caffeinemc/mods/sodium/client/render/viewport/CameraTransform;)V", ordinal=1, shift=At.Shift.BY, by=-3)})
    public void bc$renderCustomShadersInSublevels(ChunkRenderMatrices originalMatrices, RenderType layer, double camX, double camY, double camZ, CallbackInfo ci, @Local(name={"matrices"}) ChunkRenderMatrices matrices) {
        Map<RenderType, ResourceLocation> layers = BlockRenderLayers.reverseLayers;
        Map<ResourceLocation, TerrainRenderPass> passes = BCPasses.get();
        if (layers.containsKey(layer)) {
            ((RenderSectionManagerInvoker)((Object)this)).bc$invokeRenderLayer(matrices, passes.get(layers.get(layer)), -this.chunkOffset.x, -this.chunkOffset.y, -this.chunkOffset.z);
        }
    }
}

