/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.player.Player
 *  net.thebrokenscript.brokencore.api.dsl.ComponentUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.chat;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.dsl.ComponentUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.handlers.subs.ServerChatSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSLang;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/handlers/chat/ChatAlertHandler;", "", "<init>", "()V", "onChat", "", "sender", "Lnet/minecraft/server/level/ServerPlayer;", "message", "", "cancelProxy", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "thebrokenscript-common"})
public final class ChatAlertHandler {
    @NotNull
    public static final ChatAlertHandler INSTANCE = new ChatAlertHandler();

    private ChatAlertHandler() {
    }

    private final void onChat(ServerPlayer sender, String message, CancelProxy cancelProxy) {
        if ((double)sender.getRandom().nextFloat() < 0.01) {
            Player player = (Player)sender;
            String string = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getALERT_TITLE()));
            Intrinsics.checkNotNull((Object)string);
            String string2 = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getALERT_HERE_I_AM()));
            Intrinsics.checkNotNull((Object)string2);
            PlayerUtil.tryShowAlert((Player)player, (String)string, (String)string2);
        }
    }

    static {
        ServerChatSubscriber.INSTANCE.add((Function3<? super ServerPlayer, ? super String, ? super CancelProxy, Unit>)((Function3)new Function3<ServerPlayer, String, CancelProxy, Unit>((Object)INSTANCE){

            public final void invoke(ServerPlayer p0, String p1, CancelProxy p2) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
                ((ChatAlertHandler)this.receiver).onChat(p0, p1, p2);
            }
        }));
    }
}

