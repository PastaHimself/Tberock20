/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.moon;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.boss.integrity.BossGlobals;
import net.thebrokenscript.registry.TBSDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={LivingEntity.class})
public class LivingEntityGravityMixin {
    @Inject(method={"getDefaultGravity"}, at={@At(value="HEAD")}, cancellable=true)
    public void tbs$modifyGravity(CallbackInfoReturnable<Double> cir) {
        Player p;
        Object object = (LivingEntity)this;
        if (object instanceof Player && (p = (Player)object).level().dimension() == TBSDimensions.CORRUPTED_MOON) {
            cir.setReturnValue((Object)0.04);
        }
        if ((object = this) instanceof Player && (p = (Player)object).level().dimension() == TBSDimensions.STAGE3 && BossGlobals.FLIP_GRAVITY) {
            cir.setReturnValue((Object)BossGlobals.INVERSE_GRAVITY_STRENGTH);
        }
    }
}

