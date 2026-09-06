/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.cutscene;

import io.wispforest.endec.Endec;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.CutsceneEditorScreen;
import net.thebrokenscript.brokencore.api.client.event.RenderEvents;
import net.thebrokenscript.brokencore.api.cutscene.CutsceneTrackEndec;
import net.thebrokenscript.brokencore.api.cutscene.Timeline;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNode;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNodeType;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 (*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001(B=\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u001bJ\u0013\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020 H\u0007J\b\u0010!\u001a\u00020 H\u0007J\u0018\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0007J\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006)"}, d2={"Lnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrack;", "T", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNode;", "", "uuid", "Ljava/util/UUID;", "type", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodeType;", "nodes", "", "timeline", "Lnet/thebrokenscript/brokencore/api/cutscene/Timeline;", "<init>", "(Ljava/util/UUID;Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodeType;Ljava/util/Map;Lnet/thebrokenscript/brokencore/api/cutscene/Timeline;)V", "getUuid", "()Ljava/util/UUID;", "getType", "()Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodeType;", "getNodes", "()Ljava/util/Map;", "getTimeline", "()Lnet/thebrokenscript/brokencore/api/cutscene/Timeline;", "duration", "", "getDuration", "()I", "addNode", "Lkotlin/Pair;", "append", "node", "(Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNode;)Ljava/util/UUID;", "setup", "", "cleanup", "renderPlaying", "event", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$LevelStageData;", "time", "", "duplicate", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nCutsceneTrack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CutsceneTrack.kt\nnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrack\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,154:1\n1869#2,2:155\n1869#2,2:157\n1#3:159\n*S KotlinDebug\n*F\n+ 1 CutsceneTrack.kt\nnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrack\n*L\n44#1:155,2\n49#1:157,2\n*E\n"})
public final class CutsceneTrack<T extends CutsceneNode> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final UUID uuid;
    @NotNull
    private final CutsceneNodeType<T> type;
    @NotNull
    private final Map<UUID, T> nodes;
    @NotNull
    private final Timeline timeline;
    @NotNull
    private static final Endec<CutsceneTrack<?>> ENDEC = (Endec)new CutsceneTrackEndec();

    public CutsceneTrack(@NotNull UUID uuid, @NotNull CutsceneNodeType<T> type, @NotNull Map<UUID, T> nodes, @NotNull Timeline timeline) {
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter(nodes, (String)"nodes");
        Intrinsics.checkNotNullParameter((Object)timeline, (String)"timeline");
        this.uuid = uuid;
        this.type = type;
        this.nodes = nodes;
        this.timeline = timeline;
    }

    public /* synthetic */ CutsceneTrack(UUID uUID, CutsceneNodeType cutsceneNodeType, Map map, Timeline timeline, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            map = new LinkedHashMap();
        }
        if ((n & 8) != 0) {
            timeline = new Timeline();
        }
        this(uUID, cutsceneNodeType, map, timeline);
    }

    @NotNull
    public final UUID getUuid() {
        return this.uuid;
    }

    @NotNull
    public final CutsceneNodeType<T> getType() {
        return this.type;
    }

    @NotNull
    public final Map<UUID, T> getNodes() {
        return this.nodes;
    }

    @NotNull
    public final Timeline getTimeline() {
        return this.timeline;
    }

    public final int getDuration() {
        return this.timeline.getDuration();
    }

    @NotNull
    public final Pair<UUID, T> addNode() {
        T it = this.type.create();
        boolean bl = false;
        UUID id = UUID.randomUUID();
        this.nodes.put(id, it);
        Intrinsics.checkNotNull((Object)id);
        this.timeline.append(id);
        return TuplesKt.to((Object)id, it);
    }

    @NotNull
    public final UUID append(@NotNull T node) {
        Intrinsics.checkNotNullParameter(node, (String)"node");
        UUID id = UUID.randomUUID();
        this.nodes.put(id, node);
        Intrinsics.checkNotNull((Object)id);
        this.timeline.append(id);
        return id;
    }

    @SideOnly(side=Side.CLIENT)
    public final void setup() {
        Iterable $this$forEach$iv = this.nodes.values();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            CutsceneNode it = (CutsceneNode)element$iv;
            boolean bl = false;
            it.setup();
        }
    }

    @SideOnly(side=Side.CLIENT)
    public final void cleanup() {
        Iterable $this$forEach$iv = this.nodes.values();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            CutsceneNode it = (CutsceneNode)element$iv;
            boolean bl = false;
            it.cleanup();
        }
    }

    @SideOnly(side=Side.CLIENT)
    public final void renderPlaying(@NotNull RenderEvents.LevelStageData event, float time2) {
        CutsceneNode cutsceneNode;
        CutsceneNode cutsceneNode2;
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        Pair<Pair<Integer, UUID>, Pair<Integer, UUID>> pair = this.timeline.getPair(time2);
        if (pair == null) {
            return;
        }
        Pair<Pair<Integer, UUID>, Pair<Integer, UUID>> pair2 = pair;
        Pair prePair = (Pair)pair2.component1();
        Pair postPair = (Pair)pair2.component2();
        Pair pair3 = prePair;
        if (pair3 != null) {
            Pair it = pair3;
            boolean bl = false;
            cutsceneNode2 = (CutsceneNode)this.nodes.get(it.getSecond());
        } else {
            cutsceneNode2 = null;
        }
        CutsceneNode pre = cutsceneNode2;
        Pair pair4 = postPair;
        if (pair4 != null) {
            Pair it = pair4;
            boolean bl = false;
            cutsceneNode = (CutsceneNode)this.nodes.get(it.getSecond());
        } else {
            cutsceneNode = null;
        }
        CutsceneNode post = cutsceneNode;
        boolean renderPreview = ClientDSLKt.getMC().screen instanceof CutsceneEditorScreen;
        if (pre == null || post == null) {
            CutsceneNode cutsceneNode3 = pre;
            if (cutsceneNode3 == null && (cutsceneNode3 = post) == null) {
                return;
            }
            CutsceneNode item2 = cutsceneNode3;
            if (renderPreview) {
                item2.renderPreview(event);
            } else {
                item2.render(event);
            }
            item2.applyEffects();
            return;
        }
        if (Intrinsics.areEqual((Object)prePair.getSecond(), (Object)postPair.getSecond())) {
            if (renderPreview) {
                pre.renderPreview(event);
            } else {
                pre.render(event);
            }
            pre.applyEffects();
            return;
        }
        int preTime = ((Number)prePair.getFirst()).intValue();
        int postTime = ((Number)postPair.getFirst()).intValue();
        float progress = (time2 - (float)preTime) / (float)(postTime - preTime);
        CutsceneNode item3 = this.type.interpolate(progress, pre, post);
        if (renderPreview) {
            item3.renderPreview(event);
        } else {
            item3.render(event);
        }
        item3.applyEffects();
    }

    @NotNull
    public final CutsceneTrack<T> duplicate() {
        UUID uUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"randomUUID(...)");
        CutsceneTrack<T> track = new CutsceneTrack<T>(uUID, this.type, null, null, 12, null);
        return track;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrack$Companion;", "", "<init>", "()V", "ENDEC", "Lio/wispforest/endec/Endec;", "Lnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrack;", "getENDEC", "()Lio/wispforest/endec/Endec;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Endec<CutsceneTrack<?>> getENDEC() {
            return ENDEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

