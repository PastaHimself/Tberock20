/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageSources
 *  net.minecraft.world.damagesource.DamageType
 *  net.minecraft.world.entity.Entity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package net.thebrokenscript.brokencore.impl.mixin.features.damage;

import javax.annotation.Nullable;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={DamageSources.class})
public interface DamageSourcesAccessor {
    @Invoker(value="source")
    public DamageSource bc$sourceWithCausing(ResourceKey<DamageType> var1, @Nullable Entity var2);

    @Invoker(value="source")
    public DamageSource bc$sourceWithCausingDirect(ResourceKey<DamageType> var1, @Nullable Entity var2, @Nullable Entity var3);
}

