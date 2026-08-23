/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Multimap
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.packs.PackType
 *  net.minecraft.server.packs.repository.Pack$ResourcesSupplier
 *  net.minecraft.server.packs.resources.MultiPackResourceManager
 *  net.neoforged.fml.ModList
 *  net.neoforged.neoforge.common.data.ExistingFileHelper
 *  net.neoforged.neoforge.resource.ResourcePackLoader
 *  net.neoforged.neoforgespi.language.IModFileInfo
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import com.google.common.collect.Multimap;
import compat.net.neoforged.neoforge.common.data.ExistingFileHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.resources.MultiPackResourceManager;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.resource.ResourcePackLoader;
import net.neoforged.neoforgespi.language.IModFileInfo;
import net.thebrokenscript.brokencore.api.platform.PlatformDatagen;
import net.thebrokenscript.brokencore.neoforge.mixin.DatagenModLoaderAccessor;
import net.thebrokenscript.brokencore.neoforge.mixin.ExistingFileHelperAccessor;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/PlatformDatagenImpl;", "Lnet/thebrokenscript/brokencore/api/platform/PlatformDatagen;", "<init>", "()V", "createPackForMod", "Lnet/minecraft/server/packs/repository/Pack$ResourcesSupplier;", "modId", "", "createFileHelper", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "Companion", "brokencore-neoforge"})
public final class PlatformDatagenImpl
implements PlatformDatagen {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Lazy<ExistingFileHelper> helper$delegate = LazyKt.lazy(PlatformDatagenImpl::helper_delegate$lambda$0);

    @Override
    @NotNull
    public Pack.ResourcesSupplier createPackForMod(@NotNull String modId) {
        Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
        Pack.ResourcesSupplier resourcesSupplier = ResourcePackLoader.createPackForMod((IModFileInfo)ModList.get().getModFileById(modId));
        Intrinsics.checkNotNullExpressionValue((Object)resourcesSupplier, (String)"createPackForMod(...)");
        return resourcesSupplier;
    }

    @Override
    @NotNull
    public ExistingFileHelper createFileHelper() {
        return PlatformDatagenImpl.Companion.getHelper();
    }

    private static final ExistingFileHelper helper_delegate$lambda$0() {
        net.neoforged.neoforge.common.data.ExistingFileHelper existingFileHelper = DatagenModLoaderAccessor.brokencore$getExistingFileHelper();
        Intrinsics.checkNotNull((Object)existingFileHelper, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.neoforge.mixin.ExistingFileHelperAccessor");
        ExistingFileHelperAccessor it = (ExistingFileHelperAccessor)existingFileHelper;
        boolean bl = false;
        MultiPackResourceManager multiPackResourceManager = it.brokencore$getClientResources();
        Intrinsics.checkNotNullExpressionValue((Object)multiPackResourceManager, (String)"brokencore$getClientResources(...)");
        MultiPackResourceManager multiPackResourceManager2 = it.brokencore$getServerData();
        Intrinsics.checkNotNullExpressionValue((Object)multiPackResourceManager2, (String)"brokencore$getServerData(...)");
        boolean bl2 = it.brokencore$getEnable();
        Multimap<PackType, ResourceLocation> multimap = it.brokencore$getGenerated();
        Intrinsics.checkNotNullExpressionValue(multimap, (String)"brokencore$getGenerated(...)");
        return new ExistingFileHelper(multiPackResourceManager, multiPackResourceManager2, bl2, multimap);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/PlatformDatagenImpl$Companion;", "", "<init>", "()V", "helper", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "getHelper", "()Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "helper$delegate", "Lkotlin/Lazy;", "brokencore-neoforge"})
    public static final class Companion {
        private Companion() {
        }

        private final ExistingFileHelper getHelper() {
            Lazy lazy = helper$delegate;
            return (ExistingFileHelper)lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

