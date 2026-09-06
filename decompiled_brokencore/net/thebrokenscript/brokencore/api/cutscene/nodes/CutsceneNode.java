/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.wispforest.owo.ui.core.Component
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.cutscene.nodes;

import io.wispforest.owo.ui.core.Component;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.thebrokenscript.brokencore.api.client.event.RenderEvents;
import net.thebrokenscript.brokencore.api.cutscene.nodes.CutsceneNodeType;
import net.thebrokenscript.brokencore.api.util.Clone;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.api.util.serde.Tagged;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH'J\b\u0010\u000f\u001a\u00020\u0010H'J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H'J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H'J\b\u0010\u0015\u001a\u00020\u0010H'J\b\u0010\u0016\u001a\u00020\u0010H\u0017J\b\u0010\u0017\u001a\u00020\u0010H\u0017R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0018"}, d2={"Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNode;", "Lnet/thebrokenscript/brokencore/api/util/serde/Tagged;", "Lnet/thebrokenscript/brokencore/api/util/Clone;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "type", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodeType;", "getType", "()Lnet/thebrokenscript/brokencore/api/cutscene/nodes/CutsceneNodeType;", "createUI", "Lio/wispforest/owo/ui/core/Component;", "liveUpdate", "", "render", "event", "Lnet/thebrokenscript/brokencore/api/client/event/RenderEvents$LevelStageData;", "renderPreview", "applyEffects", "setup", "cleanup", "brokencore-common"})
public abstract class CutsceneNode
implements Tagged,
Clone<CutsceneNode> {
    @Override
    @NotNull
    public String getTag() {
        String string = this.getType().getId().toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        return string;
    }

    @NotNull
    public abstract CutsceneNodeType<?> getType();

    @SideOnly(side=Side.CLIENT)
    @NotNull
    public abstract Component createUI();

    @SideOnly(side=Side.CLIENT)
    public abstract void liveUpdate();

    @SideOnly(side=Side.CLIENT)
    public abstract void render(@NotNull RenderEvents.LevelStageData var1);

    @SideOnly(side=Side.CLIENT)
    public abstract void renderPreview(@NotNull RenderEvents.LevelStageData var1);

    @SideOnly(side=Side.CLIENT)
    public abstract void applyEffects();

    @SideOnly(side=Side.CLIENT)
    public void setup() {
    }

    @SideOnly(side=Side.CLIENT)
    public void cleanup() {
    }
}

