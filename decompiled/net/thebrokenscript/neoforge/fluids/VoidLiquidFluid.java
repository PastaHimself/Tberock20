/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.level.block.state.StateDefinition$Builder
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.material.Fluid
 *  net.minecraft.world.level.material.FluidState
 *  net.neoforged.neoforge.fluids.BaseFlowingFluid
 *  net.neoforged.neoforge.fluids.BaseFlowingFluid$Properties
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.neoforge.fluids;

import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.thebrokenscript.neoforge.registry.TBSFluidTypes;
import net.thebrokenscript.neoforge.registry.TBSFluids;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/neoforge/fluids/VoidLiquidFluid;", "Lnet/neoforged/neoforge/fluids/BaseFlowingFluid;", "<init>", "()V", "Source", "Flowing", "thebrokenscript-neoforge"})
public abstract class VoidLiquidFluid
extends BaseFlowingFluid {
    public VoidLiquidFluid() {
        super(new BaseFlowingFluid.Properties(() -> TBSFluidTypes.VOID_LIQUID.get(), () -> TBSFluids.SOURCE_VOID_LIQUID.get(), () -> TBSFluids.FLOWING_VOID_LIQUID.get()).slopeFindDistance(2).levelDecreasePerBlock(1).block((Supplier)TBSFluids.VOID_LIQUID_BLOCK).bucket((Supplier)TBSFluids.VOID_LIQUID_BUCKET));
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0014J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2={"Lnet/thebrokenscript/neoforge/fluids/VoidLiquidFluid$Flowing;", "Lnet/thebrokenscript/neoforge/fluids/VoidLiquidFluid;", "<init>", "()V", "createFluidStateDefinition", "", "builder", "Lnet/minecraft/world/level/block/state/StateDefinition$Builder;", "Lnet/minecraft/world/level/material/Fluid;", "Lnet/minecraft/world/level/material/FluidState;", "getAmount", "", "state", "isSource", "", "thebrokenscript-neoforge"})
    public static final class Flowing
    extends VoidLiquidFluid {
        protected void createFluidStateDefinition(@NotNull StateDefinition.Builder<Fluid, FluidState> builder) {
            Intrinsics.checkNotNullParameter(builder, (String)"builder");
            super.createFluidStateDefinition(builder);
            Property[] propertyArray = new Property[]{BaseFlowingFluid.LEVEL};
            builder.add(propertyArray);
        }

        public int getAmount(@NotNull FluidState state) {
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            Comparable comparable = state.getValue((Property)BaseFlowingFluid.LEVEL);
            Intrinsics.checkNotNullExpressionValue((Object)comparable, (String)"getValue(...)");
            return ((Number)((Object)comparable)).intValue();
        }

        public boolean isSource(@NotNull FluidState state) {
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            return false;
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2={"Lnet/thebrokenscript/neoforge/fluids/VoidLiquidFluid$Source;", "Lnet/thebrokenscript/neoforge/fluids/VoidLiquidFluid;", "<init>", "()V", "getAmount", "", "state", "Lnet/minecraft/world/level/material/FluidState;", "isSource", "", "thebrokenscript-neoforge"})
    public static final class Source
    extends VoidLiquidFluid {
        public int getAmount(@NotNull FluidState state) {
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            return 8;
        }

        public boolean isSource(@NotNull FluidState state) {
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            return true;
        }
    }
}

