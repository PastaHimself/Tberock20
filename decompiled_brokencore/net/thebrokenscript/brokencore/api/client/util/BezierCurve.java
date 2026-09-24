/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.json.JsonArray
 *  kotlinx.serialization.json.JsonArrayBuilder
 *  kotlinx.serialization.json.JsonElement
 *  kotlinx.serialization.json.JsonElementKt
 *  net.minecraft.client.gui.GuiGraphics
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Vector2d
 *  org.joml.Vector2dc
 */
package net.thebrokenscript.brokencore.api.client.util;

import java.awt.Point;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import net.minecraft.client.gui.GuiGraphics;
import net.thebrokenscript.brokencore.api.ext.JomlVecExtKt;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector2d;
import org.joml.Vector2dc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 K2\u00020\u0001:\u0001KBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000b\u0010\fB)\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u000b\u0010\u0012Jf\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u0002052\u0006\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u0002052\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;J\u001e\u0010@\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u000205J\u000e\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020HJ\u000e\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020HR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R$\u0010\u0011\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010\u0010\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R$\u0010\r\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)\u00a8\u0006L"}, d2={"Lnet/thebrokenscript/brokencore/api/client/util/BezierCurve;", "", "startX", "", "startY", "endX", "endY", "ctrlAX", "ctrlAY", "ctrlBX", "ctrlBY", "<init>", "(DDDDDDDD)V", "start", "Lorg/joml/Vector2d;", "end", "ctrlA", "ctrlB", "(Lorg/joml/Vector2d;Lorg/joml/Vector2d;Lorg/joml/Vector2d;Lorg/joml/Vector2d;)V", "getStartX", "()D", "setStartX", "(D)V", "getStartY", "setStartY", "getEndX", "setEndX", "getEndY", "setEndY", "getCtrlAX", "setCtrlAX", "getCtrlAY", "setCtrlAY", "getCtrlBX", "setCtrlBX", "getCtrlBY", "setCtrlBY", "v", "getCtrlB", "()Lorg/joml/Vector2d;", "setCtrlB", "(Lorg/joml/Vector2d;)V", "getCtrlA", "setCtrlA", "getStart", "setStart", "getEnd", "setEnd", "render", "", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "xOffset", "", "yOffset", "points", "scale", "zIndex", "thickness", "", "r", "g", "b", "a", "getClosestPoint", "fromX", "fromY", "precisionPoints", "getPoint", "delta", "", "toJson", "Lkotlinx/serialization/json/JsonArray;", "loadJson", "jsonArray", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBezierCurve.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BezierCurve.kt\nnet/thebrokenscript/brokencore/api/client/util/BezierCurve\n+ 2 JsonElementBuilders.kt\nkotlinx/serialization/json/JsonElementBuildersKt\n*L\n1#1,137:1\n52#2,3:138\n*S KotlinDebug\n*F\n+ 1 BezierCurve.kt\nnet/thebrokenscript/brokencore/api/client/util/BezierCurve\n*L\n114#1:138,3\n*E\n"})
public final class BezierCurve {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private double ctrlAX;
    private double ctrlAY;
    private double ctrlBX;
    private double ctrlBY;

    public BezierCurve(double startX, double startY, double endX, double endY, double ctrlAX, double ctrlAY, double ctrlBX, double ctrlBY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.ctrlAX = ctrlAX;
        this.ctrlAY = ctrlAY;
        this.ctrlBX = ctrlBX;
        this.ctrlBY = ctrlBY;
    }

    public final double getStartX() {
        return this.startX;
    }

    public final void setStartX(double d) {
        this.startX = d;
    }

    public final double getStartY() {
        return this.startY;
    }

    public final void setStartY(double d) {
        this.startY = d;
    }

    public final double getEndX() {
        return this.endX;
    }

    public final void setEndX(double d) {
        this.endX = d;
    }

    public final double getEndY() {
        return this.endY;
    }

    public final void setEndY(double d) {
        this.endY = d;
    }

    public final double getCtrlAX() {
        return this.ctrlAX;
    }

    public final void setCtrlAX(double d) {
        this.ctrlAX = d;
    }

    public final double getCtrlAY() {
        return this.ctrlAY;
    }

    public final void setCtrlAY(double d) {
        this.ctrlAY = d;
    }

