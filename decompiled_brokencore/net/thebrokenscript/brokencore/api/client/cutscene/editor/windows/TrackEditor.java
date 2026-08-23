/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.owo.ui.component.ButtonComponent
 *  io.wispforest.owo.ui.container.FlowLayout
 *  io.wispforest.owo.ui.core.Component
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.cutscene.editor.windows;

import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.container.FlowLayout;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.thebrokenscript.brokencore.api.client.cutscene.EditorContext;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.util.Flows;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.util.OwoDSLKt;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.windows.CutsceneEditor;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.windows.EditorWindow;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.windows.NodeEditor;
import net.thebrokenscript.brokencore.api.cutscene.Cutscene;
import net.thebrokenscript.brokencore.api.cutscene.CutsceneTrack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u000f\u001a\u00020\u0010*\u00020\u000bH\u0016J\u0014\u0010\u0011\u001a\u00020\u0010*\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0006\u0010\u0013\u001a\u00020\u0010R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/TrackEditor;", "Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/EditorWindow;", "track", "Lnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrack;", "<init>", "(Lnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrack;)V", "getTrack", "()Lnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrack;", "nodes", "", "Ljava/util/UUID;", "Lio/wispforest/owo/ui/container/FlowLayout;", "getNodes", "()Ljava/util/Map;", "container", "build", "", "createNodeUI", "uuid", "refreshNodes", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nTrackEditor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TrackEditor.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/TrackEditor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,117:1\n1869#2,2:118\n54#3:120\n29#3:121\n24#3:122\n77#3:123\n15#3:124\n29#3:125\n24#3:126\n18#3:127\n62#3:128\n15#3:129\n39#3:130\n29#3:131\n24#3:132\n*S KotlinDebug\n*F\n+ 1 TrackEditor.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/TrackEditor\n*L\n110#1:118,2\n23#1:120\n23#1:121\n23#1:122\n23#1:123\n23#1:124\n23#1:125\n23#1:126\n23#1:127\n89#1:128\n89#1:129\n89#1:130\n89#1:131\n89#1:132\n*E\n"})
public final class TrackEditor
extends EditorWindow {
    @NotNull
    private final CutsceneTrack<?> track;
    @NotNull
    private final Map<UUID, FlowLayout> nodes;
    private FlowLayout container;

    public TrackEditor(@NotNull CutsceneTrack<?> track) {
        Intrinsics.checkNotNullParameter(track, (String)"track");
        this.track = track;
        this.nodes = new LinkedHashMap();
    }

    @NotNull
    public final CutsceneTrack<?> getTrack() {
        return this.track;
    }

    @NotNull
    public final Map<UUID, FlowLayout> getNodes() {
        return this.nodes;
    }

    @Override
    public void build(@NotNull FlowLayout $this$build) {
        Intrinsics.checkNotNullParameter((Object)$this$build, (String)"<this>");
        this.container = $this$build;
        Cutscene cutscene = EditorContext.INSTANCE.getActiveCutscene();
        if (cutscene == null) {
            return;
        }
        Cutscene cur = cutscene;
        $this$build.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.horizontal((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> TrackEditor.build$lambda$0(this, arg_0))));
        OwoDSLKt.spacer($this$build, 1, 15);
        $this$build.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.horizontal((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> TrackEditor.build$lambda$1(this, cur, arg_0))));
        OwoDSLKt.spacer($this$build, 1, 15);
        this.greenButton($this$build, "Add Node", (Function0<Unit>)((Function0)() -> TrackEditor.build$lambda$2(this, $this$build)));
        OwoDSLKt.spacer($this$build, 1, 10);
        for (UUID uuid : this.track.getTimeline().values()) {
            this.createNodeUI($this$build, uuid);
        }
    }

    private final void createNodeUI(FlowLayout $this$createNodeUI, UUID uuid) {
        int secs;
        Integer n = this.track.getTimeline().getKey(uuid);
        Intrinsics.checkNotNull((Object)n);
        int time2 = n;
        int n2 = secs = time2 / 20;
        int n3 = 60;
        int n4 = n2 / n3;
        if ((n2 ^ n3) < 0 && n4 * n3 != n2) {
            --n4;
        }
        int mins = n4;
        secs -= mins * 60;
        n3 = mins;
        n4 = 60;
        int n5 = n3 / n4;
        if ((n3 ^ n4) < 0 && n5 * n4 != n3) {
            --n5;
        }
        int hrs = n5;
        int remaining = time2 - secs * 20 - (mins -= hrs * 60) * 60 * 20 - hrs * 60 * 60 * 20;
        String secsStr = StringsKt.padStart((String)String.valueOf(secs), (int)2, (char)'0');
        String minsStr = StringsKt.padStart((String)String.valueOf(mins), (int)2, (char)'0');
        String hrsStr = StringsKt.padStart((String)String.valueOf(hrs), (int)2, (char)'0');
        String[] stringArray = "%.2f";
        Object[] objectArray = new Object[]{Float.valueOf((float)remaining / 20.0f)};
        String string = String.format((String)stringArray, Arrays.copyOf(objectArray, objectArray.length));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"format(...)");
        stringArray = new String[]{"."};
        String remStr = (String)CollectionsKt.last((List)StringsKt.split$default((CharSequence)string, (String[])stringArray, (boolean)false, (int)0, (int)6, null));
        FlowLayout node = Flows.INSTANCE.vertical((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> TrackEditor.createNodeUI$lambda$0(hrsStr, minsStr, secsStr, remStr, this, uuid, time2, arg_0)));
        this.nodes.put(uuid, node);
        $this$createNodeUI.child((io.wispforest.owo.ui.core.Component)node);
    }

    public final void refreshNodes() {
        Iterable $this$forEach$iv = this.nodes.values();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            FlowLayout it = (FlowLayout)element$iv;
            boolean bl = false;
            it.remove();
        }
        this.nodes.clear();
        for (UUID uuid : this.track.getTimeline().values()) {
            FlowLayout flowLayout = this.container;
            if (flowLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"container");
                flowLayout = null;
            }
            this.createNodeUI(flowLayout, uuid);
        }
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit build$lambda$0(TrackEditor this$0, FlowLayout $this$horizontal) {
        void $this$plus$iv;
        void $this$with$iv$iv$iv;
        void $this$bold$iv$iv;
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        Component $this$bold$iv = this$0.track.getType().getName();
        boolean $i$f$getBold = false;
        Component component = $this$bold$iv;
        ChatFormatting other$iv$iv = ChatFormatting.BOLD;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv = $this$with$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        $this$bold$iv = mutableComponent3;
        String $this$bold$iv2 = " Track Editor";
        boolean $i$f$getBold2 = false;
        String $this$c$iv$iv = $this$bold$iv2;
        boolean $i$f$getC = false;
        Component component2 = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component2;
        boolean $i$f$getBold3 = false;
        $this$mut$iv$iv$iv = $this$bold$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.BOLD;
        boolean $i$f$with2 = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut2 = false;
        MutableComponent mutableComponent4 = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent4 == null) {
            MutableComponent mutableComponent5 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent4 = mutableComponent5;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent5, (String)"copy(...)");
        }
        MutableComponent mutableComponent6 = mutableComponent4.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent6, (String)"withStyle(...)");
        Component other$iv = (Component)mutableComponent6;
        boolean $i$f$plus = false;
        MutableComponent mutableComponent7 = $this$plus$iv.append(other$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent7, (String)"append(...)");
        OwoDSLKt.text($this$horizontal, (Component)mutableComponent7);
        OwoDSLKt.space($this$horizontal, 4);
        this$0.redButton($this$horizontal, "x", (Function0<Unit>)((Function0)() -> TrackEditor.build$lambda$0$0(this$0)));
        return Unit.INSTANCE;
    }

    private static final Unit build$lambda$0$0(TrackEditor this$0) {
        for (Map.Entry<UUID, ?> node : this$0.track.getNodes().entrySet()) {
            NodeEditor nodeEditor = EditorContext.INSTANCE.getNodeEditors().get(node.getKey());
            if (nodeEditor == null) continue;
            nodeEditor.remove();
        }
        this$0.remove();
        return Unit.INSTANCE;
    }

    private static final Unit build$lambda$1(TrackEditor this$0, Cutscene $cur, FlowLayout $this$horizontal) {
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        this$0.yellowButton($this$horizontal, "Duplicate", (Function0<Unit>)((Function0)() -> TrackEditor.build$lambda$1$0(this$0, $cur)));
        OwoDSLKt.space$default($this$horizontal, 0, 1, null);
        this$0.redButton($this$horizontal, "Delete", (Function0<Unit>)((Function0)() -> TrackEditor.build$lambda$1$1($cur, this$0)));
        return Unit.INSTANCE;
    }

    private static final Unit build$lambda$1$0(TrackEditor this$0, Cutscene $cur) {
        CutsceneTrack<?> cutsceneTrack = this$0.track.duplicate();
        $cur.getTracks().add(cutsceneTrack);
        CutsceneEditor cutsceneEditor = EditorContext.INSTANCE.getCutsceneEditor();
        if (cutsceneEditor != null) {
            cutsceneEditor.refreshTracks();
        }
        EditorContext.INSTANCE.getUi().createTrackWindow(cutsceneTrack);
        return Unit.INSTANCE;
    }

    private static final Unit build$lambda$1$1(Cutscene $cur, TrackEditor this$0) {
        $cur.getTracks().remove(this$0.track);
        Object object = EditorContext.INSTANCE.getCutsceneEditor();
        if (object != null && (object = object.getTracks()) != null && (object = (FlowLayout)object.remove(this$0.track.getUuid())) != null) {
            object.remove();
        }
        EditorContext.INSTANCE.getTrackEditors().remove(this$0.track.getUuid());
        this$0.remove();
        return Unit.INSTANCE;
    }

    private static final Unit build$lambda$2(TrackEditor this$0, FlowLayout $this_build) {
        UUID node = (UUID)this$0.track.addNode().getFirst();
        this$0.createNodeUI($this_build, node);
        return Unit.INSTANCE;
    }

    private static final Unit createNodeUI$lambda$0(String $hrsStr, String $minsStr, String $secsStr, String $remStr, TrackEditor this$0, UUID $uuid, int $time, FlowLayout $this$vertical) {
        Intrinsics.checkNotNullParameter((Object)$this$vertical, (String)"$this$vertical");
        OwoDSLKt.spacer($this$vertical, 1, 5);
        $this$vertical.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.horizontal((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> TrackEditor.createNodeUI$lambda$0$0($hrsStr, $minsStr, $secsStr, $remStr, this$0, $uuid, $time, $this$vertical, arg_0))));
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit createNodeUI$lambda$0$0(String $hrsStr, String $minsStr, String $secsStr, String $remStr, TrackEditor this$0, UUID $uuid, int $time, FlowLayout $this_vertical, FlowLayout $this$horizontal) {
        void $this$with$iv$iv$iv;
        void $this$darkGreen$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        String $this$darkGreen$iv = $hrsStr + ":" + $minsStr + ":" + $secsStr + "." + $remStr;
        boolean $i$f$getDarkGreen = false;
        String $this$c$iv$iv = $this$darkGreen$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getDarkGreen2 = false;
        void var13_13 = $this$darkGreen$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.DARK_GREEN;
        boolean $i$f$with = false;
        void $this$mut$iv$iv$iv$iv = $this$with$iv$iv$iv;
        boolean $i$f$mut = false;
        MutableComponent mutableComponent = $this$mut$iv$iv$iv$iv instanceof MutableComponent ? (MutableComponent)$this$mut$iv$iv$iv$iv : null;
        if (mutableComponent == null) {
            MutableComponent mutableComponent2 = $this$mut$iv$iv$iv$iv.copy();
            mutableComponent = mutableComponent2;
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent2, (String)"copy(...)");
        }
        MutableComponent mutableComponent3 = mutableComponent.withStyle(other$iv$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent3, (String)"withStyle(...)");
        OwoDSLKt.colored(OwoDSLKt.button($this$horizontal, (Component)mutableComponent3, (Function1<? super ButtonComponent, Unit>)((Function1)arg_0 -> TrackEditor.createNodeUI$lambda$0$0$0($uuid, this$0, arg_0))), 0xFF004444L, 0xFF006666L, 0xFF002222L);
        OwoDSLKt.space($this$horizontal, 3);
        this$0.redButton($this$horizontal, "x", (Function0<Unit>)((Function0)() -> TrackEditor.createNodeUI$lambda$0$0$1(this$0, $time, $uuid, $this_vertical)));
        return Unit.INSTANCE;
    }

    private static final Unit createNodeUI$lambda$0$0$0(UUID $uuid, TrackEditor this$0, ButtonComponent $this$button) {
        Intrinsics.checkNotNullParameter((Object)$this$button, (String)"$this$button");
        EditorContext.INSTANCE.getUi().createNodeWindow($uuid, this$0.track);
        return Unit.INSTANCE;
    }

    private static final Unit createNodeUI$lambda$0$0$1(TrackEditor this$0, int $time, UUID $uuid, FlowLayout $this_vertical) {
        this$0.track.getTimeline().remove((Object)$time);
        this$0.track.getNodes().remove($uuid);
        NodeEditor nodeEditor = EditorContext.INSTANCE.getNodeEditors().remove($uuid);
        if (nodeEditor != null) {
            nodeEditor.remove();
        }
        $this_vertical.remove();
        return Unit.INSTANCE;
    }
}

