/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.videoplayer;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00c6\u0003J\t\u0010#\u001a\u00020\tH\u00c6\u0003J\t\u0010$\u001a\u00020\u000bH\u00c6\u0003J\t\u0010%\u001a\u00020\tH\u00c6\u0003J\t\u0010&\u001a\u00020\tH\u00c6\u0003J\t\u0010'\u001a\u00020\u000bH\u00c6\u0003JY\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020,H\u00d6\u0001J\t\u0010-\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\r\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u001e\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0012\u00a8\u0006/"}, d2={"Lnet/thebrokenscript/brokencore/api/videoplayer/VideoDefinition;", "", "video", "Lnet/minecraft/resources/ResourceLocation;", "codec", "", "fps", "", "durationMs", "", "skippable", "", "fadeInMs", "fadeOutMs", "audio", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Ljava/lang/String;DJZJJZ)V", "getVideo", "()Lnet/minecraft/resources/ResourceLocation;", "getCodec", "()Ljava/lang/String;", "getFps", "()D", "getDurationMs", "()J", "getSkippable", "()Z", "getFadeInMs", "getFadeOutMs", "getAudio", "audioLocation", "getAudioLocation", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "brokencore-common"})
public final class VideoDefinition {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ResourceLocation video;
    @NotNull
    private final String codec;
    private final double fps;
    private final long durationMs;
    private final boolean skippable;
    private final long fadeInMs;
    private final long fadeOutMs;
    private final boolean audio;
    @NotNull
    private static final Set<String> SUPPORTED_CODECS = SetsKt.setOf((Object)"h264");

    public VideoDefinition(@NotNull ResourceLocation video, @NotNull String codec, double fps, long durationMs, boolean skippable, long fadeInMs, long fadeOutMs, boolean audio) {
        Intrinsics.checkNotNullParameter((Object)video, (String)"video");
        Intrinsics.checkNotNullParameter((Object)codec, (String)"codec");
        this.video = video;
        this.codec = codec;
        this.fps = fps;
        this.durationMs = durationMs;
        this.skippable = skippable;
        this.fadeInMs = fadeInMs;
        this.fadeOutMs = fadeOutMs;
        this.audio = audio;
    }

    @NotNull
    public final ResourceLocation getVideo() {
        return this.video;
    }

    @NotNull
    public final String getCodec() {
        return this.codec;
    }

    public final double getFps() {
        return this.fps;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final boolean getSkippable() {
        return this.skippable;
    }

    public final long getFadeInMs() {
        return this.fadeInMs;
    }

    public final long getFadeOutMs() {
        return this.fadeOutMs;
    }

    public final boolean getAudio() {
        return this.audio;
    }

    @NotNull
    public final ResourceLocation getAudioLocation() {
        String string = this.video.getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
        String name = StringsKt.substringBeforeLast$default((String)StringsKt.substringAfterLast$default((String)string, (char)'/', null, (int)2, null), (char)'.', null, (int)2, null);
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)this.video.getNamespace(), (String)("video/" + name));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return resourceLocation;
    }

    @NotNull
    public final ResourceLocation component1() {
        return this.video;
    }

    @NotNull
    public final String component2() {
        return this.codec;
    }

    public final double component3() {
        return this.fps;
    }

    public final long component4() {
        return this.durationMs;
    }

    public final boolean component5() {
        return this.skippable;
    }

    public final long component6() {
        return this.fadeInMs;
    }

    public final long component7() {
        return this.fadeOutMs;
    }

    public final boolean component8() {
        return this.audio;
    }

    @NotNull
    public final VideoDefinition copy(@NotNull ResourceLocation video, @NotNull String codec, double fps, long durationMs, boolean skippable, long fadeInMs, long fadeOutMs, boolean audio) {
        Intrinsics.checkNotNullParameter((Object)video, (String)"video");
        Intrinsics.checkNotNullParameter((Object)codec, (String)"codec");
        return new VideoDefinition(video, codec, fps, durationMs, skippable, fadeInMs, fadeOutMs, audio);
    }

    public static /* synthetic */ VideoDefinition copy$default(VideoDefinition videoDefinition, ResourceLocation resourceLocation, String string, double d, long l, boolean bl, long l2, long l3, boolean bl2, int n, Object object) {
        if ((n & 1) != 0) {
            resourceLocation = videoDefinition.video;
        }
        if ((n & 2) != 0) {
            string = videoDefinition.codec;
        }
        if ((n & 4) != 0) {
            d = videoDefinition.fps;
        }
        if ((n & 8) != 0) {
            l = videoDefinition.durationMs;
        }
        if ((n & 0x10) != 0) {
            bl = videoDefinition.skippable;
        }
        if ((n & 0x20) != 0) {
            l2 = videoDefinition.fadeInMs;
        }
        if ((n & 0x40) != 0) {
            l3 = videoDefinition.fadeOutMs;
        }
        if ((n & 0x80) != 0) {
            bl2 = videoDefinition.audio;
        }
        return videoDefinition.copy(resourceLocation, string, d, l, bl, l2, l3, bl2);
    }

    @NotNull
    public String toString() {
        return "VideoDefinition(video=" + this.video + ", codec=" + this.codec + ", fps=" + this.fps + ", durationMs=" + this.durationMs + ", skippable=" + this.skippable + ", fadeInMs=" + this.fadeInMs + ", fadeOutMs=" + this.fadeOutMs + ", audio=" + this.audio + ")";
    }

    public int hashCode() {
        int result = this.video.hashCode();
        result = result * 31 + this.codec.hashCode();
        result = result * 31 + Double.hashCode(this.fps);
        result = result * 31 + Long.hashCode(this.durationMs);
        result = result * 31 + Boolean.hashCode(this.skippable);
        result = result * 31 + Long.hashCode(this.fadeInMs);
        result = result * 31 + Long.hashCode(this.fadeOutMs);
        result = result * 31 + Boolean.hashCode(this.audio);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VideoDefinition)) {
            return false;
        }
        VideoDefinition videoDefinition = (VideoDefinition)other;
        if (!Intrinsics.areEqual((Object)this.video, (Object)videoDefinition.video)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.codec, (Object)videoDefinition.codec)) {
            return false;
        }
        if (Double.compare(this.fps, videoDefinition.fps) != 0) {
            return false;
        }
        if (this.durationMs != videoDefinition.durationMs) {
            return false;
        }
        if (this.skippable != videoDefinition.skippable) {
            return false;
        }
        if (this.fadeInMs != videoDefinition.fadeInMs) {
            return false;
        }
        if (this.fadeOutMs != videoDefinition.fadeOutMs) {
            return false;
        }
        return this.audio == videoDefinition.audio;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/videoplayer/VideoDefinition$Companion;", "", "<init>", "()V", "SUPPORTED_CODECS", "", "", "getSUPPORTED_CODECS", "()Ljava/util/Set;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Set<String> getSUPPORTED_CODECS() {
            return SUPPORTED_CODECS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

