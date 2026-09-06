/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.platform.NativeImage
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.renderer.texture.DynamicTexture
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.videoplayer;

import com.mojang.blaze3d.platform.NativeImage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0002\f\rJ\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u000b\u001a\u00020\u0003H&R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\t\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/videoplayer/VideoSource;", "", "start", "", "poll", "Lnet/thebrokenscript/brokencore/api/videoplayer/VideoSource$Frame;", "firstFrameReady", "", "getFirstFrameReady", "()Z", "isFinished", "close", "DecodedFrame", "Frame", "brokencore-common"})
public interface VideoSource {
    public void start();

    @Nullable
    public Frame poll();

    public boolean getFirstFrameReady();

    public boolean isFinished();

    public void close();

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B(\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\b\b\u00a2\u0006\u0004\b\t\u0010\nJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\u001a\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\b\bH\u00c6\u0003J.\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0019\b\u0002\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\b\bH\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\b\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/brokencore/api/videoplayer/VideoSource$DecodedFrame;", "", "index", "", "image", "Lkotlin/Function1;", "Lnet/minecraft/client/renderer/texture/DynamicTexture;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "getIndex", "()I", "getImage", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "brokencore-common"})
    public static final class DecodedFrame {
        private final int index;
        @NotNull
        private final Function1<DynamicTexture, Unit> image;

        public DecodedFrame(int index, @NotNull Function1<? super DynamicTexture, Unit> image) {
            Intrinsics.checkNotNullParameter(image, (String)"image");
            this.index = index;
            this.image = image;
        }

        public final int getIndex() {
            return this.index;
        }

        @NotNull
        public final Function1<DynamicTexture, Unit> getImage() {
            return this.image;
        }

        public final int component1() {
            return this.index;
        }

        @NotNull
        public final Function1<DynamicTexture, Unit> component2() {
            return this.image;
        }

        @NotNull
        public final DecodedFrame copy(int index, @NotNull Function1<? super DynamicTexture, Unit> image) {
            Intrinsics.checkNotNullParameter(image, (String)"image");
            return new DecodedFrame(index, image);
        }

        public static /* synthetic */ DecodedFrame copy$default(DecodedFrame decodedFrame, int n, Function1 function1, int n2, Object object) {
            if ((n2 & 1) != 0) {
                n = decodedFrame.index;
            }
            if ((n2 & 2) != 0) {
                function1 = decodedFrame.image;
            }
            return decodedFrame.copy(n, function1);
        }

        @NotNull
        public String toString() {
            return "DecodedFrame(index=" + this.index + ", image=" + this.image + ")";
        }

        public int hashCode() {
            int result = Integer.hashCode(this.index);
            result = result * 31 + this.image.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DecodedFrame)) {
                return false;
            }
            DecodedFrame decodedFrame = (DecodedFrame)other;
            if (this.index != decodedFrame.index) {
                return false;
            }
            return Intrinsics.areEqual(this.image, decodedFrame.image);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/videoplayer/VideoSource$Frame;", "", "index", "", "image", "Lcom/mojang/blaze3d/platform/NativeImage;", "<init>", "(ILcom/mojang/blaze3d/platform/NativeImage;)V", "getIndex", "()I", "getImage", "()Lcom/mojang/blaze3d/platform/NativeImage;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "brokencore-common"})
    public static final class Frame {
        private final int index;
        @NotNull
        private final NativeImage image;

        public Frame(int index, @NotNull NativeImage image) {
            Intrinsics.checkNotNullParameter((Object)image, (String)"image");
            this.index = index;
            this.image = image;
        }

        public final int getIndex() {
            return this.index;
        }

        @NotNull
        public final NativeImage getImage() {
            return this.image;
        }

        public final int component1() {
            return this.index;
        }

        @NotNull
        public final NativeImage component2() {
            return this.image;
        }

        @NotNull
        public final Frame copy(int index, @NotNull NativeImage image) {
            Intrinsics.checkNotNullParameter((Object)image, (String)"image");
            return new Frame(index, image);
        }

        public static /* synthetic */ Frame copy$default(Frame frame, int n, NativeImage nativeImage, int n2, Object object) {
            if ((n2 & 1) != 0) {
                n = frame.index;
            }
            if ((n2 & 2) != 0) {
                nativeImage = frame.image;
            }
            return frame.copy(n, nativeImage);
        }

        @NotNull
        public String toString() {
            return "Frame(index=" + this.index + ", image=" + this.image + ")";
        }

        public int hashCode() {
            int result = Integer.hashCode(this.index);
            result = result * 31 + this.image.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Frame)) {
                return false;
            }
            Frame frame = (Frame)other;
            if (this.index != frame.index) {
                return false;
            }
            return Intrinsics.areEqual((Object)this.image, (Object)frame.image);
        }
    }
}

