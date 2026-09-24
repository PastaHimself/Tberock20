/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.math.MathKt
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.overlay;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/client/overlay/IntegBossBar;", "", "<init>", "()V", "value", "", "getValue", "()F", "setValue", "(F)V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "TEX_WIDTH", "", "TEX_HEIGHT", "TEX_BG", "Lnet/minecraft/resources/ResourceLocation;", "getTEX_BG", "()Lnet/minecraft/resources/ResourceLocation;", "TEX_BORDER", "getTEX_BORDER", "TEX_FILL", "getTEX_FILL", "TEX_OVERLAY", "getTEX_OVERLAY", "render", "", "gg", "Lnet/minecraft/client/gui/GuiGraphics;", "thebrokenscript-common"})
public final class IntegBossBar {
    @NotNull
    public static final IntegBossBar INSTANCE = new IntegBossBar();
    private static float value;
    private static boolean show;
    public static final int TEX_WIDTH = 200;
    public static final int TEX_HEIGHT = 27;
    @NotNull
    private static final ResourceLocation TEX_BG;
    @NotNull
    private static final ResourceLocation TEX_BORDER;
    @NotNull
    private static final ResourceLocation TEX_FILL;
    @NotNull
    private static final ResourceLocation TEX_OVERLAY;

    private IntegBossBar() {
    }

    public final float getValue() {
        return value;
    }

    public final void setValue(float f) {
        value = f;
    }

    public final boolean getShow() {
        return show;
    }

    public final void setShow(boolean bl) {
        show = bl;
    }

    @NotNull
    public final ResourceLocation getTEX_BG() {
        return TEX_BG;
    }

    @NotNull
    public final ResourceLocation getTEX_BORDER() {
        return TEX_BORDER;
    }

    @NotNull
    public final ResourceLocation getTEX_FILL() {
        return TEX_FILL;
    }

    @NotNull
    public final ResourceLocation getTEX_OVERLAY() {
        return TEX_OVERLAY;
    }

    public final void render(@NotNull GuiGraphics gg) {
        Intrinsics.checkNotNullParameter((Object)gg, (String)"gg");
        if (!show) {
            return;
        }
        int sw = gg.guiWidth();
        int cx = sw / 2;
        int x = cx - 100;
        int y = 20;
        float drawWidth = (float)200 * value;
        gg.blit(TEX_BG, x, y, 0.0f, 0.0f, 200, 27, 200, 27);
        gg.blit(TEX_BORDER, x, y, 0.0f, 0.0f, 200, 27, 200, 27);
        gg.blit(TEX_FILL, x, y, 0.0f, 0.0f, MathKt.roundToInt((float)drawWidth), 27, 200, 27);
        gg.blit(TEX_OVERLAY, x, y, 0.0f, 0.0f, 200, 27, 200, 27);
    }

    static {
        TEX_BG = TBSConstants.id("textures/gui/bossbar/integ_bg.png");
        TEX_BORDER = TBSConstants.id("textures/gui/bossbar/integ_border.png");
        TEX_FILL = TBSConstants.id("textures/gui/bossbar/integ_fill.png");
        TEX_OVERLAY = TBSConstants.id("textures/gui/bossbar/integ_overlay.png");
    }
}

