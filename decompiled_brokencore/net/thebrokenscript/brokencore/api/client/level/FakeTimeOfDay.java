/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.level;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.client.level.FakeTimeOfDayInfo;
import net.thebrokenscript.brokencore.api.queue.QueuedTask;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.brokencore.impl.client.BCClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u000bJ\u0006\u0010\u0018\u001a\u00020\u000bJ\u0006\u0010\u0019\u001a\u00020\u000bJ\u0006\u0010\u001a\u001a\u00020\u000bR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/level/FakeTimeOfDay;", "", "<init>", "()V", "TIME_OF_DAY", "", "IN_EFFECT", "", "currentTask", "Lnet/thebrokenscript/brokencore/api/queue/QueuedTask;", "postApply", "", "set", "time", "", "reset", "enable", "disable", "apply", "data", "Lnet/thebrokenscript/brokencore/api/client/level/FakeTimeOfDayInfo;", "Lnet/thebrokenscript/brokencore/api/world/TimeOfDay;", "setDay", "setNoon", "setNight", "setMidnight", "tick", "brokencore-common"})
public final class FakeTimeOfDay {
    @NotNull
    public static final FakeTimeOfDay INSTANCE = new FakeTimeOfDay();
    @JvmField
    public static float TIME_OF_DAY;
    @JvmField
    public static boolean IN_EFFECT;
    @Nullable
    private static QueuedTask currentTask;

    private FakeTimeOfDay() {
    }

    private final void postApply() {
        QueuedTask queuedTask = currentTask;
        if (queuedTask != null) {
            queuedTask.cancel();
        }
        currentTask = BCClient.INSTANCE.getQueue().add(2400L, (Function0<Unit>)((Function0)FakeTimeOfDay::postApply$lambda$0));
    }

    public final void set(@NotNull Number time2) {
        Intrinsics.checkNotNullParameter((Object)time2, (String)"time");
        TIME_OF_DAY = time2.floatValue() / 24000.0f - 0.25f;
        IN_EFFECT = true;
        this.postApply();
    }

    public final void reset() {
        TIME_OF_DAY = 0.0f;
        IN_EFFECT = false;
    }

    public final void enable() {
        IN_EFFECT = true;
        this.postApply();
    }

    public final void disable() {
        IN_EFFECT = false;
    }

    public final void apply(@NotNull FakeTimeOfDayInfo data2) {
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        TIME_OF_DAY = data2.getTime() / 24000.0f - 0.25f;
        IN_EFFECT = data2.getEnabled();
        this.postApply();
    }

    public final void set(@NotNull TimeOfDay time2) {
        Intrinsics.checkNotNullParameter((Object)((Object)time2), (String)"time");
        this.set(time2.getTime());
    }

    public final void setDay() {
        this.set(TimeOfDay.DAY);
    }

    public final void setNoon() {
        this.set(TimeOfDay.NOON);
    }

    public final void setNight() {
        this.set(TimeOfDay.NIGHT);
    }

    public final void setMidnight() {
        this.set(TimeOfDay.MIDNIGHT);
    }

    public final void tick() {
        if (!IN_EFFECT) {
            return;
        }
        TIME_OF_DAY = ((TIME_OF_DAY + 0.25f) * 24000.0f + 1.0f) / 24000.0f - 0.25f;
    }

    private static final Unit postApply$lambda$0() {
        IN_EFFECT = false;
        return Unit.INSTANCE;
    }
}

