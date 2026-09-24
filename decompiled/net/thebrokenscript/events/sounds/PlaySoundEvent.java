/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.core.Holder
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundStopSoundPacket
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.RandomUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.sounds;

import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.core.Holder;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.TBSEvent;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.RandomUtil;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/events/sounds/PlaySoundEvent;", "Lnet/thebrokenscript/api/event/TBSEvent;", "<init>", "()V", "sounds", "", "Lnet/minecraft/core/Holder;", "Lnet/minecraft/sounds/SoundEvent;", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
public final class PlaySoundEvent
extends TBSEvent {
    @NotNull
    private final Set<Holder<SoundEvent>> sounds;

    public PlaySoundEvent() {
        super(1);
        Object[] objectArray = new Holder[]{SoundEvents.AMBIENT_CAVE, SoundEvents.MUSIC_DISC_13, SoundEvents.MUSIC_DISC_11, TBSSounds.NULL_FLEE, null};
        this.sounds = SetsKt.setOf((Object[])objectArray);
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Holder sound = (Holder)CollectionsKt.random((Collection)this.sounds, (Random)((Random)Random.Default));
        if (sound == null) {
            player.connection.send((Packet)new ClientboundStopSoundPacket(null, null));
        } else if (Intrinsics.areEqual((Object)sound, TBSSounds.NULL_FLEE)) {
            Vec3 vec3 = player.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            PlayerUtil.sendSound$default((ServerPlayer)player, (Holder)sound, (float)10.0f, (float)1.0f, (SoundSource)SoundSource.AMBIENT, (Vec3)vec3, (long)0L, (int)32, null);
        } else {
            RandomSource randomSource = level.random;
            Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
            float f = RandomUtil.nextFloat((RandomSource)randomSource, (float)0.0f, (float)1.0f);
            Vec3 vec3 = player.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            PlayerUtil.sendSound$default((ServerPlayer)player, (Holder)sound, (float)10.0f, (float)f, (SoundSource)SoundSource.AMBIENT, (Vec3)vec3, (long)0L, (int)32, null);
        }
    }
}

