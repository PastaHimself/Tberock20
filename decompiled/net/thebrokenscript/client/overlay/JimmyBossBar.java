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

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/client/overlay/JimmyBossBar;", "", "<init>", "()V", "value", "", "getValue", "()F", "setValue", "(F)V", "show", "", "getShow", "()Z", "setShow", "(Z)V", "TEX_WIDTH", "", "TEX_HEIGHT", "TEX_BACK", "Lnet/minecraft/resources/ResourceLocation;", "getTEX_BACK", "()Lnet/minecraft/resources/ResourceLocation;", "TEX_PROGRESS", "getTEX_PROGRESS", "TEX_FRONT", "getTEX_FRONT", "TEX_OVERLAY", "getTEX_OVERLAY", "render", "", "gg", "Lnet/minecraft/client/gui/GuiGraphics;", "thebrokenscript-common"})
public final class JimmyBossBar {
    @NotNull
    public static final JimmyBossBar INSTANCE = new JimmyBossBar();
    private static float value;
    private static boolean show;
    public static final int TEX_WIDTH = 250;
    public static final int TEX_HEIGHT = 57;
    @NotNull
    private static final ResourceLocation TEX_BACK;
    @NotNull
    private static final ResourceLocation TEX_PROGRESS;
    @NotNull
    private static final ResourceLocation TEX_FRONT;
    @NotNull
    private static final ResourceLocation TEX_OVERLAY;

    private JimmyBossBar() {
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
    public final ResourceLocation getTEX_BACK() {
        return TEX_BACK;
    }

    @NotNull
    public final ResourceLocation getTEX_PROGRESS() {
        return TEX_PROGRESS;
    }

    @NotNull
    public final ResourceLocation getTEX_FRONT() {
        return TEX_FRONT;
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
        int x = cx - 125;
        int y = 0;
        float drawWidth = (float)250 * value;
        gg.blit(TEX_BACK, x, y, 0.0f, 0.0f, 250, 57, 250, 57);
        gg.blit(TEX_PROGRESS, x, y, 0.0f, 0.0f, MathKt.roundToInt((float)drawWidth), 57, 250, 57);
        gg.blit(TEX_FRONT, x, y, 0.0f, 0.0f, 250, 57, 250, 57);
        gg.blit(TEX_OVERLAY, x, y, 0.0f, 0.0f, 250, 57, 250, 57);
    }

    static {
        TEX_BACK = TBSConstants.id("textures/gui/bossbar/fractured_backbar.png");
        TEX_PROGRESS = TBSConstants.id("textures/gui/bossbar/fractured_progressbar.png");
        TEX_FRONT = TBSConstants.id("textures/gui/bossbar/fractured_frontbar.png");
        TEX_OVERLAY = TBSConstants.id("textures/gui/bossbar/fractured_toppart.png");
    }
}