    public final double getCtrlBX() {
        return this.ctrlBX;
    }

    public final void setCtrlBX(double d) {
        this.ctrlBX = d;
    }

    public final double getCtrlBY() {
        return this.ctrlBY;
    }

    public final void setCtrlBY(double d) {
        this.ctrlBY = d;
    }

    public BezierCurve(@NotNull Vector2d start, @NotNull Vector2d end, @NotNull Vector2d ctrlA, @NotNull Vector2d ctrlB) {
        Intrinsics.checkNotNullParameter((Object)start, (String)"start");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        Intrinsics.checkNotNullParameter((Object)ctrlA, (String)"ctrlA");
        Intrinsics.checkNotNullParameter((Object)ctrlB, (String)"ctrlB");
        this(start.x, start.y, end.x, end.y, ctrlA.x, ctrlA.y, ctrlB.x, ctrlB.y);
    }

    @NotNull
    public final Vector2d getCtrlB() {
        return new Vector2d(this.ctrlBX, this.ctrlBY);
    }

    public final void setCtrlB(@NotNull Vector2d v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.ctrlBX = v.x;
        this.ctrlBY = v.y;
    }

    @NotNull
    public final Vector2d getCtrlA() {
        return new Vector2d(this.ctrlAX, this.ctrlAY);
    }

    public final void setCtrlA(@NotNull Vector2d v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.ctrlAX = v.x;
        this.ctrlAY = v.y;
    }

    @NotNull
    public final Vector2d getStart() {
        return new Vector2d(this.startX, this.startY);
    }

    public final void setStart(@NotNull Vector2d v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.startX = v.x;
        this.startY = v.y;
    }

    @NotNull
    public final Vector2d getEnd() {
        return new Vector2d(this.endX, this.endY);
    }

    public final void setEnd(@NotNull Vector2d v) {
        Intrinsics.checkNotNullParameter((Object)v, (String)"v");
        this.endX = v.x;
        this.endY = v.y;
    }

