/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.commands.PartType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/CommandPart;", "", "type", "Lnet/thebrokenscript/brokencore/api/commands/PartType;", "name", "", "argument", "Lcom/mojang/brigadier/arguments/ArgumentType;", "<init>", "(Lnet/thebrokenscript/brokencore/api/commands/PartType;Ljava/lang/String;Lcom/mojang/brigadier/arguments/ArgumentType;)V", "getType", "()Lnet/thebrokenscript/brokencore/api/commands/PartType;", "getName", "()Ljava/lang/String;", "getArgument", "()Lcom/mojang/brigadier/arguments/ArgumentType;", "setArgument", "(Lcom/mojang/brigadier/arguments/ArgumentType;)V", "toString", "brokencore-common"})
public final class CommandPart {
    @NotNull
    private final PartType type;
    @NotNull
    private final String name;
    @Nullable
    private ArgumentType<?> argument;

    public CommandPart(@NotNull PartType type, @NotNull String name, @Nullable ArgumentType<?> argument) {
        Intrinsics.checkNotNullParameter((Object)((Object)type), (String)"type");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        this.type = type;
        this.name = name;
        this.argument = argument;
    }

    public /* synthetic */ CommandPart(PartType partType, String string, ArgumentType argumentType, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            argumentType = null;
        }
        this(partType, string, argumentType);
    }

    @NotNull
    public final PartType getType() {
        return this.type;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final ArgumentType<?> getArgument() {
        return this.argument;
    }

    public final void setArgument(@Nullable ArgumentType<?> argumentType) {
        this.argument = argumentType;
    }

    @NotNull
    public String toString() {
        return "[type = " + this.type + "; name = " + this.name + "; argument = " + this.argument + "]";
    }
}

