/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  com.mojang.serialization.Decoder
 *  com.mojang.serialization.DynamicOps
 *  com.mojang.serialization.Encoder
 *  com.mojang.serialization.MapDecoder
 *  com.mojang.serialization.MapEncoder
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.nbt.NbtOps
 *  net.minecraft.nbt.Tag
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.ext;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Decoder;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Encoder;
import com.mojang.serialization.MapDecoder;
import com.mojang.serialization.MapEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t2\u0006\u0010\n\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\u000bJ9\u0010\f\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t2\u0006\u0010\n\u001a\u0002H\u0005\u00a2\u0006\u0002\u0010\u000eJ9\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t2\u0006\u0010\n\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\u0010J9\u0010\f\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t2\u0006\u0010\n\u001a\u0002H\u0005\u00a2\u0006\u0002\u0010\u0012J7\u0010\u0013\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t2\u0006\u0010\n\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\u000bJ7\u0010\u0014\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t2\u0006\u0010\n\u001a\u0002H\u0005\u00a2\u0006\u0002\u0010\u000eJ7\u0010\u0013\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t2\u0006\u0010\n\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\u0010J7\u0010\u0014\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00112\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t2\u0006\u0010\n\u001a\u0002H\u0005\u00a2\u0006\u0002\u0010\u0012J%\u0010\u0015\u001a\u0004\u0018\u00010\u0016\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\n\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\u0017J%\u0010\u0018\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\r2\u0006\u0010\n\u001a\u00020\u0016\u00a2\u0006\u0002\u0010\u0019J%\u0010\u0015\u001a\u0004\u0018\u00010\u0016\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u000f2\u0006\u0010\n\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\u001aJ%\u0010\u0018\u001a\u0004\u0018\u0001H\u0006\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00112\u0006\u0010\n\u001a\u00020\u0016\u00a2\u0006\u0002\u0010\u001bJ#\u0010\u001c\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\n\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\u0017J#\u0010\u001d\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\r2\u0006\u0010\n\u001a\u00020\u0016\u00a2\u0006\u0002\u0010\u0019J#\u0010\u001c\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u000f2\u0006\u0010\n\u001a\u0002H\u0006\u00a2\u0006\u0002\u0010\u001aJ#\u0010\u001d\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00112\u0006\u0010\n\u001a\u00020\u0016\u00a2\u0006\u0002\u0010\u001b\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/brokencore/api/ext/CodecExt;", "", "<init>", "()V", "tryEncode", "T", "A", "Lcom/mojang/serialization/Encoder;", "ops", "Lcom/mojang/serialization/DynamicOps;", "data", "(Lcom/mojang/serialization/Encoder;Lcom/mojang/serialization/DynamicOps;Ljava/lang/Object;)Ljava/lang/Object;", "tryDecode", "Lcom/mojang/serialization/Decoder;", "(Lcom/mojang/serialization/Decoder;Lcom/mojang/serialization/DynamicOps;Ljava/lang/Object;)Ljava/lang/Object;", "Lcom/mojang/serialization/MapEncoder;", "(Lcom/mojang/serialization/MapEncoder;Lcom/mojang/serialization/DynamicOps;Ljava/lang/Object;)Ljava/lang/Object;", "Lcom/mojang/serialization/MapDecoder;", "(Lcom/mojang/serialization/MapDecoder;Lcom/mojang/serialization/DynamicOps;Ljava/lang/Object;)Ljava/lang/Object;", "encodeOrThrow", "decodeOrThrow", "tryEncodeNbt", "Lnet/minecraft/nbt/Tag;", "(Lcom/mojang/serialization/Encoder;Ljava/lang/Object;)Lnet/minecraft/nbt/Tag;", "tryDecodeNbt", "(Lcom/mojang/serialization/Decoder;Lnet/minecraft/nbt/Tag;)Ljava/lang/Object;", "(Lcom/mojang/serialization/MapEncoder;Ljava/lang/Object;)Lnet/minecraft/nbt/Tag;", "(Lcom/mojang/serialization/MapDecoder;Lnet/minecraft/nbt/Tag;)Ljava/lang/Object;", "encodeNbtOrThrow", "decodeNbtOrThrow", "brokencore-common"})
public final class CodecExt {
    @NotNull
    public static final CodecExt INSTANCE = new CodecExt();

