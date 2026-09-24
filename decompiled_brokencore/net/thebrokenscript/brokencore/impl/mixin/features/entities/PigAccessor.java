/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.ItemBasedSteering
 *  net.minecraft.world.entity.animal.Pig
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package net.thebrokenscript.brokencore.impl.mixin.features.entities;

import net.minecraft.world.entity.ItemBasedSteering;
import net.minecraft.world.entity.animal.Pig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={Pig.class})
public interface PigAccessor {
    @Accessor(value="steering")
    public ItemBasedSteering bc$getSteering();
}

