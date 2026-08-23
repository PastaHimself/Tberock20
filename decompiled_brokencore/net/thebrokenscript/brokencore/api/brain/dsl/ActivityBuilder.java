/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableList$Builder
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableSet
 *  com.mojang.datafixers.util.Pair
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.IntRange
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.behavior.BehaviorControl
 *  net.minecraft.world.entity.ai.behavior.GateBehavior
 *  net.minecraft.world.entity.ai.behavior.GateBehavior$OrderPolicy
 *  net.minecraft.world.entity.ai.behavior.GateBehavior$RunningPolicy
 *  net.minecraft.world.entity.ai.behavior.OneShot
 *  net.minecraft.world.entity.ai.behavior.RunOne
 *  net.minecraft.world.entity.ai.memory.MemoryModuleType
 *  net.minecraft.world.entity.ai.memory.MemoryStatus
 *  net.minecraft.world.entity.schedule.Activity
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.brain.dsl;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.BehaviorControl;
import net.minecraft.world.entity.ai.behavior.GateBehavior;
import net.minecraft.world.entity.ai.behavior.OneShot;
import net.minecraft.world.entity.ai.behavior.RunOne;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.schedule.Activity;
import net.thebrokenscript.brokencore.api.brain.dsl.BehaviorBuilder;
import net.thebrokenscript.brokencore.api.brain.dsl.BrainFunctionProvider;
import net.thebrokenscript.brokencore.api.brain.dsl.UnbuiltActivity;
import net.thebrokenscript.brokencore.api.brain.util.BrainBehavior;
import net.thebrokenscript.brokencore.api.brain.util.BrainRegistryHelper;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u000267B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ<\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u000b2\"\u0010!\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0004\u0012\u00020\u001d0\"\u00a2\u0006\u0002\b$\u00a2\u0006\u0002\b%J<\u0010\u001c\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\"\u0010!\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0004\u0012\u00020\u001d0\"\u00a2\u0006\u0002\b$\u00a2\u0006\u0002\b%J\u001e\u0010\u001c\u001a\u00020\u001d2\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\b\b\u0002\u0010 \u001a\u00020\u000bJ4\u0010(\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u000b2\"\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00020\u001d0\"\u00a2\u0006\u0002\b$\u00a2\u0006\u0002\b%J4\u0010*\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u000b2\"\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00020\u001d0\"\u00a2\u0006\u0002\b$\u00a2\u0006\u0002\b%J4\u0010+\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u000b2\"\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00020\u001d0\"\u00a2\u0006\u0002\b$\u00a2\u0006\u0002\b%J.\u0010,\u001a\u00020\u001d2&\u0010)\u001a\"\u0012\u000e\u0012\f0-R\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00020\u001d0\"\u00a2\u0006\u0002\b$\u00a2\u0006\u0002\b%J\u0018\u0010.\u001a\u00020\u001d2\u0010\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u001aJ'\u0010.\u001a\u00020\u001d2\u001a\u0010/\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001500\"\u0006\u0012\u0002\b\u00030\u0015\u00a2\u0006\u0002\u00101J<\u00102\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u000b2\"\u0010'\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\u0004\u0012\u00020\u001d0\"\u00a2\u0006\u0002\b$\u00a2\u0006\u0002\b%J\u0013\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0000\u00a2\u0006\u0002\b5R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000Rf\u0010\u0012\u001aZ\u0012(\u0012&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u0004\u0012\u00020\u0016`\u00170\u0013j,\u0012(\u0012&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0015\u0012\u0004\u0012\u00020\u0016`\u0017`\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2={"Lnet/thebrokenscript/brokencore/api/brain/dsl/ActivityBuilder;", "T", "Lnet/minecraft/world/entity/LivingEntity;", "", "refMap", "", "", "Lnet/minecraft/world/entity/schedule/Activity;", "name", "Lnet/minecraft/resources/ResourceLocation;", "fromType", "", "<init>", "(Ljava/util/Map;Lnet/minecraft/resources/ResourceLocation;I)V", "map", "", "Lkotlin/Pair;", "Lnet/minecraft/world/entity/ai/behavior/BehaviorControl;", "conditions", "Ljava/util/HashSet;", "Lcom/mojang/datafixers/util/Pair;", "Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;", "Lnet/minecraft/world/entity/ai/memory/MemoryStatus;", "Lnet/thebrokenscript/brokencore/api/brain/dsl/MojPair;", "Lkotlin/collections/HashSet;", "forgettable", "", "mapType", "single", "", "runtimeRange", "Lkotlin/ranges/IntRange;", "priority", "builder", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/brain/dsl/BehaviorBuilder;", "Lnet/thebrokenscript/brokencore/api/brain/dsl/BrainBuilderMarker;", "Lkotlin/ExtensionFunctionType;", "runtime", "behavior", "random", "func", "pick", "first", "require", "Lnet/thebrokenscript/brokencore/api/brain/dsl/ActivityBuilder$ActivityConditionBuilder;", "forget", "memories", "", "([Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;)V", "once", "build", "Lnet/thebrokenscript/brokencore/api/brain/dsl/UnbuiltActivity;", "build$brokencore_common", "OneShotBehavior", "ActivityConditionBuilder", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBrainDsl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BrainDsl.kt\nnet/thebrokenscript/brokencore/api/brain/dsl/ActivityBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,686:1\n1869#2,2:687\n1869#2,2:689\n1869#2,2:691\n1056#2:693\n1869#2,2:694\n*S KotlinDebug\n*F\n+ 1 BrainDsl.kt\nnet/thebrokenscript/brokencore/api/brain/dsl/ActivityBuilder\n*L\n385#1:687,2\n400#1:689,2\n416#1:691,2\n426#1:693\n479#1:694,2\n*E\n"})
public final class ActivityBuilder<T extends LivingEntity> {
    @NotNull
    private final Map<String, Activity> refMap;
    @NotNull
    private final ResourceLocation name;
    private final int fromType;
    @NotNull
    private final List<Pair<Integer, BehaviorControl<T>>> map;
    @NotNull
    private HashSet<com.mojang.datafixers.util.Pair<MemoryModuleType<?>, MemoryStatus>> conditions;
    @NotNull
    private Set<? extends MemoryModuleType<?>> forgettable;
    private int mapType;

