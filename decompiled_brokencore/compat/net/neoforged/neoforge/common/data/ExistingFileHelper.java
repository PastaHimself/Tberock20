/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.HashMultimap
 *  com.google.common.collect.Multimap
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Regex
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.main.GameConfig
 *  net.minecraft.client.resources.ClientPackSource
 *  net.minecraft.client.resources.IndexedAssetSource
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.packs.FilePackResources
 *  net.minecraft.server.packs.FilePackResources$SharedZipFileAccess
 *  net.minecraft.server.packs.PackLocationInfo
 *  net.minecraft.server.packs.PackResources
 *  net.minecraft.server.packs.PackType
 *  net.minecraft.server.packs.PathPackResources
 *  net.minecraft.server.packs.VanillaPackResources
 *  net.minecraft.server.packs.repository.PackSource
 *  net.minecraft.server.packs.repository.ServerPacksSource
 *  net.minecraft.server.packs.resources.MultiPackResourceManager
 *  net.minecraft.server.packs.resources.Resource
 *  net.minecraft.server.packs.resources.ResourceManager
 *  org.jetbrains.annotations.ApiStatus$Internal
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.jetbrains.annotations.VisibleForTesting
 */
package compat.net.neoforged.neoforge.common.data;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import net.minecraft.client.resources.ClientPackSource;
import net.minecraft.client.resources.IndexedAssetSource;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.FilePackResources;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.VanillaPackResources;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.repository.ServerPacksSource;
import net.minecraft.server.packs.resources.MultiPackResourceManager;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.thebrokenscript.brokencore.api.mixinterfaces.MinecraftExt;
import net.thebrokenscript.brokencore.api.platform.PlatformDatagen;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0003-./BA\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\r\u0010\u000eB!\b\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u0012B5\b\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014\u00a2\u0006\u0004\b\r\u0010\u0017J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0002J$\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0007H\u0002J\u0016\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0015J\u0016\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$J&\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007J\u0016\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$J&\u0010'\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007J(\u0010)\u001a\u00020*2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0007J\u0018\u0010)\u001a\u00020*2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0015H\u0007J\u001e\u0010+\u001a\b\u0012\u0004\u0012\u00020*0,2\u0006\u0010\"\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0015H\u0007R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2={"Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "", "existingPacks", "", "Ljava/nio/file/Path;", "existingMods", "", "", "enable", "", "assetIndex", "assetsDir", "Ljava/io/File;", "<init>", "(Ljava/util/Collection;Ljava/util/Set;ZLjava/lang/String;Ljava/io/File;)V", "clientResources", "Lnet/minecraft/server/packs/resources/MultiPackResourceManager;", "serverData", "(Lnet/minecraft/server/packs/resources/MultiPackResourceManager;Lnet/minecraft/server/packs/resources/MultiPackResourceManager;Z)V", "generated", "Lcom/google/common/collect/Multimap;", "Lnet/minecraft/server/packs/PackType;", "Lnet/minecraft/resources/ResourceLocation;", "(Lnet/minecraft/server/packs/resources/MultiPackResourceManager;Lnet/minecraft/server/packs/resources/MultiPackResourceManager;ZLcom/google/common/collect/Multimap;)V", "isEnabled", "()Z", "getManager", "Lnet/minecraft/server/packs/resources/ResourceManager;", "packType", "getLocation", "base", "suffix", "prefix", "exists", "loc", "type", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper$IResourceType;", "pathSuffix", "pathPrefix", "trackGenerated", "", "getResource", "Lnet/minecraft/server/packs/resources/Resource;", "getResourceStack", "", "IResourceType", "ResourceType", "Companion", "brokencore-common"})
public final class ExistingFileHelper {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final MultiPackResourceManager clientResources;
    @NotNull
    private final MultiPackResourceManager serverData;
    private final boolean isEnabled;
    @NotNull
    private Multimap<PackType, ResourceLocation> generated;
    @NotNull
    public static final String EXISTING_RESOURCES = "porting_lib.datagen.existing_resources";
    @NotNull
    public static final String EXISTING_MODS = "porting_lib.datagen.existing-mod";

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public ExistingFileHelper(@NotNull Collection<? extends Path> existingPacks, @NotNull Set<String> existingMods, boolean enable, @Nullable String assetIndex, @Nullable File assetsDir) {
        Intrinsics.checkNotNullParameter(existingPacks, (String)"existingPacks");
        Intrinsics.checkNotNullParameter(existingMods, (String)"existingMods");
        HashMultimap hashMultimap = HashMultimap.create();
        Intrinsics.checkNotNullExpressionValue((Object)hashMultimap, (String)"create(...)");
        this.generated = (Multimap)hashMultimap;
        List candidateClientResources = new ArrayList();
        List candidateServerResources = new ArrayList();
        if (assetIndex != null && assetsDir != null && assetsDir.exists()) {
            VanillaPackResources vanillaPackResources = ClientPackSource.createVanillaPackSource((Path)IndexedAssetSource.createIndexFs((Path)assetsDir.toPath(), (String)assetIndex));
            Intrinsics.checkNotNullExpressionValue((Object)vanillaPackResources, (String)"createVanillaPackSource(...)");
            candidateClientResources.add(vanillaPackResources);
        }
        VanillaPackResources vanillaPackResources = ServerPacksSource.createVanillaPackSource();
        Intrinsics.checkNotNullExpressionValue((Object)vanillaPackResources, (String)"createVanillaPackSource(...)");
        candidateServerResources.add(vanillaPackResources);
        for (Path path : existingPacks) {
            File file = path.toFile();
            if (!file.exists()) continue;
            PackResources pack = file.isDirectory() ? (PackResources)new PathPackResources(new PackLocationInfo(file.getName(), (Component)Component.empty(), PackSource.BUILT_IN, Optional.empty()), file.toPath()) : (PackResources)new FilePackResources(new PackLocationInfo(file.getName(), (Component)Component.empty(), PackSource.BUILT_IN, Optional.empty()), new FilePackResources.SharedZipFileAccess(file), "");
            candidateClientResources.add(pack);
            candidateServerResources.add(pack);
        }
        for (String string : existingMods) {
            if (!PlatformUtil.Companion.isModLoaded(string)) continue;
            String name = "mod/" + string;
            PackResources packResources = PlatformDatagen.Companion.createPackForMod(string).openPrimary(new PackLocationInfo(name, (Component)Component.empty(), PackSource.BUILT_IN, Optional.empty()));
            Intrinsics.checkNotNullExpressionValue((Object)packResources, (String)"openPrimary(...)");
            candidateClientResources.add(packResources);
            PackResources packResources2 = PlatformDatagen.Companion.createPackForMod(string).openPrimary(new PackLocationInfo(name, (Component)Component.empty(), PackSource.BUILT_IN, Optional.empty()));
            Intrinsics.checkNotNullExpressionValue((Object)packResources2, (String)"openPrimary(...)");
            candidateServerResources.add(packResources2);
        }
        this.clientResources = new MultiPackResourceManager(PackType.CLIENT_RESOURCES, candidateClientResources);
        this.serverData = new MultiPackResourceManager(PackType.SERVER_DATA, candidateServerResources);
        this.isEnabled = enable;
    }

