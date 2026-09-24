/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.ShaderInstance
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.brokencore.impl.mixin.compat.iris;

import net.minecraft.client.renderer.ShaderInstance;
import net.thebrokenscript.brokencore.api.platform.PlatformRendering;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ShaderInstance.class})
public class ShaderInstanceMixin {
    @Inject(method={"iris$shouldSkipThis"}, at={@At(value="RETURN")}, cancellable=true)
    public void bc$forceNoSkip(CallbackInfoReturnable<Boolean> cir) {
        if (PlatformRendering.Companion.isCustomShader((ShaderInstance)this)) {
            cir.setReturnValue((Object)false);
        }
    }
}

