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
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.util.FastColor$ARGB32
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2d
 *  org.joml.Vector2i
 */
package net.thebrokenscript.brokencore.api.client.gui.range;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode2D;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractNodePreset;
import net.thebrokenscript.brokencore.api.client.gui.settings.SpriteScalingSettings;
import net.thebrokenscript.brokencore.api.client.util.BezierCurve;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.global.GlobalMathKt;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2d;
import org.joml.Vector2i;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 42\u00020\u00012\u00020\u0002:\u000245B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012J \u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J \u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0015H\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012H\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0002J \u0010'\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010(\u001a\u00020\u001aH\u0002J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u001aH\u0002J8\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u0015H\u0016J\u0010\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u001aH\u0016J\b\u00103\u001a\u00020\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/range/CurveEditor;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode2D;", "Lnet/minecraft/client/gui/components/events/GuiEventListener;", "bgTexture", "Lnet/minecraft/resources/ResourceLocation;", "bgScaling", "Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;", "curve", "Lnet/thebrokenscript/brokencore/api/client/util/BezierCurve;", "<init>", "(Lnet/minecraft/resources/ResourceLocation;Lnet/thebrokenscript/brokencore/api/client/gui/settings/SpriteScalingSettings;Lnet/thebrokenscript/brokencore/api/client/util/BezierCurve;)V", "getCurve", "()Lnet/thebrokenscript/brokencore/api/client/util/BezierCurve;", "setCurve", "(Lnet/thebrokenscript/brokencore/api/client/util/BezierCurve;)V", "getRectangle", "Lnet/minecraft/client/gui/navigation/ScreenRectangle;", "clickX", "", "clickY", "ctrlState", "", "interpolate", "delta", "", "mouseClicked", "", "mouseX", "mouseY", "button", "mouseReleased", "mouseMoved", "", "scaleMouseCoords", "Lorg/joml/Vector2d;", "scaleCtrlCoords", "Lorg/joml/Vector2i;", "x", "y", "updateCtrlState", "clicking", "getCtrlCol", "endPoint", "render", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "partialTick", "globalX", "globalY", "setFocused", "focused", "isFocused", "Companion", "CurvePreset", "brokencore-common"})
public final class CurveEditor
extends AbstractGuiNode2D
implements GuiEventListener {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ResourceLocation bgTexture;
    @NotNull
    private final SpriteScalingSettings bgScaling;
    @NotNull
    private volatile BezierCurve curve;
    private double clickX;
    private double clickY;
    private int ctrlState;
    private static final int CTRL_SIZE = 2;
    private static final int CTRL_NORMAL_COL = -1;
    private static final int CTRL_HOVERED_COL = -8421505;
    private static final int CTRL_PRESSED_COL = -10197916;

    public CurveEditor(@NotNull ResourceLocation bgTexture, @NotNull SpriteScalingSettings bgScaling, @NotNull BezierCurve curve) {
        Intrinsics.checkNotNullParameter((Object)bgTexture, (String)"bgTexture");
        Intrinsics.checkNotNullParameter((Object)bgScaling, (String)"bgScaling");
        Intrinsics.checkNotNullParameter((Object)curve, (String)"curve");
        super(0, 0, 0, 0, 15, null);
        this.bgTexture = bgTexture;
        this.bgScaling = bgScaling;
        this.curve = curve;
    }

    public /* synthetic */ CurveEditor(ResourceLocation resourceLocation, SpriteScalingSettings spriteScalingSettings, BezierCurve bezierCurve, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            bezierCurve = new BezierCurve(0.0, 1.0, 1.0, 0.0, 0.1, 0.9, 0.9, 0.1);
        }
        this(resourceLocation, spriteScalingSettings, bezierCurve);
    }

    @NotNull
    public final BezierCurve getCurve() {
        return this.curve;
    }

    public final void setCurve(@NotNull BezierCurve bezierCurve) {
        Intrinsics.checkNotNullParameter((Object)bezierCurve, (String)"<set-?>");
        this.curve = bezierCurve;
    }

    @Override
    @NotNull
    public ScreenRectangle getRectangle() {
        return super.getRectangle();
    }

    public final double interpolate(float delta) {
        return this.curve.getPoint((Number)((Number)Float.valueOf((float)delta))).x;
    }

    public final double interpolate(double delta) {
        return this.curve.getPoint((Number)((Number)Double.valueOf((double)delta))).x;
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.updateCtrlState(mouseX, mouseY, button == 0);
        this.clickX = mouseX;
        this.clickY = mouseY;
        return true;
    }

    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        this.updateCtrlState(mouseX, mouseY, false);
        return true;
    }

    public void mouseMoved(double mouseX, double mouseY) {
        if ((this.ctrlState >>> 2 & 2) == 0 && (this.ctrlState & 2) == 0) {
            this.updateCtrlState(mouseX, mouseY, false);
        }
        if ((this.ctrlState >>> 2 & 2) != 0) {
            this.curve.setCtrlA(this.scaleMouseCoords(mouseX, mouseY));
        }
        if ((this.ctrlState & 2) != 0) {
            this.curve.setCtrlB(this.scaleMouseCoords(mouseX, mouseY));
        }
    }

    private final Vector2d scaleMouseCoords(double mouseX, double mouseY) {
        return new Vector2d(Math.clamp(mouseX - (double)this.getGlobalX(), (double)this.bgScaling.getNinePatchSettings().getL(), (double)this.getW() - (double)this.bgScaling.getNinePatchSettings().getR()) / (double)this.getW(), Math.clamp(mouseY - (double)this.getGlobalY(), (double)this.bgScaling.getNinePatchSettings().getT(), (double)this.getH() - (double)this.bgScaling.getNinePatchSettings().getB()) / (double)this.getH());
    }

    private final Vector2i scaleCtrlCoords(double x, double y) {
        return new Vector2i((int)(x * (double)this.getW() + (double)this.getGlobalX()), (int)(y * (double)this.getH() + (double)this.getGlobalY()));
    }

    /*
     * Unable to fully structure code
     */
    private final void updateCtrlState(double mouseX, double mouseY, boolean clicking) {
        hovering = this.isMouseOver((int)mouseX, (int)mouseY);
        a = this.scaleCtrlCoords(this.curve.getCtrlAX(), this.curve.getCtrlAY());
        b = this.scaleCtrlCoords(this.curve.getCtrlBX(), this.curve.getCtrlBY());
        x = (int)mouseX;
        y = (int)mouseY;
        var12_9 = a.x - 2;
        v0 = x <= a.x + 2 ? var12_9 <= x : false;
        if (!v0) ** GOTO lbl-1000
        var12_9 = a.y - 2;
        v1 = y <= a.y + 2 ? var12_9 <= y : false;
        if (v1 && hovering) {
            v2 = clicking ? 2 : 1;
        } else lbl-1000:
        // 2 sources

        {
            v2 = 0;
        }
        aState = v2 << 2;
        if (aState != 0) {
            this.ctrlState = aState;
            return;
        }
        var13_11 = b.x - 2;
        v3 = x <= b.x + 2 ? var13_11 <= x : false;
        if (!v3) ** GOTO lbl-1000
        var13_11 = b.y - 2;
        v4 = y <= b.y + 2 ? var13_11 <= y : false;
        if (v4 && hovering) {
            v5 = clicking ? 2 : 1;
        } else lbl-1000:
        // 2 sources

        {
            v5 = 0;
        }
        this.ctrlState = bState = v5;
    }

    private final int getCtrlCol(boolean endPoint) {
        int state;
        int n = state = endPoint ? this.ctrlState : this.ctrlState >>> 2;
        return (state & 2) != 0 ? -10197916 : ((state & 1) != 0 ? -8421505 : -1);
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, int globalX, int globalY) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Vector2i ctrlA = this.scaleCtrlCoords(this.curve.getCtrlAX(), this.curve.getCtrlAY());
        Vector2i ctrlB = this.scaleCtrlCoords(this.curve.getCtrlBX(), this.curve.getCtrlBY());
        int l = this.bgScaling.getNinePatchSettings().getL();
        int t = this.bgScaling.getNinePatchSettings().getT();
        int r = this.bgScaling.getNinePatchSettings().getR();
        int b = this.bgScaling.getNinePatchSettings().getB();
        int colorA = this.getCtrlCol(false);
        int colorB = this.getCtrlCol(true);
        float redA = (float)FastColor.ARGB32.red((int)colorA) / 255.0f;
        float greenA = (float)FastColor.ARGB32.green((int)colorA) / 255.0f;
        float blueA = (float)FastColor.ARGB32.blue((int)colorA) / 255.0f;
        float redB = (float)FastColor.ARGB32.red((int)colorB) / (float)255;
        float greenB = (float)FastColor.ARGB32.green((int)colorB) / (float)255;
        float blueB = (float)FastColor.ARGB32.blue((int)colorB) / (float)255;
        this.bgScaling.render(guiGraphics, this.bgTexture, this);
        this.bgScaling.clip(guiGraphics, this, (Function0<Unit>)((Function0)() -> CurveEditor.render$lambda$0(guiGraphics, ctrlA, globalX, l, globalY, this, t, redA, greenA, blueA, ctrlB, r, b, redB, greenB, blueB, colorB, colorA)));
    }

    public void setFocused(boolean focused) {
    }

    public boolean isFocused() {
        return false;
    }

    private static final Unit render$lambda$0(GuiGraphics $guiGraphics, Vector2i $ctrlA, int $globalX, int $l, int $globalY, CurveEditor this$0, int $t, float $redA, float $greenA, float $blueA, Vector2i $ctrlB, int $r, int $b, float $redB, float $greenB, float $blueB, int $colorB, int $colorA) {
        MiscExt.line($guiGraphics, $ctrlA.x, $ctrlA.y, (float)$globalX + (float)$l, (float)$globalY + (float)this$0.getH() - (float)$t, this$0.getZIndex(), 1.0f, $redA, $greenA, $blueA, 1.0f);
        MiscExt.line($guiGraphics, $ctrlB.x, $ctrlB.y, (float)$globalX + (float)this$0.getW() - (float)$r, (float)$globalY + (float)$b, this$0.getZIndex(), 1.0f, $redB, $greenB, $blueB, 1.0f);
        BezierCurve.render$default(this$0.curve, $guiGraphics, $globalX + $l, $globalY + $t, GlobalMathKt.clamp(this$0.getW(), new IntRange(8, 32)), new Vector2d((double)this$0.getW() - (double)($l + $r), (double)this$0.getH() - (double)($b + $t)), this$0.getZIndex(), 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1920, null);
        $guiGraphics.fill($ctrlB.x - 2, $ctrlB.y - 2, $ctrlB.x + 2, $ctrlB.y + 2, this$0.getZIndex(), $colorB);
        $guiGraphics.fill($ctrlA.x - 2, $ctrlA.y - 2, $ctrlA.x + 2, $ctrlA.y + 2, this$0.getZIndex(), $colorA);
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/range/CurveEditor$Companion;", "", "<init>", "()V", "CTRL_SIZE", "", "CTRL_NORMAL_COL", "CTRL_HOVERED_COL", "CTRL_PRESSED_COL", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/range/CurveEditor$CurvePreset;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractNodePreset;", "Lnet/thebrokenscript/brokencore/api/client/gui/range/CurveEditor;", "<init>", "()V", "load", "", "node", "jsonObject", "Lkotlinx/serialization/json/JsonObject;", "save", "brokencore-common"})
    @SourceDebugExtension(value={"SMAP\nCurveEditor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CurveEditor.kt\nnet/thebrokenscript/brokencore/api/client/gui/range/CurveEditor$CurvePreset\n+ 2 JsonElementBuilders.kt\nkotlinx/serialization/json/JsonElementBuildersKt\n*L\n1#1,202:1\n29#2,2:203\n52#2,3:205\n52#2,3:208\n31#2:211\n*S KotlinDebug\n*F\n+ 1 CurveEditor.kt\nnet/thebrokenscript/brokencore/api/client/gui/range/CurveEditor$CurvePreset\n*L\n189#1:203,2\n190#1:205,3\n194#1:208,3\n189#1:211\n*E\n"})
    public static final class CurvePreset
    extends AbstractNodePreset<CurveEditor> {
        @Override
        public void load(@NotNull CurveEditor node, @NotNull JsonObject jsonObject) {
            Intrinsics.checkNotNullParameter((Object)node, (String)"node");
            Intrinsics.checkNotNullParameter((Object)jsonObject, (String)"jsonObject");
            Object object = jsonObject.get((Object)"a");
            Intrinsics.checkNotNull((Object)object);
            JsonArray a = JsonElementKt.getJsonArray((JsonElement)((JsonElement)object));
            Object object2 = jsonObject.get((Object)"b");
            Intrinsics.checkNotNull((Object)object2);
            JsonArray b = JsonElementKt.getJsonArray((JsonElement)((JsonElement)object2));
            node.getCurve().setCtrlA(new Vector2d(JsonElementKt.getDouble((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)a.get(0))), JsonElementKt.getDouble((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)a.get(1)))));
            node.getCurve().setCtrlB(new Vector2d(JsonElementKt.getDouble((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)b.get(0))), JsonElementKt.getDouble((JsonPrimitive)JsonElementKt.getJsonPrimitive((JsonElement)b.get(1)))));
        }

        /*
         * WARNING - void declaration
         */
        @Override
        @NotNull
        public JsonObject save(@NotNull CurveEditor node) {
            void $this$save_u24lambda_u240_u241;
            JsonArrayBuilder $this$save_u24lambda_u240_u240;
            JsonArrayBuilder builder$iv;
            JsonObjectBuilder builder$iv2;
            Intrinsics.checkNotNullParameter((Object)node, (String)"node");
            boolean $i$f$buildJsonObject = false;
            JsonObjectBuilder $this$save_u24lambda_u240 = builder$iv2 = new JsonObjectBuilder();
            boolean bl = false;
            boolean $i$f$buildJsonArray = false;
            JsonArrayBuilder jsonArrayBuilder = builder$iv = new JsonArrayBuilder();
            String string = "a";
            JsonObjectBuilder jsonObjectBuilder = $this$save_u24lambda_u240;
            boolean bl2 = false;
            JsonElementBuildersKt.add((JsonArrayBuilder)$this$save_u24lambda_u240_u240, (Number)node.getCurve().getCtrlAX());
            JsonElementBuildersKt.add((JsonArrayBuilder)$this$save_u24lambda_u240_u240, (Number)node.getCurve().getCtrlAY());
            Unit unit = Unit.INSTANCE;
            jsonObjectBuilder.put(string, (JsonElement)builder$iv.build());
            $i$f$buildJsonArray = false;
            $this$save_u24lambda_u240_u240 = builder$iv = new JsonArrayBuilder();
            string = "b";
            jsonObjectBuilder = $this$save_u24lambda_u240;
            boolean bl3 = false;
            JsonElementBuildersKt.add((JsonArrayBuilder)$this$save_u24lambda_u240_u241, (Number)node.getCurve().getCtrlBX());
            JsonElementBuildersKt.add((JsonArrayBuilder)$this$save_u24lambda_u240_u241, (Number)node.getCurve().getCtrlBY());
            unit = Unit.INSTANCE;
            jsonObjectBuilder.put(string, (JsonElement)builder$iv.build());
            return builder$iv2.build();
        }
    }
}

