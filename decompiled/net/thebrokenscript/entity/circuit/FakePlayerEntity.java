/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.yggdrasil.ProfileResult
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  kotlin.random.Random
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.RangesKt
 *  net.minecraft.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.ClientPacketListener
 *  net.minecraft.client.multiplayer.PlayerInfo
 *  net.minecraft.client.resources.DefaultPlayerSkin
 *  net.minecraft.client.resources.PlayerSkin
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.chat.MutableComponent
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.EquipmentSlot
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.player.PlayerModelPart
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.ItemLike
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.minecraft.world.scores.Scoreboard
 *  net.thebrokenscript.brokencore.api.dsl.ArrayUtil
 *  net.thebrokenscript.brokencore.api.dsl.ChatUtil
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.util.Side
 *  net.thebrokenscript.brokencore.api.util.SideOnly
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.entity.circuit;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.yggdrasil.ProfileResult;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.Scoreboard;
import net.thebrokenscript.api.entity.ai.fake_player.FakePlayerGoals;
import net.thebrokenscript.brokencore.api.dsl.ArrayUtil;
import net.thebrokenscript.brokencore.api.dsl.ChatUtil;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.util.GetRandomCachedPlayerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u0080\u00012\u00020\u00012\u00020\u0002:\u0002\u0080\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J4\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0005\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u001f2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0017H\u0014J\u0018\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J \u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020.2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u00102\u001a\u00020.2\u0006\u00103\u001a\u000204H\u0014J\b\u0010^\u001a\u00020\u0017H\u0016J\b\u0010_\u001a\u00020\u0017H\u0016J\n\u0010`\u001a\u0004\u0018\u000106H\u0015J\b\u0010a\u001a\u00020bH\u0017J\u0010\u0010c\u001a\u00020*2\u0006\u0010d\u001a\u00020eH\u0016J\b\u0010f\u001a\u00020\u0017H\u0002J\b\u0010g\u001a\u00020\u0017H\u0016J\u000e\u0010t\u001a\u00020:2\u0006\u0010u\u001a\u00020.J\n\u0010}\u001a\u0004\u0018\u00010wH\u0003R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u00105\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0083\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\b7\u00108R\u001a\u00109\u001a\u00020:X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\u001a\u0010G\u001a\u00020HX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020HX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010J\"\u0004\bO\u0010LR\u001a\u0010P\u001a\u00020HX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010J\"\u0004\bR\u0010LR\u001a\u0010S\u001a\u00020HX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010J\"\u0004\bU\u0010LR\u001a\u0010V\u001a\u00020HX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010J\"\u0004\bX\u0010LR\u001a\u0010Y\u001a\u00020HX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010J\"\u0004\b[\u0010LR\u0014\u0010\\\u001a\u00020*8EX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\\\u0010]R$\u0010h\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\u001c8F@DX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010m\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\u001c8F@DX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bn\u0010j\"\u0004\bo\u0010lR\u0011\u0010p\u001a\u00020q\u00a2\u0006\b\n\u0000\u001a\u0004\br\u0010sR&\u0010v\u001a\u0004\u0018\u00010w8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0014\n\u0000\u0012\u0004\bx\u00108\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0013\u0010~\u001a\u0004\u0018\u00010w8G\u00a2\u0006\u0006\u001a\u0004\b\u007f\u0010z\u00a8\u0006\u0081\u0001"}, d2={"Lnet/thebrokenscript/entity/circuit/FakePlayerEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "value", "Ljava/util/UUID;", "selectedPlayer", "getSelectedPlayer", "()Ljava/util/UUID;", "setSelectedPlayer", "(Ljava/util/UUID;)V", "evilDuration", "", "getEvilDuration", "()I", "setEvilDuration", "(I)V", "defineSynchedData", "", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "registerGoals", "hurt", "", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "causeFallDamage", "fallDistance", "multiplier", "getEquipmentDropChance", "slot", "Lnet/minecraft/world/entity/EquipmentSlot;", "playerInfo", "Lnet/minecraft/client/multiplayer/PlayerInfo;", "getPlayerInfo$annotations", "()V", "deltaMovementOnPreviousTick", "Lnet/minecraft/world/phys/Vec3;", "getDeltaMovementOnPreviousTick", "()Lnet/minecraft/world/phys/Vec3;", "setDeltaMovementOnPreviousTick", "(Lnet/minecraft/world/phys/Vec3;)V", "oBob", "getOBob", "()F", "setOBob", "(F)V", "bob", "getBob", "setBob", "xCloakO", "", "getXCloakO", "()D", "setXCloakO", "(D)V", "yCloakO", "getYCloakO", "setYCloakO", "zCloakO", "getZCloakO", "setZCloakO", "xCloak", "getXCloak", "setXCloak", "yCloak", "getYCloak", "setYCloak", "zCloak", "getZCloak", "setZCloak", "wantsToStopRiding", "()Z", "tick", "aiStep", "getPlayerInfo", "getSkin", "Lnet/minecraft/client/resources/PlayerSkin;", "isModelPartShown", "part", "Lnet/minecraft/world/entity/player/PlayerModelPart;", "moveCloak", "rideTick", "shoulderEntityLeft", "getShoulderEntityLeft", "()Lnet/minecraft/nbt/CompoundTag;", "setShoulderEntityLeft", "(Lnet/minecraft/nbt/CompoundTag;)V", "shoulderEntityRight", "getShoulderEntityRight", "setShoulderEntityRight", "scoreboard", "Lnet/minecraft/world/scores/Scoreboard;", "getScoreboard", "()Lnet/minecraft/world/scores/Scoreboard;", "getDeltaMovementLerped", "partialTick", "gameProfileInner", "Lcom/mojang/authlib/GameProfile;", "getGameProfileInner$annotations", "getGameProfileInner", "()Lcom/mojang/authlib/GameProfile;", "setGameProfileInner", "(Lcom/mojang/authlib/GameProfile;)V", "fetchGameProfile", "gameProfile", "getGameProfile", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nFakePlayerEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FakePlayerEntity.kt\nnet/thebrokenscript/entity/circuit/FakePlayerEntity\n+ 2 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,337:1\n15#2:338\n*S KotlinDebug\n*F\n+ 1 FakePlayerEntity.kt\nnet/thebrokenscript/entity/circuit/FakePlayerEntity\n*L\n115#1:338\n*E\n"})
public class FakePlayerEntity
extends BaseMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private int evilDuration;
    @Nullable
    private PlayerInfo playerInfo;
    @NotNull
    private Vec3 deltaMovementOnPreviousTick;
    private float oBob;
    private float bob;
    private double xCloakO;
    private double yCloakO;
    private double zCloakO;
    private double xCloak;
    private double yCloak;
    private double zCloak;
    @NotNull
    private final Scoreboard scoreboard;
    @Nullable
    private GameProfile gameProfileInner;
    @NotNull
    private static final EntityDataAccessor<Optional<UUID>> DATA_SELECTED_PLAYER;
    @NotNull
    private static final EntityDataAccessor<Byte> DATA_PLAYER_MODE_CUSTOMISATION;
    @NotNull
    private static final EntityDataAccessor<CompoundTag> DATA_SHOULDER_LEFT;
    @NotNull
    private static final EntityDataAccessor<CompoundTag> DATA_SHOULDER_RIGHT;

    public FakePlayerEntity(@NotNull EntityType<FakePlayerEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.evilDuration = RangesKt.random((IntRange)new IntRange(300, 400), (Random)((Random)Random.Default));
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
        Vec3 vec3 = Vec3.ZERO;
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"ZERO");
        this.deltaMovementOnPreviousTick = vec3;
        Scoreboard scoreboard = this.level().getScoreboard();
        Intrinsics.checkNotNullExpressionValue((Object)scoreboard, (String)"getScoreboard(...)");
        this.scoreboard = scoreboard;
    }

    @Nullable
    public final UUID getSelectedPlayer() {
        Object object = this.entityData.get(DATA_SELECTED_PLAYER);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        return (UUID)OptionalsKt.getOrNull((Optional)((Optional)object));
    }

    public final void setSelectedPlayer(@Nullable UUID value) {
        this.entityData.set(DATA_SELECTED_PLAYER, Optional.ofNullable(value));
    }

    public final int getEvilDuration() {
        return this.evilDuration;
    }

    public final void setEvilDuration(int n) {
        this.evilDuration = n;
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(DATA_PLAYER_MODE_CUSTOMISATION, (Object)127);
        builder.define(DATA_SHOULDER_LEFT, (Object)new CompoundTag());
        builder.define(DATA_SHOULDER_RIGHT, (Object)new CompoundTag());
        builder.define(DATA_SELECTED_PLAYER, Optional.empty());
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        UUID selected = this.getSelectedPlayer();
        if (selected != null) {
            compound.putUUID("selected_player", selected);
        }
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        if (compound.contains("selected_player")) {
            this.entityData.set(DATA_SELECTED_PLAYER, Optional.of(compound.getUUID("selected_player")));
        }
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Object[] objectArray;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        this.setCustomNameVisible(true);
        if (this.getSelectedPlayer() == null) {
            MinecraftServer minecraftServer = level.getLevel().getServer();
            Intrinsics.checkNotNullExpressionValue((Object)minecraftServer, (String)"getServer(...)");
            MinecraftServer server = minecraftServer;
            Object[] objectArray2 = GetRandomCachedPlayerKt.getRandomCachedPlayer(server);
            if (objectArray2 == null) {
                return null;
            }
            objectArray = objectArray2;
            UUID uuid = (UUID)objectArray.component1();
            String cachedName = (String)objectArray.component2();
            ServerPlayer player = server.getPlayerList().getPlayer(uuid);
            this.setSelectedPlayer(uuid);
            if (player != null) {
                this.setCustomName(player.getDisplayName());
                this.setItemSlot(EquipmentSlot.FEET, player.getItemBySlot(EquipmentSlot.FEET).copy());
                this.setItemSlot(EquipmentSlot.LEGS, player.getItemBySlot(EquipmentSlot.LEGS).copy());
                this.setItemSlot(EquipmentSlot.CHEST, player.getItemBySlot(EquipmentSlot.CHEST).copy());
                this.setItemSlot(EquipmentSlot.HEAD, player.getItemBySlot(EquipmentSlot.HEAD).copy());
            } else {
                String $this$c$iv = cachedName;
                boolean $i$f$getC = false;
                Component component = Component.nullToEmpty((String)$this$c$iv);
                Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
                this.setCustomName(component);
            }
        }
        LevelAccessor levelAccessor = (LevelAccessor)level;
        objectArray = new Object[]{this.getCustomName()};
        MutableComponent mutableComponent = Component.translatable((String)"multiplayer.player.joined", objectArray).withStyle(ChatFormatting.YELLOW);
        Intrinsics.checkNotNullExpressionValue((Object)mutableComponent, (String)"withStyle(...)");
        ChatUtil.chat$default((LevelAccessor)levelAccessor, (Component)((Component)mutableComponent), (boolean)false, (int)2, null);
        objectArray = new Item[]{Items.IRON_PICKAXE, Items.IRON_AXE, Items.IRON_SWORD, Items.IRON_SHOVEL};
        List items = CollectionsKt.listOf((Object[])objectArray);
        Collection collection = items;
        RandomSource randomSource = this.random;
        Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
        this.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack((ItemLike)ArrayUtil.random((Collection)collection, (RandomSource)randomSource)));
        return null;
    }

    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, (Goal)new FakePlayerGoals.FakePlayerTargeting((Mob)this, null, 2, null));
        this.goalSelector.addGoal(1, (Goal)new FakePlayerGoals.FakePlayerMimic(this));
        this.goalSelector.addGoal(2, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.0, true));
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        Entity attacker = source.getEntity();
        if (attacker instanceof Player && !this.isDeadOrDying()) {
            Entity entity = EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.CIRCUIT.get()), (LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)this.getPos());
            if (entity != null) {
                EntityUtil.applyRandomRotation((Entity)entity);
            }
            this.kill();
        }
        return super.hurt(source, amount);
    }

    public boolean causeFallDamage(float fallDistance, float multiplier, @NotNull DamageSource source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return false;
    }

    protected float getEquipmentDropChance(@NotNull EquipmentSlot slot) {
        Intrinsics.checkNotNullParameter((Object)slot, (String)"slot");
        return 0.0f;
    }

    @SideOnly(side=Side.CLIENT)
    private static /* synthetic */ void getPlayerInfo$annotations() {
    }

    @NotNull
    protected final Vec3 getDeltaMovementOnPreviousTick() {
        return this.deltaMovementOnPreviousTick;
    }

    protected final void setDeltaMovementOnPreviousTick(@NotNull Vec3 vec3) {
        Intrinsics.checkNotNullParameter((Object)vec3, (String)"<set-?>");
        this.deltaMovementOnPreviousTick = vec3;
    }

    public final float getOBob() {
        return this.oBob;
    }

    public final void setOBob(float f) {
        this.oBob = f;
    }

    public final float getBob() {
        return this.bob;
    }

    public final void setBob(float f) {
        this.bob = f;
    }

    public final double getXCloakO() {
        return this.xCloakO;
    }

    public final void setXCloakO(double d) {
        this.xCloakO = d;
    }

    public final double getYCloakO() {
        return this.yCloakO;
    }

    public final void setYCloakO(double d) {
        this.yCloakO = d;
    }

    public final double getZCloakO() {
        return this.zCloakO;
    }

    public final void setZCloakO(double d) {
        this.zCloakO = d;
    }

    public final double getXCloak() {
        return this.xCloak;
    }

    public final void setXCloak(double d) {
        this.xCloak = d;
    }

    public final double getYCloak() {
        return this.yCloak;
    }

    public final void setYCloak(double d) {
        this.yCloak = d;
    }

    public final double getZCloak() {
        return this.zCloak;
    }

    public final void setZCloak(double d) {
        this.zCloak = d;
    }

    @JvmName(name="wantsToStopRiding")
    protected final boolean wantsToStopRiding() {
        return this.isShiftKeyDown();
    }

    public void tick() {
        Vec3 vec3 = this.getDeltaMovement();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getDeltaMovement(...)");
        this.deltaMovementOnPreviousTick = vec3;
        super.tick();
        this.moveCloak();
    }

    public void aiStep() {
        this.oBob = this.bob;
        super.aiStep();
        this.setSpeed((float)this.getAttributeValue(Attributes.MOVEMENT_SPEED));
        float dist = this.onGround() && !this.isDeadOrDying() && !this.isSwimming() ? Math.min(0.1f, (float)this.getDeltaMovement().horizontalDistance()) : 0.0f;
        this.bob += (dist - this.bob) * 0.4f;
    }

    @SideOnly(side=Side.CLIENT)
    @Nullable
    protected PlayerInfo getPlayerInfo() {
        block3: {
            PlayerInfo playerInfo;
            if (this.playerInfo != null && Intrinsics.areEqual((Object)((playerInfo = this.playerInfo) != null && (playerInfo = playerInfo.getProfile()) != null ? playerInfo.getId() : null), (Object)this.getSelectedPlayer())) break block3;
            ClientPacketListener clientPacketListener = Minecraft.getInstance().getConnection();
            Intrinsics.checkNotNull((Object)clientPacketListener);
            UUID uUID = this.getSelectedPlayer();
            if (uUID == null) {
                return null;
            }
            this.playerInfo = clientPacketListener.getPlayerInfo(uUID);
            if (this.playerInfo == null) {
                GameProfile gameProfile = this.fetchGameProfile();
                if (gameProfile != null) {
                    GameProfile it = gameProfile;
                    boolean bl = false;
                    this.playerInfo = new PlayerInfo(it, false);
                }
            }
        }
        return this.playerInfo;
    }

    @SideOnly(side=Side.CLIENT)
    @NotNull
    public PlayerSkin getSkin() {
        PlayerInfo playerInfo = this.getPlayerInfo();
        if (playerInfo == null || (playerInfo = playerInfo.getSkin()) == null) {
            UUID uUID = this.getSelectedPlayer();
            if (uUID == null) {
                uUID = this.uuid;
            }
            PlayerSkin playerSkin = DefaultPlayerSkin.get((UUID)uUID);
            playerInfo = playerSkin;
            Intrinsics.checkNotNullExpressionValue((Object)playerSkin, (String)"get(...)");
        }
        return playerInfo;
    }

    public boolean isModelPartShown(@NotNull PlayerModelPart part) {
        Intrinsics.checkNotNullParameter((Object)part, (String)"part");
        return (((Number)this.entityData.get(DATA_PLAYER_MODE_CUSTOMISATION)).byteValue() & part.getMask()) == part.getMask();
    }

    private final void moveCloak() {
        this.xCloakO = this.xCloak;
        this.yCloakO = this.yCloak;
        this.zCloakO = this.zCloak;
        double xOffset = this.getX() - this.xCloak;
        double yOffset = this.getY() - this.yCloak;
        double zOffset = this.getZ() - this.zCloak;
        double maxOffset = 10.0;
        if (xOffset > maxOffset) {
            this.xCloakO = this.xCloak = this.getX();
        }
        if (zOffset > maxOffset) {
            this.zCloakO = this.zCloak = this.getZ();
        }
        if (yOffset > maxOffset) {
            this.yCloakO = this.yCloak = this.getY();
        }
        if (xOffset < -maxOffset) {
            this.xCloakO = this.xCloak = this.getX();
        }
        if (zOffset < -maxOffset) {
            this.zCloakO = this.zCloak = this.getZ();
        }
        if (yOffset < -maxOffset) {
            this.yCloakO = this.yCloak = this.getY();
        }
        this.xCloak += xOffset * 0.25;
        this.zCloak += zOffset * 0.25;
        this.yCloak += yOffset * 0.25;
    }

    public void rideTick() {
        if (!this.getLevel().isClientSide && this.wantsToStopRiding() && this.isPassenger()) {
            this.stopRiding();
            this.setShiftKeyDown(false);
        } else {
            super.rideTick();
            this.oBob = this.bob;
            this.bob = 0.0f;
        }
    }

    @NotNull
    public final CompoundTag getShoulderEntityLeft() {
        Object object = this.entityData.get(DATA_SHOULDER_LEFT);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        return (CompoundTag)object;
    }

    protected final void setShoulderEntityLeft(@NotNull CompoundTag value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        this.entityData.set(DATA_SHOULDER_LEFT, (Object)value);
    }

    @NotNull
    public final CompoundTag getShoulderEntityRight() {
        Object object = this.entityData.get(DATA_SHOULDER_RIGHT);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        return (CompoundTag)object;
    }

    protected final void setShoulderEntityRight(@NotNull CompoundTag value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        this.entityData.set(DATA_SHOULDER_RIGHT, (Object)value);
    }

    @NotNull
    public final Scoreboard getScoreboard() {
        return this.scoreboard;
    }

    @NotNull
    public final Vec3 getDeltaMovementLerped(float partialTick) {
        Vec3 vec3 = this.deltaMovementOnPreviousTick.lerp(this.getDeltaMovement(), (double)partialTick);
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"lerp(...)");
        return vec3;
    }

    @Nullable
    protected final GameProfile getGameProfileInner() {
        return this.gameProfileInner;
    }

    protected final void setGameProfileInner(@Nullable GameProfile gameProfile) {
        this.gameProfileInner = gameProfile;
    }

    @SideOnly(side=Side.CLIENT)
    protected static /* synthetic */ void getGameProfileInner$annotations() {
    }

    @SideOnly(side=Side.CLIENT)
    private final GameProfile fetchGameProfile() {
        block5: {
            block4: {
                if (this.gameProfileInner == null) break block4;
                GameProfile gameProfile = this.gameProfileInner;
                if (Intrinsics.areEqual((Object)(gameProfile != null ? gameProfile.getId() : null), (Object)this.getSelectedPlayer())) break block5;
            }
            UUID uUID = this.getSelectedPlayer();
            if (uUID == null) {
                return null;
            }
            ProfileResult profileResult = ClientDSLKt.getMC().getMinecraftSessionService().fetchProfile(uUID, false);
            this.gameProfileInner = profileResult != null ? profileResult.profile() : null;
        }
        return this.gameProfileInner;
    }

    @SideOnly(side=Side.CLIENT)
    @Nullable
    public final GameProfile getGameProfile() {
        return this.fetchGameProfile();
    }

    static {
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(FakePlayerEntity.class, (EntityDataSerializer)EntityDataSerializers.OPTIONAL_UUID);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        DATA_SELECTED_PLAYER = entityDataAccessor;
        EntityDataAccessor entityDataAccessor2 = SynchedEntityData.defineId(FakePlayerEntity.class, (EntityDataSerializer)EntityDataSerializers.BYTE);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor2, (String)"defineId(...)");
        DATA_PLAYER_MODE_CUSTOMISATION = entityDataAccessor2;
        EntityDataAccessor entityDataAccessor3 = SynchedEntityData.defineId(FakePlayerEntity.class, (EntityDataSerializer)EntityDataSerializers.COMPOUND_TAG);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor3, (String)"defineId(...)");
        DATA_SHOULDER_LEFT = entityDataAccessor3;
        EntityDataAccessor entityDataAccessor4 = SynchedEntityData.defineId(FakePlayerEntity.class, (EntityDataSerializer)EntityDataSerializers.COMPOUND_TAG);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor4, (String)"defineId(...)");
        DATA_SHOULDER_RIGHT = entityDataAccessor4;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0012\u001a\u00020\u0013R \u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\t\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/entity/circuit/FakePlayerEntity$Companion;", "", "<init>", "()V", "DATA_SELECTED_PLAYER", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "Ljava/util/Optional;", "Ljava/util/UUID;", "getDATA_SELECTED_PLAYER", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "DATA_PLAYER_MODE_CUSTOMISATION", "", "getDATA_PLAYER_MODE_CUSTOMISATION", "DATA_SHOULDER_LEFT", "Lnet/minecraft/nbt/CompoundTag;", "getDATA_SHOULDER_LEFT", "DATA_SHOULDER_RIGHT", "getDATA_SHOULDER_RIGHT", "createAttributes", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        protected final EntityDataAccessor<Optional<UUID>> getDATA_SELECTED_PLAYER() {
            return DATA_SELECTED_PLAYER;
        }

        @NotNull
        protected final EntityDataAccessor<Byte> getDATA_PLAYER_MODE_CUSTOMISATION() {
            return DATA_PLAYER_MODE_CUSTOMISATION;
        }

        @NotNull
        protected final EntityDataAccessor<CompoundTag> getDATA_SHOULDER_LEFT() {
            return DATA_SHOULDER_LEFT;
        }

        @NotNull
        protected final EntityDataAccessor<CompoundTag> getDATA_SHOULDER_RIGHT() {
            return DATA_SHOULDER_RIGHT;
        }

        @NotNull
        public final AttributeSupplier.Builder createAttributes() {
            AttributeSupplier.Builder builder = Monster.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.3).add(Attributes.MAX_HEALTH, 20.0).add(Attributes.ARMOR, 0.0).add(Attributes.ATTACK_DAMAGE, 13.0).add(Attributes.FOLLOW_RANGE, 1816.0);
            Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"add(...)");
            return builder;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

