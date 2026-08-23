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
 *  kotlin.Pair
 *  kotlin.collections.CollectionsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.WorldGenRegion
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.LevelHeightAccessor
 *  net.minecraft.world.level.NoiseColumn
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.StructureManager
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.biome.BiomeManager
 *  net.minecraft.world.level.biome.BiomeSource
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.chunk.ChunkGenerator
 *  net.minecraft.world.level.levelgen.GenerationStep$Carving
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.RandomState
 *  net.minecraft.world.level.levelgen.blending.Blender
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  net.minecraft.world.level.levelgen.synth.SimplexNoise
 *  net.thebrokenscript.brokencore.api.dsl.ArrayUtil
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.world.dimension.nowhere;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.synth.SimplexNoise;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.brokencore.api.dsl.ArrayUtil;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 G2\u00020\u0001:\u0002FGB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J>\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rJ&\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016J6\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000bJ(\u0010\"\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020&2\u0006\u0010!\u001a\u00020\u000bH\u0016J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020#H\u0016J\b\u0010)\u001a\u00020\rH\u0016J \u0010*\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0016J@\u0010+\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020#2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020&2\u0006\u0010-\u001a\u00020.2\u0006\u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010/\u001a\u000200H\u0016J0\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020&2\u0006\u0010$\u001a\u00020%2\u0006\u0010!\u001a\u00020\u000bH\u0016J\b\u00106\u001a\u00020\rH\u0016J\b\u00107\u001a\u00020\rH\u0016J0\u00108\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0006\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020&H\u0016J(\u0010?\u001a\u00020@2\u0006\u0010(\u001a\u00020\r2\u0006\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020=2\u0006\u0010<\u001a\u00020&H\u0016J(\u0010A\u001a\u00020\u00072\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010C0B2\u0006\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020\u001cH\u0016J\u0010\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010EH\u0014\u00a8\u0006H"}, d2={"Lnet/thebrokenscript/world/dimension/nowhere/NowhereGenerator;", "Lnet/minecraft/world/level/chunk/ChunkGenerator;", "biomeSource", "Lnet/minecraft/world/level/biome/BiomeSource;", "<init>", "(Lnet/minecraft/world/level/biome/BiomeSource;)V", "genRoom", "", "level", "Lnet/minecraft/world/level/WorldGenLevel;", "chunkAccess", "Lnet/minecraft/world/level/chunk/ChunkAccess;", "yOffset", "", "xOffset", "zOffset", "randomOffset", "", "divider", "structureSelection", "y", "random", "Lnet/minecraft/util/RandomSource;", "placeStructure", "structureId", "Lnet/minecraft/resources/ResourceLocation;", "region", "pos", "Lnet/minecraft/core/BlockPos;", "mirror", "Lnet/minecraft/world/level/block/Mirror;", "rotation", "Lnet/minecraft/world/level/block/Rotation;", "chunk", "buildSurface", "Lnet/minecraft/server/level/WorldGenRegion;", "structureManager", "Lnet/minecraft/world/level/StructureManager;", "Lnet/minecraft/world/level/levelgen/RandomState;", "spawnOriginalMobs", "p0", "getGenDepth", "applyBiomeDecoration", "applyCarvers", "seed", "biomeManager", "Lnet/minecraft/world/level/biome/BiomeManager;", "step", "Lnet/minecraft/world/level/levelgen/GenerationStep$Carving;", "fillFromNoise", "Ljava/util/concurrent/CompletableFuture;", "blender", "Lnet/minecraft/world/level/levelgen/blending/Blender;", "randomState", "getSeaLevel", "getMinY", "getBaseHeight", "p1", "p2", "Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "p3", "Lnet/minecraft/world/level/LevelHeightAccessor;", "p4", "getBaseColumn", "Lnet/minecraft/world/level/NoiseColumn;", "addDebugScreenInfo", "", "", "codec", "Lcom/mojang/serialization/MapCodec;", "HolePoint", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nNowhereGenerator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NowhereGenerator.kt\nnet/thebrokenscript/world/dimension/nowhere/NowhereGenerator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,394:1\n1761#2,3:395\n1788#2,4:398\n*S KotlinDebug\n*F\n+ 1 NowhereGenerator.kt\nnet/thebrokenscript/world/dimension/nowhere/NowhereGenerator\n*L\n78#1:395,3\n152#1:398,4\n*E\n"})
public final class NowhereGenerator
extends ChunkGenerator {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final MapCodec<NowhereGenerator> CODEC;

    public NowhereGenerator(@NotNull BiomeSource biomeSource) {
        Intrinsics.checkNotNullParameter((Object)biomeSource, (String)"biomeSource");
        super(biomeSource);
    }

    public final void genRoom(@NotNull WorldGenLevel level, @NotNull ChunkAccess chunkAccess, int yOffset, int xOffset, int zOffset, long randomOffset, int divider) {
        int y;
        int n;
        int targetChunkX;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)chunkAccess, (String)"chunkAccess");
        if (divider == 0) {
            throw new IllegalArgumentException("divider can't be 0");
        }
        List voronoiPoints = new ArrayList();
        for (int chunkOffsetX = -1; chunkOffsetX < 2; ++chunkOffsetX) {
            for (int chunkOffsetZ = -1; chunkOffsetZ < 2; ++chunkOffsetZ) {
                targetChunkX = chunkAccess.getPos().x + chunkOffsetX;
                int targetChunkZ = chunkAccess.getPos().z + chunkOffsetZ;
                RandomSource random = RandomSource.create((long)(level.getSeed() + (long)targetChunkX * randomOffset + (long)targetChunkZ * (randomOffset / (long)divider) + (long)yOffset * 123456789L));
                int numPoints = random.nextInt(3, 6);
                int chunkCenterX = targetChunkX * 16 + 8 + xOffset;
                int chunkCenterZ = targetChunkZ * 16 + 8 + zOffset;
                double minDistanceBetweenPoints = 8.0;
                int maxAttempts = 50;
                for (int i = 0; i < numPoints; ++i) {
                    boolean bl;
                    int pointZ;
                    int pointX;
                    int it = i;
                    boolean bl2 = false;
                    HolePoint validPoint = null;
                    for (int attempts = 0; attempts < maxAttempts; ++attempts) {
                        boolean tooClose;
                        HolePoint candidate;
                        block32: {
                            pointX = chunkCenterX + random.nextInt(-16, 16);
                            pointZ = chunkCenterZ + random.nextInt(-16, 16);
                            candidate = new HolePoint(pointX, pointZ);
                            Iterable $this$any$iv = voronoiPoints;
                            boolean $i$f$any = false;
                            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                                v0 = false;
                            } else {
                                for (Object element$iv : $this$any$iv) {
                                    int dz;
                                    HolePoint existing = (HolePoint)element$iv;
                                    boolean bl3 = false;
                                    int dx = candidate.getX() - existing.getX();
                                    if (!(Math.sqrt(dx * dx + (dz = candidate.getZ() - existing.getZ()) * dz) < minDistanceBetweenPoints)) continue;
                                    v0 = true;
                                    break block32;
                                }
                                v0 = tooClose = false;
                            }
                        }
                        if (tooClose) continue;
                        validPoint = candidate;
                        break;
                    }
                    if (validPoint != null) {
                        bl = voronoiPoints.add(validPoint);
                        continue;
                    }
                    pointX = chunkCenterX + random.nextInt(-16, 16);
                    pointZ = chunkCenterZ + random.nextInt(-16, 16);
                    bl = voronoiPoints.add(new HolePoint(pointX, pointZ));
                }
            }
        }
        Map isSolidMap = new LinkedHashMap();
        int x = chunkAccess.getPos().getMinBlockX();
        if (x <= (targetChunkX = chunkAccess.getPos().getMaxBlockX())) {
            while (true) {
                int random;
                int z;
                if ((z = chunkAccess.getPos().getMinBlockZ()) <= (random = chunkAccess.getPos().getMaxBlockZ())) {
                    while (true) {
                        double minDist = Double.MAX_VALUE;
                        double secondMinDist = Double.MAX_VALUE;
                        for (HolePoint point : voronoiPoints) {
                            double dist = Math.sqrt((x - point.getX()) * (x - point.getX()) + (z - point.getZ()) * (z - point.getZ()));
                            if (dist < minDist) {
                                secondMinDist = minDist;
                                minDist = dist;
                                continue;
                            }
                            if (!(dist < secondMinDist)) continue;
                            secondMinDist = dist;
                        }
                        double edgeDistance = Math.abs(secondMinDist - minDist);
                        double pathwayThickness = 2.895;
                        double minHoleRadius = 3.0;
                        boolean isInHole = minDist < minHoleRadius;
                        Map map = isSolidMap;
                        Pair pair = new Pair((Object)x, (Object)z);
                        Boolean bl = edgeDistance < pathwayThickness && !isInHole;
                        map.put(pair, bl);
                        if (z == random) break;
                        ++z;
                    }
                }
                if (x == targetChunkX) break;
                ++x;
            }
        }
        Map fixedSolidMap = new LinkedHashMap();
        int x2 = chunkAccess.getPos().getMinBlockX();
        if (x2 <= (n = chunkAccess.getPos().getMaxBlockX())) {
            while (true) {
                int n2;
                int z;
                if ((z = chunkAccess.getPos().getMinBlockZ()) <= (n2 = chunkAccess.getPos().getMaxBlockZ())) {
                    while (true) {
                        boolean currentIsSolid;
                        Boolean bl = (Boolean)isSolidMap.get(new Pair((Object)x2, (Object)z));
                        boolean bl4 = currentIsSolid = bl != null ? bl : false;
                        if (!currentIsSolid) {
                            int n3;
                            Object[] minDistanceBetweenPoints = new Boolean[8];
                            Boolean bl5 = (Boolean)isSolidMap.get(new Pair((Object)(x2 + 1), (Object)z));
                            minDistanceBetweenPoints[0] = bl5 != null ? bl5 : true;
                            Boolean bl6 = (Boolean)isSolidMap.get(new Pair((Object)(x2 - 1), (Object)z));
                            minDistanceBetweenPoints[1] = bl6 != null ? bl6 : true;
                            Boolean bl7 = (Boolean)isSolidMap.get(new Pair((Object)x2, (Object)(z + 1)));
                            minDistanceBetweenPoints[2] = bl7 != null ? bl7 : true;
                            Boolean bl8 = (Boolean)isSolidMap.get(new Pair((Object)x2, (Object)(z - 1)));
                            minDistanceBetweenPoints[3] = bl8 != null ? bl8 : true;
                            Boolean bl9 = (Boolean)isSolidMap.get(new Pair((Object)(x2 + 1), (Object)(z + 1)));
                            minDistanceBetweenPoints[4] = bl9 != null ? bl9 : true;
                            Boolean bl10 = (Boolean)isSolidMap.get(new Pair((Object)(x2 + 1), (Object)(z - 1)));
                            minDistanceBetweenPoints[5] = bl10 != null ? bl10 : true;
                            Boolean bl11 = (Boolean)isSolidMap.get(new Pair((Object)(x2 - 1), (Object)(z + 1)));
                            minDistanceBetweenPoints[6] = bl11 != null ? bl11 : true;
                            Boolean bl12 = (Boolean)isSolidMap.get(new Pair((Object)(x2 - 1), (Object)(z - 1)));
                            minDistanceBetweenPoints[7] = bl12 != null ? bl12 : true;
                            List surroundingSolids = CollectionsKt.listOf((Object[])minDistanceBetweenPoints);
                            $this$count$iv = surroundingSolids;
                            boolean $i$f$count = false;
                            if ($this$count$iv instanceof Collection && ((Collection)$this$count$iv).isEmpty()) {
                                n3 = 0;
                            } else {
                                int count$iv = 0;
                                Iterator iterator = $this$count$iv.iterator();
                                while (iterator.hasNext()) {
                                    Object element$iv = iterator.next();
                                    boolean it = (Boolean)element$iv;
                                    boolean bl13 = false;
                                    if (!it || ++count$iv >= 0) continue;
                                    CollectionsKt.throwCountOverflow();
                                }
                                n3 = count$iv;
                            }
                            int solidCount = n3;
                            $this$count$iv = fixedSolidMap;
                            Pair pair = new Pair((Object)x2, (Object)z);
                            Boolean bl14 = solidCount >= 6;
                            $this$count$iv.put(pair, bl14);
                        } else {
                            Map map = fixedSolidMap;
                            Pair solidCount = new Pair((Object)x2, (Object)z);
                            $this$count$iv = true;
                            map.put(solidCount, $this$count$iv);
                        }
                        if (z == n2) break;
                        ++z;
                    }
                }
                if (x2 == n) break;
                ++x2;
            }
        }
        if ((y = yOffset) <= (n = yOffset + 3)) {
            while (true) {
                int n4;
                int x3;
                if ((x3 = chunkAccess.getPos().getMinBlockX()) <= (n4 = chunkAccess.getPos().getMaxBlockX())) {
                    while (true) {
                        int n5;
                        int z;
                        if ((z = chunkAccess.getPos().getMinBlockZ()) <= (n5 = chunkAccess.getPos().getMaxBlockZ())) {
                            while (true) {
                                Boolean bl = (Boolean)fixedSolidMap.get(new Pair((Object)x3, (Object)z));
                                boolean isSolid = bl != null ? bl : false;
                                BlockPos pos = new BlockPos(x3, y, z);
                                if (level.ensureCanWrite(pos)) {
                                    boolean bl15 = isSolid ? level.setBlock(pos, Blocks.MUD.defaultBlockState(), 3) : level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                                }
                                if (z == n5) break;
                                ++z;
                            }
                        }
                        if (x3 == n4) break;
                        ++x3;
                    }
                }
                if (y == n) break;
                ++y;
            }
        }
        if ((double)level.getRandom().nextFloat() < 0.0045) {
            RandomSource randomSource = level.getRandom();
            Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"getRandom(...)");
            this.structureSelection(level, chunkAccess, yOffset + 4, randomSource);
        }
    }

    public final void structureSelection(@NotNull WorldGenLevel level, @NotNull ChunkAccess chunkAccess, int y, @NotNull RandomSource random) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)chunkAccess, (String)"chunkAccess");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Mirror mirror = random.nextBoolean() ? Mirror.FRONT_BACK : Mirror.NONE;
        Rotation rotation = (Rotation)EntriesMappings.entries$0.get(random.nextInt(0, 4));
        SimplexNoise noise = new SimplexNoise(random);
        Object[] objectArray = new String[]{"brick_artifact1", "brick_artifact2", "light_bench", "mud_house", "mud_pillar", "nowhere_descent", "nowhere_encounter", "nowhere_light", "nowhere_starve", "nowhere_worry", "nowhere_bars", "nowhere_bed", "nowhere_bricklight", "nowhere_door", "nowhere_fence", "nowhere_flower", "nowhere_glass", "nowhere_glob", "nowhere_infested", "nowhere_look", "nowhere_machine", "nowhere_marker", "nowhere_particles", "nowhere_redstone", "nowhere_smelt", "nowhere_tools", "nowhere_torch", "nowhere_tree"};
        String structure = (String)ArrayUtil.random((Collection)CollectionsKt.listOf((Object[])objectArray), (RandomSource)random);
        if (y < 70 && (double)random.nextFloat() < 0.05) {
            objectArray = new String[]{"mud_pillar", "brick_stairs"};
            structure = (String)ArrayUtil.random((Collection)CollectionsKt.listOf((Object[])objectArray), (RandomSource)random);
        }
        double baseX = chunkAccess.getPos().getWorldPosition().getX();
        double baseZ = chunkAccess.getPos().getWorldPosition().getZ();
        int offsetX = (int)(noise.getValue(baseX * 0.01, baseZ * 0.01) * (double)4);
        int offsetZ = (int)(noise.getValue(baseZ * 0.01, baseX * 0.01) * (double)4);
        ResourceLocation resourceLocation = TBSConstants.id(structure);
        BlockPos blockPos = chunkAccess.getPos().getWorldPosition().atY(y).offset(offsetX, 0, offsetZ);
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"offset(...)");
        this.placeStructure(resourceLocation, level, blockPos, mirror, rotation, chunkAccess);
    }

    public final void placeStructure(@NotNull ResourceLocation structureId, @NotNull WorldGenLevel region, @NotNull BlockPos pos, @NotNull Mirror mirror, @NotNull Rotation rotation, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)structureId, (String)"structureId");
        Intrinsics.checkNotNullParameter((Object)region, (String)"region");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)mirror, (String)"mirror");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        MinecraftServer minecraftServer = region.getServer();
        Intrinsics.checkNotNull((Object)minecraftServer);
        ServerLevel serverLevel = minecraftServer.getLevel(TBSDimensions.NOWHERE);
        if (serverLevel == null) {
            return;
        }
        ServerLevel level = serverLevel;
        Optional optional = level.getStructureManager().get(structureId);
        if (optional == null) {
            return;
        }
        Optional templateHolder = optional;
        Object t = templateHolder.get();
        Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
        StructureTemplate template = (StructureTemplate)t;
        int genMinX = chunk.getPos().getMinBlockX() - 16;
        int genMaxX = chunk.getPos().getMaxBlockX() + 16;
        int genMinZ = chunk.getPos().getMinBlockZ() - 16;
        int genMaxZ = chunk.getPos().getMaxBlockZ() + 16;
        BoundingBox boundingBox = new BoundingBox(genMinX, level.getMinBuildHeight(), genMinZ, genMaxX, level.getMaxBuildHeight(), genMaxZ);
        StructurePlaceSettings settings = new StructurePlaceSettings().setIgnoreEntities(false).setMirror(mirror).setRotation(rotation).setBoundingBox(boundingBox);
        BlockPos transformedOrigin = template.getZeroPositionWithTransform(pos, mirror, rotation);
        BlockState blockToPlace = Blocks.MUD.defaultBlockState();
        Vec3i size = template.getSize(rotation);
        BlockPos transformedMax = StructureTemplate.transform((BlockPos)new BlockPos(size.getX() - 1, 0, size.getZ() - 1), (Mirror)mirror, (Rotation)rotation, (BlockPos)BlockPos.ZERO);
        int minX = Math.min(0, transformedMax.getX());
        int maxX = Math.max(0, transformedMax.getX());
        int minZ = Math.min(0, transformedMax.getZ());
        int maxZ = Math.max(0, transformedMax.getZ());
        int worldMinX = transformedOrigin.getX() + minX;
        int worldMaxX = transformedOrigin.getX() + maxX;
        int worldMinZ = transformedOrigin.getZ() + minZ;
        int worldMaxZ = transformedOrigin.getZ() + maxZ;
        int centerX = (worldMinX + worldMaxX) / 2;
        int centerZ = (worldMinZ + worldMaxZ) / 2;
        int radius = Math.max(worldMaxX - worldMinX, worldMaxZ - worldMinZ) / 2 + 3;
        int radiusSq = radius * radius;
        block0: for (int yOffset = 1; yOffset < 5; ++yOffset) {
            int x = -radius;
            if (x > radius) continue;
            while (true) {
                int z;
                if ((z = -radius) <= radius) {
                    while (true) {
                        if (x * x + z * z <= radiusSq) {
                            BlockPos placePos = new BlockPos(centerX + x, transformedOrigin.getY() - yOffset, centerZ + z);
                            region.setBlock(placePos, blockToPlace, 2);
                        }
                        if (z == radius) break;
                        ++z;
                    }
                }
                if (x == radius) continue block0;
                ++x;
            }
        }
        template.placeInWorld((ServerLevelAccessor)region, transformedOrigin, transformedOrigin, settings, region.getRandom(), 3);
    }

    public void buildSurface(@NotNull WorldGenRegion level, @NotNull StructureManager structureManager, @NotNull RandomState random, @NotNull ChunkAccess chunk) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
    }

    public void spawnOriginalMobs(@NotNull WorldGenRegion p0) {
        Intrinsics.checkNotNullParameter((Object)p0, (String)"p0");
    }

    public int getGenDepth() {
        return 1;
    }

    public void applyBiomeDecoration(@NotNull WorldGenLevel level, @NotNull ChunkAccess chunk, @NotNull StructureManager structureManager) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        this.genRoom(level, chunk, -30, 0, 0, 341873128712L, 1);
        this.genRoom(level, chunk, -10, 10, 5, 7862437856L, 2);
        this.genRoom(level, chunk, 10, -5, 10, 7084590L, 3);
        this.genRoom(level, chunk, 30, 15, -8, 8225542L, 4);
        this.genRoom(level, chunk, 50, 3, 8, 6382540L, 1);
        this.genRoom(level, chunk, 70, 2, -7, 3183997L, 2);
    }

    public void applyCarvers(@NotNull WorldGenRegion level, long seed, @NotNull RandomState random, @NotNull BiomeManager biomeManager, @NotNull StructureManager structureManager, @NotNull ChunkAccess chunk, @NotNull GenerationStep.Carving step) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        Intrinsics.checkNotNullParameter((Object)biomeManager, (String)"biomeManager");
        Intrinsics.checkNotNullParameter((Object)structureManager, (String)"structureManager");
        Intrinsics.checkNotNullParameter((Object)chunk, (String)"chunk");
        Intrinsics.checkNotNullParameter((Object)step, (String)"step");
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

    public int getBaseHeight(int p0, int p1, @NotNull Heightmap.Types p2, @NotNull LevelHeightAccessor p3, @NotNull RandomState p4) {
        Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
        Intrinsics.checkNotNullParameter((Object)p3, (String)"p3");
        Intrinsics.checkNotNullParameter((Object)p4, (String)"p4");
        return 1;
    }

    @NotNull
    public NoiseColumn getBaseColumn(int p0, int p1, @NotNull LevelHeightAccessor p2, @NotNull RandomState p3) {
        Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
        Intrinsics.checkNotNullParameter((Object)p3, (String)"p3");
        int minY = p2.getMinBuildHeight();
        int height = p2.getHeight();
        int n = 0;
        BlockState[] blockStateArray = new BlockState[height];
        while (n < height) {
            int n2 = n++;
            blockStateArray[n2] = Blocks.AIR.defaultBlockState();
        }
        BlockState[] states = blockStateArray;
        return new NoiseColumn(minY, states);
    }

    public void addDebugScreenInfo(@NotNull List<String> p0, @NotNull RandomState p1, @NotNull BlockPos p2) {
        Intrinsics.checkNotNullParameter(p0, (String)"p0");
        Intrinsics.checkNotNullParameter((Object)p1, (String)"p1");
        Intrinsics.checkNotNullParameter((Object)p2, (String)"p2");
    }

    @NotNull
    protected MapCodec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    private static final App CODEC$lambda$0(RecordCodecBuilder.Instance instance) {
        return instance.group((App)BiomeSource.CODEC.fieldOf("biome_source").forGetter(NowhereGenerator::CODEC$lambda$0$0)).apply((Applicative)instance, NowhereGenerator::new);
    }

    private static final BiomeSource CODEC$lambda$0$0(NowhereGenerator it) {
        return it.biomeSource;
    }

    static {
        MapCodec mapCodec = RecordCodecBuilder.mapCodec(NowhereGenerator::CODEC$lambda$0);
        Intrinsics.checkNotNullExpressionValue((Object)mapCodec, (String)"mapCodec(...)");
        CODEC = mapCodec;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/thebrokenscript/world/dimension/nowhere/NowhereGenerator$Companion;", "", "<init>", "()V", "CODEC", "Lcom/mojang/serialization/MapCodec;", "Lnet/thebrokenscript/world/dimension/nowhere/NowhereGenerator;", "getCODEC", "()Lcom/mojang/serialization/MapCodec;", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final MapCodec<NowhereGenerator> getCODEC() {
            return CODEC;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Rotation> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Rotation.values()));
        }
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u00a8\u0006\u0013"}, d2={"Lnet/thebrokenscript/world/dimension/nowhere/NowhereGenerator$HolePoint;", "", "x", "", "z", "<init>", "(II)V", "getX", "()I", "getZ", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "thebrokenscript-common"})
    public static final class HolePoint {
        private final int x;
        private final int z;

        public HolePoint(int x, int z) {
            this.x = x;
            this.z = z;
        }

        public final int getX() {
            return this.x;
        }

        public final int getZ() {
            return this.z;
        }

        public final int component1() {
            return this.x;
        }

        public final int component2() {
            return this.z;
        }

        @NotNull
        public final HolePoint copy(int x, int z) {
            return new HolePoint(x, z);
        }

        public static /* synthetic */ HolePoint copy$default(HolePoint holePoint, int n, int n2, int n3, Object object) {
            if ((n3 & 1) != 0) {
                n = holePoint.x;
            }
            if ((n3 & 2) != 0) {
                n2 = holePoint.z;
            }
            return holePoint.copy(n, n2);
        }

        @NotNull
        public String toString() {
            return "HolePoint(x=" + this.x + ", z=" + this.z + ")";
        }

        public int hashCode() {
            int result = Integer.hashCode(this.x);
            result = result * 31 + Integer.hashCode(this.z);
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HolePoint)) {
                return false;
            }
            HolePoint holePoint = (HolePoint)other;
            if (this.x != holePoint.x) {
                return false;
            }
            return this.z == holePoint.z;
        }
    }
}

