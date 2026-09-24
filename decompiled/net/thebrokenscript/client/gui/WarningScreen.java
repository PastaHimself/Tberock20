/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.client.gui.screens.TitleScreen
 *  net.minecraft.network.chat.Component
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.gui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.client.gui.HardwareQueryScreen;
import net.thebrokenscript.client.gui.MarkScreen;
import net.thebrokenscript.client.gui.StartupScreen;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J(\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/client/gui/WarningScreen;", "Lnet/thebrokenscript/client/gui/StartupScreen;", "<init>", "()V", "setShowAgain", "", "value", "", "afterClose", "render", "cx", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "", "mouseY", "delta", "", "thebrokenscript-common"})
public final class WarningScreen
extends StartupScreen {
    public WarningScreen() {
        super((Component)TBSLang.INSTANCE.getWARNING_TITLE());
    }

    @Override
    public void setShowAgain(boolean value) {
        TBSConfigs.INSTANCE.getClient().getAccessibility().setShowPhotosensitivityWarning(value);
    }

    @Override
    public void afterClose() {
        Minecraft minecraft = this.minecraft;
        if (minecraft != null) {
            minecraft.setScreen(TBSConfigs.INSTANCE.getClient().getAccessibility().getShowMarkScreen() ? (Screen)new MarkScreen() : (!ClientVariables.INSTANCE.has(16384L) ? (Screen)new HardwareQueryScreen() : (Screen)new TitleScreen()));
        }
        TBSConfigs.INSTANCE.getClient().getSpecification().save();
    }

    public void render(@NotNull GuiGraphics cx, int mouseX, int mouseY, float delta) {
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        this.renderBackground(cx, mouseX, mouseY, delta);
        super.render(cx, mouseX, mouseY, delta);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getWARNING_TITLE(), this.width / 2, 60, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getWARNING_TOP(), this.width / 2, this.height / 2 - 40, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getWARNING_LINE_1(), this.width / 2, this.height / 2 - 20, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getWARNING_LINE_2(), this.width / 2, this.height / 2 - 10, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getWARNING_LINE_3(), this.width / 2, this.height / 2, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getWARNING_EXTRA(), this.width / 2, this.height / 2 + 20, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getWARNING_BOTTOM(), this.width / 2, this.height / 2 + 40, 0xFFFFFF);
        cx.drawCenteredString(this.font, (Component)TBSLang.INSTANCE.getBUTTON_CONTINUE(), this.width / 2, this.height - 40, 0xAAAAAA);
    }
}