    private CodecExt() {
    }

    @Nullable
    public final <T, A> T tryEncode(@NotNull Encoder<A> $this$tryEncode, @NotNull DynamicOps<T> ops, A data2) {
        Intrinsics.checkNotNullParameter($this$tryEncode, (String)"<this>");
        Intrinsics.checkNotNullParameter(ops, (String)"ops");
        return $this$tryEncode.encodeStart(ops, data2).result().orElse(null);
    }

    @Nullable
    public final <T, A> A tryDecode(@NotNull Decoder<A> $this$tryDecode, @NotNull DynamicOps<T> ops, T data2) {
        Intrinsics.checkNotNullParameter($this$tryDecode, (String)"<this>");
        Intrinsics.checkNotNullParameter(ops, (String)"ops");
        Pair pair = $this$tryDecode.decode(ops, data2).result().orElse(null);
        return (A)(pair != null ? pair.getFirst() : null);
    }

    @Nullable
    public final <T, A> T tryEncode(@NotNull MapEncoder<A> $this$tryEncode, @NotNull DynamicOps<T> ops, A data2) {
        Intrinsics.checkNotNullParameter($this$tryEncode, (String)"<this>");
        Intrinsics.checkNotNullParameter(ops, (String)"ops");
        Encoder encoder = $this$tryEncode.encoder();
        Intrinsics.checkNotNullExpressionValue((Object)encoder, (String)"encoder(...)");
        return this.tryEncode(encoder, ops, data2);
    }

    @Nullable
    public final <T, A> A tryDecode(@NotNull MapDecoder<A> $this$tryDecode, @NotNull DynamicOps<T> ops, T data2) {
        Intrinsics.checkNotNullParameter($this$tryDecode, (String)"<this>");
        Intrinsics.checkNotNullParameter(ops, (String)"ops");
        Decoder decoder = $this$tryDecode.decoder();
        Intrinsics.checkNotNullExpressionValue((Object)decoder, (String)"decoder(...)");
        return this.tryDecode(decoder, ops, data2);
    }

    public final <T, A> T encodeOrThrow(@NotNull Encoder<A> $this$encodeOrThrow, @NotNull DynamicOps<T> ops, A data2) {
        Intrinsics.checkNotNullParameter($this$encodeOrThrow, (String)"<this>");
        Intrinsics.checkNotNullParameter(ops, (String)"ops");
        return (T)$this$encodeOrThrow.encodeStart(ops, data2).getOrThrow();
    }

    public final <T, A> A decodeOrThrow(@NotNull Decoder<A> $this$decodeOrThrow, @NotNull DynamicOps<T> ops, T data2) {
        Intrinsics.checkNotNullParameter($this$decodeOrThrow, (String)"<this>");
        Intrinsics.checkNotNullParameter(ops, (String)"ops");
        return (A)((Pair)$this$decodeOrThrow.decode(ops, data2).getOrThrow()).getFirst();
    }

    public final <T, A> T encodeOrThrow(@NotNull MapEncoder<A> $this$encodeOrThrow, @NotNull DynamicOps<T> ops, A data2) {
        Intrinsics.checkNotNullParameter($this$encodeOrThrow, (String)"<this>");
        Intrinsics.checkNotNullParameter(ops, (String)"ops");
        Encoder encoder = $this$encodeOrThrow.encoder();
        Intrinsics.checkNotNullExpressionValue((Object)encoder, (String)"encoder(...)");
        return this.encodeOrThrow(encoder, ops, data2);
    }

    public final <T, A> A decodeOrThrow(@NotNull MapDecoder<A> $this$decodeOrThrow, @NotNull DynamicOps<T> ops, T data2) {
        Intrinsics.checkNotNullParameter($this$decodeOrThrow, (String)"<this>");
        Intrinsics.checkNotNullParameter(ops, (String)"ops");
        Decoder decoder = $this$decodeOrThrow.decoder();
        Intrinsics.checkNotNullExpressionValue((Object)decoder, (String)"decoder(...)");
        return this.decodeOrThrow(decoder, ops, data2);
    }

