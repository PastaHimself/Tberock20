/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Vec3i
 *  net.minecraft.network.chat.Component
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerChunkCache
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.tags.BlockTags
 *  net.minecraft.tags.TagKey
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Block
 *  net.minecraft.world.level.block.Blocks
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.status.ChunkStatus
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ArrayUtil
 *  net.thebrokenscript.brokencore.api.dsl.BlockUtil
 *  net.thebrokenscript.brokencore.api.dsl.EntityFinder
 *  net.thebrokenscript.brokencore.api.dsl.StructureUtil
 *  net.thebrokenscript.brokencore.impl.config.BCConfigs
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers.structure;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.TBSConstants;
import net.thebrokenscript.api.ext.LevelExt;
import net.thebrokenscript.brokencore.api.dsl.ArrayUtil;
import net.thebrokenscript.brokencore.api.dsl.BlockUtil;
import net.thebrokenscript.brokencore.api.dsl.EntityFinder;
import net.thebrokenscript.brokencore.api.dsl.StructureUtil;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import net.thebrokenscript.misc.ForceRuntimeInit;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lnet/thebrokenscript/handlers/structure/StructurePlaceHandler;", "", "<init>", "()V", "fill", "", "", "place", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "structureId", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nStructurePlaceHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StructurePlaceHandler.kt\nnet/thebrokenscript/handlers/structure/StructurePlaceHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ComponentDSL.kt\nnet/thebrokenscript/brokencore/api/dsl/ComponentUtil\n*L\n1#1,189:1\n1761#2,3:190\n15#3:193\n15#3:194\n*S KotlinDebug\n*F\n+ 1 StructurePlaceHandler.kt\nnet/thebrokenscript/handlers/structure/StructurePlaceHandler\n*L\n118#1:190,3\n180#1:193\n182#1:194\n*E\n"})
public final class StructurePlaceHandler {
    @NotNull
    public static final StructurePlaceHandler INSTANCE = new StructurePlaceHandler();
    @NotNull
    private static final List<String> fill;

    private StructurePlaceHandler() {
    }

