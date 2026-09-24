/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"gameDays", "", "getGameDays", "(I)I", "brokencore-common"})
@JvmName(name="TimeUtil")
public final class TimeUtil {
    public static final int getGameDays(int $this$gameDays) {
        return 24000 * $this$gameDays;
    }
}

