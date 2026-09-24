/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.TuplesKt
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.nbt.Tag
 *  net.minecraft.network.protocol.common.custom.CustomPacketPayload
 *  net.minecraft.resources.ResourceKey
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.Level
 *  net.minecraft.world.level.LevelAccessor
 *  net.minecraft.world.level.saveddata.SavedData
 *  net.minecraft.world.level.saveddata.SavedData$Factory
 *  net.thebrokenscript.brokencore.api.ext.EndecExt
 *  net.thebrokenscript.brokencore.api.network.PacketSender
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.api.ext;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.saveddata.SavedData;
import net.thebrokenscript.brokencore.api.ext.EndecExt;
import net.thebrokenscript.brokencore.api.network.PacketSender;
import net.thebrokenscript.data.MapVariables;
import net.thebrokenscript.data.PlayerModifiedChunksData;
import net.thebrokenscript.registry.TBSPackets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J#\u0010\r\u001a\u00020\u000e*\u00020\n2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\u0002\b\u0011J\u0012\u0010\u0012\u001a\u00020\u000e*\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014R\"\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003R\u0015\u0010\t\u001a\u00020\u0006*\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00160\u00160\u0005X\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0003R\u0015\u0010\u0018\u001a\u00020\u0016*\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001b"}, d2={"Lnet/thebrokenscript/api/ext/LevelExt;", "", "<init>", "()V", "mapVarsFactory", "Lnet/minecraft/world/level/saveddata/SavedData$Factory;", "Lnet/thebrokenscript/data/MapVariables;", "kotlin.jvm.PlatformType", "getMapVarsFactory$annotations", "vars", "Lnet/minecraft/world/level/LevelAccessor;", "getVars", "(Lnet/minecraft/world/level/LevelAccessor;)Lnet/thebrokenscript/data/MapVariables;", "updateVars", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "syncVarsTo", "player", "Lnet/minecraft/server/level/ServerPlayer;", "playerChunksFactory", "Lnet/thebrokenscript/data/PlayerModifiedChunksData;", "getPlayerChunksFactory$annotations", "playerChunks", "getPlayerChunks", "(Lnet/minecraft/world/level/LevelAccessor;)Lnet/thebrokenscript/data/PlayerModifiedChunksData;", "thebrokenscript-common"})
@SourceDebugExtension(value={"SMAP\nLevelExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LevelExt.kt\nnet/thebrokenscript/api/ext/LevelExt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,66:1\n382#2,7:67\n1#3:74\n13910#4,3:75\n*S KotlinDebug\n*F\n+ 1 LevelExt.kt\nnet/thebrokenscript/api/ext/LevelExt\n*L\n23#1:67,7\n52#1:75,3\n*E\n"})
public final class LevelExt {
    @NotNull
    public static final LevelExt INSTANCE = new LevelExt();
    @NotNull
    private static final SavedData.Factory<MapVariables> mapVarsFactory = new SavedData.Factory(() -> new MapVariables(0, false, false, false, false, false, false, false, false, 0L, false, false, false, false, 0L, false, false, false, 0, false, 0, false, 0, false, false, false, false, false, null, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false, 0, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, -1, 0x1FFFFFF, null), LevelExt::mapVarsFactory$lambda$1, null);
    @NotNull
    private static final SavedData.Factory<PlayerModifiedChunksData> playerChunksFactory = new SavedData.Factory(PlayerModifiedChunksData::new, LevelExt::playerChunksFactory$lambda$0, null);

    private LevelExt() {
    }

