/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmField
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.world.item.BucketItem
 *  net.minecraft.world.item.Item$Properties
 *  net.minecraft.world.item.Items
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.MapColor
 *  net.minecraft.world.level.material.PushReaction
 *  net.thebrokenscript.brokencore.api.ext.PropertiesExt
 *  net.thebrokenscript.brokencore.api.registry.builders.BlockBuilder
 *  net.thebrokenscript.brokencore.api.registry.builders.ItemBuilder
 *  net.thebrokenscript.brokencore.api.registry.objects.BlockEntry
 *  net.thebrokenscript.brokencore.api.registry.objects.ItemEntry
 *  net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.neoforge.registry;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.thebrokenscript.brokencore.api.ext.PropertiesExt;
import net.thebrokenscript.brokencore.api.registry.builders.BlockBuilder;
import net.thebrokenscript.brokencore.api.registry.builders.ItemBuilder;
import net.thebrokenscript.brokencore.api.registry.objects.BlockEntry;
import net.thebrokenscript.brokencore.api.registry.objects.ItemEntry;
import net.thebrokenscript.brokencore.api.registry.objects.RegistryEntry;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.neoforge.fluids.VoidLiquidBlock;
import net.thebrokenscript.neoforge.fluids.VoidLiquidFluid;
import net.thebrokenscript.neoforge.registry.TBSFluids;
import net.thebrokenscript.registry.TBSReg;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\u0016\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\t\u001a\u0016\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lnet/thebrokenscript/neoforge/registry/TBSFluids;", "", "<init>", "()V", "SOURCE_VOID_LIQUID", "Lnet/thebrokenscript/brokencore/api/registry/objects/RegistryEntry;", "Lnet/minecraft/world/level/material/Fluid;", "kotlin.jvm.PlatformType", "Lnet/thebrokenscript/neoforge/fluids/VoidLiquidFluid$Source;", "FLOWING_VOID_LIQUID", "Lnet/thebrokenscript/neoforge/fluids/VoidLiquidFluid$Flowing;", "VOID_LIQUID_BLOCK", "Lnet/thebrokenscript/brokencore/api/registry/objects/BlockEntry;", "Lnet/thebrokenscript/neoforge/fluids/VoidLiquidBlock;", "VOID_LIQUID_BUCKET", "Lnet/thebrokenscript/brokencore/api/registry/objects/ItemEntry;", "Lnet/minecraft/world/item/BucketItem;", "thebrokenscript-neoforge"})
public final class TBSFluids {
    @NotNull
    public static final TBSFluids INSTANCE = new TBSFluids();
    @JvmField
    @NotNull
    public static final RegistryEntry<Fluid, VoidLiquidFluid.Source> SOURCE_VOID_LIQUID;
    @JvmField
    @NotNull
    public static final RegistryEntry<Fluid, VoidLiquidFluid.Flowing> FLOWING_VOID_LIQUID;
    @JvmField
    @NotNull
    public static final BlockEntry<VoidLiquidBlock> VOID_LIQUID_BLOCK;
    @JvmField
    @NotNull
    public static final ItemEntry<BucketItem> VOID_LIQUID_BUCKET;

    private TBSFluids() {
    }

    private static final void VOID_LIQUID_BLOCK$lambda$0(BlockBuilder $this$block) {
        Intrinsics.checkNotNullParameter((Object)$this$block, (String)"$this$block");
        $this$block.props(TBSFluids::VOID_LIQUID_BLOCK$lambda$0$0);
        $this$block.noLoot();
    }

    private static final void VOID_LIQUID_BLOCK$lambda$0$0(BlockBehaviour.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.mapColor(MapColor.WATER);
        $this$props.strength(100.0f);
        $this$props.noCollission();
        $this$props.noLootTable();
        $this$props.liquid();
        $this$props.pushReaction(PushReaction.DESTROY);
        PropertiesExt.INSTANCE.noSound($this$props);
        $this$props.replaceable();
    }

    private static final BucketItem VOID_LIQUID_BUCKET$lambda$0(Item.Properties it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return new BucketItem((Fluid)SOURCE_VOID_LIQUID.get(), it);
    }

    private static final void VOID_LIQUID_BUCKET$lambda$1(ItemBuilder $this$item) {
        Intrinsics.checkNotNullParameter((Object)$this$item, (String)"$this$item");
        $this$item.props(TBSFluids::VOID_LIQUID_BUCKET$lambda$1$0);
        $this$item.noTab();
    }

    private static final void VOID_LIQUID_BUCKET$lambda$1$0(Item.Properties $this$props) {
        Intrinsics.checkNotNullParameter((Object)$this$props, (String)"$this$props");
        $this$props.craftRemainder(Items.BUCKET);
        $this$props.stacksTo(1);
    }

    static {
        ResourceKey resourceKey = Registries.FLUID;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey, (String)"FLUID");
        SOURCE_VOID_LIQUID = TBSReg.INSTANCE.generic(resourceKey, "source_void_liquid", SOURCE_VOID_LIQUID.1.INSTANCE);
        ResourceKey resourceKey2 = Registries.FLUID;
        Intrinsics.checkNotNullExpressionValue((Object)resourceKey2, (String)"FLUID");
        FLOWING_VOID_LIQUID = TBSReg.INSTANCE.generic(resourceKey2, "flowing_void_liquid", FLOWING_VOID_LIQUID.1.INSTANCE);
        VOID_LIQUID_BLOCK = TBSReg.INSTANCE.block("void_liquid_block", VOID_LIQUID_BLOCK.1.INSTANCE, TBSFluids::VOID_LIQUID_BLOCK$lambda$0);
        VOID_LIQUID_BUCKET = TBSReg.INSTANCE.item("void_liquid_bucket", TBSFluids::VOID_LIQUID_BUCKET$lambda$0, TBSFluids::VOID_LIQUID_BUCKET$lambda$1);
    }
}

