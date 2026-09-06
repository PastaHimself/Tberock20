/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
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
 *  net.minecraft.world.entity.player.Player
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.GameRules
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.entity.LevelEntityGetterAdapter
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.entity.SpawnConditions
 *  net.thebrokenscript.brokencore.api.ext.miximpl.EntityLookupExtImplKt
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.entity.conditions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.entity.LevelEntityGetterAdapter;
import net.minecraft.world.level.levelgen.Heightmap;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.api.ext.LongExt;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.entity.SpawnConditions;
import net.thebrokenscript.brokencore.api.ext.miximpl.EntityLookupExtImplKt;
import net.thebrokenscript.config.TBSConfigs;
import net.thebrokenscript.entity.nullent.NullMazeEntity;
import net.thebrokenscript.registry.TBSDimensions;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\b\b\u0000\u0010\u0014*\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\rH\u0002J0\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\rX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006#"}, d2={"Lnet/thebrokenscript/api/entity/conditions/NullMazeConditions;", "Lnet/thebrokenscript/brokencore/api/entity/SpawnConditions;", "<init>", "()V", "placementType", "Lnet/minecraft/world/entity/SpawnPlacementType;", "getPlacementType", "()Lnet/minecraft/world/entity/SpawnPlacementType;", "heightmap", "Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "getHeightmap", "()Lnet/minecraft/world/level/levelgen/Heightmap$Types;", "mazeFloorChance", "", "getMazeFloorChance", "()D", "defaultChance", "getDefaultChance", "predicate", "Lnet/minecraft/world/entity/SpawnPlacements$SpawnPredicate;", "T", "Lnet/minecraft/world/entity/Entity;", "getLayer", "Lnet/thebrokenscript/api/entity/conditions/NullMazeConditions$Layer;", "checkMobSpawnRules", "", "type", "Lnet/minecraft/world/entity/EntityType;", "level", "Lnet/minecraft/world/level/LevelAccessor;", "spawnType", "Lnet/minecraft/world/entity/MobSpawnType;", "pos", "Lnet/minecraft/core/BlockPos;", "Layer", "thebrokenscript-common"})
public final class NullMazeConditions
implements SpawnConditions {
    @NotNull
    private final SpawnPlacementType placementType;
    @NotNull
    private final Heightmap.Types heightmap;
    private final double mazeFloorChance;
    private final double defaultChance;

    public NullMazeConditions() {
        SpawnPlacementType spawnPlacementType = SpawnPlacementTypes.ON_GROUND;
        Intrinsics.checkNotNullExpressionValue((Object)spawnPlacementType, (String)"ON_GROUND");
        this.placementType = spawnPlacementType;
        this.heightmap = Heightmap.Types.MOTION_BLOCKING_NO_LEAVES;
        this.mazeFloorChance = 0.09;
        this.defaultChance = 0.025;
    }

    @NotNull
    public SpawnPlacementType getPlacementType() {
        return this.placementType;
    }

    @NotNull
    public Heightmap.Types getHeightmap() {
        return this.heightmap;
    }

    public final double getMazeFloorChance() {
        return this.mazeFloorChance;
    }

    public final double getDefaultChance() {
        return this.defaultChance;
    }

    @NotNull
    public <T extends Entity> SpawnPlacements.SpawnPredicate<T> predicate() {
        return (arg_0, arg_1, arg_2, arg_3, arg_4) -> NullMazeConditions.predicate$lambda$0(this, arg_0, arg_1, arg_2, arg_3, arg_4);
    }

    private final Layer getLayer(double $this$getLayer) {
        double d = $this$getLayer;
        boolean bl = 200.0 <= d ? d <= 205.9 : false;
        if (bl) {
            return Layer.ClanVoid;
        }
        boolean bl2 = 206.0 <= d ? d <= 214.9 : false;
        if (bl2) {
            return Layer.MazeFloor;
        }
        boolean bl3 = 215.0 <= d ? d <= 229.9 : false;
        if (bl3) {
            return Layer.WoodFloor;
        }
        boolean bl4 = 230.0 <= d ? d <= 249.9 : false;
        if (bl4) {
            return Layer.StoneFloor;
        }
        return null;
    }

    private final boolean checkMobSpawnRules(EntityType<? extends Entity> type, LevelAccessor level, MobSpawnType spawnType, BlockPos pos) {
        return spawnType == MobSpawnType.SPAWNER || level.getBlockState(pos.below()).isValidSpawn((BlockGetter)level, pos.below(), type);
    }

    private static final boolean predicate$lambda$0(NullMazeConditions this$0, EntityType entityType, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource random) {
        if (world.getDifficulty() == Difficulty.PEACEFUL) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)world.getLevel().dimension(), TBSDimensions.CLAN_VOID)) {
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
        ServerLevel serverLevel = world.getLevel();
        Intrinsics.checkNotNullExpressionValue((Object)serverLevel, (String)"getLevel(...)");
        if (EntityLookupExtImplKt.byClass((LevelEntityGetterAdapter)EntityFinder.getEntities((ServerLevel)serverLevel), NullMazeEntity.class).size() >= 2) {
            return false;
        }
        Player player = world.getNearestPlayer((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), 152.0, false);
        if (player == null) {
            return false;
        }
        Player player2 = player;
        double d = pos.getY();
        boolean bl = 226.0 <= d ? d <= 229.0 : false;
        if (bl) {
            return false;
        }
        Layer layer = this$0.getLayer(player2.getY());
        if (layer == null) {
            return false;
        }
        Layer playerLayer = layer;
        Layer layer2 = this$0.getLayer(pos.getY());
        if (layer2 == null) {
            return false;
        }
        Layer entityLayer = layer2;
        if (playerLayer == entityLayer && playerLayer == Layer.MazeFloor) {
            return (double)random.nextFloat() <= this$0.mazeFloorChance + (double)LongExt.INSTANCE.eventFrequency(world.getLevel().getGameTime());
        }
        if (playerLayer == entityLayer && playerLayer != Layer.MazeFloor) {
            return (double)random.nextFloat() <= this$0.defaultChance + (double)LongExt.INSTANCE.eventFrequency(world.getLevel().getGameTime());
        }
        return false;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2={"Lnet/thebrokenscript/api/entity/conditions/NullMazeConditions$Layer;", "", "<init>", "(Ljava/lang/String;I)V", "ClanVoid", "MazeFloor", "WoodFloor", "StoneFloor", "thebrokenscript-common"})
    private static final class Layer
    extends Enum<Layer> {
        public static final /* enum */ Layer ClanVoid = new Layer();
        public static final /* enum */ Layer MazeFloor = new Layer();
        public static final /* enum */ Layer WoodFloor = new Layer();
        public static final /* enum */ Layer StoneFloor = new Layer();
        private static final /* synthetic */ Layer[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        public static Layer[] values() {
            return (Layer[])$VALUES.clone();
        }

        public static Layer valueOf(String value) {
            return Enum.valueOf(Layer.class, value);
        }

        @NotNull
        public static EnumEntries<Layer> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = layerArray = new Layer[]{Layer.ClanVoid, Layer.MazeFloor, Layer.WoodFloor, Layer.StoneFloor};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

