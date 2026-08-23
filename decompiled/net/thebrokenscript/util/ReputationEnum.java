/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.util;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/util/ReputationEnum;", "", "<init>", "(Ljava/lang/String;I)V", "BAD", "NORMAL", "GOOD", "thebrokenscript-common"})
public final class ReputationEnum
extends Enum<ReputationEnum> {
    public static final /* enum */ ReputationEnum BAD = new ReputationEnum();
    public static final /* enum */ ReputationEnum NORMAL = new ReputationEnum();
    public static final /* enum */ ReputationEnum GOOD = new ReputationEnum();
    private static final /* synthetic */ ReputationEnum[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static ReputationEnum[] values() {
        return (ReputationEnum[])$VALUES.clone();
    }

    public static ReputationEnum valueOf(String value) {
        return Enum.valueOf(ReputationEnum.class, value);
    }

    @NotNull
    public static EnumEntries<ReputationEnum> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = reputationEnumArray = new ReputationEnum[]{ReputationEnum.BAD, ReputationEnum.NORMAL, ReputationEnum.GOOD};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

