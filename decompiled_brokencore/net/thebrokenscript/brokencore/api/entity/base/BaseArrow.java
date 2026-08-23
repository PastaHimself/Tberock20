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
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.projectile.AbstractArrow
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate;
import net.thebrokenscript.brokencore.api.queue.QueuedTask;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 G2\u00020\u0001:\u0002FGB!\b\u0016\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007BM\b\u0014\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0006\u0010\u000fB=\b\u0014\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u0006\u0010\u0012J\u0014\u0010'\u001a\u00020\u0014*\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*J\u0014\u0010+\u001a\u00020\u0014*\u0004\u0018\u00010(2\u0006\u0010,\u001a\u00020(J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u0018\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020\u0014H\u0016J\u001a\u00104\u001a\u0002052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020507J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020;0:2\b\u0010<\u001a\u0004\u0018\u00010=J\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0:2\b\u0010<\u001a\u0004\u0018\u00010=J\u0016\u0010?\u001a\b\u0012\u0004\u0012\u00020@0:2\b\u0010<\u001a\u0004\u0018\u00010=J \u0010A\u001a\b\u0012\u0004\u0012\u0002HC0B\"\u0004\b\u0000\u0010C2\f\u0010D\u001a\b\u0012\u0004\u0012\u0002HC0ER\u0011\u0010\u0013\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010 R\u0011\u0010#\u001a\u00020\u001e8F\u00a2\u0006\u0006\u001a\u0004\b$\u0010 R\u0011\u0010%\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b%\u0010\u0016R\u0011\u0010&\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u0016\u00a8\u0006H"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/base/BaseArrow;", "Lnet/minecraft/world/entity/projectile/AbstractArrow;", "entityType", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "x", "", "y", "z", "pickupItemStack", "Lnet/minecraft/world/item/ItemStack;", "firedFromWeapon", "(Lnet/minecraft/world/entity/EntityType;DDDLnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)V", "owner", "Lnet/minecraft/world/entity/LivingEntity;", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)V", "onSurface", "", "getOnSurface", "()Z", "getLevel", "()Lnet/minecraft/world/level/Level;", "blockPos", "Lnet/minecraft/core/BlockPos;", "getBlockPos", "()Lnet/minecraft/core/BlockPos;", "pos", "Lnet/minecraft/world/phys/Vec3;", "getPos", "()Lnet/minecraft/world/phys/Vec3;", "eyePos", "getEyePos", "viewVector", "getViewVector", "isGrounded", "isMoving", "isWithin", "Lnet/minecraft/world/entity/Entity;", "dist", "", "isCloserThan", "other", "queueDiscard", "Lnet/thebrokenscript/brokencore/api/queue/QueuedTask;", "ticks", "", "startRiding", "vehicle", "force", "onServerTick", "", "block", "Lkotlin/Function1;", "Lnet/minecraft/server/level/ServerLevel;", "persistentInt", "Lnet/thebrokenscript/brokencore/api/dsl/PersistentDataDelegate;", "", "name", "", "persistentDouble", "persistentFloat", "", "entityData", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "T", "acc", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "BMC", "Companion", "brokencore-common"})
public abstract class BaseArrow
extends AbstractArrow {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final float MOVEMENT_THRESHOLD = 0.05f;
    public static final float MOVEMENT_THRESHOLD_SQR = 0.0025000002f;

    public BaseArrow(@NotNull EntityType<? extends AbstractArrow> entityType, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(entityType, level);
    }

    protected BaseArrow(@NotNull EntityType<? extends AbstractArrow> entityType, double x, double y, double z, @NotNull Level level, @Nullable ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(entityType, x, y, z, level, pickupItemStack, firedFromWeapon);
    }

    protected BaseArrow(@NotNull EntityType<? extends AbstractArrow> entityType, @NotNull LivingEntity owner, @NotNull Level level, @Nullable ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(entityType, owner, level, pickupItemStack, firedFromWeapon);
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
                ((BaseArrow)((Object)this.receiver)).discard();
            }
        }));
    }

    public boolean startRiding(@NotNull Entity vehicle, boolean force) {
        Intrinsics.checkNotNullParameter((Object)vehicle, (String)"vehicle");
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

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/base/BaseArrow$BMC;", "E", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseArrow;", "", "brokencore-common"})
    public static interface BMC<E extends BaseArrow> {
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\b\fH\u0005JL\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u0011\"\u0004\b\u0001\u0010\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0015H\u0085\bR\b\u0012\u0004\u0012\u0002H\u00100\u0012j\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0012\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/base/BaseArrow$Companion;", "", "<init>", "()V", "MOVEMENT_THRESHOLD", "", "MOVEMENT_THRESHOLD_SQR", "attrs", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "data", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "T", "E", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseArrow;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseArrow$BMC;", "<unused var>", "ser", "Lnet/minecraft/network/syncher/EntityDataSerializer;", "(Lnet/thebrokenscript/brokencore/api/entity/base/BaseArrow$BMC;Lnet/minecraft/network/syncher/EntityDataSerializer;)Lnet/minecraft/network/syncher/EntityDataAccessor;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        protected final AttributeSupplier.Builder attrs(@NotNull Function1<? super AttributeSupplier.Builder, Unit> block2) {
            Intrinsics.checkNotNullParameter(block2, (String)"block");
            AttributeSupplier.Builder builder = Mob.createMobAttributes();
            block2.invoke((Object)builder);
            AttributeSupplier.Builder builder2 = builder;
            Intrinsics.checkNotNullExpressionValue((Object)builder2, (String)"apply(...)");
            return builder2;
        }

        @JvmStatic
        protected final /* synthetic */ <E extends BaseArrow, T> EntityDataAccessor<T> data(BMC<E> bMC, EntityDataSerializer<T> ser) {
            Intrinsics.checkNotNullParameter(bMC, (String)"<unused var>");
            Intrinsics.checkNotNullParameter(ser, (String)"ser");
            boolean $i$f$data = false;
            Intrinsics.reifiedOperationMarker((int)4, (String)"E");
            EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(BaseArrow.class, ser);
            Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
            return entityDataAccessor;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

