/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.Registry
 *  net.minecraft.core.registries.Registries
 *  net.minecraft.network.protocol.Packet
 *  net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.chunk.ChunkAccess
 *  net.minecraft.world.level.chunk.LevelChunk
 *  net.minecraft.world.level.chunk.LevelChunkSection
 *  net.minecraft.world.level.levelgen.Heightmap
 *  net.minecraft.world.level.levelgen.Heightmap$Types
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.brokencore.api.world;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.levelgen.Heightmap;
import net.thebrokenscript.brokencore.impl.config.BCConfigs;
import net.thebrokenscript.brokencore.impl.mixin.features.chunkremover.ChunkAccessAccessor;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000b"}, d2={"Lnet/thebrokenscript/brokencore/api/world/ChunkHelper;", "", "<init>", "()V", "clearChunk", "", "level", "Lnet/minecraft/world/level/LevelAccessor;", "x", "", "z", "brokencore-common"})
@SourceDebugExtension(value={"SMAP\nChunkHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChunkHelper.kt\nnet/thebrokenscript/brokencore/api/world/ChunkHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,60:1\n1869#2,2:61\n*S KotlinDebug\n*F\n+ 1 ChunkHelper.kt\nnet/thebrokenscript/brokencore/api/world/ChunkHelper\n*L\n56#1:61,2\n*E\n"})
public final class ChunkHelper {
    @NotNull
    public static final ChunkHelper INSTANCE = new ChunkHelper();

    private ChunkHelper() {
    }

    public final void clearChunk(@NotNull LevelAccessor level, double x, double z) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        if (BCConfigs.INSTANCE.getServer().getDisableChunkRemoval()) {
            return;
        }
        if (!(level instanceof ServerLevel)) {
            return;
        }
        int chunkX = (int)x >> 4;
        int chunkZ = (int)z >> 4;
        LevelChunk chunk = ((ServerLevel)level).getChunk(chunkX, chunkZ);
        chunk.clearAllBlockEntities();
        chunk.unregisterTickContainerFromLevel((ServerLevel)level);
        Intrinsics.checkNotNull((Object)chunk, (String)"null cannot be cast to non-null type net.thebrokenscript.brokencore.impl.mixin.features.chunkremover.ChunkAccessAccessor");
        Map<Heightmap.Types, Heightmap> map = ((ChunkAccessAccessor)chunk).brokencore_getHeightmaps();
        Set<Heightmap.Types> keys = map.keySet();
        for (Heightmap.Types key : keys) {
            Intrinsics.checkNotNull(map);
            map.put(key, new Heightmap((ChunkAccess)chunk, key));
        }
        LevelChunkSection[] levelChunkSectionArray = ((ChunkAccess)chunk).getSections();
        Intrinsics.checkNotNullExpressionValue((Object)levelChunkSectionArray, (String)"getSections(...)");
        ArraysKt.fill$default((Object[])levelChunkSectionArray, null, (int)0, (int)0, (int)6, null);
        Registry biomes = ((ServerLevel)level).registryAccess().registryOrThrow(Registries.BIOME);
        int n = ((ChunkAccess)chunk).getSections().length;
        for (int i = 0; i < n; ++i) {
            if (((ChunkAccess)chunk).getSections()[i] != null) continue;
            ((ChunkAccess)chunk).getSections()[i] = new LevelChunkSection(biomes);
        }
        ((ChunkAccess)chunk).setLightCorrect(false);
        chunk.registerTickContainerInLevel((ServerLevel)level);
        ((ChunkAccess)chunk).setUnsaved(true);
        List list = ((ServerLevel)level).players();
        Intrinsics.checkNotNullExpressionValue((Object)list, (String)"players(...)");
        Iterable $this$forEach$iv = list;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            ServerPlayer it = (ServerPlayer)element$iv;
            boolean bl = false;
            it.connection.send((Packet)new ClientboundLevelChunkWithLightPacket(chunk, ((ServerLevel)level).getLightEngine(), null, null));
        }
    }
}

