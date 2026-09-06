/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.vivecraft.client_vr.render.helpers.VREffectsHelper
 */
package net.thebrokenscript.brokencore.impl.mixin.compat.vivecraft;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.thebrokenscript.brokencore.impl.client.OverlayLayer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.vivecraft.client_vr.render.helpers.VREffectsHelper;

@Mixin(value={VREffectsHelper.class})
public class VREffectsHelperMixin {
    @Shadow
    @Final
    private static Minecraft MC;

    @Inject(method={"renderFaceOverlay"}, at={@At(value="HEAD")})
    private static void bc$renderOverlayInVR(float partialTick, CallbackInfo ci) {
        GuiGraphics gg = new GuiGraphics(MC, MC.renderBuffers().bufferSource());
        OverlayLayer.INSTANCE.actuallyRender(gg);
    }
}

