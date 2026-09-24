/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  io.wispforest.endec.StructEndec
 *  io.wispforest.endec.impl.StructEndecBuilder
 *  io.wispforest.endec.impl.StructField
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KProperty1
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.level;

import io.wispforest.endec.Endec;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import io.wispforest.endec.impl.StructField;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import net.thebrokenscript.brokencore.api.client.level.FakeTimeOfDayInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2={"Lnet/thebrokenscript/brokencore/api/client/level/FakeTimeOfDayInfo;", "", "time", "", "enabled", "", "<init>", "(FZ)V", "getTime", "()F", "getEnabled", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "brokencore-common"})
public final class FakeTimeOfDayInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final float time;
    private final boolean enabled;
    @NotNull
    private static final Endec<FakeTimeOfDayInfo> ENDEC;

    public FakeTimeOfDayInfo(float time2, boolean enabled) {
        this.time = time2;
        this.enabled = enabled;
    }

    public final float getTime() {
        return this.time;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final float component1() {
        return this.time;
    }

    public final boolean component2() {
        return this.enabled;
    }

    @NotNull
    public final FakeTimeOfDayInfo copy(float time2, boolean enabled) {
        return new FakeTimeOfDayInfo(time2, enabled);
    }

    public static /* synthetic */ FakeTimeOfDayInfo copy$default(FakeTimeOfDayInfo fakeTimeOfDayInfo, float f, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            f = fakeTimeOfDayInfo.time;
        }
        if ((n & 2) != 0) {
            bl = fakeTimeOfDayInfo.enabled;
        }
        return fakeTimeOfDayInfo.copy(f, bl);
    }

    @NotNull
    public String toString() {
        return "FakeTimeOfDayInfo(time=" + this.time + ", enabled=" + this.enabled + ")";
    }

    public int hashCode() {
        int result = Float.hashCode(this.time);
        result = result * 31 + Boolean.hashCode(this.enabled);
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FakeTimeOfDayInfo)) {
            return false;
        }
        FakeTimeOfDayInfo fakeTimeOfDayInfo = (FakeTimeOfDayInfo)other;
        if (Float.compare(this.time, fakeTimeOfDayInfo.time) != 0) {
            return false;
        }
        return this.enabled == fakeTimeOfDayInfo.enabled;
    }

    private static final Float ENDEC$lambda$0(KProperty1 $tmp0, FakeTimeOfDayInfo p0) {
        return (Float)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Boolean ENDEC$lambda$1(KProperty1 $tmp0, FakeTimeOfDayInfo p0) {
        return (Boolean)((Function1)$tmp0).invoke((Object)p0);
    }

    static {
        StructEndec structEndec = StructEndecBuilder.of((StructField)Endec.FLOAT.fieldOf("time", arg_0 -> FakeTimeOfDayInfo.ENDEC$lambda$0((KProperty1)Companion.ENDEC.1.INSTANCE, arg_0)), (StructField)Endec.BOOLEAN.fieldOf("enabled", arg_0 -> FakeTimeOfDayInfo.ENDEC$lambda$1((KProperty1)Companion.ENDEC.2.INSTANCE, arg_0)), FakeTimeOfDayInfo::new);
        Intrinsics.checkNotNullExpressionValue((Object)structEndec, (String)"of(...)");
        ENDEC = (Endec)structEndec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/client/level/FakeTimeOfDayInfo$Companion;", "", "<init>", "()V", "ENDEC", "Lio/wispforest/endec/Endec;", "Lnet/thebrokenscript/brokencore/api/client/level/FakeTimeOfDayInfo;", "getENDEC", "()Lio/wispforest/endec/Endec;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Endec<FakeTimeOfDayInfo> getENDEC() {
            return ENDEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

