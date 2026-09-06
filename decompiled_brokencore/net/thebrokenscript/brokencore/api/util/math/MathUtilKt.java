/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.Shapes
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Intersectionf
 *  org.joml.Matrix4f
 *  org.joml.RayAabIntersection
 *  org.joml.Vector2d
 *  org.joml.Vector2f
 *  org.joml.Vector3f
 *  org.joml.Vector3fc
 */
package net.thebrokenscript.brokencore.api.util.math;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.client.util.ClientMixinBridge;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.ext.RayExt;
import net.thebrokenscript.brokencore.api.util.MiscUtilKt;
import net.thebrokenscript.brokencore.api.util.math.VoxelShapeHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Intersectionf;
import org.joml.Matrix4f;
import org.joml.RayAabIntersection;
import org.joml.Vector2d;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector3fc;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000z\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003\u001a-\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u0002H\u00112\u0006\u0010\u0005\u001a\u0002H\u0011\u00a2\u0006\u0002\u0010\u0012\u001a\u001d\u0010\u0013\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00032\u0006\u0010\u0014\u001a\u0002H\u0011\u00a2\u0006\u0002\u0010\u0015\u001a$\u0010\u0016\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u0003*\u0002H\u00112\u0006\u0010\u0014\u001a\u0002H\u0011H\u0086\u0002\u00a2\u0006\u0002\u0010\u0017\u001a\u001c\u0010\u0018\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u0003*\u0002H\u0011H\u0086\u0002\u00a2\u0006\u0002\u0010\u0015\u001a$\u0010\u0019\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u0003*\u0002H\u00112\u0006\u0010\u0014\u001a\u0002H\u0011H\u0086\u0002\u00a2\u0006\u0002\u0010\u0017\u001a$\u0010\u001a\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u0003*\u0002H\u00112\u0006\u0010\u0014\u001a\u0002H\u0011H\u0086\u0002\u00a2\u0006\u0002\u0010\u0017\u001a$\u0010\u001b\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u0003*\u0002H\u00112\u0006\u0010\u0014\u001a\u0002H\u0011H\u0086\u0002\u00a2\u0006\u0002\u0010\u0017\u001a$\u0010\u001c\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u0003*\u0002H\u00112\u0006\u0010\u0014\u001a\u0002H\u0011H\u0086\u0002\u00a2\u0006\u0002\u0010\u0017\u001a \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\"\u001a \u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\"\u001a,\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0%2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\"\u001a\u0010\u0010&\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020\"\u001a\u0010\u0010'\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020\"\u001a\u001c\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0%2\b\b\u0002\u0010!\u001a\u00020\"\u001a\u001e\u0010)\u001a\u0004\u0018\u00010**\u00020+2\u0006\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020.\u001a\u0014\u0010)\u001a\u00020/*\u0002002\b\b\u0002\u0010,\u001a\u00020\u0003\u001a6\u00101\u001a\u0002022\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003\u001a/\u00107\u001a\u0002H\u0011\"\u000e\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u001108*\u0002H\u00112\u0006\u00109\u001a\u0002H\u00112\u0006\u0010:\u001a\u0002H\u0011\u00a2\u0006\u0002\u0010;\u001a\u0016\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>\u001a\u001e\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t2\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003\u001a\u001e\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003\u001a\u001e\u0010@\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u00012\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003\u001a\u001e\u0010@\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u0003\u00a8\u0006B"}, d2={"lerpf", "", "delta", "", "start", "end", "lerpd", "", "lerpi", "", "lerpl", "", "lerps", "", "lerpb", "", "lerpN", "T", "(FLjava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;", "absN", "n", "(Ljava/lang/Number;)Ljava/lang/Number;", "rem", "(Ljava/lang/Number;Ljava/lang/Number;)Ljava/lang/Number;", "unaryMinus", "times", "minus", "plus", "div", "screenPosToWorldPos", "Lorg/joml/Vector3f;", "x", "y", "projMat", "Lorg/joml/Matrix4f;", "screenPosToWorldDir", "screenPosToWorldPosAndDir", "Lkotlin/Pair;", "getCursorWorldPos", "getCursorWorldDir", "getCursorWorldDirAndPos", "rayCastAtCursor", "Lnet/thebrokenscript/brokencore/api/util/math/VoxelShapeHitResult;", "Lnet/minecraft/world/phys/shapes/VoxelShape;", "distance", "blockPos", "Lnet/minecraft/core/BlockPos;", "Lnet/minecraft/world/phys/BlockHitResult;", "Lnet/minecraft/client/multiplayer/ClientLevel;", "pointInsideOval", "", "originX", "originY", "horizontalRadius", "verticalRadius", "clamp", "", "min", "max", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "getAngleTo", "from", "Lorg/joml/Vector2f;", "to", "wrap", "value", "brokencore-common"})
public final class MathUtilKt {
    public static final float lerpf(@NotNull Number delta, @NotNull Number start, @NotNull Number end) {
        Intrinsics.checkNotNullParameter((Object)delta, (String)"delta");
        Intrinsics.checkNotNullParameter((Object)start, (String)"start");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        return start.floatValue() + delta.floatValue() * (end.floatValue() - start.floatValue());
    }

