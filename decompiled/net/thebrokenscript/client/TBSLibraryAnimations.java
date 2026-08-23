/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.math.Axis
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 *  kotlin.random.Random
 *  kotlin.random.RandomKt
 *  kotlin.ranges.RangesKt
 *  net.minecraft.client.gui.Font
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.chat.Style
 *  net.minecraft.util.FormattedCharSequence
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client;

import com.mojang.math.Axis;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.RangesKt;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;
import net.thebrokenscript.client.NoisyScreenChar;
import net.thebrokenscript.client.util.LibraryTextUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J@\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012J@\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012J8\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u0012J>\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u0012J>\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ6\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J6\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J6\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\rJ\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J.\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010'\u001a\u00020(R\u000e\u0010$\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2={"Lnet/thebrokenscript/client/TBSLibraryAnimations;", "", "<init>", "()V", "jitteryText", "", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "text", "", "font", "Lnet/minecraft/client/gui/Font;", "x", "", "y", "time", "", "style", "Lnet/thebrokenscript/client/util/LibraryTextUtils;", "Lnet/minecraft/util/FormattedCharSequence;", "simpleText", "simpleTextStack", "", "clockText", "second", "minute", "hour", "heartText", "lungText", "noisyText", "gameTime", "", "minX", "minY", "maxX", "maxY", "RANDOM_CHAR_POOL", "randomChar", "", "random", "Lkotlin/random/Random;", "createNoisyChar", "Lnet/thebrokenscript/client/NoisyScreenChar;", "thebrokenscript-common"})
public final class TBSLibraryAnimations {
    @NotNull
    public static final TBSLibraryAnimations INSTANCE = new TBSLibraryAnimations();
    @NotNull
    private static final String RANDOM_CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-=_+[]{};:'\",.<>/?\\|`~";

    private TBSLibraryAnimations() {
    }

