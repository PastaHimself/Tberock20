/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Font
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.SubtitleOverlay
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.ComponentContents
 *  net.minecraft.network.chat.contents.TranslatableContents
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package net.thebrokenscript.mixins.features.render;

import java.util.Objects;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.SubtitleOverlay;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentContents;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.thebrokenscript.client.TBSLibraryAnimations;
import net.thebrokenscript.client.util.LibraryTextUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={SubtitleOverlay.class})
public class SubtitleOverlayMixin {
    @Unique
    private static final Set<String> tbs$JITTERY_SUBTITLE_KEYS = Set.of("subtitles.thebrokenscript.curved.curved_notice1", "subtitles.thebrokenscript.curved.curved_notice2", "subtitles.thebrokenscript.curved.curved_notice3", "subtitles.thebrokenscript.curved.curved_notice4", "subtitles.thebrokenscript.curved.curved_notice5", "subtitles.thebrokenscript.curved.curved_notice6");

    @Redirect(method={"render"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/GuiGraphics;drawString(Lnet/minecraft/client/gui/Font;Lnet/minecraft/network/chat/Component;III)I"))
    private int cancelOrModifySubtitle(GuiGraphics instance, Font font, Component text, int x, int y, int color) {
        String key = SubtitleOverlayMixin.tbs$getKey(text);
        if (tbs$JITTERY_SUBTITLE_KEYS.contains(key)) {
            LibraryTextUtils style = new LibraryTextUtils(color, true, false, false, false, false, null, null, null, null, null);
            TBSLibraryAnimations.INSTANCE.jitteryText(instance, text.getVisualOrderText(), Minecraft.getInstance().font, x - 10, y, (float)(Objects.requireNonNull(Minecraft.getInstance().level).getGameTime() + Minecraft.getInstance().getFrameTimeNs()), style);
            return 0;
        }
        return instance.drawString(font, text, x, y, color);
    }

    @Unique
    private static String tbs$getKey(Component component) {
        ComponentContents componentContents = component.getContents();
        if (componentContents instanceof TranslatableContents) {
            TranslatableContents tc = (TranslatableContents)componentContents;
            return tc.getKey();
        }
        return "";
    }
}

