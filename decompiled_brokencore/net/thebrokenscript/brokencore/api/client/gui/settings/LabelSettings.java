/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.network.chat.Style
 *  net.minecraft.util.FastColor$ARGB32
 *  net.minecraft.util.FormattedCharSequence
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.gui.settings;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FastColor;
import net.minecraft.util.FormattedCharSequence;
import net.thebrokenscript.brokencore.api.client.gui.label.FormattedLabel;
import net.thebrokenscript.brokencore.api.client.gui.label.Label;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u0000 T2\u00020\u0001:\u0001TB\u009d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)JF\u0010&\u001a\u00020*2\u0006\u0010(\u001a\u00020)26\u0010+\u001a2\u0012\u0013\u0012\u00110-\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(0\u0012\u0013\u0012\u001101\u00a2\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020)0,J\u000e\u00107\u001a\u00020-2\u0006\u0010(\u001a\u00020)J>\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020:2\u0006\u0010(\u001a\u00020)2\u0006\u0010;\u001a\u00020-2\u0006\u0010<\u001a\u00020-2\u0006\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020-2\u0006\u0010?\u001a\u00020-J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\u0003H\u00c6\u0003J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u000bH\u00c6\u0003J\t\u0010H\u001a\u00020\u000bH\u00c6\u0003J\t\u0010I\u001a\u00020\u000bH\u00c6\u0003J\t\u0010J\u001a\u00020\u000bH\u00c6\u0003J\t\u0010K\u001a\u00020\u000bH\u00c6\u0003J\t\u0010L\u001a\u00020\u000bH\u00c6\u0003J\t\u0010M\u001a\u00020\u000bH\u00c6\u0003J\t\u0010N\u001a\u00020\u000bH\u00c6\u0003J\u009f\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010P\u001a\u00020\u00032\b\u0010Q\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010R\u001a\u00020-H\u00d6\u0001J\t\u0010S\u001a\u00020)H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\u0011\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0011\u00103\u001a\u000204\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106\u00a8\u0006U"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;", "", "dropShadow", "", "bold", "italic", "underlined", "strikethrough", "obfuscated", "background", "r", "", "g", "b", "a", "bgR", "bgG", "bgB", "bgA", "<init>", "(ZZZZZZZFFFFFFFF)V", "getDropShadow", "()Z", "getBold", "getItalic", "getUnderlined", "getStrikethrough", "getObfuscated", "getBackground", "getR", "()F", "getG", "getB", "getA", "getBgR", "getBgG", "getBgB", "getBgA", "create", "Lnet/thebrokenscript/brokencore/api/client/gui/label/Label;", "text", "", "Lnet/thebrokenscript/brokencore/api/client/gui/label/FormattedLabel;", "formatter", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "", "char", "style", "Lnet/minecraft/network/chat/Style;", "getStyle", "()Lnet/minecraft/network/chat/Style;", "getTextWidth", "render", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "x", "y", "w", "h", "zIndex", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "toString", "Companion", "brokencore-common"})
public final class LabelSettings {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean dropShadow;
    private final boolean bold;
    private final boolean italic;
    private final boolean underlined;
    private final boolean strikethrough;
    private final boolean obfuscated;
    private final boolean background;
    private final float r;
    private final float g;
    private final float b;
    private final float a;
    private final float bgR;
    private final float bgG;
    private final float bgB;
    private final float bgA;
    @NotNull
    private final Style style;
    @NotNull
    private static final LabelSettings DEFAULT = new LabelSettings(false, false, false, false, false, false, false, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, Short.MAX_VALUE, null);

    public LabelSettings(boolean dropShadow, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated, boolean background, float r, float g, float b, float a, float bgR, float bgG, float bgB, float bgA) {
        this.dropShadow = dropShadow;
        this.bold = bold;
        this.italic = italic;
        this.underlined = underlined;
        this.strikethrough = strikethrough;
        this.obfuscated = obfuscated;
        this.background = background;
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
        this.bgR = bgR;
        this.bgG = bgG;
        this.bgB = bgB;
        this.bgA = bgA;
        Style style = Style.EMPTY.withBold(Boolean.valueOf(this.bold)).withItalic(Boolean.valueOf(this.italic)).withUnderlined(Boolean.valueOf(this.underlined)).withStrikethrough(Boolean.valueOf(this.strikethrough)).withObfuscated(Boolean.valueOf(this.obfuscated)).withColor(FastColor.ARGB32.colorFromFloat((float)this.a, (float)this.r, (float)this.g, (float)this.b));
        Intrinsics.checkNotNullExpressionValue((Object)style, (String)"withColor(...)");
        this.style = style;
    }

