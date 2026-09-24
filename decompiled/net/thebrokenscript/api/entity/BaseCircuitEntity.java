/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MoverType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.animal.FlyingAnimal
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.client.data.ClientVariables;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0004J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0014J\u0010\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0015H\u0014\u00a8\u0006'"}, d2={"Lnet/thebrokenscript/api/entity/BaseCircuitEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "type", "Lnet/minecraft/world/entity/EntityType;", "Lnet/minecraft/world/entity/monster/Monster;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "removeWhenFarAway", "", "distanceToClosestPlayer", "", "isPushable", "forceHurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "hurt", "kill", "", "travel", "travelVector", "Lnet/minecraft/world/phys/Vec3;", "baseTick", "tick", "canStandOnFluid", "fluidState", "Lnet/minecraft/world/level/material/FluidState;", "playStepSound", "pos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "canBeAffected", "effectInstance", "Lnet/minecraft/world/effect/MobEffectInstance;", "registerGoals", "thebrokenscript-common"})
public abstract class BaseCircuitEntity
extends UwuableMonster {
    public BaseCircuitEntity(@NotNull EntityType<? extends Monster> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean isPushable() {
        return false;
    }

    protected final boolean forceHurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return super.hurt(source, amount);
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD);
    }

    public void kill() {
        super.kill();
        this.discard();
    }

    /*
     * Unable to fully structure code
     */
    public void travel(@NotNull Vec3 travelVector) {
        block2: {
            Intrinsics.checkNotNullParameter((Object)travelVector, (String)"travelVector");
            if (!this.isControlledByLocalInstance()) break block2;
            fluidstate = this.level().getFluidState(this.blockPosition());
            if (!this.isInWater() || !this.isAffectedByFluids()) ** GOTO lbl-1000
            Intrinsics.checkNotNull((Object)fluidstate);
            if (!this.canStandOnFluid(fluidstate)) {
                this.moveRelative(this.getSpeed(), travelVector);
                this.move(MoverType.SELF, this.getDeltaMovement());
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.6, 0.98, 0.6));
            } else lbl-1000:
            // 2 sources

            {
                super.travel(travelVector);
                return;
            }
        }
        this.calculateEntityAnimation(this instanceof FlyingAnimal);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void baseTick() {
        super.baseTick();
        if (!this.getLevel().getBlockState(this.getBlockPos()).getFluidState().isEmpty() || !this.getLevel().getBlockState(this.getBlockPos().above()).getFluidState().isEmpty()) {
            FluidState fluidState = this.getBlockStateOn().getFluidState();
            Intrinsics.checkNotNullExpressionValue((Object)fluidState, (String)"getFluidState(...)");
            if (!this.canStandOnFluid(fluidState)) {
                this.navigation.setCanFloat(true);
                if (this.getTarget() == null) return;
                LivingEntity livingEntity = this.getTarget();
                Intrinsics.checkNotNull((Object)livingEntity);
                if (livingEntity.getY() > this.getPos().y) {
                    this.setDeltaMovement(this.getDeltaMovement().x, 0.1, this.getDeltaMovement().z);
                    return;
                }
                this.setDeltaMovement(this.getDeltaMovement().x, -0.1, this.getDeltaMovement().z);
                return;
            }
        }
        if (!this.isUnderWater()) return;
        FluidState fluidState = this.getBlockStateOn().getFluidState();
        Intrinsics.checkNotNullExpressionValue((Object)fluidState, (String)"getFluidState(...)");
        if (!this.canStandOnFluid(fluidState)) return;
        this.setDeltaMovement(this.getDeltaMovement().x, 0.75, this.getDeltaMovement().z);
    }

    public void tick() {
        super.tick();
        SideUtil.clientSide((Entity)((Entity)this), () -> BaseCircuitEntity.tick$lambda$0(this));
    }

    public boolean canStandOnFluid(@NotNull FluidState fluidState) {
        block7: {
            block5: {
                block6: {
                    block4: {
                        Intrinsics.checkNotNullParameter((Object)fluidState, (String)"fluidState");
                        if (this.getTarget() == null) {
                            return !fluidState.isEmpty();
                        }
                        LivingEntity livingEntity = this.getTarget();
                        Intrinsics.checkNotNull((Object)livingEntity);
                        if (!livingEntity.isSwimming()) break block4;
                        LivingEntity livingEntity2 = this.getTarget();
                        Intrinsics.checkNotNull((Object)livingEntity2);
                        if (livingEntity2.isInWater()) break block5;
                    }
                    LivingEntity livingEntity = this.getTarget();
                    Intrinsics.checkNotNull((Object)livingEntity);
                    if (!livingEntity.isVisuallySwimming()) break block6;
                    LivingEntity livingEntity3 = this.getTarget();
                    Intrinsics.checkNotNull((Object)livingEntity3);
                    if (livingEntity3.isInWater()) break block5;
                }
                LivingEntity livingEntity = this.getTarget();
                Intrinsics.checkNotNull((Object)livingEntity);
                if (!livingEntity.isInWater()) break block7;
            }
            return false;
        }
        return !fluidState.isEmpty();
    }

    protected void playStepSound(@NotNull BlockPos pos, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
    }

    public boolean canBeAffected(@NotNull MobEffectInstance effectInstance) {
        Intrinsics.checkNotNullParameter((Object)effectInstance, (String)"effectInstance");
        return false;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.goalSelector.addGoal(1, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.2, false));
        this.goalSelector.addGoal(2, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0));
        this.goalSelector.addGoal(3, (Goal)new RandomLookAroundGoal((Mob)this));
        this.goalSelector.addGoal(4, (Goal)new FloatGoal((Mob)this));
    }

    private static final Object tick$lambda$0(BaseCircuitEntity this$0) {
        if (!ClientVariables.INSTANCE.has(1L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return false;
            }
            LocalPlayer player = localPlayer;
            if (PlayerExt.INSTANCE.isEntityInFovCone((Player)player, (Entity)this$0, Double.valueOf(((Number)ClientDSLKt.getMC().options.fov().get()).intValue()))) {
                ClientVariables.INSTANCE.set(1L);
            }
        }
        return Unit.INSTANCE;
    }
}

