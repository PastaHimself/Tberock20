/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Result
 *  kotlin.ResultKt
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.FilesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0006"}, d2={"getRandomCachedPlayer", "Lkotlin/Pair;", "Ljava/util/UUID;", "", "server", "Lnet/minecraft/server/MinecraftServer;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\ngetRandomCachedPlayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 getRandomCachedPlayer.kt\nnet/thebrokenscript/util/GetRandomCachedPlayerKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,19:1\n1#2:20\n*E\n"})
public final class GetRandomCachedPlayerKt {
    @Nullable
    public static final Pair<UUID, String> getRandomCachedPlayer(@NotNull MinecraftServer server) {
        Object object;
        Object $i$a$-runCatching-GetRandomCachedPlayerKt$getRandomCachedPlayer$obj$22;
        Object $i$a$-runCatching-GetRandomCachedPlayerKt$getRandomCachedPlayer$json$22;
        Intrinsics.checkNotNullParameter((Object)server, (String)"server");
        File file = server.getServerDirectory().resolve("usernamecache.json").toFile();
        if (!file.exists()) {
            return null;
        }
        try {
            boolean $i$a$-runCatching-GetRandomCachedPlayerKt$getRandomCachedPlayer$json$22 = false;
            Intrinsics.checkNotNull((Object)file);
            $i$a$-runCatching-GetRandomCachedPlayerKt$getRandomCachedPlayer$json$22 = Result.constructor-impl((Object)FilesKt.readText$default((File)file, null, (int)1, null));
        }
        catch (Throwable throwable) {
            $i$a$-runCatching-GetRandomCachedPlayerKt$getRandomCachedPlayer$json$22 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        String string = (String)(Result.isFailure-impl((Object)$i$a$-runCatching-GetRandomCachedPlayerKt$getRandomCachedPlayer$json$22) ? null : $i$a$-runCatching-GetRandomCachedPlayerKt$getRandomCachedPlayer$json$22);
        if (string == null) {
            return null;
        }
        String json = string;
        try {
            boolean $i$a$-runCatching-GetRandomCachedPlayerKt$getRandomCachedPlayer$obj$22 = false;
            $i$a$-runCatching-GetRandomCachedPlayerKt$getRandomCachedPlayer$obj$22 = Result.constructor-impl((Object)JsonParser.parseString((String)json).getAsJsonObject());
        }
        catch (Throwable throwable) {
            $i$a$-runCatching-GetRandomCachedPlayerKt$getRandomCachedPlayer$obj$22 = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        JsonObject jsonObject = (JsonObject)(Result.isFailure-impl((Object)$i$a$-runCatching-GetRandomCachedPlayerKt$getRandomCachedPlayer$obj$22) ? null : $i$a$-runCatching-GetRandomCachedPlayerKt$getRandomCachedPlayer$obj$22);
        if (jsonObject == null) {
            return null;
        }
        JsonObject obj = jsonObject;
        if (obj.size() == 0) {
            return null;
        }
        Set set = obj.entrySet();
        Intrinsics.checkNotNullExpressionValue((Object)set, (String)"entrySet(...)");
        Map.Entry entry = (Map.Entry)CollectionsKt.random((Collection)set, (Random)((Random)Random.Default));
        try {
            boolean bl = false;
            object = Result.constructor-impl((Object)UUID.fromString((String)entry.getKey()));
        }
        catch (Throwable throwable) {
            object = Result.constructor-impl((Object)ResultKt.createFailure((Throwable)throwable));
        }
        UUID uUID = (UUID)(Result.isFailure-impl((Object)object) ? null : object);
        if (uUID == null) {
            return null;
        }
        UUID uuid = uUID;
        String name = ((JsonElement)entry.getValue()).getAsString();
        return TuplesKt.to((Object)uuid, (Object)name);
    }
}

