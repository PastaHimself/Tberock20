/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.Difficulty
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.entity.EntityType
 *  net.minecraft.world.entity.MobSpawnType
 *  net.minecraft.world.entity.SpawnPlacementType
 *  net.minecraft.world.entity.SpawnPlacementTypes
 *  net.minecraft.world.entity.SpawnPlacements$SpawnPredicate
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
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
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
import net.thebrokenscript.entity.oblit.Obliteration2Entity;
import net.thebrokenscript.entity.oblit.ObliterationEntity;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0000\u0010\u000e*\u00020\u000fH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/api/entity/conditions/ObliterationConditions;", "Lnet/thebrokenscript/brokencore/api/entity/SpawnConditions;", "<init>", "()V", "placementType", "Lnet/minecraft/world/entity/SpawnPlacementType;", "getPlacementType", "()Lnet/minecraft/world/entity/SpawnPlacementType;", "heightmap", "Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "getHeightmap", "()Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "predicate", "Lnet/minecraft/world/entity/SpawnPlacements$SpawnPredicate;", "T", "Lnet/minecraft/world/entity/Entity;", "thebrokenscript-common"})
public final class ObliterationConditions
implements SpawnConditions {
    @NotNull
    private final SpawnPlacementType placementType;
    @NotNull
    private final Heightmap.Types heightmap;

    public ObliterationConditions() {
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
        return ObliterationConditions::predicate$lambda$0;
    }

    private static final boolean predicate$lambda$0(EntityType entityType, ServerLevelAccessor world, MobSpawnType mobSpawnType, BlockPos pos, RandomSource random) {
        if (world.getDifficulty() == Difficulty.PEACEFUL) {
            return false;
        }
        if (!world.getLevel().getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
            return false;
        }
        Intrinsics.checkNotNull((Object)world);
        if (!LevelExt.INSTANCE.getVars((LevelAccessor)world).isNullHere()) {
            return false;
        }
        if (TBSConfigs.INSTANCE.getServer().getDanger().getDisableSpawningEntities()) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)world.getLevel().dimension(), (Object)Level.OVERWORLD)) {
            return false;
        }
        if (world.getBrightness(LightLayer.SKY, pos) == 0) {
            return false;
        }
        if ((double)random.nextFloat() > 0.0085 + (double)LongExt.INSTANCE.eventFrequency(world.getLevel().getGameTime())) {
            return false;
        }
        if (LevelExt.INSTANCE.getVars((LevelAccessor)world).getOblitSpawnDelay() > 0) {
            return false;
        }
        if (Arena.Companion.getInstance() != null && Arena.Companion.getPhase() == ArenaPhase.Phase1) {
            return false;
        }
        ServerLevel serverLevel = world.getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        LevelAccessor levelAccessor = (LevelAccessor)serverLevel;
        Vec3 vec3 = pos.getCenter();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
        Class[] classArray = new Class[]{ObliterationEntity.class, Obliteration2Entity.class};
        if (EntityFinder.hasEntitiesInRange((LevelAccessor)levelAccessor, (Vec3)vec3, (Number)512, (Class[])classArray)) {
            return false;
        }
        if (world.getLevel().isFlat() && (double)random.nextFloat() > 0.001) {
            return false;
        }
        if (world.getLevel().isDay()) {
            LevelExt.INSTANCE.updateVars((LevelAccessor)world, (Function1<? super MapVariables, Unit>)((Function1)ObliterationConditions::predicate$lambda$0$0));
            return true;
        }
        return false;
    }

    private static final Unit predicate$lambda$0$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setOblitSpawnDelay(32000);
        return Unit.INSTANCE;
    }
}

