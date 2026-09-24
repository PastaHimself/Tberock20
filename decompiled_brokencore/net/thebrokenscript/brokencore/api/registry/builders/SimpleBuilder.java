/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Registry
 *  net.minecraft.resources.ResourceKey
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.builders;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import net.thebrokenscript.brokencore.api.registry.builders.AbstractBuilder;
import net.thebrokenscript.brokencore.api.registry.dsl.RegistryDslMarker;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import org.jetbrains.annotations.NotNull;

@RegistryDslMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b'\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0000*\u0004\b\u0001\u0010\u00022&\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B+\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\bH\u0016\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/builders/SimpleBuilder;", "S", "T", "Lnet/thebrokenscript/brokencore/api/registry/builders/AbstractBuilder;", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "parent", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "registry", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/core/Registry;", "name", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;Lnet/minecraft/resources/ResourceKey;Ljava/lang/String;)V", "createEntry", "key", "brokencore-common"})
public abstract class SimpleBuilder<S extends SimpleBuilder<S, T>, T>
extends AbstractBuilder<S, T, T, RegistryEntry<T, T>> {
    public SimpleBuilder(@NotNull BrokenReg parent, @NotNull ResourceKey<Registry<T>> registry, @NotNull String name) {
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        Intrinsics.checkNotNullParameter(registry, (String)"registry");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        super(parent, registry, name);
    }

    @Override
    @NotNull
    public RegistryEntry<T, T> createEntry(@NotNull ResourceKey<T> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        return new RegistryEntry(key);
    }
}

