/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.thebrokenscript.brokencore.api.dsl.AttributeUtil
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package net.thebrokenscript.entity.anomaly.sa2;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.thebrokenscript.api.entity.ai.anomaly.sa2.AvoidLightGoal;
import net.thebrokenscript.brokencore.api.dsl.AttributeUtil;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.entity.anomaly.sa2.SubAnomaly2BaseEntity;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/entity/anomaly/sa2/SubAnomaly2SpiderEntity;", "Lnet/thebrokenscript/entity/anomaly/sa2/SubAnomaly2BaseEntity;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "registerGoals", "", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "tick", "Companion", "thebrokenscript-common"})
public final class SubAnomaly2SpiderEntity
extends SubAnomaly2BaseEntity {
    @NotNull
    public static final Companion Companion = new Companion(null);

    public SubAnomaly2SpiderEntity(@NotNull EntityType<SubAnomaly2SpiderEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, (Goal)new AvoidLightGoal((Mob)this));
        this.targetSelector.addGoal(4, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, false, false));
        this.goalSelector.addGoal(5, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.2, false));
        this.targetSelector.addGoal(6, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.goalSelector.addGoal(7, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0));
        this.goalSelector.addGoal(8, (Goal)new RandomLookAroundGoal((Mob)this));
        this.goalSelector.addGoal(9, (Goal)new FloatGoal((Mob)this));
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        Object[] objectArray = new String[]{"SpiderIdle", "SpiderChase", "SpiderWalk", "SpiderDespawn", "StalkIdle", "StalkFlying", "StalkChase", "StalkSpawn", "StalkDespawn", "StalkTransformToSpider", "SpiderTransformToStalk", "MimicTransformToSpider", "MimicIdle", "MimicSpawn"};
        List ANIMS = CollectionsKt.listOf((Object[])objectArray);
        reg.add(new AnimationController((GeoAnimatable)this, "base", 0, arg_0 -> SubAnomaly2SpiderEntity.registerControllers$lambda$0(this, arg_0)));
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getTarget() != null && this.navigation.isDone()) {
            LivingEntity livingEntity = this.getTarget();
            Intrinsics.checkNotNull((Object)livingEntity);
            this.navigation.moveTo((Entity)livingEntity, 1.2);
        }
    }

    private static final PlayState registerControllers$lambda$0(SubAnomaly2SpiderEntity this$0, AnimationState state) {
        if (this$0.tickCount < 46 && !this$0.getHasAlreadyTransformed() && !this$0.getTransforming()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"SpiderSpawn");
        } else if (this$0.getDespawning()) {
            int startTick = this$0.getStart();
            if (this$0.tickCount < startTick + 36) {
                Entity entity = (Entity)this$0;
                AnimationController animationController = state.getController();
                Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
                GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"SpiderDespawn");
            } else {
                this$0.discard();
                state.getController().stop();
            }
        } else if (this$0.getTransforming()) {
            int startTick = this$0.getTransformStart();
            if (this$0.tickCount < startTick + 20) {
                state.getController().getAnimationState();
                Entity entity = (Entity)this$0;
                AnimationController animationController = state.getController();
                Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
                GeckoUtil.once((Entity)entity, (AnimationController)animationController, (String)"SpiderTransformToStalk");
            } else {
                this$0.entityData.set(SubAnomaly2BaseEntity.Companion.getIS_TRANSFORMING(), (Object)false);
                this$0.setTransforming(false);
            }
        } else if (state.isMoving()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"SpiderChase");
        } else {
            Entity entity = (Entity)this$0;
            AnimationController animationController = state.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"SpiderIdle");
        }
        return PlayState.CONTINUE;
    }

    public static final /* synthetic */ AttributeSupplier.Builder access$attrs$s910975913(Function1 block) {
        return BaseMonster.attrs((Function1)block);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/entity/anomaly/sa2/SubAnomaly2SpiderEntity$Companion;", "", "<init>", "()V", "attributes", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final AttributeSupplier.Builder attributes() {
            return SubAnomaly2SpiderEntity.access$attrs$s910975913(Companion::attributes$lambda$0);
        }

        private static final Unit attributes$lambda$0(AttributeSupplier.Builder $this$attrs) {
            Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
            AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.22);
            AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)910);
            AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
            AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)1);
            AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)916);
            AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)10.6);
            return Unit.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

