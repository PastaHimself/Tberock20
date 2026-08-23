/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.screens.Screen
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.FormattedText
 *  net.minecraft.network.chat.MutableComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.videoplayer;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.api.videoplayer.VideoClip;
import net.thebrokenscript.brokencore.api.videoplayer.VideoDefinition;
import org.jetbrains.annotations.NotNull;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0013\u001a\u00020\u000bH\u0014J(\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0002J \u0010\u001d\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020\u000bH\u0016J\b\u0010\"\u001a\u00020\u000bH\u0016J\b\u0010#\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2={"Lnet/thebrokenscript/brokencore/api/videoplayer/VideoScreen;", "Lnet/minecraft/client/gui/screens/Screen;", "definition", "Lnet/thebrokenscript/brokencore/api/videoplayer/VideoDefinition;", "clips", "", "Lnet/thebrokenscript/brokencore/api/videoplayer/VideoClip;", "skippable", "", "onFinished", "Lkotlin/Function0;", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/videoplayer/VideoDefinition;Ljava/util/List;ZLkotlin/jvm/functions/Function0;)V", "startTimeNanos", "", "elapsedMs", "loading", "finished", "init", "render", "graphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "", "mouseY", "partialTick", "", "finish", "mouseClicked", "", "button", "shouldCloseOnEsc", "onClose", "removed", "isPauseScreen", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nVideoScreen.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideoScreen.kt\nnet/thebrokenscript/brokencore/api/videoplayer/VideoScreen\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,101:1\n1869#2,2:102\n2746#2,3:104\n1869#2,2:107\n1869#2,2:109\n1869#2,2:111\n*S KotlinDebug\n*F\n+ 1 VideoScreen.kt\nnet/thebrokenscript/brokencore/api/videoplayer/VideoScreen\n*L\n23#1:102,2\n34#1:104,3\n36#1:107,2\n78#1:109,2\n96#1:111,2\n*E\n"})
public final class VideoScreen
extends Screen {
    @NotNull
    private final VideoDefinition definition;
    @NotNull
    private final List<VideoClip> clips;
    private final boolean skippable;
    @NotNull
    private final Function0<Unit> onFinished;
    private long startTimeNanos;
    private long elapsedMs;
    private boolean loading;
    private boolean finished;

    public VideoScreen(@NotNull VideoDefinition definition, @NotNull List<? extends VideoClip> clips, boolean skippable, @NotNull Function0<Unit> onFinished) {
        Intrinsics.checkNotNullParameter((Object)definition, (String)"definition");
        Intrinsics.checkNotNullParameter(clips, (String)"clips");
        Intrinsics.checkNotNullParameter(onFinished, (String)"onFinished");
        super((Component)Component.empty());
        this.definition = definition;
        this.clips = clips;
        this.skippable = skippable;
        this.onFinished = onFinished;
        this.startTimeNanos = -1L;
        this.loading = true;
    }

    protected void init() {
        Iterable $this$forEach$iv = this.clips;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            VideoClip it = (VideoClip)element$iv;
            boolean bl = false;
            it.prebuffer(this);
        }
    }

    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)graphics, (String)"graphics");
        if (this.finished) {
            return;
        }
        graphics.fill(0, 0, this.width, this.height, -16777216);
        if (this.loading) {
            boolean allReady;
            VideoClip it;
            block11: {
                Iterable $this$none$iv = this.clips;
                boolean $i$f$none = false;
                if ($this$none$iv instanceof Collection && ((Collection)$this$none$iv).isEmpty()) {
                    v0 = true;
                } else {
                    for (Object element$iv : $this$none$iv) {
                        it = (VideoClip)element$iv;
                        boolean bl = false;
                        if (!(it.isLoadGate() && !it.isLoadGateReady())) continue;
                        v0 = false;
                        break block11;
                    }
                    v0 = allReady = true;
                }
            }
            if (!allReady) {
                Iterable $this$forEach$iv = this.clips;
                boolean $i$f$forEach = false;
                for (Object element$iv : $this$forEach$iv) {
                    it = (VideoClip)element$iv;
                    boolean bl = false;
                    it.prebuffer(this);
                }
                return;
            }
            this.loading = false;
            this.startTimeNanos = System.nanoTime();
        }
        long nowNanos = System.nanoTime();
        this.elapsedMs = (nowNanos - this.startTimeNanos) / 1000000L;
        if (this.elapsedMs >= this.definition.getDurationMs()) {
            this.finish();
            return;
        }
        for (VideoClip clip : this.clips) {
            long local = this.elapsedMs - clip.getStartMs();
            if (local < 0L || this.elapsedMs > clip.getEndMs()) continue;
            float progress = clip.getDurationMs() > 0L ? RangesKt.coerceIn((float)((float)local / (float)clip.getDurationMs()), (float)0.0f, (float)1.0f) : 1.0f;
            clip.preRender(this, local, progress);
        }
        for (VideoClip clip : this.clips) {
            long local = this.elapsedMs - clip.getStartMs();
            clip.checkLifecycle(this.elapsedMs, this);
            if (local < 0L || this.elapsedMs > clip.getEndMs()) continue;
            float progress = clip.getDurationMs() > 0L ? RangesKt.coerceIn((float)((float)local / (float)clip.getDurationMs()), (float)0.0f, (float)1.0f) : 1.0f;
            clip.render(graphics, this, local, progress, partialTick);
        }
        if (this.skippable) {
            MutableComponent msg = Component.literal((String)"Click or press ESC to skip");
            int msgW = this.font.width((FormattedText)msg);
            graphics.drawString(this.font, (Component)msg, this.width - msgW - 8, this.height - this.font.lineHeight - 8, -1426063361);
        }
    }

    private final void finish() {
        if (this.finished) {
            return;
        }
        this.finished = true;
        Iterable $this$forEach$iv = this.clips;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            VideoClip it = (VideoClip)element$iv;
            boolean bl = false;
            it.release();
        }
        this.onFinished.invoke();
        this.onClose();
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (this.skippable) {
            this.finish();
            return true;
        }
        return false;
    }

    public boolean shouldCloseOnEsc() {
        return this.skippable;
    }

    public void onClose() {
        if (!this.finished) {
            this.finish();
        }
        super.onClose();
    }

    public void removed() {
        Iterable $this$forEach$iv = this.clips;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            VideoClip it = (VideoClip)element$iv;
            boolean bl = false;
            it.release();
        }
    }

    public boolean isPauseScreen() {
        return false;
    }
}

