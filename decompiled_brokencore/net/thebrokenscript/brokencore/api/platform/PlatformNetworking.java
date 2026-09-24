/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.platform;

import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.thebrokenscript.brokencore.api.network.BasePacket;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007\"\u00020\u0005H&\u00a2\u0006\u0002\u0010\bJ1\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007\"\u00020\u0005H&\u00a2\u0006\u0002\u0010\fJ)\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007\"\u00020\u0005H&\u00a2\u0006\u0002\u0010\bJ1\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007\"\u00020\u0005H&\u00a2\u0006\u0002\u0010\u0011J%\u0010\u0012\u001a\u0002H\u0013\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u00142\u0006\u0010\u0004\u001a\u0002H\u0013H&\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformNetworking;", "", "sendToAllPlayers", "", "packet", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "packets", "", "(Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;[Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;)V", "sendToPlayer", "player", "Lnet/minecraft/server/level/ServerPlayer;", "(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;[Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;)V", "sendToServer", "sendToPlayersInLevel", "level", "Lnet/minecraft/server/level/ServerLevel;", "(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;[Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;)V", "registerPacket", "P", "Lnet/thebrokenscript/brokencore/api/network/BasePacket;", "(Lnet/thebrokenscript/brokencore/api/network/BasePacket;)Lnet/thebrokenscript/brokencore/api/network/BasePacket;", "Companion", "brokencore-common"})
public interface PlatformNetworking {
    @NotNull
    public static final Companion Companion = net.thebrokenscript.brokencore.api.platform.PlatformNetworking$Companion.$$INSTANCE;

    public void sendToAllPlayers(@NotNull CustomPacketPayload var1, CustomPacketPayload ... var2);

    public void sendToPlayer(@NotNull ServerPlayer var1, @NotNull CustomPacketPayload var2, CustomPacketPayload ... var3);

    public void sendToServer(@NotNull CustomPacketPayload var1, CustomPacketPayload ... var2);

    public void sendToPlayersInLevel(@NotNull ServerLevel var1, @NotNull CustomPacketPayload var2, CustomPacketPayload ... var3);

    @NotNull
    public <P extends BasePacket<P>> P registerPacket(@NotNull P var1);

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformNetworking$Companion;", "", "<init>", "()V", "INSTANCE", "Lnet/thebrokenscript/brokencore/api/platform/PlatformNetworking;", "getINSTANCE", "()Lnet/thebrokenscript/brokencore/api/platform/PlatformNetworking;", "brokencore-common"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        private static final PlatformNetworking INSTANCE;

        private Companion() {
        }

        @NotNull
        public final PlatformNetworking getINSTANCE() {
            return INSTANCE;
        }

        static {
            $$INSTANCE = new Companion();
            ServiceLoader<PlatformNetworking> serviceLoader = ServiceLoader.load(PlatformNetworking.class);
            Intrinsics.checkNotNullExpressionValue(serviceLoader, (String)"load(...)");
            Object object = CollectionsKt.first((Iterable)serviceLoader);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"first(...)");
            INSTANCE = (PlatformNetworking)object;
        }
    }
}

