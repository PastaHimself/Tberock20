/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.context.CommandContext
 *  com.mojang.brigadier.suggestion.SuggestionProvider
 *  com.mojang.brigadier.suggestion.Suggestions
 *  com.mojang.brigadier.suggestion.SuggestionsBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.commands.CommandSourceStack
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.commands.suggestion;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.commands.CommandSourceStack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/suggestion/StringCollectionSuggestionProvider;", "Lcom/mojang/brigadier/suggestion/SuggestionProvider;", "Lnet/minecraft/commands/CommandSourceStack;", "list", "", "", "<init>", "(Ljava/util/Collection;)V", "getList", "()Ljava/util/Collection;", "getSuggestions", "Ljava/util/concurrent/CompletableFuture;", "Lcom/mojang/brigadier/suggestion/Suggestions;", "context", "Lcom/mojang/brigadier/context/CommandContext;", "builder", "Lcom/mojang/brigadier/suggestion/SuggestionsBuilder;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nStringCollectionSuggestionProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringCollectionSuggestionProvider.kt\nnet/thebrokenscript/brokencore/api/commands/suggestion/StringCollectionSuggestionProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,19:1\n774#2:20\n865#2,2:21\n1869#2,2:23\n*S KotlinDebug\n*F\n+ 1 StringCollectionSuggestionProvider.kt\nnet/thebrokenscript/brokencore/api/commands/suggestion/StringCollectionSuggestionProvider\n*L\n14#1:20\n14#1:21,2\n14#1:23,2\n*E\n"})
public final class StringCollectionSuggestionProvider
implements SuggestionProvider<CommandSourceStack> {
    @NotNull
    private final Collection<String> list;

    public StringCollectionSuggestionProvider(@NotNull Collection<String> list) {
        Intrinsics.checkNotNullParameter(list, (String)"list");
        this.list = list;
    }

    @NotNull
    public final Collection<String> getList() {
        return this.list;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public CompletableFuture<Suggestions> getSuggestions(@NotNull CommandContext<CommandSourceStack> context, @NotNull SuggestionsBuilder builder) {
        void $this$filterTo$iv$iv;
        Intrinsics.checkNotNullParameter(context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Iterable $this$filter$iv = this.list;
        boolean $i$f$filter = false;
        Iterable iterable = $this$filter$iv;
        Collection destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            String it = (String)element$iv$iv;
            boolean bl = false;
            String string = builder.getRemaining();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getRemaining(...)");
            if (!StringsKt.startsWith((String)it, (String)string, (boolean)true)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        Iterable $this$forEach$iv = (List)destination$iv$iv;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            String p0 = (String)element$iv;
            boolean bl = false;
            builder.suggest(p0);
        }
        CompletableFuture completableFuture = builder.buildFuture();
        Intrinsics.checkNotNullExpressionValue((Object)completableFuture, (String)"buildFuture(...)");
        return completableFuture;
    }
}

