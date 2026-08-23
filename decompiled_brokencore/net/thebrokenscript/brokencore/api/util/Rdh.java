/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.MatchResult
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/util/Rdh;", "", "<init>", "()V", "RDH_REGEX", "Lkotlin/text/Regex;", "rdhify", "", "s", "brokencore-common"})
public final class Rdh {
    @NotNull
    public static final Rdh INSTANCE = new Rdh();
    @NotNull
    private static final Regex RDH_REGEX = new Regex("\\b\\S+\\b");

    private Rdh() {
    }

    @NotNull
    public final String rdhify(@NotNull String s) {
        Intrinsics.checkNotNullParameter((Object)s, (String)"s");
        CharSequence charSequence = StringsKt.replace$default((String)s, (String)"null", (String)"rdh", (boolean)false, (int)4, null);
        Regex regex = RDH_REGEX;
        Function1 function1 = Rdh::rdhify$lambda$0;
        return regex.replace(charSequence, function1);
    }

    private static final CharSequence rdhify$lambda$0(MatchResult it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return StringsKt.contains$default((CharSequence)it.getValue(), (CharSequence)"rdh", (boolean)false, (int)2, null) ? (CharSequence)it.getValue() : (CharSequence)"rdh";
    }
}

