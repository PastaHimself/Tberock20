/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  net.neoforged.fml.config.IConfigSpec
 *  net.neoforged.fml.config.ModConfig$Type
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.platform;

import java.nio.file.Path;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.fml.config.ModConfig;
import net.thebrokenscript.brokencore.api.config.ConfigContainer;
import net.thebrokenscript.brokencore.api.util.Side;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \"2\u00020\u0001:\u0002!\"J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H&J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00110\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J \u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H&J\b\u0010 \u001a\u00020\u0013H&\u00a8\u0006#"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformUtil;", "", "isClientSide", "", "isProduction", "isDataGen", "getModJarPath", "", "getSide", "Lnet/thebrokenscript/brokencore/api/util/Side;", "isModLoaded", "modId", "isModLoadedEarly", "runWhenOn", "", "side", "func", "Lkotlin/Function0;", "configDir", "Ljava/nio/file/Path;", "registerConfig", "id", "type", "Lnet/neoforged/fml/config/ModConfig$Type;", "spec", "Lnet/neoforged/fml/config/IConfigSpec;", "registerConfigListeners", "container", "Lnet/thebrokenscript/brokencore/api/config/ConfigContainer;", "getModVersion", "isModVersionAtMost", "maxVersion", "gameDir", "DummyPlatformUtil", "Companion", "brokencore-common"})
public interface PlatformUtil {
    @NotNull
    public static final Companion Companion = net.thebrokenscript.brokencore.api.platform.PlatformUtil$Companion.$$INSTANCE;

    public boolean isClientSide();

    public boolean isProduction();

    public boolean isDataGen();

    @NotNull
    public String getModJarPath();

    @NotNull
    public Side getSide();

    public boolean isModLoaded(@NotNull String var1);

    public boolean isModLoadedEarly(@NotNull String var1);

    public void runWhenOn(@NotNull Side var1, @NotNull Function0<? extends Function0<Unit>> var2);

    @NotNull
    public Path configDir();

    public void registerConfig(@NotNull String var1, @NotNull ModConfig.Type var2, @NotNull IConfigSpec var3);

    public void registerConfigListeners(@NotNull ConfigContainer var1);

    @NotNull
    public String getModVersion(@NotNull String var1);

    public boolean isModVersionAtMost(@NotNull String var1, @NotNull String var2);

