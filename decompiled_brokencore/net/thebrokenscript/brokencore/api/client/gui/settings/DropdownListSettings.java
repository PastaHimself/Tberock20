/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.gui.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.gui.misc.DropdownList;
import net.thebrokenscript.brokencore.api.client.gui.settings.LabelButtonSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.ScrollContainerSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteScalingSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.TextPanelButtonSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020%0!J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0007H\u00c6\u0003J\t\u0010)\u001a\u00020\tH\u00c6\u0003J\t\u0010*\u001a\u00020\u000bH\u00c6\u0003J\t\u0010+\u001a\u00020\rH\u00c6\u0003JE\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u00c6\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00100\u001a\u00020\u0007H\u00d6\u0001J\t\u00101\u001a\u00020\u001fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u00a8\u00062"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/settings/DropdownListSettings;", "", "bgSprite", "Lnet/minecraft/resources/ResourceLocation;", "bgScaling", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "bgHeight", "", "previewSettings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/TextPanelButtonSettings;", "entrySettings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelButtonSettings;", "scrollContainerSettings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/ScrollContainerSettings;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;ILnet/thebrokenscript/brokencore/api/client/gui/settings/TextPanelButtonSettings;Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelButtonSettings;Lnet/thebrokenscript/brokencore/api/client/gui/settings/ScrollContainerSettings;)V", "getBgSprite", "()Lnet/minecraft/resources/ResourceLocation;", "getBgScaling", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "getBgHeight", "()I", "getPreviewSettings", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/TextPanelButtonSettings;", "getEntrySettings", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelButtonSettings;", "getScrollContainerSettings", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/ScrollContainerSettings;", "create", "Lnet/thebrokenscript/brokencore/api/client/gui/misc/DropdownList;", "emptyPreviewText", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "selectedText", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "brokencore-common"})
public final class DropdownListSettings {
    @NotNull
    private final ResourceLocation bgSprite;
    @NotNull
    private final SpriteScalingSettings bgScaling;
    private final int bgHeight;
    @NotNull
    private final TextPanelButtonSettings previewSettings;
    @NotNull
    private final LabelButtonSettings entrySettings;
    @NotNull
    private final ScrollContainerSettings scrollContainerSettings;

    public DropdownListSettings(@NotNull ResourceLocation bgSprite, @NotNull SpriteScalingSettings bgScaling, int bgHeight, @NotNull TextPanelButtonSettings previewSettings, @NotNull LabelButtonSettings entrySettings, @NotNull ScrollContainerSettings scrollContainerSettings) {
        Intrinsics.checkNotNullParameter((Object)bgSprite, (String)"bgSprite");
        Intrinsics.checkNotNullParameter((Object)bgScaling, (String)"bgScaling");
        Intrinsics.checkNotNullParameter((Object)previewSettings, (String)"previewSettings");
        Intrinsics.checkNotNullParameter((Object)entrySettings, (String)"entrySettings");
        Intrinsics.checkNotNullParameter((Object)scrollContainerSettings, (String)"scrollContainerSettings");
        this.bgSprite = bgSprite;
        this.bgScaling = bgScaling;
        this.bgHeight = bgHeight;
        this.previewSettings = previewSettings;
        this.entrySettings = entrySettings;
        this.scrollContainerSettings = scrollContainerSettings;
    }

    @NotNull
    public final ResourceLocation getBgSprite() {
        return this.bgSprite;
    }

    @NotNull
    public final SpriteScalingSettings getBgScaling() {
        return this.bgScaling;
    }

    public final int getBgHeight() {
        return this.bgHeight;
    }

    @NotNull
    public final TextPanelButtonSettings getPreviewSettings() {
        return this.previewSettings;
    }

    @NotNull
    public final LabelButtonSettings getEntrySettings() {
        return this.entrySettings;
    }

    @NotNull
    public final ScrollContainerSettings getScrollContainerSettings() {
        return this.scrollContainerSettings;
    }

    @NotNull
    public final DropdownList create(@NotNull String emptyPreviewText, @NotNull Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter((Object)emptyPreviewText, (String)"emptyPreviewText");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        return new DropdownList(emptyPreviewText, this, callback);
    }

