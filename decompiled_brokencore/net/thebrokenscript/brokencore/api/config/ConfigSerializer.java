/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.electronwill.nightconfig.core.UnmodifiableConfig
 *  io.netty.buffer.Unpooled
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.SpreadBuilder
 *  net.minecraft.network.FriendlyByteBuf
 *  net.minecraft.network.codec.StreamEncoder
 *  net.neoforged.neoforge.common.ModConfigSpec
 *  net.neoforged.neoforge.common.ModConfigSpec$ConfigValue
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.config;

import com.electronwill.nightconfig.core.UnmodifiableConfig;
import io.netty.buffer.Unpooled;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.SpreadBuilder;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamEncoder;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.thebrokenscript.brokencore.api.config.Config;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0001H\u0002J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0001H\u0002J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u0005J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0015H\u0002J:\u0010\u0016\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00152\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u00020\u00100\u0018H\u0002JS\u0010\u001a\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00152\u001c\u0010\u0017\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u00020\u00100\u00182\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u001c\"\u00020\u0007H\u0002\u00a2\u0006\u0002\u0010\u001d\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/brokencore/api/config/ConfigSerializer;", "", "<init>", "()V", "serialize", "Lnet/minecraft/network/FriendlyByteBuf;", "id", "", "conf", "Lnet/thebrokenscript/brokencore/api/config/Config$Base;", "typeTag", "", "data", "autoRead", "buf", "autoWrite", "", "deserialize", "cfg", "Lnet/neoforged/neoforge/common/ModConfigSpec;", "map", "", "forEachValue", "cb", "Lkotlin/Function2;", "Lnet/neoforged/neoforge/common/ModConfigSpec$ConfigValue;", "forEachValueInner", "path", "", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;[Ljava/lang/String;)V", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nConfigSerializer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ConfigSerializer.kt\nnet/thebrokenscript/brokencore/api/config/ConfigSerializer\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,117:1\n216#2,2:118\n*S KotlinDebug\n*F\n+ 1 ConfigSerializer.kt\nnet/thebrokenscript/brokencore/api/config/ConfigSerializer\n*L\n101#1:118,2\n*E\n"})
public final class ConfigSerializer {
    @NotNull
    public static final ConfigSerializer INSTANCE = new ConfigSerializer();

    private ConfigSerializer() {
    }

