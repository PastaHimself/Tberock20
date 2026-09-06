/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$IntRef
 *  kotlin.math.MathKt
 *  kotlin.ranges.RangesKt
 *  net.minecraft.client.gui.navigation.ScreenRectangle
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4d
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaterniond
 *  org.joml.Quaterniondc
 *  org.joml.Quaternionf
 *  org.joml.Quaternionfc
 *  org.joml.Vector3d
 *  org.joml.Vector3dc
 */
package net.thebrokenscript.brokencore.api.ext;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4d;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaterniond;
import org.joml.Quaterniondc;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3d;
import org.joml.Vector3dc;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a-\u0010\u0005\u001a\u00020\u0006*\u00020\u00022!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b\u001a2\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0017"}, d2={"sizeBox", "Lnet/minecraft/world/phys/Vec3;", "Lnet/minecraft/world/phys/AABB;", "getSizeBox", "(Lnet/minecraft/world/phys/AABB;)Lnet/minecraft/world/phys/Vec3;", "forEachCorner", "", "consumer", "Lkotlin/Function1;", "Lorg/joml/Vector3d;", "Lkotlin/ParameterName;", "name", "pos", "toScreenRect", "Lnet/minecraft/client/gui/navigation/ScreenRectangle;", "modelMatrix", "Lorg/joml/Matrix4f;", "projectionMatrix", "cameraQuaternion", "Lorg/joml/Quaternionf;", "screenWidth", "", "screenHeight", "brokencore-common"})
public final class BoundingBoxExtKt {
    @NotNull
    public static final Vec3 getSizeBox(@NotNull AABB $this$sizeBox) {
        Intrinsics.checkNotNullParameter((Object)$this$sizeBox, (String)"<this>");
        return new Vec3($this$sizeBox.getXsize(), $this$sizeBox.getYsize(), $this$sizeBox.getZsize());
    }

    public static final void forEachCorner(@NotNull AABB $this$forEachCorner, @NotNull Function1<? super Vector3d, Unit> consumer) {
        Intrinsics.checkNotNullParameter((Object)$this$forEachCorner, (String)"<this>");
        Intrinsics.checkNotNullParameter(consumer, (String)"consumer");
        consumer.invoke((Object)new Vector3d($this$forEachCorner.minX, $this$forEachCorner.minY, $this$forEachCorner.minZ));
        consumer.invoke((Object)new Vector3d($this$forEachCorner.maxX, $this$forEachCorner.maxY, $this$forEachCorner.maxZ));
        consumer.invoke((Object)new Vector3d($this$forEachCorner.maxX, $this$forEachCorner.minY, $this$forEachCorner.minZ));
        consumer.invoke((Object)new Vector3d($this$forEachCorner.minX, $this$forEachCorner.maxY, $this$forEachCorner.minZ));
        consumer.invoke((Object)new Vector3d($this$forEachCorner.minX, $this$forEachCorner.minY, $this$forEachCorner.maxZ));
        consumer.invoke((Object)new Vector3d($this$forEachCorner.maxX, $this$forEachCorner.maxY, $this$forEachCorner.minZ));
        consumer.invoke((Object)new Vector3d($this$forEachCorner.minX, $this$forEachCorner.maxY, $this$forEachCorner.maxZ));
        consumer.invoke((Object)new Vector3d($this$forEachCorner.maxX, $this$forEachCorner.minY, $this$forEachCorner.maxZ));
    }

    @NotNull
    public static final ScreenRectangle toScreenRect(@NotNull AABB $this$toScreenRect, @NotNull Matrix4f modelMatrix, @NotNull Matrix4f projectionMatrix, @NotNull Quaternionf cameraQuaternion, int screenWidth, int screenHeight) {
        Intrinsics.checkNotNullParameter((Object)$this$toScreenRect, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)modelMatrix, (String)"modelMatrix");
        Intrinsics.checkNotNullParameter((Object)projectionMatrix, (String)"projectionMatrix");
        Intrinsics.checkNotNullParameter((Object)cameraQuaternion, (String)"cameraQuaternion");
        Ref.IntRef minX = new Ref.IntRef();
        minX.element = Integer.MAX_VALUE;
        Ref.IntRef minY = new Ref.IntRef();
        minY.element = Integer.MAX_VALUE;
        Ref.IntRef maxX = new Ref.IntRef();
        maxX.element = Integer.MIN_VALUE;
        Ref.IntRef maxY = new Ref.IntRef();
        maxY.element = Integer.MIN_VALUE;
        BoundingBoxExtKt.forEachCorner($this$toScreenRect, (Function1<? super Vector3d, Unit>)((Function1)arg_0 -> BoundingBoxExtKt.toScreenRect$lambda$0(modelMatrix, cameraQuaternion, projectionMatrix, screenWidth, screenHeight, minX, minY, maxX, maxY, arg_0)));
        return new ScreenRectangle(minX.element, minY.element, maxX.element - minX.element, maxY.element - minY.element);
    }

    private static final Unit toScreenRect$lambda$0(Matrix4f $modelMatrix, Quaternionf $cameraQuaternion, Matrix4f $projectionMatrix, int $screenWidth, int $screenHeight, Ref.IntRef $minX, Ref.IntRef $minY, Ref.IntRef $maxX, Ref.IntRef $maxY, Vector3d vert) {
        Intrinsics.checkNotNullParameter((Object)vert, (String)"vert");
        new Matrix4d((Matrix4fc)$modelMatrix).scale(-1.0).transformPosition(vert);
        vert.rotate((Quaterniondc)new Quaterniond((Quaternionfc)$cameraQuaternion));
        int[] nArray = new int[]{0, 0, $screenWidth, $screenHeight};
        Vector3d result = new Matrix4d((Matrix4fc)$projectionMatrix).project((Vector3dc)vert, nArray, new Vector3d());
        $minX.element = RangesKt.coerceAtMost((int)MathKt.roundToInt((double)result.x), (int)$minX.element);
        $minY.element = RangesKt.coerceAtMost((int)MathKt.roundToInt((double)result.y), (int)$minX.element);
        $maxX.element = RangesKt.coerceAtLeast((int)MathKt.roundToInt((double)result.x), (int)$minX.element);
        $maxY.element = RangesKt.coerceAtLeast((int)MathKt.roundToInt((double)result.y), (int)$minX.element);
        return Unit.INSTANCE;
    }
}

