/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonParser
 *  io.wispforest.endec.Deserializer
 *  io.wispforest.endec.Endec
 *  io.wispforest.endec.Serializer
 *  io.wispforest.endec.format.gson.GsonDeserializer
 *  io.wispforest.endec.format.gson.GsonSerializer
 *  io.wispforest.owo.serialization.format.nbt.NbtDeserializer
 *  io.wispforest.owo.serialization.format.nbt.NbtSerializer
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.nbt.Tag
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.ext;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.wispforest.endec.Deserializer;
import io.wispforest.endec.Endec;
import io.wispforest.endec.Serializer;
import io.wispforest.endec.format.gson.GsonDeserializer;
import io.wispforest.endec.format.gson.GsonSerializer;
import io.wispforest.owo.serialization.format.nbt.NbtDeserializer;
import io.wispforest.owo.serialization.format.nbt.NbtSerializer;
import java.util.function.Function;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.nbt.Tag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\n0\t2\u0006\u0010\u000b\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\fJE\u0010\r\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000f0\u000e2\u0006\u0010\u000b\u001a\u0002H\u0005\u00a2\u0006\u0002\u0010\u0010J=\u0010\u0011\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\n0\t2\u0006\u0010\u000b\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\fJC\u0010\u0012\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000f0\u000e2\u0006\u0010\u000b\u001a\u0002H\u0005\u00a2\u0006\u0002\u0010\u0010J%\u0010\u0013\u001a\u0004\u0018\u00010\u0014\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\u000b\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\u0015J%\u0010\u0016\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\u000b\u001a\u00020\u0014\u00a2\u0006\u0002\u0010\u0017J#\u0010\u0018\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\u000b\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\u0015J#\u0010\u0019\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\u000b\u001a\u00020\u0014\u00a2\u0006\u0002\u0010\u0017J%\u0010\u001a\u001a\u0004\u0018\u00010\u001b\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\u000b\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\u001cJ%\u0010\u001d\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\u000b\u001a\u00020\u001b\u00a2\u0006\u0002\u0010\u001eJ#\u0010\u001f\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\u000b\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\u001cJ#\u0010 \u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\u000b\u001a\u00020\u001b\u00a2\u0006\u0002\u0010\u001eJ%\u0010!\u001a\u0004\u0018\u00010\"\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\u000b\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010#J%\u0010$\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\u000b\u001a\u00020\"\u00a2\u0006\u0002\u0010%J#\u0010&\u001a\u00020\"\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\u000b\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010#J#\u0010'\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\u000b\u001a\u00020\"\u00a2\u0006\u0002\u0010%\u00a8\u0006("}, d2={"Lnet/thebrokenscript/brokencore/api/ext/EndecExt;", "", "<init>", "()V", "tryEncode", "T", "A", "Lio/wispforest/endec/Endec;", "ops", "Ljava/util/function/Supplier;", "Lio/wispforest/endec/Serializer;", "data", "(Lio/wispforest/endec/Endec;Ljava/util/function/Supplier;Ljava/lang/Object;)Ljava/lang/Object;", "tryDecode", "Ljava/util/function/Function;", "Lio/wispforest/endec/Deserializer;", "(Lio/wispforest/endec/Endec;Ljava/util/function/Function;Ljava/lang/Object;)Ljava/lang/Object;", "encodeOrThrow", "decodeOrThrow", "tryEncodeNbt", "Lnet/minecraft/nbt/Tag;", "(Lio/wispforest/endec/Endec;Ljava/lang/Object;)Lnet/minecraft/nbt/Tag;", "tryDecodeNbt", "(Lio/wispforest/endec/Endec;Lnet/minecraft/nbt/Tag;)Ljava/lang/Object;", "encodeNbtOrThrow", "decodeNbtOrThrow", "tryEncodeJson", "Lcom/google/gson/JsonElement;", "(Lio/wispforest/endec/Endec;Ljava/lang/Object;)Lcom/google/gson/JsonElement;", "tryDecodeJson", "(Lio/wispforest/endec/Endec;Lcom/google/gson/JsonElement;)Ljava/lang/Object;", "encodeJsonOrThrow", "decodeJsonOrThrow", "tryEncodeJsonString", "", "(Lio/wispforest/endec/Endec;Ljava/lang/Object;)Ljava/lang/String;", "tryDecodeJsonString", "(Lio/wispforest/endec/Endec;Ljava/lang/String;)Ljava/lang/Object;", "encodeJsonStringOrThrow", "decodeJsonStringOrThrow", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nEndecExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EndecExt.kt\nnet/thebrokenscript/brokencore/api/ext/EndecExt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,50:1\n1#2:51\n*E\n"})
public final class EndecExt {
    @NotNull
    public static final EndecExt INSTANCE = new EndecExt();

