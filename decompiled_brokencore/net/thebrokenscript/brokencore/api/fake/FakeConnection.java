/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.network.Connection
 *  net.minecraft.network.PacketListener
 *  net.minecraft.network.protocol.PacketFlow
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.fake;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.network.Connection;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.PacketFlow;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/fake/FakeConnection;", "Lnet/minecraft/network/Connection;", "<init>", "()V", "setListenerForServerboundHandshake", "", "packetListener", "Lnet/minecraft/network/PacketListener;", "brokencore-common"})
public final class FakeConnection
extends Connection {
    public FakeConnection() {
        super(PacketFlow.SERVERBOUND);
    }

    public void setListenerForServerboundHandshake(@NotNull PacketListener packetListener) {
        Intrinsics.checkNotNullParameter((Object)packetListener, (String)"packetListener");
    }
}

