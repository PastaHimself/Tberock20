/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.Decoder
 *  com.mojang.serialization.Encoder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.network.FriendlyByteBuf
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.network;

import com.mojang.serialization.Codec;
import com.mojang.serialization.Decoder;
import com.mojang.serialization.Encoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.thebrokenscript.brokencore.api.ext.CodecExt;
import net.thebrokenscript.brokencore.api.network.BaseDataPacket;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0000*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\rJ\u0015\u0010\u000e\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a2\u0006\u0002\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/network/CodecPacket;", "P", "T", "Lnet/thebrokenscript/brokencore/api/network/BaseDataPacket;", "codec", "Lcom/mojang/serialization/Codec;", "<init>", "(Lcom/mojang/serialization/Codec;)V", "write", "", "buf", "Lnet/minecraft/network/FriendlyByteBuf;", "packet", "(Lnet/minecraft/network/FriendlyByteBuf;Lnet/thebrokenscript/brokencore/api/network/CodecPacket;)V", "read", "(Lnet/minecraft/network/FriendlyByteBuf;)Lnet/thebrokenscript/brokencore/api/network/CodecPacket;", "brokencore-common"})
public abstract class CodecPacket<P extends CodecPacket<P, T>, T>
extends BaseDataPacket<P, T> {
    @NotNull
    private final Codec<T> codec;

    public CodecPacket(@NotNull Codec<T> codec) {
        Intrinsics.checkNotNullParameter(codec, (String)"codec");
        this.codec = codec;
    }

    @Override
    public void write(@NotNull FriendlyByteBuf buf, @NotNull P packet) {
        Intrinsics.checkNotNullParameter((Object)buf, (String)"buf");
        Intrinsics.checkNotNullParameter(packet, (String)"packet");
        if (((BaseDataPacket)packet).getData() == null) {
            v0 = buf.writeBoolean(false);
        } else {
            buf.writeBoolean(true);
            Encoder encoder = (Encoder)this.codec;
            Object t = ((BaseDataPacket)packet).getData();
            Intrinsics.checkNotNull(t);
            v0 = buf.writeNbt(CodecExt.INSTANCE.encodeNbtOrThrow(encoder, t));
        }
    }

    @Override
    @NotNull
    public P read(@NotNull FriendlyByteBuf buf) {
        Object t;
        Intrinsics.checkNotNullParameter((Object)buf, (String)"buf");
        Object p = this.factory();
        CodecPacket $this$read_u24lambda_u240 = (CodecPacket)p;
        boolean bl = false;
        if (buf.readBoolean()) {
            Decoder decoder = (Decoder)$this$read_u24lambda_u240.codec;
            CompoundTag compoundTag = buf.readNbt();
            Intrinsics.checkNotNull((Object)compoundTag);
            t = CodecExt.INSTANCE.decodeNbtOrThrow(decoder, (Tag)compoundTag);
        } else {
            t = null;
        }
        $this$read_u24lambda_u240.setData(t);
        return (P)((CodecPacket)p);
    }
}

