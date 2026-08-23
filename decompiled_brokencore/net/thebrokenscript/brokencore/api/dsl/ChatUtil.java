/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.chat.ChatType
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.FilterMask
 *  net.minecraft.network.chat.MessageSignatureCache
 *  net.minecraft.network.chat.SignedMessageBody
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundPlayerChatPacket
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.level.LevelAccessor
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FilterMask;
import net.minecraft.network.chat.MessageSignatureCache;
import net.minecraft.network.chat.SignedMessageBody;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundPlayerChatPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\t2\u0006\u0010\n\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2={"chat", "", "Lnet/minecraft/world/level/LevelAccessor;", "component", "Lnet/minecraft/network/chat/Component;", "bypassHiddenChat", "", "(Lnet/minecraft/world/level/LevelAccessor;Lnet/minecraft/network/chat/Component;Z)Lkotlin/Unit;", "say", "Lnet/minecraft/server/level/ServerPlayer;", "msg", "brokencore-common"})
@JvmName(name="ChatUtil")
public final class ChatUtil {
    @Nullable
    public static final Unit chat(@NotNull LevelAccessor $this$chat, @NotNull Component component, boolean bypassHiddenChat) {
        Unit unit;
        Intrinsics.checkNotNullParameter((Object)$this$chat, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)component, (String)"component");
        MinecraftServer minecraftServer = $this$chat.getServer();
        if (minecraftServer != null && (minecraftServer = minecraftServer.getPlayerList()) != null) {
            minecraftServer.broadcastSystemMessage(component, bypassHiddenChat);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        return unit;
    }

    public static /* synthetic */ Unit chat$default(LevelAccessor levelAccessor, Component component, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return ChatUtil.chat(levelAccessor, component, bl);
    }

    public static final void say(@NotNull ServerPlayer $this$say, @NotNull Component msg) {
        Intrinsics.checkNotNullParameter((Object)$this$say, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)msg, (String)"msg");
        $this$say.server.getPlayerList().broadcastAll((Packet)new ClientboundPlayerChatPacket($this$say.getUUID(), 0, null, SignedMessageBody.unsigned((String)"").pack(MessageSignatureCache.createDefault()), msg, FilterMask.PASS_THROUGH, ChatType.bind((ResourceKey)ChatType.CHAT, (Entity)((Entity)$this$say))));
    }
}

