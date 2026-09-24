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
 *  kotlin.ranges.ClosedFloatingPointRange
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.RangesKt
 *  kotlinx.serialization.json.JsonElement
 *  kotlinx.serialization.json.JsonElementBuildersKt
 *  kotlinx.serialization.json.JsonElementKt
 *  kotlinx.serialization.json.JsonObject
 *  kotlinx.serialization.json.JsonObjectBuilder
 *  kotlinx.serialization.json.JsonPrimitive
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.FastColor$ARGB32
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2f
 *  org.joml.Vector2fc
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.timeline;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonPrimitive;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.CutsceneEditorConstants;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.timeline.CutsceneEditorTimelineTrack;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractButton;
import net.thebrokenscript.brokencore.api.client.gui.container.ScrollContainer;
import net.thebrokenscript.brokencore.api.client.util.BezierCurve;
import net.thebrokenscript.brokencore.api.cutscene.nodes.TransformNode;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.JomlVecExtKt;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.impl.BrokenCore;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2f;
import org.joml.Vector2fc;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 X2\u00020\u0001:\u0001XB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0016J8\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010I\u001a\u00020+2\u0006\u0010K\u001a\u00020+2\u0006\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020+2\u0006\u0010R\u001a\u00020+H\u0016J\u0006\u0010S\u001a\u00020MJ\u0006\u0010T\u001a\u00020UJ\u000e\u0010V\u001a\u00020\u00002\u0006\u0010W\u001a\u00020UR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0014\u0010\t\u001a\u00020\n8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u0010X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0010X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R$\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u0014\u0010\u001f\u001a\u00020 X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020 X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020 X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020 X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0014\u0010)\u001a\u00020 X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R$\u0010,\u001a\u00020+2\u0006\u0010\u0015\u001a\u00020+@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00101\u001a\u00020+2\u0006\u0010\u0015\u001a\u00020+@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R$\u00104\u001a\u00020+2\u0006\u0010\u0015\u001a\u00020+8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b5\u0010.\"\u0004\b6\u00100R$\u00107\u001a\u00020+2\u0006\u0010\u0015\u001a\u00020+8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b8\u0010.\"\u0004\b9\u00100R\u0011\u0010:\u001a\u00020;8F\u00a2\u0006\u0006\u001a\u0004\b<\u0010=R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020@0?8F\u00a2\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020D8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u0010F\u00a8\u0006Y"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorKeyframe;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractButton;", "track", "Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimelineTrack;", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimelineTrack;)V", "getTrack", "()Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimelineTrack;", "setTrack", "startPosition", "Lorg/joml/Vector3f;", "getStartPosition$brokencore_common", "()Lorg/joml/Vector3f;", "endPosition", "getEndPosition$brokencore_common", "startNode", "Lnet/thebrokenscript/brokencore/api/cutscene/nodes/TransformNode;", "getStartNode$brokencore_common", "()Lnet/thebrokenscript/brokencore/api/cutscene/nodes/TransformNode;", "endNode", "getEndNode$brokencore_common", "v", "Lorg/joml/Vector2f;", "startRotation", "getStartRotation$brokencore_common", "()Lorg/joml/Vector2f;", "setStartRotation$brokencore_common", "(Lorg/joml/Vector2f;)V", "endRotation", "getEndRotation$brokencore_common", "setEndRotation$brokencore_common", "curveX", "Lnet/thebrokenscript/brokencore/api/client/util/BezierCurve;", "getCurveX$brokencore_common", "()Lnet/thebrokenscript/brokencore/api/client/util/BezierCurve;", "curveY", "getCurveY$brokencore_common", "curveZ", "getCurveZ$brokencore_common", "curveRX", "getCurveRX$brokencore_common", "curveRY", "getCurveRY$brokencore_common", "", "minTime", "getMinTime", "()I", "setMinTime", "(I)V", "maxTime", "getMaxTime", "setMaxTime", "time", "getTime", "setTime", "length", "getLength", "setLength", "tickRange", "Lkotlin/ranges/IntRange;", "getTickRange", "()Lkotlin/ranges/IntRange;", "timeRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "getTimeRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "timeString", "", "getTimeString", "()Ljava/lang/String;", "isMouseOver", "", "mouseX", "", "mouseY", "render", "", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "partialTick", "globalX", "globalY", "remove", "toJson", "Lkotlinx/serialization/json/JsonObject;", "loadJson", "jsonObject", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nCutsceneEditorKeyframe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CutsceneEditorKeyframe.kt\nnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorKeyframe\n+ 2 JsonElementBuilders.kt\nkotlinx/serialization/json/JsonElementBuildersKt\n*L\n1#1,151:1\n29#2,3:152\n*S KotlinDebug\n*F\n+ 1 CutsceneEditorKeyframe.kt\nnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorKeyframe\n*L\n116#1:152,3\n*E\n"})
public final class CutsceneEditorKeyframe
extends AbstractButton {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private CutsceneEditorTimelineTrack track;
    @NotNull
    private final TransformNode startNode;
    @NotNull
    private final TransformNode endNode;
    @NotNull
    private final BezierCurve curveX;
    @NotNull
    private final BezierCurve curveY;
    @NotNull
    private final BezierCurve curveZ;
    @NotNull
    private final BezierCurve curveRX;
    @NotNull
    private final BezierCurve curveRY;
    private int minTime;
    private int maxTime;
    @NotNull
    private static final ResourceLocation KEYFRAME_BG = BrokenCore.id("cutscene_editor/keyframe_background");
    @NotNull
    private static final ResourceLocation KEYFRAME = BrokenCore.id("cutscene_editor/keyframe");

    public CutsceneEditorKeyframe(@NotNull CutsceneEditorTimelineTrack track) {
        Intrinsics.checkNotNullParameter((Object)track, (String)"track");
        super((Function0<Unit>)((Function0)CutsceneEditorKeyframe::_init_$lambda$0));
        this.track = track;
        this.startNode = new TransformNode(null, 1, null);
        this.endNode = new TransformNode(null, 1, null);
        this.curveX = new BezierCurve(0.0, 1.0, 1.0, 0.0, 0.1, 0.9, 0.9, 0.1);
        this.curveY = new BezierCurve(0.0, 1.0, 1.0, 0.0, 0.1, 0.9, 0.9, 0.1);
        this.curveZ = new BezierCurve(0.0, 1.0, 1.0, 0.0, 0.1, 0.9, 0.9, 0.1);
        this.curveRX = new BezierCurve(0.0, 1.0, 1.0, 0.0, 0.1, 0.9, 0.9, 0.1);
        this.curveRY = new BezierCurve(0.0, 1.0, 1.0, 0.0, 0.1, 0.9, 0.9, 0.1);
        this.setCallback((Function0<Unit>)((Function0)() -> CutsceneEditorKeyframe._init_$lambda$1(this)));
        this.maxTime = 1;
    }

    @NotNull
    public final CutsceneEditorTimelineTrack getTrack() {
        return this.track;
    }

    public final void setTrack(@NotNull CutsceneEditorTimelineTrack cutsceneEditorTimelineTrack) {
        Intrinsics.checkNotNullParameter((Object)cutsceneEditorTimelineTrack, (String)"<set-?>");
        this.track = cutsceneEditorTimelineTrack;
    }

    @NotNull
    public final Vector3f getStartPosition$brokencore_common() {
        return this.startNode.getTransform().getPosition();
    }

    @NotNull
    public final Vector3f getEndPosition$brokencore_common() {
        return this.endNode.getTransform().getPosition();
    }

    @NotNull
    public final TransformNode getStartNode$brokencore_common() {
        return this.startNode;
    }

    @NotNull
    public final TransformNode getEndNode$brokencore_common() {
        return this.endNode;
    }

    @NotNull
    public final Vector2f getStartRotation$brokencore_common() {
        return new Vector2f(this.startNode.getTransform().getRotation().getYaw(), this.startNode.getTransform().getRotation().getPitch());
    }

    public final void setStartRotation$brokencore_common(@NotNull Vector2f v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.startNode.getTransform().getRotation().setYaw(v.x);
        this.startNode.getTransform().getRotation().setPitch(v.y);
    }

    @NotNull
    public final Vector2f getEndRotation$brokencore_common() {
        return new Vector2f(this.endNode.getTransform().getRotation().getYaw(), this.endNode.getTransform().getRotation().getPitch());
    }

    public final void setEndRotation$brokencore_common(@NotNull Vector2f v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.endNode.getTransform().getRotation().setYaw(v.x);
        this.endNode.getTransform().getRotation().setPitch(v.y);
    }

    @NotNull
    public final BezierCurve getCurveX$brokencore_common() {
        return this.curveX;
    }

    @NotNull
    public final BezierCurve getCurveY$brokencore_common() {
        return this.curveY;
    }

    @NotNull
    public final BezierCurve getCurveZ$brokencore_common() {
        return this.curveZ;
    }

    @NotNull
    public final BezierCurve getCurveRX$brokencore_common() {
        return this.curveRX;
    }

    @NotNull
    public final BezierCurve getCurveRY$brokencore_common() {
        return this.curveRY;
    }

    public final int getMinTime() {
        return this.minTime;
    }

    public final void setMinTime(int v) {
        this.minTime = v;
        this.track.updateKeyframePosition(this);
    }

    public final int getMaxTime() {
        return this.maxTime;
    }

    public final void setMaxTime(int v) {
        this.maxTime = v;
        this.track.updateKeyframePosition(this);
    }

    public final int getTime() {
        return this.minTime;
    }

    public final void setTime(int v) {
        int l = this.getLength();
        this.setMinTime(v);
        this.setMaxTime(this.minTime + l);
    }

    public final int getLength() {
        return this.maxTime - this.minTime;
    }

    public final void setLength(int v) {
        this.setMaxTime(v + this.minTime);
    }

    @NotNull
    public final IntRange getTickRange() {
        return new IntRange(this.minTime, this.maxTime);
    }

    @NotNull
    public final ClosedFloatingPointRange<Float> getTimeRange() {
        return RangesKt.rangeTo((float)((float)this.minTime / 20.0f), (float)((float)this.maxTime / 20.0f));
    }

    private final String getTimeString() {
        boolean seconds = this.track.getTimeline().getDisplaySeconds();
        Comparable mi = seconds ? this.getTimeRange().getStart() : Integer.valueOf(this.getTickRange().getFirst());
        Comparable mx = seconds ? this.getTimeRange().getEndInclusive() : Integer.valueOf(this.getTickRange().getLast());
        return mi + "-" + mx;
    }

    @Override
    public boolean isMouseOver(@NotNull Number mouseX, @NotNull Number mouseY) {
        Intrinsics.checkNotNullParameter((Object)mouseX, (String)"mouseX");
        Intrinsics.checkNotNullParameter((Object)mouseY, (String)"mouseY");
        return super.isMouseOver(mouseX, mouseY) && !this.track.getTimeline().getTimelineCursorHovered$brokencore_common();
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, int globalX, int globalY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        if (this.getW() == 0) {
            MiscExt.fill(guiGraphics, globalX, globalY, (float)globalX + 0.5f, (float)globalY + (float)this.getH(), this.getZIndex(), -1);
        }
        CutsceneEditorConstants.INSTANCE.getCOMMON_NINE_PATCH_SCALING().render(guiGraphics, KEYFRAME_BG, this);
        if (this.isMouseOver(mouseX, mouseY)) {
            ScrollContainer scr = this.track.getTimeline().getScrollContainer$brokencore_common();
            guiGraphics.disableScissor();
            guiGraphics.drawString(ClientDSLKt.getMC().font, this.getTimeString(), mouseX + 4, mouseY - 8, FastColor.ARGB32.colorFromFloat((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f));
            guiGraphics.enableScissor(scr.getGlobalX(), scr.getGlobalY(), scr.getGlobalX() + scr.getW(), scr.getGlobalY() + scr.getH());
        }
    }

    public final void remove() {
        this.track.removeKeyframe(this);
    }

    @NotNull
    public final JsonObject toJson() {
        JsonObjectBuilder builder$iv;
        boolean $i$f$buildJsonObject = false;
        JsonObjectBuilder $this$toJson_u24lambda_u240 = builder$iv = new JsonObjectBuilder();
        boolean bl = false;
        $this$toJson_u24lambda_u240.put("start_position", (JsonElement)JomlVecExtKt.toJson((Vector3fc)this.getStartPosition$brokencore_common()));
        $this$toJson_u24lambda_u240.put("end_position", (JsonElement)JomlVecExtKt.toJson((Vector3fc)this.getEndPosition$brokencore_common()));
        $this$toJson_u24lambda_u240.put("start_rotation", (JsonElement)JomlVecExtKt.toJson((Vector2fc)this.getStartRotation$brokencore_common()));
        $this$toJson_u24lambda_u240.put("end_rotation", (JsonElement)JomlVecExtKt.toJson((Vector2fc)this.getEndRotation$brokencore_common()));
        $this$toJson_u24lambda_u240.put("curveX", (JsonElement)this.curveX.toJson());
        $this$toJson_u24lambda_u240.put("curveY", (JsonElement)this.curveY.toJson());
        $this$toJson_u24lambda_u240.put("curveZ", (JsonElement)this.curveZ.toJson());
        $this$toJson_u24lambda_u240.put("curveRX", (JsonElement)this.curveZ.toJson());
        $this$toJson_u24lambda_u240.put("curveRY", (JsonElement)this.curveZ.toJson());
        JsonElementBuildersKt.put((JsonObjectBuilder)$this$toJson_u24lambda_u240, (String)"time", (Number)this.getTime());
        JsonElementBuildersKt.put((JsonObjectBuilder)$this$toJson_u24lambda_u240, (String)"length", (Number)this.getLength());
        return builder$iv.build();
    }

    @NotNull
    public final CutsceneEditorKeyframe loadJson(@NotNull JsonObject jsonObject) {
        Intrinsics.checkNotNullParameter((Object)jsonObject, (String)"jsonObject");
        Vector3f vector3f = this.getStartPosition$brokencore_common();
        Object object = jsonObject.get((Object)"start_position");
        Intrinsics.checkNotNull((Object)object);
        JomlVecExtKt.loadJson(vector3f, JsonElementKt.getJsonArray((JsonElement)((JsonElement)object)));
        Vector3f vector3f2 = this.getEndPosition$brokencore_common();
        Object object2 = jsonObject.get((Object)"end_position");
        Intrinsics.checkNotNull((Object)object2);
        JomlVecExtKt.loadJson(vector3f2, JsonElementKt.getJsonArray((JsonElement)((JsonElement)object2)));
        Vector2f vector2f = new Vector2f();
        Object object3 = jsonObject.get((Object)"start_rotation");
        Intrinsics.checkNotNull((Object)object3);
        this.setStartRotation$brokencore_common(JomlVecExtKt.loadJson(vector2f, JsonElementKt.getJsonArray((JsonElement)((JsonElement)object3))));
        Vector2f vector2f2 = new Vector2f();
        Object object4 = jsonObject.get((Object)"end_rotation");
        Intrinsics.checkNotNull((Object)object4);
        this.setEndRotation$brokencore_common(JomlVecExtKt.loadJson(vector2f2, JsonElementKt.getJsonArray((JsonElement)((JsonElement)object4))));
        Object object5 = jsonObject.get((Object)"curveX");
        Intrinsics.checkNotNull((Object)object5);
        this.curveX.loadJson(JsonElementKt.getJsonArray((JsonElement)((JsonElement)object5)));
        Object object6 = jsonObject.get((Object)"curveY");
        Intrinsics.checkNotNull((Object)object6);
        this.curveY.loadJson(JsonElementKt.getJsonArray((JsonElement)((JsonElement)object6)));
        Object object7 = jsonObject.get((Object)"curveZ");
        Intrinsics.checkNotNull((Object)object7);
        this.curveZ.loadJson(JsonElementKt.getJsonArray((JsonElement)((JsonElement)object7)));
        Object object8 = jsonObject.get((Object)"curveRX");
        Intrinsics.checkNotNull((Object)object8);
        this.curveRX.loadJson(JsonElementKt.getJsonArray((JsonElement)((JsonElement)object8)));
        Object object9 = jsonObject.get((Object)"curveRX");
        Intrinsics.checkNotNull((Object)object9);
        this.curveRY.loadJson(JsonElementKt.getJsonArray((JsonElement)((JsonElement)object9)));
        Object object10 = jsonObject.get((Object)"length");
        Intrinsics.checkNotNull((Object)object10);
        this.setLength(JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)((JsonElement)object10))));
        Object object11 = jsonObject.get((Object)"time");
        Intrinsics.checkNotNull((Object)object11);
        this.setTime(JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)((JsonElement)object11))));
        return this;
    }

    private static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(CutsceneEditorKeyframe this$0) {
        this$0.track.getTimeline().getRoot().setCurrentKeyframe(this$0);
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorKeyframe$Companion;", "", "<init>", "()V", "KEYFRAME_BG", "Lnet/minecraft/resources/ResourceLocation;", "getKEYFRAME_BG", "()Lnet/minecraft/resources/ResourceLocation;", "KEYFRAME", "getKEYFRAME", "fromJson", "Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorKeyframe;", "track", "Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimelineTrack;", "jsonObject", "Lkotlinx/serialization/json/JsonObject;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ResourceLocation getKEYFRAME_BG() {
            return KEYFRAME_BG;
        }

        @NotNull
        public final ResourceLocation getKEYFRAME() {
            return KEYFRAME;
        }

        @NotNull
        public final CutsceneEditorKeyframe fromJson(@NotNull CutsceneEditorTimelineTrack track, @NotNull JsonObject jsonObject) {
            Intrinsics.checkNotNullParameter((Object)track, (String)"track");
            Intrinsics.checkNotNullParameter((Object)jsonObject, (String)"jsonObject");
            return new CutsceneEditorKeyframe(track).loadJson(jsonObject);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

