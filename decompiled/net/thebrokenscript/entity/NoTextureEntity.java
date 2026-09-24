/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Position
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.ParticleUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  net.thebrokenscript.brokencore.api.ext.TagExt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.util.math.Vectors
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package net.thebrokenscript.entity;

import java.util.Collection;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.ParticleUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.brokencore.api.ext.TagExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.util.math.Vectors;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSItems;
import net.thebrokenscript.registry.TBSParticleTypes;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J4\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0016\u00a8\u0006\""}, d2={"Lnet/thebrokenscript/entity/NoTextureEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "registerGoals", "", "removeWhenFarAway", "", "distanceToClosestPlayer", "", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "baseTick", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "thebrokenscript-common"})
public final class NoTextureEntity
extends UwuableMonster
implements FinalizedSpawn {
    public NoTextureEntity(@NotNull EntityType<NoTextureEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
    }

    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, false, false));
        this.goalSelector.addGoal(1, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.2, false));
        this.goalSelector.addGoal(2, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0));
        this.goalSelector.addGoal(3, (Goal)new RandomLookAroundGoal((Mob)this));
        this.goalSelector.addGoal(4, (Goal)new FloatGoal((Mob)this));
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD);
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        LevelAccessor levelAccessor = (LevelAccessor)level;
        Vec3 vec3 = this.position();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
        Player player = (Player)EntityFinder.findClosestEntityInRange((LevelAccessor)levelAccessor, Player.class, (Vec3)vec3, (Number)100.0);
        if (player != null) {
            PlayerUtil.trySendOverlay((Player)player, (ResourceLocation)TBSConstants.id("textures/screens/blick.png"), (long)10L);
        }
        return null;
    }

    public void baseTick() {
        double timer;
        super.baseTick();
        Level level = this.level();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        ParticleUtil.sendParticles((ServerLevel)((ServerLevel)level), (Supplier)((Supplier)TBSParticleTypes.WRETCHED_PARTICLE), (Vec3)this.getPos(), (Number)2, (Vec3)Vectors.INSTANCE.all((Number)3), (Number)0);
        ServerPlayer player = EntityFinder.findClosestPlayerInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)40.0);
        if (player != null && EntityUtil.isWithin((Entity)((Entity)player), (Vec3)this.getPos(), (Number)20.0) && this.hasLineOfSight((Entity)player)) {
            if (this.random.nextBoolean()) {
                ParticleUtil.sendParticles((ServerLevel)((ServerLevel)level), (Supplier)((Supplier)TBSParticleTypes.NULL_PARTICLE), (Vec3)this.getPos(), (Number)50, (Vec3)Vectors.INSTANCE.all((Number)3), (Number)0);
                Object[] objectArray = new ResourceKey[]{TBSDimensions.CLAN_VOID, TBSDimensions.NULL_TORTURE};
                ResourceKey target = (ResourceKey)CollectionsKt.random((Collection)CollectionsKt.listOf((Object[])objectArray), (Random)((Random)Random.Default));
                this.discard();
                PlayerUtil.trySendSound$default((Player)((Player)player), (Holder)((Holder)TBSSounds.TEXT_MADNESS_1), (float)10.0f, (float)0.0f, null, null, (long)0L, (int)60, null);
                player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 1, false, false));
                player.setHealth((float)this.random.nextInt(1, 10));
                PlayerUtil.sendTo((Player)((Player)player), (ResourceKey)target);
                PlayerExt.INSTANCE.updateVars((Player)player, (Function1<? super PlayerVariables, Unit>)((Function1)NoTextureEntity::baseTick$lambda$0));
            } else {
                ParticleUtil.sendParticles((ServerLevel)((ServerLevel)level), (Supplier)((Supplier)TBSParticleTypes.NULL_PARTICLE), (Vec3)this.getPos(), (Number)50, (Vec3)Vectors.INSTANCE.all((Number)3), (Number)0);
                this.discard();
                PlayerUtil.giveItem((Player)((Player)player), (ItemStack)TBSItems.SERIAL_DESIGNATION_N.getStack());
                EntityUtil.teleport((Entity)((Entity)player), (Vec3)this.getPos());
            }
        }
        if ((timer = TagExt.INSTANCE.addDouble(EntityUtil.getPersistentData((Entity)((Entity)this)), "timer", (Number)1.0)) == 20.0) {
            EntityUtil.getPersistentData((Entity)((Entity)this)).putDouble("timer", 0.0);
            int mult = this.random.nextBoolean() ? 1 : -1;
            int ox = this.random.nextInt(0, 6) * mult;
            int oy = this.random.nextInt(0, 6);
            int oz = this.random.nextInt(0, 6) * mult;
            BlockPos newPos = BlockPos.containing((Position)((Position)this.getPos())).offset(ox, oy, oz);
            ((ServerLevel)level).setBlock(newPos, TBSBlocks.DISRUPTION.getDefaultState(), 3);
        }
        if (((ServerLevel)level).isDay() && !((ServerLevel)level).isClientSide()) {
            this.discard();
        }
        this.refreshDimensions();
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "notexture", 0, arg_0 -> NoTextureEntity.registerControllers$lambda$0(this, arg_0)));
    }

    private static final Unit baseTick$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setFixPos(true);
        $this$updateVars.setSkipFallDamage(true);
        return Unit.INSTANCE;
    }

    private static final PlayState registerControllers$lambda$0(NoTextureEntity this$0, AnimationState it) {
        if (it.isMoving()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"walk");
        } else {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"idle");
        }
        return PlayState.CONTINUE;
    }
}

