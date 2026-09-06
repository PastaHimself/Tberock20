/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.owo.ui.base.BaseOwoScreen
 *  io.wispforest.owo.ui.container.Containers
 *  io.wispforest.owo.ui.container.FlowLayout
 *  io.wispforest.owo.ui.core.Component
 *  io.wispforest.owo.ui.core.OwoUIAdapter
 *  io.wispforest.owo.ui.core.Surface
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.screens.Screen
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.cutscene.editor;

import io.wispforest.owo.ui.base.BaseOwoScreen;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.Component;
import io.wispforest.owo.ui.core.OwoUIAdapter;
import io.wispforest.owo.ui.core.Surface;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.screens.Screen;
import net.thebrokenscript.brokencore.api.client.cutscene.EditorContext;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.windows.CutsceneEditor;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.windows.NodeEditor;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.windows.TrackEditor;
import net.thebrokenscript.brokencore.api.cutscene.Cutscene;
import net.thebrokenscript.brokencore.api.cutscene.CutsceneTrack;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011J\u0012\u0010\u0012\u001a\u00020\f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\fJ\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/CutsceneEditorScreen;", "Lio/wispforest/owo/ui/base/BaseOwoScreen;", "Lio/wispforest/owo/ui/container/FlowLayout;", "<init>", "()V", "value", "root", "getRoot", "()Lio/wispforest/owo/ui/container/FlowLayout;", "createAdapter", "Lio/wispforest/owo/ui/core/OwoUIAdapter;", "build", "", "createNodeWindow", "node", "Ljava/util/UUID;", "track", "Lnet/thebrokenscript/brokencore/api/cutscene/CutsceneTrack;", "createTrackWindow", "createEditorWindow", "cutscene", "Lnet/thebrokenscript/brokencore/api/cutscene/Cutscene;", "setInactive", "isPauseScreen", "", "brokencore-common"})
public final class CutsceneEditorScreen
extends BaseOwoScreen<FlowLayout> {
    private FlowLayout root;

    @NotNull
    public final FlowLayout getRoot() {
        FlowLayout flowLayout = this.root;
        if (flowLayout != null) {
            return flowLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"root");
        return null;
    }

    @NotNull
    protected OwoUIAdapter<FlowLayout> createAdapter() {
        OwoUIAdapter owoUIAdapter = OwoUIAdapter.create((Screen)((Screen)this), Containers::verticalFlow);
        Intrinsics.checkNotNullExpressionValue((Object)owoUIAdapter, (String)"create(...)");
        return owoUIAdapter;
    }

    protected void build(@NotNull FlowLayout root) {
        Intrinsics.checkNotNullParameter((Object)root, (String)"root");
        this.root = root;
        root.surface(Surface.flat((int)0));
        root.child((Component)EditorContext.INSTANCE.getInactive());
    }

    public final void createNodeWindow(@NotNull UUID node, @NotNull CutsceneTrack<?> track) {
        Intrinsics.checkNotNullParameter((Object)node, (String)"node");
        Intrinsics.checkNotNullParameter(track, (String)"track");
        NodeEditor nodeEditor = EditorContext.INSTANCE.getNodeEditors().computeIfAbsent(node, arg_0 -> CutsceneEditorScreen.createNodeWindow$lambda$1(arg_0 -> CutsceneEditorScreen.createNodeWindow$lambda$0(track, arg_0), arg_0));
        Intrinsics.checkNotNullExpressionValue((Object)((Object)nodeEditor), (String)"computeIfAbsent(...)");
        NodeEditor window = nodeEditor;
        if (!window.hasParent()) {
            this.getRoot().child((Component)window);
        }
    }

    public final void createTrackWindow(@NotNull CutsceneTrack<?> track) {
        Intrinsics.checkNotNullParameter(track, (String)"track");
        TrackEditor trackEditor = EditorContext.INSTANCE.getTrackEditors().computeIfAbsent(track.getUuid(), arg_0 -> CutsceneEditorScreen.createTrackWindow$lambda$1(arg_0 -> CutsceneEditorScreen.createTrackWindow$lambda$0(track, arg_0), arg_0));
        Intrinsics.checkNotNullExpressionValue((Object)((Object)trackEditor), (String)"computeIfAbsent(...)");
        TrackEditor window = trackEditor;
        if (!window.hasParent()) {
            this.getRoot().child((Component)window);
        }
    }

    public final void createEditorWindow(@NotNull Cutscene cutscene) {
        Intrinsics.checkNotNullParameter((Object)cutscene, (String)"cutscene");
        CutsceneEditor window = new CutsceneEditor(cutscene);
        EditorContext.INSTANCE.setCutsceneEditor(window);
        this.getRoot().child((Component)window);
    }

    public final void setInactive() {
        this.getRoot().clearChildren();
        this.getRoot().child((Component)EditorContext.INSTANCE.getInactive());
        EditorContext.INSTANCE.reset();
    }

    public boolean isPauseScreen() {
        return false;
    }

    private static final NodeEditor createNodeWindow$lambda$0(CutsceneTrack $track, UUID it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new NodeEditor(it, $track);
    }

    private static final NodeEditor createNodeWindow$lambda$1(Function1 $tmp0, Object p0) {
        return (NodeEditor)((Object)$tmp0.invoke(p0));
    }

    private static final TrackEditor createTrackWindow$lambda$0(CutsceneTrack $track, UUID it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new TrackEditor($track);
    }

    private static final TrackEditor createTrackWindow$lambda$1(Function1 $tmp0, Object p0) {
        return (TrackEditor)((Object)$tmp0.invoke(p0));
    }
}

