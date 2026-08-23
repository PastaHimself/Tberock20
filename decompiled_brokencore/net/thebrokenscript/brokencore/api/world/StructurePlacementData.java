/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.ListTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.world.level.ChunkPos
 *  net.minecraft.world.level.saveddata.SavedData
 *  net.minecraft.world.level.saveddata.SavedData$Factory
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.world;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.saveddata.SavedData;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0007J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Lnet/thebrokenscript/brokencore/api/world/StructurePlacementData;", "Lnet/minecraft/world/level/saveddata/SavedData;", "<init>", "()V", "timesPlaced", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "usedChunks", "", "canPlace", "", "structId", "maxCount", "incrementPlaceCount", "", "chunkPos", "Lnet/minecraft/world/level/ChunkPos;", "isChunkUsed", "isTooClose", "candidate", "minDistanceSqrd", "save", "Lnet/minecraft/nbt/CompoundTag;", "tag", "registries", "Lnet/minecraft/core/HolderLookup$Provider;", "Companion", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nStructurePlacementData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StructurePlacementData.kt\nnet/thebrokenscript/brokencore/api/world/StructurePlacementData\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,81:1\n1761#2,3:82\n216#3,2:85\n216#3,2:87\n*S KotlinDebug\n*F\n+ 1 StructurePlacementData.kt\nnet/thebrokenscript/brokencore/api/world/StructurePlacementData\n*L\n32#1:82,3\n42#1:85,2\n46#1:87,2\n*E\n"})
public final class StructurePlacementData
extends SavedData {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ConcurrentHashMap<String, Integer> timesPlaced = new ConcurrentHashMap();
    @NotNull
    private final ConcurrentHashMap<Long, String> usedChunks = new ConcurrentHashMap();
    @NotNull
    private static final String DATA_NAME = "structure_placements";
    @NotNull
    private static final SavedData.Factory<StructurePlacementData> FACTORY = new SavedData.Factory(StructurePlacementData::new, (arg_0, arg_1) -> Companion.access$load(Companion, arg_0, arg_1), null);

    public final synchronized boolean canPlace(@NotNull String structId, int maxCount) {
        Intrinsics.checkNotNullParameter((Object)structId, (String)"structId");
        return ((Number)this.timesPlaced.getOrDefault(structId, 0)).intValue() < maxCount;
    }

    public static /* synthetic */ boolean canPlace$default(StructurePlacementData structurePlacementData, String string, int n, int n2, Object object) {
        if ((n2 & 2) != 0) {
            n = 1;
        }
        return structurePlacementData.canPlace(string, n);
    }

    public final synchronized void incrementPlaceCount(@NotNull String structId, @NotNull ChunkPos chunkPos) {
        Intrinsics.checkNotNullParameter((Object)structId, (String)"structId");
        Intrinsics.checkNotNullParameter((Object)chunkPos, (String)"chunkPos");
        String key = structId;
        ((Map)this.timesPlaced).put(key, ((Number)this.timesPlaced.getOrDefault(key, 0)).intValue() + 1);
        ((Map)this.usedChunks).put(chunkPos.toLong(), key);
        this.setDirty();
    }

    public final boolean isChunkUsed(@NotNull ChunkPos chunkPos) {
        Intrinsics.checkNotNullParameter((Object)chunkPos, (String)"chunkPos");
        return this.usedChunks.containsKey(chunkPos.toLong());
    }

    public final boolean isTooClose(@NotNull ChunkPos candidate, int minDistanceSqrd) {
        boolean bl;
        block3: {
            Intrinsics.checkNotNullParameter((Object)candidate, (String)"candidate");
            Set set = this.usedChunks.keySet();
            Intrinsics.checkNotNullExpressionValue((Object)set, (String)"<get-keys>(...)");
            Iterable $this$any$iv = set;
            boolean $i$f$any = false;
            if ($this$any$iv instanceof Collection && ((Collection)$this$any$iv).isEmpty()) {
                bl = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    Long packed = (Long)element$iv;
                    boolean bl2 = false;
                    Intrinsics.checkNotNull((Object)packed);
                    ChunkPos pos = new ChunkPos(packed.longValue());
                    int dx = candidate.x - pos.x;
                    int dz = candidate.z - pos.z;
                    if (!(dx * dx + dz * dz < minDistanceSqrd)) continue;
                    bl = true;
                    break block3;
                }
                bl = false;
            }
        }
        return bl;
    }

    @NotNull
    public CompoundTag save(@NotNull CompoundTag tag, @NotNull HolderLookup.Provider registries) {
        Intrinsics.checkNotNullParameter((Object)tag, (String)"tag");
        Intrinsics.checkNotNullParameter((Object)registries, (String)"registries");
        CompoundTag tagCount = new CompoundTag();
        Map $this$forEach$iv = this.timesPlaced;
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator.next();
            boolean bl = false;
            String id = (String)entry.getKey();
            int count = ((Number)entry.getValue()).intValue();
            tagCount.putInt(id, count);
        }
        tag.put("PlacedCounts", (Tag)tagCount);
        ListTag tagChunk = new ListTag();
        Map $this$forEach$iv2 = this.usedChunks;
        boolean $i$f$forEach2 = false;
        Iterator iterator2 = $this$forEach$iv2.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry element$iv;
            Map.Entry entry = element$iv = iterator2.next();
            boolean bl = false;
            long packed = ((Number)entry.getKey()).longValue();
            String id = (String)entry.getValue();
            CompoundTag entry2 = new CompoundTag();
            entry2.putLong("Pos", packed);
            entry2.putString("Id", id);
            tagChunk.add((Object)entry2);
        }
        tag.put("UsedChunks", (Tag)tagChunk);
        return tag;
    }

    @Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00070\u00070\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2={"Lnet/thebrokenscript/brokencore/api/world/StructurePlacementData$Companion;", "", "<init>", "()V", "DATA_NAME", "", "load", "Lnet/thebrokenscript/brokencore/api/world/StructurePlacementData;", "tag", "Lnet/minecraft/nbt/CompoundTag;", "registries", "Lnet/minecraft/core/HolderLookup$Provider;", "FACTORY", "Lnet/minecraft/world/level/saveddata/SavedData$Factory;", "kotlin.jvm.PlatformType", "get", "level", "Lnet/minecraft/server/level/ServerLevel;", "brokencore-common"})
    public static final class Companion {
        private Companion() {
        }

        private final StructurePlacementData load(CompoundTag tag, HolderLookup.Provider registries) {
            StructurePlacementData data2 = new StructurePlacementData();
            CompoundTag tagCount = tag.getCompound("PlacedCounts");
            for (String key : tagCount.getAllKeys()) {
                ((Map)data2.timesPlaced).put(key, tagCount.getInt(key));
            }
            ListTag tagChunk = tag.getList("UsedChunks", 10);
            int n = tagChunk.size();
            for (int i = 0; i < n; ++i) {
                CompoundTag entry = tagChunk.getCompound(i);
                ((Map)data2.usedChunks).put(entry.getLong("Pos"), entry.getString("Id"));
            }
            return data2;
        }

        @NotNull
        public final StructurePlacementData get(@NotNull ServerLevel level) {
            Intrinsics.checkNotNullParameter((Object)level, (String)"level");
            SavedData savedData = level.getDataStorage().computeIfAbsent(FACTORY, StructurePlacementData.DATA_NAME);
            Intrinsics.checkNotNullExpressionValue((Object)savedData, (String)"computeIfAbsent(...)");
            return (StructurePlacementData)savedData;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public static final /* synthetic */ StructurePlacementData access$load(Companion $this, CompoundTag tag, HolderLookup.Provider registries) {
            return $this.load(tag, registries);
        }
    }
}

