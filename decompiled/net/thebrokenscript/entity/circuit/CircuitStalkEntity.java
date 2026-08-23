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
 *  net.minecraft.world.entity.EntityDimensions
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.Pose
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.navigation.PathNavigation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
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
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.BaseCircuitEntity;
import net.thebrokenscript.api.entity.ai.pathfinding.MazeNavigator;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.behaviors.CircuitStalkBehavior;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.registry.TBSSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0014J\u0010\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020%2\u0006\u0010)\u001a\u00020*H\u0016J4\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u0005\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010-2\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u00020%H\u0016J\b\u00107\u001a\u00020%H\u0016J\u0010\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0014R+\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00148F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R+\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u00148F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019R+\u0010 \u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b#\u0010\u0013\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011\u00a8\u0006@"}, d2={"Lnet/thebrokenscript/entity/circuit/CircuitStalkEntity;", "Lnet/thebrokenscript/api/entity/BaseCircuitEntity;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "createNavigation", "Lnet/minecraft/world/entity/ai/navigation/PathNavigation;", "<set-?>", "", "spawning", "getSpawning", "()Z", "setSpawning", "(Z)V", "spawning$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "", "spawningTimer", "getSpawningTimer", "()I", "setSpawningTimer", "(I)V", "spawningTimer$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/PersistentDataDelegate;", "timer", "getTimer", "setTimer", "timer$delegate", "crouch", "getCrouch", "setCrouch", "crouch$delegate", "defineSynchedData", "", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "tick", "baseTick", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "getDefaultDimensions", "Lnet/minecraft/world/entity/EntityDimensions;", "pose", "Lnet/minecraft/world/entity/Pose;", "Companion", "thebrokenscript-common"})
public class CircuitStalkEntity
extends BaseCircuitEntity
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate spawning$delegate;
    @NotNull
    private final PersistentDataDelegate spawningTimer$delegate;
    @NotNull
    private final PersistentDataDelegate timer$delegate;
    @NotNull
    private final EntityDataDelegate crouch$delegate;
    @NotNull
    private static final String SPAWN_TIMER = "spawn_timer";
    @NotNull
    private static final String DESPAWN_TIMER = "despawn_timer";
    @NotNull
    private static final EntityDataAccessor<Boolean> SPAWNING;
    @NotNull
    private static final EntityDataAccessor<Boolean> CROUCH;

    public CircuitStalkEntity(@NotNull EntityType<? extends CircuitStalkEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.setPathfindingMalus(PathType.DANGER_POWDER_SNOW, 0.0f);
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FENCE, 0.0f);
        this.setPathfindingMalus(PathType.RAIL, 0.0f);
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0f);
        this.spawning$delegate = this.entityData(SPAWNING);
        this.spawningTimer$delegate = this.persistentInt(SPAWN_TIMER);
        this.timer$delegate = this.persistentInt(DESPAWN_TIMER);
        this.crouch$delegate = this.entityData(CROUCH);
    }

    @NotNull
    protected PathNavigation createNavigation(@NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return (PathNavigation)new MazeNavigator((Mob)this, level);
    }

    public final boolean getSpawning() {
        return (Boolean)this.spawning$delegate.getValue((BaseMonster)this, $$delegatedProperties[0]);
    }

    public final void setSpawning(boolean bl) {
        this.spawning$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)bl);
    }

    public final int getSpawningTimer() {
        return ((Number)this.spawningTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[1])).intValue();
    }

    public final void setSpawningTimer(int n) {
        this.spawningTimer$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], (Object)n);
    }

    public final int getTimer() {
        return ((Number)this.timer$delegate.getValue((BaseMonster)this, $$delegatedProperties[2])).intValue();
    }

    public final void setTimer(int n) {
        this.timer$delegate.setValue((BaseMonster)this, $$delegatedProperties[2], (Object)n);
    }

    public final boolean getCrouch() {
        return (Boolean)this.crouch$delegate.getValue((BaseMonster)this, $$delegatedProperties[3]);
    }

    public final void setCrouch(boolean bl) {
        this.crouch$delegate.setValue((BaseMonster)this, $$delegatedProperties[3], (Object)bl);
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(SPAWNING, (Object)true);
        builder.define(CROUCH, (Object)false);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt(SPAWN_TIMER, this.getSpawningTimer());
        compound.putInt(DESPAWN_TIMER, this.getTimer());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        this.setSpawningTimer(compound.getInt(SPAWN_TIMER));
        this.setTimer(compound.getInt(DESPAWN_TIMER));
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
        this.setSpawningTimer(10);
        this.setTimer(10000);
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
            this.setCrouch(BaseMonsterExtKt.shouldCrouch$default((BaseMonster)((BaseMonster)this), null, (int)1, null));
        }
    }

    @Override
    public void baseTick() {
        this.onServerTick(arg_0 -> CircuitStalkEntity.baseTick$lambda$0(this, arg_0));
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "circuit_stalk", 0, arg_0 -> CircuitStalkEntity.registerControllers$lambda$0(this, arg_0)));
    }

    @NotNull
    protected EntityDimensions getDefaultDimensions(@NotNull Pose pose) {
        Intrinsics.checkNotNullParameter((Object)pose, (String)"pose");
        EntityDimensions entityDimensions = super.getDefaultDimensions(pose).scale(1.0f);
        Intrinsics.checkNotNullExpressionValue((Object)entityDimensions, (String)"scale(...)");
        return entityDimensions;
    }

    private static final Unit baseTick$lambda$0(CircuitStalkEntity this$0, ServerLevel level) {
        int n;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super.baseTick();
        if (this$0.getSpawning()) {
            n = this$0.getSpawningTimer();
            this$0.setSpawningTimer(n + -1);
            if (this$0.getSpawningTimer() <= 0) {
                this$0.setSpawning(false);
            } else {
                return Unit.INSTANCE;
            }
        }
        n = this$0.getTimer();
        this$0.setTimer(n + -1);
        if (this$0.getTimer() <= 0) {
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)CircuitStalkEntity::baseTick$lambda$0$0));
            this$0.discard();
        }
        CircuitStalkBehavior.INSTANCE.tick(level, this$0.getPos(), this$0);
        this$0.refreshDimensions();
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$0$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHasCircuitSpawned(false);
        return Unit.INSTANCE;
    }

    private static final PlayState registerControllers$lambda$0(CircuitStalkEntity this$0, AnimationState it) {
        if (this$0.getSpawning()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.hold((Entity)entity, (AnimationController)animationController, (String)"spawn");
        } else if (it.isMoving() && this$0.getCrouch()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"calm_mineshaft_walk");
        } else if (this$0.getCrouch()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"calm_idle_mineshaft");
        } else if (it.isMoving()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"calm_walk");
        } else {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"idle_calm_normal");
        }
        return PlayState.CONTINUE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CircuitStalkEntity.class, "spawning", "getSpawning()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CircuitStalkEntity.class, "spawningTimer", "getSpawningTimer()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CircuitStalkEntity.class, "timer", "getTimer()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CircuitStalkEntity.class, "crouch", "getCrouch()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(CircuitStalkEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        SPAWNING = entityDataAccessor;
        EntityDataAccessor entityDataAccessor2 = SynchedEntityData.defineId(CircuitStalkEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor2, (String)"defineId(...)");
        CROUCH = entityDataAccessor2;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/entity/circuit/CircuitStalkEntity$Companion;", "", "<init>", "()V", "SPAWN_TIMER", "", "DESPAWN_TIMER", "SPAWNING", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "getSPAWNING", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "CROUCH", "getCROUCH", "thebrokenscript-common"})
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

