/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.MobCategory
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.LocalMobCapCalculator
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.spawning;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LocalMobCapCalculator;
import net.thebrokenscript.registry.TBSMobCategories;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={LocalMobCapCalculator.class})
public class MobCapMixin {
    @Inject(method={"canSpawn"}, at={@At(value="HEAD")}, cancellable=true)
    public void tbs$forceSpawn(MobCategory category, ChunkPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (category == TBSMobCategories.MOBS) {
            cir.setReturnValue((Object)true);
        }
    }
}

