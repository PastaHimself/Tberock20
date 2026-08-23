/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.optionals.OptionalsKt
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceKey
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.util;

import java.util.Optional;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.optionals.OptionalsKt;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00050\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/util/RegistryUtil;", "", "<init>", "()V", "getRegistry", "Lnet/minecraft/core/Registry;", "T", "key", "Lnet/minecraft/resources/ResourceKey;", "brokencore-common"})
public final class RegistryUtil {
    @NotNull
    public static final RegistryUtil INSTANCE = new RegistryUtil();

    private RegistryUtil() {
    }

    @Nullable
    public final <T> Registry<T> getRegistry(@NotNull ResourceKey<Registry<T>> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        Optional optional = BuiltInRegistries.REGISTRY.getOptional(key.location());
        Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getOptional(...)");
        return (Registry)OptionalsKt.getOrNull((Optional)optional);
    }
}

