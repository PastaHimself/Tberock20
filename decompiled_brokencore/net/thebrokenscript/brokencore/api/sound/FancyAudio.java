/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.resources.sounds.SoundInstance
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.openal.AL
 */
package net.thebrokenscript.brokencore.api.sound;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.sound.FancyEntitySoundInstance;
import net.thebrokenscript.brokencore.api.sound.FancyPositionedSoundInstance;
import net.thebrokenscript.brokencore.api.sound.FancySoundInstance;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.openal.AL;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J@\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\tJH\u0010\f\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\rJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\rJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001eJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0004\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001f"}, d2={"Lnet/thebrokenscript/brokencore/api/sound/FancyAudio;", "", "<init>", "()V", "HAS_EFX", "", "getHAS_EFX", "()Z", "RANDOM", "Lnet/minecraft/util/RandomSource;", "getRANDOM", "()Lnet/minecraft/util/RandomSource;", "play", "Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "sound", "Lnet/minecraft/sounds/SoundEvent;", "source", "Lnet/minecraft/sounds/SoundSource;", "volume", "", "pitch", "looping", "random", "Lnet/thebrokenscript/brokencore/api/sound/FancyEntitySoundInstance;", "entity", "Lnet/minecraft/world/entity/Entity;", "isPlaying", "instance", "stop", "", "Lnet/thebrokenscript/brokencore/api/sound/FancyPositionedSoundInstance;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nFancyAudio.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FancyAudio.kt\nnet/thebrokenscript/brokencore/api/sound/FancyAudio\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,85:1\n1#2:86\n*E\n"})
public final class FancyAudio {
    @NotNull
    public static final FancyAudio INSTANCE = new FancyAudio();
    @NotNull
    private static final RandomSource RANDOM;

    private FancyAudio() {
    }

    public final boolean getHAS_EFX() {
        return AL.getCapabilities().ALC_EXT_EFX;
    }

    @NotNull
    public final RandomSource getRANDOM() {
        return RANDOM;
    }

    @NotNull
    public final FancySoundInstance play(@NotNull SoundEvent sound, @NotNull SoundSource source, float volume, float pitch, boolean looping, @NotNull RandomSource random) {
        FancySoundInstance fancySoundInstance;
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        FancySoundInstance it = fancySoundInstance = new FancySoundInstance(sound, source, volume, pitch, looping, random);
        boolean bl = false;
        ClientDSLKt.getMC().getSoundManager().play((SoundInstance)it);
        return fancySoundInstance;
    }

    public static /* synthetic */ FancySoundInstance play$default(FancyAudio fancyAudio, SoundEvent soundEvent, SoundSource soundSource, float f, float f2, boolean bl, RandomSource randomSource, int n, Object object) {
        if ((n & 2) != 0) {
            soundSource = SoundSource.MASTER;
        }
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        if ((n & 8) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x10) != 0) {
            bl = false;
        }
        if ((n & 0x20) != 0) {
            randomSource = RANDOM;
        }
        return fancyAudio.play(soundEvent, soundSource, f, f2, bl, randomSource);
    }

    @NotNull
    public final FancyEntitySoundInstance play(@NotNull SoundEvent sound, @NotNull SoundSource source, float volume, float pitch, boolean looping, @NotNull RandomSource random, @NotNull Entity entity) {
        FancyEntitySoundInstance fancyEntitySoundInstance;
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        FancyEntitySoundInstance it = fancyEntitySoundInstance = new FancyEntitySoundInstance(sound, source, volume, pitch, entity, looping, random);
        boolean bl = false;
        ClientDSLKt.getMC().getSoundManager().play((SoundInstance)it);
        return fancyEntitySoundInstance;
    }

    public static /* synthetic */ FancyEntitySoundInstance play$default(FancyAudio fancyAudio, SoundEvent soundEvent, SoundSource soundSource, float f, float f2, boolean bl, RandomSource randomSource, Entity entity, int n, Object object) {
        if ((n & 2) != 0) {
            soundSource = SoundSource.MASTER;
        }
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        if ((n & 8) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x10) != 0) {
            bl = false;
        }
        if ((n & 0x20) != 0) {
            randomSource = RANDOM;
        }
        return fancyAudio.play(soundEvent, soundSource, f, f2, bl, randomSource, entity);
    }

    public final boolean isPlaying(@NotNull FancySoundInstance instance) {
        Intrinsics.checkNotNullParameter((Object)instance, (String)"instance");
        return ClientDSLKt.getMC().getSoundManager().isActive((SoundInstance)instance);
    }

    public final void stop(@NotNull FancySoundInstance instance) {
        Intrinsics.checkNotNullParameter((Object)instance, (String)"instance");
        ClientDSLKt.getMC().getSoundManager().stop((SoundInstance)instance);
    }

    public final void stop(@NotNull FancyEntitySoundInstance instance) {
        Intrinsics.checkNotNullParameter((Object)instance, (String)"instance");
        ClientDSLKt.getMC().getSoundManager().stop((SoundInstance)instance);
    }

    public final void stop(@NotNull FancyPositionedSoundInstance instance) {
        Intrinsics.checkNotNullParameter((Object)instance, (String)"instance");
        ClientDSLKt.getMC().getSoundManager().stop((SoundInstance)instance);
    }

    public final void stop(@NotNull SoundEvent sound) {
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        ClientDSLKt.getMC().getSoundManager().stop(sound.getLocation(), null);
    }

    static {
        RandomSource randomSource = RandomSource.create();
        Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"create(...)");
        RANDOM = randomSource;
    }
}

