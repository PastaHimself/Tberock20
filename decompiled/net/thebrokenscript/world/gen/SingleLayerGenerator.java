/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  com.mojang.serialization.codecs.RecordCodecBuilder$Instance
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.reflect.KProperty1
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.world.level.LevelHeightAccessor
 *  net.minecraft.world.level.NoiseColumn
 *  net.minecraft.world.level.StructureManager
 *  net.minecraft.world.level.biome.BiomeManager
 *  net.minecraft.world.level.biome.BiomeSource
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.levelgen.GenerationStep$Carving
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.RandomState
 *  net.minecraft.world.level.levelgen.blending.Blender
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.gen;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.thebrokenscript.world.gen.SingleLayerGenerator;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 52\u00020\u0001:\u00015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J@\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J(\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J.\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u001dH\u0016J\b\u0010$\u001a\u00020\u001dH\u0016J0\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010,\u001a\u00020-2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020+2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J&\u0010/\u001a\u00020\u000b2\f\u00100\u001a\b\u0012\u0004\u0012\u000202012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00103\u001a\u000204H\u0016R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u00066"}, d2={"Lnet/thebrokenscript/world/gen/SingleLayerGenerator;", "Lnet/minecraft/world/level/chunk/ChunkGenerator;", "biomeSource", "Lnet/minecraft/world/level/biome/BiomeSource;", "<init>", "(Lnet/minecraft/world/level/biome/BiomeSource;)V", "block", "Lnet/minecraft/world/level/block/state/BlockState;", "getBlock", "()Lnet/minecraft/world/level/block/state/BlockState;", "applyCarvers", "", "region", "Lnet/minecraft/server/level/WorldGenRegion;", "seed", "", "random", "Lnet/minecraft/world/level/levelgen/RandomState;", "biomeManager", "Lnet/minecraft/world/level/biome/BiomeManager;", "structureManager", "Lnet/minecraft/world/level/StructureManager;", "chunk", "Lnet/minecraft/world/level/chunk/ChunkAccess;", "step", "Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;", "buildSurface", "spawnOriginalMobs", "getGenDepth", "", "fillFromNoise", "Ljava/util/concurrent/CompletableFuture;", "blender", "Lnet/minecraft/world/level/levelgen/blending/Blender;", "randomState", "getSeaLevel", "getMinY", "getBaseHeight", "x", "z", "type", "Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "level", "Lnet/minecraft/world/level/LevelHeightAccessor;", "getBaseColumn", "Lnet/minecraft/world/level/NoiseColumn;", "height", "addDebugScreenInfo", "info", "", "", "pos", "Lnet/minecraft/core/BlockPos;", "Companion", "thebrokenscript-common"})
public abstract class SingleLayerGenerator
extends ChunkGenerator {
    @NotNull
    public static final Companion Companion = new Companion(null);

    public SingleLayerGenerator(@NotNull BiomeSource biomeSource) {
        Intrinsics.checkNotNullParameter((Object)biomeSource, (String)"biomeSource");
        super(biomeSource);
    }

    @NotNull
    protected abstract BlockState getBlock();

    public void applyCarvers(@NotNull WorldGenRegion region, long seed, @NotNull RandomState random, @NotNull BiomeManager biomeManager, @NotNull StructureManager structureManager, @NotNull ChunkAccess chunk, @NotNull GenerationStep.Carving step) {
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)biomeManager, (String)"biomeManager");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)step, (String)"step");
    }

    public void buildSurface(@NotNull WorldGenRegion region, @NotNull StructureManager structureManager, @NotNull RandomState random, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        int x = chunk.getPos().getMinBlockX();
        int n = chunk.getPos().getMaxBlockX();
        if (x <= n) {
            while (true) {
                int n2;
                int z;
                if ((z = chunk.getPos().getMinBlockZ()) <= (n2 = chunk.getPos().getMaxBlockZ())) {
                    while (true) {
                        BlockPos pos;
                        if (region.ensureCanWrite(pos = new BlockPos(x, 0, z))) {
                            region.setBlock(pos, this.getBlock(), 3);
                        }
                        if (z == n2) break;
                        ++z;
                    }
                }
                if (x == n) break;
                ++x;
            }
        }
    }

    public void spawnOriginalMobs(@NotNull WorldGenRegion region) {
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
    }

    public int getGenDepth() {
        return 1;
    }

    @NotNull
    public CompletableFuture<ChunkAccess> fillFromNoise(@NotNull Blender blender, @NotNull RandomState randomState, @NotNull StructureManager structureManager, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)blender, (String)"blender");
        Intrinsics.checkNotNullParameter((Object)randomState, (String)"randomState");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        CompletableFuture<ChunkAccess> completableFuture = CompletableFuture.completedFuture(chunk);
        Intrinsics.checkNotNullExpressionValue(completableFuture, (String)"completedFuture(...)");
        return completableFuture;
    }

    public int getSeaLevel() {
        return 0;
    }

    public int getMinY() {
        return 0;
    }

    public int getBaseHeight(int x, int z, @NotNull Heightmap.Types type, @NotNull LevelHeightAccessor level, @NotNull RandomState random) {
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        return 1;
    }

    @NotNull
    public NoiseColumn getBaseColumn(int x, int z, @NotNull LevelHeightAccessor height, @NotNull RandomState random) {
        Intrinsics.checkNotNullParameter((Object)height, (String)"height");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        BlockState[] blockStateArray = new BlockState[]{this.getBlock()};
        return new NoiseColumn(0, blockStateArray);
    }

    public void addDebugScreenInfo(@NotNull List<String> info, @NotNull RandomState random, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter(info, (String)"info");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
    }

    public static final /* synthetic */ BiomeSource access$getBiomeSource$p(SingleLayerGenerator $this) {
        return $this.biomeSource;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002H\u00060\t\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/world/gen/SingleLayerGenerator$Companion;", "", "<init>", "()V", "codec", "Lcom/mojang/serialization/MapCodec;", "T", "Lnet/thebrokenscript/world/gen/SingleLayerGenerator;", "ctor", "Lkotlin/Function1;", "Lnet/minecraft/world/level/biome/BiomeSource;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final <T extends SingleLayerGenerator> MapCodec<T> codec(@NotNull Function1<? super BiomeSource, ? extends T> ctor) {
            Intrinsics.checkNotNullParameter(ctor, (String)"ctor");
            MapCodec mapCodec = RecordCodecBuilder.mapCodec(arg_0 -> Companion.codec$lambda$0(ctor, arg_0));
            Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"mapCodec(...)");
            return mapCodec;
        }

        private static final App codec$lambda$0(Function1 $ctor, RecordCodecBuilder.Instance it) {
            return it.group((App)BiomeSource.CODEC.fieldOf("biome_source").forGetter(arg_0 -> Companion.codec$lambda$0$0((KProperty1)codec.1.1.INSTANCE, arg_0))).apply((Applicative)it, arg_0 -> Companion.codec$lambda$0$1($ctor, arg_0));
        }

        private static final BiomeSource codec$lambda$0$0(KProperty1 $tmp0, SingleLayerGenerator p0) {
            return (BiomeSource)((Function1)$tmp0).invoke((Object)p0);
        }

        private static final SingleLayerGenerator codec$lambda$0$1(Function1 $tmp0, BiomeSource p0) {
            return (SingleLayerGenerator)((Object)$tmp0.invoke((Object)p0));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

