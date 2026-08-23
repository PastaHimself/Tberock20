/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.IntRange
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundStopSoundPacket
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.RandomStrollGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ClipContext
 *  net.minecraft.world.level.ClipContext$Block
 *  net.minecraft.world.level.ClipContext$Fluid
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.DoorBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.BlockHitResult
 *  net.minecraft.world.phys.HitResult$Type
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.ComponentUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PacketUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.entity.nullent;

import java.lang.invoke.LambdaMetafactory;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.ai.null_maze.MazeHitGoal;
import net.thebrokenscript.api.entity.ai.pathfinding.MazeNavigator;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.ComponentUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PacketUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.registry.TBSDamageTypes;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.util.DynamicMazeNavigationGoal;
import net.thebrokenscript.util.RepTier;
import net.thebrokenscript.util.RepUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0003KLMB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0012H\u0016J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010$\u001a\u00020\u001eH\u0016J\b\u0010'\u001a\u00020\u0010H\u0016J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\fH\u0002J\b\u0010*\u001a\u00020\u0010H\u0002J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-H\u0016J \u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0016J4\u00104\u001a\u0004\u0018\u0001052\u0006\u0010\u0005\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00182\b\u0010:\u001a\u0004\u0018\u0001052\u0006\u0010;\u001a\u00020<H\u0016J\u0006\u0010=\u001a\u00020\u0012J\b\u0010>\u001a\u00020\u0010H\u0016J\u0010\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020!H\u0016J\u0010\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u00020\u00102\u0006\u0010H\u001a\u00020IH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010B\u001a\u00020\u000e2\u0006\u0010A\u001a\u00020\u000e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F\u00a8\u0006N"}, d2={"Lnet/thebrokenscript/entity/nullent/NullMazeEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "createNavigation", "Lnet/minecraft/world/entity/ai/navigation/PathNavigation;", "cachedGroundPos", "Lnet/minecraft/core/BlockPos;", "ticksSinceGroundSeen", "", "registerGoals", "", "doHurtTarget", "", "entity", "Lnet/minecraft/world/entity/Entity;", "checkSpawnRules", "Lnet/minecraft/world/level/LevelAccessor;", "spawnReason", "Lnet/minecraft/world/entity/MobSpawnType;", "removeWhenFarAway", "distanceToClosestPlayer", "", "causeFallDamage", "fallDistance", "", "multiplier", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "fireImmune", "hurt", "amount", "lastLightPos", "placedLightBlock", "tick", "placeLightBlock", "pos", "removeLightBlock", "remove", "reason", "Lnet/minecraft/world/entity/Entity$RemovalReason;", "awardKillScore", "killed", "scoreValue", "lastStuckCheckPos", "Lnet/minecraft/world/phys/Vec3;", "stuckTicks", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "isStuck", "baseTick", "die", "damageSource", "value", "timer", "getTimer", "()I", "setTimer", "(I)V", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "StalkGoal", "PersistentTargetGoal", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nNullMazeEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NullMazeEntity.kt\nnet/thebrokenscript/entity/nullent/NullMazeEntity\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,456:1\n183#2,2:457\n*S KotlinDebug\n*F\n+ 1 NullMazeEntity.kt\nnet/thebrokenscript/entity/nullent/NullMazeEntity\n*L\n99#1:457,2\n*E\n"})
public final class NullMazeEntity
extends BaseMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private BlockPos cachedGroundPos;
    private int ticksSinceGroundSeen;
    @Nullable
    private BlockPos lastLightPos;
    private boolean placedLightBlock;
    @NotNull
    private Vec3 lastStuckCheckPos;
    private int stuckTicks;
    @NotNull
    private static final String NATURAL_DESPAWN = "despawn_timer";

    public NullMazeEntity(@NotNull EntityType<NullMazeEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.setPathfindingMalus(PathType.DANGER_POWDER_SNOW, 0.0f);
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FENCE, 0.0f);
        this.setPathfindingMalus(PathType.RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 8.0f);
        Vec3 vec3 = Vec3.ZERO;
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"ZERO");
        this.lastStuckCheckPos = vec3;
    }

    @NotNull
    protected PathNavigation createNavigation(@NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return (PathNavigation)new MazeNavigator((Mob)this, level);
    }

    /*
     * Unable to fully structure code
     */
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, (Goal)new StalkGoal((Mob)this, (Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, registerGoals$lambda$0(net.thebrokenscript.entity.nullent.NullMazeEntity ), ()Lnet/minecraft/world/entity/player/Player;)((NullMazeEntity)this), 0.0, 4, null));
        this.goalSelector.addGoal(2, (Goal)new MazeHitGoal.ContinuousMeleeAttackGoal((PathfinderMob)this, 1.2f, 2.0));
        v0 = (Mob)this;
        v1 = (Function0)LambdaMetafactory.metafactory(null, null, null, ()Ljava/lang/Object;, registerGoals$lambda$1(net.thebrokenscript.entity.nullent.NullMazeEntity ), ()Lnet/minecraft/world/phys/Vec3;)((NullMazeEntity)this);
        if (this.getTarget() == null) ** GOTO lbl-1000
        v2 = this.getTarget();
        Intrinsics.checkNotNull((Object)v2);
        if ((double)v2.fallDistance < 0.1) {
            v3 = 1.45;
        } else lbl-1000:
        // 2 sources

        {
            v3 = this.getTarget() != null ? 1.55 : 1.45;
        }
        this.goalSelector.addGoal(3, (Goal)new DynamicMazeNavigationGoal(v0, (Function0<? extends Vec3>)v1, v3, true));
        this.goalSelector.addGoal(4, (Goal)new RandomStrollGoal(this){
            final /* synthetic */ NullMazeEntity this$0;
            {
                this.this$0 = $receiver;
                super((PathfinderMob)$receiver, 1.0);
            }

            public boolean canUse() {
                if (this.this$0.getTarget() != null || this.mob.hasControllingPassenger()) {
                    return false;
                }
                if (!this.forceTrigger && this.mob.getRandom().nextInt(RandomStrollGoal.reducedTickDelay((int)10)) != 0) {
                    return false;
                }
                Vec3 vec3 = this.getPosition();
                if (vec3 == null) {
                    return false;
                }
                Vec3 vec32 = vec3;
                this.wantedX = vec32.x;
                this.wantedY = vec32.y;
                this.wantedZ = vec32.z;
                this.forceTrigger = false;
                return true;
            }
        });
        this.targetSelector.addGoal(1, (Goal)new PersistentTargetGoal((Mob)this, Player.class, 450));
    }

    public boolean doHurtTarget(@NotNull Entity entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        return entity.hurt(this.damageSources().source(TBSDamageTypes.NULL_MAZE.getKey()), (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE));
    }

    public boolean checkSpawnRules(@NotNull LevelAccessor level, @NotNull MobSpawnType spawnReason) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)spawnReason, (String)"spawnReason");
        return true;
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
        boolean isPlayer = source.getDirectEntity() instanceof Player;
        return (isPlayer || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD)) && super.hurt(source, amount);
    }

    public void tick() {
        BlockPos currentPos;
        super.tick();
        if (!this.level().isClientSide && !Intrinsics.areEqual((Object)this.lastLightPos, (Object)(currentPos = this.blockPosition().offset(0, 1, 0)))) {
            this.removeLightBlock();
            Intrinsics.checkNotNull((Object)currentPos);
            this.placeLightBlock(currentPos);
            this.lastLightPos = currentPos;
        }
        SideUtil.clientSide((Entity)((Entity)this), () -> NullMazeEntity.tick$lambda$0(this));
    }

    private final void placeLightBlock(BlockPos pos) {
        BlockState state = this.level().getBlockState(pos);
        if (state.isAir() || state.canBeReplaced()) {
            this.level().setBlock(pos, Blocks.LIGHT.defaultBlockState(), 3);
            this.placedLightBlock = true;
        }
    }

    private final void removeLightBlock() {
        block2: {
            BlockPos blockPos = this.lastLightPos;
            if (blockPos == null) break block2;
            BlockPos pos = blockPos;
            boolean bl = false;
            if (this.placedLightBlock) {
                BlockState state = this.level().getBlockState(pos);
                if (Intrinsics.areEqual((Object)state.getBlock(), (Object)Blocks.LIGHT)) {
                    this.getLevel().setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                }
                this.placedLightBlock = false;
            }
        }
    }

    public void remove(@NotNull Entity.RemovalReason reason) {
        Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
        if (!this.level().isClientSide) {
            this.removeLightBlock();
        }
        super.remove(reason);
    }

    public void awardKillScore(@NotNull Entity killed, int scoreValue, @NotNull DamageSource source) {
        Intrinsics.checkNotNullParameter((Object)killed, (String)"killed");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        super.awardKillScore(killed, scoreValue, source);
        PacketUtil.tryBroadcastPacket((LevelAccessor)((LevelAccessor)this.getLevel()), (Packet)((Packet)new ClientboundStopSoundPacket(null, null)));
        SoundUtil.playSound$default((LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)this.getPos(), (SoundEvent)((SoundEvent)TBSSounds.NULL_KILLS_PLAYER.get()), (float)10.0f, (float)0.0f, null, (int)24, null);
        if (killed instanceof ServerPlayer && this.random.nextBoolean()) {
            ServerPlayer serverPlayer = (ServerPlayer)killed;
            String string = ComponentUtil.getTranslationKey((Component)((Component)TBSLang.INSTANCE.getNULL_MAZE_KICK()));
            Intrinsics.checkNotNull((Object)string);
            MutableComponent mutableComponent = Component.translatable((String)string);
            Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"translatable(...)");
            PlayerUtil.kick((ServerPlayer)serverPlayer, (Component)((Component)mutableComponent));
        }
        if (!this.level().isClientSide) {
            this.removeLightBlock();
        }
        this.discard();
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        this.setTimer(3200);
        return null;
    }

    public final boolean isStuck() {
        return this.stuckTicks > 30;
    }

    public void baseTick() {
        int n;
        super.baseTick();
        if (!(this.getLevel() instanceof ServerLevel)) {
            return;
        }
        if (this.getTimer() >= 0) {
            n = this.getTimer();
            this.setTimer(n + -1);
            if (this.getTimer() == 0) {
                this.removeLightBlock();
                this.discard();
                return;
            }
        }
        if (this.getTarget() != null) {
            if (this.position().distanceToSqr(this.lastStuckCheckPos) < 0.002) {
                n = this.stuckTicks;
                this.stuckTicks = n + 1;
            } else {
                this.stuckTicks = 0;
            }
            Vec3 vec3 = this.position();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
            this.lastStuckCheckPos = vec3;
        } else {
            this.stuckTicks = 0;
        }
        if (this.isStuck() && this.getTarget() != null) {
            int lookDistance = 2;
            Vec3 facing = this.getLookAngle().normalize();
            int i = 1;
            while (true) {
                BlockPos frontPos = this.blockPosition().offset((int)(facing.x * (double)i), (int)(facing.y * (double)i), (int)(facing.z * (double)i));
                BlockState state = this.getLevel().getBlockState(frontPos);
                if (!state.isAir() && !TBSConfigs.INSTANCE.getServer().getDisableBlockBreaking()) {
                    this.getLevel().destroyBlock(frontPos, true, (Entity)this);
                    this.getLevel().destroyBlock(frontPos.above(), true, (Entity)this);
                    this.stuckTicks = 0;
                }
                if (i == lookDistance) break;
                ++i;
            }
        }
        if (this.getTarget() != null) {
            double maxDistance = 2.5;
            Vec3 start = this.getEyePosition();
            Vec3 end = start.add(this.getForward().scale(maxDistance));
            BlockHitResult hit = this.level().clip(new ClipContext(start, end, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (Entity)this));
            if (hit.getType() == HitResult.Type.BLOCK) {
                BlockPos pos = hit.getBlockPos();
                BlockState state = this.level().getBlockState(pos);
                Block block = state.getBlock();
                if (block instanceof DoorBlock && !((DoorBlock)block).isOpen(state)) {
                    ((DoorBlock)block).setOpen((Entity)this, this.getLevel(), state, pos, true);
                    this.swing(InteractionHand.MAIN_HAND);
                }
            }
        }
    }

    public void die(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        Entity entity = damageSource.getEntity();
        if (entity instanceof ServerPlayer) {
            RepUtilKt.applyRep((Player)entity, RepTier.LOSS_IHY);
        }
        super.die(damageSource);
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
        compound.getInt(NATURAL_DESPAWN);
    }

    private static final Player registerGoals$lambda$0(NullMazeEntity this$0) {
        return EntityFinder.findClosestPlayerInRange((LevelAccessor)((LevelAccessor)this$0.getLevel()), (Vec3)this$0.getPos(), (Number)128.0);
    }

    /*
     * WARNING - void declaration
     */
    private static final Vec3 registerGoals$lambda$1(NullMazeEntity this$0) {
        Vec3 vec3;
        LivingEntity t = this$0.getTarget();
        if (t == null) {
            vec3 = null;
        } else {
            BlockPos blockPos;
            BlockPos support = t.mainSupportingBlockPos.orElse(null);
            if (support != null) {
                this$0.cachedGroundPos = support;
                this$0.ticksSinceGroundSeen = 0;
                blockPos = support;
            } else if (this$0.cachedGroundPos != null && this$0.ticksSinceGroundSeen < 10) {
                int n = this$0.ticksSinceGroundSeen;
                this$0.ticksSinceGroundSeen = n + 1;
                BlockPos blockPos2 = this$0.cachedGroundPos;
                blockPos = blockPos2;
                Intrinsics.checkNotNull((Object)blockPos2);
            } else {
                BlockPos scanned;
                BlockPos blockPos3;
                Object v3;
                BlockPos feetPos;
                block8: {
                    void $this$firstOrNull$iv;
                    feetPos = BlockPos.containing((double)t.getX(), (double)t.getY(), (double)t.getZ());
                    Sequence sequence = SequencesKt.map((Sequence)CollectionsKt.asSequence((Iterable)((Iterable)new IntRange(0, 4))), arg_0 -> NullMazeEntity.registerGoals$lambda$1$0(feetPos, arg_0));
                    boolean $i$f$firstOrNull = false;
                    for (Object element$iv : $this$firstOrNull$iv) {
                        BlockPos it = (BlockPos)element$iv;
                        boolean bl = false;
                        if (!this$0.level().getBlockState(it).isFaceSturdy((BlockGetter)this$0.level(), it, Direction.UP)) continue;
                        v3 = element$iv;
                        break block8;
                    }
                    v3 = null;
                }
                if ((blockPos3 = (BlockPos)v3) == null) {
                    blockPos3 = feetPos;
                }
                this$0.cachedGroundPos = scanned = blockPos3;
                this$0.ticksSinceGroundSeen = 0;
                blockPos = scanned;
            }
            BlockPos ground = blockPos;
            vec3 = ground.above().getBottomCenter();
        }
        return vec3;
    }

    private static final BlockPos registerGoals$lambda$1$0(BlockPos $feetPos, int it) {
        return $feetPos.below(it);
    }

    private static final Object tick$lambda$0(NullMazeEntity this$0) {
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

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/entity/nullent/NullMazeEntity$Companion;", "", "<init>", "()V", "NATURAL_DESPAWN", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/entity/nullent/NullMazeEntity$PersistentTargetGoal;", "Lnet/minecraft/world/entity/ai/goal/target/NearestAttackableTargetGoal;", "Lnet/minecraft/world/entity/player/Player;", "mob", "Lnet/minecraft/world/entity/Mob;", "targetType", "Ljava/lang/Class;", "losMemoryTicks", "", "<init>", "(Lnet/minecraft/world/entity/Mob;Ljava/lang/Class;I)V", "lastTickSeen", "canContinueToUse", "", "start", "", "thebrokenscript-common"})
    public static final class PersistentTargetGoal
    extends NearestAttackableTargetGoal<Player> {
        private final int losMemoryTicks;
        private int lastTickSeen;

        public PersistentTargetGoal(@NotNull Mob mob, @NotNull Class<Player> targetType, int losMemoryTicks) {
            Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
            Intrinsics.checkNotNullParameter(targetType, (String)"targetType");
            super(mob, targetType, true);
            this.losMemoryTicks = losMemoryTicks;
        }

        public /* synthetic */ PersistentTargetGoal(Mob mob, Class clazz, int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n2 & 4) != 0) {
                n = 200;
            }
            this(mob, clazz, n);
        }

        public boolean canContinueToUse() {
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) {
                return false;
            }
            LivingEntity target = livingEntity;
            if (this.mob.getSensing().hasLineOfSight((Entity)target)) {
                this.lastTickSeen = 0;
                return super.canContinueToUse();
            }
            int n = this.lastTickSeen;
            this.lastTickSeen = n + 1;
            return this.lastTickSeen < this.losMemoryTicks ? true : super.canContinueToUse();
        }

        public void start() {
            super.start();
            this.lastTickSeen = 0;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/entity/nullent/NullMazeEntity$StalkGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/Mob;", "targetProvider", "Lkotlin/Function0;", "Lnet/minecraft/world/entity/player/Player;", "speedModifier", "", "<init>", "(Lnet/minecraft/world/entity/Mob;Lkotlin/jvm/functions/Function0;D)V", "hasLos", "", "hasLosTimer", "", "canUse", "canContinueToUse", "tick", "", "start", "stop", "thebrokenscript-common"})
    public static final class StalkGoal
    extends Goal {
        @NotNull
        private final Mob mob;
        @NotNull
        private final Function0<Player> targetProvider;
        private final double speedModifier;
        private boolean hasLos;
        private int hasLosTimer;

        public StalkGoal(@NotNull Mob mob, @NotNull Function0<? extends Player> targetProvider, double speedModifier) {
            Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
            Intrinsics.checkNotNullParameter(targetProvider, (String)"targetProvider");
            this.mob = mob;
            this.targetProvider = targetProvider;
            this.speedModifier = speedModifier;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK));
        }

        public /* synthetic */ StalkGoal(Mob mob, Function0 function0, double d, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 4) != 0) {
                d = 1.1;
            }
            this(mob, (Function0<? extends Player>)function0, d);
        }

        public boolean canUse() {
            Object object = this.targetProvider.invoke();
            ServerPlayer serverPlayer = object instanceof ServerPlayer ? (ServerPlayer)object : null;
            if (serverPlayer == null) {
                return false;
            }
            ServerPlayer player = serverPlayer;
            Mob mob = this.mob;
            Intrinsics.checkNotNull((Object)mob, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.entity.base.BaseMonster");
            this.hasLos = BaseMonsterExtKt.isPlayerInFovCone((BaseMonster)((BaseMonster)mob), (Player)((Player)player), (double)120.0) && BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)this.mob), (Player)((Player)player)) && !this.mob.hasLineOfSight((Entity)player) && ((BaseMonster)this.mob).getTarget() == null;
            return this.hasLos;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean canContinueToUse() {
            Object object = this.targetProvider.invoke();
            if (!(object instanceof ServerPlayer)) return false;
            ServerPlayer serverPlayer = (ServerPlayer)object;
            if (serverPlayer == null) {
                return false;
            }
            ServerPlayer player = serverPlayer;
            if (this.mob.getTarget() != null) return false;
            Mob mob = this.mob;
            Intrinsics.checkNotNull((Object)mob, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.entity.base.BaseMonster");
            if (!BaseMonsterExtKt.isPlayerInFovCone((BaseMonster)((BaseMonster)mob), (Player)((Player)player), (double)120.0)) return false;
            if (!BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)this.mob), (Player)((Player)player))) return false;
            if (this.mob.hasLineOfSight((Entity)player)) return false;
            return true;
        }

        public void tick() {
            super.tick();
            Object object = this.targetProvider.invoke();
            Intrinsics.checkNotNull((Object)object);
            ServerPlayer player = (ServerPlayer)object;
            Vec3 mobEyePos = this.mob.getEyePosition();
            Vec3 playerPos = player.getEyePosition();
            Vec3 direction = playerPos.subtract(mobEyePos).normalize();
            ClipContext clipContext = new ClipContext(mobEyePos, playerPos, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, (Entity)this.mob);
            BlockHitResult hitResult = this.mob.level().clip(clipContext);
            HitResult.Type type = hitResult.getType();
            if ((type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) != 1) {
                return;
            }
            Vec3 vec3 = hitResult.getLocation().subtract(direction.scale(0.5));
            Intrinsics.checkNotNull((Object)vec3);
            Vec3 targetPos = vec3;
            Mob mob = this.mob;
            Intrinsics.checkNotNull((Object)mob, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.api.entity.base.BaseMonster");
            boolean bl = this.hasLos = BaseMonsterExtKt.isPlayerInFovCone((BaseMonster)((BaseMonster)mob), (Player)((Player)player), (double)120.0) && BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)this.mob), (Player)((Player)player)) && !this.mob.hasLineOfSight((Entity)player);
            if (this.hasLos) {
                int n = this.hasLosTimer;
                this.hasLosTimer = n + 1;
            } else {
                this.hasLosTimer = 0;
            }
            if (this.hasLosTimer > 80) {
                ((BaseMonster)this.mob).setTarget((LivingEntity)player);
            }
            ((BaseMonster)this.mob).getNavigation().moveTo(targetPos.x, targetPos.y, targetPos.z, this.speedModifier);
            ((BaseMonster)this.mob).getLookControl().setLookAt((Entity)player, 30.0f, 30.0f);
        }

        public void start() {
            super.start();
            this.hasLosTimer = 0;
        }

        public void stop() {
            super.stop();
            this.hasLosTimer = 0;
            this.hasLos = false;
        }

        @Metadata(mv={2, 1, 0}, k=3, xi=48)
        public static final class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] nArray = new int[HitResult.Type.values().length];
                try {
                    nArray[HitResult.Type.BLOCK.ordinal()] = 1;
                }
                catch (NoSuchFieldError noSuchFieldError) {
                    // empty catch block
                }
                $EnumSwitchMapping$0 = nArray;
            }
        }
    }
}

