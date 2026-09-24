/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  io.wispforest.owo.ui.component.ButtonComponent
 *  io.wispforest.owo.ui.component.Components
 *  io.wispforest.owo.ui.component.DropdownComponent
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
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.cutscene.editor.windows;

import com.google.gson.Gson;
import io.wispforest.owo.ui.component.ButtonComponent;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.component.DropdownComponent;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.Sizing;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
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
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.cutscene.CutsceneHandler;
import net.thebrokenscript.brokencore.api.client.cutscene.EditorContext;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.util.Flows;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.util.OwoDSLKt;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.windows.EditorWindow;
import net.thebrokenscript.brokencore.api.cutscene.Cutscene;
import net.thebrokenscript.brokencore.api.cutscene.CutsceneTrack;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNodeType;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNodes;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.EndecExt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u000f\u001a\u00020\u0010*\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u0010*\u00020\u000b2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/CutsceneEditor;", "Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/EditorWindow;", "cutscene", "Lnet/thebrokenscript/brokencore/api/cutscene/Cutscene;", "<init>", "(Lnet/thebrokenscript/brokencore/api/cutscene/Cutscene;)V", "getCutscene", "()Lnet/thebrokenscript/brokencore/api/cutscene/Cutscene;", "tracks", "", "Ljava/util/UUID;", "Lio/wispforest/owo/ui/container/FlowLayout;", "getTracks", "()Ljava/util/Map;", "container", "build", "", "createTrackUI", "track", "Lnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrack;", "refreshTracks", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nCutsceneEditor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CutsceneEditor.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/CutsceneEditor\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,121:1\n77#2:122\n15#2:123\n54#2:124\n29#2:125\n24#2:126\n70#2:129\n15#2:130\n47#2:131\n29#2:132\n24#2:133\n52#2:134\n29#2:135\n24#2:136\n75#2:137\n15#2:138\n52#2:139\n29#2:140\n24#2:141\n1869#3,2:127\n*S KotlinDebug\n*F\n+ 1 CutsceneEditor.kt\nnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/CutsceneEditor\n*L\n28#1:122\n28#1:123\n28#1:124\n28#1:125\n28#1:126\n64#1:129\n64#1:130\n64#1:131\n64#1:132\n64#1:133\n95#1:134\n95#1:135\n95#1:136\n101#1:137\n101#1:138\n101#1:139\n101#1:140\n101#1:141\n113#1:127,2\n*E\n"})
public final class CutsceneEditor
extends EditorWindow {
    @NotNull
    private final Cutscene cutscene;
    @NotNull
    private final Map<UUID, FlowLayout> tracks;
    private FlowLayout container;

    public CutsceneEditor(@NotNull Cutscene cutscene) {
        Intrinsics.checkNotNullParameter((Object)cutscene, (String)"cutscene");
        this.cutscene = cutscene;
        this.tracks = new LinkedHashMap();
    }

    @NotNull
    public final Cutscene getCutscene() {
        return this.cutscene;
    }

    @NotNull
    public final Map<UUID, FlowLayout> getTracks() {
        return this.tracks;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void build(@NotNull FlowLayout $this$build) {
        void $this$with$iv$iv$iv;
        void $this$bold$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$build, (String)"<this>");
        this.container = $this$build;
        String $this$bold$iv = "Cutscene Editor";
        boolean $i$f$getBold = false;
        String $this$c$iv$iv = $this$bold$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getBold2 = false;
        void var6_7 = $this$bold$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.BOLD;
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
        OwoDSLKt.text($this$build, (Component)mutableComponent3);
        OwoDSLKt.spacer($this$build, 1, 15);
        $this$build.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.horizontal((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> CutsceneEditor.build$lambda$0(this, arg_0))));
        OwoDSLKt.spacer($this$build, 1, 15);
        $this$build.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.horizontal((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> CutsceneEditor.build$lambda$1(this, arg_0))));
        OwoDSLKt.spacer($this$build, 1, 15);
        $this$build.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.horizontal((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> CutsceneEditor.build$lambda$2(this, $this$build, arg_0))));
        OwoDSLKt.spacer($this$build, 1, 10);
        for (CutsceneTrack<?> track : this.cutscene.getTracks()) {
            this.createTrackUI($this$build, track);
        }
        if (this.cutscene.getTracks().isEmpty()) {
            OwoDSLKt.text($this$build, "No animation tracks");
        }
    }

    private final void createTrackUI(FlowLayout $this$createTrackUI, CutsceneTrack<?> track) {
        FlowLayout ui = Flows.INSTANCE.vertical((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> CutsceneEditor.createTrackUI$lambda$0(track, this, arg_0)));
        this.tracks.put(track.getUuid(), ui);
        $this$createTrackUI.child((io.wispforest.owo.ui.core.Component)ui);
    }

    public final void refreshTracks() {
        Iterable $this$forEach$iv = this.tracks.values();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            FlowLayout it = (FlowLayout)element$iv;
            boolean bl = false;
            it.remove();
        }
        this.tracks.clear();
        for (CutsceneTrack<?> uuid : this.cutscene.getTracks()) {
            FlowLayout flowLayout = this.container;
            if (flowLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException((String)"container");
                flowLayout = null;
            }
            this.createTrackUI(flowLayout, uuid);
        }
    }

    private static final Unit build$lambda$0(CutsceneEditor this$0, FlowLayout $this$horizontal) {
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        this$0.greenButton($this$horizontal, "Play", (Function0<Unit>)((Function0)new Function0<Unit>((Object)this$0.cutscene){

            public final void invoke() {
                ((Cutscene)this.receiver).play();
            }
        }));
        OwoDSLKt.space$default($this$horizontal, 0, 1, null);
        this$0.yellowButton($this$horizontal, "Pause", (Function0<Unit>)((Function0)new Function0<Unit>((Object)this$0.cutscene){

            public final void invoke() {
                ((Cutscene)this.receiver).pause();
            }
        }));
        OwoDSLKt.space$default($this$horizontal, 0, 1, null);
        this$0.redButton($this$horizontal, "Stop", (Function0<Unit>)((Function0)new Function0<Unit>((Object)this$0.cutscene){

            public final void invoke() {
                ((Cutscene)this.receiver).stop();
            }
        }));
        return Unit.INSTANCE;
    }

    private static final Unit build$lambda$1(CutsceneEditor this$0, FlowLayout $this$horizontal) {
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        this$0.greenButton($this$horizontal, "Export", (Function0<Unit>)((Function0)() -> CutsceneEditor.build$lambda$1$0(this$0)));
        OwoDSLKt.space$default($this$horizontal, 0, 1, null);
        this$0.redButton($this$horizontal, "Delete", (Function0<Unit>)((Function0)() -> CutsceneEditor.build$lambda$1$1(this$0)));
        return Unit.INSTANCE;
    }

    private static final Unit build$lambda$1$0(CutsceneEditor this$0) {
        String json = new Gson().toJson(EndecExt.INSTANCE.tryEncodeJson(Cutscene.Companion.getENDEC(), this$0.cutscene));
        ClientDSLKt.getMC().keyboardHandler.setClipboard(json);
        return Unit.INSTANCE;
    }

    private static final Unit build$lambda$1$1(CutsceneEditor this$0) {
        EditorContext.INSTANCE.reset();
        CutsceneHandler.INSTANCE.getLoaded().remove(this$0.cutscene.getUuid());
        EditorContext.INSTANCE.getUi().setInactive();
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit build$lambda$2(CutsceneEditor this$0, FlowLayout $this_build, FlowLayout $this$horizontal) {
        void $this$with$iv$iv$iv;
        void $this$green$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        DropdownComponent dropdown = Components.dropdown((Sizing)Sizing.fixed((int)80));
        String $this$green$iv = "+ Add Track";
        boolean $i$f$getGreen = false;
        String $this$c$iv$iv = $this$green$iv;
        boolean $i$f$getC = false;
        Component component = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component;
        boolean $i$f$getGreen2 = false;
        void var8_8 = $this$green$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.GREEN;
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
        dropdown.text((Component)mutableComponent3);
        Iterator<Map.Entry<ResourceLocation, CutsceneNodeType<?>>> iterator = CutsceneNodes.TYPES.entrySet().iterator();
        while (iterator.hasNext()) {
            CutsceneNodeType<?> ty = iterator.next().getValue();
            dropdown.button(ty.getName(), arg_0 -> CutsceneEditor.build$lambda$2$0(ty, this$0, $this_build, arg_0));
        }
        $this$horizontal.child((io.wispforest.owo.ui.core.Component)dropdown);
        return Unit.INSTANCE;
    }

    private static final void build$lambda$2$0(CutsceneNodeType $ty, CutsceneEditor this$0, FlowLayout $this_build, DropdownComponent it) {
        UUID uUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"randomUUID(...)");
        CutsceneTrack track = new CutsceneTrack(uUID, $ty, null, null, 12, null);
        this$0.cutscene.getTracks().add(track);
        EditorContext.INSTANCE.getUi().createTrackWindow(track);
        this$0.createTrackUI($this_build, track);
    }

    private static final Unit createTrackUI$lambda$0(CutsceneTrack $track, CutsceneEditor this$0, FlowLayout $this$vertical) {
        Intrinsics.checkNotNullParameter((Object)$this$vertical, (String)"$this$vertical");
        OwoDSLKt.spacer($this$vertical, 1, 5);
        $this$vertical.child((io.wispforest.owo.ui.core.Component)Flows.INSTANCE.horizontal((Function1<? super FlowLayout, Unit>)((Function1)arg_0 -> CutsceneEditor.createTrackUI$lambda$0$0($track, this$0, $this$vertical, arg_0))));
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit createTrackUI$lambda$0$0(CutsceneTrack $track, CutsceneEditor this$0, FlowLayout $this_vertical, FlowLayout $this$horizontal) {
        void $this$with$iv$iv$iv;
        void $this$white$iv$iv;
        void $this$with$iv$iv;
        Intrinsics.checkNotNullParameter((Object)$this$horizontal, (String)"$this$horizontal");
        Object $this$white$iv = $track.getType().getName();
        boolean $i$f$getWhite = false;
        Component component = $this$white$iv;
        ChatFormatting other$iv$iv = ChatFormatting.WHITE;
        boolean $i$f$with22 = false;
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
        OwoDSLKt.colored(OwoDSLKt.button($this$horizontal, (Component)mutableComponent3, (Function1<? super ButtonComponent, Unit>)((Function1)arg_0 -> CutsceneEditor.createTrackUI$lambda$0$0$0($track, arg_0))), 0xFF004444L, 0xFF006666L, 0xFF002222L);
        OwoDSLKt.space($this$horizontal, 3);
        $this$white$iv = "x";
        $i$f$getWhite = false;
        Object $this$c$iv$iv = $this$white$iv;
        boolean $i$f$getC = false;
        Component component2 = Component.nullToEmpty((String)$this$c$iv$iv);
        Intrinsics.checkNotNullExpressionValue((Object)component2, (String)"nullToEmpty(...)");
        $this$c$iv$iv = component2;
        boolean $i$f$getWhite2 = false;
        void $i$f$with22 = $this$white$iv$iv;
        ChatFormatting other$iv$iv$iv = ChatFormatting.WHITE;
        boolean $i$f$with = false;
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
        OwoDSLKt.colored(OwoDSLKt.button($this$horizontal, (Component)mutableComponent6, (Function1<? super ButtonComponent, Unit>)((Function1)arg_0 -> CutsceneEditor.createTrackUI$lambda$0$0$1(this$0, $track, $this_vertical, arg_0))), 0xFF880000L, 0xFFAA0000L, 0xFF220000L);
        return Unit.INSTANCE;
    }

    private static final Unit createTrackUI$lambda$0$0$0(CutsceneTrack $track, ButtonComponent $this$button) {
        Intrinsics.checkNotNullParameter((Object)$this$button, (String)"$this$button");
        EditorContext.INSTANCE.getUi().createTrackWindow($track);
        return Unit.INSTANCE;
    }

    private static final Unit createTrackUI$lambda$0$0$1(CutsceneEditor this$0, CutsceneTrack $track, FlowLayout $this_vertical, ButtonComponent $this$button) {
        Intrinsics.checkNotNullParameter((Object)$this$button, (String)"$this$button");
        this$0.cutscene.getTracks().remove($track);
        $this_vertical.remove();
        return Unit.INSTANCE;
    }
}