    @NotNull
    public final FriendlyByteBuf serialize(@NotNull String id, @NotNull Config.Base conf) {
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)conf, (String)"conf");
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        Map map = new LinkedHashMap();
        ModConfigSpec cfg = conf.getSpecification();
        buf.writeUtf(id);
        buf.writeEnum((Enum)conf.getType());
        Map map2 = cfg.getValues().valueMap();
        Intrinsics.checkNotNullExpressionValue((Object)map2, (String)"valueMap(...)");
        this.forEachValue(map2, (arg_0, arg_1) -> ConfigSerializer.serialize$lambda$0(map, buf, arg_0, arg_1));
        return buf;
    }

    private final int typeTag(Object data2) {
        int n;
        Object object = data2;
        if (object instanceof Boolean) {
            n = 0;
        } else if (object instanceof Integer) {
            n = 1;
        } else if (object instanceof Float) {
            n = 2;
        } else if (object instanceof String) {
            n = 3;
        } else if (object instanceof Double) {
            n = 4;
        } else if (object instanceof Long) {
            n = 5;
        } else if (object instanceof Short) {
            n = 6;
        } else if (object instanceof Byte) {
            n = 7;
        } else if (object instanceof Enum) {
            n = 8;
        } else if (object instanceof Character) {
            n = 9;
        } else if (object instanceof List) {
            n = 10;
        } else if (object instanceof Map) {
            n = 11;
        } else if (object instanceof byte[]) {
            n = 12;
        } else {
            throw new IllegalStateException(("Unknown config value type: " + data2).toString());
        }
        return n;
    }

    private final Object autoRead(FriendlyByteBuf buf) {
        byte tag = buf.readByte();
        Serializable serializable = switch (tag) {
            case 0 -> Boolean.valueOf(buf.readBoolean());
            case 1 -> Integer.valueOf(buf.readInt());
            case 2 -> Float.valueOf(buf.readFloat());
            case 3 -> (Serializable)((Object)buf.readUtf());
            case 4 -> Double.valueOf(buf.readDouble());
            case 5 -> Long.valueOf(buf.readLong());
            case 6 -> Integer.valueOf(buf.readShort());
            case 7 -> Integer.valueOf(buf.readByte());
            case 8 -> {
                Class<?> v1 = Class.forName(buf.readUtf());
                Intrinsics.checkNotNull(v1, (String)"null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
                yield (Serializable)((Object)buf.readEnum(v1));
            }
            case 9 -> Character.valueOf(buf.readChar());
            case 10 -> (Serializable)((Object)buf.readCollection(ArrayList::new, arg_0 -> ConfigSerializer.autoRead$lambda$0((Function1)new Function1<FriendlyByteBuf, Object>((Object)this){

                public final Object invoke(FriendlyByteBuf p0) {
                    Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                    return ConfigSerializer.access$autoRead((ConfigSerializer)this.receiver, p0);
                }
            }, arg_0)));
            case 11 -> (Serializable)((Object)buf.readMap(HashMap::new, arg_0 -> ConfigSerializer.autoRead$lambda$1((Function1)new Function1<FriendlyByteBuf, Object>((Object)this){

                public final Object invoke(FriendlyByteBuf p0) {
                    Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                    return ConfigSerializer.access$autoRead((ConfigSerializer)this.receiver, p0);
                }
            }, arg_0), arg_0 -> ConfigSerializer.autoRead$lambda$2((Function1)new Function1<FriendlyByteBuf, Object>((Object)this){

                public final Object invoke(FriendlyByteBuf p0) {
                    Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                    return ConfigSerializer.access$autoRead((ConfigSerializer)this.receiver, p0);
                }
            }, arg_0)));
            case 12 -> (Serializable)buf.readByteArray();
            default -> throw new IllegalStateException(("Unknown config value type tag: " + tag).toString());
        };
        Intrinsics.checkNotNull((Object)serializable);
        return serializable;
    }

    private final void autoWrite(FriendlyByteBuf buf, Object data2) {
        buf.writeByte(this.typeTag(data2));
        Object object = data2;
        if (object instanceof Boolean) {
            v0 = buf.writeBoolean(((Boolean)data2).booleanValue());
        } else if (object instanceof Integer) {
            v0 = buf.writeInt(((Number)data2).intValue());
        } else if (object instanceof Float) {
            v0 = buf.writeFloat(((Number)data2).floatValue());
        } else if (object instanceof String) {
            v0 = buf.writeUtf((String)data2);
        } else if (object instanceof Double) {
            v0 = buf.writeDouble(((Number)data2).doubleValue());
        } else if (object instanceof Long) {
            v0 = buf.writeLong(((Number)data2).longValue());
        } else if (object instanceof Short) {
            v0 = buf.writeShort((int)((Number)data2).shortValue());
        } else if (object instanceof Byte) {
            v0 = buf.writeByte((int)((Number)data2).byteValue());
        } else if (object instanceof Enum) {
            buf.writeUtf(data2.getClass().getName());
            v0 = buf.writeEnum((Enum)data2);
        } else if (object instanceof Character) {
            v0 = buf.writeChar((int)((Character)data2).charValue());
        } else if (object instanceof List) {
            buf.writeCollection((Collection)data2, (arg_0, arg_1) -> ConfigSerializer.autoWrite$lambda$0((Function2)new Function2<FriendlyByteBuf, Object, Unit>((Object)this){

                public final void invoke(FriendlyByteBuf p0, Object p1) {
                    Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                    Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                    ConfigSerializer.access$autoWrite((ConfigSerializer)this.receiver, p0, p1);
                }
            }, arg_0, arg_1));
            v0 = Unit.INSTANCE;
        } else if (object instanceof Map) {
            Function2 function2 = (Function2)new Function2<FriendlyByteBuf, Object, Unit>((Object)this){

                public final void invoke(FriendlyByteBuf p0, Object p1) {
                    Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                    Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                    ConfigSerializer.access$autoWrite((ConfigSerializer)this.receiver, p0, p1);
                }
            };
            buf.writeMap((Map)data2, new StreamEncoder(function2){
                private final /* synthetic */ Function2 function;
                {
                    Intrinsics.checkNotNullParameter((Object)function, (String)"function");
                    this.function = function;
                }

                public final /* synthetic */ void encode(Object p0, Object p1) {
                    this.function.invoke(p0, p1);
                }
            }, (arg_0, arg_1) -> ConfigSerializer.autoWrite$lambda$1((Function2)new Function2<FriendlyByteBuf, Object, Unit>((Object)this){

                public final void invoke(FriendlyByteBuf p0, Object p1) {
                    Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
                    Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
                    ConfigSerializer.access$autoWrite((ConfigSerializer)this.receiver, p0, p1);
                }
            }, arg_0, arg_1));
            v0 = Unit.INSTANCE;
        } else if (object instanceof byte[]) {
            v0 = buf.writeBytes((byte[])data2);
        } else {
            throw new IllegalStateException(("Unknown config value type: " + data2).toString());
        }
    }

    public final void deserialize(@NotNull ModConfigSpec cfg, @NotNull FriendlyByteBuf buf) {
        Intrinsics.checkNotNullParameter((Object)cfg, (String)"cfg");
        Intrinsics.checkNotNullParameter((Object)buf, (String)"buf");
        Map map = new LinkedHashMap();
        while (buf.isReadable()) {
            map.put(buf.readUtf(), this.autoRead(buf));
        }
        this.deserialize(cfg, map);
    }

    private final void deserialize(ModConfigSpec cfg, Map<String, ? extends Object> map) {
        Map<String, ? extends Object> $this$forEach$iv = map;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<String, ? extends Object>> iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ? extends Object> element$iv;
            Map.Entry<String, ? extends Object> entry = element$iv = iterator.next();
            boolean bl = false;
            String k = entry.getKey();
            Object v = entry.getValue();
            ModConfigSpec.ConfigValue configValue = (ModConfigSpec.ConfigValue)cfg.getValues().get(k);
            if (configValue == null) continue;
            configValue.set(v);
        }
    }

    private final void forEachValue(Map<String, ? extends Object> map, Function2<? super String, ? super ModConfigSpec.ConfigValue<?>, Unit> cb) {
        this.forEachValueInner(map, cb, new String[0]);
    }

    private final void forEachValueInner(Map<String, ? extends Object> map, Function2<? super String, ? super ModConfigSpec.ConfigValue<?>, Unit> cb, String ... path) {
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String k = entry.getKey();
            Object v = entry.getValue();
            Object object = v;
            if (object instanceof UnmodifiableConfig) {
                Map map2 = ((UnmodifiableConfig)v).valueMap();
                Intrinsics.checkNotNullExpressionValue((Object)map2, (String)"valueMap(...)");
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.addSpread((Object)path);
                spreadBuilder.add((Object)k);
                this.forEachValueInner(map2, cb, (String[])spreadBuilder.toArray((Object[])new String[spreadBuilder.size()]));
                continue;
            }
            if (object instanceof ModConfigSpec.ConfigValue) {
                cb.invoke((Object)(ArraysKt.joinToString$default((Object[])path, (CharSequence)".", null, null, (int)0, null, null, (int)62, null) + (String)(!(path.length == 0) ? "." + k : k)), v);
                continue;
            }
            throw new IllegalStateException(("Unknown config value type: " + v).toString());
        }
    }

    private static final Unit serialize$lambda$0(Map $map, FriendlyByteBuf $buf, String k, ModConfigSpec.ConfigValue v) {
        Intrinsics.checkNotNullParameter((Object)k, (String)"k");
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        $map.put(k, v.get());
        $buf.writeUtf(k);
        Object object = v.get();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        INSTANCE.autoWrite($buf, object);
        return Unit.INSTANCE;
    }

    private static final Object autoRead$lambda$0(Function1 $tmp0, Object p0) {
        return $tmp0.invoke(p0);
    }

    private static final Object autoRead$lambda$1(Function1 $tmp0, Object p0) {
        return $tmp0.invoke(p0);
    }

    private static final Object autoRead$lambda$2(Function1 $tmp0, Object p0) {
        return $tmp0.invoke(p0);
    }

    private static final void autoWrite$lambda$0(Function2 $tmp0, Object p0, Object p1) {
        $tmp0.invoke(p0, p1);
    }

    private static final void autoWrite$lambda$1(Function2 $tmp0, Object p0, Object p1) {
        $tmp0.invoke(p0, p1);
    }

    public static final /* synthetic */ Object access$autoRead(ConfigSerializer $this, FriendlyByteBuf buf) {
        return $this.autoRead(buf);
    }

    public static final /* synthetic */ void access$autoWrite(ConfigSerializer $this, FriendlyByteBuf buf, Object data2) {
        $this.autoWrite(buf, data2);
    }
}