    public static final float lerpf(float delta, @NotNull Number start, @NotNull Number end) {
        Intrinsics.checkNotNullParameter((Object)start, (String)"start");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        return start.floatValue() + delta * (end.floatValue() - start.floatValue());
    }

    public static final double lerpd(float delta, @NotNull Number start, @NotNull Number end) {
        Intrinsics.checkNotNullParameter((Object)start, (String)"start");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        return start.doubleValue() + (double)delta * (end.doubleValue() - start.doubleValue());
    }

    public static final int lerpi(float delta, @NotNull Number start, @NotNull Number end) {
        Intrinsics.checkNotNullParameter((Object)start, (String)"start");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        return (int)((float)start.intValue() + delta * (float)(end.intValue() - start.intValue()));
    }

    public static final long lerpl(float delta, @NotNull Number start, @NotNull Number end) {
        Intrinsics.checkNotNullParameter((Object)start, (String)"start");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        return (long)((float)start.longValue() + delta * (float)(end.longValue() - start.longValue()));
    }

    public static final short lerps(float delta, @NotNull Number start, @NotNull Number end) {
        Intrinsics.checkNotNullParameter((Object)start, (String)"start");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        return (short)((float)start.shortValue() + delta * (float)(end.shortValue() - start.shortValue()));
    }

    public static final byte lerpb(float delta, @NotNull Number start, @NotNull Number end) {
        Intrinsics.checkNotNullParameter((Object)start, (String)"start");
        Intrinsics.checkNotNullParameter((Object)end, (String)"end");
        return (byte)((float)start.byteValue() + delta * (float)(end.byteValue() - start.byteValue()));
    }

    @NotNull
    public static final <T extends Number> T lerpN(float delta, @NotNull T start, @NotNull T end) {
        Number number;
        Intrinsics.checkNotNullParameter(start, (String)"start");
        Intrinsics.checkNotNullParameter(end, (String)"end");
        T t = start;
        if (t instanceof Integer) {
            number = MathUtilKt.lerpi(delta, start, end);
        } else if (t instanceof Long) {
            number = MathUtilKt.lerpl(delta, start, end);
        } else if (t instanceof Float) {
            number = Float.valueOf(MathUtilKt.lerpf(delta, start, end));
        } else if (t instanceof Double) {
            number = MathUtilKt.lerpd(delta, start, end);
        } else if (t instanceof Short) {
            number = MathUtilKt.lerps(delta, start, end);
        } else if (t instanceof Byte) {
            number = MathUtilKt.lerpb(delta, start, end);
        } else {
            throw new RuntimeException("Unknown number class " + start.getClass());
        }
        return (T)number;
    }

    @NotNull
    public static final <T extends Number> T absN(@NotNull T n) {
        Number number;
        Intrinsics.checkNotNullParameter(n, (String)"n");
        T t = n;
        if (t instanceof Integer) {
            number = Math.abs(n.intValue());
        } else if (t instanceof Long) {
            number = Math.abs(n.longValue());
        } else if (t instanceof Float) {
            number = Float.valueOf(Math.abs(n.floatValue()));
        } else if (t instanceof Double) {
            number = Math.abs(n.doubleValue());
        } else if (t instanceof Short) {
            number = (short)Math.abs(n.shortValue());
        } else if (t instanceof Byte) {
            number = (byte)Math.abs(n.byteValue());
        } else {
            throw new RuntimeException("Unknown number class " + n.getClass());
        }
        return (T)number;
    }

