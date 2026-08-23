/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.io.TextStreamsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.Charsets
 *  kotlin.text.StringsKt
 *  kotlinx.serialization.DeserializationStrategy
 *  kotlinx.serialization.json.Json
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.command.dev;

import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.command.dev.GameProfileResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/command/dev/UserAPI;", "", "<init>", "()V", "lookupUuidInternal", "Ljava/util/UUID;", "name", "", "lookupUuid", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nUserAPI.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UserAPI.kt\nnet/thebrokenscript/command/dev/UserAPI\n+ 2 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,32:1\n222#2:33\n*S KotlinDebug\n*F\n+ 1 UserAPI.kt\nnet/thebrokenscript/command/dev/UserAPI\n*L\n11#1:33\n*E\n"})
public final class UserAPI {
    @NotNull
    public static final UserAPI INSTANCE = new UserAPI();

    private UserAPI() {
    }

    /*
     * WARNING - void declaration
     */
    private final UUID lookupUuidInternal(String name) {
        void this_$iv;
        URL uRL = new URI("https://api.mojang.com/minecraft/profile/lookup/name/" + name).toURL();
        Intrinsics.checkNotNullExpressionValue((Object)uRL, (String)"toURL(...)");
        URL uRL2 = uRL;
        Charset charset = Charsets.UTF_8;
        byte[] byArray = TextStreamsKt.readBytes((URL)uRL2);
        String text = new String(byArray, charset);
        charset = (Json)Json.Default;
        String string$iv = text;
        boolean $i$f$decodeFromString = false;
        this_$iv.getSerializersModule();
        GameProfileResponse data = (GameProfileResponse)this_$iv.decodeFromString((DeserializationStrategy)GameProfileResponse.Companion.serializer(), string$iv);
        String first = StringsKt.take((String)data.getId(), (int)8);
        String string = data.getId().substring(8, 12);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"substring(...)");
        String second = string;
        String string2 = data.getId().substring(12, 16);
        Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"substring(...)");
        String third = string2;
        String string3 = data.getId().substring(16, 20);
        Intrinsics.checkNotNullExpressionValue((Object)string3, (String)"substring(...)");
        String fourth = string3;
        String string4 = data.getId().substring(20, 32);
        Intrinsics.checkNotNullExpressionValue((Object)string4, (String)"substring(...)");
        String fifth = string4;
        String str = first + "-" + second + "-" + third + "-" + fourth + "-" + fifth;
        UUID uUID = UUID.fromString(str);
        Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"fromString(...)");
        return uUID;
    }

    @Nullable
    public final UUID lookupUuid(@NotNull String name) {
        UUID uUID;
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        try {
            uUID = this.lookupUuidInternal(name);
        }
        catch (Exception ex) {
            TheBrokenScript.LOGGER.error("Failed to lookup user info for '" + name + "'!", (Throwable)ex);
            uUID = null;
        }
        return uUID;
    }
}

