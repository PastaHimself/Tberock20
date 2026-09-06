/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.Difficulty
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnPlacementType
 *  net.minecraft.world.entity.SpawnPlacementTypes
 *  net.minecraft.world.entity.SpawnPlacements$SpawnPredicate
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.GameRules
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.entity.SpawnConditions
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.conditions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.LongExt;
import net.thebrokenscript.boss.integrity.Arena;
import net.thebrokenscript.boss.integrity.ArenaPhase;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.entity.SpawnConditions;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.entity.fever.FeverStalkEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\b\b\u0000\u0010\u0012*\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J \u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J0\u0010\u001e\u001a\u00020\u00152\u000e\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130 2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006$"}, d2={"Lnet/thebrokenscript/api/entity/conditions/FeverStalkConditions;", "Lnet/thebrokenscript/brokencore/api/entity/SpawnConditions;", "<init>", "()V", "placementType", "Lnet/minecraft/world/entity/SpawnPlacementType;", "getPlacementType", "()Lnet/minecraft/world/entity/SpawnPlacementType;", "heightmap", "Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "getHeightmap", "()Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "spawnChanceMatrix", "", "getSpawnChanceMatrix", "()[F", "predicate", "Lnet/minecraft/world/entity/SpawnPlacements$SpawnPredicate;", "T", "Lnet/minecraft/world/entity/Entity;", "hasOtherFeversInRange", "", "world", "Lnet/minecraft/world/level/LevelAccessor;", "pos", "Lnet/minecraft/core/BlockPos;", "playerYCalculation", "Lnet/minecraft/world/level/ServerLevelAccessor;", "random", "Lnet/minecraft/util/RandomSource;", "checkMobSpawnRules", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "thebrokenscript-common"})
public final class FeverStalkConditions
implements SpawnConditions {
    @NotNull
    private final SpawnPlacementType placementType;
    @NotNull
    private final Heightmap.Types heightmap;
    @NotNull
    private final float[] spawnChanceMatrix;

    public FeverStalkConditions() {
        SpawnPlacementType spawnPlacementType = SpawnPlacementTypes.NO_RESTRICTIONS;
        Intrinsics.checkNotNullExpressionValue((Object)spawnPlacementType, (String)"NO_RESTRICTIONS");
        this.placementType = spawnPlacementType;
        this.heightmap = Heightmap.Types.MOTION_BLOCKING_NO_LEAVES;
        float[] fArray = new float[]{5.0E-4f, 0.001f, 0.0015f, 0.002f, 0.0025f, 0.003f};
        this.spawnChanceMatrix = fArray;
    }

    @NotNull
    public SpawnPlacementType getPlacementType() {
        return this.placementType;
    }

    @NotNull
    public Heightmap.Types getHeightmap() {
        return this.heightmap;
    }

    @NotNull
    public final float[] getSpawnChanceMatrix() {
        return this.spawnChanceMatrix;
    }

    @NotNull
    public <T extends Entity> SpawnPlacements.SpawnPredicate<T> predicate() {
        return (arg_0, arg_1, arg_2, arg_3, arg_4) -> FeverStalkConditions.predicate$lambda$0(this, arg_0, arg_1, arg_2, arg_3, arg_4);
    }

    private final boolean hasOtherFeversInRange(LevelAccessor world, BlockPos pos) {
        Vec3 center = Vec3.atCenterOf((Vec3i)((Vec3i)pos));
        Intrinsics.checkNotNull((Object)center);
        Class[] classArray = new Class[]{FeverStalkEntity.class};
        return EntityFinder.hasEntitiesInRange((LevelAccessor)world, (Vec3)center, (Number)512, (Class[])classArray);
    }

    private final boolean playerYCalculation(ServerLevelAccessor world, BlockPos pos, RandomSource random) {
        double minY = 130.0;
        double maxY = 320.0;
        double maxChance = 0.75;
        Vec3 vec3 = Vec3.atCenterOf((Vec3i)((Vec3i)pos));
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"atCenterOf(...)");
        ServerPlayer serverPlayer = EntityFinder.findClosestPlayerInRange((ServerLevelAccessor)world, (Vec3)vec3, (Number)512.0);
        if (serverPlayer == null) {
            return false;
        }
        ServerPlayer player = serverPlayer;
        if (!(world instanceof ServerLevel)) {
            return false;
        }
        if (player.getY() < minY) {
            return false;
        }
        double normalized = Math.clamp((player.getY() - minY) / (maxY - minY), 0.0, 1.0);
        double chance = normalized * maxChance;
        double randomChance = random.nextDouble();
        return randomChance <= chance;
    }

    private final boolean checkMobSpawnRules(EntityType<? extends Entity> type, LevelAccessor level, MobSpawnType spawnType, BlockPos pos) {
        return spawnType == MobSpawnType.SPAWNER || level.getBlockState(pos.below()).isValidSpawn((BlockGetter)level, pos.below(), type);
    }

    private static final boolean predicate$lambda$0(FeverStalkConditions this$0, EntityType entityType, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource random) {
        if (world.getDifficulty() == Difficulty.PEACEFUL) {
            return false;
        }
        Intrinsics.checkNotNull((Object)entityType);
        Intrinsics.checkNotNull((Object)world);
        LevelAccessor levelAccessor = (LevelAccessor)world;
        Intrinsics.checkNotNull((Object)reason);
        Intrinsics.checkNotNull((Object)pos);
        if (!this$0.checkMobSpawnRules((EntityType<? extends Entity>)entityType, levelAccessor, reason, pos)) {
            return false;
        }
        if (!world.getLevel().getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
            return false;
        }
        if (!LevelExt.INSTANCE.getVars((LevelAccessor)world).isNullHere()) {
            return false;
        }
        if (TBSConfigs.INSTANCE.getServer().getDanger().getDisableSpawningEntities()) {
            return false;
        }
        if (!world.canSeeSkyFromBelowWater(pos)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)world.getLevel().dimension(), (Object)Level.OVERWORLD)) {
            return false;
        }
        if (Arena.Companion.getInstance() != null && Arena.Companion.getPhase() == ArenaPhase.Phase1) {
            return false;
        }
        if (world.getLevel().isFlat() && (double)random.nextFloat() > 0.001) {
            return false;
        }
        if (this$0.hasOtherFeversInRange((LevelAccessor)world, pos)) {
            return false;
        }
        int corruptMoonStage = RangesKt.coerceIn((int)LevelExt.INSTANCE.getVars((LevelAccessor)world).getMoonStage(), (int)0, (int)(this$0.spawnChanceMatrix.length - 1));
        Intrinsics.checkNotNull((Object)random);
        if (!this$0.playerYCalculation(world, pos, random)) {
            return false;
        }
        return !(random.nextFloat() > this$0.spawnChanceMatrix[corruptMoonStage] + LongExt.INSTANCE.eventFrequency(world.getLevel().getGameTime()));
    }
}

