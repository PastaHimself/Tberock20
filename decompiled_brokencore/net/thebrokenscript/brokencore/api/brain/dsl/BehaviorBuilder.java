/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntRange
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.memory.MemoryModuleType
 *  net.minecraft.world.entity.ai.memory.MemoryStatus
 *  net.minecraft.world.entity.schedule.Activity
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.brain.dsl;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.schedule.Activity;
import net.thebrokenscript.brokencore.api.brain.dsl.BrainFunctionProvider;
import net.thebrokenscript.brokencore.api.brain.dsl.MemoryRequireBuilder;
import net.thebrokenscript.brokencore.api.brain.util.BrainBehavior;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B#\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010%\u001a\u00020\u00182\u001c\u0010&\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00180!\u00a2\u0006\u0002\b(\u00a2\u0006\u0002\b\u0019Jc\u0010)\u001a\u00020\u00182[\u0010*\u001aW\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u000f\u00a2\u0006\u0002\b(\u00a2\u0006\u0002\b\u0019Jc\u0010+\u001a\u00020\u00182[\u0010*\u001aW\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u000f\u00a2\u0006\u0002\b(\u00a2\u0006\u0002\b\u0019Jc\u0010,\u001a\u00020\u00182[\u0010*\u001aW\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u000f\u00a2\u0006\u0002\b(\u00a2\u0006\u0002\b\u0019Jc\u0010-\u001a\u00020\u00182[\u0010*\u001aW\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u001d0\u000f\u00a2\u0006\u0002\b(\u00a2\u0006\u0002\b\u0019JN\u0010\u001e\u001a\u00020\u00182F\u0010*\u001aB\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u001d0\u001f\u00a2\u0006\u0002\b(\u00a2\u0006\u0002\b\u0019J.\u0010.\u001a\u00020\u00182&\u0010*\u001a\"\u0012\u0018\u0012\u00160\u0016\u00a2\u0006\u0002\b(\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u001d0!J\u0013\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0000\u00a2\u0006\u0002\b1R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R`\u0010\u000e\u001aT\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000f\u00a2\u0006\u0002\b\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R`\u0010\u001a\u001aT\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000f\u00a2\u0006\u0002\b\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R`\u0010\u001b\u001aT\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000f\u00a2\u0006\u0002\b\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R`\u0010\u001c\u001aT\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u000f\u00a2\u0006\u0002\b\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000RK\u0010\u001e\u001a?\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001f\u00a2\u0006\u0002\b\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R+\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u001d\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\"\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030#\u0012\u0004\u0012\u00020$\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2={"Lnet/thebrokenscript/brokencore/api/brain/dsl/BehaviorBuilder;", "T", "Lnet/minecraft/world/entity/LivingEntity;", "", "refMap", "", "", "Lnet/minecraft/world/entity/schedule/Activity;", "runtimeRange", "Lkotlin/ranges/IntRange;", "<init>", "(Ljava/util/Map;Lkotlin/ranges/IntRange;)V", "getRefMap", "()Ljava/util/Map;", "startFunc", "Lkotlin/Function4;", "Lnet/thebrokenscript/brokencore/api/brain/dsl/BrainFunctionProvider;", "Lnet/minecraft/server/level/ServerLevel;", "Lkotlin/ParameterName;", "name", "level", "owner", "", "gameTime", "", "Lkotlin/ExtensionFunctionType;", "tickFunc", "stopFunc", "canStillUseFunc", "", "extraStartConditions", "Lkotlin/Function3;", "timedOutFunc", "Lkotlin/Function1;", "requiredMemories", "Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;", "Lnet/minecraft/world/entity/ai/memory/MemoryStatus;", "require", "builder", "Lnet/thebrokenscript/brokencore/api/brain/dsl/MemoryRequireBuilder;", "Lnet/thebrokenscript/brokencore/api/brain/dsl/BrainBuilderMarker;", "stop", "func", "tick", "start", "canStillUse", "timedOut", "build", "Lnet/thebrokenscript/brokencore/api/brain/util/BrainBehavior;", "build$brokencore_common", "brokencore-common"})
public final class BehaviorBuilder<T extends LivingEntity> {
    @NotNull
    private final Map<String, Activity> refMap;
    @NotNull
    private final IntRange runtimeRange;
    @Nullable
    private Function4<? super BrainFunctionProvider, ? super ServerLevel, ? super T, ? super Long, Unit> startFunc;
    @Nullable
    private Function4<? super BrainFunctionProvider, ? super ServerLevel, ? super T, ? super Long, Unit> tickFunc;
    @Nullable
    private Function4<? super BrainFunctionProvider, ? super ServerLevel, ? super T, ? super Long, Unit> stopFunc;
    @Nullable
    private Function4<? super BrainFunctionProvider, ? super ServerLevel, ? super T, ? super Long, Boolean> canStillUseFunc;
    @Nullable
    private Function3<? super BrainFunctionProvider, ? super ServerLevel, ? super T, Boolean> extraStartConditions;
    @Nullable
    private Function1<? super Long, Boolean> timedOutFunc;
    @Nullable
    private Map<MemoryModuleType<?>, ? extends MemoryStatus> requiredMemories;

