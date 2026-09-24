/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bawnorton.mixinsquared.TargetHandler
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.irisshaders.iris.pipeline.WorldRenderingPhase
 *  net.irisshaders.iris.pipeline.WorldRenderingPipeline
 *  net.minecraft.client.renderer.LevelRenderer
 *  net.minecraft.client.renderer.RenderType
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package net.thebrokenscript.brokencore.impl.mixin.compat.iris;

import com.bawnorton.mixinsquared.TargetHandler;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.irisshaders.iris.pipeline.WorldRenderingPhase;
import net.irisshaders.iris.pipeline.WorldRenderingPipeline;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.thebrokenscript.brokencore.api.client.blocks.BlockRenderLayers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={LevelRenderer.class}, priority=1500)
public class IrisLevelRendererMixinMixin {
    @TargetHandler(mixin="net.irisshaders.iris.mixin.MixinLevelRenderer", name="iris$beginTerrainLayer")
    @WrapOperation(method={"@MixinSquared:Handler"}, at={@At(value="INVOKE", target="Lnet/irisshaders/iris/pipeline/WorldRenderingPhase;fromTerrainRenderType(Lnet/minecraft/client/renderer/RenderType;)Lnet/irisshaders/iris/pipeline/WorldRenderingPhase;")})
    public WorldRenderingPhase bc$stopIrisBeingAnnoying(RenderType renderType, Operation<WorldRenderingPhase> original) {
        return BlockRenderLayers.layers.containsValue(renderType) ? null : (WorldRenderingPhase)original.call(new Object[]{renderType});
    }

    @TargetHandler(mixin="net.irisshaders.iris.mixin.MixinLevelRenderer", name="iris$beginTerrainLayer")
    @WrapOperation(method={"@MixinSquared:Handler"}, at={@At(value="INVOKE", target="Lnet/irisshaders/iris/pipeline/WorldRenderingPipeline;setPhase(Lnet/irisshaders/iris/pipeline/WorldRenderingPhase;)V")})
    public void bc$stopIrisBeingAnnoyingEnd(WorldRenderingPipeline instance, WorldRenderingPhase worldRenderingPhase, Operation<Void> original) {
        if (worldRenderingPhase != null) {
            original.call(new Object[]{instance, worldRenderingPhase});
        }
    }
}

