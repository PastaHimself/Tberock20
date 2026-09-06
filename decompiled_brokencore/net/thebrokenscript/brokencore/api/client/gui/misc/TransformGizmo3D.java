/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.BufferBuilder
 *  com.mojang.blaze3d.vertex.DefaultVertexFormat
 *  com.mojang.blaze3d.vertex.Tesselator
 *  com.mojang.blaze3d.vertex.VertexFormat$Mode
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.MapsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.gui.GuiGraphics
 *  net.minecraft.client.gui.components.events.GuiEventListener
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Matrix4f
 *  org.joml.Vector2f
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.brokencore.api.client.gui.misc;

import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.client.gui.abstr.AbstractGuiNode3D;
import net.thebrokenscript.brokencore.api.client.gui.util.HierarchyScreen;
import net.thebrokenscript.brokencore.api.client.util.ClientMixinBridge;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.ext.JomlVecExtKt;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.render.CensorQuad;
import net.thebrokenscript.brokencore.api.util.math.MathUtilKt;
import net.thebrokenscript.brokencore.api.util.math.VoxelShapeHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010%\u001a\u00020&J\u0018\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020(H\u0016J \u00107\u001a\u00020\u00132\u0006\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020(2\u0006\u00108\u001a\u000209H\u0016J@\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020<2\u0006\u00105\u001a\u0002092\u0006\u00106\u001a\u0002092\u0006\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020(H\u0016J\u0010\u0010A\u001a\u00020&2\u0006\u0010B\u001a\u00020\u0013H\u0016J\b\u0010C\u001a\u00020\u0013H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001b0 X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\"0\"0 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\"0\"0 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020(8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u00020(2\u0006\u0010'\u001a\u00020(8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R$\u00101\u001a\u00020(2\u0006\u0010'\u001a\u00020(8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-\u00a8\u0006E"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/misc/TransformGizmo3D;", "Lnet/thebrokenscript/brokencore/api/client/gui/abstr/AbstractGuiNode3D;", "Lnet/minecraft/client/gui/components/events/GuiEventListener;", "screen", "Lnet/thebrokenscript/brokencore/api/client/gui/util/HierarchyScreen;", "projMat", "Lorg/joml/Matrix4f;", "<init>", "(Lnet/thebrokenscript/brokencore/api/client/gui/util/HierarchyScreen;Lorg/joml/Matrix4f;)V", "getProjMat", "()Lorg/joml/Matrix4f;", "category", "", "getCategory", "()Ljava/lang/String;", "hoveredRingAxis", "Lnet/minecraft/core/Direction$Axis;", "hoveredArrowAxis", "rotating", "", "translating", "dragging", "getDragging", "()Z", "planeClickPos", "Lorg/joml/Vector2f;", "worldClickPos", "Lorg/joml/Vector3f;", "clickAngle", "", "dragPos", "debugHoverDisplay", "", "ringShapes", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "kotlin.jvm.PlatformType", "arrowShapes", "updateShapes", "", "v", "", "x", "getX", "()D", "setX", "(D)V", "y", "getY", "setY", "z", "getZ", "setZ", "mouseMoved", "mouseX", "mouseY", "mouseClicked", "button", "", "render", "guiGraphics", "Lnet/minecraft/client/gui/GuiGraphics;", "partialTick", "globalX", "globalY", "globalZ", "setFocused", "p0", "isFocused", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nTransformGizmo3D.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransformGizmo3D.kt\nnet/thebrokenscript/brokencore/api/client/gui/misc/TransformGizmo3D\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,223:1\n1#2:224\n1869#3,2:225\n*S KotlinDebug\n*F\n+ 1 TransformGizmo3D.kt\nnet/thebrokenscript/brokencore/api/client/gui/misc/TransformGizmo3D\n*L\n170#1:225,2\n*E\n"})
public final class TransformGizmo3D
extends AbstractGuiNode3D
implements GuiEventListener {
    @NotNull
    private static final Companion Companion;
    @NotNull
    private final Matrix4f projMat;
    @NotNull
    private final String category;
    @Nullable
    private Direction.Axis hoveredRingAxis;
    @Nullable
    private Direction.Axis hoveredArrowAxis;
    private boolean rotating;
    private boolean translating;
    @NotNull
    private final Vector2f planeClickPos;
    @NotNull
    private final Vector3f worldClickPos;
    private float clickAngle;
    @NotNull
    private final Vector3f dragPos;
    @NotNull
    private final Map<Direction.Axis, Vector3f> debugHoverDisplay;
    @NotNull
    private volatile Map<Direction.Axis, ? extends VoxelShape> ringShapes;
    @NotNull
    private volatile Map<Direction.Axis, ? extends VoxelShape> arrowShapes;
    @Deprecated
    public static final float RING_MIN_DIST = 2.0f;
    @Deprecated
    public static final float RING_MAX_DIST = 2.125f;
    @Deprecated
    public static final float RING_THICKNESS = 0.125f;
    @Deprecated
    public static final float RING_RADIUS = 2.0625f;
    @Deprecated
    public static final float ARROW_SELECT_DIST = 0.1f;
    @Deprecated
    public static final float ARROW_DIST = 1.0f;
    @Deprecated
    public static final float RING_MIN_SQ = 4.25f;
    @Deprecated
    public static final float RING_MAX_SQ = 4.515625f;
    @Deprecated
    public static final float ARROW_SQ = 0.010000001f;
    @Deprecated
    public static final int RING_DETAIL = 32;
    @Deprecated
    @JvmField
    @NotNull
    public static final List<Double> SIN_TABLE;
    @Deprecated
    @JvmField
    @NotNull
    public static final List<Double> COS_TABLE;

    public TransformGizmo3D(@NotNull HierarchyScreen screen, @NotNull Matrix4f projMat) {
        Intrinsics.checkNotNullParameter((Object)((Object)screen), (String)"screen");
        Intrinsics.checkNotNullParameter((Object)projMat, (String)"projMat");
        super(screen);
        this.projMat = projMat;
        this.category = "";
        this.planeClickPos = new Vector2f(0.0f);
        this.worldClickPos = new Vector3f(0.0f);
        this.dragPos = new Vector3f(0.0f);
        Pair[] pairArray = new Pair[]{TuplesKt.to((Object)Direction.Axis.X, (Object)new Vector3f(0.0f)), TuplesKt.to((Object)Direction.Axis.Y, (Object)new Vector3f(0.0f)), TuplesKt.to((Object)Direction.Axis.Z, (Object)new Vector3f(0.0f))};
        this.debugHoverDisplay = MapsKt.mapOf((Pair[])pairArray);
        pairArray = new Pair[]{TuplesKt.to((Object)Direction.Axis.X, (Object)Shapes.box((double)(this.getX() - (double)2.125f), (double)this.getY(), (double)this.getZ(), (double)(this.getX() + (double)2.125f), (double)this.getY(), (double)this.getZ())), TuplesKt.to((Object)Direction.Axis.Y, (Object)Shapes.box((double)this.getX(), (double)(this.getY() - (double)2.125f), (double)this.getZ(), (double)this.getX(), (double)(this.getY() + (double)2.125f), (double)this.getZ())), TuplesKt.to((Object)Direction.Axis.Z, (Object)Shapes.box((double)this.getX(), (double)this.getY(), (double)(this.getZ() - (double)2.125f), (double)this.getX(), (double)this.getY(), (double)(this.getZ() + (double)2.125f)))};
        this.ringShapes = MapsKt.mapOf((Pair[])pairArray);
        pairArray = new Pair[]{TuplesKt.to((Object)Direction.Axis.X, (Object)Shapes.box((double)(this.getX() + (double)1.0f), (double)(this.getY() - (double)1.0f), (double)(this.getZ() - (double)1.0f), (double)(this.getX() + (double)2.0f), (double)(this.getY() + (double)1.0f), (double)(this.getZ() + (double)1.0f))), TuplesKt.to((Object)Direction.Axis.Y, (Object)Shapes.box((double)(this.getX() - (double)1.0f), (double)(this.getY() + (double)1.0f), (double)(this.getZ() - (double)1.0f), (double)(this.getX() + (double)1.0f), (double)(this.getY() + (double)2.0f), (double)(this.getZ() + (double)1.0f))), TuplesKt.to((Object)Direction.Axis.Z, (Object)Shapes.box((double)(this.getX() - (double)1.0f), (double)(this.getY() - (double)1.0f), (double)(this.getZ() + (double)1.0f), (double)(this.getX() + (double)1.0f), (double)(this.getY() + (double)1.0f), (double)(this.getZ() + (double)2.0f)))};
        this.arrowShapes = MapsKt.mapOf((Pair[])pairArray);
    }

    public /* synthetic */ TransformGizmo3D(HierarchyScreen hierarchyScreen, Matrix4f matrix4f, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            matrix4f = ClientMixinBridge.INSTANCE.getWorldProjectionMatrix(ClientDSLKt.getMC());
        }
        this(hierarchyScreen, matrix4f);
    }

    @NotNull
    public final Matrix4f getProjMat() {
        return this.projMat;
    }

    @Override
    @NotNull
    public String getCategory() {
        return this.category;
    }

    private final boolean getDragging() {
        return this.rotating || this.translating;
    }

    public final void updateShapes() {
        if (!this.translating) {
            Pair[] pairArray = new Pair[]{TuplesKt.to((Object)Direction.Axis.X, (Object)Shapes.box((double)(this.getX() + (double)1.0f), (double)(this.getY() - (double)1.0f), (double)(this.getZ() - (double)1.0f), (double)(this.getX() + (double)2.0f), (double)(this.getY() + (double)1.0f), (double)(this.getZ() + (double)1.0f))), TuplesKt.to((Object)Direction.Axis.Y, (Object)Shapes.box((double)(this.getX() - (double)1.0f), (double)(this.getY() + (double)1.0f), (double)(this.getZ() - (double)1.0f), (double)(this.getX() + (double)1.0f), (double)(this.getY() + (double)2.0f), (double)(this.getZ() + (double)1.0f))), TuplesKt.to((Object)Direction.Axis.Z, (Object)Shapes.box((double)(this.getX() - (double)1.0f), (double)(this.getY() - (double)1.0f), (double)(this.getZ() + (double)1.0f), (double)(this.getX() + (double)1.0f), (double)(this.getY() + (double)1.0f), (double)(this.getZ() + (double)2.0f)))};
            this.arrowShapes = MapsKt.mapOf((Pair[])pairArray);
            pairArray = new Pair[]{TuplesKt.to((Object)Direction.Axis.X, (Object)Shapes.box((double)(this.getX() - (double)2.125f), (double)this.getY(), (double)this.getZ(), (double)(this.getX() + (double)2.125f), (double)this.getY(), (double)this.getZ())), TuplesKt.to((Object)Direction.Axis.Y, (Object)Shapes.box((double)this.getX(), (double)(this.getY() - (double)2.125f), (double)this.getZ(), (double)this.getX(), (double)(this.getY() + (double)2.125f), (double)this.getZ())), TuplesKt.to((Object)Direction.Axis.Z, (Object)Shapes.box((double)this.getX(), (double)this.getY(), (double)(this.getZ() - (double)2.125f), (double)this.getX(), (double)this.getY(), (double)(this.getZ() + (double)2.125f)))};
            this.ringShapes = MapsKt.mapOf((Pair[])pairArray);
        }
    }

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public void setX(double v) {
        super.setX(v);
        this.updateShapes();
    }

    @Override
    public double getY() {
        return super.getY();
    }

    @Override
    public void setY(double v) {
        super.setY(v);
        this.updateShapes();
    }

    @Override
    public double getZ() {
        return super.getZ();
    }

    @Override
    public void setZ(double v) {
        super.setZ(v);
        this.updateShapes();
    }

    public void mouseMoved(double mouseX, double mouseY) {
        block6: {
            block5: {
                boolean hitRing = false;
                Direction.Axis resultAxis = null;
                if (this.getDragging()) break block5;
                Pair<Vector3f, Vector3f> dirPos = MathUtilKt.getCursorWorldDirAndPos(this.projMat);
                float dist = ((Vector3f)dirPos.getSecond()).distance((Vector3fc)this.getPositionF()) + (float)10;
                for (Direction.Axis axis : CollectionsKt.reversed((Iterable)JomlVecExtKt.getAxesByLargest((Vector3f)dirPos.getFirst()))) {
                    VoxelShape voxelShape = this.arrowShapes.get(axis);
                    Intrinsics.checkNotNull((Object)voxelShape);
                    if (MathUtilKt.rayCastAtCursor$default(voxelShape, Float.valueOf(dist), null, 2, null) != null) {
                        resultAxis = axis;
                        break;
                    }
                    VoxelShape voxelShape2 = this.ringShapes.get(axis);
                    Intrinsics.checkNotNull((Object)voxelShape2);
                    VoxelShapeHitResult voxelShapeHitResult = MathUtilKt.rayCastAtCursor$default(voxelShape2, Float.valueOf(dist), null, 2, null);
                    if (voxelShapeHitResult == null || (voxelShapeHitResult = voxelShapeHitResult.getHitPos()) == null) continue;
                    VoxelShapeHitResult ringHitPos = voxelShapeHitResult;
                    float dist2 = ringHitPos.distanceSquared((Vector3fc)this.getPositionF());
                    boolean bl = 4.25f <= dist2 ? dist2 <= 4.515625f : false;
                    if (!bl) continue;
                    resultAxis = axis;
                    hitRing = true;
                    break;
                }
                if (hitRing) {
                    this.hoveredRingAxis = resultAxis;
                    this.hoveredArrowAxis = null;
                } else {
                    this.hoveredArrowAxis = resultAxis;
                    this.hoveredRingAxis = null;
                }
                break block6;
            }
            if (!this.rotating || this.hoveredRingAxis == null) break block6;
            Pair<Vector3f, Vector3f> dirPos = MathUtilKt.getCursorWorldDirAndPos(this.projMat);
            float dist = ((Vector3f)dirPos.getSecond()).distance((Vector3fc)this.getPositionF()) + (float)10;
            VoxelShape voxelShape = this.ringShapes.get(this.hoveredRingAxis);
            Intrinsics.checkNotNull((Object)voxelShape);
            VoxelShapeHitResult voxelShapeHitResult = MathUtilKt.rayCastAtCursor$default(voxelShape, Float.valueOf(dist), null, 2, null);
            if (voxelShapeHitResult != null && (voxelShapeHitResult = voxelShapeHitResult.getHitPos()) != null) {
                VoxelShapeHitResult it = voxelShapeHitResult;
                boolean bl = false;
            }
        }
    }

    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        block2: {
            Direction.Axis it;
            if (button != 0) break block2;
            Direction.Axis axis = this.hoveredArrowAxis;
            if (axis != null) {
                it = axis;
                boolean bl = false;
                TransformGizmo3D.mouseClicked$update(this, it, false);
            }
            Direction.Axis axis2 = this.hoveredRingAxis;
            if (axis2 != null) {
                it = axis2;
                boolean bl = false;
                TransformGizmo3D.mouseClicked$update(this, it, true);
            }
        }
        return true;
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick, double globalX, double globalY, double globalZ) {
        Intrinsics.checkNotNullParameter((Object)guiGraphics, (String)"guiGraphics");
        BufferBuilder buf = Tesselator.getInstance().begin(VertexFormat.Mode.LINES, DefaultVertexFormat.POSITION_COLOR_NORMAL);
        int n = 32;
        for (int i = 0; i < n; ++i) {
            int it = i;
            boolean bl = false;
            int next = it == 31 ? 0 : it + 1;
            float x1 = (float)(((Number)COS_TABLE.get(it)).doubleValue() * (double)2.0625f);
            float y1 = (float)(((Number)SIN_TABLE.get(it)).doubleValue() * (double)2.0625f);
            float x2 = (float)(((Number)COS_TABLE.get(next)).doubleValue() * (double)2.0625f);
            float y2 = (float)(((Number)SIN_TABLE.get(next)).doubleValue() * (double)2.0625f);
            Iterable $this$forEach$iv = (Iterable)EntriesMappings.entries$0;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Vector3f vector3f;
                Direction.Axis axis = (Direction.Axis)element$iv;
                boolean bl2 = false;
                if (this.hoveredRingAxis == axis) {
                    vector3f = new Vector3f(1.0f, 1.0f, 1.0f);
                } else {
                    switch (WhenMappings.$EnumSwitchMapping$0[axis.ordinal()]) {
                        case 1: {
                            vector3f = new Vector3f(1.0f, 0.0f, 0.0f);
                            break;
                        }
                        case 2: {
                            vector3f = new Vector3f(0.0f, 1.0f, 0.0f);
                            break;
                        }
                        case 3: {
                            vector3f = new Vector3f(0.0f, 0.0f, 1.0f);
                            break;
                        }
                        default: {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
                Vector3f rgb = vector3f;
                Vector3f vector3f2 = (switch (WhenMappings.$EnumSwitchMapping$0[axis.ordinal()]) {
                    case 1 -> new Vector3f(x1, y1, 0.0f);
                    case 2 -> new Vector3f(x1, 0.0f, y1);
                    case 3 -> new Vector3f(0.0f, y1, x1);
                    default -> throw new NoWhenBranchMatchedException();
                }).add((Vector3fc)this.getPositionF()).negate();
                Intrinsics.checkNotNullExpressionValue((Object)vector3f2, (String)"negate(...)");
                Vector3f s = CensorQuad.projectPositionToScreen$default(CensorQuad.INSTANCE, vector3f2, 0.0f, 2, null);
                Vector3f vector3f3 = (switch (WhenMappings.$EnumSwitchMapping$0[axis.ordinal()]) {
                    case 1 -> new Vector3f(x2, y2, 0.0f);
                    case 2 -> new Vector3f(x2, 0.0f, y2);
                    case 3 -> new Vector3f(0.0f, y2, x2);
                    default -> throw new NoWhenBranchMatchedException();
                }).add((Vector3fc)this.getPositionF()).negate();
                Intrinsics.checkNotNullExpressionValue((Object)vector3f3, (String)"negate(...)");
                Vector3f e = CensorQuad.projectPositionToScreen$default(CensorQuad.INSTANCE, vector3f3, 0.0f, 2, null);
                if (!(s.z > 0.0f) && !(e.z > 0.0f)) continue;
                MiscExt.line(guiGraphics, s.x, s.y, e.x, e.y, 0, 2.0f, rgb.x, rgb.y, rgb.z, 1.0f);
            }
        }
        super.render(guiGraphics, mouseX, mouseY, partialTick, globalX, globalY, globalZ);
    }

    public void setFocused(boolean p0) {
    }

    public boolean isFocused() {
        return false;
    }

    private static final void mouseClicked$update(TransformGizmo3D this$0, Direction.Axis axis, boolean rings) {
        block10: {
            Map<Direction.Axis, ? extends VoxelShape> arr = rings ? this$0.ringShapes : this$0.arrowShapes;
            Pair<Vector3f, Vector3f> dirPos = MathUtilKt.getCursorWorldDirAndPos(this$0.projMat);
            float dist = ((Vector3f)dirPos.getSecond()).distance((Vector3fc)this$0.getPositionF()) + (float)10;
            VoxelShape voxelShape = arr.get(axis);
            Intrinsics.checkNotNull((Object)voxelShape);
            VoxelShapeHitResult voxelShapeHitResult = MathUtilKt.rayCastAtCursor$default(voxelShape, Float.valueOf(dist), null, 2, null);
            if (voxelShapeHitResult == null || (voxelShapeHitResult = voxelShapeHitResult.getHitPos()) == null) break block10;
            VoxelShapeHitResult it = voxelShapeHitResult;
            boolean bl = false;
            switch (WhenMappings.$EnumSwitchMapping$0[axis.ordinal()]) {
                case 1: {
                    Vector2f vector2f = this$0.planeClickPos.set(((Vector3f)it).x, ((Vector3f)it).y);
                    break;
                }
                case 2: {
                    Vector2f vector2f = this$0.planeClickPos.set(((Vector3f)it).x, ((Vector3f)it).z);
                    break;
                }
                case 3: {
                    Vector2f vector2f = this$0.planeClickPos.set(((Vector3f)it).z, ((Vector3f)it).y);
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            Vector2f selfPos = switch (WhenMappings.$EnumSwitchMapping$0[axis.ordinal()]) {
                case 1 -> new Vector2f((float)this$0.getX(), (float)this$0.getY());
                case 2 -> new Vector2f((float)this$0.getX(), (float)this$0.getZ());
                case 3 -> new Vector2f((float)this$0.getZ(), (float)this$0.getY());
                default -> throw new NoWhenBranchMatchedException();
            };
            this$0.worldClickPos.set((Vector3fc)it);
            this$0.clickAngle = MathUtilKt.getAngleTo(this$0.planeClickPos, selfPos);
        }
    }

    static {
        int it;
        List list;
        Companion = new Companion(null);
        List $this$SIN_TABLE_u24lambda_u240 = list = CollectionsKt.createListBuilder();
        boolean bl = false;
        int n = 32;
        int n2 = 0;
        while (n2 < n) {
            it = n2++;
            boolean bl2 = false;
            $this$SIN_TABLE_u24lambda_u240.add(Math.sin((double)((float)it / 32.0f) * Math.PI * (double)2));
        }
        SIN_TABLE = CollectionsKt.build((List)list);
        List $this$COS_TABLE_u24lambda_u240 = list = CollectionsKt.createListBuilder();
        boolean bl3 = false;
        n = 32;
        n2 = 0;
        while (n2 < n) {
            it = n2++;
            boolean bl4 = false;
            $this$COS_TABLE_u24lambda_u240.add(Math.cos((double)((float)it / 32.0f) * Math.PI * (double)2));
        }
        COS_TABLE = CollectionsKt.build((List)list);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/client/gui/misc/TransformGizmo3D$Companion;", "", "<init>", "()V", "RING_MIN_DIST", "", "RING_MAX_DIST", "RING_THICKNESS", "RING_RADIUS", "ARROW_SELECT_DIST", "ARROW_DIST", "RING_MIN_SQ", "RING_MAX_SQ", "ARROW_SQ", "RING_DETAIL", "", "SIN_TABLE", "", "", "COS_TABLE", "brokencore-common"})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Direction.Axis> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Direction.Axis.values()));
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[Direction.Axis.values().length];
            try {
                nArray[Direction.Axis.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.Axis.Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[Direction.Axis.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

