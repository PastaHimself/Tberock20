/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.PrimitiveCodec
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.optionals.OptionalsKt
 *  kotlin.ranges.IntRange
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.ai.behavior.BehaviorControl
 *  net.minecraft.world.entity.ai.memory.MemoryModuleType
 *  net.minecraft.world.entity.ai.memory.MemoryStatus
 *  net.minecraft.world.entity.schedule.Activity
 *  net.minecraft.world.level.block.Blocks
 */
package net.thebrokenscript.brokencore.api.brain.example;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.PrimitiveCodec;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.optionals.OptionalsKt;
import kotlin.ranges.IntRange;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.BehaviorControl;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraft.world.level.block.Blocks;
import net.thebrokenscript.brokencore.api.BCApi;
import net.thebrokenscript.brokencore.api.brain.dsl.ActivityBuilder;
import net.thebrokenscript.brokencore.api.brain.dsl.BehaviorBuilder;
import net.thebrokenscript.brokencore.api.brain.dsl.BrainBuilder;
import net.thebrokenscript.brokencore.api.brain.dsl.BrainFunctionProvider;
import net.thebrokenscript.brokencore.api.brain.dsl.MemoryRequireBuilder;
import net.thebrokenscript.brokencore.api.brain.dsl.SensorBuilder;
import net.thebrokenscript.brokencore.api.brain.util.BrainBehavior;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/brokencore/api/brain/example/BrainBuilderExample;", "", "<init>", "()V", "test", "", "brokencore-common"})
public final class BrainBuilderExample {
    public final void test() {
        BrainBuilder.Companion.invoke(BrainBuilderExample::test$lambda$0);
    }

