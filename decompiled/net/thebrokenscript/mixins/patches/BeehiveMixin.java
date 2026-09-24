/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.entity.BeehiveBlockEntity
 *  net.minecraft.world.level.block.entity.BeehiveBlockEntity$BeeReleaseStatus
 *  net.minecraft.world.level.block.entity.BeehiveBlockEntity$Occupant
 *  net.minecraft.world.level.block.state.BlockState
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.patches;

import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.thebrokenscript.config.TBSConfigs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BeehiveBlockEntity.class})
public class BeehiveMixin {
    @Inject(method={"releaseOccupant"}, at={@At(value="HEAD")}, cancellable=true)
    private static void releaseOccupant(Level level, BlockPos pos, BlockState state, BeehiveBlockEntity.Occupant occupant, List<Entity> storedInHives, BeehiveBlockEntity.BeeReleaseStatus releaseStatus, BlockPos storedFlowerPos, CallbackInfoReturnable<Boolean> cir) {
        if (TBSConfigs.INSTANCE.getServer().getDisableNewMobSpawning()) {
            cir.cancel();
        }
    }
}

