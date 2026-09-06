/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.caffeinemc.mods.sodium.client.gl.shader.ShaderConstants
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.impl.compat.sodium;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.caffeinemc.mods.sodium.client.gl.shader.ShaderConstants;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.impl.compat.sodium.BCShaderLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/impl/compat/sodium/BCShaderParser;", "", "<init>", "()V", "IMPORT_PATTERN", "Ljava/util/regex/Pattern;", "parseShaderLegacy", "", "src", "constants", "Lnet/caffeinemc/mods/sodium/client/gl/shader/ShaderConstants;", "", "resolveImport", "line", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBCShaderParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BCShaderParser.kt\nnet/thebrokenscript/brokencore/impl/compat/sodium/BCShaderParser\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,49:1\n1#2:50\n*E\n"})
public final class BCShaderParser {
    @NotNull
    public static final BCShaderParser INSTANCE = new BCShaderParser();
    @NotNull
    private static final Pattern IMPORT_PATTERN;

    private BCShaderParser() {
    }

    @NotNull
    public final String parseShaderLegacy(@NotNull String src, @Nullable ShaderConstants constants) {
        Intrinsics.checkNotNullParameter((Object)src, (String)"src");
        List<String> lines = this.parseShaderLegacy(src);
        if (constants != null) {
            List list = constants.getDefineStrings();
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getDefineStrings(...)");
            lines.addAll(1, list);
        }
        return CollectionsKt.joinToString$default((Iterable)lines, (CharSequence)"\n", null, null, (int)0, null, null, (int)62, null);
    }

    @NotNull
    public final List<String> parseShaderLegacy(@NotNull String src) {
        Intrinsics.checkNotNullParameter((Object)src, (String)"src");
        List builder = new ArrayList();
        try {
            for (String line : StringsKt.lines((CharSequence)src)) {
                boolean bl = StringsKt.startsWith$default((String)line, (String)"#import", (boolean)false, (int)2, null) ? builder.addAll((Collection)this.resolveImport(line)) : builder.add(line);
            }
            return builder;
        }
        catch (IOException e) {
            throw new RuntimeException("Failed to read shader sources", e);
        }
    }

    private final List<String> resolveImport(String line) {
        Matcher matcher = IMPORT_PATTERN.matcher(line);
        if (!matcher.matches()) {
            boolean $i$a$-require-BCShaderParser$resolveImport$22 = false;
            String $i$a$-require-BCShaderParser$resolveImport$22 = "Malformed import statement (expected format: " + IMPORT_PATTERN + ")";
            throw new IllegalArgumentException($i$a$-require-BCShaderParser$resolveImport$22.toString());
        }
        String namespace = matcher.group("namespace");
        String path = matcher.group("path");
        ResourceLocation name = ResourceLocation.fromNamespaceAndPath((String)namespace, (String)path);
        Intrinsics.checkNotNull((Object)name);
        String source = BCShaderLoader.getShaderSource(name);
        return this.parseShaderLegacy(source);
    }

    static {
        Pattern pattern = Pattern.compile("#import <(?<namespace>.*):(?<path>.*)>");
        Intrinsics.checkNotNullExpressionValue((Object)pattern, (String)"compile(...)");
        IMPORT_PATTERN = pattern;
    }
}

