/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.StructureManager
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.biome.BiomeSource
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  net.thebrokenscript.brokencore.api.world.StructurePlacementData
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.limbo;

import com.mojang.serialization.MapCodec;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.world.StructurePlacementData;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.world.dimension.limbo.LimboGenerator;
import net.thebrokenscript.world.gen.SingleLayerGenerator;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007H\u0014J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J \u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0002R\u0014\u0010\t\u001a\u00020\n8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00a8\u0006#"}, d2={"Lnet/thebrokenscript/world/dimension/limbo/LimboGenerator;", "Lnet/thebrokenscript/world/gen/SingleLayerGenerator;", "biomeSource", "Lnet/minecraft/world/level/biome/BiomeSource;", "<init>", "(Lnet/minecraft/world/level/biome/BiomeSource;)V", "codec", "Lcom/mojang/serialization/MapCodec;", "Lnet/minecraft/world/level/chunk/ChunkGenerator;", "block", "Lnet/minecraft/world/level/block/state/BlockState;", "getBlock", "()Lnet/minecraft/world/level/block/state/BlockState;", "applyBiomeDecoration", "", "level", "Lnet/minecraft/world/level/WorldGenLevel;", "chunk", "Lnet/minecraft/world/level/chunk/ChunkAccess;", "structureManager", "Lnet/minecraft/world/level/StructureManager;", "placeStructure", "structureId", "Lnet/minecraft/resources/ResourceLocation;", "pos", "Lnet/minecraft/core/BlockPos;", "centerX", "", "centerZ", "canPlaceStructure", "", "", "data", "Lnet/thebrokenscript/brokencore/api/world/StructurePlacementData;", "Companion", "thebrokenscript-common"})
public final class LimboGenerator
extends SingleLayerGenerator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final MapCodec<LimboGenerator> CODEC = SingleLayerGenerator.Companion.codec(Companion.CODEC.1.INSTANCE);
    @NotNull
    private static final List<String> STRUCTURES;
    @NotNull
    private static final ChunkPos LIMBO_HOUSE_CHUNK;

    public LimboGenerator(@NotNull BiomeSource biomeSource) {
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
        return TBSBlocks.LIMBO.getDefaultState();
    }

    public void applyBiomeDecoration(@NotNull WorldGenLevel level, @NotNull ChunkAccess chunk, @NotNull StructureManager structureManager) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        super.applyBiomeDecoration(level, chunk, structureManager);
        MinecraftServer minecraftServer = level.getServer();
        if (minecraftServer == null || (minecraftServer = minecraftServer.getLevel(TBSDimensions.LIMBO)) == null) {
            return;
        }
        MinecraftServer serverLevel = minecraftServer;
        StructurePlacementData data = StructurePlacementData.Companion.get((ServerLevel)serverLevel);
        if (Intrinsics.areEqual((Object)chunk.getPos(), (Object)LIMBO_HOUSE_CHUNK)) {
            this.placeStructure(TBSConstants.id("limbo_house"), level, new BlockPos(-5, 1, -5));
            ChunkPos chunkPos = chunk.getPos();
            Intrinsics.checkNotNullExpressionValue((Object)chunkPos, (String)"getPos(...)");
            data.incrementPlaceCount("limbo_house", chunkPos);
        }
        for (String struct : STRUCTURES) {
            if (!this.canPlaceStructure(struct, chunk, data)) continue;
            ChunkPos chunkPos = chunk.getPos();
            Intrinsics.checkNotNull((Object)chunkPos);
            data.incrementPlaceCount(struct, chunkPos);
            int centerX = chunkPos.x * 16 + 8;
            int centerZ = chunkPos.z * 16 + 8;
            this.placeStructure(TBSConstants.id(struct), level, centerX, centerZ);
        }
    }

    private final void placeStructure(ResourceLocation structureId, WorldGenLevel level, BlockPos pos) {
        MinecraftServer minecraftServer = level.getServer();
        Intrinsics.checkNotNull((Object)minecraftServer);
        ServerLevel serverLevel = minecraftServer.getLevel(TBSDimensions.LIMBO);
        if (serverLevel == null) {
            return;
        }
        ServerLevel serverLevel2 = serverLevel;
        Object t = serverLevel2.getStructureManager().get(structureId).get();
        Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
        StructureTemplate template = (StructureTemplate)t;
        Vec3i size = template.getSize();
        BoundingBox boundingBox = new BoundingBox(pos.getX(), level.getMinBuildHeight(), pos.getZ(), pos.getX() + size.getX(), level.getMaxBuildHeight(), pos.getZ() + size.getZ());
        StructurePlaceSettings settings = new StructurePlaceSettings().setIgnoreEntities(false).setFinalizeEntities(true).setBoundingBox(boundingBox);
        template.placeInWorld((ServerLevelAccessor)level, pos, pos, settings, level.getRandom(), 2);
    }

    private final void placeStructure(ResourceLocation structureId, WorldGenLevel level, int centerX, int centerZ) {
        MinecraftServer minecraftServer = level.getServer();
        Intrinsics.checkNotNull((Object)minecraftServer);
        ServerLevel serverLevel = minecraftServer.getLevel(TBSDimensions.LIMBO);
        if (serverLevel == null) {
            return;
        }
        ServerLevel serverLevel2 = serverLevel;
        Object t = serverLevel2.getStructureManager().get(structureId).get();
        Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
        StructureTemplate template = (StructureTemplate)t;
        Vec3i size = template.getSize();
        BlockPos pos = new BlockPos(centerX - size.getX() / 2, 1, centerZ - size.getZ() / 2);
        BoundingBox boundingBox = new BoundingBox(pos.getX(), level.getMinBuildHeight(), pos.getZ(), pos.getX() + size.getX(), level.getMaxBuildHeight(), pos.getZ() + size.getZ());
        StructurePlaceSettings settings = new StructurePlaceSettings().setIgnoreEntities(false).setFinalizeEntities(true).setBoundingBox(boundingBox);
        template.placeInWorld((ServerLevelAccessor)level, pos, pos, settings, level.getRandom(), 2);
    }

    private final boolean canPlaceStructure(String structureId, ChunkAccess chunk, StructurePlacementData data) {
        int chunkX = chunk.getPos().x;
        int chunkZ = chunk.getPos().z;
        if (Math.floorMod(chunkX, 3) != 1 || Math.floorMod(chunkZ, 3) != 1) {
            return false;
        }
        if (!StructurePlacementData.canPlace$default((StructurePlacementData)data, (String)structureId, (int)0, (int)2, null)) {
            return false;
        }
        ChunkPos chunkPos = chunk.getPos();
        Intrinsics.checkNotNullExpressionValue((Object)chunkPos, (String)"getPos(...)");
        if (data.isChunkUsed(chunkPos)) {
            return false;
        }
        ChunkPos chunkPos2 = chunk.getPos();
        Intrinsics.checkNotNullExpressionValue((Object)chunkPos2, (String)"getPos(...)");
        return !data.isTooClose(chunkPos2, 1024);
    }

    static {
        Object[] objectArray = new String[]{"limbo_caveoutpost", "limbo_happyfarm", "limbo_sanctuary", "limbo_thewrongdirection", "limbo_distastefulquandary", "limbo_somethingoldsomethingnew", "limbo_towerbaseright", "limbo_treehouse"};
        STRUCTURES = CollectionsKt.listOf((Object[])objectArray);
        LIMBO_HOUSE_CHUNK = new ChunkPos(new BlockPos(-5, 1, -5));
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lnet/thebrokenscript/world/dimension/limbo/LimboGenerator$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/world/dimension/limbo/LimboGenerator;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "STRUCTURES", "", "", "LIMBO_HOUSE_CHUNK", "Lnet/minecraft/world/level/ChunkPos;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapCodec<LimboGenerator> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

