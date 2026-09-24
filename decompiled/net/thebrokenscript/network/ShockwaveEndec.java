/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Deserializer
 *  io.wispforest.endec.Endec
 *  io.wispforest.endec.SerializationContext
 *  io.wispforest.endec.Serializer
 *  kotlin.Metadata
 *  kotlin.Triple
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntRange
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.util.ByteUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.network;

import io.wispforest.endec.Deserializer;
import io.wispforest.endec.Endec;
import io.wispforest.endec.SerializationContext;
import io.wispforest.endec.Serializer;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.util.ByteUtil;
import net.thebrokenscript.entity.fractured.attacks.JimShockwaveType;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c2\u0002\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J6\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0016J.\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0016\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/network/ShockwaveEndec;", "Lio/wispforest/endec/Endec;", "Lkotlin/Triple;", "Lnet/minecraft/world/phys/Vec3;", "", "Lnet/thebrokenscript/entity/fractured/attacks/JimShockwaveType;", "<init>", "()V", "encode", "", "ctx", "Lio/wispforest/endec/SerializationContext;", "serializer", "Lio/wispforest/endec/Serializer;", "value", "decode", "deserializer", "Lio/wispforest/endec/Deserializer;", "thebrokenscript-common"})
final class ShockwaveEndec
implements Endec<Triple<? extends Vec3, ? extends Float, ? extends JimShockwaveType>> {
    @NotNull
    public static final ShockwaveEndec INSTANCE = new ShockwaveEndec();

    private ShockwaveEndec() {
    }

    public void encode(@NotNull SerializationContext ctx, @NotNull Serializer<?> serializer2, @NotNull Triple<? extends Vec3, Float, ? extends JimShockwaveType> value) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        Intrinsics.checkNotNullParameter(serializer2, (String)"serializer");
        Intrinsics.checkNotNullParameter(value, (String)"value");
        serializer2.writeBytes(ctx, ArraysKt.plus((byte[])ArraysKt.plus((byte[])ByteUtil.INSTANCE.vec3ToBytes((Vec3)value.getFirst()), (byte[])ByteUtil.INSTANCE.floatToBytes(((Number)value.getSecond()).floatValue())), (byte)((byte)((JimShockwaveType)((Object)value.getThird())).ordinal())));
    }

    @NotNull
    public Triple<Vec3, Float, JimShockwaveType> decode(@NotNull SerializationContext ctx, @NotNull Deserializer<?> deserializer) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        Intrinsics.checkNotNullParameter(deserializer, (String)"deserializer");
        byte[] bytes = deserializer.readBytes(ctx);
        Intrinsics.checkNotNull((Object)bytes);
        Vec3 pos = ByteUtil.INSTANCE.bytesToVec3(ArraysKt.sliceArray((byte[])bytes, (IntRange)new IntRange(0, 23)));
        float radius = ByteUtil.INSTANCE.bytesToFloat(ArraysKt.sliceArray((byte[])bytes, (IntRange)new IntRange(24, 27)));
        byte type = ArraysKt.last((byte[])bytes);
        return new Triple((Object)pos, (Object)Float.valueOf(radius), JimShockwaveType.getEntries().get((int)type));
    }
}

