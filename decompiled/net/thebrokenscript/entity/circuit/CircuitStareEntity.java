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
 *  kotlin.reflect.KProperty
 *  net.minecraft.commands.arguments.EntityAnchorArgument$Anchor
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package net.thebrokenscript.entity.circuit;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.behaviors.CircuitDefaultStareBehavior;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.entity.circuit.CircuitStalkEntity;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 42\u00020\u0001:\u00014B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J4\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0004\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010&2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\u0010\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u000203H\u0016R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00118F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0019\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000e\u00a8\u00065"}, d2={"Lnet/thebrokenscript/entity/circuit/CircuitStareEntity;", "Lnet/thebrokenscript/entity/circuit/CircuitStalkEntity;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "<set-?>", "", "stareSpawn", "getStareSpawn", "()Z", "setStareSpawn", "(Z)V", "stareSpawn$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "", "stareSpawningTimer", "getStareSpawningTimer", "()I", "setStareSpawningTimer", "(I)V", "stareSpawningTimer$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/PersistentDataDelegate;", "crouchBool", "getCrouchBool", "setCrouchBool", "crouchBool$delegate", "defineSynchedData", "", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "tick", "baseTick", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "Companion", "thebrokenscript-common"})
public final class CircuitStareEntity
extends CircuitStalkEntity {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate stareSpawn$delegate;
    @NotNull
    private final PersistentDataDelegate stareSpawningTimer$delegate;
    @NotNull
    private final EntityDataDelegate crouchBool$delegate;
    @NotNull
    private static final String SPAWN_TIMER = "spawn_timer";
    @NotNull
    private static final EntityDataAccessor<Boolean> SPAWNING;
    @NotNull
    private static final EntityDataAccessor<Boolean> CROUCH;

    public CircuitStareEntity(@NotNull EntityType<CircuitStareEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super((EntityType<? extends CircuitStalkEntity>)type, level);
        this.stareSpawn$delegate = this.entityData(SPAWNING);
        this.stareSpawningTimer$delegate = this.persistentInt(SPAWN_TIMER);
        this.crouchBool$delegate = this.entityData(CROUCH);
        this.setPathfindingMalus(PathType.DANGER_POWDER_SNOW, 0.0f);
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FENCE, 0.0f);
        this.setPathfindingMalus(PathType.RAIL, 0.0f);
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0f);
    }

    public final boolean getStareSpawn() {
        return (Boolean)this.stareSpawn$delegate.getValue((BaseMonster)this, $$delegatedProperties[0]);
    }

    public final void setStareSpawn(boolean bl) {
        this.stareSpawn$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)bl);
    }

    public final int getStareSpawningTimer() {
        return ((Number)this.stareSpawningTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[1])).intValue();
    }

    public final void setStareSpawningTimer(int n) {
        this.stareSpawningTimer$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], (Object)n);
    }

    public final boolean getCrouchBool() {
        return (Boolean)this.crouchBool$delegate.getValue((BaseMonster)this, $$delegatedProperties[2]);
    }

    public final void setCrouchBool(boolean bl) {
        this.crouchBool$delegate.setValue((BaseMonster)this, $$delegatedProperties[2], (Object)bl);
    }

    @Override
    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(SPAWNING, (Object)true);
        builder.define(CROUCH, (Object)false);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt(SPAWN_TIMER, this.getStareSpawningTimer());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        compound.getInt(SPAWN_TIMER);
    }

    @Override
    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (!(level instanceof ServerLevel)) {
            return null;
        }
        this.setStareSpawningTimer(10);
        if (this.random.nextBoolean()) {
            List players = EntityFinder.findPlayersInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)150);
            for (ServerPlayer player : players) {
                PlayerExt.tryPlayMusic$default(PlayerExt.INSTANCE, (Player)player, (double)this.random.nextFloat() < 0.7 ? (SoundEvent)TBSSounds.FALSE_CALM_2.invoke() : (SoundEvent)TBSSounds.INTEGRITY_WATCHING.invoke(), false, 0.0f, 0.0f, 14, null);
            }
        }
        return null;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getLevel().getGameTime() % (long)20 == 0L) {
            this.setCrouchBool(BaseMonsterExtKt.shouldCrouch$default((BaseMonster)((BaseMonster)this), null, (int)1, null));
        }
    }

    @Override
    public void baseTick() {
        this.onServerTick(arg_0 -> CircuitStareEntity.baseTick$lambda$0(this, arg_0));
    }

    @Override
    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "main_controller", 0, arg_0 -> CircuitStareEntity.registerControllers$lambda$0(this, arg_0)));
    }

    private static final Unit baseTick$lambda$0(CircuitStareEntity this$0, ServerLevel level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        if (this$0.getStareSpawn()) {
            int n = this$0.getStareSpawningTimer();
            this$0.setStareSpawningTimer(n + -1);
            if (this$0.getStareSpawningTimer() <= 0) {
                this$0.setStareSpawn(false);
            } else {
                return Unit.INSTANCE;
            }
        }
        ServerPlayer serverPlayer = EntityFinder.findClosestPlayerInRange((ServerLevel)level, (Vec3)this$0.getPos(), (Number)256);
        if (serverPlayer == null) {
            return Unit.INSTANCE;
        }
        ServerPlayer player = serverPlayer;
        this$0.lookAt(EntityAnchorArgument.Anchor.EYES, player.position());
        CircuitDefaultStareBehavior.INSTANCE.tick(level, this$0.getPos(), this$0, player);
        this$0.refreshDimensions();
        return Unit.INSTANCE;
    }

    private static final PlayState registerControllers$lambda$0(CircuitStareEntity this$0, AnimationState event) {
        if (this$0.getStareSpawn()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = event.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.hold((Entity)entity, (AnimationController)animationController, (String)"spawn");
        } else if (event.isMoving()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = event.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"calm_walk");
        } else {
            Entity entity = (Entity)this$0;
            AnimationController animationController = event.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)(!this$0.getCrouchBool() ? "idle_calm_normal" : "calm_idle_mineshaft"));
        }
        return PlayState.CONTINUE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CircuitStareEntity.class, "stareSpawn", "getStareSpawn()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CircuitStareEntity.class, "stareSpawningTimer", "getStareSpawningTimer()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CircuitStareEntity.class, "crouchBool", "getCrouchBool()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(CircuitStareEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        SPAWNING = entityDataAccessor;
        EntityDataAccessor entityDataAccessor2 = SynchedEntityData.defineId(CircuitStareEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor2, (String)"defineId(...)");
        CROUCH = entityDataAccessor2;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n\u00a8\u0006\r"}, d2={"Lnet/thebrokenscript/entity/circuit/CircuitStareEntity$Companion;", "", "<init>", "()V", "SPAWN_TIMER", "", "SPAWNING", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "getSPAWNING", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "CROUCH", "getCROUCH", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getSPAWNING() {
            return SPAWNING;
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getCROUCH() {
            return CROUCH;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

