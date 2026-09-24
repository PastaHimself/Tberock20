/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.DimensionSpecialEffects
 *  net.minecraft.world.level.dimension.DimensionType
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.vfx;

import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.world.level.dimension.DimensionType;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.registry.TBSDimensionFX;
import net.thebrokenscript.registry.TBSDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={DimensionSpecialEffects.class})
public class DimensionSpecialEffectsMixin {
    @Inject(method={"forType"}, at={@At(value="RETURN")}, cancellable=true)
    private static void forType(DimensionType dimensionType, CallbackInfoReturnable<DimensionSpecialEffects> cir) {
        if (dimensionType.effectsLocation().equals((Object)TBSDimensions.CORRUPTED_MOON.location())) {
            DimensionSpecialEffects fx;
            DimensionSpecialEffects dimensionSpecialEffects = fx = TBSConfigs.INSTANCE.getClient().getShaderBasedMoon() ? TBSDimensionFX.getShaderMoonFX() : TBSDimensionFX.getVanillaMoonFX();
            if (fx != null) {
                cir.setReturnValue((Object)fx);
            }
        }
    }
}

