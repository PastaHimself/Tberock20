/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.neoforged.api.distmarker.Dist
 *  net.neoforged.bus.api.IEventBus
 *  net.neoforged.fml.ModContainer
 *  net.neoforged.fml.ModList
 *  net.neoforged.fml.config.IConfigSpec
 *  net.neoforged.fml.config.ModConfig
 *  net.neoforged.fml.config.ModConfig$Type
 *  net.neoforged.fml.event.config.ModConfigEvent$Loading
 *  net.neoforged.fml.event.config.ModConfigEvent$Reloading
 *  net.neoforged.fml.event.config.ModConfigEvent$Unloading
 *  net.neoforged.fml.loading.FMLEnvironment
 *  net.neoforged.fml.loading.FMLLoader
 *  net.neoforged.fml.loading.FMLPaths
 *  net.neoforged.fml.loading.LoadingModList
 *  net.neoforged.fml.loading.moddiscovery.ModInfo
 *  net.neoforged.neoforge.data.loading.DatagenModLoader
 *  org.apache.maven.artifact.versioning.ArtifactVersion
 *  org.apache.maven.artifact.versioning.ComparableVersion
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.neoforge;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.fml.loading.LoadingModList;
import net.neoforged.fml.loading.moddiscovery.ModInfo;
import net.neoforged.neoforge.data.loading.DatagenModLoader;
import net.thebrokenscript.brokencore.api.config.ConfigContainer;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.util.Side;
import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.apache.maven.artifact.versioning.ComparableVersion;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00152\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001a0\u001aH\u0016J \u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H\u0016\u00a8\u0006$"}, d2={"Lnet/thebrokenscript/brokencore/neoforge/PlatformUtilImpl;", "Lnet/thebrokenscript/brokencore/api/platform/PlatformUtil;", "<init>", "()V", "isClientSide", "", "isProduction", "isDataGen", "getModJarPath", "", "isModLoaded", "modId", "isModLoadedEarly", "configDir", "Ljava/nio/file/Path;", "getModVersion", "getModVersionEarly", "isModVersionAtMost", "maxVersion", "gameDir", "getSide", "Lnet/thebrokenscript/brokencore/api/util/Side;", "runWhenOn", "", "side", "func", "Lkotlin/Function0;", "registerConfig", "id", "type", "Lnet/neoforged/fml/config/ModConfig$Type;", "spec", "Lnet/neoforged/fml/config/IConfigSpec;", "registerConfigListeners", "container", "Lnet/thebrokenscript/brokencore/api/config/ConfigContainer;", "brokencore-neoforge"})
@SourceDebugExtension(value={"SMAP\nPlatformUtilImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformUtilImpl.kt\nnet/thebrokenscript/brokencore/neoforge/PlatformUtilImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,78:1\n1#2:79\n*E\n"})
public final class PlatformUtilImpl
implements PlatformUtil {
    @Override
    public boolean isClientSide() {
        return FMLLoader.getDist().isClient();
    }

    @Override
    public boolean isProduction() {
        return FMLEnvironment.production;
    }

    @Override
    public boolean isDataGen() {
        return DatagenModLoader.isRunningDataGen();
    }

    @Override
    @NotNull
    public String getModJarPath() {
        return ((Object)ModList.get().getModFileById("brokencore").getFile().getFilePath()).toString();
    }

    @Override
    public boolean isModLoaded(@NotNull String modId) {
        Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isModLoadedEarly(@NotNull String modId) {
        Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
        return LoadingModList.get().getModFileById(modId) != null;
    }

    @Override
    @NotNull
    public Path configDir() {
        Path path = FMLPaths.CONFIGDIR.get();
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"get(...)");
        return path;
    }

    @Override
    @NotNull
    public String getModVersion(@NotNull String modId) {
        Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
        String string = ModList.get().getModContainerById(modId).map(arg_0 -> PlatformUtilImpl.getModVersion$lambda$1(PlatformUtilImpl::getModVersion$lambda$0, arg_0)).orElse("unknown");
        if (string == null) {
            string = "unknown";
        }
        return string;
    }

    @NotNull
    public final String getModVersionEarly(@NotNull String modId) {
        ArtifactVersion artifactVersion;
        Object v1;
        Object object;
        block1: {
            Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
            List list = LoadingModList.get().getMods();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getMods(...)");
            object = list;
            Iterator iterator = object.iterator();
            while (iterator.hasNext()) {
                Object t = iterator.next();
                ModInfo it = (ModInfo)t;
                boolean bl = false;
                if (!Intrinsics.areEqual((Object)it.getModId(), (Object)modId)) continue;
                v1 = t;
                break block1;
            }
            v1 = null;
        }
        ModInfo modInfo = v1;
        return modInfo != null && (artifactVersion = modInfo.getVersion()) != null && (object = artifactVersion.toString()) != null ? object : "unknown";
    }

    @Override
    public boolean isModVersionAtMost(@NotNull String modId, @NotNull String maxVersion) {
        String string;
        Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
        Intrinsics.checkNotNullParameter((Object)maxVersion, (String)"maxVersion");
        String it = string = this.getModVersionEarly(modId);
        boolean bl = false;
        String string2 = !Intrinsics.areEqual((Object)it, (Object)"unknown") ? string : null;
        if (string2 == null) {
            return false;
        }
        String current = string2;
        return new ComparableVersion(current).compareTo(new ComparableVersion(maxVersion)) <= 0;
    }

    @Override
    @NotNull
    public Path gameDir() {
        Path path = FMLPaths.GAMEDIR.get();
        Intrinsics.checkNotNullExpressionValue((Object)path, (String)"get(...)");
        return path;
    }

    @Override
    @NotNull
    public Side getSide() {
        Dist dist = FMLLoader.getDist();
        return switch (dist == null ? -1 : WhenMappings.$EnumSwitchMapping$0[dist.ordinal()]) {
            case 1 -> Side.CLIENT;
            case 2 -> Side.SERVER;
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    @Override
    public void runWhenOn(@NotNull Side side, @NotNull Function0<? extends Function0<Unit>> func) {
        Intrinsics.checkNotNullParameter((Object)((Object)side), (String)"side");
        Intrinsics.checkNotNullParameter(func, (String)"func");
        switch (WhenMappings.$EnumSwitchMapping$1[side.ordinal()]) {
            case 1: {
                if (!FMLLoader.getDist().isClient()) break;
                ((Function0)func.invoke()).invoke();
                break;
            }
            case 2: {
                if (!FMLLoader.getDist().isDedicatedServer()) break;
                ((Function0)func.invoke()).invoke();
                break;
            }
            case 3: {
                ((Function0)func.invoke()).invoke();
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    @Override
    public void registerConfig(@NotNull String id, @NotNull ModConfig.Type type, @NotNull IConfigSpec spec) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)spec, (String)"spec");
        ((ModContainer)ModList.get().getModContainerById(id).orElseThrow(() -> PlatformUtilImpl.registerConfig$lambda$0(id))).registerConfig(type, spec);
    }

    @Override
    public void registerConfigListeners(@NotNull ConfigContainer container) {
        Intrinsics.checkNotNullParameter((Object)container, (String)"container");
        IEventBus iEventBus = ((ModContainer)ModList.get().getModContainerById(container.getId()).orElseThrow(() -> PlatformUtilImpl.registerConfigListeners$lambda$0(container))).getEventBus();
        if (iEventBus == null) {
            throw new IllegalStateException(("Mod container with ID " + container.getId() + " has no event bus").toString());
        }
        IEventBus b = iEventBus;
        b.addListener(arg_0 -> PlatformUtilImpl.registerConfigListeners$lambda$1(container, arg_0));
        b.addListener(arg_0 -> PlatformUtilImpl.registerConfigListeners$lambda$2(container, arg_0));
        b.addListener(arg_0 -> PlatformUtilImpl.registerConfigListeners$lambda$3(container, arg_0));
    }

    private static final String getModVersion$lambda$0(ModContainer it) {
        return it.getModInfo().getVersion().toString();
    }

    private static final String getModVersion$lambda$1(Function1 $tmp0, Object p0) {
        return (String)$tmp0.invoke(p0);
    }

    private static final RuntimeException registerConfig$lambda$0(String $id) {
        return new RuntimeException("Mod container with ID " + $id + " not found");
    }

    private static final RuntimeException registerConfigListeners$lambda$0(ConfigContainer $container) {
        return new RuntimeException("Mod container with ID " + $container.getId() + " not found");
    }

    private static final void registerConfigListeners$lambda$1(ConfigContainer $container, ModConfigEvent.Loading it) {
        ModConfig modConfig = it.getConfig();
        Intrinsics.checkNotNullExpressionValue((Object)modConfig, (String)"getConfig(...)");
        $container.onLoad(modConfig);
    }

    private static final void registerConfigListeners$lambda$2(ConfigContainer $container, ModConfigEvent.Reloading it) {
        ModConfig modConfig = it.getConfig();
        Intrinsics.checkNotNullExpressionValue((Object)modConfig, (String)"getConfig(...)");
        $container.onReload(modConfig);
    }

    private static final void registerConfigListeners$lambda$3(ConfigContainer $container, ModConfigEvent.Unloading it) {
        ModConfig modConfig = it.getConfig();
        Intrinsics.checkNotNullExpressionValue((Object)modConfig, (String)"getConfig(...)");
        $container.onUnload(modConfig);
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] nArray = new int[Dist.values().length];
            try {
                nArray[Dist.CLIENT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Dist.DEDICATED_SERVER.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
            nArray = new int[Side.values().length];
            try {
                nArray[Side.CLIENT.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Side.SERVER.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Side.BOTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$1 = nArray;
        }
    }
}

