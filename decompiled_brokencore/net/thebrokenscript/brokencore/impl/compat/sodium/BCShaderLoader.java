/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.optionals.OptionalsKt
 *  kotlin.text.StringsKt
 *  net.caffeinemc.mods.sodium.client.gl.shader.GlShader
 *  net.caffeinemc.mods.sodium.client.gl.shader.ShaderConstants
 *  net.caffeinemc.mods.sodium.client.gl.shader.ShaderType
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.packs.resources.Resource
 *  org.apache.commons.io.IOUtils
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.compat.sodium;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.optionals.OptionalsKt;
import kotlin.text.StringsKt;
import net.caffeinemc.mods.sodium.client.gl.shader.GlShader;
import net.caffeinemc.mods.sodium.client.gl.shader.ShaderConstants;
import net.caffeinemc.mods.sodium.client.gl.shader.ShaderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.impl.compat.sodium.BCShaderParser;
import net.thebrokenscript.brokencore.impl.compat.sodium.BCSodiumInterface;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0007\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/brokencore/impl/compat/sodium/BCShaderLoader;", "", "<init>", "()V", "loadShader", "Lnet/caffeinemc/mods/sodium/client/gl/shader/GlShader;", "type", "Lnet/caffeinemc/mods/sodium/client/gl/shader/ShaderType;", "name", "Lnet/minecraft/resources/ResourceLocation;", "constants", "Lnet/caffeinemc/mods/sodium/client/gl/shader/ShaderConstants;", "getShader", "", "getShaderSource", "patchIris", "source", "brokencore-common"})
public final class BCShaderLoader {
    @NotNull
    public static final BCShaderLoader INSTANCE = new BCShaderLoader();

    private BCShaderLoader() {
    }

    @JvmStatic
    @NotNull
    public static final GlShader loadShader(@NotNull ShaderType type, @NotNull ResourceLocation name, @NotNull ShaderConstants constants) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter((Object)constants, (String)"constants");
        return BCSodiumInterface.INSTANCE.getShaderApi$brokencore_common().load(type, name, constants);
    }

    @JvmStatic
    @NotNull
    public static final String getShader(@NotNull ResourceLocation name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        return BCShaderParser.INSTANCE.parseShaderLegacy(BCShaderLoader.getShaderSource(name), null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @JvmStatic
    @NotNull
    public static final String getShaderSource(@NotNull ResourceLocation name) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Optional optional = ClientDSLKt.getMC().getResourceManager().getResource(name.withPrefix("shaders/"));
        Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"getResource(...)");
        Resource resource = (Resource)OptionalsKt.getOrNull((Optional)optional);
        if (!(resource != null)) {
            boolean $i$a$-require-BCShaderLoader$getShaderSource$22 = false;
            String $i$a$-require-BCShaderLoader$getShaderSource$22 = "Shader not found: " + name;
            throw new IllegalArgumentException($i$a$-require-BCShaderLoader$getShaderSource$22.toString());
        }
        try {
            Closeable closeable = resource.open();
            Throwable $i$a$-require-BCShaderLoader$getShaderSource$22 = null;
            try {
                InputStream it = (InputStream)closeable;
                boolean bl = false;
                if (it == null) {
                    throw new RuntimeException("Shader not found: " + name);
                }
                String string = IOUtils.toString((InputStream)it, (Charset)StandardCharsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
                String string2 = string;
                return string2;
            }
            catch (Throwable throwable) {
                $i$a$-require-BCShaderLoader$getShaderSource$22 = throwable;
                throw throwable;
            }
            finally {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)$i$a$-require-BCShaderLoader$getShaderSource$22);
            }
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to read shader source for " + name, e);
        }
    }

    @JvmStatic
    @NotNull
    public static final String patchIris(@NotNull String source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return StringsKt.replace$default((String)StringsKt.replace$default((String)source, (String)"u_ProjectionMatrix", (String)"iris_ProjectionMatrix", (boolean)false, (int)4, null), (String)"u_ModelViewMatrix", (String)"iris_ModelViewMatrix", (boolean)false, (int)4, null);
    }
}

