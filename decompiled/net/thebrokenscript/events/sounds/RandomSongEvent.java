/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Position
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.world.TimeOfDay
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.sounds;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.TBSEvent;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/events/sounds/RandomSongEvent;", "Lnet/thebrokenscript/api/event/TBSEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
public final class RandomSongEvent
extends TBSEvent {
    public RandomSongEvent() {
        super(1);
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        this.queue(1L, () -> RandomSongEvent.execute$lambda$0(player, this, level));
    }

    private static final Unit execute$lambda$0(ServerPlayer $player, RandomSongEvent this$0, ServerLevel $level) {
        PlayerUtil.stopAllSounds((Player)((Player)$player));
        PlayerUtil.sendSound$default((ServerPlayer)$player, (Holder)((Holder)TBSSounds.RANDOM_SONG), (float)10.0f, (float)0.0f, null, null, (long)0L, (int)60, null);
        TimeOfDay.MIDNIGHT.setFake();
        $player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 320, 1, false, false));
        $player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 320, 1, false, false));
        $player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 320, 1, false, false));
        this$0.queue(320L, () -> RandomSongEvent.execute$lambda$0$0($level, $player));
        return Unit.INSTANCE;
    }

    private static final Unit execute$lambda$0$0(ServerLevel $level, ServerPlayer $player) {
        if ((double)$level.random.nextFloat() < 0.5 && $level.canSeeSkyFromBelowWater(BlockPos.containing((Position)((Position)$player.position())))) {
            EntityType entityType = EntityType.LIGHTNING_BOLT;
            Intrinsics.checkNotNullExpressionValue((Object)entityType, (String)"LIGHTNING_BOLT");
            LevelAccessor levelAccessor = (LevelAccessor)$level;
            Vec3 vec3 = $player.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)levelAccessor, (Vec3)vec3);
        }
        return Unit.INSTANCE;
    }
}

