/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.MobCategory
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.spawning;

import net.minecraft.world.entity.MobCategory;
import net.thebrokenscript.registry.TBSMobCategories;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets={"net.minecraft.world.level.LocalMobCapCalculator$MobCounts"})
public class MobCapCountsMixin {
    @Inject(method={"canSpawn"}, at={@At(value="HEAD")}, cancellable=true)
    public void tbs$forceSpawn(MobCategory category, CallbackInfoReturnable<Boolean> cir) {
        if (category == TBSMobCategories.MOBS) {
            cir.setReturnValue((Object)true);
        }
    }
}

