/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.CharsKt
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.ext;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0005J\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0005\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/brokencore/api/ext/StringExt;", "", "<init>", "()V", "capitalizeWords", "", "capitalizeId", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nStringExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringExt.kt\nnet/thebrokenscript/brokencore/api/ext/StringExt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,19:1\n1#2:20\n*E\n"})
public final class StringExt {
    @NotNull
    public static final StringExt INSTANCE = new StringExt();

    private StringExt() {
    }

    @NotNull
    public final String capitalizeWords(@NotNull String $this$capitalizeWords) {
        Intrinsics.checkNotNullParameter((Object)$this$capitalizeWords, (String)"<this>");
        String[] stringArray = new String[]{" "};
        return CollectionsKt.joinToString$default((Iterable)StringsKt.split$default((CharSequence)$this$capitalizeWords, (String[])stringArray, (boolean)false, (int)0, (int)6, null), (CharSequence)" ", null, null, (int)0, null, arg_0 -> StringExt.capitalizeWords$lambda$0($this$capitalizeWords, arg_0), (int)30, null);
    }

    @NotNull
    public final String capitalizeId(@NotNull String $this$capitalizeId) {
        Intrinsics.checkNotNullParameter((Object)$this$capitalizeId, (String)"<this>");
        String string = StringsKt.replace$default((String)StringsKt.replace$default((String)$this$capitalizeId, (String)"_", (String)" ", (boolean)false, (int)4, null), (String)"-", (String)" ", (boolean)false, (int)4, null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toLowerCase(...)");
        return this.capitalizeWords(string);
    }

    /*
     * WARNING - void declaration
     */
    private static final CharSequence capitalizeWords$lambda$0(String $this_capitalizeWords, String it) {
        String string;
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        String string2 = $this_capitalizeWords;
        if (((CharSequence)string2).length() > 0) {
            String string3;
            void it2;
            char c = string2.charAt(0);
            StringBuilder stringBuilder = new StringBuilder();
            boolean bl = false;
            if (Character.isLowerCase((char)it2)) {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue((Object)locale, (String)"getDefault(...)");
                string3 = CharsKt.titlecase((char)it2, (Locale)locale);
            } else {
                string3 = String.valueOf((char)it2);
            }
            StringBuilder stringBuilder2 = stringBuilder.append((Object)string3);
            String string4 = string2;
            int n = 1;
            String string5 = string4.substring(n);
            Intrinsics.checkNotNullExpressionValue((Object)string5, (String)"substring(...)");
            string = stringBuilder2.append(string5).toString();
        } else {
            string = string2;
        }
        return string;
    }
}

