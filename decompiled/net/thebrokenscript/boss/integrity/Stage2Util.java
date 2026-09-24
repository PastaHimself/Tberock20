/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Direction
 *  net.minecraft.core.Holder
 *  net.minecraft.core.Vec3i
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.DifficultyInstance
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.Mob
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.PositionUtil
 *  net.thebrokenscript.brokencore.api.entity.FinalizedSpawn
 *  net.thebrokenscript.brokencore.api.entity.base.BaseMonster
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package net.thebrokenscript.boss.integrity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.boss.integrity.Arena;
import net.thebrokenscript.boss.integrity.Phase2;
import net.thebrokenscript.boss.integrity.Stage2Floor;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.PositionUtil;
import net.thebrokenscript.brokencore.api.entity.FinalizedSpawn;
import net.thebrokenscript.brokencore.api.entity.base.BaseMonster;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.entity.boss.TetherEntity;
import net.thebrokenscript.entity.integrity.phase2.IntegrityPhase2Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0007J\u001a\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ.\u0010\u000e\u001a\u0004\u0018\u00010\u0005*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012JR\u0010\u0013\u001a\u0004\u0018\u00010\u0005*\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u0012H\u0002J\u001c\u0010\u001e\u001a\u00020\u001f*\u00020\t2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\u00a8\u0006!"}, d2={"Lnet/thebrokenscript/boss/integrity/Stage2Util;", "", "<init>", "()V", "getCenterOfExistingGeneration", "Lnet/minecraft/core/BlockPos;", "Lnet/minecraft/world/entity/player/Player;", "spawnFloorEntities", "", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "floor", "Lnet/thebrokenscript/boss/integrity/Stage2Floor;", "getRandomFloorPos", "ent", "Lnet/thebrokenscript/brokencore/api/entity/base/BaseMonster;", "maxAttempts", "", "findSafeChunkPos", "cellChunk", "Lnet/minecraft/world/level/ChunkPos;", "centerChunk", "spawnY", "minBlockDistance", "rng", "Lnet/minecraft/util/RandomSource;", "entity", "Lnet/minecraft/world/entity/Entity;", "scanDepth", "isValidFloor", "", "pos", "thebrokenscript-common"})
public final class Stage2Util {
    @NotNull
    public static final Stage2Util INSTANCE = new Stage2Util();

    private Stage2Util() {
    }

    @JvmStatic
    @NotNull
    public static final BlockPos getCenterOfExistingGeneration(@NotNull Player $this$getCenterOfExistingGeneration) {
        Intrinsics.checkNotNullParameter((Object)$this$getCenterOfExistingGeneration, (String)"<this>");
        int chunkX = $this$getCenterOfExistingGeneration.blockPosition().getX() >> 4;
        int chunkZ = $this$getCenterOfExistingGeneration.blockPosition().getZ() >> 4;
        int cellOriginChunkX = Math.floorDiv(chunkX, 10) * 10;
        int cellOriginChunkZ = Math.floorDiv(chunkZ, 10) * 10;
        int cellOriginX = cellOriginChunkX * 16;
        int cellOriginZ = cellOriginChunkZ * 16;
        return new BlockPos(cellOriginX + 80 + 8, 253, cellOriginZ + 80 + 8);
    }

