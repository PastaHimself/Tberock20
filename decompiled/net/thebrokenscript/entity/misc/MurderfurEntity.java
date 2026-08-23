/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.Holder
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.network.protocol.game.ClientboundStopSoundPacket
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.attributes.Attribute
 *  net.minecraft.world.entity.ai.attributes.Attributes
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.LookAtPlayerGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.material.FluidState
 *  net.minecraft.world.level.pathfinder.PathType
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.GeckoUtil
 *  net.thebrokenscript.brokencore.api.dsl.SoundUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoAnimatable
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.animation.AnimationController
 *  software.bernie.geckolib.animation.AnimationState
 *  software.bernie.geckolib.animation.PlayState
 */
package net.thebrokenscript.entity.misc;

import java.util.Optional;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.Holder;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.boss.kerfur.KerfBossMusicPacket;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.GeckoUtil;
import net.thebrokenscript.brokencore.api.dsl.SoundUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.registry.TBSPackets;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.util.CustomGoals;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.animation.PlayState;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0014J \u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020 H\u0016J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'H\u0016J4\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u0005\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010)2\u0006\u00100\u001a\u000201H\u0016\u00a8\u00063"}, d2={"Lnet/thebrokenscript/entity/misc/MurderfurEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "canStandOnFluid", "", "fluidState", "Lnet/minecraft/world/level/material/FluidState;", "registerGoals", "", "getAttributeValue", "", "attribute", "Lnet/minecraft/core/Holder;", "Lnet/minecraft/world/entity/ai/attributes/Attribute;", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "awardKillScore", "killed", "Lnet/minecraft/world/entity/Entity;", "scoreValue", "", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "baseTick", "playHurtSound", "die", "damageSource", "remove", "reason", "Lnet/minecraft/world/entity/Entity$RemovalReason;", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nMurderfurEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MurderfurEntity.kt\nnet/thebrokenscript/entity/misc/MurderfurEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,172:1\n1869#2,2:173\n1869#2,2:175\n*S KotlinDebug\n*F\n+ 1 MurderfurEntity.kt\nnet/thebrokenscript/entity/misc/MurderfurEntity\n*L\n159#1:173,2\n126#1:175,2\n*E\n"})
public final class MurderfurEntity
extends UwuableMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final EntityDataAccessor<Integer> PHASE;

    public MurderfurEntity(@NotNull EntityType<MurderfurEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.setPathfindingMalus(PathType.LAVA, 0.0f);
        this.setPathfindingMalus(PathType.FENCE, 0.0f);
        this.setPathfindingMalus(PathType.RAIL, 0.0f);
        this.setPathfindingMalus(PathType.WATER, 0.0f);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0f);
    }

    public boolean canStandOnFluid(@NotNull FluidState fluidState) {
        Intrinsics.checkNotNullParameter((Object)fluidState, (String)"fluidState");
        return !fluidState.isEmpty();
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, (Goal)new FloatGoal((Mob)this));
        this.goalSelector.addGoal(2, (Goal)new CustomGoals.ContinuousMeleeAttackGoal((PathfinderMob)this, 1.0, 1.5f, 0.0, 8, null));
        this.goalSelector.addGoal(3, (Goal)new LookAtPlayerGoal((Mob)this, Player.class, 400.0f));
        this.targetSelector.addGoal(1, (Goal)new CustomGoals.AlwaysTargetPlayerGoal((Mob)this, Float.valueOf(400.0f)));
    }

    public double getAttributeValue(@NotNull Holder<Attribute> attribute) {
        Intrinsics.checkNotNullParameter(attribute, (String)"attribute");
        if (Intrinsics.areEqual(attribute, (Object)Attributes.MOVEMENT_SPEED)) {
            float f;
            Integer n;
            double orig = super.getAttributeValue(attribute);
            Integer n2 = n = (Integer)this.entityData.get(PHASE);
            int n3 = 1;
            if (n2 != null && n2 == n3) {
                f = 0.75f;
            } else {
                Integer n4 = n;
                n3 = 2;
                if (n4 != null && n4 == n3) {
                    f = 1.0f;
                } else {
                    Integer n5 = n;
                    n3 = 3;
                    f = n5 != null && n5 == n3 ? 1.5f : 0.75f;
                }
            }
            float mapping = f;
            return orig * (double)mapping;
        }
        if (Intrinsics.areEqual(attribute, (Object)Attributes.ATTACK_DAMAGE)) {
            float f;
            Integer n;
            double orig = super.getAttributeValue(attribute);
            Integer n6 = n = (Integer)this.entityData.get(PHASE);
            int n7 = 1;
            if (n6 != null && n6 == n7) {
                f = 1.0f;
            } else {
                Integer n8 = n;
                n7 = 2;
                if (n8 != null && n8 == n7) {
                    f = 2.0f;
                } else {
                    Integer n9 = n;
                    n7 = 3;
                    f = n9 != null && n9 == n7 ? 5.0f : 0.75f;
                }
            }
            float mapping = f;
            return orig * (double)mapping;
        }
        return super.getAttributeValue(attribute);
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
        reg.add(new AnimationController((GeoAnimatable)this, "murderfur", 0, arg_0 -> MurderfurEntity.registerControllers$lambda$0(this, arg_0)));
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(PHASE, (Object)1);
    }

    public void awardKillScore(@NotNull Entity killed, int scoreValue, @NotNull DamageSource source) {
        Intrinsics.checkNotNullParameter((Object)killed, (String)"killed");
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        super.awardKillScore(killed, scoreValue, source);
        if (this.getLevel().isClientSide) {
            return;
        }
        ServerPlayer serverPlayer = (ServerPlayer)killed;
        Optional optional = Optional.empty();
        Intrinsics.checkNotNullExpressionValue(optional, (String)"empty(...)");
        PacketSender.INSTANCE.sendToPlayer(serverPlayer, (CustomPacketPayload)TBSPackets.KERF_BOSS_MUSIC.of(optional), new CustomPacketPayload[0]);
    }

    public void baseTick() {
        this.onServerTick(arg_0 -> MurderfurEntity.baseTick$lambda$0(this, arg_0));
    }

    protected void playHurtSound(@NotNull DamageSource source) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        SoundUtil.tryPlaySound$default((Level)this.getLevel(), (Vec3)this.getPos(), (SoundEvent)((SoundEvent)TBSSounds.KERFUR_MEOW.get()), (float)0.0f, (float)Mth.nextFloat((RandomSource)this.random, (float)0.9f, (float)1.2f), null, (int)20, null);
    }

    public void die(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        super.die(damageSource);
        if (this.getLevel().isClientSide) {
            return;
        }
        Optional optional = Optional.empty();
        Intrinsics.checkNotNullExpressionValue(optional, (String)"empty(...)");
        PacketSender.INSTANCE.sendToAllPlayers((CustomPacketPayload)TBSPackets.KERF_BOSS_MUSIC.of(optional), new CustomPacketPayload[0]);
    }

    public void remove(@NotNull Entity.RemovalReason reason) {
        Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
        super.remove(reason);
        if (this.getLevel().isClientSide) {
            return;
        }
        Optional optional = Optional.empty();
        Intrinsics.checkNotNullExpressionValue(optional, (String)"empty(...)");
        PacketSender.INSTANCE.sendToAllPlayers((CustomPacketPayload)TBSPackets.KERF_BOSS_MUSIC.of(optional), new CustomPacketPayload[0]);
    }

    @Nullable
    public SpawnGroupData onFinalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, @Nullable SpawnGroupData spawnData, @NotNull CancelProxy event) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)difficulty, (String)"difficulty");
        Intrinsics.checkNotNullParameter((Object)spawnType, (String)"spawnType");
        Intrinsics.checkNotNullParameter((Object)event, (String)"event");
        Optional<Integer> optional = Optional.of(1);
        Intrinsics.checkNotNullExpressionValue(optional, (String)"of(...)");
        KerfBossMusicPacket packet = (KerfBossMusicPacket)TBSPackets.KERF_BOSS_MUSIC.of(optional);
        Iterable $this$forEach$iv = EntityFinder.findPlayersInRange((ServerLevelAccessor)level, (Vec3)this.getPos(), (Number)Float.valueOf(400.0f));
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerPlayer it = (ServerPlayer)element$iv;
            boolean bl = false;
            it.connection.send((Packet)new ClientboundStopSoundPacket(null, null));
            PacketSender.INSTANCE.sendToPlayer(it, (CustomPacketPayload)packet, new CustomPacketPayload[0]);
        }
        return null;
    }

    private static final PlayState registerControllers$lambda$0(MurderfurEntity this$0, AnimationState it) {
        if (it.isMoving()) {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"walk");
        } else {
            Entity entity = (Entity)this$0;
            AnimationController animationController = it.getController();
            Intrinsics.checkNotNullExpressionValue((Object)animationController, (String)"getController(...)");
            GeckoUtil.loop((Entity)entity, (AnimationController)animationController, (String)"idle");
        }
        return PlayState.CONTINUE;
    }

    private static final Unit baseTick$lambda$0(MurderfurEntity this$0, ServerLevel it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Integer cur = (Integer)this$0.entityData.get(PHASE);
        Integer n = cur;
        int n2 = 1;
        if (n != null && n == n2 && this$0.getHealth() <= 666.0f) {
            this$0.entityData.set(PHASE, (Object)2);
        } else {
            Integer n3 = cur;
            n2 = 2;
            if (n3 != null && n3 == n2 && this$0.getHealth() <= 333.0f) {
                this$0.entityData.set(PHASE, (Object)3);
            }
        }
        if (!Intrinsics.areEqual((Object)cur, (Object)this$0.entityData.get(PHASE))) {
            Optional<Object> optional = Optional.of(this$0.entityData.get(PHASE));
            Intrinsics.checkNotNullExpressionValue(optional, (String)"of(...)");
            KerfBossMusicPacket packet = (KerfBossMusicPacket)TBSPackets.KERF_BOSS_MUSIC.of(optional);
            Iterable $this$forEach$iv = EntityFinder.findPlayersInRange((ServerLevel)it, (Vec3)this$0.getPos(), (Number)Float.valueOf(400.0f));
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                ServerPlayer p = (ServerPlayer)element$iv;
                boolean bl = false;
                PacketSender.INSTANCE.sendToPlayer(p, (CustomPacketPayload)packet, new CustomPacketPayload[0]);
            }
        }
        return Unit.INSTANCE;
    }

    static {
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(MurderfurEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        PHASE = entityDataAccessor;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/entity/misc/MurderfurEntity$Companion;", "", "<init>", "()V", "PHASE", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "getPHASE", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final EntityDataAccessor<Integer> getPHASE() {
            return PHASE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