    public final void place(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos, @NotNull String structureId) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)structureId, (String)"structureId");
        int n = 10;
        for (int i = 0; i < n; ++i) {
            boolean result;
            BlockPos structurePos;
            block36: {
                Rotation rotation;
                block37: {
                    boolean bl;
                    block35: {
                        boolean isFluid;
                        int it = i;
                        boolean bl2 = false;
                        Collection collection = (Collection)EntriesMappings.entries$0;
                        RandomSource randomSource = level.random;
                        Intrinsics.checkNotNullExpressionValue((Object)randomSource, (String)"random");
                        rotation = (Rotation)ArrayUtil.random((Collection)collection, (RandomSource)randomSource);
                        StructureTemplate structure = StructureUtil.getStructure((ServerLevel)level, (ResourceLocation)TBSConstants.id(structureId));
                        Vec3i structureSize = structure.getSize(rotation);
                        structurePos = null;
                        structurePos = net.thebrokenscript.util.StructureUtil.getRandomPlacementPosition$default(net.thebrokenscript.util.StructureUtil.INSTANCE, (Level)level, pos.x, pos.z, 60.0, 250.0, false, 32, null);
                        StructurePlaceSettings settings = new StructurePlaceSettings().addProcessor((StructureProcessor)BlockIgnoreProcessor.STRUCTURE_BLOCK).setRotation(rotation).setIgnoreEntities(false);
                        BoundingBox box = structure.getBoundingBox(settings, structurePos);
                        ChunkPos minChunk = new ChunkPos(new BlockPos(box.minX(), 0, box.minZ()));
                        ChunkPos maxChunk = new ChunkPos(new BlockPos(box.maxX(), 0, box.maxZ()));
                        int cx = minChunk.x;
                        int n2 = maxChunk.x;
                        if (cx <= n2) {
                            while (true) {
                                int n3;
                                int cz;
                                if ((cz = minChunk.z) <= (n3 = maxChunk.z)) {
                                    while (true) {
                                        ServerChunkCache serverChunkCache = level.getChunkSource();
                                        Intrinsics.checkNotNull((Object)serverChunkCache, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerChunkCache");
                                        serverChunkCache.getChunk(cx, cz, ChunkStatus.FULL, true);
                                        if (cz == n3) break;
                                        ++cz;
                                    }
                                }
                                if (cx == n2) break;
                                ++cx;
                            }
                        }
                        BlockPos blockPos = level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, structurePos);
                        Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"getHeightmapPos(...)");
                        structurePos = blockPos;
                        StructurePlaceHandler $this$place_u24lambda_u240_u240 = INSTANCE;
                        boolean $i$a$-run-StructurePlaceHandler$place$1$22 = false;
                        if (!(Intrinsics.areEqual((Object)structureId, (Object)"torch") || Intrinsics.areEqual((Object)structureId, (Object)"redstone_torch") || Intrinsics.areEqual((Object)structureId, (Object)"bench"))) {
                            int structureHorizonalVolume = structureSize.getX() * structureSize.getZ();
                            boolean usingAverage = structureHorizonalVolume < 81;
                            int attempts = Math.max(Math.min(structureHorizonalVolume / 10, 10), 3);
                            while (attempts > 0) {
                                double steepness = net.thebrokenscript.util.StructureUtil.INSTANCE.getSteepnessForStructureCorners(structurePos, level, TBSConstants.id(structureId), rotation, false, usingAverage);
                                if (structureHorizonalVolume != 1 && steepness > (double)(1 + structureHorizonalVolume / 8)) {
                                    --attempts;
                                    continue;
                                }
                                BlockPos blockPos2 = structurePos.offset(structureSize);
                                Intrinsics.checkNotNullExpressionValue((Object)blockPos2, (String)"offset(...)");
                                double score = net.thebrokenscript.util.StructureUtil.INSTANCE.getAreaOccupancy(level, structurePos, blockPos2, (Function2<? super BlockState, ? super BlockPos, Double>)((Function2)(arg_0, arg_1) -> StructurePlaceHandler.place$lambda$0$0$0(level, arg_0, arg_1)));
                                int structureVol = structureSize.getX() * structureSize.getY() * structureSize.getZ();
                                if (!(score > (double)(structureVol / 4)) || structureVol <= 4) break;
                                --attempts;
                            }
                        }
                        if (!(isFluid = level.getBlockState(structurePos.below()).getFluidState().isEmpty())) continue;
                        Object[] $i$a$-run-StructurePlaceHandler$place$1$22 = new BlockPos[]{structurePos, structurePos.offset(structureSize.getX() - 1, 0, 0), structurePos.offset(0, 0, structureSize.getZ() - 1), structurePos.offset(structureSize.getX() - 1, 0, structureSize.getZ() - 1)};
                        List corners = CollectionsKt.listOf((Object[])$i$a$-run-StructurePlaceHandler$place$1$22);
                        Map<Long, Long> modifiedChunks = LevelExt.INSTANCE.getPlayerChunks((LevelAccessor)level).getChunks();
                        Iterable $this$any$iv = corners;
                        boolean $i$f$any = false;
                        if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                            bl = false;
                        } else {
                            for (Object element$iv : $this$any$iv) {
                                BlockPos it2 = (BlockPos)element$iv;
                                boolean bl3 = false;
                                Long l = modifiedChunks.get(new ChunkPos(it2).toLong());
                                if (!((l != null ? l : 0L) >= 10L)) continue;
                                bl = true;
                                break block35;
                            }
                            bl = false;
                        }
                    }
                    if (bl) continue;
                    result = false;
                    if (Intrinsics.areEqual((Object)structureId, (Object)"cavebase_overhaul")) break block37;
                    List players = EntityFinder.findPlayersInRange((ServerLevel)level, (Vec3)pos, (Number)256);
                    for (ServerPlayer p : players) {
                        int surfaceY = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int)p.getX(), (int)p.getZ());
                        if (!(p.getY() >= (double)surfaceY)) continue;
                        switch (structureId) {
                            case "torch": {
                                Block block = Blocks.TORCH;
                                Intrinsics.checkNotNullExpressionValue((Object)block, (String)"TORCH");
                                boolean bl4 = level.setBlock(structurePos, BlockUtil.default((Block)block), 3);
                                break;
                            }
                            case "redstone_torch": {
                                Block block = Blocks.REDSTONE_TORCH;
                                Intrinsics.checkNotNullExpressionValue((Object)block, (String)"REDSTONE_TORCH");
                                boolean bl4 = level.setBlock(structurePos, BlockUtil.default((Block)block), 3);
                                break;
                            }
                            case "crosses": {
                                ResourceLocation resourceLocation = TBSConstants.id(structureId);
                                BlockPos blockPos = structurePos.above(35);
                                Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"above(...)");
                                boolean bl4 = StructureUtil.placeStructureForced((ServerLevel)level, (ResourceLocation)resourceLocation, (BlockPos)blockPos, (Rotation)rotation);
                                break;
                            }
                            case "magmacross": {
                                ResourceLocation resourceLocation = TBSConstants.id(structureId);
                                BlockPos blockPos = structurePos.above(50);
                                Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"above(...)");
                                boolean bl4 = StructureUtil.placeStructureForced((ServerLevel)level, (ResourceLocation)resourceLocation, (BlockPos)blockPos, (Rotation)rotation);
                                break;
                            }
                            case "crossfly": {
                                ResourceLocation resourceLocation = TBSConstants.id(structureId);
                                BlockPos blockPos = structurePos.above(50);
                                Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"above(...)");
                                boolean bl4 = StructureUtil.placeStructureForced((ServerLevel)level, (ResourceLocation)resourceLocation, (BlockPos)blockPos, (Rotation)rotation);
                                break;
                            }
                            default: {
                                boolean bl4 = result = StructureUtil.placeStructureForced((ServerLevel)level, (ResourceLocation)TBSConstants.id(structureId), (BlockPos)structurePos, (Rotation)rotation);
                            }
                        }
                        if (fill.contains(structureId)) {
                            net.thebrokenscript.util.StructureUtil.fillDownward$default(net.thebrokenscript.util.StructureUtil.INSTANCE, structurePos, TBSConstants.id(structureId), level, false, rotation, null, StructurePlaceHandler::place$lambda$0$2, 32, null);
                        }
                        break block36;
                    }
                    break block36;
                }
                ResourceLocation resourceLocation = TBSConstants.id(structureId);
                BlockPos blockPos = structurePos.below(40);
                Intrinsics.checkNotNullExpressionValue((Object)blockPos, (String)"below(...)");
                result = StructureUtil.placeStructureForced((ServerLevel)level, (ResourceLocation)resourceLocation, (BlockPos)blockPos, (Rotation)rotation);
            }
            if (BCConfigs.INSTANCE.getServer().getEvents().getEventDebug()) {
                if (result) {
                    String $this$c$iv = "Structure Placement succeeded at X: " + structurePos.getX() + ", Y: " + structurePos.getY() + ", Z: " + structurePos.getZ();
                    boolean $i$f$getC = false;
                    Component component = Component.nullToEmpty((String)$this$c$iv);
                    Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
                    player.sendSystemMessage(component);
                } else {
                    String $this$c$iv = "Structure FAILED at X: " + structurePos.getX() + ", Y: " + structurePos.getY() + ", Z: " + structurePos.getZ();
                    boolean $i$f$getC = false;
                    Component component = Component.nullToEmpty((String)$this$c$iv);
                    Intrinsics.checkNotNullExpressionValue((Object)component, (String)"nullToEmpty(...)");
                    player.sendSystemMessage(component);
                }
            }
            if (!result) continue;
            return;
        }
    }

    private static final double place$lambda$0$0$0(ServerLevel $level, BlockState blockState, BlockPos blockPos) {
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        return Intrinsics.areEqual((Object)blockState.getBlock(), (Object)Blocks.COBBLESTONE) || blockState.getTags().anyMatch(arg_0 -> StructurePlaceHandler.place$lambda$0$0$0$1(arg_0 -> StructurePlaceHandler.place$lambda$0$0$0$0(blockState, arg_0), arg_0)) ? 8.0 : (blockState.getTags().anyMatch(arg_0 -> StructurePlaceHandler.place$lambda$0$0$0$3(StructurePlaceHandler::place$lambda$0$0$0$2, arg_0)) ? 1.0 : (blockState.getTags().anyMatch(arg_0 -> StructurePlaceHandler.place$lambda$0$0$0$5(StructurePlaceHandler::place$lambda$0$0$0$4, arg_0)) ? 2.0 : (blockState.getTags().anyMatch(arg_0 -> StructurePlaceHandler.place$lambda$0$0$0$7(StructurePlaceHandler::place$lambda$0$0$0$6, arg_0)) ? 0.0 : (blockState.getCollisionShape((BlockGetter)$level, blockPos).isEmpty() ? 0.0 : 0.25))));
    }

    private static final boolean place$lambda$0$0$0$0(BlockState $blockState, TagKey tagKey) {
        return tagKey.equals((Object)BlockTags.PLANKS) || tagKey.equals((Object)BlockTags.SLABS) || $blockState.getTags().anyMatch(arg_0 -> StructurePlaceHandler.place$lambda$0$0$0$0$1(arg_0 -> StructurePlaceHandler.place$lambda$0$0$0$0$0(tagKey, arg_0), arg_0));
    }

    private static final boolean place$lambda$0$0$0$0$0(TagKey $tagKey, TagKey it) {
        return $tagKey.equals((Object)BlockTags.STAIRS);
    }

    private static final boolean place$lambda$0$0$0$0$1(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    private static final boolean place$lambda$0$0$0$1(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    private static final boolean place$lambda$0$0$0$2(TagKey tagKey) {
        return tagKey.equals((Object)BlockTags.LEAVES);
    }

    private static final boolean place$lambda$0$0$0$3(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    private static final boolean place$lambda$0$0$0$4(TagKey tagKey) {
        return tagKey.equals((Object)BlockTags.LOGS);
    }

    private static final boolean place$lambda$0$0$0$5(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    private static final boolean place$lambda$0$0$0$6(TagKey tagKey) {
        return tagKey.equals((Object)BlockTags.AIR);
    }

    private static final boolean place$lambda$0$0$0$7(Function1 $tmp0, Object p0) {
        return (Boolean)$tmp0.invoke(p0);
    }

    private static final BlockState place$lambda$0$2(BlockPos blockPos, ServerLevel serverLevel) {
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"<unused var>");
        Intrinsics.checkNotNullParameter((Object)serverLevel, (String)"<unused var>");
        Block block = Blocks.DIRT;
        Intrinsics.checkNotNullExpressionValue((Object)block, (String)"DIRT");
        return BlockUtil.default((Block)block);
    }

    static {
        Object[] objectArray = new String[]{"clanbuildoverhaul", "house3", "house2", "house1", "trap1", "trap2"};
        fill = CollectionsKt.listOf((Object[])objectArray);
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Rotation> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Rotation.values()));
        }
    }
}

