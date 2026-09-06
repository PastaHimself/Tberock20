/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.gui.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteScalingSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020#H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006$"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/settings/SliderSettings;", "", "bgScaling", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "bgSprite", "Lnet/minecraft/resources/ResourceLocation;", "grabberScaling", "grabberNormal", "grabberHovered", "grabberHeld", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;Lnet/minecraft/resources/ResourceLocation;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;)V", "getBgScaling", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "getBgSprite", "()Lnet/minecraft/resources/ResourceLocation;", "getGrabberScaling", "getGrabberNormal", "getGrabberHovered", "getGrabberHeld", "create", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "brokencore-common"})
public final class SliderSettings {
    @NotNull
    private final SpriteScalingSettings bgScaling;
    @NotNull
    private final ResourceLocation bgSprite;
    @NotNull
    private final SpriteScalingSettings grabberScaling;
    @NotNull
    private final ResourceLocation grabberNormal;
    @NotNull
    private final ResourceLocation grabberHovered;
    @NotNull
    private final ResourceLocation grabberHeld;

    public SliderSettings(@NotNull SpriteScalingSettings bgScaling, @NotNull ResourceLocation bgSprite, @NotNull SpriteScalingSettings grabberScaling, @NotNull ResourceLocation grabberNormal, @NotNull ResourceLocation grabberHovered, @NotNull ResourceLocation grabberHeld) {
        Intrinsics.checkNotNullParameter((Object)bgScaling, (String)"bgScaling");
        Intrinsics.checkNotNullParameter((Object)bgSprite, (String)"bgSprite");
        Intrinsics.checkNotNullParameter((Object)grabberScaling, (String)"grabberScaling");
        Intrinsics.checkNotNullParameter((Object)grabberNormal, (String)"grabberNormal");
        Intrinsics.checkNotNullParameter((Object)grabberHovered, (String)"grabberHovered");
        Intrinsics.checkNotNullParameter((Object)grabberHeld, (String)"grabberHeld");
        this.bgScaling = bgScaling;
        this.bgSprite = bgSprite;
        this.grabberScaling = grabberScaling;
        this.grabberNormal = grabberNormal;
        this.grabberHovered = grabberHovered;
        this.grabberHeld = grabberHeld;
    }

    @NotNull
    public final SpriteScalingSettings getBgScaling() {
        return this.bgScaling;
    }

    @NotNull
    public final ResourceLocation getBgSprite() {
        return this.bgSprite;
    }

    @NotNull
    public final SpriteScalingSettings getGrabberScaling() {
        return this.grabberScaling;
    }

    @NotNull
    public final ResourceLocation getGrabberNormal() {
        return this.grabberNormal;
    }

    @NotNull
    public final ResourceLocation getGrabberHovered() {
        return this.grabberHovered;
    }

    @NotNull
    public final ResourceLocation getGrabberHeld() {
        return this.grabberHeld;
    }

    public final void create() {
    }

    @NotNull
    public final SpriteScalingSettings component1() {
        return this.bgScaling;
    }

    @NotNull
    public final ResourceLocation component2() {
        return this.bgSprite;
    }

    @NotNull
    public final SpriteScalingSettings component3() {
        return this.grabberScaling;
    }

    @NotNull
    public final ResourceLocation component4() {
        return this.grabberNormal;
    }

    @NotNull
    public final ResourceLocation component5() {
        return this.grabberHovered;
    }

    @NotNull
    public final ResourceLocation component6() {
        return this.grabberHeld;
    }

    @NotNull
    public final SliderSettings copy(@NotNull SpriteScalingSettings bgScaling, @NotNull ResourceLocation bgSprite, @NotNull SpriteScalingSettings grabberScaling, @NotNull ResourceLocation grabberNormal, @NotNull ResourceLocation grabberHovered, @NotNull ResourceLocation grabberHeld) {
        Intrinsics.checkNotNullParameter((Object)bgScaling, (String)"bgScaling");
        Intrinsics.checkNotNullParameter((Object)bgSprite, (String)"bgSprite");
        Intrinsics.checkNotNullParameter((Object)grabberScaling, (String)"grabberScaling");
        Intrinsics.checkNotNullParameter((Object)grabberNormal, (String)"grabberNormal");
        Intrinsics.checkNotNullParameter((Object)grabberHovered, (String)"grabberHovered");
        Intrinsics.checkNotNullParameter((Object)grabberHeld, (String)"grabberHeld");
        return new SliderSettings(bgScaling, bgSprite, grabberScaling, grabberNormal, grabberHovered, grabberHeld);
    }

    public static /* synthetic */ SliderSettings copy$default(SliderSettings sliderSettings, SpriteScalingSettings spriteScalingSettings, ResourceLocation resourceLocation, SpriteScalingSettings spriteScalingSettings2, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, ResourceLocation resourceLocation4, int n, Object object) {
        if ((n & 1) != 0) {
            spriteScalingSettings = sliderSettings.bgScaling;
        }
        if ((n & 2) != 0) {
            resourceLocation = sliderSettings.bgSprite;
        }
        if ((n & 4) != 0) {
            spriteScalingSettings2 = sliderSettings.grabberScaling;
        }
        if ((n & 8) != 0) {
            resourceLocation2 = sliderSettings.grabberNormal;
        }
        if ((n & 0x10) != 0) {
            resourceLocation3 = sliderSettings.grabberHovered;
        }
        if ((n & 0x20) != 0) {
            resourceLocation4 = sliderSettings.grabberHeld;
        }
        return sliderSettings.copy(spriteScalingSettings, resourceLocation, spriteScalingSettings2, resourceLocation2, resourceLocation3, resourceLocation4);
    }

    @NotNull
    public String toString() {
        return "SliderSettings(bgScaling=" + this.bgScaling + ", bgSprite=" + this.bgSprite + ", grabberScaling=" + this.grabberScaling + ", grabberNormal=" + this.grabberNormal + ", grabberHovered=" + this.grabberHovered + ", grabberHeld=" + this.grabberHeld + ")";
    }

    public int hashCode() {
        int result = this.bgScaling.hashCode();
        result = result * 31 + this.bgSprite.hashCode();
        result = result * 31 + this.grabberScaling.hashCode();
        result = result * 31 + this.grabberNormal.hashCode();
        result = result * 31 + this.grabberHovered.hashCode();
        result = result * 31 + this.grabberHeld.hashCode();
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SliderSettings)) {
            return false;
        }
        SliderSettings sliderSettings = (SliderSettings)other;
        if (!Intrinsics.areEqual((Object)this.bgScaling, (Object)sliderSettings.bgScaling)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.bgSprite, (Object)sliderSettings.bgSprite)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.grabberScaling, (Object)sliderSettings.grabberScaling)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.grabberNormal, (Object)sliderSettings.grabberNormal)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.grabberHovered, (Object)sliderSettings.grabberHovered)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.grabberHeld, (Object)sliderSettings.grabberHeld);
    }
}

