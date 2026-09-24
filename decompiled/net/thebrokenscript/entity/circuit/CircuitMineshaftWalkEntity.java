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
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Holder$Reference
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.sounds.SoundEvents
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
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

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.entity.BaseCircuitEntity;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.behaviors.CircuitMineshaftStalkBehaviour;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.data.MapVariables;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J4\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0005\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u001d2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0018H\u0016J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(H\u0016R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006*"}, d2={"Lnet/thebrokenscript/entity/circuit/CircuitMineshaftWalkEntity;", "Lnet/thebrokenscript/api/entity/BaseCircuitEntity;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "<set-?>", "", "timer", "getTimer", "()I", "setTimer", "(I)V", "timer$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/PersistentDataDelegate;", "checkSpawnRules", "", "Lnet/minecraft/world/level/LevelAccessor;", "reason", "Lnet/minecraft/world/entity/MobSpawnType;", "addAdditionalSaveData", "", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "baseTick", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "Companion", "thebrokenscript-common"})
public class CircuitMineshaftWalkEntity
extends BaseCircuitEntity
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final PersistentDataDelegate timer$delegate;
    @NotNull
    private static final String DESPAWN_TIMER = "despawn_timer";

    public CircuitMineshaftWalkEntity(@NotNull EntityType<? extends CircuitMineshaftWalkEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.timer$delegate = this.persistentInt(DESPAWN_TIMER);
        this.setPathfindingMalus(PathType.DANGER_POWDER_SNOW, 2.0f);
        this.setPathfindingMalus(PathType.POWDER_SNOW, 4.0f);
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FENCE, 0.0f);
        this.setPathfindingMalus(PathType.RAIL, 0.0f);
        this.setPathfindingMalus(PathType.UNPASSABLE_RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 8.0f);
        this.setPathfindingMalus(PathType.WALKABLE, 0.0f);
        this.setPathfindingMalus(PathType.DAMAGE_OTHER, 0.0f);
        this.setPathfindingMalus(PathType.DANGER_OTHER, 0.0f);
        this.setPathfindingMalus(PathType.DAMAGE_FIRE, 0.0f);
        this.setPathfindingMalus(PathType.DANGER_FIRE, 0.0f);
    }

    public final int getTimer() {
        return ((Number)this.timer$delegate.getValue((BaseMonster)this, $$delegatedProperties[0])).intValue();
    }

    public final void setTimer(int n) {
        this.timer$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)n);
    }

    public boolean checkSpawnRules(@NotNull LevelAccessor level, @NotNull MobSpawnType reason) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
        return true;
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt(DESPAWN_TIMER, this.getTimer());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        compound.getInt(DESPAWN_TIMER);
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        LevelAccessor levelAccessor = (LevelAccessor)level;
        Vec3 vec3 = this.getPos();
        Holder.Reference reference = SoundEvents.AMBIENT_CAVE;
        Intrinsics.checkNotNullExpressionValue((Object)reference, (String)"AMBIENT_CAVE");
        SoundUtil.playSound$default((LevelAccessor)levelAccessor, (Vec3)vec3, (Holder)((Holder)reference), (float)10.0f, (float)0.0f, null, (int)16, null);
        this.setTimer(10000);
        return null;
    }

    @Override
    public void baseTick() {
        this.onServerTick(arg_0 -> CircuitMineshaftWalkEntity.baseTick$lambda$0(this, arg_0));
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "circuit_mineshaft_walk", 0, arg_0 -> CircuitMineshaftWalkEntity.registerControllers$lambda$0(this, arg_0)));
    }

    private static final Unit baseTick$lambda$0(CircuitMineshaftWalkEntity this$0, ServerLevel level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        CircuitMineshaftStalkBehaviour.INSTANCE.tick(level, this$0.getPos(), this$0);
        int n = this$0.getTimer();
        this$0.setTimer(n + -1);
        if (this$0.getTimer() <= 0) {
            LevelExt.INSTANCE.updateVars((LevelAccessor)level, (Function1<? super MapVariables, Unit>)((Function1)CircuitMineshaftWalkEntity::baseTick$lambda$0$0));
            this$0.discard();
        }
        this$0.refreshDimensions();
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$0$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setHasCircuitSpawned(false);
        return Unit.INSTANCE;
    }

    private static final PlayState registerControllers$lambda$0(CircuitMineshaftWalkEntity this$0, AnimationState it) {
        if (it.isMoving()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"calm_mineshaft_walk");
        } else {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"calm_idle_mineshaft");
        }
        return PlayState.CONTINUE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(CircuitMineshaftWalkEntity.class, "timer", "getTimer()I", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/entity/circuit/CircuitMineshaftWalkEntity$Companion;", "", "<init>", "()V", "DESPAWN_TIMER", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