    @NotNull
    public static final <T extends Number> T rem(@NotNull T $this$rem, @NotNull T n) {
        Number number;
        Intrinsics.checkNotNullParameter($this$rem, (String)"<this>");
        Intrinsics.checkNotNullParameter(n, (String)"n");
        T t = n;
        if (t instanceof Integer) {
            number = $this$rem.intValue() % n.intValue();
        } else if (t instanceof Long) {
            number = $this$rem.longValue() % n.longValue();
        } else if (t instanceof Float) {
            number = Float.valueOf($this$rem.floatValue() % n.floatValue());
        } else if (t instanceof Double) {
            number = $this$rem.doubleValue() % n.doubleValue();
        } else if (t instanceof Short) {
            number = (short)($this$rem.intValue() % n.shortValue());
        } else if (t instanceof Byte) {
            number = (byte)($this$rem.intValue() % n.byteValue());
        } else {
            throw new RuntimeException("Unknown number class " + n.getClass());
        }
        return (T)number;
    }

    @NotNull
    public static final <T extends Number> T unaryMinus(@NotNull T $this$unaryMinus) {
        Number number;
        Intrinsics.checkNotNullParameter($this$unaryMinus, (String)"<this>");
        T t = $this$unaryMinus;
        if (t instanceof Integer) {
            number = -$this$unaryMinus.intValue();
        } else if (t instanceof Long) {
            number = -$this$unaryMinus.longValue();
        } else if (t instanceof Float) {
            number = Float.valueOf(-$this$unaryMinus.floatValue());
        } else if (t instanceof Double) {
            number = -$this$unaryMinus.doubleValue();
        } else if (t instanceof Short) {
            number = -$this$unaryMinus.shortValue();
        } else if (t instanceof Byte) {
            number = -$this$unaryMinus.byteValue();
        } else {
            throw new RuntimeException("Unknown number class " + $this$unaryMinus.getClass());
        }
        return (T)number;
    }

    @NotNull
    public static final <T extends Number> T times(@NotNull T $this$times, @NotNull T n) {
        Number number;
        Intrinsics.checkNotNullParameter($this$times, (String)"<this>");
        Intrinsics.checkNotNullParameter(n, (String)"n");
        T t = n;
        if (t instanceof Integer) {
            number = $this$times.intValue() * n.intValue();
        } else if (t instanceof Long) {
            number = $this$times.longValue() * n.longValue();
        } else if (t instanceof Float) {
            number = Float.valueOf($this$times.floatValue() * n.floatValue());
        } else if (t instanceof Double) {
            number = $this$times.doubleValue() * n.doubleValue();
        } else if (t instanceof Short) {
            number = (short)($this$times.intValue() * n.shortValue());
        } else if (t instanceof Byte) {
            number = (byte)($this$times.intValue() * n.byteValue());
        } else {
            throw new RuntimeException("Unknown number class " + n.getClass());
        }
        return (T)number;
    }

    @NotNull
    public static final <T extends Number> T minus(@NotNull T $this$minus, @NotNull T n) {
        Number number;
        Intrinsics.checkNotNullParameter($this$minus, (String)"<this>");
        Intrinsics.checkNotNullParameter(n, (String)"n");
        T t = n;
        if (t instanceof Integer) {
            number = $this$minus.intValue() - n.intValue();
        } else if (t instanceof Long) {
            number = $this$minus.longValue() - n.longValue();
        } else if (t instanceof Float) {
            number = Float.valueOf($this$minus.floatValue() - n.floatValue());
        } else if (t instanceof Double) {
            number = $this$minus.doubleValue() - n.doubleValue();
        } else if (t instanceof Short) {
            number = (short)($this$minus.intValue() - n.shortValue());
        } else if (t instanceof Byte) {
            number = (byte)($this$minus.intValue() - n.byteValue());
        } else {
            throw new RuntimeException("Unknown number class " + n.getClass());
        }
        return (T)number;
    }

