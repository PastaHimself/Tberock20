/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Deserializer
 *  io.wispforest.endec.Endec
 *  io.wispforest.endec.SerializationContext
 *  io.wispforest.endec.Serializer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.network.endec;

import io.wispforest.endec.Deserializer;
import io.wispforest.endec.Endec;
import io.wispforest.endec.SerializationContext;
import io.wispforest.endec.Serializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.thebrokenscript.brokencore.api.util.ByteUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u001c\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/network/endec/BlockPosEndec;", "Lio/wispforest/endec/Endec;", "Lnet/minecraft/core/BlockPos;", "<init>", "()V", "encode", "", "ctx", "Lio/wispforest/endec/SerializationContext;", "serializer", "Lio/wispforest/endec/Serializer;", "value", "decode", "deserializer", "Lio/wispforest/endec/Deserializer;", "brokencore-common"})
public final class BlockPosEndec
implements Endec<BlockPos> {
    @NotNull
    public static final BlockPosEndec INSTANCE = new BlockPosEndec();

    private BlockPosEndec() {
    }

    public void encode(@NotNull SerializationContext ctx, @NotNull Serializer<?> serializer, @NotNull BlockPos value) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        Intrinsics.checkNotNullParameter(serializer, (String)"serializer");
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        serializer.writeBytes(ctx, ByteUtil.INSTANCE.blockPosToBytes(value));
    }

    @NotNull
    public BlockPos decode(@NotNull SerializationContext ctx, @NotNull Deserializer<?> deserializer) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        Intrinsics.checkNotNullParameter(deserializer, (String)"deserializer");
        byte[] byArray = deserializer.readBytes(ctx);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"readBytes(...)");
        return ByteUtil.INSTANCE.bytesToBlockPos(byArray);
    }
}

