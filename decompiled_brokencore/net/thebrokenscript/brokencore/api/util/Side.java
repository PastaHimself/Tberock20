/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0000j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/util/Side;", "", "<init>", "(Ljava/lang/String;I)V", "CLIENT", "SERVER", "BOTH", "isCompatible", "", "current", "brokencore-common"})
public final class Side
extends Enum<Side> {
    public static final /* enum */ Side CLIENT = new Side();
    public static final /* enum */ Side SERVER = new Side();
    public static final /* enum */ Side BOTH = new Side();
    private static final /* synthetic */ Side[] $VALUES;
    private static final /* synthetic */ EnumEntries $ENTRIES;

    public final boolean isCompatible(@NotNull Side current) {
        Intrinsics.checkNotNullParameter((Object)((Object)current), (String)"current");
        return switch (WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 1 -> true;
            case 2 -> {
                if (current == CLIENT) {
                    yield true;
                }
                yield false;
            }
            case 3 -> {
                if (current == SERVER) {
                    yield true;
                }
                yield false;
            }
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    public static Side[] values() {
        return (Side[])$VALUES.clone();
    }

    public static Side valueOf(String value) {
        return Enum.valueOf(Side.class, value);
    }

    @NotNull
    public static EnumEntries<Side> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES = sideArray = new Side[]{Side.CLIENT, Side.SERVER, Side.BOTH};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Side.values().length];
            try {
                nArray[Side.BOTH.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Side.CLIENT.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Side.SERVER.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

