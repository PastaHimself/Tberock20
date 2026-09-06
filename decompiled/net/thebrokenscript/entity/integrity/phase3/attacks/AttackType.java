/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.integrity.phase3.attacks;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/entity/integrity/phase3/attacks/AttackType;", "", "<init>", "(Ljava/lang/String;I)V", "NOOP", "GRAVITY", "GROUND_ATTACK", "TENTACLE_SWIPE", "FIREBALL", "TENTACLES", "thebrokenscript-common"})
public final class AttackType
extends Enum<AttackType> {
    public static final /* enum */ AttackType NOOP = new AttackType();
    public static final /* enum */ AttackType GRAVITY = new AttackType();
    public static final /* enum */ AttackType GROUND_ATTACK = new AttackType();
    public static final /* enum */ AttackType TENTACLE_SWIPE = new AttackType();
    public static final /* enum */ AttackType FIREBALL = new AttackType();
    public static final /* enum */ AttackType TENTACLES = new AttackType();
    private static final /* synthetic */ AttackType[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public static AttackType[] values() {
        return (AttackType[])$VALUES.clone();
    }

    public static AttackType valueOf(String value) {
        return Enum.valueOf(AttackType.class, value);
    }

    @NotNull
    public static EnumEntries<AttackType> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = attackTypeArray = new AttackType[]{AttackType.NOOP, AttackType.GRAVITY, AttackType.GROUND_ATTACK, AttackType.TENTACLE_SWIPE, AttackType.FIREBALL, AttackType.TENTACLES};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }
}

