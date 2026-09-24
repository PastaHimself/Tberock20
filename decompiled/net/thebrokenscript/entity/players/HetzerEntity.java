/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundStopSoundPacket
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
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
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.AttributeSupplier$Builder
 *  net.minecraft.world.entity.ai.control.FlyingMoveControl
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.ai.navigation.FlyingPathNavigation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.AttributeUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
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
package net.thebrokenscript.entity.players;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.dsl.AttributeUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.brokencore.api.ext.EntityTypeExt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.brokencore.api.world.TimeOfDay;
import net.thebrokenscript.registry.TBSEntities;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.util.RepTier;
import net.thebrokenscript.util.RepUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J \u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\nH\u0016J\b\u0010*\u001a\u00020\nH\u0016J\u0010\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u0010.\u001a\u00020\n2\u0006\u0010%\u001a\u00020&2\u0006\u0010/\u001a\u00020#H\u0016J\u0010\u00100\u001a\u00020(2\u0006\u00101\u001a\u000202H\u0014J\u0010\u00103\u001a\u00020(2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020(2\u0006\u00104\u001a\u000205H\u0016J4\u00107\u001a\u0004\u0018\u0001082\u0006\u0010\u0005\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u0001082\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020(H\u0016J\b\u0010B\u001a\u00020(H\u0016J\u0010\u0010C\u001a\u00020(2\u0006\u0010D\u001a\u00020EH\u0016R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u001a\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\u000e\u0010\u001e\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006G"}, d2={"Lnet/thebrokenscript/entity/players/HetzerEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "<set-?>", "", "allow", "getAllow", "()Z", "setAllow", "(Z)V", "allow$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "", "timer", "getTimer", "()I", "setTimer", "(I)V", "timer$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/PersistentDataDelegate;", "despawnTimer", "getDespawnTimer", "setDespawnTimer", "despawnTimer$delegate", "spawnFinalized", "createNavigation", "Lnet/minecraft/world/entity/ai/navigation/FlyingPathNavigation;", "causeFallDamage", "dist", "", "mul", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "setNoGravity", "", "ignored", "requiresCustomPersistence", "removeWhenFarAway", "distanceToClosestPlayer", "", "hurt", "amount", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "readAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "addAdditionalSaveData", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "baseTick", "aiStep", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "Companion", "thebrokenscript-common"})
public final class HetzerEntity
extends UwuableMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate allow$delegate;
    @NotNull
    private final PersistentDataDelegate timer$delegate;
    @NotNull
    private final PersistentDataDelegate despawnTimer$delegate;
    private boolean spawnFinalized;
    @NotNull
    private static final String TIMER = "timer";
    @NotNull
    private static final String DESPAWN_TIMER = "despawn_timer";
    @NotNull
    private static final String ALLOW_TIMER = "timer_allowance";
    private static final EntityDataAccessor<Boolean> ALLOW_BOOL;

    public HetzerEntity(@NotNull EntityType<HetzerEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        EntityDataAccessor<Boolean> entityDataAccessor = ALLOW_BOOL;
        Intrinsics.checkNotNullExpressionValue(entityDataAccessor, (String)"ALLOW_BOOL");
        this.allow$delegate = this.entityData(entityDataAccessor);
        this.timer$delegate = this.persistentInt(TIMER);
        this.despawnTimer$delegate = this.persistentInt(DESPAWN_TIMER);
        this.xpReward = 0;
        this.setNoAi(false);
        this.moveControl = (MoveControl)new FlyingMoveControl((Mob)this, 10, true);
    }

    public final boolean getAllow() {
        Object object = this.allow$delegate.getValue((BaseMonster)this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return (Boolean)object;
    }

    public final void setAllow(boolean bl) {
        this.allow$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)bl);
    }

    public final int getTimer() {
        return ((Number)this.timer$delegate.getValue((BaseMonster)this, $$delegatedProperties[1])).intValue();
    }

    public final void setTimer(int n) {
        this.timer$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], (Object)n);
    }

    public final int getDespawnTimer() {
        return ((Number)this.despawnTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[2])).intValue();
    }

    public final void setDespawnTimer(int n) {
        this.despawnTimer$delegate.setValue((BaseMonster)this, $$delegatedProperties[2], (Object)n);
    }

    @NotNull
    protected FlyingPathNavigation createNavigation(@NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return new FlyingPathNavigation((Mob)this, level);
    }

    public boolean causeFallDamage(float dist, float mul, @NotNull DamageSource source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return false;
    }

    public void setNoGravity(boolean ignored) {
        super.setNoGravity(true);
    }

    public boolean requiresCustomPersistence() {
        return true;
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD);
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(ALLOW_BOOL, (Object)false);
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        this.setTimer(compound.getInt(TIMER));
        this.setAllow(compound.getBoolean(ALLOW_TIMER));
        this.setDespawnTimer(compound.getInt(DESPAWN_TIMER));
        this.spawnFinalized = compound.getBoolean("spawnFinalized");
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt(TIMER, this.getTimer());
        compound.putBoolean(ALLOW_TIMER, this.getAllow());
        compound.putInt(DESPAWN_TIMER, this.getDespawnTimer());
        compound.putBoolean("spawnFinalized", this.spawnFinalized);
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        this.setTimer(1200);
        this.setDespawnTimer(2400);
        this.spawnFinalized = true;
        this.setPersistenceRequired();
        return null;
    }

    public void baseTick() {
        super.baseTick();
        if (!this.spawnFinalized) {
            return;
        }
        Level level = this.level();
        if (!(level instanceof ServerLevel)) {
            this.refreshDimensions();
            return;
        }
        for (ServerPlayer player : EntityFinder.findPlayersInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)500.0)) {
            if (!PlayerUtil.isLookingAtEntityHitbox((Player)((Player)player), (Entity)((Entity)this)) && !EntityUtil.isWithin((Entity)((Entity)player), (Vec3)this.getPos(), (Number)10) || this.getAllow()) continue;
            this.setAllow(true);
            this.setInvisible(true);
            RepUtilKt.applyRep((Player)player, RepTier.LOSS_BABY);
            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 5, 1, false, false));
            SoundUtil.playSound$default((LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos(), (SoundEvent)((SoundEvent)TBSSounds.FALSE_SUBWOOFER_LULLABY.get()), (float)10.0f, (float)1.0f, null, (int)16, null);
            TimeOfDay.DAY.setFake();
            break;
        }
        if (this.getAllow()) {
            int n = this.getTimer();
            this.setTimer(n + -1);
            switch (this.getTimer()) {
                case 200: {
                    TimeOfDay.MIDNIGHT.setFake();
                    ((ServerLevel)level).getServer().getPlayerList().broadcastAll((Packet)new ClientboundStopSoundPacket(null, null));
                    break;
                }
                case 0: {
                    int y = ((ServerLevel)level).getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, this.getBlockPos().getX(), this.getBlockPos().getZ());
                    Vec3 newPos = this.getPos().y < (double)(y - 1) ? this.getPos() : new Vec3(this.getPos().x, (double)y, this.getPos().z);
                    EntityUtil.applyRandomRotation((Entity)EntityTypeExt.trySummon((EntityType)((EntityType)TBSEntities.CIRCUIT.get()), (LevelAccessor)((LevelAccessor)level), (Vec3)newPos));
                    this.discard();
                }
            }
        }
        if (!this.getAllow()) {
            int n = this.getDespawnTimer();
            this.setDespawnTimer(n + -1);
            if (this.getDespawnTimer() <= 0) {
                this.discard();
            }
        }
        this.refreshDimensions();
    }

    public void aiStep() {
        super.aiStep();
        this.setNoGravity(true);
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "hetzer", 0, arg_0 -> HetzerEntity.registerControllers$lambda$0(this, arg_0)));
    }

    private static final PlayState registerControllers$lambda$0(HetzerEntity this$0, AnimationState it) {
        Entity entity = (Entity)this$0;
        AnimationController animationController = it.getController();
        Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
        GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"idle1");
        return PlayState.CONTINUE;
    }

    public static final /* synthetic */ AttributeSupplier.Builder access$attrs$s910975913(Function1 block) {
        return BaseMonster.attrs((Function1)block);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(HetzerEntity.class, "allow", "getAllow()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(HetzerEntity.class, TIMER, "getTimer()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(HetzerEntity.class, "despawnTimer", "getDespawnTimer()I", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        ALLOW_BOOL = SynchedEntityData.defineId(HetzerEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R2\u0010\n\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/entity/players/HetzerEntity$Companion;", "", "<init>", "()V", "attributes", "Lnet/minecraft/world/entity/ai/attributes/AttributeSupplier$Builder;", "TIMER", "", "DESPAWN_TIMER", "ALLOW_TIMER", "ALLOW_BOOL", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "kotlin.jvm.PlatformType", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final AttributeSupplier.Builder attributes() {
            return HetzerEntity.access$attrs$s910975913(Companion::attributes$lambda$0);
        }

        private static final Unit attributes$lambda$0(AttributeSupplier.Builder $this$attrs) {
            Intrinsics.checkNotNullParameter((Object)$this$attrs, (String)"$this$attrs");
            AttributeUtil.setMovementSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0);
            AttributeUtil.setMaxHealth((AttributeSupplier.Builder)$this$attrs, (Number)900);
            AttributeUtil.setArmor((AttributeSupplier.Builder)$this$attrs, (Number)50);
            AttributeUtil.setAttackDamage((AttributeSupplier.Builder)$this$attrs, (Number)13);
            AttributeUtil.setFollowRange((AttributeSupplier.Builder)$this$attrs, (Number)1916);
            AttributeUtil.setKnockbackResistance((AttributeSupplier.Builder)$this$attrs, (Number)50);
            AttributeUtil.setFlyingSpeed((AttributeSupplier.Builder)$this$attrs, (Number)0);
            AttributeUtil.setStepHeight((AttributeSupplier.Builder)$this$attrs, (Number)0.6);
            return Unit.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

