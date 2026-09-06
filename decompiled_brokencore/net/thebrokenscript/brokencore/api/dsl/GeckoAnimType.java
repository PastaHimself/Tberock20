/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/brokencore/api/dsl/GeckoAnimType;", "", "<init>", "(Ljava/lang/String;I)V", "PLAY_HOLD", "LOOP", "PLAY_ONCE", "brokencore-common"})
final class GeckoAnimType
extends Enum<GeckoAnimType> {
    public static final /* enum */ GeckoAnimType PLAY_HOLD = new GeckoAnimType();
    public static final /* enum */ GeckoAnimType LOOP = new GeckoAnimType();
    public static final /* enum */ GeckoAnimType PLAY_ONCE = new GeckoAnimType();
    private static final /* synthetic */ GeckoAnimType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static GeckoAnimType[] values() {
        return (GeckoAnimType[])$VALUES.clone();
    }

    public static GeckoAnimType valueOf(String value) {
        return Enum.valueOf(GeckoAnimType.class, value);
    }

    @NotNull
    public static EnumEntries<GeckoAnimType> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = geckoAnimTypeArray = new GeckoAnimType[]{GeckoAnimType.PLAY_HOLD, GeckoAnimType.LOOP, GeckoAnimType.PLAY_ONCE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

