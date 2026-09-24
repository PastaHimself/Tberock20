/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.memory.MemoryModuleType
 *  net.minecraft.world.entity.ai.sensing.Sensor
 *  net.minecraft.world.entity.schedule.Activity
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.brain.dsl;

import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.schedule.Activity;
import net.thebrokenscript.brokencore.api.brain.dsl.BrainBuilderMarker;
import net.thebrokenscript.brokencore.api.brain.dsl.BrainFunctionProvider;
import net.thebrokenscript.brokencore.api.brain.util.BrainSensor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@BrainBuilderMarker
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B+\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0004\b\t\u0010\nJN\u0010$\u001a\u00020\u00152F\u0010%\u001aB\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u000e\u00a2\u0006\u0002\b&\u00a2\u0006\u0002\b\u0016J'\u0010'\u001a\u00020\u00152\u001a\u0010(\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u001a0)\"\u0006\u0012\u0002\b\u00030\u001a\u00a2\u0006\u0002\u0010*J\u0013\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0000\u00a2\u0006\u0002\b-R-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fRK\u0010\r\u001a?\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000e\u00a2\u0006\u0002\b\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0017\u001a\u0014\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u0019\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006."}, d2={"Lnet/thebrokenscript/brokencore/api/brain/dsl/SensorBuilder;", "T", "Lnet/minecraft/world/entity/LivingEntity;", "", "refMap", "Ljava/util/HashMap;", "", "Lnet/minecraft/world/entity/schedule/Activity;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/HashMap;)V", "getRefMap", "()Ljava/util/HashMap;", "tickFunc", "Lkotlin/Function3;", "Lnet/thebrokenscript/brokencore/api/brain/dsl/BrainFunctionProvider;", "Lnet/minecraft/server/level/ServerLevel;", "Lkotlin/ParameterName;", "name", "level", "owner", "", "Lkotlin/ExtensionFunctionType;", "requireFunc", "Lkotlin/Function0;", "", "Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;", "scanTimeSet", "", "v", "", "scanTime", "getScanTime", "()I", "setScanTime", "(I)V", "tick", "func", "Lnet/thebrokenscript/brokencore/api/brain/dsl/BrainBuilderMarker;", "requirements", "params", "", "([Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;)V", "build", "Lnet/minecraft/world/entity/ai/sensing/Sensor;", "build$brokencore_common", "brokencore-common"})
public final class SensorBuilder<T extends LivingEntity> {
    @NotNull
    private final HashMap<String, Activity> refMap;
    @Nullable
    private Function3<? super BrainFunctionProvider, ? super ServerLevel, ? super T, Unit> tickFunc;
    @Nullable
    private Function0<? extends Set<? extends MemoryModuleType<?>>> requireFunc;
    private boolean scanTimeSet;
    private int scanTime;

    public SensorBuilder(@NotNull HashMap<String, Activity> refMap) {
        Intrinsics.checkNotNullParameter(refMap, (String)"refMap");
        this.refMap = refMap;
        this.scanTime = 20;
    }

    @NotNull
    public final HashMap<String, Activity> getRefMap() {
        return this.refMap;
    }

    public final int getScanTime() {
        return this.scanTime;
    }

    public final void setScanTime(int v) {
        if (this.scanTimeSet) {
            throw new RuntimeException("scan time was already set");
        }
        this.scanTime = v;
        this.scanTimeSet = true;
    }

    public final void tick(@NotNull Function3<? super BrainFunctionProvider, ? super ServerLevel, ? super T, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        if (this.tickFunc != null) {
            throw new RuntimeException("tick already defined");
        }
        this.tickFunc = func;
    }

    public final void requirements(MemoryModuleType<?> ... params) {
        Intrinsics.checkNotNullParameter(params, (String)"params");
        Set params2 = ArraysKt.toSet((Object[])params);
        if (this.requireFunc != null) {
            throw new RuntimeException("require already defined");
        }
        this.requireFunc = () -> SensorBuilder.requirements$lambda$0(params2);
    }

    @NotNull
    public final Sensor<T> build$brokencore_common() {
        if (this.tickFunc == null) {
            throw new NullPointerException("tick not defined");
        }
        if (this.requireFunc == null) {
            throw new NullPointerException("require not defined");
        }
        Function3<? super BrainFunctionProvider, ? super ServerLevel, ? super T, Unit> function3 = this.tickFunc;
        Intrinsics.checkNotNull(function3);
        Function0<? extends Set<? extends MemoryModuleType<?>>> function0 = this.requireFunc;
        Intrinsics.checkNotNull(function0);
        return new BrainSensor<T>(this.scanTime, function3, function0, this.refMap);
    }

    private static final Set requirements$lambda$0(Set $params) {
        return $params;
    }
}

