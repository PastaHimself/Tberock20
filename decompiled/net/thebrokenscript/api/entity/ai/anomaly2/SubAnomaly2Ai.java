/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.PrimitiveCodec
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  kotlin.ranges.IntRange
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.BlockPos$MutableBlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Direction$Axis
 *  net.minecraft.core.Vec3i
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.Entity$RemovalReason
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.behavior.BehaviorControl
 *  net.minecraft.world.entity.ai.memory.MemoryModuleType
 *  net.minecraft.world.entity.ai.navigation.GroundPathNavigation
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.entity.schedule.Activity
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.LightLayer
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.pathfinder.Node
 *  net.minecraft.world.level.pathfinder.Path
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.brain.dsl.ActivityBuilder
 *  net.thebrokenscript.brokencore.api.brain.dsl.BehaviorBuilder
 *  net.thebrokenscript.brokencore.api.brain.dsl.BrainBuilder
 *  net.thebrokenscript.brokencore.api.brain.dsl.BrainFunctionProvider
 *  net.thebrokenscript.brokencore.api.brain.dsl.MemoryRequireBuilder
 *  net.thebrokenscript.brokencore.api.brain.dsl.SensorBuilder
 *  net.thebrokenscript.brokencore.api.brain.util.BrainBehavior
 *  net.thebrokenscript.brokencore.api.brain.util.BuiltBrain
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt
 *  net.thebrokenscript.brokencore.api.ext.MiscExt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.ai.anomaly2;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.PrimitiveCodec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.behavior.BehaviorControl;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.entity.BaseFracturedEntity;
