/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.FlowingFluid
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.blocks;

import kotlin.Metadata;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/blocks/FluidControls;", "", "canFlow", "", "level", "Lnet/minecraft/world/level/BlockGetter;", "fluid", "Lnet/minecraft/world/level/material/FlowingFluid;", "direction", "Lnet/minecraft/core/Direction;", "targetPos", "Lnet/minecraft/core/BlockPos;", "targetState", "Lnet/minecraft/world/level/block/state/BlockState;", "brokencore-common"})
public interface FluidControls {
    public boolean canFlow(@NotNull BlockGetter var1, @NotNull FlowingFluid var2, @NotNull Direction var3, @NotNull BlockPos var4, @NotNull BlockState var5);
}

