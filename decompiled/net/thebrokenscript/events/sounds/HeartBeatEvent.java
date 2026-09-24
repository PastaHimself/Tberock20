/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Holder$Reference
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.world.TimeOfDay
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.sounds;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.TBSEvent;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/events/sounds/HeartBeatEvent;", "Lnet/thebrokenscript/api/event/TBSEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
public final class HeartBeatEvent
extends TBSEvent {
    public HeartBeatEvent() {
        super(1);
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        TimeOfDay.NIGHT.setFake();
        if ((double)level.random.nextFloat() < 0.5) {
            LevelAccessor levelAccessor = (LevelAccessor)level;
            Holder.Reference reference = SoundEvents.AMBIENT_CAVE;
            Intrinsics.checkNotNullExpressionValue((Object)reference, (String)"AMBIENT_CAVE");
            SoundUtil.tryBroadcastSound$default((LevelAccessor)levelAccessor, (Holder)((Holder)reference), (float)1.0f, (float)0.0f, null, (int)8, null);
            SoundUtil.tryBroadcastSound$default((LevelAccessor)((LevelAccessor)level), (Holder)((Holder)TBSSounds.HEARTBEAT), (float)1.0f, (float)1.0f, null, (int)8, null);
        }
    }
}