    @NotNull
    public Path gameDir();

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u0011\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\fH\u0096\u0001J\t\u0010\r\u001a\u00020\u000eH\u0096\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\bH\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\bH\u0096\u0001J\u0019\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0096\u0001J\t\u0010\u0014\u001a\u00020\u000eH\u0096\u0001J!\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0096\u0001J\u0011\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0096\u0001J%\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\f2\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\"0\"H\u0096\u0001\u00a8\u0006#"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformUtil$Companion;", "Lnet/thebrokenscript/brokencore/api/platform/PlatformUtil;", "<init>", "()V", "configDir", "Ljava/nio/file/Path;", "gameDir", "getModJarPath", "", "getModVersion", "modId", "getSide", "Lnet/thebrokenscript/brokencore/api/util/Side;", "isClientSide", "", "isDataGen", "isModLoaded", "isModLoadedEarly", "isModVersionAtMost", "maxVersion", "isProduction", "registerConfig", "", "id", "type", "Lnet/neoforged/fml/config/ModConfig$Type;", "spec", "Lnet/neoforged/fml/config/IConfigSpec;", "registerConfigListeners", "container", "Lnet/thebrokenscript/brokencore/api/config/ConfigContainer;", "runWhenOn", "side", "func", "Lkotlin/Function0;", "brokencore-common"})
    public static final class Companion
    implements PlatformUtil {
        static final /* synthetic */ Companion $$INSTANCE;
        private final /* synthetic */ PlatformUtil $$delegate_0;

        private Companion() {
            PlatformUtil platformUtil;
            if (System.getenv().containsKey("TEST_ENV")) {
                platformUtil = new DummyPlatformUtil();
            } else {
                ServiceLoader<PlatformUtil> serviceLoader = ServiceLoader.load(PlatformUtil.class);
                Intrinsics.checkNotNullExpressionValue(serviceLoader, (String)"load(...)");
                Object object = CollectionsKt.first((Iterable)serviceLoader);
                Intrinsics.checkNotNullExpressionValue((Object)object, (String)"first(...)");
                platformUtil = (PlatformUtil)object;
            }
            this.$$delegate_0 = platformUtil;
        }

        @Override
        public boolean isClientSide() {
            return this.$$delegate_0.isClientSide();
        }

        @Override
        public boolean isProduction() {
            return this.$$delegate_0.isProduction();
        }

        @Override
        public boolean isDataGen() {
            return this.$$delegate_0.isDataGen();
        }

        @Override
        @NotNull
        public String getModJarPath() {
            return this.$$delegate_0.getModJarPath();
        }

        @Override
        @NotNull
        public Side getSide() {
            return this.$$delegate_0.getSide();
        }

        @Override
        public boolean isModLoaded(@NotNull String modId) {
            Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
            return this.$$delegate_0.isModLoaded(modId);
        }

        @Override
        public boolean isModLoadedEarly(@NotNull String modId) {
            Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
            return this.$$delegate_0.isModLoadedEarly(modId);
        }

        @Override
        public void runWhenOn(@NotNull Side side, @NotNull Function0<? extends Function0<Unit>> func) {
            Intrinsics.checkNotNullParameter((Object)((Object)side), (String)"side");
            Intrinsics.checkNotNullParameter(func, (String)"func");
            this.$$delegate_0.runWhenOn(side, func);
        }

        @Override
        @NotNull
        public Path configDir() {
            return this.$$delegate_0.configDir();
        }

        @Override
        public void registerConfig(@NotNull String id, @NotNull ModConfig.Type type, @NotNull IConfigSpec spec) {
            Intrinsics.checkNotNullParameter((Object)id, (String)"id");
            Intrinsics.checkNotNullParameter((Object)type, (String)"type");
            Intrinsics.checkNotNullParameter((Object)spec, (String)"spec");
            this.$$delegate_0.registerConfig(id, type, spec);
        }

        @Override
        public void registerConfigListeners(@NotNull ConfigContainer container) {
            Intrinsics.checkNotNullParameter((Object)container, (String)"container");
            this.$$delegate_0.registerConfigListeners(container);
        }

        @Override
        @NotNull
        public String getModVersion(@NotNull String modId) {
            Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
            return this.$$delegate_0.getModVersion(modId);
        }

        @Override
        public boolean isModVersionAtMost(@NotNull String modId, @NotNull String maxVersion) {
            Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
            Intrinsics.checkNotNullParameter((Object)maxVersion, (String)"maxVersion");
            return this.$$delegate_0.isModVersionAtMost(modId, maxVersion);
        }

        @Override
        @NotNull
        public Path gameDir() {
            return this.$$delegate_0.gameDir();
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00130\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u0018\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J \u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H\u0016\u00a8\u0006$"}, d2={"Lnet/thebrokenscript/brokencore/api/platform/PlatformUtil$DummyPlatformUtil;", "Lnet/thebrokenscript/brokencore/api/platform/PlatformUtil;", "<init>", "()V", "isClientSide", "", "isProduction", "isDataGen", "getModJarPath", "", "getSide", "Lnet/thebrokenscript/brokencore/api/util/Side;", "isModLoaded", "modId", "isModLoadedEarly", "runWhenOn", "", "side", "func", "Lkotlin/Function0;", "configDir", "Ljava/nio/file/Path;", "getModVersion", "", "isModVersionAtMost", "maxVersion", "gameDir", "registerConfig", "id", "type", "Lnet/neoforged/fml/config/ModConfig$Type;", "spec", "Lnet/neoforged/fml/config/IConfigSpec;", "registerConfigListeners", "container", "Lnet/thebrokenscript/brokencore/api/config/ConfigContainer;", "brokencore-common"})
    private static final class DummyPlatformUtil
    implements PlatformUtil {
        @Override
        public boolean isClientSide() {
            return true;
        }

        @Override
        public boolean isProduction() {
            return false;
        }

        @Override
        public boolean isDataGen() {
            return false;
        }

        @Override
        @NotNull
        public String getModJarPath() {
            throw new UnsupportedOperationException();
        }

        @Override
        @NotNull
        public Side getSide() {
            return Side.BOTH;
        }

        @Override
        public boolean isModLoaded(@NotNull String modId) {
            Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
            return false;
        }

        @Override
        public boolean isModLoadedEarly(@NotNull String modId) {
            Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
            return false;
        }

        @Override
        public void runWhenOn(@NotNull Side side, @NotNull Function0<? extends Function0<Unit>> func) {
            Intrinsics.checkNotNullParameter((Object)((Object)side), (String)"side");
            Intrinsics.checkNotNullParameter(func, (String)"func");
            ((Function0)func.invoke()).invoke();
        }

        @Override
        @NotNull
        public Path configDir() {
            throw new UnsupportedOperationException();
        }

        @NotNull
        public Void getModVersion(@NotNull String modId) {
            Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean isModVersionAtMost(@NotNull String modId, @NotNull String maxVersion) {
            Intrinsics.checkNotNullParameter((Object)modId, (String)"modId");
            Intrinsics.checkNotNullParameter((Object)maxVersion, (String)"maxVersion");
            throw new UnsupportedOperationException();
        }

        @Override
        @NotNull
        public Path gameDir() {
            throw new UnsupportedOperationException();
        }

        @NotNull
        public Void registerConfig(@NotNull String id, @NotNull ModConfig.Type type, @NotNull IConfigSpec spec) {
            Intrinsics.checkNotNullParameter((Object)id, (String)"id");
            Intrinsics.checkNotNullParameter((Object)type, (String)"type");
            Intrinsics.checkNotNullParameter((Object)spec, (String)"spec");
            throw new UnsupportedOperationException();
        }

        @NotNull
        public Void registerConfigListeners(@NotNull ConfigContainer container) {
            Intrinsics.checkNotNullParameter((Object)container, (String)"container");
            throw new UnsupportedOperationException();
        }
    }
}