import net.thebrokenscript.brokencore.api.brain.dsl.ActivityBuilder;
import net.thebrokenscript.brokencore.api.brain.dsl.BehaviorBuilder;
import net.thebrokenscript.brokencore.api.brain.dsl.BrainBuilder;
import net.thebrokenscript.brokencore.api.brain.dsl.BrainFunctionProvider;
import net.thebrokenscript.brokencore.api.brain.dsl.MemoryRequireBuilder;
import net.thebrokenscript.brokencore.api.brain.dsl.SensorBuilder;
import net.thebrokenscript.brokencore.api.brain.util.BrainBehavior;
import net.thebrokenscript.brokencore.api.brain.util.BuiltBrain;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.ext.BaseMonsterExtKt;
import net.thebrokenscript.brokencore.api.ext.MiscExt;
import net.thebrokenscript.entity.anomaly.sa2.SubAnomaly2Entity;
import net.thebrokenscript.entity.anomaly.sa2.transforming.SubAnomaly2Type;
import net.thebrokenscript.entity.fractured.FracturedEntity;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J;\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\nH\u0082\u0010J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J(\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0002J7\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0002\u00a2\u0006\u0002\u0010\u001dJ(\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070*\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,\u00a8\u0006-"}, d2={"Lnet/thebrokenscript/api/entity/ai/anomaly2/SubAnomaly2Ai;", "", "<init>", "()V", "findLight", "Lnet/minecraft/core/BlockPos;", "sa2", "Lnet/thebrokenscript/entity/anomaly/sa2/SubAnomaly2Entity;", "lastPos", "lastLight", "", "lastDistance", "", "depth", "isPassable", "", "level", "Lnet/minecraft/world/level/LevelAccessor;", "pos", "Lnet/minecraft/core/BlockPos$MutableBlockPos;", "hasFlatFooting", "x", "y", "z", "findGroundYFor2x2", "baseX", "baseZ", "top", "bottom", "(Lnet/minecraft/world/level/LevelAccessor;IIII)Ljava/lang/Integer;", "canPathFromTo", "groundNav", "Lnet/minecraft/world/entity/ai/navigation/GroundPathNavigation;", "from", "target", "Lnet/minecraft/world/entity/LivingEntity;", "findValidLandingSpot", "checkSunlight", "", "getHidePos", "Lnet/minecraft/world/phys/Vec3;", "ai", "Lnet/thebrokenscript/brokencore/api/brain/util/BuiltBrain;", "getAi", "()Lnet/thebrokenscript/brokencore/api/brain/util/BuiltBrain;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nSubAnomaly2Ai.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SubAnomaly2Ai.kt\nnet/thebrokenscript/api/entity/ai/anomaly2/SubAnomaly2Ai\n+ 2 MiscExt.kt\nnet/thebrokenscript/brokencore/api/ext/MiscExt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,671:1\n348#2:672\n349#2,2:674\n1869#3:673\n1870#3:676\n1#4:677\n*S KotlinDebug\n*F\n+ 1 SubAnomaly2Ai.kt\nnet/thebrokenscript/api/entity/ai/anomaly2/SubAnomaly2Ai\n*L\n44#1:672\n44#1:674,2\n44#1:673\n44#1:676\n*E\n"})
public final class SubAnomaly2Ai {
    @NotNull
    public static final SubAnomaly2Ai INSTANCE = new SubAnomaly2Ai();
    @NotNull
    private static final BuiltBrain<SubAnomaly2Entity> ai = BrainBuilder.Companion.invoke(SubAnomaly2Ai::ai$lambda$0);

    private SubAnomaly2Ai() {
    }

    private final BlockPos findLight(SubAnomaly2Entity sa2, BlockPos lastPos, int lastLight, double lastDistance, int depth) {
        SubAnomaly2Ai subAnomaly2Ai = this;
        while (depth <= 15) {
            Level level = sa2.getLevel();
            if (level.getBlockState(lastPos).getLightEmission() > 5) {
                return lastPos;
            }
            List currentPositions = new ArrayList();
            int currentMaxLight = 0;
            currentMaxLight = lastLight;
            double currentDist = 0.0;
            currentDist = lastDistance;
            BlockPos $this$forEachEncasing$iv = lastPos;
            boolean $i$f$forEachEncasing = false;
            Iterable $this$forEach$iv$iv = MiscExt.getEncasingBlockOffsets((BlockPos)$this$forEachEncasing$iv);
            boolean $i$f$forEach = false;
            for (Object element$iv$iv : $this$forEach$iv$iv) {
                BlockPos it;
                BlockPos it$iv = (BlockPos)element$iv$iv;
                boolean bl = false;
                Intrinsics.checkNotNullExpressionValue((Object)$this$forEachEncasing$iv.offset((Vec3i)it$iv), (String)"offset(...)");
                boolean bl2 = false;
                if (level.getBlockState(it).getLightEmission() > 5) {
                    return it;
                }
                double dist = it.distSqr((Vec3i)sa2.blockPosition());
                if (Intrinsics.areEqual((Object)it, (Object)lastPos) || !(currentDist <= dist) || level.getBlockState(it).getLightEmission() <= 5 && !level.getBlockState(it).getCollisionShape((BlockGetter)level, it).isEmpty()) continue;
                int brightness = Math.max(level.getBrightness(LightLayer.BLOCK, lastPos), level.getBlockState(it).getLightEmission());
                if (sa2.getFearFactor() <= 12 && brightness > sa2.getFearFactor()) continue;
                if (brightness > currentMaxLight) {
                    currentPositions.clear();
                    currentMaxLight = brightness;
                }
                if (brightness < currentMaxLight) continue;
                currentDist = dist;
                currentPositions.add(it);
            }
            if (currentPositions.isEmpty()) {
                return null;
            }
            BlockPos next = (BlockPos)CollectionsKt.random((Collection)currentPositions, (Random)((Random)Random.Default));
            if (!level.getBlockState(next).getFluidState().isEmpty()) {
                return null;
            }
            if (level.getBlockState(next).getLightEmission() != 0) {
                return next;
            }
            SubAnomaly2Ai subAnomaly2Ai2 = subAnomaly2Ai;
            SubAnomaly2Entity subAnomaly2Entity = sa2;
            int n = currentMaxLight;
            double d = currentDist;
            int n2 = depth + 1;
            subAnomaly2Ai = subAnomaly2Ai2;
            sa2 = subAnomaly2Entity;
            lastPos = next;
            lastLight = n;
            lastDistance = d;
            depth = n2;
        }
        return null;
    }

    static /* synthetic */ BlockPos findLight$default(SubAnomaly2Ai subAnomaly2Ai, SubAnomaly2Entity subAnomaly2Entity, BlockPos blockPos, int n, double d, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            BlockPos blockPos2 = subAnomaly2Entity.blockPosition();
            Intrinsics.checkNotNullExpressionValue((Object)blockPos2, (String)"blockPosition(...)");
            blockPos = blockPos2;
        }
        if ((n3 & 4) != 0) {
            n = subAnomaly2Entity.getLevel().getBrightness(LightLayer.BLOCK, blockPos);
        }
        if ((n3 & 8) != 0) {
            d = 0.0;
        }
        if ((n3 & 0x10) != 0) {
            n2 = 0;
        }
        return subAnomaly2Ai.findLight(subAnomaly2Entity, blockPos, n, d, n2);
    }

    private final boolean isPassable(LevelAccessor level, BlockPos.MutableBlockPos pos) {
        return level.getBlockState((BlockPos)pos).getCollisionShape((BlockGetter)level, (BlockPos)pos).isEmpty();
    }

    private final boolean hasFlatFooting(LevelAccessor level, int x, int y, int z) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        pos.set(x, y - 1, z);
        BlockState floor = level.getBlockState((BlockPos)pos);
        if (!floor.isFaceSturdy((BlockGetter)level, (BlockPos)pos, Direction.UP)) {
            return false;
        }
        pos.set(x, y, z);
        if (!this.isPassable(level, pos)) {
            return false;
        }
        pos.set(x, y + 1, z);
        return this.isPassable(level, pos);
    }

    private final Integer findGroundYFor2x2(LevelAccessor level, int baseX, int baseZ, int top, int bottom) {
        int y = top;
        if (bottom <= y) {
            while (true) {
                boolean ok = true;
                for (int dx = 0; dx < 2; ++dx) {
                    for (int dz = 0; dz < 2; ++dz) {
                        if (this.hasFlatFooting(level, baseX + dx, y, baseZ + dz)) continue;
                        ok = false;
                    }
                }
                if (ok) {
                    return y;
                }
                if (y == bottom) break;
                --y;
            }
        }
        return null;
    }

    private final boolean canPathFromTo(SubAnomaly2Entity sa2, GroundPathNavigation groundNav, BlockPos from, LivingEntity target) {
        Path path;
        sa2.setPos((double)from.getX() + 0.5, from.getY(), (double)from.getZ() + 0.5);
        Path path2 = path = groundNav.createPath((Entity)target, 0);
        Node lastNode = path2 != null ? path2.getEndNode() : null;
        boolean reachable = path != null && lastNode != null && lastNode.x == target.getBlockX() && lastNode.z == target.getBlockZ() && Math.abs(lastNode.y - target.getBlockY()) <= 3;
        return reachable;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final BlockPos findValidLandingSpot(SubAnomaly2Entity sa2) {
        LivingEntity livingEntity = sa2.getTarget();
        if (livingEntity == null) {
            return null;
        }
        LivingEntity target = livingEntity;
        Level level = sa2.level();
        RandomSource random = sa2.getRandom();
        BlockPos targetPos = target.blockPosition();
        Vec3 originalPos = sa2.position();
        GroundPathNavigation groundNav = new GroundPathNavigation((Mob)sa2, level);
        try {
            int n = 10;
            for (int i = 0; i < n; ++i) {
                int dz;
                int it = i;
                boolean bl = false;
                int dx = random.nextIntBetweenInclusive(-6, 6);
                if (dx * dx + (dz = random.nextIntBetweenInclusive(-6, 6)) * dz < 4) continue;
                int baseX = targetPos.getX() + dx;
                int baseZ = targetPos.getZ() + dz;
                Intrinsics.checkNotNull((Object)level);
                Integer n2 = INSTANCE.findGroundYFor2x2((LevelAccessor)level, baseX, baseZ, targetPos.getY() + 4, targetPos.getY() - 8);
                if (n2 == null) {
                    continue;
                }
                int groundY = n2;
                BlockPos landingPos = new BlockPos(baseX, groundY, baseZ);
                double distSqr = ((double)baseX - sa2.getX()) * ((double)baseX - sa2.getX()) + ((double)baseZ - sa2.getZ()) * ((double)baseZ - sa2.getZ());
                if (distSqr > 400.0 || !INSTANCE.canPathFromTo(sa2, groundNav, landingPos, target)) continue;
                BlockPos blockPos = landingPos;
                return blockPos;
            }
        }
        finally {
            sa2.setPos(originalPos.x, originalPos.y, originalPos.z);
        }
        return null;
    }

    private final void checkSunlight(SubAnomaly2Entity sa2) {
        boolean b;
        boolean bl = b = sa2.getLevel().isDay() && !sa2.getLevel().isRaining() && !sa2.getLevel().isThundering() && !Intrinsics.areEqual((Object)sa2.getLevel().dimension(), TBSDimensions.CORRUPTED_MOON);
        if (b && sa2.getLevel().canSeeSky(sa2.blockPosition())) {
            sa2.remove(Entity.RemovalReason.DISCARDED);
        }
    }

    private final Vec3 getHidePos(SubAnomaly2Entity sa2) {
        RandomSource randomSrc = sa2.getRandom();
        BlockPos currentPos = sa2.blockPosition();
        BlockPos.MutableBlockPos candidatePos = new BlockPos.MutableBlockPos();
        int n = 10;
        int n2 = 0;
        while (n2 < n) {
            int it = n2++;
            boolean bl = false;
            candidatePos.set(currentPos.getX() + randomSrc.nextIntBetweenInclusive(-16, 16), currentPos.getY() + randomSrc.nextIntBetweenInclusive(-4, 4), currentPos.getZ() + randomSrc.nextIntBetweenInclusive(-16, 16));
            int candidateLight = sa2.level().getMaxLocalRawBrightness((BlockPos)candidatePos);
            if (candidateLight > sa2.getFearFactor()) continue;
            return Vec3.atBottomCenterOf((Vec3i)((Vec3i)candidatePos));
        }
        return null;
    }

    @NotNull
    public final BuiltBrain<SubAnomaly2Entity> getAi() {
        return ai;
    }

    private static final Unit ai$lambda$0(BrainBuilder $this$BrainBuilder) {
        Intrinsics.checkNotNullParameter((Object)$this$BrainBuilder, (String)"$this$BrainBuilder");
        PrimitiveCodec primitiveCodec = Codec.BOOL;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec, (String)"BOOL");
        MemoryModuleType isPlayerNear = $this$BrainBuilder.of((Codec)primitiveCodec, TBSConstants.id("sub_anom_2_player_nearby"));
        PrimitiveCodec primitiveCodec2 = Codec.BOOL;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec2, (String)"BOOL");
        MemoryModuleType isPlayerVisible = $this$BrainBuilder.of((Codec)primitiveCodec2, TBSConstants.id("sub_anom_2_player_visible"));
        PrimitiveCodec primitiveCodec3 = Codec.BOOL;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec3, (String)"BOOL");
        MemoryModuleType isTransforming = $this$BrainBuilder.of((Codec)primitiveCodec3, TBSConstants.id("sub_anom_2_transforming"));
        PrimitiveCodec primitiveCodec4 = Codec.BOOL;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec4, (String)"BOOL");
        MemoryModuleType isInLight = $this$BrainBuilder.of((Codec)primitiveCodec4, TBSConstants.id("sub_anom_2_is_in_light"));
        PrimitiveCodec primitiveCodec5 = Codec.BOOL;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec5, (String)"BOOL");
        MemoryModuleType isInHitRange = $this$BrainBuilder.of((Codec)primitiveCodec5, TBSConstants.id("sub_anom_2_is_in_hit_range"));
        PrimitiveCodec primitiveCodec6 = Codec.BOOL;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec6, (String)"BOOL");
        MemoryModuleType tooFarAway = $this$BrainBuilder.of((Codec)primitiveCodec6, TBSConstants.id("sub_anom_2_too_far_away"));
        PrimitiveCodec primitiveCodec7 = Codec.BOOL;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec7, (String)"BOOL");
        MemoryModuleType canWalkToPlayer = $this$BrainBuilder.of((Codec)primitiveCodec7, TBSConstants.id("sub_anom_2_cant_reach"));
        PrimitiveCodec primitiveCodec8 = Codec.INT;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec8, (String)"INT");
        MemoryModuleType chargeTicks = $this$BrainBuilder.of((Codec)primitiveCodec8, TBSConstants.id("sub_anom_2_divebomb_charge"));
        PrimitiveCodec primitiveCodec9 = Codec.BOOL;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec9, (String)"BOOL");
        MemoryModuleType divebombed = $this$BrainBuilder.of((Codec)primitiveCodec9, TBSConstants.id("sub_anom_2_divebombed"));
        PrimitiveCodec primitiveCodec10 = Codec.LONG;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec10, (String)"LONG");
        MemoryModuleType lastSeenPlayerPos = $this$BrainBuilder.of((Codec)primitiveCodec10, TBSConstants.id("sub_anom_2_last_seen_pos"));
        PrimitiveCodec primitiveCodec11 = Codec.LONG;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec11, (String)"LONG");
        MemoryModuleType runFromLightPos = $this$BrainBuilder.of((Codec)primitiveCodec11, TBSConstants.id("sub_anom_2_run_from_light_pos"));
        PrimitiveCodec primitiveCodec12 = Codec.INT;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec12, (String)"INT");
        MemoryModuleType playerDistanceTimer = $this$BrainBuilder.of((Codec)primitiveCodec12, TBSConstants.id("sub_anom_2_distance_timer"));
        PrimitiveCodec primitiveCodec13 = Codec.INT;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec13, (String)"INT");
        MemoryModuleType breakLightTimer = $this$BrainBuilder.of((Codec)primitiveCodec13, TBSConstants.id("sub_anom_2_break_light_timer"));
        PrimitiveCodec primitiveCodec14 = Codec.INT;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec14, (String)"INT");
        MemoryModuleType postBreakLightTimer = $this$BrainBuilder.of((Codec)primitiveCodec14, TBSConstants.id("sub_anom_2_post_break_light_timer"));
        PrimitiveCodec primitiveCodec15 = Codec.INT;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec15, (String)"INT");
        MemoryModuleType reachAttempts = $this$BrainBuilder.of((Codec)primitiveCodec15, TBSConstants.id("sub_anom_2_reach_try_counter"));
        PrimitiveCodec primitiveCodec16 = Codec.INT;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec16, (String)"INT");
        MemoryModuleType runFromLightTimer = $this$BrainBuilder.of((Codec)primitiveCodec16, TBSConstants.id("sub_anom_2_run_from_light_timer"));
        Codec codec2 = BlockPos.CODEC;
        Intrinsics.checkNotNullExpressionValue((Object)codec2, (String)"CODEC");
        MemoryModuleType nearestLight = $this$BrainBuilder.of(codec2, TBSConstants.id("sub_anom_2_light_pos"));
        Codec codec3 = BlockPos.CODEC;
        Intrinsics.checkNotNullExpressionValue((Object)codec3, (String)"CODEC");
        MemoryModuleType stalkLandingPos = $this$BrainBuilder.of(codec3, TBSConstants.id("sub_anom_2_stalk_landing_pos"));
        PrimitiveCodec primitiveCodec17 = Codec.LONG;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec17, (String)"LONG");
        MemoryModuleType stalkLandingTargetPos = $this$BrainBuilder.of((Codec)primitiveCodec17, TBSConstants.id("sub_anom_2_stalk_landing_target_pos"));
        PrimitiveCodec primitiveCodec18 = Codec.LONG;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec18, (String)"LONG");
        MemoryModuleType stalkLastRecompute = $this$BrainBuilder.of((Codec)primitiveCodec18, TBSConstants.id("sub_anom_2_stalk_last_recompute"));
        PrimitiveCodec primitiveCodec19 = Codec.BOOL;
        Intrinsics.checkNotNullExpressionValue((Object)primitiveCodec19, (String)"BOOL");
        MemoryModuleType stalkIsFlying = $this$BrainBuilder.of((Codec)primitiveCodec19, TBSConstants.id("sub_anom_2_stalk_is_flying"));
        BrainBehavior transform = $this$BrainBuilder.behavior(1, arg_0 -> SubAnomaly2Ai.ai$lambda$0$0(reachAttempts, canWalkToPlayer, isTransforming, arg_0));
        BrainBehavior attackBehavior = $this$BrainBuilder.behavior(1, SubAnomaly2Ai::ai$lambda$0$1);
        BrainBehavior lightBehavior = $this$BrainBuilder.behavior(new IntRange(10, 20), arg_0 -> SubAnomaly2Ai.ai$lambda$0$2(isInLight, runFromLightTimer, runFromLightPos, arg_0));
        BrainBehavior destroyLightBehavior = $this$BrainBuilder.behavior(40, arg_0 -> SubAnomaly2Ai.ai$lambda$0$3(breakLightTimer, nearestLight, postBreakLightTimer, arg_0));
        BrainBehavior spiderChaseTarget = $this$BrainBuilder.behavior(1, arg_0 -> SubAnomaly2Ai.ai$lambda$0$4(reachAttempts, canWalkToPlayer, arg_0));
        BrainBehavior stalkChaseTarget = $this$BrainBuilder.behavior(new IntRange(20, 40), arg_0 -> SubAnomaly2Ai.ai$lambda$0$5(stalkLandingPos, stalkLandingTargetPos, stalkIsFlying, stalkLastRecompute, arg_0));
        BrainBehavior flyToJimmy = $this$BrainBuilder.behavior(1000, SubAnomaly2Ai::ai$lambda$0$6);
        BrainBehavior divebomb = $this$BrainBuilder.behavior(200, arg_0 -> SubAnomaly2Ai.ai$lambda$0$7(divebombed, chargeTicks, arg_0));
        Activity someActivity = $this$BrainBuilder.activity(TBSConstants.id("sub_anom_2_activity"), arg_0 -> SubAnomaly2Ai.ai$lambda$0$8(flyToJimmy, transform, attackBehavior, lightBehavior, spiderChaseTarget, stalkChaseTarget, destroyLightBehavior, divebomb, arg_0));
        $this$BrainBuilder.setDefaultActivity(someActivity);
        $this$BrainBuilder.sensor(TBSConstants.id("sub_anom_2_player_tracker"), arg_0 -> SubAnomaly2Ai.ai$lambda$0$9(lastSeenPlayerPos, isPlayerVisible, isTransforming, playerDistanceTimer, isPlayerNear, canWalkToPlayer, stalkIsFlying, arg_0));
        $this$BrainBuilder.sensor(TBSConstants.id("sub_anom_2_target_setter"), arg_0 -> SubAnomaly2Ai.ai$lambda$0$10(runFromLightTimer, arg_0));
        $this$BrainBuilder.sensor(TBSConstants.id("sub_anom_2_light_sensor"), arg_0 -> SubAnomaly2Ai.ai$lambda$0$11(runFromLightPos, isInLight, runFromLightTimer, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$0(MemoryModuleType $reachAttempts, MemoryModuleType $canWalkToPlayer, MemoryModuleType $isTransforming, BehaviorBuilder $this$behavior) {
        Intrinsics.checkNotNullParameter((Object)$this$behavior, (String)"$this$behavior");
        $this$behavior.start((arg_0, arg_1, arg_2, arg_3) -> SubAnomaly2Ai.ai$lambda$0$0$0($reachAttempts, $canWalkToPlayer, $isTransforming, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.require(SubAnomaly2Ai::ai$lambda$0$0$1);
        $this$behavior.extraStartConditions((arg_0, arg_1, arg_2) -> SubAnomaly2Ai.ai$lambda$0$0$2($isTransforming, arg_0, arg_1, arg_2));
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$0$0(MemoryModuleType $reachAttempts, MemoryModuleType $canWalkToPlayer, MemoryModuleType $isTransforming, BrainFunctionProvider $this$start, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$start, (String)"$this$start");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        INSTANCE.checkSunlight(owner);
        if (owner.getTransState() == SubAnomaly2Type.STALK) {
            owner.setTransState(SubAnomaly2Type.STALK_TO_SPIDER);
            owner.setTransTimer(10);
            owner.swapMovementAfterTransform(SubAnomaly2Type.STALK_TO_SPIDER);
            $this$start.set($reachAttempts, (Object)0);
        } else if (owner.getTransState() == SubAnomaly2Type.SPIDER || !$this$start.get($canWalkToPlayer)) {
            owner.setTransState(SubAnomaly2Type.SPIDER_TO_STALK);
            owner.setTransTimer(15);
            owner.swapMovementAfterTransform(SubAnomaly2Type.SPIDER_TO_STALK);
        } else if (owner.getTransState() == SubAnomaly2Type.MIMIC) {
            owner.setTransState(SubAnomaly2Type.MIMIC_TO_SPIDER);
            owner.setTransTimer(12);
        }
        $this$start.set($isTransforming, (Object)false);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$0$1(MemoryRequireBuilder $this$require) {
        Intrinsics.checkNotNullParameter((Object)$this$require, (String)"$this$require");
        return Unit.INSTANCE;
    }

    private static final boolean ai$lambda$0$0$2(MemoryModuleType $isTransforming, BrainFunctionProvider $this$extraStartConditions, ServerLevel level, SubAnomaly2Entity owner) {
        Intrinsics.checkNotNullParameter((Object)$this$extraStartConditions, (String)"$this$extraStartConditions");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        return $this$extraStartConditions.get($isTransforming);
    }

    private static final Unit ai$lambda$0$1(BehaviorBuilder $this$behavior) {
        Intrinsics.checkNotNullParameter((Object)$this$behavior, (String)"$this$behavior");
        $this$behavior.start(SubAnomaly2Ai::ai$lambda$0$1$0);
        $this$behavior.tick(SubAnomaly2Ai::ai$lambda$0$1$1);
        $this$behavior.require(SubAnomaly2Ai::ai$lambda$0$1$2);
        $this$behavior.extraStartConditions(SubAnomaly2Ai::ai$lambda$0$1$3);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$1$0(BrainFunctionProvider $this$start, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$start, (String)"$this$start");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        INSTANCE.checkSunlight(owner);
        LivingEntity livingEntity = owner.getTarget();
        if (livingEntity != null) {
            LivingEntity it = livingEntity;
            boolean bl = false;
            owner.getNavigation().moveTo((Entity)it, 1.2);
        }
        if (owner.getTransState() == SubAnomaly2Type.DIVEBOMB) {
            owner.setTransState(SubAnomaly2Type.DIVEBOMB_TO_STALK);
        }
        if (owner.getTransState() == SubAnomaly2Type.STALK) {
            owner.setTransState(SubAnomaly2Type.STALK_TO_SPIDER);
        }
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$1$1(BrainFunctionProvider $this$tick, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$tick, (String)"$this$tick");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        owner.setAggressive(true);
        LivingEntity livingEntity = owner.getTarget();
        if (livingEntity == null) {
            return Unit.INSTANCE;
        }
        LivingEntity target = livingEntity;
        if (owner.distanceToSqr((Entity)target) < 2.0) {
            target.hurt(owner.damageSources().generic(), 2.0f);
        }
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$1$2(MemoryRequireBuilder $this$require) {
        Intrinsics.checkNotNullParameter((Object)$this$require, (String)"$this$require");
        return Unit.INSTANCE;
    }

    private static final boolean ai$lambda$0$1$3(BrainFunctionProvider $this$extraStartConditions, ServerLevel level, SubAnomaly2Entity owner) {
        Intrinsics.checkNotNullParameter((Object)$this$extraStartConditions, (String)"$this$extraStartConditions");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        owner.getHasTarget();
        LivingEntity livingEntity = owner.getTarget();
        if (livingEntity == null) {
            return false;
        }
        LivingEntity target = livingEntity;
        return owner.distanceToSqr((Entity)target) < (double)3.2f;
    }

    private static final Unit ai$lambda$0$2(MemoryModuleType $isInLight, MemoryModuleType $runFromLightTimer, MemoryModuleType $runFromLightPos, BehaviorBuilder $this$behavior) {
        Intrinsics.checkNotNullParameter((Object)$this$behavior, (String)"$this$behavior");
        $this$behavior.start((arg_0, arg_1, arg_2, arg_3) -> SubAnomaly2Ai.ai$lambda$0$2$0($isInLight, $runFromLightTimer, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.canStillUse((arg_0, arg_1, arg_2, arg_3) -> SubAnomaly2Ai.ai$lambda$0$2$1($runFromLightTimer, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.stop((arg_0, arg_1, arg_2, arg_3) -> SubAnomaly2Ai.ai$lambda$0$2$2($runFromLightPos, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.require(SubAnomaly2Ai::ai$lambda$0$2$3);
        $this$behavior.extraStartConditions((arg_0, arg_1, arg_2) -> SubAnomaly2Ai.ai$lambda$0$2$4($isInLight, arg_0, arg_1, arg_2));
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$2$0(MemoryModuleType $isInLight, MemoryModuleType $runFromLightTimer, BrainFunctionProvider $this$start, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$start, (String)"$this$start");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        INSTANCE.checkSunlight(owner);
        Vec3 vec3 = INSTANCE.getHidePos(owner);
        if (vec3 == null) {
            return Unit.INSTANCE;
        }
        Vec3 hidePos = vec3;
        if ($this$start.get($isInLight) && level.getMaxLocalRawBrightness(owner.getBlockPos()) < owner.getFearFactor()) {
            $this$start.set($isInLight, (Object)false);
        }
        $this$start.dec($runFromLightTimer, 1);
        owner.getNavigation().moveTo(hidePos.x, hidePos.y, hidePos.z, 1.2);
        return Unit.INSTANCE;
    }

    private static final boolean ai$lambda$0$2$1(MemoryModuleType $runFromLightTimer, BrainFunctionProvider $this$canStillUse, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$canStillUse, (String)"$this$canStillUse");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        return $this$canStillUse.get($runFromLightTimer) > 0;
    }

    private static final Unit ai$lambda$0$2$2(MemoryModuleType $runFromLightPos, BrainFunctionProvider $this$stop, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$stop, (String)"$this$stop");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        owner.getNavigation().stop();
        $this$stop.set($runFromLightPos, null);
        int n = owner.getFearFactor();
        owner.setFearFactor(n + 1);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$2$3(MemoryRequireBuilder $this$require) {
        Intrinsics.checkNotNullParameter((Object)$this$require, (String)"$this$require");
        return Unit.INSTANCE;
    }

    private static final boolean ai$lambda$0$2$4(MemoryModuleType $isInLight, BrainFunctionProvider $this$extraStartConditions, ServerLevel level, SubAnomaly2Entity owner) {
        Intrinsics.checkNotNullParameter((Object)$this$extraStartConditions, (String)"$this$extraStartConditions");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        $this$extraStartConditions.get($isInLight);
        return owner.getFearFactor() <= 12;
    }

    private static final Unit ai$lambda$0$3(MemoryModuleType $breakLightTimer, MemoryModuleType $nearestLight, MemoryModuleType $postBreakLightTimer, BehaviorBuilder $this$behavior) {
        Intrinsics.checkNotNullParameter((Object)$this$behavior, (String)"$this$behavior");
        $this$behavior.start((arg_0, arg_1, arg_2, arg_3) -> SubAnomaly2Ai.ai$lambda$0$3$0($breakLightTimer, $nearestLight, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.tick((arg_0, arg_1, arg_2, arg_3) -> SubAnomaly2Ai.ai$lambda$0$3$1($nearestLight, $breakLightTimer, $postBreakLightTimer, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.canStillUse((arg_0, arg_1, arg_2, arg_3) -> SubAnomaly2Ai.ai$lambda$0$3$2($breakLightTimer, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.extraStartConditions(SubAnomaly2Ai::ai$lambda$0$3$3);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$3$0(MemoryModuleType $breakLightTimer, MemoryModuleType $nearestLight, BrainFunctionProvider $this$start, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        block6: {
            Path path;
            BlockPos lightPosition;
            block5: {
                Intrinsics.checkNotNullParameter((Object)$this$start, (String)"$this$start");
                Intrinsics.checkNotNullParameter((Object)level, (String)"level");
                Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
                if ($this$start.get($breakLightTimer) > 0) {
                    return Unit.INSTANCE;
                }
                INSTANCE.checkSunlight(owner);
                owner.setTransState(SubAnomaly2Type.SPIDER);
                BlockPos blockPos = SubAnomaly2Ai.findLight$default(INSTANCE, owner, null, 0, 0.0, 0, 30, null);
                if (blockPos == null) {
                    return Unit.INSTANCE;
                }
                lightPosition = blockPos;
                Path path2 = path = owner.getNavigation().createPath(lightPosition, 0);
                Node end = path2 != null ? path2.getEndNode() : null;
                Path path3 = path;
                if (path3 != null ? path3.canReach() : false) break block5;
                Node node = end;
                float f = node != null ? node.distanceManhattan(lightPosition) : 100.0f;
                if (!(f < 4.0f)) break block6;
            }
            $this$start.set($nearestLight, (Object)lightPosition);
            owner.getNavigation().moveTo(path, 1.0);
        }
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$3$1(MemoryModuleType $nearestLight, MemoryModuleType $breakLightTimer, MemoryModuleType $postBreakLightTimer, BrainFunctionProvider $this$tick, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$tick, (String)"$this$tick");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        BlockPos blockPos = (BlockPos)$this$tick.get($nearestLight);
        if (blockPos == null) {
            return Unit.INSTANCE;
        }
        BlockPos pos = blockPos;
        if (owner.getNavigation().isDone() && $this$tick.get($breakLightTimer) < -4) {
            BlockState state = level.getBlockState(pos);
            if (state.getLightEmission() >= 5 && !state.is(Blocks.LAVA)) {
                $this$tick.set($breakLightTimer, (Object)20);
                owner.setTransState(SubAnomaly2Type.BREAK_LIGHT);
            }
        } else if ($this$tick.get($breakLightTimer) == 2) {
            level.destroyBlock(pos, true, (Entity)owner);
            owner.setTransState(SubAnomaly2Type.SPIDER);
            $this$tick.set($postBreakLightTimer, (Object)4);
        }
        return Unit.INSTANCE;
    }

    private static final boolean ai$lambda$0$3$2(MemoryModuleType $breakLightTimer, BrainFunctionProvider $this$canStillUse, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$canStillUse, (String)"$this$canStillUse");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        BrainFunctionProvider.dec$default((BrainFunctionProvider)$this$canStillUse, (MemoryModuleType)$breakLightTimer, (int)0, (int)1, null);
        return true;
    }

    private static final boolean ai$lambda$0$3$3(BrainFunctionProvider $this$extraStartConditions, ServerLevel level, SubAnomaly2Entity owner) {
        Intrinsics.checkNotNullParameter((Object)$this$extraStartConditions, (String)"$this$extraStartConditions");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        return !owner.getNavigation().isInProgress() && level.getBrightness(LightLayer.BLOCK, owner.blockPosition()) > 0;
    }

    private static final Unit ai$lambda$0$4(MemoryModuleType $reachAttempts, MemoryModuleType $canWalkToPlayer, BehaviorBuilder $this$behavior) {
        Intrinsics.checkNotNullParameter((Object)$this$behavior, (String)"$this$behavior");
        double stopDistSqr = 4.5;
        $this$behavior.start((arg_0, arg_1, arg_2, arg_3) -> SubAnomaly2Ai.ai$lambda$0$4$0(stopDistSqr, $reachAttempts, $canWalkToPlayer, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.tick((arg_0, arg_1, arg_2, arg_3) -> SubAnomaly2Ai.ai$lambda$0$4$1(stopDistSqr, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.extraStartConditions(SubAnomaly2Ai::ai$lambda$0$4$2);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$4$0(double $stopDistSqr, MemoryModuleType $reachAttempts, MemoryModuleType $canWalkToPlayer, BrainFunctionProvider $this$start, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        boolean reachable;
        Path path;
        Intrinsics.checkNotNullParameter((Object)$this$start, (String)"$this$start");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        INSTANCE.checkSunlight(owner);
        if (owner.getTransState() == SubAnomaly2Type.STALK) {
            return Unit.INSTANCE;
        }
        LivingEntity livingEntity = owner.getTarget();
        if (livingEntity == null) {
            return Unit.INSTANCE;
        }
        LivingEntity target = livingEntity;
        if (owner.distanceToSqr((Entity)target) <= $stopDistSqr) {
            owner.getNavigation().stop();
            return Unit.INSTANCE;
        }
        if (gameTime - owner.getLastPathAttempt() < 5L) {
            return Unit.INSTANCE;
        }
        owner.setLastPathAttempt(gameTime);
        Path path2 = path = owner.getNavigation().createPath((Entity)target, 0);
        Node lastNode = path2 != null ? path2.getEndNode() : null;
        boolean bl = reachable = path != null && lastNode != null && lastNode.x == target.getBlockX() && lastNode.z == target.getBlockZ() && Math.abs(lastNode.y - target.getBlockY()) <= 3;
        if (reachable) {
            $this$start.set($reachAttempts, (Object)0);
            owner.getNavigation().moveTo(path, 1.0);
            $this$start.set($canWalkToPlayer, (Object)true);
        } else if ($this$start.get($reachAttempts) <= 8) {
            $this$start.inc($reachAttempts, 1);
        } else {
            $this$start.set($canWalkToPlayer, (Object)false);
        }
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$4$1(double $stopDistSqr, BrainFunctionProvider $this$tick, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$tick, (String)"$this$tick");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        LivingEntity livingEntity = owner.getTarget();
        if (livingEntity == null) {
            return Unit.INSTANCE;
        }
        LivingEntity target = livingEntity;
        if (!owner.getNavigation().isDone() && owner.distanceToSqr((Entity)target) <= $stopDistSqr) {
            owner.getNavigation().stop();
        }
        return Unit.INSTANCE;
    }

    private static final boolean ai$lambda$0$4$2(BrainFunctionProvider $this$extraStartConditions, ServerLevel level, SubAnomaly2Entity owner) {
        Intrinsics.checkNotNullParameter((Object)$this$extraStartConditions, (String)"$this$extraStartConditions");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        owner.getTarget();
        return owner.getTransState() != SubAnomaly2Type.STALK;
    }

    private static final Unit ai$lambda$0$5(MemoryModuleType $stalkLandingPos, MemoryModuleType $stalkLandingTargetPos, MemoryModuleType $stalkIsFlying, MemoryModuleType $stalkLastRecompute, BehaviorBuilder $this$behavior) {
        Intrinsics.checkNotNullParameter((Object)$this$behavior, (String)"$this$behavior");
        long recomputeCooldown = 10L;
        double driftThresholdSqr = 16.0;
        double arriveDistSqr = 2.25;
        $this$behavior.start(SubAnomaly2Ai::ai$lambda$0$5$0);
        $this$behavior.tick((arg_0, arg_1, arg_2, arg_3) -> SubAnomaly2Ai.ai$lambda$0$5$1($stalkLandingPos, $stalkLandingTargetPos, driftThresholdSqr, arriveDistSqr, $stalkIsFlying, $stalkLastRecompute, recomputeCooldown, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.stop((arg_0, arg_1, arg_2, arg_3) -> SubAnomaly2Ai.ai$lambda$0$5$2($stalkIsFlying, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.require(SubAnomaly2Ai::ai$lambda$0$5$3);
        $this$behavior.extraStartConditions(SubAnomaly2Ai::ai$lambda$0$5$4);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$5$0(BrainFunctionProvider $this$start, ServerLevel serverLevel, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$start, (String)"$this$start");
        Intrinsics.checkNotNullParameter((Object)serverLevel, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        INSTANCE.checkSunlight(owner);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$5$1(MemoryModuleType $stalkLandingPos, MemoryModuleType $stalkLandingTargetPos, double $driftThresholdSqr, double $arriveDistSqr, MemoryModuleType $stalkIsFlying, MemoryModuleType $stalkLastRecompute, long $recomputeCooldown, BrainFunctionProvider $this$tick, ServerLevel serverLevel, SubAnomaly2Entity owner, long gameTime) {
        boolean needsRecompute;
        boolean playerDrifted;
        Intrinsics.checkNotNullParameter((Object)$this$tick, (String)"$this$tick");
        Intrinsics.checkNotNullParameter((Object)serverLevel, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        LivingEntity livingEntity = owner.getTarget();
        if (livingEntity == null) {
            return Unit.INSTANCE;
        }
        LivingEntity target = livingEntity;
        BlockPos targetPos = target.blockPosition();
        BlockPos storedLandingPos = (BlockPos)$this$tick.get($stalkLandingPos);
        long it = $this$tick.get($stalkLandingTargetPos);
        boolean bl = false;
        BlockPos lastTargetPos = BlockPos.of((long)it);
        boolean bl2 = playerDrifted = lastTargetPos == null || targetPos.distSqr((Vec3i)lastTargetPos) > $driftThresholdSqr;
        if (storedLandingPos != null && !playerDrifted && owner.position().distanceToSqr(Vec3.atCenterOf((Vec3i)((Vec3i)storedLandingPos))) < $arriveDistSqr) {
            $this$tick.set($stalkIsFlying, (Object)false);
            return Unit.INSTANCE;
        }
        boolean bl3 = needsRecompute = storedLandingPos == null || playerDrifted || owner.getNavigation().isDone();
        if (needsRecompute && gameTime - $this$tick.get($stalkLastRecompute) >= $recomputeCooldown) {
            BlockPos blockPos = INSTANCE.findValidLandingSpot(owner);
            if (blockPos == null) {
                blockPos = targetPos;
            }
            BlockPos landingPos = blockPos;
            $this$tick.set($stalkLandingPos, (Object)landingPos);
            $this$tick.set($stalkLandingTargetPos, (Object)targetPos.asLong());
            $this$tick.set($stalkLastRecompute, (Object)gameTime);
            owner.getNavigation().moveTo((double)landingPos.getX() + 0.5, (double)landingPos.getY(), (double)landingPos.getZ() + 0.5, 1.0);
        }
        $this$tick.set($stalkIsFlying, (Object)true);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$5$2(MemoryModuleType $stalkIsFlying, BrainFunctionProvider $this$stop, ServerLevel serverLevel, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$stop, (String)"$this$stop");
        Intrinsics.checkNotNullParameter((Object)serverLevel, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        owner.getNavigation().stop();
        $this$stop.set($stalkIsFlying, (Object)false);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$5$3(MemoryRequireBuilder $this$require) {
        Intrinsics.checkNotNullParameter((Object)$this$require, (String)"$this$require");
        return Unit.INSTANCE;
    }

    private static final boolean ai$lambda$0$5$4(BrainFunctionProvider $this$extraStartConditions, ServerLevel level, SubAnomaly2Entity owner) {
        Intrinsics.checkNotNullParameter((Object)$this$extraStartConditions, (String)"$this$extraStartConditions");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        if (owner.getTransState() != SubAnomaly2Type.STALK) {
            return false;
        }
        LivingEntity livingEntity = owner.getTarget();
        if (livingEntity == null) {
            return false;
        }
        LivingEntity target = livingEntity;
        BlockPos pos = target.blockPosition().offset(0, -1, 0);
        for (Direction dir : EntriesMappings.entries$0) {
            int i;
            if (dir.getAxis() == Direction.Axis.Y) continue;
            Intrinsics.checkNotNull((Object)pos);
            BlockPos pos2 = MiscExt.offset$default((BlockPos)pos, (Direction)dir, (int)0, (int)2, null);
            for (i = 0; level.getBlockState(pos2.offset(0, -i, 0)).isAir() && i < 5; ++i) {
            }
            if (i != 5) continue;
            return false;
        }
        owner.getTransState();
        owner.getTarget();
        return owner.getHasTarget();
    }

    private static final Unit ai$lambda$0$6(BehaviorBuilder $this$behavior) {
        Intrinsics.checkNotNullParameter((Object)$this$behavior, (String)"$this$behavior");
        $this$behavior.start(SubAnomaly2Ai::ai$lambda$0$6$0);
        $this$behavior.tick(SubAnomaly2Ai::ai$lambda$0$6$1);
        $this$behavior.canStillUse(SubAnomaly2Ai::ai$lambda$0$6$2);
        $this$behavior.extraStartConditions(SubAnomaly2Ai::ai$lambda$0$6$3);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$6$0(BrainFunctionProvider $this$start, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$start, (String)"$this$start");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        if (owner.getFracturedInstance().isPresent()) {
            Entity entity = level.getEntity(owner.getFracturedInstance().get());
            FracturedEntity fracturedEntity = entity instanceof FracturedEntity ? (FracturedEntity)entity : null;
            if (fracturedEntity == null) {
                return Unit.INSTANCE;
            }
            FracturedEntity jimmy = fracturedEntity;
            if (owner.getTransState() != SubAnomaly2Type.STALK && owner.getTransState() != SubAnomaly2Type.SPIDER_TO_STALK) {
                owner.setTransState(SubAnomaly2Type.SPIDER_TO_STALK);
                owner.setTransTimer(15);
                owner.swapMovementAfterTransform(SubAnomaly2Type.SPIDER_TO_STALK);
            }
            owner.getNavigation().moveTo((Entity)jimmy, 1.5);
        }
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$6$1(BrainFunctionProvider $this$tick, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$tick, (String)"$this$tick");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        if (owner.getFracturedInstance().isPresent()) {
            Entity entity;
            if (owner.getTransState() != SubAnomaly2Type.STALK && owner.getTransState() != SubAnomaly2Type.SPIDER_TO_STALK) {
                owner.setTransState(SubAnomaly2Type.SPIDER_TO_STALK);
                owner.setTransTimer(15);
                owner.swapMovementAfterTransform(SubAnomaly2Type.SPIDER_TO_STALK);
            }
            FracturedEntity fracturedEntity = (entity = level.getEntity(owner.getFracturedInstance().get())) instanceof FracturedEntity ? (FracturedEntity)entity : null;
            if (fracturedEntity == null) {
                return Unit.INSTANCE;
            }
            FracturedEntity jimmy = fracturedEntity;
            owner.setTarget((LivingEntity)jimmy);
            if (owner.distanceToSqr((Entity)jimmy.getChest()) < 256.0) {
                owner.doHurtTarget((Entity)jimmy);
            } else if (owner.getNavigation().isDone()) {
                owner.getNavigation().moveTo((Entity)jimmy.getChest(), 1.5);
            }
        }
        return Unit.INSTANCE;
    }

    private static final boolean ai$lambda$0$6$2(BrainFunctionProvider $this$canStillUse, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$canStillUse, (String)"$this$canStillUse");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        FracturedEntity fracturedEntity = owner.getFracturedInstance().map(arg_0 -> SubAnomaly2Ai.ai$lambda$0$6$2$1(arg_0 -> SubAnomaly2Ai.ai$lambda$0$6$2$0(level, arg_0), arg_0)).orElse(null);
        if (fracturedEntity == null) {
            return false;
        }
        FracturedEntity jimmy = fracturedEntity;
        return jimmy.isOnFire() || jimmy.isCurrentlyGlowing() || jimmy.getCurrentState() == BaseFracturedEntity.JimmyStates.DEFEATED;
    }

    private static final FracturedEntity ai$lambda$0$6$2$0(ServerLevel $level, UUID it) {
        Entity entity = $level.getEntity(it);
        return entity instanceof FracturedEntity ? (FracturedEntity)entity : null;
    }

    private static final FracturedEntity ai$lambda$0$6$2$1(Function1 $tmp0, Object p0) {
        return (FracturedEntity)((Object)$tmp0.invoke(p0));
    }

    private static final boolean ai$lambda$0$6$3(BrainFunctionProvider $this$extraStartConditions, ServerLevel level, SubAnomaly2Entity owner) {
        boolean bl;
        Intrinsics.checkNotNullParameter((Object)$this$extraStartConditions, (String)"$this$extraStartConditions");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        if (owner.getFracturedInstance().isPresent()) {
            Entity entity = level.getEntity(owner.getFracturedInstance().get());
            FracturedEntity fracturedEntity = entity instanceof FracturedEntity ? (FracturedEntity)entity : null;
            if (fracturedEntity == null) {
                return false;
            }
            FracturedEntity jimmy = fracturedEntity;
            bl = jimmy.isOnFire() || jimmy.isCurrentlyGlowing() || jimmy.getCurrentState() == BaseFracturedEntity.JimmyStates.DEFEATED;
        } else {
            bl = false;
        }
        return bl;
    }

    private static final Unit ai$lambda$0$7(MemoryModuleType $divebombed, MemoryModuleType $chargeTicks, BehaviorBuilder $this$behavior) {
        Intrinsics.checkNotNullParameter((Object)$this$behavior, (String)"$this$behavior");
        $this$behavior.start((arg_0, arg_1, arg_2, arg_3) -> SubAnomaly2Ai.ai$lambda$0$7$0($divebombed, $chargeTicks, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.tick((arg_0, arg_1, arg_2, arg_3) -> SubAnomaly2Ai.ai$lambda$0$7$1($chargeTicks, $divebombed, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.canStillUse((arg_0, arg_1, arg_2, arg_3) -> SubAnomaly2Ai.ai$lambda$0$7$2($divebombed, arg_0, arg_1, arg_2, arg_3));
        $this$behavior.extraStartConditions(SubAnomaly2Ai::ai$lambda$0$7$3);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$7$0(MemoryModuleType $divebombed, MemoryModuleType $chargeTicks, BrainFunctionProvider $this$start, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$start, (String)"$this$start");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        INSTANCE.checkSunlight(owner);
        if (owner.getTransState() != SubAnomaly2Type.DIVEBOMB) {
            owner.setTransState(SubAnomaly2Type.STALK_TO_DIVEBOMB);
            owner.swapMovementAfterTransform(SubAnomaly2Type.STALK_TO_DIVEBOMB);
        }
        $this$start.set($divebombed, (Object)false);
        LivingEntity livingEntity = owner.getTarget();
        if (livingEntity == null) {
            return Unit.INSTANCE;
        }
        LivingEntity target = livingEntity;
        double angle = Math.random() * Math.PI * 2.0 - Math.PI;
        double range = 5.0;
        Vec3 ofs = new Vec3(Math.cos(angle), 0.0, Math.sin(angle)).multiply(range, 1.0, range).add(0.0, 5.0, 0.0);
        Vec3 pos = target.position().add(ofs);
        owner.getNavigation().moveTo(pos.x, pos.y, pos.z, 2, 1.0);
        $this$start.set($chargeTicks, (Object)10);
        owner.setAggressive(true);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$7$1(MemoryModuleType $chargeTicks, MemoryModuleType $divebombed, BrainFunctionProvider $this$tick, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$tick, (String)"$this$tick");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        owner.setAggressive(true);
        LivingEntity livingEntity = owner.getTarget();
        if (livingEntity == null) {
            return Unit.INSTANCE;
        }
        LivingEntity target = livingEntity;
        if (owner.getNavigation().isDone() && $this$tick.get($chargeTicks) == 1) {
            Vec3 vel;
            Vec3 vec3 = vel = owner.position().subtract(target.position().add(0.0, 0.75, 0.0)).normalize().multiply(-1.0, -1.0, -1.0);
            Intrinsics.checkNotNull((Object)vec3);
            vel = PositionUtil.withY((Vec3)vec3, (Number)Math.min(vel.y, 0.0));
            owner.setDeltaMovement(vel);
            $this$tick.set($chargeTicks, (Object)0);
            owner.setAggressive(false);
            owner.setNoGravity(false);
        }
        if (owner.getNavigation().isDone()) {
            owner.lookAt((Entity)target, 360.0f, 180.0f);
        }
        if (owner.getBoundingBox().move(owner.getPos()).intersects(target.getBoundingBox().move(target.position()))) {
            owner.doHurtTarget((Entity)target);
            $this$tick.set($divebombed, (Object)true);
            owner.setTransState(SubAnomaly2Type.DIVEBOMB_TO_STALK);
            Vec3 vec3 = owner.getDeltaMovement();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getDeltaMovement(...)");
            owner.setDeltaMovement(PositionUtil.withY((Vec3)vec3, (Number)0.0));
        }
        if (owner.getNavigation().isDone() && owner.distanceToSqr((Entity)target) < 100.0 && target.getY() < owner.getY() && $this$tick.get($chargeTicks) > 0) {
            BrainFunctionProvider.dec$default((BrainFunctionProvider)$this$tick, (MemoryModuleType)$chargeTicks, (int)0, (int)1, null);
        }
        return Unit.INSTANCE;
    }

    private static final boolean ai$lambda$0$7$2(MemoryModuleType $divebombed, BrainFunctionProvider $this$canStillUse, ServerLevel level, SubAnomaly2Entity owner, long gameTime) {
        Intrinsics.checkNotNullParameter((Object)$this$canStillUse, (String)"$this$canStillUse");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        return !$this$canStillUse.get($divebombed);
    }

    private static final boolean ai$lambda$0$7$3(BrainFunctionProvider $this$extraStartConditions, ServerLevel level, SubAnomaly2Entity owner) {
        Intrinsics.checkNotNullParameter((Object)$this$extraStartConditions, (String)"$this$extraStartConditions");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        if (owner.getTransState() != SubAnomaly2Type.STALK) {
            return false;
        }
        LivingEntity livingEntity = owner.getTarget();
        if (livingEntity == null) {
            return false;
        }
        LivingEntity target = livingEntity;
        BlockPos pos = target.blockPosition().offset(0, -1, 0);
        for (Direction dir : EntriesMappings.entries$0) {
            int i;
            if (dir.getAxis() == Direction.Axis.Y) continue;
            Intrinsics.checkNotNull((Object)pos);
            BlockPos pos2 = MiscExt.offset$default((BlockPos)pos, (Direction)dir, (int)0, (int)2, null);
            for (i = 0; level.getBlockState(pos2.offset(0, -i, 0)).isAir() && i < 5; ++i) {
            }
            if (i != 5) continue;
            return true;
        }
        return false;
    }

    private static final Unit ai$lambda$0$8(BrainBehavior $flyToJimmy, BrainBehavior $transform, BrainBehavior $attackBehavior, BrainBehavior $lightBehavior, BrainBehavior $spiderChaseTarget, BrainBehavior $stalkChaseTarget, BrainBehavior $destroyLightBehavior, BrainBehavior $divebomb, ActivityBuilder $this$activity) {
        Intrinsics.checkNotNullParameter((Object)$this$activity, (String)"$this$activity");
        ActivityBuilder.first$default((ActivityBuilder)$this$activity, (int)0, arg_0 -> SubAnomaly2Ai.ai$lambda$0$8$0($flyToJimmy, $transform, $attackBehavior, $lightBehavior, $spiderChaseTarget, $stalkChaseTarget, $destroyLightBehavior, $divebomb, arg_0), (int)1, null);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$8$0(BrainBehavior $flyToJimmy, BrainBehavior $transform, BrainBehavior $attackBehavior, BrainBehavior $lightBehavior, BrainBehavior $spiderChaseTarget, BrainBehavior $stalkChaseTarget, BrainBehavior $destroyLightBehavior, BrainBehavior $divebomb, ActivityBuilder $this$first) {
        Intrinsics.checkNotNullParameter((Object)$this$first, (String)"$this$first");
        $this$first.single((BehaviorControl)$flyToJimmy, 0);
        $this$first.single((BehaviorControl)$transform, 1);
        $this$first.single((BehaviorControl)$attackBehavior, 2);
        $this$first.random(3, arg_0 -> SubAnomaly2Ai.ai$lambda$0$8$0$0($lightBehavior, $spiderChaseTarget, $stalkChaseTarget, $destroyLightBehavior, $divebomb, arg_0));
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$8$0$0(BrainBehavior $lightBehavior, BrainBehavior $spiderChaseTarget, BrainBehavior $stalkChaseTarget, BrainBehavior $destroyLightBehavior, BrainBehavior $divebomb, ActivityBuilder $this$random) {
        Intrinsics.checkNotNullParameter((Object)$this$random, (String)"$this$random");
        ActivityBuilder.single$default((ActivityBuilder)$this$random, (BehaviorControl)((BehaviorControl)$lightBehavior), (int)0, (int)2, null);
        ActivityBuilder.single$default((ActivityBuilder)$this$random, (BehaviorControl)((BehaviorControl)$spiderChaseTarget), (int)0, (int)2, null);
        ActivityBuilder.single$default((ActivityBuilder)$this$random, (BehaviorControl)((BehaviorControl)$stalkChaseTarget), (int)0, (int)2, null);
        ActivityBuilder.single$default((ActivityBuilder)$this$random, (BehaviorControl)((BehaviorControl)$destroyLightBehavior), (int)0, (int)2, null);
        ActivityBuilder.single$default((ActivityBuilder)$this$random, (BehaviorControl)((BehaviorControl)$divebomb), (int)0, (int)2, null);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$9(MemoryModuleType $lastSeenPlayerPos, MemoryModuleType $isPlayerVisible, MemoryModuleType $isTransforming, MemoryModuleType $playerDistanceTimer, MemoryModuleType $isPlayerNear, MemoryModuleType $canWalkToPlayer, MemoryModuleType $stalkIsFlying, SensorBuilder $this$sensor) {
        Intrinsics.checkNotNullParameter((Object)$this$sensor, (String)"$this$sensor");
        $this$sensor.setScanTime(1);
        $this$sensor.tick((arg_0, arg_1, arg_2) -> SubAnomaly2Ai.ai$lambda$0$9$0($lastSeenPlayerPos, $isPlayerVisible, $canWalkToPlayer, $isTransforming, $playerDistanceTimer, $isPlayerNear, $stalkIsFlying, arg_0, arg_1, arg_2));
        MemoryModuleType[] memoryModuleTypeArray = new MemoryModuleType[]{$lastSeenPlayerPos, $isPlayerVisible, $isTransforming, $playerDistanceTimer, $isPlayerNear};
        $this$sensor.requirements(memoryModuleTypeArray);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$9$0(MemoryModuleType $lastSeenPlayerPos, MemoryModuleType $isPlayerVisible, MemoryModuleType $canWalkToPlayer, MemoryModuleType $isTransforming, MemoryModuleType $playerDistanceTimer, MemoryModuleType $isPlayerNear, MemoryModuleType $stalkIsFlying, BrainFunctionProvider $this$tick, ServerLevel level, SubAnomaly2Entity owner) {
        Intrinsics.checkNotNullParameter((Object)$this$tick, (String)"$this$tick");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        if (!owner.getHasTarget()) {
            return Unit.INSTANCE;
        }
        LivingEntity livingEntity = owner.getTarget();
        Player player = livingEntity instanceof Player ? (Player)livingEntity : null;
        if (player == null) {
            return Unit.INSTANCE;
        }
        Player target = player;
        if (BaseMonsterExtKt.isPlayerInFovCone((BaseMonster)((BaseMonster)owner), (Player)target, (double)60.0) && BaseMonsterExtKt.hasLineOfSightThroughTransparent((BaseMonster)((BaseMonster)owner), (Player)target)) {
            $this$tick.set($lastSeenPlayerPos, (Object)target.blockPosition().asLong());
            $this$tick.set($isPlayerVisible, (Object)true);
        } else {
            $this$tick.set($isPlayerVisible, (Object)false);
        }
        if (!$this$tick.get($canWalkToPlayer) && owner.getTransState() == SubAnomaly2Type.SPIDER) {
            $this$tick.set($isTransforming, (Object)true);
            $this$tick.set($playerDistanceTimer, (Object)5);
        } else if ($this$tick.get($playerDistanceTimer) <= 0 && owner.tickCount > 60) {
            $this$tick.set($isTransforming, (Object)true);
            $this$tick.set($playerDistanceTimer, (Object)5);
        } else if (owner.isPlayerNear((Level)level) && owner.getTransState() == SubAnomaly2Type.SPIDER && $this$tick.get($canWalkToPlayer)) {
            $this$tick.set($isPlayerNear, (Object)true);
            $this$tick.set($playerDistanceTimer, (Object)5);
        } else if (!owner.isPlayerNear((Level)level) && owner.getTransState() == SubAnomaly2Type.STALK) {
            $this$tick.set($isPlayerNear, (Object)false);
            $this$tick.set($playerDistanceTimer, (Object)5);
        } else if (owner.isPlayerNear((Level)level) && owner.getTransState() == SubAnomaly2Type.STALK) {
            $this$tick.set($isPlayerNear, (Object)true);
            if (!$this$tick.get($stalkIsFlying)) {
                $this$tick.dec($playerDistanceTimer, 1);
            } else {
                $this$tick.set($playerDistanceTimer, (Object)5);
            }
        } else if (!owner.isPlayerNear((Level)level) && owner.getTransState() == SubAnomaly2Type.SPIDER) {
            $this$tick.set($isPlayerNear, (Object)false);
            $this$tick.dec($playerDistanceTimer, 1);
        }
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$10(MemoryModuleType $runFromLightTimer, SensorBuilder $this$sensor) {
        Intrinsics.checkNotNullParameter((Object)$this$sensor, (String)"$this$sensor");
        $this$sensor.setScanTime(1);
        $this$sensor.tick((arg_0, arg_1, arg_2) -> SubAnomaly2Ai.ai$lambda$0$10$0($runFromLightTimer, arg_0, arg_1, arg_2));
        MemoryModuleType[] memoryModuleTypeArray = new MemoryModuleType[]{$runFromLightTimer};
        $this$sensor.requirements(memoryModuleTypeArray);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$10$0(MemoryModuleType $runFromLightTimer, BrainFunctionProvider $this$tick, ServerLevel level, SubAnomaly2Entity owner) {
        Intrinsics.checkNotNullParameter((Object)$this$tick, (String)"$this$tick");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        if ($this$tick.get($runFromLightTimer) > 0) {
            $this$tick.set($runFromLightTimer, (Object)($this$tick.get($runFromLightTimer) - 1));
            return Unit.INSTANCE;
        }
        LivingEntity target = owner.getTarget();
        if (target == null) {
            Player nearest;
            owner.setHasTarget(false);
            Player player = nearest = level.getNearestPlayer((Entity)owner, 36.0);
            if (player == null) {
                return Unit.INSTANCE;
            }
            owner.setTarget((LivingEntity)player);
            owner.setHasTarget(true);
        }
        if (target != null) {
            owner.setHasTarget(true);
        }
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$11(MemoryModuleType $runFromLightPos, MemoryModuleType $isInLight, MemoryModuleType $runFromLightTimer, SensorBuilder $this$sensor) {
        Intrinsics.checkNotNullParameter((Object)$this$sensor, (String)"$this$sensor");
        $this$sensor.setScanTime(1);
        $this$sensor.tick((arg_0, arg_1, arg_2) -> SubAnomaly2Ai.ai$lambda$0$11$0($isInLight, $runFromLightTimer, arg_0, arg_1, arg_2));
        MemoryModuleType[] memoryModuleTypeArray = new MemoryModuleType[]{$runFromLightPos, $isInLight};
        $this$sensor.requirements(memoryModuleTypeArray);
        return Unit.INSTANCE;
    }

    private static final Unit ai$lambda$0$11$0(MemoryModuleType $isInLight, MemoryModuleType $runFromLightTimer, BrainFunctionProvider $this$tick, ServerLevel level, SubAnomaly2Entity owner) {
        Intrinsics.checkNotNullParameter((Object)$this$tick, (String)"$this$tick");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)((Object)owner), (String)"owner");
        int currentLightLvl = level.getBrightness(LightLayer.BLOCK, owner.getBlockPos());
        if (currentLightLvl < owner.getFearFactor() || owner.getFearFactor() >= 13) {
            $this$tick.set($isInLight, (Object)false);
            return Unit.INSTANCE;
        }
        owner.setTarget(null);
        owner.setHasTarget(false);
        $this$tick.set($isInLight, (Object)true);
        if ($this$tick.get($runFromLightTimer) <= 0) {
            $this$tick.set($runFromLightTimer, (Object)5);
        }
        return Unit.INSTANCE;
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Direction> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Direction.values()));
        }
    }
}

