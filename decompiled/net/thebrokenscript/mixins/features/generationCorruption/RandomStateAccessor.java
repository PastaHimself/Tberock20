/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.levelgen.NoiseRouter
 *  net.minecraft.world.level.levelgen.RandomState
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package net.thebrokenscript.mixins.features.generationCorruption;

import net.minecraft.world.level.levelgen.NoiseRouter;
import net.minecraft.world.level.levelgen.RandomState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={RandomState.class})
public interface RandomStateAccessor {
    @Mutable
    @Accessor(value="router")
    public void setRouter(NoiseRouter var1);
}

