/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.NativeImage
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.renderer.texture.AbstractTexture
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.videoplayer;

import com.mojang.blaze3d.platform.NativeImage;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.api.videoplayer.JCodecVideoSource;
import net.thebrokenscript.brokencore.api.videoplayer.VideoClip;
import net.thebrokenscript.brokencore.api.videoplayer.VideoDefinition;
import net.thebrokenscript.brokencore.api.videoplayer.VideoScreen;
import net.thebrokenscript.brokencore.api.videoplayer.VideoSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0016J0\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010#\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0016J\u0010\u0010.\u001a\u00020,2\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0010\u0010/\u001a\u00020!2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020!2\u0006\u0010#\u001a\u00020$H\u0016J\b\u00103\u001a\u00020!H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u0014X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u001e\u00a8\u00065"}, d2={"Lnet/thebrokenscript/brokencore/api/videoplayer/GraphicClip;", "Lnet/thebrokenscript/brokencore/api/videoplayer/VideoClip;", "definition", "Lnet/thebrokenscript/brokencore/api/videoplayer/VideoDefinition;", "<init>", "(Lnet/thebrokenscript/brokencore/api/videoplayer/VideoDefinition;)V", "startMs", "", "getStartMs", "()J", "durationMs", "getDurationMs", "texId", "Lnet/minecraft/resources/ResourceLocation;", "kotlin.jvm.PlatformType", "source", "Lnet/thebrokenscript/brokencore/api/videoplayer/VideoSource;", "texture", "Lnet/minecraft/client/renderer/texture/DynamicTexture;", "hasTexture", "", "srcW", "", "srcH", "shownIndex", "eofReached", "released", "entered", "exited", "isLoadGate", "()Z", "isLoadGateReady", "checkLifecycle", "", "elapsedMs", "screen", "Lnet/thebrokenscript/brokencore/api/videoplayer/VideoScreen;", "prebuffer", "onEnter", "render", "g", "Lnet/minecraft/client/gui/GuiGraphics;", "localMs", "progress", "", "partialTick", "fadeAlpha", "upload", "img", "Lcom/mojang/blaze3d/platform/NativeImage;", "onExit", "release", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nGraphicClip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GraphicClip.kt\nnet/thebrokenscript/brokencore/api/videoplayer/GraphicClip\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,141:1\n1#2:142\n*E\n"})
public final class GraphicClip
implements VideoClip {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final VideoDefinition definition;
    private final long startMs;
    private final long durationMs;
    private final ResourceLocation texId;
    @Nullable
    private VideoSource source;
    @Nullable
    private DynamicTexture texture;
    private boolean hasTexture;
    private int srcW;
    private int srcH;
    private int shownIndex;
    private boolean eofReached;
    private boolean released;
    private boolean entered;
    private boolean exited;
    private final boolean isLoadGate;
    @NotNull
    private static final AtomicInteger UID = new AtomicInteger();

    public GraphicClip(@NotNull VideoDefinition definition) {
        Intrinsics.checkNotNullParameter((Object)definition, (String)"definition");
        this.definition = definition;
        this.durationMs = this.definition.getDurationMs();
        this.texId = ResourceLocation.fromNamespaceAndPath((String)"brokencore", (String)("cutscene_video_" + UID.getAndIncrement()));
        this.shownIndex = -1;
        this.isLoadGate = true;
    }

    @Override
    public long getStartMs() {
        return this.startMs;
    }

    @Override
    public long getDurationMs() {
        return this.durationMs;
    }

    @Override
    public boolean isLoadGate() {
        return this.isLoadGate;
    }

    @Override
    public boolean isLoadGateReady() {
        VideoSource videoSource = this.source;
        return videoSource != null ? videoSource.getFirstFrameReady() : false;
    }

    @Override
    public void checkLifecycle(long elapsedMs, @NotNull VideoScreen screen) {
        Intrinsics.checkNotNullParameter((Object)((Object)screen), (String)"screen");
        if (!this.entered && elapsedMs >= this.getStartMs()) {
            this.entered = true;
            this.onEnter(screen);
        }
        if (!this.exited && elapsedMs >= this.getEndMs()) {
            this.exited = true;
            this.onExit(screen);
        }
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void prebuffer(@NotNull VideoScreen screen) {
        Intrinsics.checkNotNullParameter((Object)((Object)screen), (String)"screen");
        if (this.source == null && !this.released) {
            void it;
            JCodecVideoSource jCodecVideoSource;
            JCodecVideoSource jCodecVideoSource2 = jCodecVideoSource = new JCodecVideoSource(this.definition.getVideo());
            GraphicClip graphicClip = this;
            boolean bl = false;
            it.start();
            graphicClip.source = jCodecVideoSource;
        }
    }

    @Override
    public void onEnter(@NotNull VideoScreen screen) {
        Intrinsics.checkNotNullParameter((Object)((Object)screen), (String)"screen");
        this.prebuffer(screen);
    }

    @Override
    public void render(@NotNull GuiGraphics g, @NotNull VideoScreen screen, long localMs, float progress, float partialTick) {
        Intrinsics.checkNotNullParameter((Object)g, (String)"g");
        Intrinsics.checkNotNullParameter((Object)((Object)screen), (String)"screen");
        VideoSource videoSource = this.source;
        if (videoSource == null) {
            return;
        }
        VideoSource src = videoSource;
        if (!this.eofReached) {
            int targetIndex = (int)((double)localMs / 1000.0 * this.definition.getFps());
            NativeImage newest = null;
            while (this.shownIndex < targetIndex && src.poll() != null) {
                VideoSource.Frame f;
                NativeImage nativeImage = newest;
                if (nativeImage != null) {
                    nativeImage.close();
                }
                newest = f.getImage();
                int n = this.shownIndex;
                this.shownIndex = n + 1;
            }
            NativeImage nativeImage = newest;
            if (nativeImage != null) {
                NativeImage it = nativeImage;
                boolean bl = false;
                this.upload(it);
            }
            if (src.isFinished()) {
                this.eofReached = true;
            }
        }
        if (!this.hasTexture) {
            return;
        }
        float alpha = this.fadeAlpha(localMs);
        if (alpha <= 0.001f) {
            return;
        }
        float scale = Math.min((float)screen.width / (float)this.srcW, (float)screen.height / (float)this.srcH);
        int w = (int)((float)this.srcW * scale);
        int h = (int)((float)this.srcH * scale);
        int x = (screen.width - w) / 2;
        int y = (screen.height - h) / 2;
        g.setColor(1.0f, 1.0f, 1.0f, alpha);
        g.blit(this.texId, x, y, w, h, 0.0f, 0.0f, this.srcW, this.srcH, this.srcW, this.srcH);
        g.setColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private final float fadeAlpha(long localMs) {
        float f;
        float fadeIn;
        float f2 = fadeIn = this.definition.getFadeInMs() > 0L ? RangesKt.coerceIn((float)((float)localMs / (float)this.definition.getFadeInMs()), (float)0.0f, (float)1.0f) : 1.0f;
        if (this.definition.getFadeOutMs() > 0L && this.definition.getDurationMs() > 0L) {
            long remaining = this.definition.getDurationMs() - localMs;
            f = RangesKt.coerceIn((float)((float)remaining / (float)this.definition.getFadeOutMs()), (float)0.0f, (float)1.0f);
        } else {
            f = 1.0f;
        }
        float fadeOut = f;
        return Math.min(fadeIn, fadeOut);
    }

    /*
     * WARNING - void declaration
     */
    private final void upload(NativeImage img) {
        NativeImage px;
        if (!this.hasTexture) {
            void it;
            DynamicTexture dynamicTexture;
            this.srcW = img.getWidth();
            this.srcH = img.getHeight();
            DynamicTexture dynamicTexture2 = dynamicTexture = new DynamicTexture(img);
            GraphicClip graphicClip = this;
            boolean bl = false;
            it.setFilter(true, false);
            Minecraft.getInstance().getTextureManager().register(this.texId, (AbstractTexture)it);
            graphicClip.texture = dynamicTexture;
            this.hasTexture = true;
            return;
        }
        DynamicTexture dynamicTexture = this.texture;
        Object object = px = dynamicTexture != null ? dynamicTexture.getPixels() : null;
        if (px != null && px.getWidth() == img.getWidth() && px.getHeight() == img.getHeight()) {
            px.copyFrom(img);
            DynamicTexture dynamicTexture3 = this.texture;
            if (dynamicTexture3 != null) {
                dynamicTexture3.upload();
            }
        }
        img.close();
    }

    @Override
    public void onExit(@NotNull VideoScreen screen) {
        Intrinsics.checkNotNullParameter((Object)((Object)screen), (String)"screen");
        this.release();
    }

    @Override
    public void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        VideoSource videoSource = this.source;
        if (videoSource != null) {
            videoSource.close();
        }
        this.source = null;
        if (this.hasTexture) {
            Minecraft.getInstance().getTextureManager().release(this.texId);
            this.hasTexture = false;
            this.texture = null;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/brokencore/api/videoplayer/GraphicClip$Companion;", "", "<init>", "()V", "UID", "Ljava/util/concurrent/atomic/AtomicInteger;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

