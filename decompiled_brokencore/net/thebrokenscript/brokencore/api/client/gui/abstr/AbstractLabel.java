/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.GuiGraphics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.gui.abstr;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiGraphics;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.settings.LabelSettings;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J6\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000bJ@\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010(\u001a\u00020\u001fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003@VX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u000b8VX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u001d\u00a8\u0006)"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractLabel;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "text", "", "settings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;", "<init>", "(Ljava/lang/String;Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;)V", "getSettings", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;", "value", "", "textWidth", "getTextWidth", "()I", "v", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "clipText", "", "getClipText", "()Z", "setClipText", "(Z)V", "w", "getW", "setW", "(I)V", "render", "", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "mouseY", "partialTick", "", "globalX", "globalY", "updateTextWidth", "brokencore-common"})
public abstract class AbstractLabel
extends AbstractGuiNode2D {
    @NotNull
    private final LabelSettings settings;
    private int textWidth;
    @NotNull
    private String text;
    private boolean clipText;
    private int w;

    public AbstractLabel(@NotNull String text, @NotNull LabelSettings settings) {
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super(0, 0, 0, 0, 15, null);
        this.settings = settings;
        this.text = text;
        this.updateTextWidth();
        this.w = 16;
    }

    public /* synthetic */ AbstractLabel(String string, LabelSettings labelSettings, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            string = "";
        }
        if ((n & 2) != 0) {
            labelSettings = new LabelSettings(false, false, false, false, false, false, false, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, Short.MAX_VALUE, null);
        }
        this(string, labelSettings);
    }

    @NotNull
    public final LabelSettings getSettings() {
        return this.settings;
    }

    public final int getTextWidth() {
        return this.textWidth;
    }

    @NotNull
    public String getText() {
        return this.text;
    }

    public void setText(@NotNull String v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.text = v;
        this.updateTextWidth();
    }

    public final boolean getClipText() {
        return this.clipText;
    }

    public final void setClipText(boolean bl) {
        this.clipText = bl;
    }

    @Override
    public int getW() {
        return this.clipText ? super.getW() : Math.max(super.getW(), this.textWidth);
    }

    @Override
    public void setW(int n) {
        this.w = n;
    }

    @Override
    public final void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, int globalX, int globalY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        this.textWidth = this.settings.render(guiGraphics, this.getText(), globalX, globalY, this.getW(), this.getH(), this.getZIndex());
        this.render(guiGraphics, mouseX, mouseY, partialTick, globalX, globalY, this.textWidth);
    }

    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, int globalX, int globalY, int textWidth) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
    }

    public final void updateTextWidth() {
        this.textWidth = this.settings.getTextWidth(this.getText());
    }

    public AbstractLabel() {
        this(null, null, 3, null);
    }
}

