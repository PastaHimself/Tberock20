/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.functions.Function4
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.IntRange
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.behavior.Behavior
 *  net.minecraft.world.entity.ai.memory.MemoryModuleType
 *  net.minecraft.world.entity.ai.memory.MemoryStatus
 *  net.minecraft.world.entity.schedule.Activity
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.brain.util;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.schedule.Activity;
import net.thebrokenscript.brokencore.api.brain.dsl.BrainFunctionProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u009b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012Z\b\u0002\u0010\n\u001aT\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b\u00a2\u0006\u0002\b\u0015\u0012Z\b\u0002\u0010\u0016\u001aT\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b\u00a2\u0006\u0002\b\u0015\u0012Z\b\u0002\u0010\u0017\u001aT\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b\u00a2\u0006\u0002\b\u0015\u0012Z\b\u0002\u0010\u0018\u001aT\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000b\u00a2\u0006\u0002\b\u0015\u0012E\b\u0002\u0010\u001a\u001a?\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001b\u00a2\u0006\u0002\b\u0015\u0012\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u0007\u0012%\b\u0002\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0019\u0018\u00010 \u00a2\u0006\u0004\b!\u0010\"J%\u00100\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\r2\u0006\u00101\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0014\u00a2\u0006\u0002\u00102J%\u00103\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\r2\u0006\u00101\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0014\u00a2\u0006\u0002\u00102J%\u00104\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\r2\u0006\u00101\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0014\u00a2\u0006\u0002\u00102J%\u00105\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\r2\u0006\u00101\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0014\u00a2\u0006\u0002\u00106J\u001d\u00107\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u00108J\u0010\u00109\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0012H\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$Rc\u0010\n\u001aT\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b\u00a2\u0006\u0002\b\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&Rc\u0010\u0016\u001aT\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b\u00a2\u0006\u0002\b\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010&Rc\u0010\u0017\u001aT\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000b\u00a2\u0006\u0002\b\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010&Rc\u0010\u0018\u001aT\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000b\u00a2\u0006\u0002\b\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010&RN\u0010\u001a\u001a?\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001b\u00a2\u0006\u0002\b\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001d\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R.\u0010\u001f\u001a\u001f\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0019\u0018\u00010 \u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/\u00a8\u0006:"}, d2={"Lnet/thebrokenscript/brokencore/api/brain/util/BrainBehavior;", "T", "Lnet/minecraft/world/entity/LivingEntity;", "Lnet/minecraft/world/entity/ai/behavior/Behavior;", "runtimeRange", "Lkotlin/ranges/IntRange;", "entryCondition", "", "Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;", "Lnet/minecraft/world/entity/ai/memory/MemoryStatus;", "startFunc", "Lkotlin/Function4;", "Lnet/thebrokenscript/brokencore/api/brain/dsl/BrainFunctionProvider;", "Lnet/minecraft/server/level/ServerLevel;", "Lkotlin/ParameterName;", "name", "level", "owner", "", "gameTime", "", "Lkotlin/ExtensionFunctionType;", "tickFunc", "stopFunc", "canStillUseFunc", "", "extraStartConditions", "Lkotlin/Function3;", "refMap", "", "Lnet/minecraft/world/entity/schedule/Activity;", "timedOutFunc", "Lkotlin/Function1;", "<init>", "(Lkotlin/ranges/IntRange;Ljava/util/Map;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function3;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "getRuntimeRange", "()Lkotlin/ranges/IntRange;", "getStartFunc", "()Lkotlin/jvm/functions/Function4;", "getTickFunc", "getStopFunc", "getCanStillUseFunc", "getExtraStartConditions", "()Lkotlin/jvm/functions/Function3;", "getRefMap", "()Ljava/util/Map;", "getTimedOutFunc", "()Lkotlin/jvm/functions/Function1;", "start", "entity", "(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;J)V", "stop", "tick", "canStillUse", "(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;J)Z", "checkExtraStartConditions", "(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;)Z", "timedOut", "brokencore-common"})
public final class BrainBehavior<T extends LivingEntity>
extends Behavior<T> {
    @NotNull
    private final IntRange runtimeRange;
    @Nullable
    private final Function4<BrainFunctionProvider, ServerLevel, T, Long, Unit> startFunc;
    @Nullable
    private final Function4<BrainFunctionProvider, ServerLevel, T, Long, Unit> tickFunc;
    @Nullable
    private final Function4<BrainFunctionProvider, ServerLevel, T, Long, Unit> stopFunc;
    @Nullable
    private final Function4<BrainFunctionProvider, ServerLevel, T, Long, Boolean> canStillUseFunc;
    @Nullable
    private final Function3<BrainFunctionProvider, ServerLevel, T, Boolean> extraStartConditions;
    @NotNull
    private final Map<String, Activity> refMap;
    @Nullable
    private final Function1<Long, Boolean> timedOutFunc;

    public BrainBehavior(@NotNull IntRange runtimeRange, @Nullable Map<MemoryModuleType<?>, ? extends MemoryStatus> entryCondition, @Nullable Function4<? super BrainFunctionProvider, ? super ServerLevel, ? super T, ? super Long, Unit> startFunc, @Nullable Function4<? super BrainFunctionProvider, ? super ServerLevel, ? super T, ? super Long, Unit> tickFunc, @Nullable Function4<? super BrainFunctionProvider, ? super ServerLevel, ? super T, ? super Long, Unit> stopFunc, @Nullable Function4<? super BrainFunctionProvider, ? super ServerLevel, ? super T, ? super Long, Boolean> canStillUseFunc, @Nullable Function3<? super BrainFunctionProvider, ? super ServerLevel, ? super T, Boolean> extraStartConditions, @NotNull Map<String, ? extends Activity> refMap, @Nullable Function1<? super Long, Boolean> timedOutFunc) {
        Intrinsics.checkNotNullParameter((Object)runtimeRange, (String)"runtimeRange");
        Intrinsics.checkNotNullParameter(refMap, (String)"refMap");
        Map map = entryCondition;
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        super(map, runtimeRange.getFirst(), runtimeRange.getLast());
        this.runtimeRange = runtimeRange;
        this.startFunc = startFunc;
        this.tickFunc = tickFunc;
        this.stopFunc = stopFunc;
        this.canStillUseFunc = canStillUseFunc;
        this.extraStartConditions = extraStartConditions;
        this.refMap = refMap;
        this.timedOutFunc = timedOutFunc;
    }

    public /* synthetic */ BrainBehavior(IntRange intRange, Map map, Function4 function4, Function4 function42, Function4 function43, Function4 function44, Function3 function3, Map map2, Function1 function1, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 4) != 0) {
            function4 = null;
        }
        if ((n & 8) != 0) {
            function42 = null;
        }
        if ((n & 0x10) != 0) {
            function43 = null;
        }
        if ((n & 0x20) != 0) {
            function44 = null;
        }
        if ((n & 0x40) != 0) {
            function3 = null;
        }
        if ((n & 0x100) != 0) {
            function1 = null;
        }
        this(intRange, map, function4, function42, function43, function44, function3, map2, (Function1<? super Long, Boolean>)function1);
    }

    @NotNull
    public final IntRange getRuntimeRange() {
        return this.runtimeRange;
    }

    @Nullable
    public final Function4<BrainFunctionProvider, ServerLevel, T, Long, Unit> getStartFunc() {
        return this.startFunc;
    }

    @Nullable
    public final Function4<BrainFunctionProvider, ServerLevel, T, Long, Unit> getTickFunc() {
        return this.tickFunc;
    }

    @Nullable
    public final Function4<BrainFunctionProvider, ServerLevel, T, Long, Unit> getStopFunc() {
        return this.stopFunc;
    }

    @Nullable
    public final Function4<BrainFunctionProvider, ServerLevel, T, Long, Boolean> getCanStillUseFunc() {
        return this.canStillUseFunc;
    }

    @Nullable
    public final Function3<BrainFunctionProvider, ServerLevel, T, Boolean> getExtraStartConditions() {
        return this.extraStartConditions;
    }

    @NotNull
    public final Map<String, Activity> getRefMap() {
        return this.refMap;
    }

    @Nullable
    public final Function1<Long, Boolean> getTimedOutFunc() {
        return this.timedOutFunc;
    }

    protected void start(@NotNull ServerLevel level, @NotNull T entity, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        if (this.startFunc != null) {
            this.startFunc.invoke((Object)new BrainFunctionProvider((Pair<? extends LivingEntity, ? extends Map<String, ? extends Activity>>)TuplesKt.to(entity, this.refMap)), (Object)level, entity, (Object)gameTime);
        }
    }

    protected void stop(@NotNull ServerLevel level, @NotNull T entity, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        if (this.stopFunc != null) {
            this.stopFunc.invoke((Object)new BrainFunctionProvider((Pair<? extends LivingEntity, ? extends Map<String, ? extends Activity>>)TuplesKt.to(entity, this.refMap)), (Object)level, entity, (Object)gameTime);
        }
    }

    protected void tick(@NotNull ServerLevel level, @NotNull T entity, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        if (this.tickFunc != null) {
            this.tickFunc.invoke((Object)new BrainFunctionProvider((Pair<? extends LivingEntity, ? extends Map<String, ? extends Activity>>)TuplesKt.to(entity, this.refMap)), (Object)level, entity, (Object)gameTime);
        }
    }

    protected boolean canStillUse(@NotNull ServerLevel level, @NotNull T entity, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
        Function4<BrainFunctionProvider, ServerLevel, T, Long, Boolean> function4 = this.canStillUseFunc;
        return function4 != null ? (Boolean)function4.invoke((Object)new BrainFunctionProvider((Pair<? extends LivingEntity, ? extends Map<String, ? extends Activity>>)TuplesKt.to(entity, this.refMap)), (Object)level, entity, (Object)gameTime) : true;
    }

    protected boolean checkExtraStartConditions(@NotNull ServerLevel level, @NotNull T owner) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter(owner, (String)"owner");
        Function3<BrainFunctionProvider, ServerLevel, T, Boolean> function3 = this.extraStartConditions;
        return function3 != null ? (Boolean)function3.invoke((Object)new BrainFunctionProvider((Pair<? extends LivingEntity, ? extends Map<String, ? extends Activity>>)TuplesKt.to(owner, this.refMap)), (Object)level, owner) : true;
    }

    protected boolean timedOut(long gameTime) {
        Function1<Long, Boolean> function1 = this.timedOutFunc;
        return function1 != null ? ((Boolean)function1.invoke((Object)gameTime)).booleanValue() : super.timedOut(gameTime);
    }
}

