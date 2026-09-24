/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.random.Random
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.misc;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/misc/UwuManager;", "", "<init>", "()V", "NUMBERS", "", "MAX_CHANCE", "", "shouldBeUwu", "", "brokencore-common"})
public final class UwuManager {
    @NotNull
    public static final UwuManager INSTANCE = new UwuManager();
    @NotNull
    private static final int[] NUMBERS;
    private static final int MAX_CHANCE = 100000;

    private UwuManager() {
    }

    @JvmStatic
    public static final boolean shouldBeUwu() {
        return Random.Default.nextInt(0, 100000) == ArraysKt.random((int[])NUMBERS, (Random)((Random)Random.Default)) || Calendar.getInstance().get(5) == 1 && Calendar.getInstance().get(2) == 3;
    }

    static {
        int[] nArray = new int[]{69, 420, 666, 6669, 2025, 2020, 4311, 8008, 111, 999, 2312, 5808, 8690, 1001, 4, 5, 21, 8};
        NUMBERS = nArray;
    }
}

