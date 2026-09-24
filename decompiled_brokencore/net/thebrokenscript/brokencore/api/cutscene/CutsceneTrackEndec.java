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
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.TypeIntrinsics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.cutscene;

import io.wispforest.endec.Deserializer;
import io.wispforest.endec.Endec;
import io.wispforest.endec.SerializationContext;
import io.wispforest.endec.Serializer;
import io.wispforest.endec.StructEndec;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.cutscene.CutsceneTrack;
import net.thebrokenscript.brokencore.api.cutscene.Timeline;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNode;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNodeType;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNodes;
import net.thebrokenscript.brokencore.api.util.serde.ExtraEndecs;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J(\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u000b\u001a\u00020\u0011H\u0016JJ\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0002\"\b\b\u0000\u0010\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00140\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrackEndec;", "Lio/wispforest/endec/StructEndec;", "Lnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrack;", "<init>", "()V", "encodeStruct", "", "ctx", "Lio/wispforest/endec/SerializationContext;", "serializer", "Lio/wispforest/endec/Serializer;", "struct", "Lio/wispforest/endec/Serializer$Struct;", "value", "decodeStruct", "deserializer", "Lio/wispforest/endec/Deserializer;", "Lio/wispforest/endec/Deserializer$Struct;", "finalConstruct", "N", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNode;", "uuid", "Ljava/util/UUID;", "ty", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodeType;", "map", "", "timeline", "Lnet/thebrokenscript/brokencore/api/cutscene/Timeline;", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nCutsceneTrack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CutsceneTrack.kt\nnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrackEndec\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,154:1\n1#2:155\n*E\n"})
public final class CutsceneTrackEndec
implements StructEndec<CutsceneTrack<?>> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final Endec<Map<UUID, CutsceneNode>> MAP_ENDEC = Endec.map(ExtraEndecs.UUID_ENDEC, (Endec)((Endec)CutsceneNodes.ENDEC)).xmap(CutsceneTrackEndec::MAP_ENDEC$lambda$0, CutsceneTrackEndec::MAP_ENDEC$lambda$1);
    private static final Endec<Timeline> TIMELINE_ENDEC = Endec.map((Endec)Endec.INT, ExtraEndecs.UUID_ENDEC).xmap(arg_0 -> Companion.access$deserializeTimeline(Companion, arg_0), Timeline::serialize);

    public void encodeStruct(@NotNull SerializationContext ctx, @NotNull Serializer<?> serializer, @NotNull Serializer.Struct struct, @NotNull CutsceneTrack<?> value) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        Intrinsics.checkNotNullParameter(serializer, (String)"serializer");
        Intrinsics.checkNotNullParameter((Object)struct, (String)"struct");
        Intrinsics.checkNotNullParameter(value, (String)"value");
        struct.field("type", ctx, Endec.STRING, (Object)value.getType().getId().toString());
        struct.field("uuid", ctx, ExtraEndecs.UUID_ENDEC, (Object)value.getUuid());
        Map<UUID, ?> map = value.getNodes();
        Intrinsics.checkNotNull(map, (String)"null cannot be cast to non-null type kotlin.collections.MutableMap<java.util.UUID, net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNode>");
        struct.field("nodes", ctx, MAP_ENDEC, (Object)TypeIntrinsics.asMutableMap(map));
        struct.field("timeline", ctx, TIMELINE_ENDEC, (Object)value.getTimeline());
    }

    @NotNull
    public CutsceneTrack<?> decodeStruct(@NotNull SerializationContext ctx, @NotNull Deserializer<?> deserializer, @NotNull Deserializer.Struct struct) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        Intrinsics.checkNotNullParameter(deserializer, (String)"deserializer");
        Intrinsics.checkNotNullParameter((Object)struct, (String)"struct");
        Object object = struct.field("type", ctx, Endec.STRING);
        if (object == null) {
            boolean $i$a$-checkNotNull-CutsceneTrackEndec$decodeStruct$typeId$22 = false;
            String $i$a$-checkNotNull-CutsceneTrackEndec$decodeStruct$typeId$22 = "Failed to read field \"type\" from struct!";
            throw new IllegalStateException($i$a$-checkNotNull-CutsceneTrackEndec$decodeStruct$typeId$22.toString());
        }
        String typeId = (String)object;
        CutsceneNodeType<?> cutsceneNodeType = CutsceneNodes.TYPES.get(ResourceLocation.parse((String)typeId));
        if (cutsceneNodeType == null) {
            boolean $i$a$-checkNotNull-CutsceneTrackEndec$decodeStruct$type$22 = false;
            String $i$a$-checkNotNull-CutsceneTrackEndec$decodeStruct$type$22 = "Failed to find cutscene node type: \"" + typeId + "\"";
            throw new IllegalStateException($i$a$-checkNotNull-CutsceneTrackEndec$decodeStruct$type$22.toString());
        }
        CutsceneNodeType<?> type = cutsceneNodeType;
        Object object2 = struct.field("uuid", ctx, ExtraEndecs.UUID_ENDEC);
        if (object2 == null) {
            boolean $i$a$-checkNotNull-CutsceneTrackEndec$decodeStruct$uuid$22 = false;
            String $i$a$-checkNotNull-CutsceneTrackEndec$decodeStruct$uuid$22 = "Failed to read field \"uuid\" from struct!";
            throw new IllegalStateException($i$a$-checkNotNull-CutsceneTrackEndec$decodeStruct$uuid$22.toString());
        }
        UUID uuid = (UUID)object2;
        Object object3 = struct.field("nodes", ctx, MAP_ENDEC);
        if (object3 == null) {
            boolean bl = false;
            String string = "Failed to read field \"nodes\" from struct!";
            throw new IllegalStateException(string.toString());
        }
        Map nodes = (Map)object3;
        Object object4 = struct.field("timeline", ctx, TIMELINE_ENDEC);
        if (object4 == null) {
            boolean bl = false;
            String string = "Failed to read field \"timeline\" from struct!";
            throw new IllegalStateException(string.toString());
        }
        Timeline timeline = (Timeline)object4;
        return this.finalConstruct(uuid, type, nodes, timeline);
    }

    private final <N extends CutsceneNode> CutsceneTrack<N> finalConstruct(UUID uuid, CutsceneNodeType<N> ty, Map<UUID, CutsceneNode> map, Timeline timeline) {
        Intrinsics.checkNotNull(map, (String)"null cannot be cast to non-null type kotlin.collections.MutableMap<java.util.UUID, N of net.thebrokenscript.brokencore.api.cutscene.CutsceneTrackEndec.finalConstruct>");
        return new CutsceneTrack<N>(uuid, ty, TypeIntrinsics.asMutableMap(map), timeline);
    }

    private static final Map MAP_ENDEC$lambda$0(Map it) {
        Intrinsics.checkNotNull((Object)it);
        return MapsKt.toMutableMap((Map)it);
    }

    private static final Map MAP_ENDEC$lambda$1(Map it) {
        Intrinsics.checkNotNull((Object)it);
        return MapsKt.toMap((Map)it);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0002R\u00a3\u0001\u0010\n\u001a\u0096\u0001\u0012D\u0012B\u0012\f\u0012\n \r*\u0004\u0018\u00010\t0\t\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000e0\u000e \r* \u0012\f\u0012\n \r*\u0004\u0018\u00010\t0\t\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\f0\f \r*J\u0012D\u0012B\u0012\f\u0012\n \r*\u0004\u0018\u00010\t0\t\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000e0\u000e \r* \u0012\f\u0012\n \r*\u0004\u0018\u00010\t0\t\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\f0\f\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R2\u0010\u000f\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00050\u0005 \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrackEndec$Companion;", "", "<init>", "()V", "deserializeTimeline", "Lnet/thebrokenscript/brokencore/api/cutscene/Timeline;", "map", "", "", "Ljava/util/UUID;", "MAP_ENDEC", "Lio/wispforest/endec/Endec;", "", "kotlin.jvm.PlatformType", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNode;", "TIMELINE_ENDEC", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        private final Timeline deserializeTimeline(Map<Integer, UUID> map) {
            return Timeline.Companion.deserialize(map);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static final /* synthetic */ Timeline access$deserializeTimeline(Companion $this, Map map) {
            return $this.deserializeTimeline(map);
        }
    }
}

