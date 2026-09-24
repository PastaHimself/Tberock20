/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.client.cutscene;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.client.cutscene.EditorContext;
import net.thebrokenscript.brokencore.api.client.event.RenderEvents;
import net.thebrokenscript.brokencore.api.cutscene.Cutscene;
import net.thebrokenscript.brokencore.api.cutscene.CutsceneTrack;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNode;
import net.thebrokenscript.brokencore.api.event.GameEvent;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.impl.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@SideOnly(side=Side.CLIENT)
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene/EditorRenderer;", "", "<init>", "()V", "brokencore-common"})
public final class EditorRenderer {
    @NotNull
    public static final EditorRenderer INSTANCE = new EditorRenderer();

    private EditorRenderer() {
    }

    private static final Unit _init_$lambda$0(RenderEvents.LevelStageData $this$on) {
        Intrinsics.checkNotNullParameter((Object)$this$on, (String)"$this$on");
        Cutscene cutscene = EditorContext.INSTANCE.getActiveCutscene();
        if (cutscene == null) {
            return Unit.INSTANCE;
        }
        Cutscene cur = cutscene;
        if (cur.getPlaying()) {
            return Unit.INSTANCE;
        }
        for (CutsceneTrack<?> track : cur.getTracks()) {
            for (CutsceneNode node : track.getNodes().values()) {
                node.renderPreview($this$on);
            }
        }
        return Unit.INSTANCE;
    }

    static {
        GameEvent.Companion.on(RenderEvents.LEVEL_STAGE, EditorRenderer::_init_$lambda$0);
    }
}

