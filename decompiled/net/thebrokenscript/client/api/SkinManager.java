/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  kotlin.Metadata
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.texture.AbstractTexture
 *  net.minecraft.client.renderer.texture.HttpTexture
 *  net.minecraft.resources.ResourceLocation
 *  org.apache.commons.codec.binary.Base64
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.client.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.HttpTexture;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.api.TBSConstants;
import org.apache.commons.codec.binary.Base64;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0006J \u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\tH\u0002J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/client/api/SkinManager;", "", "<init>", "()V", "SKIN_CACHE", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lnet/minecraft/resources/ResourceLocation;", "SLIM_MODEL_CACHE", "", "SKIN_URL_CACHE", "DEFAULT_SKIN", "getSkin", "uuid", "usesSlimArms", "loadSkin", "", "registerTextureOnMainThread", "skinUrl", "isSlim", "preloadSkin", "thebrokenscript-common"})
public final class SkinManager {
    @NotNull
    public static final SkinManager INSTANCE = new SkinManager();
    @NotNull
    private static final ConcurrentHashMap<String, ResourceLocation> SKIN_CACHE = new ConcurrentHashMap();
    @NotNull
    private static final ConcurrentHashMap<String, Boolean> SLIM_MODEL_CACHE = new ConcurrentHashMap();
    @NotNull
    private static final ConcurrentHashMap<String, String> SKIN_URL_CACHE = new ConcurrentHashMap();
    @NotNull
    private static final ResourceLocation DEFAULT_SKIN = TBSConstants.id("textures/skins/null.png");

    private SkinManager() {
    }

    @NotNull
    public final ResourceLocation getSkin(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        ResourceLocation resourceLocation = SKIN_CACHE.getOrDefault(uuid, DEFAULT_SKIN);
        Intrinsics.checkNotNullExpressionValue((Object)resourceLocation, (String)"getOrDefault(...)");
        return resourceLocation;
    }

    public final boolean usesSlimArms(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        Boolean bl = SLIM_MODEL_CACHE.getOrDefault(uuid, false);
        Intrinsics.checkNotNullExpressionValue((Object)bl, (String)"getOrDefault(...)");
        return bl;
    }

    public final void loadSkin(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        if (SKIN_CACHE.containsKey(uuid) || SKIN_URL_CACHE.containsKey(uuid)) {
            return;
        }
        ((Map)SKIN_CACHE).put(uuid, DEFAULT_SKIN);
        new Thread(() -> SkinManager.loadSkin$lambda$0(uuid)).start();
    }

    private final void registerTextureOnMainThread(String uuid, String skinUrl, boolean isSlim) {
        try {
            File cacheDir = new File(Minecraft.getInstance().gameDirectory, "cache/tbs/cached_skins");
            if (!cacheDir.exists() && !cacheDir.mkdirs()) {
                return;
            }
            File cacheFile = new File(cacheDir, uuid + ".png");
            ResourceLocation textureLoc = TBSConstants.id("dynamic_skin_" + uuid);
            HttpTexture httpTexture = new HttpTexture(cacheFile, skinUrl, ResourceLocation.withDefaultNamespace((String)"textures/misc/unknown_pack.png"), true, null);
            Minecraft.getInstance().getTextureManager().register(textureLoc, (AbstractTexture)httpTexture);
            ((Map)SKIN_CACHE).put(uuid, textureLoc);
            SKIN_URL_CACHE.remove(uuid);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public final void preloadSkin(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        this.loadSkin(uuid);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static final void loadSkin$lambda$0(String $uuid) {
        try {
            JsonObject metadata;
            Object reader;
            URL profileUrl = URI.create("https://sessionserver.mojang.com/session/minecraft/profile/" + StringsKt.replace$default((String)$uuid, (String)"-", (String)"", (boolean)false, (int)4, null)).toURL();
            Closeable closeable = new BufferedReader(new InputStreamReader(profileUrl.openStream()));
            Throwable throwable = null;
            try {
                reader = (BufferedReader)closeable;
                boolean bl = false;
                reader = JsonParser.parseReader((Reader)((Reader)reader)).getAsJsonObject();
            }
            catch (Throwable bl) {
                throwable = bl;
                throw bl;
            }
            finally {
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
            }
            BufferedReader profile = reader;
            String textureDataBase64 = profile.getAsJsonArray("properties").get(0).getAsJsonObject().get("value").getAsString();
            byte[] byArray = Base64.decodeBase64((String)textureDataBase64);
            Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"decodeBase64(...)");
            reader = byArray;
            String textureDataJson = new String((byte[])reader, Charsets.UTF_8);
            JsonObject textureData = JsonParser.parseString((String)textureDataJson).getAsJsonObject();
            JsonObject skinTextureObj = textureData.getAsJsonObject("textures").getAsJsonObject("SKIN");
            String skinUrl = skinTextureObj.get("url").getAsString();
            boolean isSlim = skinTextureObj.has("metadata") ? (metadata = skinTextureObj.getAsJsonObject("metadata")).has("model") && Intrinsics.areEqual((Object)metadata.get("model").getAsString(), (Object)"slim") : false;
            ((Map)SKIN_URL_CACHE).put($uuid, skinUrl);
            ((Map)SLIM_MODEL_CACHE).put($uuid, isSlim);
            Minecraft.getInstance().execute(() -> SkinManager.loadSkin$lambda$0$1($uuid, skinUrl, isSlim));
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static final void loadSkin$lambda$0$1(String $uuid, String $skinUrl, boolean $isSlim) {
        Intrinsics.checkNotNull((Object)$skinUrl);
        INSTANCE.registerTextureOnMainThread($uuid, $skinUrl, $isSlim);
    }
}

