/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.anomaly.sa2.transforming;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/entity/anomaly/sa2/transforming/SubAnomaly2Type;", "", "<init>", "(Ljava/lang/String;I)V", "SPIDER", "STALK", "MIMIC", "BREAK_LIGHT", "SPIDER_TO_STALK", "STALK_TO_DIVEBOMB", "DIVEBOMB_TO_STALK", "DIVEBOMB", "SPIDER_TO_CANNONBALL", "CANNONBALL_TO_SPIDER", "CANNONBALL", "STALK_TO_SPIDER", "MIMIC_TO_SPIDER", "SPIDER_TO_MIMIC", "thebrokenscript-common"})
public final class SubAnomaly2Type
extends Enum<SubAnomaly2Type> {
    public static final /* enum */ SubAnomaly2Type SPIDER = new SubAnomaly2Type();
    public static final /* enum */ SubAnomaly2Type STALK = new SubAnomaly2Type();
    public static final /* enum */ SubAnomaly2Type MIMIC = new SubAnomaly2Type();
    public static final /* enum */ SubAnomaly2Type BREAK_LIGHT = new SubAnomaly2Type();
    public static final /* enum */ SubAnomaly2Type SPIDER_TO_STALK = new SubAnomaly2Type();
    public static final /* enum */ SubAnomaly2Type STALK_TO_DIVEBOMB = new SubAnomaly2Type();
    public static final /* enum */ SubAnomaly2Type DIVEBOMB_TO_STALK = new SubAnomaly2Type();
    public static final /* enum */ SubAnomaly2Type DIVEBOMB = new SubAnomaly2Type();
    public static final /* enum */ SubAnomaly2Type SPIDER_TO_CANNONBALL = new SubAnomaly2Type();
    public static final /* enum */ SubAnomaly2Type CANNONBALL_TO_SPIDER = new SubAnomaly2Type();
    public static final /* enum */ SubAnomaly2Type CANNONBALL = new SubAnomaly2Type();
    public static final /* enum */ SubAnomaly2Type STALK_TO_SPIDER = new SubAnomaly2Type();
    public static final /* enum */ SubAnomaly2Type MIMIC_TO_SPIDER = new SubAnomaly2Type();
    public static final /* enum */ SubAnomaly2Type SPIDER_TO_MIMIC = new SubAnomaly2Type();
    private static final /* synthetic */ SubAnomaly2Type[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static SubAnomaly2Type[] values() {
        return (SubAnomaly2Type[])$VALUES.clone();
    }

    public static SubAnomaly2Type valueOf(String value) {
        return Enum.valueOf(SubAnomaly2Type.class, value);
    }

    @NotNull
    public static EnumEntries<SubAnomaly2Type> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = subAnomaly2TypeArray = new SubAnomaly2Type[]{SubAnomaly2Type.SPIDER, SubAnomaly2Type.STALK, SubAnomaly2Type.MIMIC, SubAnomaly2Type.BREAK_LIGHT, SubAnomaly2Type.SPIDER_TO_STALK, SubAnomaly2Type.STALK_TO_DIVEBOMB, SubAnomaly2Type.DIVEBOMB_TO_STALK, SubAnomaly2Type.DIVEBOMB, SubAnomaly2Type.SPIDER_TO_CANNONBALL, SubAnomaly2Type.CANNONBALL_TO_SPIDER, SubAnomaly2Type.CANNONBALL, SubAnomaly2Type.STALK_TO_SPIDER, SubAnomaly2Type.MIMIC_TO_SPIDER, SubAnomaly2Type.SPIDER_TO_MIMIC};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

