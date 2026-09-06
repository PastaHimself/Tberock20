/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.core.BlockPos
 *  net.minecraft.core.HolderLookup$Provider
 *  net.minecraft.core.Position
 *  net.minecraft.nbt.CompoundTag
 *  net.minecraft.server.level.ServerLevel
 *  net.minecraft.server.level.ServerPlayer
 *  net.minecraft.world.level.BlockGetter
 *  net.minecraft.world.level.block.entity.BlockEntity
 *  net.minecraft.world.level.block.state.BlockState
 *  net.minecraft.world.level.chunk.LevelChunk
 *  net.minecraft.world.phys.Vec3
 *  org.jetbrains.annotations.NotNull
 */
package net.thebrokenscript.events.misc;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Position;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.phys.Vec3;
import net.thebrokenscript.api.event.TBSEvent;
import net.thebrokenscript.block.ShadowBugBlock;
import net.thebrokenscript.registry.TBSBlocks;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 1, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014\u00a8\u0006\f"}, d2={"Lnet/thebrokenscript/events/misc/ShadowBugEvent;", "Lnet/thebrokenscript/api/event/TBSEvent;", "<init>", "()V", "execute", "", "level", "Lnet/minecraft/server/level/ServerLevel;", "player", "Lnet/minecraft/server/level/ServerPlayer;", "pos", "Lnet/minecraft/world/phys/Vec3;", "thebrokenscript-common"})
public final class ShadowBugEvent
extends TBSEvent {
    public ShadowBugEvent() {
        super(1);
    }

    protected void execute(@NotNull ServerLevel level, @NotNull ServerPlayer player, @NotNull Vec3 pos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Map capturedBlocks = new LinkedHashMap();
        for (int yi = 0; yi < 10; ++yi) {
            for (int xi = -9; xi < 10; ++xi) {
                for (int zi = -9; zi < 10; ++zi) {
                    Vec3 offset = new Vec3((double)xi, (double)yi, (double)zi);
                    BlockPos newPos = BlockPos.containing((Position)((Position)pos.add(offset)));
                    BlockState state = level.getBlockState(newPos);
                    BlockEntity blockEntity = level.getBlockEntity(newPos);
                    CompoundTag prevTag = blockEntity != null ? blockEntity.saveCustomOnly((HolderLookup.Provider)level.registryAccess()) : null;
                    capturedBlocks.put(newPos, new Pair((Object)state, (Object)prevTag));
                }
            }
        }
        for (Map.Entry xi : capturedBlocks.entrySet()) {
            BlockPos blockPos = (BlockPos)xi.getKey();
            Pair statePair = (Pair)xi.getValue();
            LevelChunk chunk = level.getChunkAt(blockPos);
            level.removeBlockEntity(blockPos);
            chunk.setBlockState(blockPos, TBSBlocks.SHADOW_BUG.getDefaultState(), false);
            ShadowBugBlock.Companion.setPreviousState((BlockGetter)level, blockPos, (BlockState)statePair.getFirst(), (CompoundTag)statePair.getSecond());
            chunk.setUnsaved(true);
        }
        for (BlockPos blockPos : capturedBlocks.keySet()) {
            Object v = capturedBlocks.get(blockPos);
            Intrinsics.checkNotNull(v);
            level.sendBlockUpdated(blockPos, (BlockState)((Pair)v).getFirst(), TBSBlocks.SHADOW_BUG.getDefaultState(), 2);
        }
    }
}

