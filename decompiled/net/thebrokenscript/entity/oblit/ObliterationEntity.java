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
 *  kotlin.ranges.RangesKt
 *  kotlin.reflect.KProperty
 *  kotlin.text.Charsets
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.core.particles.ParticleOptions
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.control.LookControl
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.EntityUtil
 *  net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 *  software.bernie.geckolib.animation.RawAnimation
 */
package net.thebrokenscript.entity.oblit;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.EntityUtil;
import net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.data.PlayerVariables;
import net.thebrokenscript.registry.TBSParticleTypes;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.util.PlayerDesyncManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 r2\u00020\u00012\u00020\u0002:\u0001rB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010A\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0014J\u0010\u0010O\u001a\u00020F2\u0006\u0010P\u001a\u00020QH\u0016J\u0010\u0010R\u001a\u00020F2\u0006\u0010P\u001a\u00020QH\u0016J\b\u0010S\u001a\u00020FH\u0016J4\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010\u0005\u001a\u00020V2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020D2\b\u0010Z\u001a\u0004\u0018\u00010U2\u0006\u0010[\u001a\u00020\\H\u0016J\b\u0010^\u001a\u00020FH\u0016J\u0010\u0010_\u001a\u00020F2\u0006\u0010`\u001a\u00020aH\u0016J\u0010\u0010b\u001a\u00020\n2\u0006\u0010c\u001a\u00020dH\u0016J \u0010e\u001a\u00020\n2\u0006\u0010f\u001a\u00020\u001e2\u0006\u0010g\u001a\u00020\u001e2\u0006\u0010h\u001a\u00020iH\u0016J\u0018\u0010j\u001a\u00020\n2\u0006\u0010h\u001a\u00020i2\u0006\u0010k\u001a\u00020\u001eH\u0016J\b\u0010l\u001a\u00020\nH\u0016J\b\u0010m\u001a\u00020\nH\u0016J\b\u0010n\u001a\u00020oH\u0016J\u0010\u0010p\u001a\u00020\n2\u0006\u0010q\u001a\u00020dH\u0016R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010)\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u001a\u0010,\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001a\u0010/\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R\u001a\u00102\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001a\u00105\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010 \"\u0004\b7\u0010\"R\u001a\u00108\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010 \"\u0004\b:\u0010\"R\u001a\u0010;\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010 \"\u0004\b=\u0010\"R\u001a\u0010>\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010\u0016R$\u0010J\u001a\u00020I2\u0006\u0010\t\u001a\u00020I8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u000e\u0010]\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006s"}, d2={"Lnet/thebrokenscript/entity/oblit/ObliterationEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "value", "", "flyUp", "getFlyUp", "()Z", "setFlyUp", "(Z)V", "<set-?>", "", "timer", "getTimer", "()I", "setTimer", "(I)V", "timer$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/PersistentDataDelegate;", "despawnTimer", "getDespawnTimer", "setDespawnTimer", "despawnTimer$delegate", "customXRot", "", "getCustomXRot", "()F", "setCustomXRot", "(F)V", "customYRot", "getCustomYRot", "setCustomYRot", "customSpinZ", "getCustomSpinZ", "setCustomSpinZ", "prevCustomXRot", "getPrevCustomXRot", "setPrevCustomXRot", "prevCustomYRot", "getPrevCustomYRot", "setPrevCustomYRot", "prevCustomSpinZ", "getPrevCustomSpinZ", "setPrevCustomSpinZ", "spinSpeed", "getSpinSpeed", "setSpinSpeed", "pivotX", "getPivotX", "setPivotX", "pivotY", "getPivotY", "setPivotY", "pivotZ", "getPivotZ", "setPivotZ", "glitchTicks", "getGlitchTicks", "setGlitchTicks", "checkSpawnRules", "Lnet/minecraft/world/level/LevelAccessor;", "reason", "Lnet/minecraft/world/entity/MobSpawnType;", "defineSynchedData", "", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "Ljava/util/UUID;", "closest", "getClosest", "()Ljava/util/UUID;", "setClosest", "(Ljava/util/UUID;)V", "addAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "tick", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "lookTicks", "baseTick", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "removeWhenFarAway", "distanceToClosestPlayer", "", "causeFallDamage", "l", "d", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "hurt", "amount", "isPushable", "isEffectiveAi", "getBoundingBoxForCulling", "Lnet/minecraft/world/phys/AABB;", "shouldRenderAtSqrDistance", "dist", "Companion", "thebrokenscript-common"})
public final class ObliterationEntity
extends UwuableMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final PersistentDataDelegate timer$delegate;
    @NotNull
    private final PersistentDataDelegate despawnTimer$delegate;
    private float customXRot;
    private float customYRot;
    private float customSpinZ;
    private float prevCustomXRot;
    private float prevCustomYRot;
    private float prevCustomSpinZ;
    private float spinSpeed;
    private float pivotX;
    private float pivotY;
    private float pivotZ;
    private int glitchTicks;
    private int lookTicks;
    @NotNull
    private static final EntityDataAccessor<Boolean> DATA_FLYUP;
    @NotNull
    private static final UUID DEFAULT_UUID;
    @NotNull
    private static final String PERSIST_FLYUP = "flyUp";
    @NotNull
    private static final String DESYNC_TIMER = "desyncTimer";
    @NotNull
    private static final String DESPAWN_TIMER = "despawnTimer";
    @NotNull
    private static final String CLOSEST_PLAYER = "closestPlayerUUID";
    private static final int REQUIRED_LOOK_TICKS = 80;

    public ObliterationEntity(@NotNull EntityType<ObliterationEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.timer$delegate = this.persistentInt(DESYNC_TIMER);
        this.despawnTimer$delegate = this.persistentInt(DESPAWN_TIMER);
        this.spinSpeed = 30.0f;
        this.lookControl = new LookControl(this){

            public void tick() {
            }
        };
    }

    public final boolean getFlyUp() {
        Object object = this.entityData.get(DATA_FLYUP);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        return (Boolean)object;
    }

    public final void setFlyUp(boolean value) {
        this.entityData.set(DATA_FLYUP, (Object)value);
        EntityUtil.getPersistentData((Entity)((Entity)this)).putBoolean(PERSIST_FLYUP, value);
    }

    public final int getTimer() {
        return ((Number)this.timer$delegate.getValue((BaseMonster)this, $$delegatedProperties[0])).intValue();
    }

    public final void setTimer(int n) {
        this.timer$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)n);
    }

    public final int getDespawnTimer() {
        return ((Number)this.despawnTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[1])).intValue();
    }

    public final void setDespawnTimer(int n) {
        this.despawnTimer$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], (Object)n);
    }

    public final float getCustomXRot() {
        return this.customXRot;
    }

    public final void setCustomXRot(float f) {
        this.customXRot = f;
    }

    public final float getCustomYRot() {
        return this.customYRot;
    }

    public final void setCustomYRot(float f) {
        this.customYRot = f;
    }

    public final float getCustomSpinZ() {
        return this.customSpinZ;
    }

    public final void setCustomSpinZ(float f) {
        this.customSpinZ = f;
    }

    public final float getPrevCustomXRot() {
        return this.prevCustomXRot;
    }

    public final void setPrevCustomXRot(float f) {
        this.prevCustomXRot = f;
    }

    public final float getPrevCustomYRot() {
        return this.prevCustomYRot;
    }

    public final void setPrevCustomYRot(float f) {
        this.prevCustomYRot = f;
    }

    public final float getPrevCustomSpinZ() {
        return this.prevCustomSpinZ;
    }

    public final void setPrevCustomSpinZ(float f) {
        this.prevCustomSpinZ = f;
    }

    public final float getSpinSpeed() {
        return this.spinSpeed;
    }

    public final void setSpinSpeed(float f) {
        this.spinSpeed = f;
    }

    public final float getPivotX() {
        return this.pivotX;
    }

    public final void setPivotX(float f) {
        this.pivotX = f;
    }

    public final float getPivotY() {
        return this.pivotY;
    }

    public final void setPivotY(float f) {
        this.pivotY = f;
    }

    public final float getPivotZ() {
        return this.pivotZ;
    }

    public final void setPivotZ(float f) {
        this.pivotZ = f;
    }

    public final int getGlitchTicks() {
        return this.glitchTicks;
    }

    public final void setGlitchTicks(int n) {
        this.glitchTicks = n;
    }

    public boolean checkSpawnRules(@NotNull LevelAccessor level, @NotNull MobSpawnType reason) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
        return true;
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(DATA_FLYUP, (Object)false);
    }

    @NotNull
    public final UUID getClosest() {
        UUID uUID;
        if (EntityUtil.getPersistentData((Entity)((Entity)this)).contains(CLOSEST_PLAYER, 11)) {
            UUID uUID2 = EntityUtil.getPersistentData((Entity)((Entity)this)).getUUID(CLOSEST_PLAYER);
            Intrinsics.checkNotNull((Object)uUID2);
            uUID = uUID2;
        } else {
            uUID = DEFAULT_UUID;
        }
        return uUID;
    }

    public final void setClosest(@NotNull UUID value) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        EntityUtil.getPersistentData((Entity)((Entity)this)).putUUID(CLOSEST_PLAYER, value);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        compound.putInt(DESYNC_TIMER, this.getTimer());
        compound.putInt(DESPAWN_TIMER, this.getDespawnTimer());
        compound.putUUID(CLOSEST_PLAYER, this.getClosest());
        compound.putBoolean(PERSIST_FLYUP, this.getFlyUp());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        UUID uUID;
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        this.setTimer(compound.getInt(DESYNC_TIMER));
        this.setDespawnTimer(compound.getInt(DESPAWN_TIMER));
        if (compound.contains(CLOSEST_PLAYER, 11)) {
            UUID uUID2 = compound.getUUID(CLOSEST_PLAYER);
            Intrinsics.checkNotNull((Object)uUID2);
            uUID = uUID2;
        } else {
            uUID = DEFAULT_UUID;
        }
        this.setClosest(uUID);
        if (compound.contains(PERSIST_FLYUP, 1)) {
            this.setFlyUp(compound.getBoolean(PERSIST_FLYUP));
        }
    }

    public void tick() {
        super.tick();
        SideUtil.clientSide((Entity)((Entity)this), () -> ObliterationEntity.tick$lambda$0(this));
        if (this.getLevel().isClientSide) {
            this.prevCustomXRot = this.customXRot;
            this.prevCustomYRot = this.customYRot;
            this.prevCustomSpinZ = this.customSpinZ;
            if (this.getFlyUp()) {
                this.spinSpeed += 0.3f;
                if (this.glitchTicks <= 0 && this.random.nextFloat() < 0.02f) {
                    this.glitchTicks = 6 + this.random.nextInt(6);
                }
                if (this.glitchTicks > 0) {
                    int n = this.glitchTicks;
                    this.glitchTicks = n + -1;
                    if (this.glitchTicks % 2 == 0) {
                        this.pivotX = (float)(Math.random() * 2.0 - 1.0) * 6.0f;
                        this.pivotY = (float)(Math.random() * 2.0 - 1.0) * 6.0f;
                        this.pivotZ = (float)(Math.random() * 2.0 - 1.0) * 6.0f;
                    }
                    this.customSpinZ = (float)(Math.random() * (double)360.0f);
                    this.customYRot = (float)(Math.random() * (double)360.0f);
                    this.customXRot = (float)(Math.random() * (double)180.0f - (double)90.0f);
                } else {
                    this.customSpinZ = (this.customSpinZ + this.spinSpeed) % 360.0f;
                    this.customYRot = (this.customYRot + this.spinSpeed) % 360.0f;
                    this.customXRot = (float)(Math.sin((double)this.tickCount * 0.1) * (double)20.0f);
                    this.pivotX = 0.0f;
                    this.pivotY = 0.0f;
                    this.pivotZ = 0.0f;
                }
            } else {
                this.pivotX = 0.0f;
                this.pivotY = 0.0f;
                this.pivotZ = 0.0f;
                this.customSpinZ = 0.0f;
                this.customYRot = 0.0f;
                this.customXRot = 0.0f;
                this.spinSpeed = 0.0f;
                this.glitchTicks = 0;
            }
        }
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        if (spawnType == MobSpawnType.NATURAL || spawnType == MobSpawnType.MOB_SUMMONED) {
            Entity entity = (Entity)this;
            BlockPos blockPos = this.getBlockPos().offset(0, 25, 0);
            Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"offset(...)");
            EntityUtil.teleport((Entity)entity, (BlockPos)blockPos);
        }
        SoundUtil.playSound$default((LevelAccessor)((LevelAccessor)level), (Vec3)this.getPos(), (Holder)((Holder)TBSSounds.INTEGRITY_WATCHING), (float)10.0f, (float)2.0f, null, (int)16, null);
        this.setTimer(150);
        this.setDespawnTimer(4200);
        this.setNoGravity(true);
        this.setNoAi(true);
        return null;
    }

    public void baseTick() {
        int n;
        boolean conditionMet;
        super.baseTick();
        if (!(this.getLevel() instanceof ServerLevel)) {
            return;
        }
        LevelAccessor levelAccessor = (LevelAccessor)this.getLevel();
        Vec3 vec3 = this.position();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"position(...)");
        Player player = EntityFinder.findClosestPlayerInRange((LevelAccessor)levelAccessor, (Vec3)vec3, (Number)480);
        if (player == null) {
            return;
        }
        Player player2 = player;
        if (!(player2 instanceof ServerPlayer)) {
            return;
        }
        boolean bl = conditionMet = PlayerUtil.isLookingAtEntityHitbox((Player)player2, (Entity)((Entity)this)) || EntityUtil.isWithin((Entity)((Entity)player2), (Vec3)this.getPos(), (Number)20) && !this.getFlyUp();
        if (conditionMet) {
            n = this.lookTicks;
            this.lookTicks = n + 1;
            if (this.lookTicks >= 80) {
                UUID uUID = ((ServerPlayer)player2).getUUID();
                Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"getUUID(...)");
                this.setClosest(uUID);
                this.setFlyUp(true);
                PlayerExt.INSTANCE.updateVars(player2, (Function1<? super PlayerVariables, Unit>)((Function1)ObliterationEntity::baseTick$lambda$0));
            }
        } else {
            this.lookTicks = RangesKt.coerceAtLeast((int)(this.lookTicks - 2), (int)0);
        }
        if (this.getFlyUp()) {
            MinecraftServer minecraftServer = this.getLevel().getServer();
            if (minecraftServer == null || (minecraftServer = minecraftServer.getPlayerList()) == null || (minecraftServer = minecraftServer.getPlayer(this.getClosest())) == null) {
                return;
            }
            MinecraftServer player3 = minecraftServer;
            if (this.getTimer() == 150) {
                PlayerExt.tryLoopSound$default(PlayerExt.INSTANCE, (Player)player3, (SoundEvent)TBSSounds.TAPE_SCRATCH.get(), 0.0f, 2, null);
                this.setDeltaMovement(new Vec3(0.0, 4.0, 0.0));
            }
            int n2 = this.getTimer();
            this.setTimer(n2 + -1);
        }
        if (this.getTimer() <= 0) {
            MinecraftServer minecraftServer = this.getLevel().getServer();
            if (minecraftServer == null || (minecraftServer = minecraftServer.getPlayerList()) == null || (minecraftServer = minecraftServer.getPlayer(this.getClosest())) == null) {
                return;
            }
            MinecraftServer player4 = minecraftServer;
            PlayerExt.INSTANCE.tryStopLoopingSound((Player)player4, (SoundEvent)TBSSounds.TAPE_SCRATCH.get());
            PlayerExt.tryLoopSound$default(PlayerExt.INSTANCE, (Player)player4, (SoundEvent)TBSSounds.TAPE_HISS.get(), 0.0f, 2, null);
            Level level = this.getLevel();
            Intrinsics.checkNotNull((Object)level, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerLevel");
            ((ServerLevel)level).sendParticles((ParticleOptions)TBSParticleTypes.NULL_PARTICLE.get(), player4.getX(), player4.getY(), player4.getZ(), 60, 1.5, 1.5, 1.5, 1.0);
            PlayerExt.INSTANCE.getVars((Player)player4).setVhsEnabled(!PlayerExt.INSTANCE.getVars((Player)player4).getVhsEnabled());
            PlayerExt.INSTANCE.getVars((Player)player4).syncTo((Player)player4);
            PlayerExt.INSTANCE.getVars((Player)player4).setSyncTimer(1000L);
            PlayerExt.INSTANCE.updateVars((Player)player4, (Function1<? super PlayerVariables, Unit>)((Function1)ObliterationEntity::baseTick$lambda$1));
            this.discard();
            PlayerExt.INSTANCE.trySetWindowTitle((Player)player4, "You are not welcome here");
            PlayerExt.INSTANCE.trySetWindowed((Player)player4);
            PlayerDesyncManager.desync((ServerPlayer)player4);
        }
        this.refreshDimensions();
        n = this.getDespawnTimer();
        this.setDespawnTimer(n + -1);
        if (this.getDespawnTimer() == 0 && !this.getFlyUp()) {
            this.discard();
        }
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "oblit", 0, ObliterationEntity::registerControllers$lambda$0));
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean causeFallDamage(float l, float d, @NotNull DamageSource source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return false;
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return false;
    }

    public boolean isPushable() {
        return false;
    }

    public boolean isEffectiveAi() {
        return true;
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

    private static final Object tick$lambda$0(ObliterationEntity this$0) {
        if (!ClientVariables.INSTANCE.has(1024L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return false;
            }
            LocalPlayer player = localPlayer;
            if (PlayerExt.INSTANCE.isEntityInFovCone((Player)player, (Entity)this$0, Double.valueOf(((Number)ClientDSLKt.getMC().options.fov().get()).intValue()))) {
                ClientVariables.INSTANCE.set(1024L);
            }
        }
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setLookedAtOblit(true);
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$1(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setLookedAtOblit(false);
        return Unit.INSTANCE;
    }

    private static final PlayState registerControllers$lambda$0(AnimationState it) {
        return it.setAndContinue(RawAnimation.begin().thenPlayAndHold("Triangles"));
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ObliterationEntity.class, "timer", "getTimer()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ObliterationEntity.class, DESPAWN_TIMER, "getDespawnTimer()I", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(ObliterationEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        DATA_FLYUP = entityDataAccessor;
        String string = "none";
        byte[] byArray = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"getBytes(...)");
        UUID uUID = UUID.nameUUIDFromBytes(byArray);
        Intrinsics.checkNotNullExpressionValue((Object)uUID, (String)"nameUUIDFromBytes(...)");
        DEFAULT_UUID = uUID;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/entity/oblit/ObliterationEntity$Companion;", "", "<init>", "()V", "DATA_FLYUP", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "DEFAULT_UUID", "Ljava/util/UUID;", "PERSIST_FLYUP", "", "DESYNC_TIMER", "DESPAWN_TIMER", "CLOSEST_PLAYER", "REQUIRED_LOOK_TICKS", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