    public final void jitteryText(@NotNull GuiGraphics guiGraphics, @NotNull String text, @NotNull Font font, int x, int y, float time, @NotNull LibraryTextUtils style) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter((Object)font, (String)"font");
        Intrinsics.checkNotNullParameter((Object)style, (String)"style");
        FormattedCharSequence formattedCharSequence = FormattedCharSequence.forward((String)text, (Style)Style.EMPTY);
        Intrinsics.checkNotNullExpressionValue((Object)formattedCharSequence, (String)"forward(...)");
        this.jitteryText(guiGraphics, formattedCharSequence, font, x, y, time, style);
    }

    public static /* synthetic */ void jitteryText$default(TBSLibraryAnimations tBSLibraryAnimations, GuiGraphics guiGraphics, String string, Font font, int n, int n2, float f, LibraryTextUtils libraryTextUtils, int n3, Object object) {
        if ((n3 & 0x40) != 0) {
            libraryTextUtils = new LibraryTextUtils(0, false, false, false, false, false, null, null, null, null, null, 2047, null);
        }
        tBSLibraryAnimations.jitteryText(guiGraphics, string, font, n, n2, f, libraryTextUtils);
    }

    public final void jitteryText(@NotNull GuiGraphics guiGraphics, @NotNull FormattedCharSequence text, @NotNull Font font, int x, int y, float time, @NotNull LibraryTextUtils style) {
        boolean needsFixing;
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter((Object)font, (String)"font");
        Intrinsics.checkNotNullParameter((Object)style, (String)"style");
        guiGraphics.pose().pushPose();
        boolean bl = needsFixing = style.getAngle() != null || style.getScale() != null;
        if (needsFixing) {
            guiGraphics.pose().translate((float)x, (float)y, 0.0f);
            if (style.getAngle() != null) {
                guiGraphics.pose().mulPose(Axis.ZP.rotationDegrees(style.getAngle().floatValue()));
            }
            if (style.getScale() != null) {
                guiGraphics.pose().scale(style.getScale().floatValue(), style.getScale().floatValue(), 1.0f);
            }
        }
        Ref.IntRef cursor = new Ref.IntRef();
        cursor.element = needsFixing ? 0 : x;
        text.accept((arg_0, arg_1, arg_2) -> TBSLibraryAnimations.jitteryText$lambda$0(time, style, y, guiGraphics, font, cursor, arg_0, arg_1, arg_2));
        guiGraphics.pose().popPose();
    }

    public static /* synthetic */ void jitteryText$default(TBSLibraryAnimations tBSLibraryAnimations, GuiGraphics guiGraphics, FormattedCharSequence formattedCharSequence, Font font, int n, int n2, float f, LibraryTextUtils libraryTextUtils, int n3, Object object) {
        if ((n3 & 0x40) != 0) {
            libraryTextUtils = new LibraryTextUtils(0, false, false, false, false, false, null, null, null, null, null, 2047, null);
        }
        tBSLibraryAnimations.jitteryText(guiGraphics, formattedCharSequence, font, n, n2, f, libraryTextUtils);
    }

    public final void simpleText(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull String text, int x, int y, @NotNull LibraryTextUtils style) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Intrinsics.checkNotNullParameter((Object)font, (String)"font");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        Intrinsics.checkNotNullParameter((Object)style, (String)"style");
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate((float)x, (float)y, 0.0f);
        if (style.getAngle() != null) {
            guiGraphics.pose().mulPose(Axis.ZP.rotationDegrees(style.getAngle().floatValue()));
        }
        if (style.getScale() != null) {
            guiGraphics.pose().scale(style.getScale().floatValue(), style.getScale().floatValue(), 1.0f);
        }
        MutableComponent component = Component.literal((String)text).withStyle(style.toStyle());
        guiGraphics.drawString(font, (Component)component, 0, 0, style.getColor(), false);
        guiGraphics.pose().popPose();
    }

    public static /* synthetic */ void simpleText$default(TBSLibraryAnimations tBSLibraryAnimations, GuiGraphics guiGraphics, Font font, String string, int n, int n2, LibraryTextUtils libraryTextUtils, int n3, Object object) {
        if ((n3 & 0x20) != 0) {
            libraryTextUtils = new LibraryTextUtils(0, false, false, false, false, false, null, null, null, null, null, 2047, null);
        }
        tBSLibraryAnimations.simpleText(guiGraphics, font, string, n, n2, libraryTextUtils);
    }

    public final void simpleTextStack(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull List<String> text, int x, int y, @NotNull LibraryTextUtils style) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Intrinsics.checkNotNullParameter((Object)font, (String)"font");
        Intrinsics.checkNotNullParameter(text, (String)"text");
        Intrinsics.checkNotNullParameter((Object)style, (String)"style");
        Iterator iterator = ((Iterable)text).iterator();
        int n = 0;
        while (iterator.hasNext()) {
            int i = n++;
            String word = (String)iterator.next();
            int textWidth = font.width(word);
            int textHeight = font.lineHeight;
            float centerX = (float)x + (float)textWidth / 2.0f;
            float centerY = (float)y + (float)textHeight / 2.0f;
            Random random = RandomKt.Random((long)((long)i * 12345L ^ (long)((Object)text).hashCode()));
            Float f = style.getXOffset();
            float xOff = f != null ? f.floatValue() : 65.0f;
            Float f2 = style.getYOffset();
            float yOff = f2 != null ? f2.floatValue() : 20.0f;
            Float f3 = style.getScale();
            float customScale = f3 != null ? f3.floatValue() : 0.84f;
            Float f4 = style.getAngle();
            float customAngle = f4 != null ? f4.floatValue() : 20.0f;
            float offsetX = random.nextFloat() * xOff;
            float offsetY = random.nextFloat() * yOff;
            float scale = customScale + random.nextFloat() * 0.16f;
            float angle = random.nextFloat() * customAngle;
            guiGraphics.pose().pushPose();
            guiGraphics.pose().translate(centerX + offsetX, centerY + offsetY, 0.0f);
            guiGraphics.pose().mulPose(Axis.ZP.rotationDegrees(angle * 1.5f));
            guiGraphics.pose().scale(scale, scale, 1.0f);
            MutableComponent component = Component.literal((String)word).withStyle(style.toStyle());
            guiGraphics.drawString(font, (Component)component, -textWidth / 2, -textHeight / 2, style.getColor(), false);
            guiGraphics.pose().popPose();
        }
    }

    public static /* synthetic */ void simpleTextStack$default(TBSLibraryAnimations tBSLibraryAnimations, GuiGraphics guiGraphics, Font font, List list, int n, int n2, LibraryTextUtils libraryTextUtils, int n3, Object object) {
        if ((n3 & 0x20) != 0) {
            libraryTextUtils = new LibraryTextUtils(0, false, false, false, false, false, null, null, null, null, null, 2047, null);
        }
        tBSLibraryAnimations.simpleTextStack(guiGraphics, font, list, n, n2, libraryTextUtils);
    }

    public final void clockText(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull String second, @NotNull String minute, @NotNull String hour, int x, int y) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Intrinsics.checkNotNullParameter((Object)font, (String)"font");
        Intrinsics.checkNotNullParameter((Object)second, (String)"second");
        Intrinsics.checkNotNullParameter((Object)minute, (String)"minute");
        Intrinsics.checkNotNullParameter((Object)hour, (String)"hour");
        LocalTime now = LocalTime.now();
        float secondAngle = (float)now.getSecond() * 6.0f;
        float minuteAngle = (float)now.getMinute() * 6.0f + (float)now.getSecond() * 0.1f;
        float hourAngle = (float)(now.getHour() % 12) * 30.0f + (float)now.getMinute() * 0.5f;
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate((float)x, (float)y, 0.0f);
        guiGraphics.pose().mulPose(Axis.ZP.rotationDegrees(secondAngle - 90.0f));
        guiGraphics.drawString(font, second, 8, -4, 0, false);
        guiGraphics.pose().popPose();
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate((float)x, (float)y, 0.0f);
        guiGraphics.pose().scale(0.85f, 0.85f, 0.85f);
        guiGraphics.pose().mulPose(Axis.ZP.rotationDegrees(minuteAngle - 90.0f));
        guiGraphics.drawString(font, minute, 6, -4, 0, false);
        guiGraphics.pose().popPose();
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate((float)x, (float)y, 0.0f);
        guiGraphics.pose().scale(0.7f, 0.7f, 0.7f);
        guiGraphics.pose().mulPose(Axis.ZP.rotationDegrees(hourAngle - 90.0f));
        guiGraphics.drawString(font, hour, 6, -4, 0, false);
        guiGraphics.pose().popPose();
    }

    public final void heartText(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull String text, int x, int y, float time) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Intrinsics.checkNotNullParameter((Object)font, (String)"font");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        float cycleLength = 1.6f;
        float f = time % cycleLength;
        float cyclePos = (!(f == 0.0f) && !(Math.signum(f) == Math.signum(cycleLength)) ? f + cycleLength : f) / cycleLength;
        float lubCenter = 0.05f;
        float dubCenter = 0.22f;
        float pulseWidth = 0.07f;
        float pulseStrength = RangesKt.coerceIn((float)(TBSLibraryAnimations.heartText$bump(cyclePos, pulseWidth, lubCenter) + TBSLibraryAnimations.heartText$bump(cyclePos, pulseWidth, dubCenter) * 0.75f), (float)0.0f, (float)1.0f);
        float maxScaleBoost = 0.26f;
        float scale = 1.0f + pulseStrength * maxScaleBoost;
        int textWidth = font.width(text);
        int textHeight = font.lineHeight;
        float centerX = (float)x + (float)textWidth / 2.0f;
        float centerY = (float)y + (float)textHeight / 2.0f;
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(centerX, centerY, 0.0f);
        guiGraphics.pose().scale(scale, scale, 1.0f);
        guiGraphics.drawString(font, text, -textWidth / 2, -textHeight / 2, 0, false);
        guiGraphics.pose().popPose();
    }

    public final void lungText(@NotNull GuiGraphics guiGraphics, @NotNull Font font, @NotNull String text, int x, int y, float time) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Intrinsics.checkNotNullParameter((Object)font, (String)"font");
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        float cycleLength = 4.0f;
        float f = time % cycleLength;
        float cyclePos = (!(f == 0.0f) && !(Math.signum(f) == Math.signum(cycleLength)) ? f + cycleLength : f) / cycleLength;
        float inhaleFraction = 0.4f;
        float angle = cyclePos < inhaleFraction ? cyclePos / inhaleFraction * (float)Math.PI : (float)Math.PI + (cyclePos - inhaleFraction) / (1.0f - inhaleFraction) * (float)Math.PI;
        float breath = (1.0f - (float)Math.cos(angle)) / 2.0f;
        float minScale = 1.0f;
        float maxScale = 1.12f;
        float scale = minScale + breath * (maxScale - minScale);
        int textWidth = font.width(text);
        int textHeight = font.lineHeight;
        float centerX = (float)x + (float)textWidth / 2.0f;
        float centerY = (float)y + (float)textHeight / 2.0f;
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(centerX, centerY, 0.0f);
        guiGraphics.pose().scale(scale, scale, 1.0f);
        guiGraphics.drawString(font, text, -textWidth / 2, -textHeight / 2, 0, false);
        guiGraphics.pose().popPose();
    }

    public final void noisyText(@NotNull GuiGraphics guiGraphics, long gameTime, int minX, int minY, int maxX, int maxY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        guiGraphics.pose().pushPose();
        Random random = RandomKt.Random((long)gameTime);
        int x = random.nextInt(minX, maxX);
        int y = random.nextInt(minY, maxY);
        int lifeTime = random.nextInt(100);
        int refreshRate = random.nextInt(7);
        guiGraphics.pose().popPose();
    }

    public final char randomChar(@NotNull Random random) {
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        return RANDOM_CHAR_POOL.charAt(random.nextInt(RANDOM_CHAR_POOL.length()));
    }

    @NotNull
    public final NoisyScreenChar createNoisyChar(int minX, int minY, int maxX, int maxY, @NotNull Random random) {
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        return new NoisyScreenChar(random.nextInt(minX, maxX), random.nextInt(minY, maxY), random.nextInt(30, 85), this.randomChar(random), random.nextInt(10, 20));
    }

    private static final boolean jitteryText$lambda$0(float $time, LibraryTextUtils $style, int $y, GuiGraphics $guiGraphics, Font $font, Ref.IntRef $cursor, int index, Style s, int n) {
        int cy;
        int seed = (int)($time * (float)10) * 1000 + index * 31 + n * 17;
        Random randumb = RandomKt.Random((long)seed);
        float xOffset = (randumb.nextFloat() * 2.0f - 1.0f) * 1.25f;
        float yOffset = (randumb.nextFloat() * 2.0f - 1.0f) * 1.25f;
        int n2 = cy = $style.getAngle() != null ? 0 : $y;
        if (n < 0 || n > 65535) {
            throw new IllegalArgumentException("Invalid Char code: " + n);
        }
        MutableComponent styled = Component.literal((String)String.valueOf((char)n)).withStyle($style.toStyle().applyTo(s));
        $guiGraphics.pose().pushPose();
        $guiGraphics.pose().translate(xOffset, yOffset, 0.0f);
        $guiGraphics.drawString($font, (Component)styled, $cursor.element, cy, $style.getColor(), false);
        $guiGraphics.pose().popPose();
        if (n < 0 || n > 65535) {
            throw new IllegalArgumentException("Invalid Char code: " + n);
        }
        $cursor.element += $font.width(String.valueOf((char)n)) + 1;
        return true;
    }

    private static final float heartText$bump(float cyclePos, float pulseWidth, float center) {
        float d = (cyclePos - center) / pulseWidth;
        return Math.abs(d) < 1.0f ? 1.0f - d * d : 0.0f;
    }
}