    private EndecExt() {
    }

    @Nullable
    public final <T, A> T tryEncode(@NotNull Endec<A> $this$tryEncode, @NotNull Supplier<Serializer<T>> ops, A data2) {
        Object object;
        Intrinsics.checkNotNullParameter($this$tryEncode, (String)"<this>");
        Intrinsics.checkNotNullParameter(ops, (String)"ops");
        try {
            object = $this$tryEncode.encodeFully(ops, data2);
        }
        catch (Exception exception) {
            object = null;
        }
        return (T)object;
    }

    @Nullable
    public final <T, A> A tryDecode(@NotNull Endec<A> $this$tryDecode, @NotNull Function<T, Deserializer<T>> ops, T data2) {
        Object object;
        Intrinsics.checkNotNullParameter($this$tryDecode, (String)"<this>");
        Intrinsics.checkNotNullParameter(ops, (String)"ops");
        try {
            object = $this$tryDecode.decodeFully(ops, data2);
        }
        catch (Exception exception) {
            object = null;
        }
        return (A)object;
    }

    public final <T, A> T encodeOrThrow(@NotNull Endec<A> $this$encodeOrThrow, @NotNull Supplier<Serializer<T>> ops, A data2) {
        Intrinsics.checkNotNullParameter($this$encodeOrThrow, (String)"<this>");
        Intrinsics.checkNotNullParameter(ops, (String)"ops");
        return (T)$this$encodeOrThrow.encodeFully(ops, data2);
    }

    public final <T, A> A decodeOrThrow(@NotNull Endec<A> $this$decodeOrThrow, @NotNull Function<T, Deserializer<T>> ops, T data2) {
        Intrinsics.checkNotNullParameter($this$decodeOrThrow, (String)"<this>");
        Intrinsics.checkNotNullParameter(ops, (String)"ops");
        return (A)$this$decodeOrThrow.decodeFully(ops, data2);
    }

    @Nullable
    public final <A> Tag tryEncodeNbt(@NotNull Endec<A> $this$tryEncodeNbt, A data2) {
        Intrinsics.checkNotNullParameter($this$tryEncodeNbt, (String)"<this>");
        return (Tag)this.tryEncode($this$tryEncodeNbt, NbtSerializer::of, data2);
    }

