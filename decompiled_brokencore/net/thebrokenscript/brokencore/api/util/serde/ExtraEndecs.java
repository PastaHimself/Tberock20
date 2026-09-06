/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Function3
 *  com.mojang.datafixers.util.Function4
 *  com.mojang.serialization.Codec
 *  io.wispforest.endec.Endec
 *  io.wispforest.owo.serialization.CodecUtils
 *  io.wispforest.owo.serialization.endec.MinecraftEndecs
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KMutableProperty1
 *  net.minecraft.network.codec.StreamCodec
 *  net.minecraft.sounds.SoundEvent
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3d
 *  org.joml.Vector4f
 */
package net.thebrokenscript.brokencore.api.util.serde;

import com.mojang.datafixers.util.Function3;
import com.mojang.datafixers.util.Function4;
import com.mojang.serialization.Codec;
import io.wispforest.endec.Endec;
import io.wispforest.owo.serialization.CodecUtils;
import io.wispforest.owo.serialization.endec.MinecraftEndecs;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KMutableProperty1;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.sounds.SoundEvent;
import net.thebrokenscript.brokencore.api.util.serde.ExtraEndecs;
import net.thebrokenscript.brokencore.api.util.serde.WrappedBlockPosList;
import net.thebrokenscript.brokencore.api.util.serde.WrappedUUIDSet;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector4f;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u008c\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0005\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u00122\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00052\u001e\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00120\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001aH\u0002J\u00a6\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0005\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u00122\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00052$\u0010\u0017\u001a \u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00120\u001d2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001a2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00130\u001aH\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2={"Lnet/thebrokenscript/brokencore/api/util/serde/ExtraEndecs;", "", "<init>", "()V", "VECTOR3D", "Lio/wispforest/endec/Endec;", "Lorg/joml/Vector3d;", "VECTOR4F", "Lorg/joml/Vector4f;", "SOUND_EVENT", "Lnet/minecraft/sounds/SoundEvent;", "UUID_ENDEC", "Ljava/util/UUID;", "BLOCK_POS_LIST", "Lnet/thebrokenscript/brokencore/api/util/serde/WrappedBlockPosList;", "UUID_SET", "Lnet/thebrokenscript/brokencore/api/util/serde/WrappedUUIDSet;", "vectorEndec", "V", "C", "name", "", "componentEndec", "constructor", "Lcom/mojang/datafixers/util/Function3;", "xGetter", "Ljava/util/function/Function;", "yGetter", "zGetter", "Lcom/mojang/datafixers/util/Function4;", "wGetter", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nExtraEndecs.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExtraEndecs.kt\nnet/thebrokenscript/brokencore/api/util/serde/ExtraEndecs\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,76:1\n1#2:77\n*E\n"})
public final class ExtraEndecs {
    @NotNull
    public static final ExtraEndecs INSTANCE = new ExtraEndecs();
    @JvmField
    @NotNull
    public static final Endec<Vector3d> VECTOR3D;
    @JvmField
    @NotNull
    public static final Endec<Vector4f> VECTOR4F;
    @JvmField
    @NotNull
    public static final Endec<SoundEvent> SOUND_EVENT;
    @JvmField
    @NotNull
    public static final Endec<UUID> UUID_ENDEC;
    @JvmField
    @NotNull
    public static final Endec<WrappedBlockPosList> BLOCK_POS_LIST;
    @JvmField
    @NotNull
    public static final Endec<WrappedUUIDSet> UUID_SET;

    private ExtraEndecs() {
    }

    private final <C, V> Endec<V> vectorEndec(String name, Endec<C> componentEndec, Function3<C, C, C, V> constructor, Function<V, C> xGetter, Function<V, C> yGetter, Function<V, C> zGetter) {
        Endec endec2 = componentEndec.listOf().validate(arg_0 -> ExtraEndecs.vectorEndec$lambda$0(name, arg_0)).xmap(arg_0 -> ExtraEndecs.vectorEndec$lambda$1(constructor, arg_0), arg_0 -> ExtraEndecs.vectorEndec$lambda$2(xGetter, yGetter, zGetter, arg_0));
        Intrinsics.checkNotNullExpressionValue((Object)endec2, (String)"xmap(...)");
        return endec2;
    }

    private final <C, V> Endec<V> vectorEndec(String name, Endec<C> componentEndec, Function4<C, C, C, C, V> constructor, Function<V, C> xGetter, Function<V, C> yGetter, Function<V, C> zGetter, Function<V, C> wGetter) {
        Endec endec2 = componentEndec.listOf().validate(arg_0 -> ExtraEndecs.vectorEndec$lambda$3(name, arg_0)).xmap(arg_0 -> ExtraEndecs.vectorEndec$lambda$4(constructor, arg_0), arg_0 -> ExtraEndecs.vectorEndec$lambda$5(xGetter, yGetter, zGetter, wGetter, arg_0));
        Intrinsics.checkNotNullExpressionValue((Object)endec2, (String)"xmap(...)");
        return endec2;
    }

    private static final Double VECTOR3D$lambda$0(Vector3d it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.x();
    }

    private static final Double VECTOR3D$lambda$1(Vector3d it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.y();
    }

    private static final Double VECTOR3D$lambda$2(Vector3d it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return it.z();
    }

    private static final Float VECTOR4F$lambda$0(Vector4f it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Float.valueOf(it.x());
    }

    private static final Float VECTOR4F$lambda$1(Vector4f it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Float.valueOf(it.y());
    }

    private static final Float VECTOR4F$lambda$2(Vector4f it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Float.valueOf(it.z());
    }

    private static final Float VECTOR4F$lambda$3(Vector4f it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Float.valueOf(it.w());
    }

    private static final Set BLOCK_POS_LIST$lambda$0(Set it) {
        Intrinsics.checkNotNull((Object)it);
        return CollectionsKt.toMutableSet((Iterable)it);
    }

    private static final Set BLOCK_POS_LIST$lambda$1(Set it) {
        return it;
    }

    private static final Set BLOCK_POS_LIST$lambda$2(KMutableProperty1 $tmp0, WrappedBlockPosList p0) {
        return (Set)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final Set UUID_SET$lambda$0(Set it) {
        Intrinsics.checkNotNull((Object)it);
        return CollectionsKt.toMutableSet((Iterable)it);
    }

    private static final Set UUID_SET$lambda$1(Set it) {
        return it;
    }

    private static final Set UUID_SET$lambda$2(KMutableProperty1 $tmp0, WrappedUUIDSet p0) {
        return (Set)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final void vectorEndec$lambda$0(String $name, List it) {
        if (!(it.size() == 3)) {
            boolean bl = false;
            String string = $name + " array must have three elements";
            throw new IllegalStateException(string.toString());
        }
    }

    private static final Object vectorEndec$lambda$1(Function3 $constructor, List components) {
        return $constructor.apply(components.get(0), components.get(1), components.get(2));
    }

    private static final List vectorEndec$lambda$2(Function $xGetter, Function $yGetter, Function $zGetter, Object vector) {
        Object[] objectArray = new Object[]{$xGetter.apply(vector), $yGetter.apply(vector), $zGetter.apply(vector)};
        return CollectionsKt.listOf((Object[])objectArray);
    }

    private static final void vectorEndec$lambda$3(String $name, List it) {
        if (!(it.size() == 4)) {
            boolean bl = false;
            String string = $name + " array must have four elements";
            throw new IllegalStateException(string.toString());
        }
    }

    private static final Object vectorEndec$lambda$4(Function4 $constructor, List components) {
        return $constructor.apply(components.get(0), components.get(1), components.get(2), components.get(3));
    }

    private static final List vectorEndec$lambda$5(Function $xGetter, Function $yGetter, Function $zGetter, Function $wGetter, Object vector) {
        Object[] objectArray = new Object[]{$xGetter.apply(vector), $yGetter.apply(vector), $zGetter.apply(vector), $wGetter.apply(vector)};
        return CollectionsKt.listOf((Object[])objectArray);
    }

    static {
        Endec endec2 = Endec.DOUBLE;
        Intrinsics.checkNotNullExpressionValue((Object)endec2, (String)"DOUBLE");
        VECTOR3D = INSTANCE.vectorEndec("Vector3d", endec2, Vector3d::new, ExtraEndecs::VECTOR3D$lambda$0, ExtraEndecs::VECTOR3D$lambda$1, ExtraEndecs::VECTOR3D$lambda$2);
        Endec endec3 = Endec.FLOAT;
        Intrinsics.checkNotNullExpressionValue((Object)endec3, (String)"FLOAT");
        VECTOR4F = INSTANCE.vectorEndec("Vector4f", endec3, Vector4f::new, ExtraEndecs::VECTOR4F$lambda$0, ExtraEndecs::VECTOR4F$lambda$1, ExtraEndecs::VECTOR4F$lambda$2, ExtraEndecs::VECTOR4F$lambda$3);
        Endec endec4 = CodecUtils.toEndec((Codec)SoundEvent.DIRECT_CODEC, (StreamCodec)SoundEvent.DIRECT_STREAM_CODEC);
        Intrinsics.checkNotNullExpressionValue((Object)endec4, (String)"toEndec(...)");
        SOUND_EVENT = endec4;
        Endec endec5 = Endec.STRING.xmap(UUID::fromString, UUID::toString);
        Intrinsics.checkNotNullExpressionValue((Object)endec5, (String)"xmap(...)");
        UUID_ENDEC = endec5;
        Endec endec6 = MinecraftEndecs.BLOCK_POS.setOf().xmap(ExtraEndecs::BLOCK_POS_LIST$lambda$0, ExtraEndecs::BLOCK_POS_LIST$lambda$1).xmap(WrappedBlockPosList::new, arg_0 -> ExtraEndecs.BLOCK_POS_LIST$lambda$2((KMutableProperty1)BLOCK_POS_LIST.4.INSTANCE, arg_0));
        Intrinsics.checkNotNullExpressionValue((Object)endec6, (String)"xmap(...)");
        BLOCK_POS_LIST = endec6;
        Endec endec7 = UUID_ENDEC.setOf().xmap(ExtraEndecs::UUID_SET$lambda$0, ExtraEndecs::UUID_SET$lambda$1).xmap(WrappedUUIDSet::new, arg_0 -> ExtraEndecs.UUID_SET$lambda$2((KMutableProperty1)UUID_SET.4.INSTANCE, arg_0));
        Intrinsics.checkNotNullExpressionValue((Object)endec7, (String)"xmap(...)");
        UUID_SET = endec7;
    }
}