    @NotNull
    public final ResourceLocation component1() {
        return this.bgSprite;
    }

    @NotNull
    public final SpriteScalingSettings component2() {
        return this.bgScaling;
    }

    public final int component3() {
        return this.bgHeight;
    }

    @NotNull
    public final TextPanelButtonSettings component4() {
        return this.previewSettings;
    }

    @NotNull
    public final LabelButtonSettings component5() {
        return this.entrySettings;
    }

    @NotNull
    public final ScrollContainerSettings component6() {
        return this.scrollContainerSettings;
    }

    @NotNull
    public final DropdownListSettings copy(@NotNull ResourceLocation bgSprite, @NotNull SpriteScalingSettings bgScaling, int bgHeight, @NotNull TextPanelButtonSettings previewSettings, @NotNull LabelButtonSettings entrySettings, @NotNull ScrollContainerSettings scrollContainerSettings) {
        Intrinsics.checkNotNullParameter((Object)bgSprite, (String)"bgSprite");
        Intrinsics.checkNotNullParameter((Object)bgScaling, (String)"bgScaling");
        Intrinsics.checkNotNullParameter((Object)previewSettings, (String)"previewSettings");
        Intrinsics.checkNotNullParameter((Object)entrySettings, (String)"entrySettings");
        Intrinsics.checkNotNullParameter((Object)scrollContainerSettings, (String)"scrollContainerSettings");
        return new DropdownListSettings(bgSprite, bgScaling, bgHeight, previewSettings, entrySettings, scrollContainerSettings);
    }

    public static /* synthetic */ DropdownListSettings copy$default(DropdownListSettings dropdownListSettings, ResourceLocation resourceLocation, SpriteScalingSettings spriteScalingSettings, int n, TextPanelButtonSettings textPanelButtonSettings, LabelButtonSettings labelButtonSettings, ScrollContainerSettings scrollContainerSettings, int n2, Object object) {
        if ((n2 & 1) != 0) {
            resourceLocation = dropdownListSettings.bgSprite;
        }
        if ((n2 & 2) != 0) {
            spriteScalingSettings = dropdownListSettings.bgScaling;
        }
        if ((n2 & 4) != 0) {
            n = dropdownListSettings.bgHeight;
        }
        if ((n2 & 8) != 0) {
            textPanelButtonSettings = dropdownListSettings.previewSettings;
        }
        if ((n2 & 0x10) != 0) {
            labelButtonSettings = dropdownListSettings.entrySettings;
        }
        if ((n2 & 0x20) != 0) {
            scrollContainerSettings = dropdownListSettings.scrollContainerSettings;
        }
        return dropdownListSettings.copy(resourceLocation, spriteScalingSettings, n, textPanelButtonSettings, labelButtonSettings, scrollContainerSettings);
    }

    @NotNull
    public String toString() {
        return "DropdownListSettings(bgSprite=" + this.bgSprite + ", bgScaling=" + this.bgScaling + ", bgHeight=" + this.bgHeight + ", previewSettings=" + this.previewSettings + ", entrySettings=" + this.entrySettings + ", scrollContainerSettings=" + this.scrollContainerSettings + ")";
    }

    public int hashCode() {
        int result = this.bgSprite.hashCode();
        result = result * 31 + this.bgScaling.hashCode();
        result = result * 31 + Integer.hashCode(this.bgHeight);
        result = result * 31 + this.previewSettings.hashCode();
        result = result * 31 + this.entrySettings.hashCode();
        result = result * 31 + this.scrollContainerSettings.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DropdownListSettings)) {
            return false;
        }
        DropdownListSettings dropdownListSettings = (DropdownListSettings)other;
        if (!Intrinsics.areEqual((Object)this.bgSprite, (Object)dropdownListSettings.bgSprite)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.bgScaling, (Object)dropdownListSettings.bgScaling)) {
            return false;
        }
        if (this.bgHeight != dropdownListSettings.bgHeight) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.previewSettings, (Object)dropdownListSettings.previewSettings)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.entrySettings, (Object)dropdownListSettings.entrySettings)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.scrollContainerSettings, (Object)dropdownListSettings.scrollContainerSettings);
    }
}

