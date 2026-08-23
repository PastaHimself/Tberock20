/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Regex
 *  kotlin.text.StringsKt
 *  net.minecraft.core.Registry
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util;

import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.util.LangUtil;
import net.thebrokenscript.brokencore.api.util.RegistryUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ.\u0010\u000b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00102\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u00130\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/util/LangUtil;", "", "<init>", "()V", "NORMAL_CHARS", "", "UPSIDE_DOWN_CHARS", "toUpsideDown", "normal", "toEnglishName", "internalName", "getAutomaticName", "id", "Lnet/minecraft/resources/ResourceLocation;", "T", "sup", "Lkotlin/Function0;", "registry", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/core/Registry;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nLangUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LangUtil.kt\nnet/thebrokenscript/brokencore/api/util/LangUtil\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,75:1\n739#2,9:76\n*S KotlinDebug\n*F\n+ 1 LangUtil.kt\nnet/thebrokenscript/brokencore/api/util/LangUtil\n*L\n67#1:76,9\n*E\n"})
public final class LangUtil {
    @NotNull
    public static final LangUtil INSTANCE = new LangUtil();
    @NotNull
    public static final String NORMAL_CHARS = "abcdefghijklmn\u00f1opqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_,;.?!/\\'";
    @NotNull
    public static final String UPSIDE_DOWN_CHARS = "\u0250q\u0254p\u01dd\u025fb\u0265\u0131\u0638\u029e\u05df\u026fuuodb\u0279s\u0287n\u028c\u028dx\u028ez\u2c6f\u15fa\u0186\u15e1\u018e\u2132\u2141HI\u017f\u029e\ua780WNO\u0500\u1f49\u1d1aS\u27d8\u2229\u039bMX\u028eZ0\u0196\u1105\u0190\u3123\u03db9\u312586\u203e'\u061b\u02d9\u00bf\u00a1/\\,";

    private LangUtil() {
    }

    @NotNull
    public final String toUpsideDown(@NotNull String normal) {
        Intrinsics.checkNotNullParameter((Object)normal, (String)"normal");
        char[] ud = new char[normal.length()];
        int i = 0;
        while (i < normal.length()) {
            char c = normal.charAt(i);
            if (c == '%') {
                Object fmtArg = "";
                while (Character.isDigit(c) || c == '%' || c == '$' || c == 's' || c == 'd') {
                    fmtArg = (String)fmtArg + c;
                    c = ++i == normal.length() ? (char)'\u0000' : normal.charAt(i);
                }
                --i;
                int n = ((String)fmtArg).length();
                for (int j = 0; j < n; ++j) {
                    ud[normal.length() - 1 - i + j] = ((String)fmtArg).charAt(j);
                }
                ++i;
                continue;
            }
            int lookup = StringsKt.indexOf$default((CharSequence)NORMAL_CHARS, (char)c, (int)0, (boolean)false, (int)6, null);
            if (lookup >= 0) {
                c = UPSIDE_DOWN_CHARS.charAt(lookup);
            }
            ud[normal.length() - 1 - i] = c;
            ++i;
        }
        return new String(ud);
    }

    @NotNull
    public final String toEnglishName(@NotNull String internalName) {
        List list;
        Intrinsics.checkNotNullParameter((Object)internalName, (String)"internalName");
        String string = internalName.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toLowerCase(...)");
        CharSequence charSequence = string;
        Regex regex = new Regex("_");
        int n = 0;
        List $this$dropLastWhile$iv = regex.split(charSequence, n);
        boolean $i$f$dropLastWhile = false;
        if (!$this$dropLastWhile$iv.isEmpty()) {
            ListIterator iterator$iv = $this$dropLastWhile$iv.listIterator($this$dropLastWhile$iv.size());
            while (iterator$iv.hasPrevious()) {
                String it = (String)iterator$iv.previous();
                boolean bl = false;
                if (((CharSequence)it).length() == 0) continue;
                list = CollectionsKt.take((Iterable)$this$dropLastWhile$iv, (int)(iterator$iv.nextIndex() + 1));
                break;
            }
        } else {
            list = CollectionsKt.emptyList();
        }
        return CollectionsKt.joinToString$default((Iterable)list, (CharSequence)" ", null, null, (int)0, null, (Function1)toEnglishName.2.INSTANCE, (int)30, null);
    }

    @NotNull
    public final String getAutomaticName(@NotNull ResourceLocation id) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        String string = id.getPath();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
        return this.toEnglishName(string);
    }

    @NotNull
    public final <T> String getAutomaticName(@NotNull Function0<? extends T> sup, @NotNull ResourceKey<Registry<T>> registry) {
        Intrinsics.checkNotNullParameter(sup, (String)"sup");
        Intrinsics.checkNotNullParameter(registry, (String)"registry");
        Registry<T> registry2 = RegistryUtil.INSTANCE.getRegistry(registry);
        Intrinsics.checkNotNull(registry2);
        ResourceLocation resourceLocation = registry2.getKey(sup.invoke());
        Intrinsics.checkNotNull((Object)resourceLocation);
        return this.getAutomaticName(resourceLocation);
    }
}

