/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util.time;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/util/time/Time;", "", "<init>", "()V", "MINS_PER_DAY", "", "SECS_PER_DAY", "TICKS_PER_DAY", "days", "brokencore-common"})
public final class Time {
    @NotNull
    public static final Time INSTANCE = new Time();
    public static final int MINS_PER_DAY = 20;
    public static final int SECS_PER_DAY = 1200;
    public static final int TICKS_PER_DAY = 24000;

    private Time() {
    }

    public final int days(int days) {
        return 24000 * days;
    }
}

