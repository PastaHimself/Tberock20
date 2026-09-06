/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.caffeinemc.mods.sodium.client.gl.shader.GlShader
 *  net.caffeinemc.mods.sodium.client.gl.shader.ShaderConstants
 *  net.caffeinemc.mods.sodium.client.gl.shader.ShaderParser
 *  net.caffeinemc.mods.sodium.client.gl.shader.ShaderType
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.compat.sodium;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.caffeinemc.mods.sodium.client.gl.shader.GlShader;
import net.caffeinemc.mods.sodium.client.gl.shader.ShaderConstants;
import net.caffeinemc.mods.sodium.client.gl.shader.ShaderParser;
import net.caffeinemc.mods.sodium.client.gl.shader.ShaderType;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.impl.compat.sodium.BCShaderLoader;
import net.thebrokenscript.brokencore.impl.compat.sodium.BCShaderParser;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0005H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/impl/compat/sodium/BCSodiumInterface;", "", "<init>", "()V", "shaderApi", "Lnet/thebrokenscript/brokencore/impl/compat/sodium/BCSodiumInterface$ShaderApi;", "getShaderApi$brokencore_common", "()Lnet/thebrokenscript/brokencore/impl/compat/sodium/BCSodiumInterface$ShaderApi;", "shaderApi$delegate", "Lkotlin/Lazy;", "detectShaderApi", "ShaderApi", "LegacyApi", "ModernApi", "brokencore-common"})
public final class BCSodiumInterface {
    @NotNull
    public static final BCSodiumInterface INSTANCE = new BCSodiumInterface();
    @NotNull
    private static final Lazy shaderApi$delegate = LazyKt.lazy(BCSodiumInterface::shaderApi_delegate$lambda$0);

    private BCSodiumInterface() {
    }

    @NotNull
    public final ShaderApi getShaderApi$brokencore_common() {
        Lazy lazy = shaderApi$delegate;
        return (ShaderApi)lazy.getValue();
    }

    private final ShaderApi detectShaderApi() {
        ShaderApi shaderApi;
        try {
            Class.forName("net.caffeinemc.mods.sodium.client.gl.shader.ShaderParser$ParsedShader");
            shaderApi = ModernApi.INSTANCE;
        }
        catch (ClassNotFoundException classNotFoundException) {
            shaderApi = LegacyApi.INSTANCE;
        }
        return shaderApi;
    }

    private static final ShaderApi shaderApi_delegate$lambda$0() {
        return INSTANCE.detectShaderApi();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R2\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/brokencore/impl/compat/sodium/BCSodiumInterface$LegacyApi;", "Lnet/thebrokenscript/brokencore/impl/compat/sodium/BCSodiumInterface$ShaderApi;", "<init>", "()V", "glShaderCtor", "Ljava/lang/reflect/Constructor;", "Lnet/caffeinemc/mods/sodium/client/gl/shader/GlShader;", "kotlin.jvm.PlatformType", "load", "type", "Lnet/caffeinemc/mods/sodium/client/gl/shader/ShaderType;", "name", "Lnet/minecraft/resources/ResourceLocation;", "constants", "Lnet/caffeinemc/mods/sodium/client/gl/shader/ShaderConstants;", "brokencore-common"})
    private static final class LegacyApi
    implements ShaderApi {
        @NotNull
        public static final LegacyApi INSTANCE = new LegacyApi();
        private static final Constructor<GlShader> glShaderCtor;

        private LegacyApi() {
        }

        @Override
        @NotNull
        public GlShader load(@NotNull ShaderType type, @NotNull ResourceLocation name, @NotNull ShaderConstants constants) {
            Intrinsics.checkNotNullParameter((Object)type, (String)"type");
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)constants, (String)"constants");
            String src = BCShaderLoader.getShaderSource(name);
            String parsed = BCShaderParser.INSTANCE.parseShaderLegacy(src, constants);
            Object[] objectArray = new Object[]{type, name, parsed};
            GlShader glShader = glShaderCtor.newInstance(objectArray);
            Intrinsics.checkNotNullExpressionValue((Object)glShader, (String)"newInstance(...)");
            return glShader;
        }

