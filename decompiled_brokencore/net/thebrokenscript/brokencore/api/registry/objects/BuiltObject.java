/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Registry
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.registry.objects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.brokencore.impl.registry.RegistrationHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u0002H\u0001*\u0014\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00042\u00020\u0005B_\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00028\u00020\u000e\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0017\u001a\u00028\u00022\u0006\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\u0002\u0010\u001aJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00028\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/brokencore/api/registry/objects/BuiltObject;", "R", "T", "E", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "", "registry", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/core/Registry;", "id", "Lnet/minecraft/resources/ResourceLocation;", "getter", "Lkotlin/Function0;", "callback", "Lkotlin/Function1;", "", "entryCtor", "<init>", "(Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceLocation;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getRegistry", "()Lnet/minecraft/resources/ResourceKey;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "accept", "handler", "Lnet/thebrokenscript/brokencore/impl/registry/RegistrationHandler;", "(Lnet/thebrokenscript/brokencore/impl/registry/RegistrationHandler;)Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "key", "brokencore-common"})
public final class BuiltObject<R, T extends R, E extends RegistryEntry<R, T>> {
    @NotNull
    private final ResourceKey<Registry<R>> registry;
    @NotNull
    private final ResourceLocation id;
    @NotNull
    private final Function0<T> getter;
    @NotNull
    private final Function1<E, Unit> callback;
    @NotNull
    private final Function1<ResourceKey<R>, E> entryCtor;

    public BuiltObject(@NotNull ResourceKey<Registry<R>> registry, @NotNull ResourceLocation id, @NotNull Function0<? extends T> getter, @NotNull Function1<? super E, Unit> callback, @NotNull Function1<? super ResourceKey<R>, ? extends E> entryCtor) {
        Intrinsics.checkNotNullParameter(registry, (String)"registry");
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter(getter, (String)"getter");
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        Intrinsics.checkNotNullParameter(entryCtor, (String)"entryCtor");
        this.registry = registry;
        this.id = id;
        this.getter = getter;
        this.callback = callback;
        this.entryCtor = entryCtor;
    }

    @NotNull
    public final ResourceKey<Registry<R>> getRegistry() {
        return this.registry;
    }

    @NotNull
    public final ResourceLocation getId() {
        return this.id;
    }

    @NotNull
    public final E accept(@NotNull RegistrationHandler handler) {
        Intrinsics.checkNotNullParameter((Object)handler, (String)"handler");
        return handler.register(this.registry, this.id, this.getter, this.callback, this.entryCtor);
    }

    @NotNull
    public final ResourceKey<R> key() {
        ResourceKey resourceKey = ResourceKey.create(this.registry, (ResourceLocation)this.id);
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"create(...)");
        return resourceKey;
    }
}

