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
 *  net.minecraft.network.chat.Component
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.sounds.SoundEvent
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.PathfinderMob
 *  net.minecraft.world.entity.SpawnGroupData
 *  net.minecraft.world.entity.ai.goal.FloatGoal
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.MeleeAttackGoal
 *  net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal
 *  net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ChatUtil
 *  net.thebrokenscript.brokencore.api.dsl.ClientDSLKt
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.SideUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.entity.nullent;

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
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.ChatUtil;
import net.thebrokenscript.brokencore.api.dsl.ClientDSLKt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.PersistentDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.SideUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.client.data.ClientVariables;
import net.thebrokenscript.registry.TBSLang;
import net.thebrokenscript.registry.TBSSounds;
import net.thebrokenscript.util.RepTier;
import net.thebrokenscript.util.RepUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0014J\n\u0010 \u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010!\u001a\u00020\u0015H\u0016J4\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0005\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010#2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\nH\u0016J\b\u0010-\u001a\u00020\nH\u0016J\u0010\u0010.\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\b\u0010/\u001a\u00020\u0015H\u0016R+\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u00061"}, d2={"Lnet/thebrokenscript/entity/nullent/NullEndgameEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "Lnet/thebrokenscript/brokencore/api/entity/FinalizedSpawn;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "registerGoals", "", "<set-?>", "", "despawnTimer", "getDespawnTimer", "()I", "setDespawnTimer", "(I)V", "despawnTimer$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/PersistentDataDelegate;", "removeWhenFarAway", "", "distanceToClosestPlayer", "", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "getHurtSound", "Lnet/minecraft/sounds/SoundEvent;", "damageSource", "getDeathSound", "fireImmune", "onFinalizeSpawn", "Lnet/minecraft/world/entity/SpawnGroupData;", "Lnet/minecraft/world/level/ServerLevelAccessor;", "difficulty", "Lnet/minecraft/world/DifficultyInstance;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "spawnData", "event", "Lnet/thebrokenscript/brokencore/api/platform/CancelProxy;", "baseTick", "tick", "die", "isPushedByFluid", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nNullEndgameEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NullEndgameEntity.kt\nnet/thebrokenscript/entity/nullent/NullEndgameEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,150:1\n1869#2,2:151\n*S KotlinDebug\n*F\n+ 1 NullEndgameEntity.kt\nnet/thebrokenscript/entity/nullent/NullEndgameEntity\n*L\n76#1:151,2\n*E\n"})
public final class NullEndgameEntity
extends BaseMonster
implements FinalizedSpawn {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final PersistentDataDelegate despawnTimer$delegate;
    @NotNull
    private static final String DESPAWN_TIMER = "despawnTimer";

    public NullEndgameEntity(@NotNull EntityType<NullEndgameEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.xpReward = 0;
        this.setNoAi(false);
        this.setPersistenceRequired();
        this.despawnTimer$delegate = this.persistentInt(DESPAWN_TIMER);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, (Goal)new NearestAttackableTargetGoal((Mob)this, Player.class, false, false));
        this.goalSelector.addGoal(2, (Goal)new MeleeAttackGoal((PathfinderMob)this, 1.2, false));
        this.targetSelector.addGoal(3, (Goal)new HurtByTargetGoal((PathfinderMob)this, new Class[0]));
        this.goalSelector.addGoal(4, (Goal)new FloatGoal((Mob)this));
    }

    public final int getDespawnTimer() {
        return ((Number)this.despawnTimer$delegate.getValue((BaseMonster)this, $$delegatedProperties[0])).intValue();
    }

    public final void setDespawnTimer(int n) {
        this.despawnTimer$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)n);
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return source.getDirectEntity() instanceof Player || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD) ? super.hurt(source, amount) : false;
    }

    @Nullable
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        return null;
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return null;
    }

    public boolean fireImmune() {
        return true;
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
        Iterable $this$forEach$iv = EntityFinder.findPlayersInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)50);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerPlayer player = (ServerPlayer)element$iv;
            boolean bl = false;
            if (!player.hasLineOfSight((Entity)this)) continue;
            PlayerExt playerExt = PlayerExt.INSTANCE;
            SoundEvent soundEvent = (SoundEvent)TBSSounds.NULL_JUMPSCARE_LOUD.invoke();
            PlayerExt.tryPlayHostile$default(playerExt, (Player)player, soundEvent, false, 0.09f, 0.65f, 0.25f, 2, null);
        }
        ChatUtil.chat$default((LevelAccessor)((LevelAccessor)level), (Component)((Component)TBSLang.INSTANCE.getNULL_ENDGAME_CHAT_1()), (boolean)false, (int)2, null);
        ChatUtil.chat$default((LevelAccessor)((LevelAccessor)level), (Component)((Component)TBSLang.INSTANCE.getNULL_ENDGAME_CHAT_2()), (boolean)false, (int)2, null);
        ServerPlayer serverPlayer = EntityFinder.findClosestPlayerInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)500);
        if (serverPlayer == null) {
            return null;
        }
        ServerPlayer player = serverPlayer;
        this.lookAt(EntityAnchorArgument.Anchor.EYES, player.position().add(0.0, 1.0, 0.0));
        player.lookAt(EntityAnchorArgument.Anchor.EYES, this.getPos().add(0.0, (double)this.getEyeHeight(), 0.0));
        this.setDespawnTimer(420);
        return null;
    }

    public void baseTick() {
        super.baseTick();
        Level level = this.level();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        ChatUtil.chat$default((LevelAccessor)((LevelAccessor)level), (Component)((Component)TBSLang.INSTANCE.getNULL_ENDGAME_CHAT_1()), (boolean)false, (int)2, null);
        ChatUtil.chat$default((LevelAccessor)((LevelAccessor)level), (Component)((Component)TBSLang.INSTANCE.getNULL_ENDGAME_CHAT_2()), (boolean)false, (int)2, null);
        ServerPlayer serverPlayer = EntityFinder.findClosestPlayerInRange((ServerLevel)((ServerLevel)level), (Vec3)this.getPos(), (Number)500.0);
        if (serverPlayer == null) {
            return;
        }
        ServerPlayer player = serverPlayer;
        this.lookControl.setLookAt((Entity)player);
        if (this.tickCount % 60 == 0) {
            player.hurt(this.damageSources().mobAttack((LivingEntity)this), 999.0f);
        }
        int n = this.getDespawnTimer();
        this.setDespawnTimer(n + -1);
        if (this.getDespawnTimer() <= 0) {
            this.discard();
        }
    }

    public void tick() {
        super.tick();
        SideUtil.clientSide((Entity)((Entity)this), () -> NullEndgameEntity.tick$lambda$0(this));
    }

    public void die(@NotNull DamageSource damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        Entity entity = damageSource.getEntity();
        if (entity instanceof ServerPlayer) {
            RepUtilKt.applyRep((Player)entity, RepTier.LOSS_IHY);
        }
        super.die(damageSource);
    }

    public boolean isPushedByFluid() {
        return false;
    }

    private static final Object tick$lambda$0(NullEndgameEntity this$0) {
        if (!ClientVariables.INSTANCE.has(16L)) {
            LocalPlayer localPlayer = ClientDSLKt.getMC().player;
            if (localPlayer == null) {
                return false;
            }
            LocalPlayer player = localPlayer;
            if (PlayerExt.INSTANCE.isEntityInFovCone((Player)player, (Entity)this$0, Double.valueOf(((Number)ClientDSLKt.getMC().options.fov().get()).intValue()))) {
                ClientVariables.INSTANCE.set(16L);
            }
        }
        return Unit.INSTANCE;
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(NullEndgameEntity.class, DESPAWN_TIMER, "getDespawnTimer()I", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/entity/nullent/NullEndgameEntity$Companion;", "", "<init>", "()V", "DESPAWN_TIMER", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

