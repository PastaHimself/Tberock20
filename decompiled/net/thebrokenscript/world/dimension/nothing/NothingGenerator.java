/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.world.level.biome.BiomeSource
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.nothing;

import com.mojang.serialization.MapCodec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.world.dimension.nothing.NothingGenerator;
import net.thebrokenscript.world.gen.SingleLayerGenerator;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0014R\u0014\u0010\t\u001a\u00020\n8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/world/dimension/nothing/NothingGenerator;", "Lnet/thebrokenscript/world/gen/SingleLayerGenerator;", "biomeSource", "Lnet/minecraft/world/level/biome/BiomeSource;", "<init>", "(Lnet/minecraft/world/level/biome/BiomeSource;)V", "codec", "Lcom/mojang/serialization/MapCodec;", "Lnet/minecraft/world/level/chunk/ChunkGenerator;", "block", "Lnet/minecraft/world/level/block/state/BlockState;", "getBlock", "()Lnet/minecraft/world/level/block/state/BlockState;", "Companion", "thebrokenscript-common"})
public final class NothingGenerator
extends SingleLayerGenerator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final MapCodec<NothingGenerator> CODEC = SingleLayerGenerator.Companion.codec(Companion.CODEC.1.INSTANCE);

    public NothingGenerator(@NotNull BiomeSource biomeSource) {
        Intrinsics.checkNotNullParameter((Object)biomeSource, (String)"biomeSource");
        super(biomeSource);
    }

    @NotNull
    protected MapCodec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    @Override
    @NotNull
    protected BlockState getBlock() {
        return TBSBlocks.NOTHING.getDefaultState();
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/world/dimension/nothing/NothingGenerator$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/world/dimension/nothing/NothingGenerator;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapCodec<NothingGenerator> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

