/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\u001a\u001a\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007\u001a\n\u0010\t\u001a\u00020\u0005*\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0015\u0010\n\u001a\u00020\u0005*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"CLEAN_STRING_REGEX", "Lkotlin/text/Regex;", "SPACE_REGEX", "isSurrounded", "", "", "prefix", "", "suffix", "flattenSpaces", "clean", "getClean", "(Ljava/lang/String;)Ljava/lang/String;", "brokencore-common"})
public final class StringExtKt {
    @NotNull
    private static final Regex CLEAN_STRING_REGEX = new Regex("[^A-Za-z0-9]");
    @NotNull
    private static final Regex SPACE_REGEX = new Regex("\\s+");

    public static final boolean isSurrounded(@NotNull String $this$isSurrounded, @NotNull CharSequence prefix, @NotNull CharSequence suffix) {
        Intrinsics.checkNotNullParameter((Object)$this$isSurrounded, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)prefix, (String)"prefix");
        Intrinsics.checkNotNullParameter((Object)suffix, (String)"suffix");
        return StringsKt.startsWith$default((CharSequence)$this$isSurrounded, (CharSequence)prefix, (boolean)false, (int)2, null) && StringsKt.endsWith$default((CharSequence)$this$isSurrounded, (CharSequence)suffix, (boolean)false, (int)2, null);
    }

    @NotNull
    public static final String flattenSpaces(@NotNull String $this$flattenSpaces) {
        Intrinsics.checkNotNullParameter((Object)$this$flattenSpaces, (String)"<this>");
        CharSequence charSequence = $this$flattenSpaces;
        Regex regex = SPACE_REGEX;
        String string = " ";
        return regex.replace(charSequence, string);
    }

    @NotNull
    public static final String getClean(@NotNull String $this$clean) {
        Intrinsics.checkNotNullParameter((Object)$this$clean, (String)"<this>");
        CharSequence charSequence = $this$clean;
        Regex regex = CLEAN_STRING_REGEX;
        String string = " ";
        return ((Object)StringsKt.trim((CharSequence)StringExtKt.flattenSpaces(regex.replace(charSequence, string)))).toString();
    }
}

