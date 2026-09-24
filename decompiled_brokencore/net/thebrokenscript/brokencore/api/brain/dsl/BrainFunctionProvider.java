/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.Brain
 *  net.minecraft.world.entity.ai.memory.MemoryModuleType
 *  net.minecraft.world.entity.schedule.Activity
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.brain.dsl;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.schedule.Activity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u001e\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0003\u00a2\u0006\u0004\b\b\u0010\tJ#\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r2\u0006\u0010\u000e\u001a\u0002H\f\u00a2\u0006\u0002\u0010\u000fJ0\u0010\u0010\u001a\u00020\u000b\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r2\b\u0010\u000e\u001a\u0004\b\u0002H\f2\u0006\u0010\u0011\u001a\u00020\u0012\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u000b2\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0016\"\u00020\u0007\u00a2\u0006\u0002\u0010\u0017J\u0014\u0010\u0014\u001a\u00020\u000b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018J\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0007J\u001f\u0010\u0014\u001a\u00020\u000b2\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0016\"\u00020\u0006\u00a2\u0006\u0002\u0010\u001cJ\u001b\u0010\u0014\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0007\u00a2\u0006\u0002\b\u001eJ\u000e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0006J\u001d\u0010 \u001a\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r\u00a2\u0006\u0002\u0010!J\u0010\u0010 \u001a\u00020\"*\b\u0012\u0004\u0012\u00020\"0\rJ\u0010\u0010 \u001a\u00020#*\b\u0012\u0004\u0012\u00020#0\rJ\u001a\u0010$\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020#0\r2\b\b\u0002\u0010%\u001a\u00020#J\u001a\u0010&\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020#0\r2\b\b\u0002\u0010%\u001a\u00020#J\u0010\u0010 \u001a\u00020\u0012*\b\u0012\u0004\u0012\u00020\u00120\rJ\u001a\u0010$\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00120\r2\b\b\u0002\u0010%\u001a\u00020\u0012J\u001a\u0010&\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00120\r2\b\b\u0002\u0010%\u001a\u00020\u0012R&\u0010\u0002\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b9\u00a8\u0006'"}, d2={"Lnet/thebrokenscript/brokencore/api/brain/dsl/BrainFunctionProvider;", "", "pair", "Lkotlin/Pair;", "Lnet/minecraft/world/entity/LivingEntity;", "", "", "Lnet/minecraft/world/entity/schedule/Activity;", "<init>", "(Lkotlin/Pair;)V", "set", "", "T", "Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;", "value", "(Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;Ljava/lang/Object;)V", "setTemporary", "lifetime", "", "(Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;Ljava/lang/Object;J)V", "doFirstValidActivity", "activities", "", "([Lnet/minecraft/world/entity/schedule/Activity;)V", "", "doActivityIfValid", "activity", "refNames", "([Ljava/lang/String;)V", "refNameStrings", "doFirstValidActivityString", "refName", "get", "(Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;)Ljava/lang/Object;", "", "", "inc", "by", "dec", "brokencore-common"})
public final class BrainFunctionProvider {
    @NotNull
    private final Pair<LivingEntity, Map<String, Activity>> pair;

    public BrainFunctionProvider(@NotNull Pair<? extends LivingEntity, ? extends Map<String, ? extends Activity>> pair) {
        Intrinsics.checkNotNullParameter(pair, (String)"pair");
        this.pair = pair;
    }

    public final <T> void set(@NotNull MemoryModuleType<T> $this$set, T value) {
        Intrinsics.checkNotNullParameter($this$set, (String)"<this>");
        ((LivingEntity)this.pair.getFirst()).getBrain().setMemory($this$set, value);
    }

    public final <T> void setTemporary(@NotNull MemoryModuleType<T> $this$setTemporary, @NotNull T value, long lifetime) {
        Intrinsics.checkNotNullParameter($this$setTemporary, (String)"<this>");
        Intrinsics.checkNotNullParameter(value, (String)"value");
        ((LivingEntity)this.pair.getFirst()).getBrain().setMemoryWithExpiry($this$setTemporary, value, lifetime);
    }

    public final void doFirstValidActivity(Activity ... activities) {
        Intrinsics.checkNotNullParameter((Object)activities, (String)"activities");
        ((LivingEntity)this.pair.getFirst()).getBrain().setActiveActivityToFirstValid(ArraysKt.toList((Object[])activities));
    }

    public final void doFirstValidActivity(@NotNull List<? extends Activity> activities) {
        Intrinsics.checkNotNullParameter(activities, (String)"activities");
        ((LivingEntity)this.pair.getFirst()).getBrain().setActiveActivityToFirstValid(activities);
    }

    public final void doActivityIfValid(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
        ((LivingEntity)this.pair.getFirst()).getBrain().setActiveActivityIfPossible(activity);
    }

