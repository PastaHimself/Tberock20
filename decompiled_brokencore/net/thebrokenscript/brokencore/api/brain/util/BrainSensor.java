/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.memory.MemoryModuleType
 *  net.minecraft.world.entity.ai.sensing.Sensor
 *  net.minecraft.world.entity.schedule.Activity
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.brain.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.schedule.Activity;
import net.thebrokenscript.brokencore.api.brain.dsl.BrainFunctionProvider;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u008e\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012A\u0010\u0006\u001a=\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007\u00a2\u0006\u0002\b\u000f\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u00120\u0011\u0012\"\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017`\u0018\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00028\u0000H\u0014\u00a2\u0006\u0002\u0010\"J\u0012\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0012H\u0016RL\u0010\u0006\u001a=\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u0007\u00a2\u0006\u0002\b\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR!\u0010\u0010\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR*\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017`\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2={"Lnet/thebrokenscript/brokencore/api/brain/util/BrainSensor;", "T", "Lnet/minecraft/world/entity/LivingEntity;", "Lnet/minecraft/world/entity/ai/sensing/Sensor;", "scanRate", "", "tickFunc", "Lkotlin/Function3;", "Lnet/thebrokenscript/brokencore/api/brain/dsl/BrainFunctionProvider;", "Lnet/minecraft/server/level/ServerLevel;", "Lkotlin/ParameterName;", "name", "serverLevel", "entity", "", "Lkotlin/ExtensionFunctionType;", "requireFunc", "Lkotlin/Function0;", "", "Lnet/minecraft/world/entity/ai/memory/MemoryModuleType;", "refMap", "Ljava/util/HashMap;", "", "Lnet/minecraft/world/entity/schedule/Activity;", "Lkotlin/collections/HashMap;", "<init>", "(ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Ljava/util/HashMap;)V", "getTickFunc", "()Lkotlin/jvm/functions/Function3;", "getRequireFunc", "()Lkotlin/jvm/functions/Function0;", "doTick", "p0", "p1", "(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;)V", "requires", "brokencore-common"})
public final class BrainSensor<T extends LivingEntity>
extends Sensor<T> {
    @NotNull
    private final Function3<BrainFunctionProvider, ServerLevel, T, Unit> tickFunc;
    @NotNull
    private final Function0<Set<MemoryModuleType<?>>> requireFunc;
    @NotNull
    private final HashMap<String, Activity> refMap;

    public BrainSensor(int scanRate, @NotNull Function3<? super BrainFunctionProvider, ? super ServerLevel, ? super T, Unit> tickFunc, @NotNull Function0<? extends Set<? extends MemoryModuleType<?>>> requireFunc, @NotNull HashMap<String, Activity> refMap) {
        Intrinsics.checkNotNullParameter(tickFunc, (String)"tickFunc");
        Intrinsics.checkNotNullParameter(requireFunc, (String)"requireFunc");
        Intrinsics.checkNotNullParameter(refMap, (String)"refMap");
        super(scanRate);
        this.tickFunc = tickFunc;
        this.requireFunc = requireFunc;
        this.refMap = refMap;
    }

    @NotNull
    public final Function3<BrainFunctionProvider, ServerLevel, T, Unit> getTickFunc() {
        return this.tickFunc;
    }

    @NotNull
    public final Function0<Set<MemoryModuleType<?>>> getRequireFunc() {
        return this.requireFunc;
    }

    protected void doTick(@NotNull ServerLevel p0, @NotNull T p1) {
        Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
        Intrinsics.checkNotNullParameter(p1, (String)"p1");
        this.tickFunc.invoke((Object)new BrainFunctionProvider((Pair<? extends LivingEntity, ? extends Map<String, ? extends Activity>>)TuplesKt.to(p1, this.refMap)), (Object)p0, p1);
    }

    @NotNull
    public Set<MemoryModuleType<?>> requires() {
        return (Set)this.requireFunc.invoke();
    }
}

