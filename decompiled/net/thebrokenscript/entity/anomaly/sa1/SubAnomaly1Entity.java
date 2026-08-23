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
 *  kotlin.text.StringsKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.item.ItemEntity
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.projectile.AbstractArrow
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.AttributeUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.RandomUtil
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.entity.anomaly.sa1;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.block.ShadowBugBlock;
import net.thebrokenscript.brokencore.api.dsl.AttributeUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.RandomUtil;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSDamageTypes;
import net.thebrokenscript.registry.TBSParticleTypes;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 12\u00020\u0001:\u00011B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J \u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020 H\u0014J\b\u00100\u001a\u00020\u0011H\u0016R\u001f\u0010'\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010)0)0(\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,\u00a8\u00062"}, d2={"Lnet/thebrokenscript/entity/anomaly/sa1/SubAnomaly1Entity;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "canStandOnFluid", "", "fluidState", "Lnet/minecraft/world/level/material/FluidState;", "checkSpawnRules", "Lnet/minecraft/world/level/LevelAccessor;", "reason", "Lnet/minecraft/world/entity/MobSpawnType;", "defineSynchedData", "", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "registerGoals", "removeWhenFarAway", "distanceToClosestPlayer", "", "fireImmune", "isPushable", "knockback", "strength", "x", "z", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "bannedBlocks", "", "", "kotlin.jvm.PlatformType", "getBannedBlocks", "()Ljava/util/List;", "getHurtSound", "Lnet/minecraft/sounds/SoundEvent;", "damageSource", "baseTick", "Companion", "thebrokenscript-common"})
public final class SubAnomaly1Entity
extends BaseMonster {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final List<Object> bannedBlocks;
    @NotNull
    private static final EntityDataAccessor<Integer> DESPAWN_TIMER;

    public SubAnomaly1Entity(@NotNull EntityType<SubAnomaly1Entity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FENCE, 0.0f);
        this.setPathfindingMalus(PathType.RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0f);
        this.setPathfindingMalus(PathType.DANGER_FIRE, 0.0f);
        this.setPathfindingMalus(PathType.DAMAGE_FIRE, 0.0f);
        Object[] objectArray = new Object[]{Blocks.WATER, TBSBlocks.SHADOW_BUG, Blocks.SNOW, Blocks.SHORT_GRASS, Blocks.TALL_GRASS};
        this.bannedBlocks = CollectionsKt.mutableListOf((Object[])objectArray);
    }

    public boolean canStandOnFluid(@NotNull FluidState fluidState) {
        Intrinsics.checkNotNullParameter((Object)fluidState, (String)"fluidState");
        return !fluidState.isEmpty();
    }

    public boolean checkSpawnRules(@NotNull LevelAccessor level, @NotNull MobSpawnType reason) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
        return true;
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(DESPAWN_TIMER, (Object)0);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, false, false));
        this.goalSelector.addGoal(2, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.2, false));
        this.goalSelector.addGoal(3, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0));
        this.targetSelector.addGoal(4, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.goalSelector.addGoal(5, (Goal)new RandomLookAroundGoal((Mob)this));
        this.goalSelector.addGoal(6, (Goal)new FloatGoal((Mob)this));
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean fireImmune() {
        return true;
    }

    public boolean isPushable() {
        return false;
    }

    public void knockback(double strength, double x, double z) {
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        boolean cond;
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        boolean always = Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD);
        boolean bl = cond = always || source.isDirect() && source.getEntity() instanceof Player && this.invulnerableTime <= 10 && !this.isDeadOrDying();
        if (cond) {
            super.hurt(source, amount);
        }
        return cond;
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        Object object = this.entityData.get(DESPAWN_TIMER);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        compound.putInt("despawn_timer", ((Number)object).intValue());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        if (compound.contains("despawn_timer")) {
            this.entityData.set(DESPAWN_TIMER, (Object)compound.getInt("despawn_timer"));
        }
    }

    @NotNull
    public final List<Object> getBannedBlocks() {
        return this.bannedBlocks;
    }

    @NotNull
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        SoundEvent soundEvent = SoundEvents.EMPTY;
        Intrinsics.checkNotNullExpressionValue((Object)soundEvent, (String)"EMPTY");
        return soundEvent;
    }

    public void baseTick() {
        super.baseTick();
        Level level = this.level();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        this.entityData.set(DESPAWN_TIMER, (Object)(((Number)this.entityData.get(DESPAWN_TIMER)).intValue() + 1));
        if (((Number)this.entityData.get(DESPAWN_TIMER)).intValue() > 3600) {
            this.discard();
        }
        ((ServerLevel)level).sendParticles((ParticleOptions)TBSParticleTypes.NULL_PARTICLE.get(), this.getX(), this.getY(), this.getZ(), 2, 3.0, 3.0, 3.0, 0.0);
        LevelAccessor levelAccessor = (LevelAccessor)level;
        Vec3 vec3 = this.position();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
        for (Entity ent : EntityFinder.findSortedEntitiesInRange((LevelAccessor)levelAccessor, Entity.class, (Vec3)vec3, (Number)5.0)) {
            if (ent instanceof SubAnomaly1Entity || !this.hasLineOfSight(ent) || ent instanceof ItemEntity) continue;
            ent.hurt(ent.damageSources().source(TBSDamageTypes.SA1.getKey()), 2.0f);
            if (!(ent instanceof AbstractArrow)) continue;
            ent.remove(Entity.RemovalReason.DISCARDED);
        }
        if ((double)this.random.nextFloat() <= 0.12 && !this.isAggressive() || (double)this.random.nextFloat() <= 0.175 && this.isAggressive()) {
            RandomSource randomSource = this.random;
            Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
            double corruptX = RandomUtil.nextFloat((RandomSource)randomSource, (float)-5.0f, (float)5.0f);
            RandomSource randomSource2 = this.random;
            Intrinsics.checkNotNullExpressionValue((Object)randomSource2, (String)"random");
            double corruptY = RandomUtil.nextFloat((RandomSource)randomSource2, (float)-2.0f, (float)5.0f);
            RandomSource randomSource3 = this.random;
            Intrinsics.checkNotNullExpressionValue((Object)randomSource3, (String)"random");
            double corruptZ = RandomUtil.nextFloat((RandomSource)randomSource3, (float)-5.0f, (float)5.0f);
            BlockPos corruptPos = BlockPos.containing((double)(this.getX() + corruptX), (double)(this.getY() + corruptY), (double)(this.getZ() + corruptZ));
            if (!this.bannedBlocks.contains(((ServerLevel)level).getBlockState(corruptPos))) {
                if (Intrinsics.areEqual((Object)((ServerLevel)level).getBlockState(corruptPos).getBlock(), (Object)Blocks.AIR)) {
                    if ((double)this.random.nextFloat() <= 0.05) {
                        Entity entity = (Entity)this;
                        Intrinsics.checkNotNull((Object)corruptPos);
                        if (EntityUtil.hasLineOfSight((Entity)entity, (BlockPos)corruptPos)) {
                            ((ServerLevel)level).setBlock(corruptPos, TBSBlocks.BLOCK_IS_MISSING_ID.getDefaultState(), 3);
                        }
                    }
                } else {
                    CompoundTag prevTag;
                    BlockState state = ((ServerLevel)level).getBlockState(corruptPos);
                    BlockEntity blockEntity = ((ServerLevel)level).getBlockEntity(corruptPos);
                    CompoundTag compoundTag = prevTag = blockEntity != null ? blockEntity.saveCustomOnly((HolderLookup.Provider)((ServerLevel)level).registryAccess()) : null;
                    if (!(Intrinsics.areEqual((Object)corruptPos, (Object)this.getBlockPos().below()) || state.is(BlockTags.DOORS) || state.is(BlockTags.PLANKS) || state.is(Blocks.GLASS) || state.is(Blocks.GLASS_PANE) || state.is((Holder)TBSBlocks.BLOCK_IS_MISSING_ID) || state.is(Blocks.COBBLESTONE))) {
                        String string = state.getBlock().toString();
                        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
                        if (!StringsKt.contains((CharSequence)string, (CharSequence)"bed", (boolean)true)) {
                            String string2 = state.getBlock().toString();
                            Intrinsics.checkNotNullExpressionValue((Object)string2, (String)"toString(...)");
                            if (!StringsKt.contains((CharSequence)string2, (CharSequence)"chest", (boolean)true)) {
                                ((ServerLevel)level).removeBlockEntity(corruptPos);
                                ((ServerLevel)level).setBlock(corruptPos, TBSBlocks.SHADOW_BUG.getDefaultState(), 3);
                                BlockGetter blockGetter = (BlockGetter)level;
                                Intrinsics.checkNotNull((Object)corruptPos);
                                Intrinsics.checkNotNull((Object)state);
                                ShadowBugBlock.Companion.setPreviousState(blockGetter, corruptPos, state, prevTag);
                            }
                        }
                    }
                }
            }
        }
    }

    public static final /* synthetic */ AttributeSupplier.Builder access$attrs$s910975913(Function1 block) {
        return BaseMonster.attrs((Function1)block);
    }

    static {
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(SubAnomaly1Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        DESPAWN_TIMER = entityDataAccessor;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/entity/anomaly/sa1/SubAnomaly1Entity$Companion;", "", "<init>", "()V", "DESPAWN_TIMER", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "getDESPAWN_TIMER", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "attributes", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final EntityDataAccessor<Integer> getDESPAWN_TIMER() {
            return DESPAWN_TIMER;
        }

        @NotNull
        public final AttributeSupplier.Builder attributes() {
            return SubAnomaly1Entity.access$attrs$s910975913(Companion::attributes$lambda$0);
        }

        private static final Unit attributes$lambda$0(AttributeSupplier.Builder $this$attrs) {
            Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
            AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0.075);
            AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)50);
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

