/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.player;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.handlers.subs.PlayerLoggedInSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/handlers/player/JoinMessageSender;", "", "<init>", "()V", "onPlayerLoggedIn", "", "player", "Lnet/minecraft/world/entity/player/Player;", "thebrokenscript-common"})
public final class JoinMessageSender {
    @NotNull
    public static final JoinMessageSender INSTANCE = new JoinMessageSender();

    private JoinMessageSender() {
    }

    private final void onPlayerLoggedIn(Player player) {
        block2: {
            MinecraftServer minecraftServer = player.getServer();
            if (minecraftServer == null) {
                return;
            }
            MinecraftServer server = minecraftServer;
            if (!server.isSingleplayer() || server.getPlayerList().getPlayerCount() > 1) {
                return;
            }
            MinecraftServer minecraftServer2 = player.getServer();
            if (minecraftServer2 == null || (minecraftServer2 = minecraftServer2.getPlayerList()) == null) break block2;
            Object[] objectArray = new Object[]{player.getDisplayName()};
            minecraftServer2.broadcastSystemMessage((Component)Component.translatable((String)"multiplayer.player.joined", (Object[])objectArray).withStyle(ChatFormatting.YELLOW), false);
        }
    }

    static {
        PlayerLoggedInSubscriber.INSTANCE.add((Function1<? super Player, Unit>)((Function1)new Function1<Player, Unit>((Object)INSTANCE){

            public final void invoke(Player p0) {
                Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                ((JoinMessageSender)this.receiver).onPlayerLoggedIn(p0);
            }
        }));
    }
}

