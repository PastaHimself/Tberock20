/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.BedBlock
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.HorizontalDirectionalBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BedPart
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.phys.BlockHitResult
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.world;

import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.thebrokenscript.registry.TBSDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BedBlock.class})
public class BedBlockMixin {
    @Unique
    private final List<ResourceKey<Level>> tbs$dimensionKeys = List.of(TBSDimensions.LIBRARY, TBSDimensions.NOWHERE, TBSDimensions.LIMBO);

    @Inject(method={"useWithoutItem"}, at={@At(value="HEAD")}, cancellable=true)
    private void tbs$removeBed(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult, CallbackInfoReturnable<InteractionResult> cir) {
        if (this.tbs$dimensionKeys.contains(level.dimension())) {
            Direction direction = (Direction)state.getValue((Property)HorizontalDirectionalBlock.FACING);
            BedPart part = (BedPart)state.getValue((Property)BedBlock.PART);
            BlockPos blockpos = part == BedPart.FOOT ? pos.relative(direction) : pos.relative(direction.getOpposite());
            BlockState otherHalfState = level.getBlockState(blockpos);
            level.setBlock(pos, Blocks.AIR.defaultBlockState(), 50);
            if (otherHalfState.getBlock() instanceof BedBlock) {
                level.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 50);
            }
            cir.setReturnValue((Object)InteractionResult.SUCCESS);
            cir.cancel();
        }
    }
}