    public ActivityBuilder(@NotNull Map<String, ? extends Activity> refMap, @NotNull ResourceLocation name, int fromType) {
        Intrinsics.checkNotNullParameter(refMap, (String)"refMap");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        this.refMap = refMap;
        this.name = name;
        this.fromType = fromType;
        this.map = new ArrayList();
        this.conditions = new HashSet();
        this.forgettable = SetsKt.emptySet();
    }

    public /* synthetic */ ActivityBuilder(Map map, ResourceLocation resourceLocation, int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            n = 0;
        }
        this(map, resourceLocation, n);
    }

    public final void single(@NotNull IntRange runtimeRange, int priority, @NotNull Function1<? super BehaviorBuilder<T>, Unit> builder) {
        Intrinsics.checkNotNullParameter((Object)runtimeRange, (String)"runtimeRange");
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        if (this.mapType != 0 && this.fromType != 1) {
            throw new RuntimeException("Behavior already defined");
        }
        BehaviorBuilder obj = new BehaviorBuilder(this.refMap, runtimeRange);
        builder.invoke(obj);
        BrainBehavior built = obj.build$brokencore_common();
        this.map.add(TuplesKt.to((Object)priority, built));
        this.mapType = 1;
    }

    public static /* synthetic */ void single$default(ActivityBuilder activityBuilder, IntRange intRange, int n, Function1 function1, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        activityBuilder.single(intRange, n, function1);
    }

    public final void single(int runtime, int priority, @NotNull Function1<? super BehaviorBuilder<T>, Unit> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        this.single(new IntRange(runtime, runtime), priority, builder);
    }

    public static /* synthetic */ void single$default(ActivityBuilder activityBuilder, int n, int n2, Function1 function1, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        activityBuilder.single(n, n2, function1);
    }

    public final void single(@NotNull BehaviorControl<T> behavior, int priority) {
        Intrinsics.checkNotNullParameter(behavior, (String)"behavior");
        if (this.mapType != 0 && this.fromType != 1) {
            throw new RuntimeException("Behavior already defined");
        }
        this.map.add(TuplesKt.to((Object)priority, behavior));
        this.mapType = 1;
    }

    public static /* synthetic */ void single$default(ActivityBuilder activityBuilder, BehaviorControl behaviorControl, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        activityBuilder.single(behaviorControl, n);
    }

    public final void random(int priority, @NotNull Function1<? super ActivityBuilder<T>, Unit> func) {
        List list;
        Intrinsics.checkNotNullParameter(func, (String)"func");
        if (this.mapType != 0 && this.fromType != 1) {
            throw new RuntimeException("Behavior already defined");
        }
        ActivityBuilder<T> builder = new ActivityBuilder<T>(this.refMap, this.name, 1);
        func.invoke(builder);
        List $this$random_u24lambda_u240 = list = CollectionsKt.createListBuilder();
        boolean bl = false;
        Iterable $this$forEach$iv = builder.map;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Pair it = (Pair)element$iv;
            boolean bl2 = false;
            $this$random_u24lambda_u240.add(new com.mojang.datafixers.util.Pair(it.getSecond(), (Object)0));
        }
        List list2 = CollectionsKt.build((List)list);
        this.map.add(TuplesKt.to((Object)priority, (Object)new RunOne(list2)));
        this.mapType = 1;
    }

    public static /* synthetic */ void random$default(ActivityBuilder activityBuilder, int n, Function1 function1, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        activityBuilder.random(n, function1);
    }

    public final void pick(int priority, @NotNull Function1<? super ActivityBuilder<T>, Unit> func) {
        List list;
        Intrinsics.checkNotNullParameter(func, (String)"func");
        if (this.mapType != 0 && this.fromType != 1) {
            throw new RuntimeException("Behavior already defined");
        }
        ActivityBuilder<T> builder = new ActivityBuilder<T>(this.refMap, this.name, 1);
        func.invoke(builder);
        List $this$pick_u24lambda_u240 = list = CollectionsKt.createListBuilder();
        boolean bl = false;
        Iterable $this$forEach$iv = builder.map;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Pair it = (Pair)element$iv;
            boolean bl2 = false;
            $this$pick_u24lambda_u240.add(new com.mojang.datafixers.util.Pair(it.getSecond(), it.getFirst()));
        }
        List list2 = CollectionsKt.build((List)list);
        this.map.add(TuplesKt.to((Object)priority, (Object)new RunOne(list2)));
        this.mapType = 1;
    }

    public static /* synthetic */ void pick$default(ActivityBuilder activityBuilder, int n, Function1 function1, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        activityBuilder.pick(n, function1);
    }

    public final void first(int priority, @NotNull Function1<? super ActivityBuilder<T>, Unit> func) {
        List list;
        Intrinsics.checkNotNullParameter(func, (String)"func");
        if (this.mapType != 0 && this.fromType != 1) {
            throw new RuntimeException("Behavior already defined");
        }
        ActivityBuilder<T> builder = new ActivityBuilder<T>(this.refMap, this.name, 1);
        func.invoke(builder);
        List $this$first_u24lambda_u240 = list = CollectionsKt.createListBuilder();
        boolean bl = false;
        Iterable $this$forEach$iv = builder.map;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Pair it = (Pair)element$iv;
            boolean bl2 = false;
            $this$first_u24lambda_u240.add(new com.mojang.datafixers.util.Pair(it.getSecond(), it.getFirst()));
        }
        List list2 = CollectionsKt.build((List)list);
        Iterable $this$sortedBy$iv = list2;
        boolean $i$f$sortedBy = false;
        this.map.add(TuplesKt.to((Object)priority, (Object)new GateBehavior((Map)ImmutableMap.of(), (Set)ImmutableSet.of(), GateBehavior.OrderPolicy.ORDERED, GateBehavior.RunningPolicy.TRY_ALL, CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)new Comparator(){

            public final int compare(T a, T b) {
                com.mojang.datafixers.util.Pair it = (com.mojang.datafixers.util.Pair)a;
                boolean bl = false;
                Comparable comparable = (Integer)it.getSecond();
                it = (com.mojang.datafixers.util.Pair)b;
                Comparable comparable2 = comparable;
                bl = false;
                return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)((Integer)it.getSecond()));
            }
        }))));
        this.mapType = 1;
    }

    public static /* synthetic */ void first$default(ActivityBuilder activityBuilder, int n, Function1 function1, int n2, Object object) {
        if ((n2 & 1) != 0) {
            n = 0;
        }
        activityBuilder.first(n, function1);
    }

    public final void require(@NotNull Function1<? super ActivityConditionBuilder, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        this.mapType = 2;
        func.invoke((Object)new ActivityConditionBuilder());
    }

    public final void forget(@NotNull Set<? extends MemoryModuleType<?>> memories) {
        Intrinsics.checkNotNullParameter(memories, (String)"memories");
        this.forgettable = memories;
        this.mapType = 3;
    }

    public final void forget(MemoryModuleType<?> ... memories) {
        Intrinsics.checkNotNullParameter(memories, (String)"memories");
        this.forgettable = ArraysKt.toSet((Object[])memories);
        this.mapType = 3;
    }

    public final void once(@NotNull IntRange runtime, int priority, @NotNull Function1<? super BehaviorBuilder<T>, Unit> behavior) {
        Intrinsics.checkNotNullParameter((Object)runtime, (String)"runtime");
        Intrinsics.checkNotNullParameter(behavior, (String)"behavior");
        if (this.mapType != 0 && this.fromType != 1) {
            throw new RuntimeException("Behavior already defined");
        }
        BehaviorBuilder obj = new BehaviorBuilder(this.refMap, runtime);
        behavior.invoke(obj);
        this.map.add(TuplesKt.to((Object)priority, obj.build$brokencore_common()));
        this.mapType = 1;
    }

    public static /* synthetic */ void once$default(ActivityBuilder activityBuilder, IntRange intRange, int n, Function1 function1, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 0;
        }
        activityBuilder.once(intRange, n, function1);
    }

    @NotNull
    public final UnbuiltActivity<T> build$brokencore_common() {
        ImmutableList.Builder list = ImmutableList.builder();
        if (this.mapType == 0) {
            throw new RuntimeException("Behaviors cannot be empty");
        }
        if (this.mapType == 2 && this.conditions.isEmpty()) {
            throw new RuntimeException("No conditions defined for conditional");
        }
        Iterable $this$forEach$iv = this.map;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            Pair it = (Pair)element$iv;
            boolean bl = false;
            list.add((Object)new com.mojang.datafixers.util.Pair(it.getFirst(), it.getSecond()));
        }
        Activity activity = BrainRegistryHelper.INSTANCE.registerActivity(this.name);
        ImmutableList immutableList = list.build();
        Intrinsics.checkNotNullExpressionValue((Object)immutableList, (String)"build(...)");
        return new UnbuiltActivity(activity, immutableList, this.mapType == 2 ? CollectionsKt.toSet((Iterable)this.conditions) : null, this.forgettable);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\b\u001a\u00020\tH\u0086\u0004\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/brokencore/api/brain/dsl/ActivityBuilder$ActivityConditionBuilder;", "", "<init>", "(Lnet/thebrokenscript/brokencore/api/brain/dsl/ActivityBuilder;)V", "of", "", "T", "Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;", "status", "Lnet/minecraft/world/entity/ai/memory/MemoryStatus;", "brokencore-common"})
    public final class ActivityConditionBuilder {
        public final <T> void of(@NotNull MemoryModuleType<T> $this$of, @NotNull MemoryStatus status) {
            Intrinsics.checkNotNullParameter($this$of, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)status, (String)"status");
            ((ActivityBuilder)ActivityBuilder.this).conditions.add(new com.mojang.datafixers.util.Pair($this$of, (Object)status));
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0004\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/brain/dsl/ActivityBuilder$OneShotBehavior;", "T", "Lnet/minecraft/world/entity/LivingEntity;", "Lnet/minecraft/world/entity/ai/behavior/OneShot;", "behavior", "Lnet/thebrokenscript/brokencore/api/brain/util/BrainBehavior;", "<init>", "(Lnet/thebrokenscript/brokencore/api/brain/dsl/ActivityBuilder;Lnet/thebrokenscript/brokencore/api/brain/util/BrainBehavior;)V", "getBehavior", "()Lnet/thebrokenscript/brokencore/api/brain/util/BrainBehavior;", "trigger", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "entity", "gameTime", "", "(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;J)Z", "brokencore-common"})
    public final class OneShotBehavior<T extends LivingEntity>
    extends OneShot<T> {
        @NotNull
        private final BrainBehavior<T> behavior;

        public OneShotBehavior(BrainBehavior<T> behavior) {
            Intrinsics.checkNotNullParameter(behavior, (String)"behavior");
            this.behavior = behavior;
        }

        @NotNull
        public final BrainBehavior<T> getBehavior() {
            return this.behavior;
        }

        public boolean trigger(@NotNull ServerLevel level, @NotNull T entity, long gameTime) {
            block0: {
                Intrinsics.checkNotNullParameter((Object)level, (String)"level");
                Intrinsics.checkNotNullParameter(entity, (String)"entity");
                Function4<BrainFunctionProvider, ServerLevel, T, Long, Unit> function4 = this.behavior.getStartFunc();
                if (function4 == null) break block0;
                function4.invoke((Object)new BrainFunctionProvider((Pair<? extends LivingEntity, ? extends Map<String, ? extends Activity>>)TuplesKt.to(entity, (Object)((ActivityBuilder)ActivityBuilder.this).refMap)), (Object)level, entity, (Object)gameTime);
            }
            return true;
        }
    }
}

