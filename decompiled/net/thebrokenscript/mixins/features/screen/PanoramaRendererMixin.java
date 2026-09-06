/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.client.gui.StartupScreen;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.config.client.MenuMode;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Screen.class}, priority=900)
public abstract class PanoramaRendererMixin {
    @Unique
    private static final ResourceLocation PANORAMA_OVERLAY = TBSConstants.id("textures/block/bedrock.png");
    @Shadow
    public int width;
    @Shadow
    public int height;
    @Shadow
    @Nullable
    protected Minecraft minecraft;

    @Unique
    public void tbs$renderDirtBackground(GuiGraphics guiGraphics) {
        guiGraphics.setColor(0.25f, 0.25f, 0.25f, 1.0f);
        guiGraphics.blit(PANORAMA_OVERLAY, 0, 0, 0, 0.0f, 0.0f, this.width, this.height, 32, 32);
        guiGraphics.setColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Inject(method={"renderBackground(Lnet/minecraft/client/gui/GuiGraphics;IIF)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void tbs$RenderBackgroundDirt(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        if (this.minecraft != null && this.minecraft.screen instanceof StartupScreen) {
            this.tbs$renderDirtBackground(guiGraphics);
            ci.cancel();
            return;
        }
        if (TBSConfigs.INSTANCE.isLoaded() && this.minecraft != null && this.minecraft.level == null && TBSConfigs.INSTANCE.getClient().getMainMenuMode() != MenuMode.VANILLA) {
            this.tbs$renderDirtBackground(guiGraphics);
            ci.cancel();
        }
    }

    @Inject(method={"renderPanorama"}, at={@At(value="HEAD")}, cancellable=true)
    protected void tbs$renderPanorama(GuiGraphics guiGraphics, float partialTick, CallbackInfo ci) {
        if (TBSConfigs.INSTANCE.isLoaded() && TBSConfigs.INSTANCE.getClient().getMainMenuMode() != MenuMode.VANILLA) {
            ci.cancel();
        }
    }
}

