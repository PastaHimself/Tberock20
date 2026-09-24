/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Either
 *  com.mojang.serialization.MapCodec
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.util.Mth
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.WorldgenRandom
 *  net.minecraft.world.level.levelgen.structure.Structure
 *  net.minecraft.world.level.levelgen.structure.Structure$GenerationContext
 *  net.minecraft.world.level.levelgen.structure.Structure$GenerationStub
 *  net.minecraft.world.level.levelgen.structure.Structure$StructureSettings
 *  net.minecraft.world.level.levelgen.structure.StructurePiece
 *  net.minecraft.world.level.levelgen.structure.StructureType
 *  net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.gen.structure;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.MapCodec;
import java.util.Optional;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.thebrokenscript.registry.TBSStructureTypes;
import net.thebrokenscript.world.gen.structure.VoidGrowthPiece;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0014J\f\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0016\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/world/gen/structure/VoidGrowthStructure;", "Lnet/minecraft/world/level/levelgen/structure/Structure;", "settings", "Lnet/minecraft/world/level/levelgen/structure/Structure$StructureSettings;", "<init>", "(Lnet/minecraft/world/level/levelgen/structure/Structure$StructureSettings;)V", "findGenerationPoint", "Ljava/util/Optional;", "Lnet/minecraft/world/level/levelgen/structure/Structure$GenerationStub;", "context", "Lnet/minecraft/world/level/levelgen/structure/Structure$GenerationContext;", "type", "Lnet/minecraft/world/level/levelgen/structure/StructureType;", "Companion", "thebrokenscript-common"})
public final class VoidGrowthStructure
extends Structure {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final MapCodec<VoidGrowthStructure> CODEC;

    public VoidGrowthStructure(@NotNull Structure.StructureSettings settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super(settings);
    }

    @NotNull
    protected Optional<Structure.GenerationStub> findGenerationPoint(@NotNull Structure.GenerationContext context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        ChunkPos chunkPos = context.chunkPos();
        WorldgenRandom random = context.random();
        int x = chunkPos.getMinBlockX() + random.nextInt(16);
        int z = chunkPos.getMinBlockZ() + random.nextInt(16);
        Holder biome = context.chunkGenerator().getBiomeSource().getNoiseBiome(x >> 2, 16, z >> 2, context.randomState().sampler());
        if (!context.validBiome().test(biome)) {
            Optional<Structure.GenerationStub> optional = Optional.empty();
            Intrinsics.checkNotNullExpressionValue(optional, (String)"empty(...)");
            return optional;
        }
        int surfaceY = context.chunkGenerator().getBaseHeight(x, z, Heightmap.Types.WORLD_SURFACE_WG, context.heightAccessor(), context.randomState());
        BlockPos startPos = new BlockPos(x, surfaceY, z).below(4);
        float angle = random.nextFloat() * ((float)Math.PI * 2);
        float radius = random.nextFloat() * 18.0f + 18.0f;
        float offsetX = Mth.cos((float)angle) * radius;
        float offsetZ = Mth.sin((float)angle) * radius;
        int targetX = startPos.getX() + (int)offsetX;
        int targetY = startPos.getY() + random.nextInt(25, 40);
        int targetZ = startPos.getZ() + (int)offsetZ;
        long pieceSeed = random.nextLong();
        Consumer<StructurePiecesBuilder> piecesConsumer = arg_0 -> VoidGrowthStructure.findGenerationPoint$lambda$0(startPos, targetX, targetY, targetZ, pieceSeed, arg_0);
        Optional<Structure.GenerationStub> optional = Optional.of(new Structure.GenerationStub(startPos, Either.left(piecesConsumer)));
        Intrinsics.checkNotNullExpressionValue(optional, (String)"of(...)");
        return optional;
    }

    @NotNull
    public StructureType<?> type() {
        return (StructureType)TBSStructureTypes.VOID_GROWTH.get();
    }

    private static final void findGenerationPoint$lambda$0(BlockPos $startPos, int $targetX, int $targetY, int $targetZ, long $pieceSeed, StructurePiecesBuilder builder) {
        Intrinsics.checkNotNull((Object)$startPos);
        builder.addPiece((StructurePiece)new VoidGrowthPiece($startPos, $targetX, $targetY, $targetZ, $pieceSeed));
    }

    static {
        MapCodec mapCodec = Structure.simpleCodec(VoidGrowthStructure::new);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"simpleCodec(...)");
        CODEC = mapCodec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/world/gen/structure/VoidGrowthStructure$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/world/gen/structure/VoidGrowthStructure;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapCodec<VoidGrowthStructure> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

