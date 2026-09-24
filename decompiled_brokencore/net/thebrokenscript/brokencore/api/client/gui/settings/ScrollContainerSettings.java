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
import net.thebrokenscript.brokencore.api.client.gui.container.ScrollContainer;
import net.thebrokenscript.brokencore.api.client.gui.settings.SliderSettings;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteScalingSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014B)\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0018J\u0006\u0010*\u001a\u00020+J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u0005H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u0005H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0005H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0005H\u00c6\u0003J\t\u00106\u001a\u00020\u0005H\u00c6\u0003J\t\u00107\u001a\u00020\u0005H\u00c6\u0003J\t\u00108\u001a\u00020\u0011H\u00c6\u0003J\t\u00109\u001a\u00020\u0011H\u00c6\u0003J\u0095\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u00c6\u0001J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010>\u001a\u00020\u0011H\u00d6\u0001J\t\u0010?\u001a\u00020@H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010(\u00a8\u0006A"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/settings/ScrollContainerSettings;", "", "scrollbarBgScalingH", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "scrollbarBgSpriteH", "Lnet/minecraft/resources/ResourceLocation;", "grabberScalingH", "grabberNormalH", "grabberHoveredH", "grabberHeldH", "scrollbarBgScalingV", "scrollbarBgSpriteV", "grabberScalingV", "grabberNormalV", "grabberHoveredV", "grabberHeldV", "scrollbarThicknessH", "", "scrollbarThicknessV", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;Lnet/minecraft/resources/ResourceLocation;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;Lnet/minecraft/resources/ResourceLocation;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;II)V", "h", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SliderSettings;", "v", "(Lnet/thebrokenscript/brokencore/api/client/gui/settings/SliderSettings;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SliderSettings;II)V", "getScrollbarBgScalingH", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "getScrollbarBgSpriteH", "()Lnet/minecraft/resources/ResourceLocation;", "getGrabberScalingH", "getGrabberNormalH", "getGrabberHoveredH", "getGrabberHeldH", "getScrollbarBgScalingV", "getScrollbarBgSpriteV", "getGrabberScalingV", "getGrabberNormalV", "getGrabberHoveredV", "getGrabberHeldV", "getScrollbarThicknessH", "()I", "getScrollbarThicknessV", "create", "Lnet/thebrokenscript/brokencore/api/client/gui/container/ScrollContainer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "", "other", "hashCode", "toString", "", "brokencore-common"})
public final class ScrollContainerSettings {
    @NotNull
    private final SpriteScalingSettings scrollbarBgScalingH;
    @NotNull
    private final ResourceLocation scrollbarBgSpriteH;
    @NotNull
    private final SpriteScalingSettings grabberScalingH;
    @NotNull
    private final ResourceLocation grabberNormalH;
    @NotNull
    private final ResourceLocation grabberHoveredH;
    @NotNull
    private final ResourceLocation grabberHeldH;
    @NotNull
    private final SpriteScalingSettings scrollbarBgScalingV;
    @NotNull
    private final ResourceLocation scrollbarBgSpriteV;
    @NotNull
    private final SpriteScalingSettings grabberScalingV;
    @NotNull
    private final ResourceLocation grabberNormalV;
    @NotNull
    private final ResourceLocation grabberHoveredV;
    @NotNull
    private final ResourceLocation grabberHeldV;
    private final int scrollbarThicknessH;
    private final int scrollbarThicknessV;

