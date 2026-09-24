/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.KeyDispatchDataCodec
 *  net.minecraft.world.level.levelgen.DensityFunction
 *  net.minecraft.world.level.levelgen.DensityFunction$ContextProvider
 *  net.minecraft.world.level.levelgen.DensityFunction$FunctionContext
 *  net.minecraft.world.level.levelgen.DensityFunction$Visitor
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.util;

import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.levelgen.DensityFunction;
import org.jetbrains.annotations.NotNull;

public record YOffsetDensityFunction(DensityFunction delegate, int yOffset) implements DensityFunction
{
    private static final ThreadLocal<MutableContext> CTX = ThreadLocal.withInitial(MutableContext::new);

    public double compute(@NotNull DensityFunction.FunctionContext ctx) {
        MutableContext c = CTX.get();
        c.x = ctx.blockX();
        c.y = ctx.blockY() - this.yOffset;
        c.z = ctx.blockZ();
        return this.delegate.compute((DensityFunction.FunctionContext)c);
    }

    public void fillArray(double @NotNull [] densities, @NotNull DensityFunction.ContextProvider ctx) {
        MutableContext c = CTX.get();
        for (int i = 0; i < densities.length; ++i) {
            DensityFunction.FunctionContext original = ctx.forIndex(i);
            c.x = original.blockX();
            c.y = original.blockY() - this.yOffset;
            c.z = original.blockZ();
            densities[i] = this.delegate.compute((DensityFunction.FunctionContext)c);
        }
    }

    @NotNull
    public DensityFunction mapAll(@NotNull DensityFunction.Visitor visitor) {
        return new YOffsetDensityFunction(this.delegate.mapAll(visitor), this.yOffset);
    }

    public double minValue() {
        return this.delegate.minValue();
    }

    public double maxValue() {
        return this.delegate.maxValue();
    }

    @NotNull
    public KeyDispatchDataCodec<? extends DensityFunction> codec() {
        throw new UnsupportedOperationException("YOffsetDensityFunction is transient");
    }

    private static final class MutableContext
    implements DensityFunction.FunctionContext {
        int x;
        int y;
        int z;

        private MutableContext() {
        }

        public int blockX() {
            return this.x;
        }

        public int blockY() {
            return this.y;
        }

        public int blockZ() {
            return this.z;
        }
    }
}

