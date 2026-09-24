/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  journeymap.client.JourneymapClient
 *  net.minecraft.client.Minecraft
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.compat.journeymap;

import journeymap.client.JourneymapClient;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={JourneymapClient.class})
public class JourneymapClientMixin {
    @Inject(method={"enabled"}, at={@At(value="HEAD")}, cancellable=true)
    private void tbs$begoneJourneyMap(CallbackInfoReturnable<Boolean> cir) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.level != null && mc.level.dimension().location().getNamespace().equals("thebrokenscript") && !mc.level.dimension().location().getPath().equals("nowhere")) {
            cir.setReturnValue((Object)false);
        }
    }
}

