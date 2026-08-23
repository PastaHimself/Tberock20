/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.Registry
 *  net.neoforged.bus.api.SubscribeEvent
 *  net.neoforged.fml.common.EventBusSubscriber
 *  net.neoforged.neoforge.registries.NewRegistryEvent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.Registry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import org.jetbrains.annotations.NotNull;

@EventBusSubscriber
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u001e\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/PlatformRegistryEvents;", "", "<init>", "()V", "registries", "", "Lnet/minecraft/core/Registry;", "getRegistries$brokencore_neoforge", "()Ljava/util/List;", "register", "", "ev", "Lnet/neoforged/neoforge/registries/NewRegistryEvent;", "brokencore-neoforge"})
@SourceDebugExtension(value={"SMAP\nPlatformRegistriesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformRegistriesImpl.kt\nnet/thebrokenscript/brokencore/neoforge/PlatformRegistryEvents\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,104:1\n1869#2,2:105\n*S KotlinDebug\n*F\n+ 1 PlatformRegistriesImpl.kt\nnet/thebrokenscript/brokencore/neoforge/PlatformRegistryEvents\n*L\n101#1:105,2\n*E\n"})
public final class PlatformRegistryEvents {
    @NotNull
    public static final PlatformRegistryEvents INSTANCE = new PlatformRegistryEvents();
    @NotNull
    private static final List<Registry<?>> registries = new ArrayList();

    private PlatformRegistryEvents() {
    }

    @NotNull
    public final List<Registry<?>> getRegistries$brokencore_neoforge() {
        return registries;
    }

    @JvmStatic
    @SubscribeEvent
    public static final void register(@NotNull NewRegistryEvent ev) {
        Intrinsics.checkNotNullParameter((Object)ev, (String)"ev");
        Iterable $this$forEach$iv = registries;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Registry it = (Registry)element$iv;
            boolean bl = false;
            ev.register(it);
        }
    }
}

