/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.multiplayer.ClientLevel
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.entity.EntityAccess
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.dsl;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.entity.EntityAccess;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.data.DataAttachment;
import net.thebrokenscript.brokencore.api.dsl.AabbUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.LevelUtil;
import net.thebrokenscript.brokencore.api.dsl.MathUtil;
import net.thebrokenscript.brokencore.api.mixinterfaces.ClientTargetAccess;
import net.thebrokenscript.brokencore.api.platform.PlatformAttachments;
import net.thebrokenscript.brokencore.api.queue.WorkQueue;
import net.thebrokenscript.brokencore.impl.mixin.client.features.level.ClientLevelAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\n\u001a\u00020\u000b\"\b\b\u0000\u0010\u0007*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00070\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u001a\f\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u0002\u001a\f\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u0002\u001a\u0012\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019\u001a!\u0010\u001a\u001a\u00020\u000b\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u0002H\u00072\u0006\u0010\r\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u001b\u001a!\u0010\u001a\u001a\u00020\u000b\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u0002H\u00072\u0006\u0010\r\u001a\u00020\u0019\u00a2\u0006\u0002\u0010\u001c\u001a+\u0010\u001d\u001a\u00020\u0017\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u0004\u0018\u0001H\u00072\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u001f\u001a\u001d\u0010 \u001a\u0004\u0018\u0001H\u0007\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u0004\u0018\u0001H\u0007\u00a2\u0006\u0002\u0010!\u001a)\u0010\"\u001a\u0004\u0018\u0001H\u0007\"\b\b\u0000\u0010\u0007*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00070#2\u0006\u0010\r\u001a\u00020\u0006\u00a2\u0006\u0002\u0010$\u001a:\u0010)\u001a\u00020\u000b\"\b\b\u0000\u0010\u0007*\u00020\u0002\"\u0004\b\u0001\u0010**\u0002H\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0,2\b\u0010-\u001a\u0004\b\u0002H*\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010.\u001a-\u0010/\u001a\u0002H*\"\b\b\u0000\u0010\u0007*\u00020\u0002\"\u0004\b\u0001\u0010**\u0002H\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0,\u00a2\u0006\u0002\u00100\u001aA\u00101\u001a\u00020\u000b\"\b\b\u0000\u0010\u0007*\u00020\u0002\"\u0004\b\u0001\u0010**\u0002H\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0,2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u00020\u000b03\u00a2\u0006\u0002\u00104\u001a\u0018\u00105\u001a\u000206*\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020609\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001f\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u0002H\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u001f\u0010%\u001a\u00020&\"\b\b\u0000\u0010\u0007*\u00020\u0002*\u0002H\u00078F\u00a2\u0006\u0006\u001a\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b9\u00a8\u0006:"}, d2={"queue", "Lnet/thebrokenscript/brokencore/api/queue/WorkQueue;", "Lnet/minecraft/world/entity/Entity;", "getQueue", "(Lnet/minecraft/world/entity/Entity;)Lnet/thebrokenscript/brokencore/api/queue/WorkQueue;", "eyePos", "Lnet/minecraft/world/phys/Vec3;", "T", "getEyePos", "(Lnet/minecraft/world/entity/Entity;)Lnet/minecraft/world/phys/Vec3;", "discardNearest", "", "Ljava/lang/Class;", "pos", "level", "Lnet/minecraft/world/level/Level;", "maxDist", "", "clientTargetUUID", "Ljava/util/UUID;", "clientTarget", "Lnet/minecraft/world/entity/LivingEntity;", "hasLineOfSight", "", "targetPos", "Lnet/minecraft/core/BlockPos;", "teleport", "(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/Vec3;)V", "(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/core/BlockPos;)V", "isWithin", "distance", "(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/Vec3;Ljava/lang/Number;)Z", "applyRandomRotation", "(Lnet/minecraft/world/entity/Entity;)Lnet/minecraft/world/entity/Entity;", "closest", "", "(Ljava/util/List;Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/entity/Entity;", "persistentData", "Lnet/minecraft/nbt/CompoundTag;", "getPersistentData", "(Lnet/minecraft/world/entity/Entity;)Lnet/minecraft/nbt/CompoundTag;", "setData", "D", "attachment", "Lnet/thebrokenscript/brokencore/api/data/DataAttachment;", "value", "(Lnet/minecraft/world/entity/Entity;Lnet/thebrokenscript/brokencore/api/data/DataAttachment;Ljava/lang/Object;)V", "getData", "(Lnet/minecraft/world/entity/Entity;Lnet/thebrokenscript/brokencore/api/data/DataAttachment;)Ljava/lang/Object;", "updateData", "cb", "Lkotlin/Function1;", "(Lnet/minecraft/world/entity/Entity;Lnet/thebrokenscript/brokencore/api/data/DataAttachment;Lkotlin/jvm/functions/Function1;)V", "incInt", "", "Lnet/minecraft/network/syncher/SynchedEntityData;", "accessor", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "brokencore-common"})
@JvmName(name="EntityUtil")
@SourceDebugExtension(value={"SMAP\nEntityDSL.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/EntityUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,73:1\n1#2:74\n2423#3,14:75\n*S KotlinDebug\n*F\n+ 1 EntityDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/EntityUtil\n*L\n61#1:75,14\n*E\n"})
public final class EntityUtil {
    @NotNull
    public static final WorkQueue getQueue(@NotNull Entity $this$queue) {
        Intrinsics.checkNotNullParameter((Object)$this$queue, (String)"<this>");
        Level level = $this$queue.level();
        Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
        return LevelUtil.getQueue(level);
    }

