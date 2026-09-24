/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KProperty
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageSources
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.animation.RawAnimation
 */
package net.thebrokenscript.entity.integrity.phase3;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.entity.boss.VoidTentacleEntity;
import net.thebrokenscript.entity.integrity.phase3.IntegrityPhase3Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 52\u00020\u0001:\u00015B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\tJ\b\u0010\u0017\u001a\u00020\tH\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001cH\u0016J\u0014\u0010!\u001a\u00020\u00122\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#H\u0016J\b\u00101\u001a\u00020\u0012H\u0016J\u0010\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u000204H\u0016R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010$\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u0010,\u001a\u0004\u0018\u00010+2\b\u0010*\u001a\u0004\u0018\u00010+8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00066"}, d2={"Lnet/thebrokenscript/entity/integrity/phase3/IntegrityP3GroundArmEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "entityType", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "<set-?>", "", "isStuck", "stuckStatus", "()Z", "setStuckStatus", "(Z)V", "isStuck$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "defineSynchedData", "", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "setStuck", "stuck", "shouldBeSaved", "isPersistenceRequired", "isPushable", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "die", "damageSource", "onSyncedDataUpdated", "key", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "timer", "", "getTimer", "()I", "setTimer", "(I)V", "value", "Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;", "ownerEntity", "getOwnerEntity", "()Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;", "setOwnerEntity", "(Lnet/thebrokenscript/entity/integrity/phase3/IntegrityPhase3Entity;)V", "tick", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nIntegrityP3GroundArmEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntegrityP3GroundArmEntity.kt\nnet/thebrokenscript/entity/integrity/phase3/IntegrityP3GroundArmEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,148:1\n1869#2,2:149\n*S KotlinDebug\n*F\n+ 1 IntegrityP3GroundArmEntity.kt\nnet/thebrokenscript/entity/integrity/phase3/IntegrityP3GroundArmEntity\n*L\n104#1:149,2\n*E\n"})
public final class IntegrityP3GroundArmEntity
extends UwuableMonster {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate isStuck$delegate;
    private int timer;
    @NotNull
    private static final EntityDataAccessor<Boolean> DATA_STUCK;
    @NotNull
    private static final EntityDataAccessor<Integer> DATA_OWNER_ID;

    public IntegrityP3GroundArmEntity(@NotNull EntityType<IntegrityP3GroundArmEntity> entityType, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(entityType, level);
        this.noCulling = true;
        this.isStuck$delegate = this.entityData(DATA_STUCK);
    }

    @JvmName(name="stuckStatus")
    public final boolean stuckStatus() {
        return (Boolean)this.isStuck$delegate.getValue((BaseMonster)this, $$delegatedProperties[0]);
    }

    @JvmName(name="setStuckStatus")
    public final void setStuckStatus(boolean bl) {
        this.isStuck$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)bl);
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(DATA_STUCK, (Object)false);
        builder.define(DATA_OWNER_ID, (Object)-1);
    }

    public final void setStuck(boolean stuck) {
        block1: {
            if (this.stuckStatus() != stuck) {
                this.setStuckStatus(stuck);
            }
            IntegrityPhase3Entity integrityPhase3Entity = this.getOwnerEntity();
            if (integrityPhase3Entity == null) break block1;
            integrityPhase3Entity.setStuck(stuck);
        }
    }

    public boolean shouldBeSaved() {
        return false;
    }

    public boolean isPersistenceRequired() {
        return false;
    }

    public boolean isPushable() {
        return false;
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        block6: {
            block5: {
                block4: {
                    Intrinsics.checkNotNullParameter((Object)source, (String)"source");
                    if (!this.stuckStatus()) {
                        return false;
                    }
                    if (this.getOwnerEntity() == null) break block4;
                    IntegrityPhase3Entity integrityPhase3Entity = this.getOwnerEntity();
                    Intrinsics.checkNotNull((Object)((Object)integrityPhase3Entity));
                    if (integrityPhase3Entity.getHurtFrames() <= 0) break block5;
                }
                return false;
            }
            IntegrityPhase3Entity integrityPhase3Entity = this.getOwnerEntity();
            if (integrityPhase3Entity == null) break block6;
            integrityPhase3Entity.hurt(source, amount);
        }
        return super.hurt(source, 0.1f);
    }

    public void die(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
    }

    public void onSyncedDataUpdated(@NotNull EntityDataAccessor<?> key) {
        Intrinsics.checkNotNullParameter(key, (String)"key");
        super.onSyncedDataUpdated(key);
        if (Intrinsics.areEqual(key, DATA_STUCK) && this.stuckStatus() && this.getLevel().isClientSide) {
            this.triggerAnim("hit", "stuck");
        }
    }

    public final int getTimer() {
        return this.timer;
    }

    public final void setTimer(int n) {
        this.timer = n;
    }

    @Nullable
    public final IntegrityPhase3Entity getOwnerEntity() {
        Integer id = (Integer)this.entityData.get(DATA_OWNER_ID);
        if (id < 0) {
            return null;
        }
        Level level = this.getLevel();
        Intrinsics.checkNotNull((Object)id);
        Entity entity = level.getEntity(id.intValue());
        return entity instanceof IntegrityPhase3Entity ? (IntegrityPhase3Entity)entity : null;
    }

    public final void setOwnerEntity(@Nullable IntegrityPhase3Entity value) {
        IntegrityPhase3Entity integrityPhase3Entity = value;
        this.entityData.set(DATA_OWNER_ID, (Object)(integrityPhase3Entity != null ? integrityPhase3Entity.getId() : -1));
    }

    public void tick() {
        boolean hasTentacleNearby;
        super.tick();
        if (this.getOwnerEntity() == null) {
            this.discard();
            return;
        }
        int n = this.timer;
        this.timer = n + 1;
        if (this.timer == 5) {
            List players = EntityFinder.findPlayersInRange((LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)this.getPos(), (Number)5);
            Iterable $this$forEach$iv = players;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Player player = (Player)element$iv;
                boolean bl = false;
                if (!player.getBoundingBox().intersects(this.getBoundingBox())) continue;
                DamageSources damageSources = this.damageSources();
                IntegrityPhase3Entity integrityPhase3Entity = this.getOwnerEntity();
                Intrinsics.checkNotNull((Object)((Object)integrityPhase3Entity));
                player.hurt(damageSources.mobAttack((LivingEntity)integrityPhase3Entity), 15.0f);
                double dx = player.getX() - this.getX();
                double dz = player.getZ() - this.getZ();
                double horizontalDist = RangesKt.coerceAtLeast((double)Math.sqrt(dx * dx + dz * dz), (double)0.001);
                double knockbackStrength = 1.5;
                double upwardStrength = 2.6;
                player.setDeltaMovement(player.getDeltaMovement().add(dx / horizontalDist * knockbackStrength, upwardStrength, dz / horizontalDist * knockbackStrength));
                player.hurtMarked = true;
            }
        }
        boolean bl = hasTentacleNearby = EntityFinder.findClosestEntityInRange((LevelAccessor)((LevelAccessor)this.getLevel()), VoidTentacleEntity.class, (Vec3)this.getPos(), (Number)20) != null;
        if (this.timer > 40 && !hasTentacleNearby) {
            this.discard();
        }
        if (this.timer > 180 && hasTentacleNearby) {
            this.discard();
        }
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        AnimationController controller = new AnimationController((GeoAnimatable)this, "hit", 0, arg_0 -> IntegrityP3GroundArmEntity.registerControllers$lambda$0(this, arg_0));
        controller.triggerableAnim("stuck", RawAnimation.begin().thenPlayAndHold("groundAttackTentaclesStuck"));
        reg.add(controller);
    }

    private static final PlayState registerControllers$lambda$0(IntegrityP3GroundArmEntity this$0, AnimationState state) {
        if (!this$0.stuckStatus()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.hold((Entity)entity, (AnimationController)animationController, (String)"groundAttackTentacles");
        }
        return PlayState.CONTINUE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(IntegrityP3GroundArmEntity.class, "isStuck", "stuckStatus()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(IntegrityP3GroundArmEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        DATA_STUCK = entityDataAccessor;
        EntityDataAccessor entityDataAccessor2 = SynchedEntityData.defineId(IntegrityP3GroundArmEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor2, (String)"defineId(...)");
        DATA_OWNER_ID = entityDataAccessor2;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/entity/integrity/phase3/IntegrityP3GroundArmEntity$Companion;", "", "<init>", "()V", "DATA_STUCK", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "DATA_OWNER_ID", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

