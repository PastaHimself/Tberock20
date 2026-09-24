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

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u001b\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dj\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/util/RepTier;", "", "amount", "", "<init>", "(Ljava/lang/String;II)V", "getAmount", "()I", "GAIN_TEENYTINY", "GAIN_BABY", "GAIN_MINOR", "GAIN_SMALL", "GAIN_RARE", "GAIN_MEDIUM", "GAIN_WELLDONE", "GAIN_HUGE", "GAIN_ILY", "LOSS_TEENYTINY", "LOSS_BABY", "LOSS_MINOR", "LOSS_SMALL", "LOSS_RARE", "LOSS_MEDIUM", "LOSS_WELLDONE", "LOSS_HUGE", "LOSS_IHY", "REGAIN_HALF", "isLoss", "", "()Z", "thebrokenscript-common"})
public final class RepTier
extends Enum<RepTier> {
    private final int amount;
    public static final /* enum */ RepTier GAIN_TEENYTINY = new RepTier(1);
    public static final /* enum */ RepTier GAIN_BABY = new RepTier(5);
    public static final /* enum */ RepTier GAIN_MINOR = new RepTier(10);
    public static final /* enum */ RepTier GAIN_SMALL = new RepTier(15);
    public static final /* enum */ RepTier GAIN_RARE = new RepTier(20);
    public static final /* enum */ RepTier GAIN_MEDIUM = new RepTier(25);
    public static final /* enum */ RepTier GAIN_WELLDONE = new RepTier(30);
    public static final /* enum */ RepTier GAIN_HUGE = new RepTier(35);
    public static final /* enum */ RepTier GAIN_ILY = new RepTier(50);
    public static final /* enum */ RepTier LOSS_TEENYTINY = new RepTier(-1);
    public static final /* enum */ RepTier LOSS_BABY = new RepTier(-5);
    public static final /* enum */ RepTier LOSS_MINOR = new RepTier(-10);
    public static final /* enum */ RepTier LOSS_SMALL = new RepTier(-15);
    public static final /* enum */ RepTier LOSS_RARE = new RepTier(-20);
    public static final /* enum */ RepTier LOSS_MEDIUM = new RepTier(-25);
    public static final /* enum */ RepTier LOSS_WELLDONE = new RepTier(-30);
    public static final /* enum */ RepTier LOSS_HUGE = new RepTier(-35);
    public static final /* enum */ RepTier LOSS_IHY = new RepTier(-50);
    public static final /* enum */ RepTier REGAIN_HALF = new RepTier(0);
    private static final /* synthetic */ RepTier[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    private RepTier(int amount) {
        this.amount = amount;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final boolean isLoss() {
        return this.amount < 0;
    }

    public static RepTier[] values() {
        return (RepTier[])$VALUES.clone();
    }

    public static RepTier valueOf(String value) {
        return Enum.valueOf(RepTier.class, value);
    }

    @NotNull
    public static EnumEntries<RepTier> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = repTierArray = new RepTier[]{RepTier.GAIN_TEENYTINY, RepTier.GAIN_BABY, RepTier.GAIN_MINOR, RepTier.GAIN_SMALL, RepTier.GAIN_RARE, RepTier.GAIN_MEDIUM, RepTier.GAIN_WELLDONE, RepTier.GAIN_HUGE, RepTier.GAIN_ILY, RepTier.LOSS_TEENYTINY, RepTier.LOSS_BABY, RepTier.LOSS_MINOR, RepTier.LOSS_SMALL, RepTier.LOSS_RARE, RepTier.LOSS_MEDIUM, RepTier.LOSS_WELLDONE, RepTier.LOSS_HUGE, RepTier.LOSS_IHY, RepTier.REGAIN_HALF};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