    /*
     * WARNING - void declaration
     */
    public final void doFirstValidActivity(String ... refNames) {
        List list;
        Intrinsics.checkNotNullParameter((Object)refNames, (String)"refNames");
        List list2 = list = CollectionsKt.createListBuilder();
        Brain brain = ((LivingEntity)this.pair.getFirst()).getBrain();
        boolean bl = false;
        for (String it : refNames) {
            Activity v;
            void $this$doFirstValidActivity_u24lambda_u240;
            if ((Activity)((Map)this.pair.getSecond()).get(it) == null) continue;
            $this$doFirstValidActivity_u24lambda_u240.add(v);
        }
        brain.setActiveActivityToFirstValid(CollectionsKt.build((List)list));
    }

    /*
     * WARNING - void declaration
     */
    @JvmName(name="doFirstValidActivityString")
    public final void doFirstValidActivityString(@NotNull List<String> refNameStrings) {
        List list;
        Intrinsics.checkNotNullParameter(refNameStrings, (String)"refNameStrings");
        List list2 = list = CollectionsKt.createListBuilder();
        Brain brain = ((LivingEntity)this.pair.getFirst()).getBrain();
        boolean bl = false;
        for (String it : refNameStrings) {
            Activity v;
            void $this$doFirstValidActivity_u24lambda_u241;
            if ((Activity)((Map)this.pair.getSecond()).get(it) == null) continue;
            $this$doFirstValidActivity_u24lambda_u241.add(v);
        }
        brain.setActiveActivityToFirstValid(CollectionsKt.build((List)list));
    }

    public final void doActivityIfValid(@NotNull String refName) {
        Intrinsics.checkNotNullParameter((Object)refName, (String)"refName");
        Activity activity = (Activity)((Map)this.pair.getSecond()).get(refName);
        if (activity == null) {
            return;
        }
        Activity v = activity;
        ((LivingEntity)this.pair.getFirst()).getBrain().setActiveActivityIfPossible(v);
    }

    @Nullable
    public final <T> T get(@NotNull MemoryModuleType<T> $this$get) {
        Intrinsics.checkNotNullParameter($this$get, (String)"<this>");
        return ((LivingEntity)this.pair.getFirst()).getBrain().getMemory($this$get).orElse(null);
    }

    public final boolean get(@NotNull MemoryModuleType<Boolean> $this$get) {
        Intrinsics.checkNotNullParameter($this$get, (String)"<this>");
        Boolean bl = ((LivingEntity)this.pair.getFirst()).getBrain().getMemory($this$get).orElse(null);
        return bl != null ? bl : false;
    }

    public final int get(@NotNull MemoryModuleType<Integer> $this$get) {
        Intrinsics.checkNotNullParameter($this$get, (String)"<this>");
        Integer n = ((LivingEntity)this.pair.getFirst()).getBrain().getMemory($this$get).orElse(null);
        return n != null ? n : 0;
    }

    public final void inc(@NotNull MemoryModuleType<Integer> $this$inc, int by) {
        Intrinsics.checkNotNullParameter($this$inc, (String)"<this>");
        this.set($this$inc, this.get($this$inc) + by);
    }

    public static /* synthetic */ void inc$default(BrainFunctionProvider brainFunctionProvider, MemoryModuleType memoryModuleType, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 1;
        }
        brainFunctionProvider.inc((MemoryModuleType<Integer>)memoryModuleType, n);
    }

    public final void dec(@NotNull MemoryModuleType<Integer> $this$dec, int by) {
        Intrinsics.checkNotNullParameter($this$dec, (String)"<this>");
        this.set($this$dec, this.get($this$dec) - by);
    }

    public static /* synthetic */ void dec$default(BrainFunctionProvider brainFunctionProvider, MemoryModuleType memoryModuleType, int n, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 1;
        }
        brainFunctionProvider.dec((MemoryModuleType<Integer>)memoryModuleType, n);
    }

    public final long get(@NotNull MemoryModuleType<Long> $this$get) {
        Intrinsics.checkNotNullParameter($this$get, (String)"<this>");
        Long l = ((LivingEntity)this.pair.getFirst()).getBrain().getMemory($this$get).orElse(null);
        return l != null ? l : 0L;
    }

    public final void inc(@NotNull MemoryModuleType<Long> $this$inc, long by) {
        Intrinsics.checkNotNullParameter($this$inc, (String)"<this>");
        this.set($this$inc, this.get($this$inc) + by);
    }

    public static /* synthetic */ void inc$default(BrainFunctionProvider brainFunctionProvider, MemoryModuleType memoryModuleType, long l, int n, Object object) {
        if ((n & 1) != 0) {
            l = 1L;
        }
        brainFunctionProvider.inc((MemoryModuleType<Long>)memoryModuleType, l);
    }

    public final void dec(@NotNull MemoryModuleType<Long> $this$dec, long by) {
        Intrinsics.checkNotNullParameter($this$dec, (String)"<this>");
        this.set($this$dec, this.get($this$dec) - by);
    }

    public static /* synthetic */ void dec$default(BrainFunctionProvider brainFunctionProvider, MemoryModuleType memoryModuleType, long l, int n, Object object) {
        if ((n & 1) != 0) {
            l = 1L;
        }
        brainFunctionProvider.dec((MemoryModuleType<Long>)memoryModuleType, l);
    }
}

