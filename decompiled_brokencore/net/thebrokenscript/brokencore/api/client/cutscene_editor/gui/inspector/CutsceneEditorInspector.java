/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.gui.GuiGraphics
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector3dc
 */
package net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.inspector;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.gui.GuiGraphics;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.CutsceneEditorConstants;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.CutsceneEditorRoot;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.timeline.CutsceneEditorKeyframe;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.timeline.CutsceneEditorTimelineTrack;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.container.ScrollContainer;
import net.thebrokenscript.brokencore.api.client.gui.container.VListContainer;
import net.thebrokenscript.brokencore.api.client.gui.field.IntField;
import net.thebrokenscript.brokencore.api.client.gui.field.Vector2Field;
import net.thebrokenscript.brokencore.api.client.gui.field.Vector3Field;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import net.thebrokenscript.brokencore.api.client.gui.label.Label;
import net.thebrokenscript.brokencore.api.client.gui.range.CurveEditor;
import net.thebrokenscript.brokencore.api.client.gui.settings.LabelSettings;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\tJ8\u00104\u001a\u0002022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010#\u001a\u00020\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0011\u0010%\u001a\u00020\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0011\u0010'\u001a\u00020\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010 R$\u0010*\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00118V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010-R$\u0010.\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u00118V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b/\u0010\u0013\"\u0004\b0\u0010-\u00a8\u0006="}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/inspector/CutsceneEditorInspector;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "root", "Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/CutsceneEditorRoot;", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/CutsceneEditorRoot;)V", "getRoot", "()Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/CutsceneEditorRoot;", "currentKeyframe", "Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorKeyframe;", "getCurrentKeyframe", "()Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorKeyframe;", "scrollContainer", "Lnet/thebrokenscript/brokencore/api/client/gui/container/ScrollContainer;", "list", "Lnet/thebrokenscript/brokencore/api/client/gui/container/VListContainer;", "cutsceneLength", "", "getCutsceneLength", "()I", "timeField", "Lnet/thebrokenscript/brokencore/api/client/gui/field/IntField;", "lengthField", "startPosField", "Lnet/thebrokenscript/brokencore/api/client/gui/field/Vector3Field;", "startRotField", "Lnet/thebrokenscript/brokencore/api/client/gui/field/Vector2Field;", "endPosField", "endRotField", "transitionCurveX", "Lnet/thebrokenscript/brokencore/api/client/gui/range/CurveEditor;", "getTransitionCurveX", "()Lnet/thebrokenscript/brokencore/api/client/gui/range/CurveEditor;", "transitionCurveY", "getTransitionCurveY", "transitionCurveZ", "getTransitionCurveZ", "transitionCurveRX", "getTransitionCurveRX", "transitionCurveRY", "getTransitionCurveRY", "v", "w", "getW", "setW", "(I)V", "h", "getH", "setH", "loadKeyframe", "", "keyframe", "render", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "mouseY", "partialTick", "", "globalX", "globalY", "brokencore-common"})
public final class CutsceneEditorInspector
extends AbstractGuiNode2D {
    @NotNull
    private final CutsceneEditorRoot root;
    @NotNull
    private final ScrollContainer scrollContainer;
    @NotNull
    private final VListContainer list;
    @NotNull
    private final IntField timeField;
    @NotNull
    private final IntField lengthField;
    @NotNull
    private final Vector3Field startPosField;
    @NotNull
    private final Vector2Field startRotField;
    @NotNull
    private final Vector3Field endPosField;
    @NotNull
    private final Vector2Field endRotField;
    @NotNull
    private final CurveEditor transitionCurveX;
    @NotNull
    private final CurveEditor transitionCurveY;
    @NotNull
    private final CurveEditor transitionCurveZ;
    @NotNull
    private final CurveEditor transitionCurveRX;
    @NotNull
    private final CurveEditor transitionCurveRY;

    public CutsceneEditorInspector(@NotNull CutsceneEditorRoot root) {
        Intrinsics.checkNotNullParameter((Object)root, (String)"root");
        super(0, 0, 0, 0, 15, null);
        this.root = root;
        this.scrollContainer = (ScrollContainer)this.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.createScrollContainer());
        this.list = (VListContainer)this.scrollContainer.addChild((GuiElement)new VListContainer(0, 1, null));
        Label label = (Label)this.list.addChild((GuiElement)LabelSettings.Companion.getDEFAULT().create("Time"));
        label.setH(8);
        this.timeField = (IntField)this.list.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.createIntField());
        label = (Label)this.list.addChild((GuiElement)LabelSettings.Companion.getDEFAULT().create("Length"));
        label.setH(8);
        this.lengthField = (IntField)this.list.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.createIntField());
        Label field = (Label)this.list.addChild((GuiElement)LabelSettings.Companion.getDEFAULT().create("Start Position"));
        field.setH(8);
        this.startPosField = (Vector3Field)this.list.addChild((GuiElement)new Vector3Field(CutsceneEditorConstants.INSTANCE.getTEXT_BOX(), CutsceneEditorConstants.INSTANCE.getCOMMON_NINE_PATCH_SCALING()));
        field = (Label)this.list.addChild((GuiElement)LabelSettings.Companion.getDEFAULT().create("Start Rotation"));
        field.setH(8);
        this.startRotField = (Vector2Field)this.list.addChild((GuiElement)new Vector2Field(CutsceneEditorConstants.INSTANCE.getTEXT_BOX(), CutsceneEditorConstants.INSTANCE.getCOMMON_NINE_PATCH_SCALING()));
        field = (Label)this.list.addChild((GuiElement)LabelSettings.Companion.getDEFAULT().create("End Position"));
        field.setH(8);
        this.endPosField = (Vector3Field)this.list.addChild((GuiElement)new Vector3Field(CutsceneEditorConstants.INSTANCE.getTEXT_BOX(), CutsceneEditorConstants.INSTANCE.getCOMMON_NINE_PATCH_SCALING()));
        field = (Label)this.list.addChild((GuiElement)LabelSettings.Companion.getDEFAULT().create("End Rotation"));
        field.setH(8);
        this.endRotField = (Vector2Field)this.list.addChild((GuiElement)new Vector2Field(CutsceneEditorConstants.INSTANCE.getTEXT_BOX(), CutsceneEditorConstants.INSTANCE.getCOMMON_NINE_PATCH_SCALING()));
        field = (Label)this.list.addChild((GuiElement)LabelSettings.Companion.getDEFAULT().create("Transition"));
        field.setH(8);
        field = (Label)this.list.addChild((GuiElement)LabelSettings.Companion.getDEFAULT().create("X Curve"));
        field.setH(8);
        this.transitionCurveX = (CurveEditor)this.list.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.createCurveEditor());
        field = (Label)this.list.addChild((GuiElement)LabelSettings.Companion.getDEFAULT().create("Y Curve"));
        field.setH(8);
        this.transitionCurveY = (CurveEditor)this.list.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.createCurveEditor());
        field = (Label)this.list.addChild((GuiElement)LabelSettings.Companion.getDEFAULT().create("Z Curve"));
        field.setH(8);
        this.transitionCurveZ = (CurveEditor)this.list.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.createCurveEditor());
        field = (Label)this.list.addChild((GuiElement)LabelSettings.Companion.getDEFAULT().create("X Rotation Curve"));
        field.setH(8);
        this.transitionCurveRX = (CurveEditor)this.list.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.createCurveEditor());
        field = (Label)this.list.addChild((GuiElement)LabelSettings.Companion.getDEFAULT().create("Y Rotation Curve"));
        field.setH(8);
        this.transitionCurveRY = (CurveEditor)this.list.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.createCurveEditor());
        this.lengthField.setChangeCallback((Function1<? super String, Unit>)((Function1)arg_0 -> CutsceneEditorInspector._init_$lambda$0(this, arg_0)));
        this.timeField.setChangeCallback((Function1<? super String, Unit>)((Function1)arg_0 -> CutsceneEditorInspector._init_$lambda$1(this, arg_0)));
        this.endPosField.setChangeCallback((Function3<? super String, ? super String, ? super String, Unit>)((Function3)(arg_0, arg_1, arg_2) -> CutsceneEditorInspector._init_$lambda$2(this, arg_0, arg_1, arg_2)));
        this.startPosField.setChangeCallback((Function3<? super String, ? super String, ? super String, Unit>)((Function3)(arg_0, arg_1, arg_2) -> CutsceneEditorInspector._init_$lambda$3(this, arg_0, arg_1, arg_2)));
        this.timeField.setUnfocusedCallback((Function0<Unit>)((Function0)() -> CutsceneEditorInspector._init_$lambda$4(this)));
        this.lengthField.setUnfocusedCallback((Function0<Unit>)((Function0)() -> CutsceneEditorInspector._init_$lambda$5(this)));
        this.startPosField.setChangeCallback((Function3<? super String, ? super String, ? super String, Unit>)((Function3)(arg_0, arg_1, arg_2) -> CutsceneEditorInspector._init_$lambda$6(this, arg_0, arg_1, arg_2)));
        this.endPosField.setChangeCallback((Function3<? super String, ? super String, ? super String, Unit>)((Function3)(arg_0, arg_1, arg_2) -> CutsceneEditorInspector._init_$lambda$7(this, arg_0, arg_1, arg_2)));
        this.startRotField.setChangeCallback((Function2<? super String, ? super String, Unit>)((Function2)(arg_0, arg_1) -> CutsceneEditorInspector._init_$lambda$8(this, arg_0, arg_1)));
        this.endRotField.setChangeCallback((Function2<? super String, ? super String, Unit>)((Function2)(arg_0, arg_1) -> CutsceneEditorInspector._init_$lambda$9(this, arg_0, arg_1)));
        this.list.updateChildren();
    }

    @NotNull
    public final CutsceneEditorRoot getRoot() {
        return this.root;
    }

    private final CutsceneEditorKeyframe getCurrentKeyframe() {
        return this.root.getCurrentKeyframe();
    }

    public final int getCutsceneLength() {
        return this.root.getCutsceneLength();
    }

    @NotNull
    public final CurveEditor getTransitionCurveX() {
        return this.transitionCurveX;
    }

    @NotNull
    public final CurveEditor getTransitionCurveY() {
        return this.transitionCurveY;
    }

    @NotNull
    public final CurveEditor getTransitionCurveZ() {
        return this.transitionCurveZ;
    }

    @NotNull
    public final CurveEditor getTransitionCurveRX() {
        return this.transitionCurveRX;
    }

    @NotNull
    public final CurveEditor getTransitionCurveRY() {
        return this.transitionCurveRY;
    }

    @Override
    public int getW() {
        return super.getW();
    }

    @Override
    public void setW(int v) {
        super.setW(this.getW());
        this.transitionCurveX.setH(v);
        this.transitionCurveY.setH(v);
        this.transitionCurveZ.setH(v);
        this.transitionCurveRX.setH(v);
        this.transitionCurveRY.setH(v);
        this.scrollContainer.setW(v);
        this.list.setW(v - 8);
    }

    @Override
    public int getH() {
        return super.getH();
    }

    @Override
    public void setH(int v) {
        super.setH(this.getH());
        this.scrollContainer.setH(v);
        this.list.setH(v);
    }

    public final void loadKeyframe(@NotNull CutsceneEditorKeyframe keyframe) {
        Intrinsics.checkNotNullParameter((Object)keyframe, (String)"keyframe");
        this.lengthField.setIntValue(keyframe.getLength());
        this.timeField.setIntValue(keyframe.getMinTime());
        this.startPosField.setFloatValue(keyframe.getStartPosition$brokencore_common());
        this.endPosField.setFloatValue(keyframe.getEndPosition$brokencore_common());
        this.startRotField.setFloatValue(keyframe.getStartRotation$brokencore_common());
        this.endRotField.setFloatValue(keyframe.getEndRotation$brokencore_common());
        this.transitionCurveX.setCurve(keyframe.getCurveX$brokencore_common());
        this.transitionCurveY.setCurve(keyframe.getCurveY$brokencore_common());
        this.transitionCurveZ.setCurve(keyframe.getCurveZ$brokencore_common());
        this.transitionCurveRX.setCurve(keyframe.getCurveRX$brokencore_common());
        this.transitionCurveRY.setCurve(keyframe.getCurveRY$brokencore_common());
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, int globalX, int globalY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        CutsceneEditorConstants.INSTANCE.getCOMMON_NINE_PATCH_SCALING().render(guiGraphics, CutsceneEditorConstants.INSTANCE.getGENERIC_BACKGROUND(), this.scrollContainer);
    }

    private static final Unit _init_$lambda$0(CutsceneEditorInspector this$0, String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        CutsceneEditorKeyframe keyframe = this$0.getCurrentKeyframe();
        if (keyframe != null) {
            int time2 = keyframe.getTime();
            int length = this$0.lengthField.getIntValue();
            boolean canMove = keyframe.getTrack().canMoveTo(keyframe, time2, length);
            if (time2 + length > this$0.getCutsceneLength() && canMove) {
                int newLength = this$0.getCutsceneLength() - time2;
                keyframe.setLength(newLength);
                this$0.lengthField.setIntValue(newLength);
            } else if (length < 1 && canMove) {
                keyframe.setLength(1);
                this$0.lengthField.setIntValue(1);
            } else if (canMove) {
                keyframe.setLength(length);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(CutsceneEditorInspector this$0, String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        CutsceneEditorKeyframe keyframe = this$0.getCurrentKeyframe();
        if (keyframe != null) {
            int time2 = this$0.timeField.getIntValue();
            int length = keyframe.getLength();
            boolean canMove = CutsceneEditorTimelineTrack.canMoveTo$default(keyframe.getTrack(), keyframe, time2, 0, 4, null);
            if (time2 + length > this$0.getCutsceneLength() && canMove) {
                int newTime = this$0.getCutsceneLength() - length;
                keyframe.setTime(newTime);
                this$0.timeField.setIntValue(newTime);
            } else if (time2 < 0 && canMove) {
                keyframe.setTime(0);
                this$0.timeField.setIntValue(0);
            } else if (canMove) {
                keyframe.setTime(time2);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$2(CutsceneEditorInspector this$0, String string, String string2, String string3) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)string, (String)"<unused var>");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"<unused var>");
            Intrinsics.checkNotNullParameter((Object)string3, (String)"<unused var>");
            CutsceneEditorKeyframe cutsceneEditorKeyframe = this$0.getCurrentKeyframe();
            if (cutsceneEditorKeyframe == null || (cutsceneEditorKeyframe = cutsceneEditorKeyframe.getStartPosition$brokencore_common()) == null) break block0;
            cutsceneEditorKeyframe.set((Vector3dc)this$0.startPosField.getDoubleValue());
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$3(CutsceneEditorInspector this$0, String string, String string2, String string3) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)string, (String)"<unused var>");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"<unused var>");
            Intrinsics.checkNotNullParameter((Object)string3, (String)"<unused var>");
            CutsceneEditorKeyframe cutsceneEditorKeyframe = this$0.getCurrentKeyframe();
            if (cutsceneEditorKeyframe == null || (cutsceneEditorKeyframe = cutsceneEditorKeyframe.getStartPosition$brokencore_common()) == null) break block0;
            cutsceneEditorKeyframe.set((Vector3dc)this$0.startPosField.getDoubleValue());
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$4(CutsceneEditorInspector this$0) {
        CutsceneEditorKeyframe keyframe = this$0.getCurrentKeyframe();
        if (keyframe != null) {
            this$0.timeField.setIntValue(keyframe.getTime());
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$5(CutsceneEditorInspector this$0) {
        CutsceneEditorKeyframe keyframe = this$0.getCurrentKeyframe();
        if (keyframe != null) {
            this$0.lengthField.setIntValue(keyframe.getLength());
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$6(CutsceneEditorInspector this$0, String string, String string2, String string3) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)string, (String)"<unused var>");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"<unused var>");
            Intrinsics.checkNotNullParameter((Object)string3, (String)"<unused var>");
            CutsceneEditorKeyframe cutsceneEditorKeyframe = this$0.getCurrentKeyframe();
            if (cutsceneEditorKeyframe == null || (cutsceneEditorKeyframe = cutsceneEditorKeyframe.getStartPosition$brokencore_common()) == null) break block0;
            cutsceneEditorKeyframe.set((Vector3dc)this$0.startPosField.getDoubleValue());
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$7(CutsceneEditorInspector this$0, String string, String string2, String string3) {
        block0: {
            Intrinsics.checkNotNullParameter((Object)string, (String)"<unused var>");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"<unused var>");
            Intrinsics.checkNotNullParameter((Object)string3, (String)"<unused var>");
            CutsceneEditorKeyframe cutsceneEditorKeyframe = this$0.getCurrentKeyframe();
            if (cutsceneEditorKeyframe == null || (cutsceneEditorKeyframe = cutsceneEditorKeyframe.getEndPosition$brokencore_common()) == null) break block0;
            cutsceneEditorKeyframe.set((Vector3dc)this$0.endPosField.getDoubleValue());
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$8(CutsceneEditorInspector this$0, String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"<unused var>");
        CutsceneEditorKeyframe keyframe = this$0.getCurrentKeyframe();
        if (keyframe != null) {
            keyframe.setStartRotation$brokencore_common(this$0.startRotField.getFloatValue());
        }
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$9(CutsceneEditorInspector this$0, String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"<unused var>");
        CutsceneEditorKeyframe keyframe = this$0.getCurrentKeyframe();
        if (keyframe != null) {
            keyframe.setEndRotation$brokencore_common(this$0.endRotField.getFloatValue());
        }
        return Unit.INSTANCE;
    }
}

