/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.world.food.FoodProperties$Builder
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.SoundType
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.block.state.BlockState
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.ext;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0005J\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0005J\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0005J\n\u0010\b\u001a\u00020\u0005*\u00020\u0005J\n\u0010\t\u001a\u00020\u0005*\u00020\u0005J\u0012\u0010\n\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ#\u0010\r\u001a\u00020\u000e*\u00020\u000e2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010\u00a2\u0006\u0002\b\u0013\u00a8\u0006\u0014"}, d2={"Lnet/thebrokenscript/brokencore/api/ext/PropertiesExt;", "", "<init>", "()V", "noSound", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "nonConductive", "postProcess", "emissive", "indestructible", "light", "value", "", "foodProps", "Lnet/minecraft/world/item/Item$Properties;", "block", "Lkotlin/Function1;", "Lnet/minecraft/world/food/FoodProperties$Builder;", "", "Lkotlin/ExtensionFunctionType;", "brokencore-common"})
public final class PropertiesExt {
    @NotNull
    public static final PropertiesExt INSTANCE = new PropertiesExt();

    private PropertiesExt() {
    }

    @NotNull
    public final BlockBehaviour.Properties noSound(@NotNull BlockBehaviour.Properties $this$noSound) {
        Intrinsics.checkNotNullParameter((Object)$this$noSound, (String)"<this>");
        BlockBehaviour.Properties properties = $this$noSound.sound(SoundType.EMPTY);
        Intrinsics.checkNotNullExpressionValue((Object)properties, (String)"sound(...)");
        return properties;
    }

    @NotNull
    public final BlockBehaviour.Properties nonConductive(@NotNull BlockBehaviour.Properties $this$nonConductive) {
        Intrinsics.checkNotNullParameter((Object)$this$nonConductive, (String)"<this>");
        BlockBehaviour.Properties properties = $this$nonConductive.isRedstoneConductor(PropertiesExt::nonConductive$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)properties, (String)"isRedstoneConductor(...)");
        return properties;
    }

    @NotNull
    public final BlockBehaviour.Properties postProcess(@NotNull BlockBehaviour.Properties $this$postProcess) {
        Intrinsics.checkNotNullParameter((Object)$this$postProcess, (String)"<this>");
        BlockBehaviour.Properties properties = $this$postProcess.hasPostProcess(PropertiesExt::postProcess$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)properties, (String)"hasPostProcess(...)");
        return properties;
    }

    @NotNull
    public final BlockBehaviour.Properties emissive(@NotNull BlockBehaviour.Properties $this$emissive) {
        Intrinsics.checkNotNullParameter((Object)$this$emissive, (String)"<this>");
        BlockBehaviour.Properties properties = $this$emissive.emissiveRendering(PropertiesExt::emissive$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)properties, (String)"emissiveRendering(...)");
        return properties;
    }

    @NotNull
    public final BlockBehaviour.Properties indestructible(@NotNull BlockBehaviour.Properties $this$indestructible) {
        Intrinsics.checkNotNullParameter((Object)$this$indestructible, (String)"<this>");
        BlockBehaviour.Properties properties = $this$indestructible.strength(-1.0f, 3600000.0f);
        Intrinsics.checkNotNullExpressionValue((Object)properties, (String)"strength(...)");
        return properties;
    }

    @NotNull
    public final BlockBehaviour.Properties light(@NotNull BlockBehaviour.Properties $this$light, int value) {
        Intrinsics.checkNotNullParameter((Object)$this$light, (String)"<this>");
        BlockBehaviour.Properties properties = $this$light.lightLevel(arg_0 -> PropertiesExt.light$lambda$0(value, arg_0));
        Intrinsics.checkNotNullExpressionValue((Object)properties, (String)"lightLevel(...)");
        return properties;
    }

    @NotNull
    public final Item.Properties foodProps(@NotNull Item.Properties $this$foodProps, @NotNull Function1<? super FoodProperties.Builder, Unit> block2) {
        Intrinsics.checkNotNullParameter((Object)$this$foodProps, (String)"<this>");
        Intrinsics.checkNotNullParameter(block2, (String)"block");
        FoodProperties.Builder builder = new FoodProperties.Builder();
        block2.invoke((Object)builder);
        Item.Properties properties = $this$foodProps.food(builder.build());
        Intrinsics.checkNotNullExpressionValue((Object)properties, (String)"food(...)");
        return properties;
    }

    private static final boolean nonConductive$lambda$0(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static final boolean postProcess$lambda$0(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return true;
    }

    private static final boolean emissive$lambda$0(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return true;
    }

    private static final int light$lambda$0(int $value, BlockState it) {
        return $value;
    }
}

