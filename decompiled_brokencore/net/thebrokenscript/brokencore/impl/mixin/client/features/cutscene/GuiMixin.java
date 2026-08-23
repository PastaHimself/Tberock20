/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.DeltaTracker
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiGraphics
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.brokencore.impl.mixin.client.features.cutscene;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.thebrokenscript.brokencore.api.mixinterfaces.CameraExt;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Gui.class})
public class GuiMixin {
    @Unique
    private boolean bc$shouldStopRender() {
        return ((CameraExt)Minecraft.getInstance().gameRenderer.getMainCamera()).getBc$overrides().getActive();
    }

    @Inject(method={"renderCameraOverlays", "renderCrosshair", "renderItemHotbar", "renderHotbarAndDecorations", "renderExperienceLevel", "renderEffects", "renderScoreboardSidebar", "renderOverlayMessage", "renderDemoOverlay", "renderTitle", "renderTabList"}, at={@At(value="HEAD")}, cancellable=true)
    public void bc$stopOverlays(GuiGraphics guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci) {
        if (this.bc$shouldStopRender()) {
            ci.cancel();
        }
    }
}