    @NotNull
    public static final <T extends Entity> Vec3 getEyePos(@NotNull T $this$eyePos) {
        Intrinsics.checkNotNullParameter($this$eyePos, (String)"<this>");
        AABB aABB = $this$eyePos.getBoundingBox();
        Intrinsics.checkNotNullExpressionValue((Object)aABB, (String)"getBoundingBox(...)");
        return AabbUtil.eyeCenter(aABB, $this$eyePos);
    }

    public static final <T extends Entity> void discardNearest(@NotNull Class<T> $this$discardNearest, @NotNull Vec3 pos, @NotNull Level level, @NotNull Number maxDist) {
        block1: {
            Intrinsics.checkNotNullParameter($this$discardNearest, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)maxDist, (String)"maxDist");
            if (level.isClientSide) {
                return;
            }
            T t = EntityFinder.findClosestEntityInRange((LevelAccessor)level, $this$discardNearest, pos, maxDist);
            if (t == null) break block1;
            t.discard();
        }
    }

    public static /* synthetic */ void discardNearest$default(Class clazz, Vec3 vec3, Level level, Number number, int n, Object object) {
        if ((n & 4) != 0) {
            number = 1000;
        }
        EntityUtil.discardNearest(clazz, vec3, level, number);
    }

    @Nullable
    public static final UUID clientTargetUUID(@NotNull Entity $this$clientTargetUUID) {
        Intrinsics.checkNotNullParameter((Object)$this$clientTargetUUID, (String)"<this>");
        ClientTargetAccess clientTargetAccess = $this$clientTargetUUID instanceof ClientTargetAccess ? (ClientTargetAccess)$this$clientTargetUUID : null;
        return clientTargetAccess != null ? clientTargetAccess.bc$getClientTargetUUID() : null;
    }

    @Nullable
    public static final LivingEntity clientTarget(@NotNull Entity $this$clientTarget) {
        Intrinsics.checkNotNullParameter((Object)$this$clientTarget, (String)"<this>");
        UUID uUID = EntityUtil.clientTargetUUID($this$clientTarget);
        if (uUID == null) {
            return null;
        }
        UUID uuid = uUID;
        Level level = $this$clientTarget.level();
        ClientLevel clientLevel = level instanceof ClientLevel ? (ClientLevel)level : null;
        if (clientLevel == null) {
            return null;
        }
        ClientLevel level2 = clientLevel;
        EntityAccess entityAccess = ((ClientLevelAccess)level2).bc$getEntities().get(uuid);
        return entityAccess instanceof LivingEntity ? (LivingEntity)entityAccess : null;
    }

    public static final boolean hasLineOfSight(@NotNull Entity $this$hasLineOfSight, @NotNull BlockPos targetPos) {
        Intrinsics.checkNotNullParameter((Object)$this$hasLineOfSight, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)targetPos, (String)"targetPos");
        Vec3 vec3 = $this$hasLineOfSight.getEyePosition();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getEyePosition(...)");
        Vec3 eyePos = vec3;
        Vec3 vec32 = Vec3.atCenterOf((Vec3i)((Vec3i)targetPos));
        Intrinsics.checkNotNullExpressionValue((Object)vec32, (String)"atCenterOf(...)");
        Vec3 targetVec = vec32;
        BlockHitResult result = $this$hasLineOfSight.level().clip(new ClipContext(eyePos, targetVec, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, $this$hasLineOfSight));
        return result.getType() == HitResult.Type.MISS || Intrinsics.areEqual((Object)result.getBlockPos(), (Object)targetPos);
    }

    public static final <T extends Entity> void teleport(@NotNull T $this$teleport, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter($this$teleport, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        $this$teleport.teleportTo(pos.x, pos.y, pos.z);
    }

    public static final <T extends Entity> void teleport(@NotNull T $this$teleport, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter($this$teleport, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Vec3 vec3 = pos.getCenter();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
        EntityUtil.teleport($this$teleport, vec3);
    }

    public static final <T extends Entity> boolean isWithin(@Nullable T $this$isWithin, @NotNull Vec3 pos, @NotNull Number distance) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)distance, (String)"distance");
        return $this$isWithin != null && $this$isWithin.position().distanceToSqr(pos) <= MathUtil.getSquared(distance.doubleValue());
    }

    @Nullable
    public static final <T extends Entity> T applyRandomRotation(@Nullable T $this$applyRandomRotation) {
        T t;
        T t2 = $this$applyRandomRotation;
        if (t2 != null) {
            T t3;
            T $this$applyRandomRotation_u24lambda_u240 = t3 = t2;
            boolean bl = false;
            $this$applyRandomRotation_u24lambda_u240.setYRot($this$applyRandomRotation_u24lambda_u240.level().random.nextFloat() * 360.0f);
            t = t3;
        } else {
            t = null;
        }
        return t;
    }

    @Nullable
    public static final <T extends Entity> T closest(@NotNull List<? extends T> $this$closest, @NotNull Vec3 pos) {
        Object v0;
        Intrinsics.checkNotNullParameter($this$closest, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Iterable $this$minByOrNull$iv = $this$closest;
        boolean $i$f$minByOrNull = false;
        Iterator iterator$iv = $this$minByOrNull$iv.iterator();
        if (!iterator$iv.hasNext()) {
            v0 = null;
        } else {
            Object minElem$iv = iterator$iv.next();
            if (!iterator$iv.hasNext()) {
                v0 = minElem$iv;
            } else {
                Entity it = (Entity)minElem$iv;
                boolean bl = false;
                double minValue$iv = it.distanceToSqr(pos);
                do {
                    Object e$iv = iterator$iv.next();
                    Entity it2 = (Entity)e$iv;
                    $i$a$-minByOrNull-EntityUtil$closest$1 = false;
                    double v$iv = it2.distanceToSqr(pos);
                    if (Double.compare(minValue$iv, v$iv) <= 0) continue;
                    minElem$iv = e$iv;
                    minValue$iv = v$iv;
                } while (iterator$iv.hasNext());
                v0 = minElem$iv;
            }
        }
        return (T)((Entity)v0);
    }

    @NotNull
    public static final <T extends Entity> CompoundTag getPersistentData(@NotNull T $this$persistentData) {
        Intrinsics.checkNotNullParameter($this$persistentData, (String)"<this>");
        return PlatformAttachments.Companion.getPersistentData($this$persistentData);
    }

    public static final <T extends Entity, D> void setData(@NotNull T $this$setData, @NotNull DataAttachment<D> attachment, @NotNull D value) {
        Intrinsics.checkNotNullParameter($this$setData, (String)"<this>");
        Intrinsics.checkNotNullParameter(attachment, (String)"attachment");
        Intrinsics.checkNotNullParameter(value, (String)"value");
        attachment.set($this$setData, value);
    }

    public static final <T extends Entity, D> D getData(@NotNull T $this$getData, @NotNull DataAttachment<D> attachment) {
        Intrinsics.checkNotNullParameter($this$getData, (String)"<this>");
        Intrinsics.checkNotNullParameter(attachment, (String)"attachment");
        return attachment.get($this$getData);
    }

    public static final <T extends Entity, D> void updateData(@NotNull T $this$updateData, @NotNull DataAttachment<D> attachment, @NotNull Function1<? super D, Unit> cb) {
        Intrinsics.checkNotNullParameter($this$updateData, (String)"<this>");
        Intrinsics.checkNotNullParameter(attachment, (String)"attachment");
        Intrinsics.checkNotNullParameter(cb, (String)"cb");
        D d = attachment.get($this$updateData);
        cb.invoke(d);
        D d2 = d;
        Intrinsics.checkNotNull(d2, (String)"null cannot be cast to non-null type {D of net.thebrokenscript.brokencore.api.dsl.EntityUtil.updateData & Any}");
        EntityUtil.setData($this$updateData, attachment, d2);
    }

    public static final int incInt(@NotNull SynchedEntityData $this$incInt, @NotNull EntityDataAccessor<Integer> accessor) {
        Intrinsics.checkNotNullParameter((Object)$this$incInt, (String)"<this>");
        Intrinsics.checkNotNullParameter(accessor, (String)"accessor");
        $this$incInt.set(accessor, (Object)(((Number)$this$incInt.get(accessor)).intValue() + 1));
        Unit $this$incInt_u24lambda_u240 = Unit.INSTANCE;
        boolean bl = false;
        Integer n = (Integer)$this$incInt.get(accessor);
        Intrinsics.checkNotNullExpressionValue((Object)n, (String)"run(...)");
        return ((Number)n).intValue();
    }
}

