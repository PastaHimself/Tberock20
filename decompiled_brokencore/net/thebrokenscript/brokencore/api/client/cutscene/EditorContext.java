/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.client.cutscene;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.CutsceneEditorScreen;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.windows.CutsceneEditor;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.windows.InactiveEditor;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.windows.NodeEditor;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.windows.TrackEditor;
import net.thebrokenscript.brokencore.api.cutscene.Cutscene;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010$\u001a\u00020%R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001d\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\"0\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010 \u00a8\u0006&"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene/EditorContext;", "", "<init>", "()V", "ui", "Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/CutsceneEditorScreen;", "getUi", "()Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/CutsceneEditorScreen;", "ui$delegate", "Lkotlin/Lazy;", "inactive", "Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/InactiveEditor;", "getInactive", "()Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/InactiveEditor;", "inactive$delegate", "activeCutscene", "Lnet/thebrokenscript/brokencore/api/cutscene/Cutscene;", "getActiveCutscene", "()Lnet/thebrokenscript/brokencore/api/cutscene/Cutscene;", "setActiveCutscene", "(Lnet/thebrokenscript/brokencore/api/cutscene/Cutscene;)V", "cutsceneEditor", "Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/CutsceneEditor;", "getCutsceneEditor", "()Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/CutsceneEditor;", "setCutsceneEditor", "(Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/CutsceneEditor;)V", "trackEditors", "", "Ljava/util/UUID;", "Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/TrackEditor;", "getTrackEditors", "()Ljava/util/Map;", "nodeEditors", "Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/NodeEditor;", "getNodeEditors", "reset", "", "brokencore-common"})
public final class EditorContext {
    @NotNull
    public static final EditorContext INSTANCE = new EditorContext();
    @NotNull
    private static final Lazy ui$delegate = LazyKt.lazy(EditorContext::ui_delegate$lambda$0);
    @NotNull
    private static final Lazy inactive$delegate = LazyKt.lazy(EditorContext::inactive_delegate$lambda$0);
    @Nullable
    private static Cutscene activeCutscene;
    @Nullable
    private static CutsceneEditor cutsceneEditor;
    @NotNull
    private static final Map<UUID, TrackEditor> trackEditors;
    @NotNull
    private static final Map<UUID, NodeEditor> nodeEditors;

    private EditorContext() {
    }

    @NotNull
    public final CutsceneEditorScreen getUi() {
        Lazy lazy = ui$delegate;
        return (CutsceneEditorScreen)((Object)lazy.getValue());
    }

    @NotNull
    public final InactiveEditor getInactive() {
        Lazy lazy = inactive$delegate;
        return (InactiveEditor)((Object)lazy.getValue());
    }

    @Nullable
    public final Cutscene getActiveCutscene() {
        return activeCutscene;
    }

    public final void setActiveCutscene(@Nullable Cutscene cutscene) {
        activeCutscene = cutscene;
    }

    @Nullable
    public final CutsceneEditor getCutsceneEditor() {
        return cutsceneEditor;
    }

    public final void setCutsceneEditor(@Nullable CutsceneEditor cutsceneEditor) {
        EditorContext.cutsceneEditor = cutsceneEditor;
    }

    @NotNull
    public final Map<UUID, TrackEditor> getTrackEditors() {
        return trackEditors;
    }

    @NotNull
    public final Map<UUID, NodeEditor> getNodeEditors() {
        return nodeEditors;
    }

    public final void reset() {
        activeCutscene = null;
        cutsceneEditor = null;
        trackEditors.clear();
        nodeEditors.clear();
    }

    private static final CutsceneEditorScreen ui_delegate$lambda$0() {
        return new CutsceneEditorScreen();
    }

    private static final InactiveEditor inactive_delegate$lambda$0() {
        return new InactiveEditor();
    }

    static {
        trackEditors = new LinkedHashMap();
        nodeEditors = new LinkedHashMap();
    }
}