    @Nullable
    public final <A> A tryDecodeNbt(@NotNull Endec<A> $this$tryDecodeNbt, @NotNull Tag data2) {
        Intrinsics.checkNotNullParameter($this$tryDecodeNbt, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        return this.tryDecode($this$tryDecodeNbt, NbtDeserializer::of, data2);
    }

    @NotNull
    public final <A> Tag encodeNbtOrThrow(@NotNull Endec<A> $this$encodeNbtOrThrow, A data2) {
        Intrinsics.checkNotNullParameter($this$encodeNbtOrThrow, (String)"<this>");
        Object t = this.encodeOrThrow($this$encodeNbtOrThrow, NbtSerializer::of, data2);
        Intrinsics.checkNotNullExpressionValue(t, (String)"encodeOrThrow(...)");
        return (Tag)t;
    }

    public final <A> A decodeNbtOrThrow(@NotNull Endec<A> $this$decodeNbtOrThrow, @NotNull Tag data2) {
        Intrinsics.checkNotNullParameter($this$decodeNbtOrThrow, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        return this.decodeOrThrow($this$decodeNbtOrThrow, NbtDeserializer::of, data2);
    }

    @Nullable
    public final <A> JsonElement tryEncodeJson(@NotNull Endec<A> $this$tryEncodeJson, A data2) {
        Intrinsics.checkNotNullParameter($this$tryEncodeJson, (String)"<this>");
        return (JsonElement)this.tryEncode($this$tryEncodeJson, GsonSerializer::of, data2);
    }

    @Nullable
    public final <A> A tryDecodeJson(@NotNull Endec<A> $this$tryDecodeJson, @NotNull JsonElement data2) {
        Intrinsics.checkNotNullParameter($this$tryDecodeJson, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        return this.tryDecode($this$tryDecodeJson, GsonDeserializer::of, data2);
    }

    @NotNull
    public final <A> JsonElement encodeJsonOrThrow(@NotNull Endec<A> $this$encodeJsonOrThrow, A data2) {
        Intrinsics.checkNotNullParameter($this$encodeJsonOrThrow, (String)"<this>");
        Object t = this.encodeOrThrow($this$encodeJsonOrThrow, GsonSerializer::of, data2);
        Intrinsics.checkNotNullExpressionValue(t, (String)"encodeOrThrow(...)");
        return (JsonElement)t;
    }

    public final <A> A decodeJsonOrThrow(@NotNull Endec<A> $this$decodeJsonOrThrow, @NotNull JsonElement data2) {
        Intrinsics.checkNotNullParameter($this$decodeJsonOrThrow, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        return this.decodeOrThrow($this$decodeJsonOrThrow, GsonDeserializer::of, data2);
    }

    @Nullable
    public final <A> String tryEncodeJsonString(@NotNull Endec<A> $this$tryEncodeJsonString, A data2) {
        String string;
        Intrinsics.checkNotNullParameter($this$tryEncodeJsonString, (String)"<this>");
        JsonElement jsonElement = this.tryEncodeJson($this$tryEncodeJsonString, data2);
        if (jsonElement != null) {
            JsonElement jsonElement2 = jsonElement;
            Gson gson = new Gson();
            JsonElement p0 = jsonElement2;
            boolean bl = false;
            string = gson.toJson(p0);
        } else {
            string = null;
        }
        return string;
    }

    @Nullable
    public final <A> A tryDecodeJsonString(@NotNull Endec<A> $this$tryDecodeJsonString, @NotNull String data2) {
        Intrinsics.checkNotNullParameter($this$tryDecodeJsonString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        JsonElement jsonElement = JsonParser.parseString((String)data2);
        Intrinsics.checkNotNullExpressionValue((Object)jsonElement, (String)"parseString(...)");
        return this.tryDecodeJson($this$tryDecodeJsonString, jsonElement);
    }

    @NotNull
    public final <A> String encodeJsonStringOrThrow(@NotNull Endec<A> $this$encodeJsonStringOrThrow, A data2) {
        Intrinsics.checkNotNullParameter($this$encodeJsonStringOrThrow, (String)"<this>");
        String string = new Gson().toJson(this.encodeJsonOrThrow($this$encodeJsonStringOrThrow, data2));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toJson(...)");
        return string;
    }

    public final <A> A decodeJsonStringOrThrow(@NotNull Endec<A> $this$decodeJsonStringOrThrow, @NotNull String data2) {
        Intrinsics.checkNotNullParameter($this$decodeJsonStringOrThrow, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        JsonElement jsonElement = JsonParser.parseString((String)data2);
        Intrinsics.checkNotNullExpressionValue((Object)jsonElement, (String)"parseString(...)");
        return this.decodeJsonOrThrow($this$decodeJsonStringOrThrow, jsonElement);
    }
}

