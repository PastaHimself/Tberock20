/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.GuiGraphics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.gui.button;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiGraphics;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractButton;
import net.thebrokenscript.brokencore.api.client.gui.settings.LabelSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteScalingSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.TextPanelButtonSettings;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\t\u0010\nJ8\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/button/TextPanelButton;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractButton;", "text", "", "settings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/TextPanelButtonSettings;", "callback", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Lnet/thebrokenscript/brokencore/api/client/gui/settings/TextPanelButtonSettings;Lkotlin/jvm/functions/Function0;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getSettings", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/TextPanelButtonSettings;", "render", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "", "mouseY", "partialTick", "", "globalX", "globalY", "brokencore-common"})
public final class TextPanelButton
extends AbstractButton {
    @NotNull
    private String text;
    @NotNull
    private final TextPanelButtonSettings settings;

    public TextPanelButton(@NotNull String text, @NotNull TextPanelButtonSettings settings, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        super(callback);
        this.text = text;
        this.settings = settings;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public final void setText(@NotNull String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<set-?>");
        this.text = string;
    }

    @NotNull
    public final TextPanelButtonSettings getSettings() {
        return this.settings;
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, int globalX, int globalY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        SpriteScalingSettings spriteScalingSettings = this.settings.getSpriteButtonSettings().getSpriteScalingSettings();
        super.render(guiGraphics, mouseX, mouseY, partialTick, globalX, globalY);
        spriteScalingSettings.render(guiGraphics, this.settings.getSprite(this.getHovered(), this.getPressed()), this);
        LabelSettings settings = this.settings.getSettings(this.getHovered(), this.getPressed());
        settings.render(guiGraphics, this.text, globalX + this.getW() / 2 - ClientDSLKt.getMC().font.width(this.text) / 2, globalY + this.getH() / 2 - spriteScalingSettings.getH() * 2, this.getW(), this.getH(), this.getZIndex());
    }
}

