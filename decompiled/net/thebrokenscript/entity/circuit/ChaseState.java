/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.circuit;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/entity/circuit/ChaseState;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "SEEKING_CLIMB", "thebrokenscript-common"})
public final class ChaseState
extends Enum<ChaseState> {
    public static final /* enum */ ChaseState NORMAL = new ChaseState();
    public static final /* enum */ ChaseState SEEKING_CLIMB = new ChaseState();
    private static final /* synthetic */ ChaseState[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static ChaseState[] values() {
        return (ChaseState[])$VALUES.clone();
    }

    public static ChaseState valueOf(String value) {
        return Enum.valueOf(ChaseState.class, value);
    }

    @NotNull
    public static EnumEntries<ChaseState> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = chaseStateArray = new ChaseState[]{ChaseState.NORMAL, ChaseState.SEEKING_CLIMB};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

