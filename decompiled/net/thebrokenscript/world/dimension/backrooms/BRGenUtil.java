/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager
 *  net.minecraft.world.level.levelgen.synth.PerlinNoise
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.world.dimension.backrooms;

import java.util.Optional;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;
import net.thebrokenscript.registry.TBSBlocks;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JF\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016JV\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J&\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u001e\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#J6\u0010$\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u0016J&\u0010(\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0016J\u001e\u0010)\u001a\u00020#2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-JF\u0010.\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u000202J\u001e\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006:"}, d2={"Lnet/thebrokenscript/world/dimension/backrooms/BRGenUtil;", "", "<init>", "()V", "random", "Ljava/util/Random;", "getRandom", "()Ljava/util/Random;", "setRandom", "(Ljava/util/Random;)V", "fillArea", "", "chunk", "Lnet/minecraft/world/level/chunk/ChunkAccess;", "startX", "", "startY", "startZ", "endX", "endY", "endZ", "state", "Lnet/minecraft/world/level/block/state/BlockState;", "fillAreaRandom", "worldGenRegion", "Lnet/minecraft/server/level/WorldGenRegion;", "chance", "", "fillLayer", "layer", "generateBasicWalls", "floorLevel", "ceilingLevel", "generateLights", "redLights", "", "generateBasicWallsWithExtension", "wallState", "extensionOffset", "extensionState", "generateBuildingInteriorWalls", "isChunkInNoise", "noise", "Lnet/minecraft/world/level/levelgen/synth/PerlinNoise;", "threshold", "", "fillWall", "startLayer", "endLayer", "block", "Lnet/minecraft/world/level/block/Block;", "placeBuildingFloor", "structure", "Lnet/minecraft/resources/ResourceLocation;", "world", "Lnet/minecraft/world/level/WorldGenLevel;", "startPos", "Lnet/minecraft/core/BlockPos;", "thebrokenscript-common"})
public final class BRGenUtil {
    @NotNull
    public static final BRGenUtil INSTANCE = new BRGenUtil();
    @NotNull
    private static Random random = new Random();

    private BRGenUtil() {
    }

    @NotNull
    public final Random getRandom() {
        return random;
    }

    public final void setRandom(@NotNull Random random) {
        Intrinsics.checkNotNullParameter((Object)random, (String)"<set-?>");
        BRGenUtil.random = random;
    }

    public final void fillArea(@NotNull ChunkAccess chunk, int startX, int startY, int startZ, int endX, int endY, int endZ, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        int minX = Math.min(startX, endX);
        int minY = Math.min(startY, endY);
        int minZ = Math.min(startZ, endZ);
        int maxX = Math.max(startX, endX);
        int maxY = Math.max(startY, endY);
        int maxZ = Math.max(startZ, endZ);
        int x = minX;
        if (x <= maxX) {
            while (true) {
                int y;
                if ((y = minY) <= maxY) {
                    while (true) {
                        int z;
                        if ((z = minZ) <= maxZ) {
                            while (true) {
                                BlockPos pos = new BlockPos(x, y, z);
                                chunk.setBlockState(pos, state, true);
                                if (z == maxZ) break;
                                ++z;
                            }
                        }
                        if (y == maxY) break;
                        ++y;
                    }
                }
                if (x == maxX) break;
                ++x;
            }
        }
    }

    public final void fillAreaRandom(@NotNull WorldGenRegion worldGenRegion, @NotNull ChunkAccess chunk, int startX, int startY, int startZ, int endX, int endY, int endZ, @NotNull BlockState state, float chance) {
        Intrinsics.checkNotNullParameter((Object)worldGenRegion, (String)"worldGenRegion");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        int minX = Math.min(startX, endX);
        int minY = Math.min(startY, endY);
        int minZ = Math.min(startZ, endZ);
        int maxX = Math.max(startX, endX);
        int maxY = Math.max(startY, endY);
        int maxZ = Math.max(startZ, endZ);
        int x = minX;
        if (x <= maxX) {
            while (true) {
                int y;
                if ((y = minY) <= maxY) {
                    while (true) {
                        int z;
                        if ((z = minZ) <= maxZ) {
                            while (true) {
                                BlockPos pos = new BlockPos(x, y, z);
                                if (worldGenRegion.getRandom().nextFloat() <= chance) {
                                    chunk.setBlockState(pos, state, true);
                                }
                                if (z == maxZ) break;
                                ++z;
                            }
                        }
                        if (y == maxY) break;
                        ++y;
                    }
                }
                if (x == maxX) break;
                ++x;
            }
        }
    }

    public final void fillLayer(@NotNull ChunkAccess chunk, int layer, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        INSTANCE.fillArea(chunk, 0, layer, 0, 15, layer, 15, state);
        chunk.initializeLightSources();
    }

