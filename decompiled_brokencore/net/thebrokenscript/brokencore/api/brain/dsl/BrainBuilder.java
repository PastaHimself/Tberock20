/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntRange
 *  net.minecraft.core.DefaultedRegistry
 *  net.minecraft.core.MappedRegistry
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.BuiltInRegistries
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.memory.MemoryModuleType
 *  net.minecraft.world.entity.ai.sensing.Sensor
 *  net.minecraft.world.entity.ai.sensing.SensorType
 *  net.minecraft.world.entity.schedule.Activity
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.phys.AABB
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.brain.dsl;

import com.mojang.serialization.Codec;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import net.minecraft.core.DefaultedRegistry;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.thebrokenscript.brokencore.api.brain.dsl.ActivityBuilder;
import net.thebrokenscript.brokencore.api.brain.dsl.BehaviorBuilder;
import net.thebrokenscript.brokencore.api.brain.dsl.BrainBuilderMarker;
import net.thebrokenscript.brokencore.api.brain.dsl.SensorBuilder;
import net.thebrokenscript.brokencore.api.brain.dsl.UnbuiltActivity;
import net.thebrokenscript.brokencore.api.brain.sensors.LineOfSightSensor;
import net.thebrokenscript.brokencore.api.brain.util.BrainBehavior;
import net.thebrokenscript.brokencore.api.brain.util.BrainRegistryHelper;
import net.thebrokenscript.brokencore.api.brain.util.BuiltBrain;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@BrainBuilderMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 :*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001:B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001e0\r\"\u0004\b\u0001\u0010\u001e*\b\u0012\u0004\u0012\u0002H\u001e0\u001f2\u0006\u0010 \u001a\u00020!H\u0086\u0004J8\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010#\u001a\u00020$2\"\u0010%\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000'\u0012\u0004\u0012\u00020(0&\u00a2\u0006\u0002\b\u0019\u00a2\u0006\u0002\b)J8\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010*\u001a\u00020+2\"\u0010%\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000'\u0012\u0004\u0012\u00020(0&\u00a2\u0006\u0002\b\u0019\u00a2\u0006\u0002\b)J2\u0010,\u001a\u00020(2\u0006\u0010 \u001a\u00020!2\"\u0010%\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000-\u0012\u0004\u0012\u00020(0&\u00a2\u0006\u0002\b\u0019\u00a2\u0006\u0002\b)J\u000e\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0014J\u001c\u0010,\u001a\u00020(2\u0006\u00100\u001a\u00020!2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017J2\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020!2\"\u0010%\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000001\u0012\u0004\u0012\u00020(0&\u00a2\u0006\u0002\b\u0019\u00a2\u0006\u0002\b)J4\u00102\u001a\u00020(2\u0006\u00100\u001a\u00020!2\u0006\u00103\u001a\u00020+2\b\b\u0002\u00104\u001a\u0002052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u00050&J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00028\u000009H\u0002R&\u0010\b\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\tj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R6\u0010\u000e\u001a*\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00110\u000fj\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011`\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00140\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0014`\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R6\u0010\u0015\u001a*\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u00160\tj\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u0016`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R,\u0010\u001a\u001a\t\u0018\u00010\u0014\u00a2\u0006\u0002\b\u00192\r\u0010\u0018\u001a\t\u0018\u00010\u0014\u00a2\u0006\u0002\b\u0019@CX\u0082\u000e\u00a2\u0006\b\n\u0000\"\u0004\b\u001b\u0010\u001c\u00a8\u0006;"}, d2={"Lnet/thebrokenscript/brokencore/api/brain/dsl/BrainBuilder;", "T", "Lnet/minecraft/world/entity/LivingEntity;", "", "ctorDifferentiator", "", "<init>", "(Z)V", "behaviors", "Ljava/util/HashSet;", "Lnet/thebrokenscript/brokencore/api/brain/util/BrainBehavior;", "Lkotlin/collections/HashSet;", "memories", "Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;", "activities", "Ljava/util/HashMap;", "", "Lnet/thebrokenscript/brokencore/api/brain/dsl/UnbuiltActivity;", "Lkotlin/collections/HashMap;", "refMap", "Lnet/minecraft/world/entity/schedule/Activity;", "sensors", "Lnet/minecraft/world/entity/ai/sensing/SensorType;", "Lnet/minecraft/world/entity/ai/sensing/Sensor;", "v", "Lnet/thebrokenscript/brokencore/api/brain/dsl/BrainBuilderMarker;", "defaultActivity", "defaultActivitySetter", "(Lnet/minecraft/world/entity/schedule/Activity;)V", "of", "A", "Lcom/mojang/serialization/Codec;", "name", "Lnet/minecraft/resources/ResourceLocation;", "behavior", "runtimeRange", "Lkotlin/ranges/IntRange;", "builder", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/brain/dsl/BehaviorBuilder;", "", "Lkotlin/ExtensionFunctionType;", "runtime", "", "sensor", "Lnet/thebrokenscript/brokencore/api/brain/dsl/SensorBuilder;", "setDefaultActivity", "activity", "location", "Lnet/thebrokenscript/brokencore/api/brain/dsl/ActivityBuilder;", "lineOfSight", "scanTime", "bounds", "Lnet/minecraft/world/phys/AABB;", "predicate", "Lnet/minecraft/world/entity/Entity;", "build", "Lnet/thebrokenscript/brokencore/api/brain/util/BuiltBrain;", "Companion", "brokencore-common"})
public final class BrainBuilder<T extends LivingEntity> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final HashSet<BrainBehavior<?>> behaviors;
    @NotNull
    private final HashSet<MemoryModuleType<?>> memories;
    @NotNull
    private final HashMap<String, UnbuiltActivity<T>> activities;
    @NotNull
    private final HashMap<String, Activity> refMap;
    @NotNull
    private final HashSet<SensorType<Sensor<T>>> sensors;
    @Nullable
    private Activity defaultActivity;

    public BrainBuilder(boolean ctorDifferentiator) {
        this.behaviors = new HashSet();
        this.memories = new HashSet();
        this.activities = new HashMap();
        this.refMap = new HashMap();
        this.sensors = new HashSet();
        DefaultedRegistry mem = BuiltInRegistries.MEMORY_MODULE_TYPE;
        Registry activity = BuiltInRegistries.ACTIVITY;
        DefaultedRegistry sensor = BuiltInRegistries.SENSOR_TYPE;
        if (mem instanceof MappedRegistry && activity instanceof MappedRegistry && sensor instanceof MappedRegistry && (MiscExt.isFrozen((MappedRegistry)mem) || MiscExt.isFrozen((MappedRegistry)activity) || MiscExt.isFrozen((MappedRegistry)sensor)) && !PlatformUtil.Companion.isDataGen()) {
            throw new IllegalStateException("Brain builders must be initialized during mod startup");
        }
    }

    public /* synthetic */ BrainBuilder(boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            bl = false;
        }
        this(bl);
    }

    @JvmName(name="defaultActivitySetter")
    private final void defaultActivitySetter(Activity v) {
        if (this.defaultActivity != null) {
            throw new RuntimeException("Default activity already set");
        }
        this.defaultActivity = v;
    }

    @NotNull
    public final <A> MemoryModuleType<A> of(@NotNull Codec<A> $this$of, @NotNull ResourceLocation name) {
        Intrinsics.checkNotNullParameter($this$of, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        MemoryModuleType<A> memory = BrainRegistryHelper.INSTANCE.registerMemory(name, $this$of);
        this.memories.add(memory);
        return memory;
    }

    @NotNull
    public final BrainBehavior<T> behavior(@NotNull IntRange runtimeRange, @NotNull Function1<? super BehaviorBuilder<T>, Unit> builder) {
        Intrinsics.checkNotNullParameter((Object)runtimeRange, (String)"runtimeRange");
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        BehaviorBuilder obj = new BehaviorBuilder((Map<String, ? extends Activity>)this.refMap, runtimeRange);
        builder.invoke(obj);
        BrainBehavior built = obj.build$brokencore_common();
        this.behaviors.add(built);
        return built;
    }

    @NotNull
    public final BrainBehavior<T> behavior(int runtime, @NotNull Function1<? super BehaviorBuilder<T>, Unit> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        BehaviorBuilder obj = new BehaviorBuilder((Map<String, ? extends Activity>)this.refMap, new IntRange(runtime, runtime));
        builder.invoke(obj);
        BrainBehavior built = obj.build$brokencore_common();
        this.behaviors.add(built);
        return built;
    }

    public final void sensor(@NotNull ResourceLocation name, @NotNull Function1<? super SensorBuilder<T>, Unit> builder) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        SensorBuilder obj = new SensorBuilder(this.refMap);
        builder.invoke(obj);
        this.sensors.add(BrainRegistryHelper.INSTANCE.registerSensor(name, obj.build$brokencore_common()));
    }

    public final void setDefaultActivity(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter((Object)activity, (String)"activity");
        this.defaultActivitySetter(activity);
    }

    public final void sensor(@NotNull ResourceLocation location, @NotNull Sensor<T> sensor) {
        Intrinsics.checkNotNullParameter((Object)location, (String)"location");
        Intrinsics.checkNotNullParameter(sensor, (String)"sensor");
        this.sensors.add(BrainRegistryHelper.INSTANCE.registerSensor(location, sensor));
    }

    @NotNull
    public final Activity activity(@NotNull ResourceLocation location, @NotNull Function1<? super ActivityBuilder<T>, Unit> builder) {
        Intrinsics.checkNotNullParameter((Object)location, (String)"location");
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        ActivityBuilder obj = new ActivityBuilder(this.refMap, location, 0, 4, null);
        builder.invoke(obj);
        UnbuiltActivity activity = obj.build$brokencore_common();
        ((Map)this.activities).put(location.getPath(), activity);
        return activity.getActivity();
    }

    public final void lineOfSight(@NotNull ResourceLocation location, int scanTime, @NotNull AABB bounds, @NotNull Function1<? super Entity, Boolean> predicate) {
        Intrinsics.checkNotNullParameter((Object)location, (String)"location");
        Intrinsics.checkNotNullParameter((Object)bounds, (String)"bounds");
        Intrinsics.checkNotNullParameter(predicate, (String)"predicate");
        this.sensor(location, new LineOfSightSensor(scanTime, bounds, predicate));
    }

    public static /* synthetic */ void lineOfSight$default(BrainBuilder brainBuilder, ResourceLocation resourceLocation, int n, AABB aABB, Function1 function1, int n2, Object object) {
        if ((n2 & 4) != 0) {
            AABB aABB2 = AABB.of((BoundingBox)BoundingBox.infinite());
            Intrinsics.checkNotNullExpressionValue((Object)aABB2, (String)"of(...)");
            aABB = aABB2;
        }
        brainBuilder.lineOfSight(resourceLocation, n, aABB, (Function1<Entity, Boolean>)function1);
    }

    private final BuiltBrain<T> build() {
        Activity activity = this.defaultActivity;
        if (activity == null) {
            if (!PlatformUtil.Companion.isDataGen()) {
                activity = null;
            } else {
                throw new RuntimeException("Default activity must be defined");
            }
        }
        return new BuiltBrain<T>(this.sensors, this.activities, this.memories, activity);
    }

    public BrainBuilder() {
        this(false, 1, null);
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J=\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00072\"\u0010\b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\n\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\u0002\b\f\u00a2\u0006\u0002\b\rH\u0086\u0002\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/brokencore/api/brain/dsl/BrainBuilder$Companion;", "", "<init>", "()V", "invoke", "Lnet/thebrokenscript/brokencore/api/brain/util/BuiltBrain;", "T", "Lnet/minecraft/world/entity/LivingEntity;", "init", "Lkotlin/Function1;", "Lnet/thebrokenscript/brokencore/api/brain/dsl/BrainBuilder;", "", "Lnet/thebrokenscript/brokencore/api/brain/dsl/BrainBuilderMarker;", "Lkotlin/ExtensionFunctionType;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final <T extends LivingEntity> BuiltBrain<T> invoke(@NotNull Function1<? super BrainBuilder<T>, Unit> init) {
            Intrinsics.checkNotNullParameter(init, (String)"init");
            BrainBuilder obj = new BrainBuilder(false);
            init.invoke(obj);
            BuiltBrain built = obj.build();
            built.register();
            return built;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

