/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.fractured.attacks;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/entity/fractured/attacks/JimAttackType;", "", "<init>", "(Ljava/lang/String;I)V", "NOOP", "STOMP", "SLAM", "MOON_ROCK_TOSS", "AIR_LIFT", "thebrokenscript-common"})
public final class JimAttackType
extends Enum<JimAttackType> {
    public static final /* enum */ JimAttackType NOOP = new JimAttackType();
    public static final /* enum */ JimAttackType STOMP = new JimAttackType();
    public static final /* enum */ JimAttackType SLAM = new JimAttackType();
    public static final /* enum */ JimAttackType MOON_ROCK_TOSS = new JimAttackType();
    public static final /* enum */ JimAttackType AIR_LIFT = new JimAttackType();
    private static final /* synthetic */ JimAttackType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static JimAttackType[] values() {
        return (JimAttackType[])$VALUES.clone();
    }

    public static JimAttackType valueOf(String value) {
        return Enum.valueOf(JimAttackType.class, value);
    }

    @NotNull
    public static EnumEntries<JimAttackType> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = jimAttackTypeArray = new JimAttackType[]{JimAttackType.NOOP, JimAttackType.STOMP, JimAttackType.SLAM, JimAttackType.MOON_ROCK_TOSS, JimAttackType.AIR_LIFT};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

