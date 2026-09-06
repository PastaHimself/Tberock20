/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.Mth
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeInstance
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.enchantment.EnchantmentHelper
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.AttributeUtil
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster$BMC
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.animation.RawAnimation
 *  software.bernie.geckolib.animation.keyframe.event.CustomInstructionKeyframeEvent
 */
package net.thebrokenscript.entity.boss;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.ai.tentacle.TentacleGoals;
import net.thebrokenscript.brokencore.api.dsl.AttributeUtil;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.entity.boss.TetherEntity;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.animation.keyframe.event.CustomInstructionKeyframeEvent;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0014J\u0016\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 H\u0016J4\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0005\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\"2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020-H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006/"}, d2={"Lnet/thebrokenscript/entity/boss/VoidTentacleEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "spawnAnimPlayed", "", "registerGoals", "", "entityList", "", "Lnet/minecraft/world/entity/LivingEntity;", "getEntityList", "()Ljava/util/List;", "setEntityList", "(Ljava/util/List;)V", "doHurtTarget", "entity", "Lnet/minecraft/world/entity/Entity;", "damage", "", "hurtMultipleTargets", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "removeWhenFarAway", "distanceToClosestPlayer", "", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nVoidTentacleEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoidTentacleEntity.kt\nnet/thebrokenscript/entity/boss/VoidTentacleEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,147:1\n1869#2,2:148\n*S KotlinDebug\n*F\n+ 1 VoidTentacleEntity.kt\nnet/thebrokenscript/entity/boss/VoidTentacleEntity\n*L\n79#1:148,2\n*E\n"})
public final class VoidTentacleEntity
extends UwuableMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean spawnAnimPlayed;
    @NotNull
    private volatile List<LivingEntity> entityList;

    public VoidTentacleEntity(@NotNull EntityType<VoidTentacleEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.setPersistenceRequired();
        this.entityList = new ArrayList();
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, (Goal)new TentacleGoals.MeleeGoal(this));
        this.targetSelector.addGoal(0, (Goal)new TentacleGoals.AlwaysTargetPlayerGoal((Mob)this, 100));
    }

    @NotNull
    public final List<LivingEntity> getEntityList() {
        return this.entityList;
    }

    public final void setEntityList(@NotNull List<LivingEntity> list) {
        Intrinsics.checkNotNullParameter(list, (String)"<set-?>");
        this.entityList = list;
    }

    public final boolean doHurtTarget(@NotNull Entity entity, float damage) {
        boolean flag;
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        float f = damage;
        DamageSource damageSource = this.damageSources().mobAttack((LivingEntity)this);
        Level var5 = this.level();
        if (var5 instanceof ServerLevel) {
            f = EnchantmentHelper.modifyDamage((ServerLevel)((ServerLevel)var5), (ItemStack)this.getWeaponItem(), (Entity)entity, (DamageSource)damageSource, (float)f);
        }
        if (flag = entity.hurt(damageSource, f)) {
            Level var7;
            float f1 = this.getKnockback(entity, damageSource);
            if (f1 > 0.0f && entity instanceof LivingEntity) {
                ((LivingEntity)entity).knockback((double)(f1 * 0.5f), (double)Mth.sin((float)(this.getYRot() * ((float)Math.PI / 180))), (double)(-Mth.cos((float)(this.getYRot() * ((float)Math.PI / 180)))));
                this.setDeltaMovement(this.getDeltaMovement().multiply(0.6, 1.0, 0.6));
            }
            if ((var7 = this.level()) instanceof ServerLevel) {
                EnchantmentHelper.doPostAttackEffects((ServerLevel)((ServerLevel)var7), (Entity)entity, (DamageSource)damageSource);
            }
            this.setLastHurtMob(entity);
            this.playAttackSound();
        }
        return flag;
    }

    public final void hurtMultipleTargets(float damage) {
        long i = 0L;
        i = 1L;
        Iterable $this$forEach$iv = this.entityList;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            LivingEntity entity = (LivingEntity)element$iv;
            boolean bl = false;
            EntityUtil.getQueue((Entity)((Entity)this)).add(i, () -> VoidTentacleEntity.hurtMultipleTargets$lambda$0$0(this, entity, damage));
            ++i;
        }
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD);
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "main_controller", 0, arg_0 -> VoidTentacleEntity.registerControllers$lambda$0(this, arg_0)));
        reg.add(new AnimationController((GeoAnimatable)this, "sweep", 0, VoidTentacleEntity::registerControllers$lambda$1).triggerableAnim("360_Sweep", RawAnimation.begin().thenPlay("360_Sweep")).setCustomInstructionKeyframeHandler(arg_0 -> VoidTentacleEntity.registerControllers$lambda$2(this, arg_0)));
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        block1: {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
            Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
            Intrinsics.checkNotNullParameter((Object)event, (String)"event");
            AttributeInstance attributeInstance = this.getAttribute(Attributes.SCALE);
            if (!Intrinsics.areEqual((Double)(attributeInstance != null ? Double.valueOf(attributeInstance.getBaseValue()) : null), (double)1.0)) break block1;
            AttributeInstance attributeInstance2 = this.getAttribute(Attributes.SCALE);
            if (attributeInstance2 != null) {
                attributeInstance2.setBaseValue((double)this.random.nextIntBetweenInclusive(1, 5));
            }
        }
        return null;
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    private static final Unit hurtMultipleTargets$lambda$0$0(VoidTentacleEntity this$0, LivingEntity $entity, float $damage) {
        this$0.doHurtTarget((Entity)$entity, $damage);
        return Unit.INSTANCE;
    }

    private static final PlayState registerControllers$lambda$0(VoidTentacleEntity this$0, AnimationState it) {
        if (!this$0.spawnAnimPlayed) {
            this$0.spawnAnimPlayed = true;
            it.getController().setAnimation(RawAnimation.begin().thenPlay("Spawn").thenLoop("Idle_Wiggle"));
        } else {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"Idle_Wiggle");
        }
        return PlayState.CONTINUE;
    }

    private static final PlayState registerControllers$lambda$1(AnimationState it) {
        return PlayState.CONTINUE;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final void registerControllers$lambda$2(VoidTentacleEntity this$0, CustomInstructionKeyframeEvent event) {
        if (!Intrinsics.areEqual((Object)event.getKeyframeData().getInstructions(), (Object)"hit;")) return;
        LocalPlayer localPlayer = ClientDSLKt.getMC().player;
        if (localPlayer == null) return;
        Level level = localPlayer.level();
        if (level == null) return;
        LevelAccessor levelAccessor = (LevelAccessor)level;
        Class<?> clazz = ((Object)((Object)this$0)).getClass();
        LocalPlayer localPlayer2 = ClientDSLKt.getMC().player;
        Intrinsics.checkNotNull((Object)localPlayer2);
        Vec3 vec3 = localPlayer2.position();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
        List list = EntityFinder.findEntitiesInRange((LevelAccessor)levelAccessor, clazz, (Vec3)vec3, (Number)((double)15 * this$0.getAttributes().getBaseValue(Attributes.SCALE)));
        if (list == null) return;
        if (((Collection)list).isEmpty()) return;
        boolean bl = true;
        if (!bl) return;
        boolean bl2 = true;
        if (!bl2) return;
        PacketSender.INSTANCE.sendToServer((CustomPacketPayload)TBSPackets.TENTACLE_HIT.of(this$0.getId()), new CustomPacketPayload[0]);
    }

    public static final /* synthetic */ AttributeSupplier.Builder access$attrs$s910975913(Function1 block) {
        return BaseMonster.attrs((Function1)block);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/entity/boss/VoidTentacleEntity$Companion;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster$BMC;", "Lnet/thebrokenscript/entity/boss/TetherEntity;", "<init>", "()V", "attributes", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "thebrokenscript-common"})
    public static final class Companion
    implements BaseMonster.BMC<TetherEntity> {
        private Companion() {
        }

        @NotNull
        public final AttributeSupplier.Builder attributes() {
            return VoidTentacleEntity.access$attrs$s910975913(Companion::attributes$lambda$0);
        }

        private static final Unit attributes$lambda$0(AttributeSupplier.Builder $this$attrs) {
            Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
            AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)14);
            AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)0);
            AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)1);
            return Unit.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

