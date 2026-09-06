/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.concurrent.ThreadsKt
 *  kotlin.io.FilesKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.math.MathKt
 *  kotlin.text.StringsKt
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JsonArray
 *  kotlinx.serialization.json.JsonArrayBuilder
 *  kotlinx.serialization.json.JsonElement
 *  kotlinx.serialization.json.JsonElementBuildersKt
 *  kotlinx.serialization.json.JsonElementKt
 *  kotlinx.serialization.json.JsonObject
 *  kotlinx.serialization.json.JsonObjectBuilder
 *  kotlinx.serialization.json.JsonPrimitive
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.client.gui.navigation.ScreenRectangle
 *  org.jetbrains.annotations.NotNull
 *  org.lwjgl.PointerBuffer
 *  org.lwjgl.system.MemoryStack
 *  org.lwjgl.util.tinyfd.TinyFileDialogs
 */
package net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.timeline;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonPrimitive;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.CutsceneEditorConstants;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.CutsceneEditorRoot;
import net.thebrokenscript.brokencore.api.client.cutscene_editor.gui.timeline.CutsceneEditorTimelineTrack;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.button.TextPanelButton;
import net.thebrokenscript.brokencore.api.client.gui.container.ScrollContainer;
import net.thebrokenscript.brokencore.api.client.gui.container.VListContainer;
import net.thebrokenscript.brokencore.api.client.gui.field.IntField;
import net.thebrokenscript.brokencore.api.client.gui.impl.GuiElement;
import net.thebrokenscript.brokencore.api.client.gui.misc.GuiSprite;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.util.tinyfd.TinyFileDialogs;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u00106\u001a\u00020\"H\u0002J\u0010\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\u0012H\u0002J8\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00122\u0006\u0010G\u001a\u00020\u00122\u0006\u0010H\u001a\u00020\"2\u0006\u0010I\u001a\u00020\u00122\u0006\u0010J\u001a\u00020\u0012H\u0016J\u0018\u0010K\u001a\u00020C2\u0006\u0010F\u001a\u00020L2\u0006\u0010G\u001a\u00020LH\u0016J \u0010M\u001a\u00020\n2\u0006\u0010F\u001a\u00020L2\u0006\u0010G\u001a\u00020L2\u0006\u0010N\u001a\u00020\u0012H\u0016J \u0010O\u001a\u00020\n2\u0006\u0010F\u001a\u00020L2\u0006\u0010G\u001a\u00020L2\u0006\u0010N\u001a\u00020\u0012H\u0016J\u000e\u0010P\u001a\u00020C2\u0006\u0010Q\u001a\u00020\u0010J\u0010\u0010R\u001a\u00020C2\u0006\u0010S\u001a\u00020\nH\u0016J\b\u0010T\u001a\u00020\nH\u0016J\b\u0010U\u001a\u00020VH\u0016J\u0006\u0010W\u001a\u00020XJ\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020XJ\b\u0010[\u001a\u00020\\H\u0002J\u001c\u0010]\u001a\u00020C2\u0014\b\u0002\u0010^\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020C0_J\u001a\u0010a\u001a\u00020C2\u0012\u0010^\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020C0_R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u0018X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010(R$\u0010*\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0012@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0012@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\u000e\u00102\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u00103\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0080\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\rR\u000e\u00105\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000208X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010:\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00128V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b;\u0010,\"\u0004\b<\u0010.R$\u0010=\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00128V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b>\u0010,\"\u0004\b?\u0010.\u00a8\u0006b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimeline;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "Lnet/minecraft/client/gui/components/events/GuiEventListener;", "root", "Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/CutsceneEditorRoot;", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/CutsceneEditorRoot;)V", "getRoot", "()Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/CutsceneEditorRoot;", "value", "", "promptOpen", "getPromptOpen", "()Z", "timelines", "", "Lnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimelineTrack;", "selectedLayer", "", "bg", "Lnet/thebrokenscript/brokencore/api/client/gui/misc/GuiSprite;", "list", "Lnet/thebrokenscript/brokencore/api/client/gui/container/VListContainer;", "scrollContainer", "Lnet/thebrokenscript/brokencore/api/client/gui/container/ScrollContainer;", "getScrollContainer$brokencore_common", "()Lnet/thebrokenscript/brokencore/api/client/gui/container/ScrollContainer;", "timelineBoxContainer", "addLayerButton", "Lnet/thebrokenscript/brokencore/api/client/gui/button/TextPanelButton;", "saveButton", "loadButton", "freeCameraButton", "cursorDelta", "", "getCursorDelta", "()F", "displaySeconds", "getDisplaySeconds", "setDisplaySeconds", "(Z)V", "v", "cutsceneLength", "getCutsceneLength", "()I", "setCutsceneLength", "(I)V", "cursorTime", "getCursorTime", "setCursorTime", "draggingCursor", "timelineCursorHovered", "getTimelineCursorHovered$brokencore_common", "cursorGuiPos", "calcCursorGuiPos", "timeField", "Lnet/thebrokenscript/brokencore/api/client/gui/field/IntField;", "lengthField", "w", "getW", "setW", "h", "getH", "setH", "xPosToTime", "x", "render", "", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "mouseX", "mouseY", "partialTick", "globalX", "globalY", "mouseMoved", "", "mouseClicked", "button", "mouseReleased", "updateSelectedLayer", "layer", "setFocused", "focused", "isFocused", "getRectangle", "Lnet/minecraft/client/gui/navigation/ScreenRectangle;", "toJson", "Lkotlinx/serialization/json/JsonObject;", "loadJson", "obj", "getJsonPtrBuffer", "Lorg/lwjgl/PointerBuffer;", "save", "callback", "Lkotlin/Function1;", "", "load", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nCutsceneEditorTimeline.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CutsceneEditorTimeline.kt\nnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimeline\n+ 2 JsonElementBuilders.kt\nkotlinx/serialization/json/JsonElementBuildersKt\n+ 3 Json.kt\nkotlinx/serialization/json/Json\n*L\n1#1,258:1\n29#2,2:259\n52#2,3:261\n31#2:264\n205#3:265\n*S KotlinDebug\n*F\n+ 1 CutsceneEditorTimeline.kt\nnet/thebrokenscript/brokencore/api/client/cutscene_editor/gui/timeline/CutsceneEditorTimeline\n*L\n198#1:259,2\n200#1:261,3\n198#1:264\n236#1:265\n*E\n"})
public final class CutsceneEditorTimeline
extends AbstractGuiNode2D
implements GuiEventListener {
    @NotNull
    private final CutsceneEditorRoot root;
    private boolean promptOpen;
    @NotNull
    private final List<CutsceneEditorTimelineTrack> timelines;
    private int selectedLayer;
    @NotNull
    private final GuiSprite bg;
    @NotNull
    private final VListContainer list;
    @NotNull
    private final ScrollContainer scrollContainer;
    @NotNull
    private final VListContainer timelineBoxContainer;
    @NotNull
    private final TextPanelButton addLayerButton;
    @NotNull
    private final TextPanelButton saveButton;
    @NotNull
    private final TextPanelButton loadButton;
    @NotNull
    private final TextPanelButton freeCameraButton;
    private boolean displaySeconds;
    private int cutsceneLength;
    private int cursorTime;
    private boolean draggingCursor;
    private boolean timelineCursorHovered;
    private float cursorGuiPos;
    @NotNull
    private final IntField timeField;
    @NotNull
    private final IntField lengthField;

    public CutsceneEditorTimeline(@NotNull CutsceneEditorRoot root) {
        Intrinsics.checkNotNullParameter((Object)root, (String)"root");
        super(0, 0, 0, 0, 15, null);
        this.root = root;
        this.timelines = new ArrayList();
        this.bg = (GuiSprite)this.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.createGenericBackground());
        this.list = (VListContainer)this.addChild((GuiElement)new VListContainer(0, 1, null));
        this.scrollContainer = (ScrollContainer)this.list.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.createScrollContainer());
        this.timelineBoxContainer = (VListContainer)this.scrollContainer.addChild((GuiElement)new VListContainer(0, 1, null));
        this.addLayerButton = (TextPanelButton)this.list.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.getTEXT_PANEL_SETTINGS().create("+", (Function0<Unit>)((Function0)() -> CutsceneEditorTimeline.addLayerButton$lambda$0(this))));
        this.saveButton = (TextPanelButton)this.list.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.getTEXT_PANEL_SETTINGS().create("Save", (Function0<Unit>)((Function0)() -> CutsceneEditorTimeline.saveButton$lambda$0(this))));
        this.loadButton = (TextPanelButton)this.list.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.getTEXT_PANEL_SETTINGS().create("Load", (Function0<Unit>)((Function0)() -> CutsceneEditorTimeline.loadButton$lambda$0(this))));
        this.freeCameraButton = (TextPanelButton)this.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.getTEXT_PANEL_SETTINGS().create("Free Camera", (Function0<Unit>)((Function0)() -> CutsceneEditorTimeline.freeCameraButton$lambda$0(this))));
        this.cutsceneLength = 1;
        this.timeField = (IntField)this.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.createIntField());
        this.lengthField = (IntField)this.addChild((GuiElement)CutsceneEditorConstants.INSTANCE.createIntField());
        this.timeField.setW(40);
        this.lengthField.setW(40);
        this.timeField.setText("0");
        this.lengthField.setText("1");
        this.setDrawSelfLast(true);
        this.timeField.getText();
        this.timeField.setChangeCallback((Function1<? super String, Unit>)((Function1)arg_0 -> CutsceneEditorTimeline._init_$lambda$0(this, arg_0)));
        this.lengthField.setChangeCallback((Function1<? super String, Unit>)((Function1)arg_0 -> CutsceneEditorTimeline._init_$lambda$1(this, arg_0)));
    }

    @NotNull
    public final CutsceneEditorRoot getRoot() {
        return this.root;
    }

    public final boolean getPromptOpen() {
        return this.promptOpen;
    }

    @NotNull
    public final ScrollContainer getScrollContainer$brokencore_common() {
        return this.scrollContainer;
    }

    public final float getCursorDelta() {
        return (float)this.cursorTime / (float)this.cutsceneLength;
    }

    public final boolean getDisplaySeconds() {
        return this.displaySeconds;
    }

    public final void setDisplaySeconds(boolean bl) {
        this.displaySeconds = bl;
    }

    public final int getCutsceneLength() {
        return this.cutsceneLength;
    }

    public final void setCutsceneLength(int v) {
        this.cutsceneLength = Math.max(1, v);
    }

    public final int getCursorTime() {
        return this.cursorTime;
    }

    public final void setCursorTime(int v) {
        this.cursorTime = v;
        this.cursorGuiPos = this.calcCursorGuiPos();
        this.timeField.setText(String.valueOf(v));
    }

    public final boolean getTimelineCursorHovered$brokencore_common() {
        return this.timelineCursorHovered;
    }

    private final float calcCursorGuiPos() {
        return ((float)this.getW() - (float)24) * this.getCursorDelta();
    }

    @Override
    public int getW() {
        return super.getW();
    }

    @Override
    public void setW(int v) {
        this.scrollContainer.setW(v);
        this.timelineBoxContainer.setW(v - 8);
        this.addLayerButton.setY(this.scrollContainer.getH());
        this.saveButton.setY(this.scrollContainer.getH());
        this.loadButton.setY(this.scrollContainer.getH());
        this.saveButton.setW(32);
        this.loadButton.setW(32);
        this.saveButton.setX(this.addLayerButton.getW() + this.lengthField.getX() + this.lengthField.getW());
        this.loadButton.setX(this.saveButton.getX() + this.saveButton.getW());
        this.freeCameraButton.setX(this.loadButton.getGlobalX() + this.loadButton.getW() + 8);
        this.freeCameraButton.setY(this.loadButton.getY());
        this.freeCameraButton.setW(72);
        this.bg.setW(v);
        this.timeField.setX(this.addLayerButton.getX() + 4 + this.addLayerButton.getW());
        this.lengthField.setX(this.timeField.getX() + this.timeField.getW() + 4);
        super.setW(v);
    }

    @Override
    public int getH() {
        return super.getH();
    }

    @Override
    public void setH(int v) {
        this.scrollContainer.setH(v - this.addLayerButton.getH());
        this.timelineBoxContainer.setH(v - this.addLayerButton.getH());
        this.addLayerButton.setY(this.scrollContainer.getH());
        this.saveButton.setY(this.scrollContainer.getH());
        this.loadButton.setY(this.scrollContainer.getH());
        this.saveButton.setW(32);
        this.loadButton.setW(32);
        this.saveButton.setX(this.addLayerButton.getW() + this.lengthField.getX() + this.lengthField.getW() + 8);
        this.loadButton.setX(this.saveButton.getX() + this.saveButton.getW());
        this.freeCameraButton.setY(this.loadButton.getY());
        this.freeCameraButton.setX(this.loadButton.getX() + this.loadButton.getW());
        this.freeCameraButton.setW(72);
        this.bg.setH(v);
        this.timeField.setY(this.addLayerButton.getY());
        this.lengthField.setY(this.addLayerButton.getY());
        super.setH(v);
    }

    private final int xPosToTime(int x) {
        float delta = (float)x / (float)(this.getW() - 24);
        return MathKt.roundToInt((float)((float)this.cutsceneLength * delta));
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, int globalX, int globalY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        if (this.timelineCursorHovered || this.draggingCursor) {
            guiGraphics.drawString(ClientDSLKt.getMC().font, String.valueOf(this.cursorTime), mouseX + 4, mouseY - 8, -1);
        }
        if (this.timeField.isMouseOver(mouseX, mouseY)) {
            guiGraphics.drawString(ClientDSLKt.getMC().font, "Tick", mouseX + 4, mouseY - 8, -1);
        }
        if (this.lengthField.isMouseOver(mouseX, mouseY)) {
            guiGraphics.drawString(ClientDSLKt.getMC().font, "Cutscene Length", mouseX + 4, mouseY - 8, -1);
        }
        if (this.addLayerButton.isMouseOver(mouseX, mouseY)) {
            guiGraphics.drawString(ClientDSLKt.getMC().font, "Add Layer", mouseX + 4, mouseY - 8, -1);
        }
        MiscExt.fill(guiGraphics, this.cursorGuiPos, globalY, this.cursorGuiPos + 1.0f, (float)globalY + (float)(this.getH() - this.addLayerButton.getH()) - (float)8, this.getZIndex(), -1);
    }

    public void mouseMoved(double mouseX, double mouseY) {
        float cPos = this.cursorGuiPos;
        boolean overSourceRect = this.isMouseOver((int)mouseX, (int)mouseY);
        int n = (int)(cPos - 1.0f);
        int n2 = (int)(cPos + 1.0f);
        int n3 = (int)mouseX;
        boolean overCursor = n <= n3 ? n3 <= n2 : false;
        boolean bl = this.timelineCursorHovered = overCursor && overSourceRect;
        if (this.draggingCursor) {
            this.setCursorTime(this.xPosToTime(Math.clamp((long)mouseX, 0, this.getW() - 24)));
            this.cursorGuiPos = (float)Math.clamp(mouseX, 0.0, (double)this.getW() - 24.0);
        }
        super.mouseMoved(mouseX, mouseY);
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (this.timelineCursorHovered) {
            this.draggingCursor = true;
        }
        return true;
    }

    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        this.draggingCursor = false;
        return true;
    }

    public final void updateSelectedLayer(@NotNull CutsceneEditorTimelineTrack layer) {
        Intrinsics.checkNotNullParameter((Object)layer, (String)"layer");
        int index = this.timelines.indexOf(layer);
        if (index != -1) {
            this.selectedLayer = index;
        }
    }

    public void setFocused(boolean focused) {
    }

    public boolean isFocused() {
        return false;
    }

    @Override
    @NotNull
    public ScreenRectangle getRectangle() {
        return super.getRectangle();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final JsonObject toJson() {
        JsonArrayBuilder builder$iv;
        JsonObjectBuilder builder$iv2;
        boolean $i$f$buildJsonObject = false;
        JsonObjectBuilder $this$toJson_u24lambda_u240 = builder$iv2 = new JsonObjectBuilder();
        boolean bl = false;
        JsonElementBuildersKt.put((JsonObjectBuilder)$this$toJson_u24lambda_u240, (String)"length", (Number)this.cutsceneLength);
        boolean $i$f$buildJsonArray = false;
        JsonArrayBuilder jsonArrayBuilder = builder$iv = new JsonArrayBuilder();
        String string = "tracks";
        JsonObjectBuilder jsonObjectBuilder = $this$toJson_u24lambda_u240;
        boolean bl2 = false;
        for (CutsceneEditorTimelineTrack track : this.timelines) {
            void $this$toJson_u24lambda_u240_u240;
            $this$toJson_u24lambda_u240_u240.add((JsonElement)track.toJson());
        }
        Unit unit = Unit.INSTANCE;
        jsonObjectBuilder.put(string, (JsonElement)builder$iv.build());
        return builder$iv2.build();
    }

    @NotNull
    public final CutsceneEditorTimeline loadJson(@NotNull JsonObject obj) {
        Intrinsics.checkNotNullParameter((Object)obj, (String)"obj");
        this.timelines.clear();
        Object object = obj.get((Object)"length");
        Intrinsics.checkNotNull((Object)object);
        int length = JsonElementKt.getInt((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)((JsonElement)object)));
        Object object2 = obj.get((Object)"tracks");
        Intrinsics.checkNotNull((Object)object2);
        JsonArray tracks = JsonElementKt.getJsonArray((JsonElement)((JsonElement)object2));
        this.setCutsceneLength(length);
        this.lengthField.setIntValue(length);
        for (JsonElement arr : tracks) {
            this.timelines.add(CutsceneEditorTimelineTrack.Companion.fromJson(JsonElementKt.getJsonArray((JsonElement)arr), this));
        }
        return this;
    }

    private final PointerBuffer getJsonPtrBuffer() {
        MemoryStack stack = MemoryStack.stackPush();
        PointerBuffer buffer = MemoryStack.stackPush().mallocPointer(1);
        buffer.put(stack.UTF8((CharSequence)"*.json"));
        Intrinsics.checkNotNull((Object)buffer);
        return buffer;
    }

    public final void save(@NotNull Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        if (this.promptOpen) {
            return;
        }
        this.promptOpen = true;
        ThreadsKt.thread$default((boolean)false, (boolean)false, null, null, (int)0, () -> CutsceneEditorTimeline.save$lambda$1(this, callback), (int)31, null);
    }

    public static /* synthetic */ void save$default(CutsceneEditorTimeline cutsceneEditorTimeline, Function1 function1, int n, Object object) {
        if ((n & 1) != 0) {
            function1 = CutsceneEditorTimeline::save$lambda$0;
        }
        cutsceneEditorTimeline.save((Function1<? super String, Unit>)function1);
    }

    public final void load(@NotNull Function1<? super JsonObject, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, (String)"callback");
        if (this.promptOpen) {
            return;
        }
        this.promptOpen = true;
        ThreadsKt.thread$default((boolean)false, (boolean)false, null, null, (int)0, () -> CutsceneEditorTimeline.load$lambda$0(this, callback), (int)31, null);
    }

    private static final Unit addLayerButton$lambda$0(CutsceneEditorTimeline this$0) {
        CutsceneEditorTimelineTrack track = (CutsceneEditorTimelineTrack)this$0.timelineBoxContainer.addChild((GuiElement)new CutsceneEditorTimelineTrack(this$0));
        this$0.timelines.add(track);
        this$0.timelineBoxContainer.updateChildren();
        this$0.scrollContainer.updateChildren();
        return Unit.INSTANCE;
    }

    private static final Unit saveButton$lambda$0(CutsceneEditorTimeline this$0) {
        this$0.save((Function1<? super String, Unit>)((Function1)arg_0 -> CutsceneEditorTimeline.saveButton$lambda$0$0(this$0, arg_0)));
        return Unit.INSTANCE;
    }

    private static final Unit saveButton$lambda$0$0(CutsceneEditorTimeline this$0, String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        this$0.root.getScreen().setCurrentSavePath$brokencore_common(it);
        this$0.promptOpen = false;
        return Unit.INSTANCE;
    }

    private static final Unit loadButton$lambda$0(CutsceneEditorTimeline this$0) {
        this$0.load((Function1<? super JsonObject, Unit>)((Function1)arg_0 -> CutsceneEditorTimeline.loadButton$lambda$0$0(this$0, arg_0)));
        return Unit.INSTANCE;
    }

    private static final Unit loadButton$lambda$0$0(CutsceneEditorTimeline this$0, JsonObject it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        this$0.loadJson(it);
        this$0.promptOpen = false;
        return Unit.INSTANCE;
    }

    private static final Unit freeCameraButton$lambda$0(CutsceneEditorTimeline this$0) {
        this$0.root.getScreen().toggleFreeCamera$brokencore_common();
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$0(CutsceneEditorTimeline this$0, String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        this$0.setCursorTime(Math.clamp(this$0.timeField.getLongValue(), 0, this$0.cutsceneLength));
        return Unit.INSTANCE;
    }

    private static final Unit _init_$lambda$1(CutsceneEditorTimeline this$0, String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        this$0.setCutsceneLength(Math.max(this$0.lengthField.getIntValue(), 1));
        this$0.setCursorTime(this$0.xPosToTime((int)this$0.cursorGuiPos));
        return Unit.INSTANCE;
    }

    private static final Unit save$lambda$0(String it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final Unit save$lambda$1(CutsceneEditorTimeline this$0, Function1 $callback) {
        Object selectedFile = TinyFileDialogs.tinyfd_saveFileDialog((CharSequence)"Json files", (CharSequence)".", (PointerBuffer)this$0.getJsonPtrBuffer(), null);
        if (selectedFile != null) {
            void this_$iv;
            if (!StringsKt.endsWith$default((String)selectedFile, (String)".json", (boolean)false, (int)2, null)) {
                selectedFile = (String)selectedFile + ".json";
            }
            $callback.invoke(selectedFile);
            File file = new File((String)selectedFile);
            if (!file.exists()) {
                file.createNewFile();
            }
            Json json = (Json)Json.Default;
            JsonObject value$iv = this$0.toJson();
            boolean $i$f$encodeToString = false;
            this_$iv.getSerializersModule();
            FilesKt.writeText$default((File)file, (String)this_$iv.encodeToString((SerializationStrategy)JsonObject.Companion.serializer(), (Object)value$iv), null, (int)2, null);
        }
        return Unit.INSTANCE;
    }

    private static final Unit load$lambda$0(CutsceneEditorTimeline this$0, Function1 $callback) {
        String selectedFile = TinyFileDialogs.tinyfd_openFileDialog((CharSequence)"Json files", (CharSequence)".", (PointerBuffer)this$0.getJsonPtrBuffer(), null, (boolean)false);
        if (selectedFile != null) {
            File file = new File(selectedFile);
            $callback.invoke((Object)JsonElementKt.getJsonObject((JsonElement)Json.Default.parseToJsonElement(FilesKt.readText$default((File)file, null, (int)1, null))));
        }
        return Unit.INSTANCE;
    }
}

