/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.util.Mth
 *  net.thebrokenscript.brokencore.api.sound.FancySoundInstance
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.boss.jimmy;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.Mth;
import net.thebrokenscript.brokencore.api.sound.FancySoundInstance;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/boss/jimmy/AudioFader;", "", "instance", "Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "<init>", "(Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;)V", "getInstance", "()Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "ticks", "", "isFading", "", "isFadeOut", "lowTaperFade", "", "fadeIn", "fadeOut", "tick", "Companion", "thebrokenscript-common"})
public final class AudioFader {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final FancySoundInstance instance;
    private long ticks;
    private boolean isFading;
    private boolean isFadeOut;
    private static final long FADE_DURATION = 30L;

    public AudioFader(@NotNull FancySoundInstance instance) {
        Intrinsics.checkNotNullParameter((Object)instance, (String)"instance");
        this.instance = instance;
    }

    @NotNull
    public final FancySoundInstance getInstance() {
        return this.instance;
    }

    public final void lowTaperFade() {
        throw new IllegalStateException("This trend died so long ago, get a fucking life.");
    }

    public final void fadeIn() {
        if (this.instance.getSoundVolume() == 1.0f || this.isFading && !this.isFadeOut) {
            return;
        }
        this.ticks = 0L;
        this.isFading = true;
        this.isFadeOut = false;
    }

    public final void fadeOut() {
        if (this.instance.getSoundVolume() == 0.0f || this.isFading && this.isFadeOut) {
            return;
        }
        this.ticks = 0L;
        this.isFading = true;
        this.isFadeOut = true;
    }

    public final void tick() {
        long l = this.ticks;
        this.ticks = l + 1L;
        if (this.ticks > 30L) {
            this.isFading = false;
        }
        if (!this.isFading) {
            return;
        }
        float target = this.isFadeOut ? Mth.lerp((float)((float)this.ticks / 30.0f), (float)1.0f, (float)0.0f) : Mth.lerp((float)((float)this.ticks / 30.0f), (float)0.0f, (float)1.0f);
        if (!(this.instance.getSoundVolume() == target)) {
            this.instance.setVolume(target);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/boss/jimmy/AudioFader$Companion;", "", "<init>", "()V", "FADE_DURATION", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

