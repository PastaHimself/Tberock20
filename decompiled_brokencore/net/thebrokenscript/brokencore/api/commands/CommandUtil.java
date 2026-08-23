/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  com.mojang.brigadier.builder.LiteralArgumentBuilder
 *  com.mojang.brigadier.builder.RequiredArgumentBuilder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\bJ4\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/CommandUtil;", "", "<init>", "()V", "literal", "Lcom/mojang/brigadier/builder/LiteralArgumentBuilder;", "S", "name", "", "argument", "Lcom/mojang/brigadier/builder/RequiredArgumentBuilder;", "T", "type", "Lcom/mojang/brigadier/arguments/ArgumentType;", "brokencore-common"})
public final class CommandUtil {
    @NotNull
    public static final CommandUtil INSTANCE = new CommandUtil();

    private CommandUtil() {
    }

    @NotNull
    public final <S> LiteralArgumentBuilder<S> literal(@NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        LiteralArgumentBuilder literalArgumentBuilder = LiteralArgumentBuilder.literal((String)name);
        Intrinsics.checkNotNullExpressionValue((Object)literalArgumentBuilder, (String)"literal(...)");
        return literalArgumentBuilder;
    }

    @NotNull
    public final <S, T> RequiredArgumentBuilder<S, T> argument(@NotNull String name, @NotNull ArgumentType<T> type) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(type, (String)"type");
        RequiredArgumentBuilder requiredArgumentBuilder = RequiredArgumentBuilder.argument((String)name, type);
        Intrinsics.checkNotNullExpressionValue((Object)requiredArgumentBuilder, (String)"argument(...)");
        return requiredArgumentBuilder;
    }
}

