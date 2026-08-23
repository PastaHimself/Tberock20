/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Font
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.client.gui.screens.TitleScreen
 *  net.minecraft.network.chat.Component
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.thebrokenscript.mixins.features.version;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import net.thebrokenscript.registry.TBSLang;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={GuiGraphics.class})
public class GuiGraphicsMixin {
    @Inject(method={"drawString(Lnet/minecraft/client/gui/Font;Ljava/lang/String;III)I"}, at={@At(value="HEAD")}, cancellable=true)
    private void ChangeVersion(Font font, String text, int x, int y, int color, CallbackInfoReturnable<Integer> cir) {
        Screen screen = Minecraft.getInstance().screen;
        if (text != null && text.startsWith("Minecraft ") && screen instanceof TitleScreen) {
            cir.cancel();
            int result = ((GuiGraphics)this).drawString(font, (Component)TBSLang.INSTANCE.getALT_MC_VER(), x, y, color, true);
            cir.setReturnValue((Object)result);
        }
    }
}

