/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.simulated_team.simulated.util.assembly.SimAssemblyContraption
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.brokencore.impl.mixin.compat.simulated;

import dev.simulated_team.simulated.util.assembly.SimAssemblyContraption;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={SimAssemblyContraption.class})
public class SimAssemblyContraptionMixin {
    @Inject(method={"movementAllowed"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$allMovable(BlockState state, Level world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (!PlatformUtil.Companion.isProduction()) {
            cir.setReturnValue((Object)true);
        }
    }
}

