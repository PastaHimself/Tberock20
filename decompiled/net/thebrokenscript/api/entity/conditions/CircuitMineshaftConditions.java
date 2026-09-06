/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.tags.StructureTags
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
 *  net.minecraft.world.level.LightLayer
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.entity.SpawnConditions
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.conditions;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.StructureTags;
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
import net.minecraft.world.level.LightLayer;
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
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.entity.circuit.CircuitMineshaftFleeEntity;
import net.thebrokenscript.entity.circuit.CircuitMineshaftStareEntity;
import net.thebrokenscript.entity.circuit.CircuitMineshaftWalkEntity;
import net.thebrokenscript.entity.circuit.CircuitStalkEntity;
import net.thebrokenscript.entity.circuit.CircuitStareEntity;
import net.thebrokenscript.entity.circuit.CircuitUtil;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0000\u0010\u000e*\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J0\u0010\u0018\u001a\u00020\u00112\u000e\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u001a2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001e"}, d2={"Lnet/thebrokenscript/api/entity/conditions/CircuitMineshaftConditions;", "Lnet/thebrokenscript/brokencore/api/entity/SpawnConditions;", "<init>", "()V", "placementType", "Lnet/minecraft/world/entity/SpawnPlacementType;", "getPlacementType", "()Lnet/minecraft/world/entity/SpawnPlacementType;", "heightmap", "Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "getHeightmap", "()Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "predicate", "Lnet/minecraft/world/entity/SpawnPlacements$SpawnPredicate;", "T", "Lnet/minecraft/world/entity/Entity;", "canCircuitSpawn", "", "world", "Lnet/minecraft/world/level/ServerLevelAccessor;", "pos", "Lnet/minecraft/core/BlockPos;", "hasOtherCircuitsInRange", "Lnet/minecraft/world/level/LevelAccessor;", "checkMobSpawnRules", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "thebrokenscript-common"})
public final class CircuitMineshaftConditions
implements SpawnConditions {
    @NotNull
    private final SpawnPlacementType placementType;
    @NotNull
    private final Heightmap.Types heightmap;

    public CircuitMineshaftConditions() {
        SpawnPlacementType spawnPlacementType = SpawnPlacementTypes.ON_GROUND;
        Intrinsics.checkNotNullExpressionValue((Object)spawnPlacementType, (String)"ON_GROUND");
        this.placementType = spawnPlacementType;
        this.heightmap = Heightmap.Types.MOTION_BLOCKING_NO_LEAVES;
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
    public <T extends Entity> SpawnPlacements.SpawnPredicate<T> predicate() {
        return (arg_0, arg_1, arg_2, arg_3, arg_4) -> CircuitMineshaftConditions.predicate$lambda$0(this, arg_0, arg_1, arg_2, arg_3, arg_4);
    }

    private final boolean canCircuitSpawn(ServerLevelAccessor world, BlockPos pos) {
        ResourceKey biome = world.getBiome(pos).unwrapKey().orElse(null);
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
        boolean playerInMineshaft = BlockPos.betweenClosedStream((BlockPos)player.blockPosition().offset(-6, -6, -6), (BlockPos)player.blockPosition().offset(6, 6, 6)).anyMatch(arg_0 -> CircuitMineshaftConditions.canCircuitSpawn$lambda$1(arg_0 -> CircuitMineshaftConditions.canCircuitSpawn$lambda$0(world, arg_0), arg_0));
        boolean rules = biome != null && !CircuitUtil.INSTANCE.getBIOME_BLACKLIST().contains(biome) && !LevelExt.INSTANCE.getVars((LevelAccessor)world).getHasCircuitSpawned() && playerInMineshaft && world.getBrightness(LightLayer.SKY, pos) == 0 && !this.hasOtherCircuitsInRange((LevelAccessor)world, pos);
        return rules;
    }

    private final boolean hasOtherCircuitsInRange(LevelAccessor world, BlockPos pos) {
        Vec3 center = Vec3.atCenterOf((Vec3i)((Vec3i)pos));
        Intrinsics.checkNotNull((Object)center);
        Class[] classArray = new Class[]{CircuitMineshaftWalkEntity.class, CircuitMineshaftStareEntity.class, CircuitMineshaftFleeEntity.class, CircuitStalkEntity.class, CircuitStareEntity.class};
        return EntityFinder.hasEntitiesInRange((LevelAccessor)world, (Vec3)center, (Number)500, (Class[])classArray);
    }

    private final boolean checkMobSpawnRules(EntityType<? extends Entity> type, LevelAccessor level, MobSpawnType spawnType, BlockPos pos) {
        return spawnType == MobSpawnType.SPAWNER || level.getBlockState(pos.below()).isValidSpawn((BlockGetter)level, pos.below(), type);
    }

    private static final boolean predicate$lambda$0(CircuitMineshaftConditions this$0, EntityType entityType, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource random) {
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
        if (!Intrinsics.areEqual((Object)world.getLevel().dimension(), (Object)Level.OVERWORLD)) {
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
        if (Arena.Companion.getInstance() != null && Arena.Companion.getPhase() == ArenaPhase.Phase1) {
            return false;
        }
        if (world.getLevel().isFlat() && (double)random.nextFloat() > 0.001) {
            return false;
        }
        if (!this$0.canCircuitSpawn(world, pos)) {
            return false;
        }
        if (!(world instanceof ServerLevel)) {
            return false;
        }
        boolean inMineshaft = BlockPos.betweenClosedStream((BlockPos)pos.offset(-6, -6, -6), (BlockPos)pos.offset(6, 6, 6)).anyMatch(arg_0 -> CircuitMineshaftConditions.predicate$lambda$0$1(arg_0 -> CircuitMineshaftConditions.predicate$lambda$0$0(world, arg_0), arg_0));
        if (LevelExt.INSTANCE.getVars((LevelAccessor)world).getCircuitSpawnDelay() > 0) {
            return false;
        }
        if (inMineshaft && (double)random.nextFloat() <= 0.065 + (double)LongExt.INSTANCE.eventFrequency(((ServerLevel)world).getLevel().getGameTime())) {
            LevelExt.INSTANCE.updateVars((LevelAccessor)world, (Function1<? super MapVariables, Unit>)((Function1)CircuitMineshaftConditions::predicate$lambda$0$2));
            return true;
        }
        return false;
    }

    private static final boolean predicate$lambda$0$0(ServerLevelAccessor $world, BlockPos checkPos) {
        return ((ServerLevel)$world).structureManager().getStructureWithPieceAt(checkPos, StructureTags.MINESHAFT).isValid();
    }

    private static final boolean predicate$lambda$0$1(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    private static final Unit predicate$lambda$0$2(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setCircuitSpawnDelay(5200);
        return Unit.INSTANCE;
    }

    private static final boolean canCircuitSpawn$lambda$0(ServerLevelAccessor $world, BlockPos checkPos) {
        return ((ServerLevel)$world).structureManager().getStructureWithPieceAt(checkPos, StructureTags.MINESHAFT).isValid();
    }

    private static final boolean canCircuitSpawn$lambda$1(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }
}

