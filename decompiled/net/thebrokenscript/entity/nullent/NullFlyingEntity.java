/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$BooleanRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.FlyingMoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.navigation.FlyingPathNavigation
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.entity.nullent;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.TheBrokenScript;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.util.RepTier;
import net.thebrokenscript.util.RepUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J \u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\nH\u0016J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001cH\u0016J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010+\u001a\u00020,H\u0016J4\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u0005\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00122\b\u00104\u001a\u0004\u0018\u00010/2\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u0016H\u0002J\b\u00108\u001a\u00020\u0016H\u0016J\b\u00109\u001a\u00020\u0016H\u0016J(\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u00192\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0014J\u0010\u0010A\u001a\u00020\u00162\u0006\u0010B\u001a\u00020\nH\u0016J\b\u0010C\u001a\u00020\u0016H\u0016J\b\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\u0019H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020$8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006I"}, d2={"Lnet/thebrokenscript/entity/nullent/NullFlyingEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "triggered", "", "getTriggered", "()Z", "setTriggered", "(Z)V", "checkSpawnRules", "Lnet/minecraft/world/level/LevelAccessor;", "reason", "Lnet/minecraft/world/entity/MobSpawnType;", "createNavigation", "Lnet/minecraft/world/entity/ai/navigation/PathNavigation;", "registerGoals", "", "removeWhenFarAway", "distanceToClosestPlayer", "", "causeFallDamage", "fallDistance", "", "multiplier", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "fireImmune", "hurt", "amount", "value", "", "timer", "getTimer", "()I", "setTimer", "(I)V", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "soundSFX", "tick", "baseTick", "checkFallDamage", "y", "onGroundIn", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "pos", "Lnet/minecraft/core/BlockPos;", "setNoGravity", "ignored", "aiStep", "getBoundingBoxForCulling", "Lnet/minecraft/world/phys/AABB;", "shouldRenderAtSqrDistance", "dist", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nNullFlyingEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NullFlyingEntity.kt\nnet/thebrokenscript/entity/nullent/NullFlyingEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,238:1\n1869#2,2:239\n*S KotlinDebug\n*F\n+ 1 NullFlyingEntity.kt\nnet/thebrokenscript/entity/nullent/NullFlyingEntity\n*L\n135#1:239,2\n*E\n"})
public final class NullFlyingEntity
extends BaseMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean triggered;
    @NotNull
    private static final String NATURAL_DESPAWN = "despawn_timer";

    public NullFlyingEntity(@NotNull EntityType<NullFlyingEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.xpReward = 0;
        this.setNoAi(false);
    }

    public final boolean getTriggered() {
        return this.triggered;
    }

    public final void setTriggered(boolean bl) {
        this.triggered = bl;
    }

    public boolean checkSpawnRules(@NotNull LevelAccessor level, @NotNull MobSpawnType reason) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
        return true;
    }

    @NotNull
    protected PathNavigation createNavigation(@NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return (PathNavigation)new FlyingPathNavigation((Mob)this, level);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 256.0f));
        this.goalSelector.addGoal(1, (Goal)new FloatGoal((Mob)this));
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean causeFallDamage(float fallDistance, float multiplier, @NotNull DamageSource source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return false;
    }

    public boolean fireImmune() {
        return true;
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Entity attacker = source.getEntity();
        if (attacker instanceof Player) {
            RepUtilKt.applyRep((Player)attacker, RepTier.LOSS_MEDIUM);
            if ((double)this.random.nextFloat() < 0.3 && PlayerExt.INSTANCE.getVars((Player)attacker).getEntityReputation() <= 25) {
                Entity entity = this.random.nextBoolean() ? EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.NULL_UNBEATABLE_BOSSFIGHT.get()), (LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)this.getPos())) : EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.NULL_IS_HERE.get()), (LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)this.getPos()));
            }
        }
        this.discard();
        return super.hurt(source, amount);
    }

    public final int getTimer() {
        return EntityUtil.getPersistentData((Entity)((Entity)this)).getInt(NATURAL_DESPAWN);
    }

    public final void setTimer(int value) {
        EntityUtil.getPersistentData((Entity)((Entity)this)).putInt(NATURAL_DESPAWN, value);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt(NATURAL_DESPAWN, this.getTimer());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        this.setTimer(compound.getInt(NATURAL_DESPAWN));
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        ServerPlayer player;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        Unit unit = this.random.nextBoolean() ? SoundUtil.tryBroadcastSoundInRange$default((LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos(), (Number)420, (SoundEvent)((SoundEvent)TBSSounds.NULL_SAD.get()), (float)420.0f, (float)0.0f, null, (int)48, null) : SoundUtil.tryBroadcastSoundInRange$default((LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos(), (Number)420, (SoundEvent)((SoundEvent)TBSSounds.NULL_SOUND_2.get()), (float)420.0f, (float)0.0f, null, (int)48, null);
        this.setTimer(3200);
        ServerPlayer serverPlayer = player = EntityFinder.findClosestPlayerInRange((ServerLevelAccessor)level, (Vec3)this.getPos(), (Number)100);
        Double playerY = serverPlayer != null ? Double.valueOf(serverPlayer.getY() + (double)25) : null;
        double surfaceY = level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, this.getBlockPos()).getY();
        if (playerY != null) {
            this.moveTo(this.getX(), playerY, this.getZ());
        } else {
            this.moveTo(this.getX(), surfaceY + (double)25, this.getZ());
        }
        this.setCustomName((Component)TBSLang.INSTANCE.getNULL_FLYING_NAME());
        this.setCustomNameVisible(true);
        this.setPersistenceRequired();
        this.moveControl = (MoveControl)new FlyingMoveControl((Mob)this, 10, true);
        return null;
    }

    private final void soundSFX() {
        Iterable $this$forEach$iv = EntityFinder.findPlayersInRange((LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)this.getPos(), (Number)128.0);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Player player = (Player)element$iv;
            boolean bl = false;
            PlayerExt.tryPlayHostile$default(PlayerExt.INSTANCE, player, (SoundEvent)TBSSounds.YOU_KNOW_NOTHING.get(), false, 0.35f, 0.5f, 0.0f, 18, null);
        }
    }

    public void tick() {
        super.tick();
        SideUtil.clientSide((Entity)((Entity)this), () -> NullFlyingEntity.tick$lambda$0(this));
    }

    public void baseTick() {
        this.onServerTick(arg_0 -> NullFlyingEntity.baseTick$lambda$0(this, arg_0));
    }

    protected void checkFallDamage(double y, boolean onGroundIn, @NotNull BlockState state, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
    }

    public void setNoGravity(boolean ignored) {
        super.setNoGravity(true);
    }

    public void aiStep() {
        super.aiStep();
        this.setNoGravity(true);
    }

    @NotNull
    public AABB getBoundingBoxForCulling() {
        AABB aABB = super.getBoundingBoxForCulling().inflate(32.0);
        Intrinsics.checkNotNullExpressionValue((Object)aABB, (String)"inflate(...)");
        return aABB;
    }

    public boolean shouldRenderAtSqrDistance(double dist) {
        return dist < 65536.0;
    }

    private static final Object tick$lambda$0(NullFlyingEntity this$0) {
        if (!ClientVariables.INSTANCE.has(16L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return false;
            }
            LocalPlayer player = localPlayer;
            if (PlayerExt.INSTANCE.isEntityInFovCone((Player)player, (Entity)this$0, Double.valueOf(((Number)ClientDSLKt.getMC().options.fov().get()).intValue()))) {
                ClientVariables.INSTANCE.set(16L);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$0(NullFlyingEntity this$0, ServerLevel level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        ServerPlayer player = EntityFinder.findClosestPlayerInRange((ServerLevel)level, (Vec3)this$0.getPos(), (Number)512.0);
        if (player != null) {
            this$0.lookControl.setLookAt((Entity)player);
            for (ServerPlayer playerInRange : EntityFinder.findPlayersInRange((ServerLevel)level, (Vec3)this$0.getPos(), (Number)128.0)) {
                if (!PlayerUtil.isLookingAt((Player)((Player)playerInRange), (Entity)((Entity)this$0)) || this$0.triggered) continue;
                Ref.BooleanRef didPlayerSneak = new Ref.BooleanRef();
                didPlayerSneak.element = playerInRange.isCrouching();
                this$0.triggered = true;
                TheBrokenScript.serverWorkQueue.add(20L, () -> NullFlyingEntity.baseTick$lambda$0$0(playerInRange, didPlayerSneak, this$0));
                break;
            }
            if (this$0.isWithin((Entity)player, 30)) {
                this$0.discard();
                Object object = (double)this$0.random.nextFloat() < 0.7 ? Boolean.valueOf(player.hurt(level.damageSources().generic(), (float)this$0.random.nextInt(1, 10))) : EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.NULL_IS_HERE.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)this$0.getPos()));
            }
        }
        int n = this$0.getTimer();
        this$0.setTimer(n + -1);
        if (this$0.getTimer() == 0) {
            this$0.discard();
        }
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$0$0(ServerPlayer $playerInRange, Ref.BooleanRef $didPlayerSneak, NullFlyingEntity this$0) {
        if ($playerInRange.isCrouching()) {
            $didPlayerSneak.element = true;
        }
        if (!$didPlayerSneak.element) {
            this$0.discard();
            RepUtilKt.applyRep((Player)$playerInRange, RepTier.LOSS_MINOR);
            this$0.soundSFX();
        } else {
            this$0.discard();
            if (PlayerExt.INSTANCE.getVars((Player)$playerInRange).getNullFlyRepGainTimer() == 0) {
                RepUtilKt.applyRep((Player)$playerInRange, RepTier.GAIN_MINOR);
                PlayerExt.INSTANCE.updateVars((Player)$playerInRange, (Function1<? super PlayerVariables, Unit>)((Function1)NullFlyingEntity::baseTick$lambda$0$0$0));
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$0$0$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setNullFlyRepGainTimer($this$updateVars.getNullFlyRepGainTimer() + 24000);
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/entity/nullent/NullFlyingEntity$Companion;", "", "<init>", "()V", "createAttributes", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "NATURAL_DESPAWN", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final AttributeSupplier.Builder createAttributes() {
            AttributeSupplier.Builder builder = Monster.createMobAttributes();
            builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
            builder = builder.add(Attributes.MAX_HEALTH, 810.0);
            builder = builder.add(Attributes.ARMOR, 0.0);
            builder = builder.add(Attributes.ATTACK_DAMAGE, 53.0);
            builder = builder.add(Attributes.FOLLOW_RANGE, 916.0);
            builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 50.0);
            builder = builder.add(Attributes.ATTACK_KNOCKBACK, 50.0);
            AttributeSupplier.Builder builder2 = builder = builder.add(Attributes.FLYING_SPEED, 0.3);
            Intrinsics.checkNotNull((Object)builder2);
            return builder2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

