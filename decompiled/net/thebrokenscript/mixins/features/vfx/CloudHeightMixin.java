/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.DimensionSpecialEffects
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.vfx;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.thebrokenscript.registry.TBSDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={DimensionSpecialEffects.class})
public class CloudHeightMixin {
    @Inject(method={"getCloudHeight"}, at={@At(value="RETURN")}, cancellable=true)
    private void tbs$cloudHeight(CallbackInfoReturnable<Float> cir) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level != null && mc.level.dimension() == TBSDimensions.CONCRETE) {
            cir.setReturnValue((Object)Float.valueOf(292.0f));
        }
    }
}

