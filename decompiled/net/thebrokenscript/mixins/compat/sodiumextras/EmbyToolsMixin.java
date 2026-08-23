/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.phys.Vec3
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  toni.sodiumextras.EmbyTools
 */
package net.thebrokenscript.mixins.compat.sodiumextras;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import toni.sodiumextras.EmbyTools;

@Mixin(value={EmbyTools.class})
public class EmbyToolsMixin {
    @Inject(method={"isEntityWithinDistance(Lnet/minecraft/world/entity/Entity;DDDII)Z"}, at={@At(value="HEAD")}, cancellable=true)
    private static void tbs$isEntityWithinDistance(Entity entity, double cameraX, double cameraY, double cameraZ, int maxHeight, int maxDistanceSquare, CallbackInfoReturnable<Boolean> cir) {
        boolean isTBS = BuiltInRegistries.ENTITY_TYPE.getKey((Object)entity.getType()).getNamespace().equals("thebrokenscript");
        if (isTBS) {
            cir.setReturnValue((Object)true);
        }
    }

    @Inject(method={"isEntityWithinDistance(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/phys/Vec3;II)Z"}, at={@At(value="HEAD")}, cancellable=true)
    private static void tbs$isEntityWithinDistance(BlockPos bePos, Vec3 camVec, int maxHeight, int maxDistanceSquare, CallbackInfoReturnable<Boolean> cir) {
        boolean isTBS;
        ResourceLocation type;
        BlockEntity block;
        ClientLevel level = Minecraft.getInstance().level;
        if (level != null && (block = level.getBlockEntity(bePos)) != null && (type = BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey((Object)block.getType())) != null && (isTBS = type.getNamespace().equals("thebrokenscript"))) {
            cir.setReturnValue((Object)true);
        }
    }
}

