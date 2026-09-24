/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  kotlin.ranges.CharRange
 *  kotlin.ranges.RangesKt
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.ext;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005J\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0005\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/api/ext/StringExt;", "", "<init>", "()V", "nextString", "", "Lkotlin/random/Random;", "length", "", "allowedSymbols", "nextChar", "", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nStringExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringExt.kt\nnet/thebrokenscript/api/ext/StringExt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,28:1\n1869#2,2:29\n*S KotlinDebug\n*F\n+ 1 StringExt.kt\nnet/thebrokenscript/api/ext/StringExt\n*L\n13#1:29,2\n*E\n"})
public final class StringExt {
    @NotNull
    public static final StringExt INSTANCE = new StringExt();

    private StringExt() {
    }

    @NotNull
    public final String nextString(@NotNull Random $this$nextString, int length, @NotNull String allowedSymbols) {
        StringBuilder stringBuilder;
        Intrinsics.checkNotNullParameter((Object)$this$nextString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)allowedSymbols, (String)"allowedSymbols");
        StringBuilder $this$nextString_u24lambda_u240 = stringBuilder = new StringBuilder();
        boolean bl = false;
        Iterable $this$forEach$iv = (Iterable)RangesKt.until((int)0, (int)length);
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv.iterator();
        while (iterator.hasNext()) {
            int element$iv = ((IntIterator)iterator).nextInt();
            boolean bl2 = false;
            $this$nextString_u24lambda_u240.append(INSTANCE.nextChar($this$nextString, allowedSymbols));
        }
        return stringBuilder.toString();
    }

    public static /* synthetic */ String nextString$default(StringExt stringExt, Random random, int n, String string, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = random.nextInt(15, 21);
        }
        if ((n2 & 2) != 0) {
            string = "$%-_";
        }
        return stringExt.nextString(random, n, string);
    }

    public final char nextChar(@NotNull Random $this$nextChar, @NotNull String allowedSymbols) {
        Intrinsics.checkNotNullParameter((Object)$this$nextChar, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)allowedSymbols, (String)"allowedSymbols");
        List letters = CollectionsKt.plus((Iterable)((Iterable)new CharRange('a', 'z')), (Iterable)((Iterable)new CharRange('A', 'Z')));
        CharRange digits = new CharRange('0', '9');
        List allAllowed = CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)StringsKt.toList((CharSequence)allowedSymbols), (Iterable)letters), (Iterable)((Iterable)digits));
        return ((Character)CollectionsKt.random((Collection)allAllowed, (Random)$this$nextChar)).charValue();
    }

    public static /* synthetic */ char nextChar$default(StringExt stringExt, Random random, String string, int n, Object object) {
        if ((n & 1) != 0) {
            string = "$%/-_";
        }
        return stringExt.nextChar(random, string);
    }
}

