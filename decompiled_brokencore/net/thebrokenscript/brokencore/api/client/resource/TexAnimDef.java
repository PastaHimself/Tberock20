/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KClass
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.resource;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import net.thebrokenscript.brokencore.api.util.serde.KClassEndec;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000b\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/brokencore/api/client/resource/TexAnimDef;", "", "frames", "", "frameTicks", "textureWidth", "textureHeight", "cols", "<init>", "(IIIII)V", "getFrames", "()I", "getFrameTicks", "getTextureWidth", "getTextureHeight", "getCols", "frameWidth", "getFrameWidth", "rows", "getRows", "frameHeight", "getFrameHeight", "duration", "getDuration", "completed", "", "playingTime", "", "frameIndex", "frameU", "frameV", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nTexAnimDef.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TexAnimDef.kt\nnet/thebrokenscript/brokencore/api/client/resource/TexAnimDef\n+ 2 KClassEndec.kt\nnet/thebrokenscript/brokencore/api/util/serde/KClassEndecKt\n*L\n1#1,68:1\n14#2:69\n*S KotlinDebug\n*F\n+ 1 TexAnimDef.kt\nnet/thebrokenscript/brokencore/api/client/resource/TexAnimDef\n*L\n65#1:69\n*E\n"})
public final class TexAnimDef {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int frames;
    private final int frameTicks;
    private final int textureWidth;
    private final int textureHeight;
    private final int cols;
    private final int frameWidth;
    private final int rows;
    private final int frameHeight;
    private final int duration;
    @NotNull
    private static final KClassEndec<TexAnimDef> ENDEC;

    public TexAnimDef(int frames, int frameTicks, int textureWidth, int textureHeight, int cols) {
        this.frames = frames;
        this.frameTicks = frameTicks;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        this.cols = cols;
        this.frameWidth = this.textureWidth / this.cols;
        this.rows = (int)Math.ceil((double)this.frames / (double)this.cols);
        this.frameHeight = this.textureHeight / this.rows;
        this.duration = this.frames * this.frameTicks;
    }

    public /* synthetic */ TexAnimDef(int n, int n2, int n3, int n4, int n5, int n6, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n6 & 0x10) != 0) {
            n5 = 1;
        }
        this(n, n2, n3, n4, n5);
    }

    public final int getFrames() {
        return this.frames;
    }

    public final int getFrameTicks() {
        return this.frameTicks;
    }

    public final int getTextureWidth() {
        return this.textureWidth;
    }

    public final int getTextureHeight() {
        return this.textureHeight;
    }

    public final int getCols() {
        return this.cols;
    }

    public final int getFrameWidth() {
        return this.frameWidth;
    }

    public final int getRows() {
        return this.rows;
    }

    public final int getFrameHeight() {
        return this.frameHeight;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final boolean completed(@NotNull Number playingTime) {
        Intrinsics.checkNotNullParameter((Object)playingTime, (String)"playingTime");
        return playingTime.intValue() >= this.duration;
    }

    public final int frameIndex(@NotNull Number playingTime) {
        Intrinsics.checkNotNullParameter((Object)playingTime, (String)"playingTime");
        return Math.min(this.frames - 1, playingTime.intValue() / this.frameTicks);
    }

    public final int frameU(@NotNull Number playingTime) {
        Intrinsics.checkNotNullParameter((Object)playingTime, (String)"playingTime");
        return this.frameIndex(playingTime) % this.cols * this.frameWidth;
    }

    public final int frameV(@NotNull Number playingTime) {
        Intrinsics.checkNotNullParameter((Object)playingTime, (String)"playingTime");
        return this.frameIndex(playingTime) / this.cols * this.frameHeight;
    }

    static {
        KClass $this$endec$iv = Reflection.getOrCreateKotlinClass(TexAnimDef.class);
        boolean $i$f$getEndec = false;
        ENDEC = new KClassEndec($this$endec$iv);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/client/resource/TexAnimDef$Companion;", "", "<init>", "()V", "ENDEC", "Lnet/thebrokenscript/brokencore/api/util/serde/KClassEndec;", "Lnet/thebrokenscript/brokencore/api/client/resource/TexAnimDef;", "getENDEC", "()Lnet/thebrokenscript/brokencore/api/util/serde/KClassEndec;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final KClassEndec<TexAnimDef> getENDEC() {
            return ENDEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

