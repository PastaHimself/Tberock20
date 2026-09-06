/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.Brain
 *  net.minecraft.world.entity.ai.Brain$Provider
 *  net.minecraft.world.entity.ai.memory.MemoryModuleType
 *  net.minecraft.world.entity.ai.sensing.Sensor
 *  net.minecraft.world.entity.ai.sensing.SensorType
 *  net.minecraft.world.entity.schedule.Activity
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.brain.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.schedule.Activity;
import net.thebrokenscript.brokencore.api.brain.dsl.UnbuiltActivity;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.util.Side;
import net.thebrokenscript.brokencore.api.util.SideOnly;
import net.thebrokenscript.brokencore.impl.mixin.features.brain.BrainProviderInvoker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0091\u0001\u0012.\u0010\u0004\u001a*\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00060\u0005j\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006`\b\u0012.\u0010\t\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\nj\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f`\r\u0012\u001e\u0010\u000e\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u0005j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f`\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0018\u001a\u00020\u0019H\u0007J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0002J\u0012\u0010\u001a\u001a\u00020\u00192\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001dJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001fR6\u0010\u0004\u001a*\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00060\u0005j\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R6\u0010\t\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\nj\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f`\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f0\u0005j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/brokencore/api/brain/util/BuiltBrain;", "T", "Lnet/minecraft/world/entity/LivingEntity;", "", "sensors", "Ljava/util/HashSet;", "Lnet/minecraft/world/entity/ai/sensing/SensorType;", "Lnet/minecraft/world/entity/ai/sensing/Sensor;", "Lkotlin/collections/HashSet;", "activities", "Ljava/util/HashMap;", "", "Lnet/thebrokenscript/brokencore/api/brain/dsl/UnbuiltActivity;", "Lkotlin/collections/HashMap;", "memories", "Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;", "defaultActivity", "Lnet/minecraft/world/entity/schedule/Activity;", "<init>", "(Ljava/util/HashSet;Ljava/util/HashMap;Ljava/util/HashSet;Lnet/minecraft/world/entity/schedule/Activity;)V", "registered", "", "getRegistered$brokencore_common", "()Z", "register", "", "addTo", "entity", "brain", "Lnet/minecraft/world/entity/ai/Brain;", "provider", "Lnet/minecraft/world/entity/ai/Brain$Provider;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nBuiltBrain.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuiltBrain.kt\nnet/thebrokenscript/brokencore/api/brain/util/BuiltBrain\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,61:1\n1869#2,2:62\n1869#2,2:64\n216#3,2:66\n216#3,2:68\n*S KotlinDebug\n*F\n+ 1 BuiltBrain.kt\nnet/thebrokenscript/brokencore/api/brain/util/BuiltBrain\n*L\n31#1:62,2\n34#1:64,2\n37#1:66,2\n50#1:68,2\n*E\n"})
public class BuiltBrain<T extends LivingEntity> {
    @NotNull
    private final HashSet<SensorType<Sensor<T>>> sensors;
    @NotNull
    private final HashMap<String, UnbuiltActivity<T>> activities;
    @NotNull
    private final HashSet<MemoryModuleType<?>> memories;
    @Nullable
    private final Activity defaultActivity;
    private final boolean registered;

    public BuiltBrain(@NotNull HashSet<SensorType<Sensor<T>>> sensors, @NotNull HashMap<String, UnbuiltActivity<T>> activities, @NotNull HashSet<MemoryModuleType<?>> memories, @Nullable Activity defaultActivity) {
        Intrinsics.checkNotNullParameter(sensors, (String)"sensors");
        Intrinsics.checkNotNullParameter(activities, (String)"activities");
        Intrinsics.checkNotNullParameter(memories, (String)"memories");
        this.sensors = sensors;
        this.activities = activities;
        this.memories = memories;
        this.defaultActivity = defaultActivity;
    }

    public final boolean getRegistered$brokencore_common() {
        return this.registered;
    }

    @SideOnly(side=Side.SERVER)
    public final void register() {
        MemoryModuleType it;
        Object element$iv;
        if (PlatformUtil.Companion.isDataGen()) {
            return;
        }
        Object $this$forEach$iv = this.memories;
        boolean $i$f$forEach = false;
        Iterator<Object> iterator = $this$forEach$iv.iterator();
        while (iterator.hasNext()) {
            element$iv = iterator.next();
            it = (MemoryModuleType)element$iv;
            boolean bl = false;
            it.getCodec();
        }
        $this$forEach$iv = this.sensors;
        $i$f$forEach = false;
        iterator = $this$forEach$iv.iterator();
        while (iterator.hasNext()) {
            element$iv = iterator.next();
            it = (SensorType)element$iv;
            boolean bl = false;
            it.create();
        }
        $this$forEach$iv = this.activities;
        $i$f$forEach = false;
        iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Object object = element$iv = (Map.Entry)iterator.next();
            boolean bl = false;
            UnbuiltActivity activity = (UnbuiltActivity)object.getValue();
            activity.getActivity();
        }
        Activity activity = this.defaultActivity;
        Intrinsics.checkNotNull((Object)activity);
        activity.getName();
    }

    public final void addTo(@NotNull LivingEntity entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        Brain brain = entity.getBrain();
        Intrinsics.checkNotNullExpressionValue((Object)brain, (String)"getBrain(...)");
        this.addTo(brain);
    }

    public final void addTo(@NotNull Brain<?> brain) {
        Intrinsics.checkNotNullParameter(brain, (String)"brain");
        if (PlatformUtil.Companion.isDataGen()) {
            return;
        }
        Brain<?> brain2 = brain;
        if (brain2 == null) {
            throw new IllegalArgumentException("Entity type does not match");
        }
        Brain<?> entity = brain2;
        brain.setDefaultActivity(this.defaultActivity);
        Map $this$forEach$iv = this.activities;
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry element$iv;
            Map.Entry it = element$iv = iterator.next();
            boolean bl = false;
            ((UnbuiltActivity)it.getValue()).addTo(brain);
        }
        brain.useDefaultActivity();
    }

    @NotNull
    public final Brain.Provider<T> provider() {
        Brain.Provider provider = BrainProviderInvoker.bc$newProvider((Collection)this.memories, (Collection)this.sensors);
        Intrinsics.checkNotNullExpressionValue(provider, (String)"bc$newProvider(...)");
        return provider;
    }
}

