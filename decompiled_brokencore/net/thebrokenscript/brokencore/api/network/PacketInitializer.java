/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.network.BasePacket;
import net.thebrokenscript.brokencore.api.platform.PlatformNetworking;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u0002H\u0005\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u00062\u0006\u0010\u0007\u001a\u0002H\u0005H\u0004\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/network/PacketInitializer;", "", "<init>", "()V", "register", "P", "Lnet/thebrokenscript/brokencore/api/network/BasePacket;", "packet", "(Lnet/thebrokenscript/brokencore/api/network/BasePacket;)Lnet/thebrokenscript/brokencore/api/network/BasePacket;", "brokencore-common"})
public class PacketInitializer {
    @NotNull
    protected final <P extends BasePacket<P>> P register(@NotNull P packet) {
        Intrinsics.checkNotNullParameter(packet, (String)"packet");
        return PlatformNetworking.Companion.getINSTANCE().registerPacket(packet);
    }
}

