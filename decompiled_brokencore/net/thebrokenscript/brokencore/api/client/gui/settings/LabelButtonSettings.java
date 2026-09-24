/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.gui.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.client.gui.button.LabelButton;
import net.thebrokenscript.brokencore.api.client.gui.settings.LabelSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u001c\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006$"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelButtonSettings;", "", "normalSettings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;", "hoveredSettings", "pressedSettings", "pressedHoveredSettings", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;)V", "getNormalSettings", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;", "getHoveredSettings", "getPressedSettings", "getPressedHoveredSettings", "getSettings", "hovered", "", "pressed", "create", "Lnet/thebrokenscript/brokencore/api/client/gui/button/LabelButton;", "text", "", "callback", "Lkotlin/Function0;", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "brokencore-common"})
public final class LabelButtonSettings {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final LabelSettings normalSettings;
    @NotNull
    private final LabelSettings hoveredSettings;
    @NotNull
    private final LabelSettings pressedSettings;
    @NotNull
    private final LabelSettings pressedHoveredSettings;
    @NotNull
    private static final LabelButtonSettings DEFAULT = new LabelButtonSettings(new LabelSettings(false, false, false, false, false, false, false, 0.8784314f, 0.8784314f, 0.8784314f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 31871, null), new LabelSettings(false, false, false, false, false, false, false, 0.0f, 0.5f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 31871, null), new LabelSettings(false, false, false, false, false, false, false, 0.4392157f, 0.4392157f, 0.4392157f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 31871, null), new LabelSettings(false, false, false, false, false, false, false, 0.0f, 0.25f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 31871, null));

    public LabelButtonSettings(@NotNull LabelSettings normalSettings, @NotNull LabelSettings hoveredSettings, @NotNull LabelSettings pressedSettings, @NotNull LabelSettings pressedHoveredSettings) {
        Intrinsics.checkNotNullParameter((Object)normalSettings, (String)"normalSettings");
        Intrinsics.checkNotNullParameter((Object)hoveredSettings, (String)"hoveredSettings");
        Intrinsics.checkNotNullParameter((Object)pressedSettings, (String)"pressedSettings");
        Intrinsics.checkNotNullParameter((Object)pressedHoveredSettings, (String)"pressedHoveredSettings");
        this.normalSettings = normalSettings;
        this.hoveredSettings = hoveredSettings;
        this.pressedSettings = pressedSettings;
        this.pressedHoveredSettings = pressedHoveredSettings;
    }

    @NotNull
    public final LabelSettings getNormalSettings() {
        return this.normalSettings;
    }

    @NotNull
    public final LabelSettings getHoveredSettings() {
        return this.hoveredSettings;
    }

    @NotNull
    public final LabelSettings getPressedSettings() {
        return this.pressedSettings;
    }

    @NotNull
    public final LabelSettings getPressedHoveredSettings() {
        return this.pressedHoveredSettings;
    }

    @NotNull
    public final LabelSettings getSettings(boolean hovered, boolean pressed) {
        return hovered ? (pressed ? this.pressedHoveredSettings : this.hoveredSettings) : (pressed ? this.pressedSettings : this.normalSettings);
    }

    @NotNull
    public final LabelButton create(@NotNull String text, @NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        return new LabelButton(text, this, callback);
    }

    @NotNull
    public final LabelSettings component1() {
        return this.normalSettings;
    }

    @NotNull
    public final LabelSettings component2() {
        return this.hoveredSettings;
    }

    @NotNull
    public final LabelSettings component3() {
        return this.pressedSettings;
    }

    @NotNull
    public final LabelSettings component4() {
        return this.pressedHoveredSettings;
    }

    @NotNull
    public final LabelButtonSettings copy(@NotNull LabelSettings normalSettings, @NotNull LabelSettings hoveredSettings, @NotNull LabelSettings pressedSettings, @NotNull LabelSettings pressedHoveredSettings) {
        Intrinsics.checkNotNullParameter((Object)normalSettings, (String)"normalSettings");
        Intrinsics.checkNotNullParameter((Object)hoveredSettings, (String)"hoveredSettings");
        Intrinsics.checkNotNullParameter((Object)pressedSettings, (String)"pressedSettings");
        Intrinsics.checkNotNullParameter((Object)pressedHoveredSettings, (String)"pressedHoveredSettings");
        return new LabelButtonSettings(normalSettings, hoveredSettings, pressedSettings, pressedHoveredSettings);
    }

    public static /* synthetic */ LabelButtonSettings copy$default(LabelButtonSettings labelButtonSettings, LabelSettings labelSettings, LabelSettings labelSettings2, LabelSettings labelSettings3, LabelSettings labelSettings4, int n, Object object) {
        if ((n & 1) != 0) {
            labelSettings = labelButtonSettings.normalSettings;
        }
        if ((n & 2) != 0) {
            labelSettings2 = labelButtonSettings.hoveredSettings;
        }
        if ((n & 4) != 0) {
            labelSettings3 = labelButtonSettings.pressedSettings;
        }
        if ((n & 8) != 0) {
            labelSettings4 = labelButtonSettings.pressedHoveredSettings;
        }
        return labelButtonSettings.copy(labelSettings, labelSettings2, labelSettings3, labelSettings4);
    }

    @NotNull
    public String toString() {
        return "LabelButtonSettings(normalSettings=" + this.normalSettings + ", hoveredSettings=" + this.hoveredSettings + ", pressedSettings=" + this.pressedSettings + ", pressedHoveredSettings=" + this.pressedHoveredSettings + ")";
    }

    public int hashCode() {
        int result = this.normalSettings.hashCode();
        result = result * 31 + this.hoveredSettings.hashCode();
        result = result * 31 + this.pressedSettings.hashCode();
        result = result * 31 + this.pressedHoveredSettings.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LabelButtonSettings)) {
            return false;
        }
        LabelButtonSettings labelButtonSettings = (LabelButtonSettings)other;
        if (!Intrinsics.areEqual((Object)this.normalSettings, (Object)labelButtonSettings.normalSettings)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.hoveredSettings, (Object)labelButtonSettings.hoveredSettings)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pressedSettings, (Object)labelButtonSettings.pressedSettings)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.pressedHoveredSettings, (Object)labelButtonSettings.pressedHoveredSettings);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelButtonSettings$Companion;", "", "<init>", "()V", "DEFAULT", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelButtonSettings;", "getDEFAULT", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelButtonSettings;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final LabelButtonSettings getDEFAULT() {
            return DEFAULT;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