    private static final Unit test$lambda$0(BrainBuilder $this$BrainBuilder) {
        Intrinsics.checkNotNullParameter((Object)$this$BrainBuilder, (String)"$this$BrainBuilder");
        PrimitiveCodec primitiveCodec = Codec.INT;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec, (String)"INT");
        MemoryModuleType spinTime = $this$BrainBuilder.of((Codec)primitiveCodec, BCApi.id("spinTime"));
        PrimitiveCodec primitiveCodec2 = Codec.BOOL;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec2, (String)"BOOL");
        MemoryModuleType spanTooMuch = $this$BrainBuilder.of((Codec)primitiveCodec2, BCApi.id("spanTooMuch"));
        PrimitiveCodec primitiveCodec3 = Codec.BOOL;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec3, (String)"BOOL");
        MemoryModuleType onStone = $this$BrainBuilder.of((Codec)primitiveCodec3, BCApi.id("onStone"));
        BrainBehavior dieIfSpanTooMuch = $this$BrainBuilder.behavior(1, arg_0 -> BrainBuilderExample.test$lambda$0$0(spanTooMuch, onStone, arg_0));
        BrainBehavior explodeIfSpanTooMuch = $this$BrainBuilder.behavior(1, arg_0 -> BrainBuilderExample.test$lambda$0$1(spanTooMuch, onStone, arg_0));
        BrainBehavior tickSpinValue = $this$BrainBuilder.behavior(new IntRange(1, 200), arg_0 -> BrainBuilderExample.test$lambda$0$2(spanTooMuch, spinTime, onStone, arg_0));
        Activity death = $this$BrainBuilder.activity(BCApi.id("death"), arg_0 -> BrainBuilderExample.test$lambda$0$3(spinTime, onStone, dieIfSpanTooMuch, explodeIfSpanTooMuch, arg_0));
        Activity spin = $this$BrainBuilder.activity(BCApi.id("spin"), arg_0 -> BrainBuilderExample.test$lambda$0$4(tickSpinValue, arg_0));
        $this$BrainBuilder.setDefaultActivity(spin);
        $this$BrainBuilder.sensor(BCApi.id("checkOnStone"), arg_0 -> BrainBuilderExample.test$lambda$0$5(spinTime, spanTooMuch, onStone, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit test$lambda$0$0(MemoryModuleType $spanTooMuch, MemoryModuleType $onStone, BehaviorBuilder $this$behavior) {
        Intrinsics.checkNotNullParameter((Object)$this$behavior, (String)"$this$behavior");
        $this$behavior.start((arg_0, arg_1, arg_2, arg_3) -> BrainBuilderExample.test$lambda$0$0$0($spanTooMuch, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.require((Function1<MemoryRequireBuilder, Unit>)((Function1)arg_0 -> BrainBuilderExample.test$lambda$0$0$1($spanTooMuch, arg_0)));
        $this$behavior.extraStartConditions((arg_0, arg_1, arg_2) -> BrainBuilderExample.test$lambda$0$0$2($onStone, arg_0, arg_1, arg_2));
        return Unit.INSTANCE;
    }

    private static final Unit test$lambda$0$0$0(MemoryModuleType $spanTooMuch, BrainFunctionProvider $this$start, ServerLevel serverLevel, LivingEntity owner, long l) {
        Intrinsics.checkNotNullParameter((Object)$this$start, (String)"$this$start");
        Intrinsics.checkNotNullParameter((Object)serverLevel, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        if ($this$start.get((MemoryModuleType<Boolean>)$spanTooMuch)) {
            owner.kill();
        }
        return Unit.INSTANCE;
    }

    private static final Unit test$lambda$0$0$1(MemoryModuleType $spanTooMuch, MemoryRequireBuilder $this$require) {
        Intrinsics.checkNotNullParameter((Object)$this$require, (String)"$this$require");
        $this$require.of($spanTooMuch, MemoryStatus.VALUE_PRESENT);
        return Unit.INSTANCE;
    }

    private static final boolean test$lambda$0$0$2(MemoryModuleType $onStone, BrainFunctionProvider $this$extraStartConditions, ServerLevel serverLevel, LivingEntity livingEntity) {
        Intrinsics.checkNotNullParameter((Object)$this$extraStartConditions, (String)"$this$extraStartConditions");
        Intrinsics.checkNotNullParameter((Object)serverLevel, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)livingEntity, (String)"<unused var>");
        return $this$extraStartConditions.get((MemoryModuleType<Boolean>)$onStone);
    }

    private static final Unit test$lambda$0$1(MemoryModuleType $spanTooMuch, MemoryModuleType $onStone, BehaviorBuilder $this$behavior) {
        Intrinsics.checkNotNullParameter((Object)$this$behavior, (String)"$this$behavior");
        $this$behavior.start((arg_0, arg_1, arg_2, arg_3) -> BrainBuilderExample.test$lambda$0$1$0($spanTooMuch, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.require((Function1<MemoryRequireBuilder, Unit>)((Function1)arg_0 -> BrainBuilderExample.test$lambda$0$1$1($spanTooMuch, arg_0)));
        $this$behavior.extraStartConditions((arg_0, arg_1, arg_2) -> BrainBuilderExample.test$lambda$0$1$2($onStone, arg_0, arg_1, arg_2));
        return Unit.INSTANCE;
    }

    private static final Unit test$lambda$0$1$0(MemoryModuleType $spanTooMuch, BrainFunctionProvider $this$start, ServerLevel serverLevel, LivingEntity owner, long l) {
        Intrinsics.checkNotNullParameter((Object)$this$start, (String)"$this$start");
        Intrinsics.checkNotNullParameter((Object)serverLevel, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        if ($this$start.get((MemoryModuleType<Boolean>)$spanTooMuch)) {
            owner.kill();
        }
        return Unit.INSTANCE;
    }

    private static final Unit test$lambda$0$1$1(MemoryModuleType $spanTooMuch, MemoryRequireBuilder $this$require) {
        Intrinsics.checkNotNullParameter((Object)$this$require, (String)"$this$require");
        $this$require.of($spanTooMuch, MemoryStatus.VALUE_PRESENT);
        return Unit.INSTANCE;
    }

    private static final boolean test$lambda$0$1$2(MemoryModuleType $onStone, BrainFunctionProvider $this$extraStartConditions, ServerLevel serverLevel, LivingEntity livingEntity) {
        Intrinsics.checkNotNullParameter((Object)$this$extraStartConditions, (String)"$this$extraStartConditions");
        Intrinsics.checkNotNullParameter((Object)serverLevel, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)livingEntity, (String)"<unused var>");
        return $this$extraStartConditions.get((MemoryModuleType<Boolean>)$onStone);
    }

    private static final Unit test$lambda$0$2(MemoryModuleType $spanTooMuch, MemoryModuleType $spinTime, MemoryModuleType $onStone, BehaviorBuilder $this$behavior) {
        Intrinsics.checkNotNullParameter((Object)$this$behavior, (String)"$this$behavior");
        $this$behavior.start(BrainBuilderExample::test$lambda$0$2$0);
        $this$behavior.tick((arg_0, arg_1, arg_2, arg_3) -> BrainBuilderExample.test$lambda$0$2$1($spanTooMuch, $spinTime, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.canStillUse((arg_0, arg_1, arg_2, arg_3) -> BrainBuilderExample.test$lambda$0$2$2($onStone, arg_0, arg_1, arg_2, arg_3));
        return Unit.INSTANCE;
    }

    private static final Unit test$lambda$0$2$0(BrainFunctionProvider $this$start, ServerLevel serverLevel, LivingEntity owner, long l) {
        Intrinsics.checkNotNullParameter((Object)$this$start, (String)"$this$start");
        Intrinsics.checkNotNullParameter((Object)serverLevel, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        owner.setYBodyRot(0.0f);
        return Unit.INSTANCE;
    }

    private static final Unit test$lambda$0$2$1(MemoryModuleType $spanTooMuch, MemoryModuleType $spinTime, BrainFunctionProvider $this$tick, ServerLevel serverLevel, LivingEntity owner, long l) {
        Intrinsics.checkNotNullParameter((Object)$this$tick, (String)"$this$tick");
        Intrinsics.checkNotNullParameter((Object)serverLevel, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        if ($this$tick.get((MemoryModuleType<Boolean>)$spanTooMuch)) {
            $this$tick.doActivityIfValid("death");
        }
        if ($this$tick.get((MemoryModuleType<Integer>)$spinTime) > 200) {
            $this$tick.set($spanTooMuch, true);
        }
        $this$tick.inc((MemoryModuleType<Integer>)$spinTime, 4);
        owner.setYBodyRot(owner.yBodyRot + (float)4);
        return Unit.INSTANCE;
    }

    private static final boolean test$lambda$0$2$2(MemoryModuleType $onStone, BrainFunctionProvider $this$canStillUse, ServerLevel serverLevel, LivingEntity livingEntity, long l) {
        Intrinsics.checkNotNullParameter((Object)$this$canStillUse, (String)"$this$canStillUse");
        Intrinsics.checkNotNullParameter((Object)serverLevel, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)livingEntity, (String)"<unused var>");
        return $this$canStillUse.get((MemoryModuleType<Boolean>)$onStone);
    }

    private static final Unit test$lambda$0$3(MemoryModuleType $spinTime, MemoryModuleType $onStone, BrainBehavior $dieIfSpanTooMuch, BrainBehavior $explodeIfSpanTooMuch, ActivityBuilder $this$activity) {
        Intrinsics.checkNotNullParameter((Object)$this$activity, (String)"$this$activity");
        ActivityBuilder.random$default($this$activity, 0, arg_0 -> BrainBuilderExample.test$lambda$0$3$0($dieIfSpanTooMuch, $explodeIfSpanTooMuch, arg_0), 1, null);
        ActivityBuilder.single$default($this$activity, 4, 0, BrainBuilderExample::test$lambda$0$3$1, 2, null);
        $this$activity.require((Function1<ActivityBuilder.ActivityConditionBuilder, Unit>)((Function1)arg_0 -> BrainBuilderExample.test$lambda$0$3$2($spinTime, $onStone, arg_0)));
        MemoryModuleType[] memoryModuleTypeArray = new MemoryModuleType[]{$spinTime, $onStone};
        $this$activity.forget(memoryModuleTypeArray);
        return Unit.INSTANCE;
    }

    private static final Unit test$lambda$0$3$0(BrainBehavior $dieIfSpanTooMuch, BrainBehavior $explodeIfSpanTooMuch, ActivityBuilder $this$random) {
        Intrinsics.checkNotNullParameter((Object)$this$random, (String)"$this$random");
        ActivityBuilder.single$default($this$random, (BehaviorControl)$dieIfSpanTooMuch, 0, 2, null);
        ActivityBuilder.single$default($this$random, (BehaviorControl)$explodeIfSpanTooMuch, 0, 2, null);
        ActivityBuilder.random$default($this$random, 0, arg_0 -> BrainBuilderExample.test$lambda$0$3$0$0($explodeIfSpanTooMuch, arg_0), 1, null);
        return Unit.INSTANCE;
    }

    private static final Unit test$lambda$0$3$0$0(BrainBehavior $explodeIfSpanTooMuch, ActivityBuilder $this$random) {
        Intrinsics.checkNotNullParameter((Object)$this$random, (String)"$this$random");
        ActivityBuilder.single$default($this$random, (BehaviorControl)$explodeIfSpanTooMuch, 0, 2, null);
        return Unit.INSTANCE;
    }

    private static final Unit test$lambda$0$3$1(BehaviorBuilder $this$single) {
        Intrinsics.checkNotNullParameter((Object)$this$single, (String)"$this$single");
        $this$single.start(BrainBuilderExample::test$lambda$0$3$1$0);
        return Unit.INSTANCE;
    }

    private static final Unit test$lambda$0$3$1$0(BrainFunctionProvider $this$start, ServerLevel level, LivingEntity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$start, (String)"$this$start");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        System.out.println((Object)"shouldn't run");
        return Unit.INSTANCE;
    }

    private static final Unit test$lambda$0$3$2(MemoryModuleType $spinTime, MemoryModuleType $onStone, ActivityBuilder.ActivityConditionBuilder $this$require) {
        Intrinsics.checkNotNullParameter((Object)$this$require, (String)"$this$require");
        $this$require.of($spinTime, MemoryStatus.VALUE_ABSENT);
        $this$require.of($onStone, MemoryStatus.VALUE_PRESENT);
        return Unit.INSTANCE;
    }

    private static final Unit test$lambda$0$4(BrainBehavior $tickSpinValue, ActivityBuilder $this$activity) {
        Intrinsics.checkNotNullParameter((Object)$this$activity, (String)"$this$activity");
        ActivityBuilder.single$default($this$activity, (BehaviorControl)$tickSpinValue, 0, 2, null);
        return Unit.INSTANCE;
    }

    private static final Unit test$lambda$0$5(MemoryModuleType $spinTime, MemoryModuleType $spanTooMuch, MemoryModuleType $onStone, SensorBuilder $this$sensor) {
        Intrinsics.checkNotNullParameter((Object)$this$sensor, (String)"$this$sensor");
        $this$sensor.setScanTime(15);
        $this$sensor.tick((arg_0, arg_1, arg_2) -> BrainBuilderExample.test$lambda$0$5$0($onStone, arg_0, arg_1, arg_2));
        MemoryModuleType[] memoryModuleTypeArray = new MemoryModuleType[]{$spinTime, $spanTooMuch, $onStone};
        $this$sensor.requirements(memoryModuleTypeArray);
        return Unit.INSTANCE;
    }

    private static final Unit test$lambda$0$5$0(MemoryModuleType $onStone, BrainFunctionProvider $this$tick, ServerLevel level, LivingEntity owner) {
        Intrinsics.checkNotNullParameter((Object)$this$tick, (String)"$this$tick");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)owner, (String)"owner");
        Optional optional = owner.mainSupportingBlockPos;
        Intrinsics.checkNotNullExpressionValue((Object)optional, (String)"mainSupportingBlockPos");
        BlockPos pos = (BlockPos)OptionalsKt.getOrNull((Optional)optional);
        $this$tick.set($onStone, pos != null && Intrinsics.areEqual((Object)level.getBlockState(pos).getBlock(), (Object)Blocks.STONE));
        return Unit.INSTANCE;
    }
}

