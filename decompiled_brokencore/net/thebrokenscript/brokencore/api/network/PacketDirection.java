/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.network;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/brokencore/api/network/PacketDirection;", "", "<init>", "(Ljava/lang/String;I)V", "CLIENTBOUND", "SERVERBOUND", "brokencore-common"})
public final class PacketDirection
extends Enum<PacketDirection> {
    public static final /* enum */ PacketDirection CLIENTBOUND = new PacketDirection();
    public static final /* enum */ PacketDirection SERVERBOUND = new PacketDirection();
    private static final /* synthetic */ PacketDirection[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static PacketDirection[] values() {
        return (PacketDirection[])$VALUES.clone();
    }

    public static PacketDirection valueOf(String value) {
        return Enum.valueOf(PacketDirection.class, value);
    }

    @NotNull
    public static EnumEntries<PacketDirection> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = packetDirectionArray = new PacketDirection[]{PacketDirection.CLIENTBOUND, PacketDirection.SERVERBOUND};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