    @ApiStatus.Internal
    public ExistingFileHelper(@NotNull MultiPackResourceManager clientResources, @NotNull MultiPackResourceManager serverData, boolean enable) {
        Intrinsics.checkNotNullParameter((Object)clientResources, (String)"clientResources");
        Intrinsics.checkNotNullParameter((Object)serverData, (String)"serverData");
        HashMultimap hashMultimap = HashMultimap.create();
        Intrinsics.checkNotNullExpressionValue((Object)hashMultimap, (String)"create(...)");
        this(clientResources, serverData, enable, (Multimap<PackType, ResourceLocation>)((Multimap)hashMultimap));
    }

    @ApiStatus.Internal
    public ExistingFileHelper(@NotNull MultiPackResourceManager clientResources, @NotNull MultiPackResourceManager serverData, boolean enable, @NotNull Multimap<PackType, ResourceLocation> generated) {
        Intrinsics.checkNotNullParameter((Object)clientResources, (String)"clientResources");
        Intrinsics.checkNotNullParameter((Object)serverData, (String)"serverData");
        Intrinsics.checkNotNullParameter(generated, (String)"generated");
        HashMultimap hashMultimap = HashMultimap.create();
        Intrinsics.checkNotNullExpressionValue((Object)hashMultimap, (String)"create(...)");
        this.generated = (Multimap)hashMultimap;
        this.clientResources = clientResources;
        this.serverData = serverData;
        this.isEnabled = enable;
        this.generated = generated;
    }

