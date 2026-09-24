/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.RangesKt
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.util.Mth
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.LivingEntity
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.ai.goal.Goal
 *  net.minecraft.world.entity.ai.goal.Goal$Flag
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.DoorBlock
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.AABB
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  net.thebrokenscript.brokencore.api.platform.PlatformUtil
 *  net.thebrokenscript.brokencore.api.util.serde.WrappedBlockPosList
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.brokencore.api.platform.PlatformUtil;
import net.thebrokenscript.brokencore.api.util.serde.WrappedBlockPosList;
import net.thebrokenscript.entity.nullent.NullMazeEntity;
import net.thebrokenscript.network.debug.MazePayload;
import net.thebrokenscript.registry.TBSDimensions;
import net.thebrokenscript.registry.TBSPackets;
import net.thebrokenscript.util.MazePathFinderKt;
import net.thebrokenscript.util.MazePathfinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0005J\u001a\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0007H\u0002J\u0018\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u0005H\u0002J\b\u0010(\u001a\u00020\tH\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J\b\u0010*\u001a\u00020\u001bH\u0002J\u0016\u0010+\u001a\u00020\u001b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0002J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\u0006\u0010-\u001a\u00020\u0005H\u0002J\b\u0010.\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2={"Lnet/thebrokenscript/util/MazeNavigationGoal;", "Lnet/minecraft/world/entity/ai/goal/Goal;", "mob", "Lnet/minecraft/world/entity/Mob;", "targetPos", "Lnet/minecraft/core/BlockPos;", "speedModifier", "", "allowDiagonal", "", "recalculateInterval", "", "<init>", "(Lnet/minecraft/world/entity/Mob;Lnet/minecraft/core/BlockPos;DZI)V", "value", "getTargetPos", "()Lnet/minecraft/core/BlockPos;", "path", "", "currentPathIndex", "ticksSinceLastRecalculation", "ticksSinceLastProgress", "active", "pathfinder", "Lnet/thebrokenscript/util/MazePathfinder;", "canUse", "start", "", "tick", "updateTarget", "newTarget", "canGoDirect", "target", "Lnet/minecraft/world/entity/LivingEntity;", "maxYDelta", "hasContinuousGround", "from", "to", "openDoorIfAhead", "waypoint", "canContinueToUse", "stop", "calculatePath", "sendPathDebug", "findNearbyWalkablePositions", "center", "isStuck", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nMazePathFinder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MazePathFinder.kt\nnet/thebrokenscript/util/MazeNavigationGoal\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,562:1\n1056#2:563\n*S KotlinDebug\n*F\n+ 1 MazePathFinder.kt\nnet/thebrokenscript/util/MazeNavigationGoal\n*L\n460#1:563\n*E\n"})
public final class MazeNavigationGoal
extends Goal {
    @NotNull
    private final Mob mob;
    private final double speedModifier;
    private final int recalculateInterval;
    @NotNull
    private BlockPos targetPos;
    @Nullable
    private List<? extends BlockPos> path;
    private int currentPathIndex;
    private int ticksSinceLastRecalculation;
    private int ticksSinceLastProgress;
    private boolean active;
    @NotNull
    private final MazePathfinder pathfinder;

    public MazeNavigationGoal(@NotNull Mob mob, @NotNull BlockPos targetPos, double speedModifier, boolean allowDiagonal, int recalculateInterval) {
        MazePathfinder mazePathfinder;
        Intrinsics.checkNotNullParameter((Object)mob, (String)"mob");
        Intrinsics.checkNotNullParameter((Object)targetPos, (String)"targetPos");
        this.mob = mob;
        this.speedModifier = speedModifier;
        this.recalculateInterval = recalculateInterval;
        this.targetPos = targetPos;
        this.active = true;
        this.setFlags(EnumSet.of((Enum)Goal.Flag.MOVE));
        if (this.mob instanceof NullMazeEntity) {
            Level level = this.mob.level();
            Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
            Level level2 = level;
            mazePathfinder = new MazePathfinder(level2, allowDiagonal, 1250, true);
        } else {
            Level level = this.mob.level();
            Intrinsics.checkNotNullExpressionValue((Object)level, (String)"level(...)");
            Level level3 = level;
            mazePathfinder = new MazePathfinder(level3, allowDiagonal, 1250, true);
        }
        this.pathfinder = mazePathfinder;
    }

    public /* synthetic */ MazeNavigationGoal(Mob mob, BlockPos blockPos, double d, boolean bl, int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            d = 1.0;
        }
        if ((n2 & 8) != 0) {
            bl = false;
        }
        if ((n2 & 0x10) != 0) {
            n = 20;
        }
        this(mob, blockPos, d, bl, n);
    }

    @NotNull
    public final BlockPos getTargetPos() {
        return this.targetPos;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean canUse() {
        if (this.mob.level().isClientSide) return false;
        BlockPos blockPos = this.mob.blockPosition();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"blockPosition(...)");
        if (!(MazePathFinderKt.distanceTo(blockPos, this.targetPos) > 2.0)) return false;
        return true;
    }

    public void start() {
        this.calculatePath();
        this.ticksSinceLastProgress = 0;
    }

    public void tick() {
        block13: {
            double arrivalThresholdSq;
            boolean stuckCheck;
            int n = this.ticksSinceLastRecalculation;
            this.ticksSinceLastRecalculation = n + 1;
            n = this.ticksSinceLastProgress;
            this.ticksSinceLastProgress = n + 1;
            LivingEntity livingEntity = this.mob.getTarget();
            if (livingEntity == null) {
                return;
            }
            LivingEntity target = livingEntity;
            AABB entityBox = this.mob.getBoundingBox().inflate(2.0, 0.0, 2.0).inflate(0.0, -this.mob.position().y, 0.0);
            boolean playerInside = target.getBoundingBox().intersects(entityBox);
            boolean playerInWater = target.isInWater();
            boolean bl = stuckCheck = this.mob instanceof NullMazeEntity ? ((NullMazeEntity)this.mob).isStuck() : this.isStuck();
            if (!(this.ticksSinceLastRecalculation < this.recalculateInterval && this.ticksSinceLastProgress <= 40 && !stuckCheck || playerInside && playerInWater)) {
                this.calculatePath();
                this.ticksSinceLastRecalculation = 0;
            }
            if (MazeNavigationGoal.canGoDirect$default(this, target, 0.0, 2, null) && this.mob.getBoundingBox().inflate(1.5, 2.0, 1.5).intersects(target.getBoundingBox())) {
                this.path = null;
                this.sendPathDebug(CollectionsKt.emptyList());
                this.mob.getMoveControl().setWantedPosition(target.getX(), this.mob.getY(), target.getZ(), this.speedModifier + 0.4);
                this.mob.getLookControl().setLookAt((Entity)target);
                this.ticksSinceLastProgress = 0;
                return;
            }
            List<? extends BlockPos> list = this.path;
            if (list == null) break block13;
            List<? extends BlockPos> currentPath = list;
            boolean bl2 = false;
            if (this.currentPathIndex >= currentPath.size()) {
                return;
            }
            BlockPos targetWaypoint = currentPath.get(this.currentPathIndex);
            Vec3 targetVec = Vec3.atCenterOf((Vec3i)((Vec3i)targetWaypoint));
            boolean isDoor = this.mob.level().getBlockState(targetWaypoint).is(BlockTags.DOORS);
            double d = arrivalThresholdSq = isDoor ? 0.65 : 1.0;
            if (this.mob.position().distanceToSqr(targetVec) <= arrivalThresholdSq) {
                int n2 = this.currentPathIndex;
                this.currentPathIndex = n2 + 1;
                this.ticksSinceLastProgress = 0;
                if (this.currentPathIndex >= currentPath.size()) {
                    return;
                }
                targetWaypoint = currentPath.get(this.currentPathIndex);
                targetVec = Vec3.atCenterOf((Vec3i)((Vec3i)targetWaypoint));
            }
            if (this.mob instanceof NullMazeEntity) {
                this.openDoorIfAhead(targetWaypoint);
            }
            if (this.mob instanceof NullMazeEntity) {
                ((NullMazeEntity)this.mob).getMoveControl().setWantedPosition(targetVec.x, targetVec.y, targetVec.z, this.speedModifier + 0.35);
            } else if (Intrinsics.areEqual((Object)this.mob.level().dimension(), TBSDimensions.STAGE2)) {
                if (this.mob.level().canSeeSky(this.mob.blockPosition())) {
                    this.mob.getMoveControl().setWantedPosition(targetVec.x, targetVec.y, targetVec.z, this.speedModifier + 0.35);
                } else {
                    this.mob.getMoveControl().setWantedPosition(targetVec.x, targetVec.y, targetVec.z, this.speedModifier + 0.3);
                }
            } else {
                this.mob.getMoveControl().setWantedPosition(targetVec.x, targetVec.y, targetVec.z, this.speedModifier + 0.35);
            }
            this.mob.getLookControl().setLookAt(targetVec.x, targetVec.y, targetVec.z);
        }
    }

    public final void updateTarget(@NotNull BlockPos newTarget) {
        Intrinsics.checkNotNullParameter((Object)newTarget, (String)"newTarget");
        if (Intrinsics.areEqual((Object)newTarget, (Object)this.targetPos)) {
            return;
        }
        this.targetPos = newTarget;
        this.calculatePath();
    }

    private final boolean canGoDirect(LivingEntity target, double maxYDelta) {
        if (!this.mob.hasLineOfSight((Entity)target)) {
            return false;
        }
        if ((double)target.fallDistance > 1.25) {
            return false;
        }
        double yDelta = Math.abs(this.mob.getY() - target.getY());
        if (yDelta > maxYDelta) {
            return false;
        }
        BlockPos blockPos = this.mob.blockPosition();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"blockPosition(...)");
        BlockPos blockPos2 = target.blockPosition();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos2, (String)"blockPosition(...)");
        return this.hasContinuousGround(blockPos, blockPos2);
    }

    static /* synthetic */ boolean canGoDirect$default(MazeNavigationGoal mazeNavigationGoal, LivingEntity livingEntity, double d, int n, Object object) {
        if ((n & 2) != 0) {
            d = 0.85;
        }
        return mazeNavigationGoal.canGoDirect(livingEntity, d);
    }

    private final boolean hasContinuousGround(BlockPos from, BlockPos to) {
        Vec3 start = Vec3.atCenterOf((Vec3i)((Vec3i)from));
        Vec3 end = Vec3.atCenterOf((Vec3i)((Vec3i)to));
        double dx = to.getX() - from.getX();
        double dz = to.getZ() - from.getZ();
        double horizontalDist = Math.sqrt(dx * dx + dz * dz);
        int samples = RangesKt.coerceAtLeast((int)((int)(horizontalDist * (double)2)), (int)4);
        for (int i = 1; i < samples; ++i) {
            double t = (double)i / (double)samples;
            Vec3 point = start.lerp(end, t);
            double sampleY = Mth.lerp((double)t, (double)from.getY(), (double)to.getY());
            BlockPos samplePos = BlockPos.containing((double)point.x, (double)sampleY, (double)point.z);
            Intrinsics.checkNotNull((Object)samplePos);
            if (this.pathfinder.isGroundSolid(samplePos)) continue;
            return false;
        }
        return true;
    }

    private final void openDoorIfAhead(BlockPos waypoint) {
        BlockState state = this.mob.level().getBlockState(waypoint);
        if (state.is(BlockTags.DOORS) && state.getBlock() instanceof DoorBlock) {
            Block block = state.getBlock();
            Intrinsics.checkNotNull((Object)block, (String)"null cannot be cast to non-null type net.minecraft.world.level.block.DoorBlock");
            DoorBlock door = (DoorBlock)block;
            if (!door.isOpen(state)) {
                door.setOpen((Entity)this.mob, this.mob.level(), state, waypoint, true);
                this.mob.swing(InteractionHand.MAIN_HAND);
            }
        }
    }

    public boolean canContinueToUse() {
        return !this.mob.level().isClientSide && this.active;
    }

    public void stop() {
        this.active = false;
        this.path = null;
        this.currentPathIndex = 0;
        this.ticksSinceLastRecalculation = 0;
        this.ticksSinceLastProgress = 0;
        this.mob.getNavigation().stop();
    }

    private final void calculatePath() {
        BlockPos startPos = this.mob.blockPosition();
        Intrinsics.checkNotNull((Object)startPos);
        List<BlockPos> list = this.pathfinder.findPath(startPos, this.targetPos);
        if (list == null) {
            List<BlockPos> list2;
            block3: {
                MazeNavigationGoal $this$calculatePath_u24lambda_u240 = this;
                boolean bl = false;
                for (BlockPos it : (Iterable)$this$calculatePath_u24lambda_u240.findNearbyWalkablePositions($this$calculatePath_u24lambda_u240.targetPos)) {
                    boolean bl2 = false;
                    List<BlockPos> list3 = $this$calculatePath_u24lambda_u240.pathfinder.findPath(startPos, it);
                    if (list3 == null) continue;
                    list2 = list3;
                    break block3;
                }
                list2 = null;
            }
            list = list2;
            if (list2 == null) {
                MazeNavigationGoal $this$calculatePath_u24lambda_u241 = this;
                boolean bl = false;
                $this$calculatePath_u24lambda_u241.sendPathDebug(CollectionsKt.emptyList());
                return;
            }
        }
        List<BlockPos> newPath = list;
        this.path = newPath;
        this.currentPathIndex = RangesKt.coerceAtMost((int)SequencesKt.count((Sequence)SequencesKt.takeWhile((Sequence)CollectionsKt.asSequence((Iterable)newPath), arg_0 -> MazeNavigationGoal.calculatePath$lambda$2(startPos, arg_0))), (int)CollectionsKt.getLastIndex(newPath));
        this.sendPathDebug(newPath);
    }

    private final void sendPathDebug(List<? extends BlockPos> path) {
        Level level = this.mob.level();
        if (!(level instanceof ServerLevel)) {
            return;
        }
        if (!PlatformUtil.Companion.isProduction()) {
            PacketSender.INSTANCE.sendToAllPlayers((CustomPacketPayload)TBSPackets.DEBUG_PATHFINDER_PACKET.of(new MazePayload(this.mob.getId(), new WrappedBlockPosList(CollectionsKt.toMutableSet((Iterable)path)))), new CustomPacketPayload[0]);
        }
    }

    private final List<BlockPos> findNearbyWalkablePositions(BlockPos center) {
        List positions = new ArrayList();
        for (int x = -2; x < 3; ++x) {
            for (int z = -2; z < 3; ++z) {
                for (int y = -1; y < 2; ++y) {
                    BlockPos pos = center.offset(x, y, z);
                    if (Intrinsics.areEqual((Object)pos, (Object)center)) continue;
                    Intrinsics.checkNotNull((Object)pos);
                    positions.add(pos);
                }
            }
        }
        Iterable $this$sortedBy$iv = positions;
        boolean $i$f$sortedBy = false;
        return CollectionsKt.sortedWith((Iterable)$this$sortedBy$iv, (Comparator)new Comparator(center){
            final /* synthetic */ BlockPos $center$inlined;
            {
                this.$center$inlined = blockPos;
            }

            public final int compare(T a, T b) {
                BlockPos it = (BlockPos)a;
                boolean bl = false;
                Comparable comparable = Double.valueOf(MazePathFinderKt.distanceTo(it, this.$center$inlined));
                it = (BlockPos)b;
                Comparable comparable2 = comparable;
                bl = false;
                return ComparisonsKt.compareValues((Comparable)comparable2, (Comparable)Double.valueOf(MazePathFinderKt.distanceTo(it, this.$center$inlined)));
            }
        });
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean isStuck() {
        BlockPos blockPos = this.path;
        BlockPos blockPos2 = blockPos;
        if (blockPos == null) return false;
        if ((blockPos2 = (BlockPos)CollectionsKt.getOrNull(blockPos2, (int)this.currentPathIndex)) == null) {
            return false;
        }
        BlockPos waypoint = blockPos2;
        if (this.ticksSinceLastProgress <= 40) return false;
        BlockPos blockPos3 = this.mob.blockPosition();
        Intrinsics.checkNotNullExpressionValue((Object)blockPos3, (String)"blockPosition(...)");
        if (!(MazePathFinderKt.distanceTo(blockPos3, waypoint) > 3.0)) return false;
        return true;
    }

    private static final boolean calculatePath$lambda$2(BlockPos $startPos, BlockPos it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        Intrinsics.checkNotNull((Object)$startPos);
        return MazePathFinderKt.distanceTo(it, $startPos) < 2.0;
    }
}