    private static /* synthetic */ void getMapVarsFactory$annotations() {
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final MapVariables getVars(@NotNull LevelAccessor $this$vars) {
        MapVariables mapVariables;
        Intrinsics.checkNotNullParameter((Object)$this$vars, (String)"<this>");
        LevelAccessor levelAccessor = $this$vars;
        if (levelAccessor instanceof ServerLevel) {
            SavedData savedData = ((ServerLevel)$this$vars).getServer().overworld().getDataStorage().computeIfAbsent(mapVarsFactory, "thebrokenscript_mapvars");
            Intrinsics.checkNotNullExpressionValue((Object)savedData, (String)"computeIfAbsent(...)");
            mapVariables = (MapVariables)savedData;
        } else if (levelAccessor instanceof Level) {
            Object object;
            void $this$getOrPut$iv;
            Map<ResourceKey<Level>, MapVariables> map = MapVariables.CLIENT_VARS;
            ResourceKey key$iv = ((Level)$this$vars).dimension();
            boolean $i$f$getOrPut = false;
            Object value$iv = $this$getOrPut$iv.get(key$iv);
            if (value$iv == null) {
                boolean bl = false;
                MapVariables answer$iv = new MapVariables(0, false, false, false, false, false, false, false, false, 0L, false, false, false, false, 0L, false, false, false, 0, false, 0, false, 0, false, false, false, false, false, null, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false, 0, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, -1, 0x1FFFFFF, null);
                $this$getOrPut$iv.put(key$iv, answer$iv);
                object = answer$iv;
            } else {
                object = value$iv;
            }
            mapVariables = (MapVariables)((Object)object);
        } else {
            throw new IllegalArgumentException("Unsupported level accessor: " + $this$vars);
        }
        return mapVariables;
    }

    public final void updateVars(@NotNull LevelAccessor $this$updateVars, @NotNull Function1<? super MapVariables, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)$this$updateVars, (String)"<this>");
        Intrinsics.checkNotNullParameter(block, (String)"block");
        MapVariables vars = this.getVars($this$updateVars);
        block.invoke((Object)vars);
        Level level = $this$updateVars instanceof Level ? (Level)$this$updateVars : null;
        if (level == null || (level = level.dimension()) == null) {
            throw new IllegalArgumentException("Unsupported level accessor: " + $this$updateVars);
        }
        vars.syncData((ResourceKey<Level>)level);
    }

    public final void syncVarsTo(@NotNull LevelAccessor $this$syncVarsTo, @NotNull ServerPlayer player) {
        Intrinsics.checkNotNullParameter((Object)$this$syncVarsTo, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Level level = $this$syncVarsTo instanceof Level ? (Level)$this$syncVarsTo : null;
        if (level == null || (level = level.dimension()) == null) {
            throw new IllegalArgumentException("Unsupported level accessor: " + $this$syncVarsTo);
        }
        PacketSender.INSTANCE.sendToPlayer(player, (CustomPacketPayload)TBSPackets.MAP_VARS_SYNC.of(TuplesKt.to((Object)level, (Object)((Object)this.getVars($this$syncVarsTo)))), new CustomPacketPayload[0]);
    }

    private static /* synthetic */ void getPlayerChunksFactory$annotations() {
    }

    @NotNull
    public final PlayerModifiedChunksData getPlayerChunks(@NotNull LevelAccessor $this$playerChunks) {
        Intrinsics.checkNotNullParameter((Object)$this$playerChunks, (String)"<this>");
        if (!($this$playerChunks instanceof ServerLevel)) {
            throw new IllegalArgumentException("Unsupported level accessor: " + $this$playerChunks);
        }
        SavedData savedData = ((ServerLevel)$this$playerChunks).getServer().overworld().getDataStorage().computeIfAbsent(playerChunksFactory, "tbs_player_modified_chunks");
        Intrinsics.checkNotNullExpressionValue((Object)savedData, (String)"computeIfAbsent(...)");
        return (PlayerModifiedChunksData)savedData;
    }

    private static final MapVariables mapVarsFactory$lambda$1(CompoundTag tag, HolderLookup.Provider provider2) {
        Object object;
        block3: {
            block2: {
                object = tag.get("data");
                if (object == null) break block2;
                Tag it = object;
                boolean bl = false;
                MapVariables mapVariables = (MapVariables)((Object)EndecExt.INSTANCE.tryDecodeNbt(MapVariables.ENDEC, it));
                object = mapVariables;
                if (mapVariables != null) break block3;
            }
            object = new MapVariables(0, false, false, false, false, false, false, false, false, 0L, false, false, false, false, 0L, false, false, false, 0, false, 0, false, 0, false, false, false, false, false, null, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, false, 0, false, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, -1, 0x1FFFFFF, null);
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    private static final PlayerModifiedChunksData playerChunksFactory$lambda$0(CompoundTag tag, HolderLookup.Provider provider2) {
        PlayerModifiedChunksData playerModifiedChunksData;
        PlayerModifiedChunksData data = playerModifiedChunksData = new PlayerModifiedChunksData();
        boolean bl = false;
        long[] keys = tag.getLongArray("chunks");
        long[] counts = tag.getLongArray("counts");
        Intrinsics.checkNotNull((Object)keys);
        long[] $this$forEachIndexed$iv = keys;
        boolean $i$f$forEachIndexed = false;
        int index$iv = 0;
        for (long item$iv : $this$forEachIndexed$iv) {
            void key;
            int n = index$iv++;
            long l = item$iv;
            int i = n;
            boolean bl2 = false;
            data.getChunks().put((long)key, counts[i]);
        }
        return playerModifiedChunksData;
    }
}