    @Nullable
    public final <A> Tag tryEncodeNbt(@NotNull Encoder<A> $this$tryEncodeNbt, A data2) {
        Intrinsics.checkNotNullParameter($this$tryEncodeNbt, (String)"<this>");
        NbtOps nbtOps = NbtOps.INSTANCE;
        Intrinsics.checkNotNullExpressionValue((Object)nbtOps, (String)"INSTANCE");
        return (Tag)this.tryEncode($this$tryEncodeNbt, (DynamicOps)nbtOps, data2);
    }

    @Nullable
    public final <A> A tryDecodeNbt(@NotNull Decoder<A> $this$tryDecodeNbt, @NotNull Tag data2) {
        Intrinsics.checkNotNullParameter($this$tryDecodeNbt, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        NbtOps nbtOps = NbtOps.INSTANCE;
        Intrinsics.checkNotNullExpressionValue((Object)nbtOps, (String)"INSTANCE");
        return this.tryDecode($this$tryDecodeNbt, (DynamicOps)nbtOps, data2);
    }

    @Nullable
    public final <A> Tag tryEncodeNbt(@NotNull MapEncoder<A> $this$tryEncodeNbt, A data2) {
        Intrinsics.checkNotNullParameter($this$tryEncodeNbt, (String)"<this>");
        NbtOps nbtOps = NbtOps.INSTANCE;
        Intrinsics.checkNotNullExpressionValue((Object)nbtOps, (String)"INSTANCE");
        return (Tag)this.tryEncode($this$tryEncodeNbt, (DynamicOps)nbtOps, data2);
    }

    @Nullable
    public final <A> A tryDecodeNbt(@NotNull MapDecoder<A> $this$tryDecodeNbt, @NotNull Tag data2) {
        Intrinsics.checkNotNullParameter($this$tryDecodeNbt, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        NbtOps nbtOps = NbtOps.INSTANCE;
        Intrinsics.checkNotNullExpressionValue((Object)nbtOps, (String)"INSTANCE");
        return this.tryDecode($this$tryDecodeNbt, (DynamicOps)nbtOps, data2);
    }

    @NotNull
    public final <A> Tag encodeNbtOrThrow(@NotNull Encoder<A> $this$encodeNbtOrThrow, A data2) {
        Intrinsics.checkNotNullParameter($this$encodeNbtOrThrow, (String)"<this>");
        NbtOps nbtOps = NbtOps.INSTANCE;
        Intrinsics.checkNotNullExpressionValue((Object)nbtOps, (String)"INSTANCE");
        Object t = this.encodeOrThrow($this$encodeNbtOrThrow, (DynamicOps)nbtOps, data2);
        Intrinsics.checkNotNullExpressionValue(t, (String)"encodeOrThrow(...)");
        return (Tag)t;
    }

    public final <A> A decodeNbtOrThrow(@NotNull Decoder<A> $this$decodeNbtOrThrow, @NotNull Tag data2) {
        Intrinsics.checkNotNullParameter($this$decodeNbtOrThrow, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        NbtOps nbtOps = NbtOps.INSTANCE;
        Intrinsics.checkNotNullExpressionValue((Object)nbtOps, (String)"INSTANCE");
        return this.decodeOrThrow($this$decodeNbtOrThrow, (DynamicOps)nbtOps, data2);
    }

    @NotNull
    public final <A> Tag encodeNbtOrThrow(@NotNull MapEncoder<A> $this$encodeNbtOrThrow, A data2) {
        Intrinsics.checkNotNullParameter($this$encodeNbtOrThrow, (String)"<this>");
        NbtOps nbtOps = NbtOps.INSTANCE;
        Intrinsics.checkNotNullExpressionValue((Object)nbtOps, (String)"INSTANCE");
        Object t = this.encodeOrThrow($this$encodeNbtOrThrow, (DynamicOps)nbtOps, data2);
        Intrinsics.checkNotNullExpressionValue(t, (String)"encodeOrThrow(...)");
        return (Tag)t;
    }

    public final <A> A decodeNbtOrThrow(@NotNull MapDecoder<A> $this$decodeNbtOrThrow, @NotNull Tag data2) {
        Intrinsics.checkNotNullParameter($this$decodeNbtOrThrow, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)data2, (String)"data");
        NbtOps nbtOps = NbtOps.INSTANCE;
        Intrinsics.checkNotNullExpressionValue((Object)nbtOps, (String)"INSTANCE");
        return this.decodeOrThrow($this$decodeNbtOrThrow, (DynamicOps)nbtOps, data2);
    }
}

