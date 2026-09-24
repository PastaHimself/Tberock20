/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  net.minecraft.client.animation.AnimationDefinition
 *  net.minecraft.network.syncher.EntityDataAccessor
 *  net.minecraft.network.syncher.SynchedEntityData$Builder
 *  net.minecraft.world.entity.AnimationState
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.monster.Monster
 *  net.minecraft.world.level.Level
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.entity.anim;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B-\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0014J\u0014\u0010-\u001a\u00020)2\n\u0010.\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\u001d\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00020\u0016H\u0004\u00a2\u0006\u0002\u00102R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R,\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u0013X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u00000\u001aX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u001e\u0010\u001c\u001a\u0004\u0018\u00018\u0000X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R,\u0010\"\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u00138@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010\u0018R(\u0010%\u001a\u0004\u0018\u00018\u00002\b\u0010$\u001a\u0004\u0018\u00018\u00008F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b&\u0010\u001e\"\u0004\b'\u0010 \u00a8\u00063"}, d2={"Lnet/thebrokenscript/brokencore/api/entity/anim/AnimatedMonster;", "S", "", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "entityType", "Lnet/minecraft/world/entity/EntityType;", "Lnet/minecraft/world/entity/monster/Monster;", "level", "Lnet/minecraft/world/level/Level;", "stateEnumValues", "", "<init>", "(Lnet/minecraft/world/entity/EntityType;Lnet/minecraft/world/level/Level;[Ljava/lang/Enum;)V", "animStateKey", "Lnet/minecraft/network/syncher/EntityDataAccessor;", "", "getAnimStateKey", "()Lnet/minecraft/network/syncher/EntityDataAccessor;", "animations", "", "Lkotlin/Pair;", "Lnet/minecraft/world/entity/AnimationState;", "Lnet/minecraft/client/animation/AnimationDefinition;", "getAnimations", "()Ljava/util/Map;", "stateEnumMap", "", "getStateEnumMap", "currentAnimState", "getCurrentAnimState", "()Ljava/lang/Enum;", "setCurrentAnimState", "(Ljava/lang/Enum;)V", "Ljava/lang/Enum;", "internalAnims", "getInternalAnims$brokencore_common", "value", "animState", "getAnimState", "setAnimState", "stopAnimations", "", "defineSynchedData", "builder", "Lnet/minecraft/network/syncher/SynchedEntityData$Builder;", "onSyncedDataUpdated", "key", "state", "id", "def", "(Ljava/lang/Enum;Lnet/minecraft/client/animation/AnimationDefinition;)Lnet/minecraft/world/entity/AnimationState;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nAnimatedMonster.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimatedMonster.kt\nnet/thebrokenscript/brokencore/api/entity/anim/AnimatedMonster\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,61:1\n9037#2,2:62\n9297#2,4:64\n1#3:68\n216#4,2:69\n*S KotlinDebug\n*F\n+ 1 AnimatedMonster.kt\nnet/thebrokenscript/brokencore/api/entity/anim/AnimatedMonster\n*L\n18#1:62,2\n18#1:64,4\n31#1:69,2\n*E\n"})
public abstract class AnimatedMonster<S extends Enum<S>>
extends BaseMonster {
    @NotNull
    private final Map<S, Pair<AnimationState, AnimationDefinition>> animations;
    @NotNull
    private final Map<Integer, S> stateEnumMap;
    @Nullable
    private S currentAnimState;

    /*
     * WARNING - void declaration
     */
    public AnimatedMonster(@NotNull EntityType<? extends Monster> entityType, @NotNull Level level, @NotNull S[] stateEnumValues) {
        void $this$associateByTo$iv$iv;
        void $this$associateBy$iv;
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(stateEnumValues, (String)"stateEnumValues");
        super(entityType, level);
        this.animations = new LinkedHashMap();
        S[] SArray = stateEnumValues;
        AnimatedMonster animatedMonster = this;
        boolean $i$f$associateBy = false;
        int capacity$iv = RangesKt.coerceAtLeast((int)MapsKt.mapCapacity((int)((void)$this$associateBy$iv).length), (int)16);
        void var7_8 = $this$associateBy$iv;
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        boolean $i$f$associateByTo = false;
        int n = ((void)$this$associateByTo$iv$iv).length;
        for (int i = 0; i < n; ++i) {
            void it;
            void element$iv$iv;
            void var13_14 = element$iv$iv = $this$associateByTo$iv$iv[i];
            Map map = destination$iv$iv;
            boolean bl = false;
            map.put(it.ordinal(), element$iv$iv);
        }
        animatedMonster.stateEnumMap = destination$iv$iv;
    }

    @NotNull
    public abstract EntityDataAccessor<Integer> getAnimStateKey();

    @NotNull
    protected final Map<S, Pair<AnimationState, AnimationDefinition>> getAnimations() {
        return this.animations;
    }

    @NotNull
    protected final Map<Integer, S> getStateEnumMap() {
        return this.stateEnumMap;
    }

    @Nullable
    protected final S getCurrentAnimState() {
        return this.currentAnimState;
    }

    protected final void setCurrentAnimState(@Nullable S s) {
        this.currentAnimState = s;
    }

    @NotNull
    public final Map<S, Pair<AnimationState, AnimationDefinition>> getInternalAnims$brokencore_common() {
        return this.animations;
    }

    @Nullable
    public final S getAnimState() {
        return this.currentAnimState;
    }

    public final void setAnimState(@Nullable S value) {
        block0: {
            S s = this.currentAnimState = value;
            if (s == null) break block0;
            S it = s;
            boolean bl = false;
            this.entityData.set(this.getAnimStateKey(), (Object)((Enum)it).ordinal());
        }
    }

    public void stopAnimations() {
        Map<S, Pair<AnimationState, AnimationDefinition>> $this$forEach$iv = this.animations;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<S, Pair<AnimationState, AnimationDefinition>>> iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<S, Pair<AnimationState, AnimationDefinition>> element$iv;
            Map.Entry<S, Pair<AnimationState, AnimationDefinition>> entry = element$iv = iterator.next();
            boolean bl = false;
            Pair<AnimationState, AnimationDefinition> it = entry.getValue();
            ((AnimationState)it.getFirst()).stop();
        }
    }

    protected void defineSynchedData(@NotNull SynchedEntityData.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"builder");
        super.defineSynchedData(builder);
        builder.define(this.getAnimStateKey(), (Object)-1);
    }

    /*
     * WARNING - void declaration
     */
    public void onSyncedDataUpdated(@NotNull EntityDataAccessor<?> key) {
        block2: {
            void it;
            Intrinsics.checkNotNullParameter(key, (String)"key");
            super.onSyncedDataUpdated(key);
            if (!Intrinsics.areEqual(key, this.getAnimStateKey())) break block2;
            Integer n = (Integer)this.entityData.get(this.getAnimStateKey());
            AnimatedMonster animatedMonster = this;
            boolean bl = false;
            void v0 = it;
            int n2 = -1;
            animatedMonster.currentAnimState = v0 != null && v0.intValue() == n2 ? null : (Enum)this.stateEnumMap.get(it);
            if (this.level().isClientSide) {
                this.stopAnimations();
                AnimationState animationState = this.animations.get(this.currentAnimState);
                if (animationState != null && (animationState = (AnimationState)animationState.getFirst()) != null) {
                    animationState.start(this.tickCount);
                }
            }
        }
    }

    @NotNull
    protected final AnimationState state(@NotNull S id, @NotNull AnimationDefinition def) {
        Intrinsics.checkNotNullParameter(id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)def, (String)"def");
        AnimationState state = new AnimationState();
        this.animations.put(id, (Pair<AnimationState, AnimationDefinition>)TuplesKt.to((Object)state, (Object)def));
        return state;
    }
}

