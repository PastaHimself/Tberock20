/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockBehaviour$BlockStateBase
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.misc;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BlockBehaviour.BlockStateBase.class})
abstract class BlockStateBaseMixin {
    BlockStateBaseMixin() {
    }

    @Inject(method={"isSuffocating"}, at={@At(value="HEAD")}, cancellable=true)
    private void onIsSuffocating(BlockGetter level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if ((level.getBlockState(pos).is(Blocks.BARRIER) || level.getBlockState(pos).is(TBSBlocks.FLESH)) && level instanceof Level && ((Level)level).dimension().equals(TBSDimensions.PROTECTED_VOID)) {
            cir.setReturnValue((Object)false);
        }
    }
}

