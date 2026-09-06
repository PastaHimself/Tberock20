/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.event.StoryEvent
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
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
import kotlin.text.StringsKt;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.event.StoryEvent;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.util.time.Time;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/events/story/TXTStoryEvent;", "Lnet/thebrokenscript/brokencore/api/event/StoryEvent;", "<init>", "()V", "execute", "", "server", "Lnet/minecraft/server/MinecraftServer;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTXTStoryEvent.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TXTStoryEvent.kt\nnet/thebrokenscript/events/story/TXTStoryEvent\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,25:1\n1869#2,2:26\n*S KotlinDebug\n*F\n+ 1 TXTStoryEvent.kt\nnet/thebrokenscript/events/story/TXTStoryEvent\n*L\n17#1:26,2\n*E\n"})
public final class TXTStoryEvent
extends StoryEvent {
    public TXTStoryEvent() {
        Number[] numberArray = new Number[]{Time.INSTANCE.days(5) + 1000, Time.INSTANCE.days(10) + 1000, Time.INSTANCE.days(15) + 1000, Time.INSTANCE.days(20) + 1000};
        super(numberArray);
    }

    protected void execute(@NotNull MinecraftServer server) {
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        if (!PlatformUtil.Companion.isProduction()) {
            return;
        }
        List list = server.getPlayerList().getPlayers();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getPlayers(...)");
        Iterable $this$forEach$iv = list;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerPlayer player = (ServerPlayer)element$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)player);
            PlayerUtil.sendPacket((ServerPlayer)player, (CustomPacketPayload)((CustomPacketPayload)TBSPackets.WRITE_TXT_PACKET));
            if (PlayerExt.INSTANCE.getVars((Player)player).getSawTxtHint()) continue;
            PlayerUtil.tryShowAlert((Player)((Player)player), (String)"err.file", (String)StringsKt.replace$default((String)PlayerExt.INSTANCE.getVars((Player)player).getUserDir(), (String)"\\", (String)"/", (boolean)false, (int)4, null));
            PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)TXTStoryEvent::execute$lambda$0$0));
        }
    }

    private static final Unit execute$lambda$0$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setSawTxtHint(true);
        return Unit.INSTANCE;
    }
}

