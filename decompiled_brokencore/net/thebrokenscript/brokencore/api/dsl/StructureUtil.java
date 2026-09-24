/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.server.level.ServerChunkCache
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.util.RandomSource
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.ServerLevelAccessor
 *  net.minecraft.world.level.block.Mirror
 *  net.minecraft.world.level.block.Rotation
 *  net.minecraft.world.level.chunk.status.ChunkStatus
 *  net.minecraft.world.level.levelgen.structure.BoundingBox
 *  net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
 *  net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.dsl;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=2, xi=48, d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001a\"\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b\u001a\u001a\u0010\f\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b\u001a\u001a\u0010\u000f\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001a\u001a\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\u0013"}, d2={"getStructure", "Lnet/minecraft/world/level/levelgen/structure/templatesystem/StructureTemplate;", "Lnet/minecraft/server/level/ServerLevel;", "id", "Lnet/minecraft/resources/ResourceLocation;", "placeStructure", "", "pos", "Lnet/minecraft/core/BlockPos;", "placeStructureForced", "rotation", "Lnet/minecraft/world/level/block/Rotation;", "place", "level", "Lnet/minecraft/world/level/ServerLevelAccessor;", "placeStructureNormal", "tryPlaceStructure", "", "Lnet/minecraft/world/level/LevelAccessor;", "brokencore-common"})
@JvmName(name="StructureUtil")
public final class StructureUtil {
    @NotNull
    public static final StructureTemplate getStructure(@NotNull ServerLevel $this$getStructure, @NotNull ResourceLocation id) {
        Intrinsics.checkNotNullParameter((Object)$this$getStructure, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        StructureTemplate structureTemplate = $this$getStructure.getStructureManager().getOrCreate(id);
        Intrinsics.checkNotNullExpressionValue((Object)structureTemplate, (String)"getOrCreate(...)");
        return structureTemplate;
    }

    public static final boolean placeStructure(@NotNull ServerLevel $this$placeStructure, @NotNull ResourceLocation id, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)$this$placeStructure, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return StructureUtil.getStructure($this$placeStructure, id).placeInWorld((ServerLevelAccessor)$this$placeStructure, pos, pos, new StructurePlaceSettings().addProcessor((StructureProcessor)BlockIgnoreProcessor.STRUCTURE_BLOCK).setRotation(Rotation.getRandom((RandomSource)$this$placeStructure.random)).setMirror((Mirror)EntriesMappings.entries$0.get($this$placeStructure.random.nextInt(2))).setIgnoreEntities(false), $this$placeStructure.random, 3);
    }

    public static final boolean placeStructureForced(@NotNull ServerLevel $this$placeStructureForced, @NotNull ResourceLocation id, @NotNull BlockPos pos, @NotNull Rotation rotation) {
        Intrinsics.checkNotNullParameter((Object)$this$placeStructureForced, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
        StructureTemplate structure = StructureUtil.getStructure($this$placeStructureForced, id);
        StructurePlaceSettings settings = new StructurePlaceSettings().addProcessor((StructureProcessor)BlockIgnoreProcessor.STRUCTURE_BLOCK).setRotation(rotation).setIgnoreEntities(false);
        BoundingBox box = structure.getBoundingBox(settings, pos);
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
                        ServerChunkCache serverChunkCache = $this$placeStructureForced.getLevel().getChunkSource();
                        Intrinsics.checkNotNull((Object)serverChunkCache, (String)"null cannot be cast to non-null type net.minecraft.server.level.ServerChunkCache");
                        serverChunkCache.getChunk(cx, cz, ChunkStatus.FULL, true);
                        if (cz == n2) break;
                        ++cz;
                    }
                }
                if (cx == n) break;
                ++cx;
            }
        }
        return structure.placeInWorld((ServerLevelAccessor)$this$placeStructureForced, pos, pos, settings, $this$placeStructureForced.random, 3);
    }

    public static final boolean place(@NotNull StructureTemplate $this$place, @NotNull ServerLevelAccessor level, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)$this$place, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return $this$place.placeInWorld(level, pos, pos, new StructurePlaceSettings().setRotation(Rotation.getRandom((RandomSource)level.getRandom())).setMirror((Mirror)EntriesMappings.entries$0.get(level.getRandom().nextInt(2))).setIgnoreEntities(false), level.getRandom(), 3);
    }

    public static final boolean placeStructureNormal(@NotNull ServerLevel $this$placeStructureNormal, @NotNull ResourceLocation id, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)$this$placeStructureNormal, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return StructureUtil.getStructure($this$placeStructureNormal, id).placeInWorld((ServerLevelAccessor)$this$placeStructureNormal, pos, pos, new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), $this$placeStructureNormal.random, 3);
    }

    public static final void tryPlaceStructure(@NotNull LevelAccessor $this$tryPlaceStructure, @NotNull ResourceLocation id, @NotNull BlockPos pos) {
        Intrinsics.checkNotNullParameter((Object)$this$tryPlaceStructure, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)id, (String)"id");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        if ($this$tryPlaceStructure instanceof ServerLevel) {
            StructureUtil.placeStructure((ServerLevel)$this$tryPlaceStructure, id, pos);
        }
    }

    @Metadata(mv={2, 1, 0}, k=3, xi=48)
    public static final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<Mirror> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])Mirror.values()));
        }
    }
}

