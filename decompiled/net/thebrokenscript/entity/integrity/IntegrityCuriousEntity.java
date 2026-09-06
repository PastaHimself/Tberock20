/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.EntityDataSerializer
 *  net.minecraft.network.syncher.EntityDataSerializers
 *  net.minecraft.network.syncher.SynchedEntityData
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.damagesource.DamageSource
 *  net.minecraft.world.damagesource.DamageTypes
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.entity.base.UwuableMonster
 *  org.jetbrains.annotations.NotNull
 *  software.bernie.geckolib.animation.AnimatableManager$ControllerRegistrar
 */
package net.thebrokenscript.entity.integrity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.PlayerExt;
import net.thebrokenscript.brokencore.api.dsl.EntityDataDelegate;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.entity.base.UwuableMonster;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.AnimatableManager;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 /2\u00020\u0001:\u0001/B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0018\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020\tH\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020\u001dH\u0016J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020.H\u0016R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00118F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R+\u0010\u0018\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00118F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016\u00a8\u00060"}, d2={"Lnet/thebrokenscript/entity/integrity/IntegrityCuriousEntity;", "Lnet/thebrokenscript/brokencore/api/entity/base/UwuableMonster;", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/Level;", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;)V", "<set-?>", "", "seen", "getSeen", "()Z", "setSeen", "(Z)V", "seen$delegate", "Lnet/thebrokenscript/brokencore/api/dsl/EntityDataDelegate;", "", "timer", "getTimer", "()I", "setTimer", "(I)V", "timer$delegate", "despawnTimer", "getDespawnTimer", "setDespawnTimer", "despawnTimer$delegate", "defineSynchedData", "", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "hurt", "source", "Lnet/minecraft/world/damagesource/DamageSource;", "amount", "", "canBeLeashed", "isPushable", "readAdditionalSaveData", "compound", "Lnet/minecraft/nbt/CompoundTag;", "addAdditionalSaveData", "baseTick", "registerControllers", "reg", "Lsoftware/bernie/geckolib/animation/AnimatableManager$ControllerRegistrar;", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nIntegrityCuriousEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntegrityCuriousEntity.kt\nnet/thebrokenscript/entity/integrity/IntegrityCuriousEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,107:1\n1869#2,2:108\n*S KotlinDebug\n*F\n+ 1 IntegrityCuriousEntity.kt\nnet/thebrokenscript/entity/integrity/IntegrityCuriousEntity\n*L\n70#1:108,2\n*E\n"})
public final class IntegrityCuriousEntity
extends UwuableMonster {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final EntityDataDelegate seen$delegate;
    @NotNull
    private final EntityDataDelegate timer$delegate;
    @NotNull
    private final EntityDataDelegate despawnTimer$delegate;
    @NotNull
    private static final EntityDataAccessor<Integer> TIMER;
    @NotNull
    private static final EntityDataAccessor<Boolean> SEEN;
    @NotNull
    private static final EntityDataAccessor<Integer> DESPAWN;

    public IntegrityCuriousEntity(@NotNull EntityType<IntegrityCuriousEntity> type, @NotNull Level level) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        super(type, level);
        this.seen$delegate = this.entityData(SEEN);
        this.timer$delegate = this.entityData(TIMER);
        this.despawnTimer$delegate = this.entityData(DESPAWN);
    }

    public final boolean getSeen() {
        return (Boolean)this.seen$delegate.getValue((BaseMonster)this, $$delegatedProperties[0]);
    }

    public final void setSeen(boolean bl) {
        this.seen$delegate.setValue((BaseMonster)this, $$delegatedProperties[0], (Object)bl);
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

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(TIMER, (Object)10);
        builder.define(SEEN, (Object)false);
        builder.define(DESPAWN, (Object)420);
    }

    public boolean hurt(@NotNull DamageSource source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        return Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.GENERIC_KILL) || Intrinsics.areEqual((Object)source.type(), (Object)DamageTypes.FELL_OUT_OF_WORLD);
    }

    public boolean canBeLeashed() {
        return false;
    }

    public boolean isPushable() {
        return false;
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.readAdditionalSaveData(compound);
        if (compound.contains("timer")) {
            this.setTimer(compound.getInt("timer"));
        }
        if (compound.contains("seen")) {
            this.setSeen(compound.getBoolean("seen"));
        }
        if (compound.contains("despawn")) {
            this.setDespawnTimer(compound.getInt("despawn"));
        }
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        Intrinsics.checkNotNullParameter((Object)compound, (String)"compound");
        super.addAdditionalSaveData(compound);
        Object object = this.entityData.get(TIMER);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        compound.putInt("timer", ((Number)object).intValue());
        Object object2 = this.entityData.get(SEEN);
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"get(...)");
        compound.putBoolean("seen", ((Boolean)object2).booleanValue());
        Object object3 = this.entityData.get(DESPAWN);
        Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"get(...)");
        compound.putInt("despawn", ((Number)object3).intValue());
    }

    public void baseTick() {
        super.baseTick();
        if (!(this.getLevel() instanceof ServerLevel)) {
            return;
        }
        List players = EntityFinder.findPlayersInRange((LevelAccessor)((LevelAccessor)this.getLevel()), (Vec3)this.getPos(), (Number)15);
        if (players.isEmpty()) {
            return;
        }
        Iterable $this$forEach$iv = players;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Player player = (Player)element$iv;
            boolean bl = false;
            if ((!PlayerExt.INSTANCE.isEntityInFovCone(player, (Entity)this, 85.0) || !PlayerExt.INSTANCE.getVars(player).getEnableMoonGlitch()) && !(player.distanceTo((Entity)this) < 9.0f)) continue;
            this.setSeen(true);
        }
        if (this.getSeen()) {
            int n = this.getTimer();
            this.setTimer(n + -1);
        }
        if (this.getTimer() <= 0) {
            this.discard();
        }
        if (this.getDespawnTimer() > 0) {
            int n = this.getDespawnTimer();
            this.setDespawnTimer(n + -1);
            if (this.getDespawnTimer() <= 0) {
                this.discard();
            }
        }
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar reg) {
        Intrinsics.checkNotNullParameter((Object)reg, (String)"reg");
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(IntegrityCuriousEntity.class, "seen", "getSeen()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(IntegrityCuriousEntity.class, "timer", "getTimer()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(IntegrityCuriousEntity.class, "despawnTimer", "getDespawnTimer()I", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        EntityDataAccessor entityDataAccessor = SynchedEntityData.defineId(IntegrityCuriousEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor, (String)"defineId(...)");
        TIMER = entityDataAccessor;
        EntityDataAccessor entityDataAccessor2 = SynchedEntityData.defineId(IntegrityCuriousEntity.class, (EntityDataSerializer)EntityDataSerializers.BOOLEAN);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor2, (String)"defineId(...)");
        SEEN = entityDataAccessor2;
        EntityDataAccessor entityDataAccessor3 = SynchedEntityData.defineId(IntegrityCuriousEntity.class, (EntityDataSerializer)EntityDataSerializers.INT);
        Intrinsics.checkNotNullExpressionValue((Object)entityDataAccessor3, (String)"defineId(...)");
        DESPAWN = entityDataAccessor3;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\b\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/entity/integrity/IntegrityCuriousEntity$Companion;", "", "<init>", "()V", "TIMER", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "getTIMER", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "SEEN", "", "getSEEN", "DESPAWN", "getDESPAWN", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final EntityDataAccessor<Integer> getTIMER() {
            return TIMER;
        }

        @NotNull
        public final EntityDataAccessor<Boolean> getSEEN() {
            return SEEN;
        }

        @NotNull
        public final EntityDataAccessor<Integer> getDESPAWN() {
            return DESPAWN;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

