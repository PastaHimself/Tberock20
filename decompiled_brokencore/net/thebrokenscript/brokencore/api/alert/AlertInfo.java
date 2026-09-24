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
 */
package net.thebrokenscript.brokencore.api.alert;

import io.wispforest.endec.Endec;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import io.wispforest.endec.impl.StructField;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import net.thebrokenscript.brokencore.api.alert.AlertInfo;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/alert/AlertInfo;", "", "title", "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getMessage", "Companion", "brokencore-common"})
public final class AlertInfo {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String title;
    @NotNull
    private final String message;
    @NotNull
    private static final StructEndec<AlertInfo> ENDEC;

    public AlertInfo(@NotNull String title, @NotNull String message) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter((Object)message, (String)"message");
        this.title = title;
        this.message = message;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    private static final String ENDEC$lambda$0(KProperty1 $tmp0, AlertInfo p0) {
        return (String)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final String ENDEC$lambda$1(KProperty1 $tmp0, AlertInfo p0) {
        return (String)((Function1)$tmp0).invoke((Object)p0);
    }

    static {
        StructEndec structEndec = StructEndecBuilder.of((StructField)Endec.STRING.fieldOf("title", arg_0 -> AlertInfo.ENDEC$lambda$0((KProperty1)Companion.ENDEC.1.INSTANCE, arg_0)), (StructField)Endec.STRING.fieldOf("message", arg_0 -> AlertInfo.ENDEC$lambda$1((KProperty1)Companion.ENDEC.2.INSTANCE, arg_0)), AlertInfo::new);
        Intrinsics.checkNotNullExpressionValue((Object)structEndec, (String)"of(...)");
        ENDEC = structEndec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/alert/AlertInfo$Companion;", "", "<init>", "()V", "ENDEC", "Lio/wispforest/endec/StructEndec;", "Lnet/thebrokenscript/brokencore/api/alert/AlertInfo;", "getENDEC", "()Lio/wispforest/endec/StructEndec;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final StructEndec<AlertInfo> getENDEC() {
            return ENDEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