    public final void render(@NotNull GuiGraphics guiGraphics, int xOffset, int yOffset, int points, @NotNull Vector2d scale, int zIndex, float thickness, float r, float g, float b, float a) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        Intrinsics.checkNotNullParameter((Object)scale, (String)"scale");
        Vector2d ofs = new Vector2d((double)xOffset, (double)yOffset);
        int n = 0;
        while (n < points) {
            int it = n++;
            boolean bl = false;
            Vector2d curr = this.getPoint(Float.valueOf((float)it / (float)points)).mul((Vector2dc)scale).add((Vector2dc)ofs);
            Vector2d next = this.getPoint(Float.valueOf(((float)it + 1.0f) / (float)points)).mul((Vector2dc)scale).add((Vector2dc)ofs);
            MiscExt.line(guiGraphics, (float)curr.x, (float)curr.y, (float)next.x, (float)next.y, zIndex, thickness, r, g, b, a);
        }
    }

    public static /* synthetic */ void render$default(BezierCurve bezierCurve, GuiGraphics guiGraphics, int n, int n2, int n3, Vector2d vector2d, int n4, float f, float f2, float f3, float f4, float f5, int n5, Object object) {
        if ((n5 & 0x80) != 0) {
            f2 = 1.0f;
        }
        if ((n5 & 0x100) != 0) {
            f3 = 1.0f;
        }
        if ((n5 & 0x200) != 0) {
            f4 = 1.0f;
        }
        if ((n5 & 0x400) != 0) {
            f5 = 1.0f;
        }
        bezierCurve.render(guiGraphics, n, n2, n3, vector2d, n4, f, f2, f3, f4, f5);
    }

    @NotNull
    public final Vector2d getClosestPoint(double fromX, double fromY, int precisionPoints) {
        double d = 1.0 / (double)precisionPoints;
        double x = 0.0;
        double y = 0.0;
        double delta = 0.0;
        double best = 0.0;
        double bestDistance = Double.POSITIVE_INFINITY;
        double currentDistance = 0.0;
        int i = 0;
        if (i <= precisionPoints) {
            while (true) {
                if ((currentDistance = Point.distanceSq(x = (1.0 - (delta = (double)i * d)) * (1.0 - delta) * (1.0 - delta) * this.startX + (double)3 * (1.0 - delta) * (1.0 - delta) * delta * this.endX + (double)3 * (1.0 - delta) * delta * delta * this.ctrlAX + delta * delta * delta * this.ctrlBX, y = (1.0 - delta) * (1.0 - delta) * (1.0 - delta) * this.startY + (double)3 * (1.0 - delta) * (1.0 - delta) * delta * this.endY + (double)3 * (1.0 - delta) * delta * delta * this.ctrlAY + delta * delta * delta * this.ctrlBY, fromX, fromY)) < bestDistance) {
                    bestDistance = currentDistance;
                    best = delta;
                }
                if (i == precisionPoints) break;
                ++i;
            }
        }
        return this.getPoint(best);
    }

    @NotNull
    public final Vector2d getPoint(@NotNull Number delta) {
        Intrinsics.checkNotNullParameter((Object)delta, (String)"delta");
        double delta2 = delta.doubleValue();
        double u = 1.0 - delta2;
        double tt = delta2 * delta2;
        double uu = u * u;
        double uuu = uu * u;
        double ttt = tt * delta2;
        double x = uuu * this.endX + (double)3 * uu * delta2 * this.ctrlBX + (double)3 * u * tt * this.ctrlAX + ttt * this.startX;
        double y = uuu * this.endY + (double)3 * uu * delta2 * this.ctrlBY + (double)3 * u * tt * this.ctrlAY + ttt * this.startY;
        return new Vector2d(x, y);
    }

    @NotNull
    public final JsonArray toJson() {
        JsonArrayBuilder builder$iv;
        boolean $i$f$buildJsonArray = false;
        JsonArrayBuilder $this$toJson_u24lambda_u240 = builder$iv = new JsonArrayBuilder();
        boolean bl = false;
        $this$toJson_u24lambda_u240.add((JsonElement)JomlVecExtKt.toJson((Vector2dc)this.getStart()));
        $this$toJson_u24lambda_u240.add((JsonElement)JomlVecExtKt.toJson((Vector2dc)this.getEnd()));
        $this$toJson_u24lambda_u240.add((JsonElement)JomlVecExtKt.toJson((Vector2dc)this.getCtrlA()));
        $this$toJson_u24lambda_u240.add((JsonElement)JomlVecExtKt.toJson((Vector2dc)this.getCtrlB()));
        return builder$iv.build();
    }

    @NotNull
    public final BezierCurve loadJson(@NotNull JsonArray jsonArray) {
        Intrinsics.checkNotNullParameter((Object)jsonArray, (String)"jsonArray");
        this.setStart(JomlVecExtKt.loadJson(new Vector2d(), JsonElementKt.getJsonArray((JsonElement)jsonArray.get(0))));
        this.setEnd(JomlVecExtKt.loadJson(new Vector2d(), JsonElementKt.getJsonArray((JsonElement)jsonArray.get(1))));
        this.setCtrlA(JomlVecExtKt.loadJson(new Vector2d(), JsonElementKt.getJsonArray((JsonElement)jsonArray.get(2))));
        this.setCtrlB(JomlVecExtKt.loadJson(new Vector2d(), JsonElementKt.getJsonArray((JsonElement)jsonArray.get(3))));
        return this;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/brokencore/api/client/util/BezierCurve$Companion;", "", "<init>", "()V", "fromJson", "Lnet/thebrokenscript/brokencore/api/client/util/BezierCurve;", "jsonArray", "Lkotlinx/serialization/json/JsonArray;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final BezierCurve fromJson(@NotNull JsonArray jsonArray) {
            Intrinsics.checkNotNullParameter((Object)jsonArray, (String)"jsonArray");
            Vector2d s = JomlVecExtKt.loadJson(new Vector2d(), JsonElementKt.getJsonArray((JsonElement)jsonArray.get(0)));
            Vector2d e = JomlVecExtKt.loadJson(new Vector2d(), JsonElementKt.getJsonArray((JsonElement)jsonArray.get(1)));
            Vector2d a = JomlVecExtKt.loadJson(new Vector2d(), JsonElementKt.getJsonArray((JsonElement)jsonArray.get(2)));
            Vector2d b = JomlVecExtKt.loadJson(new Vector2d(), JsonElementKt.getJsonArray((JsonElement)jsonArray.get(3)));
            return new BezierCurve(s, e, a, b);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

