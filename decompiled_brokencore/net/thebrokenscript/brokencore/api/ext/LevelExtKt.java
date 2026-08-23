/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Position
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.phys.shapes.VoxelShape
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Intersectiond
 *  org.joml.RayAabIntersection
 *  org.joml.Vector2d
 *  org.joml.Vector3d
 *  org.joml.Vector3dc
 *  org.joml.Vector3f
 */
package net.thebrokenscript.brokencore.api.ext;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.util.PreciseBlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Intersectiond;
import org.joml.RayAabIntersection;
import org.joml.Vector2d;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3f;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001aJ\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000426\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\b\u00a8\u0006\u0010"}, d2={"clipPrecise", "Lnet/thebrokenscript/brokencore/api/util/PreciseBlockHitResult;", "Lnet/minecraft/world/level/Level;", "context", "Lnet/minecraft/world/level/ClipContext;", "clip", "Lnet/minecraft/world/phys/BlockHitResult;", "predicate", "Lkotlin/Function2;", "Lnet/minecraft/core/BlockPos;", "Lkotlin/ParameterName;", "name", "pos", "Lnet/minecraft/world/level/block/state/BlockState;", "state", "", "brokencore-common"})
public final class LevelExtKt {
    @Nullable
    public static final PreciseBlockHitResult clipPrecise(@NotNull Level $this$clipPrecise, @NotNull ClipContext context) {
        Intrinsics.checkNotNullParameter((Object)$this$clipPrecise, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Ref.ObjectRef resultHit = new Ref.ObjectRef();
        BlockHitResult imprecise = $this$clipPrecise.clip(context);
        BlockPos bPos = imprecise.getBlockPos();
        BlockState state = $this$clipPrecise.getBlockState(imprecise.getBlockPos());
        VoxelShape shape = state.getShape((BlockGetter)$this$clipPrecise, imprecise.getBlockPos());
        Vec3 dir = context.getTo().subtract(context.getFrom()).normalize();
        Vector3f dirF = dir.toVector3f();
        Vec3 pos = context.getFrom();
        Vector3f posF = pos.toVector3f();
        RayAabIntersection intersection = new RayAabIntersection(posF.x, posF.y, posF.z, dirF.x, dirF.y, dirF.z);
        shape.forAllBoxes((arg_0, arg_1, arg_2, arg_3, arg_4, arg_5) -> LevelExtKt.clipPrecise$lambda$0(intersection, bPos, pos, dir, resultHit, arg_0, arg_1, arg_2, arg_3, arg_4, arg_5));
        if (resultHit.element == null) {
            return null;
        }
        Intrinsics.checkNotNull((Object)pos);
        return new PreciseBlockHitResult(pos, (Vec3)resultHit.element, imprecise.getDirection(), imprecise.getBlockPos(), imprecise.isInside());
    }

    @NotNull
    public static final BlockHitResult clip(@NotNull Level $this$clip, @NotNull ClipContext context, @NotNull Function2<? super BlockPos, ? super BlockState, Boolean> predicate) {
        Intrinsics.checkNotNullParameter((Object)$this$clip, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
        Object object = BlockGetter.traverseBlocks((Vec3)context.getFrom(), (Vec3)context.getTo(), (Object)context, (arg_0, arg_1) -> LevelExtKt.clip$lambda$0($this$clip, predicate, arg_0, arg_1), LevelExtKt::clip$lambda$1);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"traverseBlocks(...)");
        return (BlockHitResult)object;
    }

    private static final void clipPrecise$lambda$0(RayAabIntersection $intersection, BlockPos $bPos, Vec3 $pos, Vec3 $dir, Ref.ObjectRef $resultHit, double d, double d1, double d2, double d3, double d4, double d5) {
        if ($intersection.test((float)d + (float)$bPos.getX(), (float)d1 + (float)$bPos.getY(), (float)d2 + (float)$bPos.getZ(), (float)d3 + (float)$bPos.getX(), (float)d4 + (float)$bPos.getY(), (float)d5 + (float)$bPos.getZ())) {
            Vector2d result = new Vector2d(0.0);
            Intrinsics.checkNotNull((Object)$pos);
            Vector3dc vector3dc = (Vector3dc)MiscExt.toVector3d($pos);
            Intrinsics.checkNotNull((Object)$dir);
            if (Intersectiond.intersectRayAab((Vector3dc)vector3dc, (Vector3dc)((Vector3dc)MiscExt.toVector3d($dir)), (Vector3dc)((Vector3dc)new Vector3d(d + (double)$bPos.getX(), d1 + (double)$bPos.getY(), d2 + (double)$bPos.getZ())), (Vector3dc)((Vector3dc)new Vector3d(d3 + (double)$bPos.getX(), d4 + (double)$bPos.getY(), d5 + (double)$bPos.getZ())), (Vector2d)result)) {
                double t = result.x;
                Vector3d precise = MiscExt.toVector3d($pos).add((Vector3dc)MiscExt.toVector3d($dir).mul(t));
                if ($resultHit.element == null) {
                    $resultHit.element = new Vec3(precise.x, precise.y, precise.z);
                } else {
                    double d6 = precise.distanceSquared((Vector3dc)MiscExt.toVector3d($pos));
                    Object object = $resultHit.element;
                    Intrinsics.checkNotNull((Object)object);
                    if (d6 < ((Vec3)object).distanceToSqr(precise.x, precise.y, precise.z)) {
                        $resultHit.element = new Vec3(precise.x, precise.y, precise.z);
                    }
                }
            }
        }
    }

    private static final BlockHitResult clip$lambda$0(Level $this_clip, Function2 $predicate, ClipContext context, BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        BlockState blockState = $this_clip.getBlockState(pos);
        Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"getBlockState(...)");
        BlockState blockState2 = blockState;
        FluidState fluidState = $this_clip.getFluidState(pos);
        Intrinsics.checkNotNullExpressionValue((Object)fluidState, (String)"getFluidState(...)");
        FluidState fluidState2 = fluidState;
        Vec3 from = context.getFrom();
        Vec3 to = context.getTo();
        VoxelShape voxelShape = context.getBlockShape(blockState2, (BlockGetter)$this_clip, pos);
        BlockHitResult blockHitResult = $this_clip.clipWithInteractionOverride(from, to, pos, voxelShape, blockState2);
        VoxelShape voxelShape1 = context.getFluidShape(fluidState2, (BlockGetter)$this_clip, pos);
        BlockHitResult blockHitResult1 = voxelShape1.clip(from, to, pos);
        double d0 = blockHitResult == null ? Double.MAX_VALUE : context.getFrom().distanceToSqr(blockHitResult.getLocation());
        double d1 = blockHitResult1 == null ? Double.MAX_VALUE : context.getFrom().distanceToSqr(blockHitResult1.getLocation());
        BlockState blockState3 = $this_clip.getBlockState(pos);
        Intrinsics.checkNotNullExpressionValue((Object)blockState3, (String)"getBlockState(...)");
        return ((Boolean)$predicate.invoke((Object)pos, (Object)blockState3)).booleanValue() ? (d0 <= d1 ? blockHitResult : blockHitResult1) : null;
    }

    private static final BlockHitResult clip$lambda$1(ClipContext context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Vec3 vec3 = context.getFrom().subtract(context.getTo());
        return BlockHitResult.miss((Vec3)context.getTo(), (Direction)Direction.getNearest((double)vec3.x, (double)vec3.y, (double)vec3.z), (BlockPos)BlockPos.containing((Position)((Position)context.getTo())));
    }
}

