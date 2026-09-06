/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function5
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.Holder
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.MinecraftServer
 *  net.minecraft.server.level.ServerChunkCache
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.InteractionHand
 *  net.minecraft.world.entity.Entity
 *  net.minecraft.world.item.Item
 *  net.minecraft.world.item.ItemStack
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.ChunkSource
 *  net.minecraft.world.level.chunk.status.ChunkStatus
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  net.minecraft.world.phys.Vec3
 *  net.thebrokenscript.brokencore.api.dsl.ItemUtil
 *  net.thebrokenscript.brokencore.api.dsl.StructureUtil
 *  net.thebrokenscript.brokencore.api.platform.CancelProxy
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.handlers;

import com.mojang.datafixers.util.Pair;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkSource;
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
import net.thebrokenscript.brokencore.api.dsl.ItemUtil;
import net.thebrokenscript.brokencore.api.dsl.StructureUtil;
import net.thebrokenscript.brokencore.api.platform.CancelProxy;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.handlers.subs.EntityPlaceSubscriber;
import net.thebrokenscript.misc.ForceRuntimeInit;
import net.thebrokenscript.registry.TBSBlocks;
import net.thebrokenscript.registry.TBSTags;
import org.jetbrains.annotations.NotNull;

@ForceRuntimeInit
@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lnet/thebrokenscript/handlers/CorruptedCommandBlockHandler;", "", "<init>", "()V", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nCorruptedCommandBlockHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CorruptedCommandBlockHandler.kt\nnet/thebrokenscript/handlers/CorruptedCommandBlockHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,136:1\n1563#2:137\n1634#2,3:138\n295#2,2:141\n*S KotlinDebug\n*F\n+ 1 CorruptedCommandBlockHandler.kt\nnet/thebrokenscript/handlers/CorruptedCommandBlockHandler\n*L\n36#1:137\n36#1:138,3\n37#1:141,2\n*E\n"})
public final class CorruptedCommandBlockHandler {
    @NotNull
    public static final CorruptedCommandBlockHandler INSTANCE = new CorruptedCommandBlockHandler();

    private CorruptedCommandBlockHandler() {
    }