    @NotNull
    public static final <T extends Number> T plus(@NotNull T $this$plus, @NotNull T n) {
        Number number;
        Intrinsics.checkNotNullParameter($this$plus, (String)"<this>");
        Intrinsics.checkNotNullParameter(n, (String)"n");
        T t = n;
        if (t instanceof Integer) {
            number = $this$plus.intValue() + n.intValue();
        } else if (t instanceof Long) {
            number = $this$plus.longValue() + n.longValue();
        } else if (t instanceof Float) {
            number = Float.valueOf($this$plus.floatValue() + n.floatValue());
        } else if (t instanceof Double) {
            number = $this$plus.doubleValue() + n.doubleValue();
        } else if (t instanceof Short) {
            number = (short)($this$plus.intValue() + n.shortValue());
        } else if (t instanceof Byte) {
            number = (byte)($this$plus.intValue() + n.byteValue());
        } else {
            throw new RuntimeException("Unknown number class " + n.getClass());
        }
        return (T)number;
    }

    @NotNull
    public static final <T extends Number> T div(@NotNull T $this$div, @NotNull T n) {
        Number number;
        Intrinsics.checkNotNullParameter($this$div, (String)"<this>");
        Intrinsics.checkNotNullParameter(n, (String)"n");
        T t = n;
        if (t instanceof Integer) {
            number = $this$div.intValue() / n.intValue();
        } else if (t instanceof Long) {
            number = $this$div.longValue() / n.longValue();
        } else if (t instanceof Float) {
            number = Float.valueOf($this$div.floatValue() / n.floatValue());
        } else if (t instanceof Double) {
            number = $this$div.doubleValue() / n.doubleValue();
        } else if (t instanceof Short) {
            number = (short)($this$div.intValue() / n.shortValue());
        } else if (t instanceof Byte) {
            number = (byte)($this$div.intValue() / n.byteValue());
        } else {
            throw new RuntimeException("Unknown number class " + n.getClass());
        }
        return (T)number;
    }

    @NotNull
    public static final Vector3f screenPosToWorldPos(@NotNull Number x, @NotNull Number y, @NotNull Matrix4f projMat) {
        Intrinsics.checkNotNullParameter((Object)x, (String)"x");
        Intrinsics.checkNotNullParameter((Object)y, (String)"y");
        Intrinsics.checkNotNullParameter((Object)projMat, (String)"projMat");
        return (Vector3f)MathUtilKt.screenPosToWorldPosAndDir(x, y, projMat).getSecond();
    }

    public static /* synthetic */ Vector3f screenPosToWorldPos$default(Number number, Number number2, Matrix4f matrix4f, int n, Object object) {
        if ((n & 4) != 0) {
            matrix4f = ClientMixinBridge.INSTANCE.getWorldProjectionMatrix(ClientDSLKt.getMC());
        }
        return MathUtilKt.screenPosToWorldPos(number, number2, matrix4f);
    }

    @NotNull
    public static final Vector3f screenPosToWorldDir(@NotNull Number x, @NotNull Number y, @NotNull Matrix4f projMat) {
        Intrinsics.checkNotNullParameter((Object)x, (String)"x");
        Intrinsics.checkNotNullParameter((Object)y, (String)"y");
        Intrinsics.checkNotNullParameter((Object)projMat, (String)"projMat");
        return (Vector3f)MathUtilKt.screenPosToWorldPosAndDir(x, y, projMat).getFirst();
    }

    public static /* synthetic */ Vector3f screenPosToWorldDir$default(Number number, Number number2, Matrix4f matrix4f, int n, Object object) {
        if ((n & 4) != 0) {
            matrix4f = ClientMixinBridge.INSTANCE.getWorldProjectionMatrix(ClientDSLKt.getMC());
        }
        return MathUtilKt.screenPosToWorldDir(number, number2, matrix4f);
    }

