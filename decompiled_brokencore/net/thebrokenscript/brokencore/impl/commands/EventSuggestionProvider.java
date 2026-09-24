/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.context.CommandContext
 *  com.mojang.brigadier.suggestion.SuggestionProvider
 *  com.mojang.brigadier.suggestion.Suggestions
 *  com.mojang.brigadier.suggestion.SuggestionsBuilder
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.commands.CommandSourceStack
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.commands;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.registry.BCRegistries;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/impl/commands/EventSuggestionProvider;", "Lcom/mojang/brigadier/suggestion/SuggestionProvider;", "Lnet/minecraft/commands/CommandSourceStack;", "<init>", "()V", "getSuggestions", "Ljava/util/concurrent/CompletableFuture;", "Lcom/mojang/brigadier/suggestion/Suggestions;", "context", "Lcom/mojang/brigadier/context/CommandContext;", "builder", "Lcom/mojang/brigadier/suggestion/SuggestionsBuilder;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nEventSuggestionProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventSuggestionProvider.kt\nnet/thebrokenscript/brokencore/impl/commands/EventSuggestionProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,22:1\n1563#2:23\n1634#2,3:24\n774#2:27\n865#2,2:28\n1869#2,2:30\n*S KotlinDebug\n*F\n+ 1 EventSuggestionProvider.kt\nnet/thebrokenscript/brokencore/impl/commands/EventSuggestionProvider\n*L\n16#1:23\n16#1:24,3\n17#1:27\n17#1:28,2\n17#1:30,2\n*E\n"})
public final class EventSuggestionProvider
implements SuggestionProvider<CommandSourceStack> {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public CompletableFuture<Suggestions> getSuggestions(@NotNull CommandContext<CommandSourceStack> context, @NotNull SuggestionsBuilder builder) {
        void $this$filterTo$iv$iv;
        Iterable $this$mapTo$iv$iv;
        Intrinsics.checkNotNullParameter(context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        Set set = BCRegistries.EVENT.keySet();
        Intrinsics.checkNotNullExpressionValue((Object)set, (String)"keySet(...)");
        Iterable $this$map$iv = set;
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            void p0;
            ResourceLocation resourceLocation = (ResourceLocation)item$iv$iv;
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(p0.toString());
        }
        Iterable $this$filter$iv = (List)destination$iv$iv;
        boolean $i$f$filter = false;
        $this$mapTo$iv$iv = $this$filter$iv;
        destination$iv$iv = new ArrayList();
        boolean $i$f$filterTo = false;
        for (Object element$iv$iv : $this$filterTo$iv$iv) {
            String it = (String)element$iv$iv;
            boolean bl = false;
            Intrinsics.checkNotNull((Object)it);
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

