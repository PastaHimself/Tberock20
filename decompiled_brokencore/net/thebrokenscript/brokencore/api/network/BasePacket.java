/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.network.codec.StreamCodec
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload$Type
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.network;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.network.PacketHandlerContext;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J\r\u0010\u000e\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0013H&\u00a2\u0006\u0002\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u001aH&\u00a2\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00028\u00000\u001dH\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/brokencore/api/network/BasePacket;", "P", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload;", "<init>", "()V", "id", "Lnet/minecraft/resources/ResourceLocation;", "getId", "()Lnet/minecraft/resources/ResourceLocation;", "packetType", "Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "getPacketType", "()Lnet/minecraft/network/protocol/common/custom/CustomPacketPayload$Type;", "type", "factory", "()Lnet/thebrokenscript/brokencore/api/network/BasePacket;", "write", "", "buf", "Lnet/minecraft/network/FriendlyByteBuf;", "packet", "(Lnet/minecraft/network/FriendlyByteBuf;Lnet/thebrokenscript/brokencore/api/network/BasePacket;)V", "read", "(Lnet/minecraft/network/FriendlyByteBuf;)Lnet/thebrokenscript/brokencore/api/network/BasePacket;", "handle", "cx", "Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;", "(Lnet/thebrokenscript/brokencore/api/network/BasePacket;Lnet/thebrokenscript/brokencore/api/network/PacketHandlerContext;)V", "streamCodec", "Lnet/minecraft/network/codec/StreamCodec;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBasePacket.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BasePacket.kt\nnet/thebrokenscript/brokencore/api/network/BasePacket\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,29:1\n12970#2,2:30\n*S KotlinDebug\n*F\n+ 1 BasePacket.kt\nnet/thebrokenscript/brokencore/api/network/BasePacket\n*L\n18#1:30,2\n*E\n"})
public abstract class BasePacket<P extends BasePacket<P>>
implements CustomPacketPayload {
    @NotNull
    public abstract ResourceLocation getId();

    @NotNull
    protected final CustomPacketPayload.Type<P> getPacketType() {
        return new CustomPacketPayload.Type(this.getId());
    }

    @NotNull
    public CustomPacketPayload.Type<P> type() {
        return this.getPacketType();
    }

    @NotNull
    public P factory() {
        boolean bl;
        Class<?> clazz;
        block2: {
            Class<?> clazz2 = this.getClass();
            Intrinsics.checkNotNull(clazz2, (String)"null cannot be cast to non-null type java.lang.Class<P of net.thebrokenscript.brokencore.api.network.BasePacket>");
            clazz = clazz2;
            Constructor<?>[] constructorArray = clazz.getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructorArray, (String)"getConstructors(...)");
            Object[] $this$any$iv = constructorArray;
            boolean $i$f$any = false;
            for (Object element$iv : $this$any$iv) {
                Constructor it = (Constructor)element$iv;
                boolean bl2 = false;
                Parameter[] parameterArray = it.getParameters();
                Intrinsics.checkNotNullExpressionValue((Object)parameterArray, (String)"getParameters(...)");
                boolean bl3 = ((Object[])parameterArray).length == 0;
                if (!bl3) continue;
                bl = true;
                break block2;
            }
            bl = false;
        }
        if (!bl) {
            throw new IllegalArgumentException("Could not find zero-argument constructor for packet class " + clazz.getSimpleName() + "!");
        }
        Object obj = clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
        Intrinsics.checkNotNull(obj, (String)"null cannot be cast to non-null type P of net.thebrokenscript.brokencore.api.network.BasePacket");
        return (P)((BasePacket)obj);
    }

    public abstract void write(@NotNull FriendlyByteBuf var1, @NotNull P var2);

    @NotNull
    public abstract P read(@NotNull FriendlyByteBuf var1);

    public abstract void handle(@NotNull P var1, @NotNull PacketHandlerContext var2);

    @NotNull
    public StreamCodec<FriendlyByteBuf, P> streamCodec() {
        StreamCodec streamCodec = StreamCodec.of(this::write, this::read);
        Intrinsics.checkNotNullExpressionValue((Object)streamCodec, (String)"of(...)");
        return streamCodec;
    }
}

