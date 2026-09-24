/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.NativeImage
 *  kotlin.Metadata
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.io.ByteStreamsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  net.minecraft.client.Minecraft
 *  net.minecraft.resources.ResourceLocation
 *  org.jcodec.api.FrameGrab
 *  org.jcodec.api.PictureWithMetadata
 *  org.jcodec.common.io.ByteBufferSeekableByteChannel
 *  org.jcodec.common.io.SeekableByteChannel
 *  org.jcodec.common.model.ColorSpace
 *  org.jcodec.common.model.Picture
 *  org.jcodec.scale.ColorUtil
 *  org.jcodec.scale.Transform
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package net.thebrokenscript.brokencore.api.videoplayer;

import com.mojang.blaze3d.platform.NativeImage;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.api.videoplayer.VideoSource;
import org.jcodec.api.FrameGrab;
import org.jcodec.api.PictureWithMetadata;
import org.jcodec.common.io.ByteBufferSeekableByteChannel;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.scale.ColorUtil;
import org.jcodec.scale.Transform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002 !B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001d\u00a8\u0006\""}, d2={"Lnet/thebrokenscript/brokencore/api/videoplayer/JCodecVideoSource;", "Lnet/thebrokenscript/brokencore/api/videoplayer/VideoSource;", "resource", "Lnet/minecraft/resources/ResourceLocation;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;)V", "queue", "Ljava/util/concurrent/ArrayBlockingQueue;", "Lnet/thebrokenscript/brokencore/api/videoplayer/VideoSource$Frame;", "running", "", "finished", "thread", "Ljava/lang/Thread;", "transform", "Lorg/jcodec/scale/Transform;", "rgbScratch", "Lorg/jcodec/common/model/Picture;", "start", "", "decodeLoop", "emitFrame", "frame", "toNativeImage", "Lcom/mojang/blaze3d/platform/NativeImage;", "pic", "poll", "firstFrameReady", "getFirstFrameReady", "()Z", "isFinished", "close", "PendingFrame", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nJCodecVideoSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JCodecVideoSource.kt\nnet/thebrokenscript/brokencore/api/videoplayer/JCodecVideoSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,163:1\n1#2:164\n1011#3,2:165\n1011#3,2:167\n*S KotlinDebug\n*F\n+ 1 JCodecVideoSource.kt\nnet/thebrokenscript/brokencore/api/videoplayer/JCodecVideoSource\n*L\n71#1:165,2\n78#1:167,2\n*E\n"})
public final class JCodecVideoSource
implements VideoSource {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ResourceLocation resource;
    @NotNull
    private final ArrayBlockingQueue<VideoSource.Frame> queue;
    private volatile boolean running;
    private volatile boolean finished;
    @Nullable
    private Thread thread;
    @Nullable
    private Transform transform;
    @Nullable
    private Picture rgbScratch;
    private static final Logger LOGGER = LoggerFactory.getLogger((String)"BrokenCore/Cutscene");
    private static final int BUFFER_FRAMES = 8;

    public JCodecVideoSource(@NotNull ResourceLocation resource) {
        Intrinsics.checkNotNullParameter((Object)resource, (String)"resource");
        this.resource = resource;
        this.queue = new ArrayBlockingQueue(8);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void start() {
        void it;
        Thread thread;
        if (this.running) {
            return;
        }
        this.running = true;
        Thread thread2 = thread = new Thread(this::decodeLoop, "brokencore-cutscene-decoder");
        JCodecVideoSource jCodecVideoSource = this;
        boolean bl = false;
        it.setDaemon(true);
        it.start();
        jCodecVideoSource.thread = thread;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     */
    private final void decodeLoop() {
        block30: {
            Object $this$decodeLoop_u24lambda_u243;
            Object object;
            try {
                Object it;
                object = Minecraft.getInstance().getResourceManager().open(this.resource);
                Throwable throwable = null;
                try {
                    it = (InputStream)object;
                    boolean bl = false;
                    Intrinsics.checkNotNull((Object)it);
                    it = ByteStreamsKt.readBytes((InputStream)it);
                }
                catch (Throwable bl) {
                    throwable = bl;
                    throw bl;
                }
                finally {
                    CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                }
                object = it;
            }
            catch (Exception e) {
                LOGGER.error("[BrokenCore] Cutscene: failed to read video {}", (Object)this.resource, (Object)e);
                this.finished = true;
                return;
            }
            Object bytes = object;
            ByteBufferSeekableByteChannel channel = ByteBufferSeekableByteChannel.readFromByteBuffer((ByteBuffer)ByteBuffer.wrap((byte[])bytes));
            List reorderBuffer = new ArrayList();
            Object grab = FrameGrab.createFrameGrab((SeekableByteChannel)((SeekableByteChannel)channel));
            int maxReorderDepth = 8;
            int outIndex = 0;
            while (this.running && grab.getNativeFrameWithMetadata() != null) {
                PictureWithMetadata frameMeta;
                Picture pic = frameMeta.getPicture();
                double pts = frameMeta.getTimestamp();
                if (!this.running) break;
                Intrinsics.checkNotNull((Object)pic);
                NativeImage img = this.toNativeImage(pic);
                reorderBuffer.add(new PendingFrame(pts, img));
                if (reorderBuffer.size() <= maxReorderDepth) continue;
                List $this$sortBy$iv = reorderBuffer;
                boolean $i$f$sortBy = false;
                if ($this$sortBy$iv.size() > 1) {
                    CollectionsKt.sortWith((List)$this$sortBy$iv, (Comparator)new Comparator(){

                        public final int compare(T a, T b) {
                            PendingFrame it = (PendingFrame)a;
                            boolean bl = false;
                            Comparable comparable = Double.valueOf(it.getPts());
                            it = (PendingFrame)b;
                            Comparable comparable2 = comparable;
                            bl = false;
                            return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)Double.valueOf(it.getPts()));
                        }
                    });
                }
                PendingFrame oldest = (PendingFrame)reorderBuffer.remove(0);
                this.emitFrame(new VideoSource.Frame(outIndex++, oldest.getImage()));
            }
            List $this$sortBy$iv = reorderBuffer;
            boolean $i$f$sortBy = false;
            if ($this$sortBy$iv.size() > 1) {
                CollectionsKt.sortWith((List)$this$sortBy$iv, (Comparator)new Comparator(){

                    public final int compare(T a, T b) {
                        PendingFrame it = (PendingFrame)a;
                        boolean bl = false;
                        Comparable comparable = Double.valueOf(it.getPts());
                        it = (PendingFrame)b;
                        Comparable comparable2 = comparable;
                        bl = false;
                        return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)Double.valueOf(it.getPts()));
                    }
                });
            }
            while (!((Collection)reorderBuffer).isEmpty() && this.running) {
                PendingFrame pending = (PendingFrame)reorderBuffer.remove(0);
                this.emitFrame(new VideoSource.Frame(outIndex++, pending.getImage()));
            }
            this.finished = true;
            grab = this;
            try {
                $this$decodeLoop_u24lambda_u243 = (JCodecVideoSource)grab;
                boolean bl = false;
                channel.close();
                $this$decodeLoop_u24lambda_u243 = Result.constructor-impl((Object)Unit.INSTANCE);
            }
            catch (Throwable bl) {
                $this$decodeLoop_u24lambda_u243 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl));
            }
            grab = reorderBuffer.iterator();
            while (grab.hasNext()) {
                NativeImage image = ((PendingFrame)grab.next()).component2();
                image.close();
            }
            reorderBuffer.clear();
            break block30;
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break block30;
            }
            catch (Throwable t) {
                Object object2;
                LOGGER.error("[BrokenCore] Cutscene: decode failed for {}", (Object)this.resource, (Object)t);
                this.finished = true;
                Object object3 = this;
                try {
                    JCodecVideoSource $this$decodeLoop_u24lambda_u2432 = object3;
                    boolean bl = false;
                    channel.close();
                    object2 = Result.constructor-impl((Object)Unit.INSTANCE);
                }
                catch (Throwable bl) {
                    object2 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl));
                }
                object3 = reorderBuffer.iterator();
                while (object3.hasNext()) {
                    NativeImage image = ((PendingFrame)object3.next()).component2();
                    image.close();
                }
                reorderBuffer.clear();
                break block30;
                {
                    catch (Throwable throwable) {
                        throw throwable;
                    }
                }
            }
            finally {
                Object $this$decodeLoop_u24lambda_u2433;
                this.finished = true;
                Object e = this;
                try {
                    $this$decodeLoop_u24lambda_u2433 = e;
                    boolean bl = false;
                    channel.close();
                    $this$decodeLoop_u24lambda_u2433 = Result.constructor-impl((Object)Unit.INSTANCE);
                }
                catch (Throwable bl) {
                    $this$decodeLoop_u24lambda_u2433 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)bl));
                }
                e = reorderBuffer.iterator();
                while (e.hasNext()) {
                    NativeImage image = ((PendingFrame)e.next()).component2();
                    image.close();
                }
                reorderBuffer.clear();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void emitFrame(VideoSource.Frame frame) {
        boolean handed = false;
        try {
            while (this.running) {
                boolean bl;
                boolean it = bl = this.queue.offer(frame, 50L, TimeUnit.MILLISECONDS);
                boolean bl2 = false;
                handed = it;
                if (!bl) continue;
                break;
            }
        }
        finally {
            if (!handed) {
                frame.getImage().close();
            }
        }
    }

    private final NativeImage toNativeImage(Picture pic) {
        int w = pic.getWidth();
        int h = pic.getHeight();
        if (this.transform == null) {
            this.transform = ColorUtil.getTransform((ColorSpace)pic.getColor(), (ColorSpace)ColorSpace.RGB);
            this.rgbScratch = Picture.create((int)w, (int)h, (ColorSpace)ColorSpace.RGB);
        }
        Transform transform2 = this.transform;
        Intrinsics.checkNotNull((Object)transform2);
        transform2.transform(pic, this.rgbScratch);
        Picture picture = this.rgbScratch;
        Intrinsics.checkNotNull((Object)picture);
        byte[] data2 = picture.getPlaneData(0);
        NativeImage img = new NativeImage(w, h, false);
        int p = 0;
        for (int y = 0; y < h; ++y) {
            for (int x = 0; x < w; ++x) {
                int r = RangesKt.coerceIn((int)(data2[p++] + 128), (int)0, (int)255);
                int g = RangesKt.coerceIn((int)(data2[p++] + 128), (int)0, (int)255);
                int b = RangesKt.coerceIn((int)(data2[p++] + 128), (int)0, (int)255);
                img.setPixelRGBA(x, y, 0xFF000000 | b << 16 | g << 8 | r);
            }
        }
        return img;
    }

    @Override
    @Nullable
    public VideoSource.Frame poll() {
        return this.queue.poll();
    }

    @Override
    public boolean getFirstFrameReady() {
        return this.queue.size() >= 3 || this.finished;
    }

    @Override
    public boolean isFinished() {
        return this.finished && this.queue.isEmpty();
    }

    @Override
    public void close() {
        Object it;
        this.running = false;
        Thread thread = this.thread;
        if (thread != null) {
            it = thread;
            boolean bl = false;
            ((Thread)it).interrupt();
            try {
                ((Thread)it).join(500L);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        Object f = null;
        while (true) {
            VideoSource.Frame frame = this.queue.poll();
            it = frame;
            boolean bl = false;
            f = it;
            if (frame == null) break;
            Object object = f;
            Intrinsics.checkNotNull((Object)object);
            ((VideoSource.Frame)object).getImage().close();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/videoplayer/JCodecVideoSource$Companion;", "", "<init>", "()V", "LOGGER", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "BUFFER_FRAMES", "", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/videoplayer/JCodecVideoSource$PendingFrame;", "", "pts", "", "image", "Lcom/mojang/blaze3d/platform/NativeImage;", "<init>", "(DLcom/mojang/blaze3d/platform/NativeImage;)V", "getPts", "()D", "getImage", "()Lcom/mojang/blaze3d/platform/NativeImage;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "brokencore-common"})
    private static final class PendingFrame {
        private final double pts;
        @NotNull
        private final NativeImage image;

        public PendingFrame(double pts, @NotNull NativeImage image) {
            Intrinsics.checkNotNullParameter((Object)image, (String)"image");
            this.pts = pts;
            this.image = image;
        }

        public final double getPts() {
            return this.pts;
        }

        @NotNull
        public final NativeImage getImage() {
            return this.image;
        }

        public final double component1() {
            return this.pts;
        }

        @NotNull
        public final NativeImage component2() {
            return this.image;
        }

        @NotNull
        public final PendingFrame copy(double pts, @NotNull NativeImage image) {
            Intrinsics.checkNotNullParameter((Object)image, (String)"image");
            return new PendingFrame(pts, image);
        }

        public static /* synthetic */ PendingFrame copy$default(PendingFrame pendingFrame, double d, NativeImage nativeImage, int n, Object object) {
            if ((n & 1) != 0) {
                d = pendingFrame.pts;
            }
            if ((n & 2) != 0) {
                nativeImage = pendingFrame.image;
            }
            return pendingFrame.copy(d, nativeImage);
        }

        @NotNull
        public String toString() {
            return "PendingFrame(pts=" + this.pts + ", image=" + this.image + ")";
        }

        public int hashCode() {
            int result = Double.hashCode(this.pts);
            result = result * 31 + this.image.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingFrame)) {
                return false;
            }
            PendingFrame pendingFrame = (PendingFrame)other;
            if (Double.compare(this.pts, pendingFrame.pts) != 0) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.image, (Object)pendingFrame.image);
        }
    }
}