    public final void spawnFloorEntities(@NotNull ServerLevel $this$spawnFloorEntities, @NotNull ServerPlayer player, @NotNull Stage2Floor floor) {
        Intrinsics.checkNotNullParameter((Object)$this$spawnFloorEntities, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)((Object)floor), (String)"floor");
        RandomSource rng = $this$spawnFloorEntities.random;
        ChunkPos cellChunk = PositionUtil.times((ChunkPos)PositionUtil.floorDiv((ChunkPos)PositionUtil.getChunk((BlockPos)Stage2Util.getCenterOfExistingGeneration((Player)player)), (Number)10), (Number)10);
        ChunkPos centerChunk = PositionUtil.overBy((ChunkPos)cellChunk, (Number)5);
        for (Holder<EntityType<?>> entityType : floor.getSpawns()) {
            Entity entity;
            if (((EntityType)entityType.value()).create((Level)$this$spawnFloorEntities) == null) continue;
            int chosenY = floor.pickSpawnY();
            int n = floor.getBounds().getMinDistance();
            Intrinsics.checkNotNull((Object)rng);
            BlockPos spawnPos = Stage2Util.findSafeChunkPos$default(this, $this$spawnFloorEntities, cellChunk, centerChunk, chosenY, n, rng, entity, 0, 0, 192, null);
            if (spawnPos == null) {
                entity.discard();
                continue;
            }
            entity.moveTo((double)spawnPos.getX() + 0.5, (double)spawnPos.getY(), (double)spawnPos.getZ() + 0.5, 0.0f, 0.0f);
            if (entity instanceof Mob) {
                ((Mob)entity).setPersistenceRequired();
            }
            $this$spawnFloorEntities.addFreshEntityWithPassengers(entity);
            if (entity instanceof FinalizedSpawn) {
                FinalizedSpawn finalizedSpawn = (FinalizedSpawn)entity;
                ServerLevelAccessor serverLevelAccessor = (ServerLevelAccessor)$this$spawnFloorEntities;
                DifficultyInstance difficultyInstance = $this$spawnFloorEntities.getCurrentDifficultyAt(spawnPos);
                Intrinsics.checkNotNullExpressionValue((Object)difficultyInstance, (String)"getCurrentDifficultyAt(...)");
                finalizedSpawn.onFinalizeSpawn(serverLevelAccessor, difficultyInstance, MobSpawnType.NATURAL, null, new CancelProxy(Stage2Util::spawnFloorEntities$lambda$0, Stage2Util::spawnFloorEntities$lambda$1));
            }
            if (!(entity instanceof IntegrityPhase2Entity)) continue;
            Object object = Arena.Companion.getInstance();
            if (object == null || (object = ((Arena)object).getPhase2()) == null) continue;
            ((Phase2)object).setIntegrity((IntegrityPhase2Entity)entity);
        }
    }

    @Nullable
    public final BlockPos getRandomFloorPos(@NotNull ServerLevel $this$getRandomFloorPos, @NotNull ServerPlayer player, @NotNull Stage2Floor floor, @NotNull BaseMonster ent, int maxAttempts) {
        Intrinsics.checkNotNullParameter((Object)$this$getRandomFloorPos, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)((Object)floor), (String)"floor");
        Intrinsics.checkNotNullParameter((Object)ent, (String)"ent");
        RandomSource rng = $this$getRandomFloorPos.random;
        ChunkPos cellChunk = PositionUtil.times((ChunkPos)PositionUtil.floorDiv((ChunkPos)PositionUtil.getChunk((BlockPos)Stage2Util.getCenterOfExistingGeneration((Player)player)), (Number)10), (Number)10);
        ChunkPos centerChunk = PositionUtil.overBy((ChunkPos)cellChunk, (Number)5);
        int chosenY = floor.pickSpawnY();
        for (int i = 0; i < maxAttempts; ++i) {
            int it = i;
            boolean bl = false;
            int n = floor.getBounds().getMinDistance();
            Intrinsics.checkNotNull((Object)rng);
            BlockPos spawnPos = Stage2Util.findSafeChunkPos$default(INSTANCE, $this$getRandomFloorPos, cellChunk, centerChunk, chosenY, n, rng, (Entity)ent, 0, 0, 192, null);
            if (spawnPos == null) continue;
            if (ent instanceof IntegrityPhase2Entity) {
                ServerLevel serverLevel = $this$getRandomFloorPos.getLevel();
                Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
                LevelAccessor levelAccessor = (LevelAccessor)serverLevel;
                Vec3 vec3 = Vec3.atCenterOf((Vec3i)((Vec3i)spawnPos));
                Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"atCenterOf(...)");
                if (EntityFinder.findClosestEntityInRange((LevelAccessor)levelAccessor, TetherEntity.class, (Vec3)vec3, (Number)50) != null) continue;
            }
            return spawnPos;
        }
        return null;
    }

    public static /* synthetic */ BlockPos getRandomFloorPos$default(Stage2Util stage2Util, ServerLevel serverLevel, ServerPlayer serverPlayer, Stage2Floor stage2Floor, BaseMonster baseMonster, int n, int n2, Object object) {
        if ((n2 & 8) != 0) {
            n = 40;
        }
        return stage2Util.getRandomFloorPos(serverLevel, serverPlayer, stage2Floor, baseMonster, n);
    }

    private final BlockPos findSafeChunkPos(ServerLevel $this$findSafeChunkPos, ChunkPos cellChunk, ChunkPos centerChunk, int spawnY, int minBlockDistance, RandomSource rng, Entity entity, int maxAttempts, int scanDepth) {
        int attempts = 0;
        block0: while (attempts < maxAttempts) {
            int minChunkDistance;
            int chunkZ;
            int dChunkZ;
            ++attempts;
            int chunkX = !(160 <= spawnY ? spawnY < 201 : false) && entity instanceof TetherEntity ? cellChunk.x + rng.nextIntBetweenInclusive(0, 9) : centerChunk.x;
            int dChunkX = chunkX - centerChunk.x;
            if (dChunkX * dChunkX + (dChunkZ = (chunkZ = cellChunk.z + rng.nextIntBetweenInclusive(0, 9)) - centerChunk.z) * dChunkZ < (minChunkDistance = minBlockDistance >> 4) * minChunkDistance) continue;
            int blockX = !(160 <= spawnY ? spawnY < 201 : false) ? (chunkX << 4) + rng.nextIntBetweenInclusive(0, 15) : (chunkX << 4) + 5;
            int blockZ = (chunkZ << 4) + rng.nextIntBetweenInclusive(0, 15);
            int dy = 0;
            if (dy > scanDepth) continue;
            BlockPos candidate;
            while (!(this.isValidFloor($this$findSafeChunkPos, candidate = new BlockPos(blockX, spawnY - dy, blockZ), entity) && $this$findSafeChunkPos.getBlockState(candidate.above()).canBeReplaced() && $this$findSafeChunkPos.getBlockState(candidate.above(2)).canBeReplaced() && $this$findSafeChunkPos.getBlockState(candidate.above(3)).canBeReplaced())) {
                if (dy == scanDepth) continue block0;
                ++dy;
            }
            return candidate.above();
        }
        return null;
    }

    static /* synthetic */ BlockPos findSafeChunkPos$default(Stage2Util stage2Util, ServerLevel serverLevel, ChunkPos chunkPos, ChunkPos chunkPos2, int n, int n2, RandomSource randomSource, Entity entity, int n3, int n4, int n5, Object object) {
        if ((n5 & 0x40) != 0) {
            n3 = 40;
        }
        if ((n5 & 0x80) != 0) {
            n4 = 4;
        }
        return stage2Util.findSafeChunkPos(serverLevel, chunkPos, chunkPos2, n, n2, randomSource, entity, n3, n4);
    }

    private final boolean isValidFloor(ServerLevel $this$isValidFloor, BlockPos pos, Entity entity) {
        BlockState state = $this$isValidFloor.getBlockState(pos);
        if (state.isAir()) {
            return false;
        }
        if (state.canBeReplaced()) {
            return false;
        }
        return state.entityCanStandOnFace((BlockGetter)$this$isValidFloor, pos, entity, Direction.UP) || state.is(Blocks.BARRIER) || state.is(Blocks.MUD);
    }

    private static final Unit spawnFloorEntities$lambda$0(boolean it) {
        return Unit.INSTANCE;
    }

    private static final boolean spawnFloorEntities$lambda$1() {
        return false;
    }
}

