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
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty
 *  net.minecraft.client.player.LocalPlayer
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.chat.Component
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.control.LookControl
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.PlayerUtil
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
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
package net.thebrokenscript.entity.oblit;

import java.lang.invoke.LambdaMetafactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.PlayerUtil;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.data.PlayerVariables;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001TB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010!\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020&H\u0016J\u0006\u0010.\u001a\u00020/J4\u00100\u001a\u0004\u0018\u0001012\u0006\u0010\u0005\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020$2\b\u00106\u001a\u0004\u0018\u0001012\u0006\u00107\u001a\u000208H\u0016J\b\u0010?\u001a\u00020&H\u0016J\u0010\u0010@\u001a\u00020&2\u0006\u0010#\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020GH\u0016J \u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020MH\u0016J\u0018\u0010N\u001a\u00020\n2\u0006\u0010L\u001a\u00020M2\u0006\u0010O\u001a\u00020JH\u0016J\b\u0010P\u001a\u00020\nH\u0016J\b\u0010Q\u001a\u00020/H\u0016J\u0010\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020GH\u0016R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR+\u0010\u001d\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b \u0010\u0011\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020;0:X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006U"}, d2={"Lnet/thebrokenscript/entity/oblit/Obliteration2Entity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "<set-?>", "", "spawning", "getSpawning", "()Z", "setSpawning", "(Z)V", "spawning$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "", "spawnTimer", "getSpawnTimer", "()I", "setSpawnTimer", "(I)V", "spawnTimer$delegate", "despawn", "getDespawn", "setDespawn", "despawn$delegate", "despawnTimer", "getDespawnTimer", "setDespawnTimer", "despawnTimer$delegate", "checkSpawnRules", "Lnet/minecraft/world/level/LevelAccessor;", "reason", "Lnet/minecraft/world/entity/MobSpawnType;", "addAdditionalSaveData", "", "compound", "Lnet/minecraft/nbt/CompoundTag;", "readAdditionalSaveData", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "tick", "underneathBox", "Lnet/minecraft/world/phys/AABB;", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "uuidList", "", "Ljava/util/UUID;", "hideTimer", "wanderTarget", "Lnet/minecraft/world/phys/Vec3;", "baseTick", "remove", "Lnet/minecraft/world/entity/Entity$RemovalReason;", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "removeWhenFarAway", "distanceToClosestPlayer", "", "causeFallDamage", "l", "", "d", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "hurt", "amount", "isPushable", "getBoundingBoxForCulling", "shouldRenderAtSqrDistance", "dist", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nObliteration2Entity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Obliteration2Entity.kt\nnet/thebrokenscript/entity/oblit/Obliteration2Entity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,315:1\n295#2,2:316\n1869#2:318\n1870#2:320\n1869#2,2:321\n1869#2,2:323\n15#3:319\n*S KotlinDebug\n*F\n+ 1 Obliteration2Entity.kt\nnet/thebrokenscript/entity/oblit/Obliteration2Entity\n*L\n174#1:316,2\n230#1:318\n230#1:320\n258#1:321,2\n270#1:323,2\n251#1:319\n*E\n"})
public final class Obliteration2Entity
extends UwuableMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate spawning$delegate;
    @NotNull
    private final EntityDataDelegate spawnTimer$delegate;
    @NotNull
    private final EntityDataDelegate despawn$delegate;
    @NotNull
    private final EntityDataDelegate despawnTimer$delegate;
    @NotNull
    private List<UUID> uuidList;
    private int hideTimer;
    @Nullable
    private Vec3 wanderTarget;
    @NotNull
    private static final EntityDataAccessor<Boolean> SPAWNING;
    @NotNull
    private static final EntityDataAccessor<Integer> SPAWNING_TIMER;
    @NotNull
    private static final EntityDataAccessor<Boolean> DESPAWN;
    @NotNull
    private static final EntityDataAccessor<Integer> DESPAWN_TIMER;

    public Obliteration2Entity(@NotNull EntityType<Obliteration2Entity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.lookControl = new LookControl(this){

            public void tick() {
            }
        };
        this.spawning$delegate = this.entityData(SPAWNING);
        this.spawnTimer$delegate = this.entityData(SPAWNING_TIMER);
        this.despawn$delegate = this.entityData(DESPAWN);
        this.despawnTimer$delegate = this.entityData(DESPAWN_TIMER);
        this.uuidList = new ArrayList();
    }

    public final boolean getSpawning() {
        return (Boolean)this.spawning$delegate.getValue((BaseMonster)this, $$delegatedProperties[0]);
    }

    public final void setSpawning(boolean bl) {
        this.spawning$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)bl);
    }

    public final int getSpawnTimer() {
        return ((Number)this.spawnTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[1])).intValue();
    }

    public final void setSpawnTimer(int n) {
        this.spawnTimer$delegate.setValue((BaseMonster)this, $$delegatedProperties[1], (Object)n);
    }

    public final boolean getDespawn() {
        return (Boolean)this.despawn$delegate.getValue((BaseMonster)this, $$delegatedProperties[2]);
    }

    public final void setDespawn(boolean bl) {
        this.despawn$delegate.setValue((BaseMonster)this, $$delegatedProperties[2], (Object)bl);
    }

    public final int getDespawnTimer() {
        return ((Number)this.despawnTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[3])).intValue();
    }

    public final void setDespawnTimer(int n) {
        this.despawnTimer$delegate.setValue((BaseMonster)this, $$delegatedProperties[3], (Object)n);
    }

    public boolean checkSpawnRules(@NotNull LevelAccessor level, @NotNull MobSpawnType reason) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
        return true;
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        Object object = this.entityData.get(SPAWNING);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        compound.putBoolean("spawning", ((Boolean)object).booleanValue());
        Object object2 = this.entityData.get(DESPAWN);
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"get(...)");
        compound.putBoolean("despawning", ((Boolean)object2).booleanValue());
        Object object3 = this.entityData.get(SPAWNING_TIMER);
        Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"get(...)");
        compound.putInt("spawning_timer", ((Number)object3).intValue());
        Object object4 = this.entityData.get(DESPAWN_TIMER);
        Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"get(...)");
        compound.putInt("despawn_timer", ((Number)object4).intValue());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        if (compound.contains("spawning")) {
            this.setSpawning(compound.getBoolean("spawning"));
        }
        if (compound.contains("spawning_timer")) {
            this.setSpawnTimer(compound.getInt("spawning_timer"));
        }
        if (compound.contains("despawning")) {
            this.setDespawn(compound.getBoolean("despawning"));
        }
        if (compound.contains("despawn_timer")) {
            this.setDespawnTimer(compound.getInt("despawn_timer"));
        }
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(SPAWNING, (Object)true);
        builder.define(SPAWNING_TIMER, (Object)110);
        builder.define(DESPAWN, (Object)false);
        builder.define(DESPAWN_TIMER, (Object)4200);
    }

    public void tick() {
        super.tick();
        SideUtil.clientSide((Entity)((Entity)this), () -> Obliteration2Entity.tick$lambda$0(this));
    }

    @NotNull
    public final AABB underneathBox() {
        AABB box = this.getBoundingBox();
        return new AABB(box.minX, (double)this.getLevel().getMinBuildHeight(), box.minZ, box.maxX, box.minY, box.maxZ);
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        return null;
    }

    /*
     * Unable to fully structure code
     */
    public void baseTick() {
        block30: {
            block34: {
                block33: {
                    block31: {
                        block32: {
                            super.baseTick();
                            if (!(this.getLevel() instanceof ServerLevel)) break block30;
                            if (this.getDespawnTimer() > 0) {
                                if (this.getDespawnTimer() < 40) {
                                    this.setDespawn(true);
                                }
                                var1_1 = this.getDespawnTimer();
                                this.setDespawnTimer(var1_1 + -1);
                            } else {
                                this.discard();
                            }
                            if (this.getDespawn()) {
                                return;
                            }
                            if (this.getSpawnTimer() > 0) {
                                var1_1 = this.getSpawnTimer();
                                this.setSpawnTimer(var1_1 + -1);
                            } else if (this.getSpawning()) {
                                this.setSpawning(false);
                            }
                            if (this.getSpawnTimer() > 45) {
                                return;
                            }
                            surfaceHeight = this.getLevel().getHeight(Heightmap.Types.WORLD_SURFACE, this.getBlockX(), this.getBlockZ());
                            this.setDeltaMovement(this.getBlockY() - surfaceHeight < 65 ? new Vec3(this.getDeltaMovement().x, 0.35, this.getDeltaMovement().z) : new Vec3(this.getDeltaMovement().x, 0.0, this.getDeltaMovement().z));
                            v0 = this.getTarget();
                            v1 = v0 != null ? v0.isRemoved() : false;
                            if (v1) {
                                this.setTarget(null);
                                this.hideTimer = 0;
                            }
                            if (this.getTarget() == null) {
                                block29: {
                                    $this$firstOrNull$iv = EntityFinder.findPlayersInRange((LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)this.getPos(), (Number)320);
                                    $i$f$firstOrNull = false;
                                    for (T element$iv : $this$firstOrNull$iv) {
                                        it = (Player)element$iv;
                                        $i$a$-firstOrNull-Obliteration2Entity$baseTick$spotted$1 = false;
                                        if (!PlayerExt.INSTANCE.isEntityInFovCone(it, (Entity)this, 75.0)) continue;
                                        v2 = element$iv;
                                        break block29;
                                    }
                                    v2 = null;
                                }
                                spotted = v2;
                                if (spotted != null) {
                                    this.setTarget((LivingEntity)spotted);
                                    this.wanderTarget = null;
                                }
                                this.hideTimer = 0;
                            }
                            v3 = this.getTarget();
                            if (v3 == null) break block31;
                            player = v3;
                            $i$a$-let-Obliteration2Entity$baseTick$1 = false;
                            if (!(player instanceof ServerPlayer)) break block31;
                            if (!BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)this), (Player)((Player)player))) break block32;
                            this.hideTimer = 0;
                            ** GOTO lbl-1000
                        }
                        element$iv = this.hideTimer;
                        this.hideTimer = element$iv + 1;
                        if (this.hideTimer > 100) {
                            this.setTarget(null);
                            this.hideTimer = 0;
                        } else lbl-1000:
                        // 2 sources

                        {
                            dx = ((ServerPlayer)player).getX() - this.getX();
                            dz = ((ServerPlayer)player).getZ() - this.getZ();
                            horizDist = Math.sqrt(dx * dx + dz * dz);
                            if (horizDist > 2.0) {
                                speed = 0.6;
                                this.setDeltaMovement(new Vec3(dx / horizDist * speed, this.getDeltaMovement().y, dz / horizDist * speed));
                            } else {
                                this.setTarget(null);
                                this.hideTimer = 0;
                            }
                        }
                    }
                    if (this.getTarget() != null) break block30;
                    if (this.wanderTarget == null) break block33;
                    v4 = this.wanderTarget;
                    Intrinsics.checkNotNull((Object)v4);
                    if (!(this.distanceToSqr(v4) < 9.0)) break block34;
                }
                angle = this.random.nextDouble() * 3.141592653589793 * (double)2;
                dist = 75.0 + this.random.nextDouble() * 75.0;
                this.wanderTarget = new Vec3(this.getX() + Math.cos(angle) * dist, this.getY(), this.getZ() + Math.sin(angle) * dist);
            }
            v5 = this.wanderTarget;
            if (v5 != null) {
                point = v5;
                $i$a$-let-Obliteration2Entity$baseTick$2 = false;
                dx = point.x - this.getX();
                horizDist = Math.sqrt(dx * dx + (dz = point.z - this.getZ()) * dz);
                if (horizDist > 2.0) {
                    speed = 0.4;
                    this.setDeltaMovement(new Vec3(dx / horizDist * speed, this.getDeltaMovement().y, dz / horizDist * speed));
                }
            }
        }
        playersUnderneath = this.getLevel().getEntitiesOfClass(Player.class, this.underneathBox());
        Intrinsics.checkNotNull((Object)playersUnderneath);
        if (((Collection)playersUnderneath).isEmpty() == false) {
            $this$forEach$iv = playersUnderneath;
            $i$f$forEach = false;
            for (T element$iv : $this$forEach$iv) {
                player = (Player)element$iv;
                $i$a$-forEach-Obliteration2Entity$baseTick$3 = false;
                v6 = (BaseMonster)this;
                Intrinsics.checkNotNull((Object)player);
                if (!BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)v6, (Player)player)) continue;
                if (!this.uuidList.contains(player.getUUID())) {
                    v7 = player.getUUID();
                    Intrinsics.checkNotNullExpressionValue((Object)v7, (String)"getUUID(...)");
                    this.uuidList.add(v7);
                }
                if (!PlayerExt.INSTANCE.getVars(player).getGlitchesEnabled()) {
                    PlayerExt.INSTANCE.updateVars(player, (Function1<? super PlayerVariables, Unit>)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, baseTick$lambda$3$0(net.thebrokenscript.data.PlayerVariables ), (Lnet/thebrokenscript/data/PlayerVariables;)Lkotlin/Unit;)());
                }
                dz = PlayerExt.INSTANCE.getVars(player);
                dz = dz.getTriangleKickTimer();
                dz.setTriangleKickTimer(dz + 1);
                if (PlayerExt.INSTANCE.getVars(player).getTriangleKickTimer() <= 100) continue;
                PlayerExt.INSTANCE.syncVars(player);
                PlayerExt.INSTANCE.updateVars(player, (Function1<? super PlayerVariables, Unit>)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, baseTick$lambda$3$1(net.thebrokenscript.data.PlayerVariables ), (Lnet/thebrokenscript/data/PlayerVariables;)Lkotlin/Unit;)());
                if (!(player instanceof ServerPlayer)) continue;
                if (this.getDespawnTimer() > 40) {
                    this.setDespawnTimer(40);
                }
                v8 = (ServerPlayer)player;
                $this$c$iv = "";
                $i$f$getC = false;
                v9 = Component.nullToEmpty((String)$this$c$iv);
                Intrinsics.checkNotNullExpressionValue((Object)v9, (String)"nullToEmpty(...)");
                PlayerUtil.kick((ServerPlayer)v8, (Component)v9);
            }
        }
        $this$forEach$iv = this.uuidList;
        $i$f$forEach = false;
        for (T element$iv : $this$forEach$iv) {
            uuid = (UUID)element$iv;
            $i$a$-forEach-Obliteration2Entity$baseTick$4 = false;
            player = this.getLevel().getPlayerByUUID(uuid);
            if (player == null || !PlayerExt.INSTANCE.getVars(player).getGlitchesEnabled() || playersUnderneath.contains(player)) continue;
            PlayerExt.INSTANCE.updateVars(player, (Function1<? super PlayerVariables, Unit>)(Function1)LambdaMetafactory.metafactory(null, null, null, (Ljava/lang/Object;)Ljava/lang/Object;, baseTick$lambda$4$0(net.thebrokenscript.data.PlayerVariables ), (Lnet/thebrokenscript/data/PlayerVariables;)Lkotlin/Unit;)());
        }
    }

    public void remove(@NotNull Entity.RemovalReason reason) {
        Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
        Iterable $this$forEach$iv = this.uuidList;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Player player;
            UUID uuid = (UUID)element$iv;
            boolean bl = false;
            if (this.getLevel().getPlayerByUUID(uuid) == null) continue;
            boolean bl2 = false;
            PlayerExt.INSTANCE.updateVars(player, (Function1<? super PlayerVariables, Unit>)((Function1)Obliteration2Entity::remove$lambda$0$0$0));
            PlayerExt.INSTANCE.updateVars(player, (Function1<? super PlayerVariables, Unit>)((Function1)Obliteration2Entity::remove$lambda$0$0$1));
        }
        super.remove(reason);
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "obliteration2", 0, arg_0 -> Obliteration2Entity.registerControllers$lambda$0(this, arg_0)));
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

    @NotNull
    public AABB getBoundingBoxForCulling() {
        AABB aABB = super.getBoundingBoxForCulling().inflate(32.0);
        Intrinsics.checkNotNullExpressionValue((Object)aABB, (String)"inflate(...)");
        return aABB;
    }

    public boolean shouldRenderAtSqrDistance(double dist) {
        return true;
    }

    private static final Object tick$lambda$0(Obliteration2Entity this$0) {
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

    private static final Unit baseTick$lambda$3$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setGlitchesEnabled(true);
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$3$1(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setTriangleKickTimer(0);
        return Unit.INSTANCE;
    }

    private static final Unit baseTick$lambda$4$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setGlitchesEnabled(false);
        return Unit.INSTANCE;
    }

    private static final Unit remove$lambda$0$0$0(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setTriangleKickTimer(0);
        return Unit.INSTANCE;
    }

    private static final Unit remove$lambda$0$0$1(PlayerVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"$this$updateVars");
        $this$updateVars.setGlitchesEnabled(false);
        return Unit.INSTANCE;
    }

    private static final PlayState registerControllers$lambda$0(Obliteration2Entity this$0, AnimationState it) {
        AnimationController ctrl = it.getController();
        if (this$0.getDespawn()) {
            Entity entity = (Entity)this$0;
            Intrinsics.checkNotNull((Object)ctrl);
            GeckoUtil.hold((Entity)entity, (AnimationController)ctrl, (String)"despawn");
        } else if (this$0.getSpawning()) {
            Entity entity = (Entity)this$0;
            Intrinsics.checkNotNull((Object)ctrl);
            GeckoUtil.hold((Entity)entity, (AnimationController)ctrl, (String)"spawn");
        } else {
            Entity entity = (Entity)this$0;
            Intrinsics.checkNotNull((Object)ctrl);
            GeckoUtil.loop((Entity)entity, (AnimationController)ctrl, (String)"spinidle");
        }
        return PlayState.CONTINUE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(Obliteration2Entity.class, "spawning", "getSpawning()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(Obliteration2Entity.class, "spawnTimer", "getSpawnTimer()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(Obliteration2Entity.class, "despawn", "getDespawn()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(Obliteration2Entity.class, "despawnTimer", "getDespawnTimer()I", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(Obliteration2Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        SPAWNING = entityDataAccessor;
        EntityDataAccessor entityDataAccessor2 = SynchedEntityData.defineId(Obliteration2Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor2, (String)"defineId(...)");
        SPAWNING_TIMER = entityDataAccessor2;
        EntityDataAccessor entityDataAccessor3 = SynchedEntityData.defineId(Obliteration2Entity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor3, (String)"defineId(...)");
        DESPAWN = entityDataAccessor3;
        EntityDataAccessor entityDataAccessor4 = SynchedEntityData.defineId(Obliteration2Entity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor4, (String)"defineId(...)");
        DESPAWN_TIMER = entityDataAccessor4;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/entity/oblit/Obliteration2Entity$Companion;", "", "<init>", "()V", "SPAWNING", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "SPAWNING_TIMER", "", "DESPAWN", "DESPAWN_TIMER", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