    @NotNull
    public static final Pair<Vector3f, Vector3f> screenPosToWorldPosAndDir(@NotNull Number x, @NotNull Number y, @NotNull Matrix4f projMat) {
        Intrinsics.checkNotNullParameter((Object)x, (String)"x");
        Intrinsics.checkNotNullParameter((Object)y, (String)"y");
        Intrinsics.checkNotNullParameter((Object)projMat, (String)"projMat");
        int w = ClientDSLKt.getMC().getWindow().getWidth();
        int h = ClientDSLKt.getMC().getWindow().getHeight();
        int[] nArray = new int[]{0, 0, w, h};
        int[] dims = nArray;
        float x2 = x.floatValue();
        float y2 = y.floatValue();
        Vector3f dir = new Vector3f();
        Vector3f pos = new Vector3f();
        projMat.unprojectRay(x2, y2, dims, pos, dir);
        return TuplesKt.to((Object)dir, (Object)pos);
    }

    public static /* synthetic */ Pair screenPosToWorldPosAndDir$default(Number number, Number number2, Matrix4f matrix4f, int n, Object object) {
        if ((n & 4) != 0) {
            matrix4f = ClientMixinBridge.INSTANCE.getWorldProjectionMatrix(ClientDSLKt.getMC());
        }
        return MathUtilKt.screenPosToWorldPosAndDir(number, number2, matrix4f);
    }

    @NotNull
    public static final Vector3f getCursorWorldPos(@NotNull Matrix4f projMat) {
        Intrinsics.checkNotNullParameter((Object)projMat, (String)"projMat");
        Vector2d cursorPos = MiscUtilKt.getCursorPos();
        return MathUtilKt.screenPosToWorldPos(cursorPos.x, cursorPos.y, projMat);
    }

    public static /* synthetic */ Vector3f getCursorWorldPos$default(Matrix4f matrix4f, int n, Object object) {
        if ((n & 1) != 0) {
            matrix4f = ClientMixinBridge.INSTANCE.getWorldProjectionMatrix(ClientDSLKt.getMC());
        }
        return MathUtilKt.getCursorWorldPos(matrix4f);
    }

    @NotNull
    public static final Vector3f getCursorWorldDir(@NotNull Matrix4f projMat) {
        Intrinsics.checkNotNullParameter((Object)projMat, (String)"projMat");
        Vector2d cursorPos = MiscUtilKt.getCursorPos();
        return MathUtilKt.screenPosToWorldDir(cursorPos.x, cursorPos.y, projMat);
    }

    public static /* synthetic */ Vector3f getCursorWorldDir$default(Matrix4f matrix4f, int n, Object object) {
        if ((n & 1) != 0) {
            matrix4f = ClientMixinBridge.INSTANCE.getWorldProjectionMatrix(ClientDSLKt.getMC());
        }
        return MathUtilKt.getCursorWorldDir(matrix4f);
    }

    @NotNull
    public static final Pair<Vector3f, Vector3f> getCursorWorldDirAndPos(@NotNull Matrix4f projMat) {
        Intrinsics.checkNotNullParameter((Object)projMat, (String)"projMat");
        Vector2d cursorPos = MiscUtilKt.getCursorPos();
        return MathUtilKt.screenPosToWorldPosAndDir(cursorPos.x, cursorPos.y, projMat);
    }

    public static /* synthetic */ Pair getCursorWorldDirAndPos$default(Matrix4f matrix4f, int n, Object object) {
        if ((n & 1) != 0) {
            matrix4f = ClientMixinBridge.INSTANCE.getWorldProjectionMatrix(ClientDSLKt.getMC());
        }
        return MathUtilKt.getCursorWorldDirAndPos(matrix4f);
    }

