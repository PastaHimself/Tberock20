/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  net.minecraft.core.Registry
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.registry;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u008b\u0001\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u0004\"\b\b\u0001\u0010\u0005*\u0002H\u0004\"\u0014\b\u0002\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00050\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\u00100\u000f2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\b\u0012\u0004\u0012\u0002H\u00030\u000fH&\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/impl/registry/RegistrationHandler;", "", "register", "E", "R", "T", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "registry", "Lnet/minecraft/resources/ResourceKey;", "Lnet/minecraft/core/Registry;", "id", "Lnet/minecraft/resources/ResourceLocation;", "getter", "Lkotlin/Function0;", "callback", "Lkotlin/Function1;", "", "entryCtor", "(Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/resources/ResourceLocation;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "brokencore-common"})
public interface RegistrationHandler {
    @NotNull
    public <R, T extends R, E extends RegistryEntry<R, T>> E register(@NotNull ResourceKey<Registry<R>> var1, @NotNull ResourceLocation var2, @NotNull Function0<? extends T> var3, @NotNull Function1<? super E, Unit> var4, @NotNull Function1<? super ResourceKey<R>, ? extends E> var5);
}