    public ScrollContainerSettings(@NotNull SpriteScalingSettings scrollbarBgScalingH, @NotNull ResourceLocation scrollbarBgSpriteH, @NotNull SpriteScalingSettings grabberScalingH, @NotNull ResourceLocation grabberNormalH, @NotNull ResourceLocation grabberHoveredH, @NotNull ResourceLocation grabberHeldH, @NotNull SpriteScalingSettings scrollbarBgScalingV, @NotNull ResourceLocation scrollbarBgSpriteV, @NotNull SpriteScalingSettings grabberScalingV, @NotNull ResourceLocation grabberNormalV, @NotNull ResourceLocation grabberHoveredV, @NotNull ResourceLocation grabberHeldV, int scrollbarThicknessH, int scrollbarThicknessV) {
        Intrinsics.checkNotNullParameter((Object)scrollbarBgScalingH, (String)"scrollbarBgScalingH");
        Intrinsics.checkNotNullParameter((Object)scrollbarBgSpriteH, (String)"scrollbarBgSpriteH");
        Intrinsics.checkNotNullParameter((Object)grabberScalingH, (String)"grabberScalingH");
        Intrinsics.checkNotNullParameter((Object)grabberNormalH, (String)"grabberNormalH");
        Intrinsics.checkNotNullParameter((Object)grabberHoveredH, (String)"grabberHoveredH");
        Intrinsics.checkNotNullParameter((Object)grabberHeldH, (String)"grabberHeldH");
        Intrinsics.checkNotNullParameter((Object)scrollbarBgScalingV, (String)"scrollbarBgScalingV");
        Intrinsics.checkNotNullParameter((Object)scrollbarBgSpriteV, (String)"scrollbarBgSpriteV");
        Intrinsics.checkNotNullParameter((Object)grabberScalingV, (String)"grabberScalingV");
        Intrinsics.checkNotNullParameter((Object)grabberNormalV, (String)"grabberNormalV");
        Intrinsics.checkNotNullParameter((Object)grabberHoveredV, (String)"grabberHoveredV");
        Intrinsics.checkNotNullParameter((Object)grabberHeldV, (String)"grabberHeldV");
        this.scrollbarBgScalingH = scrollbarBgScalingH;
        this.scrollbarBgSpriteH = scrollbarBgSpriteH;
        this.grabberScalingH = grabberScalingH;
        this.grabberNormalH = grabberNormalH;
        this.grabberHoveredH = grabberHoveredH;
        this.grabberHeldH = grabberHeldH;
        this.scrollbarBgScalingV = scrollbarBgScalingV;
        this.scrollbarBgSpriteV = scrollbarBgSpriteV;
        this.grabberScalingV = grabberScalingV;
        this.grabberNormalV = grabberNormalV;
        this.grabberHoveredV = grabberHoveredV;
        this.grabberHeldV = grabberHeldV;
        this.scrollbarThicknessH = scrollbarThicknessH;
        this.scrollbarThicknessV = scrollbarThicknessV;
    }

    @NotNull
    public final SpriteScalingSettings getScrollbarBgScalingH() {
        return this.scrollbarBgScalingH;
    }

    @NotNull
    public final ResourceLocation getScrollbarBgSpriteH() {
        return this.scrollbarBgSpriteH;
    }

    @NotNull
    public final SpriteScalingSettings getGrabberScalingH() {
        return this.grabberScalingH;
    }

    @NotNull
    public final ResourceLocation getGrabberNormalH() {
        return this.grabberNormalH;
    }

    @NotNull
    public final ResourceLocation getGrabberHoveredH() {
        return this.grabberHoveredH;
    }

    @NotNull
    public final ResourceLocation getGrabberHeldH() {
        return this.grabberHeldH;
    }

    @NotNull
    public final SpriteScalingSettings getScrollbarBgScalingV() {
        return this.scrollbarBgScalingV;
    }

    @NotNull
    public final ResourceLocation getScrollbarBgSpriteV() {
        return this.scrollbarBgSpriteV;
    }

    @NotNull
    public final SpriteScalingSettings getGrabberScalingV() {
        return this.grabberScalingV;
    }

    @NotNull
    public final ResourceLocation getGrabberNormalV() {
        return this.grabberNormalV;
    }

    @NotNull
    public final ResourceLocation getGrabberHoveredV() {
        return this.grabberHoveredV;
    }

    @NotNull
    public final ResourceLocation getGrabberHeldV() {
        return this.grabberHeldV;
    }

    public final int getScrollbarThicknessH() {
        return this.scrollbarThicknessH;
    }

    public final int getScrollbarThicknessV() {
        return this.scrollbarThicknessV;
    }

    public ScrollContainerSettings(@NotNull SliderSettings h, @NotNull SliderSettings v, int scrollbarThicknessH, int scrollbarThicknessV) {
        Intrinsics.checkNotNullParameter((Object)h, (String)"h");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this(h.getBgScaling(), h.getBgSprite(), h.getGrabberScaling(), h.getGrabberNormal(), h.getGrabberHovered(), h.getGrabberHeld(), v.getBgScaling(), v.getBgSprite(), v.getGrabberScaling(), v.getGrabberNormal(), v.getGrabberHovered(), v.getGrabberHeld(), scrollbarThicknessH, scrollbarThicknessV);
    }

    @NotNull
    public final ScrollContainer create() {
        return new ScrollContainer(this);
    }

    @NotNull
    public final SpriteScalingSettings component1() {
        return this.scrollbarBgScalingH;
    }

    @NotNull
    public final ResourceLocation component2() {
        return this.scrollbarBgSpriteH;
    }

    @NotNull
    public final SpriteScalingSettings component3() {
        return this.grabberScalingH;
    }

    @NotNull
    public final ResourceLocation component4() {
        return this.grabberNormalH;
    }

    @NotNull
    public final ResourceLocation component5() {
        return this.grabberHoveredH;
    }

    @NotNull
    public final ResourceLocation component6() {
        return this.grabberHeldH;
    }