    public final void generateBasicWalls(@NotNull ChunkAccess chunk, int floorLevel, int ceilingLevel, @NotNull BlockState state) {
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        int startX = random.nextInt(0, 15);
        int startZ = random.nextInt(0, 15);
        int length = random.nextInt(1, 15);
        int wallThickness = random.nextInt(0, 6);
        if (random.nextBoolean()) {
            INSTANCE.fillArea(chunk, startX, floorLevel + 1, startZ, startX + length, ceilingLevel - 1, startZ + wallThickness, state);
        } else {
            INSTANCE.fillArea(chunk, startX, floorLevel + 1, startZ, startX + wallThickness, ceilingLevel - 1, startZ + length, state);
        }
    }

    public final void generateLights(@NotNull ChunkAccess chunk, int layer, boolean redLights) {
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        ChunkPos chunkPos = chunk.getPos();
        for (int x = 0; x < 15; x += 4) {
            for (int z = 0; z < 15; z += 4) {
                BlockState lightState = TBSBlocks.CEILING_LIGHT.getDefaultState();
                if (redLights) {
                    lightState = TBSBlocks.RED_CEILING_LIGHT.getDefaultState();
                }
                chunk.setBlockState(chunkPos.getWorldPosition().offset(x, layer, z), lightState, true);
            }
        }
    }

    public final void generateBasicWallsWithExtension(@NotNull ChunkAccess chunk, int floorLevel, int ceilingLevel, @NotNull BlockState wallState, int extensionOffset, @NotNull BlockState extensionState) {
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)wallState, (String)"wallState");
        Intrinsics.checkNotNullParameter((Object)extensionState, (String)"extensionState");
        int startX = random.nextInt(0, 15);
        int startZ = random.nextInt(0, 15);
        int length = random.nextInt(5, 15);
        int wallThickness = random.nextInt(0, 4);
        if (random.nextBoolean()) {
            INSTANCE.fillArea(chunk, startX, floorLevel + 1, startZ, startX + length, ceilingLevel - 1, startZ + wallThickness, wallState);
            INSTANCE.fillArea(chunk, startX, ceilingLevel + 1, startZ, startX + length, ceilingLevel + extensionOffset, startZ + wallThickness, extensionState);
        } else {
            INSTANCE.fillArea(chunk, startX, floorLevel + 1, startZ, startX + wallThickness, ceilingLevel - 1, startZ + length, wallState);
            INSTANCE.fillArea(chunk, startX, ceilingLevel + 1, startZ, startX + wallThickness, ceilingLevel + extensionOffset, startZ + length, extensionState);
        }
    }

    public final void generateBuildingInteriorWalls(@NotNull ChunkAccess chunk, int floorLevel, int ceilingLevel, @NotNull BlockState wallState) {
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)wallState, (String)"wallState");
        int interiorMin = 2;
        int interiorMax = 13;
        int startX = random.nextInt(interiorMin, interiorMax + 1);
        int startZ = random.nextInt(interiorMin, interiorMax + 1);
        int maxLength = interiorMax - interiorMin;
        int length = random.nextInt(2, maxLength + 1);
        int wallThickness = 1;
        if (random.nextBoolean()) {
            int endX = Math.min(startX + length, interiorMax);
            int endZ = Math.min(startZ + wallThickness - 1, interiorMax);
            INSTANCE.fillArea(chunk, startX, floorLevel + 1, startZ, endX, ceilingLevel - 1, endZ, wallState);
        } else {
            int endX = Math.min(startX + wallThickness - 1, interiorMax);
            int endZ = Math.min(startZ + length, interiorMax);
            INSTANCE.fillArea(chunk, startX, floorLevel + 1, startZ, endX, ceilingLevel - 1, endZ, wallState);
        }
    }

    public final boolean isChunkInNoise(@NotNull ChunkAccess chunk, @NotNull PerlinNoise noise, double threshold) {
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)noise, (String)"noise");
        double scale = 0.1;
        double noiseValue = noise.getValue((double)chunk.getPos().x * scale, (double)chunk.getPos().z * scale, 0.0);
        return noiseValue > threshold;
    }

    public final void fillWall(@NotNull ChunkAccess chunk, int startX, int startZ, int endX, int endZ, int startLayer, int endLayer, @NotNull Block block) {
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)block, (String)"block");
        int n = endLayer + 1;
        for (int height = startLayer; height < n; ++height) {
            for (int ix = startX; ix < endX; ++ix) {
                for (int iz = startZ; iz < endZ; ++iz) {
                    chunk.setBlockState(chunk.getPos().getWorldPosition().offset(ix, height, iz), block.defaultBlockState(), true);
                }
            }
        }
    }

    public final void placeBuildingFloor(@NotNull ResourceLocation structure, @NotNull WorldGenLevel world, @NotNull BlockPos startPos) {
        Intrinsics.checkNotNullParameter((Object)structure, (String)"structure");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)startPos, (String)"startPos");
        StructureTemplateManager templateManager = world.getLevel().getStructureManager();
        Optional structureTemplate = templateManager.get(structure);
        if (structureTemplate.isPresent()) {
            Object t = structureTemplate.get();
            Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
            StructureTemplate template = (StructureTemplate)t;
            StructurePlaceSettings placeSettings = new StructurePlaceSettings().setRandom(world.getRandom()).setIgnoreEntities(true);
            template.placeInWorld((ServerLevelAccessor)world, startPos, startPos, placeSettings, world.getRandom(), 2);
        }
    }
}

