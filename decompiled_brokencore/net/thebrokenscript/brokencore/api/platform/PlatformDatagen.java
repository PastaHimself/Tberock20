/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.packs.repository.Pack$ResourcesSupplier
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.platform;

import compat.net.neoforged.neoforge.common.data.ExistingFileHelper;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.packs.repository.Pack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformDatagen;", "", "createPackForMod", "Lnet/minecraft/server/packs/repository/Pack$ResourcesSupplier;", "modId", "", "createFileHelper", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "Companion", "brokencore-common"})
public interface PlatformDatagen {
    @NotNull
    public static final Companion Companion = net.thebrokenscript.brokencore.api.platform.PlatformDatagen$Companion.$$INSTANCE;

    @NotNull
    public Pack.ResourcesSupplier createPackForMod(@NotNull String var1);

    @NotNull
    public ExistingFileHelper createFileHelper();

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformDatagen$Companion;", "Lnet/thebrokenscript/brokencore/api/platform/PlatformDatagen;", "<init>", "()V", "createFileHelper", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "createPackForMod", "Lnet/minecraft/server/packs/repository/Pack$ResourcesSupplier;", "modId", "", "brokencore-common"})
    public static final class Companion
    implements PlatformDatagen {
        static final /* synthetic */ Companion $$INSTANCE;
        private final /* synthetic */ PlatformDatagen $$delegate_0;

        private Companion() {
            ServiceLoader<PlatformDatagen> serviceLoader = ServiceLoader.load(PlatformDatagen.class);
            Intrinsics.checkNotNullExpressionValue(serviceLoader, (String)"load(...)");
            this.$$delegate_0 = (PlatformDatagen)CollectionsKt.first((Iterable)serviceLoader);
        }

        @Override
        @NotNull
        public Pack.ResourcesSupplier createPackForMod(@NotNull String modId) {
            Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
            return this.$$delegate_0.createPackForMod(modId);
        }

        @Override
        @NotNull
        public ExistingFileHelper createFileHelper() {
            return this.$$delegate_0.createFileHelper();
        }

        static {
            $$INSTANCE = new Companion();
        }
    }
}

