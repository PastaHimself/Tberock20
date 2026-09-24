/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.LogoRenderer
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.RandomSource
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.thebrokenscript.mixins.features.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.LogoRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={LogoRenderer.class}, priority=1100)
public class LogoRendererMixin {
    @Unique
    private static final ResourceLocation tbs$GLITCHED_TITLE = ResourceLocation.fromNamespaceAndPath((String)"thebrokenscript", (String)"textures/gui/menu/glitch_logo.png");
    @Unique
    private static final RandomSource tbs$RANDOM = RandomSource.create();

    @Inject(method={"renderLogo(Lnet/minecraft/client/gui/GuiGraphics;IFI)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;blit(Lnet/minecraft/resources/ResourceLocation;IIFFIIII)V")}, cancellable=true)
    private void animateGlitchLogo(GuiGraphics guiGraphics, int screenWidth, float transparency, int height, CallbackInfo ci) {
        ci.cancel();
        int i = screenWidth / 2 - 128;
        long tickCount = Minecraft.getInstance().gui.getGuiTicks();
        int frame = (int)(tickCount / 2L % 9L);
        int offset = frame * 166;
        int strength = 1;
        guiGraphics.blit(tbs$GLITCHED_TITLE, i + tbs$RANDOM.nextInt(-strength, strength), height + tbs$RANDOM.nextInt(-strength, strength), 256, 44, 0.0f, (float)offset, 1024, 166, 1024, 1491);
    }
}

