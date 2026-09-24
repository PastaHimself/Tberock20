/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.level.block.LiquidBlock
 *  net.minecraft.world.level.block.state.BlockBehaviour$Properties
 *  net.minecraft.world.level.material.FlowingFluid
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.neoforge.fluids;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.thebrokenscript.neoforge.registry.TBSFluids;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/neoforge/fluids/VoidLiquidBlock;", "Lnet/minecraft/world/level/block/LiquidBlock;", "props", "Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;", "<init>", "(Lnet/minecraft/world/level/block/state/BlockBehaviour$Properties;)V", "thebrokenscript-neoforge"})
public final class VoidLiquidBlock
extends LiquidBlock {
    public VoidLiquidBlock(@NotNull BlockBehaviour.Properties props) {
        Intrinsics.checkNotNullParameter((Object)props, (String)"props");
        super((FlowingFluid)TBSFluids.SOURCE_VOID_LIQUID.get(), props);
    }
}

