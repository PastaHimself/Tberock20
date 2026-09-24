/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.item.ClampedItemPropertyFunction
 *  net.minecraft.client.renderer.item.ItemProperties
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.Item
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package net.thebrokenscript.brokencore.impl.mixin.features.registry;

import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={ItemProperties.class})
public interface ItemPropertiesAccessor {
    @Invoker(value="register")
    public static void register(Item item2, ResourceLocation name, ClampedItemPropertyFunction property) {
        throw new AssertionError((Object)"Implemented by mixin");
    }
}

