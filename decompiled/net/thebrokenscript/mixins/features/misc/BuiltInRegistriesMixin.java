/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.ItemNameBlockItem
 *  net.minecraft.world.level.block.Blocks
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.misc;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={BuiltInRegistries.class}, priority=980)
public class BuiltInRegistriesMixin {
    @Inject(method={"bootStrap"}, at={@At(value="INVOKE", target="Lnet/minecraft/core/registries/BuiltInRegistries;freeze()V")})
    private static void beforeFreeze(CallbackInfo ci) {
        Registry.register((Registry)BuiltInRegistries.ITEM, (ResourceLocation)ResourceLocation.withDefaultNamespace((String)"fire"), (Object)new ItemNameBlockItem(Blocks.FIRE, new Item.Properties()));
    }
}

