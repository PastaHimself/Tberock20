/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.chat.Style
 *  net.minecraft.network.chat.TextColor
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.client.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 72\u00020\u0001:\u00017B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010#\u001a\u00020$J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\t\u0010'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010,\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010-\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010.\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u0086\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00c6\u0001\u00a2\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00104\u001a\u00020\u0003H\u00d6\u0001J\t\u00105\u001a\u000206H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001cR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b \u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"\u00a8\u00068"}, d2={"Lnet/thebrokenscript/client/util/LibraryTextUtils;", "", "color", "", "italic", "", "bold", "underlined", "strikethrough", "obfuscated", "angle", "", "scale", "xOffset", "yOffset", "textFont", "Lnet/minecraft/resources/ResourceLocation;", "<init>", "(IZZZZZLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lnet/minecraft/resources/ResourceLocation;)V", "getColor", "()I", "getItalic", "()Z", "getBold", "getUnderlined", "getStrikethrough", "getObfuscated", "getAngle", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getScale", "getXOffset", "getYOffset", "getTextFont", "()Lnet/minecraft/resources/ResourceLocation;", "toStyle", "Lnet/minecraft/network/chat/Style;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(IZZZZZLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lnet/minecraft/resources/ResourceLocation;)Lnet/thebrokenscript/client/util/LibraryTextUtils;", "equals", "other", "hashCode", "toString", "", "Companion", "thebrokenscript-common"})
public final class LibraryTextUtils {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int color;
    private final boolean italic;
    private final boolean bold;
    private final boolean underlined;
    private final boolean strikethrough;
    private final boolean obfuscated;
    @Nullable
    private final Float angle;
    @Nullable
    private final Float scale;
    @Nullable
    private final Float xOffset;
    @Nullable
    private final Float yOffset;
    @Nullable
    private final ResourceLocation textFont;

    public LibraryTextUtils(int color, boolean italic, boolean bold, boolean underlined, boolean strikethrough, boolean obfuscated, @Nullable Float angle, @Nullable Float scale, @Nullable Float xOffset, @Nullable Float yOffset, @Nullable ResourceLocation textFont) {
        this.color = color;
        this.italic = italic;
        this.bold = bold;
        this.underlined = underlined;
        this.strikethrough = strikethrough;
        this.obfuscated = obfuscated;
        this.angle = angle;
        this.scale = scale;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.textFont = textFont;
    }

