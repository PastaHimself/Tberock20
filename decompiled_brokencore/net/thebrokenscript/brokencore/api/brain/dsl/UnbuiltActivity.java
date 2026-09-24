/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.mojang.datafixers.util.Pair
 *  kotlin.Metadata
 *  kotlin.collections.SetsKt
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.Brain
 *  net.minecraft.world.entity.ai.behavior.BehaviorControl
 *  net.minecraft.world.entity.ai.memory.MemoryModuleType
 *  net.minecraft.world.entity.ai.memory.MemoryStatus
 *  net.minecraft.world.entity.schedule.Activity
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.brain.dsl;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.BehaviorControl;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.schedule.Activity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0095\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012>\u0010\u0006\u001a:\u0012,\u0012*\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\bj\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n`\u000b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\f\u00122\u0010\r\u001a.\u0012(\u0012&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00100\bj\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u0010`\u000b\u0018\u00010\u000e\u0012\u0010\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u001eJ\u0014\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015RI\u0010\u0006\u001a:\u0012,\u0012*\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\bj\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n`\u000b0\u0007j\b\u0012\u0004\u0012\u00028\u0000`\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R=\u0010\r\u001a.\u0012(\u0012&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u00100\bj\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0004\u0012\u00020\u0010`\u000b\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/brokencore/api/brain/dsl/UnbuiltActivity;", "T", "Lnet/minecraft/world/entity/LivingEntity;", "", "activity", "Lnet/minecraft/world/entity/schedule/Activity;", "behaviors", "Lcom/google/common/collect/ImmutableList;", "Lcom/mojang/datafixers/util/Pair;", "", "Lnet/minecraft/world/entity/ai/behavior/BehaviorControl;", "Lnet/thebrokenscript/brokencore/api/brain/dsl/MojPair;", "Lnet/thebrokenscript/brokencore/api/brain/dsl/BehaviorList;", "conditions", "", "Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;", "Lnet/minecraft/world/entity/ai/memory/MemoryStatus;", "forget", "<init>", "(Lnet/minecraft/world/entity/schedule/Activity;Lcom/google/common/collect/ImmutableList;Ljava/util/Set;Ljava/util/Set;)V", "getActivity", "()Lnet/minecraft/world/entity/schedule/Activity;", "getBehaviors", "()Lcom/google/common/collect/ImmutableList;", "getConditions", "()Ljava/util/Set;", "getForget", "addTo", "", "entity", "(Lnet/minecraft/world/entity/LivingEntity;)V", "brain", "Lnet/minecraft/world/entity/ai/Brain;", "brokencore-common"})
public final class UnbuiltActivity<T extends LivingEntity> {
    @NotNull
    private final Activity activity;
    @NotNull
    private final ImmutableList<Pair<Integer, BehaviorControl<T>>> behaviors;
    @Nullable
    private final Set<Pair<MemoryModuleType<?>, MemoryStatus>> conditions;
    @NotNull
    private final Set<MemoryModuleType<?>> forget;

    public UnbuiltActivity(@NotNull Activity activity, @NotNull ImmutableList<Pair<Integer, BehaviorControl<T>>> behaviors, @Nullable Set<? extends Pair<MemoryModuleType<?>, MemoryStatus>> conditions, @NotNull Set<? extends MemoryModuleType<?>> forget) {
        Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
        Intrinsics.checkNotNullParameter(behaviors, (String)"behaviors");
        Intrinsics.checkNotNullParameter(forget, (String)"forget");
        this.activity = activity;
        this.behaviors = behaviors;
        this.conditions = conditions;
        this.forget = forget;
    }

    @NotNull
    public final Activity getActivity() {
        return this.activity;
    }

    @NotNull
    public final ImmutableList<Pair<Integer, BehaviorControl<T>>> getBehaviors() {
        return this.behaviors;
    }

    @Nullable
    public final Set<Pair<MemoryModuleType<?>, MemoryStatus>> getConditions() {
        return this.conditions;
    }

    @NotNull
    public final Set<MemoryModuleType<?>> getForget() {
        return this.forget;
    }

    public final void addTo(@NotNull T entity) {
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Brain brain = entity.getBrain();
        ImmutableList<Pair<Integer, BehaviorControl<T>>> immutableList = this.behaviors;
        Intrinsics.checkNotNull(immutableList, (String)"null cannot be cast to non-null type com.google.common.collect.ImmutableList<com.mojang.datafixers.util.Pair<kotlin.Int, net.minecraft.world.entity.ai.behavior.BehaviorControl<net.minecraft.world.entity.LivingEntity>>>");
        Set set = this.conditions;
        if (set == null) {
            set = SetsKt.emptySet();
        }
        brain.addActivityAndRemoveMemoriesWhenStopped(this.activity, immutableList, set, this.forget);
    }

    public final void addTo(@NotNull Brain<T> brain) {
        Intrinsics.checkNotNullParameter(brain, (String)"brain");
        ImmutableList<Pair<Integer, BehaviorControl<T>>> immutableList = this.behaviors;
        Intrinsics.checkNotNull(immutableList, (String)"null cannot be cast to non-null type com.google.common.collect.ImmutableList<com.mojang.datafixers.util.Pair<kotlin.Int, net.minecraft.world.entity.ai.behavior.BehaviorControl<net.minecraft.world.entity.LivingEntity>>>");
        Set set = this.conditions;
        if (set == null) {
            set = SetsKt.emptySet();
        }
        brain.addActivityAndRemoveMemoriesWhenStopped(this.activity, immutableList, set, this.forget);
    }
}

