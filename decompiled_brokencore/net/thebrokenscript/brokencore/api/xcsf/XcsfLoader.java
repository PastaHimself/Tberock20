/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.xcsf;

import io.netty.buffer.ByteBuf;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.thebrokenscript.brokencore.api.xcsf.XcsfStructure;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/brokencore/api/xcsf/XcsfLoader;", "", "<init>", "()V", "decode", "Lnet/thebrokenscript/brokencore/api/xcsf/XcsfStructure;", "buf", "Lio/netty/buffer/ByteBuf;", "MASK", "", "unpackPos", "Lnet/minecraft/core/BlockPos;", "value", "brokencore-common"})
public final class XcsfLoader {
    @NotNull
    public static final XcsfLoader INSTANCE = new XcsfLoader();
    public static final long MASK = 511L;

    private XcsfLoader() {
    }

    @JvmStatic
    @NotNull
    public static final XcsfStructure decode(@NotNull ByteBuf buf) {
        int it;
        Intrinsics.checkNotNullParameter((Object)buf, (String)"buf");
        long sizeX = buf.readUnsignedIntLE();
        long sizeY = buf.readUnsignedIntLE();
        long sizeZ = buf.readUnsignedIntLE();
        short idLen = buf.readUnsignedByte();
        int paletteLen = buf.readUnsignedByte();
        List modIds = new ArrayList();
        List palette = new ArrayList();
        int n = CollectionsKt.count((Iterable)((Iterable)RangesKt.until((int)0, (short)idLen)));
        int n2 = 0;
        while (n2 < n) {
            it = n2++;
            boolean bl = false;
            short len = buf.readUnsignedByte();
            String str = ((Object)buf.readCharSequence((int)len, Charset.defaultCharset())).toString();
            modIds.add(str);
        }
        n = CollectionsKt.count((Iterable)((Iterable)RangesKt.until((int)0, (short)paletteLen)));
        n2 = 0;
        while (n2 < n) {
            it = n2++;
            boolean bl = false;
            short idPos = buf.readUnsignedByte();
            short len = buf.readUnsignedByte();
            String str = ((Object)buf.readCharSequence((int)len, Charset.defaultCharset())).toString();
            String id = modIds.get(idPos) + ":" + str;
            palette.add(id);
        }
        Map finalWorld = new LinkedHashMap();
        int n3 = paletteLen;
        for (int idx = 0; idx < n3; ++idx) {
            String key = (String)palette.get(idx);
            List positions = new ArrayList();
            long len = buf.readUnsignedIntLE();
            int n4 = CollectionsKt.count((Iterable)((Iterable)RangesKt.until((int)0, (long)len)));
            block3: for (int i = 0; i < n4; ++i) {
                boolean flag;
                int it2 = i;
                boolean bl = false;
                boolean bl2 = flag = buf.readUnsignedByte() == 1;
                if (flag) {
                    long len2;
                    long l;
                    long start = buf.readUnsignedIntLE();
                    long it3 = start;
                    if (it3 > (l = start + (len2 = buf.readUnsignedIntLE()))) continue;
                    while (true) {
                        positions.add(INSTANCE.unpackPos(it3));
                        if (it3 == l) continue block3;
                        ++it3;
                    }
                }
                positions.add(INSTANCE.unpackPos(buf.readUnsignedIntLE()));
            }
            finalWorld.put(key, positions);
        }
        return new XcsfStructure(new Vec3i((int)sizeX, (int)sizeY, (int)sizeZ), finalWorld);
    }

    private final BlockPos unpackPos(long value) {
        long x = value >> 18 & 0x1FFL;
        long y = value >> 9 & 0x1FFL;
        long z = value & 0x1FFL;
        return new BlockPos((int)x, (int)y, (int)z);
    }
}

