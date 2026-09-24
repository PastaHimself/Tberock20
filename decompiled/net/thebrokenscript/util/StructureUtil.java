/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$DoubleRef
 *  kotlin.jvm.internal.Ref$IntRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.Mth
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  net.thebrokenscript.brokencore.api.dsl.StructureUtil
 *  net.thebrokenscript.brokencore.api.ext.BoundingBoxExt
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector2d
 */
package net.thebrokenscript.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.thebrokenscript.brokencore.api.ext.BoundingBoxExt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2d;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00012B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005JG\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052'\u0010\u0013\u001a#\u0012\u0004\u0012\u00020\u0015\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\t0\u0014J6\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eJ\u001e\u0010!\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000eJ\u001e\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000eJr\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010&\u001a\u00020'26\u0010(\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00150\u0014J7\u0010)\u001a\u00020*2\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0012\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050,\"\u00020\u0005\u00a2\u0006\u0002\u0010-J.\u0010.\u001a\u00020*2\u0006\u0010\u0006\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eJ.\u0010/\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000eJ\f\u00100\u001a\u00020\t*\u000201H\u0002\u00a8\u00063"}, d2={"Lnet/thebrokenscript/util/StructureUtil;", "", "<init>", "()V", "getRandomPlacementPosition", "Lnet/minecraft/core/BlockPos;", "level", "Lnet/minecraft/world/level/Level;", "startX", "", "startZ", "minDist", "maxDist", "includeLeavesForDetection", "", "getAreaOccupancy", "Lnet/minecraft/server/level/ServerLevel;", "min", "max", "scoreFunc", "Lkotlin/Function2;", "Lnet/minecraft/world/level/block/state/BlockState;", "Lkotlin/ParameterName;", "name", "blockPos", "getSteepnessForStructureCorners", "pos", "id", "Lnet/minecraft/resources/ResourceLocation;", "rotation", "Lnet/minecraft/world/level/block/Rotation;", "includeLeaves", "useAverage", "getHighestPos", "distanceToGroundAt", "", "fillDownward", "", "mirror", "Lnet/minecraft/world/level/block/Mirror;", "stateProvider", "getSteepnessForPositions", "Lnet/thebrokenscript/util/StructureUtil$SteepnessMap;", "positions", "", "(Lnet/minecraft/server/level/ServerLevel;ZZ[Lnet/minecraft/core/BlockPos;)Lnet/thebrokenscript/util/StructureUtil$SteepnessMap;", "getSteepnessForArea", "getCornerSteepness", "deviation", "", "SteepnessMap", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nStructureUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StructureUtil.kt\nnet/thebrokenscript/util/StructureUtil\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,226:1\n13805#2,2:227\n*S KotlinDebug\n*F\n+ 1 StructureUtil.kt\nnet/thebrokenscript/util/StructureUtil\n*L\n154#1:227,2\n*E\n"})
public final class StructureUtil {
    @NotNull
    public static final StructureUtil INSTANCE = new StructureUtil();

    private StructureUtil() {
    }

    @NotNull
    public final BlockPos getRandomPlacementPosition(@NotNull Level level, double startX, double startZ, double minDist, double maxDist, boolean includeLeavesForDetection) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        RandomSource rand = RandomSource.create();
        double angle = Mth.nextDouble((RandomSource)rand, (double)(-Math.PI), (double)Math.PI);
        Vector2d vec = new Vector2d(Math.cos(angle), Math.sin(angle)).mul(Mth.nextDouble((RandomSource)rand, (double)minDist, (double)maxDist));
        BlockPos pos = new BlockPos((int)(startX + vec.x), level.getMaxBuildHeight(), (int)(startZ + vec.y));
        return this.getHighestPos(pos, level, includeLeavesForDetection);
    }

    public static /* synthetic */ BlockPos getRandomPlacementPosition$default(StructureUtil structureUtil, Level level, double d, double d2, double d3, double d4, boolean bl, int n, Object object) {
        if ((n & 0x20) != 0) {
            bl = false;
        }
        return structureUtil.getRandomPlacementPosition(level, d, d2, d3, d4, bl);
    }

    public final double getAreaOccupancy(@NotNull ServerLevel level, @NotNull BlockPos min, @NotNull BlockPos max) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        BoundingBox box = BoundingBox.fromCorners((Vec3i)((Vec3i)min), (Vec3i)((Vec3i)max));
        Vec3i length = box.getLength();
        int maxOccupancy = length.getX() * length.getY() * length.getZ();
        Ref.IntRef occupancy = new Ref.IntRef();
        Intrinsics.checkNotNull((Object)box);
        BoundingBoxExt.INSTANCE.forEachPos(box, arg_0 -> StructureUtil.getAreaOccupancy$lambda$0(level, occupancy, arg_0));
        return (double)occupancy.element / (double)maxOccupancy;
    }

    public final double getAreaOccupancy(@NotNull ServerLevel level, @NotNull BlockPos min, @NotNull BlockPos max, @NotNull Function2<? super BlockState, ? super BlockPos, Double> scoreFunc) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        Intrinsics.checkNotNullParameter(scoreFunc, (String)"scoreFunc");
        BoundingBox box = BoundingBox.fromCorners((Vec3i)((Vec3i)min), (Vec3i)((Vec3i)max));
        Vec3i length = box.getLength();
        int maxOccupancy = length.getX() * length.getY() * length.getZ();
        Ref.DoubleRef occupancy = new Ref.DoubleRef();
        Intrinsics.checkNotNull((Object)box);
        BoundingBoxExt.INSTANCE.forEachPos(box, arg_0 -> StructureUtil.getAreaOccupancy$lambda$1(occupancy, scoreFunc, level, arg_0));
        return Math.clamp(occupancy.element, 0.0, (double)maxOccupancy);
    }

    public final double getSteepnessForStructureCorners(@NotNull BlockPos pos, @NotNull ServerLevel level, @NotNull ResourceLocation id, @NotNull Rotation rotation, boolean includeLeaves, boolean useAverage) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
        StructureTemplate structure = net.thebrokenscript.brokencore.api.dsl.StructureUtil.getStructure((ServerLevel)level, (ResourceLocation)id);
        BlockPos max = pos.offset(structure.getSize(rotation));
        Intrinsics.checkNotNull((Object)max);
        return this.getCornerSteepness(pos, max, (Level)level, includeLeaves, useAverage);
    }

    @NotNull
    public final BlockPos getHighestPos(@NotNull BlockPos pos, @NotNull Level level, boolean includeLeaves) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        BlockPos.MutableBlockPos mutable = pos.mutable();
        while (mutable.getY() > level.getMinBuildHeight()) {
            BlockState state = level.getBlockState((BlockPos)mutable);
            if (!state.canBeReplaced() && !state.isAir() && (includeLeaves ? true : !state.is(BlockTags.LEAVES))) {
                BlockPos blockPos = mutable.immutable();
                Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"immutable(...)");
                return blockPos;
            }
            mutable.setY(mutable.getY() - 1);
        }
        BlockPos blockPos = mutable.immutable();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"immutable(...)");
        return blockPos;
    }

    public final int distanceToGroundAt(@NotNull BlockPos pos, @NotNull Level level, boolean includeLeaves) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        int a = pos.getY();
        int b = this.getHighestPos(pos, level, includeLeaves).getY();
        return Math.abs(b - a);
    }

    public final void fillDownward(@NotNull BlockPos pos, @NotNull ResourceLocation id, @NotNull ServerLevel level, boolean includeLeaves, @NotNull Rotation rotation, @NotNull Mirror mirror, @NotNull Function2<? super BlockPos, ? super ServerLevel, ? extends BlockState> stateProvider) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
        Intrinsics.checkNotNullParameter((Object)mirror, (String)"mirror");
        Intrinsics.checkNotNullParameter(stateProvider, (String)"stateProvider");
        StructureTemplate structure = net.thebrokenscript.brokencore.api.dsl.StructureUtil.getStructure((ServerLevel)level, (ResourceLocation)id);
        StructurePlaceSettings settings = new StructurePlaceSettings().addProcessor((StructureProcessor)BlockIgnoreProcessor.STRUCTURE_BLOCK).setRotation(rotation).setIgnoreEntities(false).setMirror(mirror);
        BoundingBox box = structure.getBoundingBox(settings, pos);
        int x = box.minX();
        int n = box.maxX();
        if (x <= n) {
            while (true) {
                int n2;
                int z;
                if ((z = box.minZ()) <= (n2 = box.maxZ())) {
                    while (true) {
                        BlockPos ofsPos;
                        BlockState state;
                        int candidateY;
                        if ((candidateY = pos.getY() - 1) < box.minY()) {
                            candidateY = box.minY();
                        }
                        while (candidateY > level.getMinBuildHeight() && ((state = level.getBlockState(ofsPos = new BlockPos(x, candidateY, z))).canBeReplaced() || state.isAir()) && state.getFluidState().isEmpty() && (includeLeaves || !state.is(BlockTags.LEAVES))) {
                            BlockPos blockPos = ofsPos.immutable();
                            Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"immutable(...)");
                            level.setBlock(ofsPos, (BlockState)stateProvider.invoke((Object)blockPos, (Object)level), 3);
                            --candidateY;
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

    public static /* synthetic */ void fillDownward$default(StructureUtil structureUtil, BlockPos blockPos, ResourceLocation resourceLocation, ServerLevel serverLevel, boolean bl, Rotation rotation, Mirror mirror, Function2 function2, int n, Object object) {
        if ((n & 0x10) != 0) {
            rotation = Rotation.NONE;
        }
        if ((n & 0x20) != 0) {
            mirror = Mirror.NONE;
        }
        structureUtil.fillDownward(blockPos, resourceLocation, serverLevel, bl, rotation, mirror, (Function2<? super BlockPos, ? super ServerLevel, ? extends BlockState>)function2);
    }

    @NotNull
    public final SteepnessMap getSteepnessForPositions(@NotNull ServerLevel level, boolean includeLeaves, boolean useAverage, BlockPos ... positions) {
        int n;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)positions, (String)"positions");
        List list = new ArrayList();
        HashMap<BlockPos, Pair<BlockPos, Integer>> posMap = new HashMap<BlockPos, Pair<BlockPos, Integer>>();
        BlockPos[] $this$forEach$iv = positions;
        boolean $i$f$forEach = false;
        int n2 = $this$forEach$iv.length;
        for (n = 0; n < n2; ++n) {
            BlockPos element$iv;
            BlockPos it = element$iv = $this$forEach$iv[n];
            boolean bl = false;
            BlockPos groundPos = INSTANCE.getHighestPos(it, (Level)level, includeLeaves);
            int distanceToGround = Math.abs(it.getY() - groundPos.getY());
            ((Map)posMap).put(it, new Pair((Object)groundPos, (Object)distanceToGround));
            list.add(distanceToGround);
        }
        int n3 = 0;
        n = list.size();
        int[] nArray = new int[n];
        while (n3 < n) {
            int n4 = n3++;
            nArray[n4] = ((Number)list.get(n4)).intValue();
        }
        int[] steepness = nArray;
        return new SteepnessMap(useAverage ? ArraysKt.average((int[])steepness) : this.deviation(steepness), posMap);
    }

    @NotNull
    public final SteepnessMap getSteepnessForArea(@NotNull ServerLevel level, @NotNull BlockPos min, @NotNull BlockPos max, boolean includeLeaves, boolean useAverage) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        List list = new ArrayList();
        HashMap<BlockPos, Pair<BlockPos, Integer>> posMap = new HashMap<BlockPos, Pair<BlockPos, Integer>>();
        int x = min.getX();
        int n = max.getX();
        if (x <= n) {
            while (true) {
                int n2;
                int z;
                if ((z = min.getZ()) <= (n2 = max.getZ())) {
                    while (true) {
                        BlockPos pos = new BlockPos(x, min.getY(), z);
                        BlockPos groundPos = this.getHighestPos(pos, (Level)level, includeLeaves);
                        int distanceToGround = Math.abs(pos.getY() - groundPos.getY());
                        ((Map)posMap).put(min, new Pair((Object)groundPos, (Object)distanceToGround));
                        list.add(distanceToGround);
                        if (z == n2) break;
                        ++z;
                    }
                }
                if (x == n) break;
                ++x;
            }
        }
        n = 0;
        int n3 = list.size();
        int[] nArray = new int[n3];
        while (n < n3) {
            int n4 = n++;
            nArray[n4] = ((Number)list.get(n4)).intValue();
        }
        int[] steepness = nArray;
        return new SteepnessMap(useAverage ? ArraysKt.average((int[])steepness) : this.deviation(steepness), posMap);
    }

    public final double getCornerSteepness(@NotNull BlockPos min, @NotNull BlockPos max, @NotNull Level level, boolean includeLeaves, boolean useAverage) {
        Intrinsics.checkNotNullParameter((Object)min, (String)"min");
        Intrinsics.checkNotNullParameter((Object)max, (String)"max");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        BlockPos nw = new BlockPos(min.getX(), max.getY(), min.getZ());
        BlockPos ne = new BlockPos(max.getX(), max.getY(), min.getZ());
        BlockPos sw = new BlockPos(min.getX(), max.getY(), max.getZ());
        BlockPos se = new BlockPos(max.getX(), max.getY(), max.getZ());
        int nwDist = this.distanceToGroundAt(nw, level, includeLeaves);
        int neDist = this.distanceToGroundAt(ne, level, includeLeaves);
        int swDist = this.distanceToGroundAt(sw, level, includeLeaves);
        int seDist = this.distanceToGroundAt(se, level, includeLeaves);
        int[] nArray = new int[]{nwDist, neDist, swDist, seDist};
        int[] steepness = nArray;
        return useAverage ? ArraysKt.average((int[])steepness) : this.deviation(steepness);
    }

    private final double deviation(int[] $this$deviation) {
        double standardDeviation = 0.0;
        int n = $this$deviation.length;
        for (int i = 0; i < n; ++i) {
            int num = $this$deviation[i];
            standardDeviation += Math.pow((double)num - ArraysKt.average((int[])$this$deviation), 2.0);
        }
        double result = Math.sqrt(standardDeviation / (double)$this$deviation.length);
        return Double.isNaN(result) ? 0.0 : result;
    }

    private static final Unit getAreaOccupancy$lambda$0(ServerLevel $level, Ref.IntRef $occupancy, BlockPos it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        if ($level.getBlockState(it).canBeReplaced()) {
            int n = $occupancy.element;
            $occupancy.element = n + 1;
        }
        return Unit.INSTANCE;
    }

    private static final Unit getAreaOccupancy$lambda$1(Ref.DoubleRef $occupancy, Function2 $scoreFunc, ServerLevel $level, BlockPos it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        double d = $occupancy.element;
        BlockState blockState = $level.getBlockState(it);
        Intrinsics.checkNotNullExpressionValue((Object)blockState, (String)"getBlockState(...)");
        $occupancy.element = d + ((Number)$scoreFunc.invoke((Object)blockState, (Object)it)).doubleValue();
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012:\u0010\u0004\u001a6\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0007`\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J=\u0010\u0011\u001a6\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0007`\tH\u00c6\u0003JQ\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032<\b\u0002\u0010\u0004\u001a6\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0007`\tH\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\bH\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rRE\u0010\u0004\u001a6\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00070\u0005j\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0007`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0019"}, d2={"Lnet/thebrokenscript/util/StructureUtil$SteepnessMap;", "", "steepness", "", "positions", "Ljava/util/HashMap;", "Lnet/minecraft/core/BlockPos;", "Lkotlin/Pair;", "", "Lkotlin/collections/HashMap;", "<init>", "(DLjava/util/HashMap;)V", "getSteepness", "()D", "getPositions", "()Ljava/util/HashMap;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "thebrokenscript-common"})
    public static final class SteepnessMap {
        private final double steepness;
        @NotNull
        private final HashMap<BlockPos, Pair<BlockPos, Integer>> positions;

        public SteepnessMap(double steepness, @NotNull HashMap<BlockPos, Pair<BlockPos, Integer>> positions) {
            Intrinsics.checkNotNullParameter(positions, (String)"positions");
            this.steepness = steepness;
            this.positions = positions;
        }

        public final double getSteepness() {
            return this.steepness;
        }

        @NotNull
        public final HashMap<BlockPos, Pair<BlockPos, Integer>> getPositions() {
            return this.positions;
        }

        public final double component1() {
            return this.steepness;
        }

        @NotNull
        public final HashMap<BlockPos, Pair<BlockPos, Integer>> component2() {
            return this.positions;
        }

        @NotNull
        public final SteepnessMap copy(double steepness, @NotNull HashMap<BlockPos, Pair<BlockPos, Integer>> positions) {
            Intrinsics.checkNotNullParameter(positions, (String)"positions");
            return new SteepnessMap(steepness, positions);
        }

        public static /* synthetic */ SteepnessMap copy$default(SteepnessMap steepnessMap, double d, HashMap hashMap, int n, Object object) {
            if ((n & 1) != 0) {
                d = steepnessMap.steepness;
            }
            if ((n & 2) != 0) {
                hashMap = steepnessMap.positions;
            }
            return steepnessMap.copy(d, hashMap);
        }

        @NotNull
        public String toString() {
            return "SteepnessMap(steepness=" + this.steepness + ", positions=" + this.positions + ")";
        }

        public int hashCode() {
            int result = Double.hashCode(this.steepness);
            result = result * 31 + this.positions.hashCode();
            return result;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SteepnessMap)) {
                return false;
            }
            SteepnessMap steepnessMap = (SteepnessMap)other;
            if (Double.compare(this.steepness, steepnessMap.steepness) != 0) {
                return false;
            }
            return Intrinsics.areEqual(this.positions, steepnessMap.positions);
        }
    }
}