    public BehaviorBuilder(@NotNull Map<String, ? extends Activity> refMap, @NotNull IntRange runtimeRange) {
        Intrinsics.checkNotNullParameter(refMap, (String)"refMap");
        Intrinsics.checkNotNullParameter((Object)runtimeRange, (String)"runtimeRange");
        this.refMap = refMap;
        this.runtimeRange = runtimeRange;
    }

    @NotNull
    public final Map<String, Activity> getRefMap() {
        return this.refMap;
    }

    public final void require(@NotNull Function1<? super MemoryRequireBuilder, Unit> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        if (this.requiredMemories != null) {
            throw new RuntimeException("require already defined");
        }
        MemoryRequireBuilder builderObj = new MemoryRequireBuilder();
        builder.invoke((Object)builderObj);
        this.requiredMemories = builderObj.build$brokencore_common();
    }

    public final void stop(@NotNull Function4<? super BrainFunctionProvider, ? super ServerLevel, ? super T, ? super Long, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        if (this.stopFunc != null) {
            throw new RuntimeException("stopFunc already defined");
        }
        this.stopFunc = func;
    }

    public final void tick(@NotNull Function4<? super BrainFunctionProvider, ? super ServerLevel, ? super T, ? super Long, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        if (this.tickFunc != null) {
            throw new RuntimeException("tick already defined");
        }
        this.tickFunc = func;
    }

    public final void start(@NotNull Function4<? super BrainFunctionProvider, ? super ServerLevel, ? super T, ? super Long, Unit> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        if (this.startFunc != null) {
            throw new RuntimeException("startFunc already defined");
        }
        this.startFunc = func;
    }

    public final void canStillUse(@NotNull Function4<? super BrainFunctionProvider, ? super ServerLevel, ? super T, ? super Long, Boolean> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        if (this.canStillUseFunc != null) {
            throw new RuntimeException("canStillUse already defined");
        }
        this.canStillUseFunc = func;
    }

    public final void extraStartConditions(@NotNull Function3<? super BrainFunctionProvider, ? super ServerLevel, ? super T, Boolean> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        if (this.extraStartConditions != null) {
            throw new RuntimeException("extraStartConditions already defined");
        }
        this.extraStartConditions = func;
    }

    public final void timedOut(@NotNull Function1<? super Long, Boolean> func) {
        Intrinsics.checkNotNullParameter(func, (String)"func");
        if (this.timedOutFunc != null) {
            throw new RuntimeException("timedOut already defined");
        }
        this.timedOutFunc = func;
    }

    @NotNull
    public final BrainBehavior<T> build$brokencore_common() {
        return new BrainBehavior<T>(this.runtimeRange, this.requiredMemories, this.startFunc, this.tickFunc, this.stopFunc, this.canStillUseFunc, this.extraStartConditions, this.refMap, this.timedOutFunc);
    }
}

