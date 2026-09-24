/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.thebrokenscript.brokencore.api.sound.FancyAudio
 *  net.thebrokenscript.brokencore.api.sound.FancySoundInstance
 *  net.thebrokenscript.brokencore.api.util.math.MathUtilKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.boss.jimmy;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.thebrokenscript.boss.jimmy.AudioFader;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import net.thebrokenscript.brokencore.api.sound.FancySoundInstance;
import net.thebrokenscript.brokencore.api.util.math.MathUtilKt;
import net.thebrokenscript.registry.TBSSoundCategories;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0002J\u000e\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001dJ\u0006\u0010&\u001a\u00020#R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006'"}, d2={"Lnet/thebrokenscript/boss/jimmy/MoonRiseAmbience;", "", "<init>", "()V", "ambience1", "Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "getAmbience1", "()Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "setAmbience1", "(Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;)V", "ambience2", "getAmbience2", "setAmbience2", "ambience3", "getAmbience3", "setAmbience3", "fader1", "Lnet/thebrokenscript/boss/jimmy/AudioFader;", "getFader1", "()Lnet/thebrokenscript/boss/jimmy/AudioFader;", "setFader1", "(Lnet/thebrokenscript/boss/jimmy/AudioFader;)V", "fader2", "getFader2", "setFader2", "fader3", "getFader3", "setFader3", "stage", "", "getStage", "()I", "setStage", "(I)V", "checkSounds", "", "applyStage", "next", "tick", "thebrokenscript-common"})
public final class MoonRiseAmbience {
    @NotNull
    private FancySoundInstance ambience1 = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.MOONRISE_P1.get()), (SoundSource)TBSSoundCategories.TBS_MUSIC, (float)0.0f, (float)0.0f, (boolean)true, null, (int)40, null);
    @NotNull
    private FancySoundInstance ambience2 = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.MOONRISE_P2.get()), (SoundSource)TBSSoundCategories.TBS_MUSIC, (float)0.0f, (float)0.0f, (boolean)true, null, (int)40, null);
    @NotNull
    private FancySoundInstance ambience3 = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.MOONRISE_P3.get()), (SoundSource)TBSSoundCategories.TBS_MUSIC, (float)0.0f, (float)0.0f, (boolean)true, null, (int)40, null);
    @NotNull
    private AudioFader fader1 = new AudioFader(this.ambience1);
    @NotNull
    private AudioFader fader2 = new AudioFader(this.ambience2);
    @NotNull
    private AudioFader fader3 = new AudioFader(this.ambience3);
    private int stage;

    @NotNull
    public final FancySoundInstance getAmbience1() {
        return this.ambience1;
    }

    public final void setAmbience1(@NotNull FancySoundInstance fancySoundInstance) {
        Intrinsics.checkNotNullParameter((Object)fancySoundInstance, (String)"<set-?>");
        this.ambience1 = fancySoundInstance;
    }

    @NotNull
    public final FancySoundInstance getAmbience2() {
        return this.ambience2;
    }

    public final void setAmbience2(@NotNull FancySoundInstance fancySoundInstance) {
        Intrinsics.checkNotNullParameter((Object)fancySoundInstance, (String)"<set-?>");
        this.ambience2 = fancySoundInstance;
    }

    @NotNull
    public final FancySoundInstance getAmbience3() {
        return this.ambience3;
    }

    public final void setAmbience3(@NotNull FancySoundInstance fancySoundInstance) {
        Intrinsics.checkNotNullParameter((Object)fancySoundInstance, (String)"<set-?>");
        this.ambience3 = fancySoundInstance;
    }

    @NotNull
    public final AudioFader getFader1() {
        return this.fader1;
    }

    public final void setFader1(@NotNull AudioFader audioFader) {
        Intrinsics.checkNotNullParameter((Object)audioFader, (String)"<set-?>");
        this.fader1 = audioFader;
    }

    @NotNull
    public final AudioFader getFader2() {
        return this.fader2;
    }

    public final void setFader2(@NotNull AudioFader audioFader) {
        Intrinsics.checkNotNullParameter((Object)audioFader, (String)"<set-?>");
        this.fader2 = audioFader;
    }

    @NotNull
    public final AudioFader getFader3() {
        return this.fader3;
    }

    public final void setFader3(@NotNull AudioFader audioFader) {
        Intrinsics.checkNotNullParameter((Object)audioFader, (String)"<set-?>");
        this.fader3 = audioFader;
    }

    public final int getStage() {
        return this.stage;
    }

    public final void setStage(int n) {
        this.stage = n;
    }

    private final void checkSounds() {
        if (this.ambience1.isStopped()) {
            this.ambience1 = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.MOONRISE_P1.get()), (SoundSource)TBSSoundCategories.TBS_MUSIC, (float)0.0f, (float)0.0f, (boolean)true, null, (int)40, null);
            this.fader1 = new AudioFader(this.ambience1);
        }
        if (this.ambience2.isStopped()) {
            this.ambience2 = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.MOONRISE_P2.get()), (SoundSource)TBSSoundCategories.TBS_MUSIC, (float)0.0f, (float)0.0f, (boolean)true, null, (int)40, null);
            this.fader2 = new AudioFader(this.ambience2);
        }
        if (this.ambience3.isStopped()) {
            this.ambience3 = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)((SoundEvent)TBSSounds.MOONRISE_P3.get()), (SoundSource)TBSSoundCategories.TBS_MUSIC, (float)0.0f, (float)0.0f, (boolean)true, null, (int)40, null);
            this.fader3 = new AudioFader(this.ambience3);
        }
    }

    public final void applyStage(int next) {
        this.checkSounds();
        this.stage = ((Number)((Object)MathUtilKt.clamp((Comparable)Integer.valueOf(next), (Comparable)Integer.valueOf(0), (Comparable)Integer.valueOf(4)))).intValue();
        switch (this.stage) {
            case 0: 
            case 4: {
                this.fader1.fadeOut();
                this.fader2.fadeOut();
                this.fader3.fadeOut();
                break;
            }
            case 1: {
                this.fader1.fadeIn();
                this.fader2.fadeOut();
                this.fader3.fadeOut();
                break;
            }
            case 2: {
                this.fader1.fadeOut();
                this.fader2.fadeIn();
                this.fader3.fadeOut();
                break;
            }
            case 3: {
                this.fader1.fadeOut();
                this.fader2.fadeOut();
                this.fader3.fadeIn();
            }
        }
    }

    public final void tick() {
        this.fader1.tick();
        this.fader2.tick();
        this.fader3.tick();
    }
}

