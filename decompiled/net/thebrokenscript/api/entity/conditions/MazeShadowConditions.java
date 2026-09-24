/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnPlacementType
 *  net.minecraft.world.entity.SpawnPlacementTypes
 *  net.minecraft.world.entity.SpawnPlacements$SpawnPredicate
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.entity.LevelEntityGetterAdapter
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.phys.AABB
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.entity.SpawnConditions
 *  net.thebrokenscript.brokencore.api.ext.miximpl.EntityLookupExtImplKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.conditions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.entity.LevelEntityGetterAdapter;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.entity.SpawnConditions;
import net.thebrokenscript.brokencore.api.ext.miximpl.EntityLookupExtImplKt;
import net.thebrokenscript.entity.maze.MazeShadowsEntity;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0000\u0010\u000e*\u00020\u000fH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/api/entity/conditions/MazeShadowConditions;", "Lnet/thebrokenscript/brokencore/api/entity/SpawnConditions;", "<init>", "()V", "placementType", "Lnet/minecraft/world/entity/SpawnPlacementType;", "getPlacementType", "()Lnet/minecraft/world/entity/SpawnPlacementType;", "heightmap", "Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "getHeightmap", "()Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "predicate", "Lnet/minecraft/world/entity/SpawnPlacements$SpawnPredicate;", "T", "Lnet/minecraft/world/entity/Entity;", "thebrokenscript-common"})
public final class MazeShadowConditions
implements SpawnConditions {
    @NotNull
    private final SpawnPlacementType placementType;
    @NotNull
    private final Heightmap.Types heightmap;

    public MazeShadowConditions() {
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
        return MazeShadowConditions::predicate$lambda$0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final boolean predicate$lambda$0(EntityType entityType, ServerLevelAccessor level, MobSpawnType mobSpawnType, BlockPos pos, RandomSource randomSource) {
        if (!level.getBlockStates(new AABB(pos).inflate(5.0).move(-3.0, -3.0, -3.0)).anyMatch(arg_0 -> MazeShadowConditions.predicate$lambda$0$1(MazeShadowConditions::predicate$lambda$0$0, arg_0))) return false;
        if (!Intrinsics.areEqual((Object)level.getLevel().dimension(), TBSDimensions.NULL_TORTURE)) return false;
        ServerLevel serverLevel = level.getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        if (EntityLookupExtImplKt.byClass((LevelEntityGetterAdapter)EntityFinder.getEntities((ServerLevel)serverLevel), MazeShadowsEntity.class).size() > 50) return false;
        return true;
    }

    private static final boolean predicate$lambda$0$0(BlockState it) {
        return it.is(Blocks.BEDROCK);
    }

    private static final boolean predicate$lambda$0$1(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }
}

