/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.math.MathKt
 *  kotlin.ranges.RangesKt
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Position
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundStopSoundPacket
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.RandomLookAroundGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.Node
 *  net.minecraft.world.level.pathfinder.Path
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.entity.nullent;

import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.util.RepTier;
import net.thebrokenscript.util.RepUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0003VWXB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010%\u001a\u00020&H\u0014J\u0018\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\nH\u0016J\b\u00100\u001a\u00020\nH\u0016J\b\u00101\u001a\u00020\nH\u0016J\b\u00102\u001a\u00020\nH\u0016J\u0010\u00107\u001a\u00020&2\u0006\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020&2\u0006\u00108\u001a\u000209H\u0016J4\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010\u0005\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010<2\u0006\u0010C\u001a\u00020DH\u0016J \u0010E\u001a\u00020&2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u00162\u0006\u0010I\u001a\u00020)H\u0016J\b\u0010J\u001a\u00020&H\u0016J\b\u0010K\u001a\u00020&H\u0016J\u000e\u0010L\u001a\u00020&2\u0006\u0010M\u001a\u00020\u0010J\u000e\u0010N\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020OJ\u0016\u0010P\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020O2\u0006\u0010M\u001a\u00020\u0010J\u000e\u0010Q\u001a\u00020&2\u0006\u0010M\u001a\u00020\u0010J\u0010\u0010R\u001a\u00020&2\u0006\u0010M\u001a\u00020\u0010H\u0002J\u0010\u0010S\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020OH\u0002J\u0016\u0010T\u001a\u00020\n2\u0006\u0010M\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010U\u001a\u00020&2\u0006\u0010I\u001a\u00020)H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u000e\u0010!\u001a\u00020\u0016X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0016X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100$X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u00104\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u00168F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001a\u00a8\u0006Y"}, d2={"Lnet/thebrokenscript/entity/nullent/NullMiningEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "despawning", "", "getDespawning", "()Z", "setDespawning", "(Z)V", "miningPos", "Lnet/minecraft/core/BlockPos;", "getMiningPos", "()Lnet/minecraft/core/BlockPos;", "setMiningPos", "(Lnet/minecraft/core/BlockPos;)V", "miningProgress", "", "getMiningProgress", "()I", "setMiningProgress", "(I)V", "buildingPos", "getBuildingPos", "setBuildingPos", "buildingProgress", "getBuildingProgress", "setBuildingProgress", "buildDelay", "mineDelay", "builtBlocks", "", "registerGoals", "", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "removeWhenFarAway", "distanceToClosestPlayer", "", "isPushable", "fireImmune", "canBreatheUnderwater", "isPushedByFluid", "value", "timer", "getTimer", "setTimer", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "awardKillScore", "entity", "Lnet/minecraft/world/entity/Entity;", "score", "damageSource", "tick", "baseTick", "startMining", "pos", "tickMining", "Lnet/minecraft/server/level/ServerLevel;", "resetMining", "startBuilding", "lookAtBlock", "executeBuild", "isPathBlock", "die", "MiningGoal", "BuildingGoal", "Companion", "thebrokenscript-common"})
public final class NullMiningEntity
extends BaseMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean despawning;
    @Nullable
    private BlockPos miningPos;
    private int miningProgress;
    @Nullable
    private BlockPos buildingPos;
    private int buildingProgress;
    private final int buildDelay;
    private final int mineDelay;
    @NotNull
    private final Set<BlockPos> builtBlocks;
    @NotNull
    private static final String NATURAL_DESPAWN = "despawn_timer";

    public NullMiningEntity(@NotNull EntityType<NullMiningEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.buildDelay = 10;
        this.mineDelay = 10;
        this.builtBlocks = new LinkedHashSet();
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)Items.IRON_PICKAXE));
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)Items.IRON_HELMET));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)Items.IRON_CHESTPLATE));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)Items.IRON_LEGGINGS));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack((ItemLike)Items.IRON_BOOTS));
    }

    public final boolean getDespawning() {
        return this.despawning;
    }

    public final void setDespawning(boolean bl) {
        this.despawning = bl;
    }

    @Nullable
    public final BlockPos getMiningPos() {
        return this.miningPos;
    }

    public final void setMiningPos(@Nullable BlockPos blockPos) {
        this.miningPos = blockPos;
    }

    public final int getMiningProgress() {
        return this.miningProgress;
    }

    public final void setMiningProgress(int n) {
        this.miningProgress = n;
    }

    @Nullable
    public final BlockPos getBuildingPos() {
        return this.buildingPos;
    }

    public final void setBuildingPos(@Nullable BlockPos blockPos) {
        this.buildingPos = blockPos;
    }

    public final int getBuildingProgress() {
        return this.buildingProgress;
    }

    public final void setBuildingProgress(int n) {
        this.buildingProgress = n;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, (Goal)new MiningGoal(this));
        this.goalSelector.addGoal(2, (Goal)new BuildingGoal(this));
        this.goalSelector.addGoal(3, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.2, false));
        this.goalSelector.addGoal(4, (Goal)new FloatGoal((Mob)this));
        this.targetSelector.addGoal(5, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.goalSelector.addGoal(6, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 12.0f));
        this.goalSelector.addGoal(7, (Goal)new RandomLookAroundGoal((Mob)this));
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        boolean isPlayer = source.getDirectEntity() instanceof Player;
        return isPlayer || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD) ? super.hurt(source, amount) : false;
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean isPushable() {
        return false;
    }

    public boolean fireImmune() {
        return true;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public boolean isPushedByFluid() {
        return false;
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
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        LevelAccessor levelAccessor = (LevelAccessor)level;
        Vec3 vec3 = this.getPos();
        Object object = SoundEvents.AMBIENT_CAVE.value();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"value(...)");
        SoundUtil.playSound$default((LevelAccessor)levelAccessor, (Vec3)vec3, (SoundEvent)((SoundEvent)object), (float)10.0f, (float)0.0f, null, (int)16, null);
        this.setTimer(1200);
        return null;
    }

    public void awardKillScore(@NotNull Entity entity, int score, @NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        super.awardKillScore(entity, score, damageSource);
        Level level = this.getLevel();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        ((ServerLevel)level).getServer().getPlayerList().broadcastAll((Packet)new ClientboundStopSoundPacket(null, null));
        SoundUtil.playSound$default((LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos(), (SoundEvent)((SoundEvent)TBSSounds.ONE_OF_US.get()), (float)35.0f, (float)1.0f, null, (int)16, null);
        this.discard();
    }

    public void tick() {
        super.tick();
        SideUtil.clientSide((Entity)((Entity)this), () -> NullMiningEntity.tick$lambda$0(this));
    }

    public void baseTick() {
        super.baseTick();
        Level level = this.level();
        ServerLevel serverLevel = level instanceof ServerLevel ? (ServerLevel)level : null;
        if (serverLevel == null) {
            return;
        }
        ServerLevel level2 = serverLevel;
        if (this.getTimer() > 0) {
            int n = this.getTimer();
            this.setTimer(n + -1);
            if (this.getTimer() <= 0) {
                this.discard();
            }
        }
        LevelAccessor levelAccessor = (LevelAccessor)level2;
        Vec3 vec3 = this.position();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
        Player targetPlayer = (Player)EntityFinder.findClosestEntityInRange((LevelAccessor)levelAccessor, Player.class, (Vec3)vec3, (Number)1000.0);
        if (targetPlayer == null || targetPlayer.isSpectator()) {
            return;
        }
        this.setTarget((LivingEntity)targetPlayer);
    }

    public final void startMining(@NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        if (this.miningPos == null && !this.builtBlocks.contains(pos)) {
            this.miningPos = pos;
            this.miningProgress = 0;
            this.lookAtBlock(pos);
        }
    }

    public final void tickMining(@NotNull ServerLevel level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        BlockPos blockPos = this.miningPos;
        if (blockPos == null) {
            return;
        }
        BlockPos pos = blockPos;
        BlockState state = level.getBlockState(pos);
        if (state.isAir()) {
            this.resetMining(level, pos);
            return;
        }
        this.swing(InteractionHand.MAIN_HAND);
        int n = this.miningProgress;
        this.miningProgress = n + 1;
        int stage = RangesKt.coerceAtMost((int)(this.miningProgress * 9 / this.mineDelay), (int)9);
        level.destroyBlockProgress(this.getId(), pos, stage);
        if (this.miningProgress >= this.mineDelay) {
            Block.dropResources((BlockState)state, (Level)((Level)level), (BlockPos)pos, (BlockEntity)level.getBlockEntity(pos), (Entity)((Entity)this), (ItemStack)this.getMainHandItem());
            level.destroyBlock(pos, false);
            this.resetMining(level, pos);
        }
    }

    public final void resetMining(@NotNull ServerLevel level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        level.destroyBlockProgress(this.getId(), pos, -1);
        this.miningPos = null;
        this.miningProgress = 0;
    }

    public final void startBuilding(@NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        if (this.buildingPos == null && !this.builtBlocks.contains(pos)) {
            this.buildingPos = pos;
            this.buildingProgress = 0;
            this.lookAtBlock(pos);
        }
    }

    private final void lookAtBlock(BlockPos pos) {
        Vec3 targetPos = new Vec3((double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5);
        this.lookControl.setLookAt(targetPos);
    }

    private final void executeBuild(ServerLevel level) {
        BlockPos blockPos = this.buildingPos;
        if (blockPos == null) {
            return;
        }
        BlockPos pos = blockPos;
        int n = this.buildingProgress;
        this.buildingProgress = n + 1;
        if (this.buildingProgress >= this.buildDelay) {
            if (level.getBlockState(pos).isAir()) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)Blocks.COBBLESTONE));
                this.swing(InteractionHand.MAIN_HAND);
                level.setBlock(pos, Blocks.COBBLESTONE.defaultBlockState(), 3);
                this.builtBlocks.add(pos);
                if (Intrinsics.areEqual((Object)pos, (Object)this.blockPosition())) {
                    this.setPos(this.getX(), this.getY() + 1.0, this.getZ());
                }
            }
            this.buildingPos = null;
            this.buildingProgress = 0;
        }
    }

    public final boolean isPathBlock(@NotNull BlockPos pos, @NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        BlockState state = level.getBlockState(pos);
        return !state.isAir() && !this.builtBlocks.contains(pos) && (state.is(BlockTags.BASE_STONE_OVERWORLD) || state.is(Blocks.COBBLESTONE) || state.is(Blocks.COBBLED_DEEPSLATE));
    }

    public void die(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        Entity entity = damageSource.getEntity();
        if (entity instanceof ServerPlayer) {
            RepUtilKt.applyRep((Player)entity, RepTier.LOSS_IHY);
        }
        super.die(damageSource);
    }

    private static final Object tick$lambda$0(NullMiningEntity this$0) {
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

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lnet/thebrokenscript/entity/nullent/NullMiningEntity$BuildingGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/thebrokenscript/entity/nullent/NullMiningEntity;", "<init>", "(Lnet/thebrokenscript/entity/nullent/NullMiningEntity;)V", "canUse", "", "canContinueToUse", "stop", "", "tick", "hasWalkablePath", "target", "Lnet/minecraft/world/entity/LivingEntity;", "level", "Lnet/minecraft/server/level/ServerLevel;", "isPathSafe", "path", "Lnet/minecraft/world/level/pathfinder/Path;", "shouldProvidePathfindingHelp", "thebrokenscript-common"})
    public static final class BuildingGoal
    extends Goal {
        @NotNull
        private final NullMiningEntity mob;

        public BuildingGoal(@NotNull NullMiningEntity mob) {
            Intrinsics.checkNotNullParameter((Object)((Object)mob), (String)"mob");
            this.mob = mob;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK));
        }

        public boolean canUse() {
            BlockPos below;
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) {
                return false;
            }
            LivingEntity target = livingEntity;
            Level level = this.mob.getLevel();
            ServerLevel serverLevel = level instanceof ServerLevel ? (ServerLevel)level : null;
            if (serverLevel == null) {
                return false;
            }
            ServerLevel level2 = serverLevel;
            BlockPos myPos = this.mob.blockPosition();
            int myY = myPos.getY();
            BlockPos targetBlock = target.blockPosition();
            int targetY = targetBlock.getY();
            if (this.hasWalkablePath(target, level2)) {
                return false;
            }
            if (targetY - myY > 0 && !level2.getBlockState(below = myPos.below()).isAir() && level2.getBlockState(myPos).isAir()) {
                Intrinsics.checkNotNull((Object)myPos);
                this.mob.startBuilding(myPos);
                return true;
            }
            if (Math.abs(targetY - myY) <= 1) {
                Vec3 targetPos = new Vec3(target.getX(), (double)myY, target.getZ());
                Vec3 dir = targetPos.subtract(this.mob.position()).normalize();
                if (dir.length() <= 0.0) {
                    return false;
                }
                for (int stepSize = 1; stepSize < 4; ++stepSize) {
                    int nextX = MathKt.roundToInt((double)(this.mob.getX() + dir.x * (double)stepSize));
                    int nextZ = MathKt.roundToInt((double)(this.mob.getZ() + dir.z * (double)stepSize));
                    BlockPos nextFootPos = new BlockPos(nextX, myY, nextZ);
                    BlockPos supportPos = nextFootPos.below();
                    if (Intrinsics.areEqual((Object)nextFootPos, (Object)this.mob.blockPosition()) || !level2.getBlockState(supportPos).isAir() || !level2.getBlockState(nextFootPos).isAir() || this.mob.builtBlocks.contains(supportPos)) continue;
                    Intrinsics.checkNotNull((Object)supportPos);
                    this.mob.startBuilding(supportPos);
                    return true;
                }
            }
            return false;
        }

        public boolean canContinueToUse() {
            if (this.mob.getBuildingPos() != null) {
                return true;
            }
            LivingEntity target = this.mob.getTarget();
            if (target != null) {
                ServerLevel level;
                Level level2 = this.mob.getLevel();
                ServerLevel serverLevel = level = level2 instanceof ServerLevel ? (ServerLevel)level2 : null;
                if (level != null && this.shouldProvidePathfindingHelp(target, level)) {
                    this.mob.navigation.stop();
                    return false;
                }
            }
            return false;
        }

        public void stop() {
            this.mob.setBuildingPos(null);
            this.mob.setBuildingProgress(0);
            this.mob.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack((ItemLike)Items.IRON_PICKAXE));
        }

        public void tick() {
            Level level = this.mob.getLevel();
            ServerLevel serverLevel = level instanceof ServerLevel ? (ServerLevel)level : null;
            if (serverLevel == null) {
                return;
            }
            ServerLevel level2 = serverLevel;
            this.mob.executeBuild(level2);
        }

        private final boolean hasWalkablePath(LivingEntity target, ServerLevel level) {
            Path path = this.mob.navigation.createPath((Entity)target, 0);
            if (path == null || !path.canReach()) {
                return false;
            }
            return this.isPathSafe(path, level);
        }

        private final boolean isPathSafe(Path path, ServerLevel level) {
            int n = path.getNodeCount();
            for (int i = 0; i < n; ++i) {
                Node node = path.getNode(i);
                BlockPos nodePos = new BlockPos(node.x, node.y, node.z);
                BlockPos belowPos = nodePos.below();
                if (level.getBlockState(nodePos).isAir() && level.getBlockState(belowPos).isAir()) {
                    return false;
                }
                BlockPos below2 = belowPos.below();
                BlockPos below3 = below2.below();
                if (!level.getBlockState(belowPos).isAir() || !level.getBlockState(below2).isAir() || !level.getBlockState(below3).isAir()) continue;
                return false;
            }
            return true;
        }

        private final boolean shouldProvidePathfindingHelp(LivingEntity target, ServerLevel level) {
            Vec3 dir;
            double distanceToTarget = this.mob.position().distanceTo(target.position());
            Path currentPath = this.mob.navigation.getPath();
            if (distanceToTarget < 10.0 && (currentPath == null || !this.isPathSafe(currentPath, level)) && (dir = new Vec3(target.getX(), this.mob.getY(), target.getZ()).subtract(this.mob.position()).normalize()).length() > 0.0) {
                for (int step = 1; step < 4; ++step) {
                    int checkX = MathKt.roundToInt((double)(this.mob.getX() + dir.x * (double)step));
                    int checkZ = MathKt.roundToInt((double)(this.mob.getZ() + dir.z * (double)step));
                    BlockPos checkPos = new BlockPos(checkX, this.mob.blockPosition().getY(), checkZ);
                    BlockPos supportPos = checkPos.below();
                    if (!level.getBlockState(supportPos).isAir() || !level.getBlockState(checkPos).isAir() || this.mob.builtBlocks.contains(supportPos)) continue;
                    return true;
                }
            }
            return false;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/entity/nullent/NullMiningEntity$Companion;", "", "<init>", "()V", "NATURAL_DESPAWN", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/entity/nullent/NullMiningEntity$MiningGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/thebrokenscript/entity/nullent/NullMiningEntity;", "<init>", "(Lnet/thebrokenscript/entity/nullent/NullMiningEntity;)V", "canUse", "", "canContinueToUse", "stop", "", "tick", "getNextObstacle", "Lnet/minecraft/core/BlockPos;", "target", "Lnet/minecraft/world/entity/LivingEntity;", "level", "Lnet/minecraft/server/level/ServerLevel;", "thebrokenscript-common"})
    @SourceDebugExtension(value={"SMAP\nNullMiningEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NullMiningEntity.kt\nnet/thebrokenscript/entity/nullent/NullMiningEntity$MiningGoal\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,439:1\n1#2:440\n*E\n"})
    public static final class MiningGoal
    extends Goal {
        @NotNull
        private final NullMiningEntity mob;

        public MiningGoal(@NotNull NullMiningEntity mob) {
            Intrinsics.checkNotNullParameter((Object)((Object)mob), (String)"mob");
            this.mob = mob;
            this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE, (Enum)Goal.Flag.LOOK));
        }

        public boolean canUse() {
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) {
                return false;
            }
            LivingEntity target = livingEntity;
            Level level = this.mob.getLevel();
            ServerLevel serverLevel = level instanceof ServerLevel ? (ServerLevel)level : null;
            if (serverLevel == null) {
                return false;
            }
            ServerLevel level2 = serverLevel;
            BlockPos blockPos = this.getNextObstacle(target, level2);
            if (blockPos == null) {
                return false;
            }
            BlockPos next = blockPos;
            this.mob.startMining(next);
            return true;
        }

        public boolean canContinueToUse() {
            return this.mob.getMiningPos() != null;
        }

        public void stop() {
            block1: {
                Level level = this.mob.getLevel();
                ServerLevel serverLevel = level instanceof ServerLevel ? (ServerLevel)level : null;
                if (serverLevel == null) {
                    return;
                }
                ServerLevel level2 = serverLevel;
                BlockPos blockPos = this.mob.getMiningPos();
                if (blockPos == null) break block1;
                BlockPos it = blockPos;
                boolean bl = false;
                this.mob.resetMining(level2, it);
            }
        }

        public void tick() {
            Level level = this.mob.getLevel();
            ServerLevel serverLevel = level instanceof ServerLevel ? (ServerLevel)level : null;
            if (serverLevel == null) {
                return;
            }
            ServerLevel level2 = serverLevel;
            this.mob.tickMining(level2);
        }

        private final BlockPos getNextObstacle(LivingEntity target, ServerLevel level) {
            Object object;
            Vec3 dir = new Vec3(target.getX(), this.mob.getY(), target.getZ()).subtract(this.mob.position()).normalize();
            BlockPos nextFoot = BlockPos.containing((Position)((Position)this.mob.position().add(dir.x, 0.0, dir.z)));
            BlockPos nextHead = nextFoot.above();
            Intrinsics.checkNotNull((Object)nextHead);
            if (this.mob.isPathBlock(nextHead, (Level)level)) {
                object = nextHead;
            } else {
                Intrinsics.checkNotNull((Object)nextFoot);
                object = this.mob.isPathBlock(nextFoot, (Level)level) ? nextFoot : null;
            }
            return object;
        }
    }
}

