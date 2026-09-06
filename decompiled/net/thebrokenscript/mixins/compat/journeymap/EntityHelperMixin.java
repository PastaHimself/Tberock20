/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  journeymap.client.model.entity.EntityHelper
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package net.thebrokenscript.mixins.compat.journeymap;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import journeymap.client.model.entity.EntityHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={EntityHelper.class})
public class EntityHelperMixin {
    @WrapOperation(method={"getEntitiesNearby"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;isAlive()Z")})
    private static boolean tbs$hideEntitiesJM(Entity instance, Operation<Boolean> original) {
        ResourceLocation key = BuiltInRegistries.ENTITY_TYPE.getKey((Object)instance.getType());
        boolean notOurs = !key.getNamespace().equals("thebrokenscript");
        return notOurs && (Boolean)original.call(new Object[]{instance}) != false;
    }
}

