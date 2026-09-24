/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Position
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.dsl;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a7\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\r\u001a=\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u000f\u001aG\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u0013\u001aM\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u0014\u001a>\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a8\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a8\u0006\u0017"}, d2={"playSound", "", "Lnet/minecraft/world/level/LevelAccessor;", "pos", "Lnet/minecraft/world/phys/Vec3;", "sound", "Lnet/minecraft/sounds/SoundEvent;", "volume", "", "pitch", "source", "Lnet/minecraft/sounds/SoundSource;", "tryBroadcastSound", "(Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/sounds/SoundEvent;FFLnet/minecraft/sounds/SoundSource;)Lkotlin/Unit;", "Lnet/minecraft/core/Holder;", "(Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/core/Holder;FFLnet/minecraft/sounds/SoundSource;)Lkotlin/Unit;", "tryBroadcastSoundInRange", "range", "", "(Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/phys/Vec3;Ljava/lang/Number;Lnet/minecraft/sounds/SoundEvent;FFLnet/minecraft/sounds/SoundSource;)Lkotlin/Unit;", "(Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/world/phys/Vec3;Ljava/lang/Number;Lnet/minecraft/core/Holder;FFLnet/minecraft/sounds/SoundSource;)Lkotlin/Unit;", "tryPlaySound", "Lnet/minecraft/world/level/Level;", "brokencore-common"})
@JvmName(name="SoundUtil")
@SourceDebugExtension(value={"SMAP\nSoundDSL.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SoundDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/SoundUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,64:1\n1869#2,2:65\n1869#2,2:67\n*S KotlinDebug\n*F\n+ 1 SoundDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/SoundUtil\n*L\n28#1:65,2\n47#1:67,2\n*E\n"})
public final class SoundUtil {
    public static final void playSound(@NotNull LevelAccessor $this$playSound, @NotNull Vec3 pos, @NotNull SoundEvent sound, float volume, float pitch, @NotNull SoundSource source) {
        Intrinsics.checkNotNullParameter((Object)$this$playSound, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        if ($this$playSound instanceof Level) {
            SoundUtil.tryPlaySound((Level)$this$playSound, pos, sound, volume, pitch, source);
        }
    }

    public static /* synthetic */ void playSound$default(LevelAccessor levelAccessor, Vec3 vec3, SoundEvent soundEvent, float f, float f2, SoundSource soundSource, int n, Object object) {
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        if ((n & 8) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x10) != 0) {
            soundSource = SoundSource.NEUTRAL;
        }
        SoundUtil.playSound(levelAccessor, vec3, soundEvent, f, f2, soundSource);
    }

