/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.GuiGraphics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.videoplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiGraphics;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.api.videoplayer.VideoScreen;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J0\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010\u00a8\u0006\u001f"}, d2={"Lnet/thebrokenscript/brokencore/api/videoplayer/VideoClip;", "", "startMs", "", "getStartMs", "()J", "durationMs", "getDurationMs", "endMs", "getEndMs", "prebuffer", "", "screen", "Lnet/thebrokenscript/brokencore/api/videoplayer/VideoScreen;", "isLoadGate", "", "()Z", "isLoadGateReady", "onEnter", "preRender", "localMs", "progress", "", "render", "g", "Lnet/minecraft/client/gui/GuiGraphics;", "partialTick", "onExit", "release", "checkLifecycle", "elapsedMs", "brokencore-common"})
public interface VideoClip {
    public long getStartMs();

    public long getDurationMs();

    public long getEndMs();

    public void prebuffer(@NotNull VideoScreen var1);

    public boolean isLoadGate();

    public boolean isLoadGateReady();

    public void onEnter(@NotNull VideoScreen var1);

    public void preRender(@NotNull VideoScreen var1, long var2, float var4);

    public void render(@NotNull GuiGraphics var1, @NotNull VideoScreen var2, long var3, float var5, float var6);

    public void onExit(@NotNull VideoScreen var1);

    public void release();

    public void checkLifecycle(long var1, @NotNull VideoScreen var3);

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        public static long getEndMs(@NotNull VideoClip $this) {
            return $this.getStartMs() + $this.getDurationMs();
        }

        public static void prebuffer(@NotNull VideoClip $this, @NotNull VideoScreen screen) {
            Intrinsics.checkNotNullParameter((Object)((Object)screen), (String)"screen");
        }

        public static boolean isLoadGate(@NotNull VideoClip $this) {
            return false;
        }

        public static boolean isLoadGateReady(@NotNull VideoClip $this) {
            return true;
        }

        public static void onEnter(@NotNull VideoClip $this, @NotNull VideoScreen screen) {
            Intrinsics.checkNotNullParameter((Object)((Object)screen), (String)"screen");
        }

        public static void preRender(@NotNull VideoClip $this, @NotNull VideoScreen screen, long localMs, float progress) {
            Intrinsics.checkNotNullParameter((Object)((Object)screen), (String)"screen");
        }

        public static void render(@NotNull VideoClip $this, @NotNull GuiGraphics g, @NotNull VideoScreen screen, long localMs, float progress, float partialTick) {
            Intrinsics.checkNotNullParameter((Object)g, (String)"g");
            Intrinsics.checkNotNullParameter((Object)((Object)screen), (String)"screen");
        }

        public static void onExit(@NotNull VideoClip $this, @NotNull VideoScreen screen) {
            Intrinsics.checkNotNullParameter((Object)((Object)screen), (String)"screen");
        }

        public static void release(@NotNull VideoClip $this) {
        }
    }
}

