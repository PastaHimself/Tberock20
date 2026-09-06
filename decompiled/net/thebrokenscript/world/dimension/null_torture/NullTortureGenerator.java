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
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.StructureManager
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.biome.BiomeSource
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator
 *  net.minecraft.world.level.levelgen.NoiseGeneratorSettings
 *  net.minecraft.world.level.levelgen.RandomState
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.null_torture;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Collection;
import java.util.Optional;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ&\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eJ(\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u001dH\u0014\u00a8\u0006 "}, d2={"Lnet/thebrokenscript/world/dimension/null_torture/NullTortureGenerator;", "Lnet/minecraft/world/level/levelgen/NoiseBasedChunkGenerator;", "biomeSource", "Lnet/minecraft/world/level/biome/BiomeSource;", "settings", "Lnet/minecraft/core/Holder;", "Lnet/minecraft/world/level/levelgen/NoiseGeneratorSettings;", "<init>", "(Lnet/minecraft/world/level/biome/BiomeSource;Lnet/minecraft/core/Holder;)V", "genRoom", "", "worldGenLevel", "Lnet/minecraft/world/level/WorldGenLevel;", "chunkAccess", "Lnet/minecraft/world/level/chunk/ChunkAccess;", "placeStructure", "structureId", "Lnet/minecraft/resources/ResourceLocation;", "level", "pos", "Lnet/minecraft/core/BlockPos;", "chunk", "buildSurface", "Lnet/minecraft/server/level/WorldGenRegion;", "structureManager", "Lnet/minecraft/world/level/StructureManager;", "random", "Lnet/minecraft/world/level/levelgen/RandomState;", "codec", "Lcom/mojang/serialization/MapCodec;", "Lnet/minecraft/world/level/chunk/ChunkGenerator;", "Companion", "thebrokenscript-common"})
public final class NullTortureGenerator
extends NoiseBasedChunkGenerator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final MapCodec<NullTortureGenerator> CODEC;

    public NullTortureGenerator(@NotNull BiomeSource biomeSource, @NotNull Holder<NoiseGeneratorSettings> settings) {
        Intrinsics.checkNotNullParameter((Object)biomeSource, (String)"biomeSource");
        Intrinsics.checkNotNullParameter(settings, (String)"settings");
        super(biomeSource, settings);
    }

    public final void genRoom(@NotNull WorldGenLevel worldGenLevel, @NotNull ChunkAccess chunkAccess) {
        String string;
        Intrinsics.checkNotNullParameter((Object)worldGenLevel, (String)"worldGenLevel");
        Intrinsics.checkNotNullParameter((Object)chunkAccess, (String)"chunkAccess");
        RandomSource randomSource = RandomSource.create();
        Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"create(...)");
        RandomSource random = randomSource;
        if (random.nextFloat() < 0.9f) {
            string = "bedrockhallway1";
        } else {
            Object[] objectArray = new String[]{"bedrockhallway2", "bedrockhallway3", "bedrockhallway4", "bedrockhallway5", "bedrockhallway6", "bedrockhallway7", "bedrockhallway8", "bedrockhallway9", "bedrockhallway10", "bedrockhallwayexit"};
            string = (String)CollectionsKt.random((Collection)CollectionsKt.listOf((Object[])objectArray), (Random)((Random)Random.Default));
        }
        String structureId = string;
        ResourceLocation resourceLocation = TBSConstants.id(structureId);
        BlockPos blockPos = chunkAccess.getPos().getWorldPosition();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"getWorldPosition(...)");
        this.placeStructure(resourceLocation, worldGenLevel, PositionUtil.withY((BlockPos)blockPos, (Number)64), chunkAccess);
    }

    public final void placeStructure(@NotNull ResourceLocation structureId, @NotNull WorldGenLevel level, @NotNull BlockPos pos, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)structureId, (String)"structureId");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        ServerLevel serverLevel = level.getLevel();
        StructureTemplateManager templateManager = serverLevel.getStructureManager();
        Optional optional = templateManager.get(structureId);
        if (optional == null) {
            return;
        }
        Optional template = optional;
        ChunkPos chunkPos = chunk.getPos();
        BoundingBox boundingBox = new BoundingBox(chunkPos.getMinBlockX(), level.getMinBuildHeight(), chunkPos.getMinBlockZ(), chunkPos.getMaxBlockX(), level.getMaxBuildHeight(), chunkPos.getMaxBlockZ());
        StructurePlaceSettings settings = new StructurePlaceSettings().setIgnoreEntities(false).setFinalizeEntities(true).setBoundingBox(boundingBox);
        ((StructureTemplate)template.get()).placeInWorld((ServerLevelAccessor)level, pos, pos, settings, level.getRandom(), 2);
    }

    public void buildSurface(@NotNull WorldGenRegion level, @NotNull StructureManager structureManager, @NotNull RandomState random, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        super.buildSurface(level, structureManager, random, chunk);
        this.genRoom((WorldGenLevel)level, chunk);
    }

    @NotNull
    protected MapCodec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    private static final App CODEC$lambda$0(RecordCodecBuilder.Instance instance) {
        return instance.group((App)BiomeSource.CODEC.fieldOf("biome_source").forGetter(NullTortureGenerator::CODEC$lambda$0$0), (App)NoiseGeneratorSettings.CODEC.fieldOf("settings").forGetter(NullTortureGenerator::CODEC$lambda$0$1)).apply((Applicative)instance, NullTortureGenerator::new);
    }

    private static final BiomeSource CODEC$lambda$0$0(NullTortureGenerator it) {
        return it.biomeSource;
    }

    private static final Holder CODEC$lambda$0$1(NullTortureGenerator it) {
        return it.generatorSettings();
    }

    static {
        MapCodec mapCodec = RecordCodecBuilder.mapCodec(NullTortureGenerator::CODEC$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"mapCodec(...)");
        CODEC = mapCodec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/world/dimension/null_torture/NullTortureGenerator$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/world/dimension/null_torture/NullTortureGenerator;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapCodec<NullTortureGenerator> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

