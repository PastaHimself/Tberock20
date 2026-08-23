/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.irisshaders.iris.gl.blending.BlendModeOverride
 *  net.irisshaders.iris.shaderpack.programs.ProgramSet
 *  net.irisshaders.iris.shaderpack.programs.ProgramSource
 *  net.irisshaders.iris.shaderpack.properties.ShaderProperties
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.impl.compat.iris;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.irisshaders.iris.gl.blending.BlendModeOverride;
import net.irisshaders.iris.shaderpack.programs.ProgramSet;
import net.irisshaders.iris.shaderpack.programs.ProgramSource;
import net.irisshaders.iris.shaderpack.properties.ShaderProperties;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.impl.compat.sodium.BCShaderLoader;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/impl/compat/iris/ProgramSourceGetter;", "", "<init>", "()V", "get", "Lnet/irisshaders/iris/shaderpack/programs/ProgramSource;", "shader", "Lnet/minecraft/resources/ResourceLocation;", "parent", "Lnet/irisshaders/iris/shaderpack/programs/ProgramSet;", "brokencore-common"})
public final class ProgramSourceGetter {
    @NotNull
    public static final ProgramSourceGetter INSTANCE = new ProgramSourceGetter();

    private ProgramSourceGetter() {
    }

    @JvmStatic
    @NotNull
    public static final ProgramSource get(@NotNull ResourceLocation shader, @NotNull ProgramSet parent) {
        Intrinsics.checkNotNullParameter((Object)shader, (String)"shader");
        Intrinsics.checkNotNullParameter((Object)parent, (String)"parent");
        String string = shader.toString();
        ResourceLocation resourceLocation = shader.withSuffix(".vsh");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"withSuffix(...)");
        String string2 = BCShaderLoader.patchIris(BCShaderLoader.getShader(resourceLocation));
        ResourceLocation resourceLocation2 = shader.withSuffix(".fsh");
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation2, (String)"withSuffix(...)");
        return new ProgramSource(string, string2, null, null, null, BCShaderLoader.patchIris(BCShaderLoader.getShader(resourceLocation2)), parent, ShaderProperties.empty(), BlendModeOverride.OFF);
    }
}

