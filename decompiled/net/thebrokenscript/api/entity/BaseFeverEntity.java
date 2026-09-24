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
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.control.MoveControl
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.phys.AABB
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package net.thebrokenscript.api.entity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.entity.fever.FeverMoveControl;
import net.thebrokenscript.entity.fever.FeverNavigation;
import net.thebrokenscript.registry.TBSDamageTypes;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 22\u00020\u0001:\u00012B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J \u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0004\u001a\u00020\u0005H\u0014J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0006\u0010&\u001a\u00020\tJ\b\u0010'\u001a\u00020#H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0016H\u0016J\u0010\u0010/\u001a\u00020#2\u0006\u00100\u001a\u000201H\u0014R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000e\u00a8\u00063"}, d2={"Lnet/thebrokenscript/api/entity/BaseFeverEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "<set-?>", "", "rooted", "getRooted", "()Z", "setRooted", "(Z)V", "rooted$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "canMoveCached", "getCanMoveCached", "setCanMoveCached", "removeWhenFarAway", "distanceToClosestPlayer", "", "isPushable", "causeFallDamage", "fallDistance", "", "multiplier", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "hurt", "amount", "createNavigation", "Lnet/thebrokenscript/entity/fever/FeverNavigation;", "registerControllers", "", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "canMove", "tick", "doHurtTarget", "target", "Lnet/minecraft/world/entity/Entity;", "getBoundingBoxForCulling", "Lnet/minecraft/world/phys/AABB;", "shouldRenderAtSqrDistance", "dist", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "Companion", "thebrokenscript-common"})
public abstract class BaseFeverEntity
extends UwuableMonster {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate rooted$delegate;
    private boolean canMoveCached;
    private static final EntityDataAccessor<Boolean> ROOTED;

    public BaseFeverEntity(@NotNull EntityType<BaseFeverEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        EntityDataAccessor<Boolean> entityDataAccessor = ROOTED;
        Intrinsics.checkNotNullExpressionValue(entityDataAccessor, (String)"ROOTED");
        this.rooted$delegate = this.entityData(entityDataAccessor);
        this.canMoveCached = true;
        this.setNoGravity(true);
        this.noPhysics = true;
        this.moveControl = (MoveControl)new FeverMoveControl(this, 10, false);
        this.setPersistenceRequired();
    }

    public final boolean getRooted() {
        Object object = this.rooted$delegate.getValue((BaseMonster)this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getValue(...)");
        return (Boolean)object;
    }

    public final void setRooted(boolean bl) {
        this.rooted$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)bl);
    }

    public final boolean getCanMoveCached() {
        return this.canMoveCached;
    }

    public final void setCanMoveCached(boolean bl) {
        this.canMoveCached = bl;
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean isPushable() {
        return false;
    }

    public boolean causeFallDamage(float fallDistance, float multiplier, @NotNull DamageSource source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return false;
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD);
    }

    @NotNull
    protected FeverNavigation createNavigation(@NotNull Level level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return new FeverNavigation(this, level);
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "Fever", 0, arg_0 -> BaseFeverEntity.registerControllers$lambda$0(this, arg_0)));
    }

    public final boolean canMove() {
        return this.canMoveCached;
    }

    public void tick() {
        super.tick();
        SideUtil.clientSide((Entity)((Entity)this), () -> BaseFeverEntity.tick$lambda$0(this));
    }

    public boolean doHurtTarget(@NotNull Entity target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        if (target instanceof Player) {
            PlayerExt.INSTANCE.updateVars((Player)target, (Function1<? super PlayerVariables, Unit>)((Function1)BaseFeverEntity::doHurtTarget$lambda$0));
        }
        return target.hurt(this.damageSources().source(TBSDamageTypes.FEVER_ATTACK.getKey()), (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE));
    }

    @NotNull
    public AABB getBoundingBoxForCulling() {
        AABB aABB = super.getBoundingBoxForCulling().inflate(32.0);
        Intrinsics.checkNotNullExpressionValue((Object)aABB, (String)"inflate(...)");
        return aABB;
    }

    public boolean shouldRenderAtSqrDistance(double dist) {
        return true;
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(ROOTED, (Object)false);
    }

    private static final PlayState registerControllers$lambda$0(BaseFeverEntity this$0, AnimationState it) {
        if (((BaseFeverEntity)it.getAnimatable()).isMoving()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"FlyingMoving2");
        } else if (((BaseFeverEntity)it.getAnimatable()).getRooted()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"RootedIdle");
        } else if (!((BaseFeverEntity)it.getAnimatable()).isGrounded()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"FlyingIdle2");
        } else {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"StandingIdle");
        }
        return PlayState.CONTINUE;
    }

    private static final Object tick$lambda$0(BaseFeverEntity this$0) {
        if (!ClientVariables.INSTANCE.has(2L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return false;
            }
            LocalPlayer player = localPlayer;
            if (PlayerExt.INSTANCE.isEntityInFovCone((Player)player, (Entity)this$0, Double.valueOf(((Number)ClientDSLKt.getMC().options.fov().get()).intValue()))) {
                ClientVariables.INSTANCE.set(2L);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit doHurtTarget$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setInvertEnabled(true);
        $this$updateVars.setInvertTimer(10L);
        return Unit.INSTANCE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(BaseFeverEntity.class, "rooted", "getRooted()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        ROOTED = SynchedEntityData.defineId(BaseFeverEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R2\u0010\u0004\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/api/entity/BaseFeverEntity$Companion;", "", "<init>", "()V", "ROOTED", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "kotlin.jvm.PlatformType", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