    @NotNull
    public final SpriteScalingSettings component7() {
        return this.scrollbarBgScalingV;
    }

    @NotNull
    public final ResourceLocation component8() {
        return this.scrollbarBgSpriteV;
    }

    @NotNull
    public final SpriteScalingSettings component9() {
        return this.grabberScalingV;
    }

    @NotNull
    public final ResourceLocation component10() {
        return this.grabberNormalV;
    }

    @NotNull
    public final ResourceLocation component11() {
        return this.grabberHoveredV;
    }

    @NotNull
    public final ResourceLocation component12() {
        return this.grabberHeldV;
    }

    public final int component13() {
        return this.scrollbarThicknessH;
    }

    public final int component14() {
        return this.scrollbarThicknessV;
    }

    @NotNull
    public final ScrollContainerSettings copy(@NotNull SpriteScalingSettings scrollbarBgScalingH, @NotNull ResourceLocation scrollbarBgSpriteH, @NotNull SpriteScalingSettings grabberScalingH, @NotNull ResourceLocation grabberNormalH, @NotNull ResourceLocation grabberHoveredH, @NotNull ResourceLocation grabberHeldH, @NotNull SpriteScalingSettings scrollbarBgScalingV, @NotNull ResourceLocation scrollbarBgSpriteV, @NotNull SpriteScalingSettings grabberScalingV, @NotNull ResourceLocation grabberNormalV, @NotNull ResourceLocation grabberHoveredV, @NotNull ResourceLocation grabberHeldV, int scrollbarThicknessH, int scrollbarThicknessV) {
        Intrinsics.checkNotNullParameter((Object)scrollbarBgScalingH, (String)"scrollbarBgScalingH");
        Intrinsics.checkNotNullParameter((Object)scrollbarBgSpriteH, (String)"scrollbarBgSpriteH");
        Intrinsics.checkNotNullParameter((Object)grabberScalingH, (String)"grabberScalingH");
        Intrinsics.checkNotNullParameter((Object)grabberNormalH, (String)"grabberNormalH");
        Intrinsics.checkNotNullParameter((Object)grabberHoveredH, (String)"grabberHoveredH");
        Intrinsics.checkNotNullParameter((Object)grabberHeldH, (String)"grabberHeldH");
        Intrinsics.checkNotNullParameter((Object)scrollbarBgScalingV, (String)"scrollbarBgScalingV");
        Intrinsics.checkNotNullParameter((Object)scrollbarBgSpriteV, (String)"scrollbarBgSpriteV");
        Intrinsics.checkNotNullParameter((Object)grabberScalingV, (String)"grabberScalingV");
        Intrinsics.checkNotNullParameter((Object)grabberNormalV, (String)"grabberNormalV");
        Intrinsics.checkNotNullParameter((Object)grabberHoveredV, (String)"grabberHoveredV");
        Intrinsics.checkNotNullParameter((Object)grabberHeldV, (String)"grabberHeldV");
        return new ScrollContainerSettings(scrollbarBgScalingH, scrollbarBgSpriteH, grabberScalingH, grabberNormalH, grabberHoveredH, grabberHeldH, scrollbarBgScalingV, scrollbarBgSpriteV, grabberScalingV, grabberNormalV, grabberHoveredV, grabberHeldV, scrollbarThicknessH, scrollbarThicknessV);
    }

