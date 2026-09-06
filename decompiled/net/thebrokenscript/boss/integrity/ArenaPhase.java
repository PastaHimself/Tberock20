/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.boss.integrity;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0000j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/boss/integrity/ArenaPhase;", "", "<init>", "(Ljava/lang/String;I)V", "Phase1", "Phase2", "Phase3", "next", "thebrokenscript-common"})
public final class ArenaPhase
extends Enum<ArenaPhase> {
    public static final /* enum */ ArenaPhase Phase1 = new ArenaPhase();
    public static final /* enum */ ArenaPhase Phase2 = new ArenaPhase();
    public static final /* enum */ ArenaPhase Phase3 = new ArenaPhase();
    private static final /* synthetic */ ArenaPhase[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    @Nullable
    public final ArenaPhase next() {
        return switch (WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 1 -> Phase2;
            case 2 -> Phase3;
            case 3 -> null;
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    public static ArenaPhase[] values() {
        return (ArenaPhase[])$VALUES.clone();
    }

    public static ArenaPhase valueOf(String value) {
        return Enum.valueOf(ArenaPhase.class, value);
    }

    @NotNull
    public static EnumEntries<ArenaPhase> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = arenaPhaseArray = new ArenaPhase[]{ArenaPhase.Phase1, ArenaPhase.Phase2, ArenaPhase.Phase3};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[ArenaPhase.values().length];
            try {
                nArray[ArenaPhase.Phase1.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ArenaPhase.Phase2.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[ArenaPhase.Phase3.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

