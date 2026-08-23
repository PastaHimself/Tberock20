/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.arguments.ArgumentType
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.synchronization.ArgumentTypeInfo
 *  net.minecraft.commands.synchronization.ArgumentTypeInfo$Template
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;
import net.thebrokenscript.brokencore.impl.mixin.features.commands.ArgumentTypeInfosAccessor;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003Ja\u0010\u0004\u001a\u0002H\u0005\"\f\b\u0000\u0010\u0006*\u0006\u0012\u0002\b\u00030\u0007\"\u000e\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00060\t\"\u0014\b\u0002\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\b0\n2\u0016\u0010\u000b\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00070\f2\u0006\u0010\r\u001a\u0002H\u0005H\u0007\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/api/commands/ArgumentTypeRegistration;", "", "<init>", "()V", "registerByClass", "I", "A", "Lcom/mojang/brigadier/arguments/ArgumentType;", "T", "Lnet/minecraft/commands/synchronization/ArgumentTypeInfo$Template;", "Lnet/minecraft/commands/synchronization/ArgumentTypeInfo;", "infoClass", "Ljava/lang/Class;", "argumentTypeInfo", "(Ljava/lang/Class;Lnet/minecraft/commands/synchronization/ArgumentTypeInfo;)Lnet/minecraft/commands/synchronization/ArgumentTypeInfo;", "brokencore-common"})
public final class ArgumentTypeRegistration {
    @NotNull
    public static final ArgumentTypeRegistration INSTANCE = new ArgumentTypeRegistration();

    private ArgumentTypeRegistration() {
    }

    @JvmStatic
    @NotNull
    public static final synchronized <A extends ArgumentType<?>, T extends ArgumentTypeInfo.Template<A>, I extends ArgumentTypeInfo<A, T>> I registerByClass(@NotNull Class<? extends ArgumentType<? extends Object>> infoClass, @NotNull I argumentTypeInfo) {
        Intrinsics.checkNotNullParameter(infoClass, (String)"infoClass");
        Intrinsics.checkNotNullParameter(argumentTypeInfo, (String)"argumentTypeInfo");
        Map<Class<?>, ArgumentTypeInfo<?, ?>> map = ArgumentTypeInfosAccessor.bc$getByClass();
        Intrinsics.checkNotNullExpressionValue(map, (String)"bc$getByClass(...)");
        map.put(infoClass, argumentTypeInfo);
        return argumentTypeInfo;
    }
}

