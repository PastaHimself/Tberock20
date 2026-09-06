/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.entity.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate;
import net.thebrokenscript.brokencore.api.queue.QueuedTask;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 B2\u00020\u0001:\u0002ABB\u001f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u001c\u001a\u00020\t*\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0014\u0010 \u001a\u00020\t*\u0004\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0018\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\tH\u0016J\b\u0010)\u001a\u00020\tH\u0016J\u001a\u0010*\u001a\u00020+2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020+0-J\u0010\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u000201H\u0016J\u0016\u00102\u001a\b\u0012\u0004\u0012\u000204032\b\u00105\u001a\u0004\u0018\u000106J\u0016\u00107\u001a\b\u0012\u0004\u0012\u00020\t032\b\u00105\u001a\u0004\u0018\u000106J\u0016\u00108\u001a\b\u0012\u0004\u0012\u000209032\b\u00105\u001a\u0004\u0018\u000106J\u0016\u0010:\u001a\b\u0012\u0004\u0012\u00020;032\b\u00105\u001a\u0004\u0018\u000106J \u0010<\u001a\b\u0012\u0004\u0012\u0002H>0=\"\u0004\b\u0000\u0010>2\f\u0010?\u001a\b\u0012\u0004\u0012\u0002H>0@R\u0011\u0010\b\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0018\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u001a\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u000bR\u0011\u0010\u001b\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u000b\u00a8\u0006C"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "Lnet/minecraft/world/entity/monster/Monster;", "entityType", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "onSurface", "", "getOnSurface", "()Z", "getLevel", "()Lnet/minecraft/world/level/Level;", "blockPos", "Lnet/minecraft/core/BlockPos;", "getBlockPos", "()Lnet/minecraft/core/BlockPos;", "pos", "Lnet/minecraft/world/phys/Vec3;", "getPos", "()Lnet/minecraft/world/phys/Vec3;", "eyePos", "getEyePos", "viewVector", "getViewVector", "isGrounded", "isMoving", "isWithin", "Lnet/minecraft/world/entity/Entity;", "dist", "", "isCloserThan", "other", "queueDiscard", "Lnet/thebrokenscript/brokencore/api/queue/QueuedTask;", "ticks", "", "startRiding", "vehicle", "force", "canBeLeashed", "onServerTick", "", "block", "Lkotlin/Function1;", "Lnet/minecraft/server/level/ServerLevel;", "canStandOnFluid", "fluidState", "Lnet/minecraft/world/level/material/FluidState;", "persistentInt", "Lnet/thebrokenscript/brokencore/api/dsl/PersistentDataDelegate;", "", "name", "", "persistentBool", "persistentDouble", "", "persistentFloat", "", "entityData", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "T", "acc", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "BMC", "Companion", "brokencore-common"})
public class BaseMonster
extends Monster {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final float MOVEMENT_THRESHOLD = 0.05f;
    public static final float MOVEMENT_THRESHOLD_SQR = 0.0025000002f;

    public BaseMonster(@NotNull EntityType<? extends Monster> entityType, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(entityType, level);
    }

    public final boolean getOnSurface() {
        return this.level().canSeeSkyFromBelowWater(this.blockPosition());
    }

    @NotNull
    public final Level getLevel() {
        Level level = this.level();
        Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
        return level;
    }

    @NotNull
    public final BlockPos getBlockPos() {
        BlockPos blockPos = this.blockPosition();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"blockPosition(...)");
        return blockPos;
    }

    @NotNull
    public final Vec3 getPos() {
        Vec3 vec3 = this.position();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
        return vec3;
    }

    @NotNull
    public final Vec3 getEyePos() {
        Vec3 vec3 = this.getEyePosition(1.0f);
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getEyePosition(...)");
        return vec3;
    }

    @NotNull
    public final Vec3 getViewVector() {
        Vec3 vec3 = this.getViewVector(1.0f);
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getViewVector(...)");
        return vec3;
    }

    public final boolean isGrounded() {
        return this.onGround();
    }

    public final boolean isMoving() {
        return this.getDeltaMovement().lengthSqr() > 0.002500000176951289;
    }

    public final boolean isWithin(@Nullable Entity $this$isWithin, @NotNull Number dist) {
        Intrinsics.checkNotNullParameter((Object)dist, (String)"dist");
        return EntityUtil.isWithin($this$isWithin, this.getPos(), dist);
    }

    public final boolean isCloserThan(@Nullable Entity $this$isCloserThan, @NotNull Entity other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return $this$isCloserThan != null && $this$isCloserThan.distanceToSqr(this.getPos()) < other.distanceToSqr(this.getPos());
    }

    @NotNull
    public final QueuedTask queueDiscard(long ticks) {
        return EntityUtil.getQueue((Entity)this).add(ticks, (Function0<Unit>)((Function0)new Function0<Unit>((Object)this){

            public final void invoke() {
                ((BaseMonster)((Object)this.receiver)).discard();
            }
        }));
    }

    public boolean startRiding(@NotNull Entity vehicle, boolean force) {
        Intrinsics.checkNotNullParameter((Object)vehicle, (String)"vehicle");
        return false;
    }

    public boolean canBeLeashed() {
        return false;
    }

    public final void onServerTick(@NotNull Function1<? super ServerLevel, Unit> block2) {
        block0: {
            Intrinsics.checkNotNullParameter(block2, (String)"block");
            super.baseTick();
            Level level = this.getLevel();
            ServerLevel serverLevel = level instanceof ServerLevel ? (ServerLevel)level : null;
            if (serverLevel == null) break block0;
            block2.invoke((Object)serverLevel);
        }
    }

    public boolean canStandOnFluid(@NotNull FluidState fluidState) {
        Intrinsics.checkNotNullParameter((Object)fluidState, (String)"fluidState");
        return !fluidState.isEmpty();
    }

    @NotNull
    public final PersistentDataDelegate<Integer> persistentInt(@Nullable String name) {
        return new PersistentDataDelegate<Integer>(name, (Function1)new Function1<String, Integer>((Object)EntityUtil.getPersistentData((Entity)this)){

            public final Integer invoke(String p0) {
                return ((CompoundTag)this.receiver).getInt(p0);
            }
        }, (Function2)new Function2<String, Integer, Unit>((Object)EntityUtil.getPersistentData((Entity)this)){

            public final void invoke(String p0, int p1) {
                ((CompoundTag)this.receiver).putInt(p0, p1);
            }
        });
    }

    @NotNull
    public final PersistentDataDelegate<Boolean> persistentBool(@Nullable String name) {
        return new PersistentDataDelegate<Boolean>(name, (Function1)new Function1<String, Boolean>((Object)EntityUtil.getPersistentData((Entity)this)){

            public final Boolean invoke(String p0) {
                return ((CompoundTag)this.receiver).getBoolean(p0);
            }
        }, (Function2)new Function2<String, Boolean, Unit>((Object)EntityUtil.getPersistentData((Entity)this)){

            public final void invoke(String p0, boolean p1) {
                ((CompoundTag)this.receiver).putBoolean(p0, p1);
            }
        });
    }

    @NotNull
    public final PersistentDataDelegate<Double> persistentDouble(@Nullable String name) {
        return new PersistentDataDelegate<Double>(name, (Function1)new Function1<String, Double>((Object)EntityUtil.getPersistentData((Entity)this)){

            public final Double invoke(String p0) {
                return ((CompoundTag)this.receiver).getDouble(p0);
            }
        }, (Function2)new Function2<String, Double, Unit>((Object)EntityUtil.getPersistentData((Entity)this)){

            public final void invoke(String p0, double p1) {
                ((CompoundTag)this.receiver).putDouble(p0, p1);
            }
        });
    }

    @NotNull
    public final PersistentDataDelegate<Float> persistentFloat(@Nullable String name) {
        return new PersistentDataDelegate<Float>(name, (Function1)new Function1<String, Float>((Object)EntityUtil.getPersistentData((Entity)this)){

            public final Float invoke(String p0) {
                return Float.valueOf(((CompoundTag)this.receiver).getFloat(p0));
            }
        }, (Function2)new Function2<String, Float, Unit>((Object)EntityUtil.getPersistentData((Entity)this)){

            public final void invoke(String p0, float p1) {
                ((CompoundTag)this.receiver).putFloat(p0, p1);
            }
        });
    }

    @NotNull
    public final <T> EntityDataDelegate<T> entityData(@NotNull EntityDataAccessor<T> acc) {
        Intrinsics.checkNotNullParameter(acc, (String)"acc");
        return new EntityDataDelegate<T>(acc);
    }

    @JvmStatic
    @NotNull
    protected static final AttributeSupplier.Builder attrs(@NotNull Function1<? super AttributeSupplier.Builder, Unit> block2) {
        return Companion.attrs(block2);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster$BMC;", "E", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "", "brokencore-common"})
    public static interface BMC<E extends BaseMonster> {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\b\fH\u0005JL\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u0011\"\u0004\b\u0001\u0010\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0015H\u0085\bR\b\u0012\u0004\u0012\u0002H\u00100\u0012j\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster$Companion;", "", "<init>", "()V", "MOVEMENT_THRESHOLD", "", "MOVEMENT_THRESHOLD_SQR", "attrs", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "data", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "T", "E", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster$BMC;", "<unused var>", "ser", "Lnet/minecraft/network/syncher/EntityDataSerializer;", "(Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster$BMC;Lnet/minecraft/network/syncher/EntityDataSerializer;)Lnet/minecraft/network/syncher/EntityDataAccessor;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        protected final AttributeSupplier.Builder attrs(@NotNull Function1<? super AttributeSupplier.Builder, Unit> block2) {
            Intrinsics.checkNotNullParameter(block2, (String)"block");
            AttributeSupplier.Builder builder = Monster.createMobAttributes();
            block2.invoke((Object)builder);
            AttributeSupplier.Builder builder2 = builder;
            Intrinsics.checkNotNullExpressionValue((Object)builder2, (String)"apply(...)");
            return builder2;
        }

        @JvmStatic
        protected final /* synthetic */ <E extends BaseMonster, T> EntityDataAccessor<T> data(BMC<E> bMC, EntityDataSerializer<T> ser) {
            Intrinsics.checkNotNullParameter(bMC, (String)"<unused var>");
            Intrinsics.checkNotNullParameter(ser, (String)"ser");
            boolean $i$f$data = false;
            Intrinsics.reifiedOperationMarker((int)4, (String)"E");
            EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(BaseMonster.class, ser);
            Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
            return entityDataAccessor;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

