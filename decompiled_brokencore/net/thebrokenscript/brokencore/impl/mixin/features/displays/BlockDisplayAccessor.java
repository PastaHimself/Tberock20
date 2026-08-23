/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.Display$BlockDisplay
 *  net.minecraft.world.level.block.state.BlockState
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package net.thebrokenscript.brokencore.impl.mixin.features.displays;

import net.minecraft.world.entity.Display;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={Display.BlockDisplay.class})
public interface BlockDisplayAccessor {
    @Invoker(value="getBlockState")
    public BlockState bc$getBlockState();

    @Invoker(value="setBlockState")
    public void bc$setBlockState(BlockState var1);
}

