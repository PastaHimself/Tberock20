/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.optionals.OptionalsKt
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.level.storage.loot.LootPool
 *  net.minecraft.world.level.storage.loot.LootPool$Builder
 *  net.minecraft.world.level.storage.loot.LootTable$Builder
 *  net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer$Builder
 *  net.minecraft.world.level.storage.loot.parameters.LootContextParamSet
 *  net.minecraft.world.level.storage.loot.predicates.LootItemCondition$Builder
 *  net.minecraft.world.level.storage.loot.providers.number.ConstantValue
 *  net.minecraft.world.level.storage.loot.providers.number.NumberProvider
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.brokencore.api.registry.util;

import java.util.Optional;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.optionals.OptionalsKt;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.brokencore.impl.mixin.features.loot.LootTableBuilderAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006\u001a<\u0010\u001d\u001a\u00020\u0004\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u00020\u00042\u0006\u0010 \u001a\u0002H\u001e2\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006\u00a2\u0006\u0002\u0010\"\u001aD\u0010#\u001a\u00020\u0004\"\u0010\b\u0000\u0010\u001e*\n\u0012\u0006\b\u0001\u0012\u0002H\u001e0$*\u00020\u00042\u0006\u0010 \u001a\u0002H\u001e2\u0019\b\u0002\u0010!\u001a\u0013\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\b\u0006\u00a2\u0006\u0002\u0010%\",\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\",\u0010\u000f\u001a\u0004\u0018\u00010\u000e*\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u000e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\"(\u0010\u0015\u001a\u00020\u0014*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00148F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\"(\u0010\u001a\u001a\u00020\u0014*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00148F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019\u00a8\u0006&"}, d2={"pool", "Lnet/minecraft/world/level/storage/loot/LootTable$Builder;", "builder", "Lkotlin/Function1;", "Lnet/minecraft/world/level/storage/loot/LootPool$Builder;", "", "Lkotlin/ExtensionFunctionType;", "value", "Lnet/minecraft/world/level/storage/loot/parameters/LootContextParamSet;", "paramSet", "getParamSet", "(Lnet/minecraft/world/level/storage/loot/LootTable$Builder;)Lnet/minecraft/world/level/storage/loot/parameters/LootContextParamSet;", "setParamSet", "(Lnet/minecraft/world/level/storage/loot/LootTable$Builder;Lnet/minecraft/world/level/storage/loot/parameters/LootContextParamSet;)V", "Lnet/minecraft/resources/ResourceLocation;", "randomSequence", "getRandomSequence", "(Lnet/minecraft/world/level/storage/loot/LootTable$Builder;)Lnet/minecraft/resources/ResourceLocation;", "setRandomSequence", "(Lnet/minecraft/world/level/storage/loot/LootTable$Builder;Lnet/minecraft/resources/ResourceLocation;)V", "", "rolls", "getRolls", "(Lnet/minecraft/world/level/storage/loot/LootPool$Builder;)F", "setRolls", "(Lnet/minecraft/world/level/storage/loot/LootPool$Builder;F)V", "bonusRolls", "getBonusRolls", "setBonusRolls", "condition", "T", "Lnet/minecraft/world/level/storage/loot/predicates/LootItemCondition$Builder;", "cond", "block", "(Lnet/minecraft/world/level/storage/loot/LootPool$Builder;Lnet/minecraft/world/level/storage/loot/predicates/LootItemCondition$Builder;Lkotlin/jvm/functions/Function1;)Lnet/minecraft/world/level/storage/loot/LootPool$Builder;", "entry", "Lnet/minecraft/world/level/storage/loot/entries/LootPoolEntryContainer$Builder;", "(Lnet/minecraft/world/level/storage/loot/LootPool$Builder;Lnet/minecraft/world/level/storage/loot/entries/LootPoolEntryContainer$Builder;Lkotlin/jvm/functions/Function1;)Lnet/minecraft/world/level/storage/loot/LootPool$Builder;", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nLootBuilders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LootBuilders.kt\nnet/thebrokenscript/brokencore/api/registry/util/LootBuildersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,39:1\n1#2:40\n*E\n"})
public final class LootBuildersKt {
    @NotNull
    public static final LootTable.Builder pool(@NotNull LootTable.Builder $this$pool, @NotNull Function1<? super LootPool.Builder, Unit> builder) {
        Intrinsics.checkNotNullParameter((Object)$this$pool, (String)"<this>");
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        LootPool.Builder builder2 = LootPool.lootPool();
        builder.invoke((Object)builder2);
        LootTable.Builder builder3 = $this$pool.withPool(builder2);
        Intrinsics.checkNotNullExpressionValue((Object)builder3, (String)"withPool(...)");
        return builder3;
    }

    @Nullable
    public static final LootContextParamSet getParamSet(@NotNull LootTable.Builder $this$paramSet) {
        Intrinsics.checkNotNullParameter((Object)$this$paramSet, (String)"<this>");
        return ((LootTableBuilderAccessor)$this$paramSet).bc$getParamSet();
    }

    public static final void setParamSet(@NotNull LootTable.Builder $this$paramSet, @Nullable LootContextParamSet value) {
        LootTable.Builder builder;
        Intrinsics.checkNotNullParameter((Object)$this$paramSet, (String)"<this>");
        LootContextParamSet lootContextParamSet = value;
        if (lootContextParamSet != null) {
            LootContextParamSet it = lootContextParamSet;
            boolean bl = false;
            builder = $this$paramSet.setParamSet(it);
        } else {
            builder = null;
        }
        MiscExt.void(builder);
    }

    @Nullable
    public static final ResourceLocation getRandomSequence(@NotNull LootTable.Builder $this$randomSequence) {
        Intrinsics.checkNotNullParameter((Object)$this$randomSequence, (String)"<this>");
        Optional<ResourceLocation> optional = ((LootTableBuilderAccessor)$this$randomSequence).bc$getRandomSequence();
        return optional != null ? (ResourceLocation)OptionalsKt.getOrNull(optional) : null;
    }

    public static final void setRandomSequence(@NotNull LootTable.Builder $this$randomSequence, @Nullable ResourceLocation value) {
        LootTable.Builder builder;
        Intrinsics.checkNotNullParameter((Object)$this$randomSequence, (String)"<this>");
        ResourceLocation resourceLocation = value;
        if (resourceLocation != null) {
            ResourceLocation it = resourceLocation;
            boolean bl = false;
            builder = $this$randomSequence.setRandomSequence(it);
        } else {
            builder = null;
        }
        MiscExt.void(builder);
    }

    public static final float getRolls(@NotNull LootPool.Builder $this$rolls) {
        Intrinsics.checkNotNullParameter((Object)$this$rolls, (String)"<this>");
        return 0.0f;
    }

    public static final void setRolls(@NotNull LootPool.Builder $this$rolls, float value) {
        Intrinsics.checkNotNullParameter((Object)$this$rolls, (String)"<this>");
        MiscExt.void($this$rolls.setRolls((NumberProvider)ConstantValue.exactly((float)value)));
    }

    public static final float getBonusRolls(@NotNull LootPool.Builder $this$bonusRolls) {
        Intrinsics.checkNotNullParameter((Object)$this$bonusRolls, (String)"<this>");
        return 0.0f;
    }

    public static final void setBonusRolls(@NotNull LootPool.Builder $this$bonusRolls, float value) {
        Intrinsics.checkNotNullParameter((Object)$this$bonusRolls, (String)"<this>");
        MiscExt.void($this$bonusRolls.setBonusRolls((NumberProvider)ConstantValue.exactly((float)value)));
    }

    @NotNull
    public static final <T extends LootItemCondition.Builder> LootPool.Builder condition(@NotNull LootPool.Builder $this$condition, @NotNull T cond, @NotNull Function1<? super T, Unit> block2) {
        Intrinsics.checkNotNullParameter((Object)$this$condition, (String)"<this>");
        Intrinsics.checkNotNullParameter(cond, (String)"cond");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        T t = cond;
        block2.invoke(t);
        LootPool.Builder builder = $this$condition.when(t);
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"when(...)");
        return builder;
    }

    public static /* synthetic */ LootPool.Builder condition$default(LootPool.Builder builder, LootItemCondition.Builder builder2, Function1 function1, int n, Object object) {
        if ((n & 2) != 0) {
            function1 = LootBuildersKt::condition$lambda$0;
        }
        return LootBuildersKt.condition(builder, builder2, function1);
    }

    @NotNull
    public static final <T extends LootPoolEntryContainer.Builder<? extends T>> LootPool.Builder entry(@NotNull LootPool.Builder $this$entry, @NotNull T cond, @NotNull Function1<? super T, Unit> block2) {
        Intrinsics.checkNotNullParameter((Object)$this$entry, (String)"<this>");
        Intrinsics.checkNotNullParameter(cond, (String)"cond");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        T t = cond;
        block2.invoke(t);
        LootPool.Builder builder = $this$entry.add(t);
        Intrinsics.checkNotNullExpressionValue((Object)builder, (String)"add(...)");
        return builder;
    }

    public static /* synthetic */ LootPool.Builder entry$default(LootPool.Builder builder, LootPoolEntryContainer.Builder builder2, Function1 function1, int n, Object object) {
        if ((n & 2) != 0) {
            function1 = LootBuildersKt::entry$lambda$0;
        }
        return LootBuildersKt.entry(builder, builder2, function1);
    }

    private static final Unit condition$lambda$0(LootItemCondition.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"<this>");
        return Unit.INSTANCE;
    }

    private static final Unit entry$lambda$0(LootPoolEntryContainer.Builder builder) {
        Intrinsics.checkNotNullParameter((Object)builder, (String)"<this>");
        return Unit.INSTANCE;
    }
}