    @Nullable
    public static final Unit tryBroadcastSound(@NotNull LevelAccessor $this$tryBroadcastSound, @NotNull SoundEvent sound, float volume, float pitch, @NotNull SoundSource source) {
        Intrinsics.checkNotNullParameter((Object)$this$tryBroadcastSound, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Holder holder = Holder.direct((Object)sound);
        Intrinsics.checkNotNullExpressionValue((Object)holder, (String)"direct(...)");
        return SoundUtil.tryBroadcastSound($this$tryBroadcastSound, (Holder<SoundEvent>)holder, volume, pitch, source);
    }

    public static /* synthetic */ Unit tryBroadcastSound$default(LevelAccessor levelAccessor, SoundEvent soundEvent, float f, float f2, SoundSource soundSource, int n, Object object) {
        if ((n & 2) != 0) {
            f = 1.0f;
        }
        if ((n & 4) != 0) {
            f2 = 1.0f;
        }
        if ((n & 8) != 0) {
            soundSource = SoundSource.NEUTRAL;
        }
        return SoundUtil.tryBroadcastSound(levelAccessor, soundEvent, f, f2, soundSource);
    }

    @Nullable
    public static final Unit tryBroadcastSound(@NotNull LevelAccessor $this$tryBroadcastSound, @NotNull Holder<SoundEvent> sound, float volume, float pitch, @NotNull SoundSource source) {
        Unit unit;
        Intrinsics.checkNotNullParameter((Object)$this$tryBroadcastSound, (String)"<this>");
        Intrinsics.checkNotNullParameter(sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Object object = $this$tryBroadcastSound instanceof ServerLevel ? (ServerLevel)$this$tryBroadcastSound : null;
        if (object != null && (object = object.players()) != null) {
            Iterable $this$forEach$iv = (Iterable)object;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                ServerPlayer it = (ServerPlayer)element$iv;
                boolean bl = false;
                Intrinsics.checkNotNull((Object)it);
                PlayerUtil.trySendSound$default((Player)it, sound, volume, pitch, source, null, 0L, 48, null);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        return unit;
    }

    public static /* synthetic */ Unit tryBroadcastSound$default(LevelAccessor levelAccessor, Holder holder, float f, float f2, SoundSource soundSource, int n, Object object) {
        if ((n & 2) != 0) {
            f = 1.0f;
        }
        if ((n & 4) != 0) {
            f2 = 1.0f;
        }
        if ((n & 8) != 0) {
            soundSource = SoundSource.NEUTRAL;
        }
        return SoundUtil.tryBroadcastSound(levelAccessor, (Holder<SoundEvent>)holder, f, f2, soundSource);
    }

    @Nullable
    public static final Unit tryBroadcastSoundInRange(@NotNull LevelAccessor $this$tryBroadcastSoundInRange, @NotNull Vec3 pos, @NotNull Number range, @NotNull SoundEvent sound, float volume, float pitch, @NotNull SoundSource source) {
        Intrinsics.checkNotNullParameter((Object)$this$tryBroadcastSoundInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)range, (String)"range");
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Holder holder = Holder.direct((Object)sound);
        Intrinsics.checkNotNullExpressionValue((Object)holder, (String)"direct(...)");
        return SoundUtil.tryBroadcastSoundInRange($this$tryBroadcastSoundInRange, pos, range, (Holder<SoundEvent>)holder, volume, pitch, source);
    }

    public static /* synthetic */ Unit tryBroadcastSoundInRange$default(LevelAccessor levelAccessor, Vec3 vec3, Number number, SoundEvent soundEvent, float f, float f2, SoundSource soundSource, int n, Object object) {
        if ((n & 8) != 0) {
            f = 1.0f;
        }
        if ((n & 0x10) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x20) != 0) {
            soundSource = SoundSource.NEUTRAL;
        }
        return SoundUtil.tryBroadcastSoundInRange(levelAccessor, vec3, number, soundEvent, f, f2, soundSource);
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public static final Unit tryBroadcastSoundInRange(@NotNull LevelAccessor $this$tryBroadcastSoundInRange, @NotNull Vec3 pos, @NotNull Number range, @NotNull Holder<SoundEvent> sound, float volume, float pitch, @NotNull SoundSource source) {
        Unit unit;
        List<ServerPlayer> list;
        ServerLevel serverLevel;
        Intrinsics.checkNotNullParameter((Object)$this$tryBroadcastSoundInRange, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)range, (String)"range");
        Intrinsics.checkNotNullParameter(sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        ServerLevel serverLevel2 = serverLevel = $this$tryBroadcastSoundInRange instanceof ServerLevel ? (ServerLevel)$this$tryBroadcastSoundInRange : null;
        if (serverLevel != null && (list = EntityFinder.findPlayersInRange(serverLevel, pos, range)) != null) {
            void $this$forEach$iv;
            Iterable iterable = list;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                ServerPlayer it = (ServerPlayer)element$iv;
                boolean bl = false;
                PlayerUtil.trySendSound$default((Player)it, sound, volume, pitch, source, pos, 0L, 32, null);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        return unit;
    }

    public static /* synthetic */ Unit tryBroadcastSoundInRange$default(LevelAccessor levelAccessor, Vec3 vec3, Number number, Holder holder, float f, float f2, SoundSource soundSource, int n, Object object) {
        if ((n & 8) != 0) {
            f = 1.0f;
        }
        if ((n & 0x10) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x20) != 0) {
            soundSource = SoundSource.NEUTRAL;
        }
        return SoundUtil.tryBroadcastSoundInRange(levelAccessor, vec3, number, (Holder<SoundEvent>)holder, f, f2, soundSource);
    }

    public static final void playSound(@NotNull LevelAccessor $this$playSound, @NotNull Vec3 pos, @NotNull Holder<SoundEvent> sound, float volume, float pitch, @NotNull SoundSource source) {
        Intrinsics.checkNotNullParameter((Object)$this$playSound, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter(sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Object object = sound.value();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"value(...)");
        SoundUtil.playSound($this$playSound, pos, (SoundEvent)object, volume, pitch, source);
    }

    public static /* synthetic */ void playSound$default(LevelAccessor levelAccessor, Vec3 vec3, Holder holder, float f, float f2, SoundSource soundSource, int n, Object object) {
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        if ((n & 8) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x10) != 0) {
            soundSource = SoundSource.NEUTRAL;
        }
        SoundUtil.playSound(levelAccessor, vec3, (Holder<SoundEvent>)holder, f, f2, soundSource);
    }

    public static final void tryPlaySound(@NotNull Level $this$tryPlaySound, @NotNull Vec3 pos, @NotNull SoundEvent sound, float volume, float pitch, @NotNull SoundSource source) {
        Intrinsics.checkNotNullParameter((Object)$this$tryPlaySound, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        if (!$this$tryPlaySound.isClientSide()) {
            $this$tryPlaySound.playSound(null, BlockPos.containing((Position)((Position)pos)), sound, source, volume, pitch);
        }
    }

    public static /* synthetic */ void tryPlaySound$default(Level level, Vec3 vec3, SoundEvent soundEvent, float f, float f2, SoundSource soundSource, int n, Object object) {
        if ((n & 4) != 0) {
            f = 1.0f;
        }
        if ((n & 8) != 0) {
            f2 = 1.0f;
        }
        if ((n & 0x10) != 0) {
            soundSource = SoundSource.NEUTRAL;
        }
        SoundUtil.tryPlaySound(level, vec3, soundEvent, f, f2, soundSource);
    }
}

