/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Holder$Reference
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundSoundPacket
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.sounds.SoundSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.InteractionResult
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.LivingEntity$Fallsounds
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.entity.siluet;

import java.util.Optional;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.entity.BaseSiluetEntity;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.entity.siluet.SiluetHallucinationNavigation;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 P2\u00020\u00012\u00020\u0002:\u0001PB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010)\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020\nH\u0016J\b\u0010/\u001a\u00020\nH\u0016J\b\u00100\u001a\u000201H\u0016J \u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J\u0018\u00109\u001a\u00020,2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0014J\u0010\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020@H\u0014J\u0010\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u00020,2\u0006\u0010B\u001a\u00020CH\u0016J4\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010\u0005\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010F2\u0006\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020,H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR+\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b!\u0010\u001d\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR(\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\"\u001a\u0004\u0018\u00010#8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006Q"}, d2={"Lnet/thebrokenscript/entity/siluet/SiluetHallucinationEntity;", "Lnet/thebrokenscript/api/entity/BaseSiluetEntity;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "playerLooked", "", "getPlayerLooked", "()Z", "setPlayerLooked", "(Z)V", "playerEnt", "Lnet/minecraft/world/entity/player/Player;", "getPlayerEnt", "()Lnet/minecraft/world/entity/player/Player;", "setPlayerEnt", "(Lnet/minecraft/world/entity/player/Player;)V", "<set-?>", "", "despawnTimer", "getDespawnTimer", "()I", "setDespawnTimer", "(I)V", "despawnTimer$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/PersistentDataDelegate;", "finalizedSpawn", "getFinalizedSpawn", "setFinalizedSpawn", "finalizedSpawn$delegate", "value", "Ljava/util/UUID;", "playerUUID", "getPlayerUUID", "()Ljava/util/UUID;", "setPlayerUUID", "(Ljava/util/UUID;)V", "createNavigation", "Lnet/minecraft/world/entity/ai/navigation/PathNavigation;", "registerGoals", "", "attackable", "isPushable", "canBeCollidedWith", "getFallSounds", "Lnet/minecraft/world/entity/LivingEntity$Fallsounds;", "interactAt", "Lnet/minecraft/world/InteractionResult;", "player", "vec", "Lnet/minecraft/world/phys/Vec3;", "hand", "Lnet/minecraft/world/InteractionHand;", "playStepSound", "pos", "Lnet/minecraft/core/BlockPos;", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "baseTick", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nSiluetHallucinationEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SiluetHallucinationEntity.kt\nnet/thebrokenscript/entity/siluet/SiluetHallucinationEntity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,250:1\n1#2:251\n*E\n"})
public final class SiluetHallucinationEntity
extends BaseSiluetEntity
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private boolean playerLooked;
    @Nullable
    private Player playerEnt;
    @NotNull
    private final PersistentDataDelegate despawnTimer$delegate;
    @NotNull
    private final PersistentDataDelegate finalizedSpawn$delegate;
    @NotNull
    private static final String NATURAL_DESPAWN = "despawn_timer";
    @NotNull
    private static final String FINALIZED = "finalized_spawn";
    @NotNull
    private static final EntityDataAccessor<Optional<UUID>> PLAYER_UUID;

    public SiluetHallucinationEntity(@NotNull EntityType<SiluetHallucinationEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.despawnTimer$delegate = this.persistentInt(NATURAL_DESPAWN);
        this.finalizedSpawn$delegate = this.persistentBool(FINALIZED);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.setPathfindingMalus(PathType.DANGER_POWDER_SNOW, 0.0f);
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FENCE, 0.0f);
        this.setPathfindingMalus(PathType.RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0f);
    }

    public final boolean getPlayerLooked() {
        return this.playerLooked;
    }

    public final void setPlayerLooked(boolean bl) {
        this.playerLooked = bl;
    }

    @Nullable
    public final Player getPlayerEnt() {
        return this.playerEnt;
    }

    public final void setPlayerEnt(@Nullable Player player) {
        this.playerEnt = player;
    }

    public final int getDespawnTimer() {
        return ((Number)this.despawnTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[0])).intValue();
    }

    public final void setDespawnTimer(int n) {
        this.despawnTimer$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)n);
    }

    public final boolean getFinalizedSpawn() {
        return (Boolean)this.finalizedSpawn$delegate.getValue((BaseMonster)this, $$delegatedProperties[1]);
    }

    public final void setFinalizedSpawn(boolean bl) {
        this.finalizedSpawn$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], (Object)bl);
    }

    @Nullable
    public final UUID getPlayerUUID() {
        return ((Optional)this.entityData.get(PLAYER_UUID)).orElse(null);
    }

    public final void setPlayerUUID(@Nullable UUID value) {
        this.entityData.set(PLAYER_UUID, Optional.ofNullable(value));
    }

    @NotNull
    protected PathNavigation createNavigation(@NotNull Level level) {
        SiluetHallucinationNavigation siluetHallucinationNavigation;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        SiluetHallucinationNavigation $this$createNavigation_u24lambda_u240 = siluetHallucinationNavigation = new SiluetHallucinationNavigation(this, level);
        boolean bl = false;
        $this$createNavigation_u24lambda_u240.setCanFloat(true);
        $this$createNavigation_u24lambda_u240.setCanWalkOverFences(true);
        return (PathNavigation)siluetHallucinationNavigation;
    }

    protected void registerGoals() {
    }

    public boolean attackable() {
        return false;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    public boolean canBeCollidedWith() {
        return false;
    }

    @NotNull
    public LivingEntity.Fallsounds getFallSounds() {
        return new LivingEntity.Fallsounds(SoundEvents.EMPTY, SoundEvents.EMPTY);
    }

    @NotNull
    public InteractionResult interactAt(@NotNull Player player, @NotNull Vec3 vec, @NotNull InteractionHand hand) {
        InteractionResult interactionResult;
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
        if (Intrinsics.areEqual((Object)player.getUUID(), (Object)this.getPlayerUUID())) {
            InteractionResult interactionResult2 = super.interact(player, hand);
            Intrinsics.checkNotNull((Object)interactionResult2);
            interactionResult = interactionResult2;
        } else {
            interactionResult = InteractionResult.FAIL;
        }
        return interactionResult;
    }

    protected void playStepSound(@NotNull BlockPos pos, @NotNull BlockState state) {
        block2: {
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            SoundType soundtype = state.getSoundType();
            if (this.getPlayerUUID() == null) break block2;
            Level level = this.getLevel();
            UUID uUID = this.getPlayerUUID();
            Intrinsics.checkNotNull((Object)uUID);
            Player player = level.getPlayerByUUID(uUID);
            ServerPlayer serverPlayer = player instanceof ServerPlayer ? (ServerPlayer)player : null;
            Optional optional = BuiltInRegistries.SOUND_EVENT.getResourceKey((Object)soundtype.getStepSound());
            Registry registry = BuiltInRegistries.SOUND_EVENT;
            Intrinsics.checkNotNullExpressionValue((Object)registry, (String)"SOUND_EVENT");
            Holder.Reference reference = optional.flatMap(arg_0 -> SiluetHallucinationEntity.playStepSound$lambda$0((Function1)new Function1<ResourceKey<SoundEvent>, Optional<Holder.Reference<SoundEvent>>>((Object)registry){

                public final Optional<Holder.Reference<SoundEvent>> invoke(ResourceKey<SoundEvent> p0) {
                    return ((Registry)this.receiver).getHolder(p0);
                }
            }, arg_0)).orElse(null);
            if (reference == null) {
                return;
            }
            Holder holder2 = (Holder)reference;
            ServerPlayer serverPlayer2 = serverPlayer;
            if (serverPlayer2 != null && (serverPlayer2 = serverPlayer2.connection) != null) {
                serverPlayer2.send((Packet)new ClientboundSoundPacket(holder2, SoundSource.AMBIENT, this.getX(), this.getY(), this.getZ(), soundtype.getVolume(), soundtype.getPitch(), this.random.nextLong()));
            }
        }
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(PLAYER_UUID, Optional.empty());
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt(NATURAL_DESPAWN, this.getDespawnTimer());
        UUID uUID = this.getPlayerUUID();
        if (uUID != null) {
            UUID it = uUID;
            boolean bl = false;
            compound.putUUID("PlayerUUID", it);
        }
        compound.putBoolean(FINALIZED, this.getFinalizedSpawn());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        this.setDespawnTimer(compound.getInt(NATURAL_DESPAWN));
        if (compound.hasUUID("PlayerUUID")) {
            this.setPlayerUUID(compound.getUUID("PlayerUUID"));
        }
        this.setFinalizedSpawn(compound.getBoolean(FINALIZED));
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        this.setFinalizedSpawn(false);
        if (spawnType != MobSpawnType.COMMAND) {
            if (this.getPlayerUUID() != null) {
                Player player;
                ServerPlayer serverPlayer;
                ServerPlayer serverPlayer2;
                if (this.playerEnt == null) {
                    UUID uUID = this.getPlayerUUID();
                    Intrinsics.checkNotNull((Object)uUID);
                    this.playerEnt = level.getPlayerByUUID(uUID);
                }
                if ((serverPlayer2 = (serverPlayer = (player = this.playerEnt) instanceof ServerPlayer ? (ServerPlayer)player : null)) != null && (serverPlayer2 = serverPlayer2.connection) != null) {
                    serverPlayer2.send((Packet)new ClientboundSoundPacket((Holder)SoundEvents.AMBIENT_CAVE, SoundSource.AMBIENT, this.getPos().x, this.getPos().y, this.getPos().z, 35.0f, this.random.nextFloat(), level.getRandom().nextLong()));
                }
            }
        } else {
            EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.SILUET_CHASE.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos());
            event.setCanceled(true);
            return null;
        }
        this.setDespawnTimer(600);
        this.setFinalizedSpawn(true);
        return null;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void baseTick() {
        block14: {
            block13: {
                super.baseTick();
                if (!this.getFinalizedSpawn()) {
                    return;
                }
                level = this.level();
                if (!(level instanceof ServerLevel)) {
                    return;
                }
                if (this.getPlayerUUID() != null) {
                    if (this.playerEnt == null) {
                        v0 = (ServerLevel)level;
                        v1 = this.getPlayerUUID();
                        Intrinsics.checkNotNull((Object)v1);
                        this.playerEnt = v0.getPlayerByUUID(v1);
                    }
                    if (this.playerEnt != null) {
                        v2 = this.playerEnt;
                        Intrinsics.checkNotNull((Object)v2);
                        this.lookAt(EntityAnchorArgument.Anchor.EYES, v2.position());
                        v3 = this.playerEnt;
                        Intrinsics.checkNotNull((Object)v3);
                        if (PlayerExt.isEntityInFovCone$default(PlayerExt.INSTANCE, v3, (Entity)this, null, 2, null)) {
                            this.playerLooked = true;
                        }
                    }
                }
                if (!this.playerLooked) break block13;
                if (!(this.playerEnt instanceof ServerPlayer)) ** GOTO lbl-1000
                v4 = this.playerEnt;
                Intrinsics.checkNotNull((Object)v4, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
                if (!((ServerPlayer)v4).hasDisconnected()) {
                    v5 = this.playerEnt;
                } else lbl-1000:
                // 2 sources

                {
                    v5 = null;
                }
                v6 = (LivingEntity)v5;
                break block14;
            }
            v6 = null;
        }
        this.setTarget(v6);
        if (this.getTarget() != null) {
            v7 = this.getTarget();
            Intrinsics.checkNotNull((Object)v7);
            this.navigation.moveTo((Entity)v7, 1.4);
            isClose = EntityFinder.findClosestPlayerInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)1);
            if (isClose != null && this.getPlayerUUID() != null && Intrinsics.areEqual((Object)isClose.getUUID(), (Object)this.getPlayerUUID())) {
                this.discard();
                if (this.playerEnt != null) {
                    v8 = this.playerEnt;
                    Intrinsics.checkNotNull((Object)v8, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerPlayer");
                    v9 = ((ServerPlayer)v8).connection;
                    v10 = (Holder)TBSSounds.HALLUCINATION_POOF;
                    v11 = this.playerEnt;
                    Intrinsics.checkNotNull((Object)v11);
                    v12 = v11.getX();
                    v13 = this.playerEnt;
                    Intrinsics.checkNotNull((Object)v13);
                    v14 = v13.getY();
                    v15 = this.playerEnt;
                    Intrinsics.checkNotNull((Object)v15);
                    v9.send((Packet)new ClientboundSoundPacket(v10, SoundSource.AMBIENT, v12, v14, v15.getZ(), 10.0f, 1.0f, ((ServerLevel)level).random.nextLong()));
                    v16 = this.playerEnt;
                    Intrinsics.checkNotNull((Object)v16);
                    PlayerUtil.trySendOverlay((Player)v16, (ResourceLocation)TBSConstants.id("textures/screens/blick.png"), (long)3L);
                }
            }
        } else {
            this.navigation.stop();
        }
        var2_3 = this.getDespawnTimer();
        this.setDespawnTimer(var2_3 + -1);
        if (this.getDespawnTimer() <= 0) {
            this.discard();
        }
        this.refreshDimensions();
    }

    private static final Optional playStepSound$lambda$0(Function1 $tmp0, Object p0) {
        return (Optional)$tmp0.invoke(p0);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SiluetHallucinationEntity.class, "despawnTimer", "getDespawnTimer()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SiluetHallucinationEntity.class, "finalizedSpawn", "getFinalizedSpawn()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(SiluetHallucinationEntity.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_UUID);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        PLAYER_UUID = entityDataAccessor;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/entity/siluet/SiluetHallucinationEntity$Companion;", "", "<init>", "()V", "NATURAL_DESPAWN", "", "FINALIZED", "PLAYER_UUID", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "Ljava/util/Optional;", "Ljava/util/UUID;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

