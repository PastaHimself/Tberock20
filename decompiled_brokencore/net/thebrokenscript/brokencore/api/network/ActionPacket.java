/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.FriendlyByteBuf
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.FriendlyByteBuf;
import net.thebrokenscript.brokencore.api.network.BasePacket;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000b\u0010\u0005\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00028\u00002\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H&\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/network/ActionPacket;", "P", "Lnet/thebrokenscript/brokencore/api/network/BasePacket;", "<init>", "()V", "create", "()Lnet/thebrokenscript/brokencore/api/network/ActionPacket;", "write", "", "buf", "Lnet/minecraft/network/FriendlyByteBuf;", "packet", "(Lnet/minecraft/network/FriendlyByteBuf;Lnet/thebrokenscript/brokencore/api/network/ActionPacket;)V", "read", "(Lnet/minecraft/network/FriendlyByteBuf;)Lnet/thebrokenscript/brokencore/api/network/ActionPacket;", "handle", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "(Lnet/thebrokenscript/brokencore/api/network/ActionPacket;Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;)V", "brokencore-common"})
public abstract class ActionPacket<P extends ActionPacket<P>>
extends BasePacket<P> {
    @NotNull
    public final P create() {
        return (P)((ActionPacket)this.factory());
    }

    @Override
    public void write(@NotNull FriendlyByteBuf buf, @NotNull P packet) {
        Intrinsics.checkNotNullParameter((Object)buf, (String)"buf");
        Intrinsics.checkNotNullParameter(packet, (String)"packet");
    }

    @Override
    @NotNull
    public P read(@NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter((Object)buf, (String)"buf");
        return (P)((ActionPacket)this.factory());
    }

    @Override
    public void handle(@NotNull P packet, @NotNull PacketHandlerContext cx) {
        Intrinsics.checkNotNullParameter(packet, (String)"packet");
        Intrinsics.checkNotNullParameter((Object)cx, (String)"cx");
        this.handle(cx);
    }

    public abstract void handle(@NotNull PacketHandlerContext var1);
}

