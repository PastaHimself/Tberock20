/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.gui.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.gui.button.SpriteButton;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteScalingSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u0017\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0086\u0002J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010!\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020$H\u00d6\u0001J\t\u0010%\u001a\u00020&H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006'"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteButtonSettings;", "", "spriteScalingSettings", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "normalSprite", "Lnet/minecraft/resources/ResourceLocation;", "normalHoveredSprite", "pressedSprite", "pressedHoveredSprite", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)V", "getSpriteScalingSettings", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "getNormalSprite", "()Lnet/minecraft/resources/ResourceLocation;", "getNormalHoveredSprite", "getPressedSprite", "getPressedHoveredSprite", "getSprite", "hovered", "", "pressed", "invoke", "Lnet/thebrokenscript/brokencore/api/client/gui/button/SpriteButton;", "callback", "Lkotlin/Function0;", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "brokencore-common"})
public final class SpriteButtonSettings {
    @NotNull
    private final SpriteScalingSettings spriteScalingSettings;
    @NotNull
    private final ResourceLocation normalSprite;
    @NotNull
    private final ResourceLocation normalHoveredSprite;
    @NotNull
    private final ResourceLocation pressedSprite;
    @NotNull
    private final ResourceLocation pressedHoveredSprite;

    public SpriteButtonSettings(@NotNull SpriteScalingSettings spriteScalingSettings, @NotNull ResourceLocation normalSprite, @NotNull ResourceLocation normalHoveredSprite, @NotNull ResourceLocation pressedSprite, @NotNull ResourceLocation pressedHoveredSprite) {
        Intrinsics.checkNotNullParameter((Object)spriteScalingSettings, (String)"spriteScalingSettings");
        Intrinsics.checkNotNullParameter((Object)normalSprite, (String)"normalSprite");
        Intrinsics.checkNotNullParameter((Object)normalHoveredSprite, (String)"normalHoveredSprite");
        Intrinsics.checkNotNullParameter((Object)pressedSprite, (String)"pressedSprite");
        Intrinsics.checkNotNullParameter((Object)pressedHoveredSprite, (String)"pressedHoveredSprite");
        this.spriteScalingSettings = spriteScalingSettings;
        this.normalSprite = normalSprite;
        this.normalHoveredSprite = normalHoveredSprite;
        this.pressedSprite = pressedSprite;
        this.pressedHoveredSprite = pressedHoveredSprite;
    }

