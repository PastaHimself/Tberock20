/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Holder$Reference
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.nullent;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.event.NullEvent;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.registry.TBSMenus;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/events/nullent/FakeDisconnectEvent;", "Lnet/thebrokenscript/api/event/NullEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
public final class FakeDisconnectEvent
extends NullEvent {
    public FakeDisconnectEvent() {
        super(1);
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        TBSMenus.FAKE_DISCONNECT.open(player, (Component)TBSLang.INSTANCE.getDISCONNECTED_2());
        PlayerUtil.stopAllSounds((Player)((Player)player));
        PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)FakeDisconnectEvent::execute$lambda$0));
        Player player2 = (Player)player;
        Holder.Reference reference = SoundEvents.MUSIC_MENU;
        Intrinsics.checkNotNullExpressionValue((Object)reference, (String)"MUSIC_MENU");
        PlayerUtil.trySendSound$default((Player)player2, (Holder)((Holder)reference), (float)0.0f, (float)0.0f, null, null, (long)0L, (int)62, null);
        TheBrokenScript.serverWorkQueue.add(100L, () -> FakeDisconnectEvent.execute$lambda$1(player));
    }

    private static final Unit execute$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setMusicCausedByTBS(true);
        return Unit.INSTANCE;
    }

    private static final Unit execute$lambda$1(ServerPlayer $player) {
        $player.closeContainer();
        PlayerUtil.stopAllSounds((Player)((Player)$player));
        PlayerExt.INSTANCE.updateVars((Player)$player, (Function1<? super PlayerVariables, Unit>)((Function1)FakeDisconnectEvent::execute$lambda$1$0));
        return Unit.INSTANCE;
    }

    private static final Unit execute$lambda$1$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setMusicCausedByTBS(false);
        return Unit.INSTANCE;
    }
}

