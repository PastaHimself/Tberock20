/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.event.StoryEvent
 *  net.thebrokenscript.brokencore.api.util.time.Time
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.story;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.event.StoryEvent;
import net.thebrokenscript.brokencore.api.util.time.Time;
import net.thebrokenscript.data.PlayerVariables;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/events/story/CoordsStoryEvent;", "Lnet/thebrokenscript/brokencore/api/event/StoryEvent;", "<init>", "()V", "execute", "", "server", "Lnet/minecraft/server/MinecraftServer;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCoordsStoryEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoordsStoryEvent.kt\nnet/thebrokenscript/events/story/CoordsStoryEvent\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,29:1\n1869#2,2:30\n1869#2,2:32\n*S KotlinDebug\n*F\n+ 1 CoordsStoryEvent.kt\nnet/thebrokenscript/events/story/CoordsStoryEvent\n*L\n14#1:30,2\n21#1:32,2\n*E\n"})
public final class CoordsStoryEvent
extends StoryEvent {
    public CoordsStoryEvent() {
        Number[] numberArray = new Number[]{Time.INSTANCE.days(6) + 1000};
        super(numberArray);
    }

    protected void execute(@NotNull MinecraftServer server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        List players = server.getPlayerList().getPlayers();
        Intrinsics.checkNotNull((Object)players);
        Iterable $this$forEach$iv = players;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerPlayer player = (ServerPlayer)element$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)player);
            if (PlayerExt.INSTANCE.getVars((Player)player).getShowCoords()) continue;
            PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)CoordsStoryEvent::execute$lambda$0$0));
        }
        TheBrokenScript.serverWorkQueue.add(1200L, () -> CoordsStoryEvent.execute$lambda$1(players));
    }

    private static final Unit execute$lambda$0$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setShowCoords(true);
        return Unit.INSTANCE;
    }

    private static final Unit execute$lambda$1(List $players) {
        Intrinsics.checkNotNull((Object)$players);
        Iterable $this$forEach$iv = $players;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerPlayer player = (ServerPlayer)element$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)player);
            if (!PlayerExt.INSTANCE.getVars((Player)player).getShowCoords()) continue;
            PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)CoordsStoryEvent::execute$lambda$1$0$0));
        }
        return Unit.INSTANCE;
    }

    private static final Unit execute$lambda$1$0$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setShowCoords(false);
        return Unit.INSTANCE;
    }
}

