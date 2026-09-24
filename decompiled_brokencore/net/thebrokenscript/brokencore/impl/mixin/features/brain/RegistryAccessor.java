/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.MappedRegistry
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package net.thebrokenscript.brokencore.impl.mixin.features.brain;

import net.minecraft.core.MappedRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={MappedRegistry.class})
public interface RegistryAccessor {
    @Accessor(value="frozen")
    public boolean bc$isFrozen();
}

