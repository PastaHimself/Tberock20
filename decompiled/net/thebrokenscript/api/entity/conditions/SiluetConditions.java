/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
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
 *  net.minecraft.world.entity.monster.Monster
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
import kotlin.jvm.internal.SourceDebugExtension;
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
import net.minecraft.world.entity.monster.Monster;
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
import net.thebrokenscript.entity.siluet.SiluetEntity;
import net.thebrokenscript.entity.siluet.SiluetStareEntity;
import net.thebrokenscript.registry.TBSEntities;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\b\b\u0000\u0010\u0014*\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J0\u0010\u001c\u001a\u00020\u00172\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u001e2\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\""}, d2={"Lnet/thebrokenscript/api/entity/conditions/SiluetConditions;", "Lnet/thebrokenscript/brokencore/api/entity/SpawnConditions;", "<init>", "()V", "placementType", "Lnet/minecraft/world/entity/SpawnPlacementType;", "getPlacementType", "()Lnet/minecraft/world/entity/SpawnPlacementType;", "heightmap", "Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "getHeightmap", "()Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "spawnChanceMatrix", "", "", "getSpawnChanceMatrix", "()[[F", "[[F", "predicate", "Lnet/minecraft/world/entity/SpawnPlacements$SpawnPredicate;", "T", "Lnet/minecraft/world/entity/Entity;", "hasOtherSiluetsInRange", "", "world", "Lnet/minecraft/world/level/LevelAccessor;", "pos", "Lnet/minecraft/core/BlockPos;", "checkMobSpawnRules", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nSiluetConditions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SiluetConditions.kt\nnet/thebrokenscript/api/entity/conditions/SiluetConditions\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,89:1\n1869#2,2:90\n*S KotlinDebug\n*F\n+ 1 SiluetConditions.kt\nnet/thebrokenscript/api/entity/conditions/SiluetConditions\n*L\n64#1:90,2\n*E\n"})
public final class SiluetConditions
implements SpawnConditions {
    @NotNull
    private final SpawnPlacementType placementType;
    @NotNull
    private final Heightmap.Types heightmap;
    @NotNull
    private final float[][] spawnChanceMatrix;

    public SiluetConditions() {
        SpawnPlacementType spawnPlacementType = SpawnPlacementTypes.ON_GROUND;
        Intrinsics.checkNotNullExpressionValue((Object)spawnPlacementType, (String)"ON_GROUND");
        this.placementType = spawnPlacementType;
        this.heightmap = Heightmap.Types.MOTION_BLOCKING_NO_LEAVES;
        float[][] fArrayArray = new float[3][];
        float[] fArray = new float[]{0.0f, 0.001f, 0.001f, 0.005f, 0.0085f, 0.0085f, 0.0085f, 0.0085f};
        fArrayArray[0] = fArray;
        fArray = new float[]{0.001f, 0.002f, 0.002f, 0.005f, 0.0085f, 0.009f, 0.01f, 0.01f};
        fArrayArray[1] = fArray;
        fArray = new float[]{0.003f, 0.003f, 0.006f, 0.006f, 0.005f, 0.0f, 0.0f, 0.0f};
        fArrayArray[2] = fArray;
        this.spawnChanceMatrix = fArrayArray;
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
    public final float[][] getSpawnChanceMatrix() {
        return this.spawnChanceMatrix;
    }

    @NotNull
    public <T extends Entity> SpawnPlacements.SpawnPredicate<T> predicate() {
        return (arg_0, arg_1, arg_2, arg_3, arg_4) -> SiluetConditions.predicate$lambda$0(this, arg_0, arg_1, arg_2, arg_3, arg_4);
    }

    private final boolean hasOtherSiluetsInRange(LevelAccessor world, BlockPos pos) {
        Vec3 center = Vec3.atCenterOf((Vec3i)((Vec3i)pos));
        Intrinsics.checkNotNull((Object)center);
        Class[] classArray = new Class[]{SiluetEntity.class, SiluetStareEntity.class};
        return EntityFinder.hasEntitiesInRange((LevelAccessor)world, (Vec3)center, (Number)500, (Class[])classArray);
    }

    private final boolean checkMobSpawnRules(EntityType<? extends Entity> type, LevelAccessor level, MobSpawnType spawnType, BlockPos pos) {
        return spawnType == MobSpawnType.SPAWNER || level.getBlockState(pos.below()).isValidSpawn((BlockGetter)level, pos.below(), type);
    }

    private static final boolean predicate$lambda$0(SiluetConditions this$0, EntityType entityType, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource random) {
        if (world.getDifficulty() == Difficulty.PEACEFUL) {
            return false;
        }
        if (!Monster.isDarkEnoughToSpawn((ServerLevelAccessor)world, (BlockPos)pos, (RandomSource)random)) {
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
        ServerLevel serverLevel = world.getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        if (LevelExt.INSTANCE.getVars((LevelAccessor)serverLevel).getEntitySpawnDelay() > 0) {
            return false;
        }
        if (this$0.hasOtherSiluetsInRange((LevelAccessor)world, pos)) {
            return false;
        }
        if (Arena.Companion.getInstance() != null && Arena.Companion.getPhase() == ArenaPhase.Phase1) {
            return false;
        }
        if (world.getLevel().isFlat() && (double)random.nextFloat() > 0.001) {
            return false;
        }
        int moonPhase = world.getMoonPhase();
        int corruptMoonStage = LevelExt.INSTANCE.getVars((LevelAccessor)world).getMoonStage();
        if (random.nextFloat() > this$0.spawnChanceMatrix[corruptMoonStage][moonPhase] + LongExt.INSTANCE.eventFrequency(world.getLevel().getGameTime())) {
            return false;
        }
        if (Intrinsics.areEqual((Object)entityType, TBSEntities.HE) && (double)random.nextFloat() > 0.1) {
            return false;
        }
        Vec3 vec3 = pos.getBottomCenter();
        Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getBottomCenter(...)");
        Iterable $this$forEach$iv = EntityFinder.findPlayersInRange((ServerLevelAccessor)world, (Vec3)vec3, (Number)75);
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerPlayer player = (ServerPlayer)element$iv;
            boolean bl = false;
            BlockPos playerPos = player.blockPosition();
            int skyLight = player.level().getBrightness(LightLayer.SKY, playerPos);
            if (skyLight < 2) continue;
            ServerLevel serverLevel2 = world.getLevel();
            Intrinsics.checkNotNullExpressionValue((Object)serverLevel2, (String)"getLevel(...)");
            LevelExt.INSTANCE.updateVars((LevelAccessor)serverLevel2, (Function1<? super MapVariables, Unit>)((Function1)SiluetConditions::predicate$lambda$0$0$0));
            return true;
        }
        return false;
    }

    private static final Unit predicate$lambda$0$0$0(MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setEntitySpawnDelay(6400);
        return Unit.INSTANCE;
    }
}

