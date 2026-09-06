/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.owo.ui.container.FlowLayout
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.cutscene.editor.windows;

import io.wispforest.owo.ui.container.FlowLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.thebrokenscript.brokencore.api.client.cutscene.CutsceneHandler;
import net.thebrokenscript.brokencore.api.client.cutscene.EditorContext;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.util.OwoDSLKt;
import net.thebrokenscript.brokencore.api.client.cutscene.editor.windows.EditorWindow;
import net.thebrokenscript.brokencore.api.cutscene.Cutscene;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.EndecExt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/InactiveEditor;", "Lnet/thebrokenscript/brokencore/api/client/cutscene/editor/windows/EditorWindow;", "<init>", "()V", "build", "", "Lio/wispforest/owo/ui/container/FlowLayout;", "brokencore-common"})
public final class InactiveEditor
extends EditorWindow {
    @Override
    public void build(@NotNull FlowLayout $this$build) {
        Intrinsics.checkNotNullParameter((Object)$this$build, (String)"<this>");
        OwoDSLKt.text($this$build, "Uh oh! No active cutscene!");
        OwoDSLKt.spacer($this$build, 1, 15);
        this.greenButton($this$build, "+ Create", (Function0<Unit>)((Function0)() -> InactiveEditor.build$lambda$0(this)));
        OwoDSLKt.space$default($this$build, 0, 1, null);
        this.yellowButton($this$build, "Import", (Function0<Unit>)((Function0)() -> InactiveEditor.build$lambda$1(this)));
    }

    private static final Unit build$lambda$0(InactiveEditor this$0) {
        Cutscene cutscene = new Cutscene(null, null, 3, null);
        EditorContext.INSTANCE.reset();
        EditorContext.INSTANCE.setActiveCutscene(cutscene);
        CutsceneHandler.INSTANCE.getLoaded().putIfAbsent(cutscene.getUuid(), cutscene);
        EditorContext.INSTANCE.getUi().createEditorWindow(cutscene);
        this$0.remove();
        return Unit.INSTANCE;
    }

    private static final Unit build$lambda$1(InactiveEditor this$0) {
        String data2 = ClientDSLKt.getMC().keyboardHandler.getClipboard();
        Intrinsics.checkNotNull((Object)data2);
        if (((CharSequence)data2).length() == 0 || StringsKt.isBlank((CharSequence)data2)) {
            System.out.println((Object)"Clipboard is empty!");
            return Unit.INSTANCE;
        }
        Cutscene cutscene = EndecExt.INSTANCE.tryDecodeJsonString(Cutscene.Companion.getENDEC(), data2);
        if (cutscene == null) {
            return Unit.INSTANCE;
        }
        EditorContext.INSTANCE.reset();
        EditorContext.INSTANCE.setActiveCutscene(cutscene);
        CutsceneHandler.INSTANCE.getLoaded().putIfAbsent(cutscene.getUuid(), cutscene);
        EditorContext.INSTANCE.getUi().createEditorWindow(cutscene);
        this$0.remove();
        return Unit.INSTANCE;
    }
}

