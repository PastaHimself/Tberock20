/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.overlay;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001b\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/brokencore/api/client/overlay/OverlayRenderer;", "", "tex", "Lnet/minecraft/resources/ResourceLocation;", "ticks", "", "<init>", "(Lnet/minecraft/resources/ResourceLocation;J)V", "getTex", "()Lnet/minecraft/resources/ResourceLocation;", "getTicks", "()J", "runningTime", "", "getRunningTime", "()I", "setRunningTime", "(I)V", "tick", "", "render", "graphics", "Lnet/minecraft/client/gui/GuiGraphics;", "w", "h", "isComplete", "", "()Z", "brokencore-common"})
public class OverlayRenderer {
    @NotNull
    private final ResourceLocation tex;
    private final long ticks;
    private int runningTime;

    public OverlayRenderer(@NotNull ResourceLocation tex, long ticks) {
        Intrinsics.checkNotNullParameter((Object)tex, (String)"tex");
        this.tex = tex;
        this.ticks = ticks;
    }

    @NotNull
    protected final ResourceLocation getTex() {
        return this.tex;
    }

    protected final long getTicks() {
        return this.ticks;
    }

    protected final int getRunningTime() {
        return this.runningTime;
    }

    protected final void setRunningTime(int n) {
        this.runningTime = n;
    }

    public void tick() {
        int n = this.runningTime;
        this.runningTime = n + 1;
    }

    public void render(@NotNull GuiGraphics graphics, int w, int h) {
        Intrinsics.checkNotNullParameter((Object)graphics, (String)"graphics");
        graphics.blit(this.tex, 0, 0, 0.0f, 0.0f, w, h, w, h);
    }

    public boolean isComplete() {
        return (long)this.runningTime >= this.ticks;
    }
}

