/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Registry
 *  net.minecraft.resources.ResourceKey
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.platform;

import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.thebrokenscript.brokencore.api.registry.BrokenReg;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00102\u00020\u0001:\u0002\u000f\u0010J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007H&J(\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\fH&J6\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\b0\fH&\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformRegistries;", "", "setup", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "registerRegistry", "Lnet/minecraft/core/Registry;", "T", "registry", "createSyncedRegistry", "key", "Lnet/minecraft/resources/ResourceKey;", "createDefaultedSyncedRegistry", "defaultKey", "DummyPlatformRegistries", "Companion", "brokencore-common"})
public interface PlatformRegistries {
    @NotNull
    public static final Companion Companion = net.thebrokenscript.brokencore.api.platform.PlatformRegistries$Companion.$$INSTANCE;

    public void setup(@NotNull BrokenReg var1);

    @NotNull
    public <T> Registry<T> registerRegistry(@NotNull Registry<T> var1);

    @NotNull
    public <T> Registry<T> createSyncedRegistry(@NotNull ResourceKey<Registry<T>> var1);

    @NotNull
    public <T> Registry<T> createDefaultedSyncedRegistry(@NotNull ResourceKey<Registry<T>> var1, @NotNull ResourceKey<T> var2);

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformRegistries$Companion;", "", "<init>", "()V", "INSTANCE", "Lnet/thebrokenscript/brokencore/api/platform/PlatformRegistries;", "getINSTANCE", "()Lnet/thebrokenscript/brokencore/api/platform/PlatformRegistries;", "brokencore-common"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        @NotNull
        private static final PlatformRegistries INSTANCE;

        private Companion() {
        }

        @NotNull
        public final PlatformRegistries getINSTANCE() {
            return INSTANCE;
        }

        static {
            PlatformRegistries platformRegistries;
            $$INSTANCE = new Companion();
            if (System.getenv().containsKey("TEST_ENV")) {
                platformRegistries = new DummyPlatformRegistries();
            } else {
                ServiceLoader<PlatformRegistries> serviceLoader = ServiceLoader.load(PlatformRegistries.class);
                Intrinsics.checkNotNullExpressionValue(serviceLoader, (String)"load(...)");
                Object object = CollectionsKt.first((Iterable)serviceLoader);
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"first(...)");
                platformRegistries = (PlatformRegistries)object;
            }
            INSTANCE = platformRegistries;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\tH\u0016J(\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\t0\u000eH\u0016J6\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\t0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\n0\u000eH\u0016\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformRegistries$DummyPlatformRegistries;", "Lnet/thebrokenscript/brokencore/api/platform/PlatformRegistries;", "<init>", "()V", "setup", "", "reg", "Lnet/thebrokenscript/brokencore/api/registry/BrokenReg;", "registerRegistry", "Lnet/minecraft/core/Registry;", "T", "registry", "createSyncedRegistry", "key", "Lnet/minecraft/resources/ResourceKey;", "createDefaultedSyncedRegistry", "defaultKey", "brokencore-common"})
    private static final class DummyPlatformRegistries
    implements PlatformRegistries {
        @Override
        public void setup(@NotNull BrokenReg reg) {
            Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        }

        @Override
        @NotNull
        public <T> Registry<T> registerRegistry(@NotNull Registry<T> registry) {
            Intrinsics.checkNotNullParameter(registry, (String)"registry");
            throw new UnsupportedOperationException();
        }

        @Override
        @NotNull
        public <T> Registry<T> createSyncedRegistry(@NotNull ResourceKey<Registry<T>> key) {
            Intrinsics.checkNotNullParameter(key, (String)"key");
            throw new UnsupportedOperationException();
        }

        @Override
        @NotNull
        public <T> Registry<T> createDefaultedSyncedRegistry(@NotNull ResourceKey<Registry<T>> key, @NotNull ResourceKey<T> defaultKey) {
            Intrinsics.checkNotNullParameter(key, (String)"key");
            Intrinsics.checkNotNullParameter(defaultKey, (String)"defaultKey");
            throw new UnsupportedOperationException();
        }
    }
}

