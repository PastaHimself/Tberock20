/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap$Entry
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap$FastEntrySet
 *  it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap
 *  it.unimi.dsi.fastutil.longs.LongCollection
 *  it.unimi.dsi.fastutil.longs.LongIterator
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  it.unimi.dsi.fastutil.objects.ObjectIterator
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.ArraysKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.collections.MapsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.math.MathKt
 *  kotlin.ranges.IntRange
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.Vec3i
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.WorldGenLevel
 *  net.minecraft.world.level.block.RotatedPillarBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.block.state.properties.BlockStateProperties
 *  net.minecraft.world.level.block.state.properties.BooleanProperty
 *  net.minecraft.world.level.block.state.properties.Property
 *  net.minecraft.world.level.levelgen.feature.Feature
 *  net.minecraft.world.level.levelgen.feature.FeaturePlaceContext
 *  net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.world.gen.features;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongCollection;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.thebrokenscript.registry.TBSBlocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004JT\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002Jb\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015Jb\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J^\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J^\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002JL\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020#J^\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000e2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00104\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u00105\u001a\u0002062\u000e\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000208H\u0016J\u0018\u00109\u001a\u0002062\u0006\u0010\u0007\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u00a8\u0006;"}, d2={"Lnet/thebrokenscript/world/gen/features/VoidCystFeature;", "Lnet/minecraft/world/level/levelgen/feature/Feature;", "Lnet/minecraft/world/level/levelgen/feature/configurations/NoneFeatureConfiguration;", "<init>", "()V", "addWoodOrObsidian", "", "pos", "Lnet/minecraft/core/BlockPos$MutableBlockPos;", "block", "Lnet/minecraft/world/level/block/state/BlockState;", "woodMap", "Lit/unimi/dsi/fastutil/longs/Long2ObjectOpenHashMap;", "vineCandidates", "Lit/unimi/dsi/fastutil/longs/LongOpenHashSet;", "obsidianSet", "obsidianChance", "", "random", "Lnet/minecraft/util/RandomSource;", "origin", "Lnet/minecraft/core/BlockPos;", "placeLineBetween", "from", "to", "placeSphere", "center", "radius", "generateMotherBranch", "start", "end", "generateChildBranch", "generateRootWaypoints", "", "originX", "", "originY", "originZ", "outerX", "outerY", "outerZ", "controlX", "controlZ", "processVines", "level", "Lnet/minecraft/world/level/WorldGenLevel;", "candidates", "vineMap", "vineState", "chance", "minLen", "maxLen", "minY", "place", "", "context", "Lnet/minecraft/world/level/levelgen/feature/FeaturePlaceContext;", "isWithinGenRegion", "Companion", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nVoidCystFeature.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoidCystFeature.kt\nnet/thebrokenscript/world/gen/features/VoidCystFeature\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,559:1\n1563#2:560\n1634#2,3:561\n1068#2:564\n37#3,2:565\n1#4:567\n*S KotlinDebug\n*F\n+ 1 VoidCystFeature.kt\nnet/thebrokenscript/world/gen/features/VoidCystFeature\n*L\n222#1:560\n222#1:561,3\n464#1:564\n494#1:565,2\n*E\n"})
