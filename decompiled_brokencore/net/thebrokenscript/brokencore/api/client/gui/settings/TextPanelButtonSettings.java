/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.gui.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.gui.button.TextPanelButton;
import net.thebrokenscript.brokencore.api.client.gui.settings.LabelButtonSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.LabelSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteButtonSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u001c\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001J\t\u0010!\u001a\u00020\u0016H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\""}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/settings/TextPanelButtonSettings;", "", "spriteButtonSettings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteButtonSettings;", "labelButtonSettings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelButtonSettings;", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteButtonSettings;Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelButtonSettings;)V", "getSpriteButtonSettings", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteButtonSettings;", "getLabelButtonSettings", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelButtonSettings;", "getSettings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;", "hovered", "", "pressed", "getSprite", "Lnet/minecraft/resources/ResourceLocation;", "create", "Lnet/thebrokenscript/brokencore/api/client/gui/button/TextPanelButton;", "text", "", "callback", "Lkotlin/Function0;", "", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "brokencore-common"})
public final class TextPanelButtonSettings {
    @NotNull
    private final SpriteButtonSettings spriteButtonSettings;
    @NotNull
    private final LabelButtonSettings labelButtonSettings;

    public TextPanelButtonSettings(@NotNull SpriteButtonSettings spriteButtonSettings, @NotNull LabelButtonSettings labelButtonSettings) {
        Intrinsics.checkNotNullParameter((Object)spriteButtonSettings, (String)"spriteButtonSettings");
        Intrinsics.checkNotNullParameter((Object)labelButtonSettings, (String)"labelButtonSettings");
        this.spriteButtonSettings = spriteButtonSettings;
        this.labelButtonSettings = labelButtonSettings;
    }

    @NotNull
    public final SpriteButtonSettings getSpriteButtonSettings() {
        return this.spriteButtonSettings;
    }

    @NotNull
    public final LabelButtonSettings getLabelButtonSettings() {
        return this.labelButtonSettings;
    }

    @NotNull
    public final LabelSettings getSettings(boolean hovered, boolean pressed) {
        return this.labelButtonSettings.getSettings(hovered, pressed);
    }

    @NotNull
    public final ResourceLocation getSprite(boolean hovered, boolean pressed) {
        return this.spriteButtonSettings.getSprite(hovered, pressed);
    }

    @NotNull
    public final TextPanelButton create(@NotNull String text, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        return new TextPanelButton(text, this, callback);
    }

    @NotNull
    public final SpriteButtonSettings component1() {
        return this.spriteButtonSettings;
    }

    @NotNull
    public final LabelButtonSettings component2() {
        return this.labelButtonSettings;
    }

    @NotNull
    public final TextPanelButtonSettings copy(@NotNull SpriteButtonSettings spriteButtonSettings, @NotNull LabelButtonSettings labelButtonSettings) {
        Intrinsics.checkNotNullParameter((Object)spriteButtonSettings, (String)"spriteButtonSettings");
        Intrinsics.checkNotNullParameter((Object)labelButtonSettings, (String)"labelButtonSettings");
        return new TextPanelButtonSettings(spriteButtonSettings, labelButtonSettings);
    }

    public static /* synthetic */ TextPanelButtonSettings copy$default(TextPanelButtonSettings textPanelButtonSettings, SpriteButtonSettings spriteButtonSettings, LabelButtonSettings labelButtonSettings, int n, Object object) {
        if ((n & 1) != 0) {
            spriteButtonSettings = textPanelButtonSettings.spriteButtonSettings;
        }
        if ((n & 2) != 0) {
            labelButtonSettings = textPanelButtonSettings.labelButtonSettings;
        }
        return textPanelButtonSettings.copy(spriteButtonSettings, labelButtonSettings);
    }

    @NotNull
    public String toString() {
        return "TextPanelButtonSettings(spriteButtonSettings=" + this.spriteButtonSettings + ", labelButtonSettings=" + this.labelButtonSettings + ")";
    }

    public int hashCode() {
        int result = this.spriteButtonSettings.hashCode();
        result = result * 31 + this.labelButtonSettings.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextPanelButtonSettings)) {
            return false;
        }
        TextPanelButtonSettings textPanelButtonSettings = (TextPanelButtonSettings)other;
        if (!Intrinsics.areEqual((Object)this.spriteButtonSettings, (Object)textPanelButtonSettings.spriteButtonSettings)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.labelButtonSettings, (Object)textPanelButtonSettings.labelButtonSettings);
    }
}

