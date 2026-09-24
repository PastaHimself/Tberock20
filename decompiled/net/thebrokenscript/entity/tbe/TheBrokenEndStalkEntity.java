/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.core.BlockPos
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.protocol.game.ClientboundStopSoundPacket
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.GameRules
 *  net.minecraft.world.level.GameRules$BooleanValue
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.LevelUtil
 *  net.thebrokenscript.brokencore.api.dsl.PacketUtil
 *  net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  net.thebrokenscript.brokencore.api.ext.EntityTypeExt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  net.thebrokenscript.brokencore.api.world.TimeOfDay
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package net.thebrokenscript.entity.tbe;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.block.PhysicalStacktraceBlock;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.LevelUtil;
import net.thebrokenscript.brokencore.api.dsl.PacketUtil;
import net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSPackets;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J4\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u0005\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010*2\u0006\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020%H\u0016J\b\u00104\u001a\u00020%H\u0016J\u0010\u00105\u001a\u00020%2\u0006\u00106\u001a\u000207H\u0016J\b\u00108\u001a\u000209H\u0016J\u0010\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\fH\u0016J \u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020\f2\u0006\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\fH\u0016R\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR+\u0010 \u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b#\u0010\u001f\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001d\u00a8\u0006A"}, d2={"Lnet/thebrokenscript/entity/tbe/TheBrokenEndStalkEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "removeWhenFarAway", "", "distanceToClosestPlayer", "", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "enableTimer", "getEnableTimer", "()Z", "setEnableTimer", "(Z)V", "<set-?>", "", "despawnTimer", "getDespawnTimer", "()I", "setDespawnTimer", "(I)V", "despawnTimer$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/PersistentDataDelegate;", "spawnTimer", "getSpawnTimer", "setSpawnTimer", "spawnTimer$delegate", "addAdditionalSaveData", "", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "baseTick", "tick", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "getBoundingBoxForCulling", "Lnet/minecraft/world/phys/AABB;", "shouldRenderAtSqrDistance", "dist", "shouldRender", "x", "y", "z", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nTheBrokenEndStalkEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TheBrokenEndStalkEntity.kt\nnet/thebrokenscript/entity/tbe/TheBrokenEndStalkEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,189:1\n1869#2,2:190\n*S KotlinDebug\n*F\n+ 1 TheBrokenEndStalkEntity.kt\nnet/thebrokenscript/entity/tbe/TheBrokenEndStalkEntity\n*L\n78#1:190,2\n*E\n"})
public final class TheBrokenEndStalkEntity
extends UwuableMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private boolean enableTimer;
    @NotNull
    private final PersistentDataDelegate despawnTimer$delegate;
    @NotNull
    private final PersistentDataDelegate spawnTimer$delegate;
    @NotNull
    private static final String NATURAL_DESPAWN = "despawn_timer";
    @NotNull
    private static final String TBE_SPAWN = "tbe_timer";

    public TheBrokenEndStalkEntity(@NotNull EntityType<TheBrokenEndStalkEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.despawnTimer$delegate = this.persistentInt(NATURAL_DESPAWN);
        this.spawnTimer$delegate = this.persistentInt(TBE_SPAWN);
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD);
    }

    public final boolean getEnableTimer() {
        return this.enableTimer;
    }

    public final void setEnableTimer(boolean bl) {
        this.enableTimer = bl;
    }

    public final int getDespawnTimer() {
        return ((Number)this.despawnTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[0])).intValue();
    }

    public final void setDespawnTimer(int n) {
        this.despawnTimer$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)n);
    }

    public final int getSpawnTimer() {
        return ((Number)this.spawnTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[1])).intValue();
    }

    public final void setSpawnTimer(int n) {
        this.spawnTimer$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], (Object)n);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt(NATURAL_DESPAWN, this.getDespawnTimer());
        compound.putInt(TBE_SPAWN, this.getSpawnTimer());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        compound.getInt(NATURAL_DESPAWN);
        compound.getInt(TBE_SPAWN);
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (!(level instanceof ServerLevel)) {
            return null;
        }
        LevelUtil.getQueue((Level)((Level)level)).add(1L, () -> TheBrokenEndStalkEntity.onFinalizeSpawn$lambda$0(level, this));
        ((GameRules.BooleanValue)((ServerLevel)level).getLevelData().getGameRules().getRule(GameRules.RULE_DAYLIGHT)).set(false, ((ServerLevel)level).getServer());
        ((ServerLevel)level).setWeatherParameters(0, ServerLevel.RAIN_DURATION.sample(((ServerLevel)level).random), true, false);
        this.setDespawnTimer(7200);
        this.setSpawnTimer(320);
        return null;
    }

    public void baseTick() {
        super.baseTick();
        Level level = this.level();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        if (this.enableTimer) {
            int n = this.getSpawnTimer();
            this.setSpawnTimer(n + -1);
            if (this.getSpawnTimer() == 0) {
                this.discard();
                EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.THE_BROKEN_END.get()), (LevelAccessor)((LevelAccessor)level), (BlockPos)this.getBlockPos()));
            }
        }
        if (this.isInvisible()) {
            return;
        }
        ServerPlayer serverPlayer = EntityFinder.findClosestPlayerInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)150.0);
        if (serverPlayer == null) {
            return;
        }
        ServerPlayer closestPlayer = serverPlayer;
        this.lookAt(EntityAnchorArgument.Anchor.EYES, closestPlayer.position());
        if (this.isWithin((Entity)closestPlayer, 30)) {
            closestPlayer.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 21, 1, false, false));
            SoundUtil.tryPlaySound$default((Level)level, (Vec3)this.getPos(), (SoundEvent)((SoundEvent)TBSSounds.HEARTBEAT.get()), (float)10.0f, (float)0.0f, null, (int)16, null);
            if ((double)((ServerLevel)level).random.nextFloat() < 0.2) {
                this.discard();
                if ((double)((ServerLevel)level).random.nextFloat() < 0.7) {
                    TimeOfDay.MIDNIGHT.setFake();
                }
            } else {
                this.setInvisible(true);
                this.enableTimer = true;
            }
        }
        if (EntityUtil.isWithin((Entity)((Entity)closestPlayer), (Vec3)this.getPos(), (Number)192) && PlayerUtil.isLookingAtEntityHitbox((Player)((Player)closestPlayer), (Entity)((Entity)this))) {
            closestPlayer.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 21, 1, false, false));
            SoundUtil.tryPlaySound$default((Level)level, (Vec3)this.getPos(), (SoundEvent)((SoundEvent)TBSSounds.HEARTBEAT.get()), (float)10.0f, (float)0.0f, null, (int)16, null);
            if ((double)this.random.nextFloat() < 0.7) {
                this.setInvisible(true);
                PacketUtil.tryBroadcastPacket((LevelAccessor)((LevelAccessor)level), (Packet)((Packet)new ClientboundStopSoundPacket(null, null)));
                this.enableTimer = true;
            } else {
                this.discard();
                ((ServerLevel)level).setBlock(BlockPos.containing((double)this.getX(), (double)(this.getY() - 1.0), (double)this.getZ()), ((PhysicalStacktraceBlock)((Object)TBSBlocks.PHYSICAL_STACKTRACE.get())).defaultBlockState(), 3);
            }
        }
        int n = this.getDespawnTimer();
        this.setDespawnTimer(n + -1);
        if (this.getDespawnTimer() <= 0) {
            this.discard();
            ((GameRules.BooleanValue)((ServerLevel)level).getLevelData().getGameRules().getRule(GameRules.RULE_DAYLIGHT)).set(true, ((ServerLevel)level).getServer());
        }
    }

    public void tick() {
        super.tick();
        SideUtil.clientSide((Entity)((Entity)this), () -> TheBrokenEndStalkEntity.tick$lambda$0(this));
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "tbe_stalk", 0, arg_0 -> TheBrokenEndStalkEntity.registerControllers$lambda$0(this, arg_0)));
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

    public boolean shouldRender(double x, double y, double z) {
        return true;
    }

    private static final Unit onFinalizeSpawn$lambda$0(ServerLevelAccessor $level, TheBrokenEndStalkEntity this$0) {
        Iterable $this$forEach$iv = EntityFinder.findPlayersInRange((ServerLevel)((ServerLevel)$level), (Vec3)this$0.getPos(), (Number)256);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerPlayer player = (ServerPlayer)element$iv;
            boolean bl = false;
            PlayerUtil.trySendCustomPacket((Player)((Player)player), (CustomPacketPayload)((CustomPacketPayload)TBSPackets.TBE_SPAWN_PACKET.of(this$0.getId())));
        }
        return Unit.INSTANCE;
    }

    private static final Object tick$lambda$0(TheBrokenEndStalkEntity this$0) {
        if (!ClientVariables.INSTANCE.has(4096L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return false;
            }
            LocalPlayer player = localPlayer;
            if (PlayerExt.INSTANCE.isEntityInFovCone((Player)player, (Entity)this$0, Double.valueOf(((Number)ClientDSLKt.getMC().options.fov().get()).intValue()))) {
                ClientVariables.INSTANCE.set(4096L);
            }
        }
        return Unit.INSTANCE;
    }

    private static final PlayState registerControllers$lambda$0(TheBrokenEndStalkEntity this$0, AnimationState it) {
        Entity entity = (Entity)this$0;
        AnimationController animationController = it.getController();
        Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
        GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"animation.tbe.idle");
        return PlayState.CONTINUE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(TheBrokenEndStalkEntity.class, "despawnTimer", "getDespawnTimer()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(TheBrokenEndStalkEntity.class, "spawnTimer", "getSpawnTimer()I", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Lnet/thebrokenscript/entity/tbe/TheBrokenEndStalkEntity$Companion;", "", "<init>", "()V", "NATURAL_DESPAWN", "", "TBE_SPAWN", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