    private final ResourceManager getManager(PackType packType) {
        return packType == PackType.CLIENT_RESOURCES ? (ResourceManager)this.clientResources : (ResourceManager)this.serverData;
    }

    private final ResourceLocation getLocation(ResourceLocation base, String suffix, String prefix) {
        ResourceLocation resourceLocation = ResourceLocation.fromNamespaceAndPath((String)base.getNamespace(), (String)(prefix + "/" + base.getPath() + suffix));
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"fromNamespaceAndPath(...)");
        return resourceLocation;
    }

    public final boolean exists(@NotNull ResourceLocation loc, @NotNull PackType packType) {
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        Intrinsics.checkNotNullParameter((Object)packType, (String)"packType");
        if (!this.isEnabled) {
            return true;
        }
        return this.generated.get((Object)packType).contains(loc) || this.getManager(packType).getResource(loc).isPresent();
    }

    public final boolean exists(@NotNull ResourceLocation loc, @NotNull IResourceType type) {
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        return this.exists(this.getLocation(loc, type.getSuffix(), type.getPrefix()), type.getPackType());
    }

    public final boolean exists(@NotNull ResourceLocation loc, @NotNull PackType packType, @NotNull String pathSuffix, @NotNull String pathPrefix) {
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        Intrinsics.checkNotNullParameter((Object)packType, (String)"packType");
        Intrinsics.checkNotNullParameter((Object)pathSuffix, (String)"pathSuffix");
        Intrinsics.checkNotNullParameter((Object)pathPrefix, (String)"pathPrefix");
        return this.exists(this.getLocation(loc, pathSuffix, pathPrefix), packType);
    }

    public final void trackGenerated(@NotNull ResourceLocation loc, @NotNull IResourceType type) {
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        this.generated.put((Object)type.getPackType(), (Object)this.getLocation(loc, type.getSuffix(), type.getPrefix()));
    }

    public final void trackGenerated(@NotNull ResourceLocation loc, @NotNull PackType packType, @NotNull String pathSuffix, @NotNull String pathPrefix) {
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        Intrinsics.checkNotNullParameter((Object)packType, (String)"packType");
        Intrinsics.checkNotNullParameter((Object)pathSuffix, (String)"pathSuffix");
        Intrinsics.checkNotNullParameter((Object)pathPrefix, (String)"pathPrefix");
        this.generated.put((Object)packType, (Object)this.getLocation(loc, pathSuffix, pathPrefix));
    }

    @VisibleForTesting
    @NotNull
    public final Resource getResource(@NotNull ResourceLocation loc, @NotNull PackType packType, @NotNull String pathSuffix, @NotNull String pathPrefix) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        Intrinsics.checkNotNullParameter((Object)packType, (String)"packType");
        Intrinsics.checkNotNullParameter((Object)pathSuffix, (String)"pathSuffix");
        Intrinsics.checkNotNullParameter((Object)pathPrefix, (String)"pathPrefix");
        return this.getResource(this.getLocation(loc, pathSuffix, pathPrefix), packType);
    }

    @VisibleForTesting
    @NotNull
    public final Resource getResource(@NotNull ResourceLocation loc, @NotNull PackType packType) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        Intrinsics.checkNotNullParameter((Object)packType, (String)"packType");
        Resource resource = this.getManager(packType).getResourceOrThrow(loc);
        Intrinsics.checkNotNullExpressionValue((Object)resource, (String)"getResourceOrThrow(...)");
        return resource;
    }

    @VisibleForTesting
    @NotNull
    public final List<Resource> getResourceStack(@NotNull ResourceLocation loc, @NotNull PackType packType) {
        Intrinsics.checkNotNullParameter((Object)loc, (String)"loc");
        Intrinsics.checkNotNullParameter((Object)packType, (String)"packType");
        List list = this.getManager(packType).getResourceStack(loc);
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getResourceStack(...)");
        return list;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u001f\u0010\f\u001a\u00020\b2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J-\u0010\f\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000f\u00a2\u0006\u0002\u0010\u0013J5\u0010\f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000f\u00a2\u0006\u0002\u0010\u0015J=\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000f\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper$Companion;", "", "<init>", "()V", "EXISTING_RESOURCES", "", "EXISTING_MODS", "withResourcesFromArg", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "withConfig", "config", "Lnet/minecraft/client/main/GameConfig;", "withResources", "paths", "", "Ljava/nio/file/Path;", "([Ljava/nio/file/Path;)Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "mods", "", "(Ljava/util/Set;[Ljava/nio/file/Path;)Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "gameConfig", "(Lnet/minecraft/client/main/GameConfig;Ljava/util/Set;[Ljava/nio/file/Path;)Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "withInfoAndResources", "assetIndex", "assetDirectory", "Ljava/io/File;", "(Ljava/lang/String;Ljava/io/File;Ljava/util/Set;[Ljava/nio/file/Path;)Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper;", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nExistingFileHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExistingFileHelper.kt\ncompat/net/neoforged/neoforge/common/data/ExistingFileHelper$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,357:1\n1#2:358\n739#3,9:359\n37#4,2:368\n*S KotlinDebug\n*F\n+ 1 ExistingFileHelper.kt\ncompat/net/neoforged/neoforge/common/data/ExistingFileHelper$Companion\n*L\n311#1:359,9\n311#1:368,2\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final ExistingFileHelper withResourcesFromArg() {
            void $this$toTypedArray$iv;
            List list;
            Collection $this$dropLastWhile$iv;
            String property = System.getProperty(ExistingFileHelper.EXISTING_RESOURCES);
            if (property == null) {
                boolean $i$a$-requireNotNull-ExistingFileHelper$Companion$withResourcesFromArg$22 = false;
                String $i$a$-requireNotNull-ExistingFileHelper$Companion$withResourcesFromArg$22 = "Existing resources not specified with 'porting_lib.datagen.existing_resources' argument";
                throw new IllegalArgumentException($i$a$-requireNotNull-ExistingFileHelper$Companion$withResourcesFromArg$22.toString());
            }
            Path path = Paths.get(property, new String[0]);
            if (!Files.isDirectory(path, new LinkOption[0])) {
                boolean bl = false;
                String string = "Path " + property + " is not a directory or does not exist";
                throw new IllegalStateException(string.toString());
            }
            String mods = System.getProperty(ExistingFileHelper.EXISTING_MODS);
            if (mods == null) {
                mods = "";
            }
            Object object = mods;
            String string = ",";
            string = new Regex(string);
            int n = 0;
            object = string.split((CharSequence)object, n);
            Companion companion = this;
            boolean $i$f$dropLastWhile = false;
            if (!$this$dropLastWhile$iv.isEmpty()) {
                ListIterator iterator$iv = $this$dropLastWhile$iv.listIterator($this$dropLastWhile$iv.size());
                while (iterator$iv.hasPrevious()) {
                    String it = (String)iterator$iv.previous();
                    boolean bl = false;
                    if (((CharSequence)it).length() == 0) continue;
                    list = CollectionsKt.take((Iterable)$this$dropLastWhile$iv, (int)(iterator$iv.nextIndex() + 1));
                    break;
                }
            } else {
                list = CollectionsKt.emptyList();
            }
            $this$dropLastWhile$iv = list;
            boolean $i$f$toTypedArray = false;
            void thisCollection$iv = $this$toTypedArray$iv;
            Object[] objectArray = thisCollection$iv.toArray(new String[0]);
            Collection collection = CollectionsKt.listOf((Object[])Arrays.copyOf(objectArray, objectArray.length));
            Set set = new HashSet(collection);
            objectArray = new Path[1];
            Intrinsics.checkNotNull((Object)path);
            objectArray[0] = path;
            return companion.withResources(set, (Path[])objectArray);
        }

        @NotNull
        public final ExistingFileHelper withConfig(@NotNull GameConfig config) {
            Intrinsics.checkNotNullParameter((Object)config, (String)"config");
            return new ExistingFileHelper(new ArrayList(), new LinkedHashSet(), true, config.location.assetIndex, config.location.assetDirectory);
        }

        @NotNull
        public final ExistingFileHelper withResources(Path ... paths) {
            Intrinsics.checkNotNullParameter((Object)paths, (String)"paths");
            Minecraft minecraft = Minecraft.getInstance();
            Intrinsics.checkNotNull((Object)minecraft, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.mixinterfaces.MinecraftExt");
            GameConfig gameConfig = ((MinecraftExt)minecraft).bc$getGameConfig();
            return new ExistingFileHelper(CollectionsKt.listOf((Object[])Arrays.copyOf(paths, paths.length)), new LinkedHashSet(), true, gameConfig.location.assetIndex, gameConfig.location.assetDirectory);
        }

        @NotNull
        public final ExistingFileHelper withResources(@NotNull Set<String> mods, Path ... paths) {
            Intrinsics.checkNotNullParameter(mods, (String)"mods");
            Intrinsics.checkNotNullParameter((Object)paths, (String)"paths");
            Minecraft minecraft = Minecraft.getInstance();
            Intrinsics.checkNotNull((Object)minecraft, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.mixinterfaces.MinecraftExt");
            return this.withResources(((MinecraftExt)minecraft).bc$getGameConfig(), mods, Arrays.copyOf(paths, paths.length));
        }

        @NotNull
        public final ExistingFileHelper withResources(@NotNull GameConfig gameConfig, @NotNull Set<String> mods, Path ... paths) {
            Intrinsics.checkNotNullParameter((Object)gameConfig, (String)"gameConfig");
            Intrinsics.checkNotNullParameter(mods, (String)"mods");
            Intrinsics.checkNotNullParameter((Object)paths, (String)"paths");
            return new ExistingFileHelper(CollectionsKt.listOf((Object[])Arrays.copyOf(paths, paths.length)), mods, true, gameConfig.location.assetIndex, gameConfig.location.assetDirectory);
        }

        @NotNull
        public final ExistingFileHelper withInfoAndResources(@NotNull String assetIndex, @NotNull File assetDirectory, @NotNull Set<String> mods, Path ... paths) {
            Intrinsics.checkNotNullParameter((Object)assetIndex, (String)"assetIndex");
            Intrinsics.checkNotNullParameter((Object)assetDirectory, (String)"assetDirectory");
            Intrinsics.checkNotNullParameter(mods, (String)"mods");
            Intrinsics.checkNotNullParameter((Object)paths, (String)"paths");
            return new ExistingFileHelper(CollectionsKt.listOf((Object[])Arrays.copyOf(paths, paths.length)), mods, true, assetIndex, assetDirectory);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\f"}, d2={"Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper$IResourceType;", "", "packType", "Lnet/minecraft/server/packs/PackType;", "getPackType", "()Lnet/minecraft/server/packs/PackType;", "suffix", "", "getSuffix", "()Ljava/lang/String;", "prefix", "getPrefix", "brokencore-common"})
    public static interface IResourceType {
        @NotNull
        public PackType getPackType();

        @NotNull
        public String getSuffix();

        @NotNull
        public String getPrefix();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u000e"}, d2={"Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper$ResourceType;", "Lcompat/net/neoforged/neoforge/common/data/ExistingFileHelper$IResourceType;", "packType", "Lnet/minecraft/server/packs/PackType;", "suffix", "", "prefix", "<init>", "(Lnet/minecraft/server/packs/PackType;Ljava/lang/String;Ljava/lang/String;)V", "getPackType", "()Lnet/minecraft/server/packs/PackType;", "getSuffix", "()Ljava/lang/String;", "getPrefix", "brokencore-common"})
    public static final class ResourceType
    implements IResourceType {
        @NotNull
        private final PackType packType;
        @NotNull
        private final String suffix;
        @NotNull
        private final String prefix;

        public ResourceType(@NotNull PackType packType, @NotNull String suffix, @NotNull String prefix) {
            Intrinsics.checkNotNullParameter((Object)packType, (String)"packType");
            Intrinsics.checkNotNullParameter((Object)suffix, (String)"suffix");
            Intrinsics.checkNotNullParameter((Object)prefix, (String)"prefix");
            this.packType = packType;
            this.suffix = suffix;
            this.prefix = prefix;
        }

        @Override
        @NotNull
        public PackType getPackType() {
            return this.packType;
        }

        @Override
        @NotNull
        public String getSuffix() {
            return this.suffix;
        }

        @Override
        @NotNull
        public String getPrefix() {
            return this.prefix;
        }
    }
}