    public /* synthetic */ LabelSettings(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            bl = false;
        }
        if ((n & 2) != 0) {
            bl2 = false;
        }
        if ((n & 4) != 0) {
            bl3 = false;
        }
        if ((n & 8) != 0) {
            bl4 = false;
        }
        if ((n & 0x10) != 0) {
            bl5 = false;
        }
        if ((n & 0x20) != 0) {
            bl6 = false;
        }
        if ((n & 0x40) != 0) {
            bl7 = false;
        }
        if ((n & 0x80) != 0) {
            f = 1.0f;
        }
        if ((n & 0x100) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x200) != 0) {
            f3 = 1.0f;
        }
        if ((n & 0x400) != 0) {
            f4 = 1.0f;
        }
        if ((n & 0x800) != 0) {
            f5 = 0.0f;
        }
        if ((n & 0x1000) != 0) {
            f6 = 0.0f;
        }
        if ((n & 0x2000) != 0) {
            f7 = 0.0f;
        }
        if ((n & 0x4000) != 0) {
            f8 = 0.0f;
        }
        this(bl, bl2, bl3, bl4, bl5, bl6, bl7, f, f2, f3, f4, f5, f6, f7, f8);
    }

    public final boolean getDropShadow() {
        return this.dropShadow;
    }

    public final boolean getBold() {
        return this.bold;
    }

    public final boolean getItalic() {
        return this.italic;
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

    public final boolean getBackground() {
        return this.background;
    }

    public final float getR() {
        return this.r;
    }

    public final float getG() {
        return this.g;
    }

    public final float getB() {
        return this.b;
    }

    public final float getA() {
        return this.a;
    }

    public final float getBgR() {
        return this.bgR;
    }

    public final float getBgG() {
        return this.bgG;
    }

    public final float getBgB() {
        return this.bgB;
    }

    public final float getBgA() {
        return this.bgA;
    }

    @NotNull
    public final Label create(@NotNull String text) {
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        return new Label(text, this);
    }

    @NotNull
    public final FormattedLabel create(@NotNull String text, @NotNull Function2<? super Integer, ? super Character, String> formatter) {
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter(formatter, (String)"formatter");
        return new FormattedLabel(text, this, formatter);
    }

    @NotNull
    public final Style getStyle() {
        return this.style;
    }

    public final int getTextWidth(@NotNull String text) {
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        return ClientDSLKt.getMC().font.width(FormattedCharSequence.forward((String)text, (Style)this.style));
    }

    public final int render(@NotNull GuiGraphics guiGraphics, @NotNull String text, int x, int y, int w, int h, int zIndex) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(0.0f, 0.0f, (float)zIndex);
        guiGraphics.enableScissor(x, y, x + w, y + h);
        int width = guiGraphics.drawString(ClientDSLKt.getMC().font, text, x, y, FastColor.ARGB32.colorFromFloat((float)this.a, (float)this.r, (float)this.g, (float)this.b), this.dropShadow);
        if (this.background) {
            guiGraphics.fill(x - 2, y - 2, x + width + 2, y + 11, FastColor.ARGB32.colorFromFloat((float)this.bgA, (float)this.bgR, (float)this.bgG, (float)this.bgB));
        }
        guiGraphics.disableScissor();
        guiGraphics.pose().popPose();
        return width;
    }

    public final boolean component1() {
        return this.dropShadow;
    }

    public final boolean component2() {
        return this.bold;
    }

    public final boolean component3() {
        return this.italic;
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

    public final boolean component7() {
        return this.background;
    }

    public final float component8() {
        return this.r;
    }

    public final float component9() {
        return this.g;
    }

    public final float component10() {
        return this.b;
    }

    public final float component11() {
        return this.a;
    }

    public final float component12() {
        return this.bgR;
    }

    public final float component13() {
        return this.bgG;
    }

    public final float component14() {
        return this.bgB;
    }

    public final float component15() {
        return this.bgA;
    }

    @NotNull
    public final LabelSettings copy(boolean dropShadow, boolean bold, boolean italic, boolean underlined, boolean strikethrough, boolean obfuscated, boolean background, float r, float g, float b, float a, float bgR, float bgG, float bgB, float bgA) {
        return new LabelSettings(dropShadow, bold, italic, underlined, strikethrough, obfuscated, background, r, g, b, a, bgR, bgG, bgB, bgA);
    }

    public static /* synthetic */ LabelSettings copy$default(LabelSettings labelSettings, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n, Object object) {
        if ((n & 1) != 0) {
            bl = labelSettings.dropShadow;
        }
        if ((n & 2) != 0) {
            bl2 = labelSettings.bold;
        }
        if ((n & 4) != 0) {
            bl3 = labelSettings.italic;
        }
        if ((n & 8) != 0) {
            bl4 = labelSettings.underlined;
        }
        if ((n & 0x10) != 0) {
            bl5 = labelSettings.strikethrough;
        }
        if ((n & 0x20) != 0) {
            bl6 = labelSettings.obfuscated;
        }
        if ((n & 0x40) != 0) {
            bl7 = labelSettings.background;
        }
        if ((n & 0x80) != 0) {
            f = labelSettings.r;
        }
        if ((n & 0x100) != 0) {
            f2 = labelSettings.g;
        }
        if ((n & 0x200) != 0) {
            f3 = labelSettings.b;
        }
        if ((n & 0x400) != 0) {
            f4 = labelSettings.a;
        }
        if ((n & 0x800) != 0) {
            f5 = labelSettings.bgR;
        }
        if ((n & 0x1000) != 0) {
            f6 = labelSettings.bgG;
        }
        if ((n & 0x2000) != 0) {
            f7 = labelSettings.bgB;
        }
        if ((n & 0x4000) != 0) {
            f8 = labelSettings.bgA;
        }
        return labelSettings.copy(bl, bl2, bl3, bl4, bl5, bl6, bl7, f, f2, f3, f4, f5, f6, f7, f8);
    }

    @NotNull
    public String toString() {
        return "LabelSettings(dropShadow=" + this.dropShadow + ", bold=" + this.bold + ", italic=" + this.italic + ", underlined=" + this.underlined + ", strikethrough=" + this.strikethrough + ", obfuscated=" + this.obfuscated + ", background=" + this.background + ", r=" + this.r + ", g=" + this.g + ", b=" + this.b + ", a=" + this.a + ", bgR=" + this.bgR + ", bgG=" + this.bgG + ", bgB=" + this.bgB + ", bgA=" + this.bgA + ")";
    }

    public int hashCode() {
        int result = Boolean.hashCode(this.dropShadow);
        result = result * 31 + Boolean.hashCode(this.bold);
        result = result * 31 + Boolean.hashCode(this.italic);
        result = result * 31 + Boolean.hashCode(this.underlined);
        result = result * 31 + Boolean.hashCode(this.strikethrough);
        result = result * 31 + Boolean.hashCode(this.obfuscated);
        result = result * 31 + Boolean.hashCode(this.background);
        result = result * 31 + Float.hashCode(this.r);
        result = result * 31 + Float.hashCode(this.g);
        result = result * 31 + Float.hashCode(this.b);
        result = result * 31 + Float.hashCode(this.a);
        result = result * 31 + Float.hashCode(this.bgR);
        result = result * 31 + Float.hashCode(this.bgG);
        result = result * 31 + Float.hashCode(this.bgB);
        result = result * 31 + Float.hashCode(this.bgA);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LabelSettings)) {
            return false;
        }
        LabelSettings labelSettings = (LabelSettings)other;
        if (this.dropShadow != labelSettings.dropShadow) {
            return false;
        }
        if (this.bold != labelSettings.bold) {
            return false;
        }
        if (this.italic != labelSettings.italic) {
            return false;
        }
        if (this.underlined != labelSettings.underlined) {
            return false;
        }
        if (this.strikethrough != labelSettings.strikethrough) {
            return false;
        }
        if (this.obfuscated != labelSettings.obfuscated) {
            return false;
        }
        if (this.background != labelSettings.background) {
            return false;
        }
        if (Float.compare(this.r, labelSettings.r) != 0) {
            return false;
        }
        if (Float.compare(this.g, labelSettings.g) != 0) {
            return false;
        }
        if (Float.compare(this.b, labelSettings.b) != 0) {
            return false;
        }
        if (Float.compare(this.a, labelSettings.a) != 0) {
            return false;
        }
        if (Float.compare(this.bgR, labelSettings.bgR) != 0) {
            return false;
        }
        if (Float.compare(this.bgG, labelSettings.bgG) != 0) {
            return false;
        }
        if (Float.compare(this.bgB, labelSettings.bgB) != 0) {
            return false;
        }
        return Float.compare(this.bgA, labelSettings.bgA) == 0;
    }

    public LabelSettings() {
        this(false, false, false, false, false, false, false, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, Short.MAX_VALUE, null);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings$Companion;", "", "<init>", "()V", "DEFAULT", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;", "getDEFAULT", "()Lnet/thebrokenscript/brokencore/api/client/gui/settings/LabelSettings;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final LabelSettings getDEFAULT() {
            return DEFAULT;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

