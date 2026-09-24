/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Holder$Reference
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.misc;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.NullEvent;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/events/misc/OpenGLErrorEvent;", "Lnet/thebrokenscript/api/event/NullEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
public final class OpenGLErrorEvent
extends NullEvent {
    public OpenGLErrorEvent() {
        super(1);
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        this.queue(1L, () -> OpenGLErrorEvent.execute$lambda$0(player));
        this.queue(20L, () -> OpenGLErrorEvent.execute$lambda$1(player));
        this.queue(40L, () -> OpenGLErrorEvent.execute$lambda$2(player));
        this.queue(60L, () -> OpenGLErrorEvent.execute$lambda$3(player));
        this.queue(100L, () -> OpenGLErrorEvent.execute$lambda$4(player, level));
    }

    private static final Unit execute$lambda$0(ServerPlayer $player) {
        $player.sendSystemMessage((Component)TBSLang.INSTANCE.getOPENGL_INVALID_OPERATION());
        return Unit.INSTANCE;
    }

    private static final Unit execute$lambda$1(ServerPlayer $player) {
        $player.sendSystemMessage((Component)TBSLang.INSTANCE.getOPENGL_INVALID_OPERATION());
        return Unit.INSTANCE;
    }

    private static final Unit execute$lambda$2(ServerPlayer $player) {
        $player.sendSystemMessage((Component)TBSLang.INSTANCE.getOPENGL_INVALID_OPERATION());
        return Unit.INSTANCE;
    }

    private static final Unit execute$lambda$3(ServerPlayer $player) {
        $player.sendSystemMessage((Component)TBSLang.INSTANCE.getOPENGL_INVALID_OPERATION());
        return Unit.INSTANCE;
    }

    private static final Unit execute$lambda$4(ServerPlayer $player, ServerLevel $level) {
        $player.sendSystemMessage((Component)TBSLang.INSTANCE.getOPENGL_HERE_I_AM());
        LevelAccessor levelAccessor = (LevelAccessor)$level;
        Holder.Reference reference = SoundEvents.AMBIENT_CAVE;
        Intrinsics.checkNotNullExpressionValue((Object)reference, (String)"AMBIENT_CAVE");
        SoundUtil.tryBroadcastSound$default((LevelAccessor)levelAccessor, (Holder)((Holder)reference), (float)10.0f, (float)0.0f, null, (int)8, null);
        return Unit.INSTANCE;
    }
}

