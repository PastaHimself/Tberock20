/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.farcr.nomansland.client.ambience.FogModifierHandler
 *  net.neoforged.neoforge.client.event.ViewportEvent$RenderFog
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.neoforge.mixin.compat.nomansland;

import com.farcr.nomansland.client.ambience.FogModifierHandler;
import net.neoforged.neoforge.client.event.ViewportEvent;
import net.thebrokenscript.util.MoonGlitchState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={FogModifierHandler.class})
public class FogModifierHandlerMixin {
    @Inject(method={"renderFog"}, at={@At(value="TAIL")})
    private static void tbs$moonGlitch(ViewportEvent.RenderFog event, CallbackInfo ci) {
        float factor = MoonGlitchState.timer + 1.0f;
        if (factor != 1.0f) {
            event.setNearPlaneDistance(event.getNearPlaneDistance() / factor);
            event.setFarPlaneDistance(event.getFarPlaneDistance() / factor);
        }
    }
}

