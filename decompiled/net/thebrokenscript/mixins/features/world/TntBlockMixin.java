/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.TntBlock
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.world;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TntBlock;
import net.thebrokenscript.registry.TBSDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={TntBlock.class})
public class TntBlockMixin {
    @Inject(method={"explode(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private static void onExplodeCancel(Level level, BlockPos pos, CallbackInfo ci) {
        if (level.dimension() == TBSDimensions.LIBRARY) {
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            ci.cancel();
        }
    }
}

