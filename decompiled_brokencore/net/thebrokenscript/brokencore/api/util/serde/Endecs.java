/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  io.wispforest.endec.Endec
 *  io.wispforest.owo.serialization.CodecUtils
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.Registry
 *  net.minecraft.network.codec.StreamCodec
 *  net.minecraft.resources.ResourceKey
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util.serde;

import com.mojang.serialization.Codec;
import io.wispforest.endec.Endec;
import io.wispforest.owo.serialization.CodecUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.Registry;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.thebrokenscript.brokencore.api.util.serde.PairEndec;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0000\u0010\u0006\"\u0004\b\u0001\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\tJ,\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\f0\t\"\u0004\b\u0000\u0010\r2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u000f0\f\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/util/serde/Endecs;", "", "<init>", "()V", "pair", "Lnet/thebrokenscript/brokencore/api/util/serde/PairEndec;", "L", "R", "left", "Lio/wispforest/endec/Endec;", "right", "resourceKey", "Lnet/minecraft/resources/ResourceKey;", "T", "registryKey", "Lnet/minecraft/core/Registry;", "brokencore-common"})
public final class Endecs {
    @NotNull
    public static final Endecs INSTANCE = new Endecs();

    private Endecs() {
    }

    @NotNull
    public final <L, R> PairEndec<L, R> pair(@NotNull Endec<L> left, @NotNull Endec<R> right) {
        Intrinsics.checkNotNullParameter(left, (String)"left");
        Intrinsics.checkNotNullParameter(right, (String)"right");
        return new PairEndec<L, R>(left, right);
    }

    @NotNull
    public final <T> Endec<ResourceKey<T>> resourceKey(@NotNull ResourceKey<Registry<T>> registryKey) {
        Intrinsics.checkNotNullParameter(registryKey, (String)"registryKey");
        Endec endec2 = CodecUtils.toEndec((Codec)ResourceKey.codec(registryKey), (StreamCodec)ResourceKey.streamCodec(registryKey));
        Intrinsics.checkNotNullExpressionValue((Object)endec2, (String)"toEndec(...)");
        return endec2;
    }
}

