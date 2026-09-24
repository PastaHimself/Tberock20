/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.resources.sounds.SimpleSoundInstance
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.sounds.SoundEvent
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package net.thebrokenscript.brokencore.api.videoplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.api.videoplayer.AudioResolver;
import net.thebrokenscript.brokencore.api.videoplayer.VideoClip;
import net.thebrokenscript.brokencore.api.videoplayer.VideoDefinition;
import net.thebrokenscript.brokencore.api.videoplayer.VideoScreen;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\rX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/brokencore/api/videoplayer/AudioClip;", "Lnet/thebrokenscript/brokencore/api/videoplayer/VideoClip;", "definition", "Lnet/thebrokenscript/brokencore/api/videoplayer/VideoDefinition;", "<init>", "(Lnet/thebrokenscript/brokencore/api/videoplayer/VideoDefinition;)V", "startMs", "", "getStartMs", "()J", "durationMs", "getDurationMs", "playing", "", "sound", "Lnet/minecraft/client/resources/sounds/SimpleSoundInstance;", "entered", "exited", "isLoadGate", "()Z", "checkLifecycle", "", "elapsedMs", "screen", "Lnet/thebrokenscript/brokencore/api/videoplayer/VideoScreen;", "onEnter", "onExit", "release", "stop", "Companion", "brokencore-common"})
public final class AudioClip
implements VideoClip {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final VideoDefinition definition;
    private final long startMs;
    private final long durationMs;
    private boolean playing;
    @Nullable
    private SimpleSoundInstance sound;
    private boolean entered;
    private boolean exited;
    private final boolean isLoadGate;
    private static final Logger LOGGER = LoggerFactory.getLogger((String)"BrokenCore/audio");

    public AudioClip(@NotNull VideoDefinition definition) {
        Intrinsics.checkNotNullParameter((Object)definition, (String)"definition");
        this.definition = definition;
        this.durationMs = this.definition.getDurationMs();
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

    @Override
    public void onEnter(@NotNull VideoScreen screen) {
        SimpleSoundInstance instance;
        Intrinsics.checkNotNullParameter((Object)((Object)screen), (String)"screen");
        if (this.playing || !this.definition.getAudio()) {
            return;
        }
        SoundEvent soundEvent = AudioResolver.INSTANCE.get(this.definition.getAudioLocation());
        if (soundEvent == null) {
            AudioClip $this$onEnter_u24lambda_u240 = this;
            boolean bl = false;
            LOGGER.warn("[BrokenCore] Missing cutscene audio sound {}", (Object)$this$onEnter_u24lambda_u240.definition.getAudioLocation());
            return;
        }
        SoundEvent soundEvent2 = soundEvent;
        this.sound = instance = SimpleSoundInstance.forUI((SoundEvent)soundEvent2, (float)1.0f, (float)1.0f);
        Minecraft.getInstance().getSoundManager().play((SoundInstance)instance);
        this.playing = true;
    }

    @Override
    public void onExit(@NotNull VideoScreen screen) {
        Intrinsics.checkNotNullParameter((Object)((Object)screen), (String)"screen");
        this.stop();
    }

    @Override
    public void release() {
        this.stop();
    }

    private final void stop() {
        SimpleSoundInstance simpleSoundInstance = this.sound;
        if (simpleSoundInstance == null) {
            return;
        }
        SimpleSoundInstance instance = simpleSoundInstance;
        Minecraft.getInstance().getSoundManager().stop((SoundInstance)instance);
        this.sound = null;
        this.playing = false;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/brokencore/api/videoplayer/AudioClip$Companion;", "", "<init>", "()V", "LOGGER", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

