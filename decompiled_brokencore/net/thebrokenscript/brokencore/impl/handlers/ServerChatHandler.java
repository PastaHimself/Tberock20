/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.handlers;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.thebrokenscript.brokencore.api.registry.BCRegistries;
import net.thebrokenscript.brokencore.api.responses.ChatResponse;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/impl/handlers/ServerChatHandler;", "", "<init>", "()V", "handle", "", "sender", "Lnet/minecraft/server/level/ServerPlayer;", "message", "", "brokencore-common"})
public final class ServerChatHandler {
    @NotNull
    public static final ServerChatHandler INSTANCE = new ServerChatHandler();

    private ServerChatHandler() {
    }

    public final void handle(@NotNull ServerPlayer sender, @NotNull String message) {
        Intrinsics.checkNotNullParameter((Object)sender, (String)"sender");
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
        if (!BCConfigs.INSTANCE.getServer().getChat().getEnableChatResponses()) {
            return;
        }
        for (Map.Entry entry : BCRegistries.CHAT_RESPONSE.entrySet()) {
            Intrinsics.checkNotNull((Object)entry);
            ChatResponse response = (ChatResponse)entry.getValue();
            if (!response.check(message)) continue;
            ServerLevel serverLevel = sender.serverLevel();
            Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"serverLevel(...)");
            response.execute(serverLevel, sender);
            break;
        }
    }
}

