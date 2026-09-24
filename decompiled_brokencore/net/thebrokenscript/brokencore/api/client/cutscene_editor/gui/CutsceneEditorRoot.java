/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.Camera
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.player.LocalPlayer
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector2d
 *  org.joml.Vector2f
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.brokencore.api.client.cutscene_editor.gui;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.Camera;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.CutsceneEditorScreen;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.inspector.CutsceneEditorInspector;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.timeline.CutsceneEditorKeyframe;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.timeline.CutsceneEditorTimeline;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.timeline.CutsceneEditorTimelineTrack;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractButton;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.JomlVecExtKt;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.ext.miximpl.CameraExtImplKt;
import net.thebrokenscript.brokencore.api.global.GlobalMathKt;
import net.thebrokenscript.brokencore.api.render.CensorQuad;
import net.thebrokenscript.brokencore.api.util.math.MathUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2d;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010#\u001a\u00020$H\u0002J8\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\u001f\u00a8\u0006."}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/CutsceneEditorRoot;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "screen", "Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/CutsceneEditorScreen;", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/CutsceneEditorScreen;)V", "getScreen", "()Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/CutsceneEditorScreen;", "cutsceneLength", "", "getCutsceneLength", "()I", "timeline", "Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimeline;", "getTimeline$brokencore_common", "()Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimeline;", "inspector", "Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/inspector/CutsceneEditorInspector;", "getInspector$brokencore_common", "()Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/inspector/CutsceneEditorInspector;", "v", "Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorKeyframe;", "currentKeyframe", "getCurrentKeyframe", "()Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorKeyframe;", "setCurrentKeyframe", "(Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorKeyframe;)V", "_", "w", "getW", "setW", "(I)V", "h", "getH", "setH", "updateElements", "", "render", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "mouseY", "partialTick", "", "globalX", "globalY", "brokencore-common"})
public final class CutsceneEditorRoot
extends AbstractGuiNode2D {
    @NotNull
    private final CutsceneEditorScreen screen;
    @NotNull
    private final CutsceneEditorTimeline timeline;
    @NotNull
    private final CutsceneEditorInspector inspector;
    @Nullable
    private CutsceneEditorKeyframe currentKeyframe;

    public CutsceneEditorRoot(@NotNull CutsceneEditorScreen screen) {
        Intrinsics.checkNotNullParameter((Object)((Object)screen), (String)"screen");
        super(0, 0, 0, 0, 15, null);
        this.screen = screen;
        this.timeline = (CutsceneEditorTimeline)this.addChild((GuiElement)new CutsceneEditorTimeline(this));
        this.inspector = (CutsceneEditorInspector)this.addChild((GuiElement)new CutsceneEditorInspector(this));
        this.updateElements();
    }

    @NotNull
    public final CutsceneEditorScreen getScreen() {
        return this.screen;
    }

    public final int getCutsceneLength() {
        return this.timeline.getCutsceneLength();
    }

    @NotNull
    public final CutsceneEditorTimeline getTimeline$brokencore_common() {
        return this.timeline;
    }

    @NotNull
    public final CutsceneEditorInspector getInspector$brokencore_common() {
        return this.inspector;
    }

    @Nullable
    public final CutsceneEditorKeyframe getCurrentKeyframe() {
        return this.currentKeyframe;
    }

    public final void setCurrentKeyframe(@Nullable CutsceneEditorKeyframe v) {
        this.currentKeyframe = v;
        if (v != null) {
            this.inspector.loadKeyframe(v);
        }
    }

    @Override
    public int getW() {
        return super.getW();
    }

    @Override
    public void setW(int n) {
        this.updateElements();
    }

    @Override
    public int getH() {
        return super.getH();
    }

    @Override
    public void setH(int n) {
        this.updateElements();
    }

    private final void updateElements() {
        this.setX(0);
        this.setY(0);
        super.setW(ClientDSLKt.getMC().getWindow().getGuiScaledWidth());
        super.setH(ClientDSLKt.getMC().getWindow().getGuiScaledHeight());
        int timelineY = (int)((double)ClientDSLKt.getMC().getWindow().getGuiScaledHeight() * 0.75);
        int timelineHeight = ClientDSLKt.getMC().getWindow().getGuiScaledHeight() - timelineY;
        this.timeline.setW(this.getW());
        this.timeline.setY(timelineY);
        this.timeline.setH(timelineHeight);
        int inspectorWidth = (int)((double)ClientDSLKt.getMC().getWindow().getGuiScaledWidth() * 0.273);
        this.inspector.setX(ClientDSLKt.getMC().getWindow().getGuiScaledWidth() - inspectorWidth);
        this.inspector.setH((int)((double)ClientDSLKt.getMC().getWindow().getGuiScaledHeight() * 0.75));
        this.inspector.setW(inspectorWidth);
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, int globalX, int globalY) {
        block4: {
            Vector3f vector3f;
            Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
            AbstractButton abstractButton = this.currentKeyframe;
            if (abstractButton == null || (abstractButton = ((CutsceneEditorKeyframe)abstractButton).getTrack()) == null) break block4;
            AbstractButton track = abstractButton;
            boolean bl = false;
            Vector3f cpos = ClientDSLKt.getMC().gameRenderer.getMainCamera().getPosition().toVector3f();
            Camera camera = ClientDSLKt.getMC().gameRenderer.getMainCamera();
            Intrinsics.checkNotNullExpressionValue((Object)camera, (String)"getMainCamera(...)");
            if (CameraExtImplKt.getOverrides(camera).getActive()) {
                Vector3f vector3f2 = new Vector3f((Vector3fc)this.screen.getFreeCameraPos$brokencore_common());
                LocalPlayer localPlayer = ClientDSLKt.getMC().player;
                Intrinsics.checkNotNull((Object)localPlayer);
                vector3f = vector3f2.sub((Vector3fc)localPlayer.getEyePosition().toVector3f());
            } else {
                vector3f = new Vector3f(0.0f);
            }
            Vector3f cOfs = vector3f;
            int n = this.getCutsceneLength();
            for (int i = 0; i < n; ++i) {
                CutsceneEditorKeyframe keyframe;
                int it = i;
                boolean bl2 = false;
                if (((CutsceneEditorTimelineTrack)track).getKeyframeAt(it) == null) continue;
                boolean bl3 = false;
                if (it + 1 >= this.getCutsceneLength() || it + 1 >= keyframe.getMaxTime() + 1) continue;
                float deltaX = JomlVecExtKt.toFloat((Vector2d)keyframe.getCurveX$brokencore_common().getPoint((Number)((Number)Float.valueOf((float)((float)(it - keyframe.getTime()) / (float)keyframe.getLength()))))).x;
                float nextDeltaX = JomlVecExtKt.toFloat((Vector2d)keyframe.getCurveX$brokencore_common().getPoint((Number)((Number)Float.valueOf((float)((float)(it + 1 - keyframe.getTime()) / (float)keyframe.getLength()))))).x;
                float deltaY = JomlVecExtKt.toFloat((Vector2d)keyframe.getCurveY$brokencore_common().getPoint((Number)((Number)Float.valueOf((float)((float)(it - keyframe.getTime()) / (float)keyframe.getLength()))))).x;
                float nextDeltaY = JomlVecExtKt.toFloat((Vector2d)keyframe.getCurveY$brokencore_common().getPoint((Number)((Number)Float.valueOf((float)((float)(it + 1 - keyframe.getTime()) / (float)keyframe.getLength()))))).x;
                float deltaZ = JomlVecExtKt.toFloat((Vector2d)keyframe.getCurveZ$brokencore_common().getPoint((Number)((Number)Float.valueOf((float)((float)(it - keyframe.getTime()) / (float)keyframe.getLength()))))).x;
                float nextDeltaZ = JomlVecExtKt.toFloat((Vector2d)keyframe.getCurveZ$brokencore_common().getPoint((Number)((Number)Float.valueOf((float)((float)(it + 1 - keyframe.getTime()) / (float)keyframe.getLength()))))).x;
                Vector3f pos = new Vector3f(MathUtilKt.lerpf(deltaX, (Number)Float.valueOf(keyframe.getStartPosition$brokencore_common().x), (Number)Float.valueOf(keyframe.getEndPosition$brokencore_common().x)), MathUtilKt.lerpf(deltaY, (Number)Float.valueOf(keyframe.getStartPosition$brokencore_common().y), (Number)Float.valueOf(keyframe.getEndPosition$brokencore_common().y)), MathUtilKt.lerpf(deltaZ, (Number)Float.valueOf(keyframe.getStartPosition$brokencore_common().z), (Number)Float.valueOf(keyframe.getEndPosition$brokencore_common().z)));
                Vector3f nextPos = new Vector3f(MathUtilKt.lerpf(nextDeltaX, (Number)Float.valueOf(keyframe.getStartPosition$brokencore_common().x), (Number)Float.valueOf(keyframe.getEndPosition$brokencore_common().x)), MathUtilKt.lerpf(nextDeltaY, (Number)Float.valueOf(keyframe.getStartPosition$brokencore_common().y), (Number)Float.valueOf(keyframe.getEndPosition$brokencore_common().y)), MathUtilKt.lerpf(nextDeltaZ, (Number)Float.valueOf(keyframe.getStartPosition$brokencore_common().z), (Number)Float.valueOf(keyframe.getEndPosition$brokencore_common().z)));
                Vector2f rot = new Vector2f(MathUtilKt.lerpf(deltaX, (Number)Float.valueOf(keyframe.getStartRotation$brokencore_common().x), (Number)Float.valueOf(keyframe.getEndRotation$brokencore_common().x)), MathUtilKt.lerpf(deltaY, (Number)Float.valueOf(keyframe.getStartRotation$brokencore_common().y), (Number)Float.valueOf(keyframe.getEndRotation$brokencore_common().y)));
                Vector3f rPos = new Vector3f((Vector3fc)pos).add((Vector3fc)new Vector3f(0.0f, 0.0f, 0.5f).rotateX(-GlobalMathKt.getToRadians(rot.x)).rotateY(-GlobalMathKt.getToRadians(rot.y)));
                Vector3f vector3f3 = new Vector3f((Vector3fc)pos).sub((Vector3fc)cOfs);
                Intrinsics.checkNotNullExpressionValue((Object)vector3f3, (String)"sub(...)");
                Vector3f s = CensorQuad.projectPositionToScreen$default(CensorQuad.INSTANCE, vector3f3, 0.0f, 2, null);
                Vector3f vector3f4 = new Vector3f((Vector3fc)nextPos).sub((Vector3fc)cOfs);
                Intrinsics.checkNotNullExpressionValue((Object)vector3f4, (String)"sub(...)");
                Vector3f e = CensorQuad.projectPositionToScreen$default(CensorQuad.INSTANCE, vector3f4, 0.0f, 2, null);
                Vector3f vector3f5 = new Vector3f((Vector3fc)rPos).sub((Vector3fc)cOfs);
                Intrinsics.checkNotNullExpressionValue((Object)vector3f5, (String)"sub(...)");
                Vector3f rs = CensorQuad.projectPositionToScreen$default(CensorQuad.INSTANCE, vector3f5, 0.0f, 2, null);
                float d = 5.0f;
                if (s.z < 1.0f && e.z < 1.0f) {
                    MiscExt.line(guiGraphics, s.x, s.y, e.x, e.y, -2, d, 1.0f, 0.0f, 0.0f, 1.0f);
                }
                if (!(rs.z < 1.0f) || !(s.z < 1.0f)) continue;
                MiscExt.directionalTriangle(guiGraphics, s.x, s.y, rs.x, rs.y, -1, d, 0.0f, 0.0f, 1.0f, 1.0f);
            }
        }
    }
}

