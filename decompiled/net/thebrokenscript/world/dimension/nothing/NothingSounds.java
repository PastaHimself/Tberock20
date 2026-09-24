/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.thebrokenscript.brokencore.api.sound.FancySoundInstance
 *  net.thebrokenscript.brokencore.api.sound.fx.AudioEffect
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset
 *  net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.nothing;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.thebrokenscript.brokencore.api.sound.FancySoundInstance;
import net.thebrokenscript.brokencore.api.sound.fx.AudioEffect;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPreset;
import net.thebrokenscript.brokencore.api.sound.fx.ReverbPresets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0007\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/world/dimension/nothing/NothingSounds;", "", "<init>", "()V", "createInstance", "Lnet/thebrokenscript/brokencore/api/sound/FancySoundInstance;", "soundEvent", "Lnet/minecraft/sounds/SoundEvent;", "source", "Lnet/minecraft/sounds/SoundSource;", "volume", "", "pitch", "random", "Lnet/minecraft/util/RandomSource;", "x", "", "y", "z", "thebrokenscript-common"})
public final class NothingSounds {
    @NotNull
    public static final NothingSounds INSTANCE = new NothingSounds();

    private NothingSounds() {
    }

    @JvmStatic
    @NotNull
    public static final FancySoundInstance createInstance(@NotNull SoundEvent soundEvent, @NotNull SoundSource source, float volume, float pitch, @NotNull RandomSource random, double x, double y, double z) {
        FancySoundInstance fancySoundInstance;
        Intrinsics.checkNotNullParameter((Object)soundEvent, (String)"soundEvent");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        FancySoundInstance $this$createInstance_u24lambda_u240 = fancySoundInstance = new FancySoundInstance(soundEvent, source, Math.max(0.8f, volume), pitch, false, random, x, y, z);
        boolean bl = false;
        $this$createInstance_u24lambda_u240.addEffect((AudioEffect)ReverbPreset.create$default((ReverbPreset)ReverbPresets.EFX_REVERB_PRESET_MOOD_MEMORY, null, (int)1, null));
        return fancySoundInstance;
    }
}