public final class VoidCystFeature
extends Feature<NoneFeatureConfiguration> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int MAX_HORIZONTAL_RADIUS = 15;

    public VoidCystFeature() {
        super(NoneFeatureConfiguration.CODEC);
    }

    private final void addWoodOrObsidian(BlockPos.MutableBlockPos pos, BlockState block, Long2ObjectOpenHashMap<BlockState> woodMap, LongOpenHashSet vineCandidates, LongOpenHashSet obsidianSet, double obsidianChance, RandomSource random, BlockPos origin) {
        block2: {
            block1: {
                if (!this.isWithinGenRegion((BlockPos)pos, origin)) {
                    return;
                }
                if (random == null || obsidianSet == null || !(obsidianChance > 0.0) || !(random.nextDouble() < obsidianChance)) break block1;
                obsidianSet.add(pos.asLong());
                break block2;
            }
            woodMap.put(pos.asLong(), (Object)block);
            LongOpenHashSet longOpenHashSet = vineCandidates;
            if (longOpenHashSet == null) break block2;
            longOpenHashSet.add(pos.asLong());
        }
    }

    public final void placeLineBetween(@NotNull BlockPos from, @NotNull BlockPos to, @NotNull BlockState block, @NotNull Long2ObjectOpenHashMap<BlockState> woodMap, @Nullable LongOpenHashSet vineCandidates, @Nullable LongOpenHashSet obsidianSet, double obsidianChance, @Nullable RandomSource random, @NotNull BlockPos origin) {
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        Intrinsics.checkNotNullParameter((Object)to, (String)"to");
        Intrinsics.checkNotNullParameter((Object)block, (String)"block");
        Intrinsics.checkNotNullParameter(woodMap, (String)"woodMap");
        Intrinsics.checkNotNullParameter((Object)origin, (String)"origin");
        int x = 0;
        x = from.getX();
        int y = 0;
        y = from.getY();
        int z = 0;
        z = from.getZ();
        int dx = Math.abs(to.getX() - x);
        int dy = Math.abs(to.getY() - y);
        int dz = Math.abs(to.getZ() - z);
        int sx = to.getX() > x ? 1 : -1;
        int sy = to.getY() > y ? 1 : -1;
        int sz = to.getZ() > z ? 1 : -1;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        if (dx >= dy && dx >= dz) {
            BlockState rotatedBlock = (BlockState)block.setValue((Property)RotatedPillarBlock.AXIS, (Comparable)Direction.Axis.X);
            int ey = 0;
            ey = 2 * dy - dx;
            int ez = 0;
            ez = 2 * dz - dx;
            for (int i = 0; i < dx; ++i) {
                int it = i;
                boolean bl = false;
                pos.set(x, y, z);
                Intrinsics.checkNotNull((Object)rotatedBlock);
                this.addWoodOrObsidian(pos, rotatedBlock, woodMap, vineCandidates, obsidianSet, obsidianChance, random, origin);
                if (ey > 0) {
                    y += sy;
                    ey -= 2 * dx;
                }
                ey += 2 * dy;
                if (ez > 0) {
                    z += sz;
                    ez -= 2 * dz;
                }
                ez += 2 * dz;
                x += sx;
            }
        } else if (dz >= dx && dz >= dy) {
            BlockState rotatedBlock = (BlockState)block.setValue((Property)RotatedPillarBlock.AXIS, (Comparable)Direction.Axis.Z);
            int ex = 0;
            ex = 2 * dx - dz;
            int ey = 0;
            ey = 2 * dy - dz;
            for (int i = 0; i < dz; ++i) {
                int it = i;
                boolean bl = false;
                pos.set(x, y, z);
                Intrinsics.checkNotNull((Object)rotatedBlock);
                this.addWoodOrObsidian(pos, rotatedBlock, woodMap, vineCandidates, obsidianSet, obsidianChance, random, origin);
                if (ex > 0) {
                    x += sx;
                    ex -= 2 * dz;
                }
                ex += 2 * dx;
                if (ey > 0) {
                    y += sy;
                    ey -= 2 * dz;
                }
                ey += 2 * dy;
                z += sz;
            }
        } else {
            BlockState rotatedBlock = (BlockState)block.setValue((Property)RotatedPillarBlock.AXIS, (Comparable)Direction.Axis.Y);
            int ex = 0;
            ex = 2 * dx - dy;
            int ez = 0;
            ez = 2 * dz - dy;
            for (int i = 0; i < dy; ++i) {
                int it = i;
                boolean bl = false;
                pos.set(x, y, z);
                Intrinsics.checkNotNull((Object)rotatedBlock);
                this.addWoodOrObsidian(pos, rotatedBlock, woodMap, vineCandidates, obsidianSet, obsidianChance, random, origin);
                if (ex > 0) {
                    x += sx;
                    ex -= 2 * dy;
                }
                ex += 2 * dx;
                if (ez > 0) {
                    z += sz;
                    ez -= 2 * dy;
                }
                ez += 2 * dz;
                y += sy;
            }
        }
        pos.set(x, y, z);
        this.addWoodOrObsidian(pos, block, woodMap, vineCandidates, obsidianSet, obsidianChance, random, origin);
    }

    public static /* synthetic */ void placeLineBetween$default(VoidCystFeature voidCystFeature, BlockPos blockPos, BlockPos blockPos2, BlockState blockState, Long2ObjectOpenHashMap long2ObjectOpenHashMap, LongOpenHashSet longOpenHashSet, LongOpenHashSet longOpenHashSet2, double d, RandomSource randomSource, BlockPos blockPos3, int n, Object object) {
        if ((n & 0x10) != 0) {
            longOpenHashSet = null;
        }
        if ((n & 0x20) != 0) {
            longOpenHashSet2 = null;
        }
        if ((n & 0x40) != 0) {
            d = 0.0;
        }
        if ((n & 0x80) != 0) {
            randomSource = null;
        }
        voidCystFeature.placeLineBetween(blockPos, blockPos2, blockState, (Long2ObjectOpenHashMap<BlockState>)long2ObjectOpenHashMap, longOpenHashSet, longOpenHashSet2, d, randomSource, blockPos3);
    }

    public final void placeSphere(@NotNull BlockPos center, double radius, @NotNull BlockState block, @NotNull Long2ObjectOpenHashMap<BlockState> woodMap, @Nullable LongOpenHashSet vineCandidates, @Nullable LongOpenHashSet obsidianSet, double obsidianChance, @Nullable RandomSource random, @NotNull BlockPos origin) {
        Intrinsics.checkNotNullParameter((Object)center, (String)"center");
        Intrinsics.checkNotNullParameter((Object)block, (String)"block");
        Intrinsics.checkNotNullParameter(woodMap, (String)"woodMap");
        Intrinsics.checkNotNullParameter((Object)origin, (String)"origin");
        int r = MathKt.roundToInt((double)radius);
        double rSquared = radius * radius;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        int ox = -r;
        if (ox <= r) {
            while (true) {
                int oy;
                if ((oy = -r) <= r) {
                    while (true) {
                        int oz;
                        if ((oz = -r) <= r) {
                            while (true) {
                                if ((double)(ox * ox + oy * oy + oz * oz) <= rSquared) {
                                    pos.set(center.getX() + ox, center.getY() + oy, center.getZ() + oz);
                                    this.addWoodOrObsidian(pos, block, woodMap, vineCandidates, obsidianSet, obsidianChance, random, origin);
                                }
                                if (oz == r) break;
                                ++oz;
                            }
                        }
                        if (oy == r) break;
                        ++oy;
                    }
                }
                if (ox == r) break;
                ++ox;
            }
        }
    }

    public static /* synthetic */ void placeSphere$default(VoidCystFeature voidCystFeature, BlockPos blockPos, double d, BlockState blockState, Long2ObjectOpenHashMap long2ObjectOpenHashMap, LongOpenHashSet longOpenHashSet, LongOpenHashSet longOpenHashSet2, double d2, RandomSource randomSource, BlockPos blockPos2, int n, Object object) {
        if ((n & 0x10) != 0) {
            longOpenHashSet = null;
        }
        if ((n & 0x20) != 0) {
            longOpenHashSet2 = null;
        }
        if ((n & 0x40) != 0) {
            d2 = 0.0;
        }
        if ((n & 0x80) != 0) {
            randomSource = null;
        }
        voidCystFeature.placeSphere(blockPos, d, blockState, (Long2ObjectOpenHashMap<BlockState>)long2ObjectOpenHashMap, longOpenHashSet, longOpenHashSet2, d2, randomSource, blockPos2);
    }

    private final void generateMotherBranch(BlockPos start, BlockPos end, RandomSource random, BlockState block, Long2ObjectOpenHashMap<BlockState> woodMap, LongOpenHashSet vineCandidates, LongOpenHashSet obsidianSet, double obsidianChance, BlockPos origin) {
        int dx = end.getX() - start.getX();
        int dy = end.getY() - start.getY();
        int dz = end.getZ() - start.getZ();
        double midX = (double)start.getX() + (double)dx * 0.3;
        double midY = (double)start.getY() + (double)dy * 0.6 + (double)random.nextInt(3);
        double midZ = (double)start.getZ() + (double)dz * 0.3;
        int curlAmount = random.nextInt(6) - 3;
        double perpAngle = Math.atan2(dz, dx) + (random.nextBoolean() ? 1.5707963267948966 : -1.5707963267948966);
        int controlX = (int)(midX + (double)MathKt.roundToInt((double)((double)curlAmount * Math.cos(perpAngle))));
        int controlZ = (int)(midZ + (double)MathKt.roundToInt((double)((double)curlAmount * Math.sin(perpAngle))));
        BlockPos control = new BlockPos(controlX, (int)midY, controlZ);
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        for (int step = 0; step < 17; ++step) {
            double t = (double)step / 16.0;
            double oneMinusT = 1.0 - t;
            int x = MathKt.roundToInt((double)(oneMinusT * oneMinusT * (double)start.getX() + (double)2 * oneMinusT * t * (double)control.getX() + t * t * (double)end.getX()));
            int y = MathKt.roundToInt((double)(oneMinusT * oneMinusT * (double)start.getY() + (double)2 * oneMinusT * t * (double)control.getY() + t * t * (double)end.getY()));
            int z = MathKt.roundToInt((double)(oneMinusT * oneMinusT * (double)start.getZ() + (double)2 * oneMinusT * t * (double)control.getZ() + t * t * (double)end.getZ()));
            double tNext = (double)(step + 1) / 16.0;
            double oneMinusTNext = 1.0 - tNext;
            int nextX = MathKt.roundToInt((double)(oneMinusTNext * oneMinusTNext * (double)start.getX() + (double)2 * oneMinusTNext * tNext * (double)control.getX() + tNext * tNext * (double)end.getX()));
            int nextY = MathKt.roundToInt((double)(oneMinusTNext * oneMinusTNext * (double)start.getY() + (double)2 * oneMinusTNext * tNext * (double)control.getY() + tNext * tNext * (double)end.getY()));
            int nextZ = MathKt.roundToInt((double)(oneMinusTNext * oneMinusTNext * (double)start.getZ() + (double)2 * oneMinusTNext * tNext * (double)control.getZ() + tNext * tNext * (double)end.getZ()));
            int localDx = Math.abs(nextX - x);
            int localDy = Math.abs(nextY - y);
            int localDz = Math.abs(nextZ - z);
            BlockState rotatedBlock = (BlockState)block.setValue((Property)RotatedPillarBlock.AXIS, (Comparable)(localDx >= localDy && localDx >= localDz ? Direction.Axis.X : (localDy >= localDx && localDy >= localDz ? Direction.Axis.Y : Direction.Axis.Z)));
            pos.set(x, y, z);
            Intrinsics.checkNotNull((Object)rotatedBlock);
            this.addWoodOrObsidian(pos, rotatedBlock, woodMap, vineCandidates, obsidianSet, obsidianChance, random, origin);
            pos.set(x + 1, y, z);
            this.addWoodOrObsidian(pos, rotatedBlock, woodMap, null, obsidianSet, obsidianChance, random, origin);
            pos.set(x - 1, y, z);
            this.addWoodOrObsidian(pos, rotatedBlock, woodMap, null, obsidianSet, obsidianChance, random, origin);
            pos.set(x, y, z + 1);
            this.addWoodOrObsidian(pos, rotatedBlock, woodMap, null, obsidianSet, obsidianChance, random, origin);
            pos.set(x, y, z - 1);
            this.addWoodOrObsidian(pos, rotatedBlock, woodMap, null, obsidianSet, obsidianChance, random, origin);
        }
    }

    static /* synthetic */ void generateMotherBranch$default(VoidCystFeature voidCystFeature, BlockPos blockPos, BlockPos blockPos2, RandomSource randomSource, BlockState blockState, Long2ObjectOpenHashMap long2ObjectOpenHashMap, LongOpenHashSet longOpenHashSet, LongOpenHashSet longOpenHashSet2, double d, BlockPos blockPos3, int n, Object object) {
        if ((n & 0x20) != 0) {
            longOpenHashSet = null;
        }
        if ((n & 0x40) != 0) {
            longOpenHashSet2 = null;
        }
        voidCystFeature.generateMotherBranch(blockPos, blockPos2, randomSource, blockState, (Long2ObjectOpenHashMap<BlockState>)long2ObjectOpenHashMap, longOpenHashSet, longOpenHashSet2, d, blockPos3);
    }

    private final void generateChildBranch(BlockPos start, BlockPos end, RandomSource random, BlockState block, Long2ObjectOpenHashMap<BlockState> woodMap, LongOpenHashSet vineCandidates, LongOpenHashSet obsidianSet, double obsidianChance, BlockPos origin) {
        int dx = end.getX() - start.getX();
        int dz = end.getZ() - start.getZ();
        int steps = Math.max(11, MathKt.roundToInt((double)(Math.sqrt(dx * dx + dz * dz) * 2.0)));
        int deltaY = end.getY() - start.getY();
        double sagDepth = random.nextInt(1, 4);
        double A = 8.0 * sagDepth - 2.0 * (double)deltaY;
        double B = 3.0 * (double)deltaY - 8.0 * sagDepth;
        for (int step = 0; step < steps; ++step) {
            double t1 = (double)step / (double)steps;
            double t2 = (double)(step + 1) / (double)steps;
            this.placeLineBetween(new BlockPos(MathKt.roundToInt((double)((double)start.getX() + t1 * (double)dx)), MathKt.roundToInt((double)(A * t1 * t1 * t1 + B * t1 * t1 + (double)start.getY())), MathKt.roundToInt((double)((double)start.getZ() + t1 * (double)dz))), new BlockPos(MathKt.roundToInt((double)((double)start.getX() + t2 * (double)dx)), MathKt.roundToInt((double)(A * t2 * t2 * t2 + B * t2 * t2 + (double)start.getY())), MathKt.roundToInt((double)((double)start.getZ() + t2 * (double)dz))), block, woodMap, vineCandidates, obsidianSet, obsidianChance, random, origin);
        }
        int hookLength = random.nextInt(1, 3);
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        int i = 1;
        if (i <= hookLength) {
            while (true) {
                pos.set(end.getX(), end.getY() + i, end.getZ());
                this.addWoodOrObsidian(pos, block, woodMap, vineCandidates, obsidianSet, obsidianChance, random, origin);
                if (i == hookLength) break;
                ++i;
            }
        }
    }

    static /* synthetic */ void generateChildBranch$default(VoidCystFeature voidCystFeature, BlockPos blockPos, BlockPos blockPos2, RandomSource randomSource, BlockState blockState, Long2ObjectOpenHashMap long2ObjectOpenHashMap, LongOpenHashSet longOpenHashSet, LongOpenHashSet longOpenHashSet2, double d, BlockPos blockPos3, int n, Object object) {
        if ((n & 0x20) != 0) {
            longOpenHashSet = null;
        }
        if ((n & 0x40) != 0) {
            longOpenHashSet2 = null;
        }
        voidCystFeature.generateChildBranch(blockPos, blockPos2, randomSource, blockState, (Long2ObjectOpenHashMap<BlockState>)long2ObjectOpenHashMap, longOpenHashSet, longOpenHashSet2, d, blockPos3);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<BlockPos> generateRootWaypoints(int originX, int originY, int originZ, int outerX, int outerY, int outerZ, int controlX, int controlZ) {
        void $this$mapTo$iv$iv;
        Iterable $this$map$iv = (Iterable)new IntRange(0, 12);
        boolean $i$f$map = false;
        Iterable iterable = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        Iterator iterator = $this$mapTo$iv$iv.iterator();
        while (iterator.hasNext()) {
            void step;
            int item$iv$iv;
            int n = item$iv$iv = ((IntIterator)iterator).nextInt();
            Collection collection = destination$iv$iv;
            boolean bl = false;
            double t = (double)step / 12.0;
            double p1x = (double)originX + t * (double)(controlX - originX);
            double p1z = (double)originZ + t * (double)(controlZ - originZ);
            double p2x = (double)controlX + t * (double)(outerX - controlX);
            double p2z = (double)controlZ + t * (double)(outerZ - controlZ);
            int pathX = MathKt.roundToInt((double)(p1x + t * (p2x - p1x)));
            int pathZ = MathKt.roundToInt((double)(p1z + t * (p2z - p1z)));
            int baseY = originY + MathKt.roundToInt((double)((double)6 * (1.0 - t) * (1.0 - t)));
            collection.add(new BlockPos(pathX, MathKt.roundToInt((double)((double)baseY + (double)(outerY - originY) * t)), pathZ));
        }
        return (List)destination$iv$iv;
    }

    private final void processVines(WorldGenLevel level, LongOpenHashSet candidates, Long2ObjectOpenHashMap<BlockState> vineMap, BlockState vineState, double chance, int minLen, int maxLen, RandomSource random, int minY, BlockPos origin) {
        Direction[] directionArray = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST};
        Direction[] directions = directionArray;
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        BlockPos.MutableBlockPos neighborPos = new BlockPos.MutableBlockPos();
        LongIterator longIterator = new LongIterator[]{TuplesKt.to((Object)Direction.NORTH, (Object)((BlockState)((BlockState)((BlockState)vineState.setValue((Property)BlockStateProperties.NORTH, (Comparable)Boolean.valueOf(true))).setValue((Property)BlockStateProperties.SOUTH, (Comparable)Boolean.valueOf(false))).setValue((Property)BlockStateProperties.EAST, (Comparable)Boolean.valueOf(false))).setValue((Property)BlockStateProperties.WEST, (Comparable)Boolean.valueOf(false))), TuplesKt.to((Object)Direction.SOUTH, (Object)((BlockState)((BlockState)((BlockState)vineState.setValue((Property)BlockStateProperties.NORTH, (Comparable)Boolean.valueOf(false))).setValue((Property)BlockStateProperties.SOUTH, (Comparable)Boolean.valueOf(true))).setValue((Property)BlockStateProperties.EAST, (Comparable)Boolean.valueOf(false))).setValue((Property)BlockStateProperties.WEST, (Comparable)Boolean.valueOf(false))), TuplesKt.to((Object)Direction.EAST, (Object)((BlockState)((BlockState)((BlockState)vineState.setValue((Property)BlockStateProperties.NORTH, (Comparable)Boolean.valueOf(false))).setValue((Property)BlockStateProperties.SOUTH, (Comparable)Boolean.valueOf(false))).setValue((Property)BlockStateProperties.EAST, (Comparable)Boolean.valueOf(true))).setValue((Property)BlockStateProperties.WEST, (Comparable)Boolean.valueOf(false))), TuplesKt.to((Object)Direction.WEST, (Object)((BlockState)((BlockState)((BlockState)vineState.setValue((Property)BlockStateProperties.NORTH, (Comparable)Boolean.valueOf(false))).setValue((Property)BlockStateProperties.SOUTH, (Comparable)Boolean.valueOf(false))).setValue((Property)BlockStateProperties.EAST, (Comparable)Boolean.valueOf(false))).setValue((Property)BlockStateProperties.WEST, (Comparable)Boolean.valueOf(true)))};
        Map vineStateFor = MapsKt.mapOf((Pair[])longIterator);
        LongIterator longIterator2 = candidates.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)longIterator2, (String)"iterator(...)");
        longIterator = longIterator2;
        while (longIterator.hasNext()) {
            Long candidate = longIterator.next();
            Intrinsics.checkNotNull((Object)candidate);
            mutablePos.set(candidate.longValue());
            int x = mutablePos.getX();
            int y = mutablePos.getY();
            int z = mutablePos.getZ();
            if (y < minY || !this.isWithinGenRegion((BlockPos)mutablePos, origin)) continue;
            block1: for (Direction attachedDir : directions) {
                BlockState finalVineState;
                if (random.nextDouble() >= chance) continue;
                neighborPos.set(x + attachedDir.getStepX(), y + attachedDir.getStepY(), z + attachedDir.getStepZ());
                if (!level.isEmptyBlock((BlockPos)neighborPos)) continue;
                long vineLong = BlockPos.asLong((int)(x + attachedDir.getStepX()), (int)y, (int)(z + attachedDir.getStepZ()));
                BlockPos vinePos = BlockPos.of((long)vineLong);
                Intrinsics.checkNotNull((Object)vinePos);
                if (!this.isWithinGenRegion(vinePos, origin) || vineMap.containsKey(vineLong) || !level.isEmptyBlock(vinePos) || (BlockState)vineStateFor.get(attachedDir.getOpposite()) == null) continue;
                vineMap.put(vineLong, (Object)finalVineState);
                BlockPos.MutableBlockPos dropPos = new BlockPos.MutableBlockPos().set((Vec3i)BlockPos.of((long)vineLong));
                int length = random.nextInt(minLen, maxLen + 1);
                for (int i = 0; i < length; ++i) {
                    dropPos.move(Direction.DOWN);
                    long dropLong = dropPos.asLong();
                    if (dropPos.getY() < minY || vineMap.containsKey(dropLong) || !level.isEmptyBlock((BlockPos)dropPos)) continue block1;
                    BlockState cfr_ignored_0 = (BlockState)vineMap.put(dropLong, (Object)finalVineState);
                }
            }
        }
    }

    public boolean place(@NotNull FeaturePlaceContext<NoneFeatureConfiguration> context) {
        Intrinsics.checkNotNullParameter(context, (String)"context");
        BlockPos origin = context.origin();
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockState voidLog = TBSBlocks.VOID_LOG.getDefaultState();
        BlockState voidVines = TBSBlocks.VOID_VINE.getDefaultState();
        Long2ObjectOpenHashMap woodMap = new Long2ObjectOpenHashMap();
        LongOpenHashSet trunkCandidates = new LongOpenHashSet();
        LongOpenHashSet branchCandidates = new LongOpenHashSet();
        LongOpenHashSet obsidianSet = new LongOpenHashSet();
        Object[] objectArray = new Pair[]{new Pair((Object)-1, (Object)-1), new Pair((Object)0, (Object)-1), new Pair((Object)1, (Object)-1), new Pair((Object)-1, (Object)0), new Pair((Object)0, (Object)0), new Pair((Object)1, (Object)0), new Pair((Object)-1, (Object)1), new Pair((Object)0, (Object)1), new Pair((Object)1, (Object)1)};
        List superFatOffsets = CollectionsKt.listOf((Object[])objectArray);
        Object[] objectArray2 = new Pair[]{new Pair((Object)-1, (Object)-1), new Pair((Object)0, (Object)-1), new Pair((Object)-1, (Object)0), new Pair((Object)0, (Object)0)};
        List fatOffsets = CollectionsKt.listOf((Object[])objectArray2);
        Object[] objectArray3 = new Pair[]{new Pair((Object)-1, (Object)0), new Pair((Object)0, (Object)0)};
        List thinOffsets = CollectionsKt.listOf((Object[])objectArray3);
        BlockPos.MutableBlockPos rootPos = new BlockPos.MutableBlockPos();
        for (int i = 0; i < 7; ++i) {
            double angle = (double)i * 0.8975979010256552;
            int outerX = origin.getX() + MathKt.roundToInt((double)((double)16 * Math.cos(angle))) + random.nextInt(6) - 3;
            int outerZ = origin.getZ() + MathKt.roundToInt((double)((double)16 * Math.sin(angle))) + random.nextInt(6) - 3;
            int outerY = origin.getY();
            boolean foundGround = false;
            for (int j = 0; j < 12; ++j) {
                int checkY = outerY - j;
                if (level.isEmptyBlock(new BlockPos(outerX, checkY, outerZ))) continue;
                outerY = checkY + 1;
                foundGround = true;
                break;
            }
            if (!foundGround) continue;
            double pAngle = angle + 1.5707963267948966;
            int curlAmount = random.nextInt(8) - 4;
            int controlX = (origin.getX() + outerX) / 2 + MathKt.roundToInt((double)((double)curlAmount * Math.cos(pAngle)));
            int controlZ = (origin.getZ() + outerZ) / 2 + MathKt.roundToInt((double)((double)curlAmount * Math.sin(pAngle)));
            List<BlockPos> waypoints = this.generateRootWaypoints(origin.getX(), origin.getY(), origin.getZ(), outerX, outerY, outerZ, controlX, controlZ);
            int n = waypoints.size() - 1;
            for (int idx = 0; idx < n; ++idx) {
                BlockPos a = waypoints.get(idx);
                BlockPos b = waypoints.get(idx + 1);
                double t = (double)idx / 12.0;
                List offsets = t < 0.22 ? superFatOffsets : (t < 0.55 ? fatOffsets : thinOffsets);
                for (Pair pair : offsets) {
                    int ox = ((Number)pair.component1()).intValue();
                    int oz = ((Number)pair.component2()).intValue();
                    BlockPos from = a.offset(ox, 0, oz);
                    BlockPos to = b.offset(ox, 0, oz);
                    Intrinsics.checkNotNull((Object)from);
                    Intrinsics.checkNotNull((Object)to);
                    Intrinsics.checkNotNull((Object)origin);
                    this.placeLineBetween(from, to, voidLog, (Long2ObjectOpenHashMap<BlockState>)woodMap, null, obsidianSet, 0.03, random, origin);
                    rootPos.set((Vec3i)from.below());
                    this.addWoodOrObsidian(rootPos, voidLog, (Long2ObjectOpenHashMap<BlockState>)woodMap, null, obsidianSet, 0.03, random, origin);
                    rootPos.set((Vec3i)to.below());
                    this.addWoodOrObsidian(rootPos, voidLog, (Long2ObjectOpenHashMap<BlockState>)woodMap, null, obsidianSet, 0.03, random, origin);
                }
            }
        }
        BlockPos trunkPos = origin;
        double sphereRadius = 3.5;
        for (int i = 0; i < 3; ++i) {
            int nextX = trunkPos.getX() + random.nextInt(8) - 4;
            int nextZ = trunkPos.getZ() + random.nextInt(8) - 4;
            int nextY = trunkPos.getY() + 7;
            BlockPos nextPos = new BlockPos(nextX, nextY, nextZ);
            int controlX = (trunkPos.getX() + nextX) / 2 + random.nextInt(8) - 4;
            int controlZ = (trunkPos.getZ() + nextZ) / 2 + random.nextInt(8) - 4;
            int controlY = (trunkPos.getY() + nextY) / 2;
            for (int step = 0; step < 14; ++step) {
                double t = (double)step / 13.0;
                double p1x = (double)trunkPos.getX() + t * (double)(controlX - trunkPos.getX());
                double p1y = (double)trunkPos.getY() + t * (double)(controlY - trunkPos.getY());
                double p1z = (double)trunkPos.getZ() + t * (double)(controlZ - trunkPos.getZ());
                double p2x = (double)controlX + t * (double)(nextX - controlX);
                double p2y = (double)controlY + t * (double)(nextY - controlY);
                double p2z = (double)controlZ + t * (double)(nextZ - controlZ);
                BlockPos blockPos = new BlockPos(MathKt.roundToInt((double)(p1x + t * (p2x - p1x))), MathKt.roundToInt((double)(p1y + t * (p2y - p1y))), MathKt.roundToInt((double)(p1z + t * (p2z - p1z))));
                Intrinsics.checkNotNull((Object)origin);
                this.placeSphere(blockPos, sphereRadius, voidLog, (Long2ObjectOpenHashMap<BlockState>)woodMap, trunkCandidates, obsidianSet, 0.03, random, origin);
            }
            trunkPos = nextPos;
            sphereRadius -= 1.0;
        }
        double baseAngle = random.nextDouble() * 2.0 * Math.PI;
        int motherHeightOffset = random.nextInt(2, 6);
        List motherPoints = new ArrayList();
        for (int i = 0; i < 3; ++i) {
            double angle = baseAngle + (double)i * 2.0943951023931953;
            int mX = trunkPos.getX() + MathKt.roundToInt((double)(12.0 * Math.cos(angle))) + random.nextInt(-2, 3);
            int mZ = trunkPos.getZ() + MathKt.roundToInt((double)(12.0 * Math.sin(angle))) + random.nextInt(-2, 3);
            int mY = trunkPos.getY() + motherHeightOffset + random.nextInt(1, 5);
            BlockPos motherPoint = new BlockPos(mX, mY, mZ);
            motherPoints.add(motherPoint);
            BlockPos p1x = trunkPos;
            Intrinsics.checkNotNull((Object)p1x);
            Intrinsics.checkNotNull((Object)random);
            Intrinsics.checkNotNull((Object)origin);
            this.generateMotherBranch(p1x, motherPoint, random, voidLog, (Long2ObjectOpenHashMap<BlockState>)woodMap, branchCandidates, obsidianSet, 0.03, origin);
        }
        for (BlockPos mother : motherPoints) {
            int numChildBranches = random.nextInt(4, 7);
            double backTowardsTrunkAngle = Math.atan2(mother.getZ() - trunkPos.getZ(), mother.getX() - trunkPos.getX()) + Math.PI;
            double childBaseAngle = random.nextDouble() * 2.0 * Math.PI;
            double childCircleRadius = random.nextDouble() * 4.0 + 6.0;
            double forbiddenWindow = 1.0471975511965976;
            for (int i = 0; i < numChildBranches; ++i) {
                double diff;
                double childAngle = childBaseAngle + (double)i * (Math.PI * 2 / (double)numChildBranches);
                for (diff = childAngle - backTowardsTrunkAngle; diff > Math.PI; diff -= Math.PI * 2) {
                }
                while (diff < -Math.PI) {
                    diff += Math.PI * 2;
                }
                if (Math.abs(diff) < forbiddenWindow) {
                    childAngle = diff > 0.0 ? backTowardsTrunkAngle + forbiddenWindow + 0.3 : backTowardsTrunkAngle - forbiddenWindow - 0.3;
                }
                BlockPos childPoint = new BlockPos(mother.getX() + MathKt.roundToInt((double)(childCircleRadius * Math.cos(childAngle))) + random.nextInt(-1, 2), mother.getY() + random.nextInt(-1, 4), mother.getZ() + MathKt.roundToInt((double)(childCircleRadius * Math.sin(childAngle))) + random.nextInt(-1, 2));
                Intrinsics.checkNotNull((Object)random);
                Intrinsics.checkNotNull((Object)origin);
                this.generateChildBranch(mother, childPoint, random, voidLog, (Long2ObjectOpenHashMap<BlockState>)woodMap, branchCandidates, obsidianSet, 0.03, origin);
            }
        }
        branchCandidates.removeAll((LongCollection)trunkCandidates);
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        ObjectIterator objectIterator = woodMap.long2ObjectEntrySet().iterator();
        Intrinsics.checkNotNullExpressionValue((Object)objectIterator, (String)"iterator(...)");
        ObjectIterator mother = objectIterator;
        while (mother.hasNext()) {
            Long2ObjectMap.Entry entry = (Long2ObjectMap.Entry)mother.next();
            mutablePos.set(entry.getLongKey());
            level.setBlock((BlockPos)mutablePos, (BlockState)entry.getValue(), 3);
        }
        BlockState obsidianState = TBSBlocks.OBSIDIAN.getDefaultState();
        LongIterator longIterator = obsidianSet.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)longIterator, (String)"iterator(...)");
        LongIterator entry = longIterator;
        while (entry.hasNext()) {
            Long posLong = entry.next();
            Intrinsics.checkNotNull((Object)posLong);
            mutablePos.set(posLong.longValue());
            level.setBlock((BlockPos)mutablePos, obsidianState, 3);
        }
        Long2ObjectOpenHashMap vineMap = new Long2ObjectOpenHashMap();
        Intrinsics.checkNotNull((Object)level);
        Intrinsics.checkNotNull((Object)random);
        int n = origin.getY();
        Intrinsics.checkNotNull((Object)origin);
        this.processVines(level, trunkCandidates, (Long2ObjectOpenHashMap<BlockState>)vineMap, voidVines, 0.16666666666666666, 3, 6, random, n, origin);
        this.processVines(level, branchCandidates, (Long2ObjectOpenHashMap<BlockState>)vineMap, voidVines, 0.4, 4, 14, random, origin.getY(), origin);
        Long2ObjectMap.FastEntrySet fastEntrySet = vineMap.long2ObjectEntrySet();
        Intrinsics.checkNotNullExpressionValue((Object)fastEntrySet, (String)"long2ObjectEntrySet(...)");
        Iterable $this$sortedByDescending$iv = (Iterable)fastEntrySet;
        boolean $i$f$sortedByDescending22 = false;
        for (Long2ObjectMap.Entry entry2 : CollectionsKt.sortedWith((Iterable)$this$sortedByDescending$iv, (Comparator)new Comparator(){

            public final int compare(T a, T b) {
                Long2ObjectMap.Entry it = (Long2ObjectMap.Entry)b;
                boolean bl = false;
                Comparable comparable = Integer.valueOf(BlockPos.getY((long)it.getLongKey()));
                it = (Long2ObjectMap.Entry)a;
                Comparable comparable2 = comparable;
                bl = false;
                return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)Integer.valueOf(BlockPos.getY((long)it.getLongKey())));
            }
        })) {
            mutablePos.set(entry2.getLongKey());
            level.setBlock((BlockPos)mutablePos, (BlockState)entry2.getValue(), 3);
        }
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        LongIterator longIterator2 = ((LongSet)woodMap.keySet()).iterator();
        Intrinsics.checkNotNullExpressionValue((Object)longIterator2, (String)"iterator(...)");
        LongIterator $i$f$sortedByDescending22 = longIterator2;
        while ($i$f$sortedByDescending22.hasNext()) {
            Long key = $i$f$sortedByDescending22.next();
            Intrinsics.checkNotNull((Object)key);
            int y = BlockPos.getY((long)key);
            if (y < minY) {
                minY = y;
            }
            if (y <= maxY) continue;
            maxY = y;
        }
        LongIterator longIterator3 = obsidianSet.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)longIterator3, (String)"iterator(...)");
        $i$f$sortedByDescending22 = longIterator3;
        while ($i$f$sortedByDescending22.hasNext()) {
            Long key = $i$f$sortedByDescending22.next();
            Intrinsics.checkNotNull((Object)key);
            int y = BlockPos.getY((long)key);
            if (y < minY) {
                minY = y;
            }
            if (y <= maxY) continue;
            maxY = y;
        }
        Object[] key = new BlockState[]{TBSBlocks.VOID_SPROUT.getDefaultState(), TBSBlocks.VOID_BUD.getDefaultState(), TBSBlocks.VOID_BUDDING.getDefaultState(), TBSBlocks.VOID_BLOOM.getDefaultState(), TBSBlocks.VOID_BLOSSOM.getDefaultState()};
        List floraBlocks = CollectionsKt.listOf((Object[])key);
        Pair[] y = new Pair[]{TuplesKt.to((Object)Direction.NORTH, (Object)BlockStateProperties.NORTH), TuplesKt.to((Object)Direction.SOUTH, (Object)BlockStateProperties.SOUTH), TuplesKt.to((Object)Direction.EAST, (Object)BlockStateProperties.EAST), TuplesKt.to((Object)Direction.WEST, (Object)BlockStateProperties.WEST), TuplesKt.to((Object)Direction.UP, (Object)BlockStateProperties.UP), TuplesKt.to((Object)Direction.DOWN, (Object)BlockStateProperties.DOWN)};
        Map boolProps = MapsKt.mapOf((Pair[])y);
        BlockPos.MutableBlockPos adjPos = new BlockPos.MutableBlockPos();
        Collection $this$toTypedArray$iv = (Collection)EntriesMappings.entries$0;
        boolean $i$f$toTypedArray = false;
        Collection thisCollection$iv = $this$toTypedArray$iv;
        Direction[] allDirs = thisCollection$iv.toArray(new Direction[0]);
        double it = maxY - minY;
        boolean bl = false;
        double yRange = it == 0.0 ? 1.0 : it;
        LongIterator longIterator4 = obsidianSet.iterator();
        Intrinsics.checkNotNullExpressionValue((Object)longIterator4, (String)"iterator(...)");
        LongIterator longIterator5 = longIterator4;
        while (longIterator5.hasNext()) {
            Long posLong = longIterator5.next();
            Intrinsics.checkNotNull((Object)posLong);
            mutablePos.set(posLong.longValue());
            int obsY = mutablePos.getY();
            if (obsY < origin.getY()) continue;
            double t = (double)(obsY - minY) / yRange;
            int p2z = 0;
            double[] dArray = new double[5];
            while (p2z < 5) {
                int n2 = p2z++;
                dArray[n2] = Math.max(0.0, 1.0 - Math.abs(t - (double)n2 / 4.0) * 4.0);
            }
            double[] weights = dArray;
            double totalWeight = ArraysKt.sum((double[])weights);
            for (Direction dir : allDirs) {
                BlockState finalFloraState;
                long adjLong;
                int adjX = mutablePos.getX() + dir.getStepX();
                int adjY = mutablePos.getY() + dir.getStepY();
                int adjZ = mutablePos.getZ() + dir.getStepZ();
                if (adjY < origin.getY() || woodMap.containsKey(adjLong = BlockPos.asLong((int)adjX, (int)adjY, (int)adjZ)) || obsidianSet.contains(adjLong) || vineMap.containsKey(adjLong)) continue;
                adjPos.set(adjX, adjY, adjZ);
                if (!this.isWithinGenRegion((BlockPos)adjPos, origin) || !level.isEmptyBlock((BlockPos)adjPos) || random.nextDouble() >= 0.4) continue;
                double roll = random.nextDouble() * totalWeight;
                BlockState chosenFlora = (BlockState)floraBlocks.get(4);
                for (int i = 0; i < 5; ++i) {
                    if (!((roll -= weights[i]) <= 0.0)) continue;
                    chosenFlora = (BlockState)floraBlocks.get(i);
                    break;
                }
                if ((finalFloraState = chosenFlora).hasProperty((Property)BlockStateProperties.FACING)) {
                    Object object = finalFloraState.setValue((Property)BlockStateProperties.FACING, (Comparable)dir);
                    Intrinsics.checkNotNullExpressionValue((Object)object, (String)"setValue(...)");
                    finalFloraState = (BlockState)object;
                } else {
                    Iterator iterator = boolProps.entrySet().iterator();
                    while (iterator.hasNext()) {
                        BooleanProperty prop = (BooleanProperty)iterator.next().getValue();
                        if (!finalFloraState.hasProperty((Property)prop)) continue;
                        Object object = finalFloraState.setValue((Property)prop, (Comparable)Boolean.valueOf(false));
                        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"setValue(...)");
                        finalFloraState = (BlockState)object;
                    }
                    BooleanProperty targetProp = (BooleanProperty)boolProps.get(dir);
                    if (targetProp != null && finalFloraState.hasProperty((Property)targetProp)) {
                        Object object = finalFloraState.setValue((Property)targetProp, (Comparable)Boolean.valueOf(true));
                        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"setValue(...)");
                        finalFloraState = (BlockState)object;
                    }
                }
                level.setBlock((BlockPos)adjPos, finalFloraState, 3);
            }
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean isWithinGenRegion(BlockPos pos, BlockPos origin) {
        int dx = pos.getX() - origin.getX();
        int dz = pos.getZ() - origin.getZ();
        if (-15 > dx) return false;
        if (dx >= 16) return false;
        boolean bl = true;
        if (!bl) return false;
        if (-15 > dz) return false;
        if (dz >= 16) return false;
        return true;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lnet/thebrokenscript/world/gen/features/VoidCystFeature$Companion;", "", "<init>", "()V", "MAX_HORIZONTAL_RADIUS", "", "thebrokenscript-common"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Direction> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Direction.values()));
        }
    }
}