    public /* synthetic */ SpriteButtonSettings(SpriteScalingSettings spriteScalingSettings, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, ResourceLocation resourceLocation4, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            resourceLocation2 = resourceLocation;
        }
        if ((n & 8) != 0) {
            resourceLocation3 = resourceLocation;
        }
        if ((n & 0x10) != 0) {
            resourceLocation4 = resourceLocation;
        }
        this(spriteScalingSettings, resourceLocation, resourceLocation2, resourceLocation3, resourceLocation4);
    }

    @NotNull
    public final SpriteScalingSettings getSpriteScalingSettings() {
        return this.spriteScalingSettings;
    }

    @NotNull
    public final ResourceLocation getNormalSprite() {
        return this.normalSprite;
    }

    @NotNull
    public final ResourceLocation getNormalHoveredSprite() {
        return this.normalHoveredSprite;
    }

    @NotNull
    public final ResourceLocation getPressedSprite() {
        return this.pressedSprite;
    }

    @NotNull
    public final ResourceLocation getPressedHoveredSprite() {
        return this.pressedHoveredSprite;
    }

    @NotNull
    public final ResourceLocation getSprite(boolean hovered, boolean pressed) {
        return hovered ? (pressed ? this.pressedHoveredSprite : this.normalHoveredSprite) : (pressed ? this.pressedSprite : this.normalSprite);
    }

    @NotNull
    public final SpriteButton invoke(@NotNull Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        return new SpriteButton(this, callback);
    }

    @NotNull
    public final SpriteScalingSettings component1() {
        return this.spriteScalingSettings;
    }

    @NotNull
    public final ResourceLocation component2() {
        return this.normalSprite;
    }

    @NotNull
    public final ResourceLocation component3() {
        return this.normalHoveredSprite;
    }

    @NotNull
    public final ResourceLocation component4() {
        return this.pressedSprite;
    }

    @NotNull
    public final ResourceLocation component5() {
        return this.pressedHoveredSprite;
    }

    @NotNull
    public final SpriteButtonSettings copy(@NotNull SpriteScalingSettings spriteScalingSettings, @NotNull ResourceLocation normalSprite, @NotNull ResourceLocation normalHoveredSprite, @NotNull ResourceLocation pressedSprite, @NotNull ResourceLocation pressedHoveredSprite) {
        Intrinsics.checkNotNullParameter((Object)spriteScalingSettings, (String)"spriteScalingSettings");
        Intrinsics.checkNotNullParameter((Object)normalSprite, (String)"normalSprite");
        Intrinsics.checkNotNullParameter((Object)normalHoveredSprite, (String)"normalHoveredSprite");
        Intrinsics.checkNotNullParameter((Object)pressedSprite, (String)"pressedSprite");
        Intrinsics.checkNotNullParameter((Object)pressedHoveredSprite, (String)"pressedHoveredSprite");
        return new SpriteButtonSettings(spriteScalingSettings, normalSprite, normalHoveredSprite, pressedSprite, pressedHoveredSprite);
    }

    public static /* synthetic */ SpriteButtonSettings copy$default(SpriteButtonSettings spriteButtonSettings, SpriteScalingSettings spriteScalingSettings, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, ResourceLocation resourceLocation4, int n, Object object) {
        if ((n & 1) != 0) {
            spriteScalingSettings = spriteButtonSettings.spriteScalingSettings;
        }
        if ((n & 2) != 0) {
            resourceLocation = spriteButtonSettings.normalSprite;
        }
        if ((n & 4) != 0) {
            resourceLocation2 = spriteButtonSettings.normalHoveredSprite;
        }
        if ((n & 8) != 0) {
            resourceLocation3 = spriteButtonSettings.pressedSprite;
        }
        if ((n & 0x10) != 0) {
            resourceLocation4 = spriteButtonSettings.pressedHoveredSprite;
        }
        return spriteButtonSettings.copy(spriteScalingSettings, resourceLocation, resourceLocation2, resourceLocation3, resourceLocation4);
    }

    @NotNull
    public String toString() {
        return "SpriteButtonSettings(spriteScalingSettings=" + this.spriteScalingSettings + ", normalSprite=" + this.normalSprite + ", normalHoveredSprite=" + this.normalHoveredSprite + ", pressedSprite=" + this.pressedSprite + ", pressedHoveredSprite=" + this.pressedHoveredSprite + ")";
    }

    public int hashCode() {
        int result = this.spriteScalingSettings.hashCode();
        result = result * 31 + this.normalSprite.hashCode();
        result = result * 31 + this.normalHoveredSprite.hashCode();
        result = result * 31 + this.pressedSprite.hashCode();
        result = result * 31 + this.pressedHoveredSprite.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpriteButtonSettings)) {
            return false;
        }
        SpriteButtonSettings spriteButtonSettings = (SpriteButtonSettings)other;
        if (!Intrinsics.areEqual((Object)this.spriteScalingSettings, (Object)spriteButtonSettings.spriteScalingSettings)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.normalSprite, (Object)spriteButtonSettings.normalSprite)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.normalHoveredSprite, (Object)spriteButtonSettings.normalHoveredSprite)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.pressedSprite, (Object)spriteButtonSettings.pressedSprite)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.pressedHoveredSprite, (Object)spriteButtonSettings.pressedHoveredSprite);
    }
}

