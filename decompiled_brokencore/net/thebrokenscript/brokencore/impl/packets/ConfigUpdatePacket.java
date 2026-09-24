/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.Unpooled
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.player.Player
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.packets;

import io.netty.buffer.Unpooled;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.thebrokenscript.brokencore.api.BCApi;
import net.thebrokenscript.brokencore.api.config.ConfigContainer;
import net.thebrokenscript.brokencore.api.network.BaseDataPacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0000H\u0016J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/impl/packets/ConfigUpdatePacket;", "Lnet/thebrokenscript/brokencore/api/network/BaseDataPacket;", "Lnet/minecraft/network/FriendlyByteBuf;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "write", "", "buf", "packet", "read", "handle", "data", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "brokencore-common"})
public final class ConfigUpdatePacket
extends BaseDataPacket<ConfigUpdatePacket, FriendlyByteBuf> {
    @NotNull
    private final ResourceLocation id = BCApi.id("config_update");

    @Override
    @NotNull
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public void write(@NotNull FriendlyByteBuf buf, @NotNull ConfigUpdatePacket packet) {
        Intrinsics.checkNotNullParameter((Object)buf, (String)"buf");
        Intrinsics.checkNotNullParameter((Object)packet, (String)"packet");
        FriendlyByteBuf friendlyByteBuf = (FriendlyByteBuf)packet.getData();
        if (friendlyByteBuf == null) {
            throw new IllegalStateException("Cannot write null data");
        }
        FriendlyByteBuf sourceBuffer = friendlyByteBuf;
        buf.writeVarInt(sourceBuffer.readableBytes());
        buf.writeBytes(sourceBuffer.slice());
    }

    @Override
    @NotNull
    public ConfigUpdatePacket read(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter((Object)buf, (String)"buf");
        Object p = this.factory();
        ConfigUpdatePacket $this$read_u24lambda_u240 = (ConfigUpdatePacket)p;
        boolean bl = false;
        int length = buf.readVarInt();
        byte[] bytes = new byte[length];
        buf.readBytes(bytes);
        $this$read_u24lambda_u240.setData(new FriendlyByteBuf(Unpooled.wrappedBuffer((byte[])bytes)));
        return (ConfigUpdatePacket)p;
    }

    @Override
    public void handle(@NotNull FriendlyByteBuf data2, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (cx.isClientbound) {
            return;
        }
        Player player = cx.getPlayer();
        if (!(player != null ? player.hasPermissions(4) : false)) {
            return;
        }
        cx.getEnqueueWork().invoke(() -> ConfigUpdatePacket.handle$lambda$0(data2));
    }

    private static final void handle$lambda$0(FriendlyByteBuf $data) {
        ConfigContainer.Companion.onUpdate($data);
    }
}

