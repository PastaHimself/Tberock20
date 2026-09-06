/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.network.BasePacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0000*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0001H\u0016\u00a2\u0006\u0002\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00020\u0012H&\u00a2\u0006\u0002\u0010\u0013J\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0016\u00a2\u0006\u0002\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0001X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/network/BaseDataPacket;", "P", "T", "Lnet/thebrokenscript/brokencore/api/network/BasePacket;", "<init>", "()V", "data", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "of", "dataIn", "(Ljava/lang/Object;)Lnet/thebrokenscript/brokencore/api/network/BaseDataPacket;", "handle", "", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "(Ljava/lang/Object;Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;)V", "packet", "(Lnet/thebrokenscript/brokencore/api/network/BaseDataPacket;Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;)V", "brokencore-common"})
public abstract class BaseDataPacket<P extends BaseDataPacket<P, T>, T>
extends BasePacket<P> {
    @Nullable
    private T data;

    @Nullable
    protected final T getData() {
        return this.data;
    }

    protected final void setData(@Nullable T t) {
        this.data = t;
    }

    @NotNull
    public P of(T dataIn) {
        Object p = this.factory();
        BaseDataPacket $this$of_u24lambda_u240 = (BaseDataPacket)p;
        boolean bl = false;
        $this$of_u24lambda_u240.data = dataIn;
        return (P)((BaseDataPacket)p);
    }

    @Override
    public abstract void handle(T var1, @NotNull PacketHandlerContext var2);

    @Override
    public void handle(@NotNull P packet, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter(packet, (String)"packet");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        if (((BaseDataPacket)packet).data == null) {
            throw new IllegalStateException("Packet data is null!");
        }
        T t = ((BaseDataPacket)packet).data;
        Intrinsics.checkNotNull(t);
        this.handle((P)t, cx);
    }
}

