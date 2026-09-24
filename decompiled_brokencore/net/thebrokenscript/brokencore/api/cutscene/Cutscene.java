/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.endec.Endec
 *  io.wispforest.endec.StructEndec
 *  io.wispforest.endec.impl.StructEndecBuilder
 *  io.wispforest.endec.impl.StructField
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty1
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.cutscene;

import io.wispforest.endec.Endec;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import io.wispforest.endec.impl.StructField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty1;
import net.thebrokenscript.brokencore.api.client.event.RenderEvents;
import net.thebrokenscript.brokencore.api.cutscene.Cutscene;
import net.thebrokenscript.brokencore.api.cutscene.CutsceneTrack;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.api.util.serde.ExtraEndecs;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u001fJ\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u000eH\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006'"}, d2={"Lnet/thebrokenscript/brokencore/api/cutscene/Cutscene;", "", "uuid", "Ljava/util/UUID;", "tracks", "", "Lnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrack;", "<init>", "(Ljava/util/UUID;Ljava/util/List;)V", "getUuid", "()Ljava/util/UUID;", "getTracks", "()Ljava/util/List;", "time", "", "getTime", "()F", "setTime", "(F)V", "playing", "", "getPlaying", "()Z", "setPlaying", "(Z)V", "wasPlaying", "duration", "", "getDuration", "()I", "play", "", "pause", "stop", "render", "event", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$LevelStageData;", "delta", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nCutscene.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cutscene.kt\nnet/thebrokenscript/brokencore/api/cutscene/Cutscene\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,70:1\n1#2:71\n1869#3,2:72\n1869#3,2:74\n*S KotlinDebug\n*F\n+ 1 Cutscene.kt\nnet/thebrokenscript/brokencore/api/cutscene/Cutscene\n*L\n37#1:72,2\n44#1:74,2\n*E\n"})
public final class Cutscene {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final UUID uuid;
    @NotNull
    private final List<CutsceneTrack<?>> tracks;
    private float time;
    private boolean playing;
    private boolean wasPlaying;
    @NotNull
    private static final Endec<Cutscene> ENDEC;

    public Cutscene(@NotNull UUID uuid, @NotNull List<CutsceneTrack<?>> tracks) {
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        Intrinsics.checkNotNullParameter(tracks, (String)"tracks");
        this.uuid = uuid;
        this.tracks = tracks;
    }

    public /* synthetic */ Cutscene(UUID uUID, List list, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            UUID uUID2 = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue((Object)uUID2, (String)"randomUUID(...)");
            uUID = uUID2;
        }
        if ((n & 2) != 0) {
            list = new ArrayList();
        }
        this(uUID, list);
    }

    @NotNull
    public final UUID getUuid() {
        return this.uuid;
    }

    @NotNull
    public final List<CutsceneTrack<?>> getTracks() {
        return this.tracks;
    }

    public final float getTime() {
        return this.time;
    }

    public final void setTime(float f) {
        this.time = f;
    }

    public final boolean getPlaying() {
        return this.playing;
    }

    public final void setPlaying(boolean bl) {
        this.playing = bl;
    }

    public final int getDuration() {
        Comparable comparable;
        Iterator iterator = ((Iterable)this.tracks).iterator();
        if (!iterator.hasNext()) {
            comparable = null;
        } else {
            CutsceneTrack it = (CutsceneTrack)iterator.next();
            boolean bl = false;
            Comparable comparable2 = Integer.valueOf(it.getDuration());
            while (iterator.hasNext()) {
                CutsceneTrack it2 = (CutsceneTrack)iterator.next();
                $i$a$-maxOfOrNull-Cutscene$duration$1 = false;
                Comparable comparable3 = Integer.valueOf(it2.getDuration());
                if (comparable2.compareTo(comparable3) >= 0) continue;
                comparable2 = comparable3;
            }
            comparable = comparable2;
        }
        Integer n = (Integer)comparable;
        return n != null ? n : 0;
    }

    public final void play() {
        this.playing = true;
    }

    public final void pause() {
        this.playing = false;
    }

    public final void stop() {
        this.playing = false;
        this.time = 0.0f;
    }

    @SideOnly(side=Side.CLIENT)
    public final void render(@NotNull RenderEvents.LevelStageData event, float delta) {
        CutsceneTrack it;
        boolean $i$f$forEach;
        Iterable $this$forEach$iv;
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (this.wasPlaying && !this.playing) {
            $this$forEach$iv = this.tracks;
            $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                it = (CutsceneTrack)element$iv;
                boolean bl = false;
                it.cleanup();
            }
            this.wasPlaying = false;
        }
        if (!this.playing) {
            return;
        }
        if (!this.wasPlaying) {
            $this$forEach$iv = this.tracks;
            $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                it = (CutsceneTrack)element$iv;
                boolean bl = false;
                it.setup();
            }
            this.wasPlaying = true;
        }
        this.time += delta;
        if (this.time > (float)this.getDuration()) {
            this.time = 0.0f;
        }
        for (CutsceneTrack<?> track : this.tracks) {
            track.renderPlaying(event, this.time);
        }
    }

    private static final UUID ENDEC$lambda$0(KProperty1 $tmp0, Cutscene p0) {
        return (UUID)((Function1)$tmp0).invoke((Object)p0);
    }

    private static final List ENDEC$lambda$1(List it) {
        Intrinsics.checkNotNull((Object)it);
        return CollectionsKt.toMutableList((Collection)it);
    }

    private static final List ENDEC$lambda$2(List it) {
        Intrinsics.checkNotNull((Object)it);
        return CollectionsKt.toList((Iterable)it);
    }

    private static final List ENDEC$lambda$3(KProperty1 $tmp0, Cutscene p0) {
        return (List)((Function1)$tmp0).invoke((Object)p0);
    }

    public Cutscene() {
        this(null, null, 3, null);
    }

    static {
        StructEndec structEndec = StructEndecBuilder.of((StructField)ExtraEndecs.UUID_ENDEC.fieldOf("uuid", arg_0 -> Cutscene.ENDEC$lambda$0((KProperty1)Companion.ENDEC.1.INSTANCE, arg_0)), (StructField)CutsceneTrack.Companion.getENDEC().listOf().xmap(Cutscene::ENDEC$lambda$1, Cutscene::ENDEC$lambda$2).fieldOf("tracks", arg_0 -> Cutscene.ENDEC$lambda$3((KProperty1)Companion.ENDEC.4.INSTANCE, arg_0)), Cutscene::new);
        Intrinsics.checkNotNullExpressionValue((Object)structEndec, (String)"of(...)");
        ENDEC = (Endec)structEndec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/cutscene/Cutscene$Companion;", "", "<init>", "()V", "ENDEC", "Lio/wispforest/endec/Endec;", "Lnet/thebrokenscript/brokencore/api/cutscene/Cutscene;", "getENDEC", "()Lio/wispforest/endec/Endec;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Endec<Cutscene> getENDEC() {
            return ENDEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

