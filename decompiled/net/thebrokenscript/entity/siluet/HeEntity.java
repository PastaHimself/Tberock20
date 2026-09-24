/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.DifficultyInstance
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
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.world.TimeOfDay
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.entity.siluet;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
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
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.entity.BaseSiluetEntity;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSParticleTypes;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J4\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0005\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\nH\u0016R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\""}, d2={"Lnet/thebrokenscript/entity/siluet/HeEntity;", "Lnet/thebrokenscript/api/entity/BaseSiluetEntity;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "registerGoals", "", "value", "", "despawnTimer", "getDespawnTimer", "()I", "setDespawnTimer", "(I)V", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "baseTick", "Companion", "thebrokenscript-common"})
public final class HeEntity
extends BaseSiluetEntity
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String NATURAL_DESPAWN = "despawn_timer";

    public HeEntity(@NotNull EntityType<HeEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FENCE, 0.0f);
        this.setPathfindingMalus(PathType.RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0f);
    }

    protected void registerGoals() {
        this.targetSelector.addGoal(1, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, false, false));
        this.goalSelector.addGoal(2, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.2, false));
        this.goalSelector.addGoal(3, (Goal)new RandomStrollGoal((PathfinderMob)this, 1.0));
        this.targetSelector.addGoal(4, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.goalSelector.addGoal(5, (Goal)new RandomLookAroundGoal((Mob)this));
        this.goalSelector.addGoal(6, (Goal)new FloatGoal((Mob)this));
    }

    public final int getDespawnTimer() {
        return EntityUtil.getPersistentData((Entity)((Entity)this)).getInt(NATURAL_DESPAWN);
    }

    public final void setDespawnTimer(int value) {
        EntityUtil.getPersistentData((Entity)((Entity)this)).putInt(NATURAL_DESPAWN, value);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt(NATURAL_DESPAWN, this.getDespawnTimer());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        compound.getInt(NATURAL_DESPAWN);
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        SoundUtil.playSound$default((LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos(), (SoundEvent)((SoundEvent)TBSSounds.HIM_SPAWN.get()), (float)10.0f, (float)0.0f, null, (int)16, null);
        if (level instanceof ServerLevel) {
            EntityType entityType = EntityType.LIGHTNING_BOLT;
            Intrinsics.checkNotNullExpressionValue((Object)entityType, (String)"LIGHTNING_BOLT");
            EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos());
            ((ServerLevel)level).setWeatherParameters(0, ServerLevel.RAIN_DURATION.sample(((ServerLevel)level).random), true, false);
            this.setDespawnTimer(18000);
        }
        return null;
    }

    @Override
    public void baseTick() {
        super.baseTick();
        Level level = this.level();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        ServerPlayer player = EntityFinder.findClosestPlayerInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)1000.0);
        if (player != null) {
            this.lookAt(EntityAnchorArgument.Anchor.EYES, player.position());
            if (this.isWithin((Entity)player, 10)) {
                if (((ServerLevel)level).random.nextBoolean()) {
                    this.discard();
                    player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 35, 1, false, false));
                    List players = EntityFinder.findPlayersInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)25);
                    for (ServerPlayer player2 : players) {
                        PlayerExt.tryPlaySound$default(PlayerExt.INSTANCE, (Player)player2, (SoundEvent)TBSSounds.NULL_IS_HERE_LOOP.get(), false, 0.0f, 0.0f, 0.0f, 22, null);
                    }
                    if ((double)((ServerLevel)level).random.nextFloat() < 0.7) {
                        TimeOfDay.MIDNIGHT.setFake();
                    }
                } else {
                    this.discard();
                    EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.HE_CHASE.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos());
                }
            }
            if (this.isWithin((Entity)player, 20.0) && PlayerUtil.isLookingAt((Player)((Player)player), (Entity)((Entity)this))) {
                this.discard();
                player.lookAt(EntityAnchorArgument.Anchor.EYES, this.getPos().add(0.0, 1.0, 0.0));
                if (this.random.nextBoolean()) {
                    if (this.getOnSurface()) {
                        EntityType entityType = EntityType.LIGHTNING_BOLT;
                        Intrinsics.checkNotNullExpressionValue((Object)entityType, (String)"LIGHTNING_BOLT");
                        LevelAccessor levelAccessor = (LevelAccessor)level;
                        Vec3 vec3 = player.position();
                        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
                        EntityTypeExt.trySummon((EntityType)entityType, (LevelAccessor)levelAccessor, (Vec3)vec3);
                    }
                    EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.HE_CHASE.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos()));
                } else {
                    PlayerUtil.sendSound$default((ServerPlayer)player, (SoundEvent)((SoundEvent)TBSSounds.TEXT_MADNESS_1.get()), (float)10.0f, (float)0.0f, null, null, (long)0L, (int)60, null);
                    PlayerUtil.trySendOverlay((Player)((Player)player), (ResourceLocation)TBSConstants.id("textures/screens/cantyousee.png"), (long)10L);
                }
            }
        }
        if (((ServerLevel)level).isDay()) {
            this.discard();
            ((ServerLevel)level).sendParticles((ParticleOptions)TBSParticleTypes.NULL_PARTICLE.get(), this.getX(), this.getY(), this.getZ(), 50, 3.0, 3.0, 3.0, 0.0);
        }
        int n = this.getDespawnTimer();
        this.setDespawnTimer(n + -1);
        if (this.getDespawnTimer() <= 0) {
            this.discard();
            if ((double)this.random.nextFloat() < 0.01) {
                EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.HE_CHASE.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos()));
            }
        }
        this.refreshDimensions();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/entity/siluet/HeEntity$Companion;", "", "<init>", "()V", "NATURAL_DESPAWN", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

