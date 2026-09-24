/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.level.dimension.DimensionType
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.brokencore.impl.mixin.features.faketime;

import net.minecraft.world.level.dimension.DimensionType;
import net.thebrokenscript.brokencore.api.client.level.FakeTimeOfDay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={DimensionType.class})
public class DimensionTypeMixin {
    @Inject(method={"timeOfDay"}, at={@At(value="RETURN")}, cancellable=true)
    public void brokencore$replaceTimeOfDay(long dayTime, CallbackInfoReturnable<Float> cir) {
        if (!FakeTimeOfDay.IN_EFFECT) {
            return;
        }
        cir.setReturnValue((Object)Float.valueOf(FakeTimeOfDay.TIME_OF_DAY));
    }
}