    private static final Unit _init_$lambda$0(BlockPos pos, LevelAccessor level, Entity entity, BlockState state, CancelProxy proxy) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)proxy, (String)"proxy");
        if (!Intrinsics.areEqual((Object)state.getBlock(), (Object)TBSBlocks.CORRUPTED_COMMAND_BLOCK.get())) {
            return Unit.INSTANCE;
        }
        Entity entity2 = entity;
        if (!Intrinsics.areEqual((Object)(entity2 != null && (entity2 = entity2.level()) != null ? entity2.dimension() : null), (Object)Level.OVERWORLD)) {
            CorruptedCommandBlockHandler.lambda$0$cancelAndMaybeDrop(proxy, entity, level, pos);
            return Unit.INSTANCE;
        }
        Thread thread = Thread.currentThread();
        MinecraftServer minecraftServer = level.getServer();
        Intrinsics.checkNotNull((Object)minecraftServer);
        if (!Intrinsics.areEqual((Object)thread, (Object)minecraftServer.getRunningThread())) {
            return Unit.INSTANCE;
        }
        boolean isAllowedPlacement = Intrinsics.areEqual((Object)level.getBlockState(pos.below()).getBlock(), (Object)TBSBlocks.INITIATOR.get());
        if (isAllowedPlacement) {
            return Unit.INSTANCE;
        }
        MapVariables vars = LevelExt.INSTANCE.getVars(level);
        if (vars.getPlacedStructure()) {
            CorruptedCommandBlockHandler.lambda$0$cancelAndMaybeDrop(proxy, entity, level, pos);
            return Unit.INSTANCE;
        }
        double minDist = 1000.0;
        double maxDist = 2000.0;
        double angle = level.getRandom().nextDouble() * (Math.PI * 2);
        double radius = minDist + level.getRandom().nextDouble() * (maxDist - minDist);
        int dx = (int)(Math.cos(angle) * radius);
        int dz = (int)(Math.sin(angle) * radius);
        int baseX = pos.getX();
        int baseZ = pos.getZ();
        int targetX = baseX + dx;
        int targetZ = baseZ + dz;
        MinecraftServer minecraftServer2 = entity.getServer();
        Intrinsics.checkNotNull((Object)minecraftServer2);
        ServerLevel overworld = minecraftServer2.overworld();
        BlockPos searchOrigin = new BlockPos(targetX, 0, targetZ);
        Pair plainsResult = overworld.findClosestBiome3d(CorruptedCommandBlockHandler::lambda$0$2, searchOrigin, 6400, 32, 64);
        if (plainsResult == null) {
            CorruptedCommandBlockHandler.lambda$0$cancelAndMaybeDrop(proxy, entity, level, pos);
            return Unit.INSTANCE;
        }
        int finalX = ((BlockPos)plainsResult.getFirst()).getX();
        int finalZ = ((BlockPos)plainsResult.getFirst()).getZ();
        ResourceLocation structID = TBSConstants.id("futile_efforts");
        BlockPos finalChunkPos = new BlockPos(finalX, 0, finalZ);
        Intrinsics.checkNotNull((Object)overworld);
        StructureTemplate structure = StructureUtil.getStructure((ServerLevel)overworld, (ResourceLocation)structID);
        StructurePlaceSettings settings = new StructurePlaceSettings().addProcessor((StructureProcessor)BlockIgnoreProcessor.STRUCTURE_BLOCK).setRotation(Rotation.NONE).setIgnoreEntities(false);
        BoundingBox box = structure.getBoundingBox(settings, finalChunkPos);
        ChunkPos minChunk = new ChunkPos(new BlockPos(box.minX(), 0, box.minZ()));
        ChunkPos maxChunk = new ChunkPos(new BlockPos(box.maxX(), 0, box.maxZ()));
        int cx = minChunk.x;
        int n = maxChunk.x;
        if (cx <= n) {
            while (true) {
                int n2;
                int cz;
                if ((cz = minChunk.z) <= (n2 = maxChunk.z)) {
                    while (true) {
                        ChunkSource chunkSource = level.getChunkSource();
                        Intrinsics.checkNotNull((Object)chunkSource, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerChunkCache");
                        ((ServerChunkCache)chunkSource).getChunk(cx, cz, ChunkStatus.FULL, true);
                        if (cz == n2) break;
                        ++cz;
                    }
                }
                if (cx == n) break;
                ++cx;
            }
        }
        int y = overworld.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, finalX, finalZ);
        BlockPos finalPos = new BlockPos(finalX, y + 30, finalZ);
        MinecraftServer minecraftServer3 = entity.getServer();
        Intrinsics.checkNotNull((Object)minecraftServer3);
        minecraftServer3.execute(() -> CorruptedCommandBlockHandler.lambda$0$3(overworld, structID, finalPos, level, finalX, finalZ));
        CorruptedCommandBlockHandler.lambda$0$cancelAndMaybeDrop(proxy, entity, level, pos);
        return Unit.INSTANCE;
    }

    /*
     * WARNING - void declaration
     */
    private static final void lambda$0$cancelAndMaybeDrop(CancelProxy $proxy, Entity $entity, LevelAccessor $level, BlockPos $pos) {
        Object v2;
        block6: {
            void $this$firstOrNull$iv;
            void $this$mapTo$iv$iv;
            Iterable $this$map$iv;
            $proxy.setCanceled(true);
            ServerPlayer serverPlayer = $entity instanceof ServerPlayer ? (ServerPlayer)$entity : null;
            if (serverPlayer == null) {
                return;
            }
            ServerPlayer player = serverPlayer;
            if (player.isCreative()) {
                return;
            }
            ItemStack itemStack = TBSBlocks.CORRUPTED_COMMAND_BLOCK.getItemStack();
            Intrinsics.checkNotNull((Object)itemStack);
            Item item = itemStack.getItem();
            Iterable iterable = (Iterable)EntriesMappings.entries$0;
            boolean $i$f$map = false;
            Iterator iterator = $this$map$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
            boolean $i$f$mapTo = false;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                void it;
                InteractionHand interactionHand = (InteractionHand)item$iv$iv;
                Collection collection = destination$iv$iv;
                boolean bl = false;
                collection.add(player.getItemInHand((InteractionHand)it));
            }
            $this$map$iv = (List)destination$iv$iv;
            boolean $i$f$firstOrNull = false;
            for (Object element$iv : $this$firstOrNull$iv) {
                ItemStack it = (ItemStack)element$iv;
                boolean bl = false;
                if (!Intrinsics.areEqual((Object)it.getItem(), (Object)item)) continue;
                v2 = element$iv;
                break block6;
            }
            v2 = null;
        }
        ItemStack handStack = v2;
        if (handStack != null) {
            handStack.shrink(1);
            Vec3 vec3 = $pos.getCenter();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
            ItemStack itemStack = TBSBlocks.CORRUPTED_COMMAND_BLOCK.getItemStack();
            Intrinsics.checkNotNull((Object)itemStack);
            ItemUtil.tryDropItems$default((LevelAccessor)$level, (Vec3)vec3, (ItemStack)itemStack, (int)0, (int)4, null);
        } else {
            Vec3 vec3 = $pos.getCenter();
            Intrinsics.checkNotNullExpressionValue((Object)vec3, (String)"getCenter(...)");
            ItemStack itemStack = TBSBlocks.CORRUPTED_COMMAND_BLOCK.getItemStack();
            Intrinsics.checkNotNull((Object)itemStack);
            ItemUtil.tryDropItems$default((LevelAccessor)$level, (Vec3)vec3, (ItemStack)itemStack, (int)0, (int)4, null);
        }
    }

    private static final boolean lambda$0$2(Holder it) {
        return it.is(TBSTags.ALLOWED_BIOMES_BOSS);
    }

    private static final void lambda$0$3(ServerLevel $overworld, ResourceLocation $structID, BlockPos $finalPos, LevelAccessor $level, int $finalX, int $finalZ) {
        Intrinsics.checkNotNull((Object)$overworld);
        StructureUtil.placeStructureForced((ServerLevel)$overworld, (ResourceLocation)$structID, (BlockPos)$finalPos, (Rotation)Rotation.NONE);
        LevelExt.INSTANCE.updateVars($level, (Function1<? super MapVariables, Unit>)((Function1)arg_0 -> CorruptedCommandBlockHandler.lambda$0$3$0($finalX, $finalZ, arg_0)));
    }

    private static final Unit lambda$0$3$0(int $finalX, int $finalZ, MapVariables $this$updateVars) {
        Intrinsics.checkNotNullParameter((Object)((Object)$this$updateVars), (String)"$this$updateVars");
        $this$updateVars.setPlacedStructure(true);
        $this$updateVars.setBossStructX($finalX);
        $this$updateVars.setBossStructZ($finalZ);
        return Unit.INSTANCE;
    }

    static {
        EntityPlaceSubscriber.INSTANCE.add((Function5<? super BlockPos, ? super LevelAccessor, ? super Entity, ? super BlockState, ? super CancelProxy, Unit>)((Function5)CorruptedCommandBlockHandler::_init_$lambda$0));
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<InteractionHand> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])InteractionHand.values()));
        }
    }
}

