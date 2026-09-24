/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.ItemBlockRenderTypes
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.block.state.BlockState
 *  net.neoforged.neoforge.client.ChunkRenderTypeSet
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.brokencore.neoforge.mixin;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.ChunkRenderTypeSet;
import net.thebrokenscript.brokencore.neoforge.BCChunkRenderTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ItemBlockRenderTypes.class})
public class ItemBlockRenderTypesMixin {
    @Inject(method={"getRenderLayers"}, at={@At(value="HEAD")}, cancellable=true)
    private static void tbs$forceCustomRender(BlockState state, CallbackInfoReturnable<ChunkRenderTypeSet> cir) {
        ResourceLocation id;
        ChunkRenderTypeSet rt;
        ResourceKey key = state.getBlockHolder().getKey();
        if (key != null && (rt = BCChunkRenderTypes.get(id = key.location())) != null) {
            cir.setReturnValue((Object)rt);
        }
    }
}

