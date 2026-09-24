/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockBehaviour
 *  net.minecraft.world.level.block.state.BlockState
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.misc;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.registry.TBSDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={BlockBehaviour.class})
public class BlockBehaviourMixin {
    @Inject(method={"onRemove"}, at={@At(value="HEAD")})
    private void MirrorDestroyal(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston, CallbackInfo ci) {
        if (level.dimension().equals(TBSDimensions.LIBRARY) && (double)pos.getY() > 34.0 && (double)pos.getY() < 140.0) {
            level.setBlock(pos.atY(pos.getY() - 68), newState, 3);
            level.setBlock(pos.atY(pos.getY() + 68), newState, 3);
        }
    }

    @Inject(method={"onPlace"}, at={@At(value="HEAD")})
    private void MirrorPlacement(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston, CallbackInfo ci) {
        if (level.dimension().equals(TBSDimensions.LIBRARY) && (double)pos.getY() > 34.0 && (double)pos.getY() < 140.0) {
            level.setBlock(pos.atY(pos.getY() - 68), state, 3);
            level.setBlock(pos.atY(pos.getY() + 68), state, 3);
        }
    }
}

