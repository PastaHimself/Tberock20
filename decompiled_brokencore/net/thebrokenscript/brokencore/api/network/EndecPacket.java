/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  io.wispforest.endec.Endec
 *  io.wispforest.endec.Serializer
 *  io.wispforest.endec.format.bytebuf.ByteBufDeserializer
 *  io.wispforest.endec.format.bytebuf.ByteBufSerializer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.FriendlyByteBuf
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.network;

import io.netty.buffer.ByteBuf;
import io.wispforest.endec.Endec;
import io.wispforest.endec.Serializer;
import io.wispforest.endec.format.bytebuf.ByteBufDeserializer;
import io.wispforest.endec.format.bytebuf.ByteBufSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.FriendlyByteBuf;
import net.thebrokenscript.brokencore.api.network.BaseDataPacket;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0000*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\rJ\u0015\u0010\u000e\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a2\u0006\u0002\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "P", "T", "Lnet/thebrokenscript/brokencore/api/network/BaseDataPacket;", "endec", "Lio/wispforest/endec/Endec;", "<init>", "(Lio/wispforest/endec/Endec;)V", "write", "", "buf", "Lnet/minecraft/network/FriendlyByteBuf;", "packet", "(Lnet/minecraft/network/FriendlyByteBuf;Lnet/thebrokenscript/brokencore/api/network/EndecPacket;)V", "read", "(Lnet/minecraft/network/FriendlyByteBuf;)Lnet/thebrokenscript/brokencore/api/network/EndecPacket;", "brokencore-common"})
public abstract class EndecPacket<P extends EndecPacket<P, T>, T>
extends BaseDataPacket<P, T> {
    @NotNull
    private final Endec<T> endec;

    public EndecPacket(@NotNull Endec<T> endec2) {
        Intrinsics.checkNotNullParameter(endec2, (String)"endec");
        this.endec = endec2;
    }

    @Override
    public void write(@NotNull FriendlyByteBuf buf, @NotNull P packet) {
        Intrinsics.checkNotNullParameter((Object)buf, (String)"buf");
        Intrinsics.checkNotNullParameter(packet, (String)"packet");
        if (((BaseDataPacket)packet).getData() == null) {
            v0 = buf.writeBoolean(false);
        } else {
            buf.writeBoolean(true);
            v0 = (FriendlyByteBuf)this.endec.encodeFully(() -> EndecPacket.write$lambda$0(buf), ((BaseDataPacket)packet).getData());
        }
    }

    @Override
    @NotNull
    public P read(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter((Object)buf, (String)"buf");
        Object p = this.factory();
        EndecPacket $this$read_u24lambda_u240 = (EndecPacket)p;
        boolean bl = false;
        $this$read_u24lambda_u240.setData(buf.readBoolean() ? $this$read_u24lambda_u240.endec.decodeFully(ByteBufDeserializer::of, (Object)buf) : null);
        return (P)((EndecPacket)p);
    }

    private static final Serializer write$lambda$0(FriendlyByteBuf $buf) {
        return (Serializer)ByteBufSerializer.of((ByteBuf)((ByteBuf)$buf));
    }
}