    public /* synthetic */ LibraryTextUtils(int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, Float f, Float f2, Float f3, Float f4, ResourceLocation resourceLocation, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            n = 0xFFFFFF;
        }
        if ((n2 & 2) != 0) {
            bl = false;
        }
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        if ((n2 & 8) != 0) {
            bl3 = false;
        }
        if ((n2 & 0x10) != 0) {
            bl4 = false;
        }
        if ((n2 & 0x20) != 0) {
            bl5 = false;
        }
        if ((n2 & 0x40) != 0) {
            f = null;
        }
        if ((n2 & 0x80) != 0) {
            f2 = null;
        }
        if ((n2 & 0x100) != 0) {
            f3 = null;
        }
        if ((n2 & 0x200) != 0) {
            f4 = null;
        }
        if ((n2 & 0x400) != 0) {
            resourceLocation = null;
        }
        this(n, bl, bl2, bl3, bl4, bl5, f, f2, f3, f4, resourceLocation);
    }

    public final int getColor() {
        return this.color;
    }

    public final boolean getItalic() {
        return this.italic;
    }

    public final boolean getBold() {
        return this.bold;
    }

    public final boolean getUnderlined() {
        return this.underlined;
    }

    public final boolean getStrikethrough() {
        return this.strikethrough;
    }

    public final boolean getObfuscated() {
        return this.obfuscated;
    }

    @Nullable
    public final Float getAngle() {
        return this.angle;
    }

    @Nullable
    public final Float getScale() {
        return this.scale;
    }

    @Nullable
    public final Float getXOffset() {
        return this.xOffset;
    }

    @Nullable
    public final Float getYOffset() {
        return this.yOffset;
    }

    @Nullable
    public final ResourceLocation getTextFont() {
        return this.textFont;
    }

    @NotNull
    public final Style toStyle() {
        Style style = Style.EMPTY.withBold(Boolean.valueOf(this.bold)).withItalic(Boolean.valueOf(this.italic)).withUnderlined(Boolean.valueOf(this.underlined)).withStrikethrough(Boolean.valueOf(this.strikethrough)).withObfuscated(Boolean.valueOf(this.obfuscated)).withFont(this.textFont);
        Intrinsics.checkNotNullExpressionValue((Object)style, (String)"withFont(...)");
        return style;
    }

    public final int component1() {
        return this.color;
    }

    public final boolean component2() {
        return this.italic;
    }

    public final boolean component3() {
        return this.bold;
    }

    public final boolean component4() {
        return this.underlined;
    }

    public final boolean component5() {
        return this.strikethrough;
    }

    public final boolean component6() {
        return this.obfuscated;
    }

    @Nullable
    public final Float component7() {
        return this.angle;
    }

    @Nullable
    public final Float component8() {
        return this.scale;
    }

    @Nullable
    public final Float component9() {
        return this.xOffset;
    }

    @Nullable
    public final Float component10() {
        return this.yOffset;
    }

    @Nullable
    public final ResourceLocation component11() {
        return this.textFont;
    }

    @NotNull
    public final LibraryTextUtils copy(int color, boolean italic, boolean bold, boolean underlined, boolean strikethrough, boolean obfuscated, @Nullable Float angle, @Nullable Float scale, @Nullable Float xOffset, @Nullable Float yOffset, @Nullable ResourceLocation textFont) {
        return new LibraryTextUtils(color, italic, bold, underlined, strikethrough, obfuscated, angle, scale, xOffset, yOffset, textFont);
    }

    public static /* synthetic */ LibraryTextUtils copy$default(LibraryTextUtils libraryTextUtils, int n, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, Float f, Float f2, Float f3, Float f4, ResourceLocation resourceLocation, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = libraryTextUtils.color;
        }
        if ((n2 & 2) != 0) {
            bl = libraryTextUtils.italic;
        }
        if ((n2 & 4) != 0) {
            bl2 = libraryTextUtils.bold;
        }
        if ((n2 & 8) != 0) {
            bl3 = libraryTextUtils.underlined;
        }
        if ((n2 & 0x10) != 0) {
            bl4 = libraryTextUtils.strikethrough;
        }
        if ((n2 & 0x20) != 0) {
            bl5 = libraryTextUtils.obfuscated;
        }
        if ((n2 & 0x40) != 0) {
            f = libraryTextUtils.angle;
        }
        if ((n2 & 0x80) != 0) {
            f2 = libraryTextUtils.scale;
        }
        if ((n2 & 0x100) != 0) {
            f3 = libraryTextUtils.xOffset;
        }
        if ((n2 & 0x200) != 0) {
            f4 = libraryTextUtils.yOffset;
        }
        if ((n2 & 0x400) != 0) {
            resourceLocation = libraryTextUtils.textFont;
        }
        return libraryTextUtils.copy(n, bl, bl2, bl3, bl4, bl5, f, f2, f3, f4, resourceLocation);
    }

    @NotNull
    public String toString() {
        return "LibraryTextUtils(color=" + this.color + ", italic=" + this.italic + ", bold=" + this.bold + ", underlined=" + this.underlined + ", strikethrough=" + this.strikethrough + ", obfuscated=" + this.obfuscated + ", angle=" + this.angle + ", scale=" + this.scale + ", xOffset=" + this.xOffset + ", yOffset=" + this.yOffset + ", textFont=" + this.textFont + ")";
    }

    public int hashCode() {
        int result = Integer.hashCode(this.color);
        result = result * 31 + Boolean.hashCode(this.italic);
        result = result * 31 + Boolean.hashCode(this.bold);
        result = result * 31 + Boolean.hashCode(this.underlined);
        result = result * 31 + Boolean.hashCode(this.strikethrough);
        result = result * 31 + Boolean.hashCode(this.obfuscated);
        result = result * 31 + (this.angle == null ? 0 : ((Object)this.angle).hashCode());
        result = result * 31 + (this.scale == null ? 0 : ((Object)this.scale).hashCode());
        result = result * 31 + (this.xOffset == null ? 0 : ((Object)this.xOffset).hashCode());
        result = result * 31 + (this.yOffset == null ? 0 : ((Object)this.yOffset).hashCode());
        result = result * 31 + (this.textFont == null ? 0 : this.textFont.hashCode());
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LibraryTextUtils)) {
            return false;
        }
        LibraryTextUtils libraryTextUtils = (LibraryTextUtils)other;
        if (this.color != libraryTextUtils.color) {
            return false;
        }
        if (this.italic != libraryTextUtils.italic) {
            return false;
        }
        if (this.bold != libraryTextUtils.bold) {
            return false;
        }
        if (this.underlined != libraryTextUtils.underlined) {
            return false;
        }
        if (this.strikethrough != libraryTextUtils.strikethrough) {
            return false;
        }
        if (this.obfuscated != libraryTextUtils.obfuscated) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.angle, (Object)libraryTextUtils.angle)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.scale, (Object)libraryTextUtils.scale)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.xOffset, (Object)libraryTextUtils.xOffset)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.yOffset, (Object)libraryTextUtils.yOffset)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.textFont, (Object)libraryTextUtils.textFont);
    }

    public LibraryTextUtils() {
        this(0, false, false, false, false, false, null, null, null, null, null, 2047, null);
    }

    @JvmStatic
    @NotNull
    public static final LibraryTextUtils fromStyle(@NotNull Style style) {
        return Companion.fromStyle(style);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/client/util/LibraryTextUtils$Companion;", "", "<init>", "()V", "fromStyle", "Lnet/thebrokenscript/client/util/LibraryTextUtils;", "style", "Lnet/minecraft/network/chat/Style;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final LibraryTextUtils fromStyle(@NotNull Style style) {
            Intrinsics.checkNotNullParameter((Object)style, (String)"style");
            TextColor textColor = style.getColor();
            return new LibraryTextUtils(textColor != null ? textColor.getValue() : 0xFFFFFF, style.isItalic(), style.isBold(), style.isUnderlined(), style.isStrikethrough(), style.isObfuscated(), null, null, null, null, style.getFont(), 960, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

