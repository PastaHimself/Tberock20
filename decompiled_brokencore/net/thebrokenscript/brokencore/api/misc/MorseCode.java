/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\f\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/api/misc/MorseCode;", "", "<init>", "()V", "chars", "", "", "", "getChars", "()Ljava/util/Map;", "translate", "text", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nMorseCode.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MorseCode.kt\nnet/thebrokenscript/brokencore/api/misc/MorseCode\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,66:1\n975#2:67\n1046#2,3:68\n*S KotlinDebug\n*F\n+ 1 MorseCode.kt\nnet/thebrokenscript/brokencore/api/misc/MorseCode\n*L\n65#1:67\n65#1:68,3\n*E\n"})
public final class MorseCode {
    @NotNull
    public static final MorseCode INSTANCE = new MorseCode();
    @NotNull
    private static final Map<Character, String> chars;

    private MorseCode() {
    }

    @NotNull
    public final Map<Character, String> getChars() {
        return chars;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final String translate(@NotNull String text) {
        void $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter((Object)text, (String)"text");
        String string = text.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toUpperCase(...)");
        CharSequence $this$map$iv = string;
        boolean $i$f$map = false;
        CharSequence charSequence = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length());
        boolean $i$f$mapTo = false;
        for (int i = 0; i < $this$mapTo$iv$iv.length(); ++i) {
            void it;
            char item$iv$iv;
            char c = item$iv$iv = $this$mapTo$iv$iv.charAt(i);
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(chars.get(Character.valueOf((char)it)));
        }
        return CollectionsKt.joinToString$default((Iterable)((List)destination$iv$iv), (CharSequence)" ", null, null, (int)0, null, null, (int)62, null);
    }

    static {
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)Character.valueOf('A'), (Object)".-"), TuplesKt.to((Object)Character.valueOf('B'), (Object)"-..."), TuplesKt.to((Object)Character.valueOf('C'), (Object)"-.-."), TuplesKt.to((Object)Character.valueOf('D'), (Object)"-.."), TuplesKt.to((Object)Character.valueOf('E'), (Object)"."), TuplesKt.to((Object)Character.valueOf('F'), (Object)"..-."), TuplesKt.to((Object)Character.valueOf('G'), (Object)"--."), TuplesKt.to((Object)Character.valueOf('H'), (Object)"...."), TuplesKt.to((Object)Character.valueOf('I'), (Object)".."), TuplesKt.to((Object)Character.valueOf('J'), (Object)".---"), TuplesKt.to((Object)Character.valueOf('K'), (Object)"-.-"), TuplesKt.to((Object)Character.valueOf('L'), (Object)".-.."), TuplesKt.to((Object)Character.valueOf('M'), (Object)"--"), TuplesKt.to((Object)Character.valueOf('N'), (Object)"-."), TuplesKt.to((Object)Character.valueOf('O'), (Object)"---"), TuplesKt.to((Object)Character.valueOf('P'), (Object)".--."), TuplesKt.to((Object)Character.valueOf('Q'), (Object)"--.-"), TuplesKt.to((Object)Character.valueOf('R'), (Object)".-."), TuplesKt.to((Object)Character.valueOf('S'), (Object)"..."), TuplesKt.to((Object)Character.valueOf('T'), (Object)"-"), TuplesKt.to((Object)Character.valueOf('U'), (Object)"..-"), TuplesKt.to((Object)Character.valueOf('V'), (Object)"...-"), TuplesKt.to((Object)Character.valueOf('W'), (Object)".--"), TuplesKt.to((Object)Character.valueOf('X'), (Object)"-..-"), TuplesKt.to((Object)Character.valueOf('Y'), (Object)"-.--"), TuplesKt.to((Object)Character.valueOf('Z'), (Object)"--.."), TuplesKt.to((Object)Character.valueOf('0'), (Object)"-----"), TuplesKt.to((Object)Character.valueOf('1'), (Object)".----"), TuplesKt.to((Object)Character.valueOf('2'), (Object)"..---"), TuplesKt.to((Object)Character.valueOf('3'), (Object)"...--"), TuplesKt.to((Object)Character.valueOf('4'), (Object)"....-"), TuplesKt.to((Object)Character.valueOf('5'), (Object)"....."), TuplesKt.to((Object)Character.valueOf('6'), (Object)"-...."), TuplesKt.to((Object)Character.valueOf('7'), (Object)"--..."), TuplesKt.to((Object)Character.valueOf('8'), (Object)"---.."), TuplesKt.to((Object)Character.valueOf('9'), (Object)"----."), TuplesKt.to((Object)Character.valueOf('_'), (Object)"..--.-"), TuplesKt.to((Object)Character.valueOf('-'), (Object)"-....-"), TuplesKt.to((Object)Character.valueOf(','), (Object)"--..--"), TuplesKt.to((Object)Character.valueOf(';'), (Object)"-.-.-."), TuplesKt.to((Object)Character.valueOf(':'), (Object)"---..."), TuplesKt.to((Object)Character.valueOf('!'), (Object)"-.-.--"), TuplesKt.to((Object)Character.valueOf('\u00a1'), (Object)"--...-"), TuplesKt.to((Object)Character.valueOf('?'), (Object)"..--.."), TuplesKt.to((Object)Character.valueOf('\u00bf'), (Object)"..-.-"), TuplesKt.to((Object)Character.valueOf('.'), (Object)".-.-.-"), TuplesKt.to((Object)Character.valueOf('\''), (Object)".----."), TuplesKt.to((Object)Character.valueOf('\"'), (Object)".-..-."), TuplesKt.to((Object)Character.valueOf('('), (Object)"-.--."), TuplesKt.to((Object)Character.valueOf(')'), (Object)"-.--.-"), TuplesKt.to((Object)Character.valueOf('@'), (Object)".--.-."), TuplesKt.to((Object)Character.valueOf('/'), (Object)"-..-."), TuplesKt.to((Object)Character.valueOf('&'), (Object)".-..."), TuplesKt.to((Object)Character.valueOf('+'), (Object)".-.-."), TuplesKt.to((Object)Character.valueOf('='), (Object)"-...-"), TuplesKt.to((Object)Character.valueOf('$'), (Object)"...-..-"), TuplesKt.to((Object)Character.valueOf(' '), (Object)"/")};
        chars = MapsKt.mapOf((Pair[])pairArray);
    }
}

