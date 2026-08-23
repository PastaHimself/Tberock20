/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.RangesKt
 *  kotlinx.serialization.json.JsonArray
 *  kotlinx.serialization.json.JsonArrayBuilder
 *  kotlinx.serialization.json.JsonElement
 *  kotlinx.serialization.json.JsonElementKt
 *  net.minecraft.client.Camera
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.resources.ResourceLocation
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector2f
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.timeline;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import net.minecraft.client.Camera;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.CutsceneEditorConstants;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.CutsceneEditorScreen;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.timeline.CutsceneEditorKeyframe;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.timeline.CutsceneEditorTimeline;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractButton;
import net.thebrokenscript.brokencore.api.client.gui.button.TextPanelButton;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.RangeExtKt;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 62\u00020\u0001:\u00016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0013J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\nJ \u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0013H\u0016J \u0010%\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0013H\u0016J8\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u0013H\u0016J\u000e\u00103\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u00104\u001a\u000205R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010'\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00138V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00067"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimelineTrack;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractButton;", "timeline", "Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimeline;", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimeline;)V", "getTimeline", "()Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimeline;", "keyframes", "", "Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorKeyframe;", "shiftPressed", "", "ctrlPressed", "canMove", "tickRange", "Lkotlin/ranges/IntRange;", "getKeyframeAt", "tick", "", "canMoveTo", "keyframe", "time", "length", "isMouseOver", "mouseX", "", "mouseY", "", "addKeyframeButton", "Lnet/thebrokenscript/brokencore/api/client/gui/button/TextPanelButton;", "removeKeyframe", "", "keyPressed", "keyCode", "scanCode", "modifiers", "keyReleased", "v", "h", "getH", "()I", "setH", "(I)V", "render", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "partialTick", "", "globalX", "globalY", "updateKeyframePosition", "toJson", "Lkotlinx/serialization/json/JsonArray;", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nCutsceneEditorTimelineTrack.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CutsceneEditorTimelineTrack.kt\nnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimelineTrack\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 JsonElementBuilders.kt\nkotlinx/serialization/json/JsonElementBuildersKt\n*L\n1#1,198:1\n1869#2,2:199\n1869#2,2:201\n1869#2,2:203\n1869#2,2:205\n1869#2,2:207\n52#3,3:209\n*S KotlinDebug\n*F\n+ 1 CutsceneEditorTimelineTrack.kt\nnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimelineTrack\n*L\n22#1:199,2\n31#1:201,2\n40#1:203,2\n59#1:205,2\n127#1:207,2\n183#1:209,3\n*E\n"})
public final class CutsceneEditorTimelineTrack
extends AbstractButton {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final CutsceneEditorTimeline timeline;
    @NotNull
    private final List<CutsceneEditorKeyframe> keyframes;
    private boolean shiftPressed;
    private boolean ctrlPressed;
    @NotNull
    private final TextPanelButton addKeyframeButton;
    @NotNull
    private static final ResourceLocation BACKGROUND = BrokenCore.id("cutscene_editor/timeline_background");

    public CutsceneEditorTimelineTrack(@NotNull CutsceneEditorTimeline timeline) {
        Intrinsics.checkNotNullParameter((Object)timeline, (String)"timeline");
        super((Function0<Unit>)((Function0)CutsceneEditorTimelineTrack::_init_$lambda$0));
        this.timeline = timeline;
        this.keyframes = new ArrayList();
        this.setCallback((Function0<Unit>)((Function0)() -> CutsceneEditorTimelineTrack._init_$lambda$1(this)));
        this.addKeyframeButton = (TextPanelButton)this.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.getTEXT_PANEL_SETTINGS().create("+", (Function0<Unit>)((Function0)() -> CutsceneEditorTimelineTrack.addKeyframeButton$lambda$0(this))));
    }

    @NotNull
    public final CutsceneEditorTimeline getTimeline() {
        return this.timeline;
    }

    public final boolean canMove(@NotNull IntRange tickRange) {
        Intrinsics.checkNotNullParameter((Object)tickRange, (String)"tickRange");
        IntRange other = new IntRange(0, this.timeline.getCutsceneLength());
        Iterable $this$forEach$iv = this.keyframes;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            CutsceneEditorKeyframe it = (CutsceneEditorKeyframe)element$iv;
            boolean bl = false;
            if (Intrinsics.areEqual((Object)tickRange, (Object)it.getTickRange()) || RangeExtKt.contains(other, tickRange) && !RangeExtKt.contains(it.getTickRange(), tickRange)) continue;
            return false;
        }
        return true;
    }

    @Nullable
    public final CutsceneEditorKeyframe getKeyframeAt(int tick) {
        Iterable $this$forEach$iv = this.keyframes;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            CutsceneEditorKeyframe it = (CutsceneEditorKeyframe)element$iv;
            boolean bl = false;
            IntRange intRange = it.getTickRange();
            int n = intRange.getFirst();
            boolean bl2 = tick <= intRange.getLast() ? n <= tick : false;
            if (!bl2) continue;
            return it;
        }
        return null;
    }

    public final boolean canMoveTo(@NotNull CutsceneEditorKeyframe keyframe, int time2, int length) {
        Intrinsics.checkNotNullParameter((Object)keyframe, (String)"keyframe");
        IntRange tickRange = RangesKt.until((int)time2, (int)(time2 + length));
        Iterable $this$forEach$iv = this.keyframes;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            IntRange other;
            CutsceneEditorKeyframe it = (CutsceneEditorKeyframe)element$iv;
            boolean bl = false;
            if (keyframe == it || !RangeExtKt.contains(other = new IntRange(it.getTickRange().getFirst() - 1, it.getTickRange().getLast()), tickRange)) continue;
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean canMoveTo$default(CutsceneEditorTimelineTrack cutsceneEditorTimelineTrack, CutsceneEditorKeyframe cutsceneEditorKeyframe, int n, int n2, int n3, Object object) {
        if ((n3 & 4) != 0) {
            n2 = cutsceneEditorKeyframe.getLength();
        }
        return cutsceneEditorTimelineTrack.canMoveTo(cutsceneEditorKeyframe, n, n2);
    }

    @Override
    public boolean isMouseOver(@NotNull Number mouseX, @NotNull Number mouseY) {
        Intrinsics.checkNotNullParameter((Object)mouseX, (String)"mouseX");
        Intrinsics.checkNotNullParameter((Object)mouseY, (String)"mouseY");
        Iterable $this$forEach$iv = this.keyframes;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            CutsceneEditorKeyframe it = (CutsceneEditorKeyframe)element$iv;
            boolean bl = false;
            if (!it.isMouseOver(mouseX, mouseY)) continue;
            return false;
        }
        return super.isMouseOver(mouseX, mouseY) && !this.timeline.getTimelineCursorHovered$brokencore_common();
    }

    public boolean isMouseOver(double mouseX, double mouseY) {
        return this.isMouseOver((Number)((int)mouseX), (Number)((int)mouseY));
    }

    public final void removeKeyframe(@NotNull CutsceneEditorKeyframe keyframe) {
        Intrinsics.checkNotNullParameter((Object)keyframe, (String)"keyframe");
        this.keyframes.remove(keyframe);
        this.getChildren().remove(keyframe);
    }

    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 340) {
            this.shiftPressed = true;
        }
        if (keyCode == 341) {
            this.ctrlPressed = true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 340) {
            this.shiftPressed = false;
        }
        if (keyCode == 341) {
            this.ctrlPressed = false;
        }
        return super.keyReleased(keyCode, scanCode, modifiers);
    }

    @Override
    public int getH() {
        return super.getH();
    }

    @Override
    public void setH(int v) {
        Iterable $this$forEach$iv = this.keyframes;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            CutsceneEditorKeyframe it = (CutsceneEditorKeyframe)element$iv;
            boolean bl = false;
            it.setH(v);
        }
        super.setH(v);
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, int globalX, int globalY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        CutsceneEditorConstants.INSTANCE.getCOMMON_NINE_PATCH_SCALING().render(guiGraphics, BACKGROUND, globalX, globalY, this.getZIndex(), this.getW() - this.addKeyframeButton.getW(), this.getH());
        this.addKeyframeButton.setText(this.shiftPressed && !this.ctrlPressed ? "*" : (this.ctrlPressed && !this.shiftPressed ? "#" : (this.ctrlPressed ? "-" : "+")));
        if (this.addKeyframeButton.getHovered()) {
            String hoverText = this.shiftPressed && !this.ctrlPressed ? "Set start to camera" : (this.ctrlPressed && !this.shiftPressed ? "Set end to camera" : (this.ctrlPressed ? "Remove keyframe" : "Add keyframe"));
            int w = ClientDSLKt.getMC().font.width(hoverText);
            guiGraphics.drawString(ClientDSLKt.getMC().font, hoverText, mouseX - w - 16, mouseY + (mouseY + 32 > this.timeline.getScrollContainer$brokencore_common().getH() + this.timeline.getScrollContainer$brokencore_common().getGlobalY() ? -12 : 12), -1);
        }
        this.addKeyframeButton.setX(this.getW() - this.addKeyframeButton.getW());
        this.addKeyframeButton.setH(this.getH());
    }

    public final void updateKeyframePosition(@NotNull CutsceneEditorKeyframe keyframe) {
        Intrinsics.checkNotNullParameter((Object)keyframe, (String)"keyframe");
        float timeDelta = (float)keyframe.getMinTime() / (float)this.timeline.getCutsceneLength();
        float lengthDelta = Math.min((float)keyframe.getLength() / (float)this.timeline.getCutsceneLength(), 1.0f);
        keyframe.setX((int)(timeDelta * (float)(this.getW() - this.addKeyframeButton.getW())));
        keyframe.setW((int)(lengthDelta * (float)(this.getW() - this.addKeyframeButton.getW())));
    }

    @NotNull
    public final JsonArray toJson() {
        JsonArrayBuilder builder$iv;
        boolean $i$f$buildJsonArray = false;
        JsonArrayBuilder $this$toJson_u24lambda_u240 = builder$iv = new JsonArrayBuilder();
        boolean bl = false;
        for (CutsceneEditorKeyframe keyframe : this.keyframes) {
            $this$toJson_u24lambda_u240.add((JsonElement)keyframe.toJson());
        }
        return builder$iv.build();
    }

    private static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(CutsceneEditorTimelineTrack this$0) {
        this$0.timeline.updateSelectedLayer(this$0);
        return Unit.INSTANCE;
    }

    private static final Unit addKeyframeButton$lambda$0(CutsceneEditorTimelineTrack this$0) {
        block2: {
            block4: {
                block3: {
                    block1: {
                        CutsceneEditorKeyframe keyframe = new CutsceneEditorKeyframe(this$0);
                        keyframe.setLength(1);
                        if (!this$0.canMoveTo(keyframe, this$0.timeline.getCursorTime(), 1) || this$0.shiftPressed || this$0.ctrlPressed) break block1;
                        keyframe.setTime(this$0.timeline.getCursorTime());
                        this$0.keyframes.add(keyframe);
                        this$0.addChild((GuiElement)keyframe);
                        this$0.timeline.getRoot().getInspector$brokencore_common().loadKeyframe(keyframe);
                        break block2;
                    }
                    if (!this$0.shiftPressed || !this$0.ctrlPressed) break block3;
                    CutsceneEditorKeyframe cutsceneEditorKeyframe = this$0.timeline.getRoot().getCurrentKeyframe();
                    if (cutsceneEditorKeyframe == null) break block2;
                    CutsceneEditorKeyframe it = cutsceneEditorKeyframe;
                    boolean bl = false;
                    this$0.timeline.getRoot().setCurrentKeyframe(null);
                    this$0.removeKeyframe(it);
                    break block2;
                }
                if (!this$0.ctrlPressed) break block4;
                CutsceneEditorKeyframe cutsceneEditorKeyframe = this$0.timeline.getRoot().getCurrentKeyframe();
                if (cutsceneEditorKeyframe == null) break block2;
                CutsceneEditorKeyframe it = cutsceneEditorKeyframe;
                boolean bl = false;
                CutsceneEditorScreen screen = this$0.timeline.getRoot().getScreen();
                boolean freeCam = screen.getFreeCamera$brokencore_common();
                Camera cam = ClientDSLKt.getMC().gameRenderer.getMainCamera();
                Vector3f cpos = freeCam ? screen.getFreeCameraPos$brokencore_common() : cam.getPosition().toVector3f();
                Vector2f rot = this$0.getDrawSelfLast() ? screen.getFreeCameraRot$brokencore_common() : new Vector2f(cam.getXRot(), cam.getYRot());
                it.getEndPosition$brokencore_common().set((Vector3fc)cpos);
                it.setEndRotation$brokencore_common(rot);
                this$0.timeline.getRoot().getInspector$brokencore_common().loadKeyframe(it);
                break block2;
            }
            if (!this$0.shiftPressed) break block2;
            CutsceneEditorKeyframe cutsceneEditorKeyframe = this$0.timeline.getRoot().getCurrentKeyframe();
            if (cutsceneEditorKeyframe != null) {
                CutsceneEditorKeyframe it = cutsceneEditorKeyframe;
                boolean bl = false;
                CutsceneEditorScreen screen = this$0.timeline.getRoot().getScreen();
                boolean freeCam = screen.getFreeCamera$brokencore_common();
                Camera cam = ClientDSLKt.getMC().gameRenderer.getMainCamera();
                Vector3f cpos = freeCam ? screen.getFreeCameraPos$brokencore_common() : cam.getPosition().toVector3f();
                Vector2f rot = this$0.getDrawSelfLast() ? screen.getFreeCameraRot$brokencore_common() : new Vector2f(cam.getXRot(), cam.getYRot());
                it.getStartPosition$brokencore_common().set((Vector3fc)cpos);
                it.setStartRotation$brokencore_common(rot);
            }
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimelineTrack$Companion;", "", "<init>", "()V", "BACKGROUND", "Lnet/minecraft/resources/ResourceLocation;", "getBACKGROUND", "()Lnet/minecraft/resources/ResourceLocation;", "fromJson", "Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimelineTrack;", "json", "Lkotlinx/serialization/json/JsonArray;", "timeline", "Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimeline;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ResourceLocation getBACKGROUND() {
            return BACKGROUND;
        }

        @NotNull
        public final CutsceneEditorTimelineTrack fromJson(@NotNull JsonArray json, @NotNull CutsceneEditorTimeline timeline) {
            Intrinsics.checkNotNullParameter((Object)json, (String)"json");
            Intrinsics.checkNotNullParameter((Object)timeline, (String)"timeline");
            CutsceneEditorTimelineTrack track = new CutsceneEditorTimelineTrack(timeline);
            for (JsonElement obj : json) {
                track.keyframes.add(CutsceneEditorKeyframe.Companion.fromJson(track, JsonElementKt.getJsonObject((JsonElement)obj)));
            }
            return track;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