        static {
            Class[] classArray = new Class[]{ShaderType.class, ResourceLocation.class, String.class};
            glShaderCtor = GlShader.class.getConstructor(classArray);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001e\u0010\u0004\u001a\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\t\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u000b0\u000b \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/brokencore/impl/compat/sodium/BCSodiumInterface$ModernApi;", "Lnet/thebrokenscript/brokencore/impl/compat/sodium/BCSodiumInterface$ShaderApi;", "<init>", "()V", "parsedShaderClass", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "parseMethod", "Ljava/lang/reflect/Method;", "glShaderCtor", "Ljava/lang/reflect/Constructor;", "Lnet/caffeinemc/mods/sodium/client/gl/shader/GlShader;", "load", "type", "Lnet/caffeinemc/mods/sodium/client/gl/shader/ShaderType;", "name", "Lnet/minecraft/resources/ResourceLocation;", "constants", "Lnet/caffeinemc/mods/sodium/client/gl/shader/ShaderConstants;", "brokencore-common"})
    private static final class ModernApi
    implements ShaderApi {
        @NotNull
        public static final ModernApi INSTANCE = new ModernApi();
        private static final Class<?> parsedShaderClass = Class.forName("net.caffeinemc.mods.sodium.client.gl.shader.ShaderParser$ParsedShader");
        private static final Method parseMethod;
        private static final Constructor<GlShader> glShaderCtor;

        private ModernApi() {
        }

        @Override
        @NotNull
        public GlShader load(@NotNull ShaderType type, @NotNull ResourceLocation name, @NotNull ShaderConstants constants) {
            Intrinsics.checkNotNullParameter((Object)type, (String)"type");
            Intrinsics.checkNotNullParameter((Object)name, (String)"name");
            Intrinsics.checkNotNullParameter((Object)constants, (String)"constants");
            String src = BCShaderLoader.getShaderSource(name);
            Object[] objectArray = new Object[]{src, constants};
            Object parsed = parseMethod.invoke(null, objectArray);
            Object[] objectArray2 = new Object[]{type, name, parsed};
            GlShader glShader = glShaderCtor.newInstance(objectArray2);
            Intrinsics.checkNotNullExpressionValue((Object)glShader, (String)"newInstance(...)");
            return glShader;
        }

        static {
            Class[] classArray = new Class[]{String.class, ShaderConstants.class};
            parseMethod = ShaderParser.class.getMethod("parseShader", classArray);
            classArray = new Class[]{ShaderType.class, ResourceLocation.class, parsedShaderClass};
            glShaderCtor = GlShader.class.getConstructor(classArray);
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u0082\u0001\u0002\n\u000b\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/brokencore/impl/compat/sodium/BCSodiumInterface$ShaderApi;", "", "load", "Lnet/caffeinemc/mods/sodium/client/gl/shader/GlShader;", "type", "Lnet/caffeinemc/mods/sodium/client/gl/shader/ShaderType;", "name", "Lnet/minecraft/resources/ResourceLocation;", "constants", "Lnet/caffeinemc/mods/sodium/client/gl/shader/ShaderConstants;", "Lnet/thebrokenscript/brokencore/impl/compat/sodium/BCSodiumInterface$LegacyApi;", "Lnet/thebrokenscript/brokencore/impl/compat/sodium/BCSodiumInterface$ModernApi;", "brokencore-common"})
    public static sealed interface ShaderApi
    permits LegacyApi, ModernApi {
        @NotNull
        public GlShader load(@NotNull ShaderType var1, @NotNull ResourceLocation var2, @NotNull ShaderConstants var3);
    }
}