    public static /* synthetic */ ScrollContainerSettings copy$default(ScrollContainerSettings scrollContainerSettings, SpriteScalingSettings spriteScalingSettings, ResourceLocation resourceLocation, SpriteScalingSettings spriteScalingSettings2, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, ResourceLocation resourceLocation4, SpriteScalingSettings spriteScalingSettings3, ResourceLocation resourceLocation5, SpriteScalingSettings spriteScalingSettings4, ResourceLocation resourceLocation6, ResourceLocation resourceLocation7, ResourceLocation resourceLocation8, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            spriteScalingSettings = scrollContainerSettings.scrollbarBgScalingH;
        }
        if ((n3 & 2) != 0) {
            resourceLocation = scrollContainerSettings.scrollbarBgSpriteH;
        }
        if ((n3 & 4) != 0) {
            spriteScalingSettings2 = scrollContainerSettings.grabberScalingH;
        }
        if ((n3 & 8) != 0) {
            resourceLocation2 = scrollContainerSettings.grabberNormalH;
        }
        if ((n3 & 0x10) != 0) {
            resourceLocation3 = scrollContainerSettings.grabberHoveredH;
        }
        if ((n3 & 0x20) != 0) {
            resourceLocation4 = scrollContainerSettings.grabberHeldH;
        }
        if ((n3 & 0x40) != 0) {
            spriteScalingSettings3 = scrollContainerSettings.scrollbarBgScalingV;
        }
        if ((n3 & 0x80) != 0) {
            resourceLocation5 = scrollContainerSettings.scrollbarBgSpriteV;
        }
        if ((n3 & 0x100) != 0) {
            spriteScalingSettings4 = scrollContainerSettings.grabberScalingV;
        }
        if ((n3 & 0x200) != 0) {
            resourceLocation6 = scrollContainerSettings.grabberNormalV;
        }
        if ((n3 & 0x400) != 0) {
            resourceLocation7 = scrollContainerSettings.grabberHoveredV;
        }
        if ((n3 & 0x800) != 0) {
            resourceLocation8 = scrollContainerSettings.grabberHeldV;
        }
        if ((n3 & 0x1000) != 0) {
            n = scrollContainerSettings.scrollbarThicknessH;
        }
        if ((n3 & 0x2000) != 0) {
            n2 = scrollContainerSettings.scrollbarThicknessV;
        }
        return scrollContainerSettings.copy(spriteScalingSettings, resourceLocation, spriteScalingSettings2, resourceLocation2, resourceLocation3, resourceLocation4, spriteScalingSettings3, resourceLocation5, spriteScalingSettings4, resourceLocation6, resourceLocation7, resourceLocation8, n, n2);
    }

    @NotNull
    public String toString() {
        return "ScrollContainerSettings(scrollbarBgScalingH=" + this.scrollbarBgScalingH + ", scrollbarBgSpriteH=" + this.scrollbarBgSpriteH + ", grabberScalingH=" + this.grabberScalingH + ", grabberNormalH=" + this.grabberNormalH + ", grabberHoveredH=" + this.grabberHoveredH + ", grabberHeldH=" + this.grabberHeldH + ", scrollbarBgScalingV=" + this.scrollbarBgScalingV + ", scrollbarBgSpriteV=" + this.scrollbarBgSpriteV + ", grabberScalingV=" + this.grabberScalingV + ", grabberNormalV=" + this.grabberNormalV + ", grabberHoveredV=" + this.grabberHoveredV + ", grabberHeldV=" + this.grabberHeldV + ", scrollbarThicknessH=" + this.scrollbarThicknessH + ", scrollbarThicknessV=" + this.scrollbarThicknessV + ")";
    }

    public int hashCode() {
        int result = this.scrollbarBgScalingH.hashCode();
        result = result * 31 + this.scrollbarBgSpriteH.hashCode();
        result = result * 31 + this.grabberScalingH.hashCode();
        result = result * 31 + this.grabberNormalH.hashCode();
        result = result * 31 + this.grabberHoveredH.hashCode();
        result = result * 31 + this.grabberHeldH.hashCode();
        result = result * 31 + this.scrollbarBgScalingV.hashCode();
        result = result * 31 + this.scrollbarBgSpriteV.hashCode();
        result = result * 31 + this.grabberScalingV.hashCode();
        result = result * 31 + this.grabberNormalV.hashCode();
        result = result * 31 + this.grabberHoveredV.hashCode();
        result = result * 31 + this.grabberHeldV.hashCode();
        result = result * 31 + Integer.hashCode(this.scrollbarThicknessH);
        result = result * 31 + Integer.hashCode(this.scrollbarThicknessV);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScrollContainerSettings)) {
            return false;
        }
        ScrollContainerSettings scrollContainerSettings = (ScrollContainerSettings)other;
        if (!Intrinsics.areEqual((Object)this.scrollbarBgScalingH, (Object)scrollContainerSettings.scrollbarBgScalingH)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.scrollbarBgSpriteH, (Object)scrollContainerSettings.scrollbarBgSpriteH)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.grabberScalingH, (Object)scrollContainerSettings.grabberScalingH)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.grabberNormalH, (Object)scrollContainerSettings.grabberNormalH)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.grabberHoveredH, (Object)scrollContainerSettings.grabberHoveredH)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.grabberHeldH, (Object)scrollContainerSettings.grabberHeldH)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.scrollbarBgScalingV, (Object)scrollContainerSettings.scrollbarBgScalingV)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.scrollbarBgSpriteV, (Object)scrollContainerSettings.scrollbarBgSpriteV)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.grabberScalingV, (Object)scrollContainerSettings.grabberScalingV)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.grabberNormalV, (Object)scrollContainerSettings.grabberNormalV)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.grabberHoveredV, (Object)scrollContainerSettings.grabberHoveredV)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.grabberHeldV, (Object)scrollContainerSettings.grabberHeldV)) {
            return false;
        }
        if (this.scrollbarThicknessH != scrollContainerSettings.scrollbarThicknessH) {
            return false;
        }
        return this.scrollbarThicknessV == scrollContainerSettings.scrollbarThicknessV;
    }
}

