/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.sounds.SoundEvent
 *  net.thebrokenscript.brokencore.api.sound.FancyAudio
 *  net.thebrokenscript.brokencore.api.sound.FancySoundInstance
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.boss.kerfur;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.sounds.SoundEvent;
import net.thebrokenscript.boss.kerfur.KerfBossMusicState;
import net.thebrokenscript.brokencore.api.sound.FancyAudio;
import net.thebrokenscript.brokencore.api.sound.FancySoundInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/boss/kerfur/ClientKerfBossMusicHandler;", "", "<init>", "()V", "playing", "", "targetState", "Lnet/thebrokenscript/boss/kerfur/KerfBossMusicState;", "curState", "curInst", "Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "setState", "", "newState", "stop", "update", "thebrokenscript-common"})
public final class ClientKerfBossMusicHandler {
    @NotNull
    public static final ClientKerfBossMusicHandler INSTANCE = new ClientKerfBossMusicHandler();
    private static boolean playing;
    @NotNull
    private static KerfBossMusicState targetState;
    @Nullable
    private static KerfBossMusicState curState;
    @Nullable
    private static FancySoundInstance curInst;

    private ClientKerfBossMusicHandler() {
    }

    public final void setState(@NotNull KerfBossMusicState newState) {
        Intrinsics.checkNotNullParameter((Object)((Object)newState), (String)"newState");
        targetState = newState;
        this.update();
    }

    public final synchronized void stop() {
        FancySoundInstance fancySoundInstance = curInst;
        if (fancySoundInstance != null) {
            fancySoundInstance.stop();
        }
        curInst = null;
        playing = false;
    }

    public final synchronized void update() {
        if (curState == targetState && curInst != null) {
            return;
        }
        KerfBossMusicState kerfBossMusicState = curState = targetState;
        Intrinsics.checkNotNull((Object)((Object)kerfBossMusicState));
        SoundEvent sound = (SoundEvent)kerfBossMusicState.getTrack().invoke();
        FancySoundInstance fancySoundInstance = curInst;
        if (fancySoundInstance != null) {
            fancySoundInstance.stop();
        }
        curInst = FancyAudio.play$default((FancyAudio)FancyAudio.INSTANCE, (SoundEvent)sound, null, (float)0.0f, (float)0.0f, (boolean)true, null, (int)46, null);
        playing = true;
    }

    static {
        targetState = KerfBossMusicState.PHASE_1;
    }
}

