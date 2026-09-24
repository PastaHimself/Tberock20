/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.StringReader
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.suggestion.SuggestionProvider
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.SharedSuggestionProvider
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.commands;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.SharedSuggestionProvider;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u0003*\u000e\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u00052\b\u0012\u0004\u0012\u0002H\u00030\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00028\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0010\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0016\u00a2\u0006\u0002\u0010\u0013R\u0013\u0010\u0006\u001a\u00028\u0002\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/SuggestingArgument;", "S", "Lnet/minecraft/commands/SharedSuggestionProvider;", "V", "T", "Lcom/mojang/brigadier/arguments/ArgumentType;", "arg", "suggester", "Lcom/mojang/brigadier/suggestion/SuggestionProvider;", "<init>", "(Lcom/mojang/brigadier/arguments/ArgumentType;Lcom/mojang/brigadier/suggestion/SuggestionProvider;)V", "getArg", "()Lcom/mojang/brigadier/arguments/ArgumentType;", "Lcom/mojang/brigadier/arguments/ArgumentType;", "getSuggester", "()Lcom/mojang/brigadier/suggestion/SuggestionProvider;", "parse", "reader", "Lcom/mojang/brigadier/StringReader;", "(Lcom/mojang/brigadier/StringReader;)Ljava/lang/Object;", "brokencore-common"})
public final class SuggestingArgument<S extends SharedSuggestionProvider, V, T extends ArgumentType<V>>
implements ArgumentType<V> {
    @NotNull
    private final T arg;
    @NotNull
    private final SuggestionProvider<S> suggester;

    public SuggestingArgument(@NotNull T arg, @NotNull SuggestionProvider<S> suggester) {
        Intrinsics.checkNotNullParameter(arg, (String)"arg");
        Intrinsics.checkNotNullParameter(suggester, (String)"suggester");
        this.arg = arg;
        this.suggester = suggester;
    }

    @NotNull
    public final T getArg() {
        return this.arg;
    }

    @NotNull
    public final SuggestionProvider<S> getSuggester() {
        return this.suggester;
    }

    public V parse(@NotNull StringReader reader) {
        Intrinsics.checkNotNullParameter((Object)reader, (String)"reader");
        return (V)this.arg.parse(reader);
    }
}

