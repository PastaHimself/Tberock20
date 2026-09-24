/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001e\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/brokencore/api/util/ByteUtil;", "", "<init>", "()V", "floatToBytes", "", "f", "", "bytesToFloat", "bytes", "doubleToBytes", "d", "", "bytesToDouble", "longToBytes", "i", "", "bytesToLong", "intToBytes", "", "bytesToInt", "blockPosToBytes", "pos", "Lnet/minecraft/core/BlockPos;", "bytesToBlockPos", "bytesToVec3i", "Lnet/minecraft/core/Vec3i;", "vec3iToBytes", "vec3d", "bytesToVec3", "Lnet/minecraft/world/phys/Vec3;", "vec3ToBytes", "brokencore-common"})
public final class ByteUtil {
    @NotNull
    public static final ByteUtil INSTANCE = new ByteUtil();

    private ByteUtil() {
    }

    @NotNull
    public final byte[] floatToBytes(float f) {
        return this.intToBytes(Float.floatToIntBits(f));
    }

    public final float bytesToFloat(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter((Object)bytes, (String)"bytes");
        return Float.intBitsToFloat(this.bytesToInt(bytes));
    }

    @NotNull
    public final byte[] doubleToBytes(double d) {
        return this.longToBytes(Double.doubleToLongBits(d));
    }

    public final double bytesToDouble(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter((Object)bytes, (String)"bytes");
        return Double.longBitsToDouble(this.bytesToLong(bytes));
    }

    @NotNull
    public final byte[] longToBytes(long i) {
        byte[] array = new byte[8];
        for (int j = 0; j < 8; ++j) {
            array[j] = (byte)(i << j * 8 >>> 56);
        }
        return array;
    }

    public final long bytesToLong(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter((Object)bytes, (String)"bytes");
        long aLong = 0L;
        int n = bytes.length;
        for (int i = 0; i < n; ++i) {
            byte aByte = bytes[i];
            for (int bit = 0; bit < 8; ++bit) {
                aLong |= ((long)aByte & 1L << bit) >> bit << (7 - i) * 8 + bit;
            }
        }
        return aLong;
    }

    @NotNull
    public final byte[] intToBytes(int i) {
        byte[] array = new byte[4];
        for (int j = 0; j < 4; ++j) {
            array[j] = (byte)(i << j * 8 >> 24);
        }
        return array;
    }

    public final int bytesToInt(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter((Object)bytes, (String)"bytes");
        int anInt = 0;
        int n = bytes.length;
        for (int i = 0; i < n; ++i) {
            byte aByte = bytes[i];
            for (int bit = 0; bit < 8; ++bit) {
                anInt |= (aByte & 1 << bit) >> bit << (3 - i) * 8 + bit;
            }
        }
        return anInt;
    }

    @NotNull
    public final byte[] blockPosToBytes(@NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return this.vec3iToBytes((Vec3i)pos);
    }

    @NotNull
    public final BlockPos bytesToBlockPos(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter((Object)bytes, (String)"bytes");
        return new BlockPos(this.bytesToVec3i(bytes));
    }

    @NotNull
    public final Vec3i bytesToVec3i(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter((Object)bytes, (String)"bytes");
        byte[] x = new byte[4];
        byte[] y = new byte[4];
        byte[] z = new byte[4];
        System.arraycopy(bytes, 0, x, 0, 4);
        System.arraycopy(bytes, 4, y, 0, 4);
        System.arraycopy(bytes, 8, z, 0, 4);
        return new Vec3i(this.bytesToInt(x), this.bytesToInt(y), this.bytesToInt(z));
    }

    @NotNull
    public final byte[] vec3iToBytes(@NotNull Vec3i vec3d) {
        Intrinsics.checkNotNullParameter((Object)vec3d, (String)"vec3d");
        byte[] x = this.doubleToBytes(vec3d.getX());
        byte[] y = this.doubleToBytes(vec3d.getY());
        byte[] z = this.doubleToBytes(vec3d.getZ());
        byte[] all = new byte[12];
        System.arraycopy(x, 0, all, 0, 4);
        System.arraycopy(y, 0, all, 4, 4);
        System.arraycopy(z, 0, all, 8, 4);
        return all;
    }

    @NotNull
    public final Vec3 bytesToVec3(@NotNull byte[] bytes) {
        Intrinsics.checkNotNullParameter((Object)bytes, (String)"bytes");
        byte[] x = new byte[8];
        byte[] y = new byte[8];
        byte[] z = new byte[8];
        System.arraycopy(bytes, 0, x, 0, 8);
        System.arraycopy(bytes, 8, y, 0, 8);
        System.arraycopy(bytes, 16, z, 0, 8);
        return new Vec3(this.bytesToDouble(x), this.bytesToDouble(y), this.bytesToDouble(z));
    }

    @NotNull
    public final byte[] vec3ToBytes(@NotNull Vec3 vec3d) {
        Intrinsics.checkNotNullParameter((Object)vec3d, (String)"vec3d");
        byte[] x = this.doubleToBytes(vec3d.x);
        byte[] y = this.doubleToBytes(vec3d.y);
        byte[] z = this.doubleToBytes(vec3d.z);
        byte[] all = new byte[24];
        System.arraycopy(x, 0, all, 0, 8);
        System.arraycopy(y, 0, all, 8, 8);
        System.arraycopy(z, 0, all, 16, 8);
        return all;
    }
}

