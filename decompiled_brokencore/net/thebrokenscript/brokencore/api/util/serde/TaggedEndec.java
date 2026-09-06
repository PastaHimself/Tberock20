/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Deserializer
 *  io.wispforest.endec.Deserializer$Struct
 *  io.wispforest.endec.Endec
 *  io.wispforest.endec.SerializationContext
 *  io.wispforest.endec.Serializer
 *  io.wispforest.endec.Serializer$Struct
 *  io.wispforest.endec.StructEndec
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.util.serde;

import io.wispforest.endec.Deserializer;
import io.wispforest.endec.Endec;
import io.wispforest.endec.SerializationContext;
import io.wispforest.endec.Serializer;
import io.wispforest.endec.StructEndec;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.thebrokenscript.brokencore.api.util.serde.Tagged;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J,\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\b\b\u0001\u0010\u000b*\u00028\u00002\u0006\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\tJ1\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0017J+\u0010\u0018\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0010\u001a\u00020\u00112\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010\u0014\u001a\u00020\u001bH\u0016\u00a2\u0006\u0002\u0010\u001cR \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lnet/thebrokenscript/brokencore/api/util/serde/TaggedEndec;", "B", "Lnet/thebrokenscript/brokencore/api/util/serde/Tagged;", "Lio/wispforest/endec/StructEndec;", "<init>", "()V", "endecs", "", "", "Lio/wispforest/endec/Endec;", "register", "V", "tag", "endec", "encodeStruct", "", "ctx", "Lio/wispforest/endec/SerializationContext;", "serializer", "Lio/wispforest/endec/Serializer;", "struct", "Lio/wispforest/endec/Serializer$Struct;", "value", "(Lio/wispforest/endec/SerializationContext;Lio/wispforest/endec/Serializer;Lio/wispforest/endec/Serializer$Struct;Lnet/thebrokenscript/brokencore/api/util/serde/Tagged;)V", "decodeStruct", "deserializer", "Lio/wispforest/endec/Deserializer;", "Lio/wispforest/endec/Deserializer$Struct;", "(Lio/wispforest/endec/SerializationContext;Lio/wispforest/endec/Deserializer;Lio/wispforest/endec/Deserializer$Struct;)Lnet/thebrokenscript/brokencore/api/util/serde/Tagged;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nTaggedEndec.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaggedEndec.kt\nnet/thebrokenscript/brokencore/api/util/serde/TaggedEndec\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,34:1\n1#2:35\n*E\n"})
public final class TaggedEndec<B extends Tagged>
implements StructEndec<B> {
    @NotNull
    private final Map<String, Endec<B>> endecs = new LinkedHashMap();

    @NotNull
    public final <V extends B> TaggedEndec<B> register(@NotNull String tag, @NotNull Endec<V> endec2) {
        TaggedEndec taggedEndec;
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        Intrinsics.checkNotNullParameter(endec2, (String)"endec");
        TaggedEndec $this$register_u24lambda_u240 = taggedEndec = this;
        boolean bl = false;
        $this$register_u24lambda_u240.endecs.put(tag, endec2);
        return taggedEndec;
    }

    public void encodeStruct(@NotNull SerializationContext ctx, @NotNull Serializer<?> serializer, @NotNull Serializer.Struct struct, @NotNull B value) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        Intrinsics.checkNotNullParameter(serializer, (String)"serializer");
        Intrinsics.checkNotNullParameter((Object)struct, (String)"struct");
        Intrinsics.checkNotNullParameter(value, (String)"value");
        String tag = value.getTag();
        Endec<B> endec2 = this.endecs.get(tag);
        if (endec2 == null) {
            boolean bl = false;
            String string = "No endec registered for tag " + tag + "!";
            throw new IllegalStateException(string.toString());
        }
        Endec<B> endec3 = endec2;
        struct.field("type", ctx, Endec.STRING, (Object)tag);
        struct.field("value", ctx, endec3, value);
    }

    @Nullable
    public B decodeStruct(@NotNull SerializationContext ctx, @NotNull Deserializer<?> deserializer, @NotNull Deserializer.Struct struct) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        Intrinsics.checkNotNullParameter(deserializer, (String)"deserializer");
        Intrinsics.checkNotNullParameter((Object)struct, (String)"struct");
        Object object = struct.field("type", ctx, Endec.STRING);
        if (object == null) {
            boolean bl = false;
            String string = "Could not read field \"type\" from data!";
            throw new IllegalStateException(string.toString());
        }
        String tag = (String)object;
        Endec<B> endec2 = this.endecs.get(tag);
        if (endec2 == null) {
            boolean bl = false;
            String string = "No endec registered for tag " + tag + "!";
            throw new IllegalStateException(string.toString());
        }
        Endec<B> endec3 = endec2;
        return (B)((Tagged)struct.field("value", ctx, endec3));
    }
}

