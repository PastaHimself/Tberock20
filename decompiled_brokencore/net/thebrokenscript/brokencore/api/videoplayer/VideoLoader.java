/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  kotlin.Metadata
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 *  net.minecraft.client.Minecraft
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package net.thebrokenscript.brokencore.api.videoplayer;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.api.videoplayer.VideoDefinition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/videoplayer/VideoLoader;", "", "<init>", "()V", "LOGGER", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "load", "Lnet/thebrokenscript/brokencore/api/videoplayer/VideoDefinition;", "location", "Lnet/minecraft/resources/ResourceLocation;", "brokencore-common"})
public final class VideoLoader {
    @NotNull
    public static final VideoLoader INSTANCE = new VideoLoader();
    private static final Logger LOGGER = LoggerFactory.getLogger((String)"BrokenCore/video");

    private VideoLoader() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @JvmStatic
    @Nullable
    public static final VideoDefinition load(@NotNull ResourceLocation location) {
        Object object;
        Intrinsics.checkNotNullParameter((Object)location, (String)"location");
        ResourceLocation jsonLoc = ResourceLocation.fromNamespaceAndPath((String)location.getNamespace(), (String)("video/" + location.getPath() + ".json"));
        try {
            JsonObject jsonObject;
            object = Minecraft.getInstance().getResourceManager().open(jsonLoc);
            Throwable throwable = null;
            try {
                JsonObject jsonObject2;
                InputStream stream = (InputStream)object;
                boolean bl = false;
                Intrinsics.checkNotNull((Object)stream);
                InputStream inputStream = stream;
                Charset charset = Charsets.UTF_8;
                if (JsonParser.parseReader((Reader)new InputStreamReader(inputStream, charset)).getAsJsonObject() == null) {
                    VideoLoader $this$load_u24lambda_u240_u240 = INSTANCE;
                    boolean bl2 = false;
                    LOGGER.error("[BrokenCore] Cutscene JSON is not an object: {}", (Object)jsonLoc);
                    VideoDefinition videoDefinition = null;
                    return videoDefinition;
                }
                jsonObject = jsonObject2;
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
            finally {
                CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
            }
            object = jsonObject;
        }
        catch (Exception e) {
            LOGGER.error("[BrokenCore] Failed to open cutscene JSON: {}", (Object)jsonLoc, (Object)e);
            return null;
        }
        Closeable json = object;
        try {
            Object codec;
            Object object2 = json.get("codec");
            if (object2 == null || (object2 = object2.getAsString()) == null) {
                object2 = codec = "h264";
            }
            if (!VideoDefinition.Companion.getSUPPORTED_CODECS().contains(codec)) {
                Object[] e = new Object[]{codec, jsonLoc, VideoDefinition.Companion.getSUPPORTED_CODECS()};
                LOGGER.error("[BrokenCore] Unsupported codec '{}' in cutscene {}. Supported: {}", e);
                return null;
            }
            ResourceLocation resourceLocation = ResourceLocation.parse((String)json.get("video").getAsString());
            Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"parse(...)");
            JsonElement jsonElement = json.get("skippable");
            JsonElement jsonElement2 = json.get("fade_in_ms");
            JsonElement jsonElement3 = json.get("fade_out_ms");
            JsonElement jsonElement4 = json.get("audio");
            object = new VideoDefinition(resourceLocation, (String)codec, json.get("fps").getAsDouble(), json.get("duration_ms").getAsLong(), jsonElement != null ? jsonElement.getAsBoolean() : false, jsonElement2 != null ? jsonElement2.getAsLong() : 0L, jsonElement3 != null ? jsonElement3.getAsLong() : 0L, jsonElement4 != null ? jsonElement4.getAsBoolean() : false);
        }
        catch (Exception e) {
            LOGGER.error("[BrokenCore] Failed to parse cutscene JSON: {}", (Object)jsonLoc, (Object)e);
            object = null;
        }
        return object;
    }
}

