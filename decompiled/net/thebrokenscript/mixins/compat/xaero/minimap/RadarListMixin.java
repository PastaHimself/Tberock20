/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.world.entity.Entity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  xaero.hud.minimap.radar.state.RadarList
 */
package net.thebrokenscript.mixins.compat.xaero.minimap;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xaero.hud.minimap.radar.state.RadarList;

@Mixin(value={RadarList.class})
public class RadarListMixin {
    @Inject(method={"add"}, at={@At(value="HEAD")}, cancellable=true)
    public void tbs$stopTbsEntities(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        boolean isTBS = BuiltInRegistries.ENTITY_TYPE.getKey((Object)entity.getType()).getNamespace().equals("thebrokenscript");
        if (isTBS) {
            cir.cancel();
        }
    }
}

