/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.owo.ui.container.FlowLayout
 *  io.wispforest.owo.ui.core.Component
 *  io.wispforest.owo.ui.core.Sizing
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.ChatFormatting
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.cutscene.editor.windows;

import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.Sizing;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.thebrokenscript.brokencore.api.client.cutscene.EditorContext;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.components.IntBox;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.util.Flows;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.util.OwoDSLKt;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.windows.EditorWindow;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.windows.TrackEditor;
import net.thebrokenscript.brokencore.api.cutscene.CutsceneTrack;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNode;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/NodeEditor;", "Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/EditorWindow;", "uuid", "Ljava/util/UUID;", "track", "Lnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrack;", "<init>", "(Ljava/util/UUID;Lnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrack;)V", "getUuid", "()Ljava/util/UUID;", "getTrack", "()Lnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrack;", "trackId", "getTrackId", "node", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNode;", "getNode", "()Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNode;", "time", "", "getTime", "()I", "build", "", "Lio/wispforest/owo/ui/container/FlowLayout;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nNodeEditor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NodeEditor.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/NodeEditor\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,79:1\n54#2:80\n29#2:81\n24#2:82\n77#2:83\n15#2:84\n29#2:85\n24#2:86\n18#2:87\n66#2:88\n15#2:89\n43#2:90\n29#2:91\n24#2:92\n*S KotlinDebug\n*F\n+ 1 NodeEditor.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/NodeEditor\n*L\n28#1:80\n28#1:81\n28#1:82\n28#1:83\n28#1:84\n28#1:85\n28#1:86\n28#1:87\n60#1:88\n60#1:89\n60#1:90\n60#1:91\n60#1:92\n*E\n"})
public final class NodeEditor
extends EditorWindow {
    @NotNull
    private final UUID uuid;
    @NotNull
    private final CutsceneTrack<?> track;

    public NodeEditor(@NotNull UUID uuid, @NotNull CutsceneTrack<?> track) {
        Intrinsics.checkNotNullParameter((Object)uuid, (String)"uuid");
        Intrinsics.checkNotNullParameter(track, (String)"track");
        this.uuid = uuid;
        this.track = track;
    }

    @NotNull
    public final UUID getUuid() {
        return this.uuid;
    }

    @NotNull
    public final CutsceneTrack<?> getTrack() {
        return this.track;
    }

    @NotNull
    public final UUID getTrackId() {
        return this.track.getUuid();
    }

    @NotNull
    public final CutsceneNode getNode() {
        Object obj = this.track.getNodes().get(this.uuid);
        Intrinsics.checkNotNull(obj);
        return (CutsceneNode)obj;
    }

    public final int getTime() {
        Integer n = this.track.getTimeline().getKey(this.uuid);
        Intrinsics.checkNotNull((Object)n);
        return n;
    }

    @Override
    public void build(@NotNull FlowLayout $this$build) {
        Intrinsics.checkNotNullParameter((Object)$this$build, (String)"<this>");
        Sizing sizing = Sizing.fixed((int)250);
        Intrinsics.checkNotNullExpressionValue((Object)sizing, (String)"fixed(...)");
        MiscExt.void($this$build.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.verticalScroll(sizing, (Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> NodeEditor.build$lambda$0(this, arg_0)))));
    }

    private static final Unit build$lambda$0(NodeEditor this$0, FlowLayout $this$verticalScroll) {
        Intrinsics.checkNotNullParameter((Object)$this$verticalScroll, (String)"$this$verticalScroll");
        $this$verticalScroll.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.horizontal((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> NodeEditor.build$lambda$0$0(this$0, arg_0))));
        OwoDSLKt.spacer($this$verticalScroll, 1, 15);
        $this$verticalScroll.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.horizontal((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> NodeEditor.build$lambda$0$1(this$0, arg_0))));
        OwoDSLKt.spacer($this$verticalScroll, 1, 15);
        $this$verticalScroll.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.horizontal((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> NodeEditor.build$lambda$0$2(this$0, arg_0))));
        OwoDSLKt.spacer($this$verticalScroll, 1, 15);
        $this$verticalScroll.child(this$0.getNode().createUI());
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit build$lambda$0$0(NodeEditor this$0, FlowLayout $this$horizontal) {
        void $this$plus$iv;
        void $this$with$iv$iv$iv;
        void $this$bold$iv$iv;
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        Component $this$bold$iv = this$0.getNode().getType().getName();
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
        String $this$bold$iv2 = " Node Editor";
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
        OwoDSLKt.space($this$horizontal, 3);
        this$0.redButton($this$horizontal, "x", (Function0<Unit>)((Function0)() -> NodeEditor.build$lambda$0$0$0(this$0)));
        return Unit.INSTANCE;
    }

    private static final Unit build$lambda$0$0$0(NodeEditor this$0) {
        this$0.remove();
        return Unit.INSTANCE;
    }

    private static final Unit build$lambda$0$1(NodeEditor this$0, FlowLayout $this$horizontal) {
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        this$0.yellowButton($this$horizontal, "Duplicate", (Function0<Unit>)((Function0)() -> NodeEditor.build$lambda$0$1$0(this$0)));
        OwoDSLKt.space$default($this$horizontal, 0, 1, null);
        this$0.redButton($this$horizontal, "Delete", (Function0<Unit>)((Function0)() -> NodeEditor.build$lambda$0$1$1(this$0)));
        return Unit.INSTANCE;
    }

    private static final Unit build$lambda$0$1$0(NodeEditor this$0) {
        CutsceneNode copy = (CutsceneNode)this$0.getNode().copy();
        CutsceneTrack<?> cutsceneTrack = this$0.track;
        Intrinsics.checkNotNull(cutsceneTrack, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.cutscene.CutsceneTrack<net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNode>");
        UUID id = cutsceneTrack.append(copy);
        TrackEditor trackEditor = EditorContext.INSTANCE.getTrackEditors().get(this$0.getTrackId());
        if (trackEditor != null) {
            trackEditor.refreshNodes();
        }
        EditorContext.INSTANCE.getUi().createNodeWindow(id, this$0.track);
        return Unit.INSTANCE;
    }

    private static final Unit build$lambda$0$1$1(NodeEditor this$0) {
        this$0.track.getNodes().remove(this$0.uuid);
        this$0.track.getTimeline().remove((Object)this$0.getTime());
        Object object = EditorContext.INSTANCE.getTrackEditors().get(this$0.getTrackId());
        if (object != null && (object = object.getNodes()) != null && (object = (FlowLayout)object.remove(this$0.uuid)) != null) {
            object.remove();
        }
        this$0.remove();
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit build$lambda$0$2(NodeEditor this$0, FlowLayout $this$horizontal) {
        void $this$build_u24lambda_u240_u242_u240;
        IntBox intBox;
        void $this$with$iv$iv$iv;
        void $this$gold$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        String $this$gold$iv = "Time";
        boolean $i$f$getGold22 = false;
        String $this$c$iv$iv = $this$gold$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getGold = false;
        void var6_8 = $this$gold$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.GOLD;
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
        OwoDSLKt.text($this$horizontal, (Component)mutableComponent3);
        OwoDSLKt.spacer($this$horizontal, 3, 1);
        Sizing sizing = Sizing.fixed((int)80);
        Intrinsics.checkNotNullExpressionValue((Object)sizing, (String)"fixed(...)");
        IntBox $i$f$getGold22 = intBox = new IntBox(sizing, null, null, 6, null);
        FlowLayout flowLayout = $this$horizontal;
        boolean bl = false;
        $this$build_u24lambda_u240_u242_u240.setNumValue(this$0.getTime());
        $this$build_u24lambda_u240_u242_u240.setChangeCallback(arg_0 -> NodeEditor.build$lambda$0$2$0$0(this$0, arg_0));
        flowLayout.child((io.wispforest.owo.ui.core.Component)intBox);
        return Unit.INSTANCE;
    }

    private static final Unit build$lambda$0$2$0$0(NodeEditor this$0, int it) {
        block0: {
            this$0.track.getTimeline().remove((Object)this$0.getTime());
            this$0.track.getTimeline().set(it, this$0.uuid);
            TrackEditor trackEditor = EditorContext.INSTANCE.getTrackEditors().get(this$0.getTrackId());
            if (trackEditor == null) break block0;
            trackEditor.refreshNodes();
        }
        return Unit.INSTANCE;
    }
}

