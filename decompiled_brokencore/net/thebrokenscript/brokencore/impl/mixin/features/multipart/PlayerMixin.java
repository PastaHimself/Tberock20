/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.llamalad7.mixinextras.sugar.ref.LocalRef
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.player.Player
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Slice
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.features.multipart;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.entity.multipart.MultipartEntityPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Player.class})
public class PlayerMixin {
    @Inject(method={"attack"}, slice={@Slice(from=@At(value="INVOKE", target="Lnet/minecraft/world/entity/player/Player;setLastHurtMob(Lnet/minecraft/world/entity/Entity;)V"))}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/player/Player;level()Lnet/minecraft/world/level/Level;", ordinal=0)})
    public void bc$fixMultiparts(Entity target, CallbackInfo ci, @Local(ordinal=1) LocalRef<Entity> entity) {
        Object object = entity.get();
        if (object instanceof MultipartEntityPart) {
            MultipartEntityPart part = (MultipartEntityPart)((Object)object);
            entity.set(part.getParent());
        }
    }
}

