/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.io.TextStreamsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Charsets
 *  kotlinx.serialization.DeserializationStrategy
 *  kotlinx.serialization.json.Json
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.api.anim;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.anim.AnimJson;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/api/anim/AnimLoader;", "", "<init>", "()V", "cache", "", "Lnet/minecraft/resources/ResourceLocation;", "Lnet/thebrokenscript/api/anim/AnimJson;", "loadAnimJson", "id", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nAnimLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimLoader.kt\nnet/thebrokenscript/api/anim/AnimLoader\n+ 2 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,23:1\n222#2:24\n*S KotlinDebug\n*F\n+ 1 AnimLoader.kt\nnet/thebrokenscript/api/anim/AnimLoader\n*L\n17#1:24\n*E\n"})
public final class AnimLoader {
    @NotNull
    public static final AnimLoader INSTANCE = new AnimLoader();
    @NotNull
    private static final Map<ResourceLocation, AnimJson> cache = new LinkedHashMap();

    private AnimLoader() {
    }

    /*
     * WARNING - void declaration
     */
    @Nullable
    public final AnimJson loadAnimJson(@NotNull ResourceLocation id) {
        void this_$iv;
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        if (cache.containsKey(id)) {
            return cache.get(id);
        }
        URL uRL = AnimLoader.class.getResource("/assets/" + id.getNamespace() + "/animations/" + id.getPath() + ".animation.json");
        if (uRL == null) {
            return null;
        }
        URL uRL2 = uRL;
        Charset charset = Charsets.UTF_8;
        byte[] byArray = TextStreamsKt.readBytes((URL)uRL2);
        String data = new String(byArray, charset);
        Json json = (Json)Json.Default;
        String string$iv = data;
        boolean $i$f$decodeFromString = false;
        this_$iv.getSerializersModule();
        AnimJson parsed = (AnimJson)this_$iv.decodeFromString((DeserializationStrategy)AnimJson.Companion.serializer(), string$iv);
        cache.put(id, parsed);
        return parsed;
    }
}