    @Nullable
    public static final VoxelShapeHitResult rayCastAtCursor(@NotNull VoxelShape $this$rayCastAtCursor, @NotNull Number distance, @NotNull BlockPos blockPos) {
        Intrinsics.checkNotNullParameter((Object)$this$rayCastAtCursor, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)distance, (String)"distance");
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Ref.ObjectRef hitResult = new Ref.ObjectRef();
        Pair dirPos = MathUtilKt.getCursorWorldDirAndPos$default(null, 1, null);
        RayAabIntersection intersection = new RayAabIntersection();
        Vector3f start = (Vector3f)dirPos.getSecond();
        Vec3 end = PositionUtil.toVec3((Vector3fc)dirPos.getSecond()).add(PositionUtil.toVec3((Vector3fc)dirPos.getFirst()).multiply(distance.doubleValue(), distance.doubleValue(), distance.doubleValue()));
        intersection.set(((Vector3f)dirPos.getSecond()).x, ((Vector3f)dirPos.getSecond()).y, ((Vector3f)dirPos.getSecond()).z, ((Vector3f)dirPos.getFirst()).x, ((Vector3f)dirPos.getFirst()).y, ((Vector3f)dirPos.getFirst()).z);
        $this$rayCastAtCursor.forAllBoxes((arg_0, arg_1, arg_2, arg_3, arg_4, arg_5) -> MathUtilKt.rayCastAtCursor$lambda$0(intersection, start, end, blockPos, dirPos, hitResult, arg_0, arg_1, arg_2, arg_3, arg_4, arg_5));
        return (VoxelShapeHitResult)hitResult.element;
    }

    public static /* synthetic */ VoxelShapeHitResult rayCastAtCursor$default(VoxelShape voxelShape, Number number, BlockPos blockPos, int n, Object object) {
        if ((n & 2) != 0) {
            blockPos = new BlockPos(0, 0, 0);
        }
        return MathUtilKt.rayCastAtCursor(voxelShape, number, blockPos);
    }

    @NotNull
    public static final BlockHitResult rayCastAtCursor(@NotNull ClientLevel $this$rayCastAtCursor, @NotNull Number distance) {
        Intrinsics.checkNotNullParameter((Object)$this$rayCastAtCursor, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)distance, (String)"distance");
        Pair dirPos = MathUtilKt.getCursorWorldDirAndPos$default(null, 1, null);
        Vector3f end = ((Vector3f)dirPos.getFirst()).mul(distance.floatValue());
        Level level = (Level)$this$rayCastAtCursor;
        Vec3 vec3 = PositionUtil.toVec3((Vector3fc)dirPos.getSecond());
        Intrinsics.checkNotNull((Object)end);
        return RayExt.rayCast(level, vec3, PositionUtil.toVec3((Vector3fc)end));
    }

    public static /* synthetic */ BlockHitResult rayCastAtCursor$default(ClientLevel clientLevel, Number number, int n, Object object) {
        if ((n & 1) != 0) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            Intrinsics.checkNotNull((Object)localPlayer);
            number = localPlayer.getAttributeValue(Attributes.BLOCK_INTERACTION_RANGE);
        }
        return MathUtilKt.rayCastAtCursor(clientLevel, number);
    }

    public static final boolean pointInsideOval(@NotNull Number x, @NotNull Number y, @NotNull Number originX, @NotNull Number originY, @NotNull Number horizontalRadius, @NotNull Number verticalRadius) {
        Intrinsics.checkNotNullParameter((Object)x, (String)"x");
        Intrinsics.checkNotNullParameter((Object)y, (String)"y");
        Intrinsics.checkNotNullParameter((Object)originX, (String)"originX");
        Intrinsics.checkNotNullParameter((Object)originY, (String)"originY");
        Intrinsics.checkNotNullParameter((Object)horizontalRadius, (String)"horizontalRadius");
        Intrinsics.checkNotNullParameter((Object)verticalRadius, (String)"verticalRadius");
        double x2 = x.doubleValue();
        double y2 = y.doubleValue();
        double oX = originX.doubleValue();
        double oY = originY.doubleValue();
        double h = Math.pow(horizontalRadius.doubleValue(), 2);
        double v = Math.pow(verticalRadius.doubleValue(), 2);
        return Math.pow(x2 - oX, 2) / h + Math.pow(y2 - oY, 2) / v <= 1.0;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T clamp(@NotNull T $this$clamp, @NotNull T min, @NotNull T max) {
        Intrinsics.checkNotNullParameter($this$clamp, (String)"<this>");
        Intrinsics.checkNotNullParameter(min, (String)"min");
        Intrinsics.checkNotNullParameter(max, (String)"max");
        return $this$clamp.compareTo(min) < 0 ? min : ($this$clamp.compareTo(max) > 0 ? max : $this$clamp);
    }

    public static final float getAngleTo(@NotNull Vector2f from, @NotNull Vector2f to) {
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        Intrinsics.checkNotNullParameter((Object)to, (String)"to");
        double n = (double)270 - Math.atan2(from.y - to.y, from.x - to.x) * (double)180 / Math.PI;
        return (float)(n % (double)360);
    }

    public static final int wrap(int value, @NotNull Number min, @NotNull Number max) {
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        Pair pair = new Pair((Object)min.intValue(), (Object)(max.intValue() - min.intValue()));
        int mi = ((Number)pair.component1()).intValue();
        int mx = ((Number)pair.component2()).intValue();
        int range = mx - mi;
        if (range == 0) {
            return mi;
        }
        int wrappedValue = (value - mi) % range;
        if (wrappedValue < 0) {
            wrappedValue += range;
        }
        return wrappedValue + mi;
    }

    public static final double wrap(double value, @NotNull Number min, @NotNull Number max) {
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        Pair pair = new Pair((Object)min.doubleValue(), (Object)(max.doubleValue() - min.doubleValue()));
        double mi = ((Number)pair.component1()).doubleValue();
        double mx = ((Number)pair.component2()).doubleValue();
        double range = mx - mi;
        if (range == 0.0) {
            return mi;
        }
        double wrappedValue = (value - mi) % range;
        if (wrappedValue < 0.0) {
            wrappedValue += range;
        }
        return wrappedValue + mi;
    }

    public static final float wrap(float value, @NotNull Number min, @NotNull Number max) {
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        Pair pair = new Pair((Object)Float.valueOf(min.floatValue()), (Object)Float.valueOf(max.floatValue() - min.floatValue()));
        float mi = ((Number)pair.component1()).floatValue();
        float mx = ((Number)pair.component2()).floatValue();
        float range = mx - mi;
        if (range == 0.0f) {
            return mi;
        }
        float wrappedValue = (value - mi) % range;
        if (wrappedValue < 0.0f) {
            wrappedValue += range;
        }
        return wrappedValue + mi;
    }

    public static final long wrap(long value, @NotNull Number min, @NotNull Number max) {
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        Pair pair = new Pair((Object)min.longValue(), (Object)(max.longValue() - min.longValue()));
        long mi = ((Number)pair.component1()).longValue();
        long mx = ((Number)pair.component2()).longValue();
        long range = mx - mi;
        if (range == 0L) {
            return mi;
        }
        long wrappedValue = (value - mi) % range;
        if (wrappedValue < 0L) {
            wrappedValue += range;
        }
        return wrappedValue + mi;
    }

    private static final void rayCastAtCursor$lambda$0(RayAabIntersection $intersection, Vector3f $start, Vec3 $end, BlockPos $blockPos, Pair $dirPos, Ref.ObjectRef $hitResult, double d, double d1, double d2, double d3, double d4, double d5) {
        BlockHitResult blockHitResult;
        if ($intersection.test((float)d, (float)d1, (float)d2, (float)d3, (float)d4, (float)d5) && (blockHitResult = Shapes.box((double)d, (double)d1, (double)d2, (double)d3, (double)d4, (double)d5).clip(PositionUtil.toVec3((Vector3fc)$start), $end, $blockPos)) != null) {
            BlockHitResult result = blockHitResult;
            boolean bl = false;
            Vector2f nearFar = new Vector2f();
            Vector3f mn = new Vector3f((float)d, (float)d1, (float)d2);
            Vector3f mx = new Vector3f((float)d3, (float)d4, (float)d5);
            Intersectionf.intersectRayAab((Vector3fc)((Vector3fc)$start), (Vector3fc)((Vector3fc)new Vector3f((Vector3fc)$dirPos.getFirst())), (Vector3fc)((Vector3fc)mx), (Vector3fc)((Vector3fc)mn), (Vector2f)nearFar);
            Vector3f hitPos = new Vector3f((Vector3fc)$start).add((Vector3fc)new Vector3f((Vector3fc)$dirPos.getFirst()).mul(nearFar.x));
            Vector3f vector3f = new Vector3f((Vector3fc)$start);
            Vector3f vector3f2 = new Vector3f((Vector3fc)$dirPos.getFirst());
            Intrinsics.checkNotNull((Object)hitPos);
            Direction direction = result.getDirection();
            Intrinsics.checkNotNullExpressionValue((Object)direction, (String)"getDirection(...)");
            $hitResult.element = new VoxelShapeHitResult(vector3f, vector3f2, hitPos, direction);
            return;
        }
    }
}

