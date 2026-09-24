/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  io.wispforest.endec.StructEndec
 *  io.wispforest.endec.impl.StructEndecBuilder
 *  io.wispforest.endec.impl.StructField
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KProperty1
 *  net.minecraft.sounds.SoundEvent
 *  net.thebrokenscript.brokencore.api.util.serde.ExtraEndecs
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.boss.kerfur;

import io.wispforest.endec.Endec;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import io.wispforest.endec.impl.StructField;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import net.minecraft.sounds.SoundEvent;
import net.thebrokenscript.boss.kerfur.CustomMusicPayload;
import net.thebrokenscript.brokencore.api.util.serde.ExtraEndecs;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/boss/kerfur/CustomMusicPayload;", "", "sound", "Lnet/minecraft/sounds/SoundEvent;", "loops", "", "volume", "", "pitch", "gain", "<init>", "(Lnet/minecraft/sounds/SoundEvent;ZFFF)V", "getSound", "()Lnet/minecraft/sounds/SoundEvent;", "getLoops", "()Z", "getVolume", "()F", "getPitch", "getGain", "Companion", "thebrokenscript-common"})
public final class CustomMusicPayload {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final SoundEvent sound;
    private final boolean loops;
    private final float volume;
    private final float pitch;
    private final float gain;
    @NotNull
    private static final Endec<CustomMusicPayload> ENDEC;

    public CustomMusicPayload(@NotNull SoundEvent sound, boolean loops, float volume, float pitch, float gain) {
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        this.sound = sound;
        this.loops = loops;
        this.volume = volume;
        this.pitch = pitch;
        this.gain = gain;
    }

    public /* synthetic */ CustomMusicPayload(SoundEvent soundEvent, boolean bl, float f, float f2, float f3, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        if ((n & 8) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x10) != 0) {
            f3 = 1.0f;
        }
        this(soundEvent, bl, f, f2, f3);
    }

    @NotNull
    public final SoundEvent getSound() {
        return this.sound;
    }

    public final boolean getLoops() {
        return this.loops;
    }

    public final float getVolume() {
        return this.volume;
    }

    public final float getPitch() {
        return this.pitch;
    }

    public final float getGain() {
        return this.gain;
    }

    private static final SoundEvent ENDEC$lambda$0(KProperty1 $tmp0, CustomMusicPayload p0) {
        return (SoundEvent)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Boolean ENDEC$lambda$1(KProperty1 $tmp0, CustomMusicPayload p0) {
        return (Boolean)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Float ENDEC$lambda$2(KProperty1 $tmp0, CustomMusicPayload p0) {
        return (Float)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Float ENDEC$lambda$3(KProperty1 $tmp0, CustomMusicPayload p0) {
        return (Float)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Float ENDEC$lambda$4(KProperty1 $tmp0, CustomMusicPayload p0) {
        return (Float)((Function1)$tmp0).invoke((Object)p0);
    }

    static {
        StructEndec structEndec = StructEndecBuilder.of((StructField)ExtraEndecs.SOUND_EVENT.fieldOf("loops", arg_0 -> CustomMusicPayload.ENDEC$lambda$0((KProperty1)Companion.ENDEC.1.INSTANCE, arg_0)), (StructField)Endec.BOOLEAN.fieldOf("loops", arg_0 -> CustomMusicPayload.ENDEC$lambda$1((KProperty1)Companion.ENDEC.2.INSTANCE, arg_0)), (StructField)Endec.FLOAT.fieldOf("volume", arg_0 -> CustomMusicPayload.ENDEC$lambda$2((KProperty1)Companion.ENDEC.3.INSTANCE, arg_0)), (StructField)Endec.FLOAT.fieldOf("pitch", arg_0 -> CustomMusicPayload.ENDEC$lambda$3((KProperty1)Companion.ENDEC.4.INSTANCE, arg_0)), (StructField)Endec.FLOAT.fieldOf("gain", arg_0 -> CustomMusicPayload.ENDEC$lambda$4((KProperty1)Companion.ENDEC.5.INSTANCE, arg_0)), CustomMusicPayload::new);
        Intrinsics.checkNotNullExpressionValue((Object)structEndec, (String)"of(...)");
        ENDEC = (Endec)structEndec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/boss/kerfur/CustomMusicPayload$Companion;", "", "<init>", "()V", "ENDEC", "Lio/wispforest/endec/Endec;", "Lnet/thebrokenscript/boss/kerfur/CustomMusicPayload;", "getENDEC", "()Lio/wispforest/endec/Endec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Endec<CustomMusicPayload> getENDEC() {
            return ENDEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

