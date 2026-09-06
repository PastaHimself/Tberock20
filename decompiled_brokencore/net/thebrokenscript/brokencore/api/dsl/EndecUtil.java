/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  io.wispforest.endec.impl.StructField
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import io.wispforest.endec.Endec;
import io.wispforest.endec.impl.StructField;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aH\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\b\u00a8\u0006\t"}, d2={"nullableFieldOf", "Lio/wispforest/endec/impl/StructField;", "S", "T", "Lio/wispforest/endec/Endec;", "name", "", "getter", "Lkotlin/Function1;", "brokencore-common"})
@JvmName(name="EndecUtil")
public final class EndecUtil {
    @NotNull
    public static final <S, T> StructField<S, T> nullableFieldOf(@NotNull Endec<T> $this$nullableFieldOf, @NotNull String name, @NotNull Function1<? super S, ? extends T> getter) {
        Intrinsics.checkNotNullParameter($this$nullableFieldOf, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        StructField structField = $this$nullableFieldOf.optionalFieldOf(name, arg_0 -> EndecUtil.nullableFieldOf$lambda$0(getter, arg_0), EndecUtil::nullableFieldOf$lambda$1);
        Intrinsics.checkNotNullExpressionValue((Object)structField, (String)"optionalFieldOf(...)");
        return structField;
    }

    private static final Object nullableFieldOf$lambda$0(Function1 $tmp0, Object p0) {
        return $tmp0.invoke(p0);
    }

    private static final Object nullableFieldOf$lambda$1() {
        return null;
    }
}

