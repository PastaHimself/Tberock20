/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Holder
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundSoundPacket
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Holder;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=5, xi=48, d1={"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r\u001aJ\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r\u001aD\u0010\u000f\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r\u001aJ\u0010\u000f\u001a\u00020\u0001*\u00020\u00102\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r\u00a8\u0006\u0011"}, d2={"trySendSound", "", "Lnet/minecraft/world/entity/player/Player;", "sound", "Lnet/minecraft/sounds/SoundEvent;", "volume", "", "pitch", "source", "Lnet/minecraft/sounds/SoundSource;", "pos", "Lnet/minecraft/world/phys/Vec3;", "seed", "", "Lnet/minecraft/core/Holder;", "sendSound", "Lnet/minecraft/server/level/ServerPlayer;", "brokencore-common"}, xs="net/thebrokenscript/brokencore/api/dsl/PlayerUtil")
final class PlayerUtil__PlayerSoundDSLKt {
    public static final void trySendSound(@NotNull Player $this$trySendSound, @NotNull SoundEvent sound, float volume, float pitch, @NotNull SoundSource source, @NotNull Vec3 pos, long seed) {
        Intrinsics.checkNotNullParameter((Object)$this$trySendSound, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        if ($this$trySendSound instanceof ServerPlayer) {
            PlayerUtil.sendSound((ServerPlayer)$this$trySendSound, sound, volume, pitch, source, pos, seed);
        }
    }

    public static /* synthetic */ void trySendSound$default(Player player, SoundEvent soundEvent, float f, float f2, SoundSource soundSource, Vec3 vec3, long l, int n, Object object) {
        if ((n & 2) != 0) {
            f = 1.0f;
        }
        if ((n & 4) != 0) {
            f2 = 1.0f;
        }
        if ((n & 8) != 0) {
            soundSource = SoundSource.MASTER;
        }
        if ((n & 0x10) != 0) {
            Vec3 vec32 = player.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"position(...)");
            vec3 = vec32;
        }
        if ((n & 0x20) != 0) {
            l = player.level().random.nextLong();
        }
        PlayerUtil.trySendSound(player, soundEvent, f, f2, soundSource, vec3, l);
    }

    public static final void trySendSound(@NotNull Player $this$trySendSound, @NotNull Holder<SoundEvent> sound, float volume, float pitch, @NotNull SoundSource source, @NotNull Vec3 pos, long seed) {
        Intrinsics.checkNotNullParameter((Object)$this$trySendSound, (String)"<this>");
        Intrinsics.checkNotNullParameter(sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        if ($this$trySendSound instanceof ServerPlayer) {
            PlayerUtil.sendSound((ServerPlayer)$this$trySendSound, sound, volume, pitch, source, pos, seed);
        }
    }

    public static /* synthetic */ void trySendSound$default(Player player, Holder holder, float f, float f2, SoundSource soundSource, Vec3 vec3, long l, int n, Object object) {
        if ((n & 2) != 0) {
            f = 1.0f;
        }
        if ((n & 4) != 0) {
            f2 = 1.0f;
        }
        if ((n & 8) != 0) {
            soundSource = SoundSource.MASTER;
        }
        if ((n & 0x10) != 0) {
            Vec3 vec32 = player.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"position(...)");
            vec3 = vec32;
        }
        if ((n & 0x20) != 0) {
            l = player.level().random.nextLong();
        }
        PlayerUtil.trySendSound(player, (Holder<SoundEvent>)holder, f, f2, soundSource, vec3, l);
    }

    public static final void sendSound(@NotNull ServerPlayer $this$sendSound, @NotNull SoundEvent sound, float volume, float pitch, @NotNull SoundSource source, @NotNull Vec3 pos, long seed) {
        Intrinsics.checkNotNullParameter((Object)$this$sendSound, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Holder holder = Holder.direct((Object)sound);
        Intrinsics.checkNotNullExpressionValue((Object)holder, (String)"direct(...)");
        PlayerUtil.sendSound($this$sendSound, (Holder<SoundEvent>)holder, volume, pitch, source, pos, seed);
    }

    public static /* synthetic */ void sendSound$default(ServerPlayer serverPlayer, SoundEvent soundEvent, float f, float f2, SoundSource soundSource, Vec3 vec3, long l, int n, Object object) {
        if ((n & 2) != 0) {
            f = 1.0f;
        }
        if ((n & 4) != 0) {
            f2 = 1.0f;
        }
        if ((n & 8) != 0) {
            soundSource = SoundSource.MASTER;
        }
        if ((n & 0x10) != 0) {
            Vec3 vec32 = serverPlayer.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"position(...)");
            vec3 = vec32;
        }
        if ((n & 0x20) != 0) {
            l = serverPlayer.level().random.nextLong();
        }
        PlayerUtil.sendSound(serverPlayer, soundEvent, f, f2, soundSource, vec3, l);
    }

    public static final void sendSound(@NotNull ServerPlayer $this$sendSound, @NotNull Holder<SoundEvent> sound, float volume, float pitch, @NotNull SoundSource source, @NotNull Vec3 pos, long seed) {
        Intrinsics.checkNotNullParameter((Object)$this$sendSound, (String)"<this>");
        Intrinsics.checkNotNullParameter(sound, (String)"sound");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        $this$sendSound.connection.send((Packet)new ClientboundSoundPacket(sound, source, pos.x, pos.y, pos.z, volume, pitch, seed));
    }

    public static /* synthetic */ void sendSound$default(ServerPlayer serverPlayer, Holder holder, float f, float f2, SoundSource soundSource, Vec3 vec3, long l, int n, Object object) {
        if ((n & 2) != 0) {
            f = 1.0f;
        }
        if ((n & 4) != 0) {
            f2 = 1.0f;
        }
        if ((n & 8) != 0) {
            soundSource = SoundSource.MASTER;
        }
        if ((n & 0x10) != 0) {
            Vec3 vec32 = serverPlayer.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"position(...)");
            vec3 = vec32;
        }
        if ((n & 0x20) != 0) {
            l = serverPlayer.level().random.nextLong();
        }
        PlayerUtil.sendSound(serverPlayer, (Holder<SoundEvent>)holder, f, f2, soundSource, vec3, l);
    }
}

