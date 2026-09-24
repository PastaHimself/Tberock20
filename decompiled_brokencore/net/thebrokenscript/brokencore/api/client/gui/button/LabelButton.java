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
import net.thebrokenscript.brokencore.api.client.gui.settings.LabelButtonSettings;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0004\b\t\u0010\nJ8\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/button/LabelButton;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractButton;", "text", "", "settings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelButtonSettings;", "callback", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/String;Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelButtonSettings;Lkotlin/jvm/functions/Function0;)V", "getText", "()Ljava/lang/String;", "getSettings", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelButtonSettings;", "render", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "", "mouseY", "partialTick", "", "globalX", "globalY", "brokencore-common"})
public final class LabelButton
extends AbstractButton {
    @NotNull
    private final String text;
    @NotNull
    private final LabelButtonSettings settings;

    public LabelButton(@NotNull String text, @NotNull LabelButtonSettings settings, @NotNull Function0<Unit> callback) {
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

    @NotNull
    public final LabelButtonSettings getSettings() {
        return this.settings;
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, int globalX, int globalY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        this.settings.getSettings(this.getHovered(), this.getPressed()).render(guiGraphics, this.text, globalX, globalY, this.getW(), this.getH(), this.getZIndex());
    }
}

